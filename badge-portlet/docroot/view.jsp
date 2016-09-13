<%@page import="com.liferay.hu.badge.service.service.BadgeServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.hu.badge.service.model.Badge"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.hu.badge.portlet.BadgePortlet"%>
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
	boolean isThankyoubadge = GetterUtil.getBoolean(portletPreferences.getValue("addthankyou", "false"), false);
	int badgeType = BadgePortlet.BADGETYPE_THANKYOU;
	if (!isThankyoubadge) {
		badgeType = BadgePortlet.BADGETYPE_RESPECT;
	}
	List<Badge> badges = BadgeServiceUtil.getBadges(badgeType);
	Calendar today = Calendar.getInstance();
	boolean isAdminMode = GetterUtil.getBoolean(portletPreferences.getValue("adminmode", "false"), false);
%>

<portlet:actionURL var="addBadgeURL" name="addBadgeAction"></portlet:actionURL>

<aui:form name="addBadgeForm" action="<%= addBadgeURL %>" method="POST">

	<% if (isAdminMode) {%>

	<liferay-ui:input-date name="assignDate" 
		dayValue="<%= today.get(Calendar.DAY_OF_MONTH) %>" dayParam="assignDay"
		monthValue="<%= today.get(Calendar.MONTH) %>" monthParam="assignMonth"
		yearValue="<%= today.get(Calendar.YEAR) %>" yearParam="assignYear"
	/>

	<aui:select name="fromUser">
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

	<% } %>

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

	<aui:input type="submit" name="addBadgeSubmit" value="Add Badge"></aui:input>
</aui:form>

<liferay-ui:search-container total="<%= badges.size() %>"
>

	<liferay-ui:search-container-results
		results="<%=
			badges.subList(
				searchContainer.getStart(),
				Math.min(searchContainer.getEnd(), badges.size()))
				%>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.hu.badge.service.model.Badge"
		modelVar="badge"
	>

	<liferay-ui:search-container-column-text
		name="Date"
		property="assignDate"
	/>

	<%
		String imgName = (badge.getBadgeType() == 0) ? "thankyou" : "respect";
	%>

	<liferay-ui:search-container-column-text name="Bage Type">
		<img class="badgeimage" src="<%= request.getContextPath() %>/images/<%= imgName %>badge.png"/>
	</liferay-ui:search-container-column-text>

	<liferay-ui:search-container-column-text
		name="To User"
		property="toUserFullName"
	/>

	<liferay-ui:search-container-column-text
		name="From User"
		property="fromUserFullName"
	/>

	<liferay-ui:search-container-column-text
		name="Description"
		property="description"
	/>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>