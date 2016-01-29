package hu.borkutip.lfrnevnapp.logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import hu.borkutip.lfrnevnapp.data.model.DayEntity;
import hu.borkutip.lfrnevnapp.data.model.NameEntity;
import hu.borkutip.lfrnevnapp.data.service.DayEntityLocalServiceUtil;

public class NevnAppLogic {

	public static List<NameEntity> getNames(int month, int day, List<String> errors) {
		List<NameEntity> names = new ArrayList<NameEntity>();

		try {
			names = DayEntityLocalServiceUtil.getNamesByMonthAndDay(month, day);

		} catch (Exception e) {
			_log.error(e);
			errors.add(e.getMessage());
		}

		return names;
	}

	public static List<NameEntity> getNames(List<String> errors) {
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

		return getNames(month, day, errors);
	}

	
	public static List<DayEntity> getDays(long nameId, List<String> errors) {
		List<DayEntity> days = new ArrayList<DayEntity>();

		try {
			days = DayEntityLocalServiceUtil.getDatesByNameId(nameId);
		} catch (Exception e) {
			_log.error(e);
			errors.add(e.getMessage());
		}

		return days;

	}

	private static Logger _log = Logger.getLogger(NevnAppLogic.class);
}
