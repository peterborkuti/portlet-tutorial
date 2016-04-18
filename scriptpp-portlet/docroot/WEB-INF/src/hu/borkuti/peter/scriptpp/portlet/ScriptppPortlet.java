package hu.borkuti.peter.scriptpp.portlet;

import java.io.IOException;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncPrintWriter;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.log.SanitizerLogWrapper;
import com.liferay.portal.kernel.scripting.ScriptingException;
import com.liferay.portal.kernel.scripting.ScriptingHelperUtil;
import com.liferay.portal.kernel.scripting.ScriptingUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnsyncPrintWriterPool;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ScriptppPortlet extends MVCPortlet {

	public void executeScript(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		PortletConfig portletConfig = 
			(PortletConfig)actionRequest.getAttribute(
				JavaConstants.JAVAX_PORTLET_CONFIG);

		String script = ParamUtil.getString(actionRequest, "script", "");

		_log.error("executeScript:" + script);

		runScript(portletConfig, actionRequest, actionResponse);

		PortalUtil.copyRequestParameters(actionRequest, actionResponse);
	}

	protected void runScript(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) {

		String language = "groovy";
		String script = ParamUtil.getString(actionRequest, "script");

		PortletContext portletContext = portletConfig.getPortletContext();

		Map<String, Object> portletObjects =
			ScriptingHelperUtil.getPortletObjects(
				portletConfig, portletContext, actionRequest, actionResponse);

		UnsyncByteArrayOutputStream unsyncByteArrayOutputStream =
			new UnsyncByteArrayOutputStream();

		UnsyncPrintWriter unsyncPrintWriter = UnsyncPrintWriterPool.borrow(
			unsyncByteArrayOutputStream);

		portletObjects.put("out", unsyncPrintWriter);

		try {
			ScriptingUtil.exec(
				null, portletObjects, language, script, StringPool.EMPTY_ARRAY);

			unsyncPrintWriter.flush();

			actionRequest.setAttribute(
				"output", unsyncByteArrayOutputStream.toString());
		}
		catch (ScriptingException se) {
			actionRequest.setAttribute("error", se.getMessage());
		}
	}

	private Log _log = LogFactoryUtil.getLog(getClass());
}
