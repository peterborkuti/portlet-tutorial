package hu.borkuti.peter.scriptpp.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.SystemException;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnsyncPrintWriterPool;
import com.liferay.util.bridges.mvc.MVCPortlet;

import hu.borkuti.peter.scriptpp.service.model.Script;
import hu.borkuti.peter.scriptpp.service.model.ScriptOptions;
import hu.borkuti.peter.scriptpp.service.service.ScriptServiceUtil;
import hu.borkuti.peter.scriptpp.service.service.persistence.ScriptOptionsUtil;

public class ScriptppPortlet extends MVCPortlet {

	
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response)
			throws IOException, PortletException {

		PortletConfig portletConfig = 
			(PortletConfig)request.getAttribute(
				JavaConstants.JAVAX_PORTLET_CONFIG);

		String type = ParamUtil.getString(request, "type", "command");
		String command = ParamUtil.getString(request, "command", "");
		String script = ParamUtil.getString(request, "script", "");
		String deps = ParamUtil.getString(request, "dependencies", "");

		List<Long> allDependencies = new ArrayList<Long>();
		getDependencyIds(deps, allDependencies);

		_log.error("done: allDeps:" + StringUtil.merge(allDependencies.toArray(new Long[0])));

		String bigScript =
			getConcatenatedScripts(script, "", command,
				allDependencies.toArray(new Long[0]));

		String groovyScript = bigScript;
		_log.error("executeScript:" + groovyScript);

		runScript(portletConfig, "groovy", groovyScript, request, response);

	}

	protected void getDependencyIds(String deps, List<Long> allDeps) {
		_log.error("deps:" + deps);
		_log.error("allDeps:" + StringUtil.merge(allDeps.toArray(new Long[0])));
		Long[] depIds = ScriptUtil.getLongArrFromStringList(deps);

		//prevent circular dependencies
		List<Long> newIds = new ArrayList<Long>();
		for (Long newId: depIds) {
			if (!allDeps.contains(newId)) {
				newIds.add(newId);
			}
		}

		for (long scriptId: newIds) {
			Script script = ScriptServiceUtil.getScriptObject(scriptId);

			if (script == null) {
				continue;
			}

			ScriptOptions sOpts = null;
			String subDeps = "";
			try {
				sOpts = ScriptOptionsUtil.fetchByPrimaryKey(script.getScriptOptionsId());
				subDeps = sOpts.getDependencyList();
			} catch (SystemException e) {
				_log.error(e.getMessage());
			}

			if ((subDeps != null) && !"".equals(subDeps)) {
				getDependencyIds(subDeps, allDeps);
			}

			if (!allDeps.contains(scriptId)) {
				allDeps.add(scriptId);
			}
		}

	}

	protected String getConcatenatedScripts(String moduleContent,
		String importContent, String command, Long[] allDeps) {

		String concatenatedScripts = "\n";
		for (long scriptId: allDeps) {
			Script script = ScriptServiceUtil.getScriptObject(scriptId);

			concatenatedScripts +=
				";\n" + script.getImportContent() + ";\n" +
					script.getModuleContent() + "\n";
		}

		return concatenatedScripts + ";\n" + importContent + ";\n" +
			moduleContent + ";\n" + command + "\n";
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
