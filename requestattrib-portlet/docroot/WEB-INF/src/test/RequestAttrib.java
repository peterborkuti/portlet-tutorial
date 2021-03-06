package test;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class RequestAttrib extends GenericPortlet {

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

		String s = "Hello";
		request.setAttribute("myattr", s);

		PortletRequestDispatcher prd = getPortletContext()
				.getRequestDispatcher("/view.jsp");
		prd.include(request, response);
	}

}
