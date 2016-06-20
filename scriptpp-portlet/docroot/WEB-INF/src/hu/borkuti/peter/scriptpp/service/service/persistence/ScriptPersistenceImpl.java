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

package hu.borkuti.peter.scriptpp.service.service.persistence;

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

import hu.borkuti.peter.scriptpp.service.NoSuchScriptException;
import hu.borkuti.peter.scriptpp.service.model.Script;
import hu.borkuti.peter.scriptpp.service.model.impl.ScriptImpl;
import hu.borkuti.peter.scriptpp.service.model.impl.ScriptModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the script service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Peter Borkuti
 * @see ScriptPersistence
 * @see ScriptUtil
 * @generated
 */
public class ScriptPersistenceImpl extends BasePersistenceImpl<Script>
	implements ScriptPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ScriptUtil} to access the script persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ScriptImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ScriptModelImpl.ENTITY_CACHE_ENABLED,
			ScriptModelImpl.FINDER_CACHE_ENABLED, ScriptImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ScriptModelImpl.ENTITY_CACHE_ENABLED,
			ScriptModelImpl.FINDER_CACHE_ENABLED, ScriptImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ScriptModelImpl.ENTITY_CACHE_ENABLED,
			ScriptModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_U_SOID = new FinderPath(ScriptModelImpl.ENTITY_CACHE_ENABLED,
			ScriptModelImpl.FINDER_CACHE_ENABLED, ScriptImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_U_SOid",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U_SOID =
		new FinderPath(ScriptModelImpl.ENTITY_CACHE_ENABLED,
			ScriptModelImpl.FINDER_CACHE_ENABLED, ScriptImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_U_SOid",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			ScriptModelImpl.GROUPID_COLUMN_BITMASK |
			ScriptModelImpl.USERID_COLUMN_BITMASK |
			ScriptModelImpl.SCRIPTOPTIONSID_COLUMN_BITMASK |
			ScriptModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_U_SOID = new FinderPath(ScriptModelImpl.ENTITY_CACHE_ENABLED,
			ScriptModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_U_SOid",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the scripts where groupId = &#63; and userId = &#63; and scriptOptionsId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param scriptOptionsId the script options ID
	 * @return the matching scripts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Script> findByG_U_SOid(long groupId, long userId,
		long scriptOptionsId) throws SystemException {
		return findByG_U_SOid(groupId, userId, scriptOptionsId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the scripts where groupId = &#63; and userId = &#63; and scriptOptionsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param scriptOptionsId the script options ID
	 * @param start the lower bound of the range of scripts
	 * @param end the upper bound of the range of scripts (not inclusive)
	 * @return the range of matching scripts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Script> findByG_U_SOid(long groupId, long userId,
		long scriptOptionsId, int start, int end) throws SystemException {
		return findByG_U_SOid(groupId, userId, scriptOptionsId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the scripts where groupId = &#63; and userId = &#63; and scriptOptionsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param scriptOptionsId the script options ID
	 * @param start the lower bound of the range of scripts
	 * @param end the upper bound of the range of scripts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching scripts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Script> findByG_U_SOid(long groupId, long userId,
		long scriptOptionsId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U_SOID;
			finderArgs = new Object[] { groupId, userId, scriptOptionsId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_U_SOID;
			finderArgs = new Object[] {
					groupId, userId, scriptOptionsId,
					
					start, end, orderByComparator
				};
		}

		List<Script> list = (List<Script>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Script script : list) {
				if ((groupId != script.getGroupId()) ||
						(userId != script.getUserId()) ||
						(scriptOptionsId != script.getScriptOptionsId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_SCRIPT_WHERE);

			query.append(_FINDER_COLUMN_G_U_SOID_GROUPID_2);

			query.append(_FINDER_COLUMN_G_U_SOID_USERID_2);

			query.append(_FINDER_COLUMN_G_U_SOID_SCRIPTOPTIONSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScriptModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				qPos.add(scriptOptionsId);

				if (!pagination) {
					list = (List<Script>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Script>(list);
				}
				else {
					list = (List<Script>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first script in the ordered set where groupId = &#63; and userId = &#63; and scriptOptionsId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param scriptOptionsId the script options ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching script
	 * @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptException if a matching script could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Script findByG_U_SOid_First(long groupId, long userId,
		long scriptOptionsId, OrderByComparator orderByComparator)
		throws NoSuchScriptException, SystemException {
		Script script = fetchByG_U_SOid_First(groupId, userId, scriptOptionsId,
				orderByComparator);

		if (script != null) {
			return script;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", scriptOptionsId=");
		msg.append(scriptOptionsId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScriptException(msg.toString());
	}

	/**
	 * Returns the first script in the ordered set where groupId = &#63; and userId = &#63; and scriptOptionsId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param scriptOptionsId the script options ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching script, or <code>null</code> if a matching script could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Script fetchByG_U_SOid_First(long groupId, long userId,
		long scriptOptionsId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Script> list = findByG_U_SOid(groupId, userId, scriptOptionsId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last script in the ordered set where groupId = &#63; and userId = &#63; and scriptOptionsId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param scriptOptionsId the script options ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching script
	 * @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptException if a matching script could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Script findByG_U_SOid_Last(long groupId, long userId,
		long scriptOptionsId, OrderByComparator orderByComparator)
		throws NoSuchScriptException, SystemException {
		Script script = fetchByG_U_SOid_Last(groupId, userId, scriptOptionsId,
				orderByComparator);

		if (script != null) {
			return script;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", scriptOptionsId=");
		msg.append(scriptOptionsId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScriptException(msg.toString());
	}

	/**
	 * Returns the last script in the ordered set where groupId = &#63; and userId = &#63; and scriptOptionsId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param scriptOptionsId the script options ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching script, or <code>null</code> if a matching script could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Script fetchByG_U_SOid_Last(long groupId, long userId,
		long scriptOptionsId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_U_SOid(groupId, userId, scriptOptionsId);

		if (count == 0) {
			return null;
		}

		List<Script> list = findByG_U_SOid(groupId, userId, scriptOptionsId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the scripts before and after the current script in the ordered set where groupId = &#63; and userId = &#63; and scriptOptionsId = &#63;.
	 *
	 * @param ScriptId the primary key of the current script
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param scriptOptionsId the script options ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next script
	 * @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptException if a script with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Script[] findByG_U_SOid_PrevAndNext(long ScriptId, long groupId,
		long userId, long scriptOptionsId, OrderByComparator orderByComparator)
		throws NoSuchScriptException, SystemException {
		Script script = findByPrimaryKey(ScriptId);

		Session session = null;

		try {
			session = openSession();

			Script[] array = new ScriptImpl[3];

			array[0] = getByG_U_SOid_PrevAndNext(session, script, groupId,
					userId, scriptOptionsId, orderByComparator, true);

			array[1] = script;

			array[2] = getByG_U_SOid_PrevAndNext(session, script, groupId,
					userId, scriptOptionsId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Script getByG_U_SOid_PrevAndNext(Session session, Script script,
		long groupId, long userId, long scriptOptionsId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCRIPT_WHERE);

		query.append(_FINDER_COLUMN_G_U_SOID_GROUPID_2);

		query.append(_FINDER_COLUMN_G_U_SOID_USERID_2);

		query.append(_FINDER_COLUMN_G_U_SOID_SCRIPTOPTIONSID_2);

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
			query.append(ScriptModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(userId);

		qPos.add(scriptOptionsId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(script);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Script> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the scripts where groupId = &#63; and userId = &#63; and scriptOptionsId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param scriptOptionsId the script options ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_U_SOid(long groupId, long userId, long scriptOptionsId)
		throws SystemException {
		for (Script script : findByG_U_SOid(groupId, userId, scriptOptionsId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(script);
		}
	}

	/**
	 * Returns the number of scripts where groupId = &#63; and userId = &#63; and scriptOptionsId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param scriptOptionsId the script options ID
	 * @return the number of matching scripts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_U_SOid(long groupId, long userId, long scriptOptionsId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_U_SOID;

		Object[] finderArgs = new Object[] { groupId, userId, scriptOptionsId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SCRIPT_WHERE);

			query.append(_FINDER_COLUMN_G_U_SOID_GROUPID_2);

			query.append(_FINDER_COLUMN_G_U_SOID_USERID_2);

			query.append(_FINDER_COLUMN_G_U_SOID_SCRIPTOPTIONSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				qPos.add(scriptOptionsId);

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

	private static final String _FINDER_COLUMN_G_U_SOID_GROUPID_2 = "script.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_U_SOID_USERID_2 = "script.userId = ? AND ";
	private static final String _FINDER_COLUMN_G_U_SOID_SCRIPTOPTIONSID_2 = "script.scriptOptionsId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_U = new FinderPath(ScriptModelImpl.ENTITY_CACHE_ENABLED,
			ScriptModelImpl.FINDER_CACHE_ENABLED, ScriptImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U = new FinderPath(ScriptModelImpl.ENTITY_CACHE_ENABLED,
			ScriptModelImpl.FINDER_CACHE_ENABLED, ScriptImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_U",
			new String[] { Long.class.getName(), Long.class.getName() },
			ScriptModelImpl.GROUPID_COLUMN_BITMASK |
			ScriptModelImpl.USERID_COLUMN_BITMASK |
			ScriptModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_U = new FinderPath(ScriptModelImpl.ENTITY_CACHE_ENABLED,
			ScriptModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_U",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the scripts where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching scripts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Script> findByG_U(long groupId, long userId)
		throws SystemException {
		return findByG_U(groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the scripts where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of scripts
	 * @param end the upper bound of the range of scripts (not inclusive)
	 * @return the range of matching scripts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Script> findByG_U(long groupId, long userId, int start, int end)
		throws SystemException {
		return findByG_U(groupId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the scripts where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of scripts
	 * @param end the upper bound of the range of scripts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching scripts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Script> findByG_U(long groupId, long userId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U;
			finderArgs = new Object[] { groupId, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_U;
			finderArgs = new Object[] {
					groupId, userId,
					
					start, end, orderByComparator
				};
		}

		List<Script> list = (List<Script>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Script script : list) {
				if ((groupId != script.getGroupId()) ||
						(userId != script.getUserId())) {
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

			query.append(_SQL_SELECT_SCRIPT_WHERE);

			query.append(_FINDER_COLUMN_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_G_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScriptModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Script>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Script>(list);
				}
				else {
					list = (List<Script>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first script in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching script
	 * @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptException if a matching script could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Script findByG_U_First(long groupId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchScriptException, SystemException {
		Script script = fetchByG_U_First(groupId, userId, orderByComparator);

		if (script != null) {
			return script;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScriptException(msg.toString());
	}

	/**
	 * Returns the first script in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching script, or <code>null</code> if a matching script could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Script fetchByG_U_First(long groupId, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Script> list = findByG_U(groupId, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last script in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching script
	 * @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptException if a matching script could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Script findByG_U_Last(long groupId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchScriptException, SystemException {
		Script script = fetchByG_U_Last(groupId, userId, orderByComparator);

		if (script != null) {
			return script;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScriptException(msg.toString());
	}

	/**
	 * Returns the last script in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching script, or <code>null</code> if a matching script could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Script fetchByG_U_Last(long groupId, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_U(groupId, userId);

		if (count == 0) {
			return null;
		}

		List<Script> list = findByG_U(groupId, userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the scripts before and after the current script in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param ScriptId the primary key of the current script
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next script
	 * @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptException if a script with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Script[] findByG_U_PrevAndNext(long ScriptId, long groupId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchScriptException, SystemException {
		Script script = findByPrimaryKey(ScriptId);

		Session session = null;

		try {
			session = openSession();

			Script[] array = new ScriptImpl[3];

			array[0] = getByG_U_PrevAndNext(session, script, groupId, userId,
					orderByComparator, true);

			array[1] = script;

			array[2] = getByG_U_PrevAndNext(session, script, groupId, userId,
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

	protected Script getByG_U_PrevAndNext(Session session, Script script,
		long groupId, long userId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCRIPT_WHERE);

		query.append(_FINDER_COLUMN_G_U_GROUPID_2);

		query.append(_FINDER_COLUMN_G_U_USERID_2);

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
			query.append(ScriptModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(script);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Script> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the scripts where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_U(long groupId, long userId)
		throws SystemException {
		for (Script script : findByG_U(groupId, userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(script);
		}
	}

	/**
	 * Returns the number of scripts where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching scripts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_U(long groupId, long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_U;

		Object[] finderArgs = new Object[] { groupId, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SCRIPT_WHERE);

			query.append(_FINDER_COLUMN_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_G_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_G_U_GROUPID_2 = "script.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_U_USERID_2 = "script.userId = ?";

	public ScriptPersistenceImpl() {
		setModelClass(Script.class);
	}

	/**
	 * Caches the script in the entity cache if it is enabled.
	 *
	 * @param script the script
	 */
	@Override
	public void cacheResult(Script script) {
		EntityCacheUtil.putResult(ScriptModelImpl.ENTITY_CACHE_ENABLED,
			ScriptImpl.class, script.getPrimaryKey(), script);

		script.resetOriginalValues();
	}

	/**
	 * Caches the scripts in the entity cache if it is enabled.
	 *
	 * @param scripts the scripts
	 */
	@Override
	public void cacheResult(List<Script> scripts) {
		for (Script script : scripts) {
			if (EntityCacheUtil.getResult(
						ScriptModelImpl.ENTITY_CACHE_ENABLED, ScriptImpl.class,
						script.getPrimaryKey()) == null) {
				cacheResult(script);
			}
			else {
				script.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all scripts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ScriptImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ScriptImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the script.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Script script) {
		EntityCacheUtil.removeResult(ScriptModelImpl.ENTITY_CACHE_ENABLED,
			ScriptImpl.class, script.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Script> scripts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Script script : scripts) {
			EntityCacheUtil.removeResult(ScriptModelImpl.ENTITY_CACHE_ENABLED,
				ScriptImpl.class, script.getPrimaryKey());
		}
	}

	/**
	 * Creates a new script with the primary key. Does not add the script to the database.
	 *
	 * @param ScriptId the primary key for the new script
	 * @return the new script
	 */
	@Override
	public Script create(long ScriptId) {
		Script script = new ScriptImpl();

		script.setNew(true);
		script.setPrimaryKey(ScriptId);

		return script;
	}

	/**
	 * Removes the script with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ScriptId the primary key of the script
	 * @return the script that was removed
	 * @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptException if a script with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Script remove(long ScriptId)
		throws NoSuchScriptException, SystemException {
		return remove((Serializable)ScriptId);
	}

	/**
	 * Removes the script with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the script
	 * @return the script that was removed
	 * @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptException if a script with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Script remove(Serializable primaryKey)
		throws NoSuchScriptException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Script script = (Script)session.get(ScriptImpl.class, primaryKey);

			if (script == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchScriptException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(script);
		}
		catch (NoSuchScriptException nsee) {
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
	protected Script removeImpl(Script script) throws SystemException {
		script = toUnwrappedModel(script);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(script)) {
				script = (Script)session.get(ScriptImpl.class,
						script.getPrimaryKeyObj());
			}

			if (script != null) {
				session.delete(script);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (script != null) {
			clearCache(script);
		}

		return script;
	}

	@Override
	public Script updateImpl(
		hu.borkuti.peter.scriptpp.service.model.Script script)
		throws SystemException {
		script = toUnwrappedModel(script);

		boolean isNew = script.isNew();

		ScriptModelImpl scriptModelImpl = (ScriptModelImpl)script;

		Session session = null;

		try {
			session = openSession();

			if (script.isNew()) {
				session.save(script);

				script.setNew(false);
			}
			else {
				session.merge(script);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ScriptModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((scriptModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U_SOID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scriptModelImpl.getOriginalGroupId(),
						scriptModelImpl.getOriginalUserId(),
						scriptModelImpl.getOriginalScriptOptionsId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_U_SOID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U_SOID,
					args);

				args = new Object[] {
						scriptModelImpl.getGroupId(),
						scriptModelImpl.getUserId(),
						scriptModelImpl.getScriptOptionsId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_U_SOID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U_SOID,
					args);
			}

			if ((scriptModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scriptModelImpl.getOriginalGroupId(),
						scriptModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U,
					args);

				args = new Object[] {
						scriptModelImpl.getGroupId(),
						scriptModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U,
					args);
			}
		}

		EntityCacheUtil.putResult(ScriptModelImpl.ENTITY_CACHE_ENABLED,
			ScriptImpl.class, script.getPrimaryKey(), script);

		return script;
	}

	protected Script toUnwrappedModel(Script script) {
		if (script instanceof ScriptImpl) {
			return script;
		}

		ScriptImpl scriptImpl = new ScriptImpl();

		scriptImpl.setNew(script.isNew());
		scriptImpl.setPrimaryKey(script.getPrimaryKey());

		scriptImpl.setScriptId(script.getScriptId());
		scriptImpl.setCompanyId(script.getCompanyId());
		scriptImpl.setGroupId(script.getGroupId());
		scriptImpl.setUserId(script.getUserId());
		scriptImpl.setCreateDate(script.getCreateDate());
		scriptImpl.setModifiedDate(script.getModifiedDate());
		scriptImpl.setScriptOptionsId(script.getScriptOptionsId());
		scriptImpl.setImportContent(script.getImportContent());
		scriptImpl.setModuleContent(script.getModuleContent());

		return scriptImpl;
	}

	/**
	 * Returns the script with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the script
	 * @return the script
	 * @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptException if a script with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Script findByPrimaryKey(Serializable primaryKey)
		throws NoSuchScriptException, SystemException {
		Script script = fetchByPrimaryKey(primaryKey);

		if (script == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchScriptException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return script;
	}

	/**
	 * Returns the script with the primary key or throws a {@link hu.borkuti.peter.scriptpp.service.NoSuchScriptException} if it could not be found.
	 *
	 * @param ScriptId the primary key of the script
	 * @return the script
	 * @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptException if a script with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Script findByPrimaryKey(long ScriptId)
		throws NoSuchScriptException, SystemException {
		return findByPrimaryKey((Serializable)ScriptId);
	}

	/**
	 * Returns the script with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the script
	 * @return the script, or <code>null</code> if a script with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Script fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Script script = (Script)EntityCacheUtil.getResult(ScriptModelImpl.ENTITY_CACHE_ENABLED,
				ScriptImpl.class, primaryKey);

		if (script == _nullScript) {
			return null;
		}

		if (script == null) {
			Session session = null;

			try {
				session = openSession();

				script = (Script)session.get(ScriptImpl.class, primaryKey);

				if (script != null) {
					cacheResult(script);
				}
				else {
					EntityCacheUtil.putResult(ScriptModelImpl.ENTITY_CACHE_ENABLED,
						ScriptImpl.class, primaryKey, _nullScript);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ScriptModelImpl.ENTITY_CACHE_ENABLED,
					ScriptImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return script;
	}

	/**
	 * Returns the script with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ScriptId the primary key of the script
	 * @return the script, or <code>null</code> if a script with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Script fetchByPrimaryKey(long ScriptId) throws SystemException {
		return fetchByPrimaryKey((Serializable)ScriptId);
	}

	/**
	 * Returns all the scripts.
	 *
	 * @return the scripts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Script> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the scripts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of scripts
	 * @param end the upper bound of the range of scripts (not inclusive)
	 * @return the range of scripts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Script> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the scripts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of scripts
	 * @param end the upper bound of the range of scripts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of scripts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Script> findAll(int start, int end,
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

		List<Script> list = (List<Script>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SCRIPT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SCRIPT;

				if (pagination) {
					sql = sql.concat(ScriptModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Script>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Script>(list);
				}
				else {
					list = (List<Script>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the scripts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Script script : findAll()) {
			remove(script);
		}
	}

	/**
	 * Returns the number of scripts.
	 *
	 * @return the number of scripts
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

				Query q = session.createQuery(_SQL_COUNT_SCRIPT);

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
	 * Initializes the script persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.hu.borkuti.peter.scriptpp.service.model.Script")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Script>> listenersList = new ArrayList<ModelListener<Script>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Script>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ScriptImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SCRIPT = "SELECT script FROM Script script";
	private static final String _SQL_SELECT_SCRIPT_WHERE = "SELECT script FROM Script script WHERE ";
	private static final String _SQL_COUNT_SCRIPT = "SELECT COUNT(script) FROM Script script";
	private static final String _SQL_COUNT_SCRIPT_WHERE = "SELECT COUNT(script) FROM Script script WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "script.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Script exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Script exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ScriptPersistenceImpl.class);
	private static Script _nullScript = new ScriptImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Script> toCacheModel() {
				return _nullScriptCacheModel;
			}
		};

	private static CacheModel<Script> _nullScriptCacheModel = new CacheModel<Script>() {
			@Override
			public Script toEntityModel() {
				return _nullScript;
			}
		};
}