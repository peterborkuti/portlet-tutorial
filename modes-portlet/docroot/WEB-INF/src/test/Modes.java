package test;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class Modes extends GenericPortlet {

	@Override
	protected void doEdit(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

		PortletRequestDispatcher prd =
			getPortletContext().getRequestDispatcher("/edit.jsp");

		prd.include(request, response);
	}

	@Override
	protected void doHelp(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

		PortletRequestDispatcher prd =
			getPortletContext().getRequestDispatcher("/help.jsp");

			prd.include(request, response);
	}

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

		PortletRequestDispatcher prd =
			getPortletContext().getRequestDispatcher("/view.jsp");

			prd.include(request, response);
	}

}
