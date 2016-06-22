package vn.dtt.ns.thongtinphanhoi.business;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.ns.thongtinphanhoi.dao.model.TrangThaiThongKePhanHoi;
import vn.dtt.ns.thongtinphanhoi.dao.service.TrangThaiThongKePhanHoiLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class TrangThaiThongKePhanHoiBusiness {
	private static Log _log = LogFactoryUtil.getLog(TrangThaiThongKePhanHoiBusiness.class);
	public static TrangThaiThongKePhanHoi fetchByarticleId(int articleId){
		TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = null;
		try{
			trangThaiThongKePhanHoi = TrangThaiThongKePhanHoiLocalServiceUtil.fetchByarticleId(articleId);
		}catch (Exception e) {
			_log.error(e);
		}
		return trangThaiThongKePhanHoi;
	}
	public static TrangThaiThongKePhanHoi fetchBymaTinhThangNamChuyenSangMB(String maTinh, String thangNam, int daChuyenSangMinhBach){
		TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = null;
		try{
			trangThaiThongKePhanHoi = TrangThaiThongKePhanHoiLocalServiceUtil.fetchBymaTinhThangNamChuyenSangMB(maTinh, thangNam, daChuyenSangMinhBach);
		}catch (Exception e) {
			_log.error(e);
		}
		return trangThaiThongKePhanHoi;
	}
	public static List<TrangThaiThongKePhanHoi> findBymaTinh(String maTinh){
		List<TrangThaiThongKePhanHoi> lst = new ArrayList<TrangThaiThongKePhanHoi>();
		try{
			lst = TrangThaiThongKePhanHoiLocalServiceUtil.findBymaTinh(maTinh);
		}catch (Exception e) {
			_log.error(e);
		}
		return lst;
	}
	public static List<TrangThaiThongKePhanHoi> findBythangNam(String thangNam){
		List<TrangThaiThongKePhanHoi> lst = new ArrayList<TrangThaiThongKePhanHoi>();
		try{
			lst = TrangThaiThongKePhanHoiLocalServiceUtil.findBythangNam(thangNam);
		}catch (Exception e) {
			_log.error(e);
		}
		return lst;
	}
	public static TrangThaiThongKePhanHoi fetchByarticleIdAndDaChuyenSangMinhBach(int articleId, int daChuyenSangMinhBach ){
		TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = null;
		try{
			trangThaiThongKePhanHoi = TrangThaiThongKePhanHoiLocalServiceUtil.fetchByarticleIdAndDaChuyenSangMinhBach(articleId, daChuyenSangMinhBach);
		}catch (Exception e) {
			_log.error(e);
		}
		return trangThaiThongKePhanHoi;
	}
}
