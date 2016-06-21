package hu.borkuti.peter.scriptpp.portlet;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import hu.borkuti.peter.scriptpp.service.model.Script;
import hu.borkuti.peter.scriptpp.service.model.ScriptOptions;

public class ScriptUtil {

	public static JSONObject setJSONScriptObject(JSONObject json, Script script) {
		if (json == null) {
			json = createEmptyJSONScriptObject();
		}

		if (script != null) {
			json.put("scriptId", script.getScriptId());
			json.put("importContent", script.getImportContent());
			json.put("moduleContent", script.getModuleContent());
		}
		return json;
	}

	public static Long[] getLongArrFromStringList(String list) {
		List<Long> arr = new ArrayList<Long>();

		if ((list == null) || ("".equals(list))) {
			return arr.toArray(new Long[0]);
		}

		String[] sIds = list.split(",");

		for (String sId: sIds) {
			Long l = 0l;
			try {
				l = Long.valueOf(sId);
				arr.add(l);
			} catch (NumberFormatException e) {
				_log.error(e.getMessage());
			}
		}

		return arr.toArray(new Long[0]);
	}

	public static JSONObject setJSONScriptObject(JSONObject json, ScriptOptions scriptOptions) {
		if (json == null) {
			json = createEmptyJSONScriptObject();
		}

		if (scriptOptions != null) {
			json.put("scriptOptionsId", scriptOptions.getScriptOptionsId());
			json.put("scriptName", scriptOptions.getScriptName());
			JSONArray depArr = JSONFactoryUtil.createJSONArray();

			Long[] ids =
				getLongArrFromStringList(scriptOptions.getDependencyList());

			for (Long id: ids) {
				depArr.put(id);
			}

			json.put("dependencyIds", depArr);
		}

		return json;
	}

	public static JSONObject createEmptyJSONScriptObject() {
		JSONObject script = JSONFactoryUtil.createJSONObject();
		script.put("scriptId", 0l);
		script.put("scriptName", "");
		script.put("importContent", "");
		script.put("moduleContent", "");
		JSONArray arr = JSONFactoryUtil.createJSONArray();
		script.put("dependencyIds", arr);

		return script;
	}

	private static Logger _log = Logger.getLogger("ScriptUtil");
}
