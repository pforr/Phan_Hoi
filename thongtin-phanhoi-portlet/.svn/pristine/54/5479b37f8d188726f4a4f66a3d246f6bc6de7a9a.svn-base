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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.dtt.ns.thongtinphanhoi.dao.service.http.TopicPhanHoiServiceSoap}.
 *
 * @author tubq
 * @see vn.dtt.ns.thongtinphanhoi.dao.service.http.TopicPhanHoiServiceSoap
 * @generated
 */
public class TopicPhanHoiSoap implements Serializable {
	public static TopicPhanHoiSoap toSoapModel(TopicPhanHoi model) {
		TopicPhanHoiSoap soapModel = new TopicPhanHoiSoap();

		soapModel.setTopicCode(model.getTopicCode());
		soapModel.setMaTinh(model.getMaTinh());
		soapModel.setMaHuyen(model.getMaHuyen());
		soapModel.setMaXa(model.getMaXa());
		soapModel.setTopicName(model.getTopicName());

		return soapModel;
	}

	public static TopicPhanHoiSoap[] toSoapModels(TopicPhanHoi[] models) {
		TopicPhanHoiSoap[] soapModels = new TopicPhanHoiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TopicPhanHoiSoap[][] toSoapModels(TopicPhanHoi[][] models) {
		TopicPhanHoiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TopicPhanHoiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TopicPhanHoiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TopicPhanHoiSoap[] toSoapModels(List<TopicPhanHoi> models) {
		List<TopicPhanHoiSoap> soapModels = new ArrayList<TopicPhanHoiSoap>(models.size());

		for (TopicPhanHoi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TopicPhanHoiSoap[soapModels.size()]);
	}

	public TopicPhanHoiSoap() {
	}

	public String getPrimaryKey() {
		return _topicCode;
	}

	public void setPrimaryKey(String pk) {
		setTopicCode(pk);
	}

	public String getTopicCode() {
		return _topicCode;
	}

	public void setTopicCode(String topicCode) {
		_topicCode = topicCode;
	}

	public String getMaTinh() {
		return _maTinh;
	}

	public void setMaTinh(String maTinh) {
		_maTinh = maTinh;
	}

	public String getMaHuyen() {
		return _maHuyen;
	}

	public void setMaHuyen(String maHuyen) {
		_maHuyen = maHuyen;
	}

	public String getMaXa() {
		return _maXa;
	}

	public void setMaXa(String maXa) {
		_maXa = maXa;
	}

	public String getTopicName() {
		return _topicName;
	}

	public void setTopicName(String topicName) {
		_topicName = topicName;
	}

	private String _topicCode;
	private String _maTinh;
	private String _maHuyen;
	private String _maXa;
	private String _topicName;
}