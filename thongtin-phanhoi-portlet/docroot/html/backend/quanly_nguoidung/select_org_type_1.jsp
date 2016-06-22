<%@page import="com.liferay.portal.model.User"%>
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
	UserMapping userMapping = null;
	
	long id = ParamUtil.getLong(request, QuanLyNguoiDungAction.ID);

	User selUser = null;
	
	List<Role> roles = new ArrayList<Role>();
	
	int userType = 0;
	
	String capTinh = "0";
	
	if (Validator.isNotNull(userMapping)) {
		userType = userMapping.getUserType();
		
		try {
			selUser = UserLocalServiceUtil.getUser(userMapping.getUserId());
			roles = RoleLocalServiceUtil.getUserRoles(selUser.getUserId());
		} catch (Exception e) {
		}
	}
	
	List<DATAITEM> listTinh = DATAITEMLocalServiceUtil.getByDataGroupLevel1(1);
	
	List<DATAITEM> listHuyen = new ArrayList<DATAITEM>();
	
	List<TramCapNuoc> listTramCap = new ArrayList<TramCapNuoc>();
%>


	<aui:select name="<%= QuanLyNguoiDungAction.USER_TYPE %>" id="userType" showEmptyOption="<%= true %>" helpMessage="gioi-thieu-cach-chon-cap">
		<aui:option value="1" selected='<%= userType == 1 %>'><liferay-ui:message key="cap-trung-uong"/></aui:option>
		<aui:option value="2" selected='<%= userType == 2 %>'><liferay-ui:message key="cap-tinh"/></aui:option>
		<aui:option value="3" selected='<%= userType == 3 %>'><liferay-ui:message key="cap-huyen"/></aui:option>
		<aui:option value="4" selected='<%= userType == 4 %>'><liferay-ui:message key="cap-tram-cap"/></aui:option>
	</aui:select>
	
	<aui:fieldset id="optCapTinh">
		<aui:select name="capTinh" showEmptyOption="<%= true %>" id="capTinh" inlineField="<%= true %>">
			<%
				for (DATAITEM tinh : listTinh) {
			%>
				<aui:option value="<%= tinh.getNode1() %>"><%= tinh.getName() %></aui:option>
			<%
				}
			%>
		</aui:select>
	</aui:fieldset>
	
	<aui:fieldset id="optCapHuyen">
		<aui:select name="capHuyen" id="capHuyen" showEmptyOption="<%= true %>" inlineField="<%= true %>">
		</aui:select>
	</aui:fieldset>
	
	<aui:fieldset id="optCapTram" >
		<aui:select name="capTram" id="capTram" inlineField="<%= true %>" showEmptyOption="<%= true %>">
	
		</aui:select>
	</aui:fieldset>
	
<portlet:resourceURL var="callResourceURL" >
	<portlet:param name="mvcPath" value="/html/backend/quanly_nguoidung/_blank.jsp"/>
</portlet:resourceURL>

<script type="text/javascript">
	AUI().ready(function(A){
		
		var userType = '<%= userType %>';
		var userTypeInput = A.one("#<portlet:namespace/>userType");
		
		var capTinhInput = A.one("#<portlet:namespace/>capTinh");

		capTinhInput.on('change', function(){
			var capTinhId = capTinhInput.val();
			var userTypeId = userTypeInput.val();
			ajaxRequest(capTinhId, userTypeId);
		});
		
		<portlet:namespace/>loadingDialogState(userType);
		
		userTypeInput.on('change', function(){
			var value = userTypeInput.val();
			<portlet:namespace />loadingDialogState(value);
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
								document.<portlet:namespace />fm.<portlet:namespace />capHuyen.options[index+1] = new Option(obj.nameHuyen,obj.idHuyen);
							});
						} else {
							document.<portlet:namespace />fm.<portlet:namespace/>capTram.options.length=0;
							
							A.Array.each(data, function(obj, index){
								document.<portlet:namespace />fm.<portlet:namespace />capTram.options[index+1] = new Option(obj.nameTramCap,obj.idTramCap);
							});
						}
					}
				}
			});
		});
	}

	Liferay.provide(window, '<portlet:namespace/>loadingDialogState',

	function(
			value) {
		var A = AUI();

		var capTinh = A.one('#<portlet:namespace/>optCapTinh');
		var capHuyen = A.one('#<portlet:namespace/>optCapHuyen');
		var capTramCap = A.one('#<portlet:namespace/>optCapTram');

		if (value == '2') {
			capTinh.show();
			capHuyen.hide();
			capTramCap.hide();
		} else if (value == '3') {
			capTinh.show();
			capHuyen.show();
			capTramCap.hide();
		} else if (value == '4') {
			capTinh.show();
			capHuyen.hide();
			capTramCap.show();
		} else {
			capTinh.hide();
			capHuyen.hide();
			capTramCap.hide();
		}
	});
</script>