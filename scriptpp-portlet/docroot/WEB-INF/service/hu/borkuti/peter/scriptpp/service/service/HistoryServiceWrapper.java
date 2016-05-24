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
 * Provides a wrapper for {@link HistoryService}.
 *
 * @author Peter Borkuti
 * @see HistoryService
 * @generated
 */
public class HistoryServiceWrapper implements HistoryService,
	ServiceWrapper<HistoryService> {
	public HistoryServiceWrapper(HistoryService historyService) {
		_historyService = historyService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _historyService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_historyService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _historyService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.lang.Integer getRandomNumber() {
		return _historyService.getRandomNumber();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public HistoryService getWrappedHistoryService() {
		return _historyService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedHistoryService(HistoryService historyService) {
		_historyService = historyService;
	}

	@Override
	public HistoryService getWrappedService() {
		return _historyService;
	}

	@Override
	public void setWrappedService(HistoryService historyService) {
		_historyService = historyService;
	}

	private HistoryService _historyService;
}