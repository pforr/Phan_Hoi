<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="vn.dtt.cmon.user.dao.model.UserMapping"%>
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

<%@include file="init.jsp" %>

<%
	String[] CATEGORY_NAMES = new String[]{"basic-information", "dia-ban-quan-ly", "quyen-han"};
	
	String[] basic_information = new String[]{"basic"};
	String[] dia_ban_quan_ly = new String[]{"dia_ban_qly"};
	String[] quyen_han = new String[]{"quyen_han"};
	
	String[][] categorySections = {basic_information, dia_ban_quan_ly, quyen_han};
	
	UserMapping userMapping = (UserMapping) renderRequest.getAttribute("userMapping");
	
	long userMappingId = ParamUtil.getLong(request, "userMappingId");
	if(userMapping == null && Validator.isNotNull(userMappingId)){
		userMapping = UserMappingBusiness.getUserMapping(userMappingId);
	} 
	
	String maTinh = ParamUtil.getString(request, "maTinh");
%>

<liferay-ui:header
	backURL="<%= redirectURL %>"
	title='<%= Validator.isNotNull(userMapping) ? "edit-user-mapping-cap-huyen" : "add-user-mapping-cap-huyen" %>'
/>

<liferay-ui:error key="screen-name-khong-hop-le" message="screen-name-khong-hop-le" />
<liferay-ui:error key="full-name-khong-hop-le" message="full-name-khong-hop-le" />
<liferay-ui:error key="dia-chi-email-khong-hop-le" message="mat-khau-khong-trung-nhau" />
<liferay-ui:error key="mat-khau-khong-hop-le" message="mat-khau-khong-hop-le" />
<liferay-ui:error key="tai-khoan-da-ton-tai" message="tai-khoan-da-ton-tai" />

<portlet:actionURL var="formAction" name="addUserHuyen" />

<aui:form action="<%= formAction %>" method="post" name="fm">
	<aui:model-context bean="<%= userMapping %>" model="<%= UserMapping.class %>"></aui:model-context>
	<aui:input name="userMappingId" type="hidden" value="<%= Validator.isNotNull(userMapping) ? userMapping.getId() : StringPool.BLANK %>"/>
	<aui:input name="pageSuccessURL" type="hidden" value="<%= redirectURL %>"/>
	<aui:input name="pageErrorURL" type="hidden" value="<%= currentURL %>"/>
	<aui:input name="userType" type="hidden" value="7"/>
	<aui:input name="selTinh" type="hidden" value="<%= maTinh %>"/>
	<aui:input name="userId" type="hidden" value="<%= Validator.isNotNull(userMapping) ? userMapping.getUserId() : StringPool.BLANK %>"/>	
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Validator.isNotNull(userMapping) ? Constants.UPDATE : Constants.ADD %>"/>
	
	<div class="add-user-tramcap-wrapper">
		<liferay-ui:form-navigator
			categoryNames="<%= CATEGORY_NAMES %>"
			categorySections="<%= categorySections %>"
			jspPath="/html/backend/quanly_nguoidung/userhuyen/"
		/>
	</div>
</aui:form>