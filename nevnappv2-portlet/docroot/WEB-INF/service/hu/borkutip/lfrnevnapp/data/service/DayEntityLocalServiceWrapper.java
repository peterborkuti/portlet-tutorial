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

package hu.borkutip.lfrnevnapp.data.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DayEntityLocalService}.
 *
 * @author Péter Borkuti
 * @see DayEntityLocalService
 * @generated
 */
public class DayEntityLocalServiceWrapper implements DayEntityLocalService,
	ServiceWrapper<DayEntityLocalService> {
	public DayEntityLocalServiceWrapper(
		DayEntityLocalService dayEntityLocalService) {
		_dayEntityLocalService = dayEntityLocalService;
	}

	/**
	* Adds the day entity to the database. Also notifies the appropriate model listeners.
	*
	* @param dayEntity the day entity
	* @return the day entity that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.borkutip.lfrnevnapp.data.model.DayEntity addDayEntity(
		hu.borkutip.lfrnevnapp.data.model.DayEntity dayEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dayEntityLocalService.addDayEntity(dayEntity);
	}

	/**
	* Creates a new day entity with the primary key. Does not add the day entity to the database.
	*
	* @param dayId the primary key for the new day entity
	* @return the new day entity
	*/
	@Override
	public hu.borkutip.lfrnevnapp.data.model.DayEntity createDayEntity(
		long dayId) {
		return _dayEntityLocalService.createDayEntity(dayId);
	}

	/**
	* Deletes the day entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dayId the primary key of the day entity
	* @return the day entity that was removed
	* @throws PortalException if a day entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.borkutip.lfrnevnapp.data.model.DayEntity deleteDayEntity(
		long dayId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dayEntityLocalService.deleteDayEntity(dayId);
	}

	/**
	* Deletes the day entity from the database. Also notifies the appropriate model listeners.
	*
	* @param dayEntity the day entity
	* @return the day entity that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.borkutip.lfrnevnapp.data.model.DayEntity deleteDayEntity(
		hu.borkutip.lfrnevnapp.data.model.DayEntity dayEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dayEntityLocalService.deleteDayEntity(dayEntity);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dayEntityLocalService.dynamicQuery();
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
		return _dayEntityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkutip.lfrnevnapp.data.model.impl.DayEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dayEntityLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkutip.lfrnevnapp.data.model.impl.DayEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dayEntityLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _dayEntityLocalService.dynamicQueryCount(dynamicQuery);
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
		return _dayEntityLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public hu.borkutip.lfrnevnapp.data.model.DayEntity fetchDayEntity(
		long dayId) throws com.liferay.portal.kernel.exception.SystemException {
		return _dayEntityLocalService.fetchDayEntity(dayId);
	}

	/**
	* Returns the day entity with the primary key.
	*
	* @param dayId the primary key of the day entity
	* @return the day entity
	* @throws PortalException if a day entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.borkutip.lfrnevnapp.data.model.DayEntity getDayEntity(long dayId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dayEntityLocalService.getDayEntity(dayId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dayEntityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the day entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkutip.lfrnevnapp.data.model.impl.DayEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of day entities
	* @param end the upper bound of the range of day entities (not inclusive)
	* @return the range of day entities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<hu.borkutip.lfrnevnapp.data.model.DayEntity> getDayEntities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dayEntityLocalService.getDayEntities(start, end);
	}

	/**
	* Returns the number of day entities.
	*
	* @return the number of day entities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDayEntitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dayEntityLocalService.getDayEntitiesCount();
	}

	/**
	* Updates the day entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dayEntity the day entity
	* @return the day entity that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.borkutip.lfrnevnapp.data.model.DayEntity updateDayEntity(
		hu.borkutip.lfrnevnapp.data.model.DayEntity dayEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dayEntityLocalService.updateDayEntity(dayEntity);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _dayEntityLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dayEntityLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dayEntityLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<hu.borkutip.lfrnevnapp.data.model.DayEntity> getDatesByNameId(
		long nameId) throws com.liferay.portal.kernel.exception.SystemException {
		return _dayEntityLocalService.getDatesByNameId(nameId);
	}

	@Override
	public java.util.List<hu.borkutip.lfrnevnapp.data.model.NameEntity> getNamesByMonthAndDay(
		int month, int day)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkutip.lfrnevnapp.data.NoSuchNameEntityException {
		return _dayEntityLocalService.getNamesByMonthAndDay(month, day);
	}

	@Override
	public boolean fillDatabase(java.net.URL resource) {
		return _dayEntityLocalService.fillDatabase(resource);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DayEntityLocalService getWrappedDayEntityLocalService() {
		return _dayEntityLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDayEntityLocalService(
		DayEntityLocalService dayEntityLocalService) {
		_dayEntityLocalService = dayEntityLocalService;
	}

	@Override
	public DayEntityLocalService getWrappedService() {
		return _dayEntityLocalService;
	}

	@Override
	public void setWrappedService(DayEntityLocalService dayEntityLocalService) {
		_dayEntityLocalService = dayEntityLocalService;
	}

	private DayEntityLocalService _dayEntityLocalService;
}