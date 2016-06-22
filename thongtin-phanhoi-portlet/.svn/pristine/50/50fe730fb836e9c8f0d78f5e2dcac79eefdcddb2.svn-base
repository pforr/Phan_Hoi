<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.language.Language"%>
<%@page import="java.util.Date"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.DateTimeUtil"%>
<%@page import="vn.dtt.cmon.dm.dao.service.DATAITEMLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiLocalServiceUtil"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.dao.service.TopicDetailsLocalServiceUtil"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/html/init.jsp" %>

<%
String strPhanHoiId = ParamUtil.getString(request, "phanHoiId", "");
long phanHoiId =  Long.parseLong(strPhanHoiId);
String backURL = ParamUtil.getString(request, "backURL");

String chuaLapYcgt = LanguageUtil.get(pageContext, "vn.dtt.thongtinphanhoi.backend.label.chualapycgt");
String daLapYcgt = LanguageUtil.get(pageContext, "vn.dtt.thongtinphanhoi.backend.label.dalapycgt");

TopicDetails topicDetails = null;
if(!Validator.isNull(phanHoiId)){
	topicDetails = ChiTietThongTinPhanHoiLocalServiceUtil.getTopicDetailsById(phanHoiId);
}

if(themeDisplay.isSignedIn()){
	if(topicDetails != null){
		DATAITEM itemTinh = DATAITEMLocalServiceUtil.getDataItem(1, 1, topicDetails.getMaTinh());
		DATAITEM itemHuyen = DATAITEMLocalServiceUtil.getDataItem(1, 2, topicDetails.getMaHuyen());
		DATAITEM dataItem = DATAITEMLocalServiceUtil.getDataItem(9, 2, topicDetails.getMaThongTinPhanAnh());
%>
	<div>	
		<liferay-ui:header backURL="<%= backURL.toString() %>" title="vn.dtt.thongtinphanhoi.backend.label.chitietphanhoi"/>	
		<table class="table table-bordered table-hover table-striped" style="width:100%;">
			<tr>
				<td>
					<liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.sodienthoai" />
				</td>
				<td>
					<%=topicDetails.getSoDienThoai() %>
				</td>				
			</tr>			
			<tr>
				<td>
					<liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.thoigiangoi" />
				</td>
				<td>
					<%=DateTimeUtil.formatDate(topicDetails.getThoiGianGoi()) %>
				</td>				
			</tr>
			<tr>
				<td>
					<liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.tongdai" />
				</td>
				<td>
					<% if(topicDetails.getTongDai() == 0){ %>
						<liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.dienthoaivien"/>						
					<%
					}else{
					%>	
						<liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.tongdaitudong"/>
					<%
					}
					%>
				</td>				
			</tr>
			<tr>
				<td>
					<liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.matramcap" />
				</td>
				<td>
					<%=topicDetails.getMaTramCapNuoc() != null ? topicDetails.getMaTramCapNuoc() : StringPool.BLANK %>
				</td>				
			</tr>
			<tr>
				<td>
					<liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.tinhthanhpho" />
				</td>
				<td>
					<%=itemTinh.getName() != null ? itemTinh.getName() : StringPool.BLANK %>
				</td>				
			</tr>
			<tr>
				<td>
					<liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.quanhuyen" />
				</td>
				<td>
					<%=itemHuyen.getName() != null ? itemHuyen.getName() : StringPool.BLANK %>
				</td>				
			</tr>
			<tr>
				<td>
					<liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.thongtinphananh" />
				</td>
				<td>
					<%=dataItem.getName() != null ? dataItem.getName() : StringPool.BLANK %>
				</td>				
			</tr>
			<tr>
				<td>
					<liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.noidungkhacnuoc" />
				</td>
				<td>
					<%=topicDetails.getNoiDungKhacNuoc() != null ? topicDetails.getNoiDungKhacNuoc() : StringPool.BLANK %>
				</td>				
			</tr>
			<tr>
				<td>
					<liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.noidungkhacvesinh" />
				</td>
				<td>
					<%=topicDetails.getNoiDungKhacVesinh() != null ? topicDetails.getNoiDungKhacVesinh() : StringPool.BLANK %>
				</td>				
			</tr>
			<tr>
				<td>
					<liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.trangthailapycgt" />
				</td>
				<td>
					<%=Validator.isNull(topicDetails.getYeuCauGiaiTrinhId()) ?  chuaLapYcgt : daLapYcgt%>
				</td>				
			</tr>
		</table>
	</div>
<%
	}
}
%>