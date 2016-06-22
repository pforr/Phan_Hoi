<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="vn.dtt.ns.reporting.ReportConstant"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.DauNoiNuocConstantString"%>
<%@page import="vn.dtt.cmon.user.dao.service.UserMappingLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.user.dao.model.UserMapping"%>
<%@page import="vn.dtt.cmon.user.dao.service.UserHuyenLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.user.dao.model.UserHuyen"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="vn.dtt.ns.quanlynguoidung.permission.UserYcgtPermission"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="vn.dtt.ns.yeucaugiaitrinh.dao.model.ChiTietYeuCauGiaiTrinh"%>
<%@page import="java.util.Date"%>
<%@page import="vn.dtt.ns.yeucaugiaitrinh.dao.service.ChiTietYeuCauGiaiTrinhLocalServiceUtil"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.ThongTinPhanHoiConstants"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.DateTimeUtil"%>
<%@page import="vn.dtt.ns.yeucaugiaitrinh.dao.service.TrangThaiGiaiTrinhLocalServiceUtil"%>
<%@page import="vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh"%>
<%@page import="vn.dtt.cmon.dm.dao.service.DATAITEMLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiLocalServiceUtil"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails"%>
<%@page import="vn.dtt.ns.yeucaugiaitrinh.dao.service.YeuCauGiaiTrinhLocalServiceUtil"%>
<%@page import="vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.ActionKeys"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/html/init.jsp" %>
<style type="text/css">
	#popupQuaTrinhXuLy{ 
		display: none;	
		width:70%;					
		background: #eeeeee;
		color: #000000;
		border: 1px solid #1a1a1a;
		font-size: 90%;
	 }
	 
	 .close_div{
	 	float: right;
	 	padding: 1%;
	 	font-weight: bold;	 	
	 }	 
