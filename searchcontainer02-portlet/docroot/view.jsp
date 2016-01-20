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
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.service.RoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparator" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
	long companyId = themeDisplay.getCompanyId();
	String name = null;
	String description = null;
	Integer[] types = null;
	OrderByComparator obc =
		OrderByComparatorFactoryUtil.create("role_", "roleId", true);

%>

This is the <b>searchcontainer02</b> portlet.

<liferay-ui:search-container
	delta="10"
	total="<%=
		RoleLocalServiceUtil.searchCount(
			companyId, name, description, types) 
		%>"
>

	<liferay-ui:search-container-results
		results="<%= 
			RoleLocalServiceUtil.search(
				companyId, name, description, types,
				searchContainer.getStart(), searchContainer.getEnd(), obc)
			%>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.portal.model.Role"
		modelVar="role"
	>

	<liferay-ui:search-container-column-text
		name="Role Id"
		property="roleId"
	/>

	<liferay-ui:search-container-column-text
		name="User Id"
		property="userId"
	/>

	<liferay-ui:search-container-column-text
		name="Role Name"
		property="name"
	/>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>
