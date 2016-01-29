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

package hu.borkutip.lfrnevnapp.data.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import hu.borkutip.lfrnevnapp.data.model.NameEntity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing NameEntity in entity cache.
 *
 * @author Péter Borkuti
 * @see NameEntity
 * @generated
 */
public class NameEntityCacheModel implements CacheModel<NameEntity>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{nameId=");
		sb.append(nameId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", gender=");
		sb.append(gender);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public NameEntity toEntityModel() {
		NameEntityImpl nameEntityImpl = new NameEntityImpl();

		nameEntityImpl.setNameId(nameId);

		if (name == null) {
			nameEntityImpl.setName(StringPool.BLANK);
		}
		else {
			nameEntityImpl.setName(name);
		}

		nameEntityImpl.setGender(gender);

		nameEntityImpl.resetOriginalValues();

		return nameEntityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		nameId = objectInput.readLong();
		name = objectInput.readUTF();
		gender = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(nameId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(gender);
	}

	public long nameId;
	public String name;
	public int gender;
}