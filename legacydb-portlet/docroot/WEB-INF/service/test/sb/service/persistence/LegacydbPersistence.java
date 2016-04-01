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

package test.sb.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import test.sb.model.Legacydb;

/**
 * The persistence interface for the legacydb service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author peter
 * @see LegacydbPersistenceImpl
 * @see LegacydbUtil
 * @generated
 */
public interface LegacydbPersistence extends BasePersistence<Legacydb> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegacydbUtil} to access the legacydb persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the legacydbs where name = &#63;.
	*
	* @param name the name
	* @return the matching legacydbs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<test.sb.model.Legacydb> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legacydbs where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link test.sb.model.impl.LegacydbModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of legacydbs
	* @param end the upper bound of the range of legacydbs (not inclusive)
	* @return the range of matching legacydbs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<test.sb.model.Legacydb> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legacydbs where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link test.sb.model.impl.LegacydbModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of legacydbs
	* @param end the upper bound of the range of legacydbs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching legacydbs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<test.sb.model.Legacydb> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first legacydb in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legacydb
	* @throws test.sb.NoSuchLegacydbException if a matching legacydb could not be found
	* @throws SystemException if a system exception occurred
	*/
	public test.sb.model.Legacydb findByName_First(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			test.sb.NoSuchLegacydbException;

	/**
	* Returns the first legacydb in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legacydb, or <code>null</code> if a matching legacydb could not be found
	* @throws SystemException if a system exception occurred
	*/
	public test.sb.model.Legacydb fetchByName_First(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last legacydb in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legacydb
	* @throws test.sb.NoSuchLegacydbException if a matching legacydb could not be found
	* @throws SystemException if a system exception occurred
	*/
	public test.sb.model.Legacydb findByName_Last(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			test.sb.NoSuchLegacydbException;

	/**
	* Returns the last legacydb in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legacydb, or <code>null</code> if a matching legacydb could not be found
	* @throws SystemException if a system exception occurred
	*/
	public test.sb.model.Legacydb fetchByName_Last(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legacydbs before and after the current legacydb in the ordered set where name = &#63;.
	*
	* @param legacydbid the primary key of the current legacydb
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next legacydb
	* @throws test.sb.NoSuchLegacydbException if a legacydb with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public test.sb.model.Legacydb[] findByName_PrevAndNext(long legacydbid,
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			test.sb.NoSuchLegacydbException;

	/**
	* Removes all the legacydbs where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legacydbs where name = &#63;.
	*
	* @param name the name
	* @return the number of matching legacydbs
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the legacydb in the entity cache if it is enabled.
	*
	* @param legacydb the legacydb
	*/
	public void cacheResult(test.sb.model.Legacydb legacydb);

	/**
	* Caches the legacydbs in the entity cache if it is enabled.
	*
	* @param legacydbs the legacydbs
	*/
	public void cacheResult(java.util.List<test.sb.model.Legacydb> legacydbs);

	/**
	* Creates a new legacydb with the primary key. Does not add the legacydb to the database.
	*
	* @param legacydbid the primary key for the new legacydb
	* @return the new legacydb
	*/
	public test.sb.model.Legacydb create(long legacydbid);

	/**
	* Removes the legacydb with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param legacydbid the primary key of the legacydb
	* @return the legacydb that was removed
	* @throws test.sb.NoSuchLegacydbException if a legacydb with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public test.sb.model.Legacydb remove(long legacydbid)
		throws com.liferay.portal.kernel.exception.SystemException,
			test.sb.NoSuchLegacydbException;

	public test.sb.model.Legacydb updateImpl(test.sb.model.Legacydb legacydb)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the legacydb with the primary key or throws a {@link test.sb.NoSuchLegacydbException} if it could not be found.
	*
	* @param legacydbid the primary key of the legacydb
	* @return the legacydb
	* @throws test.sb.NoSuchLegacydbException if a legacydb with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public test.sb.model.Legacydb findByPrimaryKey(long legacydbid)
		throws com.liferay.portal.kernel.exception.SystemException,
			test.sb.NoSuchLegacydbException;

	/**
	* Returns the legacydb with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param legacydbid the primary key of the legacydb
	* @return the legacydb, or <code>null</code> if a legacydb with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public test.sb.model.Legacydb fetchByPrimaryKey(long legacydbid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the legacydbs.
	*
	* @return the legacydbs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<test.sb.model.Legacydb> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the legacydbs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link test.sb.model.impl.LegacydbModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacydbs
	* @param end the upper bound of the range of legacydbs (not inclusive)
	* @return the range of legacydbs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<test.sb.model.Legacydb> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the legacydbs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link test.sb.model.impl.LegacydbModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of legacydbs
	* @param end the upper bound of the range of legacydbs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of legacydbs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<test.sb.model.Legacydb> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the legacydbs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of legacydbs.
	*
	* @return the number of legacydbs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}