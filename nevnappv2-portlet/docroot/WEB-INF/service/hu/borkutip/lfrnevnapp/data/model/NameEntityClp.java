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
import hu.borkutip.lfrnevnapp.data.service.NameEntityLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Péter Borkuti
 */
public class NameEntityClp extends BaseModelImpl<NameEntity>
	implements NameEntity {
	public NameEntityClp() {
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
	public long getPrimaryKey() {
		return _nameId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNameId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _nameId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getNameId() {
		return _nameId;
	}

	@Override
	public void setNameId(long nameId) {
		_nameId = nameId;

		if (_nameEntityRemoteModel != null) {
			try {
				Class<?> clazz = _nameEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setNameId", long.class);

				method.invoke(_nameEntityRemoteModel, nameId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_nameEntityRemoteModel != null) {
			try {
				Class<?> clazz = _nameEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_nameEntityRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getGender() {
		return _gender;
	}

	@Override
	public void setGender(int gender) {
		_gender = gender;

		if (_nameEntityRemoteModel != null) {
			try {
				Class<?> clazz = _nameEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setGender", int.class);

				method.invoke(_nameEntityRemoteModel, gender);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getNameEntityRemoteModel() {
		return _nameEntityRemoteModel;
	}

	public void setNameEntityRemoteModel(BaseModel<?> nameEntityRemoteModel) {
		_nameEntityRemoteModel = nameEntityRemoteModel;
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

		Class<?> remoteModelClass = _nameEntityRemoteModel.getClass();

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

		Object returnValue = method.invoke(_nameEntityRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			NameEntityLocalServiceUtil.addNameEntity(this);
		}
		else {
			NameEntityLocalServiceUtil.updateNameEntity(this);
		}
	}

	@Override
	public NameEntity toEscapedModel() {
		return (NameEntity)ProxyUtil.newProxyInstance(NameEntity.class.getClassLoader(),
			new Class[] { NameEntity.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		NameEntityClp clone = new NameEntityClp();

		clone.setNameId(getNameId());
		clone.setName(getName());
		clone.setGender(getGender());

		return clone;
	}

	@Override
	public int compareTo(NameEntity nameEntity) {
		int value = 0;

		value = getName().compareTo(nameEntity.getName());

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

		if (!(obj instanceof NameEntityClp)) {
			return false;
		}

		NameEntityClp nameEntity = (NameEntityClp)obj;

		long primaryKey = nameEntity.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{nameId=");
		sb.append(getNameId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", gender=");
		sb.append(getGender());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("hu.borkutip.lfrnevnapp.data.model.NameEntity");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>nameId</column-name><column-value><![CDATA[");
		sb.append(getNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gender</column-name><column-value><![CDATA[");
		sb.append(getGender());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _nameId;
	private String _name;
	private int _gender;
	private BaseModel<?> _nameEntityRemoteModel;
	private Class<?> _clpSerializerClass = hu.borkutip.lfrnevnapp.data.service.ClpSerializer.class;
}