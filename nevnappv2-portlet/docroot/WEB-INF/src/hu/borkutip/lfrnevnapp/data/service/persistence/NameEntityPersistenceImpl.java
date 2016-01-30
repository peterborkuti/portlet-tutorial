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

import hu.borkutip.lfrnevnapp.data.NoSuchNameEntityException;
import hu.borkutip.lfrnevnapp.data.model.NameEntity;
import hu.borkutip.lfrnevnapp.data.model.impl.NameEntityImpl;
import hu.borkutip.lfrnevnapp.data.model.impl.NameEntityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the name entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Péter Borkuti
 * @see NameEntityPersistence
 * @see NameEntityUtil
 * @generated
 */
public class NameEntityPersistenceImpl extends BasePersistenceImpl<NameEntity>
	implements NameEntityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NameEntityUtil} to access the name entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NameEntityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NameEntityModelImpl.ENTITY_CACHE_ENABLED,
			NameEntityModelImpl.FINDER_CACHE_ENABLED, NameEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NameEntityModelImpl.ENTITY_CACHE_ENABLED,
			NameEntityModelImpl.FINDER_CACHE_ENABLED, NameEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NameEntityModelImpl.ENTITY_CACHE_ENABLED,
			NameEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public NameEntityPersistenceImpl() {
		setModelClass(NameEntity.class);
	}

	/**
	 * Caches the name entity in the entity cache if it is enabled.
	 *
	 * @param nameEntity the name entity
	 */
	@Override
	public void cacheResult(NameEntity nameEntity) {
		EntityCacheUtil.putResult(NameEntityModelImpl.ENTITY_CACHE_ENABLED,
			NameEntityImpl.class, nameEntity.getPrimaryKey(), nameEntity);

		nameEntity.resetOriginalValues();
	}

	/**
	 * Caches the name entities in the entity cache if it is enabled.
	 *
	 * @param nameEntities the name entities
	 */
	@Override
	public void cacheResult(List<NameEntity> nameEntities) {
		for (NameEntity nameEntity : nameEntities) {
			if (EntityCacheUtil.getResult(
						NameEntityModelImpl.ENTITY_CACHE_ENABLED,
						NameEntityImpl.class, nameEntity.getPrimaryKey()) == null) {
				cacheResult(nameEntity);
			}
			else {
				nameEntity.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all name entities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NameEntityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NameEntityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the name entity.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NameEntity nameEntity) {
		EntityCacheUtil.removeResult(NameEntityModelImpl.ENTITY_CACHE_ENABLED,
			NameEntityImpl.class, nameEntity.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<NameEntity> nameEntities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (NameEntity nameEntity : nameEntities) {
			EntityCacheUtil.removeResult(NameEntityModelImpl.ENTITY_CACHE_ENABLED,
				NameEntityImpl.class, nameEntity.getPrimaryKey());
		}
	}

	/**
	 * Creates a new name entity with the primary key. Does not add the name entity to the database.
	 *
	 * @param nameId the primary key for the new name entity
	 * @return the new name entity
	 */
	@Override
	public NameEntity create(long nameId) {
		NameEntity nameEntity = new NameEntityImpl();

		nameEntity.setNew(true);
		nameEntity.setPrimaryKey(nameId);

		return nameEntity;
	}

	/**
	 * Removes the name entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param nameId the primary key of the name entity
	 * @return the name entity that was removed
	 * @throws hu.borkutip.lfrnevnapp.data.NoSuchNameEntityException if a name entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NameEntity remove(long nameId)
		throws NoSuchNameEntityException, SystemException {
		return remove((Serializable)nameId);
	}

	/**
	 * Removes the name entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the name entity
	 * @return the name entity that was removed
	 * @throws hu.borkutip.lfrnevnapp.data.NoSuchNameEntityException if a name entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NameEntity remove(Serializable primaryKey)
		throws NoSuchNameEntityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			NameEntity nameEntity = (NameEntity)session.get(NameEntityImpl.class,
					primaryKey);

			if (nameEntity == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNameEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(nameEntity);
		}
		catch (NoSuchNameEntityException nsee) {
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
	protected NameEntity removeImpl(NameEntity nameEntity)
		throws SystemException {
		nameEntity = toUnwrappedModel(nameEntity);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(nameEntity)) {
				nameEntity = (NameEntity)session.get(NameEntityImpl.class,
						nameEntity.getPrimaryKeyObj());
			}

			if (nameEntity != null) {
				session.delete(nameEntity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (nameEntity != null) {
			clearCache(nameEntity);
		}

		return nameEntity;
	}

	@Override
	public NameEntity updateImpl(
		hu.borkutip.lfrnevnapp.data.model.NameEntity nameEntity)
		throws SystemException {
		nameEntity = toUnwrappedModel(nameEntity);

		boolean isNew = nameEntity.isNew();

		Session session = null;

		try {
			session = openSession();

			if (nameEntity.isNew()) {
				session.save(nameEntity);

				nameEntity.setNew(false);
			}
			else {
				session.merge(nameEntity);
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

		EntityCacheUtil.putResult(NameEntityModelImpl.ENTITY_CACHE_ENABLED,
			NameEntityImpl.class, nameEntity.getPrimaryKey(), nameEntity);

		return nameEntity;
	}

	protected NameEntity toUnwrappedModel(NameEntity nameEntity) {
		if (nameEntity instanceof NameEntityImpl) {
			return nameEntity;
		}

		NameEntityImpl nameEntityImpl = new NameEntityImpl();

		nameEntityImpl.setNew(nameEntity.isNew());
		nameEntityImpl.setPrimaryKey(nameEntity.getPrimaryKey());

		nameEntityImpl.setNameId(nameEntity.getNameId());
		nameEntityImpl.setName(nameEntity.getName());
		nameEntityImpl.setGender(nameEntity.getGender());

		return nameEntityImpl;
	}

	/**
	 * Returns the name entity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the name entity
	 * @return the name entity
	 * @throws hu.borkutip.lfrnevnapp.data.NoSuchNameEntityException if a name entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NameEntity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNameEntityException, SystemException {
		NameEntity nameEntity = fetchByPrimaryKey(primaryKey);

		if (nameEntity == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNameEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return nameEntity;
	}

	/**
	 * Returns the name entity with the primary key or throws a {@link hu.borkutip.lfrnevnapp.data.NoSuchNameEntityException} if it could not be found.
	 *
	 * @param nameId the primary key of the name entity
	 * @return the name entity
	 * @throws hu.borkutip.lfrnevnapp.data.NoSuchNameEntityException if a name entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NameEntity findByPrimaryKey(long nameId)
		throws NoSuchNameEntityException, SystemException {
		return findByPrimaryKey((Serializable)nameId);
	}

	/**
	 * Returns the name entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the name entity
	 * @return the name entity, or <code>null</code> if a name entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NameEntity fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		NameEntity nameEntity = (NameEntity)EntityCacheUtil.getResult(NameEntityModelImpl.ENTITY_CACHE_ENABLED,
				NameEntityImpl.class, primaryKey);

		if (nameEntity == _nullNameEntity) {
			return null;
		}

		if (nameEntity == null) {
			Session session = null;

			try {
				session = openSession();

				nameEntity = (NameEntity)session.get(NameEntityImpl.class,
						primaryKey);

				if (nameEntity != null) {
					cacheResult(nameEntity);
				}
				else {
					EntityCacheUtil.putResult(NameEntityModelImpl.ENTITY_CACHE_ENABLED,
						NameEntityImpl.class, primaryKey, _nullNameEntity);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(NameEntityModelImpl.ENTITY_CACHE_ENABLED,
					NameEntityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return nameEntity;
	}

	/**
	 * Returns the name entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param nameId the primary key of the name entity
	 * @return the name entity, or <code>null</code> if a name entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NameEntity fetchByPrimaryKey(long nameId) throws SystemException {
		return fetchByPrimaryKey((Serializable)nameId);
	}

	/**
	 * Returns all the name entities.
	 *
	 * @return the name entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NameEntity> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the name entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkutip.lfrnevnapp.data.model.impl.NameEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of name entities
	 * @param end the upper bound of the range of name entities (not inclusive)
	 * @return the range of name entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NameEntity> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the name entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkutip.lfrnevnapp.data.model.impl.NameEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of name entities
	 * @param end the upper bound of the range of name entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of name entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NameEntity> findAll(int start, int end,
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

		List<NameEntity> list = (List<NameEntity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NAMEENTITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NAMEENTITY;

				if (pagination) {
					sql = sql.concat(NameEntityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<NameEntity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<NameEntity>(list);
				}
				else {
					list = (List<NameEntity>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the name entities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (NameEntity nameEntity : findAll()) {
			remove(nameEntity);
		}
	}

	/**
	 * Returns the number of name entities.
	 *
	 * @return the number of name entities
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

				Query q = session.createQuery(_SQL_COUNT_NAMEENTITY);

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
	 * Initializes the name entity persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.hu.borkutip.lfrnevnapp.data.model.NameEntity")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<NameEntity>> listenersList = new ArrayList<ModelListener<NameEntity>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<NameEntity>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(NameEntityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_NAMEENTITY = "SELECT nameEntity FROM NameEntity nameEntity";
	private static final String _SQL_COUNT_NAMEENTITY = "SELECT COUNT(nameEntity) FROM NameEntity nameEntity";
	private static final String _ORDER_BY_ENTITY_ALIAS = "nameEntity.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NameEntity exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NameEntityPersistenceImpl.class);
	private static NameEntity _nullNameEntity = new NameEntityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<NameEntity> toCacheModel() {
				return _nullNameEntityCacheModel;
			}
		};

	private static CacheModel<NameEntity> _nullNameEntityCacheModel = new CacheModel<NameEntity>() {
			@Override
			public NameEntity toEntityModel() {
				return _nullNameEntity;
			}
		};
}