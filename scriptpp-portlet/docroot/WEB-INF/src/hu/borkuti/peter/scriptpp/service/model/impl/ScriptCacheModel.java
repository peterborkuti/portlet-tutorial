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

import hu.borkuti.peter.scriptpp.service.model.Script;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Script in entity cache.
 *
 * @author Peter Borkuti
 * @see Script
 * @generated
 */
public class ScriptCacheModel implements CacheModel<Script>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{ScriptId=");
		sb.append(ScriptId);
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
		sb.append(", importContent=");
		sb.append(importContent);
		sb.append(", moduleContent=");
		sb.append(moduleContent);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Script toEntityModel() {
		ScriptImpl scriptImpl = new ScriptImpl();

		scriptImpl.setScriptId(ScriptId);
		scriptImpl.setCompanyId(companyId);
		scriptImpl.setGroupId(groupId);
		scriptImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			scriptImpl.setCreateDate(null);
		}
		else {
			scriptImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			scriptImpl.setModifiedDate(null);
		}
		else {
			scriptImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (importContent == null) {
			scriptImpl.setImportContent(StringPool.BLANK);
		}
		else {
			scriptImpl.setImportContent(importContent);
		}

		if (moduleContent == null) {
			scriptImpl.setModuleContent(StringPool.BLANK);
		}
		else {
			scriptImpl.setModuleContent(moduleContent);
		}

		scriptImpl.resetOriginalValues();

		return scriptImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ScriptId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		importContent = objectInput.readUTF();
		moduleContent = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ScriptId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (importContent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(importContent);
		}

		if (moduleContent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(moduleContent);
		}
	}

	public long ScriptId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String importContent;
	public String moduleContent;
}