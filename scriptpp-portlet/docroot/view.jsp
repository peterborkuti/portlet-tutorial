
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
	<div id="<portlet:namespace/>fileTab" class="fileTab">
		<div class="tabBox">
		<div class="container-fluid">
			<%@ include file="/file.jspf" %>
		</div>
		</div>
	</div>
</div>

<aui:script>

jQuery(function($, undefined) {
	ScriptppJS('<portlet:namespace/>', '<%= p_auth %>', '<%= actionURL %>');
});

</aui:script>