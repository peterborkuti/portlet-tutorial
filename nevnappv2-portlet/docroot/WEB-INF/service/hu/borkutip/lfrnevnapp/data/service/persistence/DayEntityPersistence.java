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

import com.liferay.portal.service.persistence.BasePersistence;

import hu.borkutip.lfrnevnapp.data.model.DayEntity;

/**
 * The persistence interface for the day entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Péter Borkuti
 * @see DayEntityPersistenceImpl
 * @see DayEntityUtil
 * @generated
 */
public interface DayEntityPersistence extends BasePersistence<DayEntity> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DayEntityUtil} to access the day entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the day entities where month = &#63; and day = &#63;.
	*
	* @param month the month
	* @param day the day
	* @return the matching day entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkutip.lfrnevnapp.data.model.DayEntity> findBymonthAndDay(
		int month, int day)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.borkutip.lfrnevnapp.data.model.DayEntity> findBymonthAndDay(
		int month, int day, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.borkutip.lfrnevnapp.data.model.DayEntity> findBymonthAndDay(
		int month, int day, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.borkutip.lfrnevnapp.data.model.DayEntity findBymonthAndDay_First(
		int month, int day,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException;

	/**
	* Returns the first day entity in the ordered set where month = &#63; and day = &#63;.
	*
	* @param month the month
	* @param day the day
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching day entity, or <code>null</code> if a matching day entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkutip.lfrnevnapp.data.model.DayEntity fetchBymonthAndDay_First(
		int month, int day,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.borkutip.lfrnevnapp.data.model.DayEntity findBymonthAndDay_Last(
		int month, int day,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException;

	/**
	* Returns the last day entity in the ordered set where month = &#63; and day = &#63;.
	*
	* @param month the month
	* @param day the day
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching day entity, or <code>null</code> if a matching day entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkutip.lfrnevnapp.data.model.DayEntity fetchBymonthAndDay_Last(
		int month, int day,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.borkutip.lfrnevnapp.data.model.DayEntity[] findBymonthAndDay_PrevAndNext(
		long dayId, int month, int day,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException;

	/**
	* Removes all the day entities where month = &#63; and day = &#63; from the database.
	*
	* @param month the month
	* @param day the day
	* @throws SystemException if a system exception occurred
	*/
	public void removeBymonthAndDay(int month, int day)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of day entities where month = &#63; and day = &#63;.
	*
	* @param month the month
	* @param day the day
	* @return the number of matching day entities
	* @throws SystemException if a system exception occurred
	*/
	public int countBymonthAndDay(int month, int day)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the day entities where nameId = &#63;.
	*
	* @param nameId the name ID
	* @return the matching day entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkutip.lfrnevnapp.data.model.DayEntity> findByNameId(
		long nameId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.borkutip.lfrnevnapp.data.model.DayEntity> findByNameId(
		long nameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.borkutip.lfrnevnapp.data.model.DayEntity> findByNameId(
		long nameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first day entity in the ordered set where nameId = &#63;.
	*
	* @param nameId the name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching day entity
	* @throws hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException if a matching day entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkutip.lfrnevnapp.data.model.DayEntity findByNameId_First(
		long nameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException;

	/**
	* Returns the first day entity in the ordered set where nameId = &#63;.
	*
	* @param nameId the name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching day entity, or <code>null</code> if a matching day entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkutip.lfrnevnapp.data.model.DayEntity fetchByNameId_First(
		long nameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last day entity in the ordered set where nameId = &#63;.
	*
	* @param nameId the name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching day entity
	* @throws hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException if a matching day entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkutip.lfrnevnapp.data.model.DayEntity findByNameId_Last(
		long nameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException;

	/**
	* Returns the last day entity in the ordered set where nameId = &#63;.
	*
	* @param nameId the name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching day entity, or <code>null</code> if a matching day entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkutip.lfrnevnapp.data.model.DayEntity fetchByNameId_Last(
		long nameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.borkutip.lfrnevnapp.data.model.DayEntity[] findByNameId_PrevAndNext(
		long dayId, long nameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException;

	/**
	* Removes all the day entities where nameId = &#63; from the database.
	*
	* @param nameId the name ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNameId(long nameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of day entities where nameId = &#63;.
	*
	* @param nameId the name ID
	* @return the number of matching day entities
	* @throws SystemException if a system exception occurred
	*/
	public int countByNameId(long nameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the day entity in the entity cache if it is enabled.
	*
	* @param dayEntity the day entity
	*/
	public void cacheResult(
		hu.borkutip.lfrnevnapp.data.model.DayEntity dayEntity);

	/**
	* Caches the day entities in the entity cache if it is enabled.
	*
	* @param dayEntities the day entities
	*/
	public void cacheResult(
		java.util.List<hu.borkutip.lfrnevnapp.data.model.DayEntity> dayEntities);

	/**
	* Creates a new day entity with the primary key. Does not add the day entity to the database.
	*
	* @param dayId the primary key for the new day entity
	* @return the new day entity
	*/
	public hu.borkutip.lfrnevnapp.data.model.DayEntity create(long dayId);

	/**
	* Removes the day entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dayId the primary key of the day entity
	* @return the day entity that was removed
	* @throws hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException if a day entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkutip.lfrnevnapp.data.model.DayEntity remove(long dayId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException;

	public hu.borkutip.lfrnevnapp.data.model.DayEntity updateImpl(
		hu.borkutip.lfrnevnapp.data.model.DayEntity dayEntity)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the day entity with the primary key or throws a {@link hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException} if it could not be found.
	*
	* @param dayId the primary key of the day entity
	* @return the day entity
	* @throws hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException if a day entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkutip.lfrnevnapp.data.model.DayEntity findByPrimaryKey(
		long dayId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException;

	/**
	* Returns the day entity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dayId the primary key of the day entity
	* @return the day entity, or <code>null</code> if a day entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkutip.lfrnevnapp.data.model.DayEntity fetchByPrimaryKey(
		long dayId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the day entities.
	*
	* @return the day entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkutip.lfrnevnapp.data.model.DayEntity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.borkutip.lfrnevnapp.data.model.DayEntity> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.borkutip.lfrnevnapp.data.model.DayEntity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the day entities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of day entities.
	*
	* @return the number of day entities
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}