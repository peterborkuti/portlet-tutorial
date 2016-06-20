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

package hu.borkuti.peter.scriptpp.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ScriptOptions}.
 * </p>
 *
 * @author Peter Borkuti
 * @see ScriptOptions
 * @generated
 */
public class ScriptOptionsWrapper implements ScriptOptions,
	ModelWrapper<ScriptOptions> {
	public ScriptOptionsWrapper(ScriptOptions scriptOptions) {
		_scriptOptions = scriptOptions;
	}

	@Override
	public Class<?> getModelClass() {
		return ScriptOptions.class;
	}

	@Override
	public String getModelClassName() {
		return ScriptOptions.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ScriptOptionsId", getScriptOptionsId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("scriptName", getScriptName());
		attributes.put("dependencyList", getDependencyList());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ScriptOptionsId = (Long)attributes.get("ScriptOptionsId");

		if (ScriptOptionsId != null) {
			setScriptOptionsId(ScriptOptionsId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String scriptName = (String)attributes.get("scriptName");

		if (scriptName != null) {
			setScriptName(scriptName);
		}

		String dependencyList = (String)attributes.get("dependencyList");

		if (dependencyList != null) {
			setDependencyList(dependencyList);
		}
	}

	/**
	* Returns the primary key of this script options.
	*
	* @return the primary key of this script options
	*/
	@Override
	public long getPrimaryKey() {
		return _scriptOptions.getPrimaryKey();
	}

	/**
	* Sets the primary key of this script options.
	*
	* @param primaryKey the primary key of this script options
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_scriptOptions.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the script options ID of this script options.
	*
	* @return the script options ID of this script options
	*/
	@Override
	public long getScriptOptionsId() {
		return _scriptOptions.getScriptOptionsId();
	}

	/**
	* Sets the script options ID of this script options.
	*
	* @param ScriptOptionsId the script options ID of this script options
	*/
	@Override
	public void setScriptOptionsId(long ScriptOptionsId) {
		_scriptOptions.setScriptOptionsId(ScriptOptionsId);
	}

	/**
	* Returns the company ID of this script options.
	*
	* @return the company ID of this script options
	*/
	@Override
	public long getCompanyId() {
		return _scriptOptions.getCompanyId();
	}

	/**
	* Sets the company ID of this script options.
	*
	* @param companyId the company ID of this script options
	*/
	@Override
	public void setCompanyId(long companyId) {
		_scriptOptions.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this script options.
	*
	* @return the group ID of this script options
	*/
	@Override
	public long getGroupId() {
		return _scriptOptions.getGroupId();
	}

	/**
	* Sets the group ID of this script options.
	*
	* @param groupId the group ID of this script options
	*/
	@Override
	public void setGroupId(long groupId) {
		_scriptOptions.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this script options.
	*
	* @return the user ID of this script options
	*/
	@Override
	public long getUserId() {
		return _scriptOptions.getUserId();
	}

	/**
	* Sets the user ID of this script options.
	*
	* @param userId the user ID of this script options
	*/
	@Override
	public void setUserId(long userId) {
		_scriptOptions.setUserId(userId);
	}

	/**
	* Returns the user uuid of this script options.
	*
	* @return the user uuid of this script options
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scriptOptions.getUserUuid();
	}

	/**
	* Sets the user uuid of this script options.
	*
	* @param userUuid the user uuid of this script options
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_scriptOptions.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this script options.
	*
	* @return the create date of this script options
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _scriptOptions.getCreateDate();
	}

	/**
	* Sets the create date of this script options.
	*
	* @param createDate the create date of this script options
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_scriptOptions.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this script options.
	*
	* @return the modified date of this script options
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _scriptOptions.getModifiedDate();
	}

	/**
	* Sets the modified date of this script options.
	*
	* @param modifiedDate the modified date of this script options
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_scriptOptions.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the script name of this script options.
	*
	* @return the script name of this script options
	*/
	@Override
	public java.lang.String getScriptName() {
		return _scriptOptions.getScriptName();
	}

	/**
	* Sets the script name of this script options.
	*
	* @param scriptName the script name of this script options
	*/
	@Override
	public void setScriptName(java.lang.String scriptName) {
		_scriptOptions.setScriptName(scriptName);
	}

	/**
	* Returns the dependency list of this script options.
	*
	* @return the dependency list of this script options
	*/
	@Override
	public java.lang.String getDependencyList() {
		return _scriptOptions.getDependencyList();
	}

	/**
	* Sets the dependency list of this script options.
	*
	* @param dependencyList the dependency list of this script options
	*/
	@Override
	public void setDependencyList(java.lang.String dependencyList) {
		_scriptOptions.setDependencyList(dependencyList);
	}

	@Override
	public boolean isNew() {
		return _scriptOptions.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_scriptOptions.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _scriptOptions.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_scriptOptions.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _scriptOptions.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _scriptOptions.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_scriptOptions.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _scriptOptions.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_scriptOptions.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_scriptOptions.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_scriptOptions.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ScriptOptionsWrapper((ScriptOptions)_scriptOptions.clone());
	}

	@Override
	public int compareTo(
		hu.borkuti.peter.scriptpp.service.model.ScriptOptions scriptOptions) {
		return _scriptOptions.compareTo(scriptOptions);
	}

	@Override
	public int hashCode() {
		return _scriptOptions.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<hu.borkuti.peter.scriptpp.service.model.ScriptOptions> toCacheModel() {
		return _scriptOptions.toCacheModel();
	}

	@Override
	public hu.borkuti.peter.scriptpp.service.model.ScriptOptions toEscapedModel() {
		return new ScriptOptionsWrapper(_scriptOptions.toEscapedModel());
	}

	@Override
	public hu.borkuti.peter.scriptpp.service.model.ScriptOptions toUnescapedModel() {
		return new ScriptOptionsWrapper(_scriptOptions.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _scriptOptions.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _scriptOptions.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ScriptOptionsWrapper)) {
			return false;
		}

		ScriptOptionsWrapper scriptOptionsWrapper = (ScriptOptionsWrapper)obj;

		if (Validator.equals(_scriptOptions, scriptOptionsWrapper._scriptOptions)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ScriptOptions getWrappedScriptOptions() {
		return _scriptOptions;
	}

	@Override
	public ScriptOptions getWrappedModel() {
		return _scriptOptions;
	}

	@Override
	public void resetOriginalValues() {
		_scriptOptions.resetOriginalValues();
	}

	private ScriptOptions _scriptOptions;
}