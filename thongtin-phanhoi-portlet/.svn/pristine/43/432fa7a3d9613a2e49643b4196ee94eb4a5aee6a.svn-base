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

package vn.dtt.ns.yeucaugiaitrinh.dao.service.impl;

import java.util.List;

import vn.dtt.ns.yeucaugiaitrinh.dao.model.ChiTietYeuCauGiaiTrinh;
import vn.dtt.ns.yeucaugiaitrinh.dao.service.base.ChiTietYeuCauGiaiTrinhLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the chi tiet yeu cau giai trinh local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.dtt.ns.yeucaugiaitrinh.dao.service.ChiTietYeuCauGiaiTrinhLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author tubq
 * @see vn.dtt.ns.yeucaugiaitrinh.dao.service.base.ChiTietYeuCauGiaiTrinhLocalServiceBaseImpl
 * @see vn.dtt.ns.yeucaugiaitrinh.dao.service.ChiTietYeuCauGiaiTrinhLocalServiceUtil
 */
public class ChiTietYeuCauGiaiTrinhLocalServiceImpl
	extends ChiTietYeuCauGiaiTrinhLocalServiceBaseImpl {
	
	public ChiTietYeuCauGiaiTrinh getChiTietGiaiTrinhByYcgtIdAndMaThongTinPhanAnh(long ycgtId, String maThongTinPhanAnh)throws SystemException{
		return chiTietYeuCauGiaiTrinhPersistence.fetchByChiTietGiaiTrinhByYcgtIdAndMaThongTinPhanAnh(ycgtId, maThongTinPhanAnh);		
	}
	
	public List<ChiTietYeuCauGiaiTrinh> getChiTietGiaiTrinhByYcgtId(long ycgtId)throws SystemException{
		return chiTietYeuCauGiaiTrinhPersistence.findByChiTietGiaiTrinhByYcgtId(ycgtId);		
	}
}