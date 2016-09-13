package com.liferay.hu.badge.portlet;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;

import org.apache.log4j.Logger;

import com.liferay.hu.badge.service.service.BadgeServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class BadgePortlet extends MVCPortlet {

	private boolean isAdminMode(ActionRequest request) {
		PortletPreferences pp = request.getPreferences();

		boolean prefAdmin = GetterUtil.getBoolean(pp.getValue("adminmode", "false"));

		return prefAdmin;
	}

	public void addBadgeAction(ActionRequest request, ActionResponse actionResponse)
			throws IOException, PortletException {

		long toUserId = GetterUtil.getLong(request.getParameter("toUser"), -1);
		String description = GetterUtil.getString(request.getParameter("description"), StringPool.BLANK);

		User user = (User) request.getAttribute(WebKeys.USER);

		if ((user == null ) || (user.getUserId() <= 0)) {
			_log.error("user is null or userId <= 0");
			return;
		}

		PortletPreferences pp = request.getPreferences();
		boolean addrespect = GetterUtil.getBoolean(pp.getValue("addrespect", "false"), false);

		int badgeType = BADGETYPE_THANKYOU;

		if (addrespect) {
			badgeType = BADGETYPE_RESPECT;
		}

		long fromUserId = user.getUserId();

		Date date = new Date();

		if (isAdminMode(request)) {
			long tmpUserId = GetterUtil.getLong(request.getParameter("fromUser"), -1);
			if (tmpUserId >= 0) {
				fromUserId = tmpUserId;
			}
			int year = GetterUtil.getInteger(request.getParameter("assignYear"), -1);
			int month = GetterUtil.getInteger(request.getParameter("assignMonth"), -1);
			int day = GetterUtil.getInteger(request.getParameter("assignDay"), -1);

			if ((year > 0) && (month > 0) && (day > 0)) {
				date = new Date(year, month, day);
			}
		}

		BadgeServiceUtil.addBadge(date, fromUserId, toUserId, badgeType, description);
	}

	public void editPreferencesAction(ActionRequest request, ActionResponse actionResponse)
			throws IOException, PortletException {

		PortletPreferences pp = request.getPreferences();

		for (String param: editCheckboxParameters) {
			boolean paramValue = GetterUtil.getBoolean(request.getParameter(param), false);
			pp.setValue(param, Boolean.toString(paramValue));
		}

		for (String param: editRadioParameters) {
			boolean paramValue = param.equals(request.getParameter("restrictbadgetype"));
			pp.setValue(param, Boolean.toString(paramValue));
		}

		pp.store();
	}

	private Logger _log = Logger.getLogger(getClass());

	private static String[] editCheckboxParameters =
		{"showthankyou", "showrespect", 
		"displayform", "displaybadges", "adminmode"};

	private static String[] editRadioParameters =
		{"addthankyou", "addrespect"};

	public static int BADGETYPE_THANKYOU = 0;
	public static int BADGETYPE_RESPECT = 1;

}
