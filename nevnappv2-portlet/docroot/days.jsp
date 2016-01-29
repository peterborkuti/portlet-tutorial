<%@page import="java.util.List"%>
<%@page import="hu.borkutip.lfrnevnapp.data.model.DayEntity"%>
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
	List<DayEntity> days = (List<DayEntity>)renderRequest.getAttribute("days");

%>

<p>
Found <%= days.size() %> dates for a name.
</p>
<liferay-ui:search-container
	delta="10"
	total="<%= days.size()	%>"
>

	<liferay-ui:search-container-results
		results="<%=
			days.subList(
				searchContainer.getStart(),
				Math.min(searchContainer.getEnd(), days.size()))
				%>"
	/>

	<liferay-ui:search-container-row
		className="hu.borkutip.lfrnevnapp.data.model.DayEntity"
		modelVar="day"
	>

	<liferay-ui:search-container-column-text
		name="Day"
		value="<%= day.getMonth() + ". " + day.getDay() %>"
	/>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>

