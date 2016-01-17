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

<%
	boolean reset = "true".equals(renderRequest.getParameter("resetcolor"));

	String color = renderRequest.getParameter("color");

	String divcolor = "background-color:" + color;
	if (reset) {
		divcolor = "";
	}
%>

<div style="width:100%; height:100%; <%= divcolor %>">

This is the <b>colorshower</b> portlet.
</div>

It needs colorsetter portlet.