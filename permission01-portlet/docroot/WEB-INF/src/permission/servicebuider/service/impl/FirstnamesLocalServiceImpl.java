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

package permission.servicebuider.service.impl;

import java.util.Date;

import com.liferay.portal.kernel.exception.SystemException;

import permission.servicebuider.model.Firstnames;
import permission.servicebuider.service.base.FirstnamesLocalServiceBaseImpl;

/**
 * The implementation of the firstnames local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link permission.servicebuider.service.FirstnamesLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author peter
 * @see permission.servicebuider.service.base.FirstnamesLocalServiceBaseImpl
 * @see permission.servicebuider.service.FirstnamesLocalServiceUtil
 */
public class FirstnamesLocalServiceImpl extends FirstnamesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link permission.servicebuider.service.FirstnamesLocalServiceUtil} to access the firstnames local service.
	 */

	public boolean addName(String name) {
		long id;
		try {
			id = counterLocalService.increment(Firstnames.class.getName());
			Firstnames fname = firstnamesPersistence.create(id);
			fname.setFirstname(name);
			fname.setModifiedDate(new Date());
			fname.setCreateDate(new Date());
			firstnamesPersistence.update(fname);
		} catch (SystemException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
}