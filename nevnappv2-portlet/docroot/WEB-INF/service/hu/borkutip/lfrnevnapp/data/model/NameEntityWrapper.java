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

package hu.borkutip.lfrnevnapp.data.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link NameEntity}.
 * </p>
 *
 * @author Péter Borkuti
 * @see NameEntity
 * @generated
 */
public class NameEntityWrapper implements NameEntity, ModelWrapper<NameEntity> {
	public NameEntityWrapper(NameEntity nameEntity) {
		_nameEntity = nameEntity;
	}

	@Override
	public Class<?> getModelClass() {
		return NameEntity.class;
	}

	@Override
	public String getModelClassName() {
		return NameEntity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("nameId", getNameId());
		attributes.put("name", getName());
		attributes.put("gender", getGender());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long nameId = (Long)attributes.get("nameId");

		if (nameId != null) {
			setNameId(nameId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer gender = (Integer)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}
	}

	/**
	* Returns the primary key of this name entity.
	*
	* @return the primary key of this name entity
	*/
	@Override
	public long getPrimaryKey() {
		return _nameEntity.getPrimaryKey();
	}

	/**
	* Sets the primary key of this name entity.
	*
	* @param primaryKey the primary key of this name entity
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_nameEntity.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the name ID of this name entity.
	*
	* @return the name ID of this name entity
	*/
	@Override
	public long getNameId() {
		return _nameEntity.getNameId();
	}

	/**
	* Sets the name ID of this name entity.
	*
	* @param nameId the name ID of this name entity
	*/
	@Override
	public void setNameId(long nameId) {
		_nameEntity.setNameId(nameId);
	}

	/**
	* Returns the name of this name entity.
	*
	* @return the name of this name entity
	*/
	@Override
	public java.lang.String getName() {
		return _nameEntity.getName();
	}

	/**
	* Sets the name of this name entity.
	*
	* @param name the name of this name entity
	*/
	@Override
	public void setName(java.lang.String name) {
		_nameEntity.setName(name);
	}

	/**
	* Returns the gender of this name entity.
	*
	* @return the gender of this name entity
	*/
	@Override
	public int getGender() {
		return _nameEntity.getGender();
	}

	/**
	* Sets the gender of this name entity.
	*
	* @param gender the gender of this name entity
	*/
	@Override
	public void setGender(int gender) {
		_nameEntity.setGender(gender);
	}

	@Override
	public boolean isNew() {
		return _nameEntity.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_nameEntity.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _nameEntity.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_nameEntity.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _nameEntity.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _nameEntity.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_nameEntity.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _nameEntity.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_nameEntity.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_nameEntity.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_nameEntity.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NameEntityWrapper((NameEntity)_nameEntity.clone());
	}

	@Override
	public int compareTo(
		hu.borkutip.lfrnevnapp.data.model.NameEntity nameEntity) {
		return _nameEntity.compareTo(nameEntity);
	}

	@Override
	public int hashCode() {
		return _nameEntity.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<hu.borkutip.lfrnevnapp.data.model.NameEntity> toCacheModel() {
		return _nameEntity.toCacheModel();
	}

	@Override
	public hu.borkutip.lfrnevnapp.data.model.NameEntity toEscapedModel() {
		return new NameEntityWrapper(_nameEntity.toEscapedModel());
	}

	@Override
	public hu.borkutip.lfrnevnapp.data.model.NameEntity toUnescapedModel() {
		return new NameEntityWrapper(_nameEntity.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _nameEntity.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _nameEntity.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_nameEntity.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NameEntityWrapper)) {
			return false;
		}

		NameEntityWrapper nameEntityWrapper = (NameEntityWrapper)obj;

		if (Validator.equals(_nameEntity, nameEntityWrapper._nameEntity)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public NameEntity getWrappedNameEntity() {
		return _nameEntity;
	}

	@Override
	public NameEntity getWrappedModel() {
		return _nameEntity;
	}

	@Override
	public void resetOriginalValues() {
		_nameEntity.resetOriginalValues();
	}

	private NameEntity _nameEntity;
}