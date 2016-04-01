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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import test.sb.NoSuchLegacydbException;

import test.sb.model.Legacydb;
import test.sb.model.impl.LegacydbImpl;
import test.sb.model.impl.LegacydbModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the legacydb service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author peter
 * @see LegacydbPersistence
 * @see LegacydbUtil
 * @generated
 */
public class LegacydbPersistenceImpl extends BasePersistenceImpl<Legacydb>
	implements LegacydbPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LegacydbUtil} to access the legacydb persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LegacydbImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LegacydbModelImpl.ENTITY_CACHE_ENABLED,
			LegacydbModelImpl.FINDER_CACHE_ENABLED, LegacydbImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LegacydbModelImpl.ENTITY_CACHE_ENABLED,
			LegacydbModelImpl.FINDER_CACHE_ENABLED, LegacydbImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LegacydbModelImpl.ENTITY_CACHE_ENABLED,
			LegacydbModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(LegacydbModelImpl.ENTITY_CACHE_ENABLED,
			LegacydbModelImpl.FINDER_CACHE_ENABLED, LegacydbImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(LegacydbModelImpl.ENTITY_CACHE_ENABLED,
			LegacydbModelImpl.FINDER_CACHE_ENABLED, LegacydbImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] { String.class.getName() },
			LegacydbModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(LegacydbModelImpl.ENTITY_CACHE_ENABLED,
			LegacydbModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the legacydbs where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching legacydbs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legacydb> findByName(String name) throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Legacydb> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
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
	@Override
	public List<Legacydb> findByName(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<Legacydb> list = (List<Legacydb>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Legacydb legacydb : list) {
				if (!Validator.equals(name, legacydb.getName())) {
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

			query.append(_SQL_SELECT_LEGACYDB_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LegacydbModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<Legacydb>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Legacydb>(list);
				}
				else {
					list = (List<Legacydb>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first legacydb in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legacydb
	 * @throws test.sb.NoSuchLegacydbException if a matching legacydb could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legacydb findByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchLegacydbException, SystemException {
		Legacydb legacydb = fetchByName_First(name, orderByComparator);

		if (legacydb != null) {
			return legacydb;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegacydbException(msg.toString());
	}

	/**
	 * Returns the first legacydb in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legacydb, or <code>null</code> if a matching legacydb could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legacydb fetchByName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<Legacydb> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Legacydb findByName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchLegacydbException, SystemException {
		Legacydb legacydb = fetchByName_Last(name, orderByComparator);

		if (legacydb != null) {
			return legacydb;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLegacydbException(msg.toString());
	}

	/**
	 * Returns the last legacydb in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legacydb, or <code>null</code> if a matching legacydb could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legacydb fetchByName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<Legacydb> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Legacydb[] findByName_PrevAndNext(long legacydbid, String name,
		OrderByComparator orderByComparator)
		throws NoSuchLegacydbException, SystemException {
		Legacydb legacydb = findByPrimaryKey(legacydbid);

		Session session = null;

		try {
			session = openSession();

			Legacydb[] array = new LegacydbImpl[3];

			array[0] = getByName_PrevAndNext(session, legacydb, name,
					orderByComparator, true);

			array[1] = legacydb;

			array[2] = getByName_PrevAndNext(session, legacydb, name,
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

	protected Legacydb getByName_PrevAndNext(Session session,
		Legacydb legacydb, String name, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGACYDB_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
		}

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
			query.append(LegacydbModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(legacydb);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Legacydb> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legacydbs where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByName(String name) throws SystemException {
		for (Legacydb legacydb : findByName(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(legacydb);
		}
	}

	/**
	 * Returns the number of legacydbs where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching legacydbs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGACYDB_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "legacydb.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "legacydb.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(legacydb.name IS NULL OR legacydb.name = '')";

	public LegacydbPersistenceImpl() {
		setModelClass(Legacydb.class);
	}

	/**
	 * Caches the legacydb in the entity cache if it is enabled.
	 *
	 * @param legacydb the legacydb
	 */
	@Override
	public void cacheResult(Legacydb legacydb) {
		EntityCacheUtil.putResult(LegacydbModelImpl.ENTITY_CACHE_ENABLED,
			LegacydbImpl.class, legacydb.getPrimaryKey(), legacydb);

		legacydb.resetOriginalValues();
	}

	/**
	 * Caches the legacydbs in the entity cache if it is enabled.
	 *
	 * @param legacydbs the legacydbs
	 */
	@Override
	public void cacheResult(List<Legacydb> legacydbs) {
		for (Legacydb legacydb : legacydbs) {
			if (EntityCacheUtil.getResult(
						LegacydbModelImpl.ENTITY_CACHE_ENABLED,
						LegacydbImpl.class, legacydb.getPrimaryKey()) == null) {
				cacheResult(legacydb);
			}
			else {
				legacydb.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legacydbs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LegacydbImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LegacydbImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legacydb.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Legacydb legacydb) {
		EntityCacheUtil.removeResult(LegacydbModelImpl.ENTITY_CACHE_ENABLED,
			LegacydbImpl.class, legacydb.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Legacydb> legacydbs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Legacydb legacydb : legacydbs) {
			EntityCacheUtil.removeResult(LegacydbModelImpl.ENTITY_CACHE_ENABLED,
				LegacydbImpl.class, legacydb.getPrimaryKey());
		}
	}

	/**
	 * Creates a new legacydb with the primary key. Does not add the legacydb to the database.
	 *
	 * @param legacydbid the primary key for the new legacydb
	 * @return the new legacydb
	 */
	@Override
	public Legacydb create(long legacydbid) {
		Legacydb legacydb = new LegacydbImpl();

		legacydb.setNew(true);
		legacydb.setPrimaryKey(legacydbid);

		return legacydb;
	}

	/**
	 * Removes the legacydb with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legacydbid the primary key of the legacydb
	 * @return the legacydb that was removed
	 * @throws test.sb.NoSuchLegacydbException if a legacydb with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legacydb remove(long legacydbid)
		throws NoSuchLegacydbException, SystemException {
		return remove((Serializable)legacydbid);
	}

	/**
	 * Removes the legacydb with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legacydb
	 * @return the legacydb that was removed
	 * @throws test.sb.NoSuchLegacydbException if a legacydb with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legacydb remove(Serializable primaryKey)
		throws NoSuchLegacydbException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Legacydb legacydb = (Legacydb)session.get(LegacydbImpl.class,
					primaryKey);

			if (legacydb == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegacydbException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(legacydb);
		}
		catch (NoSuchLegacydbException nsee) {
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
	protected Legacydb removeImpl(Legacydb legacydb) throws SystemException {
		legacydb = toUnwrappedModel(legacydb);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legacydb)) {
				legacydb = (Legacydb)session.get(LegacydbImpl.class,
						legacydb.getPrimaryKeyObj());
			}

			if (legacydb != null) {
				session.delete(legacydb);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (legacydb != null) {
			clearCache(legacydb);
		}

		return legacydb;
	}

	@Override
	public Legacydb updateImpl(test.sb.model.Legacydb legacydb)
		throws SystemException {
		legacydb = toUnwrappedModel(legacydb);

		boolean isNew = legacydb.isNew();

		LegacydbModelImpl legacydbModelImpl = (LegacydbModelImpl)legacydb;

		Session session = null;

		try {
			session = openSession();

			if (legacydb.isNew()) {
				session.save(legacydb);

				legacydb.setNew(false);
			}
			else {
				session.merge(legacydb);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LegacydbModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((legacydbModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { legacydbModelImpl.getOriginalName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { legacydbModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}
		}

		EntityCacheUtil.putResult(LegacydbModelImpl.ENTITY_CACHE_ENABLED,
			LegacydbImpl.class, legacydb.getPrimaryKey(), legacydb);

		return legacydb;
	}

	protected Legacydb toUnwrappedModel(Legacydb legacydb) {
		if (legacydb instanceof LegacydbImpl) {
			return legacydb;
		}

		LegacydbImpl legacydbImpl = new LegacydbImpl();

		legacydbImpl.setNew(legacydb.isNew());
		legacydbImpl.setPrimaryKey(legacydb.getPrimaryKey());

		legacydbImpl.setLegacydbid(legacydb.getLegacydbid());
		legacydbImpl.setName(legacydb.getName());

		return legacydbImpl;
	}

	/**
	 * Returns the legacydb with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacydb
	 * @return the legacydb
	 * @throws test.sb.NoSuchLegacydbException if a legacydb with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legacydb findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegacydbException, SystemException {
		Legacydb legacydb = fetchByPrimaryKey(primaryKey);

		if (legacydb == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegacydbException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return legacydb;
	}

	/**
	 * Returns the legacydb with the primary key or throws a {@link test.sb.NoSuchLegacydbException} if it could not be found.
	 *
	 * @param legacydbid the primary key of the legacydb
	 * @return the legacydb
	 * @throws test.sb.NoSuchLegacydbException if a legacydb with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legacydb findByPrimaryKey(long legacydbid)
		throws NoSuchLegacydbException, SystemException {
		return findByPrimaryKey((Serializable)legacydbid);
	}

	/**
	 * Returns the legacydb with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legacydb
	 * @return the legacydb, or <code>null</code> if a legacydb with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legacydb fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Legacydb legacydb = (Legacydb)EntityCacheUtil.getResult(LegacydbModelImpl.ENTITY_CACHE_ENABLED,
				LegacydbImpl.class, primaryKey);

		if (legacydb == _nullLegacydb) {
			return null;
		}

		if (legacydb == null) {
			Session session = null;

			try {
				session = openSession();

				legacydb = (Legacydb)session.get(LegacydbImpl.class, primaryKey);

				if (legacydb != null) {
					cacheResult(legacydb);
				}
				else {
					EntityCacheUtil.putResult(LegacydbModelImpl.ENTITY_CACHE_ENABLED,
						LegacydbImpl.class, primaryKey, _nullLegacydb);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LegacydbModelImpl.ENTITY_CACHE_ENABLED,
					LegacydbImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return legacydb;
	}

	/**
	 * Returns the legacydb with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param legacydbid the primary key of the legacydb
	 * @return the legacydb, or <code>null</code> if a legacydb with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Legacydb fetchByPrimaryKey(long legacydbid)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)legacydbid);
	}

	/**
	 * Returns all the legacydbs.
	 *
	 * @return the legacydbs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Legacydb> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Legacydb> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Legacydb> findAll(int start, int end,
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

		List<Legacydb> list = (List<Legacydb>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEGACYDB);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGACYDB;

				if (pagination) {
					sql = sql.concat(LegacydbModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Legacydb>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Legacydb>(list);
				}
				else {
					list = (List<Legacydb>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the legacydbs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Legacydb legacydb : findAll()) {
			remove(legacydb);
		}
	}

	/**
	 * Returns the number of legacydbs.
	 *
	 * @return the number of legacydbs
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

				Query q = session.createQuery(_SQL_COUNT_LEGACYDB);

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
	 * Initializes the legacydb persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.test.sb.model.Legacydb")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Legacydb>> listenersList = new ArrayList<ModelListener<Legacydb>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Legacydb>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LegacydbImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEGACYDB = "SELECT legacydb FROM Legacydb legacydb";
	private static final String _SQL_SELECT_LEGACYDB_WHERE = "SELECT legacydb FROM Legacydb legacydb WHERE ";
	private static final String _SQL_COUNT_LEGACYDB = "SELECT COUNT(legacydb) FROM Legacydb legacydb";
	private static final String _SQL_COUNT_LEGACYDB_WHERE = "SELECT COUNT(legacydb) FROM Legacydb legacydb WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "legacydb.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Legacydb exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Legacydb exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LegacydbPersistenceImpl.class);
	private static Legacydb _nullLegacydb = new LegacydbImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Legacydb> toCacheModel() {
				return _nullLegacydbCacheModel;
			}
		};

	private static CacheModel<Legacydb> _nullLegacydbCacheModel = new CacheModel<Legacydb>() {
			@Override
			public Legacydb toEntityModel() {
				return _nullLegacydb;
			}
		};
}