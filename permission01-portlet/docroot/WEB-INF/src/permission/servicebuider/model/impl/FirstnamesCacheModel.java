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

package permission.servicebuider.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import permission.servicebuider.model.Firstnames;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Firstnames in entity cache.
 *
 * @author peter
 * @see Firstnames
 * @generated
 */
public class FirstnamesCacheModel implements CacheModel<Firstnames>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{firstnameId=");
		sb.append(firstnameId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", firstname=");
		sb.append(firstname);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Firstnames toEntityModel() {
		FirstnamesImpl firstnamesImpl = new FirstnamesImpl();

		firstnamesImpl.setFirstnameId(firstnameId);
		firstnamesImpl.setGroupId(groupId);
		firstnamesImpl.setCompanyId(companyId);
		firstnamesImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			firstnamesImpl.setCreateDate(null);
		}
		else {
			firstnamesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			firstnamesImpl.setModifiedDate(null);
		}
		else {
			firstnamesImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (firstname == null) {
			firstnamesImpl.setFirstname(StringPool.BLANK);
		}
		else {
			firstnamesImpl.setFirstname(firstname);
		}

		firstnamesImpl.resetOriginalValues();

		return firstnamesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		firstnameId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		firstname = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(firstnameId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (firstname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstname);
		}
	}

	public long firstnameId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String firstname;
}