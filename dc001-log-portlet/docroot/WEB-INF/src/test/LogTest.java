package test;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

public class LogTest extends GenericPortlet {

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/view.jsp");
		prd.include(request, response);

		_log.error("doView");
	}

	private static Logger _log = Logger.getLogger(LogTest.class);

}
