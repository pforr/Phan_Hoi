package vn.dtt.ns.yeucaugiaitrinh.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh;
import vn.dtt.ns.yeucaugiaitrinh.dao.service.YeuCauGiaiTrinhLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class YeuCauGiaiTrinhBusiness {
	private static Log _log = LogFactoryUtil.getLog(YeuCauGiaiTrinhBusiness.class);
	public static YeuCauGiaiTrinh getYeuCauGiaiTrinh(long ycgtId){
		YeuCauGiaiTrinh yeuCauGiaiTrinh = null;
		
		try{
			yeuCauGiaiTrinh = YeuCauGiaiTrinhLocalServiceUtil.getYeuCauGiaiTrinh(ycgtId);
		}catch (Exception e) {
			_log.error(e);
		}
		
		return yeuCauGiaiTrinh;
	}
	public static long countYeuCauGiaiTrinhNSVS(String maTinh, String[] maHuyen, String[] maXa, int trangThaiGiaiTrinh, String[] maChuDe, int soLuotPhanHoi, Date fromDate, Date toDate){
		long out = 0;
		try{
			out = YeuCauGiaiTrinhLocalServiceUtil.countYeuCauGiaiTrinhNSVS( maTinh,  maHuyen, maXa,  trangThaiGiaiTrinh, maChuDe,  soLuotPhanHoi,  fromDate,  toDate);
		}catch (Exception e) {
			_log.error(e);
		}
		return out;
	}
	public static List<YeuCauGiaiTrinh> searchYeuCauGiaiTrinhNSVS(String maTinh, String[] maHuyen, String[] maXa, int trangThaiGiaiTrinh, String[] maChuDe, int soLuotPhanHoi, Date fromDate, Date toDate, int start, int end){
		List<YeuCauGiaiTrinh> lst = new ArrayList<YeuCauGiaiTrinh>();
		try{
			lst = YeuCauGiaiTrinhLocalServiceUtil.searchYeuCauGiaiTrinhNSVS( maTinh,  maHuyen,  maXa,  trangThaiGiaiTrinh,  maChuDe,  soLuotPhanHoi,  fromDate,  toDate,  start,  end);
		}catch (Exception e) {
			_log.error(e);
		}
		return lst;
	}
	public static long countYeuCauGiaiTrinh(String maTinh, String maHuyen, String maXa, int trangThaiGiaiTrinh, String maChuDe, int soLuotPhanHoi, Date fromDate, Date toDate){
		long out = 0;
		try{
			out = YeuCauGiaiTrinhLocalServiceUtil.countYeuCauGiaiTrinh(maTinh, maHuyen, maXa, trangThaiGiaiTrinh, maChuDe, soLuotPhanHoi, fromDate, toDate);
		}catch (Exception e) {
			_log.error(e);
		}
		return out;
	}
	public static List<YeuCauGiaiTrinh> searchYeuCauGiaiTrinh(String maTinh, String maHuyen, String maXa, int trangThaiGiaiTrinh, String maChuDe, int soLuotPhanHoi,  Date fromDate, Date toDate, int start, int end){
		List<YeuCauGiaiTrinh> lst = new ArrayList<YeuCauGiaiTrinh>();
		try{
			lst = YeuCauGiaiTrinhLocalServiceUtil.searchYeuCauGiaiTrinh(maTinh, maHuyen, maXa, trangThaiGiaiTrinh, maChuDe, soLuotPhanHoi, fromDate, toDate, start, end);
		}catch (Exception e) {
			_log.error(e);
		}
		return lst;
	}
}
