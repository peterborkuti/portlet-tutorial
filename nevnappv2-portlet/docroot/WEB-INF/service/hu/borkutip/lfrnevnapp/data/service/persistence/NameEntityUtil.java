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

package hu.borkutip.lfrnevnapp.data.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import hu.borkutip.lfrnevnapp.data.model.NameEntity;

import java.util.List;

/**
 * The persistence utility for the name entity service. This utility wraps {@link NameEntityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Péter Borkuti
 * @see NameEntityPersistence
 * @see NameEntityPersistenceImpl
 * @generated
 */
public class NameEntityUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(NameEntity nameEntity) {
		getPersistence().clearCache(nameEntity);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<NameEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<NameEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<NameEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static NameEntity update(NameEntity nameEntity)
		throws SystemException {
		return getPersistence().update(nameEntity);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static NameEntity update(NameEntity nameEntity,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(nameEntity, serviceContext);
	}

	/**
	* Caches the name entity in the entity cache if it is enabled.
	*
	* @param nameEntity the name entity
	*/
	public static void cacheResult(
		hu.borkutip.lfrnevnapp.data.model.NameEntity nameEntity) {
		getPersistence().cacheResult(nameEntity);
	}

	/**
	* Caches the name entities in the entity cache if it is enabled.
	*
	* @param nameEntities the name entities
	*/
	public static void cacheResult(
		java.util.List<hu.borkutip.lfrnevnapp.data.model.NameEntity> nameEntities) {
		getPersistence().cacheResult(nameEntities);
	}

	/**
	* Creates a new name entity with the primary key. Does not add the name entity to the database.
	*
	* @param nameId the primary key for the new name entity
	* @return the new name entity
	*/
	public static hu.borkutip.lfrnevnapp.data.model.NameEntity create(
		long nameId) {
		return getPersistence().create(nameId);
	}

	/**
	* Removes the name entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param nameId the primary key of the name entity
	* @return the name entity that was removed
	* @throws hu.borkutip.lfrnevnapp.data.NoSuchNameEntityException if a name entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.borkutip.lfrnevnapp.data.model.NameEntity remove(
		long nameId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkutip.lfrnevnapp.data.NoSuchNameEntityException {
		return getPersistence().remove(nameId);
	}

	public static hu.borkutip.lfrnevnapp.data.model.NameEntity updateImpl(
		hu.borkutip.lfrnevnapp.data.model.NameEntity nameEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(nameEntity);
	}

	/**
	* Returns the name entity with the primary key or throws a {@link hu.borkutip.lfrnevnapp.data.NoSuchNameEntityException} if it could not be found.
	*
	* @param nameId the primary key of the name entity
	* @return the name entity
	* @throws hu.borkutip.lfrnevnapp.data.NoSuchNameEntityException if a name entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.borkutip.lfrnevnapp.data.model.NameEntity findByPrimaryKey(
		long nameId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkutip.lfrnevnapp.data.NoSuchNameEntityException {
		return getPersistence().findByPrimaryKey(nameId);
	}

	/**
	* Returns the name entity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param nameId the primary key of the name entity
	* @return the name entity, or <code>null</code> if a name entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.borkutip.lfrnevnapp.data.model.NameEntity fetchByPrimaryKey(
		long nameId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(nameId);
	}

	/**
	* Returns all the name entities.
	*
	* @return the name entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.borkutip.lfrnevnapp.data.model.NameEntity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<hu.borkutip.lfrnevnapp.data.model.NameEntity> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the name entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkutip.lfrnevnapp.data.model.impl.NameEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of name entities
	* @param end the upper bound of the range of name entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of name entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.borkutip.lfrnevnapp.data.model.NameEntity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the name entities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of name entities.
	*
	* @return the number of name entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static NameEntityPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (NameEntityPersistence)PortletBeanLocatorUtil.locate(hu.borkutip.lfrnevnapp.data.service.ClpSerializer.getServletContextName(),
					NameEntityPersistence.class.getName());

			ReferenceRegistry.registerReference(NameEntityUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(NameEntityPersistence persistence) {
	}

	private static NameEntityPersistence _persistence;
}