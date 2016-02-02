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

package permission.servicebuider.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import permission.servicebuider.model.Firstnames;

/**
 * The persistence interface for the firstnames service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author peter
 * @see FirstnamesPersistenceImpl
 * @see FirstnamesUtil
 * @generated
 */
public interface FirstnamesPersistence extends BasePersistence<Firstnames> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FirstnamesUtil} to access the firstnames persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the firstnameses where firstname = &#63;.
	*
	* @param firstname the firstname
	* @return the matching firstnameses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<permission.servicebuider.model.Firstnames> findByfirstname(
		java.lang.String firstname)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the firstnameses where firstname = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link permission.servicebuider.model.impl.FirstnamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param firstname the firstname
	* @param start the lower bound of the range of firstnameses
	* @param end the upper bound of the range of firstnameses (not inclusive)
	* @return the range of matching firstnameses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<permission.servicebuider.model.Firstnames> findByfirstname(
		java.lang.String firstname, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the firstnameses where firstname = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link permission.servicebuider.model.impl.FirstnamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param firstname the firstname
	* @param start the lower bound of the range of firstnameses
	* @param end the upper bound of the range of firstnameses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching firstnameses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<permission.servicebuider.model.Firstnames> findByfirstname(
		java.lang.String firstname, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first firstnames in the ordered set where firstname = &#63;.
	*
	* @param firstname the firstname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching firstnames
	* @throws permission.servicebuider.NoSuchFirstnamesException if a matching firstnames could not be found
	* @throws SystemException if a system exception occurred
	*/
	public permission.servicebuider.model.Firstnames findByfirstname_First(
		java.lang.String firstname,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			permission.servicebuider.NoSuchFirstnamesException;

	/**
	* Returns the first firstnames in the ordered set where firstname = &#63;.
	*
	* @param firstname the firstname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching firstnames, or <code>null</code> if a matching firstnames could not be found
	* @throws SystemException if a system exception occurred
	*/
	public permission.servicebuider.model.Firstnames fetchByfirstname_First(
		java.lang.String firstname,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last firstnames in the ordered set where firstname = &#63;.
	*
	* @param firstname the firstname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching firstnames
	* @throws permission.servicebuider.NoSuchFirstnamesException if a matching firstnames could not be found
	* @throws SystemException if a system exception occurred
	*/
	public permission.servicebuider.model.Firstnames findByfirstname_Last(
		java.lang.String firstname,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			permission.servicebuider.NoSuchFirstnamesException;

	/**
	* Returns the last firstnames in the ordered set where firstname = &#63;.
	*
	* @param firstname the firstname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching firstnames, or <code>null</code> if a matching firstnames could not be found
	* @throws SystemException if a system exception occurred
	*/
	public permission.servicebuider.model.Firstnames fetchByfirstname_Last(
		java.lang.String firstname,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the firstnameses before and after the current firstnames in the ordered set where firstname = &#63;.
	*
	* @param firstnameId the primary key of the current firstnames
	* @param firstname the firstname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next firstnames
	* @throws permission.servicebuider.NoSuchFirstnamesException if a firstnames with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public permission.servicebuider.model.Firstnames[] findByfirstname_PrevAndNext(
		long firstnameId, java.lang.String firstname,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			permission.servicebuider.NoSuchFirstnamesException;

	/**
	* Removes all the firstnameses where firstname = &#63; from the database.
	*
	* @param firstname the firstname
	* @throws SystemException if a system exception occurred
	*/
	public void removeByfirstname(java.lang.String firstname)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of firstnameses where firstname = &#63;.
	*
	* @param firstname the firstname
	* @return the number of matching firstnameses
	* @throws SystemException if a system exception occurred
	*/
	public int countByfirstname(java.lang.String firstname)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the firstnames in the entity cache if it is enabled.
	*
	* @param firstnames the firstnames
	*/
	public void cacheResult(
		permission.servicebuider.model.Firstnames firstnames);

	/**
	* Caches the firstnameses in the entity cache if it is enabled.
	*
	* @param firstnameses the firstnameses
	*/
	public void cacheResult(
		java.util.List<permission.servicebuider.model.Firstnames> firstnameses);

	/**
	* Creates a new firstnames with the primary key. Does not add the firstnames to the database.
	*
	* @param firstnameId the primary key for the new firstnames
	* @return the new firstnames
	*/
	public permission.servicebuider.model.Firstnames create(long firstnameId);

	/**
	* Removes the firstnames with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param firstnameId the primary key of the firstnames
	* @return the firstnames that was removed
	* @throws permission.servicebuider.NoSuchFirstnamesException if a firstnames with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public permission.servicebuider.model.Firstnames remove(long firstnameId)
		throws com.liferay.portal.kernel.exception.SystemException,
			permission.servicebuider.NoSuchFirstnamesException;

	public permission.servicebuider.model.Firstnames updateImpl(
		permission.servicebuider.model.Firstnames firstnames)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the firstnames with the primary key or throws a {@link permission.servicebuider.NoSuchFirstnamesException} if it could not be found.
	*
	* @param firstnameId the primary key of the firstnames
	* @return the firstnames
	* @throws permission.servicebuider.NoSuchFirstnamesException if a firstnames with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public permission.servicebuider.model.Firstnames findByPrimaryKey(
		long firstnameId)
		throws com.liferay.portal.kernel.exception.SystemException,
			permission.servicebuider.NoSuchFirstnamesException;

	/**
	* Returns the firstnames with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param firstnameId the primary key of the firstnames
	* @return the firstnames, or <code>null</code> if a firstnames with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public permission.servicebuider.model.Firstnames fetchByPrimaryKey(
		long firstnameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the firstnameses.
	*
	* @return the firstnameses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<permission.servicebuider.model.Firstnames> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<permission.servicebuider.model.Firstnames> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the firstnameses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link permission.servicebuider.model.impl.FirstnamesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of firstnameses
	* @param end the upper bound of the range of firstnameses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of firstnameses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<permission.servicebuider.model.Firstnames> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the firstnameses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of firstnameses.
	*
	* @return the number of firstnameses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}