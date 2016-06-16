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

import java.util.Date;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import hu.borkuti.peter.scriptpp.service.model.Script;
import hu.borkuti.peter.scriptpp.service.service.ScriptLocalServiceUtil;
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

	public String[] getLastScript() {
		String[] strScript = {"", ""};

		try {
			User user = userService.getCurrentUser();

			Script script = scriptPersistence.fetchByG_U(user.getGroupId(), user.getUserId());

			if (script != null) {
				strScript[1] = script.getImportContent();
				strScript[0] = script.getModuleContent();
			}
		} catch (SystemException e) {
			_log.error(e.getMessage());
		} catch (PortalException e) {
			_log.error(e.getMessage());
		}

		return strScript;
	}

	public void addScript(String importContent, String moduleContent) {
		try {
			long scriptId;
			ServiceContext context = new ServiceContext();
			Date now = new Date();
			User user = userService.getCurrentUser();

			scriptId = counterLocalService.increment();
			Script script = scriptPersistence.create(scriptId);
			script.setUserId(user.getUserId());
			script.setGroupId(user.getGroupId());
			script.setCompanyId(user.getCompanyId());
			script.setCreateDate(context.getCreateDate(now));
			script.setModifiedDate(context.getModifiedDate(now));
			script.setImportContent(importContent);
			script.setModuleContent(moduleContent);
			scriptPersistence.update(script);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		} catch (PortalException e) {
			_log.error(e.getMessage());
		}
	}

	Logger _log = Logger.getLogger(getClass());
}