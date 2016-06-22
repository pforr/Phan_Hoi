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

package vn.dtt.ns.thongtinphanhoi.dao.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ThongTinPhanHoi service. Represents a row in the &quot;ws_thongtin_phanhoi&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.dtt.ns.thongtinphanhoi.dao.model.impl.ThongTinPhanHoiModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.dtt.ns.thongtinphanhoi.dao.model.impl.ThongTinPhanHoiImpl}.
 * </p>
 *
 * @author tubq
 * @see ThongTinPhanHoi
 * @see vn.dtt.ns.thongtinphanhoi.dao.model.impl.ThongTinPhanHoiImpl
 * @see vn.dtt.ns.thongtinphanhoi.dao.model.impl.ThongTinPhanHoiModelImpl
 * @generated
 */
public interface ThongTinPhanHoiModel extends BaseModel<ThongTinPhanHoi> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a thong tin phan hoi model instance should use the {@link ThongTinPhanHoi} interface instead.
	 */

	/**
	 * Returns the primary key of this thong tin phan hoi.
	 *
	 * @return the primary key of this thong tin phan hoi
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this thong tin phan hoi.
	 *
	 * @param primaryKey the primary key of this thong tin phan hoi
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this thong tin phan hoi.
	 *
	 * @return the ID of this thong tin phan hoi
	 */
	public long getId();

	/**
	 * Sets the ID of this thong tin phan hoi.
	 *
	 * @param id the ID of this thong tin phan hoi
	 */
	public void setId(long id);

	/**
	 * Returns the so dien thoai of this thong tin phan hoi.
	 *
	 * @return the so dien thoai of this thong tin phan hoi
	 */
	@AutoEscape
	public String getSoDienThoai();

	/**
	 * Sets the so dien thoai of this thong tin phan hoi.
	 *
	 * @param soDienThoai the so dien thoai of this thong tin phan hoi
	 */
	public void setSoDienThoai(String soDienThoai);

	/**
	 * Returns the thoi gian goi of this thong tin phan hoi.
	 *
	 * @return the thoi gian goi of this thong tin phan hoi
	 */
	public Date getThoiGianGoi();

	/**
	 * Sets the thoi gian goi of this thong tin phan hoi.
	 *
	 * @param thoiGianGoi the thoi gian goi of this thong tin phan hoi
	 */
	public void setThoiGianGoi(Date thoiGianGoi);

	/**
	 * Returns the trang thai giao dich of this thong tin phan hoi.
	 *
	 * @return the trang thai giao dich of this thong tin phan hoi
	 */
	public int getTrangThaiGiaoDich();

	/**
	 * Sets the trang thai giao dich of this thong tin phan hoi.
	 *
	 * @param trangThaiGiaoDich the trang thai giao dich of this thong tin phan hoi
	 */
	public void setTrangThaiGiaoDich(int trangThaiGiaoDich);

	/**
	 * Returns the tong dai of this thong tin phan hoi.
	 *
	 * @return the tong dai of this thong tin phan hoi
	 */
	public int getTongDai();

	/**
	 * Sets the tong dai of this thong tin phan hoi.
	 *
	 * @param tongDai the tong dai of this thong tin phan hoi
	 */
	public void setTongDai(int tongDai);

	/**
	 * Returns the ma tinh of this thong tin phan hoi.
	 *
	 * @return the ma tinh of this thong tin phan hoi
	 */
	@AutoEscape
	public String getMaTinh();

	/**
	 * Sets the ma tinh of this thong tin phan hoi.
	 *
	 * @param maTinh the ma tinh of this thong tin phan hoi
	 */
	public void setMaTinh(String maTinh);

	/**
	 * Returns the ma huyen of this thong tin phan hoi.
	 *
	 * @return the ma huyen of this thong tin phan hoi
	 */
	@AutoEscape
	public String getMaHuyen();

	/**
	 * Sets the ma huyen of this thong tin phan hoi.
	 *
	 * @param maHuyen the ma huyen of this thong tin phan hoi
	 */
	public void setMaHuyen(String maHuyen);

	/**
	 * Returns the ma xa of this thong tin phan hoi.
	 *
	 * @return the ma xa of this thong tin phan hoi
	 */
	@AutoEscape
	public String getMaXa();

	/**
	 * Sets the ma xa of this thong tin phan hoi.
	 *
	 * @param maXa the ma xa of this thong tin phan hoi
	 */
	public void setMaXa(String maXa);

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
	public int compareTo(ThongTinPhanHoi thongTinPhanHoi);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ThongTinPhanHoi> toCacheModel();

	@Override
	public ThongTinPhanHoi toEscapedModel();

	@Override
	public ThongTinPhanHoi toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}