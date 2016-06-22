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

import vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiLocalServiceUtil;
import vn.dtt.ns.thongtinphanhoi.dao.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tubq
 */
public class ChiTietThongTinPhanHoiClp extends BaseModelImpl<ChiTietThongTinPhanHoi>
	implements ChiTietThongTinPhanHoi {
	public ChiTietThongTinPhanHoiClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ChiTietThongTinPhanHoi.class;
	}

	@Override
	public String getModelClassName() {
		return ChiTietThongTinPhanHoi.class.getName();
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
		attributes.put("thongTinPhanHoiId", getThongTinPhanHoiId());
		attributes.put("maTramCapNuoc", getMaTramCapNuoc());
		attributes.put("noiDungKhacNuoc", getNoiDungKhacNuoc());
		attributes.put("noiDungKhacVeSinh", getNoiDungKhacVeSinh());
		attributes.put("maThongTinPhanAnh", getMaThongTinPhanAnh());
		attributes.put("yeuCauGiaiTrinhId", getYeuCauGiaiTrinhId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long thongTinPhanHoiId = (Long)attributes.get("thongTinPhanHoiId");

		if (thongTinPhanHoiId != null) {
			setThongTinPhanHoiId(thongTinPhanHoiId);
		}

		String maTramCapNuoc = (String)attributes.get("maTramCapNuoc");

		if (maTramCapNuoc != null) {
			setMaTramCapNuoc(maTramCapNuoc);
		}

		String noiDungKhacNuoc = (String)attributes.get("noiDungKhacNuoc");

		if (noiDungKhacNuoc != null) {
			setNoiDungKhacNuoc(noiDungKhacNuoc);
		}

		String noiDungKhacVeSinh = (String)attributes.get("noiDungKhacVeSinh");

		if (noiDungKhacVeSinh != null) {
			setNoiDungKhacVeSinh(noiDungKhacVeSinh);
		}

		String maThongTinPhanAnh = (String)attributes.get("maThongTinPhanAnh");

		if (maThongTinPhanAnh != null) {
			setMaThongTinPhanAnh(maThongTinPhanAnh);
		}

		Long yeuCauGiaiTrinhId = (Long)attributes.get("yeuCauGiaiTrinhId");

		if (yeuCauGiaiTrinhId != null) {
			setYeuCauGiaiTrinhId(yeuCauGiaiTrinhId);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_chiTietThongTinPhanHoiRemoteModel != null) {
			try {
				Class<?> clazz = _chiTietThongTinPhanHoiRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_chiTietThongTinPhanHoiRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getThongTinPhanHoiId() {
		return _thongTinPhanHoiId;
	}

	@Override
	public void setThongTinPhanHoiId(long thongTinPhanHoiId) {
		_thongTinPhanHoiId = thongTinPhanHoiId;

		if (_chiTietThongTinPhanHoiRemoteModel != null) {
			try {
				Class<?> clazz = _chiTietThongTinPhanHoiRemoteModel.getClass();

				Method method = clazz.getMethod("setThongTinPhanHoiId",
						long.class);

				method.invoke(_chiTietThongTinPhanHoiRemoteModel,
					thongTinPhanHoiId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMaTramCapNuoc() {
		return _maTramCapNuoc;
	}

	@Override
	public void setMaTramCapNuoc(String maTramCapNuoc) {
		_maTramCapNuoc = maTramCapNuoc;

		if (_chiTietThongTinPhanHoiRemoteModel != null) {
			try {
				Class<?> clazz = _chiTietThongTinPhanHoiRemoteModel.getClass();

				Method method = clazz.getMethod("setMaTramCapNuoc", String.class);

				method.invoke(_chiTietThongTinPhanHoiRemoteModel, maTramCapNuoc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNoiDungKhacNuoc() {
		return _noiDungKhacNuoc;
	}

	@Override
	public void setNoiDungKhacNuoc(String noiDungKhacNuoc) {
		_noiDungKhacNuoc = noiDungKhacNuoc;

		if (_chiTietThongTinPhanHoiRemoteModel != null) {
			try {
				Class<?> clazz = _chiTietThongTinPhanHoiRemoteModel.getClass();

				Method method = clazz.getMethod("setNoiDungKhacNuoc",
						String.class);

				method.invoke(_chiTietThongTinPhanHoiRemoteModel,
					noiDungKhacNuoc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNoiDungKhacVeSinh() {
		return _noiDungKhacVeSinh;
	}

	@Override
	public void setNoiDungKhacVeSinh(String noiDungKhacVeSinh) {
		_noiDungKhacVeSinh = noiDungKhacVeSinh;

		if (_chiTietThongTinPhanHoiRemoteModel != null) {
			try {
				Class<?> clazz = _chiTietThongTinPhanHoiRemoteModel.getClass();

				Method method = clazz.getMethod("setNoiDungKhacVeSinh",
						String.class);

				method.invoke(_chiTietThongTinPhanHoiRemoteModel,
					noiDungKhacVeSinh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMaThongTinPhanAnh() {
		return _maThongTinPhanAnh;
	}

	@Override
	public void setMaThongTinPhanAnh(String maThongTinPhanAnh) {
		_maThongTinPhanAnh = maThongTinPhanAnh;

		if (_chiTietThongTinPhanHoiRemoteModel != null) {
			try {
				Class<?> clazz = _chiTietThongTinPhanHoiRemoteModel.getClass();

				Method method = clazz.getMethod("setMaThongTinPhanAnh",
						String.class);

				method.invoke(_chiTietThongTinPhanHoiRemoteModel,
					maThongTinPhanAnh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getYeuCauGiaiTrinhId() {
		return _yeuCauGiaiTrinhId;
	}

	@Override
	public void setYeuCauGiaiTrinhId(long yeuCauGiaiTrinhId) {
		_yeuCauGiaiTrinhId = yeuCauGiaiTrinhId;

		if (_chiTietThongTinPhanHoiRemoteModel != null) {
			try {
				Class<?> clazz = _chiTietThongTinPhanHoiRemoteModel.getClass();

				Method method = clazz.getMethod("setYeuCauGiaiTrinhId",
						long.class);

				method.invoke(_chiTietThongTinPhanHoiRemoteModel,
					yeuCauGiaiTrinhId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getChiTietThongTinPhanHoiRemoteModel() {
		return _chiTietThongTinPhanHoiRemoteModel;
	}

	public void setChiTietThongTinPhanHoiRemoteModel(
		BaseModel<?> chiTietThongTinPhanHoiRemoteModel) {
		_chiTietThongTinPhanHoiRemoteModel = chiTietThongTinPhanHoiRemoteModel;
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

		Class<?> remoteModelClass = _chiTietThongTinPhanHoiRemoteModel.getClass();

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

		Object returnValue = method.invoke(_chiTietThongTinPhanHoiRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ChiTietThongTinPhanHoiLocalServiceUtil.addChiTietThongTinPhanHoi(this);
		}
		else {
			ChiTietThongTinPhanHoiLocalServiceUtil.updateChiTietThongTinPhanHoi(this);
		}
	}

	@Override
	public ChiTietThongTinPhanHoi toEscapedModel() {
		return (ChiTietThongTinPhanHoi)ProxyUtil.newProxyInstance(ChiTietThongTinPhanHoi.class.getClassLoader(),
			new Class[] { ChiTietThongTinPhanHoi.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ChiTietThongTinPhanHoiClp clone = new ChiTietThongTinPhanHoiClp();

		clone.setId(getId());
		clone.setThongTinPhanHoiId(getThongTinPhanHoiId());
		clone.setMaTramCapNuoc(getMaTramCapNuoc());
		clone.setNoiDungKhacNuoc(getNoiDungKhacNuoc());
		clone.setNoiDungKhacVeSinh(getNoiDungKhacVeSinh());
		clone.setMaThongTinPhanAnh(getMaThongTinPhanAnh());
		clone.setYeuCauGiaiTrinhId(getYeuCauGiaiTrinhId());

		return clone;
	}

	@Override
	public int compareTo(ChiTietThongTinPhanHoi chiTietThongTinPhanHoi) {
		int value = 0;

		if (getId() < chiTietThongTinPhanHoi.getId()) {
			value = -1;
		}
		else if (getId() > chiTietThongTinPhanHoi.getId()) {
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

		if (!(obj instanceof ChiTietThongTinPhanHoiClp)) {
			return false;
		}

		ChiTietThongTinPhanHoiClp chiTietThongTinPhanHoi = (ChiTietThongTinPhanHoiClp)obj;

		long primaryKey = chiTietThongTinPhanHoi.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", thongTinPhanHoiId=");
		sb.append(getThongTinPhanHoiId());
		sb.append(", maTramCapNuoc=");
		sb.append(getMaTramCapNuoc());
		sb.append(", noiDungKhacNuoc=");
		sb.append(getNoiDungKhacNuoc());
		sb.append(", noiDungKhacVeSinh=");
		sb.append(getNoiDungKhacVeSinh());
		sb.append(", maThongTinPhanAnh=");
		sb.append(getMaThongTinPhanAnh());
		sb.append(", yeuCauGiaiTrinhId=");
		sb.append(getYeuCauGiaiTrinhId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thongTinPhanHoiId</column-name><column-value><![CDATA[");
		sb.append(getThongTinPhanHoiId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maTramCapNuoc</column-name><column-value><![CDATA[");
		sb.append(getMaTramCapNuoc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiDungKhacNuoc</column-name><column-value><![CDATA[");
		sb.append(getNoiDungKhacNuoc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiDungKhacVeSinh</column-name><column-value><![CDATA[");
		sb.append(getNoiDungKhacVeSinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maThongTinPhanAnh</column-name><column-value><![CDATA[");
		sb.append(getMaThongTinPhanAnh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yeuCauGiaiTrinhId</column-name><column-value><![CDATA[");
		sb.append(getYeuCauGiaiTrinhId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _thongTinPhanHoiId;
	private String _maTramCapNuoc;
	private String _noiDungKhacNuoc;
	private String _noiDungKhacVeSinh;
	private String _maThongTinPhanAnh;
	private long _yeuCauGiaiTrinhId;
	private BaseModel<?> _chiTietThongTinPhanHoiRemoteModel;
}