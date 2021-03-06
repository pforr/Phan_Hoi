package vn.dtt.ns.thongtinphanhoi;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi;
import vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class CustomConfigurationAction implements com.liferay.portal.kernel.portlet.ConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		String cmd = ParamUtil.getString(actionRequest, com.liferay.portal.kernel.util.Constants.CMD);
		if (!cmd.equals(com.liferay.portal.kernel.util.Constants.UPDATE)) {
			return;
		}
		
		String portletResource = ParamUtil.getString(actionRequest, "portletResource"); 
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
				
		List<TopicPhanHoi> listTopicPhanHoi = new ArrayList<TopicPhanHoi>();
		listTopicPhanHoi = ChiTietThongTinPhanHoiLocalServiceUtil.searchTopicPhanHoi("", "", "", "", null, null, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		for(TopicPhanHoi topic: listTopicPhanHoi){	
			String rangeTopic = ParamUtil.getString(actionRequest, topic.getTopicCode(), "0");
		
			prefs.setValue(topic.getTopicCode(), rangeTopic);		
		}
		prefs.store();			
	}

	@Override
	public String render(PortletConfig portletConfig, RenderRequest actionRequest,
			RenderResponse actionResponse) throws Exception {
		return "/html/backend/phanhoi/config.jsp";
	}

}
