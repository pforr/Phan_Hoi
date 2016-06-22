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

package vn.dtt.ns.thongtinphanhoi.dao.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import vn.dtt.ns.thongtinphanhoi.dao.model.TrangThaiThongKePhanHoi;
import vn.dtt.ns.thongtinphanhoi.dao.service.base.TrangThaiThongKePhanHoiLocalServiceBaseImpl;

/**
 * The implementation of the trang thai thong ke phan hoi local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.dtt.ns.thongtinphanhoi.dao.service.TrangThaiThongKePhanHoiLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author tubq
 * @see vn.dtt.ns.thongtinphanhoi.dao.service.base.TrangThaiThongKePhanHoiLocalServiceBaseImpl
 * @see vn.dtt.ns.thongtinphanhoi.dao.service.TrangThaiThongKePhanHoiLocalServiceUtil
 */
public class TrangThaiThongKePhanHoiLocalServiceImpl
	extends TrangThaiThongKePhanHoiLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.dtt.ns.thongtinphanhoi.dao.service.TrangThaiThongKePhanHoiLocalServiceUtil} to access the trang thai thong ke phan hoi local service.
	 */
	public TrangThaiThongKePhanHoi fetchByarticleId(int articleId) throws SystemException{
		return trangThaiThongKePhanHoiPersistence.fetchByarticleId(articleId);
	}
	public TrangThaiThongKePhanHoi fetchBymaTinhThangNamChuyenSangMB(String maTinh, String thangNam, int daChuyenSangMinhBach ) throws SystemException{
		return trangThaiThongKePhanHoiPersistence.fetchBymaTinhThangNamChuyenSangMB(maTinh, thangNam, daChuyenSangMinhBach);
	}
	public List<TrangThaiThongKePhanHoi> findBymaTinh(String maTinh) throws SystemException{
		return trangThaiThongKePhanHoiPersistence.findBymaTinh(maTinh);
	}
	public List<TrangThaiThongKePhanHoi> findBythangNam(String thangNam) throws SystemException{
		return trangThaiThongKePhanHoiPersistence.findBythangNam(thangNam);
	}
	public TrangThaiThongKePhanHoi fetchByarticleIdAndDaChuyenSangMinhBach(int articleId, int daChuyenSangMinhBach ) throws SystemException{
		return trangThaiThongKePhanHoiPersistence.fetchByarticleIdAndDaChuyenSangMinhBach(articleId, daChuyenSangMinhBach);
	}
}