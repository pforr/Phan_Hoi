<%@page import="vn.dtt.cmon.user.dao.model.UserMapping"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.DiaBanQuanLyUtils"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.business.DataItemBusiness"%>
<%@include file="../init.jsp" %>

<%
	String maTinh = ParamUtil.getString(request, "maTinh");
	long maTramCap = ParamUtil.getLong(request, "maTramCap");
	
	UserMapping userMapping = (UserMapping) renderRequest.getAttribute("userMapping");
	long userMappingId = ParamUtil.getLong(request, "userMappingId");
	if(userMapping == null && Validator.isNotNull(userMappingId)){
		userMapping = UserMappingBusiness.getUserMapping(userMappingId);
	} 
	
	long userId = 0;
	
	if (Validator.isNotNull(userMapping)){
		userId = userMapping.getUserId();
	}

	
	List<DATAITEM> lsHuyen = DiaBanQuanLyUtils.findHuyenInTramByUser(maTinh, maTramCap, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	
%>

<%
	for (DATAITEM huyen : lsHuyen) {
		List<DATAITEM> lsXa = DiaBanQuanLyUtils.findXaInHuyenInTramByUser(maTinh, huyen.getNode2(), maTramCap, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
%>
		<aui:input type="checkbox" value="<%= huyen.getNode2() %>" label="<%= huyen.getName() %>" cssClass="<%= Long.toString(maTramCap) %>" name='<%= maTramCap + "selMaHuyenDel" %>'/>
		
		<liferay-ui:panel collapsible="<%= true %>" extended="<%= false %>" persistState="<%= true %>" title="chon-dia-ban-huyen-quan-ly" helpMessage="neu-khong-chon-theo-xa-mac-dinh-quan-ly-toan-huyen" >
		
<%
		for (DATAITEM xa : lsXa) {
%>
			<div class="sel-xa">
				<aui:input cssClass="<%= huyen.getNode2()  %>" type="checkbox" value="<%= xa.getNode3() %>" label="<%= xa.getName() %>" name='<%= huyen.getNode2() + "_selXaDel" %>'/>
			</div>
<%
		}
%>
		</liferay-ui:panel>
<%
	}
%>

