<%@page import="vn.dtt.ns.thongtinphanhoi.util.ActionKeys"%>
<%@page import="vn.dtt.ns.quanlynguoidung.permission.UserNSPermission"%>
<%@page import="vn.dtt.cmon.kiemdemvien.dao.service.KiemDemVienLocalServiceUtil"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.business.UserMappingBusiness"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.NuocSachUtils"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
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

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "1.jsp" %>'/>
</liferay-portlet:renderURL>

<c:if test="<%= UserNSPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADMIN_NUOCSACH) %>">
	
	<div class="header-kdv">
		<liferay-ui:message key="danh-sach-kiem-dem-vien-nuoc"/>
	</div>
	
	<aui:form action="<%= searchURL %>" method="get" name="fm2">
		
		<liferay-portlet:renderURLParams varImpl="searchURL" />
			
		<aui:fieldset>
			<liferay-ui:search-container delta="<%= 20 %>" emptyResultsMessage="no-result-were-found">
				
				<liferay-ui:search-container-results results="<%=  ListUtil.subList(NuocSachUtils.getDiaBanTU(user), searchContainer.getStart(), searchContainer.getEnd()) %>"
									 total="<%= NuocSachUtils.getDiaBanTU(user).size() %>">
	
				</liferay-ui:search-container-results>
	
				<liferay-ui:search-container-row
		 			className="vn.dtt.cmon.dm.dao.model.DATAITEM"
					keyProperty="id"
					modelVar="tinh"
				>
					<liferay-portlet:renderURL var="rowURL">
						<portlet:param name="mvcPath" value='<%= templatePath + "view_kdv_nuoc_by_tinh.jsp" %>'/>
						<portlet:param name="maTinh" value="<%=tinh.getNode1() %>"/>
						<portlet:param name="tenTinh" value="<%=tinh.getName() %>"/>
						<portlet:param name="capHoatDong" value="3"/>
						<portlet:param name="currentURL" value="<%= currentURL %>"/>
					</liferay-portlet:renderURL>
					
	
					<liferay-ui:search-container-column-text
						name="ten-tinh"
						href="<%= rowURL %>"
						align="left"
					>
	
						<%= tinh.getName() %>
					</liferay-ui:search-container-column-text>
					
					<liferay-ui:search-container-column-text
						name="so-kdv"
						href="<%= rowURL %>"
						align="left"
						cssClass="col-small"
					>
						<%= KiemDemVienLocalServiceUtil.countCTHTT("3", tinh.getNode1(), StringPool.BLANK, -1l) %>
					</liferay-ui:search-container-column-text>
					
					<liferay-ui:search-container-column-text
						name="so-gsv"
						href="<%= rowURL %>"
						align="left"
						cssClass="col-small"
					>
						<%= UserMappingBusiness.countUser(StringPool.BLANK, 4, tinh.getNode1(), StringPool.BLANK) %>
					</liferay-ui:search-container-column-text>
					
				</liferay-ui:search-container-row>
		
				<liferay-ui:search-iterator />
	
			</liferay-ui:search-container>
		</aui:fieldset>
	</aui:form>
</c:if>

<c:if test="<%= UserNSPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADMIN_VESINH) %>">

	<div class="header-kdv">
		<liferay-ui:message key="kdv-ve-sinh-danh-sach-tinh"/>
	</div>
	
	<aui:form action="<%= searchURL %>" method="get" name="fm3">
		
		<liferay-portlet:renderURLParams varImpl="searchURL" />
			
		<aui:fieldset>
			<liferay-ui:search-container delta="<%= 20 %>" emptyResultsMessage="no-result-were-found">
				
				<liferay-ui:search-container-results results="<%=  ListUtil.subList(NuocSachUtils.getDiaBanTU(user), searchContainer.getStart(), searchContainer.getEnd()) %>"
									 total="<%= NuocSachUtils.getDiaBanTU(user).size() %>">
	
				</liferay-ui:search-container-results>
	
				<liferay-ui:search-container-row
		 			className="vn.dtt.cmon.dm.dao.model.DATAITEM"
					keyProperty="id"
					modelVar="tinh"
				>
					<liferay-portlet:renderURL var="rowURL">
						<portlet:param name="mvcPath" value='<%= templatePath + "view_kdv_nuoc_by_tinh.jsp" %>' />
						<portlet:param name="maTinh" value="<%=tinh.getNode1() %>"/>
						<portlet:param name="currentURL" value="<%= currentURL %>"/>
						<portlet:param name="capHoatDong" value="2"/>
					</liferay-portlet:renderURL>
					
	
					<liferay-ui:search-container-column-text
						name="ten-tinh"
						href="<%= rowURL %>"
						align="left"
					>
	
						<%= tinh.getName() %>
					</liferay-ui:search-container-column-text>
					
					<liferay-ui:search-container-column-text
						name="so-kdv"
						href="<%= rowURL %>"
						align="left"
						cssClass="col-small"
					>
						<%= KiemDemVienLocalServiceUtil.countCTHTT("2", tinh.getNode1(), StringPool.BLANK, -1l) %>
					</liferay-ui:search-container-column-text>
					
					<liferay-ui:search-container-column-text
						name="so-gsv"
						href="<%= rowURL %>"
						align="left"
						cssClass="col-small"
					>
						<%= UserMappingBusiness.countUser(StringPool.BLANK, 3, tinh.getNode1(), StringPool.BLANK) %>
					</liferay-ui:search-container-column-text>
	
				</liferay-ui:search-container-row>
		
				<liferay-ui:search-iterator />
	
			</liferay-ui:search-container>
		</aui:fieldset>
	</aui:form>

</c:if>