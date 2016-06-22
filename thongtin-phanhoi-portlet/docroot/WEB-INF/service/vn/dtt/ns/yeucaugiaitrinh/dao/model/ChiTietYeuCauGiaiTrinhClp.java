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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import vn.dtt.ns.yeucaugiaitrinh.dao.service.ChiTietYeuCauGiaiTrinhLocalServiceUtil;
import vn.dtt.ns.yeucaugiaitrinh.dao.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tubq
 */
public class ChiTietYeuCauGiaiTrinhClp extends BaseModelImpl<ChiTietYeuCauGiaiTrinh>
	implements ChiTietYeuCauGiaiTrinh {
	public ChiTietYeuCauGiaiTrinhClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ChiTietYeuCauGiaiTrinh.class;
	}

	@Override
	public String getModelClassName() {
		return ChiTietYeuCauGiaiTrinh.class.getName();
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
		attributes.put("yeuCauGiaiTrinhId", getYeuCauGiaiTrinhId());
		attributes.put("maThongTinPhanAnh", getMaThongTinPhanAnh());
		attributes.put("soLuong", getSoLuong());
		attributes.put("giaiTrinh", getGiaiTrinh());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long yeuCauGiaiTrinhId = (Long)attributes.get("yeuCauGiaiTrinhId");

		if (yeuCauGiaiTrinhId != null) {
			setYeuCauGiaiTrinhId(yeuCauGiaiTrinhId);
		}

		String maThongTinPhanAnh = (String)attributes.get("maThongTinPhanAnh");

		if (maThongTinPhanAnh != null) {
			setMaThongTinPhanAnh(maThongTinPhanAnh);
		}

		Integer soLuong = (Integer)attributes.get("soLuong");

		if (soLuong != null) {
			setSoLuong(soLuong);
		}

		String giaiTrinh = (String)attributes.get("giaiTrinh");

		if (giaiTrinh != null) {
			setGiaiTrinh(giaiTrinh);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_chiTietYeuCauGiaiTrinhRemoteModel != null) {
			try {
				Class<?> clazz = _chiTietYeuCauGiaiTrinhRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_chiTietYeuCauGiaiTrinhRemoteModel, id);
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

		if (_chiTietYeuCauGiaiTrinhRemoteModel != null) {
			try {
				Class<?> clazz = _chiTietYeuCauGiaiTrinhRemoteModel.getClass();

				Method method = clazz.getMethod("setYeuCauGiaiTrinhId",
						long.class);

				method.invoke(_chiTietYeuCauGiaiTrinhRemoteModel,
					yeuCauGiaiTrinhId);
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

		if (_chiTietYeuCauGiaiTrinhRemoteModel != null) {
			try {
				Class<?> clazz = _chiTietYeuCauGiaiTrinhRemoteModel.getClass();

				Method method = clazz.getMethod("setMaThongTinPhanAnh",
						String.class);

				method.invoke(_chiTietYeuCauGiaiTrinhRemoteModel,
					maThongTinPhanAnh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSoLuong() {
		return _soLuong;
	}

	@Override
	public void setSoLuong(int soLuong) {
		_soLuong = soLuong;

		if (_chiTietYeuCauGiaiTrinhRemoteModel != null) {
			try {
				Class<?> clazz = _chiTietYeuCauGiaiTrinhRemoteModel.getClass();

				Method method = clazz.getMethod("setSoLuong", int.class);

				method.invoke(_chiTietYeuCauGiaiTrinhRemoteModel, soLuong);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGiaiTrinh() {
		return _giaiTrinh;
	}

	@Override
	public void setGiaiTrinh(String giaiTrinh) {
		_giaiTrinh = giaiTrinh;

		if (_chiTietYeuCauGiaiTrinhRemoteModel != null) {
			try {
				Class<?> clazz = _chiTietYeuCauGiaiTrinhRemoteModel.getClass();

				Method method = clazz.getMethod("setGiaiTrinh", String.class);

				method.invoke(_chiTietYeuCauGiaiTrinhRemoteModel, giaiTrinh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getChiTietYeuCauGiaiTrinhRemoteModel() {
		return _chiTietYeuCauGiaiTrinhRemoteModel;
	}

	public void setChiTietYeuCauGiaiTrinhRemoteModel(
		BaseModel<?> chiTietYeuCauGiaiTrinhRemoteModel) {
		_chiTietYeuCauGiaiTrinhRemoteModel = chiTietYeuCauGiaiTrinhRemoteModel;
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

		Class<?> remoteModelClass = _chiTietYeuCauGiaiTrinhRemoteModel.getClass();

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

		Object returnValue = method.invoke(_chiTietYeuCauGiaiTrinhRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ChiTietYeuCauGiaiTrinhLocalServiceUtil.addChiTietYeuCauGiaiTrinh(this);
		}
		else {
			ChiTietYeuCauGiaiTrinhLocalServiceUtil.updateChiTietYeuCauGiaiTrinh(this);
		}
	}

	@Override
	public ChiTietYeuCauGiaiTrinh toEscapedModel() {
		return (ChiTietYeuCauGiaiTrinh)ProxyUtil.newProxyInstance(ChiTietYeuCauGiaiTrinh.class.getClassLoader(),
			new Class[] { ChiTietYeuCauGiaiTrinh.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ChiTietYeuCauGiaiTrinhClp clone = new ChiTietYeuCauGiaiTrinhClp();

		clone.setId(getId());
		clone.setYeuCauGiaiTrinhId(getYeuCauGiaiTrinhId());
		clone.setMaThongTinPhanAnh(getMaThongTinPhanAnh());
		clone.setSoLuong(getSoLuong());
		clone.setGiaiTrinh(getGiaiTrinh());

		return clone;
	}

	@Override
	public int compareTo(ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh) {
		int value = 0;

		if (getId() < chiTietYeuCauGiaiTrinh.getId()) {
			value = -1;
		}
		else if (getId() > chiTietYeuCauGiaiTrinh.getId()) {
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

		if (!(obj instanceof ChiTietYeuCauGiaiTrinhClp)) {
			return false;
		}

		ChiTietYeuCauGiaiTrinhClp chiTietYeuCauGiaiTrinh = (ChiTietYeuCauGiaiTrinhClp)obj;

		long primaryKey = chiTietYeuCauGiaiTrinh.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", yeuCauGiaiTrinhId=");
		sb.append(getYeuCauGiaiTrinhId());
		sb.append(", maThongTinPhanAnh=");
		sb.append(getMaThongTinPhanAnh());
		sb.append(", soLuong=");
		sb.append(getSoLuong());
		sb.append(", giaiTrinh=");
		sb.append(getGiaiTrinh());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("vn.dtt.ns.yeucaugiaitrinh.dao.model.ChiTietYeuCauGiaiTrinh");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yeuCauGiaiTrinhId</column-name><column-value><![CDATA[");
		sb.append(getYeuCauGiaiTrinhId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maThongTinPhanAnh</column-name><column-value><![CDATA[");
		sb.append(getMaThongTinPhanAnh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soLuong</column-name><column-value><![CDATA[");
		sb.append(getSoLuong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>giaiTrinh</column-name><column-value><![CDATA[");
		sb.append(getGiaiTrinh());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _yeuCauGiaiTrinhId;
	private String _maThongTinPhanAnh;
	private int _soLuong;
	private String _giaiTrinh;
	private BaseModel<?> _chiTietYeuCauGiaiTrinhRemoteModel;
}