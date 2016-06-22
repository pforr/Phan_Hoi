<%@page import="vn.dtt.ns.quanlynguoidung.permission.UserYcgtPermission"%>
<%@page import="vn.dtt.ns.yeucaugiaitrinh.dao.service.ChiTietYeuCauGiaiTrinhLocalServiceUtil"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.business.DataItemBusiness"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.DauNoiNuocConstantString"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.business.UserMappingBusiness"%>
<%@page import="vn.dtt.cmon.user.dao.model.UserMapping"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.WebKeys"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.ThongTinPhanHoiConstants"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi"%>
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
<%@page import="vn.dtt.ns.thongtinphanhoi.util.ActionKeys"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/html/init.jsp" %>
<style type="text/css">	
	a:hover{		
		font-weight: bold;
	}
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

String topicCode = ParamUtil.getString(request, "topicCode", "");
String feedbackCode = ParamUtil.getString(request, "feedbackCode", "");
String strFromDate = ParamUtil.getString(request, "fromDate", "");
String strToDate = ParamUtil.getString(request, "toDate", "");
String maTinh = ParamUtil.getString(request, "maTinh", "");
String maHuyen = ParamUtil.getString(request, "maHuyen", "");
String maXa = ParamUtil.getString(request, "maXa", "");
String topicName = ParamUtil.getString(request, "topicName", "");
int soPhanHoiChuaTaoYcgt = ParamUtil.getInteger(request, "soPhanHoiChuaTaoYcgt", 0);
int soPhanHoiDaTaoYcgt = ParamUtil.getInteger(request, "soPhanHoiDaTaoYcgt", 0);

Date fromDate = StringPool.BLANK.equals(strFromDate)? null: sdf.parse(strFromDate);
Date toDate  = StringPool.BLANK.equals(strToDate)? null: sdf.parse(strToDate);

UserMapping userMapping =  UserMappingBusiness.getUserMapping(user);
if(userMapping.getUserType() == DauNoiNuocConstantString.UserMapping.USER_TINH){
	maTinh = userMapping.getOrgCode1();
}

boolean isSupperAdmin = request.isUserInRole("Administrator");

List<DATAITEM> listHuyen = new ArrayList<DATAITEM>();
if(!StringPool.BLANK.equals(maTinh)){
	listHuyen = DataItemBusiness.getInLevel2(WebKeys.DATAGROUPID_DONVIHANHCHINH, maTinh);
}

List<DATAITEM> listXa = new ArrayList<DATAITEM>();
if(!StringPool.BLANK.equals(maHuyen)){
	listXa = DataItemBusiness.getInLevel3(WebKeys.DATAGROUPID_DONVIHANHCHINH, maTinh, maHuyen);
}


DATAITEM itemTinh = DATAITEMLocalServiceUtil.getDataItem(1, 1, maTinh);
DATAITEM itemHuyen = DATAITEMLocalServiceUtil.getDataItem(1, 2, maHuyen);
DATAITEM itemXa = DATAITEMLocalServiceUtil.getDataItem(1, 3, maXa);


List<DATAITEM> itemName = DATAITEMLocalServiceUtil.getDATAITEMByTen(topicName);
List<DATAITEM> listFeedback = new ArrayList<DATAITEM>();
listFeedback = DATAITEMLocalServiceUtil.getDATAITEMByDataGroupIdAndLevel(9, 2);

PortletURL backURL = renderResponse.createRenderURL();
backURL.setParameter("jspPage", "/html/backend/phanhoi/ds_phanhoi.jsp");

PortletURL pagingURL = renderResponse.createRenderURL();
pagingURL.setParameter("jspPage", "/html/backend/phanhoi/chitiet_chude.jsp");
pagingURL.setParameter("topicCode", topicCode);
pagingURL.setParameter("feedbackCode", feedbackCode);
pagingURL.setParameter("fromDate", strFromDate);
pagingURL.setParameter("toDate", strToDate);
pagingURL.setParameter("maTinh", maTinh);
pagingURL.setParameter("maHuyen", maHuyen);
pagingURL.setParameter("maXa", maXa);
pagingURL.setParameter("soPhanHoiChuaTaoYcgt", String.valueOf(soPhanHoiChuaTaoYcgt));
pagingURL.setParameter("soPhanHoiDaTaoYcgt", String.valueOf(soPhanHoiDaTaoYcgt));
pagingURL.setParameter("topicName", topicName);
pagingURL.setParameter("backURL", backURL.toString());
pagingURL.setParameter("delta", String.valueOf(delta));

