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

package hu.borkuti.peter.scriptpp.service.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import hu.borkuti.peter.scriptpp.service.service.ScriptServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link hu.borkuti.peter.scriptpp.service.service.ScriptServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link hu.borkuti.peter.scriptpp.service.model.ScriptSoap}.
 * If the method in the service utility returns a
 * {@link hu.borkuti.peter.scriptpp.service.model.Script}, that is translated to a
 * {@link hu.borkuti.peter.scriptpp.service.model.ScriptSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Peter Borkuti
 * @see ScriptServiceHttp
 * @see hu.borkuti.peter.scriptpp.service.model.ScriptSoap
 * @see hu.borkuti.peter.scriptpp.service.service.ScriptServiceUtil
 * @generated
 */
public class ScriptServiceSoap {
	public static void addScript(java.lang.String importContent,
		java.lang.String moduleContent) throws RemoteException {
		try {
			ScriptServiceUtil.addScript(importContent, moduleContent);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addScript(java.lang.String importContent,
		java.lang.String moduleContent, java.lang.String scriptName)
		throws RemoteException {
		try {
			ScriptServiceUtil.addScript(importContent, moduleContent, scriptName);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addScript(java.lang.String importContent,
		java.lang.String moduleContent, java.lang.String scriptName,
		java.lang.String dependencies) throws RemoteException {
		try {
			ScriptServiceUtil.addScript(importContent, moduleContent,
				scriptName, dependencies);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteScripts(java.lang.String scriptIds)
		throws RemoteException {
		try {
			ScriptServiceUtil.deleteScripts(scriptIds);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getLastScript() throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = ScriptServiceUtil.getLastScript();

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.borkuti.peter.scriptpp.service.model.ScriptSoap getScriptObject(
		long scriptId) throws RemoteException {
		try {
			hu.borkuti.peter.scriptpp.service.model.Script returnValue = ScriptServiceUtil.getScriptObject(scriptId);

			return hu.borkuti.peter.scriptpp.service.model.ScriptSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getScript(long scriptId)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = ScriptServiceUtil.getScript(scriptId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getScriptList() throws RemoteException {
		try {
			java.lang.String returnValue = ScriptServiceUtil.getScriptList();

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getScriptNameVersions()
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = ScriptServiceUtil.getScriptNameVersions();

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.borkuti.peter.scriptpp.service.model.ScriptOptionsSoap[] getScriptOptions()
		throws RemoteException {
		try {
			java.util.List<hu.borkuti.peter.scriptpp.service.model.ScriptOptions> returnValue =
				ScriptServiceUtil.getScriptOptions();

			return hu.borkuti.peter.scriptpp.service.model.ScriptOptionsSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ScriptServiceSoap.class);
}