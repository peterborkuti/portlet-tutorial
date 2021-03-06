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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import test.sb.model.Legacydb;
import test.sb.model.LegacydbModel;
import test.sb.model.LegacydbSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Legacydb service. Represents a row in the &quot;legacydb&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link test.sb.model.LegacydbModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LegacydbImpl}.
 * </p>
 *
 * @author peter
 * @see LegacydbImpl
 * @see test.sb.model.Legacydb
 * @see test.sb.model.LegacydbModel
 * @generated
 */
@JSON(strict = true)
public class LegacydbModelImpl extends BaseModelImpl<Legacydb>
	implements LegacydbModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a legacydb model instance should use the {@link test.sb.model.Legacydb} interface instead.
	 */
	public static final String TABLE_NAME = "legacydb";
	public static final Object[][] TABLE_COLUMNS = {
			{ "legacydbid", Types.BIGINT },
			{ "name", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table legacydb (legacydbid LONG not null primary key,name VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table legacydb";
	public static final String ORDER_BY_JPQL = " ORDER BY legacydb.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY legacydb.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.test.sb.model.Legacydb"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.test.sb.model.Legacydb"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.test.sb.model.Legacydb"),
			true);
	public static long NAME_COLUMN_BITMASK = 1L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Legacydb toModel(LegacydbSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Legacydb model = new LegacydbImpl();

		model.setLegacydbid(soapModel.getLegacydbid());
		model.setName(soapModel.getName());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Legacydb> toModels(LegacydbSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Legacydb> models = new ArrayList<Legacydb>(soapModels.length);

		for (LegacydbSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.test.sb.model.Legacydb"));

	public LegacydbModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _legacydbid;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLegacydbid(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _legacydbid;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Legacydb.class;
	}

	@Override
	public String getModelClassName() {
		return Legacydb.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("legacydbid", getLegacydbid());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long legacydbid = (Long)attributes.get("legacydbid");

		if (legacydbid != null) {
			setLegacydbid(legacydbid);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@JSON
	@Override
	public long getLegacydbid() {
		return _legacydbid;
	}

	@Override
	public void setLegacydbid(long legacydbid) {
		_legacydbid = legacydbid;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Legacydb.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Legacydb toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Legacydb)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LegacydbImpl legacydbImpl = new LegacydbImpl();

		legacydbImpl.setLegacydbid(getLegacydbid());
		legacydbImpl.setName(getName());

		legacydbImpl.resetOriginalValues();

		return legacydbImpl;
	}

	@Override
	public int compareTo(Legacydb legacydb) {
		int value = 0;

		value = getName().compareTo(legacydb.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Legacydb)) {
			return false;
		}

		Legacydb legacydb = (Legacydb)obj;

		long primaryKey = legacydb.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		LegacydbModelImpl legacydbModelImpl = this;

		legacydbModelImpl._originalName = legacydbModelImpl._name;

		legacydbModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Legacydb> toCacheModel() {
		LegacydbCacheModel legacydbCacheModel = new LegacydbCacheModel();

		legacydbCacheModel.legacydbid = getLegacydbid();

		legacydbCacheModel.name = getName();

		String name = legacydbCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			legacydbCacheModel.name = null;
		}

		return legacydbCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{legacydbid=");
		sb.append(getLegacydbid());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("test.sb.model.Legacydb");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>legacydbid</column-name><column-value><![CDATA[");
		sb.append(getLegacydbid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Legacydb.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Legacydb.class
		};
	private long _legacydbid;
	private String _name;
	private String _originalName;
	private long _columnBitmask;
	private Legacydb _escapedModel;
}