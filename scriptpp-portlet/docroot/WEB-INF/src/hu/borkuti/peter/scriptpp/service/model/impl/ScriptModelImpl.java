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

package hu.borkuti.peter.scriptpp.service.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import hu.borkuti.peter.scriptpp.service.model.Script;
import hu.borkuti.peter.scriptpp.service.model.ScriptModel;
import hu.borkuti.peter.scriptpp.service.model.ScriptSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Script service. Represents a row in the &quot;scriptpp_Script&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link hu.borkuti.peter.scriptpp.service.model.ScriptModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ScriptImpl}.
 * </p>
 *
 * @author Peter Borkuti
 * @see ScriptImpl
 * @see hu.borkuti.peter.scriptpp.service.model.Script
 * @see hu.borkuti.peter.scriptpp.service.model.ScriptModel
 * @generated
 */
@JSON(strict = true)
public class ScriptModelImpl extends BaseModelImpl<Script>
	implements ScriptModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a script model instance should use the {@link hu.borkuti.peter.scriptpp.service.model.Script} interface instead.
	 */
	public static final String TABLE_NAME = "scriptpp_Script";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ScriptId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "scriptOptionsId", Types.BIGINT },
			{ "importContent", Types.VARCHAR },
			{ "moduleContent", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table scriptpp_Script (ScriptId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,scriptOptionsId LONG,importContent STRING null,moduleContent STRING null)";
	public static final String TABLE_SQL_DROP = "drop table scriptpp_Script";
	public static final String ORDER_BY_JPQL = " ORDER BY script.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY scriptpp_Script.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.hu.borkuti.peter.scriptpp.service.model.Script"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.hu.borkuti.peter.scriptpp.service.model.Script"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.hu.borkuti.peter.scriptpp.service.model.Script"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long SCRIPTOPTIONSID_COLUMN_BITMASK = 2L;
	public static long USERID_COLUMN_BITMASK = 4L;
	public static long CREATEDATE_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Script toModel(ScriptSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Script model = new ScriptImpl();

		model.setScriptId(soapModel.getScriptId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setScriptOptionsId(soapModel.getScriptOptionsId());
		model.setImportContent(soapModel.getImportContent());
		model.setModuleContent(soapModel.getModuleContent());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Script> toModels(ScriptSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Script> models = new ArrayList<Script>(soapModels.length);

		for (ScriptSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.hu.borkuti.peter.scriptpp.service.model.Script"));

	public ScriptModelImpl() {
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
	public Class<?> getModelClass() {
		return Script.class;
	}

	@Override
	public String getModelClassName() {
		return Script.class.getName();
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
		attributes.put("scriptOptionsId", getScriptOptionsId());
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

		Long scriptOptionsId = (Long)attributes.get("scriptOptionsId");

		if (scriptOptionsId != null) {
			setScriptOptionsId(scriptOptionsId);
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

	@JSON
	@Override
	public long getScriptId() {
		return _ScriptId;
	}

	@Override
	public void setScriptId(long ScriptId) {
		_ScriptId = ScriptId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getScriptOptionsId() {
		return _scriptOptionsId;
	}

	@Override
	public void setScriptOptionsId(long scriptOptionsId) {
		_columnBitmask |= SCRIPTOPTIONSID_COLUMN_BITMASK;

		if (!_setOriginalScriptOptionsId) {
			_setOriginalScriptOptionsId = true;

			_originalScriptOptionsId = _scriptOptionsId;
		}

		_scriptOptionsId = scriptOptionsId;
	}

	public long getOriginalScriptOptionsId() {
		return _originalScriptOptionsId;
	}

	@JSON
	@Override
	public String getImportContent() {
		if (_importContent == null) {
			return StringPool.BLANK;
		}
		else {
			return _importContent;
		}
	}

	@Override
	public void setImportContent(String importContent) {
		_importContent = importContent;
	}

	@JSON
	@Override
	public String getModuleContent() {
		if (_moduleContent == null) {
			return StringPool.BLANK;
		}
		else {
			return _moduleContent;
		}
	}

	@Override
	public void setModuleContent(String moduleContent) {
		_moduleContent = moduleContent;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Script.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Script toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Script)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ScriptImpl scriptImpl = new ScriptImpl();

		scriptImpl.setScriptId(getScriptId());
		scriptImpl.setCompanyId(getCompanyId());
		scriptImpl.setGroupId(getGroupId());
		scriptImpl.setUserId(getUserId());
		scriptImpl.setCreateDate(getCreateDate());
		scriptImpl.setModifiedDate(getModifiedDate());
		scriptImpl.setScriptOptionsId(getScriptOptionsId());
		scriptImpl.setImportContent(getImportContent());
		scriptImpl.setModuleContent(getModuleContent());

		scriptImpl.resetOriginalValues();

		return scriptImpl;
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

		if (!(obj instanceof Script)) {
			return false;
		}

		Script script = (Script)obj;

		long primaryKey = script.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		ScriptModelImpl scriptModelImpl = this;

		scriptModelImpl._originalGroupId = scriptModelImpl._groupId;

		scriptModelImpl._setOriginalGroupId = false;

		scriptModelImpl._originalUserId = scriptModelImpl._userId;

		scriptModelImpl._setOriginalUserId = false;

		scriptModelImpl._originalScriptOptionsId = scriptModelImpl._scriptOptionsId;

		scriptModelImpl._setOriginalScriptOptionsId = false;

		scriptModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Script> toCacheModel() {
		ScriptCacheModel scriptCacheModel = new ScriptCacheModel();

		scriptCacheModel.ScriptId = getScriptId();

		scriptCacheModel.companyId = getCompanyId();

		scriptCacheModel.groupId = getGroupId();

		scriptCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			scriptCacheModel.createDate = createDate.getTime();
		}
		else {
			scriptCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			scriptCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			scriptCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		scriptCacheModel.scriptOptionsId = getScriptOptionsId();

		scriptCacheModel.importContent = getImportContent();

		String importContent = scriptCacheModel.importContent;

		if ((importContent != null) && (importContent.length() == 0)) {
			scriptCacheModel.importContent = null;
		}

		scriptCacheModel.moduleContent = getModuleContent();

		String moduleContent = scriptCacheModel.moduleContent;

		if ((moduleContent != null) && (moduleContent.length() == 0)) {
			scriptCacheModel.moduleContent = null;
		}

		return scriptCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

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
		sb.append(", scriptOptionsId=");
		sb.append(getScriptOptionsId());
		sb.append(", importContent=");
		sb.append(getImportContent());
		sb.append(", moduleContent=");
		sb.append(getModuleContent());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

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
			"<column><column-name>scriptOptionsId</column-name><column-value><![CDATA[");
		sb.append(getScriptOptionsId());
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

	private static ClassLoader _classLoader = Script.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Script.class };
	private long _ScriptId;
	private long _companyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _scriptOptionsId;
	private long _originalScriptOptionsId;
	private boolean _setOriginalScriptOptionsId;
	private String _importContent;
	private String _moduleContent;
	private long _columnBitmask;
	private Script _escapedModel;
}