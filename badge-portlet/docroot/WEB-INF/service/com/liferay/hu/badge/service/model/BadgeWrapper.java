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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Badge}.
 * </p>
 *
 * @author Borkuti Peter
 * @see Badge
 * @generated
 */
public class BadgeWrapper implements Badge, ModelWrapper<Badge> {
	public BadgeWrapper(Badge badge) {
		_badge = badge;
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

	/**
	* Returns the primary key of this badge.
	*
	* @return the primary key of this badge
	*/
	@Override
	public long getPrimaryKey() {
		return _badge.getPrimaryKey();
	}

	/**
	* Sets the primary key of this badge.
	*
	* @param primaryKey the primary key of this badge
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_badge.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the badge ID of this badge.
	*
	* @return the badge ID of this badge
	*/
	@Override
	public long getBadgeId() {
		return _badge.getBadgeId();
	}

	/**
	* Sets the badge ID of this badge.
	*
	* @param badgeId the badge ID of this badge
	*/
	@Override
	public void setBadgeId(long badgeId) {
		_badge.setBadgeId(badgeId);
	}

	/**
	* Returns the group ID of this badge.
	*
	* @return the group ID of this badge
	*/
	@Override
	public long getGroupId() {
		return _badge.getGroupId();
	}

	/**
	* Sets the group ID of this badge.
	*
	* @param groupId the group ID of this badge
	*/
	@Override
	public void setGroupId(long groupId) {
		_badge.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this badge.
	*
	* @return the company ID of this badge
	*/
	@Override
	public long getCompanyId() {
		return _badge.getCompanyId();
	}

	/**
	* Sets the company ID of this badge.
	*
	* @param companyId the company ID of this badge
	*/
	@Override
	public void setCompanyId(long companyId) {
		_badge.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this badge.
	*
	* @return the user ID of this badge
	*/
	@Override
	public long getUserId() {
		return _badge.getUserId();
	}

	/**
	* Sets the user ID of this badge.
	*
	* @param userId the user ID of this badge
	*/
	@Override
	public void setUserId(long userId) {
		_badge.setUserId(userId);
	}

	/**
	* Returns the user uuid of this badge.
	*
	* @return the user uuid of this badge
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _badge.getUserUuid();
	}

	/**
	* Sets the user uuid of this badge.
	*
	* @param userUuid the user uuid of this badge
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_badge.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this badge.
	*
	* @return the user name of this badge
	*/
	@Override
	public java.lang.String getUserName() {
		return _badge.getUserName();
	}

	/**
	* Sets the user name of this badge.
	*
	* @param userName the user name of this badge
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_badge.setUserName(userName);
	}

	/**
	* Returns the create date of this badge.
	*
	* @return the create date of this badge
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _badge.getCreateDate();
	}

	/**
	* Sets the create date of this badge.
	*
	* @param createDate the create date of this badge
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_badge.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this badge.
	*
	* @return the modified date of this badge
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _badge.getModifiedDate();
	}

	/**
	* Sets the modified date of this badge.
	*
	* @param modifiedDate the modified date of this badge
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_badge.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the badge type of this badge.
	*
	* @return the badge type of this badge
	*/
	@Override
	public long getBadgeType() {
		return _badge.getBadgeType();
	}

	/**
	* Sets the badge type of this badge.
	*
	* @param badgeType the badge type of this badge
	*/
	@Override
	public void setBadgeType(long badgeType) {
		_badge.setBadgeType(badgeType);
	}

	/**
	* Returns the assign date of this badge.
	*
	* @return the assign date of this badge
	*/
	@Override
	public java.util.Date getAssignDate() {
		return _badge.getAssignDate();
	}

	/**
	* Sets the assign date of this badge.
	*
	* @param assignDate the assign date of this badge
	*/
	@Override
	public void setAssignDate(java.util.Date assignDate) {
		_badge.setAssignDate(assignDate);
	}

	/**
	* Returns the to user of this badge.
	*
	* @return the to user of this badge
	*/
	@Override
	public long getToUser() {
		return _badge.getToUser();
	}

	/**
	* Sets the to user of this badge.
	*
	* @param toUser the to user of this badge
	*/
	@Override
	public void setToUser(long toUser) {
		_badge.setToUser(toUser);
	}

	/**
	* Returns the to user full name of this badge.
	*
	* @return the to user full name of this badge
	*/
	@Override
	public java.lang.String getToUserFullName() {
		return _badge.getToUserFullName();
	}

	/**
	* Sets the to user full name of this badge.
	*
	* @param toUserFullName the to user full name of this badge
	*/
	@Override
	public void setToUserFullName(java.lang.String toUserFullName) {
		_badge.setToUserFullName(toUserFullName);
	}

	/**
	* Returns the from user of this badge.
	*
	* @return the from user of this badge
	*/
	@Override
	public long getFromUser() {
		return _badge.getFromUser();
	}

	/**
	* Sets the from user of this badge.
	*
	* @param fromUser the from user of this badge
	*/
	@Override
	public void setFromUser(long fromUser) {
		_badge.setFromUser(fromUser);
	}

	/**
	* Returns the from user full name of this badge.
	*
	* @return the from user full name of this badge
	*/
	@Override
	public java.lang.String getFromUserFullName() {
		return _badge.getFromUserFullName();
	}

	/**
	* Sets the from user full name of this badge.
	*
	* @param fromUserFullName the from user full name of this badge
	*/
	@Override
	public void setFromUserFullName(java.lang.String fromUserFullName) {
		_badge.setFromUserFullName(fromUserFullName);
	}

	/**
	* Returns the description of this badge.
	*
	* @return the description of this badge
	*/
	@Override
	public java.lang.String getDescription() {
		return _badge.getDescription();
	}

	/**
	* Sets the description of this badge.
	*
	* @param description the description of this badge
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_badge.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _badge.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_badge.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _badge.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_badge.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _badge.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _badge.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_badge.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _badge.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_badge.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_badge.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_badge.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BadgeWrapper((Badge)_badge.clone());
	}

	@Override
	public int compareTo(com.liferay.hu.badge.service.model.Badge badge) {
		return _badge.compareTo(badge);
	}

	@Override
	public int hashCode() {
		return _badge.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.hu.badge.service.model.Badge> toCacheModel() {
		return _badge.toCacheModel();
	}

	@Override
	public com.liferay.hu.badge.service.model.Badge toEscapedModel() {
		return new BadgeWrapper(_badge.toEscapedModel());
	}

	@Override
	public com.liferay.hu.badge.service.model.Badge toUnescapedModel() {
		return new BadgeWrapper(_badge.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _badge.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _badge.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_badge.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BadgeWrapper)) {
			return false;
		}

		BadgeWrapper badgeWrapper = (BadgeWrapper)obj;

		if (Validator.equals(_badge, badgeWrapper._badge)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Badge getWrappedBadge() {
		return _badge;
	}

	@Override
	public Badge getWrappedModel() {
		return _badge;
	}

	@Override
	public void resetOriginalValues() {
		_badge.resetOriginalValues();
	}

	private Badge _badge;
}