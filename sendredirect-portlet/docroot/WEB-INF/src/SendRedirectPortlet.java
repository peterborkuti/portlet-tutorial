import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;

import com.liferay.util.bridges.mvc.MVCPortlet;


public class SendRedirectPortlet extends MVCPortlet {
	

	@ProcessAction(name = "doRedirect")
	public void doRedirectAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		sendRedirect(actionRequest, actionResponse);
	}

}
