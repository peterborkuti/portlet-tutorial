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

package hu.borkuti.peter.scriptpp.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link hu.borkuti.peter.scriptpp.service.service.http.HistoryServiceSoap}.
 *
 * @author Peter Borkuti
 * @see hu.borkuti.peter.scriptpp.service.service.http.HistoryServiceSoap
 * @generated
 */
public class HistorySoap implements Serializable {
	public static HistorySoap toSoapModel(History model) {
		HistorySoap soapModel = new HistorySoap();

		soapModel.setHistoryId(model.getHistoryId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLine(model.getLine());

		return soapModel;
	}

	public static HistorySoap[] toSoapModels(History[] models) {
		HistorySoap[] soapModels = new HistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HistorySoap[][] toSoapModels(History[][] models) {
		HistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new HistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HistorySoap[] toSoapModels(List<History> models) {
		List<HistorySoap> soapModels = new ArrayList<HistorySoap>(models.size());

		for (History model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HistorySoap[soapModels.size()]);
	}

	public HistorySoap() {
	}

	public long getPrimaryKey() {
		return _historyId;
	}

	public void setPrimaryKey(long pk) {
		setHistoryId(pk);
	}

	public long getHistoryId() {
		return _historyId;
	}

	public void setHistoryId(long historyId) {
		_historyId = historyId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public String getLine() {
		return _line;
	}

	public void setLine(String line) {
		_line = line;
	}

	private long _historyId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _line;
}