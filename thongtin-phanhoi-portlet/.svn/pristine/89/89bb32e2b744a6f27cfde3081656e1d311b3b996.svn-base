<%@page import="vn.dtt.cmon.user.dao.model.UserMapping"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.DiaBanQuanLyUtils"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.business.DataItemBusiness"%>
<%@include file="../init.jsp" %>

<%
	String maTinh = ParamUtil.getString(request, "maTinh");
	long maTramCap = ParamUtil.getLong(request, "maTramCap");
	
	List<DATAITEM> lsHuyen = DiaBanQuanLyUtils.getHuyenInTramCap(maTinh, maTramCap, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	
	UserMapping userMapping = (UserMapping) renderRequest.getAttribute("userMapping");
	long userMappingId = ParamUtil.getLong(request, "userMappingId");
	if(userMapping == null && Validator.isNotNull(userMappingId)){
		userMapping = UserMappingBusiness.getUserMapping(userMappingId);
	} 
	
	long selUserId = 0;
	
	if (Validator.isNotNull(userMapping)) {
		selUserId = userMapping.getUserId();
	}
%>

<%
	for (DATAITEM huyen : lsHuyen) {
		List<DATAITEM> lsXa = 
				DiaBanQuanLyUtils.findXaKhongInHuyenInTramByUser(maTinh, huyen.getNode2(), maTramCap, selUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
%>

<c:choose>
	<c:when test="<%= lsXa.size() != 0 %>">
		<aui:input type="checkbox" value="<%= huyen.getNode2() %>" label="<%= huyen.getName() %>" cssClass="title" name='<%= maTramCap + "selMaHuyen" %>'/>
		
		<liferay-ui:panel collapsible="<%= true %>" extended="<%= false %>" persistState="<%= true %>" title="chon-dia-ban-huyen-quan-ly" helpMessage="neu-khong-chon-theo-xa-mac-dinh-quan-ly-toan-huyen" >
		
<%
		for (DATAITEM xa : lsXa) {
%>
			<div class="sel-xa">
				<aui:input type="checkbox" value="<%= xa.getNode3() %>" label="<%= xa.getName() %>" name='<%= huyen.getNode2() + "_selXa" %>'/>
			</div>
<%

		}
%>
		</liferay-ui:panel>
	</c:when>
	<c:otherwise>
		<div><liferay-ui:message key="toan-bo-dia-ban-huyen-da-duoc-chon"/></div>
	</c:otherwise>
</c:choose>

<%
	}
%>

