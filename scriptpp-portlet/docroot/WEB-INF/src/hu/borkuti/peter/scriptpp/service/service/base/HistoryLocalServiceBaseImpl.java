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

package hu.borkuti.peter.scriptpp.service.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import hu.borkuti.peter.scriptpp.service.model.History;
import hu.borkuti.peter.scriptpp.service.service.HistoryLocalService;
import hu.borkuti.peter.scriptpp.service.service.persistence.HistoryPersistence;
import hu.borkuti.peter.scriptpp.service.service.persistence.ScriptPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the history local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link hu.borkuti.peter.scriptpp.service.service.impl.HistoryLocalServiceImpl}.
 * </p>
 *
 * @author Peter Borkuti
 * @see hu.borkuti.peter.scriptpp.service.service.impl.HistoryLocalServiceImpl
 * @see hu.borkuti.peter.scriptpp.service.service.HistoryLocalServiceUtil
 * @generated
 */
public abstract class HistoryLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements HistoryLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link hu.borkuti.peter.scriptpp.service.service.HistoryLocalServiceUtil} to access the history local service.
	 */

	/**
	 * Adds the history to the database. Also notifies the appropriate model listeners.
	 *
	 * @param history the history
	 * @return the history that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public History addHistory(History history) throws SystemException {
		history.setNew(true);

		return historyPersistence.update(history);
	}

	/**
	 * Creates a new history with the primary key. Does not add the history to the database.
	 *
	 * @param historyId the primary key for the new history
	 * @return the new history
	 */
	@Override
	public History createHistory(long historyId) {
		return historyPersistence.create(historyId);
	}

	/**
	 * Deletes the history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param historyId the primary key of the history
	 * @return the history that was removed
	 * @throws PortalException if a history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public History deleteHistory(long historyId)
		throws PortalException, SystemException {
		return historyPersistence.remove(historyId);
	}

	/**
	 * Deletes the history from the database. Also notifies the appropriate model listeners.
	 *
	 * @param history the history
	 * @return the history that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public History deleteHistory(History history) throws SystemException {
		return historyPersistence.remove(history);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(History.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return historyPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return historyPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return historyPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return historyPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return historyPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public History fetchHistory(long historyId) throws SystemException {
		return historyPersistence.fetchByPrimaryKey(historyId);
	}

	/**
	 * Returns the history with the primary key.
	 *
	 * @param historyId the primary key of the history
	 * @return the history
	 * @throws PortalException if a history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public History getHistory(long historyId)
		throws PortalException, SystemException {
		return historyPersistence.findByPrimaryKey(historyId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return historyPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of histories
	 * @param end the upper bound of the range of histories (not inclusive)
	 * @return the range of histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<History> getHistories(int start, int end)
		throws SystemException {
		return historyPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of histories.
	 *
	 * @return the number of histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getHistoriesCount() throws SystemException {
		return historyPersistence.countAll();
	}

	/**
	 * Updates the history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param history the history
	 * @return the history that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public History updateHistory(History history) throws SystemException {
		return historyPersistence.update(history);
	}

	/**
	 * Returns the history local service.
	 *
	 * @return the history local service
	 */
	public hu.borkuti.peter.scriptpp.service.service.HistoryLocalService getHistoryLocalService() {
		return historyLocalService;
	}

	/**
	 * Sets the history local service.
	 *
	 * @param historyLocalService the history local service
	 */
	public void setHistoryLocalService(
		hu.borkuti.peter.scriptpp.service.service.HistoryLocalService historyLocalService) {
		this.historyLocalService = historyLocalService;
	}

	/**
	 * Returns the history remote service.
	 *
	 * @return the history remote service
	 */
	public hu.borkuti.peter.scriptpp.service.service.HistoryService getHistoryService() {
		return historyService;
	}

	/**
	 * Sets the history remote service.
	 *
	 * @param historyService the history remote service
	 */
	public void setHistoryService(
		hu.borkuti.peter.scriptpp.service.service.HistoryService historyService) {
		this.historyService = historyService;
	}

	/**
	 * Returns the history persistence.
	 *
	 * @return the history persistence
	 */
	public HistoryPersistence getHistoryPersistence() {
		return historyPersistence;
	}

	/**
	 * Sets the history persistence.
	 *
	 * @param historyPersistence the history persistence
	 */
	public void setHistoryPersistence(HistoryPersistence historyPersistence) {
		this.historyPersistence = historyPersistence;
	}

	/**
	 * Returns the script local service.
	 *
	 * @return the script local service
	 */
	public hu.borkuti.peter.scriptpp.service.service.ScriptLocalService getScriptLocalService() {
		return scriptLocalService;
	}

	/**
	 * Sets the script local service.
	 *
	 * @param scriptLocalService the script local service
	 */
	public void setScriptLocalService(
		hu.borkuti.peter.scriptpp.service.service.ScriptLocalService scriptLocalService) {
		this.scriptLocalService = scriptLocalService;
	}

	/**
	 * Returns the script remote service.
	 *
	 * @return the script remote service
	 */
	public hu.borkuti.peter.scriptpp.service.service.ScriptService getScriptService() {
		return scriptService;
	}

	/**
	 * Sets the script remote service.
	 *
	 * @param scriptService the script remote service
	 */
	public void setScriptService(
		hu.borkuti.peter.scriptpp.service.service.ScriptService scriptService) {
		this.scriptService = scriptService;
	}

	/**
	 * Returns the script persistence.
	 *
	 * @return the script persistence
	 */
	public ScriptPersistence getScriptPersistence() {
		return scriptPersistence;
	}

	/**
	 * Sets the script persistence.
	 *
	 * @param scriptPersistence the script persistence
	 */
	public void setScriptPersistence(ScriptPersistence scriptPersistence) {
		this.scriptPersistence = scriptPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("hu.borkuti.peter.scriptpp.service.model.History",
			historyLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"hu.borkuti.peter.scriptpp.service.model.History");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return History.class;
	}

	protected String getModelClassName() {
		return History.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = historyPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = hu.borkuti.peter.scriptpp.service.service.HistoryLocalService.class)
	protected hu.borkuti.peter.scriptpp.service.service.HistoryLocalService historyLocalService;
	@BeanReference(type = hu.borkuti.peter.scriptpp.service.service.HistoryService.class)
	protected hu.borkuti.peter.scriptpp.service.service.HistoryService historyService;
	@BeanReference(type = HistoryPersistence.class)
	protected HistoryPersistence historyPersistence;
	@BeanReference(type = hu.borkuti.peter.scriptpp.service.service.ScriptLocalService.class)
	protected hu.borkuti.peter.scriptpp.service.service.ScriptLocalService scriptLocalService;
	@BeanReference(type = hu.borkuti.peter.scriptpp.service.service.ScriptService.class)
	protected hu.borkuti.peter.scriptpp.service.service.ScriptService scriptService;
	@BeanReference(type = ScriptPersistence.class)
	protected ScriptPersistence scriptPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private HistoryLocalServiceClpInvoker _clpInvoker = new HistoryLocalServiceClpInvoker();
}