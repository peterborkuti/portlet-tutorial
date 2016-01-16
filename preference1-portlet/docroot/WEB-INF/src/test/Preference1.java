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

import org.apache.log4j.Logger;



public class Preference1 extends GenericPortlet {

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

		PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/view.jsp");
		prd.include(request, response);
	}


	@Override
	public void processAction(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {
		PortletPreferences pp = request.getPreferences();
		String s = pp.getValue("counter", "0");

		Integer i = Integer.parseInt(s);
		i++;

		pp.setValue("counter", "" + i);
		pp.store();

	}

}
