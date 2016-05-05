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

import com.liferay.portal.service.persistence.BasePersistence;

import hu.borkuti.peter.scriptpp.service.model.History;

/**
 * The persistence interface for the history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Peter Borkuti
 * @see HistoryPersistenceImpl
 * @see HistoryUtil
 * @generated
 */
public interface HistoryPersistence extends BasePersistence<History> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HistoryUtil} to access the history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the history in the entity cache if it is enabled.
	*
	* @param history the history
	*/
	public void cacheResult(
		hu.borkuti.peter.scriptpp.service.model.History history);

	/**
	* Caches the histories in the entity cache if it is enabled.
	*
	* @param histories the histories
	*/
	public void cacheResult(
		java.util.List<hu.borkuti.peter.scriptpp.service.model.History> histories);

	/**
	* Creates a new history with the primary key. Does not add the history to the database.
	*
	* @param historyId the primary key for the new history
	* @return the new history
	*/
	public hu.borkuti.peter.scriptpp.service.model.History create(
		long historyId);

	/**
	* Removes the history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param historyId the primary key of the history
	* @return the history that was removed
	* @throws hu.borkuti.peter.scriptpp.service.NoSuchHistoryException if a history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.History remove(
		long historyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkuti.peter.scriptpp.service.NoSuchHistoryException;

	public hu.borkuti.peter.scriptpp.service.model.History updateImpl(
		hu.borkuti.peter.scriptpp.service.model.History history)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the history with the primary key or throws a {@link hu.borkuti.peter.scriptpp.service.NoSuchHistoryException} if it could not be found.
	*
	* @param historyId the primary key of the history
	* @return the history
	* @throws hu.borkuti.peter.scriptpp.service.NoSuchHistoryException if a history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.History findByPrimaryKey(
		long historyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkuti.peter.scriptpp.service.NoSuchHistoryException;

	/**
	* Returns the history with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param historyId the primary key of the history
	* @return the history, or <code>null</code> if a history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.History fetchByPrimaryKey(
		long historyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the histories.
	*
	* @return the histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkuti.peter.scriptpp.service.model.History> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.borkuti.peter.scriptpp.service.model.History> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.borkuti.peter.scriptpp.service.model.History> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the histories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of histories.
	*
	* @return the number of histories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}