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
 * This class is a wrapper for {@link TopicPhanHoi}.
 * </p>
 *
 * @author tubq
 * @see TopicPhanHoi
 * @generated
 */
public class TopicPhanHoiWrapper implements TopicPhanHoi,
	ModelWrapper<TopicPhanHoi> {
	public TopicPhanHoiWrapper(TopicPhanHoi topicPhanHoi) {
		_topicPhanHoi = topicPhanHoi;
	}

	@Override
	public Class<?> getModelClass() {
		return TopicPhanHoi.class;
	}

	@Override
	public String getModelClassName() {
		return TopicPhanHoi.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("topicCode", getTopicCode());
		attributes.put("maTinh", getMaTinh());
		attributes.put("maHuyen", getMaHuyen());
		attributes.put("maXa", getMaXa());
		attributes.put("topicName", getTopicName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String topicCode = (String)attributes.get("topicCode");

		if (topicCode != null) {
			setTopicCode(topicCode);
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

		String topicName = (String)attributes.get("topicName");

		if (topicName != null) {
			setTopicName(topicName);
		}
	}

	/**
	* Returns the primary key of this topic phan hoi.
	*
	* @return the primary key of this topic phan hoi
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _topicPhanHoi.getPrimaryKey();
	}

	/**
	* Sets the primary key of this topic phan hoi.
	*
	* @param primaryKey the primary key of this topic phan hoi
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_topicPhanHoi.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the topic code of this topic phan hoi.
	*
	* @return the topic code of this topic phan hoi
	*/
	@Override
	public java.lang.String getTopicCode() {
		return _topicPhanHoi.getTopicCode();
	}

	/**
	* Sets the topic code of this topic phan hoi.
	*
	* @param topicCode the topic code of this topic phan hoi
	*/
	@Override
	public void setTopicCode(java.lang.String topicCode) {
		_topicPhanHoi.setTopicCode(topicCode);
	}

	/**
	* Returns the ma tinh of this topic phan hoi.
	*
	* @return the ma tinh of this topic phan hoi
	*/
	@Override
	public java.lang.String getMaTinh() {
		return _topicPhanHoi.getMaTinh();
	}

	/**
	* Sets the ma tinh of this topic phan hoi.
	*
	* @param maTinh the ma tinh of this topic phan hoi
	*/
	@Override
	public void setMaTinh(java.lang.String maTinh) {
		_topicPhanHoi.setMaTinh(maTinh);
	}

	/**
	* Returns the ma huyen of this topic phan hoi.
	*
	* @return the ma huyen of this topic phan hoi
	*/
	@Override
	public java.lang.String getMaHuyen() {
		return _topicPhanHoi.getMaHuyen();
	}

	/**
	* Sets the ma huyen of this topic phan hoi.
	*
	* @param maHuyen the ma huyen of this topic phan hoi
	*/
	@Override
	public void setMaHuyen(java.lang.String maHuyen) {
		_topicPhanHoi.setMaHuyen(maHuyen);
	}

	/**
	* Returns the ma xa of this topic phan hoi.
	*
	* @return the ma xa of this topic phan hoi
	*/
	@Override
	public java.lang.String getMaXa() {
		return _topicPhanHoi.getMaXa();
	}

	/**
	* Sets the ma xa of this topic phan hoi.
	*
	* @param maXa the ma xa of this topic phan hoi
	*/
	@Override
	public void setMaXa(java.lang.String maXa) {
		_topicPhanHoi.setMaXa(maXa);
	}

	/**
	* Returns the topic name of this topic phan hoi.
	*
	* @return the topic name of this topic phan hoi
	*/
	@Override
	public java.lang.String getTopicName() {
		return _topicPhanHoi.getTopicName();
	}

	/**
	* Sets the topic name of this topic phan hoi.
	*
	* @param topicName the topic name of this topic phan hoi
	*/
	@Override
	public void setTopicName(java.lang.String topicName) {
		_topicPhanHoi.setTopicName(topicName);
	}

	@Override
	public boolean isNew() {
		return _topicPhanHoi.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_topicPhanHoi.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _topicPhanHoi.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_topicPhanHoi.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _topicPhanHoi.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _topicPhanHoi.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_topicPhanHoi.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _topicPhanHoi.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_topicPhanHoi.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_topicPhanHoi.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_topicPhanHoi.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TopicPhanHoiWrapper((TopicPhanHoi)_topicPhanHoi.clone());
	}

	@Override
	public int compareTo(
		vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi topicPhanHoi) {
		return _topicPhanHoi.compareTo(topicPhanHoi);
	}

	@Override
	public int hashCode() {
		return _topicPhanHoi.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi> toCacheModel() {
		return _topicPhanHoi.toCacheModel();
	}

	@Override
	public vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi toEscapedModel() {
		return new TopicPhanHoiWrapper(_topicPhanHoi.toEscapedModel());
	}

	@Override
	public vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi toUnescapedModel() {
		return new TopicPhanHoiWrapper(_topicPhanHoi.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _topicPhanHoi.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _topicPhanHoi.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_topicPhanHoi.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TopicPhanHoiWrapper)) {
			return false;
		}

		TopicPhanHoiWrapper topicPhanHoiWrapper = (TopicPhanHoiWrapper)obj;

		if (Validator.equals(_topicPhanHoi, topicPhanHoiWrapper._topicPhanHoi)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TopicPhanHoi getWrappedTopicPhanHoi() {
		return _topicPhanHoi;
	}

	@Override
	public TopicPhanHoi getWrappedModel() {
		return _topicPhanHoi;
	}

	@Override
	public void resetOriginalValues() {
		_topicPhanHoi.resetOriginalValues();
	}

	private TopicPhanHoi _topicPhanHoi;
}