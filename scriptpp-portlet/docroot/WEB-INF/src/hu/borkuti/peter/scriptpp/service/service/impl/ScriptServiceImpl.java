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

package hu.borkuti.peter.scriptpp.service.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException;
import hu.borkuti.peter.scriptpp.service.model.Script;
import hu.borkuti.peter.scriptpp.service.model.ScriptOptions;
import hu.borkuti.peter.scriptpp.service.service.base.ScriptServiceBaseImpl;

/**
 * The implementation of the script remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.borkuti.peter.scriptpp.service.service.ScriptService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Peter Borkuti
 * @see hu.borkuti.peter.scriptpp.service.service.base.ScriptServiceBaseImpl
 * @see hu.borkuti.peter.scriptpp.service.service.ScriptServiceUtil
 */
public class ScriptServiceImpl extends ScriptServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link hu.borkuti.peter.scriptpp.service.service.ScriptServiceUtil} to access the script remote service.
	 */

	public List<ScriptOptions> getScriptOptions() {
		List<ScriptOptions> scriptOpts = null;

		try {
			User user = userService.getCurrentUser();

			scriptOpts = scriptOptionsPersistence.findByG_U(
				user.getGroupId(), user.getUserId());

		} catch (SystemException e) {
			_log.error(e.getMessage());
		} catch (PortalException e) {
			_log.error(e.getMessage());
		}

		return scriptOpts;
	}

	private ServiceContext getContext() {
		ServiceContext context = new ServiceContext();
		User user;
		try {
			user = userService.getCurrentUser();
			context.setUserId(user.getUserId());
			context.setScopeGroupId(user.getGroupId());
			context.setCompanyId(user.getCompanyId());
			context.setCreateDate(new Date());
			context.setModifiedDate(new Date());
		} catch (PortalException e) {
			_log.error(e.getMessage());
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		return context;
	}

	public JSONObject getScriptNameVersions() {
		List<ScriptOptions> scriptOpts = getScriptOptions();

		JSONArray jsonScriptNames = JSONFactoryUtil.createJSONArray();
		JSONArray jsonScriptVersions = JSONFactoryUtil.createJSONArray();

		ServiceContext context = getContext();

		long userId = context.getUserId();
		long groupId = context.getScopeGroupId();

		if (userId == 0) {
			JSONObject emptyObj = JSONFactoryUtil.createJSONObject();
			JSONArray emptyArr = JSONFactoryUtil.createJSONArray();

			emptyObj.put("scriptNames", emptyArr);
			emptyObj.put("versions", emptyArr);

			return emptyObj;
		}

		for (ScriptOptions sOpts : scriptOpts) {
			long scriptOId = sOpts.getScriptOptionsId();

			String scriptName = sOpts.getScriptName() + " - " + sOpts.getScriptOptionsId();
			jsonScriptNames.put(scriptName);

			try {
				List<Script> scripts = scriptPersistence.findByG_U_SOid(groupId, userId, scriptOId);

				for (Script script: scripts) {
					//$('#your-select').multiSelect('addOption', { value: 'test', text: 'test', index: 0, nested: 'optgroup_label' });
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
					jsonObject.put("value",script.getScriptId());
					jsonObject.put("text",script.getCreateDate());
					jsonObject.put("nested", scriptName);
					jsonScriptVersions.put(jsonObject);
				}
			} catch (SystemException e) {
				_log.error(e.getMessage());
			}
		}

		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("scriptNames", jsonScriptNames);
		json.put("versions", jsonScriptVersions);

		return json;
	}

	public String[] getLastScript() {
		String[] strScript = {"", ""};

		try {
			ServiceContext context = getContext();

			long userId = context.getUserId();
			long groupId = context.getScopeGroupId();

			if (userId == 0) {
				return new String[0];
			}

			Script script = scriptPersistence.fetchByG_U_Last(groupId, userId, null);

			if (script != null) {
				strScript[1] = script.getImportContent();
				strScript[0] = script.getModuleContent();
			}
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		return strScript;
	}

	public String getScriptList() {
		String scripts = "ScriptServiceImp.getScriptList - Not Implemented Yet";

		ServiceContext context = getContext();

		long userId = context.getUserId();
		long groupId = context.getScopeGroupId();

		if (userId == 0) {
			return "";
		}

		try {
			List<Script> scriptList =
				scriptPersistence.findByG_U(groupId, userId);

		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		return scripts;
	}

	public void addScript(String importContent, String moduleContent) {
		addScript(importContent, moduleContent, "anonym");
	}

	private long getOrCreateScriptOptions(ServiceContext context, String scriptName) {
		ScriptOptions sOpt = null;
		long sOptId = 0;

		try {
			sOpt = scriptOptionsPersistence.findByG_U_ScriptName_Last(
				context.getScopeGroupId(), context.getUserId(), scriptName, null);

			sOptId = sOpt.getScriptOptionsId();
		} catch (NoSuchScriptOptionsException e1) {
		} catch (SystemException e1) {
			e1.printStackTrace();
			return 0;
		}

		if (sOpt == null) {
			try {
				sOptId = counterLocalService.increment();
			} catch (SystemException e) {
				e.printStackTrace();
				return 0;
			}

			sOpt = scriptOptionsPersistence.create(sOptId);
			sOpt.setScriptName(scriptName);
			sOpt.setCompanyId(context.getCompanyId());
			sOpt.setUserId(context.getUserId());
			sOpt.setGroupId(context.getScopeGroupId());
			sOpt.setCreateDate(context.getCreateDate());
			sOpt.setModifiedDate(context.getModifiedDate());

			try {
				scriptOptionsPersistence.update(sOpt);
			} catch (SystemException e) {
				e.printStackTrace();
				return 0;
			}
		}

		return sOptId;
	}

	public void addScript(String importContent, String moduleContent, String scriptName) {
		ServiceContext context = getContext();

		long userId = context.getUserId();

		if (userId == 0) {
			return;
		}

		if ("".equals(scriptName)) {
			scriptName = "anonym";
		}

		try {
			long sOptId = getOrCreateScriptOptions(context, scriptName);

			long scriptId = counterLocalService.increment();
			Script script = scriptPersistence.create(scriptId);
			script.setUserId(context.getUserId());
			script.setGroupId(context.getScopeGroupId());
			script.setCompanyId(context.getCompanyId());
			script.setCreateDate(context.getCreateDate());
			script.setModifiedDate(context.getModifiedDate());
			script.setScriptOptionsId(sOptId);
			script.setImportContent(importContent);
			script.setModuleContent(moduleContent);
			scriptPersistence.update(script);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}
	}

	Logger _log = Logger.getLogger(getClass());
}