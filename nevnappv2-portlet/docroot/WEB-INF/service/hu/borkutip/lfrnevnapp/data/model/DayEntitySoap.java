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

package hu.borkutip.lfrnevnapp.data.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link hu.borkutip.lfrnevnapp.data.service.http.DayEntityServiceSoap}.
 *
 * @author Péter Borkuti
 * @see hu.borkutip.lfrnevnapp.data.service.http.DayEntityServiceSoap
 * @generated
 */
public class DayEntitySoap implements Serializable {
	public static DayEntitySoap toSoapModel(DayEntity model) {
		DayEntitySoap soapModel = new DayEntitySoap();

		soapModel.setDayId(model.getDayId());
		soapModel.setMonth(model.getMonth());
		soapModel.setDay(model.getDay());
		soapModel.setNameId(model.getNameId());

		return soapModel;
	}

	public static DayEntitySoap[] toSoapModels(DayEntity[] models) {
		DayEntitySoap[] soapModels = new DayEntitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DayEntitySoap[][] toSoapModels(DayEntity[][] models) {
		DayEntitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DayEntitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new DayEntitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DayEntitySoap[] toSoapModels(List<DayEntity> models) {
		List<DayEntitySoap> soapModels = new ArrayList<DayEntitySoap>(models.size());

		for (DayEntity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DayEntitySoap[soapModels.size()]);
	}

	public DayEntitySoap() {
	}

	public long getPrimaryKey() {
		return _dayId;
	}

	public void setPrimaryKey(long pk) {
		setDayId(pk);
	}

	public long getDayId() {
		return _dayId;
	}

	public void setDayId(long dayId) {
		_dayId = dayId;
	}

	public int getMonth() {
		return _month;
	}

	public void setMonth(int month) {
		_month = month;
	}

	public int getDay() {
		return _day;
	}

	public void setDay(int day) {
		_day = day;
	}

	public long getNameId() {
		return _nameId;
	}

	public void setNameId(long nameId) {
		_nameId = nameId;
	}

	private long _dayId;
	private int _month;
	private int _day;
	private long _nameId;
}