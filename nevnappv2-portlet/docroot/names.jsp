<%@page import="java.util.List"%>
<%@page import="hu.borkutip.lfrnevnapp.data.model.NameEntity"%>
<%@page import="javax.portlet.PortletURL" %>
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

<%@include file="today.jspf" %>

<%
	List<NameEntity> names = (List<NameEntity>)renderRequest.getAttribute("names");
	PortletURL iteratorURL = (PortletURL)renderRequest.getAttribute("iteratorURL");
%>

<liferay-ui:search-container
	iteratorURL="<%= iteratorURL %>"
	delta="3"
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
		className="hu.borkutip.lfrnevnapp.data.model.NameEntity"
		modelVar="name"
	>

	<portlet:actionURL name="listDays" var="listDaysURL">
		<portlet:param name="nameId" value='<%= "" + name.getNameId() %>'/>
	</portlet:actionURL>

	<% String href="<a href='" + listDaysURL + "'>" + name.getName() + "</a>"; %>

	<liferay-ui:search-container-column-text
		name="Name"
		value="<%= href %>"
	/>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>

