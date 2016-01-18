package test;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;

import com.liferay.util.bridges.mvc.MVCPortlet;

public class SuccessAction extends MVCPortlet {

	@ProcessAction(name="myaction")
	public void myAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
	}

}
