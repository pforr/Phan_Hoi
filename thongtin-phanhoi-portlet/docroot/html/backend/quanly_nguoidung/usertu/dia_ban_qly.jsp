<%@page import="vn.dtt.cmon.dm.dao.service.DATAITEMLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="vn.dtt.cmon.user.dao.model.UserMapping"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.DiaBanQuanLyUtils"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>
<%
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>

<%@include file="../init.jsp" %>

<%
	List<DATAITEM> lsTinhQuanLy = DATAITEMLocalServiceUtil.getListTinhTU(user, isSupperAdmin, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	
	List<DATAITEM> lsSelTinh = new ArrayList<DATAITEM>();
		 
	UserMapping userMapping = (UserMapping) renderRequest.getAttribute("userMapping");
	long userMappingId = ParamUtil.getLong(request, "userMappingId");
	if(userMapping == null && Validator.isNotNull(userMappingId)){
		userMapping = UserMappingBusiness.getUserMapping(userMappingId);
	} 
	User selUser = null;
	
	if (Validator.isNotNull(userMapping)) {
		selUser = UserMappingBusiness.getUser(userMapping.getId());
		lsSelTinh = DiaBanQuanLyUtils.getListTinhTU(selUser, false, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}
%>
<div class="header-um">
	<liferay-ui:message key="chon-dia-ban-quan-ly"/>
</div>

<%
	for (DATAITEM tinh : lsTinhQuanLy) {
		
		//DiaBanQuanLyUtils util = new DiaBanQuanLyUtils();
		boolean isChecked = DATAITEMLocalServiceUtil.checkTinhContains(tinh.getNode1(), lsSelTinh);
		
%>
	<aui:input name="orgCode1" checked="<%= isChecked ? true : false %>" type="checkbox" value="<%= tinh.getNode1() %>" label="<%= tinh.getName() %>"></aui:input>
<%
	}
%>

