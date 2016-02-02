package permission.controller;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import permission.servicebuider.service.FirstnamesLocalServiceUtil;

/**
 * @author peter
 *
 */
public class PermissionPortlet extends MVCPortlet {

	public void saveName(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String name = GetterUtil.getString(actionRequest.getParameter("name"), "");

		FirstnamesLocalServiceUtil.addName(name);

		actionResponse.setPortletMode(PortletMode.VIEW);
	}

	

}
