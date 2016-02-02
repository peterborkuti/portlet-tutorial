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

import permission.servicebuider.NoSuchFirstnamesException;

import permission.servicebuider.model.Firstnames;
import permission.servicebuider.model.impl.FirstnamesImpl;
import permission.servicebuider.model.impl.FirstnamesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the firstnames service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author peter
 * @see FirstnamesPersistence
 * @see FirstnamesUtil
 * @generated
 */
public class FirstnamesPersistenceImpl extends BasePersistenceImpl<Firstnames>
	implements FirstnamesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FirstnamesUtil} to access the firstnames persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FirstnamesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FirstnamesModelImpl.ENTITY_CACHE_ENABLED,
			FirstnamesModelImpl.FINDER_CACHE_ENABLED, FirstnamesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FirstnamesModelImpl.ENTITY_CACHE_ENABLED,
			FirstnamesModelImpl.FINDER_CACHE_ENABLED, FirstnamesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FirstnamesModelImpl.ENTITY_CACHE_ENABLED,
			FirstnamesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FIRSTNAME =
		new FinderPath(FirstnamesModelImpl.ENTITY_CACHE_ENABLED,
			FirstnamesModelImpl.FINDER_CACHE_ENABLED, FirstnamesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfirstname",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME =
		new FinderPath(FirstnamesModelImpl.ENTITY_CACHE_ENABLED,
			FirstnamesModelImpl.FINDER_CACHE_ENABLED, FirstnamesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfirstname",
			new String[] { String.class.getName() },
			FirstnamesModelImpl.FIRSTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FIRSTNAME = new FinderPath(FirstnamesModelImpl.ENTITY_CACHE_ENABLED,
			FirstnamesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfirstname",
			new String[] { String.class.getName() });

	/**
	 * Returns all the firstnameses where firstname = &#63;.
	 *
	 * @param firstname the firstname
	 * @return the matching firstnameses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Firstnames> findByfirstname(String firstname)
		throws SystemException {
		return findByfirstname(firstname, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Firstnames> findByfirstname(String firstname, int start, int end)
		throws SystemException {
		return findByfirstname(firstname, start, end, null);
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
	@Override
	public List<Firstnames> findByfirstname(String firstname, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME;
			finderArgs = new Object[] { firstname };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FIRSTNAME;
			finderArgs = new Object[] { firstname, start, end, orderByComparator };
		}

		List<Firstnames> list = (List<Firstnames>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Firstnames firstnames : list) {
				if (!Validator.equals(firstname, firstnames.getFirstname())) {
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

			query.append(_SQL_SELECT_FIRSTNAMES_WHERE);

			boolean bindFirstname = false;

			if (firstname == null) {
				query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_1);
			}
			else if (firstname.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_3);
			}
			else {
				bindFirstname = true;

				query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FirstnamesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFirstname) {
					qPos.add(firstname);
				}

				if (!pagination) {
					list = (List<Firstnames>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Firstnames>(list);
				}
				else {
					list = (List<Firstnames>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first firstnames in the ordered set where firstname = &#63;.
	 *
	 * @param firstname the firstname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching firstnames
	 * @throws permission.servicebuider.NoSuchFirstnamesException if a matching firstnames could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Firstnames findByfirstname_First(String firstname,
		OrderByComparator orderByComparator)
		throws NoSuchFirstnamesException, SystemException {
		Firstnames firstnames = fetchByfirstname_First(firstname,
				orderByComparator);

		if (firstnames != null) {
			return firstnames;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("firstname=");
		msg.append(firstname);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFirstnamesException(msg.toString());
	}

	/**
	 * Returns the first firstnames in the ordered set where firstname = &#63;.
	 *
	 * @param firstname the firstname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching firstnames, or <code>null</code> if a matching firstnames could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Firstnames fetchByfirstname_First(String firstname,
		OrderByComparator orderByComparator) throws SystemException {
		List<Firstnames> list = findByfirstname(firstname, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Firstnames findByfirstname_Last(String firstname,
		OrderByComparator orderByComparator)
		throws NoSuchFirstnamesException, SystemException {
		Firstnames firstnames = fetchByfirstname_Last(firstname,
				orderByComparator);

		if (firstnames != null) {
			return firstnames;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("firstname=");
		msg.append(firstname);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFirstnamesException(msg.toString());
	}

	/**
	 * Returns the last firstnames in the ordered set where firstname = &#63;.
	 *
	 * @param firstname the firstname
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching firstnames, or <code>null</code> if a matching firstnames could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Firstnames fetchByfirstname_Last(String firstname,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByfirstname(firstname);

		if (count == 0) {
			return null;
		}

		List<Firstnames> list = findByfirstname(firstname, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Firstnames[] findByfirstname_PrevAndNext(long firstnameId,
		String firstname, OrderByComparator orderByComparator)
		throws NoSuchFirstnamesException, SystemException {
		Firstnames firstnames = findByPrimaryKey(firstnameId);

		Session session = null;

		try {
			session = openSession();

			Firstnames[] array = new FirstnamesImpl[3];

			array[0] = getByfirstname_PrevAndNext(session, firstnames,
					firstname, orderByComparator, true);

			array[1] = firstnames;

			array[2] = getByfirstname_PrevAndNext(session, firstnames,
					firstname, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Firstnames getByfirstname_PrevAndNext(Session session,
		Firstnames firstnames, String firstname,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FIRSTNAMES_WHERE);

		boolean bindFirstname = false;

		if (firstname == null) {
			query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_1);
		}
		else if (firstname.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_3);
		}
		else {
			bindFirstname = true;

			query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_2);
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
			query.append(FirstnamesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindFirstname) {
			qPos.add(firstname);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(firstnames);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Firstnames> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the firstnameses where firstname = &#63; from the database.
	 *
	 * @param firstname the firstname
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByfirstname(String firstname) throws SystemException {
		for (Firstnames firstnames : findByfirstname(firstname,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(firstnames);
		}
	}

	/**
	 * Returns the number of firstnameses where firstname = &#63;.
	 *
	 * @param firstname the firstname
	 * @return the number of matching firstnameses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByfirstname(String firstname) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FIRSTNAME;

		Object[] finderArgs = new Object[] { firstname };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FIRSTNAMES_WHERE);

			boolean bindFirstname = false;

			if (firstname == null) {
				query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_1);
			}
			else if (firstname.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_3);
			}
			else {
				bindFirstname = true;

				query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFirstname) {
					qPos.add(firstname);
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

	private static final String _FINDER_COLUMN_FIRSTNAME_FIRSTNAME_1 = "firstnames.firstname IS NULL";
	private static final String _FINDER_COLUMN_FIRSTNAME_FIRSTNAME_2 = "firstnames.firstname = ?";
	private static final String _FINDER_COLUMN_FIRSTNAME_FIRSTNAME_3 = "(firstnames.firstname IS NULL OR firstnames.firstname = '')";

	public FirstnamesPersistenceImpl() {
		setModelClass(Firstnames.class);
	}

	/**
	 * Caches the firstnames in the entity cache if it is enabled.
	 *
	 * @param firstnames the firstnames
	 */
	@Override
	public void cacheResult(Firstnames firstnames) {
		EntityCacheUtil.putResult(FirstnamesModelImpl.ENTITY_CACHE_ENABLED,
			FirstnamesImpl.class, firstnames.getPrimaryKey(), firstnames);

		firstnames.resetOriginalValues();
	}

	/**
	 * Caches the firstnameses in the entity cache if it is enabled.
	 *
	 * @param firstnameses the firstnameses
	 */
	@Override
	public void cacheResult(List<Firstnames> firstnameses) {
		for (Firstnames firstnames : firstnameses) {
			if (EntityCacheUtil.getResult(
						FirstnamesModelImpl.ENTITY_CACHE_ENABLED,
						FirstnamesImpl.class, firstnames.getPrimaryKey()) == null) {
				cacheResult(firstnames);
			}
			else {
				firstnames.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all firstnameses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FirstnamesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FirstnamesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the firstnames.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Firstnames firstnames) {
		EntityCacheUtil.removeResult(FirstnamesModelImpl.ENTITY_CACHE_ENABLED,
			FirstnamesImpl.class, firstnames.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Firstnames> firstnameses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Firstnames firstnames : firstnameses) {
			EntityCacheUtil.removeResult(FirstnamesModelImpl.ENTITY_CACHE_ENABLED,
				FirstnamesImpl.class, firstnames.getPrimaryKey());
		}
	}

	/**
	 * Creates a new firstnames with the primary key. Does not add the firstnames to the database.
	 *
	 * @param firstnameId the primary key for the new firstnames
	 * @return the new firstnames
	 */
	@Override
	public Firstnames create(long firstnameId) {
		Firstnames firstnames = new FirstnamesImpl();

		firstnames.setNew(true);
		firstnames.setPrimaryKey(firstnameId);

		return firstnames;
	}

	/**
	 * Removes the firstnames with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param firstnameId the primary key of the firstnames
	 * @return the firstnames that was removed
	 * @throws permission.servicebuider.NoSuchFirstnamesException if a firstnames with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Firstnames remove(long firstnameId)
		throws NoSuchFirstnamesException, SystemException {
		return remove((Serializable)firstnameId);
	}

	/**
	 * Removes the firstnames with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the firstnames
	 * @return the firstnames that was removed
	 * @throws permission.servicebuider.NoSuchFirstnamesException if a firstnames with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Firstnames remove(Serializable primaryKey)
		throws NoSuchFirstnamesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Firstnames firstnames = (Firstnames)session.get(FirstnamesImpl.class,
					primaryKey);

			if (firstnames == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFirstnamesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(firstnames);
		}
		catch (NoSuchFirstnamesException nsee) {
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
	protected Firstnames removeImpl(Firstnames firstnames)
		throws SystemException {
		firstnames = toUnwrappedModel(firstnames);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(firstnames)) {
				firstnames = (Firstnames)session.get(FirstnamesImpl.class,
						firstnames.getPrimaryKeyObj());
			}

			if (firstnames != null) {
				session.delete(firstnames);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (firstnames != null) {
			clearCache(firstnames);
		}

		return firstnames;
	}

	@Override
	public Firstnames updateImpl(
		permission.servicebuider.model.Firstnames firstnames)
		throws SystemException {
		firstnames = toUnwrappedModel(firstnames);

		boolean isNew = firstnames.isNew();

		FirstnamesModelImpl firstnamesModelImpl = (FirstnamesModelImpl)firstnames;

		Session session = null;

		try {
			session = openSession();

			if (firstnames.isNew()) {
				session.save(firstnames);

				firstnames.setNew(false);
			}
			else {
				session.merge(firstnames);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FirstnamesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((firstnamesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						firstnamesModelImpl.getOriginalFirstname()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIRSTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME,
					args);

				args = new Object[] { firstnamesModelImpl.getFirstname() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIRSTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME,
					args);
			}
		}

		EntityCacheUtil.putResult(FirstnamesModelImpl.ENTITY_CACHE_ENABLED,
			FirstnamesImpl.class, firstnames.getPrimaryKey(), firstnames);

		return firstnames;
	}

	protected Firstnames toUnwrappedModel(Firstnames firstnames) {
		if (firstnames instanceof FirstnamesImpl) {
			return firstnames;
		}

		FirstnamesImpl firstnamesImpl = new FirstnamesImpl();

		firstnamesImpl.setNew(firstnames.isNew());
		firstnamesImpl.setPrimaryKey(firstnames.getPrimaryKey());

		firstnamesImpl.setFirstnameId(firstnames.getFirstnameId());
		firstnamesImpl.setGroupId(firstnames.getGroupId());
		firstnamesImpl.setCompanyId(firstnames.getCompanyId());
		firstnamesImpl.setUserId(firstnames.getUserId());
		firstnamesImpl.setCreateDate(firstnames.getCreateDate());
		firstnamesImpl.setModifiedDate(firstnames.getModifiedDate());
		firstnamesImpl.setFirstname(firstnames.getFirstname());

		return firstnamesImpl;
	}

	/**
	 * Returns the firstnames with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the firstnames
	 * @return the firstnames
	 * @throws permission.servicebuider.NoSuchFirstnamesException if a firstnames with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Firstnames findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFirstnamesException, SystemException {
		Firstnames firstnames = fetchByPrimaryKey(primaryKey);

		if (firstnames == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFirstnamesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return firstnames;
	}

	/**
	 * Returns the firstnames with the primary key or throws a {@link permission.servicebuider.NoSuchFirstnamesException} if it could not be found.
	 *
	 * @param firstnameId the primary key of the firstnames
	 * @return the firstnames
	 * @throws permission.servicebuider.NoSuchFirstnamesException if a firstnames with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Firstnames findByPrimaryKey(long firstnameId)
		throws NoSuchFirstnamesException, SystemException {
		return findByPrimaryKey((Serializable)firstnameId);
	}

	/**
	 * Returns the firstnames with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the firstnames
	 * @return the firstnames, or <code>null</code> if a firstnames with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Firstnames fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Firstnames firstnames = (Firstnames)EntityCacheUtil.getResult(FirstnamesModelImpl.ENTITY_CACHE_ENABLED,
				FirstnamesImpl.class, primaryKey);

		if (firstnames == _nullFirstnames) {
			return null;
		}

		if (firstnames == null) {
			Session session = null;

			try {
				session = openSession();

				firstnames = (Firstnames)session.get(FirstnamesImpl.class,
						primaryKey);

				if (firstnames != null) {
					cacheResult(firstnames);
				}
				else {
					EntityCacheUtil.putResult(FirstnamesModelImpl.ENTITY_CACHE_ENABLED,
						FirstnamesImpl.class, primaryKey, _nullFirstnames);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FirstnamesModelImpl.ENTITY_CACHE_ENABLED,
					FirstnamesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return firstnames;
	}

	/**
	 * Returns the firstnames with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param firstnameId the primary key of the firstnames
	 * @return the firstnames, or <code>null</code> if a firstnames with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Firstnames fetchByPrimaryKey(long firstnameId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)firstnameId);
	}

	/**
	 * Returns all the firstnameses.
	 *
	 * @return the firstnameses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Firstnames> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Firstnames> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Firstnames> findAll(int start, int end,
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

		List<Firstnames> list = (List<Firstnames>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FIRSTNAMES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FIRSTNAMES;

				if (pagination) {
					sql = sql.concat(FirstnamesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Firstnames>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Firstnames>(list);
				}
				else {
					list = (List<Firstnames>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the firstnameses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Firstnames firstnames : findAll()) {
			remove(firstnames);
		}
	}

	/**
	 * Returns the number of firstnameses.
	 *
	 * @return the number of firstnameses
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

				Query q = session.createQuery(_SQL_COUNT_FIRSTNAMES);

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
	 * Initializes the firstnames persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.permission.servicebuider.model.Firstnames")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Firstnames>> listenersList = new ArrayList<ModelListener<Firstnames>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Firstnames>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FirstnamesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FIRSTNAMES = "SELECT firstnames FROM Firstnames firstnames";
	private static final String _SQL_SELECT_FIRSTNAMES_WHERE = "SELECT firstnames FROM Firstnames firstnames WHERE ";
	private static final String _SQL_COUNT_FIRSTNAMES = "SELECT COUNT(firstnames) FROM Firstnames firstnames";
	private static final String _SQL_COUNT_FIRSTNAMES_WHERE = "SELECT COUNT(firstnames) FROM Firstnames firstnames WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "firstnames.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Firstnames exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Firstnames exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FirstnamesPersistenceImpl.class);
	private static Firstnames _nullFirstnames = new FirstnamesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Firstnames> toCacheModel() {
				return _nullFirstnamesCacheModel;
			}
		};

	private static CacheModel<Firstnames> _nullFirstnamesCacheModel = new CacheModel<Firstnames>() {
			@Override
			public Firstnames toEntityModel() {
				return _nullFirstnames;
			}
		};
}