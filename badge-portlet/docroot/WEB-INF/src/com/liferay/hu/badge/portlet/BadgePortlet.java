package com.liferay.hu.badge.portlet;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.hu.badge.service.service.BadgeServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class BadgePortlet extends MVCPortlet {

	@Override
	public void processAction(ActionRequest request, ActionResponse actionResponse)
			throws IOException, PortletException {
		Integer toUserId = GetterUtil.getInteger(request.getParameter("toUser"), -1);
		String description = GetterUtil.getString(request.getParameter("description"), StringPool.BLANK);

		User user = (User) request.getAttribute(WebKeys.USER);

		if ((user == null ) || (user.getUserId() <= 0)) {
			return;
		}

		long fromUserId = user.getUserId();

		Date date = new Date();

		BadgeServiceUtil.addBadge(date, fromUserId, toUserId, 0, description);

		
	}

}
