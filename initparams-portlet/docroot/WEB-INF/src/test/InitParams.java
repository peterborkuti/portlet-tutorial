package test;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class InitParams extends GenericPortlet {

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

		PortletConfig pc = getPortletConfig();
		String path = pc.getInitParameter("view-template");

		PortletRequestDispatcher prd =
			getPortletContext().getRequestDispatcher(path);

		prd.include(request, response);
	}
	

}
