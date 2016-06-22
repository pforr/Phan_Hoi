<%@page import="vn.dtt.cmon.dm.dao.service.DATAITEMLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.dm.dao.model.DATAITEM"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.DiaBanQuanLyUtils"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.business.DataItemBusiness"%>
<%@include file="../init.jsp" %>

<%
	String maTinh = ParamUtil.getString(request, "maTinh");
	String maHuyen = ParamUtil.getString(request, "maHuyen");
	long userIdSel = ParamUtil.getLong(request, "userIdSel");

	List<DATAITEM> lsXa = DATAITEMLocalServiceUtil.findHuyenDuocChonByUser(maTinh, maHuyen, userIdSel, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	
%>

<c:choose>
	<c:when test="<%= lsXa.size() != 0 %>">
		<aui:input type="hidden" name='<%= maHuyen + "_selXaIds" %>'  value="" />
		<%
			for (DATAITEM xa : lsXa) {
		%>
			
			<div class="sel-xa">
				<input type="checkbox" value="<%=xa.getNode3() %>"  name='<%= maHuyen + "_selXa" %>' onclick="javascript:getSelectedChbox('<%=maHuyen%>');" /> 
				<%=xa.getName() %>
			</div>
		
		<%
			}
		%>	
	</c:when>
	<c:otherwise>
		<liferay-ui:message key="toan-bo-xa-da-duoc-chon"/>
	</c:otherwise>
</c:choose>

<%--  label="<%= xa.getName() %>"  onclick="javascript:getSelectedChbox('<%=maHuyen%>');" --%>



<script type="text/javascript">

function getSelectedChbox(maHuyen) {
	var A = AUI();
	
	var selchbox = [];  
	
	var _selXaIds = A.one("#<portlet:namespace/>" + maHuyen+"_selXaIds");
	
	var cbs = document.getElementsByName(maHuyen + "_selXa");
	for(var i=0; i < cbs.length; i++) {
		if(cbs[i].type == 'checkbox' && cbs[i].checked == true) {
			selchbox.push(cbs[i].value);
		}
	}

	
	A.one("#<portlet:namespace/>" + maHuyen+"_selXaIds").set('value', selchbox);


}
</script>

