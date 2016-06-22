<%@page import="vn.dtt.ns.thongtinphanhoi.business.UserMappingBusiness"%>
<%@page import="vn.dtt.ns.quanlynguoidung.QuanLyNguoiDungAction"%>
<%@page import="vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc"%>
<%@page import="vn.dtt.cmon.dm.dao.service.DATAITEMLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.security.membershippolicy.RoleMembershipPolicyUtil"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.PortletKeys"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.PortletPropsValues"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.MessageErrors"%>
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

<%@include file="/html/init.jsp" %>

<%
	// lay thong tin userMapping cua nguoi dang nhap
	UserMapping userMapping = UserMappingBusiness.getUserMapping(user);
	
	int userType = UserMappingBusiness.getUserType(user);
		 
	String capTinh = StringPool.BLANK;
	
	// ma cap tinh mac dinh
	if (Validator.isNotNull(userMapping)) {
		capTinh = userMapping.getOrgCode1();
	}

	String selCapHuyen = ParamUtil.getString(request, "capHuyen");

	String selCapTram = ParamUtil.getString(request, "capTram");
	
%>

<portlet:resourceURL var="callResourceURL" id="searchType2">
	<portlet:param name="mvcPath" value="/html/backend/quanly_nguoidung/_blank.jsp"/>
</portlet:resourceURL>

<liferay-portlet:renderURL varImpl="userSearchURL">
	<portlet:param name="mvcPath" value="/html/backend/quanly_nguoidung/view.jsp"/>
</liferay-portlet:renderURL>

<aui:field-wrapper cssClass="search-form">
	<aui:form action="<%= userSearchURL %>" method="post" name="fm">
		<aui:row cssClass="row-search">
				<aui:col width="25">
					<aui:input name="keyword" type="text"/>
				</aui:col>
				<aui:col width="25">
					<aui:select name="userType" id="userType" showEmptyOption="<%= true %>" helpMessage="gioi-thieu-cach-chon-cap">
						<aui:option value="3" selected='<%= userType == 3 %>'><liferay-ui:message key="cap-huyen"/></aui:option>
						<aui:option value="4" selected='<%= userType == 4 %>'><liferay-ui:message key="cap-tram-cap"/></aui:option>
					</aui:select>
				</aui:col>

				<aui:col width="25" id="formCapHuyen">
					<aui:select name="capHuyen" id="capHuyen" showEmptyOption="<%= true %>" inlineField="<%= true %>">
					</aui:select>
				</aui:col>
				<aui:col width="25" id="formCapTram">
					<aui:select name="capTram" id="capTram" showEmptyOption="<%= true %>" inlineField="<%= true %>">
	
					</aui:select>
				</aui:col>
		</aui:row>
		
		<aui:row cssClass="row-field">
			<aui:col width="100">
				<aui:button-row>
					<aui:button name="search" type="submit" value="search"/>
				</aui:button-row>
			</aui:col>
		</aui:row>
	</aui:form>
</aui:field-wrapper>

<script type="text/javascript">
	AUI().ready(function(A){
		// gia tri khoi tao cua UserType
		var userType = '<%= userType %>';
		var userTypeInput = A.one("#<portlet:namespace/>userType");

		// khi userType co gi tri, formSearch hien thi theo userType nay 
		if (userTypeInput.val() != '0') {
			userType = userTypeInput.val();
		}
		
		<portlet:namespace/>loadingSearchForm(userType);

		ajaxRequest('<%= capTinh %>', userTypeInput.val());

		userTypeInput.on('change', function(){
			var userTypeId = userTypeInput.val();
			ajaxRequest('<%= capTinh %>', userTypeId);
		});
		
		
		userTypeInput.on('change', function(){
			var value = userTypeInput.val();
			<portlet:namespace />loadingSearchForm(value);
		});
		
	});
	
	function ajaxRequest(capTinhId, userTypeId){
		AUI().use('aui-base','aui-io-request', function(A){
			//aui ajax call to get updated content
			A.io.request('<%= callResourceURL %>',
			{
				dataType: 'json',
				method: 'GET',
				data: { 
					"<portlet:namespace />capTinhId": capTinhId,
					"<portlet:namespace />userType": userTypeId
				},
				on: {
					success: function() {
						var data = this.get('responseData');
						if (userTypeId == '3') {
							document.<portlet:namespace />fm.<portlet:namespace/>capHuyen.options.length=0;
							
							A.Array.each(data, function(obj, index){
								
								// kiem tra truong hop da select
								if (obj.idHuyen == '<%= selCapHuyen %>') {
									document.<portlet:namespace />fm.<portlet:namespace />capHuyen.options[index+1] = new Option(obj.nameHuyen, obj.idHuyen, false, true);
								} else {
									document.<portlet:namespace />fm.<portlet:namespace />capHuyen.options[index+1] = new Option(obj.nameHuyen,obj.idHuyen);					
								}
							});
							
						} else {
							document.<portlet:namespace />fm.<portlet:namespace/>capTram.options.length=0;
							
							A.Array.each(data, function(obj, index){
								if (obj.idTramCap == '<%= selCapTram %>') {
									document.<portlet:namespace />fm.<portlet:namespace />capTram.options[index+1] = new Option(obj.nameTramCap,obj.idTramCap,false, true);
								} else {
									document.<portlet:namespace />fm.<portlet:namespace />capTram.options[index+1] = new Option(obj.nameTramCap,obj.idTramCap);									
								}
							});
						}
					}
				}
			});
		});
	}

	Liferay.provide(window, '<portlet:namespace/>loadingSearchForm',

	function(value) {
		var A = AUI();

		var capHuyen = A.one('#<portlet:namespace/>formCapHuyen');
		var capTramCap = A.one('#<portlet:namespace/>formCapTram');
		
		if (value == '3') {
			capHuyen.show();
			capTramCap.hide();
		} else if (value == '4') {
			capHuyen.hide();
			capTramCap.show();
		} else {
			capHuyen.hide();
			capTramCap.hide();
		}
	});
</script>

