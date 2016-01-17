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

<portlet:defineObjects />

This is the <b>colorsetter</b> portlet.

<a href="<portlet:renderURL><portlet:param name="color" value="red"/><portlet:param name="resetcolor" value="false"/></portlet:renderURL>">red</a><br>
<a href="<portlet:renderURL><portlet:param name="color" value="green"/><portlet:param name="resetcolor" value="false"/></portlet:renderURL>">green</a><br>
<a href="<portlet:renderURL><portlet:param name="color" value="yellow"/><portlet:param name="resetcolor" value="false"/></portlet:renderURL>">yellow</a><br>
<a href="<portlet:renderURL><portlet:param name="resetcolor" value="true"/></portlet:renderURL>">none</a><br>