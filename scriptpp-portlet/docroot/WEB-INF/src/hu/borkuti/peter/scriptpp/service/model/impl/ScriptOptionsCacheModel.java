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

import hu.borkuti.peter.scriptpp.service.model.ScriptOptions;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ScriptOptions in entity cache.
 *
 * @author Peter Borkuti
 * @see ScriptOptions
 * @generated
 */
public class ScriptOptionsCacheModel implements CacheModel<ScriptOptions>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{ScriptOptionsId=");
		sb.append(ScriptOptionsId);
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
		sb.append(", scriptName=");
		sb.append(scriptName);
		sb.append(", dependencyList=");
		sb.append(dependencyList);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ScriptOptions toEntityModel() {
		ScriptOptionsImpl scriptOptionsImpl = new ScriptOptionsImpl();

		scriptOptionsImpl.setScriptOptionsId(ScriptOptionsId);
		scriptOptionsImpl.setCompanyId(companyId);
		scriptOptionsImpl.setGroupId(groupId);
		scriptOptionsImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			scriptOptionsImpl.setCreateDate(null);
		}
		else {
			scriptOptionsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			scriptOptionsImpl.setModifiedDate(null);
		}
		else {
			scriptOptionsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (scriptName == null) {
			scriptOptionsImpl.setScriptName(StringPool.BLANK);
		}
		else {
			scriptOptionsImpl.setScriptName(scriptName);
		}

		if (dependencyList == null) {
			scriptOptionsImpl.setDependencyList(StringPool.BLANK);
		}
		else {
			scriptOptionsImpl.setDependencyList(dependencyList);
		}

		scriptOptionsImpl.resetOriginalValues();

		return scriptOptionsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ScriptOptionsId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		scriptName = objectInput.readUTF();
		dependencyList = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ScriptOptionsId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (scriptName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(scriptName);
		}

		if (dependencyList == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dependencyList);
		}
	}

	public long ScriptOptionsId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String scriptName;
	public String dependencyList;
}