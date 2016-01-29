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

package hu.borkutip.lfrnevnapp.data.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringPool;

import hu.borkutip.lfrnevnapp.data.model.DayEntity;
import hu.borkutip.lfrnevnapp.data.model.NameEntity;
import hu.borkutip.lfrnevnapp.data.service.base.NameEntityLocalServiceBaseImpl;

/**
 * The implementation of the name entity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.borkutip.lfrnevnapp.data.service.NameEntityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Péter Borkuti
 * @see hu.borkutip.lfrnevnapp.data.service.base.NameEntityLocalServiceBaseImpl
 * @see hu.borkutip.lfrnevnapp.data.service.NameEntityLocalServiceUtil
 */
public class NameEntityLocalServiceImpl extends NameEntityLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link hu.borkutip.lfrnevnapp.data.service.NameEntityLocalServiceUtil} to access the name entity local service.
	 */
	public boolean fillDatabase(URL resource) {
		boolean success = false;
		try {
			if (nameEntityPersistence.countAll() > 0) {
				_log.error("table exists, remove all");
				nameEntityPersistence.removeAll();
			}
		} catch (Exception e) {
			_log.error(e);
		}

		try {
			String dates = HttpUtil.URLtoString(resource);
			String[] lines = dates.split(StringPool.NEW_LINE);
			for (String l : lines) {
				String[] parts = l.split(",");
				if (parts.length < 2) {
					_log.error("error when adding line :" + l);
					continue;
				}
				Long nameId;
				try {
					nameId = Long.parseLong(parts[0]);
				} catch (Exception e) {
					_log.error(e);
					continue;
				}
				String name = parts[1];
				NameEntity ne = nameEntityPersistence.create(nameId);
				ne.setGender(3);
				ne.setName(name);
				nameEntityLocalService.addNameEntity(ne);
				_log.error("added:" + l);
			}
			success = true;

		} catch (MalformedURLException e) {
			_log.error(e);
		} catch (IOException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

		return success;
	}

	private static Logger _log = Logger.getLogger(DayEntityLocalServiceImpl.class);
}