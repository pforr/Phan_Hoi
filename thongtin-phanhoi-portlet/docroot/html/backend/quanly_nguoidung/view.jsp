<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
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
	int userType = UserMappingBusiness.getUserType(user);
%>

<c:if test="<%= UserNSPermission.contains(permissionChecker, scopeGroupId, ActionKeys.PERMISSIONS) %>">
	<aui:button-row cssClass="bnt-add-entry" >

		<liferay-security:permissionsURL
			modelResource="vn.dtt.cmon.user.dao.model.UserMapping"
			modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
			resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
			var="userPerURL"
		/>
		
		
		<liferay-security:permissionsURL
			modelResource="vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh"
			modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
			resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
			var="dliPerURL"
		/>
				
		<aui:button href="<%= userPerURL %>" name="permissions" value="permissions" />
		
		<aui:button href="<%= dliPerURL %>" name="permissions" value="permissions" />
		
	</aui:button-row>
</c:if>
<c:if test="<%= userType==1 || userType==5 || userType==6|| userType==7 || userType==8 %>">
	<liferay-util:include page='<%= templatePath + "view_type/" + userType + ".jsp" %>' servletContext="<%= application %>" />
</c:if>
<%!
	private static Log _log = LogFactoryUtil.getLog("html.backend.quanly_nguoidung.view.jsp");
%>