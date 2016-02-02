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
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />

<portlet:actionURL name="saveName" var="saveURL"/>

<portlet:renderURL var="cancelURL">
	<portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>

<aui:form action="<%= saveURL.toString() %>" method="POST">
	<aui:input name="name" type="text"/>
	<aui:button-row>
	<aui:button type="submit" value="Save"/>
	<aui:button type="cancel" value="Cancel" onClick="<%= cancelURL.toString() %>"/>
	</aui:button-row>
</aui:form>
