<%@page import="java.util.HashMap"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.LSTORE"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiLocalServiceUtil"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@include file="/html/init.jsp" %>

<%
List<TopicPhanHoi> listTopicPhanHoi = new ArrayList<TopicPhanHoi>();
listTopicPhanHoi = ChiTietThongTinPhanHoiLocalServiceUtil.getAllTopicPhanHoi();

%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL.toString() %>" method="post" name="frmConfig">
	<aui:input name="<%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" />
	
	<div>
		<fieldset>
			<table style="width: 100%;">
				<tr>					
					<th style="width:70%"><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.chude"/></th>
					<th style="width:30%"><liferay-ui:message key="vn.dtt.thongtinphanhoi.backend.label.sophanhoigioihan"/></th>								
				</tr>
				<%
					for(TopicPhanHoi topic: listTopicPhanHoi){
						String rangeTopic = preferences.getValue(topic.getTopicCode(), "0");
				%>
				<tr>
					<td  style="width:70%">
						<%=topic.getTopicName() %>
					</td>
					<td  style="width:30%">
						<aui:input name="<%=topic.getTopicCode() %>" label="" value="<%= rangeTopic %>"/>
					</td>							
				</tr>
				<%
					}
				%>
			</table>
		</fieldset>
	</div>
	<aui:button type="submit" name="btnSave" id="btnSave" value="vn.dtt.thongtinphanhoi.backend.button.save"/>
</aui:form>