<%@page import="com.liferay.hu.badge.service.service.BadgeServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.hu.badge.service.model.Badge"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
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
	List<Badge> badges = BadgeServiceUtil.getBadges();
	boolean adminmode = GetterUtil.getBoolean(portletPreferences.getValue("adminmode", "false"), false);
	boolean addthankyou = GetterUtil.getBoolean(portletPreferences.getValue("addthankyou", "false"), false);
	boolean addrespect = GetterUtil.getBoolean(portletPreferences.getValue("addrespect", "false"), false);
%>

<portlet:actionURL name="editPreferencesAction" var="editPreferencesURL"></portlet:actionURL>

<aui:form name="editPreferencesForm" action="<%= editPreferencesURL %>" method="POST">
	<%-- 
	<aui:fieldset label="Badge types to show">
		<aui:input type="checkbox" name="showthankyou" label="Thank You"></aui:input>
		<aui:input type="checkbox" name="showrespect" label="Respect"></aui:input>
	</aui:fieldset>
	--%>

	<aui:fieldset label="Restrict Badge Type">
		<aui:input type="radio" name="restrictbadgetype" value="addthankyou" label="Thank You" checked="<%= addthankyou %>"></aui:input>
		<aui:input type="radio" name="restrictbadgetype" value="addrespect" label="Respect" checked="<%= addrespect %>"></aui:input>
	</aui:fieldset>

	<%--
	<aui:fieldset label="Portlet parts to display">
		<aui:input type="checkbox" name="displayform" label="Add Badge Form"></aui:input>
		<aui:input type="checkbox" name="displaybadges" label="Display Badges"></aui:input>
	</aui:fieldset>
	 --%>

	<aui:fieldset label="Admin Mode">
		<aui:input type="checkbox" name="adminmode" label="Admin Mode" checked="<%= adminmode %>"></aui:input>
	</aui:fieldset>

	<aui:input type="submit" name="editSubmit" value="Save"></aui:input>
</aui:form>

