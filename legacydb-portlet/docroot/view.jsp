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
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%@ page import="test.sb.model.Legacydb"%>
<%@ page import="java.util.List"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="javax.portlet.PortletURL" %>

<portlet:defineObjects />

<%

	List<Legacydb> entities = (List<Legacydb>)renderRequest.getAttribute("entities");
	Integer delta2 = GetterUtil.getInteger(renderRequest.getParameter("delta2"), 10);
	String curPage2 = GetterUtil.getString(renderRequest.getParameter("cur2"), "1");
	Integer delta1 = GetterUtil.getInteger(renderRequest.getParameter("delta1"), 10);
	String curPage1 = GetterUtil.getString(renderRequest.getParameter("cur1"), "1");

%>
This is the <b>legacydb</b> portlet.

<portlet:actionURL var="actionURL">
	<portlet:param name="delta2" value='<%= "" + delta2 %>'/>
	<portlet:param name="cur2" value='<%= curPage2 %>'/>
	<portlet:param name="delta1" value='<%= "" + delta1 %>'/>
	<portlet:param name="cur1" value='<%= curPage1 %>'/>
</portlet:actionURL>

<%
PortletURL iteratorURL1 = renderResponse.createRenderURL();
iteratorURL1.setParameter("delta2", "" + delta2);
iteratorURL1.setParameter("cur2", curPage2);

PortletURL iteratorURL2 = renderResponse.createRenderURL();
iteratorURL2.setParameter("delta1", "" + delta1);
iteratorURL2.setParameter("cur1", curPage1);
%>

<p>
Add new <a href="<%= actionURL %>">random entity</a>
</p>

<liferay-ui:search-container
	iteratorURL="<%= iteratorURL1 %>"
	delta="<%= delta1 %>"
	emptyResultsMessage="no-data-found"
	curParam="cur1"
	deltaParam="delta1"
	>

	<liferay-ui:search-container-results
		results="<%= 
			ListUtil.subList(
				entities, searchContainer.getStart(), searchContainer.getEnd())
		%>"
		total="<%= entities.size() %>"
	/>

	<liferay-ui:search-container-row
		className="test.sb.model.Legacydb"
		keyProperty="legacydbid"
		modelVar="entity"
	>
		<liferay-ui:search-container-column-text
			name="Id"
			property="legacydbid"
		/>

		<liferay-ui:search-container-column-text
			name="Name"
			property="name"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>

<liferay-ui:search-container
	iteratorURL="<%= iteratorURL2 %>"
	delta="<%= delta2 %>"
	emptyResultsMessage="no-data-found"
	curParam="cur2"
	deltaParam="delta2"
	>

	<liferay-ui:search-container-results
		results="<%= 
			ListUtil.subList(
				entities, searchContainer.getStart(), searchContainer.getEnd())
		%>"
		total="<%= entities.size() %>"
	/>

	<liferay-ui:search-container-row
		className="test.sb.model.Legacydb"
		keyProperty="legacydbid"
		modelVar="entity"
	>
		<liferay-ui:search-container-column-text
			name="Id"
			property="legacydbid"
		/>

		<liferay-ui:search-container-column-text
			name="Name"
			property="name"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>

