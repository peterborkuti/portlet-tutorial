package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.Contact;
import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


public class DynaQueryPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		boolean order = GetterUtil.getBoolean(renderRequest.getParameter("order"), true);
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Contact.class, PortalClassLoaderUtil.getClassLoader());

		OrderByComparator oComp = new DayComparator(order);

		List<Contact> results = new ArrayList<Contact>();
		try {
			results =(List<Contact>)
				ContactLocalServiceUtil.dynamicQuery(
					query, QueryUtil.ALL_POS, QueryUtil.ALL_POS, oComp);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		List<Contact> modifiableList = new ArrayList<Contact>(results);
		Collections.sort(modifiableList, oComp);
		renderRequest.setAttribute("contactList", modifiableList);

		super.doView(renderRequest, renderResponse);
	}

	static Logger _log = Logger.getLogger(DynaQueryPortlet.class.getName());

}
