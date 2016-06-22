<%@page import="vn.dtt.cmon.user.dao.service.UserTinhLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.dm.dao.service.DATAITEMLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.DiaBanQuanLyUtils"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.business.DataItemBusiness"%>
<%@include file="../init.jsp" %>

<%
	String maTinh = ParamUtil.getString(request, "maTinh");
	long umId = ParamUtil.getLong(request, "umId");
	
%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value='<%= templatePath + "usertinh/render_huyen.jsp" %>'/>
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm2">
	
	<liferay-portlet:renderURLParams varImpl="searchURL" />
		
	<aui:fieldset>
		
		<liferay-ui:search-container rowChecker="<%= new RowChecker(renderResponse) %>" delta="<%= 100 %>" emptyResultsMessage="no-result-were-found" iteratorURL="<%= searchURL %>">
			
 			<liferay-ui:search-container-results results="<%= umId == 0 ? DATAITEMLocalServiceUtil.getByDataGroupLevel2(1, maTinh, searchContainer.getStart(), searchContainer.getEnd()) : DATAITEMLocalServiceUtil.getHuyenSelectByTinhUser(maTinh, umId, searchContainer.getStart(), searchContainer.getEnd()) %>"
								 total="<%= umId == 0 ? DATAITEMLocalServiceUtil.countByDataGroupLevel2(1, maTinh) : DATAITEMLocalServiceUtil.getHuyenSelectByTinhUser(maTinh, umId, QueryUtil.ALL_POS, QueryUtil.ALL_POS).size() %>">

			</liferay-ui:search-container-results>

 
 
 	<%-- 		<liferay-ui:search-container-results results="<%= umId == 0 ? DATAITEMLocalServiceUtil.getByDataGroupLevel2(1, maTinh, searchContainer.getStart(), searchContainer.getEnd()) : UserTinhLocalServiceUtil.getHuyenSelectByTinhAndUser(maTinh, umId, searchContainer.getStart(), searchContainer.getEnd()) %>"
								 total="<%= umId == 0 ? DATAITEMLocalServiceUtil.countByDataGroupLevel2(1, maTinh) : UserTinhLocalServiceUtil.getHuyenSelectByTinhAndUser(maTinh, umId, QueryUtil.ALL_POS, QueryUtil.ALL_POS).size() %>">

			</liferay-ui:search-container-results> --%>
 
			<liferay-ui:search-container-row
	 			className="vn.dtt.cmon.dm.dao.model.DATAITEM"
				keyProperty="node2"
				modelVar="huyen"
			>
			
				<liferay-ui:search-container-column-text
					name="ten-huyen"
					align="left"
					cssClass="col-small"
					property="name"
				/>
				
			</liferay-ui:search-container-row>
	
			<liferay-ui:search-iterator paginate="simple" />

		</liferay-ui:search-container>
	</aui:fieldset>
</aui:form>
