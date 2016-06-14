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

package hu.borkuti.peter.scriptpp.service.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import hu.borkuti.peter.scriptpp.service.service.ClpSerializer;
import hu.borkuti.peter.scriptpp.service.service.HistoryLocalServiceUtil;
import hu.borkuti.peter.scriptpp.service.service.HistoryServiceUtil;
import hu.borkuti.peter.scriptpp.service.service.ScriptLocalServiceUtil;
import hu.borkuti.peter.scriptpp.service.service.ScriptServiceUtil;

/**
 * @author Peter Borkuti
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			HistoryLocalServiceUtil.clearService();

			HistoryServiceUtil.clearService();
			ScriptLocalServiceUtil.clearService();

			ScriptServiceUtil.clearService();
		}
	}
}