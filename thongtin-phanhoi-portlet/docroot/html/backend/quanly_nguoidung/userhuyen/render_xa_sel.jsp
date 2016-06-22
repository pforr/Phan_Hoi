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
	
	List<DATAITEM> lsXa = DATAITEMLocalServiceUtil.findXaTrongHuyenChonByUser(maTinh, maHuyen, userIdSel, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
%>
	<aui:input type="hidden" name='<%= maHuyen + "_selXaDelIds" %>'  value="" />
<%
	for (DATAITEM xa : lsXa) {
%>

	<div class="sel-xa">
		<%-- <aui:input type="checkbox" value="<%= xa.getNode3() %>" label="<%= xa.getName() %>" name='<%= maHuyen + "_selXaDel" %>'/> --%>
		
		<input type="checkbox" value="<%=xa.getNode3() %>"  name='<%= maHuyen + "_selXaDel" %>' onclick="javascript:getUnSelectedChbox('<%=maHuyen%>');" /> 
				<%=xa.getName() %> 
		
	</div>

<%
	}
%>

<script type="text/javascript">

function getUnSelectedChbox(maHuyen) {
	var A = AUI();
	
	var selchbox = [];  
	
	var _selXaIds = A.one("#<portlet:namespace/>" + maHuyen+"_selXaDelIds");
	
	var cbs = document.getElementsByName(maHuyen + "_selXaDel");
	for(var i=0; i < cbs.length; i++) {
		if(cbs[i].type == 'checkbox' && cbs[i].checked == true) {
			selchbox.push(cbs[i].value);
		}
	}

	
	A.one("#<portlet:namespace/>" + maHuyen+"_selXaDelIds").set('value', selchbox);


}
</script>