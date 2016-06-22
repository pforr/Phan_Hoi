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

import com.liferay.portal.kernel.exception.SystemException;

import vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh;
import vn.dtt.ns.yeucaugiaitrinh.dao.service.base.TrangThaiGiaiTrinhLocalServiceBaseImpl;

/**
 * The implementation of the trang thai giai trinh local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.dtt.ns.yeucaugiaitrinh.dao.service.TrangThaiGiaiTrinhLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author tubq
 * @see vn.dtt.ns.yeucaugiaitrinh.dao.service.base.TrangThaiGiaiTrinhLocalServiceBaseImpl
 * @see vn.dtt.ns.yeucaugiaitrinh.dao.service.TrangThaiGiaiTrinhLocalServiceUtil
 */
public class TrangThaiGiaiTrinhLocalServiceImpl
	extends TrangThaiGiaiTrinhLocalServiceBaseImpl {
	
	public TrangThaiGiaiTrinh getTrangThaiGiaiTrinhByYcgtId(long ycgtId) throws SystemException{	
		return trangThaiGiaiTrinhFinder.getTrangThaiGiaiTrinhByYcgtId(ycgtId);
	}
	
	public TrangThaiGiaiTrinh getTrangThaiGiaiTrinhByYcgtIdAndTrangThai(long ycgtId, int trangThai) throws SystemException{	
		return trangThaiGiaiTrinhFinder.getTrangThaiGiaiTrinhByYcgtIdAndTrangThai(ycgtId, trangThai);
	}
	
	public List<TrangThaiGiaiTrinh> getTrangThaiGiaiTrinhByQuaTrinhXuLy(long ycgtId) throws SystemException{	
		return trangThaiGiaiTrinhPersistence.findByQuaTrinhXuLy(ycgtId);
	}
}