
package vn.dtt.ns.reporting;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import vn.dtt.ns.ulti.format.DateUtils;
import vn.dtt.ns.ulti.format.FormatData;





import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.portlet.PortletProps;

public class ReportFunction {
	
	private static Log log = LogFactoryUtil.getLog(ReportFunction.class);
	
	private static final String NGAY_UPPERCASE = PortletProps.get("vn.ns.label.report.ngay.uppercase");
	private static final String GIO = PortletProps.get("vn.ns.label.report.gio");
	private static final String NGAY = PortletProps.get("vn.ns.label.report.ngay");
	private static final String THANG = PortletProps.get("vn.ns.label.report.thang");
	private static final String NAM = PortletProps.get("vn.ns.label.report.nam");
	
	
	
	public static String getCurrentDate() {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			String sDay = "";
			if (day < 10) { sDay = "0" + day; }
			else { sDay = day + ""; };
			
			int month = calendar.get(Calendar.MONTH) + 1;
			String sMonth = "";
			if (month < 10) { sMonth = "0" + month; }
			else { sMonth = month + ""; }
			
			int year = calendar.get(Calendar.YEAR);
			return "(Date)      , " + NGAY + " " + sDay + " " + THANG + " " + sMonth + " " + NAM + " " + year;
		} catch (Exception e) {
			log.error(e);
		}
		return "(Date)      , " + NGAY + "      " + THANG + "      " + NAM + "     ";
	}
	
	public static String parseDateToString(Date date) {
		if (Validator.isNotNull(date)) {
			try {
				return DateUtils.dateToString("dd/MM/yyyy", date);
			} catch (Exception es) {
				log.error(es);
			}
		}
		return "";
	}
	
	public static String parseDateToString1(Date date) {
		if (Validator.isNotNull(date)) {
			try {
				return DateUtils.dateToString("dd/MM/yyyy", date);
			} catch (Exception es) {
				log.error(es);
			}
		}
		return "";
	}
	
	
	
	public static String parserDateToString3 (Date date) {
		if (Validator.isNotNull(date)) {
			try {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				
				int hours = calendar.get(Calendar.HOUR_OF_DAY);
				String sHours = "";
				if (hours < 10) { sHours = "0" + hours; }
				else { sHours = hours + ""; }
				
				int minutes = calendar.get(Calendar.MINUTE);
				String sMinutes = "";
				if (minutes < 10) { sMinutes = "0" + minutes ; }
				else { sMinutes = minutes + ""; };
				
				int day = calendar.get(Calendar.DAY_OF_MONTH);
				String sDay = "";
				if (day < 10) { sDay = "0" + day; }
				else { sDay = day + ""; };
				
				int month = calendar.get(Calendar.MONTH) + 1;
				String sMonth = "";
				if (month < 10) { sMonth = "0" + month; }
				else { sMonth = month + ""; }
				
				int year = calendar.get(Calendar.YEAR);
				return sHours + ":" + sMinutes + " " + NGAY + " " + sDay + " " + THANG + " " + sMonth + " " + NAM + " " + year;
			} catch (Exception e) {
				log.error(e);
			}
		}
		return "";
	}
	public static String parserDateToString3LT (Date date) {
		if (Validator.isNotNull(date)) {
			try {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				int hours = calendar.get(Calendar.HOUR_OF_DAY);
				int minutes = calendar.get(Calendar.MINUTE);
				
				String sHours = "";
				if (hours < 10) { sHours = "0" + hours; }
				else { sHours = hours + ""; };
				
				String sMinutes = "";
				if (minutes < 10) { sMinutes = "0" + minutes ; }
				else { sMinutes = minutes + ""; };
				
				int day = calendar.get(Calendar.DAY_OF_MONTH);
				
				String sDay = "";
				if (day < 10) { sDay = "0" + day; }
				else { sDay = day + ""; }
				
				int month = calendar.get(Calendar.MONTH) + 1;
				String sMonth = "";
				if (month < 10) { sMonth = "0" + month; }
				else { sMonth = month + ""; }
				
				int year = calendar.get(Calendar.YEAR);
				return sDay + "/" + sMonth + "/" + year + "-" + sHours +":"+ sMinutes + " ";
			} catch (Exception e) {
				log.error(e);
			}
		}
		return "";
	}
	
	public static String parserDateToString4 (Date date) {
		if (Validator.isNotNull(date)) {
			try {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				int day = calendar.get(Calendar.DAY_OF_MONTH);
				String sDay = "";
				if (day < 10) { sDay = "0" + day;
				} else { sDay = day + ""; }

				int month = calendar.get(Calendar.MONTH) + 1;
				String sMonth = "";
				if (month < 10) { sMonth = "0" + month; }
				else { sMonth = month + ""; }
				
				int year = calendar.get(Calendar.YEAR);
				return NGAY + " " + sDay + " " + THANG + " " + sMonth + " " + NAM + " " + year;
			} catch (Exception e) {
				log.error(e);
			}
		}
		return "";
	}
	
	public static String parserDateToString5 (Date date) {
		if (Validator.isNotNull(date)) {
			try {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				
				int day = calendar.get(Calendar.DAY_OF_MONTH);
				String sDay = "";
				if (day < 10) { sDay = "0" + day;
				} else { sDay = day + ""; }

				int month = calendar.get(Calendar.MONTH) + 1;
				String sMonth = "";
				if (month < 10) { sMonth = "0" + month; }
				else { sMonth = month + ""; }
				
				int year = calendar.get(Calendar.YEAR);
				return NGAY_UPPERCASE + " " + sDay + " " + THANG + " " + sMonth + " " + NAM + " " + year;
			} catch (Exception e) {
				log.error(e);
			}
		}
		return "";
	}
	public static String getSignPlaceAndSignDate (String signPlace, String signDate) {
		if(Validator.isNotNull(signPlace) && signPlace.trim().length() > 0){
			signPlace = signPlace + ", ";
		}
		Date date = null;
		if (Validator.isNotNull(signDate) && signDate.trim().length() > 0) {
			try {
				date = FormatData.formatDateShort.parse(signDate);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			try {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				int day = calendar.get(Calendar.DAY_OF_MONTH);
				String sDay = "";
				if (day < 10) { sDay = "0" + day;
				} else { sDay = day + ""; }

				int month = calendar.get(Calendar.MONTH) + 1;
				String sMonth = "";
				if (month < 10) { sMonth = "0" + month; }
				else { sMonth = month + ""; }
				
				int year = calendar.get(Calendar.YEAR);
				return signPlace + NGAY + " " + sDay + " " + THANG + " " + sMonth + " " + NAM + " " + year;
			} catch (Exception e) {
				log.error(e);
			}
		}
		return "(Date)       ,ngày       tháng      năm     ";
	}
	
	public static String parseDateVN(Date date) {
		if (Validator.isNotNull(date)) {
			try {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				int day = calendar.get(Calendar.DAY_OF_MONTH);
				String sDay = "";
				if (day < 10) {
					sDay = "0" + day;
				} else {
					sDay = day + "";
				}
				
				int month = calendar.get(Calendar.MONTH) + 1;
				String sMonth = "";
				if (month < 10) {
					sMonth = "0" + month;
				} else {
					sMonth = month + "";
				}
				int year = calendar.get(Calendar.YEAR);
				return NGAY + "  " + sDay + "  " + THANG + "  " + sMonth + "  " + NAM + "  " + year;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	public static String parseDateVN() {
		Date date = new Date();
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			String sDay = "";
			if (day < 10) {
				sDay = "0" + day;
			} else {
				sDay = day + "";
			}
			
			int month = calendar.get(Calendar.MONTH) + 1;
			String sMonth = "";
			if (month < 10) {
				sMonth = "0" + month;
			} else {
				sMonth = month + "";
			}
			int year = calendar.get(Calendar.YEAR);
		
			
			//return NGAY + "  " + sDay + "  " + THANG + "  " + sMonth + "  " + NAM + "  " + year;
			return "ngày" + "  " + sDay + "  " + "tháng" + "  " + sMonth + "  " + "năm" + "  " + year;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
