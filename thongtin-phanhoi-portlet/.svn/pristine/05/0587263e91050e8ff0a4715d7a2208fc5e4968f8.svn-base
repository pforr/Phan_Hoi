<%@page import="com.liferay.portal.model.User"%>
<%@page import="vn.dtt.cmon.user.dao.model.UserMapping"%>
<%@include file="../init.jsp" %>

<%
	UserMapping userMapping = (UserMapping) renderRequest.getAttribute("userMapping");

	long userMappingId = ParamUtil.getLong(request, "userMappingId");
	if(userMapping == null && Validator.isNotNull(userMappingId)){
		userMapping = UserMappingBusiness.getUserMapping(userMappingId);
	} 

	User selUser = null;
	
	if (Validator.isNotNull(userMapping)) {
		selUser = UserMappingBusiness.getUser(userMapping.getId());
	}
%>

<table>
	<tr>
		<td class="col-1">
			<aui:input name="screenName" value="<%= Validator.isNotNull(selUser) ? selUser.getScreenName() : StringPool.BLANK %>" label="user-name" type="text" cssClass="input-50">
				<aui:validator name="required" />
			</aui:input>
		</td>
		<td class="col-2">
			<aui:input name="fullName" value="<%= Validator.isNotNull(selUser) ? selUser.getFirstName() : StringPool.BLANK %>" type="text" label="full-name" cssClass="input-50">
				<aui:validator name="required" />
			</aui:input>
		</td>
	</tr>
	<tr>
		<td>
			<aui:input name="emailAddress" value="<%= Validator.isNotNull(selUser) ? selUser.getEmailAddress() : StringPool.BLANK %>" type="text" cssClass="input-50">
				<aui:validator name="email" />
			</aui:input>
		</td>
		<td>
		
		</td>
	</tr>
	<tr>
		<td>
			<aui:input name="password1" label='<%= Validator.isNull(userMapping) ? "password" : "new-password" %>' type="password" cssClass="input-50">
				<c:if test="<%= Validator.isNull(userMapping) %>">
					<aui:validator name="required" />
				</c:if>
			</aui:input>
			
		</td>
		<td>
			<aui:input name="password2" type="password" label="re-password" cssClass="input-50">
					<aui:validator name="equalTo">'#<portlet:namespace />password1'</aui:validator>
			</aui:input>
		
		</td>
	</tr>
</table>