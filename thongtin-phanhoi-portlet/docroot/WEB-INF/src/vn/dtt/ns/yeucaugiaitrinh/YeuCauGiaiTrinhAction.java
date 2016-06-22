package vn.dtt.ns.yeucaugiaitrinh;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import vn.dtt.cmon.dm.dao.model.DATAITEM;
import vn.dtt.cmon.dm.dao.service.DATAITEMLocalServiceUtil;
import vn.dtt.cmon.user.dao.model.UserHuyen;
import vn.dtt.cmon.user.dao.model.UserMapping;
import vn.dtt.cmon.user.dao.service.UserHuyenLocalServiceUtil;
import vn.dtt.cmon.user.dao.service.UserMappingLocalServiceUtil;
import vn.dtt.cmon.user.dao.service.UserTinhLocalServiceUtil;
import vn.dtt.ns.minhbach.ModelAddUpdateArticle;
import vn.dtt.ns.minhbach.TestLiferayJSON;
import vn.dtt.ns.reporting.ReportBusinessUtils;
import vn.dtt.ns.thongtinphanhoi.business.DataItemBusiness;
import vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails;
import vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiLocalServiceUtil;
import vn.dtt.ns.thongtinphanhoi.util.DauNoiNuocConstantString;
import vn.dtt.ns.thongtinphanhoi.util.ThongTinPhanHoiConstants;
import vn.dtt.ns.ulti.format.FormatData;
import vn.dtt.ns.yeucaugiaitrinh.dao.model.ChiTietYeuCauGiaiTrinh;
import vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh;
import vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh;
import vn.dtt.ns.yeucaugiaitrinh.dao.service.ChiTietYeuCauGiaiTrinhLocalServiceUtil;
import vn.dtt.ns.yeucaugiaitrinh.dao.service.TrangThaiGiaiTrinhLocalServiceUtil;
import vn.dtt.ns.yeucaugiaitrinh.dao.service.YeuCauGiaiTrinhLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class YeuCauGiaiTrinhAction
 */
public class YeuCauGiaiTrinhAction extends MVCPortlet {
	
	private static Log _log = LogFactoryUtil.getLog(YeuCauGiaiTrinhAction.class);

