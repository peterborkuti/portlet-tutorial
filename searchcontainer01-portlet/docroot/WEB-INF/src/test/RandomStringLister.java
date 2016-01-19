package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class RandomStringLister extends MVCPortlet {
	private final static List<String> randomStringList = new ArrayList<String>();

	@Override
	public void init() throws PortletException {
		super.init();

		for (int i = 0; i < 100; i++) {
			randomStringList.add(i + ":" + StringUtil.randomString());
		}
	}

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		renderRequest.setAttribute("randomList", randomStringList);

		super.doView(renderRequest, renderResponse);
	}

}
