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

package permission.servicebuider.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Firstnames}.
 * </p>
 *
 * @author peter
 * @see Firstnames
 * @generated
 */
public class FirstnamesWrapper implements Firstnames, ModelWrapper<Firstnames> {
	public FirstnamesWrapper(Firstnames firstnames) {
		_firstnames = firstnames;
	}

	@Override
	public Class<?> getModelClass() {
		return Firstnames.class;
	}

	@Override
	public String getModelClassName() {
		return Firstnames.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("firstnameId", getFirstnameId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("firstname", getFirstname());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long firstnameId = (Long)attributes.get("firstnameId");

		if (firstnameId != null) {
			setFirstnameId(firstnameId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		String firstname = (String)attributes.get("firstname");

		if (firstname != null) {
			setFirstname(firstname);
		}
	}

	/**
	* Returns the primary key of this firstnames.
	*
	* @return the primary key of this firstnames
	*/
	@Override
	public long getPrimaryKey() {
		return _firstnames.getPrimaryKey();
	}

	/**
	* Sets the primary key of this firstnames.
	*
	* @param primaryKey the primary key of this firstnames
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_firstnames.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the firstname ID of this firstnames.
	*
	* @return the firstname ID of this firstnames
	*/
	@Override
	public long getFirstnameId() {
		return _firstnames.getFirstnameId();
	}

	/**
	* Sets the firstname ID of this firstnames.
	*
	* @param firstnameId the firstname ID of this firstnames
	*/
	@Override
	public void setFirstnameId(long firstnameId) {
		_firstnames.setFirstnameId(firstnameId);
	}

	/**
	* Returns the group ID of this firstnames.
	*
	* @return the group ID of this firstnames
	*/
	@Override
	public long getGroupId() {
		return _firstnames.getGroupId();
	}

	/**
	* Sets the group ID of this firstnames.
	*
	* @param groupId the group ID of this firstnames
	*/
	@Override
	public void setGroupId(long groupId) {
		_firstnames.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this firstnames.
	*
	* @return the company ID of this firstnames
	*/
	@Override
	public long getCompanyId() {
		return _firstnames.getCompanyId();
	}

	/**
	* Sets the company ID of this firstnames.
	*
	* @param companyId the company ID of this firstnames
	*/
	@Override
	public void setCompanyId(long companyId) {
		_firstnames.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this firstnames.
	*
	* @return the user ID of this firstnames
	*/
	@Override
	public long getUserId() {
		return _firstnames.getUserId();
	}

	/**
	* Sets the user ID of this firstnames.
	*
	* @param userId the user ID of this firstnames
	*/
	@Override
	public void setUserId(long userId) {
		_firstnames.setUserId(userId);
	}

	/**
	* Returns the user uuid of this firstnames.
	*
	* @return the user uuid of this firstnames
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _firstnames.getUserUuid();
	}

	/**
	* Sets the user uuid of this firstnames.
	*
	* @param userUuid the user uuid of this firstnames
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_firstnames.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this firstnames.
	*
	* @return the create date of this firstnames
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _firstnames.getCreateDate();
	}

	/**
	* Sets the create date of this firstnames.
	*
	* @param createDate the create date of this firstnames
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_firstnames.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this firstnames.
	*
	* @return the modified date of this firstnames
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _firstnames.getModifiedDate();
	}

	/**
	* Sets the modified date of this firstnames.
	*
	* @param modifiedDate the modified date of this firstnames
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_firstnames.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the firstname of this firstnames.
	*
	* @return the firstname of this firstnames
	*/
	@Override
	public java.lang.String getFirstname() {
		return _firstnames.getFirstname();
	}

	/**
	* Sets the firstname of this firstnames.
	*
	* @param firstname the firstname of this firstnames
	*/
	@Override
	public void setFirstname(java.lang.String firstname) {
		_firstnames.setFirstname(firstname);
	}

	@Override
	public boolean isNew() {
		return _firstnames.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_firstnames.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _firstnames.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_firstnames.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _firstnames.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _firstnames.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_firstnames.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _firstnames.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_firstnames.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_firstnames.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_firstnames.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FirstnamesWrapper((Firstnames)_firstnames.clone());
	}

	@Override
	public int compareTo(permission.servicebuider.model.Firstnames firstnames) {
		return _firstnames.compareTo(firstnames);
	}

	@Override
	public int hashCode() {
		return _firstnames.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<permission.servicebuider.model.Firstnames> toCacheModel() {
		return _firstnames.toCacheModel();
	}

	@Override
	public permission.servicebuider.model.Firstnames toEscapedModel() {
		return new FirstnamesWrapper(_firstnames.toEscapedModel());
	}

	@Override
	public permission.servicebuider.model.Firstnames toUnescapedModel() {
		return new FirstnamesWrapper(_firstnames.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _firstnames.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _firstnames.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_firstnames.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FirstnamesWrapper)) {
			return false;
		}

		FirstnamesWrapper firstnamesWrapper = (FirstnamesWrapper)obj;

		if (Validator.equals(_firstnames, firstnamesWrapper._firstnames)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Firstnames getWrappedFirstnames() {
		return _firstnames;
	}

	@Override
	public Firstnames getWrappedModel() {
		return _firstnames;
	}

	@Override
	public void resetOriginalValues() {
		_firstnames.resetOriginalValues();
	}

	private Firstnames _firstnames;
}