<%@page import="java.util.List"%>
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

This is the <b>NevNapp</b> portlet.

<%
	java.util.List<String> names = (java.util.List<String>)renderRequest.getAttribute("names");

%>

<p>
Found <%= names.size() %> names for today.
</p>
<liferay-ui:search-container
	delta="10"
	total="<%= names.size()	%>"
>

	<liferay-ui:search-container-results
		results="<%=
			names.subList(
				searchContainer.getStart(),
				Math.min(searchContainer.getEnd(), names.size()))
				%>"
	/>

	<liferay-ui:search-container-row
		className="String"
		modelVar="name"
	>

	<liferay-ui:search-container-column-text
		name="Name"
		value="<%= name %>"
	/>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>

