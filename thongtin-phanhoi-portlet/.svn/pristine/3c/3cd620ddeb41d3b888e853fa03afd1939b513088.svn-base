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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.dtt.ns.yeucaugiaitrinh.dao.service.http.ChiTietYeuCauGiaiTrinhServiceSoap}.
 *
 * @author tubq
 * @see vn.dtt.ns.yeucaugiaitrinh.dao.service.http.ChiTietYeuCauGiaiTrinhServiceSoap
 * @generated
 */
public class ChiTietYeuCauGiaiTrinhSoap implements Serializable {
	public static ChiTietYeuCauGiaiTrinhSoap toSoapModel(
		ChiTietYeuCauGiaiTrinh model) {
		ChiTietYeuCauGiaiTrinhSoap soapModel = new ChiTietYeuCauGiaiTrinhSoap();

		soapModel.setId(model.getId());
		soapModel.setYeuCauGiaiTrinhId(model.getYeuCauGiaiTrinhId());
		soapModel.setMaThongTinPhanAnh(model.getMaThongTinPhanAnh());
		soapModel.setSoLuong(model.getSoLuong());
		soapModel.setGiaiTrinh(model.getGiaiTrinh());

		return soapModel;
	}

	public static ChiTietYeuCauGiaiTrinhSoap[] toSoapModels(
		ChiTietYeuCauGiaiTrinh[] models) {
		ChiTietYeuCauGiaiTrinhSoap[] soapModels = new ChiTietYeuCauGiaiTrinhSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ChiTietYeuCauGiaiTrinhSoap[][] toSoapModels(
		ChiTietYeuCauGiaiTrinh[][] models) {
		ChiTietYeuCauGiaiTrinhSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ChiTietYeuCauGiaiTrinhSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ChiTietYeuCauGiaiTrinhSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ChiTietYeuCauGiaiTrinhSoap[] toSoapModels(
		List<ChiTietYeuCauGiaiTrinh> models) {
		List<ChiTietYeuCauGiaiTrinhSoap> soapModels = new ArrayList<ChiTietYeuCauGiaiTrinhSoap>(models.size());

		for (ChiTietYeuCauGiaiTrinh model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ChiTietYeuCauGiaiTrinhSoap[soapModels.size()]);
	}

	public ChiTietYeuCauGiaiTrinhSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getYeuCauGiaiTrinhId() {
		return _yeuCauGiaiTrinhId;
	}

	public void setYeuCauGiaiTrinhId(long yeuCauGiaiTrinhId) {
		_yeuCauGiaiTrinhId = yeuCauGiaiTrinhId;
	}

	public String getMaThongTinPhanAnh() {
		return _maThongTinPhanAnh;
	}

	public void setMaThongTinPhanAnh(String maThongTinPhanAnh) {
		_maThongTinPhanAnh = maThongTinPhanAnh;
	}

	public int getSoLuong() {
		return _soLuong;
	}

	public void setSoLuong(int soLuong) {
		_soLuong = soLuong;
	}

	public String getGiaiTrinh() {
		return _giaiTrinh;
	}

	public void setGiaiTrinh(String giaiTrinh) {
		_giaiTrinh = giaiTrinh;
	}

	private long _id;
	private long _yeuCauGiaiTrinhId;
	private String _maThongTinPhanAnh;
	private int _soLuong;
	private String _giaiTrinh;
}