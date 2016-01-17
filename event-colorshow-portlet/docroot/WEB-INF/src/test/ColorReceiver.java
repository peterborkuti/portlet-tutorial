package test;

import java.io.IOException;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class ColorReceiver extends GenericPortlet {

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		PortletRequestDispatcher prd = getPortletContext()
				.getRequestDispatcher("/view.jsp");
		prd.include(request, response);
	}

	@ProcessEvent(qname="{mynamespace}colorsetevent")
	public void colorSetEventProcessor(EventRequest request, EventResponse response)
			throws PortletException, IOException {

		Event event = request.getEvent();
		String payLoad = (String)event.getValue();

		request.setAttribute("color", payLoad);
	}

}
