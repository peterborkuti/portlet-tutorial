<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="java.util.Date" %>
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

<%
	String[] names={"A","B","C"};

%>

This is the <b>auibutton</b> portlet.

<portlet:renderURL var="renderURL"></portlet:renderURL>

<aui:button value="add-manufacturer" onClick="<%= renderURL.toString() %>"/>

<aui:select name="someSelect">
<%
	for (int i = 0; i < names.length; i++) {
%>

	<aui:option value='<%= "" + i %>'><%= HtmlUtil.escape(names[i]) %></aui:option>

<%
	}
%>
</aui:select>

<%

class MyDate {
	private Date myDate = new Date();
	private String aaa = "";
	public void setMyDate(Date d) {
		myDate = d;
	}
	public Date getMyDate() {
		return myDate;
	}
	public void setAaa(String d) {
		aaa = d;
	}
	public String getAaa() {
		return aaa;
	}
}

MyDate mDate = new MyDate();

%>

<aui:model-context bean="<%= mDate %>" model="<%= MyDate.class %>"/>

<portlet:actionURL name="setDate" var="setDateURL"></portlet:actionURL>
<aui:form action="<%= setDateURL %>" name="fm" method="POST">
<aui:fieldset>
<aui:input name="myDate"/>
<aui:input name="aaa"/>
</aui:fieldset>
<aui:button type="submit">Send</aui:button>
</aui:form>