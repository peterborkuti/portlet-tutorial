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
<%@ page import="com.liferay.portal.model.Contact" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparator" %>

<portlet:defineObjects />

This is the <b>dynaquery00</b> portlet.

<portlet:renderURL var="upURL"><portlet:param name="order" value="true"/></portlet:renderURL>

<portlet:renderURL var="downURL"><portlet:param name="order" value="false"/></portlet:renderURL>

<p>
<a href="<%= upURL %>">UP</a>
</p>

<p>
<a href="<%= downURL %>">DOWN</a>
</p>

<%
java.util.List<Contact> contactList =
	(java.util.List<Contact>)renderRequest.getAttribute("contactList");
%>

<liferay-ui:search-container delta="10" total="<%= contactList.size() %>" >

	<liferay-ui:search-container-results
		results="<%= 
			contactList.subList(
				searchContainer.getStart(),
				Math.min(searchContainer.getEnd(), contactList.size())) 
				%>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.portal.model.Contact"
		keyProperty="contactId"
		modelVar="contact"
	>

	<liferay-ui:search-container-column-text
		name="ID"
		property="contactId"
	/>

	<liferay-ui:search-container-column-text
		name="name"
		property="firstName"
	/>

	<liferay-ui:search-container-column-text
		name="email"
		property="emailAddress"
	/>

	<liferay-ui:search-container-column-text
		name="moddate"
		property="modifiedDate"
	/>


	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>