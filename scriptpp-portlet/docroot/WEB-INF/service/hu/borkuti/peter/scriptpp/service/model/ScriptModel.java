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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Script service. Represents a row in the &quot;scriptpp_Script&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptImpl}.
 * </p>
 *
 * @author Peter Borkuti
 * @see Script
 * @see hu.borkuti.peter.scriptpp.service.model.impl.ScriptImpl
 * @see hu.borkuti.peter.scriptpp.service.model.impl.ScriptModelImpl
 * @generated
 */
public interface ScriptModel extends BaseModel<Script> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a script model instance should use the {@link Script} interface instead.
	 */

	/**
	 * Returns the primary key of this script.
	 *
	 * @return the primary key of this script
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this script.
	 *
	 * @param primaryKey the primary key of this script
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the script ID of this script.
	 *
	 * @return the script ID of this script
	 */
	public long getScriptId();

	/**
	 * Sets the script ID of this script.
	 *
	 * @param ScriptId the script ID of this script
	 */
	public void setScriptId(long ScriptId);

	/**
	 * Returns the company ID of this script.
	 *
	 * @return the company ID of this script
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this script.
	 *
	 * @param companyId the company ID of this script
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this script.
	 *
	 * @return the group ID of this script
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this script.
	 *
	 * @param groupId the group ID of this script
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this script.
	 *
	 * @return the user ID of this script
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this script.
	 *
	 * @param userId the user ID of this script
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this script.
	 *
	 * @return the user uuid of this script
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this script.
	 *
	 * @param userUuid the user uuid of this script
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this script.
	 *
	 * @return the create date of this script
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this script.
	 *
	 * @param createDate the create date of this script
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this script.
	 *
	 * @return the modified date of this script
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this script.
	 *
	 * @param modifiedDate the modified date of this script
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the script options ID of this script.
	 *
	 * @return the script options ID of this script
	 */
	public long getScriptOptionsId();

	/**
	 * Sets the script options ID of this script.
	 *
	 * @param scriptOptionsId the script options ID of this script
	 */
	public void setScriptOptionsId(long scriptOptionsId);

	/**
	 * Returns the import content of this script.
	 *
	 * @return the import content of this script
	 */
	@AutoEscape
	public String getImportContent();

	/**
	 * Sets the import content of this script.
	 *
	 * @param importContent the import content of this script
	 */
	public void setImportContent(String importContent);

	/**
	 * Returns the module content of this script.
	 *
	 * @return the module content of this script
	 */
	@AutoEscape
	public String getModuleContent();

	/**
	 * Sets the module content of this script.
	 *
	 * @param moduleContent the module content of this script
	 */
	public void setModuleContent(String moduleContent);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(hu.borkuti.peter.scriptpp.service.model.Script script);

	@Override
	public int hashCode();

	@Override
	public CacheModel<hu.borkuti.peter.scriptpp.service.model.Script> toCacheModel();

	@Override
	public hu.borkuti.peter.scriptpp.service.model.Script toEscapedModel();

	@Override
	public hu.borkuti.peter.scriptpp.service.model.Script toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}