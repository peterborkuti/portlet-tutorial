
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
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<portlet:defineObjects />

This is the
<b>aui-validation-test-00</b>
portlet.


<portlet:actionURL var="validate"></portlet:actionURL>

<h3>This works with aui:validator tag</h3>
<aui:form name="fm1" id="fm1" action="<%= validate %>" method="post">
	<aui:input name="emailfield1" value='' label="email">
		<aui:validator name="custom" errorMessage="Email is missing">
			function(val,node,junction){
				var result = false;
				if(val.length > 0) {
					result = true;
				}
				return result;
			}
		</aui:validator>
	</aui:input>
	<aui:button type="submit" value="Save" />
</aui:form>


<h3>This should work with form "required" validator script according to the 
<a href="https://dev.liferay.com/develop/tutorials/-/knowledge_base/6-2/using-the-alloyui-form-validator-in-a-portlet">doc</a>
</h3>

<aui:form name="fm2" id="fm2" action="<%= validate %>" method="post">
	<aui:input name="emailfield2" value='' label="email" />
	<aui:button type="submit" value="Save" />
</aui:form>

<aui:script>
	AUI().use('aui-form-validator', function(A) {
		new A.FormValidator({
			boundingBox : '#<portlet:namespace/>fm2',
			rules : {
				<portlet:namespace/>emailfield2 : {
					required : true
				}
			}
		})
	});
</aui:script>

<h3>Is this working?</h3>

<aui:form name="fm3" id="fm3" action="<%= validate %>" method="post">
	<aui:input name="emailfield3" value='' label="email" />
	<aui:button type="submit" value="Save" />
</aui:form>


<aui:script use="liferay-form">
	Liferay.Form.register({
		id : '<portlet:namespace />fm3',
		fieldRules : [ {
			body : function(val, fieldNode, ruleValue) {
				var result = false;
				if (val.length > 0) {
					result = true;
				}
				return result;
			},
			custom : true,
			errorMessage : 'First name is missing.',
			fieldName : '<portlet:namespace />emailfield3',
			validatorName : 'custom_rule_emailfield3'
		} ]
	});
</aui:script>
