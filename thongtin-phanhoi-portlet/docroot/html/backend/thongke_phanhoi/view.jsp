<%@page import="vn.dtt.ns.thongtinphanhoi.business.DataItemBusiness"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="vn.dtt.ns.reporting.ReportConstant"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.DauNoiNuocConstantString"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.business.UserMappingBusiness"%>
<%@page import="vn.dtt.cmon.user.dao.model.UserMapping"%>
<%@page import="java.util.Calendar"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.ThongTinPhanHoiConstants"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiLocalServiceUtil"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails"%>
<%@page import="java.util.Date"%>
<%@page import="vn.dtt.cmon.dm.dao.service.DATAITEMLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.1/jquery.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/jquery-ui.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/base/jquery-ui.css">

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/html/init.jsp" %>

<style>
	.ui-datepicker-calendar {
    	display: none;
    }
</style>

<%
if(themeDisplay.isSignedIn()){
	String maTinh = ParamUtil.getString(request, "maTinh", "");
	String strMonthAndYear = ParamUtil.getString(request, "monthAndYear", "");
	Date fromDate = null;
	Date toDate = null;
	int month = 0;
	int year = 0;
	if(!StringPool.BLANK.equals(strMonthAndYear)){
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
	
	UserMapping userMapping =  UserMappingBusiness.getUserMapping(user);
	if(userMapping.getUserType() == DauNoiNuocConstantString.UserMapping.USER_TINH){
		maTinh = userMapping.getOrgCode1();
	}
	
	List<DATAITEM> lstTinh = DATAITEMLocalServiceUtil.getByDataGroupLevel1(1, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	List<TopicPhanHoi> lstTopicPhanHoi = null;
	Long total = ChiTietThongTinPhanHoiLocalServiceUtil.countThongKePhanHoi(maTinh, month, year);
	if(total > 0){
		lstTopicPhanHoi = ChiTietThongTinPhanHoiLocalServiceUtil.searchThongKePhanHoi(maTinh, month, year, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}
	
	PortletURL searchURL = renderResponse.createActionURL();
	searchURL.setParameter(ActionRequest.ACTION_NAME, "search");
	
	StringBuilder strTitleTransferToMB = new StringBuilder("");
	strTitleTransferToMB.append(LanguageUtil.get(pageContext, "vn.dtt.thongkephanhoi.backend.label.thongke")).append(" ").append(Validator.isNotNull(maTinh)  ?  DataItemBusiness.getDataItem(1, 1, maTinh).getName():StringPool.BLANK).append(" ").append(Validator.isNotNull(strMonthAndYear) ? strMonthAndYear:StringPool.BLANK);
	
	StringBuilder strTransferToMB = new StringBuilder("");
	strTransferToMB.append("<h4  style=\"text-align:center;\">").append(LanguageUtil.get(pageContext, "vn.dtt.thongkephanhoi.backend.label.thongke")).append(" ").append(Validator.isNotNull(maTinh) ?  DataItemBusiness.getDataItem(1, 1, maTinh).getName():StringPool.BLANK).append(" ").append(Validator.isNotNull(strMonthAndYear) ? strMonthAndYear:StringPool.BLANK).append("</h4>");
	
	strTransferToMB.append("<div><table style=\"width:100%; text-align:center;\">");
	strTransferToMB.append("<tr>");
	strTransferToMB.append("<td style=\"width:30%; text-align:left;\">").append(LanguageUtil.get(pageContext, "vn.dtt.thongkephanhoi.backend.label.tinhthanhpho")).append(": ").append(Validator.isNotNull(maTinh) ?  DataItemBusiness.getDataItem(1, 1, maTinh).getName():StringPool.BLANK).append("</td>");
	strTransferToMB.append("<td style=\"width:30%; text-align:left;\">").append(LanguageUtil.get(pageContext, "vn.dtt.thongkephanhoi.backend.label.selectmonth")).append(": ").append(Validator.isNotNull(strMonthAndYear) ? strMonthAndYear:StringPool.BLANK).append("</td>");
	strTransferToMB.append("</tr>");
	strTransferToMB.append("</table></div>");
	
	strTransferToMB.append("<div><table  style=\"width:100%; text-align:center;border-collapse: collapse;border: 1px solid black;\">");
	strTransferToMB.append("<thead><tr>");
	strTransferToMB.append("<th style=\"border: 1px solid black;\">").append(LanguageUtil.get(pageContext, "vn.dtt.thongkephanhoi.backend.label.chude")).append("</th>");
	strTransferToMB.append("<th style=\"border: 1px solid black;\">").append(LanguageUtil.get(pageContext, "vn.dtt.thongkephanhoi.backend.label.sophanhoi")).append("</th>");
	strTransferToMB.append("<th style=\"border: 1px solid black;\">").append(LanguageUtil.get(pageContext, "vn.dtt.thongkephanhoi.backend.label.sophanhoidataoycgt")).append("</th>");
	strTransferToMB.append("<th style=\"border: 1px solid black;\">").append(LanguageUtil.get(pageContext, "vn.dtt.thongkephanhoi.backend.label.sophanhoichuataoycgt")).append("</th>");
	strTransferToMB.append("</thead></tr>");
		
	String strHeader = LanguageUtil.get(pageContext, "vn.dtt.thongkephanhoi.backend.label.thongke");
	%>
	<liferay-ui:header title="<%=strHeader %>"/>
	<aui:form method="post" name="frmThongKePhanHoi" id="frmThongKePhanHoi" action="<%=searchURL.toString() %>">
		<table style="width:80%;">
			<tr>
				<c:if test="<%=userMapping.getUserType() == DauNoiNuocConstantString.UserMapping.CAP_TU %>">		
					<td style="width:30%;">
						<aui:select name="selectMaTinh" label="vn.dtt.thongkephanhoi.backend.label.tinhthanhpho">
							<aui:option><liferay-ui:message key="vn.dtt.thongkephanhoi.backend.label.select.tinhthanhpho"/></aui:option>
							<c:if test="<%=lstTinh != null && lstTinh.size() > 0 %>">
								<%
								for(DATAITEM item : lstTinh){							
								%>
								<aui:option value="<%= item.getNode1() %>" selected="<%= item.getNode1().equals(maTinh) %>"><%= item.getName() %></aui:option>
								<%			
								}
								%>
							</c:if>
						</aui:select>
					</td>
				</c:if>
				<td style="width:30%;">
					<aui:input type="text" name="monthAndYear" id="monthAndYear" label="vn.dtt.thongkephanhoi.backend.label.selectmonth" value="<%=strMonthAndYear %>" />
				</td>
				<td style="width:30%;">
					<aui:button type="submit" name="btnSearch" value="vn.dtt.thongkephanhoi.backend.button.search"/>
					<liferay-portlet:resourceURL var="resourceUrlExportDoc" >
						<liferay-portlet:param name="duoiFileRS" value="<%=ReportConstant.DUOI_DOC %>"/>
						<liferay-portlet:param name="typeRS" value="<%=ReportConstant.THONGKEPHANHOI %>"/>
						<liferay-portlet:param name="maTinhRS" value="<%=maTinh %>"/>
						<liferay-portlet:param name="strMonthAndYearRS" value="<%=strMonthAndYear %>"/>
					</liferay-portlet:resourceURL>
					<aui:button type="button" cssClass="btn-primary" name="btnExportDoc" value="vn.dtt.thongkephanhoi.backend.button.exportdoc" href="<%=resourceUrlExportDoc.toString()%>"/>
					<c:if test="<%=userMapping.getUserType() != DauNoiNuocConstantString.UserMapping.CAP_TU %>">
						<aui:button name="btnChuyenSangMB" value="vn.dtt.thongkephanhoi.backend.button.chuyensangmb"  onClick="javascript:onChuyenSangMB()"/>	
					</c:if>
				</td>
			</tr>
		</table>
	</aui:form>
	
	<div>
		<table class="table table-bordered table-hover table-striped" style="width:100%;">	
			<thead class="table-columns">
				<tr>
					<th><liferay-ui:message key="vn.dtt.thongkephanhoi.backend.label.stt" /></th>
					<th><liferay-ui:message key="vn.dtt.thongkephanhoi.backend.label.chude" /></th>
					<th><liferay-ui:message key="vn.dtt.thongkephanhoi.backend.label.sophanhoi" /></th>
					<th><liferay-ui:message key="vn.dtt.thongkephanhoi.backend.label.sophanhoidataoycgt" /></th>
					<th><liferay-ui:message key="vn.dtt.thongkephanhoi.backend.label.sophanhoichuataoycgt" /></th>							
				</tr>
			</thead>	
			<%
			int index = 1;
			if(lstTopicPhanHoi != null && lstTopicPhanHoi.size() > 0){
				for(TopicPhanHoi topic : lstTopicPhanHoi){
					Long soPhanHoiDaTaoYcgt = ChiTietThongTinPhanHoiLocalServiceUtil.countThongKePhanHoiByTrangThai(ThongTinPhanHoiConstants.TrangThaiYcgt.DA_TAO_YCGT, topic.getTopicCode(), maTinh, fromDate, toDate);
					Long soPhanHoiChuaTaoYcgt = ChiTietThongTinPhanHoiLocalServiceUtil.countThongKePhanHoiByTrangThai(ThongTinPhanHoiConstants.TrangThaiYcgt.CHUA_TAO_YCGT, topic.getTopicCode(), maTinh, fromDate, toDate);
					Long soPhanHoi = soPhanHoiDaTaoYcgt + soPhanHoiChuaTaoYcgt;
					
					strTransferToMB.append("<tr>");
					strTransferToMB.append("<td style=\"width:40%; text-align: center;border: 1px solid black;\">").append(topic.getTopicName()).append("</td>");
					strTransferToMB.append("<td style=\"width:20%; text-align: center;border: 1px solid black;\">").append(Validator.isNotNull(soPhanHoi) ? soPhanHoi.intValue() : 0).append("</td>");
					strTransferToMB.append("<td style=\"width:20%; text-align: center;border: 1px solid black;\">").append(Validator.isNotNull(soPhanHoiDaTaoYcgt) ? soPhanHoiDaTaoYcgt.intValue() : 0).append("</td>");
					strTransferToMB.append("<td style=\"width:20%; text-align: center;border: 1px solid black;\">").append(Validator.isNotNull(soPhanHoiChuaTaoYcgt) ? soPhanHoiChuaTaoYcgt.intValue() : 0).append("</td>");
					strTransferToMB.append("</tr>");
			%>
				<tr>
					<td  style="width:5%; text-align: center;"><%=index++%></td>
					<td  style="width:35%; text-align: center;"><%=topic.getTopicName() %></td>
					<td  style="width:20%; text-align: center;"><%=Validator.isNotNull(soPhanHoi) ? soPhanHoi.intValue() : 0 %></td>	
					<td  style="width:20%; text-align: center;"><%=Validator.isNotNull(soPhanHoiDaTaoYcgt) ? soPhanHoiDaTaoYcgt.intValue() : 0 %></td>
					<td  style="width:20%; text-align: center;"><%=Validator.isNotNull(soPhanHoiChuaTaoYcgt) ? soPhanHoiChuaTaoYcgt.intValue() : 0 %></td>
				</tr>
			<%
				}
				strTransferToMB.append("</table></div>");
			}
			%>
		</table>
	</div>

<portlet:actionURL var="chuyenSangTrangMinhBach" name="chuyenSangTrangMinhBach"/>
<script type="text/javascript">
$(function() {	
    $('#<portlet:namespace/>monthAndYear').datepicker({    	
	 	showButtonPanel: true,
	    dateFormat: "mm/yy",
	    changeMonth: true,
	    changeYear: true,
	    monthNames: ["1","2","3","4","5","6","7","8","9","10","11","12"],
	    monthNamesShort: ["1","2","3","4","5","6","7","8","9","10","11","12"],
	    onClose: function(dateText, inst){		  
		   $(this).datepicker('setDate', new Date(inst.selectedYear, inst.selectedMonth, 1));	
	    }
	 });
});
<% if(userMapping.getUserType() != DauNoiNuocConstantString.UserMapping.CAP_TU){ %>
	var chuyenSangTrangMinhBachUrl = '<%=chuyenSangTrangMinhBach.toString()%>';	
	function onChuyenSangMB(){	
		var errorMsg = '<liferay-ui:message key="vn.dtt.thongkephanhoi.transfer2mb.label.errornamthangmessage" />';
		var namThang = '<%=strMonthAndYear%>';
		if (namThang == "" || namThang.length == 0 || namThang == null)
		{
		    alert(errorMsg);
		}else{
			var successMsg = '<liferay-ui:message key="vn.dtt.thongkephanhoi.transfer2mb.label.successmessage" />';
			$.ajax({
				type : 'POST',				
				url : chuyenSangTrangMinhBachUrl,						
				data :{
					<portlet:namespace/>maTinh : '<%= maTinh%>',
					<portlet:namespace/>thangNam : '<%= strMonthAndYear%>',
					<portlet:namespace/>nguoiChuyen : '<%= userMapping.getUserId() %>',
					<portlet:namespace/>title : '<%= strTitleTransferToMB.toString()%>',
					<portlet:namespace/>content : '<%= strTransferToMB.toString()%>'
				},
				success : function(data) {		
					alert(successMsg);						
					$("#<portlet:namespace/>btnChuyenSangMB").prop('disabled', true);
				}
			});
		}	
		
	}
<% } %>
</script>
<%
}
%>