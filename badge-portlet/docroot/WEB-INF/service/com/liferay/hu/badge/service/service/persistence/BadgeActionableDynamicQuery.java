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

package com.liferay.hu.badge.service.service.persistence;

import com.liferay.hu.badge.service.model.Badge;
import com.liferay.hu.badge.service.service.BadgeLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Borkuti Peter
 * @generated
 */
public abstract class BadgeActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public BadgeActionableDynamicQuery() throws SystemException {
		setBaseLocalService(BadgeLocalServiceUtil.getService());
		setClass(Badge.class);

		setClassLoader(com.liferay.hu.badge.service.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("badgeId");
	}
}