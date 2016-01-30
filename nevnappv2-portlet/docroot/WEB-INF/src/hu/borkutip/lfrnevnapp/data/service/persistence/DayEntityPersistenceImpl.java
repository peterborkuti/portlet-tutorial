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

import hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException;
import hu.borkutip.lfrnevnapp.data.model.DayEntity;
import hu.borkutip.lfrnevnapp.data.model.impl.DayEntityImpl;
import hu.borkutip.lfrnevnapp.data.model.impl.DayEntityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the day entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Péter Borkuti
 * @see DayEntityPersistence
 * @see DayEntityUtil
 * @generated
 */
public class DayEntityPersistenceImpl extends BasePersistenceImpl<DayEntity>
	implements DayEntityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DayEntityUtil} to access the day entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DayEntityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DayEntityModelImpl.ENTITY_CACHE_ENABLED,
			DayEntityModelImpl.FINDER_CACHE_ENABLED, DayEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DayEntityModelImpl.ENTITY_CACHE_ENABLED,
			DayEntityModelImpl.FINDER_CACHE_ENABLED, DayEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DayEntityModelImpl.ENTITY_CACHE_ENABLED,
			DayEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MONTHANDDAY =
		new FinderPath(DayEntityModelImpl.ENTITY_CACHE_ENABLED,
			DayEntityModelImpl.FINDER_CACHE_ENABLED, DayEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymonthAndDay",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHANDDAY =
		new FinderPath(DayEntityModelImpl.ENTITY_CACHE_ENABLED,
			DayEntityModelImpl.FINDER_CACHE_ENABLED, DayEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBymonthAndDay",
			new String[] { Integer.class.getName(), Integer.class.getName() },
			DayEntityModelImpl.MONTH_COLUMN_BITMASK |
			DayEntityModelImpl.DAY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MONTHANDDAY = new FinderPath(DayEntityModelImpl.ENTITY_CACHE_ENABLED,
			DayEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymonthAndDay",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the day entities where month = &#63; and day = &#63;.
	 *
	 * @param month the month
	 * @param day the day
	 * @return the matching day entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DayEntity> findBymonthAndDay(int month, int day)
		throws SystemException {
		return findBymonthAndDay(month, day, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<DayEntity> findBymonthAndDay(int month, int day, int start,
		int end) throws SystemException {
		return findBymonthAndDay(month, day, start, end, null);
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
	@Override
	public List<DayEntity> findBymonthAndDay(int month, int day, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHANDDAY;
			finderArgs = new Object[] { month, day };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MONTHANDDAY;
			finderArgs = new Object[] { month, day, start, end, orderByComparator };
		}

		List<DayEntity> list = (List<DayEntity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DayEntity dayEntity : list) {
				if ((month != dayEntity.getMonth()) ||
						(day != dayEntity.getDay())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_DAYENTITY_WHERE);

			query.append(_FINDER_COLUMN_MONTHANDDAY_MONTH_2);

			query.append(_FINDER_COLUMN_MONTHANDDAY_DAY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DayEntityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(month);

				qPos.add(day);

				if (!pagination) {
					list = (List<DayEntity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DayEntity>(list);
				}
				else {
					list = (List<DayEntity>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first day entity in the ordered set where month = &#63; and day = &#63;.
	 *
	 * @param month the month
	 * @param day the day
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching day entity
	 * @throws hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException if a matching day entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DayEntity findBymonthAndDay_First(int month, int day,
		OrderByComparator orderByComparator)
		throws NoSuchDayEntityException, SystemException {
		DayEntity dayEntity = fetchBymonthAndDay_First(month, day,
				orderByComparator);

		if (dayEntity != null) {
			return dayEntity;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("month=");
		msg.append(month);

		msg.append(", day=");
		msg.append(day);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDayEntityException(msg.toString());
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
	@Override
	public DayEntity fetchBymonthAndDay_First(int month, int day,
		OrderByComparator orderByComparator) throws SystemException {
		List<DayEntity> list = findBymonthAndDay(month, day, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DayEntity findBymonthAndDay_Last(int month, int day,
		OrderByComparator orderByComparator)
		throws NoSuchDayEntityException, SystemException {
		DayEntity dayEntity = fetchBymonthAndDay_Last(month, day,
				orderByComparator);

		if (dayEntity != null) {
			return dayEntity;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("month=");
		msg.append(month);

		msg.append(", day=");
		msg.append(day);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDayEntityException(msg.toString());
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
	@Override
	public DayEntity fetchBymonthAndDay_Last(int month, int day,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBymonthAndDay(month, day);

		if (count == 0) {
			return null;
		}

		List<DayEntity> list = findBymonthAndDay(month, day, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DayEntity[] findBymonthAndDay_PrevAndNext(long dayId, int month,
		int day, OrderByComparator orderByComparator)
		throws NoSuchDayEntityException, SystemException {
		DayEntity dayEntity = findByPrimaryKey(dayId);

		Session session = null;

		try {
			session = openSession();

			DayEntity[] array = new DayEntityImpl[3];

			array[0] = getBymonthAndDay_PrevAndNext(session, dayEntity, month,
					day, orderByComparator, true);

			array[1] = dayEntity;

			array[2] = getBymonthAndDay_PrevAndNext(session, dayEntity, month,
					day, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DayEntity getBymonthAndDay_PrevAndNext(Session session,
		DayEntity dayEntity, int month, int day,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DAYENTITY_WHERE);

		query.append(_FINDER_COLUMN_MONTHANDDAY_MONTH_2);

		query.append(_FINDER_COLUMN_MONTHANDDAY_DAY_2);

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
			query.append(DayEntityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(month);

		qPos.add(day);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dayEntity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DayEntity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the day entities where month = &#63; and day = &#63; from the database.
	 *
	 * @param month the month
	 * @param day the day
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBymonthAndDay(int month, int day)
		throws SystemException {
		for (DayEntity dayEntity : findBymonthAndDay(month, day,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dayEntity);
		}
	}

	/**
	 * Returns the number of day entities where month = &#63; and day = &#63;.
	 *
	 * @param month the month
	 * @param day the day
	 * @return the number of matching day entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBymonthAndDay(int month, int day) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MONTHANDDAY;

		Object[] finderArgs = new Object[] { month, day };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DAYENTITY_WHERE);

			query.append(_FINDER_COLUMN_MONTHANDDAY_MONTH_2);

			query.append(_FINDER_COLUMN_MONTHANDDAY_DAY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(month);

				qPos.add(day);

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

	private static final String _FINDER_COLUMN_MONTHANDDAY_MONTH_2 = "dayEntity.month = ? AND ";
	private static final String _FINDER_COLUMN_MONTHANDDAY_DAY_2 = "dayEntity.day = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMEID = new FinderPath(DayEntityModelImpl.ENTITY_CACHE_ENABLED,
			DayEntityModelImpl.FINDER_CACHE_ENABLED, DayEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNameId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEID =
		new FinderPath(DayEntityModelImpl.ENTITY_CACHE_ENABLED,
			DayEntityModelImpl.FINDER_CACHE_ENABLED, DayEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNameId",
			new String[] { Long.class.getName() },
			DayEntityModelImpl.NAMEID_COLUMN_BITMASK |
			DayEntityModelImpl.MONTH_COLUMN_BITMASK |
			DayEntityModelImpl.DAY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAMEID = new FinderPath(DayEntityModelImpl.ENTITY_CACHE_ENABLED,
			DayEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNameId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the day entities where nameId = &#63;.
	 *
	 * @param nameId the name ID
	 * @return the matching day entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DayEntity> findByNameId(long nameId) throws SystemException {
		return findByNameId(nameId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DayEntity> findByNameId(long nameId, int start, int end)
		throws SystemException {
		return findByNameId(nameId, start, end, null);
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
	@Override
	public List<DayEntity> findByNameId(long nameId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEID;
			finderArgs = new Object[] { nameId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMEID;
			finderArgs = new Object[] { nameId, start, end, orderByComparator };
		}

		List<DayEntity> list = (List<DayEntity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DayEntity dayEntity : list) {
				if ((nameId != dayEntity.getNameId())) {
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

			query.append(_SQL_SELECT_DAYENTITY_WHERE);

			query.append(_FINDER_COLUMN_NAMEID_NAMEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DayEntityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nameId);

				if (!pagination) {
					list = (List<DayEntity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DayEntity>(list);
				}
				else {
					list = (List<DayEntity>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first day entity in the ordered set where nameId = &#63;.
	 *
	 * @param nameId the name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching day entity
	 * @throws hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException if a matching day entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DayEntity findByNameId_First(long nameId,
		OrderByComparator orderByComparator)
		throws NoSuchDayEntityException, SystemException {
		DayEntity dayEntity = fetchByNameId_First(nameId, orderByComparator);

		if (dayEntity != null) {
			return dayEntity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nameId=");
		msg.append(nameId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDayEntityException(msg.toString());
	}

	/**
	 * Returns the first day entity in the ordered set where nameId = &#63;.
	 *
	 * @param nameId the name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching day entity, or <code>null</code> if a matching day entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DayEntity fetchByNameId_First(long nameId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DayEntity> list = findByNameId(nameId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DayEntity findByNameId_Last(long nameId,
		OrderByComparator orderByComparator)
		throws NoSuchDayEntityException, SystemException {
		DayEntity dayEntity = fetchByNameId_Last(nameId, orderByComparator);

		if (dayEntity != null) {
			return dayEntity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nameId=");
		msg.append(nameId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDayEntityException(msg.toString());
	}

	/**
	 * Returns the last day entity in the ordered set where nameId = &#63;.
	 *
	 * @param nameId the name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching day entity, or <code>null</code> if a matching day entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DayEntity fetchByNameId_Last(long nameId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByNameId(nameId);

		if (count == 0) {
			return null;
		}

		List<DayEntity> list = findByNameId(nameId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DayEntity[] findByNameId_PrevAndNext(long dayId, long nameId,
		OrderByComparator orderByComparator)
		throws NoSuchDayEntityException, SystemException {
		DayEntity dayEntity = findByPrimaryKey(dayId);

		Session session = null;

		try {
			session = openSession();

			DayEntity[] array = new DayEntityImpl[3];

			array[0] = getByNameId_PrevAndNext(session, dayEntity, nameId,
					orderByComparator, true);

			array[1] = dayEntity;

			array[2] = getByNameId_PrevAndNext(session, dayEntity, nameId,
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

	protected DayEntity getByNameId_PrevAndNext(Session session,
		DayEntity dayEntity, long nameId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DAYENTITY_WHERE);

		query.append(_FINDER_COLUMN_NAMEID_NAMEID_2);

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
			query.append(DayEntityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(nameId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dayEntity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DayEntity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the day entities where nameId = &#63; from the database.
	 *
	 * @param nameId the name ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNameId(long nameId) throws SystemException {
		for (DayEntity dayEntity : findByNameId(nameId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(dayEntity);
		}
	}

	/**
	 * Returns the number of day entities where nameId = &#63;.
	 *
	 * @param nameId the name ID
	 * @return the number of matching day entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNameId(long nameId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAMEID;

		Object[] finderArgs = new Object[] { nameId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DAYENTITY_WHERE);

			query.append(_FINDER_COLUMN_NAMEID_NAMEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nameId);

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

	private static final String _FINDER_COLUMN_NAMEID_NAMEID_2 = "dayEntity.nameId = ?";

	public DayEntityPersistenceImpl() {
		setModelClass(DayEntity.class);
	}

	/**
	 * Caches the day entity in the entity cache if it is enabled.
	 *
	 * @param dayEntity the day entity
	 */
	@Override
	public void cacheResult(DayEntity dayEntity) {
		EntityCacheUtil.putResult(DayEntityModelImpl.ENTITY_CACHE_ENABLED,
			DayEntityImpl.class, dayEntity.getPrimaryKey(), dayEntity);

		dayEntity.resetOriginalValues();
	}

	/**
	 * Caches the day entities in the entity cache if it is enabled.
	 *
	 * @param dayEntities the day entities
	 */
	@Override
	public void cacheResult(List<DayEntity> dayEntities) {
		for (DayEntity dayEntity : dayEntities) {
			if (EntityCacheUtil.getResult(
						DayEntityModelImpl.ENTITY_CACHE_ENABLED,
						DayEntityImpl.class, dayEntity.getPrimaryKey()) == null) {
				cacheResult(dayEntity);
			}
			else {
				dayEntity.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all day entities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DayEntityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DayEntityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the day entity.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DayEntity dayEntity) {
		EntityCacheUtil.removeResult(DayEntityModelImpl.ENTITY_CACHE_ENABLED,
			DayEntityImpl.class, dayEntity.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DayEntity> dayEntities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DayEntity dayEntity : dayEntities) {
			EntityCacheUtil.removeResult(DayEntityModelImpl.ENTITY_CACHE_ENABLED,
				DayEntityImpl.class, dayEntity.getPrimaryKey());
		}
	}

	/**
	 * Creates a new day entity with the primary key. Does not add the day entity to the database.
	 *
	 * @param dayId the primary key for the new day entity
	 * @return the new day entity
	 */
	@Override
	public DayEntity create(long dayId) {
		DayEntity dayEntity = new DayEntityImpl();

		dayEntity.setNew(true);
		dayEntity.setPrimaryKey(dayId);

		return dayEntity;
	}

	/**
	 * Removes the day entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dayId the primary key of the day entity
	 * @return the day entity that was removed
	 * @throws hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException if a day entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DayEntity remove(long dayId)
		throws NoSuchDayEntityException, SystemException {
		return remove((Serializable)dayId);
	}

	/**
	 * Removes the day entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the day entity
	 * @return the day entity that was removed
	 * @throws hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException if a day entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DayEntity remove(Serializable primaryKey)
		throws NoSuchDayEntityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DayEntity dayEntity = (DayEntity)session.get(DayEntityImpl.class,
					primaryKey);

			if (dayEntity == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDayEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dayEntity);
		}
		catch (NoSuchDayEntityException nsee) {
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
	protected DayEntity removeImpl(DayEntity dayEntity)
		throws SystemException {
		dayEntity = toUnwrappedModel(dayEntity);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dayEntity)) {
				dayEntity = (DayEntity)session.get(DayEntityImpl.class,
						dayEntity.getPrimaryKeyObj());
			}

			if (dayEntity != null) {
				session.delete(dayEntity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dayEntity != null) {
			clearCache(dayEntity);
		}

		return dayEntity;
	}

	@Override
	public DayEntity updateImpl(
		hu.borkutip.lfrnevnapp.data.model.DayEntity dayEntity)
		throws SystemException {
		dayEntity = toUnwrappedModel(dayEntity);

		boolean isNew = dayEntity.isNew();

		DayEntityModelImpl dayEntityModelImpl = (DayEntityModelImpl)dayEntity;

		Session session = null;

		try {
			session = openSession();

			if (dayEntity.isNew()) {
				session.save(dayEntity);

				dayEntity.setNew(false);
			}
			else {
				session.merge(dayEntity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DayEntityModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dayEntityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHANDDAY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dayEntityModelImpl.getOriginalMonth(),
						dayEntityModelImpl.getOriginalDay()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MONTHANDDAY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHANDDAY,
					args);

				args = new Object[] {
						dayEntityModelImpl.getMonth(),
						dayEntityModelImpl.getDay()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MONTHANDDAY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MONTHANDDAY,
					args);
			}

			if ((dayEntityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dayEntityModelImpl.getOriginalNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEID,
					args);

				args = new Object[] { dayEntityModelImpl.getNameId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEID,
					args);
			}
		}

		EntityCacheUtil.putResult(DayEntityModelImpl.ENTITY_CACHE_ENABLED,
			DayEntityImpl.class, dayEntity.getPrimaryKey(), dayEntity);

		return dayEntity;
	}

	protected DayEntity toUnwrappedModel(DayEntity dayEntity) {
		if (dayEntity instanceof DayEntityImpl) {
			return dayEntity;
		}

		DayEntityImpl dayEntityImpl = new DayEntityImpl();

		dayEntityImpl.setNew(dayEntity.isNew());
		dayEntityImpl.setPrimaryKey(dayEntity.getPrimaryKey());

		dayEntityImpl.setDayId(dayEntity.getDayId());
		dayEntityImpl.setMonth(dayEntity.getMonth());
		dayEntityImpl.setDay(dayEntity.getDay());
		dayEntityImpl.setNameId(dayEntity.getNameId());

		return dayEntityImpl;
	}

	/**
	 * Returns the day entity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the day entity
	 * @return the day entity
	 * @throws hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException if a day entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DayEntity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDayEntityException, SystemException {
		DayEntity dayEntity = fetchByPrimaryKey(primaryKey);

		if (dayEntity == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDayEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dayEntity;
	}

	/**
	 * Returns the day entity with the primary key or throws a {@link hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException} if it could not be found.
	 *
	 * @param dayId the primary key of the day entity
	 * @return the day entity
	 * @throws hu.borkutip.lfrnevnapp.data.NoSuchDayEntityException if a day entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DayEntity findByPrimaryKey(long dayId)
		throws NoSuchDayEntityException, SystemException {
		return findByPrimaryKey((Serializable)dayId);
	}

	/**
	 * Returns the day entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the day entity
	 * @return the day entity, or <code>null</code> if a day entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DayEntity fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DayEntity dayEntity = (DayEntity)EntityCacheUtil.getResult(DayEntityModelImpl.ENTITY_CACHE_ENABLED,
				DayEntityImpl.class, primaryKey);

		if (dayEntity == _nullDayEntity) {
			return null;
		}

		if (dayEntity == null) {
			Session session = null;

			try {
				session = openSession();

				dayEntity = (DayEntity)session.get(DayEntityImpl.class,
						primaryKey);

				if (dayEntity != null) {
					cacheResult(dayEntity);
				}
				else {
					EntityCacheUtil.putResult(DayEntityModelImpl.ENTITY_CACHE_ENABLED,
						DayEntityImpl.class, primaryKey, _nullDayEntity);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DayEntityModelImpl.ENTITY_CACHE_ENABLED,
					DayEntityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dayEntity;
	}

	/**
	 * Returns the day entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dayId the primary key of the day entity
	 * @return the day entity, or <code>null</code> if a day entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DayEntity fetchByPrimaryKey(long dayId) throws SystemException {
		return fetchByPrimaryKey((Serializable)dayId);
	}

	/**
	 * Returns all the day entities.
	 *
	 * @return the day entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DayEntity> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DayEntity> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<DayEntity> findAll(int start, int end,
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

		List<DayEntity> list = (List<DayEntity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DAYENTITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DAYENTITY;

				if (pagination) {
					sql = sql.concat(DayEntityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DayEntity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DayEntity>(list);
				}
				else {
					list = (List<DayEntity>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the day entities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DayEntity dayEntity : findAll()) {
			remove(dayEntity);
		}
	}

	/**
	 * Returns the number of day entities.
	 *
	 * @return the number of day entities
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

				Query q = session.createQuery(_SQL_COUNT_DAYENTITY);

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
	 * Initializes the day entity persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.hu.borkutip.lfrnevnapp.data.model.DayEntity")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DayEntity>> listenersList = new ArrayList<ModelListener<DayEntity>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DayEntity>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DayEntityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DAYENTITY = "SELECT dayEntity FROM DayEntity dayEntity";
	private static final String _SQL_SELECT_DAYENTITY_WHERE = "SELECT dayEntity FROM DayEntity dayEntity WHERE ";
	private static final String _SQL_COUNT_DAYENTITY = "SELECT COUNT(dayEntity) FROM DayEntity dayEntity";
	private static final String _SQL_COUNT_DAYENTITY_WHERE = "SELECT COUNT(dayEntity) FROM DayEntity dayEntity WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dayEntity.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DayEntity exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DayEntity exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DayEntityPersistenceImpl.class);
	private static DayEntity _nullDayEntity = new DayEntityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DayEntity> toCacheModel() {
				return _nullDayEntityCacheModel;
			}
		};

	private static CacheModel<DayEntity> _nullDayEntityCacheModel = new CacheModel<DayEntity>() {
			@Override
			public DayEntity toEntityModel() {
				return _nullDayEntity;
			}
		};
}