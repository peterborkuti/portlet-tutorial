/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package permission.servicebuider.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FirstnamesLocalService}.
 *
 * @author peter
 * @see FirstnamesLocalService
 * @generated
 */
public class FirstnamesLocalServiceWrapper implements FirstnamesLocalService,
	ServiceWrapper<FirstnamesLocalService> {
	public FirstnamesLocalServiceWrapper(
		FirstnamesLocalService firstnamesLocalService) {
		_firstnamesLocalService = firstnamesLocalService;
	}

	/**
	* Adds the firstnames to the database. Also notifies the appropriate model listeners.
	*
	* @param firstnames the firstnames
	* @return the firstnames that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public permission.servicebuider.model.Firstnames addFirstnames(
		permission.servicebuider.model.Firstnames firstnames)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _firstnamesLocalService.addFirstnames(firstnames);
	}

	/**
	* Creates a new firstnames with the primary key. Does not add the firstnames to the database.
	*
	* @param firstnameId the primary key for the new firstnames
	* @return the new firstnames
	*/
	@Override
	public permission.servicebuider.model.Firstnames createFirstnames(
		long firstnameId) {
		return _firstnamesLocalService.createFirstnames(firstnameId);
	}

	/**
	* Deletes the firstnames with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param firstnameId the primary key of the firstnames
	* @return the firstnames that was removed
	* @throws PortalException if a firstnames with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public permission.servicebuider.model.Firstnames deleteFirstnames(
		long firstnameId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _firstnamesLocalService.deleteFirstnames(firstnameId);
	}

	/**
	* Deletes the firstnames from the database. Also notifies the appropriate model listeners.
	*
	* @param firstnames the firstnames
	* @return the firstnames that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public permission.servicebuider.model.Firstnames deleteFirstnames(
		permission.servicebuider.model.Firstnames firstnames)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _firstnamesLocalService.deleteFirstnames(firstnames);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _firstnamesLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _firstnamesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link permission.servicebuider.model.impl.FirstnamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _firstnamesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link permission.servicebuider.model.impl.FirstnamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _firstnamesLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _firstnamesLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _firstnamesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public permission.servicebuider.model.Firstnames fetchFirstnames(
		long firstnameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _firstnamesLocalService.fetchFirstnames(firstnameId);
	}

	/**
	* Returns the firstnames with the primary key.
	*
	* @param firstnameId the primary key of the firstnames
	* @return the firstnames
	* @throws PortalException if a firstnames with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public permission.servicebuider.model.Firstnames getFirstnames(
		long firstnameId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _firstnamesLocalService.getFirstnames(firstnameId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _firstnamesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the firstnameses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link permission.servicebuider.model.impl.FirstnamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of firstnameses
	* @param end the upper bound of the range of firstnameses (not inclusive)
	* @return the range of firstnameses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<permission.servicebuider.model.Firstnames> getFirstnameses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _firstnamesLocalService.getFirstnameses(start, end);
	}

	/**
	* Returns the number of firstnameses.
	*
	* @return the number of firstnameses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFirstnamesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _firstnamesLocalService.getFirstnamesesCount();
	}

	/**
	* Updates the firstnames in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param firstnames the firstnames
	* @return the firstnames that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public permission.servicebuider.model.Firstnames updateFirstnames(
		permission.servicebuider.model.Firstnames firstnames)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _firstnamesLocalService.updateFirstnames(firstnames);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _firstnamesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_firstnamesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _firstnamesLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FirstnamesLocalService getWrappedFirstnamesLocalService() {
		return _firstnamesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFirstnamesLocalService(
		FirstnamesLocalService firstnamesLocalService) {
		_firstnamesLocalService = firstnamesLocalService;
	}

	@Override
	public FirstnamesLocalService getWrappedService() {
		return _firstnamesLocalService;
	}

	@Override
	public void setWrappedService(FirstnamesLocalService firstnamesLocalService) {
		_firstnamesLocalService = firstnamesLocalService;
	}

	private FirstnamesLocalService _firstnamesLocalService;
}