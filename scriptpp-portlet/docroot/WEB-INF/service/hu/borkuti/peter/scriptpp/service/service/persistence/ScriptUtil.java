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

import hu.borkuti.peter.scriptpp.service.model.Script;

import java.util.List;

/**
 * The persistence utility for the script service. This utility wraps {@link ScriptPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Peter Borkuti
 * @see ScriptPersistence
 * @see ScriptPersistenceImpl
 * @generated
 */
public class ScriptUtil {
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
	public static void clearCache(Script script) {
		getPersistence().clearCache(script);
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
	public static List<Script> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Script> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Script> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Script update(Script script) throws SystemException {
		return getPersistence().update(script);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Script update(Script script, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(script, serviceContext);
	}

	/**
	* Caches the script in the entity cache if it is enabled.
	*
	* @param script the script
	*/
	public static void cacheResult(
		hu.borkuti.peter.scriptpp.service.model.Script script) {
		getPersistence().cacheResult(script);
	}

	/**
	* Caches the scripts in the entity cache if it is enabled.
	*
	* @param scripts the scripts
	*/
	public static void cacheResult(
		java.util.List<hu.borkuti.peter.scriptpp.service.model.Script> scripts) {
		getPersistence().cacheResult(scripts);
	}

	/**
	* Creates a new script with the primary key. Does not add the script to the database.
	*
	* @param ScriptId the primary key for the new script
	* @return the new script
	*/
	public static hu.borkuti.peter.scriptpp.service.model.Script create(
		long ScriptId) {
		return getPersistence().create(ScriptId);
	}

	/**
	* Removes the script with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ScriptId the primary key of the script
	* @return the script that was removed
	* @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptException if a script with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.borkuti.peter.scriptpp.service.model.Script remove(
		long ScriptId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkuti.peter.scriptpp.service.NoSuchScriptException {
		return getPersistence().remove(ScriptId);
	}

	public static hu.borkuti.peter.scriptpp.service.model.Script updateImpl(
		hu.borkuti.peter.scriptpp.service.model.Script script)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(script);
	}

	/**
	* Returns the script with the primary key or throws a {@link hu.borkuti.peter.scriptpp.service.NoSuchScriptException} if it could not be found.
	*
	* @param ScriptId the primary key of the script
	* @return the script
	* @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptException if a script with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.borkuti.peter.scriptpp.service.model.Script findByPrimaryKey(
		long ScriptId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkuti.peter.scriptpp.service.NoSuchScriptException {
		return getPersistence().findByPrimaryKey(ScriptId);
	}

	/**
	* Returns the script with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ScriptId the primary key of the script
	* @return the script, or <code>null</code> if a script with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.borkuti.peter.scriptpp.service.model.Script fetchByPrimaryKey(
		long ScriptId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ScriptId);
	}

	/**
	* Returns all the scripts.
	*
	* @return the scripts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.borkuti.peter.scriptpp.service.model.Script> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<hu.borkuti.peter.scriptpp.service.model.Script> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<hu.borkuti.peter.scriptpp.service.model.Script> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the scripts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of scripts.
	*
	* @return the number of scripts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ScriptPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ScriptPersistence)PortletBeanLocatorUtil.locate(hu.borkuti.peter.scriptpp.service.service.ClpSerializer.getServletContextName(),
					ScriptPersistence.class.getName());

			ReferenceRegistry.registerReference(ScriptUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ScriptPersistence persistence) {
	}

	private static ScriptPersistence _persistence;
}