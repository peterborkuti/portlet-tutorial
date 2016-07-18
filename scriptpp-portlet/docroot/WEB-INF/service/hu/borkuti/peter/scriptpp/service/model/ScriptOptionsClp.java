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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import hu.borkuti.peter.scriptpp.service.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Peter Borkuti
 */
public class ScriptOptionsClp extends BaseModelImpl<ScriptOptions>
	implements ScriptOptions {
	public ScriptOptionsClp() {
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
	public long getPrimaryKey() {
		return _ScriptOptionsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setScriptOptionsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ScriptOptionsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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
		attributes.put("scriptCounter", getScriptCounter());

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

		Long scriptCounter = (Long)attributes.get("scriptCounter");

		if (scriptCounter != null) {
			setScriptCounter(scriptCounter);
		}
	}

	@Override
	public long getScriptOptionsId() {
		return _ScriptOptionsId;
	}

	@Override
	public void setScriptOptionsId(long ScriptOptionsId) {
		_ScriptOptionsId = ScriptOptionsId;

		if (_scriptOptionsRemoteModel != null) {
			try {
				Class<?> clazz = _scriptOptionsRemoteModel.getClass();

				Method method = clazz.getMethod("setScriptOptionsId", long.class);

				method.invoke(_scriptOptionsRemoteModel, ScriptOptionsId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_scriptOptionsRemoteModel != null) {
			try {
				Class<?> clazz = _scriptOptionsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_scriptOptionsRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_scriptOptionsRemoteModel != null) {
			try {
				Class<?> clazz = _scriptOptionsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_scriptOptionsRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_scriptOptionsRemoteModel != null) {
			try {
				Class<?> clazz = _scriptOptionsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_scriptOptionsRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_scriptOptionsRemoteModel != null) {
			try {
				Class<?> clazz = _scriptOptionsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_scriptOptionsRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_scriptOptionsRemoteModel != null) {
			try {
				Class<?> clazz = _scriptOptionsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_scriptOptionsRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getScriptName() {
		return _scriptName;
	}

	@Override
	public void setScriptName(String scriptName) {
		_scriptName = scriptName;

		if (_scriptOptionsRemoteModel != null) {
			try {
				Class<?> clazz = _scriptOptionsRemoteModel.getClass();

				Method method = clazz.getMethod("setScriptName", String.class);

				method.invoke(_scriptOptionsRemoteModel, scriptName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDependencyList() {
		return _dependencyList;
	}

	@Override
	public void setDependencyList(String dependencyList) {
		_dependencyList = dependencyList;

		if (_scriptOptionsRemoteModel != null) {
			try {
				Class<?> clazz = _scriptOptionsRemoteModel.getClass();

				Method method = clazz.getMethod("setDependencyList",
						String.class);

				method.invoke(_scriptOptionsRemoteModel, dependencyList);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Long getScriptCounter() {
		return _scriptCounter;
	}

	@Override
	public void setScriptCounter(Long scriptCounter) {
		_scriptCounter = scriptCounter;

		if (_scriptOptionsRemoteModel != null) {
			try {
				Class<?> clazz = _scriptOptionsRemoteModel.getClass();

				Method method = clazz.getMethod("setScriptCounter", Long.class);

				method.invoke(_scriptOptionsRemoteModel, scriptCounter);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getScriptOptionsRemoteModel() {
		return _scriptOptionsRemoteModel;
	}

	public void setScriptOptionsRemoteModel(
		BaseModel<?> scriptOptionsRemoteModel) {
		_scriptOptionsRemoteModel = scriptOptionsRemoteModel;
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

		Class<?> remoteModelClass = _scriptOptionsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_scriptOptionsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public ScriptOptions toEscapedModel() {
		return (ScriptOptions)ProxyUtil.newProxyInstance(ScriptOptions.class.getClassLoader(),
			new Class[] { ScriptOptions.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ScriptOptionsClp clone = new ScriptOptionsClp();

		clone.setScriptOptionsId(getScriptOptionsId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setScriptName(getScriptName());
		clone.setDependencyList(getDependencyList());
		clone.setScriptCounter(getScriptCounter());

		return clone;
	}

	@Override
	public int compareTo(ScriptOptions scriptOptions) {
		int value = 0;

		value = getScriptName().compareTo(scriptOptions.getScriptName());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreateDate(),
				scriptOptions.getCreateDate());

		value = value * -1;

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

		if (!(obj instanceof ScriptOptionsClp)) {
			return false;
		}

		ScriptOptionsClp scriptOptions = (ScriptOptionsClp)obj;

		long primaryKey = scriptOptions.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{ScriptOptionsId=");
		sb.append(getScriptOptionsId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", scriptName=");
		sb.append(getScriptName());
		sb.append(", dependencyList=");
		sb.append(getDependencyList());
		sb.append(", scriptCounter=");
		sb.append(getScriptCounter());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("hu.borkuti.peter.scriptpp.service.model.ScriptOptions");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ScriptOptionsId</column-name><column-value><![CDATA[");
		sb.append(getScriptOptionsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scriptName</column-name><column-value><![CDATA[");
		sb.append(getScriptName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dependencyList</column-name><column-value><![CDATA[");
		sb.append(getDependencyList());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scriptCounter</column-name><column-value><![CDATA[");
		sb.append(getScriptCounter());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ScriptOptionsId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _scriptName;
	private String _dependencyList;
	private Long _scriptCounter;
	private BaseModel<?> _scriptOptionsRemoteModel;
	private Class<?> _clpSerializerClass = hu.borkuti.peter.scriptpp.service.service.ClpSerializer.class;
}