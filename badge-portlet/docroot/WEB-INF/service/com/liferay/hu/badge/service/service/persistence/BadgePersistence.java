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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the badge service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Borkuti Peter
 * @see BadgePersistenceImpl
 * @see BadgeUtil
 * @generated
 */
public interface BadgePersistence extends BasePersistence<Badge> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BadgeUtil} to access the badge persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the badges where badgeType = &#63;.
	*
	* @param badgeType the badge type
	* @return the matching badges
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.hu.badge.service.model.Badge> findBybadgeType(
		long badgeType)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.hu.badge.service.model.Badge> findBybadgeType(
		long badgeType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.hu.badge.service.model.Badge> findBybadgeType(
		long badgeType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first badge in the ordered set where badgeType = &#63;.
	*
	* @param badgeType the badge type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge
	* @throws com.liferay.hu.badge.service.NoSuchBadgeException if a matching badge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.hu.badge.service.model.Badge findBybadgeType_First(
		long badgeType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.hu.badge.service.NoSuchBadgeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first badge in the ordered set where badgeType = &#63;.
	*
	* @param badgeType the badge type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge, or <code>null</code> if a matching badge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.hu.badge.service.model.Badge fetchBybadgeType_First(
		long badgeType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last badge in the ordered set where badgeType = &#63;.
	*
	* @param badgeType the badge type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge
	* @throws com.liferay.hu.badge.service.NoSuchBadgeException if a matching badge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.hu.badge.service.model.Badge findBybadgeType_Last(
		long badgeType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.hu.badge.service.NoSuchBadgeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last badge in the ordered set where badgeType = &#63;.
	*
	* @param badgeType the badge type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge, or <code>null</code> if a matching badge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.hu.badge.service.model.Badge fetchBybadgeType_Last(
		long badgeType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.hu.badge.service.model.Badge[] findBybadgeType_PrevAndNext(
		long badgeId, long badgeType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.hu.badge.service.NoSuchBadgeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the badges where badgeType = &#63; from the database.
	*
	* @param badgeType the badge type
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybadgeType(long badgeType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of badges where badgeType = &#63;.
	*
	* @param badgeType the badge type
	* @return the number of matching badges
	* @throws SystemException if a system exception occurred
	*/
	public int countBybadgeType(long badgeType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the badge in the entity cache if it is enabled.
	*
	* @param badge the badge
	*/
	public void cacheResult(com.liferay.hu.badge.service.model.Badge badge);

	/**
	* Caches the badges in the entity cache if it is enabled.
	*
	* @param badges the badges
	*/
	public void cacheResult(
		java.util.List<com.liferay.hu.badge.service.model.Badge> badges);

	/**
	* Creates a new badge with the primary key. Does not add the badge to the database.
	*
	* @param badgeId the primary key for the new badge
	* @return the new badge
	*/
	public com.liferay.hu.badge.service.model.Badge create(long badgeId);

	/**
	* Removes the badge with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param badgeId the primary key of the badge
	* @return the badge that was removed
	* @throws com.liferay.hu.badge.service.NoSuchBadgeException if a badge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.hu.badge.service.model.Badge remove(long badgeId)
		throws com.liferay.hu.badge.service.NoSuchBadgeException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.hu.badge.service.model.Badge updateImpl(
		com.liferay.hu.badge.service.model.Badge badge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the badge with the primary key or throws a {@link com.liferay.hu.badge.service.NoSuchBadgeException} if it could not be found.
	*
	* @param badgeId the primary key of the badge
	* @return the badge
	* @throws com.liferay.hu.badge.service.NoSuchBadgeException if a badge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.hu.badge.service.model.Badge findByPrimaryKey(
		long badgeId)
		throws com.liferay.hu.badge.service.NoSuchBadgeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the badge with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param badgeId the primary key of the badge
	* @return the badge, or <code>null</code> if a badge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.hu.badge.service.model.Badge fetchByPrimaryKey(
		long badgeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the badges.
	*
	* @return the badges
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.hu.badge.service.model.Badge> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.hu.badge.service.model.Badge> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.hu.badge.service.model.Badge> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the badges from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of badges.
	*
	* @return the number of badges
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}