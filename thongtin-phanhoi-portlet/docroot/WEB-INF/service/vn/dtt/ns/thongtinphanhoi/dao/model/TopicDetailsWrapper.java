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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TopicDetails}.
 * </p>
 *
 * @author tubq
 * @see TopicDetails
 * @generated
 */
public class TopicDetailsWrapper implements TopicDetails,
	ModelWrapper<TopicDetails> {
	public TopicDetailsWrapper(TopicDetails topicDetails) {
		_topicDetails = topicDetails;
	}

	@Override
	public Class<?> getModelClass() {
		return TopicDetails.class;
	}

	@Override
	public String getModelClassName() {
		return TopicDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("soDienThoai", getSoDienThoai());
		attributes.put("thoiGianGoi", getThoiGianGoi());
		attributes.put("tongDai", getTongDai());
		attributes.put("maTinh", getMaTinh());
		attributes.put("maHuyen", getMaHuyen());
		attributes.put("maXa", getMaXa());
		attributes.put("maTramCapNuoc", getMaTramCapNuoc());
		attributes.put("maThongTinPhanAnh", getMaThongTinPhanAnh());
		attributes.put("noiDungKhacNuoc", getNoiDungKhacNuoc());
		attributes.put("noiDungKhacVesinh", getNoiDungKhacVesinh());
		attributes.put("yeuCauGiaiTrinhId", getYeuCauGiaiTrinhId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String soDienThoai = (String)attributes.get("soDienThoai");

		if (soDienThoai != null) {
			setSoDienThoai(soDienThoai);
		}

		Date thoiGianGoi = (Date)attributes.get("thoiGianGoi");

		if (thoiGianGoi != null) {
			setThoiGianGoi(thoiGianGoi);
		}

		Integer tongDai = (Integer)attributes.get("tongDai");

		if (tongDai != null) {
			setTongDai(tongDai);
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

		String maTramCapNuoc = (String)attributes.get("maTramCapNuoc");

		if (maTramCapNuoc != null) {
			setMaTramCapNuoc(maTramCapNuoc);
		}

		String maThongTinPhanAnh = (String)attributes.get("maThongTinPhanAnh");

		if (maThongTinPhanAnh != null) {
			setMaThongTinPhanAnh(maThongTinPhanAnh);
		}

		String noiDungKhacNuoc = (String)attributes.get("noiDungKhacNuoc");

		if (noiDungKhacNuoc != null) {
			setNoiDungKhacNuoc(noiDungKhacNuoc);
		}

		String noiDungKhacVesinh = (String)attributes.get("noiDungKhacVesinh");

		if (noiDungKhacVesinh != null) {
			setNoiDungKhacVesinh(noiDungKhacVesinh);
		}

		Long yeuCauGiaiTrinhId = (Long)attributes.get("yeuCauGiaiTrinhId");

		if (yeuCauGiaiTrinhId != null) {
			setYeuCauGiaiTrinhId(yeuCauGiaiTrinhId);
		}
	}

	/**
	* Returns the primary key of this topic details.
	*
	* @return the primary key of this topic details
	*/
	@Override
	public long getPrimaryKey() {
		return _topicDetails.getPrimaryKey();
	}

	/**
	* Sets the primary key of this topic details.
	*
	* @param primaryKey the primary key of this topic details
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_topicDetails.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this topic details.
	*
	* @return the ID of this topic details
	*/
	@Override
	public long getId() {
		return _topicDetails.getId();
	}

	/**
	* Sets the ID of this topic details.
	*
	* @param id the ID of this topic details
	*/
	@Override
	public void setId(long id) {
		_topicDetails.setId(id);
	}

	/**
	* Returns the so dien thoai of this topic details.
	*
	* @return the so dien thoai of this topic details
	*/
	@Override
	public java.lang.String getSoDienThoai() {
		return _topicDetails.getSoDienThoai();
	}

	/**
	* Sets the so dien thoai of this topic details.
	*
	* @param soDienThoai the so dien thoai of this topic details
	*/
	@Override
	public void setSoDienThoai(java.lang.String soDienThoai) {
		_topicDetails.setSoDienThoai(soDienThoai);
	}

	/**
	* Returns the thoi gian goi of this topic details.
	*
	* @return the thoi gian goi of this topic details
	*/
	@Override
	public java.util.Date getThoiGianGoi() {
		return _topicDetails.getThoiGianGoi();
	}

	/**
	* Sets the thoi gian goi of this topic details.
	*
	* @param thoiGianGoi the thoi gian goi of this topic details
	*/
	@Override
	public void setThoiGianGoi(java.util.Date thoiGianGoi) {
		_topicDetails.setThoiGianGoi(thoiGianGoi);
	}

	/**
	* Returns the tong dai of this topic details.
	*
	* @return the tong dai of this topic details
	*/
	@Override
	public int getTongDai() {
		return _topicDetails.getTongDai();
	}

	/**
	* Sets the tong dai of this topic details.
	*
	* @param tongDai the tong dai of this topic details
	*/
	@Override
	public void setTongDai(int tongDai) {
		_topicDetails.setTongDai(tongDai);
	}

	/**
	* Returns the ma tinh of this topic details.
	*
	* @return the ma tinh of this topic details
	*/
	@Override
	public java.lang.String getMaTinh() {
		return _topicDetails.getMaTinh();
	}

	/**
	* Sets the ma tinh of this topic details.
	*
	* @param maTinh the ma tinh of this topic details
	*/
	@Override
	public void setMaTinh(java.lang.String maTinh) {
		_topicDetails.setMaTinh(maTinh);
	}

	/**
	* Returns the ma huyen of this topic details.
	*
	* @return the ma huyen of this topic details
	*/
	@Override
	public java.lang.String getMaHuyen() {
		return _topicDetails.getMaHuyen();
	}

	/**
	* Sets the ma huyen of this topic details.
	*
	* @param maHuyen the ma huyen of this topic details
	*/
	@Override
	public void setMaHuyen(java.lang.String maHuyen) {
		_topicDetails.setMaHuyen(maHuyen);
	}

	/**
	* Returns the ma xa of this topic details.
	*
	* @return the ma xa of this topic details
	*/
	@Override
	public java.lang.String getMaXa() {
		return _topicDetails.getMaXa();
	}

	/**
	* Sets the ma xa of this topic details.
	*
	* @param maXa the ma xa of this topic details
	*/
	@Override
	public void setMaXa(java.lang.String maXa) {
		_topicDetails.setMaXa(maXa);
	}

	/**
	* Returns the ma tram cap nuoc of this topic details.
	*
	* @return the ma tram cap nuoc of this topic details
	*/
	@Override
	public java.lang.String getMaTramCapNuoc() {
		return _topicDetails.getMaTramCapNuoc();
	}

	/**
	* Sets the ma tram cap nuoc of this topic details.
	*
	* @param maTramCapNuoc the ma tram cap nuoc of this topic details
	*/
	@Override
	public void setMaTramCapNuoc(java.lang.String maTramCapNuoc) {
		_topicDetails.setMaTramCapNuoc(maTramCapNuoc);
	}

	/**
	* Returns the ma thong tin phan anh of this topic details.
	*
	* @return the ma thong tin phan anh of this topic details
	*/
	@Override
	public java.lang.String getMaThongTinPhanAnh() {
		return _topicDetails.getMaThongTinPhanAnh();
	}

	/**
	* Sets the ma thong tin phan anh of this topic details.
	*
	* @param maThongTinPhanAnh the ma thong tin phan anh of this topic details
	*/
	@Override
	public void setMaThongTinPhanAnh(java.lang.String maThongTinPhanAnh) {
		_topicDetails.setMaThongTinPhanAnh(maThongTinPhanAnh);
	}

	/**
	* Returns the noi dung khac nuoc of this topic details.
	*
	* @return the noi dung khac nuoc of this topic details
	*/
	@Override
	public java.lang.String getNoiDungKhacNuoc() {
		return _topicDetails.getNoiDungKhacNuoc();
	}

	/**
	* Sets the noi dung khac nuoc of this topic details.
	*
	* @param noiDungKhacNuoc the noi dung khac nuoc of this topic details
	*/
	@Override
	public void setNoiDungKhacNuoc(java.lang.String noiDungKhacNuoc) {
		_topicDetails.setNoiDungKhacNuoc(noiDungKhacNuoc);
	}

	/**
	* Returns the noi dung khac vesinh of this topic details.
	*
	* @return the noi dung khac vesinh of this topic details
	*/
	@Override
	public java.lang.String getNoiDungKhacVesinh() {
		return _topicDetails.getNoiDungKhacVesinh();
	}

	/**
	* Sets the noi dung khac vesinh of this topic details.
	*
	* @param noiDungKhacVesinh the noi dung khac vesinh of this topic details
	*/
	@Override
	public void setNoiDungKhacVesinh(java.lang.String noiDungKhacVesinh) {
		_topicDetails.setNoiDungKhacVesinh(noiDungKhacVesinh);
	}

	/**
	* Returns the yeu cau giai trinh ID of this topic details.
	*
	* @return the yeu cau giai trinh ID of this topic details
	*/
	@Override
	public long getYeuCauGiaiTrinhId() {
		return _topicDetails.getYeuCauGiaiTrinhId();
	}

	/**
	* Sets the yeu cau giai trinh ID of this topic details.
	*
	* @param yeuCauGiaiTrinhId the yeu cau giai trinh ID of this topic details
	*/
	@Override
	public void setYeuCauGiaiTrinhId(long yeuCauGiaiTrinhId) {
		_topicDetails.setYeuCauGiaiTrinhId(yeuCauGiaiTrinhId);
	}

	@Override
	public boolean isNew() {
		return _topicDetails.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_topicDetails.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _topicDetails.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_topicDetails.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _topicDetails.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _topicDetails.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_topicDetails.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _topicDetails.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_topicDetails.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_topicDetails.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_topicDetails.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TopicDetailsWrapper((TopicDetails)_topicDetails.clone());
	}

	@Override
	public int compareTo(
		vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails topicDetails) {
		return _topicDetails.compareTo(topicDetails);
	}

	@Override
	public int hashCode() {
		return _topicDetails.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails> toCacheModel() {
		return _topicDetails.toCacheModel();
	}

	@Override
	public vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails toEscapedModel() {
		return new TopicDetailsWrapper(_topicDetails.toEscapedModel());
	}

	@Override
	public vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails toUnescapedModel() {
		return new TopicDetailsWrapper(_topicDetails.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _topicDetails.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _topicDetails.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_topicDetails.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TopicDetailsWrapper)) {
			return false;
		}

		TopicDetailsWrapper topicDetailsWrapper = (TopicDetailsWrapper)obj;

		if (Validator.equals(_topicDetails, topicDetailsWrapper._topicDetails)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TopicDetails getWrappedTopicDetails() {
		return _topicDetails;
	}

	@Override
	public TopicDetails getWrappedModel() {
		return _topicDetails;
	}

	@Override
	public void resetOriginalValues() {
		_topicDetails.resetOriginalValues();
	}

	private TopicDetails _topicDetails;
}