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
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ChiTietYeuCauGiaiTrinh service. Represents a row in the &quot;ws_chitiet_yeucau_giaitrinh&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.ChiTietYeuCauGiaiTrinhModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.ChiTietYeuCauGiaiTrinhImpl}.
 * </p>
 *
 * @author tubq
 * @see ChiTietYeuCauGiaiTrinh
 * @see vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.ChiTietYeuCauGiaiTrinhImpl
 * @see vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.ChiTietYeuCauGiaiTrinhModelImpl
 * @generated
 */
public interface ChiTietYeuCauGiaiTrinhModel extends BaseModel<ChiTietYeuCauGiaiTrinh> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a chi tiet yeu cau giai trinh model instance should use the {@link ChiTietYeuCauGiaiTrinh} interface instead.
	 */

	/**
	 * Returns the primary key of this chi tiet yeu cau giai trinh.
	 *
	 * @return the primary key of this chi tiet yeu cau giai trinh
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this chi tiet yeu cau giai trinh.
	 *
	 * @param primaryKey the primary key of this chi tiet yeu cau giai trinh
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this chi tiet yeu cau giai trinh.
	 *
	 * @return the ID of this chi tiet yeu cau giai trinh
	 */
	public long getId();

	/**
	 * Sets the ID of this chi tiet yeu cau giai trinh.
	 *
	 * @param id the ID of this chi tiet yeu cau giai trinh
	 */
	public void setId(long id);

	/**
	 * Returns the yeu cau giai trinh ID of this chi tiet yeu cau giai trinh.
	 *
	 * @return the yeu cau giai trinh ID of this chi tiet yeu cau giai trinh
	 */
	public long getYeuCauGiaiTrinhId();

	/**
	 * Sets the yeu cau giai trinh ID of this chi tiet yeu cau giai trinh.
	 *
	 * @param yeuCauGiaiTrinhId the yeu cau giai trinh ID of this chi tiet yeu cau giai trinh
	 */
	public void setYeuCauGiaiTrinhId(long yeuCauGiaiTrinhId);

	/**
	 * Returns the ma thong tin phan anh of this chi tiet yeu cau giai trinh.
	 *
	 * @return the ma thong tin phan anh of this chi tiet yeu cau giai trinh
	 */
	@AutoEscape
	public String getMaThongTinPhanAnh();

	/**
	 * Sets the ma thong tin phan anh of this chi tiet yeu cau giai trinh.
	 *
	 * @param maThongTinPhanAnh the ma thong tin phan anh of this chi tiet yeu cau giai trinh
	 */
	public void setMaThongTinPhanAnh(String maThongTinPhanAnh);

	/**
	 * Returns the so luong of this chi tiet yeu cau giai trinh.
	 *
	 * @return the so luong of this chi tiet yeu cau giai trinh
	 */
	public int getSoLuong();

	/**
	 * Sets the so luong of this chi tiet yeu cau giai trinh.
	 *
	 * @param soLuong the so luong of this chi tiet yeu cau giai trinh
	 */
	public void setSoLuong(int soLuong);

	/**
	 * Returns the giai trinh of this chi tiet yeu cau giai trinh.
	 *
	 * @return the giai trinh of this chi tiet yeu cau giai trinh
	 */
	@AutoEscape
	public String getGiaiTrinh();

	/**
	 * Sets the giai trinh of this chi tiet yeu cau giai trinh.
	 *
	 * @param giaiTrinh the giai trinh of this chi tiet yeu cau giai trinh
	 */
	public void setGiaiTrinh(String giaiTrinh);

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
	public int compareTo(ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ChiTietYeuCauGiaiTrinh> toCacheModel();

	@Override
	public ChiTietYeuCauGiaiTrinh toEscapedModel();

	@Override
	public ChiTietYeuCauGiaiTrinh toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}