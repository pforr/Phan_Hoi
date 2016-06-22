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

package vn.dtt.ns.thongtinphanhoi.dao.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author tubq
 */
public class ThongTinPhanHoiFinderUtil {
	public static long countTopicPhanHoi(java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String topicCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countTopicPhanHoi(maTinh, maHuyen, topicCode);
	}

	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi> searchTopicPhanHoi(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String topicCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .searchTopicPhanHoi(maTinh, maHuyen, topicCode, start, end);
	}

	public static ThongTinPhanHoiFinder getFinder() {
		if (_finder == null) {
			_finder = (ThongTinPhanHoiFinder)PortletBeanLocatorUtil.locate(vn.dtt.ns.thongtinphanhoi.dao.service.ClpSerializer.getServletContextName(),
					ThongTinPhanHoiFinder.class.getName());

			ReferenceRegistry.registerReference(ThongTinPhanHoiFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ThongTinPhanHoiFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ThongTinPhanHoiFinderUtil.class,
			"_finder");
	}

	private static ThongTinPhanHoiFinder _finder;
}