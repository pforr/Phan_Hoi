<%@page import="vn.dtt.cmon.dm.dao.service.DATAITEMLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.DiaBanQuanLyUtils"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.ActionKeys"%>
<%@page import="vn.dtt.ns.quanlynguoidung.permission.UserNSPermission"%>
<%@page import="vn.dtt.cmon.kiemdemvien.dao.service.KiemDemVienLocalServiceUtil"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.business.UserMappingBusiness"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.NuocSachUtils"%>
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


<c:if test="<%= UserNSPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADMIN_USER) %>">

	<liferay-ui:icon-menu direction="right" message="them-nguoi-dung">
		<liferay-portlet:renderURL var="addUserTU">
			<portlet:param name="mvcPath" value='<%= templatePath + "addUserTU.jsp" %>'/>
			<portlet:param name="backURL" value="<%= currentURL %>"/>
		</liferay-portlet:renderURL>
		
		<liferay-portlet:renderURL var="addUserTinh">
			<portlet:param name="mvcPath" value='<%= templatePath + "addUserTinh.jsp" %>'/>
			<portlet:param name="backURL" value="<%= currentURL %>"/>
		</liferay-portlet:renderURL>
		
		<liferay-portlet:renderURL var="addUserHuyen">
			<portlet:param name="mvcPath" value='<%= templatePath + "addUserHuyen.jsp" %>'/>
			<portlet:param name="backURL" value="<%= currentURL %>"/>
		</liferay-portlet:renderURL>
		
		<liferay-portlet:renderURL var="addUserTramCap">
			<portlet:param name="backURL" value="<%= currentURL %>"/>
			<portlet:param name="mvcPath" value='<%= templatePath + "addUserGTNuoc.jsp" %>'/>
		</liferay-portlet:renderURL>
		
		<liferay-ui:icon
			image="add"
			message="add-user-tu"
			url="<%= addUserTU %>"/>
		
		<liferay-ui:icon
			image="add"
			message="add-user-tinh"
			url="<%= addUserTinh %>"/>
		
<%-- 		<liferay-ui:icon
			image="add"
			message="add-user-huyen"
			url="<%= addUserHuyen %>"/>
		
		<liferay-ui:icon
			image="add"
			message="add-user-tram-cap"
			url="<%= addUserTramCap %>"/> --%>
		
	</liferay-ui:icon-menu>
