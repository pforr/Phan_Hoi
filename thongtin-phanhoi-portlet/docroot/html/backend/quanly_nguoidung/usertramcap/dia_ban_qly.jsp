<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.business.DataItemBusiness"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.NuocSachUtils"%>
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

<%@include file="../init.jsp"%>

<%
	// Ma tinh truyen vao voi nguoi dung cap Tinh
	String maTinh = ParamUtil.getString(request, "maTinh");

	UserMapping userMapping = (UserMapping) renderRequest.getAttribute("userMapping");
	long userMappingId = ParamUtil.getLong(request, "userMappingId");
	if(userMapping == null && Validator.isNotNull(userMappingId)){
		userMapping = UserMappingBusiness.getUserMapping(userMappingId);
	} 
		 
	long selUserId = 0;
	
	if (Validator.isNotNull(userMapping)) {
		selUserId = userMapping.getId();
	}
		 
	List<TramCapNuoc> lsTramCapDaChon = new ArrayList<TramCapNuoc>();
	
	if(Validator.isNotNull(userMapping)) {
		lsTramCapDaChon = DiaBanQuanLyUtils.getListTramCap(UserMappingBusiness.getUser(selUserId) , maTinh, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

%>

<c:if test="<%= lsTramCapDaChon.size() != 0 %>">
	<div class="header-um">
		<liferay-ui:message key="danh-sach-tram-cap-da-chon" />
	</div>
	
	<div class="selected-huyen">
		<table>
			<%
				for (TramCapNuoc tramCap : lsTramCapDaChon) {
			%>
			<tr>
				<td class="col-action">
					<aui:input name="tramCapIds" type="checkbox" value="<%= Long.toString(tramCap.getId()) %>" label="<%= StringPool.BLANK %>"/>
				</td>
				<td>
					<%= tramCap.getTenTram() %> 
						<liferay-util:include page="/html/backend/quanly_nguoidung/usertramcap/render_huyen_xa_sel.jsp" servletContext="<%= application %>">
							<liferay-util:param name="maTinh" value="<%= maTinh %>" />
							<liferay-util:param name="maTramCap" value="<%= Long.toString(tramCap.getId()) %>" />
						</liferay-util:include></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</c:if>

<div class="header-um">
	<liferay-ui:message key="chon-dia-ban-quan-ly" />
</div>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "usertramcap/dia_ban_qly.jsp" %>' />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm2">

	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<aui:fieldset>
		<liferay-ui:search-container rowChecker="<%= new RowChecker(renderResponse) %>" delta="<%= 100 %>" emptyResultsMessage="no-result-were-found" iteratorURL="<%= searchURL %>">

			<liferay-ui:search-container-results 
						results="<%= DiaBanQuanLyUtils.getTramCap(user, maTinh, permissionChecker.isOmniadmin(), searchContainer.getStart(), searchContainer.getEnd())%>"
						total="<%= DiaBanQuanLyUtils.getTramCap(user, maTinh, permissionChecker.isOmniadmin(), searchContainer.getStart(), searchContainer.getEnd()).size() %>">
			</liferay-ui:search-container-results>

			<liferay-ui:search-container-row className="vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc" keyProperty="id" modelVar="tramCap">

				<liferay-ui:search-container-column-text name="ten-tram-cap" align="left" cssClass="col-small">
					<%=tramCap.getTenTram()%>
					
					<liferay-util:include page="/html/backend/quanly_nguoidung/usertramcap/render_huyen_xa.jsp" servletContext="<%=application%>">
						<liferay-util:param name="maTinh" value="<%=maTinh%>" />
						<liferay-util:param name="maTramCap" value="<%=Long.toString(tramCap.getId())%>" />
					</liferay-util:include>

				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="simple" />

		</liferay-ui:search-container>
	</aui:fieldset>
</aui:form>

<script type="text/javascript">
	function toggle(source, className) {
		checkboxes = document.getElementsByClassName(className);
		
		if (source.checked) {
			for (var i = 0; i < checkboxes.length; i++) {
				if (checkboxes[i].type == 'checkbox') {
					checkboxes[i].checked = true;
				}
			}
		} else {
			for (var i = 0; i < checkboxes.length; i++) {
				console.log(i)
				if (checkboxes[i].type == 'checkbox') {
					checkboxes[i].checked = false;
				}
			}
		}
	}
</script>