package hu.borkutip.lfrnevnapp.logic;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.util.bridges.mvc.MVCPortlet;

import hu.borkutip.lfrnevnapp.data.service.DayEntityLocalServiceUtil;
import hu.borkutip.lfrnevnapp.data.service.NameEntityLocalServiceUtil;
import hu.borkutip.lfrnevnapp.data.service.impl.DayEntityLocalServiceImpl;

public class NevnAppPortlet extends MVCPortlet {

	@Override
	public void init() throws PortletException {
		super.init();
		_log.error("init started");
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
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

		List<String> names = new ArrayList<String>();

		try {
			names = DayEntityLocalServiceUtil.getNamesByMonthAndDay(month, day);

		} catch (Exception e) {
			_log.error(e);
		}

		renderRequest.setAttribute("names", names);

		super.doView(renderRequest, renderResponse);
	}

	private static Logger _log = Logger.getLogger(NevnAppPortlet.class);

}