SearchContainer searchContainer = new SearchContainer(renderRequest, null,
		null, SearchContainer.DEFAULT_CUR_PARAM,
		cur, delta, pagingURL, null, null);

int start = searchContainer.getStart();
int end = searchContainer.getEnd();

List<TopicDetails> lstTopicDetails = new ArrayList<TopicDetails>();
Long total = 0L;
if(soPhanHoiChuaTaoYcgt > 0){
	total = ChiTietThongTinPhanHoiLocalServiceUtil.countPhanHoiByTrangThaiYcgt(ThongTinPhanHoiConstants.TrangThaiYcgt.CHUA_TAO_YCGT, topicCode, feedbackCode, maTinh, maHuyen, maXa, fromDate, toDate);
	if(total > 0){
		lstTopicDetails = ChiTietThongTinPhanHoiLocalServiceUtil.getTopicDetailsByTrangThaiYcgt(ThongTinPhanHoiConstants.TrangThaiYcgt.CHUA_TAO_YCGT, topicCode, feedbackCode, maTinh, maHuyen, maXa, fromDate, toDate, start, end);
	}
}else if(soPhanHoiDaTaoYcgt > 0){
	total = ChiTietThongTinPhanHoiLocalServiceUtil.countPhanHoiByTrangThaiYcgt(ThongTinPhanHoiConstants.TrangThaiYcgt.DA_TAO_YCGT, topicCode, feedbackCode, maTinh, maHuyen, maXa, fromDate, toDate);
	if(total > 0){
		lstTopicDetails = ChiTietThongTinPhanHoiLocalServiceUtil.getTopicDetailsByTrangThaiYcgt(ThongTinPhanHoiConstants.TrangThaiYcgt.DA_TAO_YCGT, topicCode, feedbackCode, maTinh, maHuyen, maXa, fromDate, toDate, start, end);
	}	
}else{
	total = ChiTietThongTinPhanHoiLocalServiceUtil.countPhanHoiByTopicCode(topicCode, maTinh, maHuyen, maXa, feedbackCode, fromDate, toDate);
	if(total > 0){
		lstTopicDetails = ChiTietThongTinPhanHoiLocalServiceUtil.getTopicDetailsByTopicCode(topicCode, maTinh, maHuyen, maXa, feedbackCode, fromDate, toDate, start, end);
	}
}

searchContainer.setTotal(total.intValue());
searchContainer.setResults(lstTopicDetails);

PortletURL searchPhanHoiURL = renderResponse.createActionURL();
searchPhanHoiURL.setParameter(ActionRequest.ACTION_NAME, "searchPhanHoi");
searchPhanHoiURL.setParameter("maTinh", maTinh);
searchPhanHoiURL.setParameter("maHuyen", maHuyen);
searchPhanHoiURL.setParameter("maXa", maXa);
searchPhanHoiURL.setParameter("topicCode", topicCode);
searchPhanHoiURL.setParameter("topicName", topicName);
searchPhanHoiURL.setParameter("soPhanHoiChuaTaoYcgt", String.valueOf(soPhanHoiChuaTaoYcgt));
searchPhanHoiURL.setParameter("soPhanHoiDaTaoYcgt", String.valueOf(soPhanHoiDaTaoYcgt));
searchPhanHoiURL.setParameter("fromDate", strFromDate);
searchPhanHoiURL.setParameter("toDate", strToDate);

StringBuilder strHeaderBuilder = new StringBuilder();
strHeaderBuilder.append(LanguageUtil.get(pageContext, "vn.dtt.thongtinphanhoi.backend.label.danhsachphanhoi")).append(" "); 
strHeaderBuilder.append(LanguageUtil.get(pageContext, "vn.dtt.thongtinphanhoi.backend.label.cuachude"));
strHeaderBuilder.append("\n").append(topicName);


