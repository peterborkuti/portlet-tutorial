<%
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />

This is the <b>form-navigator-01</b> portlet.

<%
	String[] sectionNames = {"section-1", "section-2"};
	String[][] entries = {{"page-a","page-b"}, {"page-c"}};
%>

<aui:form action='<portlet:actionURL/>' method="post" name="fm">
	<liferay-ui:form-navigator
		categoryNames="<%= sectionNames %>"
		categorySections="<%= entries %>"
		jspPath="/"
	/>
</aui:form>
