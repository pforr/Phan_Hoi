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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link YeuCauGiaiTrinh}.
 * </p>
 *
 * @author tubq
 * @see YeuCauGiaiTrinh
 * @generated
 */
public class YeuCauGiaiTrinhWrapper implements YeuCauGiaiTrinh,
	ModelWrapper<YeuCauGiaiTrinh> {
	public YeuCauGiaiTrinhWrapper(YeuCauGiaiTrinh yeuCauGiaiTrinh) {
		_yeuCauGiaiTrinh = yeuCauGiaiTrinh;
	}

	@Override
	public Class<?> getModelClass() {
		return YeuCauGiaiTrinh.class;
	}

	@Override
	public String getModelClassName() {
		return YeuCauGiaiTrinh.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("maTinh", getMaTinh());
		attributes.put("maHuyen", getMaHuyen());
		attributes.put("maXa", getMaXa());
		attributes.put("maChuDe", getMaChuDe());
		attributes.put("trangThai", getTrangThai());
		attributes.put("soLuongTheoChuDe", getSoLuongTheoChuDe());
		attributes.put("userId", getUserId());
		attributes.put("ngayTao", getNgayTao());
		attributes.put("ngayCapNhat", getNgayCapNhat());
		attributes.put("nguoiPheDuyet", getNguoiPheDuyet());
		attributes.put("daChuyenSangMinhBach", getDaChuyenSangMinhBach());
		attributes.put("maYeuCauGiaiTrinh", getMaYeuCauGiaiTrinh());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String maTinh = (String)attributes.get("maTinh");

		if (maTinh != null) {
			setMaTinh(maTinh);
		}

		String maHuyen = (String)attributes.get("maHuyen");

		if (maHuyen != null) {
			setMaHuyen(maHuyen);
		}

		String maXa = (String)attributes.get("maXa");

		if (maXa != null) {
			setMaXa(maXa);
		}

		String maChuDe = (String)attributes.get("maChuDe");

		if (maChuDe != null) {
			setMaChuDe(maChuDe);
		}

		Integer trangThai = (Integer)attributes.get("trangThai");

		if (trangThai != null) {
			setTrangThai(trangThai);
		}

		Integer soLuongTheoChuDe = (Integer)attributes.get("soLuongTheoChuDe");

		if (soLuongTheoChuDe != null) {
			setSoLuongTheoChuDe(soLuongTheoChuDe);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date ngayTao = (Date)attributes.get("ngayTao");

		if (ngayTao != null) {
			setNgayTao(ngayTao);
		}

		Date ngayCapNhat = (Date)attributes.get("ngayCapNhat");

		if (ngayCapNhat != null) {
			setNgayCapNhat(ngayCapNhat);
		}

		Long nguoiPheDuyet = (Long)attributes.get("nguoiPheDuyet");

		if (nguoiPheDuyet != null) {
			setNguoiPheDuyet(nguoiPheDuyet);
		}

		Integer daChuyenSangMinhBach = (Integer)attributes.get(
				"daChuyenSangMinhBach");

		if (daChuyenSangMinhBach != null) {
			setDaChuyenSangMinhBach(daChuyenSangMinhBach);
		}

		String maYeuCauGiaiTrinh = (String)attributes.get("maYeuCauGiaiTrinh");

		if (maYeuCauGiaiTrinh != null) {
			setMaYeuCauGiaiTrinh(maYeuCauGiaiTrinh);
		}
	}

	/**
	* Returns the primary key of this yeu cau giai trinh.
	*
	* @return the primary key of this yeu cau giai trinh
	*/
	@Override
	public long getPrimaryKey() {
		return _yeuCauGiaiTrinh.getPrimaryKey();
	}

	/**
	* Sets the primary key of this yeu cau giai trinh.
	*
	* @param primaryKey the primary key of this yeu cau giai trinh
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_yeuCauGiaiTrinh.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this yeu cau giai trinh.
	*
	* @return the ID of this yeu cau giai trinh
	*/
	@Override
	public long getId() {
		return _yeuCauGiaiTrinh.getId();
	}

	/**
	* Sets the ID of this yeu cau giai trinh.
	*
	* @param id the ID of this yeu cau giai trinh
	*/
	@Override
	public void setId(long id) {
		_yeuCauGiaiTrinh.setId(id);
	}

	/**
	* Returns the ma tinh of this yeu cau giai trinh.
	*
	* @return the ma tinh of this yeu cau giai trinh
	*/
	@Override
	public java.lang.String getMaTinh() {
		return _yeuCauGiaiTrinh.getMaTinh();
	}

	/**
	* Sets the ma tinh of this yeu cau giai trinh.
	*
	* @param maTinh the ma tinh of this yeu cau giai trinh
	*/
	@Override
	public void setMaTinh(java.lang.String maTinh) {
		_yeuCauGiaiTrinh.setMaTinh(maTinh);
	}

	/**
	* Returns the ma huyen of this yeu cau giai trinh.
	*
	* @return the ma huyen of this yeu cau giai trinh
	*/
	@Override
	public java.lang.String getMaHuyen() {
		return _yeuCauGiaiTrinh.getMaHuyen();
	}

	/**
	* Sets the ma huyen of this yeu cau giai trinh.
	*
	* @param maHuyen the ma huyen of this yeu cau giai trinh
	*/
	@Override
	public void setMaHuyen(java.lang.String maHuyen) {
		_yeuCauGiaiTrinh.setMaHuyen(maHuyen);
	}

	/**
	* Returns the ma xa of this yeu cau giai trinh.
	*
	* @return the ma xa of this yeu cau giai trinh
	*/
	@Override
	public java.lang.String getMaXa() {
		return _yeuCauGiaiTrinh.getMaXa();
	}

	/**
	* Sets the ma xa of this yeu cau giai trinh.
	*
	* @param maXa the ma xa of this yeu cau giai trinh
	*/
	@Override
	public void setMaXa(java.lang.String maXa) {
		_yeuCauGiaiTrinh.setMaXa(maXa);
	}

	/**
	* Returns the ma chu de of this yeu cau giai trinh.
	*
	* @return the ma chu de of this yeu cau giai trinh
	*/
	@Override
	public java.lang.String getMaChuDe() {
		return _yeuCauGiaiTrinh.getMaChuDe();
	}

	/**
	* Sets the ma chu de of this yeu cau giai trinh.
	*
	* @param maChuDe the ma chu de of this yeu cau giai trinh
	*/
	@Override
	public void setMaChuDe(java.lang.String maChuDe) {
		_yeuCauGiaiTrinh.setMaChuDe(maChuDe);
	}

	/**
	* Returns the trang thai of this yeu cau giai trinh.
	*
	* @return the trang thai of this yeu cau giai trinh
	*/
	@Override
	public int getTrangThai() {
		return _yeuCauGiaiTrinh.getTrangThai();
	}

	/**
	* Sets the trang thai of this yeu cau giai trinh.
	*
	* @param trangThai the trang thai of this yeu cau giai trinh
	*/
	@Override
	public void setTrangThai(int trangThai) {
		_yeuCauGiaiTrinh.setTrangThai(trangThai);
	}

	/**
	* Returns the so luong theo chu de of this yeu cau giai trinh.
	*
	* @return the so luong theo chu de of this yeu cau giai trinh
	*/
	@Override
	public int getSoLuongTheoChuDe() {
		return _yeuCauGiaiTrinh.getSoLuongTheoChuDe();
	}

	/**
	* Sets the so luong theo chu de of this yeu cau giai trinh.
	*
	* @param soLuongTheoChuDe the so luong theo chu de of this yeu cau giai trinh
	*/
	@Override
	public void setSoLuongTheoChuDe(int soLuongTheoChuDe) {
		_yeuCauGiaiTrinh.setSoLuongTheoChuDe(soLuongTheoChuDe);
	}

	/**
	* Returns the user ID of this yeu cau giai trinh.
	*
	* @return the user ID of this yeu cau giai trinh
	*/
	@Override
	public long getUserId() {
		return _yeuCauGiaiTrinh.getUserId();
	}

	/**
	* Sets the user ID of this yeu cau giai trinh.
	*
	* @param userId the user ID of this yeu cau giai trinh
	*/
	@Override
	public void setUserId(long userId) {
		_yeuCauGiaiTrinh.setUserId(userId);
	}

	/**
	* Returns the user uuid of this yeu cau giai trinh.
	*
	* @return the user uuid of this yeu cau giai trinh
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _yeuCauGiaiTrinh.getUserUuid();
	}

	/**
	* Sets the user uuid of this yeu cau giai trinh.
	*
	* @param userUuid the user uuid of this yeu cau giai trinh
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_yeuCauGiaiTrinh.setUserUuid(userUuid);
	}

	/**
	* Returns the ngay tao of this yeu cau giai trinh.
	*
	* @return the ngay tao of this yeu cau giai trinh
	*/
	@Override
	public java.util.Date getNgayTao() {
		return _yeuCauGiaiTrinh.getNgayTao();
	}

	/**
	* Sets the ngay tao of this yeu cau giai trinh.
	*
	* @param ngayTao the ngay tao of this yeu cau giai trinh
	*/
	@Override
	public void setNgayTao(java.util.Date ngayTao) {
		_yeuCauGiaiTrinh.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay cap nhat of this yeu cau giai trinh.
	*
	* @return the ngay cap nhat of this yeu cau giai trinh
	*/
	@Override
	public java.util.Date getNgayCapNhat() {
		return _yeuCauGiaiTrinh.getNgayCapNhat();
	}

	/**
	* Sets the ngay cap nhat of this yeu cau giai trinh.
	*
	* @param ngayCapNhat the ngay cap nhat of this yeu cau giai trinh
	*/
	@Override
	public void setNgayCapNhat(java.util.Date ngayCapNhat) {
		_yeuCauGiaiTrinh.setNgayCapNhat(ngayCapNhat);
	}

	/**
	* Returns the nguoi phe duyet of this yeu cau giai trinh.
	*
	* @return the nguoi phe duyet of this yeu cau giai trinh
	*/
	@Override
	public long getNguoiPheDuyet() {
		return _yeuCauGiaiTrinh.getNguoiPheDuyet();
	}

	/**
	* Sets the nguoi phe duyet of this yeu cau giai trinh.
	*
	* @param nguoiPheDuyet the nguoi phe duyet of this yeu cau giai trinh
	*/
	@Override
	public void setNguoiPheDuyet(long nguoiPheDuyet) {
		_yeuCauGiaiTrinh.setNguoiPheDuyet(nguoiPheDuyet);
	}

	/**
	* Returns the da chuyen sang minh bach of this yeu cau giai trinh.
	*
	* @return the da chuyen sang minh bach of this yeu cau giai trinh
	*/
	@Override
	public int getDaChuyenSangMinhBach() {
		return _yeuCauGiaiTrinh.getDaChuyenSangMinhBach();
	}

	/**
	* Sets the da chuyen sang minh bach of this yeu cau giai trinh.
	*
	* @param daChuyenSangMinhBach the da chuyen sang minh bach of this yeu cau giai trinh
	*/
	@Override
	public void setDaChuyenSangMinhBach(int daChuyenSangMinhBach) {
		_yeuCauGiaiTrinh.setDaChuyenSangMinhBach(daChuyenSangMinhBach);
	}

	/**
	* Returns the ma yeu cau giai trinh of this yeu cau giai trinh.
	*
	* @return the ma yeu cau giai trinh of this yeu cau giai trinh
	*/
	@Override
	public java.lang.String getMaYeuCauGiaiTrinh() {
		return _yeuCauGiaiTrinh.getMaYeuCauGiaiTrinh();
	}

	/**
	* Sets the ma yeu cau giai trinh of this yeu cau giai trinh.
	*
	* @param maYeuCauGiaiTrinh the ma yeu cau giai trinh of this yeu cau giai trinh
	*/
	@Override
	public void setMaYeuCauGiaiTrinh(java.lang.String maYeuCauGiaiTrinh) {
		_yeuCauGiaiTrinh.setMaYeuCauGiaiTrinh(maYeuCauGiaiTrinh);
	}

	@Override
	public boolean isNew() {
		return _yeuCauGiaiTrinh.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_yeuCauGiaiTrinh.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _yeuCauGiaiTrinh.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_yeuCauGiaiTrinh.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _yeuCauGiaiTrinh.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _yeuCauGiaiTrinh.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_yeuCauGiaiTrinh.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _yeuCauGiaiTrinh.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_yeuCauGiaiTrinh.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_yeuCauGiaiTrinh.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_yeuCauGiaiTrinh.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new YeuCauGiaiTrinhWrapper((YeuCauGiaiTrinh)_yeuCauGiaiTrinh.clone());
	}

	@Override
	public int compareTo(
		vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh yeuCauGiaiTrinh) {
		return _yeuCauGiaiTrinh.compareTo(yeuCauGiaiTrinh);
	}

	@Override
	public int hashCode() {
		return _yeuCauGiaiTrinh.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh> toCacheModel() {
		return _yeuCauGiaiTrinh.toCacheModel();
	}

	@Override
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh toEscapedModel() {
		return new YeuCauGiaiTrinhWrapper(_yeuCauGiaiTrinh.toEscapedModel());
	}

	@Override
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh toUnescapedModel() {
		return new YeuCauGiaiTrinhWrapper(_yeuCauGiaiTrinh.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _yeuCauGiaiTrinh.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _yeuCauGiaiTrinh.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_yeuCauGiaiTrinh.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof YeuCauGiaiTrinhWrapper)) {
			return false;
		}

		YeuCauGiaiTrinhWrapper yeuCauGiaiTrinhWrapper = (YeuCauGiaiTrinhWrapper)obj;

		if (Validator.equals(_yeuCauGiaiTrinh,
					yeuCauGiaiTrinhWrapper._yeuCauGiaiTrinh)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public YeuCauGiaiTrinh getWrappedYeuCauGiaiTrinh() {
		return _yeuCauGiaiTrinh;
	}

	@Override
	public YeuCauGiaiTrinh getWrappedModel() {
		return _yeuCauGiaiTrinh;
	}

	@Override
	public void resetOriginalValues() {
		_yeuCauGiaiTrinh.resetOriginalValues();
	}

	private YeuCauGiaiTrinh _yeuCauGiaiTrinh;
}