
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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>


<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@ page import="com.liferay.portal.kernel.template.TemplateHandler"%>
<%@ page
	import="com.liferay.portal.kernel.template.TemplateHandlerRegistryUtil"%>
<%@ page import="test.portlet.Adt01Portlet"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />

This is the
<b>adt01</b>
portlet configuration page.

<div class="display-template">

	<%
		TemplateHandler templateHandler = TemplateHandlerRegistryUtil.getTemplateHandler(String.class.getName());
		String displayStyle = portletPreferences.getValue("displayStyle", "normal");
		long displayStyleGroupId = GetterUtil.getLong(portletPreferences.getValue("displayStyleGroupId", null),
				themeDisplay.getScopeGroupId());

		List<String> displayStyles = new ArrayList<String>();
	%>

	<liferay-portlet:actionURL portletConfiguration="true"
		var="configurationURL" />

	<aui:form action="<%=configurationURL%>" method="post" name="fm">
		<aui:input name="<%=Constants.CMD%>" type="hidden"
			value="<%=Constants.UPDATE%>" />

		<aui:fieldset>

			<div class="display-template">

				<liferay-ui:ddm-template-selector
					classNameId="<%=PortalUtil.getClassNameId(templateHandler.getClassName())%>"
					displayStyle="<%=displayStyle%>"
					displayStyleGroupId="<%=displayStyleGroupId%>"
					displayStyles="<%=displayStyles%>"
					refreshURL="<%=PortalUtil.getCurrentURL(request)%>"
					showEmptyOption="<%=true%>" />
			</div>

		</aui:fieldset>

		<aui:button-row>
			<aui:button type="submit" />
		</aui:button-row>
	</aui:form>