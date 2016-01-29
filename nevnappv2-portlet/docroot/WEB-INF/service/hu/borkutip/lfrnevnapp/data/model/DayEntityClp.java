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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import hu.borkutip.lfrnevnapp.data.service.ClpSerializer;
import hu.borkutip.lfrnevnapp.data.service.DayEntityLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Péter Borkuti
 */
public class DayEntityClp extends BaseModelImpl<DayEntity> implements DayEntity {
	public DayEntityClp() {
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
	public long getPrimaryKey() {
		return _dayId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDayId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dayId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getDayId() {
		return _dayId;
	}

	@Override
	public void setDayId(long dayId) {
		_dayId = dayId;

		if (_dayEntityRemoteModel != null) {
			try {
				Class<?> clazz = _dayEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setDayId", long.class);

				method.invoke(_dayEntityRemoteModel, dayId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMonth() {
		return _month;
	}

	@Override
	public void setMonth(int month) {
		_month = month;

		if (_dayEntityRemoteModel != null) {
			try {
				Class<?> clazz = _dayEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setMonth", int.class);

				method.invoke(_dayEntityRemoteModel, month);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDay() {
		return _day;
	}

	@Override
	public void setDay(int day) {
		_day = day;

		if (_dayEntityRemoteModel != null) {
			try {
				Class<?> clazz = _dayEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setDay", int.class);

				method.invoke(_dayEntityRemoteModel, day);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNameId() {
		return _nameId;
	}

	@Override
	public void setNameId(long nameId) {
		_nameId = nameId;

		if (_dayEntityRemoteModel != null) {
			try {
				Class<?> clazz = _dayEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setNameId", long.class);

				method.invoke(_dayEntityRemoteModel, nameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDayEntityRemoteModel() {
		return _dayEntityRemoteModel;
	}

	public void setDayEntityRemoteModel(BaseModel<?> dayEntityRemoteModel) {
		_dayEntityRemoteModel = dayEntityRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _dayEntityRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_dayEntityRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DayEntityLocalServiceUtil.addDayEntity(this);
		}
		else {
			DayEntityLocalServiceUtil.updateDayEntity(this);
		}
	}

	@Override
	public DayEntity toEscapedModel() {
		return (DayEntity)ProxyUtil.newProxyInstance(DayEntity.class.getClassLoader(),
			new Class[] { DayEntity.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DayEntityClp clone = new DayEntityClp();

		clone.setDayId(getDayId());
		clone.setMonth(getMonth());
		clone.setDay(getDay());
		clone.setNameId(getNameId());

		return clone;
	}

	@Override
	public int compareTo(DayEntity dayEntity) {
		int value = 0;

		if (getMonth() < dayEntity.getMonth()) {
			value = -1;
		}
		else if (getMonth() > dayEntity.getMonth()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getDay() < dayEntity.getDay()) {
			value = -1;
		}
		else if (getDay() > dayEntity.getDay()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DayEntityClp)) {
			return false;
		}

		DayEntityClp dayEntity = (DayEntityClp)obj;

		long primaryKey = dayEntity.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{dayId=");
		sb.append(getDayId());
		sb.append(", month=");
		sb.append(getMonth());
		sb.append(", day=");
		sb.append(getDay());
		sb.append(", nameId=");
		sb.append(getNameId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("hu.borkutip.lfrnevnapp.data.model.DayEntity");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dayId</column-name><column-value><![CDATA[");
		sb.append(getDayId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>month</column-name><column-value><![CDATA[");
		sb.append(getMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>day</column-name><column-value><![CDATA[");
		sb.append(getDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nameId</column-name><column-value><![CDATA[");
		sb.append(getNameId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _dayId;
	private int _month;
	private int _day;
	private long _nameId;
	private BaseModel<?> _dayEntityRemoteModel;
	private Class<?> _clpSerializerClass = hu.borkutip.lfrnevnapp.data.service.ClpSerializer.class;
}