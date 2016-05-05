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
 * This class is a wrapper for {@link History}.
 * </p>
 *
 * @author Peter Borkuti
 * @see History
 * @generated
 */
public class HistoryWrapper implements History, ModelWrapper<History> {
	public HistoryWrapper(History history) {
		_history = history;
	}

	@Override
	public Class<?> getModelClass() {
		return History.class;
	}

	@Override
	public String getModelClassName() {
		return History.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("historyId", getHistoryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("line", getLine());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long historyId = (Long)attributes.get("historyId");

		if (historyId != null) {
			setHistoryId(historyId);
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

		String line = (String)attributes.get("line");

		if (line != null) {
			setLine(line);
		}
	}

	/**
	* Returns the primary key of this history.
	*
	* @return the primary key of this history
	*/
	@Override
	public long getPrimaryKey() {
		return _history.getPrimaryKey();
	}

	/**
	* Sets the primary key of this history.
	*
	* @param primaryKey the primary key of this history
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_history.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the history ID of this history.
	*
	* @return the history ID of this history
	*/
	@Override
	public long getHistoryId() {
		return _history.getHistoryId();
	}

	/**
	* Sets the history ID of this history.
	*
	* @param historyId the history ID of this history
	*/
	@Override
	public void setHistoryId(long historyId) {
		_history.setHistoryId(historyId);
	}

	/**
	* Returns the company ID of this history.
	*
	* @return the company ID of this history
	*/
	@Override
	public long getCompanyId() {
		return _history.getCompanyId();
	}

	/**
	* Sets the company ID of this history.
	*
	* @param companyId the company ID of this history
	*/
	@Override
	public void setCompanyId(long companyId) {
		_history.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this history.
	*
	* @return the group ID of this history
	*/
	@Override
	public long getGroupId() {
		return _history.getGroupId();
	}

	/**
	* Sets the group ID of this history.
	*
	* @param groupId the group ID of this history
	*/
	@Override
	public void setGroupId(long groupId) {
		_history.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this history.
	*
	* @return the user ID of this history
	*/
	@Override
	public long getUserId() {
		return _history.getUserId();
	}

	/**
	* Sets the user ID of this history.
	*
	* @param userId the user ID of this history
	*/
	@Override
	public void setUserId(long userId) {
		_history.setUserId(userId);
	}

	/**
	* Returns the user uuid of this history.
	*
	* @return the user uuid of this history
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _history.getUserUuid();
	}

	/**
	* Sets the user uuid of this history.
	*
	* @param userUuid the user uuid of this history
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_history.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this history.
	*
	* @return the create date of this history
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _history.getCreateDate();
	}

	/**
	* Sets the create date of this history.
	*
	* @param createDate the create date of this history
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_history.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this history.
	*
	* @return the modified date of this history
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _history.getModifiedDate();
	}

	/**
	* Sets the modified date of this history.
	*
	* @param modifiedDate the modified date of this history
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_history.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the line of this history.
	*
	* @return the line of this history
	*/
	@Override
	public java.lang.String getLine() {
		return _history.getLine();
	}

	/**
	* Sets the line of this history.
	*
	* @param line the line of this history
	*/
	@Override
	public void setLine(java.lang.String line) {
		_history.setLine(line);
	}

	@Override
	public boolean isNew() {
		return _history.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_history.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _history.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_history.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _history.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _history.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_history.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _history.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_history.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_history.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_history.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HistoryWrapper((History)_history.clone());
	}

	@Override
	public int compareTo(
		hu.borkuti.peter.scriptpp.service.model.History history) {
		return _history.compareTo(history);
	}

	@Override
	public int hashCode() {
		return _history.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<hu.borkuti.peter.scriptpp.service.model.History> toCacheModel() {
		return _history.toCacheModel();
	}

	@Override
	public hu.borkuti.peter.scriptpp.service.model.History toEscapedModel() {
		return new HistoryWrapper(_history.toEscapedModel());
	}

	@Override
	public hu.borkuti.peter.scriptpp.service.model.History toUnescapedModel() {
		return new HistoryWrapper(_history.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _history.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _history.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_history.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HistoryWrapper)) {
			return false;
		}

		HistoryWrapper historyWrapper = (HistoryWrapper)obj;

		if (Validator.equals(_history, historyWrapper._history)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public History getWrappedHistory() {
		return _history;
	}

	@Override
	public History getWrappedModel() {
		return _history;
	}

	@Override
	public void resetOriginalValues() {
		_history.resetOriginalValues();
	}

	private History _history;
}