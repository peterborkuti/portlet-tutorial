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

package com.liferay.hu.badge.service.model.impl;

import com.liferay.hu.badge.service.model.Badge;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Badge in entity cache.
 *
 * @author Borkuti Peter
 * @see Badge
 * @generated
 */
public class BadgeCacheModel implements CacheModel<Badge>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{badgeId=");
		sb.append(badgeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", badgeType=");
		sb.append(badgeType);
		sb.append(", assignDate=");
		sb.append(assignDate);
		sb.append(", toUser=");
		sb.append(toUser);
		sb.append(", toUserFullName=");
		sb.append(toUserFullName);
		sb.append(", fromUser=");
		sb.append(fromUser);
		sb.append(", fromUserFullName=");
		sb.append(fromUserFullName);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Badge toEntityModel() {
		BadgeImpl badgeImpl = new BadgeImpl();

		badgeImpl.setBadgeId(badgeId);
		badgeImpl.setGroupId(groupId);
		badgeImpl.setCompanyId(companyId);
		badgeImpl.setUserId(userId);

		if (userName == null) {
			badgeImpl.setUserName(StringPool.BLANK);
		}
		else {
			badgeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			badgeImpl.setCreateDate(null);
		}
		else {
			badgeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			badgeImpl.setModifiedDate(null);
		}
		else {
			badgeImpl.setModifiedDate(new Date(modifiedDate));
		}

		badgeImpl.setBadgeType(badgeType);

		if (assignDate == Long.MIN_VALUE) {
			badgeImpl.setAssignDate(null);
		}
		else {
			badgeImpl.setAssignDate(new Date(assignDate));
		}

		badgeImpl.setToUser(toUser);

		if (toUserFullName == null) {
			badgeImpl.setToUserFullName(StringPool.BLANK);
		}
		else {
			badgeImpl.setToUserFullName(toUserFullName);
		}

		badgeImpl.setFromUser(fromUser);

		if (fromUserFullName == null) {
			badgeImpl.setFromUserFullName(StringPool.BLANK);
		}
		else {
			badgeImpl.setFromUserFullName(fromUserFullName);
		}

		if (description == null) {
			badgeImpl.setDescription(StringPool.BLANK);
		}
		else {
			badgeImpl.setDescription(description);
		}

		badgeImpl.resetOriginalValues();

		return badgeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		badgeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		badgeType = objectInput.readLong();
		assignDate = objectInput.readLong();
		toUser = objectInput.readLong();
		toUserFullName = objectInput.readUTF();
		fromUser = objectInput.readLong();
		fromUserFullName = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(badgeId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(badgeType);
		objectOutput.writeLong(assignDate);
		objectOutput.writeLong(toUser);

		if (toUserFullName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(toUserFullName);
		}

		objectOutput.writeLong(fromUser);

		if (fromUserFullName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fromUserFullName);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long badgeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long badgeType;
	public long assignDate;
	public long toUser;
	public String toUserFullName;
	public long fromUser;
	public String fromUserFullName;
	public String description;
}