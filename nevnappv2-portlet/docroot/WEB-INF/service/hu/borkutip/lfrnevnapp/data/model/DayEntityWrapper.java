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
 * This class is a wrapper for {@link DayEntity}.
 * </p>
 *
 * @author Péter Borkuti
 * @see DayEntity
 * @generated
 */
public class DayEntityWrapper implements DayEntity, ModelWrapper<DayEntity> {
	public DayEntityWrapper(DayEntity dayEntity) {
		_dayEntity = dayEntity;
	}

	@Override
	public Class<?> getModelClass() {
		return DayEntity.class;
	}

	@Override
	public String getModelClassName() {
		return DayEntity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dayId", getDayId());
		attributes.put("month", getMonth());
		attributes.put("day", getDay());
		attributes.put("nameId", getNameId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dayId = (Long)attributes.get("dayId");

		if (dayId != null) {
			setDayId(dayId);
		}

		Integer month = (Integer)attributes.get("month");

		if (month != null) {
			setMonth(month);
		}

		Integer day = (Integer)attributes.get("day");

		if (day != null) {
			setDay(day);
		}

		Long nameId = (Long)attributes.get("nameId");

		if (nameId != null) {
			setNameId(nameId);
		}
	}

	/**
	* Returns the primary key of this day entity.
	*
	* @return the primary key of this day entity
	*/
	@Override
	public long getPrimaryKey() {
		return _dayEntity.getPrimaryKey();
	}

	/**
	* Sets the primary key of this day entity.
	*
	* @param primaryKey the primary key of this day entity
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dayEntity.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the day ID of this day entity.
	*
	* @return the day ID of this day entity
	*/
	@Override
	public long getDayId() {
		return _dayEntity.getDayId();
	}

	/**
	* Sets the day ID of this day entity.
	*
	* @param dayId the day ID of this day entity
	*/
	@Override
	public void setDayId(long dayId) {
		_dayEntity.setDayId(dayId);
	}

	/**
	* Returns the month of this day entity.
	*
	* @return the month of this day entity
	*/
	@Override
	public int getMonth() {
		return _dayEntity.getMonth();
	}

	/**
	* Sets the month of this day entity.
	*
	* @param month the month of this day entity
	*/
	@Override
	public void setMonth(int month) {
		_dayEntity.setMonth(month);
	}

	/**
	* Returns the day of this day entity.
	*
	* @return the day of this day entity
	*/
	@Override
	public int getDay() {
		return _dayEntity.getDay();
	}

	/**
	* Sets the day of this day entity.
	*
	* @param day the day of this day entity
	*/
	@Override
	public void setDay(int day) {
		_dayEntity.setDay(day);
	}

	/**
	* Returns the name ID of this day entity.
	*
	* @return the name ID of this day entity
	*/
	@Override
	public long getNameId() {
		return _dayEntity.getNameId();
	}

	/**
	* Sets the name ID of this day entity.
	*
	* @param nameId the name ID of this day entity
	*/
	@Override
	public void setNameId(long nameId) {
		_dayEntity.setNameId(nameId);
	}

	@Override
	public boolean isNew() {
		return _dayEntity.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_dayEntity.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _dayEntity.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dayEntity.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _dayEntity.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _dayEntity.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dayEntity.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dayEntity.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_dayEntity.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_dayEntity.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dayEntity.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DayEntityWrapper((DayEntity)_dayEntity.clone());
	}

	@Override
	public int compareTo(hu.borkutip.lfrnevnapp.data.model.DayEntity dayEntity) {
		return _dayEntity.compareTo(dayEntity);
	}

	@Override
	public int hashCode() {
		return _dayEntity.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<hu.borkutip.lfrnevnapp.data.model.DayEntity> toCacheModel() {
		return _dayEntity.toCacheModel();
	}

	@Override
	public hu.borkutip.lfrnevnapp.data.model.DayEntity toEscapedModel() {
		return new DayEntityWrapper(_dayEntity.toEscapedModel());
	}

	@Override
	public hu.borkutip.lfrnevnapp.data.model.DayEntity toUnescapedModel() {
		return new DayEntityWrapper(_dayEntity.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dayEntity.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dayEntity.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_dayEntity.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DayEntityWrapper)) {
			return false;
		}

		DayEntityWrapper dayEntityWrapper = (DayEntityWrapper)obj;

		if (Validator.equals(_dayEntity, dayEntityWrapper._dayEntity)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DayEntity getWrappedDayEntity() {
		return _dayEntity;
	}

	@Override
	public DayEntity getWrappedModel() {
		return _dayEntity;
	}

	@Override
	public void resetOriginalValues() {
		_dayEntity.resetOriginalValues();
	}

	private DayEntity _dayEntity;
}