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

package vn.dtt.ns.thongtinphanhoi.dao.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiLocalServiceUtil;
import vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiServiceUtil;
import vn.dtt.ns.thongtinphanhoi.dao.service.ClpSerializer;
import vn.dtt.ns.thongtinphanhoi.dao.service.ThongTinPhanHoiLocalServiceUtil;
import vn.dtt.ns.thongtinphanhoi.dao.service.ThongTinPhanHoiServiceUtil;
import vn.dtt.ns.thongtinphanhoi.dao.service.TopicDetailsLocalServiceUtil;
import vn.dtt.ns.thongtinphanhoi.dao.service.TopicDetailsServiceUtil;
import vn.dtt.ns.thongtinphanhoi.dao.service.TopicPhanHoiLocalServiceUtil;
import vn.dtt.ns.thongtinphanhoi.dao.service.TopicPhanHoiServiceUtil;

/**
 * @author tubq
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			ChiTietThongTinPhanHoiLocalServiceUtil.clearService();

			ChiTietThongTinPhanHoiServiceUtil.clearService();
			ThongTinPhanHoiLocalServiceUtil.clearService();

			ThongTinPhanHoiServiceUtil.clearService();
			TopicDetailsLocalServiceUtil.clearService();

			TopicDetailsServiceUtil.clearService();
			TopicPhanHoiLocalServiceUtil.clearService();

			TopicPhanHoiServiceUtil.clearService();
		}
	}
}