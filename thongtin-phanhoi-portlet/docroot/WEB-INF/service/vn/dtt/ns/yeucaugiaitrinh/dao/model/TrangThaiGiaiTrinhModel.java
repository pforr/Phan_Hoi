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

package vn.dtt.ns.yeucaugiaitrinh.dao.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the TrangThaiGiaiTrinh service. Represents a row in the &quot;ws_trangthai_giaitrinh&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.TrangThaiGiaiTrinhModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.TrangThaiGiaiTrinhImpl}.
 * </p>
 *
 * @author tubq
 * @see TrangThaiGiaiTrinh
 * @see vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.TrangThaiGiaiTrinhImpl
 * @see vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.TrangThaiGiaiTrinhModelImpl
 * @generated
 */
public interface TrangThaiGiaiTrinhModel extends BaseModel<TrangThaiGiaiTrinh> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a trang thai giai trinh model instance should use the {@link TrangThaiGiaiTrinh} interface instead.
	 */

	/**
	 * Returns the primary key of this trang thai giai trinh.
	 *
	 * @return the primary key of this trang thai giai trinh
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this trang thai giai trinh.
	 *
	 * @param primaryKey the primary key of this trang thai giai trinh
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this trang thai giai trinh.
	 *
	 * @return the ID of this trang thai giai trinh
	 */
	public long getId();

	/**
	 * Sets the ID of this trang thai giai trinh.
	 *
	 * @param id the ID of this trang thai giai trinh
	 */
	public void setId(long id);

	/**
	 * Returns the yeu cau giai trinh ID of this trang thai giai trinh.
	 *
	 * @return the yeu cau giai trinh ID of this trang thai giai trinh
	 */
	public long getYeuCauGiaiTrinhId();

	/**
	 * Sets the yeu cau giai trinh ID of this trang thai giai trinh.
	 *
	 * @param yeuCauGiaiTrinhId the yeu cau giai trinh ID of this trang thai giai trinh
	 */
	public void setYeuCauGiaiTrinhId(long yeuCauGiaiTrinhId);

	/**
	 * Returns the trang thai of this trang thai giai trinh.
	 *
	 * @return the trang thai of this trang thai giai trinh
	 */
	public int getTrangThai();

	/**
	 * Sets the trang thai of this trang thai giai trinh.
	 *
	 * @param trangThai the trang thai of this trang thai giai trinh
	 */
	public void setTrangThai(int trangThai);

	/**
	 * Returns the ghi chu nguoi lap of this trang thai giai trinh.
	 *
	 * @return the ghi chu nguoi lap of this trang thai giai trinh
	 */
	@AutoEscape
	public String getGhiChuNguoiLap();

	/**
	 * Sets the ghi chu nguoi lap of this trang thai giai trinh.
	 *
	 * @param ghiChuNguoiLap the ghi chu nguoi lap of this trang thai giai trinh
	 */
	public void setGhiChuNguoiLap(String ghiChuNguoiLap);

	/**
	 * Returns the user ID of this trang thai giai trinh.
	 *
	 * @return the user ID of this trang thai giai trinh
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this trang thai giai trinh.
	 *
	 * @param userId the user ID of this trang thai giai trinh
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this trang thai giai trinh.
	 *
	 * @return the user uuid of this trang thai giai trinh
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this trang thai giai trinh.
	 *
	 * @param userUuid the user uuid of this trang thai giai trinh
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the ngay tao of this trang thai giai trinh.
	 *
	 * @return the ngay tao of this trang thai giai trinh
	 */
	public Date getNgayTao();

	/**
	 * Sets the ngay tao of this trang thai giai trinh.
	 *
	 * @param ngayTao the ngay tao of this trang thai giai trinh
	 */
	public void setNgayTao(Date ngayTao);

	/**
	 * Returns the ngay cap nhat of this trang thai giai trinh.
	 *
	 * @return the ngay cap nhat of this trang thai giai trinh
	 */
	public Date getNgayCapNhat();

	/**
	 * Sets the ngay cap nhat of this trang thai giai trinh.
	 *
	 * @param ngayCapNhat the ngay cap nhat of this trang thai giai trinh
	 */
	public void setNgayCapNhat(Date ngayCapNhat);

	/**
	 * Returns the ghi chu nguoi duyet of this trang thai giai trinh.
	 *
	 * @return the ghi chu nguoi duyet of this trang thai giai trinh
	 */
	@AutoEscape
	public String getGhiChuNguoiDuyet();

	/**
	 * Sets the ghi chu nguoi duyet of this trang thai giai trinh.
	 *
	 * @param ghiChuNguoiDuyet the ghi chu nguoi duyet of this trang thai giai trinh
	 */
	public void setGhiChuNguoiDuyet(String ghiChuNguoiDuyet);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(TrangThaiGiaiTrinh trangThaiGiaiTrinh);

	@Override
	public int hashCode();

	@Override
	public CacheModel<TrangThaiGiaiTrinh> toCacheModel();

	@Override
	public TrangThaiGiaiTrinh toEscapedModel();

	@Override
	public TrangThaiGiaiTrinh toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}