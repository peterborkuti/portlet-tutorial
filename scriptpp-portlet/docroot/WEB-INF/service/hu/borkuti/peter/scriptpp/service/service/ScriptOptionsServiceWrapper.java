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
 * Provides a wrapper for {@link ScriptOptionsService}.
 *
 * @author Peter Borkuti
 * @see ScriptOptionsService
 * @generated
 */
public class ScriptOptionsServiceWrapper implements ScriptOptionsService,
	ServiceWrapper<ScriptOptionsService> {
	public ScriptOptionsServiceWrapper(
		ScriptOptionsService scriptOptionsService) {
		_scriptOptionsService = scriptOptionsService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _scriptOptionsService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_scriptOptionsService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _scriptOptionsService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.lang.Integer getRandomNumber() {
		return _scriptOptionsService.getRandomNumber();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ScriptOptionsService getWrappedScriptOptionsService() {
		return _scriptOptionsService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedScriptOptionsService(
		ScriptOptionsService scriptOptionsService) {
		_scriptOptionsService = scriptOptionsService;
	}

	@Override
	public ScriptOptionsService getWrappedService() {
		return _scriptOptionsService;
	}

	@Override
	public void setWrappedService(ScriptOptionsService scriptOptionsService) {
		_scriptOptionsService = scriptOptionsService;
	}

	private ScriptOptionsService _scriptOptionsService;
}