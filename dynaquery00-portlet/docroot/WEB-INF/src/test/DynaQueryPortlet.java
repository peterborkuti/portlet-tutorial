package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.Contact;
import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


public class DynaQueryPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Contact.class, PortalClassLoaderUtil.getClassLoader());

		OrderByComparator oComp = new DayComparator(true);

		List<Contact> results = new ArrayList<Contact>();
			try {
				results =(List<Contact>)
					ContactLocalServiceUtil.dynamicQuery(
						query, QueryUtil.ALL_POS, QueryUtil.ALL_POS, oComp);
			} catch (SystemException e) {
				_log.error(e.getMessage());
			}
		for (Contact contact: results) {
			_log.error("Contact:" + contact.getEmailAddress() + "," + contact.getModifiedDate().getDate());
		}
		super.doView(renderRequest, renderResponse);
	}

	static Logger _log = Logger.getLogger(DynaQueryPortlet.class.getName());

}
