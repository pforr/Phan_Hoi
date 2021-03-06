package vn.dtt.ns.thongtinphanhoi.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.liferay.portal.kernel.util.StringPool;

public class DateTimeUtil {
	
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public static String formatDate(Date dateInput) {
		
		String result = StringPool.BLANK;
		try {
			result = DATE_FORMAT.format(dateInput);
			
			return result;
		} catch (Exception e) {
			
			e.printStackTrace();
			return StringPool.BLANK;
		}
	}
	
	public static Date convertStringToDate(String stringInput) {
		
		Date result = null;
		try {
			result = DATE_FORMAT.parse(stringInput);
			
			return result;
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
	public static Date getDauNgay(Date day) {
	      return getDauNgay(day,Calendar.getInstance());
	}
	
	public static Date getDauNgay(Date day,Calendar cal) {
	      if (day == null) day = new Date();
	      cal.setTime(day);
	      cal.set(Calendar.HOUR_OF_DAY, cal.getMinimum(Calendar.HOUR_OF_DAY));
	      cal.set(Calendar.MINUTE,      cal.getMinimum(Calendar.MINUTE));
	      cal.set(Calendar.SECOND,      cal.getMinimum(Calendar.SECOND));
	      cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
	      return cal.getTime();
	}
	public static Date getCuoiNgay(Date day) {
	      return getCuoiNgay(day,Calendar.getInstance());
	}
	
	public static Date getCuoiNgay(Date day,Calendar cal) {
	      if (day == null) day = new Date();
	      cal.setTime(day);
	      cal.set(Calendar.HOUR_OF_DAY, cal.getMaximum(Calendar.HOUR_OF_DAY));
	      cal.set(Calendar.MINUTE,      cal.getMaximum(Calendar.MINUTE));
	      cal.set(Calendar.SECOND,      cal.getMaximum(Calendar.SECOND));
	      cal.set(Calendar.MILLISECOND, cal.getMaximum(Calendar.MILLISECOND));
	      return cal.getTime();
	}
	public static Date getNgayDauThang(Date day) {
	      return getNgayDauThang(day,Calendar.getInstance());
	}
	
	public static Date getNgayDauThang(Date day,Calendar cal) {
	      if (day == null) day = new Date();
	      cal.setTime(day);
	      cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DAY_OF_MONTH));
	      return cal.getTime();
	}
	public static Date getNgayCuoiThang(Date day) {
	      return getNgayCuoiThang(day,Calendar.getInstance());
	}
	
	public static Date getNgayCuoiThang(Date day,Calendar cal) {
	      if (day == null) day = new Date();
	      cal.setTime(day);
	      cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
	      return cal.getTime();
	}
}
