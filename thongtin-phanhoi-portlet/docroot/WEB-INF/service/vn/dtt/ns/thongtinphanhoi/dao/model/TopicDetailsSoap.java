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
 * This class is used by SOAP remote services, specifically {@link vn.dtt.ns.thongtinphanhoi.dao.service.http.TopicDetailsServiceSoap}.
 *
 * @author tubq
 * @see vn.dtt.ns.thongtinphanhoi.dao.service.http.TopicDetailsServiceSoap
 * @generated
 */
public class TopicDetailsSoap implements Serializable {
	public static TopicDetailsSoap toSoapModel(TopicDetails model) {
		TopicDetailsSoap soapModel = new TopicDetailsSoap();

		soapModel.setId(model.getId());
		soapModel.setSoDienThoai(model.getSoDienThoai());
		soapModel.setThoiGianGoi(model.getThoiGianGoi());
		soapModel.setTongDai(model.getTongDai());
		soapModel.setMaTinh(model.getMaTinh());
		soapModel.setMaHuyen(model.getMaHuyen());
		soapModel.setMaXa(model.getMaXa());
		soapModel.setMaTramCapNuoc(model.getMaTramCapNuoc());
		soapModel.setMaThongTinPhanAnh(model.getMaThongTinPhanAnh());
		soapModel.setNoiDungKhacNuoc(model.getNoiDungKhacNuoc());
		soapModel.setNoiDungKhacVesinh(model.getNoiDungKhacVesinh());
		soapModel.setYeuCauGiaiTrinhId(model.getYeuCauGiaiTrinhId());

		return soapModel;
	}

	public static TopicDetailsSoap[] toSoapModels(TopicDetails[] models) {
		TopicDetailsSoap[] soapModels = new TopicDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TopicDetailsSoap[][] toSoapModels(TopicDetails[][] models) {
		TopicDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TopicDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TopicDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TopicDetailsSoap[] toSoapModels(List<TopicDetails> models) {
		List<TopicDetailsSoap> soapModels = new ArrayList<TopicDetailsSoap>(models.size());

		for (TopicDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TopicDetailsSoap[soapModels.size()]);
	}

	public TopicDetailsSoap() {
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

	public String getMaTramCapNuoc() {
		return _maTramCapNuoc;
	}

	public void setMaTramCapNuoc(String maTramCapNuoc) {
		_maTramCapNuoc = maTramCapNuoc;
	}

	public String getMaThongTinPhanAnh() {
		return _maThongTinPhanAnh;
	}

	public void setMaThongTinPhanAnh(String maThongTinPhanAnh) {
		_maThongTinPhanAnh = maThongTinPhanAnh;
	}

	public String getNoiDungKhacNuoc() {
		return _noiDungKhacNuoc;
	}

	public void setNoiDungKhacNuoc(String noiDungKhacNuoc) {
		_noiDungKhacNuoc = noiDungKhacNuoc;
	}

	public String getNoiDungKhacVesinh() {
		return _noiDungKhacVesinh;
	}

	public void setNoiDungKhacVesinh(String noiDungKhacVesinh) {
		_noiDungKhacVesinh = noiDungKhacVesinh;
	}

	public long getYeuCauGiaiTrinhId() {
		return _yeuCauGiaiTrinhId;
	}

	public void setYeuCauGiaiTrinhId(long yeuCauGiaiTrinhId) {
		_yeuCauGiaiTrinhId = yeuCauGiaiTrinhId;
	}

	private long _id;
	private String _soDienThoai;
	private Date _thoiGianGoi;
	private int _tongDai;
	private String _maTinh;
	private String _maHuyen;
	private String _maXa;
	private String _maTramCapNuoc;
	private String _maThongTinPhanAnh;
	private String _noiDungKhacNuoc;
	private String _noiDungKhacVesinh;
	private long _yeuCauGiaiTrinhId;
}