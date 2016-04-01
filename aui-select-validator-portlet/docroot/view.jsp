
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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui"%>

<portlet:defineObjects />

This is the
<b>aui-select-validator</b>
portlet.

<portlet:renderURL var="formRenderUrl" />

<aui:form action="<%=formRenderUrl.toString()%>" name="fm1"
	method="post">
	<aui:select label="select1" name="select1">
		<aui:option value="" label="Please select from list!" />
		<aui:option value="1" label="1" />
		<aui:option value="2" label="2" />
	</aui:select>
	<aui:script>
		AUI().use('aui-form-validator', function(A) {
			new A.FormValidator({
				boundingBox : '#<portlet:namespace />fm1',
				rules : {
					<portlet:namespace />select1 : {
						required : true
					}
				}
			});
		});
	</aui:script>

</aui:form>

<aui:form action="<%=formRenderUrl.toString()%>" name="fm2"
	method="post">
	<aui:select required="true" label="select2" name="select2">
		<aui:option value="" label="Please select from list!" />
		<aui:option value="1" label="1" />
		<aui:option value="2" label="2" />
	</aui:select>
</aui:form>