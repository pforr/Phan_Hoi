package vn.dtt.ns.thongtinphanhoi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletResponse;

import vn.dtt.cmon.dm.dao.model.DATAITEM;
import vn.dtt.cmon.dm.dao.service.DATAITEMLocalServiceUtil;
import vn.dtt.cmon.user.dao.model.UserHuyen;
import vn.dtt.cmon.user.dao.model.UserMapping;
import vn.dtt.cmon.user.dao.service.UserHuyenLocalServiceUtil;
import vn.dtt.cmon.user.dao.service.UserMappingLocalServiceUtil;
import vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi;
import vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails;
import vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiLocalServiceUtil;
import vn.dtt.ns.thongtinphanhoi.util.DateTimeUtil;
import vn.dtt.ns.thongtinphanhoi.util.DauNoiNuocConstantString;
import vn.dtt.ns.thongtinphanhoi.util.DiaBanQuanLyUtils;
import vn.dtt.ns.thongtinphanhoi.util.ThongTinPhanHoiConstants;
import vn.dtt.ns.ulti.format.FormatData;
import vn.dtt.ns.yeucaugiaitrinh.business.YeuCauGiaiTrinhBusiness;
import vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh;
import vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh;
import vn.dtt.ns.yeucaugiaitrinh.dao.service.TrangThaiGiaiTrinhLocalServiceUtil;
import vn.dtt.ns.yeucaugiaitrinh.dao.service.YeuCauGiaiTrinhLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ThongTinPhanHoiAction
 */
public class ThongTinPhanHoiAction extends MVCPortlet {
	private static Log _log = LogFactoryUtil.getLog(ThongTinPhanHoiAction.class);

