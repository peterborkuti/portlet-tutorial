/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.hu.badge.service.service.persistence;

import com.liferay.hu.badge.service.model.Badge;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the badge service. This utility wraps {@link BadgePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Borkuti Peter
 * @see BadgePersistence
 * @see BadgePersistenceImpl
 * @generated
 */
public class BadgeUtil {
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
	public static void clearCache(Badge badge) {
		getPersistence().clearCache(badge);
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
	public static List<Badge> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Badge> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Badge> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Badge update(Badge badge) throws SystemException {
		return getPersistence().update(badge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Badge update(Badge badge, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(badge, serviceContext);
	}

	/**
	* Returns all the badges where badgeType = &#63;.
	*
	* @param badgeType the badge type
	* @return the matching badges
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.hu.badge.service.model.Badge> findBybadgeType(
		long badgeType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybadgeType(badgeType);
	}

	/**
	* Returns a range of all the badges where badgeType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.hu.badge.service.model.impl.BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param badgeType the badge type
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @return the range of matching badges
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.hu.badge.service.model.Badge> findBybadgeType(
		long badgeType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBybadgeType(badgeType, start, end);
	}

	/**
	* Returns an ordered range of all the badges where badgeType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.hu.badge.service.model.impl.BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param badgeType the badge type
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching badges
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.hu.badge.service.model.Badge> findBybadgeType(
		long badgeType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybadgeType(badgeType, start, end, orderByComparator);
	}

	/**
	* Returns the first badge in the ordered set where badgeType = &#63;.
	*
	* @param badgeType the badge type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge
	* @throws com.liferay.hu.badge.service.NoSuchBadgeException if a matching badge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.hu.badge.service.model.Badge findBybadgeType_First(
		long badgeType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.hu.badge.service.NoSuchBadgeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybadgeType_First(badgeType, orderByComparator);
	}

	/**
	* Returns the first badge in the ordered set where badgeType = &#63;.
	*
	* @param badgeType the badge type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge, or <code>null</code> if a matching badge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.hu.badge.service.model.Badge fetchBybadgeType_First(
		long badgeType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybadgeType_First(badgeType, orderByComparator);
	}

	/**
	* Returns the last badge in the ordered set where badgeType = &#63;.
	*
	* @param badgeType the badge type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge
	* @throws com.liferay.hu.badge.service.NoSuchBadgeException if a matching badge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.hu.badge.service.model.Badge findBybadgeType_Last(
		long badgeType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.hu.badge.service.NoSuchBadgeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybadgeType_Last(badgeType, orderByComparator);
	}

	/**
	* Returns the last badge in the ordered set where badgeType = &#63;.
	*
	* @param badgeType the badge type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge, or <code>null</code> if a matching badge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.hu.badge.service.model.Badge fetchBybadgeType_Last(
		long badgeType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBybadgeType_Last(badgeType, orderByComparator);
	}

	/**
	* Returns the badges before and after the current badge in the ordered set where badgeType = &#63;.
	*
	* @param badgeId the primary key of the current badge
	* @param badgeType the badge type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next badge
	* @throws com.liferay.hu.badge.service.NoSuchBadgeException if a badge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.hu.badge.service.model.Badge[] findBybadgeType_PrevAndNext(
		long badgeId, long badgeType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.hu.badge.service.NoSuchBadgeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBybadgeType_PrevAndNext(badgeId, badgeType,
			orderByComparator);
	}

	/**
	* Removes all the badges where badgeType = &#63; from the database.
	*
	* @param badgeType the badge type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBybadgeType(long badgeType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBybadgeType(badgeType);
	}

	/**
	* Returns the number of badges where badgeType = &#63;.
	*
	* @param badgeType the badge type
	* @return the number of matching badges
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybadgeType(long badgeType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybadgeType(badgeType);
	}

	/**
	* Caches the badge in the entity cache if it is enabled.
	*
	* @param badge the badge
	*/
	public static void cacheResult(
		com.liferay.hu.badge.service.model.Badge badge) {
		getPersistence().cacheResult(badge);
	}

	/**
	* Caches the badges in the entity cache if it is enabled.
	*
	* @param badges the badges
	*/
	public static void cacheResult(
		java.util.List<com.liferay.hu.badge.service.model.Badge> badges) {
		getPersistence().cacheResult(badges);
	}

	/**
	* Creates a new badge with the primary key. Does not add the badge to the database.
	*
	* @param badgeId the primary key for the new badge
	* @return the new badge
	*/
	public static com.liferay.hu.badge.service.model.Badge create(long badgeId) {
		return getPersistence().create(badgeId);
	}

	/**
	* Removes the badge with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param badgeId the primary key of the badge
	* @return the badge that was removed
	* @throws com.liferay.hu.badge.service.NoSuchBadgeException if a badge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.hu.badge.service.model.Badge remove(long badgeId)
		throws com.liferay.hu.badge.service.NoSuchBadgeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(badgeId);
	}

	public static com.liferay.hu.badge.service.model.Badge updateImpl(
		com.liferay.hu.badge.service.model.Badge badge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(badge);
	}

	/**
	* Returns the badge with the primary key or throws a {@link com.liferay.hu.badge.service.NoSuchBadgeException} if it could not be found.
	*
	* @param badgeId the primary key of the badge
	* @return the badge
	* @throws com.liferay.hu.badge.service.NoSuchBadgeException if a badge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.hu.badge.service.model.Badge findByPrimaryKey(
		long badgeId)
		throws com.liferay.hu.badge.service.NoSuchBadgeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(badgeId);
	}

	/**
	* Returns the badge with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param badgeId the primary key of the badge
	* @return the badge, or <code>null</code> if a badge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.hu.badge.service.model.Badge fetchByPrimaryKey(
		long badgeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(badgeId);
	}

	/**
	* Returns all the badges.
	*
	* @return the badges
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.hu.badge.service.model.Badge> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the badges.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.hu.badge.service.model.impl.BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @return the range of badges
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.hu.badge.service.model.Badge> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the badges.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.hu.badge.service.model.impl.BadgeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of badges
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.hu.badge.service.model.Badge> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the badges from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of badges.
	*
	* @return the number of badges
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BadgePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BadgePersistence)PortletBeanLocatorUtil.locate(com.liferay.hu.badge.service.service.ClpSerializer.getServletContextName(),
					BadgePersistence.class.getName());

			ReferenceRegistry.registerReference(BadgeUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BadgePersistence persistence) {
	}

	private static BadgePersistence _persistence;
}