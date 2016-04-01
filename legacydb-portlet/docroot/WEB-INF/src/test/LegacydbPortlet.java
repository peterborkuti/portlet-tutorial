package test;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import test.sb.model.Legacydb;
import test.sb.service.LegacydbLocalServiceUtil;

public class LegacydbPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		List<Legacydb> entities = null;

		try {
			entities = LegacydbLocalServiceUtil.getLegacydbs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		renderRequest.setAttribute("entities", entities);

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		long id = 0;
		try {
			id = CounterLocalServiceUtil.increment();
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}
		Legacydb entity=LegacydbLocalServiceUtil.createLegacydb(id);

		entity.setName(StringUtil.randomString());
		try {
			LegacydbLocalServiceUtil.addLegacydb(entity);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		_log.error("added " + entity);

		// After a processaction, render parameters are cleared, so the
		// pagination and delta parameter will be lost in normal case
		PortalUtil.copyRequestParameters(actionRequest, actionResponse);
	}

	static Logger _log = Logger.getLogger(LegacydbPortlet.class.getName());

}