</c:if>

	
<c:choose>
	<c:when test="<%= UserNSPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADMIN_USER) %>">
		<liferay-ui:success key="them-thanh-cong-nguoi-su-dung" message="them-thanh-cong-nguoi-su-dung"/>
		<liferay-ui:success key="cap-nhat-thanh-cong-nguoi-su-dung" message="cap-nhat-thanh-cong-nguoi-su-dung"/>
		
		<div class="header-user">
			<liferay-ui:message key="danh-sach-nguoi-dung-cap-trung-uong"/>
		</div>

		<liferay-portlet:renderURL varImpl="searchURL">
			<portlet:param name="mvcPath" value='<%= templatePath + "/type_view/1.jsp" %>'/>
		</liferay-portlet:renderURL>

		<aui:form action="<%= searchURL %>" method="get" name="fm2">
			<liferay-portlet:renderURLParams varImpl="searchURL" />
				
			<aui:fieldset>
				<liferay-ui:search-container delta="15" emptyResultsMessage="no-result-were-found">
					<liferay-ui:search-container-results
						results="<%= UserMappingBusiness.findUser(StringPool.BLANK, 1, StringPool.BLANK, StringPool.BLANK, searchContainer.getStart(), searchContainer.getEnd())%>"
						total="<%= UserMappingBusiness.countUser(StringPool.BLANK, 1, StringPool.BLANK, StringPool.BLANK) %>"
				/>
		
					<liferay-ui:search-container-row
			 			className="vn.dtt.cmon.user.dao.model.UserMapping"
						keyProperty="id"
						modelVar="usermapping"
					>
						<portlet:renderURL var="rowURL">
							<portlet:param name="mvcPath" value='<%= templatePath + "addUserTU.jsp" %>' />
							<portlet:param name="userMappingId" value="<%= String.valueOf(usermapping.getId()) %>"/>
							<portlet:param name="backURL" value="<%= currentURL %>"/>
						</portlet:renderURL>
						
						<liferay-ui:search-container-column-text
							name="name"
							href="<%= rowURL %>"
							property="name"
							cssClass="col-small"
						/>
						<liferay-ui:search-container-column-text
							name="tai-khoan"
							href="<%= rowURL %>"
							buffer="taikhoan"
							cssClass="col-small"
							
						>
							<%
								User userSys = null;
								try {
									userSys = UserLocalServiceUtil.fetchUser(usermapping.getUserId());
								} catch (Exception e) {
									
								}
								
								if (Validator.isNotNull(userSys)) {
									taikhoan = taikhoan.append(userSys.getScreenName());
								}
							%>
						</liferay-ui:search-container-column-text>
						
						<liferay-ui:search-container-column-text
							name="email"
							href="<%= rowURL %>"
							cssClass="col-small"
						>
							<%= NuocSachUtils.getEmailUser(usermapping) %>
						</liferay-ui:search-container-column-text>
						
						<liferay-ui:search-container-column-text
							name="quan-ly"
						>
							<ul>
								<%
									List<Role> selRoles = RoleLocalServiceUtil.getUserRoles(usermapping.getUserId());
									
									for (Role role : selRoles) {
								%>
									<c:if test='<%= !Validator.equals(role.getName(), "User") %>'>
										<li><%= role.getTitle(locale) %></li>
									</c:if>
								<%	
									}
								%>
							</ul>
						</liferay-ui:search-container-column-text>
						
					</liferay-ui:search-container-row>
			
					<liferay-ui:search-iterator />
		
				</liferay-ui:search-container>
			</aui:fieldset>
		</aui:form>

		<div class="header-user">
			<liferay-ui:message key="danh-sach-nguoi-dung-cap-tinh"/>
		</div>
		
		<aui:form action="<%= searchURL %>" method="get" name="fm2">
			
			<liferay-portlet:renderURLParams varImpl="searchURL" />
				
			<aui:fieldset>
				<liferay-ui:search-container delta="<%= 20 %>" emptyResultsMessage="no-result-were-found">
					
					<liferay-ui:search-container-results results="<%=  DATAITEMLocalServiceUtil.getListTinhTU(user, permissionChecker.isOmniadmin() ? true : false, searchContainer.getStart(), searchContainer.getEnd()) %>"
										 total="<%= DATAITEMLocalServiceUtil.countListTinhTU(user, permissionChecker.isOmniadmin() ? true : false) %>">
		
					</liferay-ui:search-container-results>
		
					<liferay-ui:search-container-row
			 			className="vn.dtt.cmon.dm.dao.model.DATAITEM"
						keyProperty="id"
						modelVar="tinh"
					>
						<liferay-portlet:renderURL var="rowURL">
							<portlet:param name="mvcPath" value='<%= templatePath + "view_type/6.jsp" %>'/>
							<portlet:param name="maTinh" value="<%=tinh.getNode1() %>"/>
							<portlet:param name="tenTinh" value="<%=tinh.getName() %>"/>
							<portlet:param name="backURL" value="<%= currentURL %>"/>
						</liferay-portlet:renderURL>
						
		
						<liferay-ui:search-container-column-text
							name="ten-tinh"
							href="<%= rowURL %>"
							align="left"
							cssClass="col-small"
						>
		
							<%= tinh.getName() %>
						</liferay-ui:search-container-column-text>
						
						<liferay-ui:search-container-column-text
							name="so-quan-ly"
							href="<%= rowURL %>"
							align="left"
							cssClass="col-small"
						>
							<%= UserMappingBusiness.countUser(StringPool.BLANK, 6, tinh.getNode1(), StringPool.BLANK) %>
						</liferay-ui:search-container-column-text>

						<liferay-ui:search-container-column-text
							name="so-gsv-nuoc"
							href="<%= rowURL %>"
							align="left"
							cssClass="col-small"
						>
							<%= UserMappingBusiness.countUser(StringPool.BLANK, 8, tinh.getNode1(), StringPool.BLANK) %>
						</liferay-ui:search-container-column-text>

						<liferay-ui:search-container-column-text
							name="so-gsv-ve-sinh"
							href="<%= rowURL %>"
							align="left"
							cssClass="col-small"
						>
							<%= UserMappingBusiness.countUser(StringPool.BLANK, 7, tinh.getNode1(), StringPool.BLANK) %>
						</liferay-ui:search-container-column-text>
						
<%-- 						<liferay-ui:search-container-column-text
							name="them-nguoi-dung"
							align="left"
						>
						</liferay-ui:search-container-column-text> --%>
						
					</liferay-ui:search-container-row>
			
					<liferay-ui:search-iterator />
		
				</liferay-ui:search-container>
			</aui:fieldset>
		</aui:form>
	</c:when>
	<c:otherwise>
		<liferay-ui:message key="ban-chua-phan-quyen-quan-ly-nguoi-dung"/>
	</c:otherwise>
</c:choose>

