<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="vn.dtt.ns.quanlynguoidung.permission.UserYcgtPermission"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.ActionKeys"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.business.UserMappingBusiness"%>
<%@page import="vn.dtt.cmon.user.dao.model.UserMapping"%>
<%@page import="vn.dtt.ns.yeucaugiaitrinh.dao.service.ChiTietYeuCauGiaiTrinhLocalServiceUtil"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.DateTimeUtil"%>
<%@page import="vn.dtt.cmon.dm.dao.service.DATAITEMLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>
<%@page import="java.util.Date"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.ThongTinPhanHoiConstants"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiLocalServiceUtil"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/html/init.jsp" %>

<style type="text/css">
	
</style>

<%
	
	int cur =  Integer.valueOf(preferences.getValue("curTP", "1"));
	int delta =  Integer.valueOf(preferences.getValue("deltaTP", "10"));
	int curnext = ParamUtil.getInteger(renderRequest, "cur", 1);
	int deltanext = ParamUtil.getInteger(renderRequest, "delta", 10);
	
	if(curnext != cur) {
		cur = curnext;
	}
	if(deltanext != delta) {
		delta = deltanext;
	}
		
	
	String backURL = ParamUtil.getString(request, "backURL");	
	String topicCode = ParamUtil.getString(request, "topicCode", "");
	String maTinh = ParamUtil.getString(request, "maTinh", "");
	String maHuyen = ParamUtil.getString(request, "maHuyen", "");
	String maXa = ParamUtil.getString(request, "maXa", "");
	String topicName = ParamUtil.getString(request, "topicName", "");
	int soPhanHoiChuaTaoYcgt = ParamUtil.getInteger(request, "soPhanHoiChuaTaoYcgt", 0);
	String strFromDate = ParamUtil.getString(request, "fromDate", "");
	String strToDate = ParamUtil.getString(request, "toDate", "");
	Date fromDate = StringPool.BLANK.equals(strFromDate)? null: sdf.parse(strFromDate);
	Date toDate  = StringPool.BLANK.equals(strToDate)? null: sdf.parse(strToDate);
	
	DATAITEM itemHuyen = DATAITEMLocalServiceUtil.getDataItem(1, 2, maHuyen);
	DATAITEM itemXa = DATAITEMLocalServiceUtil.getDataItem(1, 3, maXa);
	
	PortletURL pagingURL = renderResponse.createRenderURL();
	pagingURL.setParameter("jspPage", "/html/backend/phanhoi/tao_yeucau_giaitrinh.jsp");
	pagingURL.setParameter("topicCode", topicCode);
	pagingURL.setParameter("fromDate", strFromDate);
	pagingURL.setParameter("toDate", strToDate);
	pagingURL.setParameter("maTinh", maTinh);
	pagingURL.setParameter("maHuyen", maHuyen);
	pagingURL.setParameter("maXa", maXa);
	pagingURL.setParameter("soPhanHoiChuaTaoYcgt", String.valueOf(soPhanHoiChuaTaoYcgt));
	pagingURL.setParameter("topicName", topicName);
	pagingURL.setParameter("backURL", backURL);
	pagingURL.setParameter("delta", String.valueOf(delta));

	SearchContainer searchContainer = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM,
			cur, delta, pagingURL, null, null);

	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();
	
	List<TopicDetails> lstTopicDetails = new ArrayList<TopicDetails>();
	Long total = 0L;
	
	total = ChiTietThongTinPhanHoiLocalServiceUtil.countPhanHoiByTrangThaiYcgtAndGroupByFeedbackCode(ThongTinPhanHoiConstants.TrangThaiYcgt.CHUA_TAO_YCGT, topicCode, "", maTinh, maHuyen, maXa, fromDate, toDate);
	if(total > 0){
		lstTopicDetails = ChiTietThongTinPhanHoiLocalServiceUtil.getTopicDetailsByTrangThaiYcgtAndGroupByFeedbackCode(ThongTinPhanHoiConstants.TrangThaiYcgt.CHUA_TAO_YCGT, topicCode, "", maTinh, maHuyen, maXa, fromDate, toDate, start, end);
	}
	
	searchContainer.setTotal(total.intValue());
	searchContainer.setResults(lstTopicDetails);
	
	if(themeDisplay.isSignedIn() && UserYcgtPermission.contains(permissionChecker, scopeGroupId, ActionKeys.TAO_YCGT)){
		PortletURL addYeuCauGiaiTrinhURL = renderResponse.createActionURL();
		addYeuCauGiaiTrinhURL.setParameter(ActionRequest.ACTION_NAME, "addYeuCauGiaiTrinh");
		addYeuCauGiaiTrinhURL.setParameter("fromDate", strFromDate);
		addYeuCauGiaiTrinhURL.setParameter("toDate", strToDate);
		
		String strHeader = LanguageUtil.get(pageContext, "vn.dtt.thongtinphanhoi.backend.label.taoycgt");
%>

<liferay-ui:header backURL="<%= backURL.toString() %>" title="<%=strHeader %>"/>

<aui:form name="frmSaveYcgt" method="post" action="<%=addYeuCauGiaiTrinhURL.toString()%>">
	<aui:input type="hidden" name="maTinh" value="<%= maTinh%>"/>
	<aui:input type="hidden" name="maHuyen" value="<%= maHuyen%>"/>
	<aui:input type="hidden" name="maXa" value="<%= maXa%>"/>
	<aui:input type="hidden" name="maChuDe" value="<%= topicCode %>" />
	<aui:input type="hidden" name="soLuongTheoChuDe" value="<%= soPhanHoiChuaTaoYcgt %>" />
	<aui:input type="hidden" name="userId" value="<%=user.getUserId() %>"/>
	<aui:input type="hidden" name="actionMode" value=""/>
	
	<table style="width:100%;">
		<tr>
			<td><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.quanhuyen" /></td>
			<td><aui:input name="huyen" value="<%= itemHuyen != null ? itemHuyen.getName() : StringPool.BLANK%>" label="" disabled="true" style="width:80%;"/></td>
			<td><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.xaphuong" /></td>
			<td><aui:input name="xa" value="<%= itemXa != null ? itemXa.getName() : StringPool.BLANK%>" label="" disabled="true" style="width:80%;"/></td>			
		</tr>
		<tr>			
			<td><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.chude" /></td>
			<td><aui:input name="chude" value="<%= topicName%>" label="" disabled="true" style="width:80%;"/></td>
			<td><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.nguoitao" /></td>
			<td><aui:input name="user" value="<%= user.getFullName()%>" label="" disabled="true" style="width:80%;"/></td>			
		</tr>
		<tr>
			<td><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.soluongphananh" /></td>
			<td><aui:input name="user" value="<%= soPhanHoiChuaTaoYcgt%>" label="" disabled="true" style="width:80%;"/></td>
			<td><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.ghichu" /></td>
			<td>
				<aui:input type="textarea" name="ghiChuNguoiLap" value="" label="" style="width:80%;"/>
			</td>			
		</tr>		
	</table>
	<div>
		<c:if test="<%=UserYcgtPermission.contains(permissionChecker, scopeGroupId, ActionKeys.TAO_YCGT) %>">
			<aui:button name="btnSave" value="vn.dtt.thongtinphanhoi.backend.button.save" onClick="javascript:onSaveYcgt()"/>
		</c:if>
	</div>
</aui:form>

<div>
	<table class="table table-bordered table-hover table-striped" style="width:100%;">	
		<thead class="table-columns">
			<tr>
				<th  style="width:10%"><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.stt"/></th>								
				<th  style="width:20%"><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.mathongtinphananh"/></th>
				<th  style="width:20%"><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.soluongphananh"/></th>					
				<th  style="width:50%"><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.thongtinphananh"/></th>
			</tr>
		</thead>
		<%
		int index = 1;
		for(TopicDetails topicDetails: lstTopicDetails){	
			DATAITEM dataItem = DATAITEMLocalServiceUtil.getDataItem(9, 2, topicDetails.getMaThongTinPhanAnh());							
			DATAITEM dHuyen = DATAITEMLocalServiceUtil.getDataItem(1, 2, topicDetails.getMaHuyen());
			DATAITEM dXa = DATAITEMLocalServiceUtil.getDataItem(1, 3, topicDetails.getMaXa());
		%>
		<tr>
				<td  style="width:10%; text-align: center;"><%=(searchContainer.getStart() +  (index++))%></td>								
				<td  style="width:20%; text-align: center;"><%=topicDetails.getMaThongTinPhanAnh() != null ? topicDetails.getMaThongTinPhanAnh() : StringPool.BLANK %></td>		
				<td style="width:20%; text-align: center;""><%=ChiTietThongTinPhanHoiLocalServiceUtil.countPhanHoiGroupByFeedBackCode(topicCode, topicDetails.getMaThongTinPhanAnh(), maTinh, maHuyen, maXa, fromDate, toDate)%></td>						
				<td style="width:50%">					
						<%=dataItem != null ? dataItem.getName() : StringPool.BLANK %>				
				</td>					
			</tr>
		<%
		}
		%>
	</table>
	<aui:button name="btnBack" id="btnBack" value="vn.dtt.thongtinphanhoi.backend.button.back" onClick="<%=backURL.toString() %>"/>
	<%
		if(searchContainer != null){
	%>		
			<div class="tongso"><div id = "pagination"><liferay-ui:search-paginator searchContainer="<%= searchContainer %>" /></div></div>
	<%				
		}
	%>
</div>

<%
	}
%>

<script type="text/javascript">
	function onSaveYcgt(){
		var action = <%=ThongTinPhanHoiConstants.ActionMode.LUU%>;
		$("#<portlet:namespace />actionMode").val(action);

		submitForm(document.<portlet:namespace />frmSaveYcgt);
	}

	<%-- function onSendYcgt(){
		var action = <%=ThongTinPhanHoiConstants.ActionMode.GUI_DUYET%>;
		$("#<portlet:namespace />actionMode").val(action);

		submitForm(document.<portlet:namespace />frmSaveYcgt);
	} --%>
</script>
