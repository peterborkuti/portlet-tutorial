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
import com.liferay.portal.model.Contact;
import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


public class DynaQueryPortlet extends MVCPortlet {
	protected class DayComparator extends OrderByComparator {



		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public String getOrderBy() {
			return "createDate";
		}

		@Override
		public int compare(Object obj1, Object obj2) {
			Contact a = (Contact)obj1;
			Contact b = (Contact)obj2;
			if ((a == null) || (b == null)) {
				return 0;
			}
			int da = a.getModifiedDate().getDate();
			int db = b.getModifiedDate().getDate();

			if (da > db) {
				return -1;
			}
			if (da < db) {
				return 1;
			}

			return 0;
		}
		
	}


	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Contact.class);

		OrderByComparator oComp = new DayComparator();

		List<Contact> results = new ArrayList<Contact>();
			try {
				results =
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
