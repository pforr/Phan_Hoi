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

package vn.dtt.ns.yeucaugiaitrinh.dao.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author tubq
 */
public class TrangThaiGiaiTrinhFinderUtil {
	public static vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh getTrangThaiGiaiTrinhByYcgtId(
		long ycgtId) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getTrangThaiGiaiTrinhByYcgtId(ycgtId);
	}

	public static vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh getTrangThaiGiaiTrinhByYcgtIdAndTrangThai(
		long ycgtId, int trangThai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getTrangThaiGiaiTrinhByYcgtIdAndTrangThai(ycgtId, trangThai);
	}

	public static TrangThaiGiaiTrinhFinder getFinder() {
		if (_finder == null) {
			_finder = (TrangThaiGiaiTrinhFinder)PortletBeanLocatorUtil.locate(vn.dtt.ns.yeucaugiaitrinh.dao.service.ClpSerializer.getServletContextName(),
					TrangThaiGiaiTrinhFinder.class.getName());

			ReferenceRegistry.registerReference(TrangThaiGiaiTrinhFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(TrangThaiGiaiTrinhFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(TrangThaiGiaiTrinhFinderUtil.class,
			"_finder");
	}

	private static TrangThaiGiaiTrinhFinder _finder;
}