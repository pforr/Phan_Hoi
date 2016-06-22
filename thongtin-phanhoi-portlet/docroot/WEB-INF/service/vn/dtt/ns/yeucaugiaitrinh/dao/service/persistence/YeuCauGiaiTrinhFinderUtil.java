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
public class YeuCauGiaiTrinhFinderUtil {
	public static long countYeuCauGiaiTrinh(java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		int trangThaiGiaiTrinh, java.lang.String maChuDe, int soLuotPhanHoi,
		java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countYeuCauGiaiTrinh(maTinh, maHuyen, maXa,
			trangThaiGiaiTrinh, maChuDe, soLuotPhanHoi, fromDate, toDate);
	}

	public static java.util.List<vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh> searchYeuCauGiaiTrinh(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, int trangThaiGiaiTrinh,
		java.lang.String maChuDe, int soLuotPhanHoi, java.util.Date fromDate,
		java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .searchYeuCauGiaiTrinh(maTinh, maHuyen, maXa,
			trangThaiGiaiTrinh, maChuDe, soLuotPhanHoi, fromDate, toDate,
			start, end);
	}

	public static long countYeuCauGiaiTrinhNSVS(java.lang.String maTinh,
		java.lang.String[] maHuyen, java.lang.String[] maXa,
		int trangThaiGiaiTrinh, java.lang.String[] maChuDe, int soLuotPhanHoi,
		java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countYeuCauGiaiTrinhNSVS(maTinh, maHuyen, maXa,
			trangThaiGiaiTrinh, maChuDe, soLuotPhanHoi, fromDate, toDate);
	}

	public static java.util.List<vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh> searchYeuCauGiaiTrinhNSVS(
		java.lang.String maTinh, java.lang.String[] maHuyen,
		java.lang.String[] maXa, int trangThaiGiaiTrinh,
		java.lang.String[] maChuDe, int soLuotPhanHoi, java.util.Date fromDate,
		java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .searchYeuCauGiaiTrinhNSVS(maTinh, maHuyen, maXa,
			trangThaiGiaiTrinh, maChuDe, soLuotPhanHoi, fromDate, toDate,
			start, end);
	}

	public static YeuCauGiaiTrinhFinder getFinder() {
		if (_finder == null) {
			_finder = (YeuCauGiaiTrinhFinder)PortletBeanLocatorUtil.locate(vn.dtt.ns.yeucaugiaitrinh.dao.service.ClpSerializer.getServletContextName(),
					YeuCauGiaiTrinhFinder.class.getName());

			ReferenceRegistry.registerReference(YeuCauGiaiTrinhFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(YeuCauGiaiTrinhFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(YeuCauGiaiTrinhFinderUtil.class,
			"_finder");
	}

	private static YeuCauGiaiTrinhFinder _finder;
}