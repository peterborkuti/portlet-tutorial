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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import permission.servicebuider.model.Firstnames;

import java.util.List;

/**
 * The persistence utility for the firstnames service. This utility wraps {@link FirstnamesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author peter
 * @see FirstnamesPersistence
 * @see FirstnamesPersistenceImpl
 * @generated
 */
public class FirstnamesUtil {
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
	public static void clearCache(Firstnames firstnames) {
		getPersistence().clearCache(firstnames);
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
	public static List<Firstnames> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Firstnames> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Firstnames> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Firstnames update(Firstnames firstnames)
		throws SystemException {
		return getPersistence().update(firstnames);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Firstnames update(Firstnames firstnames,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(firstnames, serviceContext);
	}

	/**
	* Returns all the firstnameses where firstname = &#63;.
	*
	* @param firstname the firstname
	* @return the matching firstnameses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<permission.servicebuider.model.Firstnames> findByfirstname(
		java.lang.String firstname)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByfirstname(firstname);
	}

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
	public static java.util.List<permission.servicebuider.model.Firstnames> findByfirstname(
		java.lang.String firstname, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByfirstname(firstname, start, end);
	}

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
	public static java.util.List<permission.servicebuider.model.Firstnames> findByfirstname(
		java.lang.String firstname, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByfirstname(firstname, start, end, orderByComparator);
	}

	/**
	* Returns the first firstnames in the ordered set where firstname = &#63;.
	*
	* @param firstname the firstname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching firstnames
	* @throws permission.servicebuider.NoSuchFirstnamesException if a matching firstnames could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static permission.servicebuider.model.Firstnames findByfirstname_First(
		java.lang.String firstname,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			permission.servicebuider.NoSuchFirstnamesException {
		return getPersistence()
				   .findByfirstname_First(firstname, orderByComparator);
	}

	/**
	* Returns the first firstnames in the ordered set where firstname = &#63;.
	*
	* @param firstname the firstname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching firstnames, or <code>null</code> if a matching firstnames could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static permission.servicebuider.model.Firstnames fetchByfirstname_First(
		java.lang.String firstname,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfirstname_First(firstname, orderByComparator);
	}

	/**
	* Returns the last firstnames in the ordered set where firstname = &#63;.
	*
	* @param firstname the firstname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching firstnames
	* @throws permission.servicebuider.NoSuchFirstnamesException if a matching firstnames could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static permission.servicebuider.model.Firstnames findByfirstname_Last(
		java.lang.String firstname,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			permission.servicebuider.NoSuchFirstnamesException {
		return getPersistence()
				   .findByfirstname_Last(firstname, orderByComparator);
	}

	/**
	* Returns the last firstnames in the ordered set where firstname = &#63;.
	*
	* @param firstname the firstname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching firstnames, or <code>null</code> if a matching firstnames could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static permission.servicebuider.model.Firstnames fetchByfirstname_Last(
		java.lang.String firstname,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfirstname_Last(firstname, orderByComparator);
	}

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
	public static permission.servicebuider.model.Firstnames[] findByfirstname_PrevAndNext(
		long firstnameId, java.lang.String firstname,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			permission.servicebuider.NoSuchFirstnamesException {
		return getPersistence()
				   .findByfirstname_PrevAndNext(firstnameId, firstname,
			orderByComparator);
	}

	/**
	* Removes all the firstnameses where firstname = &#63; from the database.
	*
	* @param firstname the firstname
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByfirstname(java.lang.String firstname)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByfirstname(firstname);
	}

	/**
	* Returns the number of firstnameses where firstname = &#63;.
	*
	* @param firstname the firstname
	* @return the number of matching firstnameses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByfirstname(java.lang.String firstname)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByfirstname(firstname);
	}

	/**
	* Caches the firstnames in the entity cache if it is enabled.
	*
	* @param firstnames the firstnames
	*/
	public static void cacheResult(
		permission.servicebuider.model.Firstnames firstnames) {
		getPersistence().cacheResult(firstnames);
	}

	/**
	* Caches the firstnameses in the entity cache if it is enabled.
	*
	* @param firstnameses the firstnameses
	*/
	public static void cacheResult(
		java.util.List<permission.servicebuider.model.Firstnames> firstnameses) {
		getPersistence().cacheResult(firstnameses);
	}

	/**
	* Creates a new firstnames with the primary key. Does not add the firstnames to the database.
	*
	* @param firstnameId the primary key for the new firstnames
	* @return the new firstnames
	*/
	public static permission.servicebuider.model.Firstnames create(
		long firstnameId) {
		return getPersistence().create(firstnameId);
	}

	/**
	* Removes the firstnames with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param firstnameId the primary key of the firstnames
	* @return the firstnames that was removed
	* @throws permission.servicebuider.NoSuchFirstnamesException if a firstnames with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static permission.servicebuider.model.Firstnames remove(
		long firstnameId)
		throws com.liferay.portal.kernel.exception.SystemException,
			permission.servicebuider.NoSuchFirstnamesException {
		return getPersistence().remove(firstnameId);
	}

	public static permission.servicebuider.model.Firstnames updateImpl(
		permission.servicebuider.model.Firstnames firstnames)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(firstnames);
	}

	/**
	* Returns the firstnames with the primary key or throws a {@link permission.servicebuider.NoSuchFirstnamesException} if it could not be found.
	*
	* @param firstnameId the primary key of the firstnames
	* @return the firstnames
	* @throws permission.servicebuider.NoSuchFirstnamesException if a firstnames with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static permission.servicebuider.model.Firstnames findByPrimaryKey(
		long firstnameId)
		throws com.liferay.portal.kernel.exception.SystemException,
			permission.servicebuider.NoSuchFirstnamesException {
		return getPersistence().findByPrimaryKey(firstnameId);
	}

	/**
	* Returns the firstnames with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param firstnameId the primary key of the firstnames
	* @return the firstnames, or <code>null</code> if a firstnames with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static permission.servicebuider.model.Firstnames fetchByPrimaryKey(
		long firstnameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(firstnameId);
	}

	/**
	* Returns all the firstnameses.
	*
	* @return the firstnameses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<permission.servicebuider.model.Firstnames> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<permission.servicebuider.model.Firstnames> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<permission.servicebuider.model.Firstnames> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the firstnameses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of firstnameses.
	*
	* @return the number of firstnameses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FirstnamesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FirstnamesPersistence)PortletBeanLocatorUtil.locate(permission.servicebuider.service.ClpSerializer.getServletContextName(),
					FirstnamesPersistence.class.getName());

			ReferenceRegistry.registerReference(FirstnamesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FirstnamesPersistence persistence) {
	}

	private static FirstnamesPersistence _persistence;
}