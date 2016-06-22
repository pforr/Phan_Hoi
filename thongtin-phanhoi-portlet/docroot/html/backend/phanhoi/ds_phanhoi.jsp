<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.ThongTinPhanHoiConstants"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.WebKeys"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.business.DataItemBusiness"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.business.UserMappingBusiness"%>
<%@page import="vn.dtt.cmon.user.dao.model.UserMapping"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.DauNoiNuocConstantString"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.DateTimeUtil"%>
<%@page import="java.util.Date"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiLocalServiceUtil"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.LSTORE"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.dao.service.ThongTinPhanHoiLocalServiceUtil"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi"%>
<%@page import="vn.dtt.cmon.dm.dao.service.DATAITEMLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.DiaBanQuanLyUtils"%>

<%@ include file="/html/init.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<style type="text/css">
	.required{
		color: red;
	}	
	
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

String maTinh = ParamUtil.getString(request, "maTinh", "");
String maHuyen = ParamUtil.getString(request, "maHuyen", "");
String maXa = ParamUtil.getString(request, "maXa", "");
String maChuDe = ParamUtil.getString(request, "maChuDe", "");
String strFromDate = ParamUtil.getString(request, "fromDate", "");
String strToDate = ParamUtil.getString(request, "toDate", "");

Date currentDate = new Date();
Calendar calendar = Calendar.getInstance();
calendar.set(Calendar.DATE, 1);
calendar.add(Calendar.MONTH, -1);
Date firstDateOfPrevMonth = calendar.getTime();

Date fromDate = StringPool.BLANK.equals(strFromDate)? firstDateOfPrevMonth: sdf.parse(strFromDate);
Date toDate  = StringPool.BLANK.equals(strToDate)? currentDate: sdf.parse(strToDate);

