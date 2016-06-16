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

package hu.borkuti.peter.scriptpp.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ScriptLocalService}.
 *
 * @author Peter Borkuti
 * @see ScriptLocalService
 * @generated
 */
public class ScriptLocalServiceWrapper implements ScriptLocalService,
	ServiceWrapper<ScriptLocalService> {
	public ScriptLocalServiceWrapper(ScriptLocalService scriptLocalService) {
		_scriptLocalService = scriptLocalService;
	}

	/**
	* Adds the script to the database. Also notifies the appropriate model listeners.
	*
	* @param script the script
	* @return the script that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.borkuti.peter.scriptpp.service.model.Script addScript(
		hu.borkuti.peter.scriptpp.service.model.Script script)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scriptLocalService.addScript(script);
	}

	/**
	* Creates a new script with the primary key. Does not add the script to the database.
	*
	* @param ScriptId the primary key for the new script
	* @return the new script
	*/
	@Override
	public hu.borkuti.peter.scriptpp.service.model.Script createScript(
		long ScriptId) {
		return _scriptLocalService.createScript(ScriptId);
	}

	/**
	* Deletes the script with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ScriptId the primary key of the script
	* @return the script that was removed
	* @throws PortalException if a script with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.borkuti.peter.scriptpp.service.model.Script deleteScript(
		long ScriptId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scriptLocalService.deleteScript(ScriptId);
	}

	/**
	* Deletes the script from the database. Also notifies the appropriate model listeners.
	*
	* @param script the script
	* @return the script that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.borkuti.peter.scriptpp.service.model.Script deleteScript(
		hu.borkuti.peter.scriptpp.service.model.Script script)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scriptLocalService.deleteScript(script);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _scriptLocalService.dynamicQuery();
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scriptLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _scriptLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scriptLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scriptLocalService.dynamicQueryCount(dynamicQuery);
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scriptLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public hu.borkuti.peter.scriptpp.service.model.Script fetchScript(
		long ScriptId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scriptLocalService.fetchScript(ScriptId);
	}

	/**
	* Returns the script with the primary key.
	*
	* @param ScriptId the primary key of the script
	* @return the script
	* @throws PortalException if a script with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.borkuti.peter.scriptpp.service.model.Script getScript(
		long ScriptId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scriptLocalService.getScript(ScriptId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scriptLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<hu.borkuti.peter.scriptpp.service.model.Script> getScripts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scriptLocalService.getScripts(start, end);
	}

	/**
	* Returns the number of scripts.
	*
	* @return the number of scripts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getScriptsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scriptLocalService.getScriptsCount();
	}

	/**
	* Updates the script in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param script the script
	* @return the script that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public hu.borkuti.peter.scriptpp.service.model.Script updateScript(
		hu.borkuti.peter.scriptpp.service.model.Script script)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scriptLocalService.updateScript(script);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _scriptLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_scriptLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _scriptLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.lang.String[] getLastScript()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scriptLocalService.getLastScript();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ScriptLocalService getWrappedScriptLocalService() {
		return _scriptLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedScriptLocalService(
		ScriptLocalService scriptLocalService) {
		_scriptLocalService = scriptLocalService;
	}

	@Override
	public ScriptLocalService getWrappedService() {
		return _scriptLocalService;
	}

	@Override
	public void setWrappedService(ScriptLocalService scriptLocalService) {
		_scriptLocalService = scriptLocalService;
	}

	private ScriptLocalService _scriptLocalService;
}