package vn.dtt.ns.thongkephanhoi;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import vn.dtt.ns.minhbach.ModelAddUpdateArticle;
import vn.dtt.ns.minhbach.TestLiferayJSON;
import vn.dtt.ns.reporting.ReportBusinessUtils;
import vn.dtt.ns.thongtinphanhoi.business.TrangThaiThongKePhanHoiBusiness;
import vn.dtt.ns.thongtinphanhoi.dao.model.TrangThaiThongKePhanHoi;
import vn.dtt.ns.thongtinphanhoi.dao.model.impl.TrangThaiThongKePhanHoiImpl;
import vn.dtt.ns.thongtinphanhoi.dao.service.TrangThaiThongKePhanHoiLocalServiceUtil;
import vn.dtt.ns.thongtinphanhoi.util.ThongTinPhanHoiConstants;
import vn.dtt.ns.ulti.format.ConvertUtil;
import vn.dtt.ns.ulti.format.FormatData;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ThongKePhanHoiAction
 */
public class ThongKePhanHoiAction extends MVCPortlet {
	private static Log _log = LogFactoryUtil.getLog(ThongKePhanHoiAction.class);
	public void search(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String maTinh = ParamUtil.getString(actionRequest, "selectMaTinh", "");
		String strMonthAndYear = ParamUtil.getString(actionRequest, "monthAndYear", "");		
			
		actionResponse.setRenderParameter("maTinh", maTinh);
		actionResponse.setRenderParameter("monthAndYear", String.valueOf(strMonthAndYear));
		PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);		
		SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);		
	}
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		ReportBusinessUtils.inBaoCaoDLI(resourceRequest, resourceResponse);
		// TODO Auto-generated method stub
		
	}
	public boolean chuyenSangTrangMinhBach(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException{
		boolean result = false;
		try {
			String maTinh = ParamUtil.getString(actionRequest, "maTinh", ""); // lay tu view.jsp
			String thangNam = ParamUtil.getString(actionRequest, "thangNam", ""); // lay tu view.jsp
			Date ngayTao = FormatData.getCurrentDateTime();
			Date ngayCapNhat = FormatData.getCurrentDateTime();
			long nguoiChuyen = ParamUtil.getLong(actionRequest, "nguoiChuyen", 0); // lay tu view.jsp
			int articleId = -1;
			int groupId = -1;
			int userId = -1;
			String version = "";
			String title = ParamUtil.getString(actionRequest, "title", ""); // lay tu view.jsp
			String content = ParamUtil.getString(actionRequest, "content", ""); // lay tu view.jsp
			
			TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = TrangThaiThongKePhanHoiBusiness.fetchBymaTinhThangNamChuyenSangMB(maTinh, thangNam, ThongTinPhanHoiConstants.Transfer2MinhBach.DA_CHUYENSAN_MINHBACH);
			if(Validator.isNotNull(trangThaiThongKePhanHoi)){ // da chuyen sang minh bach truoc day roi, can update lai
				_log.info("--chuyenSangTrangMinhBach--update--");
				articleId = trangThaiThongKePhanHoi.getArticleId();
				groupId = trangThaiThongKePhanHoi.getGroupId();
				userId = trangThaiThongKePhanHoi.getUserId();
				version = trangThaiThongKePhanHoi.getVersion();
				
				ModelAddUpdateArticle isSuccess = TestLiferayJSON.updateArticle(String.valueOf(articleId), String.valueOf(groupId),  String.valueOf(userId), version, title, content);
				
				if(Validator.isNotNull(isSuccess)){
					_log.info("--chuyenSangTrangMinhBach--update--OK--");
					//TrangThaiThongKePhanHoi trangThaiThongKePhanHoiUpdate = TrangThaiThongKePhanHoiBusiness.fetchByarticleIdAndDaChuyenSangMinhBach(articleId, ThongTinPhanHoiConstants.Transfer2MinhBach.DA_CHUYENSAN_MINHBACH);
					
					trangThaiThongKePhanHoi.setNgayCapNhat(ngayCapNhat);
					trangThaiThongKePhanHoi.setNguoiCapNhat(String.valueOf(nguoiChuyen));
					trangThaiThongKePhanHoi.setUserId(ConvertUtil.convertToInt(isSuccess.getUserId()));
					trangThaiThongKePhanHoi.setVersion(isSuccess.getVersion());
					
					TrangThaiThongKePhanHoiLocalServiceUtil.updateTrangThaiThongKePhanHoi(trangThaiThongKePhanHoi);
					result = true;
				}
				
			}else{ // ko co trong db, tuc la chua chuyen sang minh bach, phai them moi
				_log.info("--chuyenSangTrangMinhBach--themmoi--");
				ModelAddUpdateArticle isSuccess = TestLiferayJSON.addArticle(title, content);
				
				if(Validator.isNotNull(isSuccess)){ // chuyen sang minh bach thanh cong, nhung chua co trong db nen phai them moi
					_log.info("--chuyenSangTrangMinhBach--themmoi--OK--");
					articleId = ConvertUtil.convertToInt(isSuccess.getArticleId());
					groupId = ConvertUtil.convertToInt(isSuccess.getGroupId());
					userId = ConvertUtil.convertToInt(isSuccess.getUserId());
					version = isSuccess.getVersion();
					
					TrangThaiThongKePhanHoi trangThaiThongKePhanHoiInsert = new TrangThaiThongKePhanHoiImpl();
					
					trangThaiThongKePhanHoiInsert.setMaTinh(maTinh);
					trangThaiThongKePhanHoiInsert.setThangNam(thangNam);
					trangThaiThongKePhanHoiInsert.setNgayTao(ngayTao);
					trangThaiThongKePhanHoiInsert.setNgayCapNhat(ngayCapNhat); // neu them moi thi ngay tao se la ngay cap nhat luon
					trangThaiThongKePhanHoiInsert.setNguoiChuyen(String.valueOf(nguoiChuyen));
					trangThaiThongKePhanHoiInsert.setNguoiCapNhat(String.valueOf(nguoiChuyen)); // neu them moi thi nguoi chuyen se la nguoi cap nhat luon
					trangThaiThongKePhanHoiInsert.setDaChuyenSangMinhBach(ThongTinPhanHoiConstants.Transfer2MinhBach.DA_CHUYENSAN_MINHBACH);
					trangThaiThongKePhanHoiInsert.setArticleId(articleId);
					trangThaiThongKePhanHoiInsert.setGroupId(groupId);
					trangThaiThongKePhanHoiInsert.setUserId(userId);
					trangThaiThongKePhanHoiInsert.setVersion(version);
					
					TrangThaiThongKePhanHoiLocalServiceUtil.addTrangThaiThongKePhanHoi(trangThaiThongKePhanHoiInsert);
					result = true;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return result;
	}
}