//int soLuotPhanHoi = ParamUtil.getInteger(request, "soLuotPhanHoi", 0);
List<DATAITEM> listTinh = DATAITEMLocalServiceUtil.getByDataGroupLevel1(1, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
List<DATAITEM> listHuyen = new ArrayList<DATAITEM>();
List<DATAITEM> listXa = new ArrayList<DATAITEM>();
boolean isSupperAdmin = request.isUserInRole("Administrator");

UserMapping userMapping =  UserMappingBusiness.getUserMapping(user);
if(userMapping.getUserType() == DauNoiNuocConstantString.UserMapping.USER_TINH){
	maTinh = userMapping.getOrgCode1();
}

if(DauNoiNuocConstantString.UserMapping.USER_TINH == userMapping.getUserType()
	||DauNoiNuocConstantString.UserMapping.USER_GT_NUOC == userMapping.getUserType() 
	|| DauNoiNuocConstantString.UserMapping.USER_GT_VS == userMapping.getUserType()){
	maTinh = userMapping.getOrgCode1();
}

if(DauNoiNuocConstantString.UserMapping.USER_GT_NUOC == userMapping.getUserType() || DauNoiNuocConstantString.UserMapping.USER_GT_VS == userMapping.getUserType()){
	if(!StringPool.BLANK.equals(maTinh)){	
		listHuyen =  DATAITEMLocalServiceUtil.findHuyenChonByUser(maTinh, userMapping.getUserId(),  QueryUtil.ALL_POS, QueryUtil.ALL_POS);	 	
	}	
}else{
	if(!StringPool.BLANK.equals(maTinh)){	
		listHuyen = DataItemBusiness.getInLevel2(WebKeys.DATAGROUPID_DONVIHANHCHINH, maTinh);
	}	
}

if(!StringPool.BLANK.equals(maHuyen)){
	listXa = DataItemBusiness.getInLevel3(WebKeys.DATAGROUPID_DONVIHANHCHINH, maTinh, maHuyen);	
}

List<DATAITEM> listChuDe = new ArrayList<DATAITEM>();
listChuDe = DATAITEMLocalServiceUtil.getDATAITEMByDataGroupIdAndLevel(9, 1);

PortletURL pagingURL = renderResponse.createRenderURL();
pagingURL.setParameter("jspPage", "/html/backend/phanhoi/ds_phanhoi.jsp");
pagingURL.setParameter("maTinh", maTinh);
pagingURL.setParameter("maHuyen", maHuyen);
pagingURL.setParameter("maXa", maXa);
pagingURL.setParameter("maChuDe", maChuDe);
pagingURL.setParameter("fromDate", sdf.format(fromDate));
pagingURL.setParameter("toDate", sdf.format(toDate));
pagingURL.setParameter("delta", String.valueOf(delta));

SearchContainer searchContainer = new SearchContainer(renderRequest, null,
		null, SearchContainer.DEFAULT_CUR_PARAM,
		cur, delta, pagingURL, null, null);

int start = searchContainer.getStart();
int end = searchContainer.getEnd();

List<TopicPhanHoi> listTopicPhanHoi = new ArrayList<TopicPhanHoi>();
Long total = 0L;
total = ChiTietThongTinPhanHoiLocalServiceUtil.countTopicPhanHoi(maTinh, maHuyen, maXa, maChuDe, fromDate, toDate);
if(total > 0){
	listTopicPhanHoi = ChiTietThongTinPhanHoiLocalServiceUtil.searchTopicPhanHoi(maTinh, maHuyen, maXa, maChuDe, fromDate, toDate, start, end);
}

searchContainer.setTotal(total.intValue());
searchContainer.setResults(listTopicPhanHoi);

PortletURL searchURL = renderResponse.createActionURL();
searchURL.setParameter(ActionRequest.ACTION_NAME, "search");

if(themeDisplay.isSignedIn()){
	String strHeader = LanguageUtil.get(pageContext, "vn.dtt.thongtinphanhoi.backend.label.danhsachchude");
%>
<div>
	<liferay-ui:header title="<%=strHeader %>"/>
	<aui:form name="frmSearchPhanHoi" id="frmSearchPhanHoi" method="post" action="<%=searchURL.toString() %>">
		<table  style="width:100%">						
			<tr>
				<c:if test="<%=userMapping.getUserType() == DauNoiNuocConstantString.UserMapping.CAP_TU %>">											
					<td  style="width:20%">		
						<aui:select name="selectMaTinh" id="selectMaTinh" label="vn.dtt.thongtinphanhoi.backend.label.tinhthanhpho">		
							<aui:option><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.select.matinh"/></aui:option>
							<%
								for(DATAITEM tinh: listTinh){
							%>
								<aui:option value="<%= tinh.getNode1() %>" selected="<%= tinh.getNode1().equals(maTinh)%>"><%= tinh.getName() %></aui:option>
							<%
								}
							%>
						</aui:select>					
					</td>
				</c:if> 
				<td  style="width:20%">
					<aui:select name="selectMaHuyen" id="selectMaHuyen" label="vn.dtt.thongtinphanhoi.backend.label.quanhuyen">					
						<aui:option><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.select.mahuyen"/></aui:option>						
						
						<%
							for(DATAITEM huyen: listHuyen){
						%>
							<aui:option value="<%= huyen.getNode2() %>" selected="<%= huyen.getNode2().equals(maHuyen)%>"><%= huyen.getName() %></aui:option>
						<%
							}
						%>
					</aui:select>				
				</td>
				
				<td  style="width:20%">
					<aui:select name="selectMaXa" id="selectMaXa" label="vn.dtt.thongtinphanhoi.backend.label.xaphuong">
						<aui:option><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.select.maxa"/></aui:option>						
						<%
							for(DATAITEM xa: listXa){
						%>
							<aui:option value="<%= xa.getNode3() %>" selected="<%= xa.getNode3().equals(maXa)%>"><%= xa.getName() %></aui:option>
						<%
							}
						%>
					</aui:select>				
				</td>
				
				<td  style="width:20%">
					<aui:select name="selectMaChuDe" id="selectMaChuDe" label="vn.dtt.thongtinphanhoi.backend.label.chude">
						<aui:option><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.select.chude"/></aui:option>
						<%
							for(DATAITEM chude: listChuDe){
						%>
							<aui:option value="<%= chude.getCode() %>" selected="<%= chude.getCode().equals(maChuDe)%>"><%= chude.getName() %></aui:option>
						<%
							}
						%>
					</aui:select>
				</td>
			</tr>
			<tr>
				<%-- <td>
					<aui:input type="text" name="soLuotPhanHoi" value="<%=soLuotPhanHoi %>" label="vn.dtt.thongtinphanhoi.backend.label.soluotphanhoi" />
				</td> --%>
				<td style="width:20%">
					<aui:input type="text" name="fromDate" label="vn.dtt.thongtinphanhoi.backend.label.tungay" value="<%=sdf.format(fromDate) %>" />
				</td>
				<td style="width:20%">
					<aui:input type="text" name="toDate" label="vn.dtt.thongtinphanhoi.backend.label.denngay" value="<%=sdf.format(toDate) %>" />
				</td>
				<td  style="width:20%">
					<aui:button type="submit" name="btnSearch" id="btnSearch" value="vn.dtt.thongtinphanhoi.backend.button.search"/>
				</td>
			</tr>
		</table>				
	</aui:form>
	
	<div>
		<table class="table table-bordered table-hover table-striped" style="width:100%;">	
			<thead class="table-columns">
				<tr>
					<th style="width:5%"><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.stt"/></th>
					<th style="width:15%"><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.tinhthanhpho"/></th>
					<th style="width:15%"><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.quanhuyen"/></th>
					<th style="width:15%"><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.xaphuong"/></th>
					<th style="width:20%"><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.chude"/></th>
					<th style="width:10%"><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.sophanhoi"/></th>				
					<th style="width:10%"><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.dataoycgt"/></th>
					<th style="width:10%"><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.chuataoycgt"/></th>					
				</tr>
			</thead>	
			<%
				int index = 1;
				for(TopicPhanHoi topic: listTopicPhanHoi) {
					String strRangeTopic = preferences.getValue(topic.getTopicCode(), "0");
					int rangeTopic = Integer.parseInt(strRangeTopic);					
					Long soPhanHoiDaTaoYcgt = ChiTietThongTinPhanHoiLocalServiceUtil.countPhanHoiByTrangThaiYcgt(ThongTinPhanHoiConstants.TrangThaiYcgt.DA_TAO_YCGT, topic.getTopicCode(), "", topic.getMaTinh(), topic.getMaHuyen(), topic.getMaXa(), fromDate, toDate);
					Long soPhanHoiChuaTaoYcgt = ChiTietThongTinPhanHoiLocalServiceUtil.countPhanHoiByTrangThaiYcgt(ThongTinPhanHoiConstants.TrangThaiYcgt.CHUA_TAO_YCGT, topic.getTopicCode(), "",  topic.getMaTinh(), topic.getMaHuyen(),  topic.getMaXa(),  fromDate, toDate);
					
					Long soPhanHoi = soPhanHoiDaTaoYcgt + soPhanHoiChuaTaoYcgt;
					
					PortletURL viewTopicDetailsUrl = renderResponse.createRenderURL();
					viewTopicDetailsUrl.setParameter("jspPage", "/html/backend/phanhoi/chitiet_chude.jsp");
					viewTopicDetailsUrl.setParameter("topicCode", topic.getTopicCode());
					viewTopicDetailsUrl.setParameter("backURL", themeDisplay.getURLCurrent());
					viewTopicDetailsUrl.setParameter("fromDate", strFromDate);
					viewTopicDetailsUrl.setParameter("toDate", strToDate);
					viewTopicDetailsUrl.setParameter("maTinh", topic.getMaTinh());
					viewTopicDetailsUrl.setParameter("maHuyen", topic.getMaHuyen());
					viewTopicDetailsUrl.setParameter("maXa", topic.getMaXa());
					viewTopicDetailsUrl.setParameter("topicName", topic.getTopicName());
					viewTopicDetailsUrl.setParameter("fromDate", sdf.format(fromDate));
					viewTopicDetailsUrl.setParameter("toDate", sdf.format(toDate));
					DATAITEM itemTinh = DATAITEMLocalServiceUtil.getDataItem(1, 1, topic.getMaTinh());					
					DATAITEM itemHuyen = DATAITEMLocalServiceUtil.getDataItem(1, 2, topic.getMaHuyen());
					DATAITEM itemXa = DATAITEMLocalServiceUtil.getDataItem(1, 3, topic.getMaXa());
			%>
				<tr>
					<td  style="width:5%; text-align: center;"><%=(searchContainer.getStart() +  (index++))%></td>
					<td  style="width:15%; text-align: center;"><%=itemTinh != null ? itemTinh.getName() : StringPool.BLANK %></td>
					<td  style="width:15%; text-align: center;"><%=itemHuyen != null ? itemHuyen.getName() : StringPool.BLANK %></td>
					<td  style="width:15%; text-align: center;"><%=itemXa != null ? itemXa.getName() : StringPool.BLANK %></td>
					<td  style="width:20%; text-align: center;">
						<a href="<%=viewTopicDetailsUrl.toString()%>"><%=topic.getTopicName() %></a>						
					</td>
					<td  style="width:10%; text-align: center;"><%=Validator.isNotNull(soPhanHoi) ? soPhanHoi.intValue() : 0 %></td>				
					<td  style="width:10%; text-align: center;">						
						<%
							if(soPhanHoiDaTaoYcgt > 0){
								PortletURL viewChuDeDaTaoYcgtUrl = renderResponse.createRenderURL();
								viewChuDeDaTaoYcgtUrl.setParameter("jspPage", "/html/backend/phanhoi/chitiet_chude.jsp");
								viewChuDeDaTaoYcgtUrl.setParameter("topicCode", topic.getTopicCode());
								viewChuDeDaTaoYcgtUrl.setParameter("backURL", themeDisplay.getURLCurrent());								
								viewChuDeDaTaoYcgtUrl.setParameter("fromDate", sdf.format(fromDate));
								viewChuDeDaTaoYcgtUrl.setParameter("toDate", sdf.format(toDate));
								viewChuDeDaTaoYcgtUrl.setParameter("maTinh", topic.getMaTinh());
								viewChuDeDaTaoYcgtUrl.setParameter("maHuyen", topic.getMaHuyen());
								viewChuDeDaTaoYcgtUrl.setParameter("maXa", topic.getMaXa());
								viewChuDeDaTaoYcgtUrl.setParameter("topicName", topic.getTopicName());							
								viewChuDeDaTaoYcgtUrl.setParameter("soPhanHoiDaTaoYcgt", soPhanHoiDaTaoYcgt.toString());
							%>
							<a href="<%=viewChuDeDaTaoYcgtUrl.toString()%>">
								<%=Validator.isNotNull(soPhanHoiDaTaoYcgt) ? soPhanHoiDaTaoYcgt.intValue() : 0 %>
							</a>
						<%
							}else{
								%>
									0
								<%
							}
						%>
					</td>
					<td  style="width:10%; text-align: center;">
					<%
						if(soPhanHoiChuaTaoYcgt > 0){
							PortletURL viewChuDeChuaTaoYcgtUrl = renderResponse.createRenderURL();
							viewChuDeChuaTaoYcgtUrl.setParameter("jspPage", "/html/backend/phanhoi/chitiet_chude.jsp");
							viewChuDeChuaTaoYcgtUrl.setParameter("topicCode", topic.getTopicCode());
							viewChuDeChuaTaoYcgtUrl.setParameter("backURL", themeDisplay.getURLCurrent());
							viewChuDeChuaTaoYcgtUrl.setParameter("fromDate", sdf.format(fromDate));
							viewChuDeChuaTaoYcgtUrl.setParameter("toDate", sdf.format(toDate));							
							viewChuDeChuaTaoYcgtUrl.setParameter("maTinh", topic.getMaTinh());
							viewChuDeChuaTaoYcgtUrl.setParameter("maHuyen", topic.getMaHuyen());
							viewChuDeChuaTaoYcgtUrl.setParameter("maXa", topic.getMaXa());
							viewChuDeChuaTaoYcgtUrl.setParameter("topicName", topic.getTopicName());							
							viewChuDeChuaTaoYcgtUrl.setParameter("soPhanHoiChuaTaoYcgt", soPhanHoiChuaTaoYcgt.toString());
						%>
						<a href="<%=viewChuDeChuaTaoYcgtUrl.toString()%>">
							<%=soPhanHoiChuaTaoYcgt.intValue()%>
						</a>
					<%
						}else{
							%>
								0
							<%
						}
				}
					%>
		</table>
		<%
			if(searchContainer != null){
		%>		
				<div class="tongso"><div id = "pagination"><liferay-ui:search-paginator searchContainer="<%= searchContainer %>" /></div></div>
		<%				
			}
		%>
	</div>
		
</div>
<%
}
%>

<portlet:actionURL var="findQuanHuyenByMaTinh" name="findQuanHuyenByMaTinh"/>
<portlet:actionURL var="findXaPhuongByTinhHuyen" name="findXaPhuongByTinhHuyen"/>
<script type="text/javascript">

	var findQuanHuyenUrl = '<%=findQuanHuyenByMaTinh.toString()%>';		
		
	$('#<portlet:namespace/>selectMaTinh').change(function(event) {				
		var matinh = $("select#<portlet:namespace/>selectMaTinh").val();		
		if (matinh == "")
			return;
				
		$.ajax({
			type : 'GET',				
			url : findQuanHuyenUrl,	
			dataType: 'json',							
			data :{
				<portlet:namespace/>maTinh : matinh,
				<portlet:namespace/>userType : <%=userMapping.getUserType()%>
			},
			success : function(data) {							
				//console.log("=== data: " + data);
			    var select = $('#<portlet:namespace/>selectMaHuyen');
				select.find('option').remove();
				var selectQuanHuyen = '<liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.select.mahuyen" />';
							
				$('<option>').val('').text(selectQuanHuyen).appendTo(select);				
				for ( var i = 0; i < data.id.length; i++) { 
					$('<option>').val(data.id[i]).text(data.name[i]).appendTo(select);					
				}				
			}
		});
	});		

	var findXaPhuongUrl = '<%=findXaPhuongByTinhHuyen.toString()%>';
	$('#<portlet:namespace/>selectMaHuyen').change(function(event) {			
		var matinh = $("select#<portlet:namespace/>selectMaTinh").val();
		if(matinh == undefined)
			matinh = '<%=maTinh%>';	
					
		var mahuyen = $("select#<portlet:namespace/>selectMaHuyen").val();		
		if (mahuyen == "")
			return;
		$.ajax({
			type : 'GET',				
			url : findXaPhuongUrl,	
			dataType: 'json',							
			data :{
				<portlet:namespace/>maTinh : matinh,
				<portlet:namespace/>maHuyen : mahuyen,
				<portlet:namespace/>userType : <%=userMapping.getUserType()%>
			},
			success : function(data1) {										
			    var select = $('#<portlet:namespace/>selectMaXa');
				select.find('option').remove();
				var selectXaPhuong = '<liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.select.maxa" />';
							
				$('<option>').val('').text(selectXaPhuong).appendTo(select);				
				for ( var i = 0; i < data1.id.length; i++) { 
					$('<option>').val(data1.id[i]).text(data1.name[i]).appendTo(select);					
				}				
			}
		});
	});	

	function searchPhanHoi(){		
		document.<portlet:namespace/>frmSearchPhanHoi.submit();
	}

	
	AUI().use('aui-datepicker',function(A) {
	     new A.DatePicker(
	      {
	        trigger: '#<portlet:namespace />fromDate',
	        mask: '%d/%m/%Y',
	        popover: {
	          zIndex: 1
	        },
	        on: {
	          selectionChange: function(event) {
	            console.log(event.newSelection)
	          }
	        }
	      }
	    );

	    new A.DatePicker(
  	      {
  	        trigger: '#<portlet:namespace />toDate',
  	        mask: '%d/%m/%Y',
  	        popover: {
  	          zIndex: 1
  	        },
  	        on: {
  	          selectionChange: function(event) {
  	            console.log(event.newSelection)
  	          }
  	        }
  	      }
  	    ); 
	});

</script>