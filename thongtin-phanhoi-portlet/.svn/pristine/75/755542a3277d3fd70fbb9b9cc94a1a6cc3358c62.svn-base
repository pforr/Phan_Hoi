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
 * This class is used by SOAP remote services, specifically {@link vn.dtt.ns.thongtinphanhoi.dao.service.http.ChiTietThongTinPhanHoiServiceSoap}.
 *
 * @author tubq
 * @see vn.dtt.ns.thongtinphanhoi.dao.service.http.ChiTietThongTinPhanHoiServiceSoap
 * @generated
 */
public class ChiTietThongTinPhanHoiSoap implements Serializable {
	public static ChiTietThongTinPhanHoiSoap toSoapModel(
		ChiTietThongTinPhanHoi model) {
		ChiTietThongTinPhanHoiSoap soapModel = new ChiTietThongTinPhanHoiSoap();

		soapModel.setId(model.getId());
		soapModel.setThongTinPhanHoiId(model.getThongTinPhanHoiId());
		soapModel.setMaTramCapNuoc(model.getMaTramCapNuoc());
		soapModel.setNoiDungKhacNuoc(model.getNoiDungKhacNuoc());
		soapModel.setNoiDungKhacVeSinh(model.getNoiDungKhacVeSinh());
		soapModel.setMaThongTinPhanAnh(model.getMaThongTinPhanAnh());
		soapModel.setYeuCauGiaiTrinhId(model.getYeuCauGiaiTrinhId());

		return soapModel;
	}

	public static ChiTietThongTinPhanHoiSoap[] toSoapModels(
		ChiTietThongTinPhanHoi[] models) {
		ChiTietThongTinPhanHoiSoap[] soapModels = new ChiTietThongTinPhanHoiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ChiTietThongTinPhanHoiSoap[][] toSoapModels(
		ChiTietThongTinPhanHoi[][] models) {
		ChiTietThongTinPhanHoiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ChiTietThongTinPhanHoiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ChiTietThongTinPhanHoiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ChiTietThongTinPhanHoiSoap[] toSoapModels(
		List<ChiTietThongTinPhanHoi> models) {
		List<ChiTietThongTinPhanHoiSoap> soapModels = new ArrayList<ChiTietThongTinPhanHoiSoap>(models.size());

		for (ChiTietThongTinPhanHoi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ChiTietThongTinPhanHoiSoap[soapModels.size()]);
	}

	public ChiTietThongTinPhanHoiSoap() {
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

	public long getThongTinPhanHoiId() {
		return _thongTinPhanHoiId;
	}

	public void setThongTinPhanHoiId(long thongTinPhanHoiId) {
		_thongTinPhanHoiId = thongTinPhanHoiId;
	}

	public String getMaTramCapNuoc() {
		return _maTramCapNuoc;
	}

	public void setMaTramCapNuoc(String maTramCapNuoc) {
		_maTramCapNuoc = maTramCapNuoc;
	}

	public String getNoiDungKhacNuoc() {
		return _noiDungKhacNuoc;
	}

	public void setNoiDungKhacNuoc(String noiDungKhacNuoc) {
		_noiDungKhacNuoc = noiDungKhacNuoc;
	}

	public String getNoiDungKhacVeSinh() {
		return _noiDungKhacVeSinh;
	}

	public void setNoiDungKhacVeSinh(String noiDungKhacVeSinh) {
		_noiDungKhacVeSinh = noiDungKhacVeSinh;
	}

	public String getMaThongTinPhanAnh() {
		return _maThongTinPhanAnh;
	}

	public void setMaThongTinPhanAnh(String maThongTinPhanAnh) {
		_maThongTinPhanAnh = maThongTinPhanAnh;
	}

	public long getYeuCauGiaiTrinhId() {
		return _yeuCauGiaiTrinhId;
	}

	public void setYeuCauGiaiTrinhId(long yeuCauGiaiTrinhId) {
		_yeuCauGiaiTrinhId = yeuCauGiaiTrinhId;
	}

	private long _id;
	private long _thongTinPhanHoiId;
	private String _maTramCapNuoc;
	private String _noiDungKhacNuoc;
	private String _noiDungKhacVeSinh;
	private String _maThongTinPhanAnh;
	private long _yeuCauGiaiTrinhId;
}