</style>
<%
final Log _logchitiet_yeucau_giaitrinh = LogFactoryUtil.getLog("html.backend.yeucau_giaitrinh.chitiet_yeucau_giaitrinh.jsp");
if(themeDisplay.isSignedIn()){
	int cur =  Integer.valueOf(preferences.getValue("curYC", "1"));
	int delta =  Integer.valueOf(preferences.getValue("deltaYC", "10"));
	int curnext = ParamUtil.getInteger(renderRequest, "cur", 1);
	int deltanext = ParamUtil.getInteger(renderRequest, "delta", 10);
	
	if(curnext != cur) {
		cur = curnext;
	}
	if(deltanext != delta) {
		delta = deltanext;
	}	
		
	String backURL = ParamUtil.getString(request, "backURL");
	long ycgtId = ParamUtil.getLong(request, "ycgtId", 0);
	String topicName = ParamUtil.getString(request, "topicName", "");		
	String topicCode = ParamUtil.getString(request, "topicCode", "");
	String maTinh = ParamUtil.getString(request, "maTinh", "");
	String maHuyen = ParamUtil.getString(request, "maHuyen", "");
	String maXa = ParamUtil.getString(request, "maXa", "");
	String strFromDate = ParamUtil.getString(request, "fromDate", "");
	String strToDate = ParamUtil.getString(request, "toDate", "");
	Date fromDate = StringPool.BLANK.equals(strFromDate)? null: sdf.parse(strFromDate);
	Date toDate  = StringPool.BLANK.equals(strToDate)? null: sdf.parse(strToDate);
	
	
	YeuCauGiaiTrinh ycgt = YeuCauGiaiTrinhLocalServiceUtil.getYeuCauGiaiTrinh(ycgtId);
	Integer daChuyenSangMb = ycgt.getDaChuyenSangMinhBach();
	boolean isTransfer2Mb = (daChuyenSangMb != null && daChuyenSangMb == 1);
	
	TrangThaiGiaiTrinh trangThaiYcgt = TrangThaiGiaiTrinhLocalServiceUtil.getTrangThaiGiaiTrinhByYcgtId(ycgtId);
	Integer trangThai = trangThaiYcgt.getTrangThai();	
	String strTrangThai = trangThai == ThongTinPhanHoiConstants.ActionMode.LUU ? LanguageUtil.get(pageContext, "vn.dtt.yeucaugiaitrinh.backend.label.trangthaigiaitrinh.dataoycgt") :
						 (trangThai == ThongTinPhanHoiConstants.ActionMode.DONG_YCGT ? LanguageUtil.get(pageContext, "vn.dtt.yeucaugiaitrinh.backend.label.trangthaigiaitrinh.daduocgiaitrinh") :
						 (trangThai == ThongTinPhanHoiConstants.ActionMode.HUY_YCGT ? LanguageUtil.get(pageContext, "vn.dtt.yeucaugiaitrinh.backend.label.trangthaigiaitrinh.huy") :
						 (trangThai == ThongTinPhanHoiConstants.ActionMode.GUI_DUYET || trangThai == ThongTinPhanHoiConstants.ActionMode.GUI_GT
						  || trangThai == ThongTinPhanHoiConstants.ActionMode.YEUCAU_GIAITRINHLAI || trangThai == ThongTinPhanHoiConstants.ActionMode.USER_TINH_GT? LanguageUtil.get(pageContext, "vn.dtt.yeucaugiaitrinh.backend.label.trangthaigiaitrinh.dangxuly") : StringPool.BLANK)));	
	
	DATAITEM itemTinh = DATAITEMLocalServiceUtil.getDataItem(1, 1, ycgt.getMaTinh());
	DATAITEM itemHuyen = DATAITEMLocalServiceUtil.getDataItem(1, 2, ycgt.getMaHuyen());
	DATAITEM itemXa = DATAITEMLocalServiceUtil.getDataItem(1, 3, ycgt.getMaXa());
			
	PortletURL pagingURL = renderResponse.createRenderURL();
	pagingURL.setParameter("jspPage", "/html/backend/yeucau_giaitrinh/chitiet_yeucau_giaitrinh.jsp");
	pagingURL.setParameter("ycgtId", String.valueOf(ycgtId));
	pagingURL.setParameter("delta", String.valueOf(delta));
	pagingURL.setParameter("backURL", backURL.toString());

	SearchContainer searchContainer = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM,
			cur, delta, pagingURL, null, null);
	
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();
	
	Long total = 0L;
	List<TopicDetails> lstTopicDetails = new ArrayList<TopicDetails>();
	total = ChiTietThongTinPhanHoiLocalServiceUtil.countTopicDetailsByYcgtId(ycgtId);
	if(total > 0){
		lstTopicDetails = ChiTietThongTinPhanHoiLocalServiceUtil.getTopicDetailsByYcgtId(ycgtId, start, end);		
	}
	
	searchContainer.setTotal(total.intValue());
	searchContainer.setResults(lstTopicDetails);
	
	PortletURL updateYcgtUrl = renderResponse.createActionURL();
	updateYcgtUrl.setParameter(ActionRequest.ACTION_NAME, "updateYeuCauGiaiTrinh");
	
	List<TrangThaiGiaiTrinh> lstTrangThaiGiaiTrinh = TrangThaiGiaiTrinhLocalServiceUtil.getTrangThaiGiaiTrinhByQuaTrinhXuLy(ycgtId);	
	
	boolean hasUserGt = false;	
	List<UserHuyen> lstUserHuyen = UserHuyenLocalServiceUtil.getUserHuyenByTinhHuyenXa( ycgt.getMaTinh(), ycgt.getMaHuyen(), ycgt.getMaXa());
	for(UserHuyen usrHuyen : lstUserHuyen){
		UserMapping um = UserMappingLocalServiceUtil.getByUserId(usrHuyen.getUserId());
		if(um != null){
			int userType = um.getUserType();
			if(DauNoiNuocConstantString.UserMapping.USER_GT_NUOC == userType || DauNoiNuocConstantString.UserMapping.USER_GT_VS == userType){
				hasUserGt = true;
				break;
			}
		}
	}	
	
	//String transfer to MinhBach
	StringBuilder strTitleTransferToMB = new StringBuilder("");
	strTitleTransferToMB.append(LanguageUtil.get(pageContext, "vn.dtt.yeucaugiaitrinh.backend.transfer2mb.label.giaitrinh")).append(" ").append(topicName);
	strTitleTransferToMB.append(" ").append(LanguageUtil.get(pageContext, "vn.dtt.yeucaugiaitrinh.backend.transfer2mb.label.tai")).append(" ").append(itemXa != null ? itemXa.getName():StringPool.BLANK);
	StringBuilder strTransferToMB = new StringBuilder("");
	strTransferToMB.append("<h4  style=\"text-align:center;\">").append(LanguageUtil.get(pageContext, "vn.dtt.yeucaugiaitrinh.backend.transfer2mb.label.giaitrinh")).append(" ").append(topicName);
	strTransferToMB.append(" ").append(LanguageUtil.get(pageContext, "vn.dtt.yeucaugiaitrinh.backend.transfer2mb.label.tai")).append(" ").append(itemXa != null ? itemXa.getName():StringPool.BLANK).append("</h4>");
	strTransferToMB.append("<div style=\"padding: 5px 0px 5px 0px;\"><table style=\"width:100%; text-align:center;\">");
	strTransferToMB.append("<tr>");
	strTransferToMB.append("<td style=\"width:30%; text-align:left;padding: 5px 0px 5px 0px;\">").append(LanguageUtil.get(pageContext, "vn.dtt.yeucaugiaitrinh.backend.label.tinhthanhpho")).append(": ").append(itemTinh != null ? itemTinh.getName():StringPool.BLANK).append("</td>");
	strTransferToMB.append("<td style=\"width:30%; text-align:left;padding: 5px 0px 5px 0px;\">").append(LanguageUtil.get(pageContext, "vn.dtt.yeucaugiaitrinh.backend.label.quanhuyen")).append(": ").append(itemHuyen != null ? itemHuyen.getName():StringPool.BLANK).append("</td>");
	strTransferToMB.append("<td style=\"width:30%; text-align:left;padding: 5px 0px 5px 0px;\">").append(LanguageUtil.get(pageContext, "vn.dtt.yeucaugiaitrinh.backend.label.xaphuong")).append(": ").append(itemXa != null ? itemXa.getName():StringPool.BLANK).append("</td>");
	strTransferToMB.append("</tr>");
	strTransferToMB.append("<tr>");
	strTransferToMB.append("<td style=\"text-align:left;padding: 5px 0px 5px 0px;\"  colspan=\"3\" >").append(LanguageUtil.get(pageContext, "vn.dtt.yeucaugiaitrinh.backend.label.chude")).append(": ").append(topicName).append("</td>");
	strTransferToMB.append("</tr>");
	strTransferToMB.append("<tr>");
	strTransferToMB.append("<td style=\"width:30%; text-align:left;padding: 5px 0px 5px 0px;\">").append("</td>");
	strTransferToMB.append("<td style=\"width:30%; text-align:left;padding: 5px 0px 5px 0px;\">").append(LanguageUtil.get(pageContext, "vn.dtt.yeucaugiaitrinh.backend.label.ngaytao")).append(": ").append(ycgt.getNgayTao() != null ? sdf.format(ycgt.getNgayTao()) : StringPool.BLANK).append("</td>");
	strTransferToMB.append("<td style=\"width:30%; text-align:left;padding: 5px 0px 5px 0px;\">").append(LanguageUtil.get(pageContext, "vn.dtt.yeucaugiaitrinh.backend.label.sophananh")).append(": ").append(ycgt.getSoLuongTheoChuDe()).append("</td>");
	strTransferToMB.append("</tr>");
	strTransferToMB.append("</table></div>");
	
	strTransferToMB.append("<div style=\"padding: 5px 0px 5px 0px;\"><table  style=\"width:100%; text-align:center;border-collapse: collapse;border: 1px solid black;\">");
	strTransferToMB.append("<thead><tr>");
	strTransferToMB.append("<th style=\"border: 1px solid black;padding: 5px;\">").append(LanguageUtil.get(pageContext, "vn.dtt.yeucaugiaitrinh.backend.label.stt")).append("</th>");
	strTransferToMB.append("<th style=\"border: 1px solid black;padding: 5px;\">").append(LanguageUtil.get(pageContext, "vn.dtt.yeucaugiaitrinh.backend.label.thongtinphananh")).append("</th>");
	strTransferToMB.append("<th style=\"border: 1px solid black;padding: 5px;\">").append(LanguageUtil.get(pageContext, "vn.dtt.yeucaugiaitrinh.backend.label.giaitrinh")).append("</th>");
	strTransferToMB.append("</thead></tr>");	
	
	String strHeader = LanguageUtil.get(pageContext, "vn.dtt.yeucaugiaitrinh.backend.label.chitietycgt");
