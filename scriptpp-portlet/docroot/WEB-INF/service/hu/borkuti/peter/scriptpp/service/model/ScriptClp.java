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
import hu.borkuti.peter.scriptpp.service.service.ScriptLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Peter Borkuti
 */
public class ScriptClp extends BaseModelImpl<Script> implements Script {
	public ScriptClp() {
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
	public long getPrimaryKey() {
		return _ScriptId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setScriptId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ScriptId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		String importContent = (String)attributes.get("importContent");

		if (importContent != null) {
			setImportContent(importContent);
		}

		String moduleContent = (String)attributes.get("moduleContent");

		if (moduleContent != null) {
			setModuleContent(moduleContent);
		}
	}

	@Override
	public long getScriptId() {
		return _ScriptId;
	}

	@Override
	public void setScriptId(long ScriptId) {
		_ScriptId = ScriptId;

		if (_scriptRemoteModel != null) {
			try {
				Class<?> clazz = _scriptRemoteModel.getClass();

				Method method = clazz.getMethod("setScriptId", long.class);

				method.invoke(_scriptRemoteModel, ScriptId);
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

		if (_scriptRemoteModel != null) {
			try {
				Class<?> clazz = _scriptRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_scriptRemoteModel, companyId);
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

		if (_scriptRemoteModel != null) {
			try {
				Class<?> clazz = _scriptRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_scriptRemoteModel, groupId);
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

		if (_scriptRemoteModel != null) {
			try {
				Class<?> clazz = _scriptRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_scriptRemoteModel, userId);
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

		if (_scriptRemoteModel != null) {
			try {
				Class<?> clazz = _scriptRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_scriptRemoteModel, createDate);
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

		if (_scriptRemoteModel != null) {
			try {
				Class<?> clazz = _scriptRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_scriptRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImportContent() {
		return _importContent;
	}

	@Override
	public void setImportContent(String importContent) {
		_importContent = importContent;

		if (_scriptRemoteModel != null) {
			try {
				Class<?> clazz = _scriptRemoteModel.getClass();

				Method method = clazz.getMethod("setImportContent", String.class);

				method.invoke(_scriptRemoteModel, importContent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getModuleContent() {
		return _moduleContent;
	}

	@Override
	public void setModuleContent(String moduleContent) {
		_moduleContent = moduleContent;

		if (_scriptRemoteModel != null) {
			try {
				Class<?> clazz = _scriptRemoteModel.getClass();

				Method method = clazz.getMethod("setModuleContent", String.class);

				method.invoke(_scriptRemoteModel, moduleContent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getScriptRemoteModel() {
		return _scriptRemoteModel;
	}

	public void setScriptRemoteModel(BaseModel<?> scriptRemoteModel) {
		_scriptRemoteModel = scriptRemoteModel;
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

		Class<?> remoteModelClass = _scriptRemoteModel.getClass();

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

		Object returnValue = method.invoke(_scriptRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ScriptLocalServiceUtil.addScript(this);
		}
		else {
			ScriptLocalServiceUtil.updateScript(this);
		}
	}

	@Override
	public Script toEscapedModel() {
		return (Script)ProxyUtil.newProxyInstance(Script.class.getClassLoader(),
			new Class[] { Script.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ScriptClp clone = new ScriptClp();

		clone.setScriptId(getScriptId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setImportContent(getImportContent());
		clone.setModuleContent(getModuleContent());

		return clone;
	}

	@Override
	public int compareTo(Script script) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), script.getCreateDate());

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

		if (!(obj instanceof ScriptClp)) {
			return false;
		}

		ScriptClp script = (ScriptClp)obj;

		long primaryKey = script.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{ScriptId=");
		sb.append(getScriptId());
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
		sb.append(", importContent=");
		sb.append(getImportContent());
		sb.append(", moduleContent=");
		sb.append(getModuleContent());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("hu.borkuti.peter.scriptpp.service.model.Script");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ScriptId</column-name><column-value><![CDATA[");
		sb.append(getScriptId());
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
			"<column><column-name>importContent</column-name><column-value><![CDATA[");
		sb.append(getImportContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moduleContent</column-name><column-value><![CDATA[");
		sb.append(getModuleContent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ScriptId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _importContent;
	private String _moduleContent;
	private BaseModel<?> _scriptRemoteModel;
	private Class<?> _clpSerializerClass = hu.borkuti.peter.scriptpp.service.service.ClpSerializer.class;
}