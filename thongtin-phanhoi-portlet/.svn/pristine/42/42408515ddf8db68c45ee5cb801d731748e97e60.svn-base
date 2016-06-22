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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.dtt.ns.thongtinphanhoi.dao.service.http.ThongTinPhanHoiServiceSoap}.
 *
 * @author tubq
 * @see vn.dtt.ns.thongtinphanhoi.dao.service.http.ThongTinPhanHoiServiceSoap
 * @generated
 */
public class ThongTinPhanHoiSoap implements Serializable {
	public static ThongTinPhanHoiSoap toSoapModel(ThongTinPhanHoi model) {
		ThongTinPhanHoiSoap soapModel = new ThongTinPhanHoiSoap();

		soapModel.setId(model.getId());
		soapModel.setSoDienThoai(model.getSoDienThoai());
		soapModel.setThoiGianGoi(model.getThoiGianGoi());
		soapModel.setTrangThaiGiaoDich(model.getTrangThaiGiaoDich());
		soapModel.setTongDai(model.getTongDai());
		soapModel.setMaTinh(model.getMaTinh());
		soapModel.setMaHuyen(model.getMaHuyen());
		soapModel.setMaXa(model.getMaXa());

		return soapModel;
	}

	public static ThongTinPhanHoiSoap[] toSoapModels(ThongTinPhanHoi[] models) {
		ThongTinPhanHoiSoap[] soapModels = new ThongTinPhanHoiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ThongTinPhanHoiSoap[][] toSoapModels(
		ThongTinPhanHoi[][] models) {
		ThongTinPhanHoiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ThongTinPhanHoiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ThongTinPhanHoiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ThongTinPhanHoiSoap[] toSoapModels(
		List<ThongTinPhanHoi> models) {
		List<ThongTinPhanHoiSoap> soapModels = new ArrayList<ThongTinPhanHoiSoap>(models.size());

		for (ThongTinPhanHoi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ThongTinPhanHoiSoap[soapModels.size()]);
	}

	public ThongTinPhanHoiSoap() {
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

	public String getSoDienThoai() {
		return _soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		_soDienThoai = soDienThoai;
	}

	public Date getThoiGianGoi() {
		return _thoiGianGoi;
	}

	public void setThoiGianGoi(Date thoiGianGoi) {
		_thoiGianGoi = thoiGianGoi;
	}

	public int getTrangThaiGiaoDich() {
		return _trangThaiGiaoDich;
	}

	public void setTrangThaiGiaoDich(int trangThaiGiaoDich) {
		_trangThaiGiaoDich = trangThaiGiaoDich;
	}

	public int getTongDai() {
		return _tongDai;
	}

	public void setTongDai(int tongDai) {
		_tongDai = tongDai;
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

	private long _id;
	private String _soDienThoai;
	private Date _thoiGianGoi;
	private int _trangThaiGiaoDich;
	private int _tongDai;
	private String _maTinh;
	private String _maHuyen;
	private String _maXa;
}