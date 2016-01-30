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
		if ((month < 0) || (day < 1)) {
			month = Calendar.getInstance().get(Calendar.MONTH) + 1;
			day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		}

		List<NameEntity> names = new ArrayList<NameEntity>();

		try {
			names = DayEntityLocalServiceUtil.getNamesByMonthAndDay(month, day);

		} catch (Exception e) {
			_log.error(e);
			errors.add(e.getMessage());
		}

		return names;
	}

	public static List<DayEntity> getDays(long nameId, List<String> errors) {
		List<DayEntity> days = new ArrayList<DayEntity>();

		try {
			if (nameId > -1) {
				days = DayEntityLocalServiceUtil.getDatesByNameId(nameId);
			}
		} catch (Exception e) {
			_log.error(e);
			errors.add(e.getMessage());
		}

		return days;

	}

	private static Logger _log = Logger.getLogger(NevnAppLogic.class);
}
