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
 * This class is used by SOAP remote services, specifically {@link hu.borkuti.peter.scriptpp.service.service.http.ScriptServiceSoap}.
 *
 * @author Peter Borkuti
 * @see hu.borkuti.peter.scriptpp.service.service.http.ScriptServiceSoap
 * @generated
 */
public class ScriptSoap implements Serializable {
	public static ScriptSoap toSoapModel(Script model) {
		ScriptSoap soapModel = new ScriptSoap();

		soapModel.setScriptId(model.getScriptId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setImportContent(model.getImportContent());
		soapModel.setModuleContent(model.getModuleContent());

		return soapModel;
	}

	public static ScriptSoap[] toSoapModels(Script[] models) {
		ScriptSoap[] soapModels = new ScriptSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ScriptSoap[][] toSoapModels(Script[][] models) {
		ScriptSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ScriptSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ScriptSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ScriptSoap[] toSoapModels(List<Script> models) {
		List<ScriptSoap> soapModels = new ArrayList<ScriptSoap>(models.size());

		for (Script model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ScriptSoap[soapModels.size()]);
	}

	public ScriptSoap() {
	}

	public long getPrimaryKey() {
		return _ScriptId;
	}

	public void setPrimaryKey(long pk) {
		setScriptId(pk);
	}

	public long getScriptId() {
		return _ScriptId;
	}

	public void setScriptId(long ScriptId) {
		_ScriptId = ScriptId;
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

	public String getImportContent() {
		return _importContent;
	}

	public void setImportContent(String importContent) {
		_importContent = importContent;
	}

	public String getModuleContent() {
		return _moduleContent;
	}

	public void setModuleContent(String moduleContent) {
		_moduleContent = moduleContent;
	}

	private long _ScriptId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _importContent;
	private String _moduleContent;
}