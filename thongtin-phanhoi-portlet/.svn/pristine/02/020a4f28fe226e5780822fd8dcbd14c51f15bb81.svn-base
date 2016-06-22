<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.security.membershippolicy.RoleMembershipPolicyUtil"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.user.dao.model.UserMapping"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
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
	List<Role> selRoles = new ArrayList<Role>();
		 
	User selUser = null;
		 
	UserMapping userMapping = (UserMapping) renderRequest.getAttribute("userMapping");
	
	long userMappingId = ParamUtil.getLong(request, "userMappingId");
	if(userMapping == null && Validator.isNotNull(userMappingId)){
		userMapping = UserMappingBusiness.getUserMapping(userMappingId);
	} 
	
	if (Validator.isNotNull(userMapping)) {
		try {
			selRoles = RoleLocalServiceUtil.getUserRoles(userMapping.getUserId());
			selUser = UserMappingBusiness.getUser(userMapping.getId());
		} catch (Exception e) {
			
		}
	}
	
%>


<liferay-util:buffer var="removeRoleIcon">
	<liferay-ui:icon
		image="unlink"
		label="<%= true %>"
		message="remove"
	/>
</liferay-util:buffer>


<liferay-ui:error-marker key="errorSection" value="roles" />

<liferay-ui:membership-policy-error />

<liferay-ui:message key="selete-regular-roles" />

<liferay-ui:search-container
	headerNames="title,null"
	id="rolesSearchContainer"
>
	<liferay-ui:search-container-results
		results="<%= selRoles %>"
		total="<%= selRoles.size() %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.portal.model.Role"
		keyProperty="roleId"
		modelVar="role"
	>

		<liferay-ui:search-container-column-text
			name="title"
			value="<%= HtmlUtil.escape(role.getTitle(locale)) %>"
		/>
		
		<c:if test="<%= !RoleMembershipPolicyUtil.isRoleRequired(selUser.getUserId(), role.getRoleId()) %>">
			<liferay-ui:search-container-column-text>
				<a class="modify-link" data-rowId="<%= role.getRoleId() %>" href="javascript:;"><%= removeRoleIcon %></a>
			</liferay-ui:search-container-column-text>
		</c:if>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="<%= false %>" />
</liferay-ui:search-container>

<liferay-ui:icon
	cssClass="modify-link"
	iconCssClass="icon-search"
	id="selectRegularRoleLink"
	label="<%= true %>"
	linkCssClass="btn"
	message="select"
	method="get"
	url="javascript:;"
/>

<aui:script use="aui-base">
	A.one('#<portlet:namespace />selectRegularRoleLink').on(
		'click',
		function(event) {
			Liferay.Util.selectEntity(
				{
					dialog: {
						constrain: true,
						modal: true,
						width: 600
					},
					id: '<portlet:namespace />selectRegularRole',
					title: '<liferay-ui:message arguments="regular-role" key="select-x" />',
					uri: '<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/html/backend/quanly_nguoidung/select_regular_role.jsp" /><portlet:param name="p_u_i_d" value='<%= (selUser == null) ? "0" : String.valueOf(selUser.getUserId()) %>' /></portlet:renderURL>'
				},
				function(event) {
					<portlet:namespace />selectRole(event.roleid, event.roletitle, event.searchcontainername, event.groupdescriptivename, event.groupid);
				}
			);
		}
	);
</aui:script>


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

