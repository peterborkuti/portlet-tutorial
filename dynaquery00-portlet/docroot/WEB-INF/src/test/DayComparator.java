package test;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.Contact;

public class DayComparator extends OrderByComparator {
	private static String field = "createDate";

	public static final String ORDER_BY_ASC = field + " ASC";

	public static final String ORDER_BY_DESC = field + " DESC";

	public static final String[] ORDER_BY_FIELDS = {field};

	public DayComparator() {
		this(false);
	}

	public DayComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		_log.error("start compare");
		Contact a = (Contact)obj1;
		Contact b = (Contact)obj2;
		if ((a == null) || (b == null)) {
			return 0;
		}
		int da = a.getModifiedDate().getDate();
		int db = b.getModifiedDate().getDate();

		int value = da - db;
		_log.error("compare" + da + "," + db + "," + value);

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		_log.error("compare getOrderBy");
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

	static Logger _log = Logger.getLogger(DayComparator.class.getName());

}
