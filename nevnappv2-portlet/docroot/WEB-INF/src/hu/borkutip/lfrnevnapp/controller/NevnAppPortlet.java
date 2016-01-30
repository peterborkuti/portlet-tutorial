package hu.borkutip.lfrnevnapp.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.StateAwareResponse;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import hu.borkutip.lfrnevnapp.data.service.DayEntityLocalServiceUtil;
import hu.borkutip.lfrnevnapp.data.service.NameEntityLocalServiceUtil;
import hu.borkutip.lfrnevnapp.logic.NevnAppLogic;

public class NevnAppPortlet extends MVCPortlet {

	@Override
	public void init() throws PortletException {
		super.init();
		_log.error("init started");
		NAMES_PATH = viewTemplate;
		DAYS_PATH = getPortletConfig().getInitParameter("days-template");

		try {

			URL url = getPortletContext().getResource("/WEB-INF/data/dates.txt");
			DayEntityLocalServiceUtil.fillDatabase(url);
			url = getPortletContext().getResource("/WEB-INF/data/names.txt");
			NameEntityLocalServiceUtil.fillDatabase(url);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {
		_log.error("render getPath:" + getPath(request));

		PortletURL iteratorURL = response.createRenderURL();;

		String path = getPath(request);

		if (null == path) {
			_getListNames(request, response);
		}
		else if (NAMES_PATH.equals(path)) {
			String month = GetterUtil.getString(request.getParameter("month"), "-1");
			String day = GetterUtil.getString(request.getParameter("day"), "-1");

			iteratorURL = response.createActionURL();
			iteratorURL.setParameter(ActionRequest.ACTION_NAME, "listNames");
			iteratorURL.setParameter("month", month);
			iteratorURL.setParameter("day", day);
		}
		else if (DAYS_PATH.equals(path)) {
			String nameId = GetterUtil.getString(request.getParameter("nameId"), "-1");

			iteratorURL = response.createActionURL();
			iteratorURL.setParameter(ActionRequest.ACTION_NAME, "listDays");
			iteratorURL.setParameter("nameId", nameId);
		}
		else {
			_log.error("Invalid path:" + path);
		}

		request.setAttribute("iteratorURL", iteratorURL);

		super.render(request, response);
	}

	@ProcessAction(name = "listNames")
	public void listNamesAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		boolean today = _getListNames(actionRequest, actionResponse);

		if (!today) {
			SessionMessages.add(actionRequest, "today");
		}

		PortalUtil.copyRequestParameters(actionRequest, actionResponse);

		actionResponse.setRenderParameter(PATH_PARAM, NAMES_PATH);
	}

	@ProcessAction(name = "listDays")
	public void listDaysAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		Long nameId = GetterUtil.getLong(actionRequest.getParameter("nameId"), -1);

		List<String> errors = new ArrayList<String>();

		actionRequest.setAttribute("days", NevnAppLogic.getDays(nameId, errors));

		for (String err: errors) {
			SessionErrors.add(actionRequest, err);
		}

		SessionMessages.add(actionRequest, "today");

		PortalUtil.copyRequestParameters(actionRequest, actionResponse);

		actionResponse.setRenderParameter(PATH_PARAM, DAYS_PATH);
	}

	// return true if today
	private boolean _getListNames(PortletRequest request, PortletResponse response) {
		int month = GetterUtil.getInteger(request.getParameter("month"), -1);
		int day = GetterUtil.getInteger(request.getParameter("day"), -1);

		List<String> errors = new ArrayList<String>();

		request.setAttribute("names", NevnAppLogic.getNames(month, day, errors));

		for (String err: errors) {
			SessionErrors.add(request, err);
		}

		return ((month == -1) || (day == -1));
	}

	private static Logger _log = Logger.getLogger(NevnAppPortlet.class);
	public static String DAYS_PATH;
	public static String NAMES_PATH;
	private static final String PATH_PARAM = "mvcPath";

}
