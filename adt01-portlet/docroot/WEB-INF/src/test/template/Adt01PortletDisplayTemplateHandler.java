package test.template;

import java.util.Locale;

import com.liferay.portal.kernel.portletdisplaytemplate.BasePortletDisplayTemplateHandler;

import test.portlet.Adt01Portlet;

public class Adt01PortletDisplayTemplateHandler extends BasePortletDisplayTemplateHandler {

	@Override
	public String getClassName() {
		return String.class.getName();
	}

	@Override
	public String getName(Locale locale) {
		return "adt01 template";
	}

	@Override
	public String getResourceName() {
		//FQPI
		return "adt01_WAR_adt01portlet";
	}

}
