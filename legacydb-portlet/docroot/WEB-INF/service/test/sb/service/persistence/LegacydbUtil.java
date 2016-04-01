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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import test.sb.model.Legacydb;

import java.util.List;

/**
 * The persistence utility for the legacydb service. This utility wraps {@link LegacydbPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author peter
 * @see LegacydbPersistence
 * @see LegacydbPersistenceImpl
 * @generated
 */
public class LegacydbUtil {
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
	public static void clearCache(Legacydb legacydb) {
		getPersistence().clearCache(legacydb);
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
	public static List<Legacydb> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Legacydb> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Legacydb> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Legacydb update(Legacydb legacydb) throws SystemException {
		return getPersistence().update(legacydb);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Legacydb update(Legacydb legacydb,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(legacydb, serviceContext);
	}

	/**
	* Returns all the legacydbs where name = &#63;.
	*
	* @param name the name
	* @return the matching legacydbs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<test.sb.model.Legacydb> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name);
	}

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
	public static java.util.List<test.sb.model.Legacydb> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end);
	}

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
	public static java.util.List<test.sb.model.Legacydb> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	* Returns the first legacydb in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legacydb
	* @throws test.sb.NoSuchLegacydbException if a matching legacydb could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static test.sb.model.Legacydb findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			test.sb.NoSuchLegacydbException {
		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	* Returns the first legacydb in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching legacydb, or <code>null</code> if a matching legacydb could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static test.sb.model.Legacydb fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	* Returns the last legacydb in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legacydb
	* @throws test.sb.NoSuchLegacydbException if a matching legacydb could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static test.sb.model.Legacydb findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			test.sb.NoSuchLegacydbException {
		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	* Returns the last legacydb in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching legacydb, or <code>null</code> if a matching legacydb could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static test.sb.model.Legacydb fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

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
	public static test.sb.model.Legacydb[] findByName_PrevAndNext(
		long legacydbid, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			test.sb.NoSuchLegacydbException {
		return getPersistence()
				   .findByName_PrevAndNext(legacydbid, name, orderByComparator);
	}

	/**
	* Removes all the legacydbs where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByName(name);
	}

	/**
	* Returns the number of legacydbs where name = &#63;.
	*
	* @param name the name
	* @return the number of matching legacydbs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Caches the legacydb in the entity cache if it is enabled.
	*
	* @param legacydb the legacydb
	*/
	public static void cacheResult(test.sb.model.Legacydb legacydb) {
		getPersistence().cacheResult(legacydb);
	}

	/**
	* Caches the legacydbs in the entity cache if it is enabled.
	*
	* @param legacydbs the legacydbs
	*/
	public static void cacheResult(
		java.util.List<test.sb.model.Legacydb> legacydbs) {
		getPersistence().cacheResult(legacydbs);
	}

	/**
	* Creates a new legacydb with the primary key. Does not add the legacydb to the database.
	*
	* @param legacydbid the primary key for the new legacydb
	* @return the new legacydb
	*/
	public static test.sb.model.Legacydb create(long legacydbid) {
		return getPersistence().create(legacydbid);
	}

	/**
	* Removes the legacydb with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param legacydbid the primary key of the legacydb
	* @return the legacydb that was removed
	* @throws test.sb.NoSuchLegacydbException if a legacydb with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static test.sb.model.Legacydb remove(long legacydbid)
		throws com.liferay.portal.kernel.exception.SystemException,
			test.sb.NoSuchLegacydbException {
		return getPersistence().remove(legacydbid);
	}

	public static test.sb.model.Legacydb updateImpl(
		test.sb.model.Legacydb legacydb)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(legacydb);
	}

	/**
	* Returns the legacydb with the primary key or throws a {@link test.sb.NoSuchLegacydbException} if it could not be found.
	*
	* @param legacydbid the primary key of the legacydb
	* @return the legacydb
	* @throws test.sb.NoSuchLegacydbException if a legacydb with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static test.sb.model.Legacydb findByPrimaryKey(long legacydbid)
		throws com.liferay.portal.kernel.exception.SystemException,
			test.sb.NoSuchLegacydbException {
		return getPersistence().findByPrimaryKey(legacydbid);
	}

	/**
	* Returns the legacydb with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param legacydbid the primary key of the legacydb
	* @return the legacydb, or <code>null</code> if a legacydb with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static test.sb.model.Legacydb fetchByPrimaryKey(long legacydbid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(legacydbid);
	}

	/**
	* Returns all the legacydbs.
	*
	* @return the legacydbs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<test.sb.model.Legacydb> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<test.sb.model.Legacydb> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<test.sb.model.Legacydb> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the legacydbs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of legacydbs.
	*
	* @return the number of legacydbs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LegacydbPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LegacydbPersistence)PortletBeanLocatorUtil.locate(test.sb.service.ClpSerializer.getServletContextName(),
					LegacydbPersistence.class.getName());

			ReferenceRegistry.registerReference(LegacydbUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LegacydbPersistence persistence) {
	}

	private static LegacydbPersistence _persistence;
}