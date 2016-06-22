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
import vn.dtt.ns.thongtinphanhoi.dao.service.TopicDetailsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tubq
 */
public class TopicDetailsClp extends BaseModelImpl<TopicDetails>
	implements TopicDetails {
	public TopicDetailsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TopicDetails.class;
	}

	@Override
	public String getModelClassName() {
		return TopicDetails.class.getName();
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
		attributes.put("tongDai", getTongDai());
		attributes.put("maTinh", getMaTinh());
		attributes.put("maHuyen", getMaHuyen());
		attributes.put("maXa", getMaXa());
		attributes.put("maTramCapNuoc", getMaTramCapNuoc());
		attributes.put("maThongTinPhanAnh", getMaThongTinPhanAnh());
		attributes.put("noiDungKhacNuoc", getNoiDungKhacNuoc());
		attributes.put("noiDungKhacVesinh", getNoiDungKhacVesinh());
		attributes.put("yeuCauGiaiTrinhId", getYeuCauGiaiTrinhId());

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

		String maTramCapNuoc = (String)attributes.get("maTramCapNuoc");

		if (maTramCapNuoc != null) {
			setMaTramCapNuoc(maTramCapNuoc);
		}

		String maThongTinPhanAnh = (String)attributes.get("maThongTinPhanAnh");

		if (maThongTinPhanAnh != null) {
			setMaThongTinPhanAnh(maThongTinPhanAnh);
		}

		String noiDungKhacNuoc = (String)attributes.get("noiDungKhacNuoc");

		if (noiDungKhacNuoc != null) {
			setNoiDungKhacNuoc(noiDungKhacNuoc);
		}

		String noiDungKhacVesinh = (String)attributes.get("noiDungKhacVesinh");

		if (noiDungKhacVesinh != null) {
			setNoiDungKhacVesinh(noiDungKhacVesinh);
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

		if (_topicDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _topicDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_topicDetailsRemoteModel, id);
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

		if (_topicDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _topicDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setSoDienThoai", String.class);

				method.invoke(_topicDetailsRemoteModel, soDienThoai);
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

		if (_topicDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _topicDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setThoiGianGoi", Date.class);

				method.invoke(_topicDetailsRemoteModel, thoiGianGoi);
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

		if (_topicDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _topicDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setTongDai", int.class);

				method.invoke(_topicDetailsRemoteModel, tongDai);
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

		if (_topicDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _topicDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setMaTinh", String.class);

				method.invoke(_topicDetailsRemoteModel, maTinh);
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

		if (_topicDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _topicDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setMaHuyen", String.class);

				method.invoke(_topicDetailsRemoteModel, maHuyen);
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

		if (_topicDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _topicDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setMaXa", String.class);

				method.invoke(_topicDetailsRemoteModel, maXa);
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

		if (_topicDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _topicDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setMaTramCapNuoc", String.class);

				method.invoke(_topicDetailsRemoteModel, maTramCapNuoc);
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

		if (_topicDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _topicDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setMaThongTinPhanAnh",
						String.class);

				method.invoke(_topicDetailsRemoteModel, maThongTinPhanAnh);
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

		if (_topicDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _topicDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setNoiDungKhacNuoc",
						String.class);

				method.invoke(_topicDetailsRemoteModel, noiDungKhacNuoc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNoiDungKhacVesinh() {
		return _noiDungKhacVesinh;
	}

	@Override
	public void setNoiDungKhacVesinh(String noiDungKhacVesinh) {
		_noiDungKhacVesinh = noiDungKhacVesinh;

		if (_topicDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _topicDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setNoiDungKhacVesinh",
						String.class);

				method.invoke(_topicDetailsRemoteModel, noiDungKhacVesinh);
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

		if (_topicDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _topicDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setYeuCauGiaiTrinhId",
						long.class);

				method.invoke(_topicDetailsRemoteModel, yeuCauGiaiTrinhId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTopicDetailsRemoteModel() {
		return _topicDetailsRemoteModel;
	}

	public void setTopicDetailsRemoteModel(BaseModel<?> topicDetailsRemoteModel) {
		_topicDetailsRemoteModel = topicDetailsRemoteModel;
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

		Class<?> remoteModelClass = _topicDetailsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_topicDetailsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TopicDetailsLocalServiceUtil.addTopicDetails(this);
		}
		else {
			TopicDetailsLocalServiceUtil.updateTopicDetails(this);
		}
	}

	@Override
	public TopicDetails toEscapedModel() {
		return (TopicDetails)ProxyUtil.newProxyInstance(TopicDetails.class.getClassLoader(),
			new Class[] { TopicDetails.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TopicDetailsClp clone = new TopicDetailsClp();

		clone.setId(getId());
		clone.setSoDienThoai(getSoDienThoai());
		clone.setThoiGianGoi(getThoiGianGoi());
		clone.setTongDai(getTongDai());
		clone.setMaTinh(getMaTinh());
		clone.setMaHuyen(getMaHuyen());
		clone.setMaXa(getMaXa());
		clone.setMaTramCapNuoc(getMaTramCapNuoc());
		clone.setMaThongTinPhanAnh(getMaThongTinPhanAnh());
		clone.setNoiDungKhacNuoc(getNoiDungKhacNuoc());
		clone.setNoiDungKhacVesinh(getNoiDungKhacVesinh());
		clone.setYeuCauGiaiTrinhId(getYeuCauGiaiTrinhId());

		return clone;
	}

	@Override
	public int compareTo(TopicDetails topicDetails) {
		long primaryKey = topicDetails.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TopicDetailsClp)) {
			return false;
		}

		TopicDetailsClp topicDetails = (TopicDetailsClp)obj;

		long primaryKey = topicDetails.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", soDienThoai=");
		sb.append(getSoDienThoai());
		sb.append(", thoiGianGoi=");
		sb.append(getThoiGianGoi());
		sb.append(", tongDai=");
		sb.append(getTongDai());
		sb.append(", maTinh=");
		sb.append(getMaTinh());
		sb.append(", maHuyen=");
		sb.append(getMaHuyen());
		sb.append(", maXa=");
		sb.append(getMaXa());
		sb.append(", maTramCapNuoc=");
		sb.append(getMaTramCapNuoc());
		sb.append(", maThongTinPhanAnh=");
		sb.append(getMaThongTinPhanAnh());
		sb.append(", noiDungKhacNuoc=");
		sb.append(getNoiDungKhacNuoc());
		sb.append(", noiDungKhacVesinh=");
		sb.append(getNoiDungKhacVesinh());
		sb.append(", yeuCauGiaiTrinhId=");
		sb.append(getYeuCauGiaiTrinhId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails");
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
		sb.append(
			"<column><column-name>maTramCapNuoc</column-name><column-value><![CDATA[");
		sb.append(getMaTramCapNuoc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maThongTinPhanAnh</column-name><column-value><![CDATA[");
		sb.append(getMaThongTinPhanAnh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiDungKhacNuoc</column-name><column-value><![CDATA[");
		sb.append(getNoiDungKhacNuoc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiDungKhacVesinh</column-name><column-value><![CDATA[");
		sb.append(getNoiDungKhacVesinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yeuCauGiaiTrinhId</column-name><column-value><![CDATA[");
		sb.append(getYeuCauGiaiTrinhId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _topicDetailsRemoteModel;
}