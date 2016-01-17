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

This is the <b>twoportlets</b> portlet.

To demonstrate the working of Public Render Parameters, put TwoPortlets2 also on
this page.
<p>
Click <a href="<portlet:renderURL><portlet:param name="pparam" value="XYZ"/></portlet:renderURL>">here</a>
to set pparam public render parameter to XYZ and check twoportlets2.
</p>
<p>
For page-cross public render params, check the README.md or set this into
your portal's portal-ext.properties file:
</p>
<pre>
layout.default.p_l_reset=false
portlet.public.render.parameter.distribution=layout-set
</pre>