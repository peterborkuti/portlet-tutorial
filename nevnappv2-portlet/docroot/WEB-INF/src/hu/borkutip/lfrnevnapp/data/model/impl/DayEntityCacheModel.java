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
import com.liferay.portal.model.CacheModel;

import hu.borkutip.lfrnevnapp.data.model.DayEntity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DayEntity in entity cache.
 *
 * @author Péter Borkuti
 * @see DayEntity
 * @generated
 */
public class DayEntityCacheModel implements CacheModel<DayEntity>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{dayId=");
		sb.append(dayId);
		sb.append(", month=");
		sb.append(month);
		sb.append(", day=");
		sb.append(day);
		sb.append(", nameId=");
		sb.append(nameId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DayEntity toEntityModel() {
		DayEntityImpl dayEntityImpl = new DayEntityImpl();

		dayEntityImpl.setDayId(dayId);
		dayEntityImpl.setMonth(month);
		dayEntityImpl.setDay(day);
		dayEntityImpl.setNameId(nameId);

		dayEntityImpl.resetOriginalValues();

		return dayEntityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dayId = objectInput.readLong();
		month = objectInput.readInt();
		day = objectInput.readInt();
		nameId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dayId);
		objectOutput.writeInt(month);
		objectOutput.writeInt(day);
		objectOutput.writeLong(nameId);
	}

	public long dayId;
	public int month;
	public int day;
	public long nameId;
}