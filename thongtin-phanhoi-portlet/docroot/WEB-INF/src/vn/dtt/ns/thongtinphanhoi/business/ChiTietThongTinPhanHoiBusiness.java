package vn.dtt.ns.thongtinphanhoi.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails;
import vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi;
import vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class ChiTietThongTinPhanHoiBusiness {
	private static Log _log = LogFactoryUtil.getLog(ChiTietThongTinPhanHoiBusiness.class);
	public static List<TopicDetails> getTopicDetailsByYcgtId(long ycgtId, int start, int end){
		List<TopicDetails> lstTopicDetails = new ArrayList<TopicDetails>();
		try{
			lstTopicDetails = ChiTietThongTinPhanHoiLocalServiceUtil.getTopicDetailsByYcgtId(ycgtId, start, end);
		}catch (Exception e) {
			_log.error(e);
		}
		return lstTopicDetails;
	}
	
	public static long countPhanHoiByMaThongTinPhanAnh(String topicCode, String feedbackCode, String maTinh, String maHuyen, String maXa, Date fromDate, Date toDate) {
		long out = 0;
		try{
			out= ChiTietThongTinPhanHoiLocalServiceUtil.countPhanHoiByMaThongTinPhanAnh(topicCode, feedbackCode, maTinh, maHuyen, maXa, fromDate, toDate);
		}catch (Exception e) {
			_log.error(e);
		}
		return out;
	}
	public static long countThongKePhanHoi(String  maTinh, int month, int year){
		long out = 0;
		try{
			out = ChiTietThongTinPhanHoiLocalServiceUtil.countThongKePhanHoi(maTinh, month, year);
		}catch (Exception e) {
			_log.error(e);
		}
		return out;
	} 
	public static List<TopicPhanHoi> searchThongKePhanHoi(String maTinh, int month, int year, int start, int end) {
		List<TopicPhanHoi> lst = new ArrayList<TopicPhanHoi>();
		try{
			lst = ChiTietThongTinPhanHoiLocalServiceUtil.searchThongKePhanHoi(maTinh, month, year, start, end);
		}catch (Exception e) {
			_log.error(e);
		}
		return lst;
	}
	public static long countThongKePhanHoiByTrangThai(int  trangThai, String topicCode, String maTinh, Date fromDate, Date toDate)  {
		long out = 0;
		try{
			out= ChiTietThongTinPhanHoiLocalServiceUtil.countThongKePhanHoiByTrangThai(  trangThai,  topicCode,  maTinh,  fromDate,  toDate);
		}catch (Exception e) {
			_log.error(e);
		}
		return out;
	}
}
