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
 * This class is used by SOAP remote services, specifically {@link hu.borkutip.lfrnevnapp.data.service.http.NameEntityServiceSoap}.
 *
 * @author Péter Borkuti
 * @see hu.borkutip.lfrnevnapp.data.service.http.NameEntityServiceSoap
 * @generated
 */
public class NameEntitySoap implements Serializable {
	public static NameEntitySoap toSoapModel(NameEntity model) {
		NameEntitySoap soapModel = new NameEntitySoap();

		soapModel.setNameId(model.getNameId());
		soapModel.setName(model.getName());
		soapModel.setGender(model.getGender());

		return soapModel;
	}

	public static NameEntitySoap[] toSoapModels(NameEntity[] models) {
		NameEntitySoap[] soapModels = new NameEntitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NameEntitySoap[][] toSoapModels(NameEntity[][] models) {
		NameEntitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NameEntitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new NameEntitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NameEntitySoap[] toSoapModels(List<NameEntity> models) {
		List<NameEntitySoap> soapModels = new ArrayList<NameEntitySoap>(models.size());

		for (NameEntity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NameEntitySoap[soapModels.size()]);
	}

	public NameEntitySoap() {
	}

	public long getPrimaryKey() {
		return _nameId;
	}

	public void setPrimaryKey(long pk) {
		setNameId(pk);
	}

	public long getNameId() {
		return _nameId;
	}

	public void setNameId(long nameId) {
		_nameId = nameId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getGender() {
		return _gender;
	}

	public void setGender(int gender) {
		_gender = gender;
	}

	private long _nameId;
	private String _name;
	private int _gender;
}