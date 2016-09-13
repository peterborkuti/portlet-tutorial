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

package com.liferay.hu.badge.service.model;

import com.liferay.hu.badge.service.service.BadgeLocalServiceUtil;
import com.liferay.hu.badge.service.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Borkuti Peter
 */
public class BadgeClp extends BaseModelImpl<Badge> implements Badge {
	public BadgeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Badge.class;
	}

	@Override
	public String getModelClassName() {
		return Badge.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _badgeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBadgeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _badgeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("badgeId", getBadgeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("badgeType", getBadgeType());
		attributes.put("assignDate", getAssignDate());
		attributes.put("toUser", getToUser());
		attributes.put("toUserFullName", getToUserFullName());
		attributes.put("fromUser", getFromUser());
		attributes.put("fromUserFullName", getFromUserFullName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long badgeId = (Long)attributes.get("badgeId");

		if (badgeId != null) {
			setBadgeId(badgeId);
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

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long badgeType = (Long)attributes.get("badgeType");

		if (badgeType != null) {
			setBadgeType(badgeType);
		}

		Date assignDate = (Date)attributes.get("assignDate");

		if (assignDate != null) {
			setAssignDate(assignDate);
		}

		Long toUser = (Long)attributes.get("toUser");

		if (toUser != null) {
			setToUser(toUser);
		}

		String toUserFullName = (String)attributes.get("toUserFullName");

		if (toUserFullName != null) {
			setToUserFullName(toUserFullName);
		}

		Long fromUser = (Long)attributes.get("fromUser");

		if (fromUser != null) {
			setFromUser(fromUser);
		}

		String fromUserFullName = (String)attributes.get("fromUserFullName");

		if (fromUserFullName != null) {
			setFromUserFullName(fromUserFullName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public long getBadgeId() {
		return _badgeId;
	}

	@Override
	public void setBadgeId(long badgeId) {
		_badgeId = badgeId;

		if (_badgeRemoteModel != null) {
			try {
				Class<?> clazz = _badgeRemoteModel.getClass();

				Method method = clazz.getMethod("setBadgeId", long.class);

				method.invoke(_badgeRemoteModel, badgeId);
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

		if (_badgeRemoteModel != null) {
			try {
				Class<?> clazz = _badgeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_badgeRemoteModel, groupId);
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

		if (_badgeRemoteModel != null) {
			try {
				Class<?> clazz = _badgeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_badgeRemoteModel, companyId);
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

		if (_badgeRemoteModel != null) {
			try {
				Class<?> clazz = _badgeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_badgeRemoteModel, userId);
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
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_badgeRemoteModel != null) {
			try {
				Class<?> clazz = _badgeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_badgeRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_badgeRemoteModel != null) {
			try {
				Class<?> clazz = _badgeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_badgeRemoteModel, createDate);
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

		if (_badgeRemoteModel != null) {
			try {
				Class<?> clazz = _badgeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_badgeRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBadgeType() {
		return _badgeType;
	}

	@Override
	public void setBadgeType(long badgeType) {
		_badgeType = badgeType;

		if (_badgeRemoteModel != null) {
			try {
				Class<?> clazz = _badgeRemoteModel.getClass();

				Method method = clazz.getMethod("setBadgeType", long.class);

				method.invoke(_badgeRemoteModel, badgeType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getAssignDate() {
		return _assignDate;
	}

	@Override
	public void setAssignDate(Date assignDate) {
		_assignDate = assignDate;

		if (_badgeRemoteModel != null) {
			try {
				Class<?> clazz = _badgeRemoteModel.getClass();

				Method method = clazz.getMethod("setAssignDate", Date.class);

				method.invoke(_badgeRemoteModel, assignDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getToUser() {
		return _toUser;
	}

	@Override
	public void setToUser(long toUser) {
		_toUser = toUser;

		if (_badgeRemoteModel != null) {
			try {
				Class<?> clazz = _badgeRemoteModel.getClass();

				Method method = clazz.getMethod("setToUser", long.class);

				method.invoke(_badgeRemoteModel, toUser);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getToUserFullName() {
		return _toUserFullName;
	}

	@Override
	public void setToUserFullName(String toUserFullName) {
		_toUserFullName = toUserFullName;

		if (_badgeRemoteModel != null) {
			try {
				Class<?> clazz = _badgeRemoteModel.getClass();

				Method method = clazz.getMethod("setToUserFullName",
						String.class);

				method.invoke(_badgeRemoteModel, toUserFullName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFromUser() {
		return _fromUser;
	}

	@Override
	public void setFromUser(long fromUser) {
		_fromUser = fromUser;

		if (_badgeRemoteModel != null) {
			try {
				Class<?> clazz = _badgeRemoteModel.getClass();

				Method method = clazz.getMethod("setFromUser", long.class);

				method.invoke(_badgeRemoteModel, fromUser);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFromUserFullName() {
		return _fromUserFullName;
	}

	@Override
	public void setFromUserFullName(String fromUserFullName) {
		_fromUserFullName = fromUserFullName;

		if (_badgeRemoteModel != null) {
			try {
				Class<?> clazz = _badgeRemoteModel.getClass();

				Method method = clazz.getMethod("setFromUserFullName",
						String.class);

				method.invoke(_badgeRemoteModel, fromUserFullName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_badgeRemoteModel != null) {
			try {
				Class<?> clazz = _badgeRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_badgeRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBadgeRemoteModel() {
		return _badgeRemoteModel;
	}

	public void setBadgeRemoteModel(BaseModel<?> badgeRemoteModel) {
		_badgeRemoteModel = badgeRemoteModel;
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

		Class<?> remoteModelClass = _badgeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_badgeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BadgeLocalServiceUtil.addBadge(this);
		}
		else {
			BadgeLocalServiceUtil.updateBadge(this);
		}
	}

	@Override
	public Badge toEscapedModel() {
		return (Badge)ProxyUtil.newProxyInstance(Badge.class.getClassLoader(),
			new Class[] { Badge.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BadgeClp clone = new BadgeClp();

		clone.setBadgeId(getBadgeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setBadgeType(getBadgeType());
		clone.setAssignDate(getAssignDate());
		clone.setToUser(getToUser());
		clone.setToUserFullName(getToUserFullName());
		clone.setFromUser(getFromUser());
		clone.setFromUserFullName(getFromUserFullName());
		clone.setDescription(getDescription());

		return clone;
	}

	@Override
	public int compareTo(Badge badge) {
		int value = 0;

		value = DateUtil.compareTo(getAssignDate(), badge.getAssignDate());

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

		if (!(obj instanceof BadgeClp)) {
			return false;
		}

		BadgeClp badge = (BadgeClp)obj;

		long primaryKey = badge.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{badgeId=");
		sb.append(getBadgeId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", badgeType=");
		sb.append(getBadgeType());
		sb.append(", assignDate=");
		sb.append(getAssignDate());
		sb.append(", toUser=");
		sb.append(getToUser());
		sb.append(", toUserFullName=");
		sb.append(getToUserFullName());
		sb.append(", fromUser=");
		sb.append(getFromUser());
		sb.append(", fromUserFullName=");
		sb.append(getFromUserFullName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.liferay.hu.badge.service.model.Badge");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>badgeId</column-name><column-value><![CDATA[");
		sb.append(getBadgeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
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
			"<column><column-name>badgeType</column-name><column-value><![CDATA[");
		sb.append(getBadgeType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assignDate</column-name><column-value><![CDATA[");
		sb.append(getAssignDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toUser</column-name><column-value><![CDATA[");
		sb.append(getToUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toUserFullName</column-name><column-value><![CDATA[");
		sb.append(getToUserFullName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fromUser</column-name><column-value><![CDATA[");
		sb.append(getFromUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fromUserFullName</column-name><column-value><![CDATA[");
		sb.append(getFromUserFullName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _badgeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _badgeType;
	private Date _assignDate;
	private long _toUser;
	private String _toUserFullName;
	private long _fromUser;
	private String _fromUserFullName;
	private String _description;
	private BaseModel<?> _badgeRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.hu.badge.service.service.ClpSerializer.class;
}