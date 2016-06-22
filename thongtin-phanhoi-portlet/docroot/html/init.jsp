<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="java.net.URLDecoder"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletPreferences"%>

<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="vn.dtt.ns.thongtinphanhoi.util.WebKeys"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%

String currentURL = PortalUtil.getCurrentURL(request);

String redirect = ParamUtil.getString(request, WebKeys.REDIRECT, currentURL);

String templatePath = portletConfig.getInitParameter("template-path");
PortletPreferences preferences = null;

if (renderRequest != null) 
{
	preferences = renderRequest.getPreferences();
}
if(Validator.isNotNull(resourceRequest)){
	preferences = resourceRequest.getPreferences();
}
String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) 
{
	preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
%>