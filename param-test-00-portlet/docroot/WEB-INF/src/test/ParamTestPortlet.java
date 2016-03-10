package test;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ParamTestPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
	      HttpServletRequest httpReq = 
	                PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
	        String myParamValue = httpReq.getParameter("myParam");
	    
	    _log.error("myParam:" + myParamValue);
		super.render(request, response);
	}

	Logger _log = Logger.getLogger(getClass());

}
