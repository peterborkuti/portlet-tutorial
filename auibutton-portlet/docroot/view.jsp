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
	public void setMyDate(Date d) {
		myDate = d;
	}
	public Date getMyDate() {
		return myDate;
	}
}

MyDate mDate = new MyDate();

%>

<aui:model-context bean="<%= mDate %>" model="<%= MyDate.class %>"/>

<portlet:actionURL name="setDate" var="setDateURL"></portlet:actionURL>

<aui:form action="<%= setDateURL %>" name="fm" method="POST">

	<%--
	normally aui:input does not need type attribute because ModelHintsUtil will help
	but my object is not created with service builder so ModelHintsUtil has no clue
	about it
	 --%>
	<aui:input name="myDate" type="date"/>

	<aui:button type="submit" value="Send"/>
</aui:form>