%>
<div>
	<liferay-ui:header backURL="<%= backURL.toString() %>" title="<%=strHeader %>"/>
	<div style="text-align: center;">					
		<h5>
			<liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.trangthai" />: <%= strTrangThai%>
		</h5>
	</div>
<aui:form name="frmUpdateYcgt" method="post" action="<%=updateYcgtUrl.toString()%>">
	<aui:input type="hidden" name="ycgtId" value="<%= ycgtId%>"/>
	<aui:input type="hidden" name="nguoiPheDuyet" value="<%=themeDisplay.getUserId() %>"/>
	<aui:input type="hidden" name="actionMode" value=""/>
	<aui:input type="hidden" name="hasUserGt" value="<%=hasUserGt%>"/>
	<aui:input type="hidden" name="trangThai" value="<%=trangThai %>"/>	
<aui:input type="hidden" name="ghiChuNguoiTao" value="<%=trangThaiYcgt.getGhiChuNguoiLap() %>"/>	
	<table style="width:100%;">
		<tr>
			<td><liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.tinhthanhpho" />:</td>
			<td><%= itemTinh != null ? itemTinh.getName() : StringPool.BLANK%></td>
			<td><liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.quanhuyen" />:</td>
			<td><%= itemHuyen != null ? itemHuyen.getName() : StringPool.BLANK%></td>
			<td><liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.xaphuong" />:</td>
			<td><%= itemXa != null ? itemXa.getName() : StringPool.BLANK%></td>								
		</tr>
		<tr>
			<td><liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.chude" />:</td>
			<td><%= topicName%></td>
			<td><liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.nguoitao" />:</td>
			<td><%= user.getFullName()%></td>	
			<td><liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.ngaytao" />:</td>
			<td><%=ycgt.getNgayTao() != null ? sdf.format(ycgt.getNgayTao()) : StringPool.BLANK%></td>				
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.thoigianphanhoi" />:
				<liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.tungay" />:<%= strFromDate%>
			</td>
			
			<td><liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.denngay" />:<%= strToDate%></td>
			
			<td><liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.sophananh" />:</td>
			<td><%= ycgt.getSoLuongTheoChuDe()%></td>
			<td><liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.mayeucaugiaitrinh" />:</td>
			<td><%=Validator.isNotNull(ycgt.getMaYeuCauGiaiTrinh()) ? ycgt.getMaYeuCauGiaiTrinh() : StringPool.BLANK%></td>	
		</tr>		
		<tr>					   		 
			<td><liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.ghichu" />:</td>
			<td>					
				<aui:input type="textarea" name="ghiChu"  disabled="<%= ThongTinPhanHoiConstants.ActionMode.DONG_YCGT == trangThai || ThongTinPhanHoiConstants.ActionMode.HUY_YCGT == trangThai%>" label="" style="width:80%;"/>							
			</td>
	
			<c:if test="<%=trangThai == ThongTinPhanHoiConstants.ActionMode.DONG_YCGT || trangThai == ThongTinPhanHoiConstants.ActionMode.HUY_YCGT %>">
				<td><liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.ngayduyet" />:</td>
				<td>					
					<td><%=ycgt.getNgayCapNhat() != null ? sdf.format(ycgt.getNgayCapNhat()) : StringPool.BLANK%>							
				</td>
			</c:if>
			
		</tr>		
	</table>
	
	<div>
		<c:if test="<%= trangThai != null && ThongTinPhanHoiConstants.ActionMode.HUY_YCGT != trangThai && ThongTinPhanHoiConstants.ActionMode.DONG_YCGT != trangThai%>">
			<c:if test="<%=trangThai == ThongTinPhanHoiConstants.ActionMode.LUU && UserYcgtPermission.contains(permissionChecker, scopeGroupId, ActionKeys.YEUCAU_GIAITRINH)%>">					
				<aui:button name="btnYeuCauGt" value="vn.dtt.yeucaugiaitrinh.backend.button.yeucaugiaitrinh" onClick="javascript:onYeuCauGt()"/>
				<aui:button name="btnHuyYcgt" value="vn.dtt.yeucaugiaitrinh.backend.button.huy" onClick="javascript:onHuyYcgt()"/>				
			</c:if>
			<c:if test="<%=(trangThai == ThongTinPhanHoiConstants.ActionMode.GUI_DUYET || trangThai == ThongTinPhanHoiConstants.ActionMode.YEUCAU_GIAITRINHLAI) && hasUserGt && UserYcgtPermission.contains(permissionChecker, scopeGroupId, ActionKeys.GUI_GIAITRINH)%>">					
				<aui:button name="btnGui" value="vn.dtt.yeucaugiaitrinh.backend.button.send" onClick="javascript:onGuiGt()"/>
			</c:if>
			
			<c:if test="<%=trangThai == ThongTinPhanHoiConstants.ActionMode.GUI_GT%>">				
				<c:if test="<%=UserYcgtPermission.contains(permissionChecker, scopeGroupId, ActionKeys.YEUCAU_GIAITRINHLAI) %>">
					<aui:button name="btnGiaiTrinhLai" value="vn.dtt.yeucaugiaitrinh.backend.button.giaitrinhlai" onClick="javascript:onGiaiTrinhLai()"/>
				</c:if>
				<c:if test="<%=UserYcgtPermission.contains(permissionChecker, scopeGroupId, ActionKeys.DUYET) %>">
					<aui:button name="btnDuyet" value="vn.dtt.yeucaugiaitrinh.backend.button.duyet" onClick="javascript:onDuyetYcgt()"/>					
				</c:if>												
			</c:if>	
			
			<c:if test="<%=trangThai == ThongTinPhanHoiConstants.ActionMode.GUI_DUYET && !hasUserGt && UserYcgtPermission.contains(permissionChecker, scopeGroupId, ActionKeys.USER_TINH_GIAITRINH)%>">												
				<aui:button name="btnUsrTinhDuyet" value="vn.dtt.yeucaugiaitrinh.backend.button.duyet" onClick="javascript:onUserTinhDuyetYcgt()"/>									
			</c:if>					
		</c:if>	
		<c:if test="<%=trangThai == ThongTinPhanHoiConstants.ActionMode.DONG_YCGT && UserYcgtPermission.contains(permissionChecker, scopeGroupId, ActionKeys.CHUYEN_SANG_MINHBACH)%>">												
			<aui:button name="btnChuyenSangMB" value="vn.dtt.yeucaugiaitrinh.backend.button.chuyensangmb" disabled="<%=isTransfer2Mb %>" onClick="javascript:onChuyenSangMB()"/>									
		</c:if>
		<c:if test="<%=lstTrangThaiGiaiTrinh != null && (UserYcgtPermission.contains(permissionChecker, scopeGroupId, ActionKeys.DUYET) 
						|| UserYcgtPermission.contains(permissionChecker, scopeGroupId, ActionKeys.HUY)
						|| UserYcgtPermission.contains(permissionChecker, scopeGroupId, ActionKeys.YEUCAU_GIAITRINHLAI)
						|| UserYcgtPermission.contains(permissionChecker, scopeGroupId, ActionKeys.YEUCAU_GIAITRINH))%>">
			<aui:button name="btnQuaTrinhXuLy" value="vn.dtt.yeucaugiaitrinh.backend.label.quatrinhxuly" onClick="javascript:onQuaTrinhXuLy()"/>
		</c:if>
		<liferay-portlet:resourceURL var="resourceUrlExportDoc" >
			<liferay-portlet:param name="duoiFileRS" value="<%=ReportConstant.DUOI_DOC %>"/>
			<liferay-portlet:param name="typeRS" value="<%=ReportConstant.CHITIETYEUCAUGIAITRINH %>"/>
			<liferay-portlet:param name="ycgtIdRS" value="<%=String.valueOf(ycgtId) %>"/>
			<liferay-portlet:param name="maTinhRS" value="<%=maTinh %>"/>
			<liferay-portlet:param name="maHuyenRS" value="<%=maHuyen %>"/>
			<liferay-portlet:param name="maXaRS" value="<%=maXa%>"/>
			<liferay-portlet:param name="topicCodeRS" value="<%=topicCode%>"/>
			<liferay-portlet:param name="topicNameRS" value="<%=topicName%>"/>
			<liferay-portlet:param name="strFromDateRS" value="<%=strFromDate%>"/>
			<liferay-portlet:param name="strToDateRS" value="<%=strToDate%>"/>
		</liferay-portlet:resourceURL>
		<aui:button name="btnExportDoc" value="vn.dtt.yeucaugiaitrinh.backend.button.exportdoc"  href="<%= resourceUrlExportDoc.toString()%>"/>
	</div>
	
	<table class="table table-bordered table-hover table-striped" style="width:100%;">	
		<thead class="table-columns">
			<tr>
				<th  style="width:5%"><liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.stt"/></th>				
				<th  style="width:10%"><liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.mathongtinphananh"/></th>				
				<th  style="width:25%"><liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.thongtinphananh"/></th>
				<th  style="width:10%"><liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.soluongphananh"/></th>
				<th  style="width:25%"><liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.giaitrinh"/></th>
			</tr>
		</thead>
		<%
		int index = 1;
		int stt = 1;
			
		boolean giaiTrinhDisableFlag = false;	
		UserMapping usrMapping = UserMappingLocalServiceUtil.getByUserId(user.getUserId());
		int usrType = usrMapping.getUserType();
		giaiTrinhDisableFlag = (trangThai != ThongTinPhanHoiConstants.ActionMode.GUI_DUYET 
							  && trangThai != ThongTinPhanHoiConstants.ActionMode.YEUCAU_GIAITRINHLAI)
							  || (hasUserGt && !UserYcgtPermission.contains(permissionChecker, scopeGroupId, ActionKeys.GUI_GIAITRINH))
							  || (!hasUserGt && !UserYcgtPermission.contains(permissionChecker, scopeGroupId, ActionKeys.USER_TINH_GIAITRINH));
		
		for(TopicDetails topicDetails: lstTopicDetails){	
			DATAITEM dataItem = DATAITEMLocalServiceUtil.getDataItem(9, 2, topicDetails.getMaThongTinPhanAnh());							
			DATAITEM dHuyen = DATAITEMLocalServiceUtil.getDataItem(1, 2, topicDetails.getMaHuyen());
			DATAITEM dXa = DATAITEMLocalServiceUtil.getDataItem(1, 3, topicDetails.getMaXa());
			
			long soLuong = ChiTietThongTinPhanHoiLocalServiceUtil.countPhanHoiByMaThongTinPhanAnh(topicCode, topicDetails.getMaThongTinPhanAnh(), maTinh, maHuyen, maXa, fromDate, toDate);
			ChiTietYeuCauGiaiTrinh chiTietYcgt = ChiTietYeuCauGiaiTrinhLocalServiceUtil.getChiTietGiaiTrinhByYcgtIdAndMaThongTinPhanAnh(topicDetails.getYeuCauGiaiTrinhId(), topicDetails.getMaThongTinPhanAnh());
			
			strTransferToMB.append("<tr>");
			strTransferToMB.append("<td style=\"width:15%; text-align: center;border: 1px solid black;padding: 5px;\">").append(searchContainer.getStart() +  (stt++)).append("</td>");			
			strTransferToMB.append("<td style=\"width:60%; text-align: center;border: 1px solid black;padding: 5px;\">").append(dataItem != null ? dataItem.getName() : StringPool.BLANK).append("</td>");
			strTransferToMB.append("<td style=\"width:25%; text-align: center;border: 1px solid black;padding: 5px;\">").append(chiTietYcgt != null && !StringPool.BLANK.equals(chiTietYcgt.getGiaiTrinh()) ? chiTietYcgt.getGiaiTrinh() : StringPool.BLANK).append("</td>");
		%>
		<tr>
				<td  style="width:5%; text-align: center;"><%=(searchContainer.getStart() +  (index++))%></td>						
				<td  style="width:10%; text-align: center;"><%=topicDetails.getMaThongTinPhanAnh() != null ? topicDetails.getMaThongTinPhanAnh() : StringPool.BLANK %></td>								
				<td style="width:25%; text-align: center;">					
						<%=dataItem != null ? dataItem.getName() : StringPool.BLANK %>				
				</td>
				<td style="width:10%; text-align: center;"><aui:input type="hidden" name='<%="soLuong" + topicDetails.getId() %>' value="<%= soLuong%>" /> <%=soLuong%></td>		
				<td style="width:25%; text-align: center;">						
					<aui:input type="textarea" style="width:95%; height:auto;" name='<%="giaiTrinh" + topicDetails.getId()%>' disabled="<%=giaiTrinhDisableFlag %>" value="<%= chiTietYcgt != null && !StringPool.BLANK.equals(chiTietYcgt.getGiaiTrinh()) ? chiTietYcgt.getGiaiTrinh() : StringPool.BLANK%>" label=""/>			
				</td>			
			</tr>
		<%
		strTransferToMB.append("</tr>");
		}
		
		strTransferToMB.append("</table></div>");
		
		_logchitiet_yeucau_giaitrinh.info("strTransferToMB--=="+strTransferToMB.toString());
		%>
	</table>
