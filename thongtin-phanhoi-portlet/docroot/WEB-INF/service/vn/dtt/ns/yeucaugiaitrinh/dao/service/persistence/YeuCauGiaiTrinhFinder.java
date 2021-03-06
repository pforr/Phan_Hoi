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

/**
 * @author tubq
 */
public interface YeuCauGiaiTrinhFinder {
	public long countYeuCauGiaiTrinh(java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		int trangThaiGiaiTrinh, java.lang.String maChuDe, int soLuotPhanHoi,
		java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh> searchYeuCauGiaiTrinh(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, int trangThaiGiaiTrinh,
		java.lang.String maChuDe, int soLuotPhanHoi, java.util.Date fromDate,
		java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countYeuCauGiaiTrinhNSVS(java.lang.String maTinh,
		java.lang.String[] maHuyen, java.lang.String[] maXa,
		int trangThaiGiaiTrinh, java.lang.String[] maChuDe, int soLuotPhanHoi,
		java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh> searchYeuCauGiaiTrinhNSVS(
		java.lang.String maTinh, java.lang.String[] maHuyen,
		java.lang.String[] maXa, int trangThaiGiaiTrinh,
		java.lang.String[] maChuDe, int soLuotPhanHoi, java.util.Date fromDate,
		java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;
}