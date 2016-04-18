
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

<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<portlet:defineObjects />

<%
	String output = GetterUtil.getString((String) renderRequest.getAttribute("output"));
	String error = GetterUtil.getString((String) renderRequest.getAttribute("error"));
%>
This is the
<b>script++</b>
portlet.

<portlet:actionURL name="executeScript" var="actionURL"></portlet:actionURL>

<aui:form action="#" method="POST" name="scriptFm" id="scriptFm">
	<aui:fieldset>
		<aui:input name="script" type="textarea"></aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button onClick="submitForm();" value="submit"></aui:button>
	</aui:button-row>
	<aui:fieldset>
		<aui:input name="output" type="textarea" disabled="true"
			value="<%=output%>"></aui:input>
	</aui:fieldset>
	<aui:fieldset>
		<aui:input name="error" type="textarea" disabled="true"
			value="<%=error%>"></aui:input>
	</aui:fieldset>
</aui:form>

<aui:script use="aui-io-request,aui-node">
    Liferay.provide(window,'submitForm',
         function() {
          var A = AUI();
          A.io.request('<%= actionURL %>',{
              method: 'POST',
              form: { id: '<portlet:namespace />scriptFm' },
              on: {
                  success: function(){
  					console.log("done");
   
                   }
             }
        });
  });
</aui:script>