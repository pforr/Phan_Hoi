package vn.dtt.ns.yeucaugiaitrinh.business;

import vn.dtt.ns.yeucaugiaitrinh.dao.model.ChiTietYeuCauGiaiTrinh;
import vn.dtt.ns.yeucaugiaitrinh.dao.service.ChiTietYeuCauGiaiTrinhLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class ChiTietYeuCauGiaiTrinhBusiness {
	private static Log _log = LogFactoryUtil.getLog(ChiTietYeuCauGiaiTrinhBusiness.class);
	public static ChiTietYeuCauGiaiTrinh getChiTietGiaiTrinhByYcgtIdAndMaThongTinPhanAnh(long  ycgtId, String maThongTinPhanAnh){
		ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh = null;
		try{
			chiTietYeuCauGiaiTrinh = ChiTietYeuCauGiaiTrinhLocalServiceUtil.getChiTietGiaiTrinhByYcgtIdAndMaThongTinPhanAnh(ycgtId, maThongTinPhanAnh);
		}catch (Exception e) {
			_log.error(e);
		}
		return chiTietYeuCauGiaiTrinh;
	}
}
