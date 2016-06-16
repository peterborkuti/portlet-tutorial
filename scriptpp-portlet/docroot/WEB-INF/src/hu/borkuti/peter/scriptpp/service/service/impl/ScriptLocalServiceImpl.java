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
import java.util.List;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

import hu.borkuti.peter.scriptpp.service.model.History;
import hu.borkuti.peter.scriptpp.service.model.Script;
import hu.borkuti.peter.scriptpp.service.service.base.ScriptLocalServiceBaseImpl;

/**
 * The implementation of the script local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.borkuti.peter.scriptpp.service.service.ScriptLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Peter Borkuti
 * @see hu.borkuti.peter.scriptpp.service.service.base.ScriptLocalServiceBaseImpl
 * @see hu.borkuti.peter.scriptpp.service.service.ScriptLocalServiceUtil
 */
public class ScriptLocalServiceImpl extends ScriptLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link hu.borkuti.peter.scriptpp.service.service.ScriptLocalServiceUtil} to access the script local service.
	 */
	public String[] getLastScript() throws SystemException {
		String[] strScript = {"", ""};

		try {
			User user = userService.getCurrentUser();

			Script script = scriptPersistence.fetchByG_U(user.getGroupId(), user.getUserId());

			if (script != null) {
				strScript[0] = script.getImportContent();
				strScript[1] = script.getModuleContent();
			}
		} catch (PortalException e) {
			_log.error(e.getMessage());
		}

		return strScript;
	}

	Logger _log = Logger.getLogger(getClass());
}