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

package test.sb.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Legacydb}.
 * </p>
 *
 * @author peter
 * @see Legacydb
 * @generated
 */
public class LegacydbWrapper implements Legacydb, ModelWrapper<Legacydb> {
	public LegacydbWrapper(Legacydb legacydb) {
		_legacydb = legacydb;
	}

	@Override
	public Class<?> getModelClass() {
		return Legacydb.class;
	}

	@Override
	public String getModelClassName() {
		return Legacydb.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("legacydbid", getLegacydbid());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long legacydbid = (Long)attributes.get("legacydbid");

		if (legacydbid != null) {
			setLegacydbid(legacydbid);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this legacydb.
	*
	* @return the primary key of this legacydb
	*/
	@Override
	public long getPrimaryKey() {
		return _legacydb.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legacydb.
	*
	* @param primaryKey the primary key of this legacydb
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_legacydb.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the legacydbid of this legacydb.
	*
	* @return the legacydbid of this legacydb
	*/
	@Override
	public long getLegacydbid() {
		return _legacydb.getLegacydbid();
	}

	/**
	* Sets the legacydbid of this legacydb.
	*
	* @param legacydbid the legacydbid of this legacydb
	*/
	@Override
	public void setLegacydbid(long legacydbid) {
		_legacydb.setLegacydbid(legacydbid);
	}

	/**
	* Returns the name of this legacydb.
	*
	* @return the name of this legacydb
	*/
	@Override
	public java.lang.String getName() {
		return _legacydb.getName();
	}

	/**
	* Sets the name of this legacydb.
	*
	* @param name the name of this legacydb
	*/
	@Override
	public void setName(java.lang.String name) {
		_legacydb.setName(name);
	}

	@Override
	public boolean isNew() {
		return _legacydb.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legacydb.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legacydb.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legacydb.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legacydb.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legacydb.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legacydb.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legacydb.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legacydb.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legacydb.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legacydb.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegacydbWrapper((Legacydb)_legacydb.clone());
	}

	@Override
	public int compareTo(test.sb.model.Legacydb legacydb) {
		return _legacydb.compareTo(legacydb);
	}

	@Override
	public int hashCode() {
		return _legacydb.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<test.sb.model.Legacydb> toCacheModel() {
		return _legacydb.toCacheModel();
	}

	@Override
	public test.sb.model.Legacydb toEscapedModel() {
		return new LegacydbWrapper(_legacydb.toEscapedModel());
	}

	@Override
	public test.sb.model.Legacydb toUnescapedModel() {
		return new LegacydbWrapper(_legacydb.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legacydb.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legacydb.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legacydb.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacydbWrapper)) {
			return false;
		}

		LegacydbWrapper legacydbWrapper = (LegacydbWrapper)obj;

		if (Validator.equals(_legacydb, legacydbWrapper._legacydb)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Legacydb getWrappedLegacydb() {
		return _legacydb;
	}

	@Override
	public Legacydb getWrappedModel() {
		return _legacydb;
	}

	@Override
	public void resetOriginalValues() {
		_legacydb.resetOriginalValues();
	}

	private Legacydb _legacydb;
}