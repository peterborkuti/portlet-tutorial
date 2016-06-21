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

package hu.borkuti.peter.scriptpp.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ScriptService}.
 *
 * @author Peter Borkuti
 * @see ScriptService
 * @generated
 */
public class ScriptServiceWrapper implements ScriptService,
	ServiceWrapper<ScriptService> {
	public ScriptServiceWrapper(ScriptService scriptService) {
		_scriptService = scriptService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _scriptService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_scriptService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _scriptService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public void addScript(java.lang.String importContent,
		java.lang.String moduleContent) {
		_scriptService.addScript(importContent, moduleContent);
	}

	@Override
	public void addScript(java.lang.String importContent,
		java.lang.String moduleContent, java.lang.String scriptName) {
		_scriptService.addScript(importContent, moduleContent, scriptName);
	}

	@Override
	public void addScript(java.lang.String importContent,
		java.lang.String moduleContent, java.lang.String scriptName,
		java.lang.String dependencies) {
		_scriptService.addScript(importContent, moduleContent, scriptName,
			dependencies);
	}

	@Override
	public void deleteScripts(java.lang.String scriptIds) {
		_scriptService.deleteScripts(scriptIds);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getLastScript() {
		return _scriptService.getLastScript();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getScript(long scriptId) {
		return _scriptService.getScript(scriptId);
	}

	@Override
	public java.lang.String getScriptList() {
		return _scriptService.getScriptList();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getScriptNameVersions() {
		return _scriptService.getScriptNameVersions();
	}

	@Override
	public java.util.List<hu.borkuti.peter.scriptpp.service.model.ScriptOptions> getScriptOptions() {
		return _scriptService.getScriptOptions();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ScriptService getWrappedScriptService() {
		return _scriptService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedScriptService(ScriptService scriptService) {
		_scriptService = scriptService;
	}

	@Override
	public ScriptService getWrappedService() {
		return _scriptService;
	}

	@Override
	public void setWrappedService(ScriptService scriptService) {
		_scriptService = scriptService;
	}

	private ScriptService _scriptService;
}