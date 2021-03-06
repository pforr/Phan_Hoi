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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.dtt.ns.yeucaugiaitrinh.dao.service.http.TrangThaiGiaiTrinhServiceSoap}.
 *
 * @author tubq
 * @see vn.dtt.ns.yeucaugiaitrinh.dao.service.http.TrangThaiGiaiTrinhServiceSoap
 * @generated
 */
public class TrangThaiGiaiTrinhSoap implements Serializable {
	public static TrangThaiGiaiTrinhSoap toSoapModel(TrangThaiGiaiTrinh model) {
		TrangThaiGiaiTrinhSoap soapModel = new TrangThaiGiaiTrinhSoap();

		soapModel.setId(model.getId());
		soapModel.setYeuCauGiaiTrinhId(model.getYeuCauGiaiTrinhId());
		soapModel.setTrangThai(model.getTrangThai());
		soapModel.setGhiChuNguoiLap(model.getGhiChuNguoiLap());
		soapModel.setUserId(model.getUserId());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgayCapNhat(model.getNgayCapNhat());
		soapModel.setGhiChuNguoiDuyet(model.getGhiChuNguoiDuyet());

		return soapModel;
	}

	public static TrangThaiGiaiTrinhSoap[] toSoapModels(
		TrangThaiGiaiTrinh[] models) {
		TrangThaiGiaiTrinhSoap[] soapModels = new TrangThaiGiaiTrinhSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TrangThaiGiaiTrinhSoap[][] toSoapModels(
		TrangThaiGiaiTrinh[][] models) {
		TrangThaiGiaiTrinhSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TrangThaiGiaiTrinhSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TrangThaiGiaiTrinhSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TrangThaiGiaiTrinhSoap[] toSoapModels(
		List<TrangThaiGiaiTrinh> models) {
		List<TrangThaiGiaiTrinhSoap> soapModels = new ArrayList<TrangThaiGiaiTrinhSoap>(models.size());

		for (TrangThaiGiaiTrinh model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TrangThaiGiaiTrinhSoap[soapModels.size()]);
	}

	public TrangThaiGiaiTrinhSoap() {
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

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	public String getGhiChuNguoiLap() {
		return _ghiChuNguoiLap;
	}

	public void setGhiChuNguoiLap(String ghiChuNguoiLap) {
		_ghiChuNguoiLap = ghiChuNguoiLap;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public Date getNgayCapNhat() {
		return _ngayCapNhat;
	}

	public void setNgayCapNhat(Date ngayCapNhat) {
		_ngayCapNhat = ngayCapNhat;
	}

	public String getGhiChuNguoiDuyet() {
		return _ghiChuNguoiDuyet;
	}

	public void setGhiChuNguoiDuyet(String ghiChuNguoiDuyet) {
		_ghiChuNguoiDuyet = ghiChuNguoiDuyet;
	}

	private long _id;
	private long _yeuCauGiaiTrinhId;
	private int _trangThai;
	private String _ghiChuNguoiLap;
	private long _userId;
	private Date _ngayTao;
	private Date _ngayCapNhat;
	private String _ghiChuNguoiDuyet;
}