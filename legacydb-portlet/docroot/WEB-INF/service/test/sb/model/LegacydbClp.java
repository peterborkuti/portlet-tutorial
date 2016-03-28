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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import test.sb.service.ClpSerializer;
import test.sb.service.LegacydbLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author peter
 */
public class LegacydbClp extends BaseModelImpl<Legacydb> implements Legacydb {
	public LegacydbClp() {
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
	public long getPrimaryKey() {
		return _legacydbid;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLegacydbid(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _legacydbid;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getLegacydbid() {
		return _legacydbid;
	}

	@Override
	public void setLegacydbid(long legacydbid) {
		_legacydbid = legacydbid;

		if (_legacydbRemoteModel != null) {
			try {
				Class<?> clazz = _legacydbRemoteModel.getClass();

				Method method = clazz.getMethod("setLegacydbid", long.class);

				method.invoke(_legacydbRemoteModel, legacydbid);
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

		if (_legacydbRemoteModel != null) {
			try {
				Class<?> clazz = _legacydbRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_legacydbRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLegacydbRemoteModel() {
		return _legacydbRemoteModel;
	}

	public void setLegacydbRemoteModel(BaseModel<?> legacydbRemoteModel) {
		_legacydbRemoteModel = legacydbRemoteModel;
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

		Class<?> remoteModelClass = _legacydbRemoteModel.getClass();

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

		Object returnValue = method.invoke(_legacydbRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LegacydbLocalServiceUtil.addLegacydb(this);
		}
		else {
			LegacydbLocalServiceUtil.updateLegacydb(this);
		}
	}

	@Override
	public Legacydb toEscapedModel() {
		return (Legacydb)ProxyUtil.newProxyInstance(Legacydb.class.getClassLoader(),
			new Class[] { Legacydb.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LegacydbClp clone = new LegacydbClp();

		clone.setLegacydbid(getLegacydbid());
		clone.setName(getName());

		return clone;
	}

	@Override
	public int compareTo(Legacydb legacydb) {
		int value = 0;

		value = getName().compareTo(legacydb.getName());

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

		if (!(obj instanceof LegacydbClp)) {
			return false;
		}

		LegacydbClp legacydb = (LegacydbClp)obj;

		long primaryKey = legacydb.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{legacydbid=");
		sb.append(getLegacydbid());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("test.sb.model.Legacydb");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>legacydbid</column-name><column-value><![CDATA[");
		sb.append(getLegacydbid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _legacydbid;
	private String _name;
	private BaseModel<?> _legacydbRemoteModel;
	private Class<?> _clpSerializerClass = test.sb.service.ClpSerializer.class;
}