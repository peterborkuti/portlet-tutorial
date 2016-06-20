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

package hu.borkuti.peter.scriptpp.service.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.exception.SystemException;

import hu.borkuti.peter.scriptpp.service.model.History;
import hu.borkuti.peter.scriptpp.service.service.base.HistoryServiceBaseImpl;

/**
 * The implementation of the history remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.borkuti.peter.scriptpp.service.service.HistoryService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Peter Borkuti
 * @see hu.borkuti.peter.scriptpp.service.service.base.HistoryServiceBaseImpl
 * @see hu.borkuti.peter.scriptpp.service.service.HistoryServiceUtil
 */
public class HistoryServiceImpl extends HistoryServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link hu.borkuti.peter.scriptpp.service.service.HistoryServiceUtil} to access the history remote service.
	 */
	public Integer getRandomNumber() {
		Random r = new Random();
		return r.nextInt();
	}

	public String[] getHistoryLines() {
		List<String> lines = new ArrayList<String>();
		try {
			List<History> histories;
			histories = historyPersistence.findAll();
			for (History h : histories) {
				lines.add(h.getLine());
			}
		} catch (SystemException e) {
			_log.error(e.getMessage());
			return new String[0];
		}

		return lines.toArray(new String[0]);
	}

	public void addHistoryLine(String line) {
		try {
			long historyId;
			historyId = counterLocalService.increment();
			History history = historyPersistence.create(historyId);
			history.setLine(line);
			historyPersistence.update(history);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}
	}

	Logger _log = Logger.getLogger(getClass());

}