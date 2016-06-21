
<%
	/**
	 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
	 *
	 * The contents of this file are subject to the terms of the Liferay Enterprise
	 * Subscription License ("License"). You may not use this file except in
	 * compliance with the License. You can obtain a copy of the License by
	 * contacting Liferay, Inc. See the License for the specific language governing
	 * permissions and limitations under the License, including but not limited to
	 * distribution rights of the Software.
	 *
	 *
	 *
	 */
%>

<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.security.auth.AuthTokenUtil" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<portlet:defineObjects />

<%

	String p_auth = AuthTokenUtil.getToken(request);

%>

<portlet:resourceURL var="actionURL"></portlet:resourceURL>

<div id="<portlet:namespace/>tabs">
	<ul>
		<li><a href="#<portlet:namespace/>terminalTab">Terminal</a></li>
		<li><a href="#<portlet:namespace/>historyTab">History</a></li>
		<li><a href="#<portlet:namespace/>moduleTab">Module</a></li>
		<li><a href="#<portlet:namespace/>importTab">Import</a></li>
		<li><a href="#<portlet:namespace/>fileTab">File</a></li>
	</ul>
	<div id="<portlet:namespace/>terminalTab">
		<div class="tabBox">
			<div id="<portlet:namespace/>terminal"></div>
		</div>
	</div>
	<div id="<portlet:namespace/>historyTab">
		<div class="tabBox">
			<ol id="<portlet:namespace/>history"></ol>
		</div>
	</div>
	
	<div id="<portlet:namespace/>moduleTab">
		<div class="tabBox">
			<textarea id="<portlet:namespace/>module"></textarea>
		</div>
	</div>
	<div id="<portlet:namespace/>importTab">
		<div class="tabBox">
			<textarea id="<portlet:namespace/>import" style="width: 100%; height: 100%;"></textarea>
		</div>
	</div>
	<div id="<portlet:namespace/>fileTab">
		<div class="tabBox">
			<fieldset>
			<label for="<portlet:namespace/>scriptName">Script name</label>
			<input id="<portlet:namespace/>scriptName"/>
			<button>Save now</button>
			<label for="<portlet:namespace/>autoSaveSwitch">Auto save</label>
			<input type="checkbox" id="<portlet:namespace/>autoSaveSwitch"/>
			</fieldset>

			<hr>

			<fieldset>
			<label for="<portlet:namespace/>dependencies">Dependencies</label>
			<select id="<portlet:namespace/>dependenceSelector"></select>
			</fieldset>

			<hr>

			<fieldset>
			<label for="<portlet:namespace/>loadScriptSelector">Load script</label>
			<select id="<portlet:namespace/>loadScriptSelector">
			</select>
			<button id="<portlet:namespace/>loadScriptButton">Load</button>
			</fieldset>

			<hr>

			<fieldset>
			<label for="<portlet:namespace/>deleteScriptsSelector">Delete script</label>
			<select id="<portlet:namespace/>deleteScriptsSelector" multiple="multiple">
			</select>
			<button id="<portlet:namespace/>deleteScriptsButton">Delete selected scripts</button>
			</fieldset>
		</div>
	</div>
</div>

<aui:script>


