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
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringPool;

import hu.borkutip.lfrnevnapp.data.NoSuchNameEntityException;
import hu.borkutip.lfrnevnapp.data.model.DayEntity;
import hu.borkutip.lfrnevnapp.data.model.NameEntity;
import hu.borkutip.lfrnevnapp.data.service.DayEntityLocalServiceUtil;
import hu.borkutip.lfrnevnapp.data.service.base.DayEntityLocalServiceBaseImpl;

/**
 * The implementation of the day entity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link hu.borkutip.lfrnevnapp.data.service.DayEntityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Péter Borkuti
 * @see hu.borkutip.lfrnevnapp.data.service.base.DayEntityLocalServiceBaseImpl
 * @see hu.borkutip.lfrnevnapp.data.service.DayEntityLocalServiceUtil
 */
public class DayEntityLocalServiceImpl extends DayEntityLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * hu.borkutip.lfrnevnapp.data.service.DayEntityLocalServiceUtil} to access
	 * the day entity local service.
	 */

	public List<String> getNamesByMonthAndDay(int month, int day) throws SystemException, NoSuchNameEntityException {
		List<DayEntity> days = dayEntityPersistence.findBymonthAndDay(month, day);
		List<String> names = new ArrayList<String>();

		for (DayEntity dDay : days) {
			NameEntity name = nameEntityPersistence.findByPrimaryKey(dDay.getNameId());
			names.add(name.getName());
		}

		return names;
	}

	public boolean fillDatabase(URL resource) {
		boolean success = false;
		try {
			if (dayEntityPersistence.countAll() > 0) {
				_log.error("table exists, remove all");
				dayEntityPersistence.removeAll();
			}
		} catch (Exception e) {
			_log.error(e);
		}

		try {

			String dates = HttpUtil.URLtoString(resource);
			String[] lines = dates.split(StringPool.NEW_LINE);
			for (String l : lines) {
				String[] parts = l.split(",");
				if (parts.length < 3) {
					_log.error("error when adding line :" + l);
					continue;
				}
				Long nameId;
				Integer month;
				Integer day;
				try {
					nameId = Long.parseLong(parts[0]);
					month = Integer.parseInt(parts[1]);
					day = Integer.parseInt(parts[2]);
				} catch (Exception e) {
					_log.error(e);
					continue;
				}
				DayEntity de = dayEntityPersistence.create(counterLocalService.increment());
				de.setDay(day);
				de.setMonth(month);
				de.setNameId(nameId);
				dayEntityLocalService.addDayEntity(de);
				// _log.error("added:" + l);
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