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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import hu.borkuti.peter.scriptpp.service.model.History;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing History in entity cache.
 *
 * @author Peter Borkuti
 * @see History
 * @generated
 */
public class HistoryCacheModel implements CacheModel<History>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{historyId=");
		sb.append(historyId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", line=");
		sb.append(line);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public History toEntityModel() {
		HistoryImpl historyImpl = new HistoryImpl();

		historyImpl.setHistoryId(historyId);
		historyImpl.setCompanyId(companyId);
		historyImpl.setGroupId(groupId);
		historyImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			historyImpl.setCreateDate(null);
		}
		else {
			historyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			historyImpl.setModifiedDate(null);
		}
		else {
			historyImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (line == null) {
			historyImpl.setLine(StringPool.BLANK);
		}
		else {
			historyImpl.setLine(line);
		}

		historyImpl.resetOriginalValues();

		return historyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		historyId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		line = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(historyId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (line == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(line);
		}
	}

	public long historyId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String line;
}