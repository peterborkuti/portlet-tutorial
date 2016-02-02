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

package permission.servicebuider.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author peter
 * @generated
 */
public class FirstnamesSoap implements Serializable {
	public static FirstnamesSoap toSoapModel(Firstnames model) {
		FirstnamesSoap soapModel = new FirstnamesSoap();

		soapModel.setFirstnameId(model.getFirstnameId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFirstname(model.getFirstname());

		return soapModel;
	}

	public static FirstnamesSoap[] toSoapModels(Firstnames[] models) {
		FirstnamesSoap[] soapModels = new FirstnamesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FirstnamesSoap[][] toSoapModels(Firstnames[][] models) {
		FirstnamesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FirstnamesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FirstnamesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FirstnamesSoap[] toSoapModels(List<Firstnames> models) {
		List<FirstnamesSoap> soapModels = new ArrayList<FirstnamesSoap>(models.size());

		for (Firstnames model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FirstnamesSoap[soapModels.size()]);
	}

	public FirstnamesSoap() {
	}

	public long getPrimaryKey() {
		return _firstnameId;
	}

	public void setPrimaryKey(long pk) {
		setFirstnameId(pk);
	}

	public long getFirstnameId() {
		return _firstnameId;
	}

	public void setFirstnameId(long firstnameId) {
		_firstnameId = firstnameId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getFirstname() {
		return _firstname;
	}

	public void setFirstname(String firstname) {
		_firstname = firstname;
	}

	private long _firstnameId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _firstname;
}