</aui:form>
	<aui:button name="btnBack" id="btnBack" value="vn.dtt.yeucaugiaitrinh.backend.button.back" onClick="<%=backURL.toString() %>"/>
	<%
		if(searchContainer != null){
	%>		
			<div class="tongso"><div id = "pagination"><liferay-ui:search-paginator searchContainer="<%= searchContainer %>" /></div></div>
	<%				
		}
	%>
</div>

<div id="popupQuaTrinhXuLy">
	<div class="close_div"><a class="close_messagepop" href="#" title="Đóng"><liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.close" /></a></div>
	<c:if test="<%=lstTrangThaiGiaiTrinh != null%>">
		<h5 style="text-align: left; padding-left:3%;"><liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.quatrinhxuly" /></h5>
		<table class="table table-bordered table-hover table-striped" style="width:100%;">	
				<thead class="table-columns">
					<tr>
						<th  style="width:5%"><liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.stt"/></th>				
						<th  style="width:10%"><liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.trangthai"/></th>				
						<th  style="width:20%"><liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.nguoitao"/></th>
						<th  style="width:15%"><liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.ngaytao"/></th>
						<th  style="width:25%"><liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.ghichu"/></th>						
						<th  style="width:25%"><liferay-ui:message key="vn.dtt.yeucaugiaitrinh.backend.label.ngaycapnhat"/></th>
					</tr>
				</thead>
		<%
			int count = 0;
			for(TrangThaiGiaiTrinh ttgt: lstTrangThaiGiaiTrinh){
				count++;
								
				int status = ttgt.getTrangThai();				
				String strStatus = status == ThongTinPhanHoiConstants.ActionMode.LUU ? LanguageUtil.get(pageContext, "vn.dtt.yeucaugiaitrinh.backend.label.trangthaigiaitrinh.dataoycgt") :
					 (status == ThongTinPhanHoiConstants.ActionMode.DONG_YCGT ? LanguageUtil.get(pageContext, "vn.dtt.yeucaugiaitrinh.backend.label.trangthaigiaitrinh.daduocgiaitrinh") :
					 (status == ThongTinPhanHoiConstants.ActionMode.HUY_YCGT ? LanguageUtil.get(pageContext, "vn.dtt.yeucaugiaitrinh.backend.label.trangthaigiaitrinh.huy") :
					 (status == ThongTinPhanHoiConstants.ActionMode.GUI_DUYET ? LanguageUtil.get(pageContext, "vn.dtt.yeucaugiaitrinh.backend.label.trangthaigiaitrinh.guiduyet") :
					 (status == ThongTinPhanHoiConstants.ActionMode.GUI_GT || status == ThongTinPhanHoiConstants.ActionMode.USER_TINH_GT ? LanguageUtil.get(pageContext, "vn.dtt.yeucaugiaitrinh.backend.label.trangthaigiaitrinh.guigt") :
					 (status == ThongTinPhanHoiConstants.ActionMode.YEUCAU_GIAITRINHLAI ? LanguageUtil.get(pageContext, "vn.dtt.yeucaugiaitrinh.backend.label.trangthaigiaitrinh.giaitrinhlai") : StringPool.BLANK)))));
				User nguoiTao = UserLocalServiceUtil.getUser(ttgt.getUserId());
				
				String strGhiChu = "";
				if(ThongTinPhanHoiConstants.ActionMode.GUI_GT  == status 
				   || ThongTinPhanHoiConstants.ActionMode.LUU  == status 
				   || (ThongTinPhanHoiConstants.ActionMode.GUI_DUYET==  status && !hasUserGt && UserYcgtPermission.contains(permissionChecker, scopeGroupId, ActionKeys.USER_TINH_GIAITRINH))){
			   		strGhiChu = ttgt != null ? ttgt.getGhiChuNguoiLap() : StringPool.BLANK;		   
			   	}else if(ThongTinPhanHoiConstants.ActionMode.DONG_YCGT  == status
			   			 ||ThongTinPhanHoiConstants.ActionMode.HUY_YCGT  == status
			   			 || ThongTinPhanHoiConstants.ActionMode.USER_TINH_GT == status){		   		
			   		strGhiChu = ttgt != null ? ttgt.getGhiChuNguoiDuyet() : StringPool.BLANK;	
			   	} 
		%>
				<tr>
					<td style="text-align: center;"><%=count %></td>
					<td style="text-align: center;"><%=strStatus %></td>
					<td style="text-align: center;"><%=nguoiTao != null ? nguoiTao.getFullName() : StringPool.BLANK %></td>
					<td style="text-align: center;"><%=ttgt.getNgayTao() != null ? DateTimeUtil.formatDate(ttgt.getNgayTao()):StringPool.BLANK %></td>
					<td style="text-align: center;"><%=strGhiChu %></td>					
					<td style="text-align: center;"><%=ttgt.getNgayCapNhat() != null ? DateTimeUtil.formatDate(ttgt.getNgayCapNhat()) : StringPool.BLANK%></td>
				</tr>							
		<%
			}
		%>
		</table>
	</c:if>
