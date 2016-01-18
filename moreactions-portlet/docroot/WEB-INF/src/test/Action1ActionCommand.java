package test;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.apache.log4j.Logger;

import com.liferay.util.bridges.mvc.ActionCommand;

public class Action1ActionCommand implements ActionCommand {

	public boolean processCommand(PortletRequest arg0, PortletResponse arg1)
			throws PortletException {
		_log.error("Action1");

		return true;
	}

	private static Logger _log = Logger.getLogger(Action1ActionCommand.class);

}
