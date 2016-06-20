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
 * This class is a wrapper for {@link Script}.
 * </p>
 *
 * @author Peter Borkuti
 * @see Script
 * @generated
 */
public class ScriptWrapper implements Script, ModelWrapper<Script> {
	public ScriptWrapper(Script script) {
		_script = script;
	}

	@Override
	public Class<?> getModelClass() {
		return Script.class;
	}

	@Override
	public String getModelClassName() {
		return Script.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ScriptId", getScriptId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("scriptOptionsId", getScriptOptionsId());
		attributes.put("importContent", getImportContent());
		attributes.put("moduleContent", getModuleContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ScriptId = (Long)attributes.get("ScriptId");

		if (ScriptId != null) {
			setScriptId(ScriptId);
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

		Long scriptOptionsId = (Long)attributes.get("scriptOptionsId");

		if (scriptOptionsId != null) {
			setScriptOptionsId(scriptOptionsId);
		}

		String importContent = (String)attributes.get("importContent");

		if (importContent != null) {
			setImportContent(importContent);
		}

		String moduleContent = (String)attributes.get("moduleContent");

		if (moduleContent != null) {
			setModuleContent(moduleContent);
		}
	}

	/**
	* Returns the primary key of this script.
	*
	* @return the primary key of this script
	*/
	@Override
	public long getPrimaryKey() {
		return _script.getPrimaryKey();
	}

	/**
	* Sets the primary key of this script.
	*
	* @param primaryKey the primary key of this script
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_script.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the script ID of this script.
	*
	* @return the script ID of this script
	*/
	@Override
	public long getScriptId() {
		return _script.getScriptId();
	}

	/**
	* Sets the script ID of this script.
	*
	* @param ScriptId the script ID of this script
	*/
	@Override
	public void setScriptId(long ScriptId) {
		_script.setScriptId(ScriptId);
	}

	/**
	* Returns the company ID of this script.
	*
	* @return the company ID of this script
	*/
	@Override
	public long getCompanyId() {
		return _script.getCompanyId();
	}

	/**
	* Sets the company ID of this script.
	*
	* @param companyId the company ID of this script
	*/
	@Override
	public void setCompanyId(long companyId) {
		_script.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this script.
	*
	* @return the group ID of this script
	*/
	@Override
	public long getGroupId() {
		return _script.getGroupId();
	}

	/**
	* Sets the group ID of this script.
	*
	* @param groupId the group ID of this script
	*/
	@Override
	public void setGroupId(long groupId) {
		_script.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this script.
	*
	* @return the user ID of this script
	*/
	@Override
	public long getUserId() {
		return _script.getUserId();
	}

	/**
	* Sets the user ID of this script.
	*
	* @param userId the user ID of this script
	*/
	@Override
	public void setUserId(long userId) {
		_script.setUserId(userId);
	}

	/**
	* Returns the user uuid of this script.
	*
	* @return the user uuid of this script
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _script.getUserUuid();
	}

	/**
	* Sets the user uuid of this script.
	*
	* @param userUuid the user uuid of this script
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_script.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this script.
	*
	* @return the create date of this script
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _script.getCreateDate();
	}

	/**
	* Sets the create date of this script.
	*
	* @param createDate the create date of this script
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_script.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this script.
	*
	* @return the modified date of this script
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _script.getModifiedDate();
	}

	/**
	* Sets the modified date of this script.
	*
	* @param modifiedDate the modified date of this script
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_script.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the script options ID of this script.
	*
	* @return the script options ID of this script
	*/
	@Override
	public long getScriptOptionsId() {
		return _script.getScriptOptionsId();
	}

	/**
	* Sets the script options ID of this script.
	*
	* @param scriptOptionsId the script options ID of this script
	*/
	@Override
	public void setScriptOptionsId(long scriptOptionsId) {
		_script.setScriptOptionsId(scriptOptionsId);
	}

	/**
	* Returns the import content of this script.
	*
	* @return the import content of this script
	*/
	@Override
	public java.lang.String getImportContent() {
		return _script.getImportContent();
	}

	/**
	* Sets the import content of this script.
	*
	* @param importContent the import content of this script
	*/
	@Override
	public void setImportContent(java.lang.String importContent) {
		_script.setImportContent(importContent);
	}

	/**
	* Returns the module content of this script.
	*
	* @return the module content of this script
	*/
	@Override
	public java.lang.String getModuleContent() {
		return _script.getModuleContent();
	}

	/**
	* Sets the module content of this script.
	*
	* @param moduleContent the module content of this script
	*/
	@Override
	public void setModuleContent(java.lang.String moduleContent) {
		_script.setModuleContent(moduleContent);
	}

	@Override
	public boolean isNew() {
		return _script.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_script.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _script.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_script.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _script.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _script.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_script.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _script.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_script.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_script.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_script.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ScriptWrapper((Script)_script.clone());
	}

	@Override
	public int compareTo(hu.borkuti.peter.scriptpp.service.model.Script script) {
		return _script.compareTo(script);
	}

	@Override
	public int hashCode() {
		return _script.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<hu.borkuti.peter.scriptpp.service.model.Script> toCacheModel() {
		return _script.toCacheModel();
	}

	@Override
	public hu.borkuti.peter.scriptpp.service.model.Script toEscapedModel() {
		return new ScriptWrapper(_script.toEscapedModel());
	}

	@Override
	public hu.borkuti.peter.scriptpp.service.model.Script toUnescapedModel() {
		return new ScriptWrapper(_script.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _script.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _script.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ScriptWrapper)) {
			return false;
		}

		ScriptWrapper scriptWrapper = (ScriptWrapper)obj;

		if (Validator.equals(_script, scriptWrapper._script)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Script getWrappedScript() {
		return _script;
	}

	@Override
	public Script getWrappedModel() {
		return _script;
	}

	@Override
	public void resetOriginalValues() {
		_script.resetOriginalValues();
	}

	private Script _script;
}