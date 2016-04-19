package hu.borkuti.peter.scriptpp.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncPrintWriter;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.scripting.ScriptingException;
import com.liferay.portal.kernel.scripting.ScriptingHelperUtil;
import com.liferay.portal.kernel.scripting.ScriptingUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnsyncPrintWriterPool;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ScriptppPortlet extends MVCPortlet {

	
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response)
			throws IOException, PortletException {

		PortletConfig portletConfig = 
			(PortletConfig)request.getAttribute(
				JavaConstants.JAVAX_PORTLET_CONFIG);

		String script = ParamUtil.getString(request, "script", "");

		_log.error("executeScript:" + script);

		runScript(portletConfig, "groovy", script, request, response);

	}

	protected void runScript(
			PortletConfig portletConfig, String language, String script,
			ResourceRequest request, ResourceResponse response) {

		PortletContext portletContext = portletConfig.getPortletContext();

		Map<String, Object> portletObjects =
			ScriptingHelperUtil.getPortletObjects(
				portletConfig, portletContext, request, response);

		UnsyncByteArrayOutputStream unsyncByteArrayOutputStream =
			new UnsyncByteArrayOutputStream();

		UnsyncPrintWriter unsyncPrintWriter = UnsyncPrintWriterPool.borrow(
			unsyncByteArrayOutputStream);

		portletObjects.put("out", unsyncPrintWriter);

		String error = "";
		String output = "";

		try {
			ScriptingUtil.exec(
				null, portletObjects, language, script, StringPool.EMPTY_ARRAY);

			unsyncPrintWriter.flush();

			output = unsyncByteArrayOutputStream.toString();
		}
		catch (ScriptingException se) {
			error = se.getMessage();
		}

		sendJSON(response, output, error);
	}

	private void sendJSON(ResourceResponse response, String output, String error) {
		PrintWriter writer;
		try {
			writer = response.getWriter();
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("output", output);
			jsonObject.put("error", error);

			writer.write(jsonObject.toString());
		} catch (IOException e) {
			_log.error(e.getMessage());
		}


	}

	private Log _log = LogFactoryUtil.getLog(getClass());
}
