package test;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.apache.log4j.Logger;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import test.producer.sb.model.Foo;
import test.producer.sb.service.FooLocalServiceUtil;

public class ProducerPortlet extends MVCPortlet {

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			long fooId;
			fooId = CounterLocalServiceUtil.increment();

			Foo foo = FooLocalServiceUtil.createFoo(fooId);

			foo.setField1(StringUtil.randomString());

			ThemeDisplay themeDisplay =
				(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			foo.setCompanyId(themeDisplay.getCompanyId());
			foo.setGroupId(themeDisplay.getSiteGroupId());
			foo.setUserId(themeDisplay.getUserId());

			Date date = new Date();
			foo.setCreateDate(date);

			FooLocalServiceUtil.addFoo(foo);

			_log.error("producer added a random entry");
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}
	}

	static Logger _log = Logger.getLogger(ProducerPortlet.class.getName());

}
