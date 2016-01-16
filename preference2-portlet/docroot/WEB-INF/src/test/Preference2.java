package test;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class Preference2 extends GenericPortlet {

	@Override
	public void processAction(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {
		String name = request.getParameter("inputname");

		PortletPreferences pp = request.getPreferences();
		pp.setValue("yourname", name);

		pp.store();
	}

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		PortletRequestDispatcher prd = getPortletContext()
				.getRequestDispatcher("/view.jsp");
		prd.include(request, response);
	}

	@Override
	protected void doEdit(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		PortletRequestDispatcher prd = getPortletContext()
				.getRequestDispatcher("/edit.jsp");
		prd.include(request, response);
	}

}
