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

package test.sb.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link test.sb.service.http.LegacydbServiceSoap}.
 *
 * @author peter
 * @see test.sb.service.http.LegacydbServiceSoap
 * @generated
 */
public class LegacydbSoap implements Serializable {
	public static LegacydbSoap toSoapModel(Legacydb model) {
		LegacydbSoap soapModel = new LegacydbSoap();

		soapModel.setLegacydbid(model.getLegacydbid());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static LegacydbSoap[] toSoapModels(Legacydb[] models) {
		LegacydbSoap[] soapModels = new LegacydbSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegacydbSoap[][] toSoapModels(Legacydb[][] models) {
		LegacydbSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegacydbSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegacydbSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegacydbSoap[] toSoapModels(List<Legacydb> models) {
		List<LegacydbSoap> soapModels = new ArrayList<LegacydbSoap>(models.size());

		for (Legacydb model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegacydbSoap[soapModels.size()]);
	}

	public LegacydbSoap() {
	}

	public long getPrimaryKey() {
		return _legacydbid;
	}

	public void setPrimaryKey(long pk) {
		setLegacydbid(pk);
	}

	public long getLegacydbid() {
		return _legacydbid;
	}

	public void setLegacydbid(long legacydbid) {
		_legacydbid = legacydbid;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _legacydbid;
	private String _name;
}