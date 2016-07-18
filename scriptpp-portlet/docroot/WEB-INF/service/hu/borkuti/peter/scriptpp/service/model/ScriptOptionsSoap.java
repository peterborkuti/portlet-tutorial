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
 * This class is used by SOAP remote services, specifically {@link hu.borkuti.peter.scriptpp.service.service.http.ScriptOptionsServiceSoap}.
 *
 * @author Peter Borkuti
 * @see hu.borkuti.peter.scriptpp.service.service.http.ScriptOptionsServiceSoap
 * @generated
 */
public class ScriptOptionsSoap implements Serializable {
	public static ScriptOptionsSoap toSoapModel(ScriptOptions model) {
		ScriptOptionsSoap soapModel = new ScriptOptionsSoap();

		soapModel.setScriptOptionsId(model.getScriptOptionsId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setScriptName(model.getScriptName());
		soapModel.setDependencyList(model.getDependencyList());
		soapModel.setScriptCounter(model.getScriptCounter());

		return soapModel;
	}

	public static ScriptOptionsSoap[] toSoapModels(ScriptOptions[] models) {
		ScriptOptionsSoap[] soapModels = new ScriptOptionsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ScriptOptionsSoap[][] toSoapModels(ScriptOptions[][] models) {
		ScriptOptionsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ScriptOptionsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ScriptOptionsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ScriptOptionsSoap[] toSoapModels(List<ScriptOptions> models) {
		List<ScriptOptionsSoap> soapModels = new ArrayList<ScriptOptionsSoap>(models.size());

		for (ScriptOptions model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ScriptOptionsSoap[soapModels.size()]);
	}

	public ScriptOptionsSoap() {
	}

	public long getPrimaryKey() {
		return _ScriptOptionsId;
	}

	public void setPrimaryKey(long pk) {
		setScriptOptionsId(pk);
	}

	public long getScriptOptionsId() {
		return _ScriptOptionsId;
	}

	public void setScriptOptionsId(long ScriptOptionsId) {
		_ScriptOptionsId = ScriptOptionsId;
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

	public String getScriptName() {
		return _scriptName;
	}

	public void setScriptName(String scriptName) {
		_scriptName = scriptName;
	}

	public String getDependencyList() {
		return _dependencyList;
	}

	public void setDependencyList(String dependencyList) {
		_dependencyList = dependencyList;
	}

	public Long getScriptCounter() {
		return _scriptCounter;
	}

	public void setScriptCounter(Long scriptCounter) {
		_scriptCounter = scriptCounter;
	}

	private long _ScriptOptionsId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _scriptName;
	private String _dependencyList;
	private Long _scriptCounter;
}