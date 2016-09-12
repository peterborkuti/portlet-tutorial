<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
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
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />

This is the <b>Badge v0.01</b> portlet.

<%
	List<User> users = UserLocalServiceUtil.getUsers(-1, -1);

%>

<portlet:actionURL var="addBadgeURL"></portlet:actionURL>

<aui:form name="addBadgeForm" action="<%= addBadgeURL %>" method="POST">
	<aui:select name="toUser">
		<% 
			for (User user: users) {
				Long userId = user.getUserId();
				String userName = user.getFullName();
				%>
				<aui:option value="<%= userId %>"><%= userName %></aui:option>
				<%
			}
		%>
	</aui:select>

	<aui:input name="description"></aui:input>

	<aui:input name="addBadge" type="submit" value="Add Badge"></aui:input>
</aui:form>