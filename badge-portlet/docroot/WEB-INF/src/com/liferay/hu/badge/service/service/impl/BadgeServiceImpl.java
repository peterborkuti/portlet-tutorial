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

package com.liferay.hu.badge.service.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.hu.badge.service.model.Badge;
import com.liferay.hu.badge.service.service.base.BadgeServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GroupThreadLocal;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.CompanyThreadLocal;

/**
 * The implementation of the badge remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.hu.badge.service.service.BadgeService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Borkuti Peter
 * @see com.liferay.hu.badge.service.service.base.BadgeServiceBaseImpl
 * @see com.liferay.hu.badge.service.service.BadgeServiceUtil
 */
public class BadgeServiceImpl extends BadgeServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.hu.badge.service.service.BadgeServiceUtil} to access the badge remote service.
	 */

	public boolean addBadge(Date date, long fromUserId, long toUserId,
			int badgeType, String description) {

		long badgeId = 0;
		try {
			badgeId = counterLocalService.increment();
		} catch (SystemException e) {
			e.printStackTrace();
			return false;
		}

		long companyId = CompanyThreadLocal.getCompanyId();
		long groupId = GroupThreadLocal.getGroupId();

		long currentUserId = 0;
		User currentUser;
		try {
			currentUser = userService.getCurrentUser();
			if (currentUser != null) {
				currentUserId = currentUser.getUserId();
			}
		} catch (PortalException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}

		
		String fromUserName = _getUserFullNameById(fromUserId);
		String toUserName = _getUserFullNameById(toUserId);

		Badge badge = badgePersistence.create(badgeId);

		badge.setBadgeType(badgeType);
		badge.setDescription(description);
		badge.setToUser(toUserId);
		badge.setFromUser(fromUserId);
		badge.setAssignDate(date);
		badge.setToUserFullName(toUserName);
		badge.setFromUserFullName(fromUserName);

		badge.setCompanyId(companyId);
		badge.setCreateDate(new Date());
		badge.setGroupId(groupId);
		badge.setUserId(currentUserId);

		try {
			badgePersistence.update(badge);
		} catch (SystemException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	private String _getUserFullNameById(long userId) {
		String userName = "";
		try {
			User user = userLocalService.fetchUser(userId);
			userName = user.getFullName();
		} catch (SystemException e) {
			e.printStackTrace();
		}

		return userName;
	}

	public List<Badge> getBadges() {
		List<Badge> badges = new ArrayList<Badge>();

		try {
			badges = badgePersistence.findAll();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return badges;
	}

	public List<Badge> getBadges(int badgeType) {
		List<Badge> badges = new ArrayList<Badge>();

		try {
			badges = badgePersistence.findBybadgeType(badgeType);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return badges;
	}

}