<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.NuocSachUtils"%>
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
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
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

	String initCapTinh = StringPool.BLANK;
	String initCapHuyen = StringPool.BLANK;
	String initCapTram = StringPool.BLANK;

	List<DATAITEM> listTinh = DATAITEMLocalServiceUtil.getByDataGroupLevel1(1);
	
	List<DATAITEM> listHuyen = new ArrayList<DATAITEM>();
	
	List<TramCapNuoc> listTramCap = new ArrayList<TramCapNuoc>();

	long selUserMappingId = ParamUtil.getLong(request, QuanLyNguoiDungAction.ID);
	
	// UserMapping chon de sua thong tin
	UserMapping selUserMapping = UserMappingBusiness.getUserMapping(selUserMappingId);
	
	// UserMapping cuar User dang nhap vao he thong
	// null: nguoi khong duoc mapping
	UserMapping loginUserMapping = UserMappingBusiness.getUserMapping(user);
	
	User selUser = UserMappingBusiness.getUser(selUserMappingId);
	
	List<Role> selRoles = new ArrayList<Role>();
	
	// userType xac dinh nguoi dang nhap vao thuc hien ADD/UPDATE user
	int userType = 0;
	
	userType = UserMappingBusiness.getUserType(user);
	
	if (Validator.isNotNull(selUser)) {
		try {
			selRoles = RoleLocalServiceUtil.getUserRoles(selUser.getUserId());
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	
%>

<liferay-ui:header
	backURL="<%= redirectURL %>"
	title='<%= (selUserMapping == null) ? "add-user-mapping" : "edit-user-mapping" %>'
/>


<portlet:resourceURL var="callResourceURL" >
	<portlet:param name="mvcPath" value="/html/backend/quanly_nguoidung/_blank.jsp"/>
</portlet:resourceURL>

<portlet:actionURL name="addUserMapping" var="addUserMappingURL"/>


<portlet:renderURL var="errorPageURL">
	<portlet:param name="mvcPath" value="/html/backend/quanly_nguoidung/add_user.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="successPageURL">
	<portlet:param name="mvcPath" value="/html/backend/quanly_nguoidung/view.jsp"/>
</portlet:renderURL>

<liferay-util:buffer var="removeRoleIcon">
	<liferay-ui:icon
		image="unlink"
		label="<%= true %>"
		message="remove"
	/>
</liferay-util:buffer>

<aui:form action="<%= addUserMappingURL %>" method="post" name="fm">
	<aui:model-context bean="<%= selUserMapping %>" model="<%= UserMapping.class %>" />

	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Validator.isNotNull(selUserMapping) ? Constants.UPDATE : Constants.ADD %>"/>
	<aui:input name="redirect" type="hidden" value="<%= StringPool.BLANK %>" />
	<aui:input name="currentURL" type="hidden" value="<%= StringPool.BLANK %>" />
	<aui:input name="onpageError" type="hidden" value="<%= errorPageURL %>"/>
	<aui:input name="onpageSuccess" type="hidden" value="<%= successPageURL %>"/>	
	<aui:input name="id" type="hidden" value="<%= selUserMappingId %>" />
	<aui:input name="userId" type="hidden" value="<%= Validator.isNotNull(selUser) ? selUser.getUserId() : StringPool.BLANK %>" />

	<liferay-ui:error key="<%= MessageErrors.EMPTY_USER_LIFERAY %>" message="<%= MessageErrors.EMPTY_USER_LIFERAY %>" />
	<liferay-ui:error key="<%= MessageErrors.EMPTY_USER_TYPE %>" message="<%= MessageErrors.EMPTY_USER_TYPE %>" />
	
	<aui:field-wrapper>
		<aui:row cssClass="fm-adduser">
			<aui:col width="50">
				<aui:input name="screenName" label="user-name" type="text" value="<%= Validator.isNotNull(selUser) ? selUser.getScreenName() : StringPool.BLANK  %>" cssClass="lfr-input-text">
					<aui:validator name="required" />
				</aui:input>
				
				<aui:input name="fullName" type="text" label="full-name" value="<%= Validator.isNotNull(selUserMapping) ? selUserMapping.getName() : StringPool.BLANK %>" cssClass="lfr-input-text">
					<aui:validator name="required" />
				</aui:input>
				
				<aui:input name="emailAddress" type="text" value="<%= Validator.isNotNull(selUser) ? selUser.getEmailAddress() : StringPool.BLANK  %>" label="email-address" cssClass="lfr-input-text">
					<aui:validator name="email" />
				</aui:input>
				
				<c:if test="<%= Validator.isNull(selUser) %>">
					<aui:input name="password1" type="password" label="password" cssClass="lfr-input-text">
						<aui:validator name="required" />
					</aui:input>
	
					<aui:input name="password2" type="password" label="re-password" cssClass="lfr-input-text">
	 					<aui:validator name="equalTo">'#<portlet:namespace />password1'</aui:validator>
					</aui:input>
				</c:if>
			</aui:col>
			
			<aui:col width="50">
				<c:choose>
					<c:when test="<%= Validator.isNull(selUserMapping) %>">
						<c:choose>
							<c:when test="<%= userType == 1 || permissionChecker.isOmniadmin() %>">
								<liferay-util:include page="/html/backend/quanly_nguoidung/select_org_type_1.jsp" servletContext="<%=this.getServletContext() %>" />
							</c:when>
							
							<c:when test="<%= userType == 2 %>">
								<liferay-util:include page="/html/backend/quanly_nguoidung/select_org_type_2.jsp" servletContext="<%= this.getServletContext() %>" />
							</c:when>
							
							<c:otherwise>
								<aui:input name="capTinh" type="hidden" value="<%= initCapTinh %>" />
								<aui:input name="capHuyen" type="hidden" value="<%= initCapHuyen %>" />
								<aui:input name="capTram" type="hidden" value="<%= initCapTram %>" />
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<aui:input name="dsType" disabled="true" type="text" value="<%= selUserMapping.getUserType() %>"/>
						
						<c:if test="<%= selUserMapping.getOrgCode1() != null && !selUserMapping.getOrgCode1().contentEquals(StringPool.BLANK) %>">
							<aui:input name="dsTinh" disabled="true" type="text" value="<%= NuocSachUtils.getNameTinh(selUserMapping.getOrgCode1()) %>"/>
						</c:if>
						
						<c:if test="<%= selUserMapping.getUserType() == 3 && selUserMapping.getOrgCode2() != null && !selUserMapping.getOrgCode2().contentEquals(StringPool.BLANK) %>">
							<aui:input name="dsHuyen" disabled="true" type="text" value="<%= selUserMapping.getOrgCode2() %>"/>
						</c:if>
						
						<c:if test="<%= selUserMapping.getUserType() == 4 && selUserMapping.getOrgCode2() != null && !selUserMapping.getOrgCode2().contentEquals(StringPool.BLANK) %>">
							<aui:input name="dsXa" disabled="true" type="text" value="<%= selUserMapping.getOrgCode2() %>"/>
						</c:if>
					</c:otherwise>
				</c:choose>
				<aui:fieldset>
					<!-- Add role -->
					<%@ include file="/html/backend/quanly_nguoidung/select_role.jspf" %>
				</aui:fieldset>
			</aui:col>
		</aui:row>
		
		<aui:row cssClass="fm-button">	
			<aui:col width="100">
				<aui:button-row>
					<aui:button type="submit" value="save"/>
					<aui:button href="<%= redirectURL %>" name="cancel" type="cancel" />
				</aui:button-row>
			</aui:col>
		</aui:row>
	</aui:field-wrapper>

</aui:form>

<script type="text/javascript">
	AUI().ready(function(A){
		
		var userType = '<%= userType %>';
		var userTypeInput = A.one("#<portlet:namespace/>userType");
		
		var capTinhInput = A.one("#<portlet:namespace/>capTinh");

		var hasSelUserMapping = '<%= Validator.isNull(selUserMapping) %>';
		
		
		if (hasSelUserMapping == 'true') {
			
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
		
		}
		
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

<aui:script>
	function <portlet:namespace />deleteGroupRole(roleId, groupId) {
		for (var i = 0; i < <portlet:namespace />groupRolesRoleIds.length; i++) {
			if ((<portlet:namespace />groupRolesRoleIds[i] == roleId) && (<portlet:namespace />groupRolesGroupIds[i] == groupId)) {
				<portlet:namespace />groupRolesGroupIds.splice(i, 1);
				<portlet:namespace />groupRolesRoleIds.splice(i, 1);
	
				break;
			}
		}
	
		document.<portlet:namespace />fm.<portlet:namespace />groupRolesGroupIds.value = <portlet:namespace />groupRolesGroupIds.join(',');
		document.<portlet:namespace />fm.<portlet:namespace />groupRolesRoleIds.value = <portlet:namespace />groupRolesRoleIds.join(',');
	}
	
	Liferay.provide(
		window,
		'<portlet:namespace />selectRole',
		function(roleId, name, searchContainer, groupName, groupId) {
			var A = AUI();
	
			var searchContainerName = '<portlet:namespace />' + searchContainer + 'SearchContainer';
	
			searchContainer = Liferay.SearchContainer.get(searchContainerName);
	
			var rowColumns = [];
	
			rowColumns.push(A.Escape.html(name));
	
			if (groupName) {
				rowColumns.push(A.Escape.html(groupName));
			}
	
			if (groupId) {
				rowColumns.push('<a class="modify-link" data-groupId="' + groupId + '" data-rowId="' + roleId + '" href="javascript:;"><%= UnicodeFormatter.toString(removeRoleIcon) %></a>');
	
				<portlet:namespace />groupRolesRoleIds.push(roleId);
				<portlet:namespace />groupRolesGroupIds.push(groupId);
	
				document.<portlet:namespace />fm.<portlet:namespace />groupRolesRoleIds.value = <portlet:namespace />groupRolesRoleIds.join(',');
				document.<portlet:namespace />fm.<portlet:namespace />groupRolesGroupIds.value = <portlet:namespace />groupRolesGroupIds.join(',');
			}
			else {
				rowColumns.push('<a class="modify-link" data-rowId="' + roleId + '" href="javascript:;"><%= UnicodeFormatter.toString(removeRoleIcon) %></a>');
			}
	
			searchContainer.addRow(rowColumns, roleId);
			searchContainer.updateDataStore();
		},
		['liferay-search-container', 'escape']
	);
</aui:script>

<aui:script use="liferay-search-container">
	var searchContainer = Liferay.SearchContainer.get('<portlet:namespace />rolesSearchContainer');
	
	searchContainer.get('contentBox').delegate(
		'click',
		function(event) {
			var link = event.currentTarget;
			var tr = link.ancestor('tr');
	
			searchContainer.deleteRow(tr, link.getAttribute('data-rowId'));
		},
		'.modify-link'
	);
</aui:script>

<%!
	private static final Log _log = LogFactoryUtil.getLog("html.portlet.usermapping.add_usermapping.jsp"); 
%>