package test;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

public class Urls extends GenericPortlet {

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

		_log.error("doView");

		PortletRequestDispatcher prd =
			getPortletContext().getRequestDispatcher("/view.jsp");

		prd.include(request, response);
	}

	@Override
	public void processAction(ActionRequest arg0, ActionResponse arg1)
			throws PortletException, IOException {

		_log.error("processAction");
	}

	@Override
	public void render(RenderRequest arg0, RenderResponse arg1)
			throws PortletException, IOException {
		_log.error("render");

		super.render(arg0, arg1);
	}

	@Override
	public void serveResource(ResourceRequest arg0, ResourceResponse arg1)
			throws PortletException, IOException {
		_log.error("serveResource");

		super.serveResource(arg0, arg1);
	}

	private static Logger _log = Logger.getLogger(Urls.class);

}
