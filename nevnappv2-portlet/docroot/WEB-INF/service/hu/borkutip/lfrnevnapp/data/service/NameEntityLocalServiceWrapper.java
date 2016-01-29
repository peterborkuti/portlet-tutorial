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
 * Provides a wrapper for {@link NameEntityLocalService}.
 *
 * @author Péter Borkuti
 * @see NameEntityLocalService
 * @generated
 */
public class NameEntityLocalServiceWrapper implements NameEntityLocalService,
	ServiceWrapper<NameEntityLocalService> {
	public NameEntityLocalServiceWrapper(
		NameEntityLocalService nameEntityLocalService) {
		_nameEntityLocalService = nameEntityLocalService;
	}

	/**
	* Adds the name entity to the database. Also notifies the appropriate model listeners.
	*
	* @param nameEntity the name entity
	* @return the name entity that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.borkutip.lfrnevnapp.data.model.NameEntity addNameEntity(
		hu.borkutip.lfrnevnapp.data.model.NameEntity nameEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nameEntityLocalService.addNameEntity(nameEntity);
	}

	/**
	* Creates a new name entity with the primary key. Does not add the name entity to the database.
	*
	* @param nameId the primary key for the new name entity
	* @return the new name entity
	*/
	@Override
	public hu.borkutip.lfrnevnapp.data.model.NameEntity createNameEntity(
		long nameId) {
		return _nameEntityLocalService.createNameEntity(nameId);
	}

	/**
	* Deletes the name entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param nameId the primary key of the name entity
	* @return the name entity that was removed
	* @throws PortalException if a name entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.borkutip.lfrnevnapp.data.model.NameEntity deleteNameEntity(
		long nameId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nameEntityLocalService.deleteNameEntity(nameId);
	}

	/**
	* Deletes the name entity from the database. Also notifies the appropriate model listeners.
	*
	* @param nameEntity the name entity
	* @return the name entity that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.borkutip.lfrnevnapp.data.model.NameEntity deleteNameEntity(
		hu.borkutip.lfrnevnapp.data.model.NameEntity nameEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nameEntityLocalService.deleteNameEntity(nameEntity);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _nameEntityLocalService.dynamicQuery();
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
		return _nameEntityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkutip.lfrnevnapp.data.model.impl.NameEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _nameEntityLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkutip.lfrnevnapp.data.model.impl.NameEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _nameEntityLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _nameEntityLocalService.dynamicQueryCount(dynamicQuery);
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
		return _nameEntityLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public hu.borkutip.lfrnevnapp.data.model.NameEntity fetchNameEntity(
		long nameId) throws com.liferay.portal.kernel.exception.SystemException {
		return _nameEntityLocalService.fetchNameEntity(nameId);
	}

	/**
	* Returns the name entity with the primary key.
	*
	* @param nameId the primary key of the name entity
	* @return the name entity
	* @throws PortalException if a name entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.borkutip.lfrnevnapp.data.model.NameEntity getNameEntity(
		long nameId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nameEntityLocalService.getNameEntity(nameId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nameEntityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the name entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkutip.lfrnevnapp.data.model.impl.NameEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of name entities
	* @param end the upper bound of the range of name entities (not inclusive)
	* @return the range of name entities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<hu.borkutip.lfrnevnapp.data.model.NameEntity> getNameEntities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nameEntityLocalService.getNameEntities(start, end);
	}

	/**
	* Returns the number of name entities.
	*
	* @return the number of name entities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getNameEntitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nameEntityLocalService.getNameEntitiesCount();
	}

	/**
	* Updates the name entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param nameEntity the name entity
	* @return the name entity that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.borkutip.lfrnevnapp.data.model.NameEntity updateNameEntity(
		hu.borkutip.lfrnevnapp.data.model.NameEntity nameEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nameEntityLocalService.updateNameEntity(nameEntity);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _nameEntityLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_nameEntityLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _nameEntityLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public NameEntityLocalService getWrappedNameEntityLocalService() {
		return _nameEntityLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedNameEntityLocalService(
		NameEntityLocalService nameEntityLocalService) {
		_nameEntityLocalService = nameEntityLocalService;
	}

	@Override
	public NameEntityLocalService getWrappedService() {
		return _nameEntityLocalService;
	}

	@Override
	public void setWrappedService(NameEntityLocalService nameEntityLocalService) {
		_nameEntityLocalService = nameEntityLocalService;
	}

	private NameEntityLocalService _nameEntityLocalService;
}