package test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class SessionMessageSetter extends MVCPortlet {
	private List<String> numbers = Arrays.asList("msg1","msg2","err1","err2");
	private Random r = new Random();

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		Collections.shuffle(numbers);

		SessionMessages.clear(renderRequest);
		int n = 1 + r.nextInt(numbers.size());
		
		for (int i = 0; i < n; i++) {
			String key = numbers.get(i);
			if (key.startsWith("msg")) {
				SessionMessages.add(renderRequest, key);
			}
			else {
				SessionErrors.add(renderRequest, key);
			}
		}
		
		super.doView(renderRequest, renderResponse);
	}

}
