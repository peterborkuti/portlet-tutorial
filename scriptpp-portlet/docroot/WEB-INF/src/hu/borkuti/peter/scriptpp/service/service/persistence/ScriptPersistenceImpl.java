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

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
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
	private static final String _SQL_COUNT_SCRIPT = "SELECT COUNT(script) FROM Script script";
	private static final String _ORDER_BY_ENTITY_ALIAS = "script.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Script exists with the primary key ";
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