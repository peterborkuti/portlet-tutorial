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

import hu.borkutip.lfrnevnapp.data.model.DayEntity;

import java.util.List;

/**
 * The persistence utility for the day entity service. This utility wraps {@link DayEntityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Péter Borkuti
 * @see DayEntityPersistence
 * @see DayEntityPersistenceImpl
 * @generated
 */
public class DayEntityUtil {
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
	public static void clearCache(DayEntity dayEntity) {
		getPersistence().clearCache(dayEntity);
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
	public static List<DayEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DayEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DayEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static DayEntity update(DayEntity dayEntity)
		throws SystemException {
		return getPersistence().update(dayEntity);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static DayEntity update(DayEntity dayEntity,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(dayEntity, serviceContext);
	}

	/**
	* Returns all the day entities where month = &#63; and day = &#63;.
	*
	* @param month the month
	* @param day the day
	* @return the matching day entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.borkutip.lfrnevnapp.data.model.DayEntity> findBymonthAndDay(
		int month, int day)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBymonthAndDay(month, day);
	}

	/**
	* Returns a range of all the day entities where month = &#63; and day = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkutip.lfrnevnapp.data.model.impl.DayEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param month the month
	* @param day the day
	* @param start the lower bound of the range of day entities
	* @param end the upper bound of the range of day entities (not inclusive)
	* @return the range of matching day entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.borkutip.lfrnevnapp.data.model.DayEntity> findBymonthAndDay(
		int month, int day, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBymonthAndDay(month, day, start, end);
	}

	/**
	* Returns an ordered range of all the day entities where month = &#63; and day = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkutip.lfrnevnapp.data.model.impl.DayEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param month the month
	* @param day the day
	* @param start the lower bound of the range of day entities
	* @param end the upper bound of the range of day entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching day entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.borkutip.lfrnevnapp.data.model.DayEntity> findBymonthAndDay(
		int month, int day, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymonthAndDay(month, day, start, end, orderByComparator);
	}

	/**
	* Returns the first day entity in the ordered set where month = &#63; and day = &#63;.
	*
	* @param month the month
	* @param day the day
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching day entity
	* @throws hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException if a matching day entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.borkutip.lfrnevnapp.data.model.DayEntity findBymonthAndDay_First(
		int month, int day,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException {
		return getPersistence()
				   .findBymonthAndDay_First(month, day, orderByComparator);
	}

	/**
	* Returns the first day entity in the ordered set where month = &#63; and day = &#63;.
	*
	* @param month the month
	* @param day the day
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching day entity, or <code>null</code> if a matching day entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.borkutip.lfrnevnapp.data.model.DayEntity fetchBymonthAndDay_First(
		int month, int day,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBymonthAndDay_First(month, day, orderByComparator);
	}

	/**
	* Returns the last day entity in the ordered set where month = &#63; and day = &#63;.
	*
	* @param month the month
	* @param day the day
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching day entity
	* @throws hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException if a matching day entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.borkutip.lfrnevnapp.data.model.DayEntity findBymonthAndDay_Last(
		int month, int day,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException {
		return getPersistence()
				   .findBymonthAndDay_Last(month, day, orderByComparator);
	}

	/**
	* Returns the last day entity in the ordered set where month = &#63; and day = &#63;.
	*
	* @param month the month
	* @param day the day
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching day entity, or <code>null</code> if a matching day entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.borkutip.lfrnevnapp.data.model.DayEntity fetchBymonthAndDay_Last(
		int month, int day,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBymonthAndDay_Last(month, day, orderByComparator);
	}

	/**
	* Returns the day entities before and after the current day entity in the ordered set where month = &#63; and day = &#63;.
	*
	* @param dayId the primary key of the current day entity
	* @param month the month
	* @param day the day
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next day entity
	* @throws hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException if a day entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.borkutip.lfrnevnapp.data.model.DayEntity[] findBymonthAndDay_PrevAndNext(
		long dayId, int month, int day,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException {
		return getPersistence()
				   .findBymonthAndDay_PrevAndNext(dayId, month, day,
			orderByComparator);
	}

	/**
	* Removes all the day entities where month = &#63; and day = &#63; from the database.
	*
	* @param month the month
	* @param day the day
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBymonthAndDay(int month, int day)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBymonthAndDay(month, day);
	}

	/**
	* Returns the number of day entities where month = &#63; and day = &#63;.
	*
	* @param month the month
	* @param day the day
	* @return the number of matching day entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countBymonthAndDay(int month, int day)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBymonthAndDay(month, day);
	}

	/**
	* Returns all the day entities where nameId = &#63;.
	*
	* @param nameId the name ID
	* @return the matching day entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.borkutip.lfrnevnapp.data.model.DayEntity> findByNameId(
		long nameId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNameId(nameId);
	}

	/**
	* Returns a range of all the day entities where nameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkutip.lfrnevnapp.data.model.impl.DayEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nameId the name ID
	* @param start the lower bound of the range of day entities
	* @param end the upper bound of the range of day entities (not inclusive)
	* @return the range of matching day entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.borkutip.lfrnevnapp.data.model.DayEntity> findByNameId(
		long nameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNameId(nameId, start, end);
	}

	/**
	* Returns an ordered range of all the day entities where nameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkutip.lfrnevnapp.data.model.impl.DayEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param nameId the name ID
	* @param start the lower bound of the range of day entities
	* @param end the upper bound of the range of day entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching day entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.borkutip.lfrnevnapp.data.model.DayEntity> findByNameId(
		long nameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNameId(nameId, start, end, orderByComparator);
	}

	/**
	* Returns the first day entity in the ordered set where nameId = &#63;.
	*
	* @param nameId the name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching day entity
	* @throws hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException if a matching day entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.borkutip.lfrnevnapp.data.model.DayEntity findByNameId_First(
		long nameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException {
		return getPersistence().findByNameId_First(nameId, orderByComparator);
	}

	/**
	* Returns the first day entity in the ordered set where nameId = &#63;.
	*
	* @param nameId the name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching day entity, or <code>null</code> if a matching day entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.borkutip.lfrnevnapp.data.model.DayEntity fetchByNameId_First(
		long nameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNameId_First(nameId, orderByComparator);
	}

	/**
	* Returns the last day entity in the ordered set where nameId = &#63;.
	*
	* @param nameId the name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching day entity
	* @throws hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException if a matching day entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.borkutip.lfrnevnapp.data.model.DayEntity findByNameId_Last(
		long nameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException {
		return getPersistence().findByNameId_Last(nameId, orderByComparator);
	}

	/**
	* Returns the last day entity in the ordered set where nameId = &#63;.
	*
	* @param nameId the name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching day entity, or <code>null</code> if a matching day entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.borkutip.lfrnevnapp.data.model.DayEntity fetchByNameId_Last(
		long nameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNameId_Last(nameId, orderByComparator);
	}

	/**
	* Returns the day entities before and after the current day entity in the ordered set where nameId = &#63;.
	*
	* @param dayId the primary key of the current day entity
	* @param nameId the name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next day entity
	* @throws hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException if a day entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.borkutip.lfrnevnapp.data.model.DayEntity[] findByNameId_PrevAndNext(
		long dayId, long nameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException {
		return getPersistence()
				   .findByNameId_PrevAndNext(dayId, nameId, orderByComparator);
	}

	/**
	* Removes all the day entities where nameId = &#63; from the database.
	*
	* @param nameId the name ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNameId(long nameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNameId(nameId);
	}

	/**
	* Returns the number of day entities where nameId = &#63;.
	*
	* @param nameId the name ID
	* @return the number of matching day entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNameId(long nameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNameId(nameId);
	}

	/**
	* Caches the day entity in the entity cache if it is enabled.
	*
	* @param dayEntity the day entity
	*/
	public static void cacheResult(
		hu.borkutip.lfrnevnapp.data.model.DayEntity dayEntity) {
		getPersistence().cacheResult(dayEntity);
	}

	/**
	* Caches the day entities in the entity cache if it is enabled.
	*
	* @param dayEntities the day entities
	*/
	public static void cacheResult(
		java.util.List<hu.borkutip.lfrnevnapp.data.model.DayEntity> dayEntities) {
		getPersistence().cacheResult(dayEntities);
	}

	/**
	* Creates a new day entity with the primary key. Does not add the day entity to the database.
	*
	* @param dayId the primary key for the new day entity
	* @return the new day entity
	*/
	public static hu.borkutip.lfrnevnapp.data.model.DayEntity create(long dayId) {
		return getPersistence().create(dayId);
	}

	/**
	* Removes the day entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dayId the primary key of the day entity
	* @return the day entity that was removed
	* @throws hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException if a day entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.borkutip.lfrnevnapp.data.model.DayEntity remove(long dayId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException {
		return getPersistence().remove(dayId);
	}

	public static hu.borkutip.lfrnevnapp.data.model.DayEntity updateImpl(
		hu.borkutip.lfrnevnapp.data.model.DayEntity dayEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(dayEntity);
	}

	/**
	* Returns the day entity with the primary key or throws a {@link hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException} if it could not be found.
	*
	* @param dayId the primary key of the day entity
	* @return the day entity
	* @throws hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException if a day entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.borkutip.lfrnevnapp.data.model.DayEntity findByPrimaryKey(
		long dayId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException {
		return getPersistence().findByPrimaryKey(dayId);
	}

	/**
	* Returns the day entity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dayId the primary key of the day entity
	* @return the day entity, or <code>null</code> if a day entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.borkutip.lfrnevnapp.data.model.DayEntity fetchByPrimaryKey(
		long dayId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(dayId);
	}

	/**
	* Returns all the day entities.
	*
	* @return the day entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.borkutip.lfrnevnapp.data.model.DayEntity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<hu.borkutip.lfrnevnapp.data.model.DayEntity> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the day entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkutip.lfrnevnapp.data.model.impl.DayEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of day entities
	* @param end the upper bound of the range of day entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of day entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.borkutip.lfrnevnapp.data.model.DayEntity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the day entities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of day entities.
	*
	* @return the number of day entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DayEntityPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DayEntityPersistence)PortletBeanLocatorUtil.locate(hu.borkutip.lfrnevnapp.data.service.ClpSerializer.getServletContextName(),
					DayEntityPersistence.class.getName());

			ReferenceRegistry.registerReference(DayEntityUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DayEntityPersistence persistence) {
	}

	private static DayEntityPersistence _persistence;
}