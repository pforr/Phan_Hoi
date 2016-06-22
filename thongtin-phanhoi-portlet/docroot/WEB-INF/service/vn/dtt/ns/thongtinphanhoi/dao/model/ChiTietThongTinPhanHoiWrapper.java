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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ChiTietThongTinPhanHoi}.
 * </p>
 *
 * @author tubq
 * @see ChiTietThongTinPhanHoi
 * @generated
 */
public class ChiTietThongTinPhanHoiWrapper implements ChiTietThongTinPhanHoi,
	ModelWrapper<ChiTietThongTinPhanHoi> {
	public ChiTietThongTinPhanHoiWrapper(
		ChiTietThongTinPhanHoi chiTietThongTinPhanHoi) {
		_chiTietThongTinPhanHoi = chiTietThongTinPhanHoi;
	}

	@Override
	public Class<?> getModelClass() {
		return ChiTietThongTinPhanHoi.class;
	}

	@Override
	public String getModelClassName() {
		return ChiTietThongTinPhanHoi.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("thongTinPhanHoiId", getThongTinPhanHoiId());
		attributes.put("maTramCapNuoc", getMaTramCapNuoc());
		attributes.put("noiDungKhacNuoc", getNoiDungKhacNuoc());
		attributes.put("noiDungKhacVeSinh", getNoiDungKhacVeSinh());
		attributes.put("maThongTinPhanAnh", getMaThongTinPhanAnh());
		attributes.put("yeuCauGiaiTrinhId", getYeuCauGiaiTrinhId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long thongTinPhanHoiId = (Long)attributes.get("thongTinPhanHoiId");

		if (thongTinPhanHoiId != null) {
			setThongTinPhanHoiId(thongTinPhanHoiId);
		}

		String maTramCapNuoc = (String)attributes.get("maTramCapNuoc");

		if (maTramCapNuoc != null) {
			setMaTramCapNuoc(maTramCapNuoc);
		}

		String noiDungKhacNuoc = (String)attributes.get("noiDungKhacNuoc");

		if (noiDungKhacNuoc != null) {
			setNoiDungKhacNuoc(noiDungKhacNuoc);
		}

		String noiDungKhacVeSinh = (String)attributes.get("noiDungKhacVeSinh");

		if (noiDungKhacVeSinh != null) {
			setNoiDungKhacVeSinh(noiDungKhacVeSinh);
		}

		String maThongTinPhanAnh = (String)attributes.get("maThongTinPhanAnh");

		if (maThongTinPhanAnh != null) {
			setMaThongTinPhanAnh(maThongTinPhanAnh);
		}

		Long yeuCauGiaiTrinhId = (Long)attributes.get("yeuCauGiaiTrinhId");

		if (yeuCauGiaiTrinhId != null) {
			setYeuCauGiaiTrinhId(yeuCauGiaiTrinhId);
		}
	}

	/**
	* Returns the primary key of this chi tiet thong tin phan hoi.
	*
	* @return the primary key of this chi tiet thong tin phan hoi
	*/
	@Override
	public long getPrimaryKey() {
		return _chiTietThongTinPhanHoi.getPrimaryKey();
	}

	/**
	* Sets the primary key of this chi tiet thong tin phan hoi.
	*
	* @param primaryKey the primary key of this chi tiet thong tin phan hoi
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_chiTietThongTinPhanHoi.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this chi tiet thong tin phan hoi.
	*
	* @return the ID of this chi tiet thong tin phan hoi
	*/
	@Override
	public long getId() {
		return _chiTietThongTinPhanHoi.getId();
	}

	/**
	* Sets the ID of this chi tiet thong tin phan hoi.
	*
	* @param id the ID of this chi tiet thong tin phan hoi
	*/
	@Override
	public void setId(long id) {
		_chiTietThongTinPhanHoi.setId(id);
	}

	/**
	* Returns the thong tin phan hoi ID of this chi tiet thong tin phan hoi.
	*
	* @return the thong tin phan hoi ID of this chi tiet thong tin phan hoi
	*/
	@Override
	public long getThongTinPhanHoiId() {
		return _chiTietThongTinPhanHoi.getThongTinPhanHoiId();
	}

	/**
	* Sets the thong tin phan hoi ID of this chi tiet thong tin phan hoi.
	*
	* @param thongTinPhanHoiId the thong tin phan hoi ID of this chi tiet thong tin phan hoi
	*/
	@Override
	public void setThongTinPhanHoiId(long thongTinPhanHoiId) {
		_chiTietThongTinPhanHoi.setThongTinPhanHoiId(thongTinPhanHoiId);
	}

	/**
	* Returns the ma tram cap nuoc of this chi tiet thong tin phan hoi.
	*
	* @return the ma tram cap nuoc of this chi tiet thong tin phan hoi
	*/
	@Override
	public java.lang.String getMaTramCapNuoc() {
		return _chiTietThongTinPhanHoi.getMaTramCapNuoc();
	}

	/**
	* Sets the ma tram cap nuoc of this chi tiet thong tin phan hoi.
	*
	* @param maTramCapNuoc the ma tram cap nuoc of this chi tiet thong tin phan hoi
	*/
	@Override
	public void setMaTramCapNuoc(java.lang.String maTramCapNuoc) {
		_chiTietThongTinPhanHoi.setMaTramCapNuoc(maTramCapNuoc);
	}

	/**
	* Returns the noi dung khac nuoc of this chi tiet thong tin phan hoi.
	*
	* @return the noi dung khac nuoc of this chi tiet thong tin phan hoi
	*/
	@Override
	public java.lang.String getNoiDungKhacNuoc() {
		return _chiTietThongTinPhanHoi.getNoiDungKhacNuoc();
	}

	/**
	* Sets the noi dung khac nuoc of this chi tiet thong tin phan hoi.
	*
	* @param noiDungKhacNuoc the noi dung khac nuoc of this chi tiet thong tin phan hoi
	*/
	@Override
	public void setNoiDungKhacNuoc(java.lang.String noiDungKhacNuoc) {
		_chiTietThongTinPhanHoi.setNoiDungKhacNuoc(noiDungKhacNuoc);
	}

	/**
	* Returns the noi dung khac ve sinh of this chi tiet thong tin phan hoi.
	*
	* @return the noi dung khac ve sinh of this chi tiet thong tin phan hoi
	*/
	@Override
	public java.lang.String getNoiDungKhacVeSinh() {
		return _chiTietThongTinPhanHoi.getNoiDungKhacVeSinh();
	}

	/**
	* Sets the noi dung khac ve sinh of this chi tiet thong tin phan hoi.
	*
	* @param noiDungKhacVeSinh the noi dung khac ve sinh of this chi tiet thong tin phan hoi
	*/
	@Override
	public void setNoiDungKhacVeSinh(java.lang.String noiDungKhacVeSinh) {
		_chiTietThongTinPhanHoi.setNoiDungKhacVeSinh(noiDungKhacVeSinh);
	}

	/**
	* Returns the ma thong tin phan anh of this chi tiet thong tin phan hoi.
	*
	* @return the ma thong tin phan anh of this chi tiet thong tin phan hoi
	*/
	@Override
	public java.lang.String getMaThongTinPhanAnh() {
		return _chiTietThongTinPhanHoi.getMaThongTinPhanAnh();
	}

	/**
	* Sets the ma thong tin phan anh of this chi tiet thong tin phan hoi.
	*
	* @param maThongTinPhanAnh the ma thong tin phan anh of this chi tiet thong tin phan hoi
	*/
	@Override
	public void setMaThongTinPhanAnh(java.lang.String maThongTinPhanAnh) {
		_chiTietThongTinPhanHoi.setMaThongTinPhanAnh(maThongTinPhanAnh);
	}

	/**
	* Returns the yeu cau giai trinh ID of this chi tiet thong tin phan hoi.
	*
	* @return the yeu cau giai trinh ID of this chi tiet thong tin phan hoi
	*/
	@Override
	public long getYeuCauGiaiTrinhId() {
		return _chiTietThongTinPhanHoi.getYeuCauGiaiTrinhId();
	}

	/**
	* Sets the yeu cau giai trinh ID of this chi tiet thong tin phan hoi.
	*
	* @param yeuCauGiaiTrinhId the yeu cau giai trinh ID of this chi tiet thong tin phan hoi
	*/
	@Override
	public void setYeuCauGiaiTrinhId(long yeuCauGiaiTrinhId) {
		_chiTietThongTinPhanHoi.setYeuCauGiaiTrinhId(yeuCauGiaiTrinhId);
	}

	@Override
	public boolean isNew() {
		return _chiTietThongTinPhanHoi.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_chiTietThongTinPhanHoi.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _chiTietThongTinPhanHoi.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_chiTietThongTinPhanHoi.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _chiTietThongTinPhanHoi.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _chiTietThongTinPhanHoi.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_chiTietThongTinPhanHoi.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _chiTietThongTinPhanHoi.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_chiTietThongTinPhanHoi.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_chiTietThongTinPhanHoi.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_chiTietThongTinPhanHoi.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ChiTietThongTinPhanHoiWrapper((ChiTietThongTinPhanHoi)_chiTietThongTinPhanHoi.clone());
	}

	@Override
	public int compareTo(
		vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi chiTietThongTinPhanHoi) {
		return _chiTietThongTinPhanHoi.compareTo(chiTietThongTinPhanHoi);
	}

	@Override
	public int hashCode() {
		return _chiTietThongTinPhanHoi.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi> toCacheModel() {
		return _chiTietThongTinPhanHoi.toCacheModel();
	}

	@Override
	public vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi toEscapedModel() {
		return new ChiTietThongTinPhanHoiWrapper(_chiTietThongTinPhanHoi.toEscapedModel());
	}

	@Override
	public vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi toUnescapedModel() {
		return new ChiTietThongTinPhanHoiWrapper(_chiTietThongTinPhanHoi.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _chiTietThongTinPhanHoi.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _chiTietThongTinPhanHoi.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_chiTietThongTinPhanHoi.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ChiTietThongTinPhanHoiWrapper)) {
			return false;
		}

		ChiTietThongTinPhanHoiWrapper chiTietThongTinPhanHoiWrapper = (ChiTietThongTinPhanHoiWrapper)obj;

		if (Validator.equals(_chiTietThongTinPhanHoi,
					chiTietThongTinPhanHoiWrapper._chiTietThongTinPhanHoi)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ChiTietThongTinPhanHoi getWrappedChiTietThongTinPhanHoi() {
		return _chiTietThongTinPhanHoi;
	}

	@Override
	public ChiTietThongTinPhanHoi getWrappedModel() {
		return _chiTietThongTinPhanHoi;
	}

	@Override
	public void resetOriginalValues() {
		_chiTietThongTinPhanHoi.resetOriginalValues();
	}

	private ChiTietThongTinPhanHoi _chiTietThongTinPhanHoi;
}