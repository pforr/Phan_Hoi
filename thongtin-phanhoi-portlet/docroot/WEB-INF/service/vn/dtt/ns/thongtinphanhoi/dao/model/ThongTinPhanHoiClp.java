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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import vn.dtt.ns.thongtinphanhoi.dao.service.ClpSerializer;
import vn.dtt.ns.thongtinphanhoi.dao.service.ThongTinPhanHoiLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tubq
 */
public class ThongTinPhanHoiClp extends BaseModelImpl<ThongTinPhanHoi>
	implements ThongTinPhanHoi {
	public ThongTinPhanHoiClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ThongTinPhanHoi.class;
	}

	@Override
	public String getModelClassName() {
		return ThongTinPhanHoi.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("soDienThoai", getSoDienThoai());
		attributes.put("thoiGianGoi", getThoiGianGoi());
		attributes.put("trangThaiGiaoDich", getTrangThaiGiaoDich());
		attributes.put("tongDai", getTongDai());
		attributes.put("maTinh", getMaTinh());
		attributes.put("maHuyen", getMaHuyen());
		attributes.put("maXa", getMaXa());

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

		Integer trangThaiGiaoDich = (Integer)attributes.get("trangThaiGiaoDich");

		if (trangThaiGiaoDich != null) {
			setTrangThaiGiaoDich(trangThaiGiaoDich);
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
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_thongTinPhanHoiRemoteModel != null) {
			try {
				Class<?> clazz = _thongTinPhanHoiRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_thongTinPhanHoiRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSoDienThoai() {
		return _soDienThoai;
	}

	@Override
	public void setSoDienThoai(String soDienThoai) {
		_soDienThoai = soDienThoai;

		if (_thongTinPhanHoiRemoteModel != null) {
			try {
				Class<?> clazz = _thongTinPhanHoiRemoteModel.getClass();

				Method method = clazz.getMethod("setSoDienThoai", String.class);

				method.invoke(_thongTinPhanHoiRemoteModel, soDienThoai);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getThoiGianGoi() {
		return _thoiGianGoi;
	}

	@Override
	public void setThoiGianGoi(Date thoiGianGoi) {
		_thoiGianGoi = thoiGianGoi;

		if (_thongTinPhanHoiRemoteModel != null) {
			try {
				Class<?> clazz = _thongTinPhanHoiRemoteModel.getClass();

				Method method = clazz.getMethod("setThoiGianGoi", Date.class);

				method.invoke(_thongTinPhanHoiRemoteModel, thoiGianGoi);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTrangThaiGiaoDich() {
		return _trangThaiGiaoDich;
	}

	@Override
	public void setTrangThaiGiaoDich(int trangThaiGiaoDich) {
		_trangThaiGiaoDich = trangThaiGiaoDich;

		if (_thongTinPhanHoiRemoteModel != null) {
			try {
				Class<?> clazz = _thongTinPhanHoiRemoteModel.getClass();

				Method method = clazz.getMethod("setTrangThaiGiaoDich",
						int.class);

				method.invoke(_thongTinPhanHoiRemoteModel, trangThaiGiaoDich);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTongDai() {
		return _tongDai;
	}

	@Override
	public void setTongDai(int tongDai) {
		_tongDai = tongDai;

		if (_thongTinPhanHoiRemoteModel != null) {
			try {
				Class<?> clazz = _thongTinPhanHoiRemoteModel.getClass();

				Method method = clazz.getMethod("setTongDai", int.class);

				method.invoke(_thongTinPhanHoiRemoteModel, tongDai);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMaTinh() {
		return _maTinh;
	}

	@Override
	public void setMaTinh(String maTinh) {
		_maTinh = maTinh;

		if (_thongTinPhanHoiRemoteModel != null) {
			try {
				Class<?> clazz = _thongTinPhanHoiRemoteModel.getClass();

				Method method = clazz.getMethod("setMaTinh", String.class);

				method.invoke(_thongTinPhanHoiRemoteModel, maTinh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMaHuyen() {
		return _maHuyen;
	}

	@Override
	public void setMaHuyen(String maHuyen) {
		_maHuyen = maHuyen;

		if (_thongTinPhanHoiRemoteModel != null) {
			try {
				Class<?> clazz = _thongTinPhanHoiRemoteModel.getClass();

				Method method = clazz.getMethod("setMaHuyen", String.class);

				method.invoke(_thongTinPhanHoiRemoteModel, maHuyen);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMaXa() {
		return _maXa;
	}

	@Override
	public void setMaXa(String maXa) {
		_maXa = maXa;

		if (_thongTinPhanHoiRemoteModel != null) {
			try {
				Class<?> clazz = _thongTinPhanHoiRemoteModel.getClass();

				Method method = clazz.getMethod("setMaXa", String.class);

				method.invoke(_thongTinPhanHoiRemoteModel, maXa);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getThongTinPhanHoiRemoteModel() {
		return _thongTinPhanHoiRemoteModel;
	}

	public void setThongTinPhanHoiRemoteModel(
		BaseModel<?> thongTinPhanHoiRemoteModel) {
		_thongTinPhanHoiRemoteModel = thongTinPhanHoiRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _thongTinPhanHoiRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_thongTinPhanHoiRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ThongTinPhanHoiLocalServiceUtil.addThongTinPhanHoi(this);
		}
		else {
			ThongTinPhanHoiLocalServiceUtil.updateThongTinPhanHoi(this);
		}
	}

	@Override
	public ThongTinPhanHoi toEscapedModel() {
		return (ThongTinPhanHoi)ProxyUtil.newProxyInstance(ThongTinPhanHoi.class.getClassLoader(),
			new Class[] { ThongTinPhanHoi.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ThongTinPhanHoiClp clone = new ThongTinPhanHoiClp();

		clone.setId(getId());
		clone.setSoDienThoai(getSoDienThoai());
		clone.setThoiGianGoi(getThoiGianGoi());
		clone.setTrangThaiGiaoDich(getTrangThaiGiaoDich());
		clone.setTongDai(getTongDai());
		clone.setMaTinh(getMaTinh());
		clone.setMaHuyen(getMaHuyen());
		clone.setMaXa(getMaXa());

		return clone;
	}

	@Override
	public int compareTo(ThongTinPhanHoi thongTinPhanHoi) {
		int value = 0;

		if (getId() < thongTinPhanHoi.getId()) {
			value = -1;
		}
		else if (getId() > thongTinPhanHoi.getId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ThongTinPhanHoiClp)) {
			return false;
		}

		ThongTinPhanHoiClp thongTinPhanHoi = (ThongTinPhanHoiClp)obj;

		long primaryKey = thongTinPhanHoi.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", soDienThoai=");
		sb.append(getSoDienThoai());
		sb.append(", thoiGianGoi=");
		sb.append(getThoiGianGoi());
		sb.append(", trangThaiGiaoDich=");
		sb.append(getTrangThaiGiaoDich());
		sb.append(", tongDai=");
		sb.append(getTongDai());
		sb.append(", maTinh=");
		sb.append(getMaTinh());
		sb.append(", maHuyen=");
		sb.append(getMaHuyen());
		sb.append(", maXa=");
		sb.append(getMaXa());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soDienThoai</column-name><column-value><![CDATA[");
		sb.append(getSoDienThoai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thoiGianGoi</column-name><column-value><![CDATA[");
		sb.append(getThoiGianGoi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThaiGiaoDich</column-name><column-value><![CDATA[");
		sb.append(getTrangThaiGiaoDich());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tongDai</column-name><column-value><![CDATA[");
		sb.append(getTongDai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maTinh</column-name><column-value><![CDATA[");
		sb.append(getMaTinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maHuyen</column-name><column-value><![CDATA[");
		sb.append(getMaHuyen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maXa</column-name><column-value><![CDATA[");
		sb.append(getMaXa());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _soDienThoai;
	private Date _thoiGianGoi;
	private int _trangThaiGiaoDich;
	private int _tongDai;
	private String _maTinh;
	private String _maHuyen;
	private String _maXa;
	private BaseModel<?> _thongTinPhanHoiRemoteModel;
}