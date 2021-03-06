package vn.dtt.ns.reporting.model.chitietyeucaugiaitrinh;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vn.dtt.cmon.dm.dao.model.DATAITEM;
import vn.dtt.ns.reporting.model.chitietyeucaugiaitrinh.ChiTietYCGiaiTrinh.ChiTietYCGiaiTrinhDanhSach;
import vn.dtt.ns.thongtinphanhoi.business.ChiTietThongTinPhanHoiBusiness;
import vn.dtt.ns.thongtinphanhoi.business.DataItemBusiness;
import vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails;
import vn.dtt.ns.ulti.format.ConvertUtil;
import vn.dtt.ns.yeucaugiaitrinh.business.ChiTietYeuCauGiaiTrinhBusiness;
import vn.dtt.ns.yeucaugiaitrinh.business.YeuCauGiaiTrinhBusiness;
import vn.dtt.ns.yeucaugiaitrinh.dao.model.ChiTietYeuCauGiaiTrinh;
import vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class ChiTietYCGiaiTrinhExport {
	private static Log log = LogFactoryUtil.getLog(ChiTietYCGiaiTrinhExport.class);
	
	
	public static ChiTietYCGiaiTrinh getModel(long ycgtId,String maTinh, String maHuyen, String maXa,String topicCode, String topicName, String strFromDate, String strToDate){
		log.info("==START==ChiTietYeuCauGiaiTrinhExport===");
		ChiTietYCGiaiTrinh result = new ChiTietYCGiaiTrinh();
		
		ChiTietYCGiaiTrinhDanhSach  chiTietYeuCauGiaiTrinhDanhSach = null;
		List<ChiTietYCGiaiTrinhDanhSach> lstChiTietYCGiaiTrinhDanhSach = null;
		
		String tenTinhValue = "";
		String tenHuyenValue = "";
		String xaValue = "";
		String chuDeValue = "";
		String ngayTaoValue = "";
		String thoiGianPhanHoiTuValue = "";
		String thoiGianPhanHoiDenValue = "";
		int soPhanHoiValue = 0;
		
		YeuCauGiaiTrinh ycgt = YeuCauGiaiTrinhBusiness.getYeuCauGiaiTrinh(ycgtId);
		if(Validator.isNotNull(ycgt)){
			DATAITEM itemTinh = DataItemBusiness.getDataItem(1, 1, ycgt.getMaTinh());
			tenTinhValue = Validator.isNotNull(itemTinh) ? itemTinh.getName(): "" ;
			
			DATAITEM itemHuyen = DataItemBusiness.getDataItem(1, 2, ycgt.getMaHuyen());
			tenHuyenValue = Validator.isNotNull(itemTinh) ? itemHuyen.getName(): "" ;
			
			DATAITEM itemXa = DataItemBusiness.getDataItem(1, 3, ycgt.getMaXa());
			xaValue = Validator.isNotNull(itemTinh) ? itemXa.getName(): "" ;
			
			chuDeValue = topicName;
			ngayTaoValue = Validator.isNotNull(ycgt.getNgayTao()) ? ConvertUtil.parseDateToString(ycgt.getNgayTao()): "";
			thoiGianPhanHoiTuValue = strFromDate;
			thoiGianPhanHoiDenValue = strToDate;
			
			soPhanHoiValue = Validator.isNotNull(ycgt.getSoLuongTheoChuDe()) ? ycgt.getSoLuongTheoChuDe() : 0 ;
			
			List<TopicDetails> lstTopicDetails = ChiTietThongTinPhanHoiBusiness.getTopicDetailsByYcgtId(ycgtId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			lstChiTietYCGiaiTrinhDanhSach = new ArrayList<ChiTietYCGiaiTrinhDanhSach>();
			
			Date fromDate = Validator.isNotNull(strFromDate) ? ConvertUtil.parseStringToDate(strFromDate) : null;
			Date toDate = Validator.isNotNull(strToDate) ?  ConvertUtil.parseStringToDate(strToDate) : null;
			
			if(Validator.isNotNull(lstTopicDetails) && lstTopicDetails.size() > 0){
				for (TopicDetails topicDetails : lstTopicDetails) {
					chiTietYeuCauGiaiTrinhDanhSach = result.new ChiTietYCGiaiTrinhDanhSach();
					
					DATAITEM dataItem = DataItemBusiness.getDataItem(9, 2, topicDetails.getMaThongTinPhanAnh());
					ChiTietYeuCauGiaiTrinh chiTietYcgt = ChiTietYeuCauGiaiTrinhBusiness.getChiTietGiaiTrinhByYcgtIdAndMaThongTinPhanAnh(topicDetails.getYeuCauGiaiTrinhId(), topicDetails.getMaThongTinPhanAnh());
					long soLuong = ChiTietThongTinPhanHoiBusiness.countPhanHoiByMaThongTinPhanAnh(topicCode, topicDetails.getMaThongTinPhanAnh(), maTinh, maHuyen, maXa, fromDate, toDate);
					
					String thongTinPhanAnhValue = "";
					int luotPhanHoiValue = 0;
					String giaiTrinhValue = "";
					
					thongTinPhanAnhValue = Validator.isNotNull(dataItem) ? dataItem.getName() : "" ;
					luotPhanHoiValue = ConvertUtil.convertLongToInt(soLuong);
					giaiTrinhValue = Validator.isNotNull(chiTietYcgt) ? chiTietYcgt.getGiaiTrinh() : "";
					
					
					chiTietYeuCauGiaiTrinhDanhSach.setThongTinPhanAnh(thongTinPhanAnhValue);
					chiTietYeuCauGiaiTrinhDanhSach.setLuotPhanHoi(luotPhanHoiValue);
					chiTietYeuCauGiaiTrinhDanhSach.setGiaiTrinh(giaiTrinhValue);
					
					lstChiTietYCGiaiTrinhDanhSach.add(chiTietYeuCauGiaiTrinhDanhSach);
				}
			}
			
		}
		
		result.setTenTinh(tenTinhValue);
		result.setTenHuyen(tenHuyenValue);
		result.setXa(xaValue);
		result.setChuDe(chuDeValue);
		result.setNgayTao(ngayTaoValue);
		result.setThoiGianPhanHoiTu(thoiGianPhanHoiTuValue);
		result.setThoiGianPhanHoiDen(thoiGianPhanHoiDenValue);
		result.setSoPhanHoi(soPhanHoiValue);
		result.setLstChiTietYCGiaiTrinhDanhSach(lstChiTietYCGiaiTrinhDanhSach);
		log.info("==END==ChiTietYeuCauGiaiTrinhExport===");
		return result;
	}
}
