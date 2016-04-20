
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

<div id="<portlet:namespace/>terminal"></div>

<aui:script>


jQuery(function($, undefined) {
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
		greetings: 'Groovy Interpreter',
		name: 'Script++ terminal',
		height: 200,
		prompt: 'groovy> '
	});
});

</aui:script>