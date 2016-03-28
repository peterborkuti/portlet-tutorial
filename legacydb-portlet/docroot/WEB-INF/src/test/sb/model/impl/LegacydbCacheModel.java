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

package test.sb.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import test.sb.model.Legacydb;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Legacydb in entity cache.
 *
 * @author peter
 * @see Legacydb
 * @generated
 */
public class LegacydbCacheModel implements CacheModel<Legacydb>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{legacydbid=");
		sb.append(legacydbid);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Legacydb toEntityModel() {
		LegacydbImpl legacydbImpl = new LegacydbImpl();

		legacydbImpl.setLegacydbid(legacydbid);

		if (name == null) {
			legacydbImpl.setName(StringPool.BLANK);
		}
		else {
			legacydbImpl.setName(name);
		}

		legacydbImpl.resetOriginalValues();

		return legacydbImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		legacydbid = objectInput.readLong();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(legacydbid);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long legacydbid;
	public String name;
}