String chuaLapYcgt = LanguageUtil.get(pageContext, "vn.dtt.thongtinphanhoi.backend.label.chualapycgt");
String daLapYcgt = LanguageUtil.get(pageContext, "vn.dtt.thongtinphanhoi.backend.label.dalapycgt");
if(themeDisplay.isSignedIn()){
%>
<div>		
	<liferay-ui:header backURL="<%= backURL.toString() %>" title="<%=strHeaderBuilder.toString() %>"/>	
		
	
	<table style="width:100%;text-align: left;">
		<tr>
			<td></td>
			<td>
				<c:if test="<%=soPhanHoiDaTaoYcgt > 0 %>">
					<h5><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.trangthaiycgt" />: <liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.dalapycgt" /></h5>
				</c:if>
				<c:if test="<%=soPhanHoiChuaTaoYcgt > 0 %>">
					<h5><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.trangthaiycgt" />: <liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.chualapycgt" /></h5>
				</c:if>	
			</td>
			<td></td>
		</tr>
		<tr>
			<td><h5><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.tinhthanhpho" />: <%=itemTinh != null ? itemTinh.getName(): StringPool.BLANK %></h5></td>
			<td><h5><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.quanhuyen" />: <%=itemHuyen != null ? itemHuyen.getName(): StringPool.BLANK %></h5></td>
			<td><h5><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.xaphuong" />: <%=itemXa != null ? itemXa.getName(): StringPool.BLANK %></h5></td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.tungay" />:<%= strFromDate%>
			</td>
			<td>
				<liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.denngay" />: <%= strToDate%>				
			</td>			
		</tr>		
	</table>
	
	<aui:form name="frmSearchFeedback" id="frmSearchFeedback" method="post" action="<%=searchPhanHoiURL.toString() %>">	
		<table>
			<tr>				
				<td>
					<aui:select name="selectFeedback" id="selectFeedback" label="vn.dtt.thongtinphanhoi.backend.label.feedback">
						<c:if test="<%=userMapping.getUserType() == DauNoiNuocConstantString.UserMapping.CAP_TU 
										|| userMapping.getUserType() == DauNoiNuocConstantString.UserMapping.USER_TINH %>">
							<aui:option><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.selectfeedback"/></aui:option>
						</c:if> 
						
						<%
							for(DATAITEM feedback: listFeedback){

								DATAITEM ITEMCC = itemName.get(0);
								if(feedback.getNode1().equals(ITEMCC.getNode1())){
						%>
							<aui:option value="<%= feedback.getCode() %>" selected="<%= feedback.getCode().equals(feedbackCode)%>"><%= feedback.getName() %></aui:option>
						<%
								}
							}
						%>
					</aui:select>
				</td>
				<td>
					<aui:button type="button" name="btnSearch" id="btnSearch" value="vn.dtt.thongtinphanhoi.backend.button.search" onClick="javascript:onSearchFeedback();" />
				</td>
			</tr>	
			<tr>
				<td colspan="4">
					<div style="color: #9d1f02;"  id="<portlet:namespace />selectMaHuyenError"></div>
				</td>
			</tr>		
		</table>		
	</aui:form>
	
	<table class="table table-bordered table-hover table-striped" style="width:100%;">	
		<thead class="table-columns">
			<tr>
				<th  style="width:5%"><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.stt"/></th>		
				<th  style="width:10%"><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.sodienthoai"/></th>
				<th  style="width:10%"><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.thoigiangoi"/></th>
				<th  style="width:10%"><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.tongdai"/></th>		
				<th  style="width:10%"><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.quanhuyen"/></th>
				<th  style="width:10%"><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.xaphuong"/></th>
				<th  style="width:10%"><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.mathongtinphananh"/></th>
				<%-- <th  style="width:10%"><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.soluongphananh"/></th>	 --%>				
				<th  style="width:25%"><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.thongtinphananh"/></th>
																		
			</tr>
		</thead>
		
		<%
			int index = 1;
			for(TopicDetails topicDetails: lstTopicDetails){				
				DATAITEM dataItem = DATAITEMLocalServiceUtil.getDataItem(9, 2, topicDetails.getMaThongTinPhanAnh());							
				DATAITEM dHuyen = DATAITEMLocalServiceUtil.getDataItem(1, 2, topicDetails.getMaHuyen());
				DATAITEM dXa = DATAITEMLocalServiceUtil.getDataItem(1, 3, topicDetails.getMaXa());
				
				PortletURL viewPhanHoiDetailsUrl = renderResponse.createRenderURL();
				viewPhanHoiDetailsUrl.setParameter("jspPage", "/html/backend/phanhoi/chitiet_phanhoi.jsp");
				viewPhanHoiDetailsUrl.setParameter("phanHoiId", String.valueOf(topicDetails.getId()));
				viewPhanHoiDetailsUrl.setParameter("backURL", themeDisplay.getURLCurrent());						
		%>
			<tr>
				<td  style="width:5%; text-align: center;"><%=(searchContainer.getStart() +  (index++))%></td>		
				<td  style="width:10%; text-align: center;"><%=topicDetails.getSoDienThoai() %></td>
				<td  style="width:10%; text-align: center;"><%=DateTimeUtil.formatDate(topicDetails.getThoiGianGoi())%></td>
				<td  style="width:10%; text-align: center;">
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
				<td style="width:10%; text-align: center;""><%=dHuyen != null ? dHuyen.getName() : StringPool.BLANK %></td>
				<td style="width:10%; text-align: center;""><%=dXa != null ?  dXa.getName() : StringPool.BLANK%></td>
				<td  style="width:10%; text-align: center;"><%=topicDetails.getMaThongTinPhanAnh() != null ? topicDetails.getMaThongTinPhanAnh() : StringPool.BLANK %></td>
				<%-- <td style="width:10%; text-align: center;""><%=ChiTietThongTinPhanHoiLocalServiceUtil.countPhanHoiByMaThongTinPhanAnh(topicCode, topicDetails.getMaThongTinPhanAnh(), maTinh, maHuyen, maXa, fromDate, toDate)%></td> --%>								
				<td style="width:25%">
					<a href="<%=viewPhanHoiDetailsUrl.toString()%>">
						<%=dataItem != null ? dataItem.getName() : StringPool.BLANK %>
					</a>
				</td>		
			</tr>
		<%
			}
		%>
	</table>
	<div>
		<aui:button name="btnBack" id="btnBack" value="vn.dtt.thongtinphanhoi.backend.button.back" onClick="<%=backURL.toString() %>"/>
		<%if(soPhanHoiChuaTaoYcgt > 0){
			PortletURL taoYcgtURL = renderResponse.createRenderURL();
			taoYcgtURL.setParameter("jspPage", "/html/backend/phanhoi/tao_yeucau_giaitrinh.jsp");
			taoYcgtURL.setParameter("topicCode", topicCode);
			taoYcgtURL.setParameter("feedbackCode", feedbackCode);
			taoYcgtURL.setParameter("backURL", themeDisplay.getURLCurrent());
			taoYcgtURL.setParameter("fromDate", strFromDate);
			taoYcgtURL.setParameter("toDate", strToDate);
			taoYcgtURL.setParameter("maTinh", maTinh);
			taoYcgtURL.setParameter("maHuyen", maHuyen);
			taoYcgtURL.setParameter("maXa", maXa);
			taoYcgtURL.setParameter("topicName", topicName);
			taoYcgtURL.setParameter("soPhanHoiChuaTaoYcgt", String.valueOf(soPhanHoiChuaTaoYcgt));
			
		%>
			<c:if test="<%=UserYcgtPermission.contains(permissionChecker, scopeGroupId, ActionKeys.TAO_YCGT) %>">
				<aui:button name="btnTaoYcgt" id="btnTaoYcgt" value="vn.dtt.thongtinphanhoi.backend.button.taoycgt" onClick="<%=taoYcgtURL.toString() %>"/>
			</c:if>
		<%
		}
		%>
	</div>
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

<portlet:actionURL var="findXaPhuongByTinhHuyen" name="findXaPhuongByTinhHuyen"/>
<script type="text/javascript">

	AUI().ready('node-base' ,'aui-form-validator', 'aui-overlay-context-panel', 'widget-locale', function(A) {		
		window.<portlet:namespace />validateActivity = new A.FormValidator({
			boundingBox: '#<portlet:namespace />frmSearchFeedback',
			validateOnBlur: true,
			validateOnInput: true,
			selectText: true,
			showMessages: false,
			containerErrorClass: '',
			errorClass: '',
			rules: {	
				<portlet:namespace />selectMaHuyen: {
	        		required: true
	            }
			},
	        fieldStrings: {	
	        	<portlet:namespace />selectMaHuyen: {
	        		required: '<liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.errormsg.selectmahuyen.required" />'	        		
	            }
			},
			
			on: {		
	            errorField: function(event) {	        
	            	var instance = this;
					var field = event.validator.field;
					var divError = A.one('#'+field.get('name')+'Error');
					if(divError) {
						divError.addClass('required');
						divError.setContent(instance.getFieldErrorMessage(field,event.validator.errors[0]));						
					}
	            },		
	            validField: function(event) {
					var divError = A.one('#'+event.validator.field.get('name')+'Error');
					if(divError) {
						divError.removeClass('required');
						divError.setContent('');
					}
	            }
			}
		});
	});
	
	function validateForm(){	
		if(window.<portlet:namespace />validateActivity){					
			window.<portlet:namespace />validateActivity.validateField('<portlet:namespace />selectMaHuyen');			
		}
		
		
		if (!window.<portlet:namespace/>validateActivity.hasErrors()) {		 
	  		submitForm(document.<portlet:namespace />frmSearchFeedback);
	    }			
	} 	
		
	function onSearchFeedback(){								
		validateForm();
	}
	
</script>