	public void search(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String maTinh = ParamUtil.getString(actionRequest, "selectMaTinh");
		String maHuyen = ParamUtil.getString(actionRequest, "selectMaHuyen");
		String maXa = ParamUtil.getString(actionRequest, "selectMaXa");
		String maChuDe = ParamUtil.getString(actionRequest, "selectMaChuDe");
		int soLuotPhanHoi = ParamUtil.getInteger(actionRequest, "soLuotPhanHoi", 0);
		String strFromDate = ParamUtil.getString(actionRequest, "fromDate");
		String strToDate = ParamUtil.getString(actionRequest, "toDate");
		
		setSearchParameter(actionRequest, actionResponse);
		
		actionResponse.setRenderParameter("maTinh", maTinh);
		actionResponse.setRenderParameter("maHuyen", maHuyen);
		actionResponse.setRenderParameter("maXa", maXa);
		actionResponse.setRenderParameter("maChuDe", maChuDe);
		actionResponse.setRenderParameter("soLuotPhanHoi", String.valueOf(soLuotPhanHoi));
		actionResponse.setRenderParameter("fromDate", strFromDate);
		actionResponse.setRenderParameter("toDate", strToDate);
		
		PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);		
		SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}
	
	public void searchPhanHoi(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String maTinh = ParamUtil.getString(actionRequest, "maTinh");
		String maHuyen = ParamUtil.getString(actionRequest, "maHuyen");
		String maXa = ParamUtil.getString(actionRequest, "maXa");
		String topicCode = ParamUtil.getString(actionRequest, "topicCode");
		int soLuotPhanHoi = ParamUtil.getInteger(actionRequest, "soLuotPhanHoi", 0);
		String feedbackCode = ParamUtil.getString(actionRequest, "selectFeedback");
		String strFromDate = ParamUtil.getString(actionRequest, "fromDate");
		String strToDate = ParamUtil.getString(actionRequest, "toDate");
		int soPhanHoiDaTaoYcgt = ParamUtil.getInteger(actionRequest, "soPhanHoiDaTaoYcgt", 0);
		int soPhanHoiChuaTaoYcgt = ParamUtil.getInteger(actionRequest, "soPhanHoiChuaTaoYcgt", 0);
		String topicName = ParamUtil.getString(actionRequest, "topicName", "");
		
		setSearchParameter(actionRequest, actionResponse);
		
		actionResponse.setRenderParameter("maTinh", maTinh);
		actionResponse.setRenderParameter("maHuyen", maHuyen);
		actionResponse.setRenderParameter("maXa", maXa);
		actionResponse.setRenderParameter("topicCode", topicCode);
		actionResponse.setRenderParameter("topicName", topicName);
		actionResponse.setRenderParameter("soLuotPhanHoi", String.valueOf(soLuotPhanHoi));
		actionResponse.setRenderParameter("feedbackCode", feedbackCode);
		actionResponse.setRenderParameter("fromDate", strFromDate);
		actionResponse.setRenderParameter("soPhanHoiChuaTaoYcgt", String.valueOf(soPhanHoiChuaTaoYcgt));
		actionResponse.setRenderParameter("soPhanHoiDaTaoYcgt", String.valueOf(soPhanHoiDaTaoYcgt));
		actionResponse.setRenderParameter("toDate", strToDate);
		actionResponse.setRenderParameter("jspPage", "/html/backend/phanhoi/chitiet_chude.jsp");
		
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
		if(DauNoiNuocConstantString.UserMapping.USER_GT_VS == userType 
		   || DauNoiNuocConstantString.UserMapping.USER_GT_NUOC == userType ){
			listQuanHuyen = DATAITEMLocalServiceUtil.findHuyenChonByUser(maTinh, user.getUserId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		}else{
			listQuanHuyen = DiaBanQuanLyUtils.getHuyen(user, maTinh, 0l, isSupperAdmin, QueryUtil.ALL_POS, QueryUtil.ALL_POS);	
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
		if(DauNoiNuocConstantString.UserMapping.USER_GT_VS == userType 
		   || DauNoiNuocConstantString.UserMapping.USER_GT_NUOC == userType ){
			listXaPhuong = DATAITEMLocalServiceUtil.findXaTrongHuyenChonByUser(maTinh, maHuyen, user.getUserId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		}else{
			listXaPhuong = DiaBanQuanLyUtils.getXa(user, maTinh, maHuyen, 0l, isSupperAdmin, QueryUtil.ALL_POS, QueryUtil.ALL_POS);		
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
	
	
	public void addYeuCauGiaiTrinh(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		int actionMode = ParamUtil.getInteger(actionRequest, "actionMode", 0);
		String ghiChuNguoiLap = ParamUtil.getString(actionRequest, "ghiChuNguoiLap", ""); 		
		String maTinh = ParamUtil.getString(actionRequest, "maTinh", "");
		String maHuyen = ParamUtil.getString(actionRequest, "maHuyen", "");
		String maXa = ParamUtil.getString(actionRequest, "maXa", "");
		String maChuDe = ParamUtil.getString(actionRequest, "maChuDe", "");		
		int soLuongTheoChuDe = ParamUtil.getInteger(actionRequest, "soLuongTheoChuDe", 0);
		long userId = ParamUtil.getLong(actionRequest, "userId", 0);
		String strFromDate = ParamUtil.getString(actionRequest, "fromDate");
		String strToDate = ParamUtil.getString(actionRequest, "toDate");
		Date fromDate = StringPool.BLANK.equals(strFromDate)? null: sdf.parse(strFromDate);
		Date toDate  = StringPool.BLANK.equals(strToDate)? null: sdf.parse(strToDate);
		Date ngayTao = new Date();
		Date ngayCapNhat = ngayTao;
			
		
		List<TopicDetails> lstTopicDetails = ChiTietThongTinPhanHoiLocalServiceUtil.getTopicDetailsByTrangThaiYcgt(ThongTinPhanHoiConstants.TrangThaiYcgt.CHUA_TAO_YCGT, maChuDe, "", maTinh, maHuyen, maXa, fromDate, toDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		try {
			if(lstTopicDetails != null && lstTopicDetails.size() > 0){
			//add ws_yeucau_giaitrinh
				long ycgtPk = CounterLocalServiceUtil.increment(YeuCauGiaiTrinh.class.getName());
				
				String maYeuCauGiaiTrinh = generateMaYeuCauGiaiTrinh(maTinh, ngayTao);
				
				YeuCauGiaiTrinh ycgt = YeuCauGiaiTrinhLocalServiceUtil.createYeuCauGiaiTrinh(ycgtPk);
				
				ycgt.setMaTinh(maTinh);
				ycgt.setMaHuyen(maHuyen);
				ycgt.setMaXa(maXa);
				ycgt.setTrangThai(ThongTinPhanHoiConstants.TrangThaiGiaiTrinh.DA_TAO_YCGT);
				ycgt.setMaChuDe(maChuDe);
				ycgt.setSoLuongTheoChuDe(soLuongTheoChuDe);
				ycgt.setUserId(userId);
				ycgt.setNgayTao(ngayTao);
				ycgt.setNgayCapNhat(ngayCapNhat);
				ycgt.setMaYeuCauGiaiTrinh(maYeuCauGiaiTrinh);
				
				
				YeuCauGiaiTrinhLocalServiceUtil.addYeuCauGiaiTrinh(ycgt);
				
				//add ws_trangthai_giaitrinh
				long ttgtPk = CounterLocalServiceUtil.increment(TrangThaiGiaiTrinh.class.getName());
				TrangThaiGiaiTrinh ttgt = TrangThaiGiaiTrinhLocalServiceUtil.createTrangThaiGiaiTrinh(ttgtPk);
				
				ttgt.setYeuCauGiaiTrinhId(ycgtPk);
				ttgt.setTrangThai(actionMode);
				ttgt.setGhiChuNguoiLap(ghiChuNguoiLap);
				ttgt.setUserId(userId);
				ttgt.setNgayTao(ngayTao);
				ttgt.setNgayCapNhat(ngayTao);
				
				TrangThaiGiaiTrinhLocalServiceUtil.addTrangThaiGiaiTrinh(ttgt);
				
				//add record for next status			
				long nextTtgt21Pk = CounterLocalServiceUtil.increment(TrangThaiGiaiTrinh.class.getName());
				TrangThaiGiaiTrinh nextTtgt21 = TrangThaiGiaiTrinhLocalServiceUtil.createTrangThaiGiaiTrinh(nextTtgt21Pk);
				
				nextTtgt21.setYeuCauGiaiTrinhId(ycgtPk);
				nextTtgt21.setNgayTao(ttgt.getNgayCapNhat());				
				nextTtgt21.setTrangThai(ThongTinPhanHoiConstants.ActionMode.GUI_DUYET);
				
				TrangThaiGiaiTrinhLocalServiceUtil.addTrangThaiGiaiTrinh(nextTtgt21);
				
				long nextTtgt0Pk = CounterLocalServiceUtil.increment(TrangThaiGiaiTrinh.class.getName());
				TrangThaiGiaiTrinh nextTtgt0 = TrangThaiGiaiTrinhLocalServiceUtil.createTrangThaiGiaiTrinh(nextTtgt0Pk);
				
				nextTtgt0.setYeuCauGiaiTrinhId(ycgtPk);
				nextTtgt0.setNgayTao(ttgt.getNgayCapNhat());				
				nextTtgt0.setTrangThai(ThongTinPhanHoiConstants.ActionMode.HUY_YCGT);
				
				TrangThaiGiaiTrinhLocalServiceUtil.addTrangThaiGiaiTrinh(nextTtgt0);
							
				for (TopicDetails topicDetails : lstTopicDetails) {
					//update trang thai lap ycgt cho table ws_chitiet_thongtin_phanhoi										
					ChiTietThongTinPhanHoi ctPhanHoi = ChiTietThongTinPhanHoiLocalServiceUtil.getChiTietThongTinPhanHoi(topicDetails.getId());
					ctPhanHoi.setYeuCauGiaiTrinhId(ycgtPk);
					ChiTietThongTinPhanHoiLocalServiceUtil.updateChiTietThongTinPhanHoi(ctPhanHoi);												
				}
			}
			
			PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);			
			SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
	private String generateMaYeuCauGiaiTrinh(String maTinh, Date ngayTao){ // se tao ra mang dang 01_1606_000001  01 la ma tnh, 1606 la nam 2016, thang 6, 000001 la lan dang dau tien cua thang 6 tinh 01
		StringBuilder out = new StringBuilder("");
		
		String namThang = FormatData.getYYMM(ngayTao); 
		String ma = "";
		
		Date fromDate = DateTimeUtil.getNgayDauThang(ngayTao);
		Date toDate = DateTimeUtil.getNgayCuoiThang(ngayTao);
		
		long soYeuCauGtCuaThang = YeuCauGiaiTrinhBusiness.countYeuCauGiaiTrinh(maTinh, null, null, 0, null, 0, fromDate, toDate);
		soYeuCauGtCuaThang = soYeuCauGtCuaThang + 1; // tang them 1
		
		ma = buildMa(soYeuCauGtCuaThang, 6);
		
		out.append(maTinh).append("_").append(namThang).append("_").append(ma);
		_log.info("generateMaYeuCauGiaiTrinh==="+out.toString());
		return out.toString();
	}
	private  String buildMa(long number, int width) {
		long wrapAt = (long)Math.pow(10, width);
		return String.valueOf(number % wrapAt + wrapAt).substring(1);
	}
}
