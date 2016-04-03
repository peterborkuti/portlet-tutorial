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

<%@ page import="test.producer.sb.service.FooLocalServiceUtil" %>

<portlet:defineObjects />

This is the <b>consumer-036-00</b> portlet.

<p>producer-036-00 portlet must be deployed first and you have to add some
record with that portlet. This portlet will display the list of those
records to show how to use another portlet's service.</p>

<liferay-ui:search-container delta="10" emptyResultsMessage="no-users-were-found">
	<liferay-ui:search-container-results
		results="<%= FooLocalServiceUtil.getFoos(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= FooLocalServiceUtil.getFoosCount() %>"
	/>

	<liferay-ui:search-container-row
		className="test.producer.sb.model.Foo"
		keyProperty="fooId"
		modelVar="foo"
	>
		<liferay-ui:search-container-column-text
			name="Field1"
			property="field1"
		/>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>