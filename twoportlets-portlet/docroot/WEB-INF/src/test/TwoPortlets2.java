package test;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class TwoPortlets2 extends GenericPortlet {

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/view2.jsp");
prd.include(request, response);
	}

}
