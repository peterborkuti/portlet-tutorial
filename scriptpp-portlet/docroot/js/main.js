var ScriptppJS = function (nameSpace, pAuth, actionURL) {
	var getDOMObject = function(id) {
		return document.getElementById(nameSpace + id);
	}
	var getJQueryObject = function(id) {
		return $(getDOMObject(id));
	}

	getJQueryObject('dependenceSelector').multiselect().empty();

	var deleteMultiSelect =
		getJQueryObject('deleteScriptsSelector').multiselect();

	var history = getJQueryObject('history');

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

	var moduleTextarea = getDOMObject('module');

	var moduleEditor =
		CodeMirror.fromTextArea(moduleTextarea, {
			lineNumbers: true,
			mode: "groovy",
			viewportMargin: Infinity
		});

	var importEditor = getJQueryObject('import');

	var sendCommand = function(command, term) {
		updateHistoryOnUI(command);
		var moduleContent = moduleEditor.getValue(),
			importContent = importEditor.val(),
			script = importContent + ";\n" + moduleContent;
		//gets all the option's value from the dependency_to select
		var depArray = $.map($('option',getJQueryObject('dependenceSelector_to')), function(e) { return $(e).attr('value'); })
		var dependencies = (depArray && depArray.join(",")) || "";
		var ajaxData = {};
		ajaxData[nameSpace + 'type'] = 'command';
		ajaxData[nameSpace + 'script'] = script;
		ajaxData[nameSpace + 'command'] = command;
		ajaxData[nameSpace + 'dependencies'] = dependencies;
		$.ajax({
				method: "POST",
				url: actionURL,
				data: ajaxData
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
					'p_auth': pAuth,
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
					'p_auth': pAuth
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

	var terminal = getJQueryObject('terminal').terminal(
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

	var loadScriptEventHandler = function(payLoad) {
		moduleEditor.setValue(payLoad.moduleContent || "");
		importEditor.val(payLoad.importContent || "");
		getJQueryObject("scriptName").val(payLoad.scriptName || "");

		//Dependence selector
		var ids = payLoad.dependencyIds || [];
		var dependence = getJQueryObject('dependenceSelector');
		//moves everything from the right to the left
		getJQueryObject('dependenceSelector_leftAll').click();
		//clicks on the dependencies than move them to the right
		if (ids.length > 0) {
			$.each(ids, function(index, value) {
				$('option[value="' + value + '"]',dependence).prop('selected', true).trigger('change');
			})
			getJQueryObject('dependenceSelector_rightSelected').click();
		}

		moduleEditor.refresh();
	}

	var addScript = function(moduleContent, importContent) {
		var isAutosavingNeed = getJQueryObject('autoSaveSwitch').is(':checked');

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

		var scriptName = getJQueryObject("scriptName").val();
		var depArray = $.map($('option',getJQueryObject('dependenceSelector_to')), function(e) { return $(e).attr('value'); })
		var dependencies = (depArray && depArray.join(",")) || "";
		autoSavingIsProcessing = true;

		lastSavedModuleContent = moduleContent;
		lastSavedImportContent = importContent;

		$.ajax({
			method: "POST",
			url: "/api/jsonws/scriptpp-portlet.script/add-script",
			data: {
				'p_auth': pAuth,
				'moduleContent': moduleContent,
				'importContent': importContent,
				'scriptName'   : scriptName,
				'dependencies' : dependencies
			}
		})
		.done(function() {
			autoSavingIsProcessing = false;
			console.log('script added on backend');
		});

	};

	var saveScript = function() {
		var scriptName = getJQueryObject('scriptName').val();

		var depArray = $.map($('option',
			getJQueryObject('dependenceSelector_to')),
			function(e) { return $(e).attr('value'); });

		var dependencies = (depArray && depArray.join(",")) || "";
		var moduleContent = moduleEditor.getValue();
		var importContent =  importEditor.val();

		$.ajax({
			method: "POST",
			url: "/api/jsonws/scriptpp-portlet.script/add-script",
			data: {
				'p_auth': pAuth,
				'moduleContent': moduleContent,
				'importContent': importContent,
				'scriptName'   : scriptName,
				'dependencies' : dependencies
			}
		})
		.done(function() {
			console.log('script added on backend');
			fillFileTab();
		});
	};

	var loadLastScript = function() {
		$.ajax({
			method: "POST",
			url: "/api/jsonws/scriptpp-portlet.script/get-last-script",
			data: {
				'p_auth': pAuth
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
				'p_auth': pAuth,
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
		var scriptIds =
				getJQueryObject('deleteScriptsSelector_to').children('option').
					map(function(i,v) { return $(v).val() });

		if (!scriptIds || scriptIds.length === 0) {
			return;
		}

		$.ajax({
			method: "POST",
			url: "/api/jsonws/scriptpp-portlet.script/delete-scripts",
			data: {
				'p_auth': pAuth,
				'scriptIds' : scriptIds.join(",")
			}
		})
		.done(function(content) {
			fillFileTab();
		});
	}


	var prepareFileTab = function() {
		var loadButton = getJQueryObject('loadScriptButton');
		loadButton.click(loadScript);
		var deleteButton = getJQueryObject('deleteScriptsButton');
		deleteButton.click(deleteScripts);
		var saveButton = getJQueryObject('saveScriptButton');
		saveButton.click(saveScript);
	}

	var fillFileTab = function() {
		var dependenceSelector = getJQueryObject('dependenceSelector');
		var loadScriptSelector = getJQueryObject('loadScriptSelector');
		var deleteScriptsSelector = getJQueryObject('deleteScriptsSelector');
		$.ajax({
			method: "POST",
			url: "/api/jsonws/scriptpp-portlet.script/get-script-name-versions",
			data: {
				'p_auth': pAuth
			}
		})
		.done(function(content) {
			//clearing the selects

			dependenceSelector.children().remove();
			loadScriptSelector.children().remove();
			deleteScriptsSelector.children().remove();
			getJQueryObject('deleteScriptsSelector_to').children().remove();

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
		});
	}

	var main = function() {
		setHistoryLines(terminal);
		getJQueryObject('tabs').tabs({
			activate: tabActivateEventHandler
		});
		loadLastScript();
		autoSave();
		fillFileTab();
		prepareFileTab();
	}

	main();

}