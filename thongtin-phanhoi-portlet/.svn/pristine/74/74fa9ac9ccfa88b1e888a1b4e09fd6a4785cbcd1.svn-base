package vn.dtt.ns.reporting.model.thongkephanhoi;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import vn.dtt.cmon.dm.dao.model.DATAITEM;
import vn.dtt.ns.reporting.model.thongkephanhoi.TKPhanHoi.TKPhanHoiDanhSach;
import vn.dtt.ns.thongtinphanhoi.business.ChiTietThongTinPhanHoiBusiness;
import vn.dtt.ns.thongtinphanhoi.business.DataItemBusiness;
import vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi;
import vn.dtt.ns.thongtinphanhoi.util.ThongTinPhanHoiConstants;
import vn.dtt.ns.ulti.format.ConvertUtil;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class TKPhanHoiExport {
	private static Log log = LogFactoryUtil.getLog(TKPhanHoiExport.class);
	
	public static TKPhanHoi getModel(String maTinh, String strMonthAndYear){
		log.info("==START==TKPhanHoiExport===");
		TKPhanHoi result = new TKPhanHoi();
		
		TKPhanHoiDanhSach phanHoiDanhSach = null;
		List<TKPhanHoiDanhSach> lstPhanHoiDanhSach = null;
		
		
		String tenTinhValue = "";
		String thangNamValue = "";
		
		DATAITEM itemTinh = DataItemBusiness.getDataItem(1, 1, maTinh);
		tenTinhValue = Validator.isNotNull(itemTinh) ? itemTinh.getName(): "" ;
		
		thangNamValue = strMonthAndYear;
		
		Date fromDate = null;
		Date toDate = null;
		int month = 0;
		int year = 0;
		if(Validator.isNotNull(strMonthAndYear)){
			String[] strMonthAndYears = strMonthAndYear.split("/");
			if(strMonthAndYears != null){
				month = Integer.parseInt(strMonthAndYears[0]);
				year = Integer.parseInt(strMonthAndYears[1]);
				
				Calendar calendar = Calendar.getInstance();
				calendar.set(Calendar.MONTH, month - 1);
				calendar.set(Calendar.YEAR, year);
				calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
				fromDate = calendar.getTime();
				
				calendar.clear();
				calendar.set(Calendar.MONTH, month - 1);
				calendar.set(Calendar.YEAR, year);
				calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));		
				toDate = calendar.getTime();
			}
		}
		
		long total = ChiTietThongTinPhanHoiBusiness.countThongKePhanHoi(maTinh, month, year);
		if(total > 0){
			
			List<TopicPhanHoi> lstTopicPhanHoi = ChiTietThongTinPhanHoiBusiness.searchThongKePhanHoi(maTinh, month, year, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			lstPhanHoiDanhSach = new ArrayList<TKPhanHoiDanhSach>();
			if(Validator.isNotNull(lstTopicPhanHoi) && lstTopicPhanHoi.size() > 0){
				for (TopicPhanHoi topicPhanHoi : lstTopicPhanHoi) {
					phanHoiDanhSach = result.new TKPhanHoiDanhSach();
					
					String chuDeValue = "";
					int soPhanHoiValue = 0;
					int soPhanHoiDaTaoGiaiTrinhValue = 0;
					int soPhanHoiChuaTaoGiaiTrinhValue = 0;
					
					
					long soPhanHoiDaTaoYcgt = ChiTietThongTinPhanHoiBusiness.countThongKePhanHoiByTrangThai(ThongTinPhanHoiConstants.TrangThaiYcgt.DA_TAO_YCGT, topicPhanHoi.getTopicCode(), maTinh, fromDate, toDate);
					long soPhanHoiChuaTaoYcgt = ChiTietThongTinPhanHoiBusiness.countThongKePhanHoiByTrangThai(ThongTinPhanHoiConstants.TrangThaiYcgt.CHUA_TAO_YCGT, topicPhanHoi.getTopicCode(), maTinh, fromDate, toDate);
					long soPhanHoi = soPhanHoiDaTaoYcgt + soPhanHoiChuaTaoYcgt;
					
					chuDeValue = Validator.isNotNull(topicPhanHoi.getTopicName()) ? topicPhanHoi.getTopicName() : "";
					soPhanHoiValue = ConvertUtil.convertLongToInt(soPhanHoi);
					soPhanHoiDaTaoGiaiTrinhValue = ConvertUtil.convertLongToInt(soPhanHoiDaTaoYcgt);
					soPhanHoiChuaTaoGiaiTrinhValue = ConvertUtil.convertLongToInt(soPhanHoiChuaTaoYcgt);
					
					phanHoiDanhSach.setChuDe(chuDeValue);
					phanHoiDanhSach.setSoPhanHoi(soPhanHoiValue);
					phanHoiDanhSach.setSoPhanHoiDaTaoGiaiTrinh(soPhanHoiDaTaoGiaiTrinhValue);
					phanHoiDanhSach.setSoPhanHoiChuaTaoGiaiTrinh(soPhanHoiChuaTaoGiaiTrinhValue);
					
					lstPhanHoiDanhSach.add(phanHoiDanhSach);
				}
				
			}
		}
		result.setTenTinh(tenTinhValue);
		result.setThangNam(thangNamValue);
		result.setLstPhanHoiDanhSach(lstPhanHoiDanhSach);
		
		log.info("==END==TKPhanHoiExport===");
		return result;
	}
}
