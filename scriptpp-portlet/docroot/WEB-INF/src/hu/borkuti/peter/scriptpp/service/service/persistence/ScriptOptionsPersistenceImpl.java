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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException;
import hu.borkuti.peter.scriptpp.service.model.ScriptOptions;
import hu.borkuti.peter.scriptpp.service.model.impl.ScriptOptionsImpl;
import hu.borkuti.peter.scriptpp.service.model.impl.ScriptOptionsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the script options service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Peter Borkuti
 * @see ScriptOptionsPersistence
 * @see ScriptOptionsUtil
 * @generated
 */
public class ScriptOptionsPersistenceImpl extends BasePersistenceImpl<ScriptOptions>
	implements ScriptOptionsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ScriptOptionsUtil} to access the script options persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ScriptOptionsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ScriptOptionsModelImpl.ENTITY_CACHE_ENABLED,
			ScriptOptionsModelImpl.FINDER_CACHE_ENABLED,
			ScriptOptionsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ScriptOptionsModelImpl.ENTITY_CACHE_ENABLED,
			ScriptOptionsModelImpl.FINDER_CACHE_ENABLED,
			ScriptOptionsImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ScriptOptionsModelImpl.ENTITY_CACHE_ENABLED,
			ScriptOptionsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_U = new FinderPath(ScriptOptionsModelImpl.ENTITY_CACHE_ENABLED,
			ScriptOptionsModelImpl.FINDER_CACHE_ENABLED,
			ScriptOptionsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByG_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U = new FinderPath(ScriptOptionsModelImpl.ENTITY_CACHE_ENABLED,
			ScriptOptionsModelImpl.FINDER_CACHE_ENABLED,
			ScriptOptionsImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByG_U",
			new String[] { Long.class.getName(), Long.class.getName() },
			ScriptOptionsModelImpl.GROUPID_COLUMN_BITMASK |
			ScriptOptionsModelImpl.USERID_COLUMN_BITMASK |
			ScriptOptionsModelImpl.SCRIPTNAME_COLUMN_BITMASK |
			ScriptOptionsModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_U = new FinderPath(ScriptOptionsModelImpl.ENTITY_CACHE_ENABLED,
			ScriptOptionsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_U",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the script optionses where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching script optionses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScriptOptions> findByG_U(long groupId, long userId)
		throws SystemException {
		return findByG_U(groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the script optionses where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptOptionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of script optionses
	 * @param end the upper bound of the range of script optionses (not inclusive)
	 * @return the range of matching script optionses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScriptOptions> findByG_U(long groupId, long userId, int start,
		int end) throws SystemException {
		return findByG_U(groupId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the script optionses where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptOptionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of script optionses
	 * @param end the upper bound of the range of script optionses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching script optionses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScriptOptions> findByG_U(long groupId, long userId, int start,
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

		List<ScriptOptions> list = (List<ScriptOptions>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScriptOptions scriptOptions : list) {
				if ((groupId != scriptOptions.getGroupId()) ||
						(userId != scriptOptions.getUserId())) {
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

			query.append(_SQL_SELECT_SCRIPTOPTIONS_WHERE);

			query.append(_FINDER_COLUMN_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_G_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScriptOptionsModelImpl.ORDER_BY_JPQL);
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
					list = (List<ScriptOptions>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScriptOptions>(list);
				}
				else {
					list = (List<ScriptOptions>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first script options in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching script options
	 * @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException if a matching script options could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScriptOptions findByG_U_First(long groupId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchScriptOptionsException, SystemException {
		ScriptOptions scriptOptions = fetchByG_U_First(groupId, userId,
				orderByComparator);

		if (scriptOptions != null) {
			return scriptOptions;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScriptOptionsException(msg.toString());
	}

	/**
	 * Returns the first script options in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching script options, or <code>null</code> if a matching script options could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScriptOptions fetchByG_U_First(long groupId, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ScriptOptions> list = findByG_U(groupId, userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last script options in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching script options
	 * @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException if a matching script options could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScriptOptions findByG_U_Last(long groupId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchScriptOptionsException, SystemException {
		ScriptOptions scriptOptions = fetchByG_U_Last(groupId, userId,
				orderByComparator);

		if (scriptOptions != null) {
			return scriptOptions;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScriptOptionsException(msg.toString());
	}

	/**
	 * Returns the last script options in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching script options, or <code>null</code> if a matching script options could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScriptOptions fetchByG_U_Last(long groupId, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_U(groupId, userId);

		if (count == 0) {
			return null;
		}

		List<ScriptOptions> list = findByG_U(groupId, userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the script optionses before and after the current script options in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param ScriptOptionsId the primary key of the current script options
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next script options
	 * @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException if a script options with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScriptOptions[] findByG_U_PrevAndNext(long ScriptOptionsId,
		long groupId, long userId, OrderByComparator orderByComparator)
		throws NoSuchScriptOptionsException, SystemException {
		ScriptOptions scriptOptions = findByPrimaryKey(ScriptOptionsId);

		Session session = null;

		try {
			session = openSession();

			ScriptOptions[] array = new ScriptOptionsImpl[3];

			array[0] = getByG_U_PrevAndNext(session, scriptOptions, groupId,
					userId, orderByComparator, true);

			array[1] = scriptOptions;

			array[2] = getByG_U_PrevAndNext(session, scriptOptions, groupId,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScriptOptions getByG_U_PrevAndNext(Session session,
		ScriptOptions scriptOptions, long groupId, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCRIPTOPTIONS_WHERE);

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
			query.append(ScriptOptionsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scriptOptions);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScriptOptions> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the script optionses where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_U(long groupId, long userId)
		throws SystemException {
		for (ScriptOptions scriptOptions : findByG_U(groupId, userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scriptOptions);
		}
	}

	/**
	 * Returns the number of script optionses where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching script optionses
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

			query.append(_SQL_COUNT_SCRIPTOPTIONS_WHERE);

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

	private static final String _FINDER_COLUMN_G_U_GROUPID_2 = "scriptOptions.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_U_USERID_2 = "scriptOptions.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_U_SCRIPTNAME =
		new FinderPath(ScriptOptionsModelImpl.ENTITY_CACHE_ENABLED,
			ScriptOptionsModelImpl.FINDER_CACHE_ENABLED,
			ScriptOptionsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByG_U_ScriptName",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U_SCRIPTNAME =
		new FinderPath(ScriptOptionsModelImpl.ENTITY_CACHE_ENABLED,
			ScriptOptionsModelImpl.FINDER_CACHE_ENABLED,
			ScriptOptionsImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByG_U_ScriptName",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			ScriptOptionsModelImpl.GROUPID_COLUMN_BITMASK |
			ScriptOptionsModelImpl.USERID_COLUMN_BITMASK |
			ScriptOptionsModelImpl.SCRIPTNAME_COLUMN_BITMASK |
			ScriptOptionsModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_U_SCRIPTNAME = new FinderPath(ScriptOptionsModelImpl.ENTITY_CACHE_ENABLED,
			ScriptOptionsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_U_ScriptName",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the script optionses where groupId = &#63; and userId = &#63; and scriptName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param scriptName the script name
	 * @return the matching script optionses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScriptOptions> findByG_U_ScriptName(long groupId, long userId,
		String scriptName) throws SystemException {
		return findByG_U_ScriptName(groupId, userId, scriptName,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the script optionses where groupId = &#63; and userId = &#63; and scriptName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptOptionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param scriptName the script name
	 * @param start the lower bound of the range of script optionses
	 * @param end the upper bound of the range of script optionses (not inclusive)
	 * @return the range of matching script optionses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScriptOptions> findByG_U_ScriptName(long groupId, long userId,
		String scriptName, int start, int end) throws SystemException {
		return findByG_U_ScriptName(groupId, userId, scriptName, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the script optionses where groupId = &#63; and userId = &#63; and scriptName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptOptionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param scriptName the script name
	 * @param start the lower bound of the range of script optionses
	 * @param end the upper bound of the range of script optionses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching script optionses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScriptOptions> findByG_U_ScriptName(long groupId, long userId,
		String scriptName, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U_SCRIPTNAME;
			finderArgs = new Object[] { groupId, userId, scriptName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_U_SCRIPTNAME;
			finderArgs = new Object[] {
					groupId, userId, scriptName,
					
					start, end, orderByComparator
				};
		}

		List<ScriptOptions> list = (List<ScriptOptions>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScriptOptions scriptOptions : list) {
				if ((groupId != scriptOptions.getGroupId()) ||
						(userId != scriptOptions.getUserId()) ||
						!Validator.equals(scriptName,
							scriptOptions.getScriptName())) {
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

			query.append(_SQL_SELECT_SCRIPTOPTIONS_WHERE);

			query.append(_FINDER_COLUMN_G_U_SCRIPTNAME_GROUPID_2);

			query.append(_FINDER_COLUMN_G_U_SCRIPTNAME_USERID_2);

			boolean bindScriptName = false;

			if (scriptName == null) {
				query.append(_FINDER_COLUMN_G_U_SCRIPTNAME_SCRIPTNAME_1);
			}
			else if (scriptName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_U_SCRIPTNAME_SCRIPTNAME_3);
			}
			else {
				bindScriptName = true;

				query.append(_FINDER_COLUMN_G_U_SCRIPTNAME_SCRIPTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScriptOptionsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				if (bindScriptName) {
					qPos.add(scriptName);
				}

				if (!pagination) {
					list = (List<ScriptOptions>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScriptOptions>(list);
				}
				else {
					list = (List<ScriptOptions>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first script options in the ordered set where groupId = &#63; and userId = &#63; and scriptName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param scriptName the script name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching script options
	 * @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException if a matching script options could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScriptOptions findByG_U_ScriptName_First(long groupId, long userId,
		String scriptName, OrderByComparator orderByComparator)
		throws NoSuchScriptOptionsException, SystemException {
		ScriptOptions scriptOptions = fetchByG_U_ScriptName_First(groupId,
				userId, scriptName, orderByComparator);

		if (scriptOptions != null) {
			return scriptOptions;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", scriptName=");
		msg.append(scriptName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScriptOptionsException(msg.toString());
	}

	/**
	 * Returns the first script options in the ordered set where groupId = &#63; and userId = &#63; and scriptName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param scriptName the script name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching script options, or <code>null</code> if a matching script options could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScriptOptions fetchByG_U_ScriptName_First(long groupId, long userId,
		String scriptName, OrderByComparator orderByComparator)
		throws SystemException {
		List<ScriptOptions> list = findByG_U_ScriptName(groupId, userId,
				scriptName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last script options in the ordered set where groupId = &#63; and userId = &#63; and scriptName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param scriptName the script name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching script options
	 * @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException if a matching script options could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScriptOptions findByG_U_ScriptName_Last(long groupId, long userId,
		String scriptName, OrderByComparator orderByComparator)
		throws NoSuchScriptOptionsException, SystemException {
		ScriptOptions scriptOptions = fetchByG_U_ScriptName_Last(groupId,
				userId, scriptName, orderByComparator);

		if (scriptOptions != null) {
			return scriptOptions;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", scriptName=");
		msg.append(scriptName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScriptOptionsException(msg.toString());
	}

	/**
	 * Returns the last script options in the ordered set where groupId = &#63; and userId = &#63; and scriptName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param scriptName the script name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching script options, or <code>null</code> if a matching script options could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScriptOptions fetchByG_U_ScriptName_Last(long groupId, long userId,
		String scriptName, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_U_ScriptName(groupId, userId, scriptName);

		if (count == 0) {
			return null;
		}

		List<ScriptOptions> list = findByG_U_ScriptName(groupId, userId,
				scriptName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the script optionses before and after the current script options in the ordered set where groupId = &#63; and userId = &#63; and scriptName = &#63;.
	 *
	 * @param ScriptOptionsId the primary key of the current script options
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param scriptName the script name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next script options
	 * @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException if a script options with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScriptOptions[] findByG_U_ScriptName_PrevAndNext(
		long ScriptOptionsId, long groupId, long userId, String scriptName,
		OrderByComparator orderByComparator)
		throws NoSuchScriptOptionsException, SystemException {
		ScriptOptions scriptOptions = findByPrimaryKey(ScriptOptionsId);

		Session session = null;

		try {
			session = openSession();

			ScriptOptions[] array = new ScriptOptionsImpl[3];

			array[0] = getByG_U_ScriptName_PrevAndNext(session, scriptOptions,
					groupId, userId, scriptName, orderByComparator, true);

			array[1] = scriptOptions;

			array[2] = getByG_U_ScriptName_PrevAndNext(session, scriptOptions,
					groupId, userId, scriptName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScriptOptions getByG_U_ScriptName_PrevAndNext(Session session,
		ScriptOptions scriptOptions, long groupId, long userId,
		String scriptName, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCRIPTOPTIONS_WHERE);

		query.append(_FINDER_COLUMN_G_U_SCRIPTNAME_GROUPID_2);

		query.append(_FINDER_COLUMN_G_U_SCRIPTNAME_USERID_2);

		boolean bindScriptName = false;

		if (scriptName == null) {
			query.append(_FINDER_COLUMN_G_U_SCRIPTNAME_SCRIPTNAME_1);
		}
		else if (scriptName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_U_SCRIPTNAME_SCRIPTNAME_3);
		}
		else {
			bindScriptName = true;

			query.append(_FINDER_COLUMN_G_U_SCRIPTNAME_SCRIPTNAME_2);
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
			query.append(ScriptOptionsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(userId);

		if (bindScriptName) {
			qPos.add(scriptName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scriptOptions);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScriptOptions> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the script optionses where groupId = &#63; and userId = &#63; and scriptName = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param scriptName the script name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_U_ScriptName(long groupId, long userId,
		String scriptName) throws SystemException {
		for (ScriptOptions scriptOptions : findByG_U_ScriptName(groupId,
				userId, scriptName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scriptOptions);
		}
	}

	/**
	 * Returns the number of script optionses where groupId = &#63; and userId = &#63; and scriptName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param scriptName the script name
	 * @return the number of matching script optionses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_U_ScriptName(long groupId, long userId,
		String scriptName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_U_SCRIPTNAME;

		Object[] finderArgs = new Object[] { groupId, userId, scriptName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SCRIPTOPTIONS_WHERE);

			query.append(_FINDER_COLUMN_G_U_SCRIPTNAME_GROUPID_2);

			query.append(_FINDER_COLUMN_G_U_SCRIPTNAME_USERID_2);

			boolean bindScriptName = false;

			if (scriptName == null) {
				query.append(_FINDER_COLUMN_G_U_SCRIPTNAME_SCRIPTNAME_1);
			}
			else if (scriptName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_U_SCRIPTNAME_SCRIPTNAME_3);
			}
			else {
				bindScriptName = true;

				query.append(_FINDER_COLUMN_G_U_SCRIPTNAME_SCRIPTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				if (bindScriptName) {
					qPos.add(scriptName);
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

	private static final String _FINDER_COLUMN_G_U_SCRIPTNAME_GROUPID_2 = "scriptOptions.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_U_SCRIPTNAME_USERID_2 = "scriptOptions.userId = ? AND ";
	private static final String _FINDER_COLUMN_G_U_SCRIPTNAME_SCRIPTNAME_1 = "scriptOptions.scriptName IS NULL";
	private static final String _FINDER_COLUMN_G_U_SCRIPTNAME_SCRIPTNAME_2 = "scriptOptions.scriptName = ?";
	private static final String _FINDER_COLUMN_G_U_SCRIPTNAME_SCRIPTNAME_3 = "(scriptOptions.scriptName IS NULL OR scriptOptions.scriptName = '')";

	public ScriptOptionsPersistenceImpl() {
		setModelClass(ScriptOptions.class);
	}

	/**
	 * Caches the script options in the entity cache if it is enabled.
	 *
	 * @param scriptOptions the script options
	 */
	@Override
	public void cacheResult(ScriptOptions scriptOptions) {
		EntityCacheUtil.putResult(ScriptOptionsModelImpl.ENTITY_CACHE_ENABLED,
			ScriptOptionsImpl.class, scriptOptions.getPrimaryKey(),
			scriptOptions);

		scriptOptions.resetOriginalValues();
	}

	/**
	 * Caches the script optionses in the entity cache if it is enabled.
	 *
	 * @param scriptOptionses the script optionses
	 */
	@Override
	public void cacheResult(List<ScriptOptions> scriptOptionses) {
		for (ScriptOptions scriptOptions : scriptOptionses) {
			if (EntityCacheUtil.getResult(
						ScriptOptionsModelImpl.ENTITY_CACHE_ENABLED,
						ScriptOptionsImpl.class, scriptOptions.getPrimaryKey()) == null) {
				cacheResult(scriptOptions);
			}
			else {
				scriptOptions.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all script optionses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ScriptOptionsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ScriptOptionsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the script options.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ScriptOptions scriptOptions) {
		EntityCacheUtil.removeResult(ScriptOptionsModelImpl.ENTITY_CACHE_ENABLED,
			ScriptOptionsImpl.class, scriptOptions.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ScriptOptions> scriptOptionses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ScriptOptions scriptOptions : scriptOptionses) {
			EntityCacheUtil.removeResult(ScriptOptionsModelImpl.ENTITY_CACHE_ENABLED,
				ScriptOptionsImpl.class, scriptOptions.getPrimaryKey());
		}
	}

	/**
	 * Creates a new script options with the primary key. Does not add the script options to the database.
	 *
	 * @param ScriptOptionsId the primary key for the new script options
	 * @return the new script options
	 */
	@Override
	public ScriptOptions create(long ScriptOptionsId) {
		ScriptOptions scriptOptions = new ScriptOptionsImpl();

		scriptOptions.setNew(true);
		scriptOptions.setPrimaryKey(ScriptOptionsId);

		return scriptOptions;
	}

	/**
	 * Removes the script options with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ScriptOptionsId the primary key of the script options
	 * @return the script options that was removed
	 * @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException if a script options with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScriptOptions remove(long ScriptOptionsId)
		throws NoSuchScriptOptionsException, SystemException {
		return remove((Serializable)ScriptOptionsId);
	}

	/**
	 * Removes the script options with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the script options
	 * @return the script options that was removed
	 * @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException if a script options with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScriptOptions remove(Serializable primaryKey)
		throws NoSuchScriptOptionsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ScriptOptions scriptOptions = (ScriptOptions)session.get(ScriptOptionsImpl.class,
					primaryKey);

			if (scriptOptions == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchScriptOptionsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(scriptOptions);
		}
		catch (NoSuchScriptOptionsException nsee) {
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
	protected ScriptOptions removeImpl(ScriptOptions scriptOptions)
		throws SystemException {
		scriptOptions = toUnwrappedModel(scriptOptions);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(scriptOptions)) {
				scriptOptions = (ScriptOptions)session.get(ScriptOptionsImpl.class,
						scriptOptions.getPrimaryKeyObj());
			}

			if (scriptOptions != null) {
				session.delete(scriptOptions);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (scriptOptions != null) {
			clearCache(scriptOptions);
		}

		return scriptOptions;
	}

	@Override
	public ScriptOptions updateImpl(
		hu.borkuti.peter.scriptpp.service.model.ScriptOptions scriptOptions)
		throws SystemException {
		scriptOptions = toUnwrappedModel(scriptOptions);

		boolean isNew = scriptOptions.isNew();

		ScriptOptionsModelImpl scriptOptionsModelImpl = (ScriptOptionsModelImpl)scriptOptions;

		Session session = null;

		try {
			session = openSession();

			if (scriptOptions.isNew()) {
				session.save(scriptOptions);

				scriptOptions.setNew(false);
			}
			else {
				session.merge(scriptOptions);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ScriptOptionsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((scriptOptionsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scriptOptionsModelImpl.getOriginalGroupId(),
						scriptOptionsModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U,
					args);

				args = new Object[] {
						scriptOptionsModelImpl.getGroupId(),
						scriptOptionsModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U,
					args);
			}

			if ((scriptOptionsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U_SCRIPTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scriptOptionsModelImpl.getOriginalGroupId(),
						scriptOptionsModelImpl.getOriginalUserId(),
						scriptOptionsModelImpl.getOriginalScriptName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_U_SCRIPTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U_SCRIPTNAME,
					args);

				args = new Object[] {
						scriptOptionsModelImpl.getGroupId(),
						scriptOptionsModelImpl.getUserId(),
						scriptOptionsModelImpl.getScriptName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_U_SCRIPTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U_SCRIPTNAME,
					args);
			}
		}

		EntityCacheUtil.putResult(ScriptOptionsModelImpl.ENTITY_CACHE_ENABLED,
			ScriptOptionsImpl.class, scriptOptions.getPrimaryKey(),
			scriptOptions);

		return scriptOptions;
	}

	protected ScriptOptions toUnwrappedModel(ScriptOptions scriptOptions) {
		if (scriptOptions instanceof ScriptOptionsImpl) {
			return scriptOptions;
		}

		ScriptOptionsImpl scriptOptionsImpl = new ScriptOptionsImpl();

		scriptOptionsImpl.setNew(scriptOptions.isNew());
		scriptOptionsImpl.setPrimaryKey(scriptOptions.getPrimaryKey());

		scriptOptionsImpl.setScriptOptionsId(scriptOptions.getScriptOptionsId());
		scriptOptionsImpl.setCompanyId(scriptOptions.getCompanyId());
		scriptOptionsImpl.setGroupId(scriptOptions.getGroupId());
		scriptOptionsImpl.setUserId(scriptOptions.getUserId());
		scriptOptionsImpl.setCreateDate(scriptOptions.getCreateDate());
		scriptOptionsImpl.setModifiedDate(scriptOptions.getModifiedDate());
		scriptOptionsImpl.setScriptName(scriptOptions.getScriptName());
		scriptOptionsImpl.setDependencyList(scriptOptions.getDependencyList());
		scriptOptionsImpl.setScriptCounter(scriptOptions.getScriptCounter());

		return scriptOptionsImpl;
	}

	/**
	 * Returns the script options with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the script options
	 * @return the script options
	 * @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException if a script options with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScriptOptions findByPrimaryKey(Serializable primaryKey)
		throws NoSuchScriptOptionsException, SystemException {
		ScriptOptions scriptOptions = fetchByPrimaryKey(primaryKey);

		if (scriptOptions == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchScriptOptionsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return scriptOptions;
	}

	/**
	 * Returns the script options with the primary key or throws a {@link hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException} if it could not be found.
	 *
	 * @param ScriptOptionsId the primary key of the script options
	 * @return the script options
	 * @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException if a script options with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScriptOptions findByPrimaryKey(long ScriptOptionsId)
		throws NoSuchScriptOptionsException, SystemException {
		return findByPrimaryKey((Serializable)ScriptOptionsId);
	}

	/**
	 * Returns the script options with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the script options
	 * @return the script options, or <code>null</code> if a script options with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScriptOptions fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ScriptOptions scriptOptions = (ScriptOptions)EntityCacheUtil.getResult(ScriptOptionsModelImpl.ENTITY_CACHE_ENABLED,
				ScriptOptionsImpl.class, primaryKey);

		if (scriptOptions == _nullScriptOptions) {
			return null;
		}

		if (scriptOptions == null) {
			Session session = null;

			try {
				session = openSession();

				scriptOptions = (ScriptOptions)session.get(ScriptOptionsImpl.class,
						primaryKey);

				if (scriptOptions != null) {
					cacheResult(scriptOptions);
				}
				else {
					EntityCacheUtil.putResult(ScriptOptionsModelImpl.ENTITY_CACHE_ENABLED,
						ScriptOptionsImpl.class, primaryKey, _nullScriptOptions);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ScriptOptionsModelImpl.ENTITY_CACHE_ENABLED,
					ScriptOptionsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return scriptOptions;
	}

	/**
	 * Returns the script options with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ScriptOptionsId the primary key of the script options
	 * @return the script options, or <code>null</code> if a script options with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScriptOptions fetchByPrimaryKey(long ScriptOptionsId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)ScriptOptionsId);
	}

	/**
	 * Returns all the script optionses.
	 *
	 * @return the script optionses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScriptOptions> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the script optionses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptOptionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of script optionses
	 * @param end the upper bound of the range of script optionses (not inclusive)
	 * @return the range of script optionses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScriptOptions> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the script optionses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptOptionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of script optionses
	 * @param end the upper bound of the range of script optionses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of script optionses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScriptOptions> findAll(int start, int end,
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

		List<ScriptOptions> list = (List<ScriptOptions>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SCRIPTOPTIONS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SCRIPTOPTIONS;

				if (pagination) {
					sql = sql.concat(ScriptOptionsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ScriptOptions>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScriptOptions>(list);
				}
				else {
					list = (List<ScriptOptions>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the script optionses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ScriptOptions scriptOptions : findAll()) {
			remove(scriptOptions);
		}
	}

	/**
	 * Returns the number of script optionses.
	 *
	 * @return the number of script optionses
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

				Query q = session.createQuery(_SQL_COUNT_SCRIPTOPTIONS);

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
	 * Initializes the script options persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.hu.borkuti.peter.scriptpp.service.model.ScriptOptions")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ScriptOptions>> listenersList = new ArrayList<ModelListener<ScriptOptions>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ScriptOptions>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ScriptOptionsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SCRIPTOPTIONS = "SELECT scriptOptions FROM ScriptOptions scriptOptions";
	private static final String _SQL_SELECT_SCRIPTOPTIONS_WHERE = "SELECT scriptOptions FROM ScriptOptions scriptOptions WHERE ";
	private static final String _SQL_COUNT_SCRIPTOPTIONS = "SELECT COUNT(scriptOptions) FROM ScriptOptions scriptOptions";
	private static final String _SQL_COUNT_SCRIPTOPTIONS_WHERE = "SELECT COUNT(scriptOptions) FROM ScriptOptions scriptOptions WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "scriptOptions.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ScriptOptions exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ScriptOptions exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ScriptOptionsPersistenceImpl.class);
	private static ScriptOptions _nullScriptOptions = new ScriptOptionsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ScriptOptions> toCacheModel() {
				return _nullScriptOptionsCacheModel;
			}
		};

	private static CacheModel<ScriptOptions> _nullScriptOptionsCacheModel = new CacheModel<ScriptOptions>() {
			@Override
			public ScriptOptions toEntityModel() {
				return _nullScriptOptions;
			}
		};
}