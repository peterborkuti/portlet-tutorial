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

import com.liferay.hu.badge.service.NoSuchBadgeException;
import com.liferay.hu.badge.service.model.Badge;
import com.liferay.hu.badge.service.model.impl.BadgeImpl;
import com.liferay.hu.badge.service.model.impl.BadgeModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the badge service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Borkuti Peter
 * @see BadgePersistence
 * @see BadgeUtil
 * @generated
 */
public class BadgePersistenceImpl extends BasePersistenceImpl<Badge>
	implements BadgePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BadgeUtil} to access the badge persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BadgeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BADGETYPE =
		new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybadgeType",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BADGETYPE =
		new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybadgeType",
			new String[] { Long.class.getName() },
			BadgeModelImpl.BADGETYPE_COLUMN_BITMASK |
			BadgeModelImpl.ASSIGNDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BADGETYPE = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybadgeType",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the badges where badgeType = &#63;.
	 *
	 * @param badgeType the badge type
	 * @return the matching badges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Badge> findBybadgeType(long badgeType)
		throws SystemException {
		return findBybadgeType(badgeType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Badge> findBybadgeType(long badgeType, int start, int end)
		throws SystemException {
		return findBybadgeType(badgeType, start, end, null);
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
	@Override
	public List<Badge> findBybadgeType(long badgeType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BADGETYPE;
			finderArgs = new Object[] { badgeType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BADGETYPE;
			finderArgs = new Object[] { badgeType, start, end, orderByComparator };
		}

		List<Badge> list = (List<Badge>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Badge badge : list) {
				if ((badgeType != badge.getBadgeType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_BADGE_WHERE);

			query.append(_FINDER_COLUMN_BADGETYPE_BADGETYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BadgeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(badgeType);

				if (!pagination) {
					list = (List<Badge>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Badge>(list);
				}
				else {
					list = (List<Badge>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Badge findBybadgeType_First(long badgeType,
		OrderByComparator orderByComparator)
		throws NoSuchBadgeException, SystemException {
		Badge badge = fetchBybadgeType_First(badgeType, orderByComparator);

		if (badge != null) {
			return badge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("badgeType=");
		msg.append(badgeType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBadgeException(msg.toString());
	}

	/**
	 * Returns the first badge in the ordered set where badgeType = &#63;.
	 *
	 * @param badgeType the badge type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching badge, or <code>null</code> if a matching badge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Badge fetchBybadgeType_First(long badgeType,
		OrderByComparator orderByComparator) throws SystemException {
		List<Badge> list = findBybadgeType(badgeType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Badge findBybadgeType_Last(long badgeType,
		OrderByComparator orderByComparator)
		throws NoSuchBadgeException, SystemException {
		Badge badge = fetchBybadgeType_Last(badgeType, orderByComparator);

		if (badge != null) {
			return badge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("badgeType=");
		msg.append(badgeType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBadgeException(msg.toString());
	}

	/**
	 * Returns the last badge in the ordered set where badgeType = &#63;.
	 *
	 * @param badgeType the badge type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching badge, or <code>null</code> if a matching badge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Badge fetchBybadgeType_Last(long badgeType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBybadgeType(badgeType);

		if (count == 0) {
			return null;
		}

		List<Badge> list = findBybadgeType(badgeType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Badge[] findBybadgeType_PrevAndNext(long badgeId, long badgeType,
		OrderByComparator orderByComparator)
		throws NoSuchBadgeException, SystemException {
		Badge badge = findByPrimaryKey(badgeId);

		Session session = null;

		try {
			session = openSession();

			Badge[] array = new BadgeImpl[3];

			array[0] = getBybadgeType_PrevAndNext(session, badge, badgeType,
					orderByComparator, true);

			array[1] = badge;

			array[2] = getBybadgeType_PrevAndNext(session, badge, badgeType,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Badge getBybadgeType_PrevAndNext(Session session, Badge badge,
		long badgeType, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BADGE_WHERE);

		query.append(_FINDER_COLUMN_BADGETYPE_BADGETYPE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(BadgeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(badgeType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(badge);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Badge> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the badges where badgeType = &#63; from the database.
	 *
	 * @param badgeType the badge type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybadgeType(long badgeType) throws SystemException {
		for (Badge badge : findBybadgeType(badgeType, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(badge);
		}
	}

	/**
	 * Returns the number of badges where badgeType = &#63;.
	 *
	 * @param badgeType the badge type
	 * @return the number of matching badges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybadgeType(long badgeType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BADGETYPE;

		Object[] finderArgs = new Object[] { badgeType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BADGE_WHERE);

			query.append(_FINDER_COLUMN_BADGETYPE_BADGETYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(badgeType);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BADGETYPE_BADGETYPE_2 = "badge.badgeType = ?";

	public BadgePersistenceImpl() {
		setModelClass(Badge.class);
	}

	/**
	 * Caches the badge in the entity cache if it is enabled.
	 *
	 * @param badge the badge
	 */
	@Override
	public void cacheResult(Badge badge) {
		EntityCacheUtil.putResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeImpl.class, badge.getPrimaryKey(), badge);

		badge.resetOriginalValues();
	}

	/**
	 * Caches the badges in the entity cache if it is enabled.
	 *
	 * @param badges the badges
	 */
	@Override
	public void cacheResult(List<Badge> badges) {
		for (Badge badge : badges) {
			if (EntityCacheUtil.getResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
						BadgeImpl.class, badge.getPrimaryKey()) == null) {
				cacheResult(badge);
			}
			else {
				badge.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all badges.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BadgeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BadgeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the badge.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Badge badge) {
		EntityCacheUtil.removeResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeImpl.class, badge.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Badge> badges) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Badge badge : badges) {
			EntityCacheUtil.removeResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
				BadgeImpl.class, badge.getPrimaryKey());
		}
	}

	/**
	 * Creates a new badge with the primary key. Does not add the badge to the database.
	 *
	 * @param badgeId the primary key for the new badge
	 * @return the new badge
	 */
	@Override
	public Badge create(long badgeId) {
		Badge badge = new BadgeImpl();

		badge.setNew(true);
		badge.setPrimaryKey(badgeId);

		return badge;
	}

	/**
	 * Removes the badge with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param badgeId the primary key of the badge
	 * @return the badge that was removed
	 * @throws com.liferay.hu.badge.service.NoSuchBadgeException if a badge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Badge remove(long badgeId)
		throws NoSuchBadgeException, SystemException {
		return remove((Serializable)badgeId);
	}

	/**
	 * Removes the badge with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the badge
	 * @return the badge that was removed
	 * @throws com.liferay.hu.badge.service.NoSuchBadgeException if a badge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Badge remove(Serializable primaryKey)
		throws NoSuchBadgeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Badge badge = (Badge)session.get(BadgeImpl.class, primaryKey);

			if (badge == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBadgeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(badge);
		}
		catch (NoSuchBadgeException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Badge removeImpl(Badge badge) throws SystemException {
		badge = toUnwrappedModel(badge);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(badge)) {
				badge = (Badge)session.get(BadgeImpl.class,
						badge.getPrimaryKeyObj());
			}

			if (badge != null) {
				session.delete(badge);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (badge != null) {
			clearCache(badge);
		}

		return badge;
	}

	@Override
	public Badge updateImpl(com.liferay.hu.badge.service.model.Badge badge)
		throws SystemException {
		badge = toUnwrappedModel(badge);

		boolean isNew = badge.isNew();

		BadgeModelImpl badgeModelImpl = (BadgeModelImpl)badge;

		Session session = null;

		try {
			session = openSession();

			if (badge.isNew()) {
				session.save(badge);

				badge.setNew(false);
			}
			else {
				session.merge(badge);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BadgeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((badgeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BADGETYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						badgeModelImpl.getOriginalBadgeType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BADGETYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BADGETYPE,
					args);

				args = new Object[] { badgeModelImpl.getBadgeType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BADGETYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BADGETYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeImpl.class, badge.getPrimaryKey(), badge);

		return badge;
	}

	protected Badge toUnwrappedModel(Badge badge) {
		if (badge instanceof BadgeImpl) {
			return badge;
		}

		BadgeImpl badgeImpl = new BadgeImpl();

		badgeImpl.setNew(badge.isNew());
		badgeImpl.setPrimaryKey(badge.getPrimaryKey());

		badgeImpl.setBadgeId(badge.getBadgeId());
		badgeImpl.setGroupId(badge.getGroupId());
		badgeImpl.setCompanyId(badge.getCompanyId());
		badgeImpl.setUserId(badge.getUserId());
		badgeImpl.setUserName(badge.getUserName());
		badgeImpl.setCreateDate(badge.getCreateDate());
		badgeImpl.setModifiedDate(badge.getModifiedDate());
		badgeImpl.setBadgeType(badge.getBadgeType());
		badgeImpl.setAssignDate(badge.getAssignDate());
		badgeImpl.setToUser(badge.getToUser());
		badgeImpl.setToUserFullName(badge.getToUserFullName());
		badgeImpl.setFromUser(badge.getFromUser());
		badgeImpl.setFromUserFullName(badge.getFromUserFullName());
		badgeImpl.setDescription(badge.getDescription());

		return badgeImpl;
	}

	/**
	 * Returns the badge with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the badge
	 * @return the badge
	 * @throws com.liferay.hu.badge.service.NoSuchBadgeException if a badge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Badge findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBadgeException, SystemException {
		Badge badge = fetchByPrimaryKey(primaryKey);

		if (badge == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBadgeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return badge;
	}

	/**
	 * Returns the badge with the primary key or throws a {@link com.liferay.hu.badge.service.NoSuchBadgeException} if it could not be found.
	 *
	 * @param badgeId the primary key of the badge
	 * @return the badge
	 * @throws com.liferay.hu.badge.service.NoSuchBadgeException if a badge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Badge findByPrimaryKey(long badgeId)
		throws NoSuchBadgeException, SystemException {
		return findByPrimaryKey((Serializable)badgeId);
	}

	/**
	 * Returns the badge with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the badge
	 * @return the badge, or <code>null</code> if a badge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Badge fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Badge badge = (Badge)EntityCacheUtil.getResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
				BadgeImpl.class, primaryKey);

		if (badge == _nullBadge) {
			return null;
		}

		if (badge == null) {
			Session session = null;

			try {
				session = openSession();

				badge = (Badge)session.get(BadgeImpl.class, primaryKey);

				if (badge != null) {
					cacheResult(badge);
				}
				else {
					EntityCacheUtil.putResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
						BadgeImpl.class, primaryKey, _nullBadge);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
					BadgeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return badge;
	}

	/**
	 * Returns the badge with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param badgeId the primary key of the badge
	 * @return the badge, or <code>null</code> if a badge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Badge fetchByPrimaryKey(long badgeId) throws SystemException {
		return fetchByPrimaryKey((Serializable)badgeId);
	}

	/**
	 * Returns all the badges.
	 *
	 * @return the badges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Badge> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Badge> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Badge> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Badge> list = (List<Badge>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BADGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BADGE;

				if (pagination) {
					sql = sql.concat(BadgeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Badge>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Badge>(list);
				}
				else {
					list = (List<Badge>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the badges from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Badge badge : findAll()) {
			remove(badge);
		}
	}

	/**
	 * Returns the number of badges.
	 *
	 * @return the number of badges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BADGE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the badge persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.hu.badge.service.model.Badge")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Badge>> listenersList = new ArrayList<ModelListener<Badge>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Badge>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(BadgeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BADGE = "SELECT badge FROM Badge badge";
	private static final String _SQL_SELECT_BADGE_WHERE = "SELECT badge FROM Badge badge WHERE ";
	private static final String _SQL_COUNT_BADGE = "SELECT COUNT(badge) FROM Badge badge";
	private static final String _SQL_COUNT_BADGE_WHERE = "SELECT COUNT(badge) FROM Badge badge WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "badge.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Badge exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Badge exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BadgePersistenceImpl.class);
	private static Badge _nullBadge = new BadgeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Badge> toCacheModel() {
				return _nullBadgeCacheModel;
			}
		};

	private static CacheModel<Badge> _nullBadgeCacheModel = new CacheModel<Badge>() {
			@Override
			public Badge toEntityModel() {
				return _nullBadge;
			}
		};
}