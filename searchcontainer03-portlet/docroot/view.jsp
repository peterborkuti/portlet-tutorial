<%@page import="test.RandomStringModel"%>
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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />

This is the <b>searchcontainer03</b> portlet.

<%
java.util.List<RandomStringModel> randomList =
	(java.util.List<RandomStringModel>)renderRequest.getAttribute("randomList");

%>

<liferay-ui:search-container delta="10" total="<%= randomList.size() %>" >

	<liferay-ui:search-container-results
		results="<%= 
			randomList.subList(
				searchContainer.getStart(),
				Math.min(searchContainer.getEnd(), randomList.size())) 
				%>"
	/>

	<liferay-ui:search-container-row
		className="test.RandomStringModel"
		keyProperty="id"
		modelVar="randomString"
	>

	<liferay-ui:search-container-column-text
		name="ID"
		property="id"
	/>

	<liferay-ui:search-container-column-text
		name="Random String"
		property="string"
	/>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>