</div>

<portlet:actionURL var="chuyenSangTrangMinhBach" name="chuyenSangTrangMinhBach"/>
<script type="text/javascript">
	function onYeuCauGt(){
		var action = <%=ThongTinPhanHoiConstants.ActionMode.GUI_DUYET%>;
		$("#<portlet:namespace />actionMode").val(action);

		submitForm(document.<portlet:namespace />frmUpdateYcgt);
	}

	function onGuiGt(){
		var action = <%=ThongTinPhanHoiConstants.ActionMode.GUI_GT%>;
		$("#<portlet:namespace />actionMode").val(action);
	
		submitForm(document.<portlet:namespace />frmUpdateYcgt);
	}

	function onHuyYcgt(){
		var action = <%=ThongTinPhanHoiConstants.ActionMode.HUY_YCGT%>;
		var msg = '<liferay-ui:message key="vn.dtt.ns.yeucaugiaitrinh.confirm.delete"/>';
		if(confirm(msg)){
			$("#<portlet:namespace />actionMode").val(action);
		
			submitForm(document.<portlet:namespace />frmUpdateYcgt);
		}
	}
	
	function onDuyetYcgt(){
		var action = <%=ThongTinPhanHoiConstants.ActionMode.DONG_YCGT%>;
		$("#<portlet:namespace />actionMode").val(action);
	
		submitForm(document.<portlet:namespace />frmUpdateYcgt);
	}

	function onUserTinhDuyetYcgt(){
		var action = <%=ThongTinPhanHoiConstants.ActionMode.USER_TINH_GT%>;
		$("#<portlet:namespace />actionMode").val(action);
	
		submitForm(document.<portlet:namespace />frmUpdateYcgt);
	}
	
	function onGiaiTrinhLai(){
		var action = <%=ThongTinPhanHoiConstants.ActionMode.YEUCAU_GIAITRINHLAI%>;
		$("#<portlet:namespace />actionMode").val(action);
	
		submitForm(document.<portlet:namespace />frmUpdateYcgt);
	}

	function onQuaTrinhXuLy(){
		$("#popupQuaTrinhXuLy").show();
	}

	var chuyenSangTrangMinhBachUrl = '<%=chuyenSangTrangMinhBach.toString()%>';	
	function onChuyenSangMB(){		
		var successMsg = '<liferay-ui:message key="vn.dtt.yeucaugiaitrinh.transfer2mb.label.successmessage" />';
		$.ajax({
			type : 'POST',				
			url : chuyenSangTrangMinhBachUrl,						
			data :{
				<portlet:namespace/>ycgtId: <%=ycgtId%>,
				<portlet:namespace/>title : '<%= strTitleTransferToMB.toString()%>',
				<portlet:namespace/>content : '<%= strTransferToMB.toString()%>'
			},
			success : function(data) {		
				alert(successMsg);						
				$("#<portlet:namespace/>btnChuyenSangMB").prop('disabled', true);
			}
		});
	}
	

	$(document).on('click','.close_messagepop',function(){	
		$(this).parent().parent().hide();
	});

	jQuery.fn.center = function ()
	{
	    this.css("position","fixed");
	    this.css("top", ($(window).height() / 2) - (this.outerHeight() / 2));
	    this.css("left", ($(window).width() / 2) - (this.outerWidth() / 2));
	    return this;
	}

	$('#popupQuaTrinhXuLy').center();
	$(window).resize(function(){
	   $('#popupQuaTrinhXuLy').center();
	});
</script>
<%
}
%>