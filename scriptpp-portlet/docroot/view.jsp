
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
		<div class="fileBox">
			<fieldset>
			<button>Save now</button>
			<label for="<portlet:namespace/>autoSaveSwitch">Auto save</label>
			<input type="checkbox" id="<portlet:namespace/>autoSaveSwitch"/>
			</fieldset>

			<fieldset>
			<label for="<portlet:namespace/>fileName">Script name</label>
			<input id="<portlet:namespace/>fileName"/>
			</fieldset>

			<fieldset>
			<label for="<portlet:namespace/>dependencies">Dependencies</label>
			<select id="<portlet:namespace/>dependenceSelector"></select>
			</fieldset>

			<fieldset>
			<label for="<portlet:namespace/>loadScriptSelector">Load script</label>
			<select id="<portlet:namespace/>loadScriptSelector">
			</select>
			<button>Load</button>
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
	var addScript = function(moduleContent, importContent) {
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

		autoSavingIsProcessing = true;

		lastSavedModuleContent = moduleContent;
		lastSavedImportContent = importContent;

		$.ajax({
			method: "POST",
			url: "/api/jsonws/scriptpp-portlet.script/add-script",
			data: {
				'p_auth': '<%= p_auth %>',
				'moduleContent': moduleContent,
				'importContent': importContent
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
		.done(function(contentArr) {
			moduleEditor.setValue(contentArr[0]);
			importEditor.val(contentArr[1]);
			moduleEditor.refresh();
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

	var main = function() {
		setHistoryLines(terminal);
		$( "#<portlet:namespace/>tabs" ).tabs({
			activate: tabActivateEventHandler
		});
		loadLastScript();
		autoSave();
		var dependenceSelector = $("#<portlet:namespace/>dependenceSelector").multiSelect(
			{
				keepOrder: true
			}
		);
		var i;
		for ( i = 0; i < 10; i++) {
			dependenceSelector.multiSelect('addOption',
				{ value: 'test' + i, text: 'test' + i}
			);
		}
	}

	main();

});

</aui:script>