	public void search(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		int actionMode = ParamUtil.getInteger(actionRequest, "actionMode", 0);
		boolean hasUserGt = ParamUtil.getBoolean(actionRequest, "hasUserGt", false);
		String maTinh = ParamUtil.getString(actionRequest, "selectMaTinh", "");
		String maHuyen = ParamUtil.getString(actionRequest, "selectMaHuyen", "");
		String maXa = ParamUtil.getString(actionRequest, "selectMaXa", "");
		String maChuDe = ParamUtil.getString(actionRequest, "selectMaChuDe", "");
		int soLuotPhanHoi = ParamUtil.getInteger(actionRequest, "soLuotPhanHoi", 0);
		String trangThaiGiaiTrinh = ParamUtil.getString(actionRequest, "trangThaiGiaiTrinh", "");
		String strFromDate = ParamUtil.getString(actionRequest, "fromDate", "");
		String strToDate = ParamUtil.getString(actionRequest, "toDate", "");
		
		setSearchParameter(actionRequest, actionResponse);
		
		actionResponse.setRenderParameter("maTinh", maTinh);
		actionResponse.setRenderParameter("actionMode", String.valueOf(actionMode));
		actionResponse.setRenderParameter("hasUserGt", String.valueOf(hasUserGt));
		actionResponse.setRenderParameter("maHuyen", maHuyen);
		actionResponse.setRenderParameter("maXa", maXa);
		actionResponse.setRenderParameter("maChuDe", maChuDe);
		actionResponse.setRenderParameter("soLuotPhanHoi", String.valueOf(soLuotPhanHoi));
		actionResponse.setRenderParameter("trangThaiGiaiTrinh", trangThaiGiaiTrinh);
		actionResponse.setRenderParameter("fromDate", strFromDate);
		actionResponse.setRenderParameter("toDate", strToDate);
		
		PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);		
		SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}
	
	private void setSearchParameter(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		String cur = ParamUtil.getString(actionRequest, "cur");
		if (!StringPool.BLANK.equals(cur)) {
			actionResponse.setRenderParameter("cur",
					ParamUtil.getString(actionRequest, "cur"));
		}
		String delta = ParamUtil.getString(actionRequest, "delta");
		if (!StringPool.BLANK.equals(delta)) {
			actionResponse.setRenderParameter("delta",
					ParamUtil.getString(actionRequest, "delta"));
		}
	}
	
	public void updateYeuCauGiaiTrinh(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException{
		long ycgtId = ParamUtil.getLong(actionRequest, "ycgtId", 0);		
		Integer actionMode = ParamUtil.getInteger(actionRequest, "actionMode");
		boolean hasUserGt = ParamUtil.getBoolean(actionRequest, "hasUserGt", false);
		long nguoiPheDuyetId = ParamUtil.getLong(actionRequest, "nguoiPheDuyet", 0);
		String ghiChu = ParamUtil.getString(actionRequest, "ghiChu", "");		
				
		
		if(ycgtId > 0 && actionMode != null){		
			Date currentDate = new Date();
			
			//update ws_trangthai_giaitrinh			
			TrangThaiGiaiTrinh trangThaiGiaiTrinh = TrangThaiGiaiTrinhLocalServiceUtil.getTrangThaiGiaiTrinhByYcgtIdAndTrangThai(ycgtId, actionMode);	
			YeuCauGiaiTrinh ycgt = YeuCauGiaiTrinhLocalServiceUtil.getYeuCauGiaiTrinh(ycgtId);
			
			int trangThai = (actionMode == ThongTinPhanHoiConstants.ActionMode.GUI_DUYET || actionMode == ThongTinPhanHoiConstants.ActionMode.GUI_GT 
							 || actionMode == ThongTinPhanHoiConstants.ActionMode.YEUCAU_GIAITRINHLAI ? ThongTinPhanHoiConstants.TrangThaiGiaiTrinh.DANG_XU_LY : 
							 (actionMode == ThongTinPhanHoiConstants.ActionMode.DONG_YCGT || actionMode == ThongTinPhanHoiConstants.ActionMode.USER_TINH_GT ? ThongTinPhanHoiConstants.TrangThaiGiaiTrinh.DA_DUOC_GIAI_TRINH :
							 (actionMode == ThongTinPhanHoiConstants.ActionMode.HUY_YCGT ? ThongTinPhanHoiConstants.TrangThaiGiaiTrinh.HUY : 0))); 
			
			if(trangThaiGiaiTrinh != null){		
				trangThaiGiaiTrinh.setNgayCapNhat(currentDate);				
				trangThaiGiaiTrinh.setTrangThai(actionMode);	
				if(ThongTinPhanHoiConstants.ActionMode.GUI_DUYET == actionMode
				   || ThongTinPhanHoiConstants.ActionMode.GUI_GT == actionMode
				   || ThongTinPhanHoiConstants.ActionMode.YEUCAU_GIAITRINHLAI == actionMode){
					trangThaiGiaiTrinh.setGhiChuNguoiLap(ghiChu);
				}else if(ThongTinPhanHoiConstants.ActionMode.DONG_YCGT == actionMode
				   || ThongTinPhanHoiConstants.ActionMode.HUY_YCGT == actionMode
				   || ThongTinPhanHoiConstants.ActionMode.USER_TINH_GT == actionMode){
					trangThaiGiaiTrinh.setGhiChuNguoiDuyet(ghiChu);
				}						
				trangThaiGiaiTrinh.setUserId(nguoiPheDuyetId);
	
				TrangThaiGiaiTrinhLocalServiceUtil.updateTrangThaiGiaiTrinh(trangThaiGiaiTrinh);
				
				Date ngayCapNhat = trangThaiGiaiTrinh.getNgayCapNhat();
			
				//update ws_yeucau_giaitrinh				
				ycgt.setNgayCapNhat(currentDate);
				ycgt.setTrangThai(trangThai);
				if(actionMode == ThongTinPhanHoiConstants.ActionMode.DONG_YCGT || actionMode == ThongTinPhanHoiConstants.ActionMode.HUY_YCGT || actionMode == ThongTinPhanHoiConstants.ActionMode.USER_TINH_GT){
					ycgt.setNguoiPheDuyet(nguoiPheDuyetId);
					if(actionMode == ThongTinPhanHoiConstants.ActionMode.USER_TINH_GT){
						//insert trang thai close
						long trangThaiDongYcgtPk = CounterLocalServiceUtil.increment(TrangThaiGiaiTrinh.class.getName());			
						TrangThaiGiaiTrinh trangThaiDongYcgt = TrangThaiGiaiTrinhLocalServiceUtil.createTrangThaiGiaiTrinh(trangThaiDongYcgtPk);
						trangThaiDongYcgt.setYeuCauGiaiTrinhId(ycgtId);
						if(ngayCapNhat != null){
							trangThaiDongYcgt.setNgayTao(ngayCapNhat);
						}
						trangThaiDongYcgt.setTrangThai(ThongTinPhanHoiConstants.ActionMode.DONG_YCGT);
						trangThaiDongYcgt.setGhiChuNguoiDuyet(ghiChu);					
						trangThaiDongYcgt.setUserId(nguoiPheDuyetId);	
						trangThaiDongYcgt.setNgayCapNhat(currentDate);
						
						TrangThaiGiaiTrinhLocalServiceUtil.addTrangThaiGiaiTrinh(trangThaiDongYcgt);
					}
				}else if(actionMode == ThongTinPhanHoiConstants.ActionMode.GUI_DUYET || actionMode == ThongTinPhanHoiConstants.ActionMode.YEUCAU_GIAITRINHLAI){
					try {
						sendEmail(actionRequest, ycgt);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//insert trang thai tiep theo
					long trangThaiTiepTheoPk = CounterLocalServiceUtil.increment(TrangThaiGiaiTrinh.class.getName());			
					TrangThaiGiaiTrinh trangThaiGiaiTrinhTiepTheo = TrangThaiGiaiTrinhLocalServiceUtil.createTrangThaiGiaiTrinh(trangThaiTiepTheoPk);
					trangThaiGiaiTrinhTiepTheo.setYeuCauGiaiTrinhId(ycgtId);
					if(ngayCapNhat != null){
						trangThaiGiaiTrinhTiepTheo.setNgayTao(ngayCapNhat);
					}
					
					if(hasUserGt){										
						trangThaiGiaiTrinhTiepTheo.setTrangThai(ThongTinPhanHoiConstants.ActionMode.GUI_GT);
					}else{
						trangThaiGiaiTrinhTiepTheo.setTrangThai(ThongTinPhanHoiConstants.ActionMode.USER_TINH_GT);
					}
	
					TrangThaiGiaiTrinhLocalServiceUtil.addTrangThaiGiaiTrinh(trangThaiGiaiTrinhTiepTheo);
				}else if(actionMode == ThongTinPhanHoiConstants.ActionMode.GUI_GT){						
					//insert to ws_chitiet_yeucau_giaittrinh
					List<TopicDetails> lstTopicDetails = ChiTietThongTinPhanHoiLocalServiceUtil.getTopicDetailsByYcgtId(ycgtId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);					
					for (TopicDetails topicDetails : lstTopicDetails) {					
						String maThongTinPhanAnh = topicDetails.getMaThongTinPhanAnh();
						String giaiTrinh = ParamUtil.getString(actionRequest, "giaiTrinh"+topicDetails.getId(), "");
						int soLuong = ParamUtil.getInteger(actionRequest, "soLuong"+topicDetails.getId(), 0);
						
						ChiTietYeuCauGiaiTrinh existChiTietYcgt = ChiTietYeuCauGiaiTrinhLocalServiceUtil.getChiTietGiaiTrinhByYcgtIdAndMaThongTinPhanAnh(ycgtId, maThongTinPhanAnh);
						if(existChiTietYcgt != null){
							existChiTietYcgt.setGiaiTrinh(giaiTrinh);
							ChiTietYeuCauGiaiTrinhLocalServiceUtil.updateChiTietYeuCauGiaiTrinh(existChiTietYcgt);
						}else{
							if(!StringPool.BLANK.equals(giaiTrinh)){
								long chiTietYcgtPk = CounterLocalServiceUtil.increment(ChiTietYeuCauGiaiTrinh.class.getName());
								ChiTietYeuCauGiaiTrinh chiTietYcgt = ChiTietYeuCauGiaiTrinhLocalServiceUtil.createChiTietYeuCauGiaiTrinh(chiTietYcgtPk);
								
								chiTietYcgt.setYeuCauGiaiTrinhId(ycgtId);
								chiTietYcgt.setMaThongTinPhanAnh(maThongTinPhanAnh);
								chiTietYcgt.setGiaiTrinh(giaiTrinh);
								chiTietYcgt.setSoLuong(soLuong);
								
								ChiTietYeuCauGiaiTrinhLocalServiceUtil.addChiTietYeuCauGiaiTrinh(chiTietYcgt);
							}
						}					
					}
					
					//insert trang thai tiep theo								
					long trangThaiTiepTheo32Pk = CounterLocalServiceUtil.increment(TrangThaiGiaiTrinh.class.getName());			
					TrangThaiGiaiTrinh trangThaiGiaiTrinhTiepTheo32 = TrangThaiGiaiTrinhLocalServiceUtil.createTrangThaiGiaiTrinh(trangThaiTiepTheo32Pk);							
					trangThaiGiaiTrinhTiepTheo32.setYeuCauGiaiTrinhId(ycgtId);
					if(ngayCapNhat != null){	
						trangThaiGiaiTrinhTiepTheo32.setNgayTao(ngayCapNhat);
					}
					trangThaiGiaiTrinhTiepTheo32.setTrangThai(ThongTinPhanHoiConstants.ActionMode.YEUCAU_GIAITRINHLAI);							
					TrangThaiGiaiTrinhLocalServiceUtil.addTrangThaiGiaiTrinh(trangThaiGiaiTrinhTiepTheo32);
					
					long trangThaiTiepTheo0Pk = CounterLocalServiceUtil.increment(TrangThaiGiaiTrinh.class.getName());			
					TrangThaiGiaiTrinh trangThaiGiaiTrinhTiepTheo0 = TrangThaiGiaiTrinhLocalServiceUtil.createTrangThaiGiaiTrinh(trangThaiTiepTheo0Pk);								
					trangThaiGiaiTrinhTiepTheo0.setYeuCauGiaiTrinhId(ycgtId);
					if(ngayCapNhat != null){
						trangThaiGiaiTrinhTiepTheo0.setNgayTao(ngayCapNhat);
					}
					trangThaiGiaiTrinhTiepTheo0.setTrangThai(ThongTinPhanHoiConstants.ActionMode.HUY_YCGT);							
					TrangThaiGiaiTrinhLocalServiceUtil.addTrangThaiGiaiTrinh(trangThaiGiaiTrinhTiepTheo0);
					
					long trangThaiTiepTheo1Pk = CounterLocalServiceUtil.increment(TrangThaiGiaiTrinh.class.getName());			
					TrangThaiGiaiTrinh trangThaiGiaiTrinhTiepTheo1 = TrangThaiGiaiTrinhLocalServiceUtil.createTrangThaiGiaiTrinh(trangThaiTiepTheo1Pk);							
					trangThaiGiaiTrinhTiepTheo1.setYeuCauGiaiTrinhId(ycgtId);
					if(ngayCapNhat != null){
						trangThaiGiaiTrinhTiepTheo1.setNgayTao(ngayCapNhat);
					}
					trangThaiGiaiTrinhTiepTheo1.setTrangThai(ThongTinPhanHoiConstants.ActionMode.DONG_YCGT);							
					TrangThaiGiaiTrinhLocalServiceUtil.addTrangThaiGiaiTrinh(trangThaiGiaiTrinhTiepTheo1);
				}				
			}
			
			YeuCauGiaiTrinhLocalServiceUtil.updateYeuCauGiaiTrinh(ycgt);
		}	
		
		PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);		
		SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}	
	
	public void findQuanHuyenByMaTinh(ActionRequest actionRequest, ActionResponse actionResponse) throws NumberFormatException, Exception {		
		String maTinh = ParamUtil.getString(actionRequest, "maTinh");		
		User user = PortalUtil.getUser(actionRequest);
		int userType = ParamUtil.getInteger(actionRequest, "userType", 0);
		boolean isSupperAdmin = actionRequest.isUserInRole("Administrator");
		
		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		JSONArray _name = JSONFactoryUtil.getJSONFactory().createJSONArray();
		JSONArray _id = JSONFactoryUtil.getJSONFactory().createJSONArray();
		
		List<DATAITEM> listQuanHuyen = new ArrayList<DATAITEM>();
		/*
		if(DauNoiNuocConstantString.UserMapping.USER_GT_VS == userType 
		   || DauNoiNuocConstantString.UserMapping.USER_GT_NUOC == userType ){
			listQuanHuyen = DATAITEMLocalServiceUtil.findHuyenChonByUser(maTinh, user.getUserId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		}else{
			listQuanHuyen = DATAITEMLocalServiceUtil.getHuyen(user, maTinh, 0l, isSupperAdmin, QueryUtil.ALL_POS, QueryUtil.ALL_POS);	
		}		
		*/
		if(DauNoiNuocConstantString.UserMapping.USER_GT_NUOC == userType || DauNoiNuocConstantString.UserMapping.USER_GT_VS == userType){//user cap huyen,xa va thap hon
			//listQuanHuyen =  UserHuyenLocalServiceUtil.findHuyenDaChonByUser(maTinh, user.getUserId(),  QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			listQuanHuyen = DATAITEMLocalServiceUtil.findHuyenChonByUser(maTinh, user.getUserId(),  QueryUtil.ALL_POS, QueryUtil.ALL_POS);	
			_log.info("--findQuanHuyenByMaTinh--userType-USER_GT_NUOC-USER_GT_VS-"+userType);
		}else if(userType == DauNoiNuocConstantString.UserMapping.USER_TINH){ // user cap tinh thi lay list ma huyen khac cua usser do quan ly
			//listQuanHuyen = UserTinhLocalServiceUtil.findHuyenQly(maTinh, user.getUserId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			listQuanHuyen = DATAITEMLocalServiceUtil.getHuyen(user, maTinh, 0l, isSupperAdmin, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			_log.info("--findQuanHuyenByMaTinh--userType-USER_TINH-"+userType);
		}else{
			//listQuanHuyen = DataItemBusiness.getInLevel2(vn.dtt.ns.thongtinphanhoi.util.WebKeys.DATAGROUPID_DONVIHANHCHINH, maTinh);
			listQuanHuyen = DATAITEMLocalServiceUtil.getByDataGroupLevel2(vn.dtt.ns.thongtinphanhoi.util.WebKeys.DATAGROUPID_DONVIHANHCHINH,maTinh);
			_log.info("--findQuanHuyenByMaTinh--userType-TW-"+userType);
		}
		
		if (listQuanHuyen == null) {
			listQuanHuyen = new ArrayList<DATAITEM>();
		}
		
		for (DATAITEM item : listQuanHuyen) {			
			_id.put(item.getNode2());
			_name.put(item.getName());			
		}
		
		jsonFeed.put("id", _id);
		jsonFeed.put("name", _name);
	
		
		HttpServletResponse resourceResponse = PortalUtil.getHttpServletResponse(actionResponse);		
		resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
		resourceResponse.setCharacterEncoding("UTF-8");
		ServletResponseUtil.write(resourceResponse, jsonFeed.toString());
		
		PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);			
		SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}
	
	public void findXaPhuongByTinhHuyen(ActionRequest actionRequest, ActionResponse actionResponse) throws NumberFormatException, Exception {		
		String maTinh = ParamUtil.getString(actionRequest, "maTinh");
		String maHuyen = ParamUtil.getString(actionRequest, "maHuyen");
		int userType = ParamUtil.getInteger(actionRequest, "userType", 0);
		
		User user = PortalUtil.getUser(actionRequest);
	    boolean isSupperAdmin = actionRequest.isUserInRole("Administrator");
		
		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		JSONArray _name = JSONFactoryUtil.getJSONFactory().createJSONArray();
		JSONArray _id = JSONFactoryUtil.getJSONFactory().createJSONArray();
	
		List<DATAITEM> listXaPhuong = new ArrayList<DATAITEM>();
		/*
		if(DauNoiNuocConstantString.UserMapping.USER_GT_VS == userType 
		   || DauNoiNuocConstantString.UserMapping.USER_GT_NUOC == userType ){
			listXaPhuong = DATAITEMLocalServiceUtil.findXaTrongHuyenChonByUser(maTinh, maHuyen, user.getUserId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		}else{
			listXaPhuong = DATAITEMLocalServiceUtil.getXa(user, maTinh, maHuyen, 0l, isSupperAdmin, QueryUtil.ALL_POS, QueryUtil.ALL_POS);		
		}
		*/
		if(DauNoiNuocConstantString.UserMapping.USER_GT_NUOC == userType || DauNoiNuocConstantString.UserMapping.USER_GT_VS == userType){//user cap huyen,xa va thap hon
			//listXaPhuong = UserHuyenLocalServiceUtil.findXaThuocHuyenChonByUser(maTinh, maHuyen,user.getUserId(),  QueryUtil.ALL_POS, QueryUtil.ALL_POS);// list ra ma xa ma no quan ly
			listXaPhuong = DATAITEMLocalServiceUtil.findXaTrongHuyenChonByUser(maTinh, maHuyen,user.getUserId(),  QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			_log.info("--findXaPhuongByTinhHuyen--userType-USER_GT_NUOC-USER_GT_VS-"+userType);
		}else{
			//listXaPhuong = DataItemBusiness.getInLevel3(vn.dtt.ns.thongtinphanhoi.util.WebKeys.DATAGROUPID_DONVIHANHCHINH, maTinh, maHuyen);
			listXaPhuong = DATAITEMLocalServiceUtil.getByDataGroupLevel3(vn.dtt.ns.thongtinphanhoi.util.WebKeys.DATAGROUPID_DONVIHANHCHINH,maTinh, maHuyen);
			_log.info("--findXaPhuongByTinhHuyen--userType-TW-"+userType);
		}
		
		if (listXaPhuong == null) {
			listXaPhuong = new ArrayList<DATAITEM>();
		}
		
		for (DATAITEM item : listXaPhuong) {			
			_id.put(item.getNode3());
			_name.put(item.getName());			
		}
		
		jsonFeed.put("id", _id);
		jsonFeed.put("name", _name);
	
		
		HttpServletResponse resourceResponse = PortalUtil.getHttpServletResponse(actionResponse);		
		resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
		resourceResponse.setCharacterEncoding("UTF-8");
		ServletResponseUtil.write(resourceResponse, jsonFeed.toString());
		
		PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);			
		SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}
	
	public boolean chuyenSangTrangMinhBach(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException{
		boolean result = false;
		try {
			long ycgtId = ParamUtil.getLong(actionRequest, "ycgtId", 0);
			String title = ParamUtil.getString(actionRequest, "title", "");
			String content = ParamUtil.getString(actionRequest, "content", "");
			
			Date ngayCapNhat = FormatData.getCurrentDateTime();
			
			ModelAddUpdateArticle isSuccess = TestLiferayJSON.addArticle(title, content);
			
			if(Validator.isNotNull(isSuccess)){
				YeuCauGiaiTrinh ycgt = YeuCauGiaiTrinhLocalServiceUtil.getYeuCauGiaiTrinh(ycgtId);
				ycgt.setNgayCapNhat(ngayCapNhat);
				ycgt.setDaChuyenSangMinhBach(ThongTinPhanHoiConstants.Transfer2MinhBach.DA_CHUYENSAN_MINHBACH);
			
				YeuCauGiaiTrinhLocalServiceUtil.updateYeuCauGiaiTrinh(ycgt);
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return result;
	}
	
	
	public void sendEmail(ActionRequest request,YeuCauGiaiTrinh ycgt ) throws Exception{

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

		if (!themeDisplay.isSignedIn()) {return;}

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    	List<UserHuyen> lstUserHuyen = UserHuyenLocalServiceUtil.getUserHuyenByTinhHuyenXa(ycgt.getMaTinh(), ycgt.getMaHuyen(), ycgt.getMaXa());
    	InternetAddress[] receiver = getReceiverList(lstUserHuyen);
    	
    	
    	DATAITEM topic = DATAITEMLocalServiceUtil.getDataItem(9, 1, ycgt.getMaChuDe());
    	
    	
    	//InternetAddress to = new InternetAddress(emailTo);
    	
    	String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),	PropsKeys.ADMIN_EMAIL_FROM_NAME);
		String fromAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
		
  //  	String fromName = "Vu Quang Hung";
//		String fromAddress = "hungvq@yahoo.com";
		
		
		InternetAddress from = new InternetAddress(fromAddress, fromName);
		ClassLoader classLoader = getClass().getClassLoader();
		
		String subject=StringUtil.read(classLoader,"vn/dtt/mail/tmp/yeu_cau_gt_subject.tmpl");
		String body   =StringUtil.read(classLoader,"vn/dtt/mail/tmp/yeu_cau_gt_body.tmpl");
		subject = StringUtil.replace(
					subject,
					new String[] {
						"[$SUBJECT_NAME$]"
					},
					new String[] {
							topic.getName()
					});

				body = StringUtil.replace(
					body,
					new String[] {
						"[$SUBJECT_NAME$]", "[$DATE$]", "[MA_YCGT]"
						
					},
					new String[] {
							topic.getName(), ycgt.getNgayTao() != null ? sdf.format(ycgt.getNgayTao()) : StringPool.BLANK, ycgt.getMaYeuCauGiaiTrinh()
					});
		
			

    	
    	if(body!=null &&!body.equals("")){
	    	
    		
    		
			System.out.println(" from: "+from);
			//System.out.println(" to: "+to + " "+user);
			System.out.println(" subject: "+subject);
			System.out.println(" body: \n"+body);
			System.out.println("----------------------\n\n");
	    		
			try{
				 if (receiver.length != 0)
		            {
						MailMessage mailMessage = new MailMessage();
						mailMessage.setFrom(from);
						mailMessage.setTo(receiver);
						mailMessage.setSubject(subject);
						mailMessage.setBody(body);
						mailMessage.setHTMLFormat(true);
						MailServiceUtil.sendEmail(mailMessage);
		               
		            }
			}
			catch(Exception ex)
			{
				if(_log.isDebugEnabled())ex.printStackTrace();
			}		
    	}else{
    		if(_log.isDebugEnabled())_log.debug(" ERROR: Can not send email.");
    	}
		
	
	}
	 private InternetAddress[] getReceiverList(List<UserHuyen> lstUserHuyen) throws PortalException, SystemException, AddressException 
	    {
	        ArrayList<InternetAddress> toList = new ArrayList<InternetAddress>();
	      	for(UserHuyen usrHuyen : lstUserHuyen){
	    		UserMapping um = UserMappingLocalServiceUtil.getByUserId(usrHuyen.getUserId());
	    		if(um != null){
	    			int userType = um.getUserType();
	    			if(DauNoiNuocConstantString.UserMapping.USER_GT_NUOC == userType || DauNoiNuocConstantString.UserMapping.USER_GT_VS == userType){
	    				User users = UserLocalServiceUtil.getUser(um.getUserId());
	    				toList.add(new InternetAddress(users.getEmailAddress()));
	    				
	     			}
	    		}
	    	}

	        return (InternetAddress[]) toList.toArray(new InternetAddress[toList.size()]);
	    }	
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		ReportBusinessUtils.inBaoCaoDLI(resourceRequest, resourceResponse);
		
	}
}
