
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

<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<portlet:defineObjects />

<portlet:resourceURL var="actionURL"></portlet:resourceURL>

<div id="<portlet:namespace/>tabs">
	<ul>
		<li><a href="#<portlet:namespace/>terminalTab">Terminal</a></li>
		<li><a href="#<portlet:namespace/>historyTab">History</a></li>
		<li><a href="#<portlet:namespace/>moduleTab">Module</a></li>
		<li><a href="#<portlet:namespace/>importTab">Import</a></li>
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

	var sendCommand = function(command, term) {
	
		var date = now().toLocalString();
		var button = $('<li><span>' + date + '</span><span>' + command + '</span></li>');
		history.append(button);
		$.ajax({
				method: "POST",
				url: "<%= actionURL %>",
				data: {
					'<portlet:namespace/>type': 'command',
					'<portlet:namespace/>script': '',
					'<portlet:namespace/>command': command
				}
			})
			.done(function(msg) {
				processResponse(msg, term);
			});
	};

	$('#<portlet:namespace/>terminal').terminal(function(command, term) {
		if (command !== '') {
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

	$( "#<portlet:namespace/>tabs" ).tabs();

	var moduleTextarea = document.getElementById('<portlet:namespace/>module');

	var moduleEditor =
		CodeMirror.fromTextArea(moduleTextarea, {
			lineNumbers: true,
			mode: "groovy",
			viewportMargin: Infinity
		});
});

</aui:script>