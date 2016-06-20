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

import java.util.Random;

import hu.borkuti.peter.scriptpp.service.service.base.ScriptOptionsServiceBaseImpl;

/**
 * The implementation of the script options remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.borkuti.peter.scriptpp.service.service.ScriptOptionsService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Peter Borkuti
 * @see hu.borkuti.peter.scriptpp.service.service.base.ScriptOptionsServiceBaseImpl
 * @see hu.borkuti.peter.scriptpp.service.service.ScriptOptionsServiceUtil
 */
public class ScriptOptionsServiceImpl extends ScriptOptionsServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link hu.borkuti.peter.scriptpp.service.service.ScriptOptionsServiceUtil} to access the script options remote service.
	 */

	public Integer getRandomNumber() {
		Random r = new Random();
		return r.nextInt();
	}
}