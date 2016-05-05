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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import hu.borkuti.peter.scriptpp.service.model.History;

import java.util.List;

/**
 * The persistence utility for the history service. This utility wraps {@link HistoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Peter Borkuti
 * @see HistoryPersistence
 * @see HistoryPersistenceImpl
 * @generated
 */
public class HistoryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(History history) {
		getPersistence().clearCache(history);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<History> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<History> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<History> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static History update(History history) throws SystemException {
		return getPersistence().update(history);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static History update(History history, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(history, serviceContext);
	}

	/**
	* Caches the history in the entity cache if it is enabled.
	*
	* @param history the history
	*/
	public static void cacheResult(
		hu.borkuti.peter.scriptpp.service.model.History history) {
		getPersistence().cacheResult(history);
	}

	/**
	* Caches the histories in the entity cache if it is enabled.
	*
	* @param histories the histories
	*/
	public static void cacheResult(
		java.util.List<hu.borkuti.peter.scriptpp.service.model.History> histories) {
		getPersistence().cacheResult(histories);
	}

	/**
	* Creates a new history with the primary key. Does not add the history to the database.
	*
	* @param historyId the primary key for the new history
	* @return the new history
	*/
	public static hu.borkuti.peter.scriptpp.service.model.History create(
		long historyId) {
		return getPersistence().create(historyId);
	}

	/**
	* Removes the history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param historyId the primary key of the history
	* @return the history that was removed
	* @throws hu.borkuti.peter.scriptpp.service.NoSuchHistoryException if a history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.borkuti.peter.scriptpp.service.model.History remove(
		long historyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkuti.peter.scriptpp.service.NoSuchHistoryException {
		return getPersistence().remove(historyId);
	}

	public static hu.borkuti.peter.scriptpp.service.model.History updateImpl(
		hu.borkuti.peter.scriptpp.service.model.History history)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(history);
	}

	/**
	* Returns the history with the primary key or throws a {@link hu.borkuti.peter.scriptpp.service.NoSuchHistoryException} if it could not be found.
	*
	* @param historyId the primary key of the history
	* @return the history
	* @throws hu.borkuti.peter.scriptpp.service.NoSuchHistoryException if a history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.borkuti.peter.scriptpp.service.model.History findByPrimaryKey(
		long historyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkuti.peter.scriptpp.service.NoSuchHistoryException {
		return getPersistence().findByPrimaryKey(historyId);
	}

	/**
	* Returns the history with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param historyId the primary key of the history
	* @return the history, or <code>null</code> if a history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.borkuti.peter.scriptpp.service.model.History fetchByPrimaryKey(
		long historyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(historyId);
	}

	/**
	* Returns all the histories.
	*
	* @return the histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.borkuti.peter.scriptpp.service.model.History> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<hu.borkuti.peter.scriptpp.service.model.History> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of histories
	* @param end the upper bound of the range of histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.borkuti.peter.scriptpp.service.model.History> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the histories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of histories.
	*
	* @return the number of histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static HistoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (HistoryPersistence)PortletBeanLocatorUtil.locate(hu.borkuti.peter.scriptpp.service.service.ClpSerializer.getServletContextName(),
					HistoryPersistence.class.getName());

			ReferenceRegistry.registerReference(HistoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(HistoryPersistence persistence) {
	}

	private static HistoryPersistence _persistence;
}