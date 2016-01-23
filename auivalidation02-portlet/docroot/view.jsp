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
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />

This is the <b>auivalidation02</b> portlet.

<aui:form name="fm1">
<aui:input name="f1"><aui:validator name="required"></aui:validator></aui:input>
<aui:input name="f2"><aui:validator name="equalTo">'#<portlet:namespace/>f1'</aui:validator></aui:input>
<aui:input name="f3"><aui:validator name="range">[1.23,10]</aui:validator></aui:input>
<aui:input name="f4"><aui:validator name="rangeLength">[3,8]</aui:validator></aui:input>
<aui:input name="f5"><aui:validator name="range">[3.28,3.75]</aui:validator></aui:input>
</aui:form>