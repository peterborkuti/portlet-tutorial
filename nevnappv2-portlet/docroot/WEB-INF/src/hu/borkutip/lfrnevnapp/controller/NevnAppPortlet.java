package hu.borkutip.lfrnevnapp.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import hu.borkutip.lfrnevnapp.data.service.DayEntityLocalServiceUtil;
import hu.borkutip.lfrnevnapp.data.service.NameEntityLocalServiceUtil;
import hu.borkutip.lfrnevnapp.logic.NevnAppLogic;

public class NevnAppPortlet extends MVCPortlet {

	@Override
	public void init() throws PortletException {
		super.init();
		_log.error("init started");
		DAYS_PATH = viewTemplate;
		NAMES_PATH = getInitParameter("days-template");

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

		if (NAMES_PATH.equals(getPath(request))) {
			List<String> errors = new ArrayList<String>();

			request.setAttribute("names", NevnAppLogic.getNames(errors));

			for (String err: errors) {
				SessionErrors.add(request, err);
			}
		}

		super.render(request, response);
	}

	@ProcessAction(name = "listDays")
	public void listDaysAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		Long nameId = GetterUtil.getLong(actionRequest.getParameter("nameId"), -1);

		if (nameId > -1) {
			List<String> errors = new ArrayList<String>();

			actionRequest.setAttribute("days", NevnAppLogic.getDays(nameId, errors));
			actionResponse.setRenderParameter("mvcPath", DAYS_PATH);

			for (String err: errors) {
				SessionErrors.add(actionRequest, err);
			}
		}
		else {
			SessionErrors.add(actionRequest, "missing-parameter");
		}

		super.processAction(actionRequest, actionResponse);
	}


	private static Logger _log = Logger.getLogger(NevnAppPortlet.class);
	private static String DAYS_PATH;
	private static String NAMES_PATH;

}
