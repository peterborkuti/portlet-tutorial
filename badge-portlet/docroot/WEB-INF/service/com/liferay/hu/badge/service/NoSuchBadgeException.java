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

package com.liferay.hu.badge.service;

import com.liferay.portal.NoSuchModelException;

/**
 * @author Borkuti Peter
 */
public class NoSuchBadgeException extends NoSuchModelException {

	public NoSuchBadgeException() {
		super();
	}

	public NoSuchBadgeException(String msg) {
		super(msg);
	}

	public NoSuchBadgeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchBadgeException(Throwable cause) {
		super(cause);
	}

}