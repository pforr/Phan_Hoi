package vn.dtt.ns.reporting;

import java.util.HashMap;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import vn.dtt.ns.reporting.model.chitietyeucaugiaitrinh.ChiTietYCGiaiTrinh;
import vn.dtt.ns.reporting.model.chitietyeucaugiaitrinh.ChiTietYCGiaiTrinhExport;
import vn.dtt.ns.reporting.model.thongkephanhoi.TKPhanHoi;
import vn.dtt.ns.reporting.model.thongkephanhoi.TKPhanHoiExport;
import vn.dtt.ns.ulti.format.FormatData;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

public class ReportBusinessUtils {
	
	private static Log log = LogFactoryUtil.getLog(ReportBusinessUtils.class);
	
	private static HashMap<String, Object> parameters = null;
	
	
	
//	public static String actionExport_Dli_11_TH(String realPath, String namBaoCao, String maTinh, String soBaoCao, String ngayBaoCao, String nguoiLap, String nguoiDuyet, String duoiFile, String thoigianthuc,String donViBaoCao){
//		String fileUrl = "";
//		log.debug("--actionExport_Dli_11_TH==maTinh--"+maTinh+"--namBaoCao=="+namBaoCao+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao);
//		
//		try {
//			String tenFile_Export = namBaoCao+"_"+maTinh+"_"+ReportConstant.GIAY_DLI1_1_TH_EXPORT+"_"+thoigianthuc;
//			SoDauNoiMoiHoatDong objectReport = SoDauNoiMoiHoatDongExport.getModel(namBaoCao, maTinh,  soBaoCao, ngayBaoCao,nguoiLap,nguoiDuyet,thoigianthuc,donViBaoCao);
//			JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
//			parameters = new HashMap<String, Object>();
//			fileUrl = ReportUtils.exportFunction(realPath, ReportUtils.DLI_1_1, ReportConstant.GIAY_DLI1_1_TH_TEMP, tenFile_Export, dataSource, parameters,duoiFile);
//		} catch (Exception e) {
//			log.error(e);
//		} 
//		return fileUrl;
//	}
	
	
	public static void inBaoCaoDLI(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		log.info("----inBaoCaoDLI---vao inbaocao");
		HashMap<String, Object> parameters = null;
		String currentTimeFull = FormatData.getCurrentTimeFull();
		
		String type = ParamUtil.getString(resourceRequest, "typeRS");
		String duoiFile = ParamUtil.getString(resourceRequest, "duoiFileRS");
		long ycgtId = ParamUtil.getLong(resourceRequest, "ycgtIdRS", 0);
		String maTinh = ParamUtil.getString(resourceRequest, "maTinhRS");
		String maHuyen = ParamUtil.getString(resourceRequest, "maHuyenRS");
		String maXa = ParamUtil.getString(resourceRequest, "maXaRS");
		String topicCode = ParamUtil.getString(resourceRequest, "topicCodeRS");
		String topicName = ParamUtil.getString(resourceRequest, "topicNameRS");
		String strFromDate = ParamUtil.getString(resourceRequest, "strFromDateRS");
		String strToDate = ParamUtil.getString(resourceRequest, "strToDateRS");
		
		String strMonthAndYear = ParamUtil.getString(resourceRequest, "strMonthAndYearRS");
		
		
		String realPath = ReportUtils.getTemplateReportFilePath(resourceRequest);
		log.info("--inBaoCaoDLI--realpath--"+realPath+"=="+ycgtId+"--"+maTinh+"=="+strMonthAndYear+"--");
		
		//String tenFileExport = ReportConstant.TEN_FILE_DEFAULT+"."+duoiFile;
		log.info("---inBaoCaoDLI--duoiFile--"+duoiFile+"====");
		log.info("---type---"+type+"===");
		try{
			if(Validator.isNotNull(duoiFile)
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.CHITIETYEUCAUGIAITRINH)){
				log.info("==type--"+type);
				
				String tenFile_Export = ReportConstant.GIAY_CHITIETYEUCAUGIAITRINH_EXPORT+"_"+currentTimeFull;
				ChiTietYCGiaiTrinh objectReport = ChiTietYCGiaiTrinhExport.getModel( ycgtId, maTinh,  maHuyen,  maXa, topicCode,  topicName,  strFromDate,  strToDate);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.GIAITRINH, ReportConstant.GIAY_CHITIETYEUCAUGIAITRINH_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
				
			}
			if(Validator.isNotNull(duoiFile)
					&& Validator.isNotNull(type) 
					&& type.trim().equalsIgnoreCase(ReportConstant.THONGKEPHANHOI)){
				log.info("==type--"+type);
				
				String tenFile_Export = ReportConstant.GIAY_THONGKEPHANHOI_EXPORT+"_"+currentTimeFull;
				TKPhanHoi objectReport = TKPhanHoiExport.getModel(  maTinh, strMonthAndYear);
				JRBeanCollectionDataSource dataSource = ObjectExportToReportUtils.exportBieuMau( objectReport);
				parameters = new HashMap<String, Object>();
				ReportUtils.exportFunctionResourceURL(realPath, ReportUtils.PHANHOI, ReportConstant.GIAY_THONGKEPHANHOI_TEMP, tenFile_Export, dataSource, parameters,duoiFile,resourceResponse);
				
			}
		}catch (Exception e) {
			log.error(e);
		}
		
		
	}
}