jQuery(function($, undefined) {
	var history = $('#<portlet:namespace/>history');

	var processResponse = function(response, term) {
		var parsedResponse = {
			'output': '',
			'error': 'no meaningful response'
		};
		try {
			parsedResponse = $.parseJSON(response);
		} catch (e) {};
		if (parsedResponse && parsedResponse.output) {
			term.echo(new String(parsedResponse.output));
		};
		if (!parsedResponse) {
			term.error("Response from server is not parseable");
		};
		if (parsedResponse && parsedResponse.error) {
			term.error(new String(parsedResponse.error));
		};
		console.log("done", response);
	};

	var updateHistoryOnUI = function(command) {
		var date = new Date();
		var dateStr = date.toLocaleDateString() + " " + date.toLocaleTimeString();
		var historyLine = $('<li><span class="historyDate">' + dateStr + '</span> - <span class="historyCommand">' + command + '</span></li>');
		history.prepend(historyLine);
	};

	var moduleTextarea = document.getElementById('<portlet:namespace/>module');

	var moduleEditor =
		CodeMirror.fromTextArea(moduleTextarea, {
			lineNumbers: true,
			mode: "groovy",
			viewportMargin: Infinity
		});

	var importEditor = $('#<portlet:namespace/>import');

	var sendCommand = function(command, term) {
		updateHistoryOnUI(command);
		var moduleContent = moduleEditor.getValue(),
			importContent = importEditor.val(),
			script = importContent + ";" + moduleContent;
		$.ajax({
				method: "POST",
				url: "<%= actionURL %>",
				data: {
					'<portlet:namespace/>type': 'command',
					'<portlet:namespace/>script': script,
					'<portlet:namespace/>command': command
				}
			})
			.done(function(msg) {
				processResponse(msg, term);
			});
	};

	var addHistoryLine = function(line) {
			$.ajax({
				method: "POST",
				url: "/api/jsonws/scriptpp-portlet.history/add-history-line",
				data: {
					'p_auth': '<%= p_auth %>',
					'line': line
				}
			})
			.done(function() {
				console.log('history added on backend');
			});
	};

	var setHistoryLines = function(terminal) {
			$.ajax({
				method: "POST",
				url: "/api/jsonws/scriptpp-portlet.history/get-history-lines",
				data: {
					'p_auth': '<%= p_auth %>'
				}
			})
			.done(function(linesArray) {
				$.each(linesArray, function(index, value) {
					terminal.history().append(value);
					updateHistoryOnUI(value);
					console.log(value + " was added to history");
				})	
			});
	};

	var terminal = $('#<portlet:namespace/>terminal').terminal(
		function(command, term) {
			if (command !== '') {
				addHistoryLine(command);
				sendCommand(command, term);
			} else {
				term.echo('');
			}
		}, {
			greetings: '',
			name: 'Script++ terminal',
			height: '90%',
			prompt: 'groovy> '
	});

	var lastSavedModuleContent = '', lastSavedImportContent = '';
	var autoSavingIsProcessing = false;

	var getJQueryObject = function(id) {
		return $("#<portlet:namespace/>" + id);
	} 

	var loadScriptEventHandler = function(payLoad) {
		moduleEditor.setValue(payLoad.moduleContent);
		importEditor.val(payLoad.importContent);
		getJQueryObject("scriptName").val(payLoad.scriptName);
		var ids = payLoad.dependencyIds;
		if (ids.length > 0) {
			getJQueryObject("dependenceSelector").multiSelect('select',ids);
		}
		moduleEditor.refresh();
	}

	var addScript = function(moduleContent, importContent) {
		var isAutosavingNeed = $("#<portlet:namespace/>autoSaveSwitch").is(':checked');

		if (!isAutosavingNeed) {
			return;
		}

		if (autoSavingIsProcessing) {
			return;
		}

		if (!moduleContent && !importContent) {
			return;
		}

		if ((lastSavedModuleContent == moduleContent) &&
			(lastSavedImportContent == importContent)) {

			return;
		}

		var scriptName = $("#<portlet:namespace/>scriptName").val();
		autoSavingIsProcessing = true;

		lastSavedModuleContent = moduleContent;
		lastSavedImportContent = importContent;

		$.ajax({
			method: "POST",
			url: "/api/jsonws/scriptpp-portlet.script/add-script",
			data: {
				'p_auth': '<%= p_auth %>',
				'moduleContent': moduleContent,
				'importContent': importContent,
				'scriptName'   : scriptName
			}
		})
		.done(function() {
			autoSavingIsProcessing = false;
			console.log('script added on backend');
		});

	};

	var loadLastScript = function() {
		$.ajax({
			method: "POST",
			url: "/api/jsonws/scriptpp-portlet.script/get-last-script",
			data: {
				'p_auth': '<%= p_auth %>'
			}
		})
		.done(function(content) {
			loadScriptEventHandler(content);
		});
	}

	var loadScript = function() {
		var scriptId = getJQueryObject('loadScriptSelector').val();

		if (!scriptId || scriptId === 0) {
			return;
		}

		$.ajax({
			method: "POST",
			url: "/api/jsonws/scriptpp-portlet.script/get-script",
			data: {
				'p_auth': '<%= p_auth %>',
				'scriptId' : scriptId
			}
		})
		.done(function(content) {
			loadScriptEventHandler(content);
		});
	}


	var autoSave = function() {
		addScript(moduleEditor.getValue(), importEditor.val());

		setTimeout(autoSave, 3000);
	}

	var tabActivateEventHandler = function(event, ui) {
		var tabId = ui.newPanel.attr('id');
		if (tabId.endsWith('moduleTab')) {
			moduleEditor.refresh();
		}
	}

	var deleteScripts = function() {
		var scriptIds = getJQueryObject('deleteScriptsSelector').val();

		if (!scriptIds || scriptIds.length === 0) {
			return;
		}

		$.ajax({
			method: "POST",
			url: "/api/jsonws/scriptpp-portlet.script/delete-scripts",
			data: {
				'p_auth': '<%= p_auth %>',
				'scriptIds' : scriptIds.join(",")
			}
		})
		.done(function(content) {
			getJQueryObject('deleteScriptsSelector').multiSelect('deselect_all');
			fillFileTab();
		});
	}


	var prepareFileTab = function() {
		var loadButton = getJQueryObject('loadScriptButton');
		loadButton.click(loadScript);
		var loadButton = getJQueryObject('deleteScriptsButton');
		loadButton.click(deleteScripts);
	}

	var fillFileTab = function() {
		var dependenceSelector = $("#<portlet:namespace/>dependenceSelector");
		var loadScriptSelector = $("#<portlet:namespace/>loadScriptSelector");
		var deleteScriptsSelector = $("#<portlet:namespace/>deleteScriptsSelector");
		$.ajax({
			method: "POST",
			url: "/api/jsonws/scriptpp-portlet.script/get-script-name-versions",
			data: {
				'p_auth': '<%= p_auth %>'
			}
		})
		.done(function(content) {
			var scriptNames = content["scriptNames"];
			var versions = content["versions"];
			var optgroups = {};

			$.each(scriptNames, function(index, value) {
				// I hope this escapes and prevents XSS issues
				var optGroup = $('<optgroup/>').attr('label', value);
				optgroups[value] = optGroup;
			});

			$.each(versions, function(index, value) {
				var key = value.nested;
				var option = $('<option/>');
				option.attr({ 'value': value.value }).text(value.text);
				if (!optgroups[value.nested]) {
					console.log("Hello!", value.nested);
				}
				else {
					optgroups[value.nested].append(option);
				}
			});

			$.each(optgroups, function(index, value) {
				dependenceSelector.append(value);
				loadScriptSelector.append(value.clone());
				deleteScriptsSelector.append(value.clone());
			});

			var multiselect1 = dependenceSelector.multiSelect(
					{
						keepOrder: true
					}
				).multiSelect('refresh');

			var multiselect2 = deleteScriptsSelector.multiSelect(
					{
						keepOrder: true,
						selectableOptgroup: true
					}
				).multiSelect('refresh');
		});
	}

	var main = function() {
		setHistoryLines(terminal);
		$( "#<portlet:namespace/>tabs" ).tabs({
			activate: tabActivateEventHandler
		});
		loadLastScript();
		autoSave();
		fillFileTab();
		prepareFileTab();
	}

	main();

});

</aui:script>