
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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<portlet:defineObjects />

This is the
<b>script++</b>
portlet.

<portlet:actionURL name="executeScript" var="actionURL"></portlet:actionURL>

<
<aui:form action="<%=actionURL%>" method="POST">
	<aui:fieldset>
		<aui:input name="script" type="textarea"></aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="submit"></aui:button>
	</aui:button-row>
</aui:form>
