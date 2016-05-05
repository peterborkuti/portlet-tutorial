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

package hu.borkuti.peter.scriptpp.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import hu.borkuti.peter.scriptpp.service.model.History;
import hu.borkuti.peter.scriptpp.service.service.HistoryLocalServiceUtil;

/**
 * @author Peter Borkuti
 * @generated
 */
public abstract class HistoryActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public HistoryActionableDynamicQuery() throws SystemException {
		setBaseLocalService(HistoryLocalServiceUtil.getService());
		setClass(History.class);

		setClassLoader(hu.borkuti.peter.scriptpp.service.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("historyId");
	}
}