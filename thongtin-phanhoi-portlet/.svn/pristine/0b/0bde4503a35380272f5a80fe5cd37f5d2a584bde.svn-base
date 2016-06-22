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
import vn.dtt.ns.thongtinphanhoi.dao.service.TopicPhanHoiLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tubq
 */
public class TopicPhanHoiClp extends BaseModelImpl<TopicPhanHoi>
	implements TopicPhanHoi {
	public TopicPhanHoiClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TopicPhanHoi.class;
	}

	@Override
	public String getModelClassName() {
		return TopicPhanHoi.class.getName();
	}

	@Override
	public String getPrimaryKey() {
		return _topicCode;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setTopicCode(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _topicCode;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("topicCode", getTopicCode());
		attributes.put("maTinh", getMaTinh());
		attributes.put("maHuyen", getMaHuyen());
		attributes.put("maXa", getMaXa());
		attributes.put("topicName", getTopicName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String topicCode = (String)attributes.get("topicCode");

		if (topicCode != null) {
			setTopicCode(topicCode);
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

		String topicName = (String)attributes.get("topicName");

		if (topicName != null) {
			setTopicName(topicName);
		}
	}

	@Override
	public String getTopicCode() {
		return _topicCode;
	}

	@Override
	public void setTopicCode(String topicCode) {
		_topicCode = topicCode;

		if (_topicPhanHoiRemoteModel != null) {
			try {
				Class<?> clazz = _topicPhanHoiRemoteModel.getClass();

				Method method = clazz.getMethod("setTopicCode", String.class);

				method.invoke(_topicPhanHoiRemoteModel, topicCode);
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

		if (_topicPhanHoiRemoteModel != null) {
			try {
				Class<?> clazz = _topicPhanHoiRemoteModel.getClass();

				Method method = clazz.getMethod("setMaTinh", String.class);

				method.invoke(_topicPhanHoiRemoteModel, maTinh);
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

		if (_topicPhanHoiRemoteModel != null) {
			try {
				Class<?> clazz = _topicPhanHoiRemoteModel.getClass();

				Method method = clazz.getMethod("setMaHuyen", String.class);

				method.invoke(_topicPhanHoiRemoteModel, maHuyen);
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

		if (_topicPhanHoiRemoteModel != null) {
			try {
				Class<?> clazz = _topicPhanHoiRemoteModel.getClass();

				Method method = clazz.getMethod("setMaXa", String.class);

				method.invoke(_topicPhanHoiRemoteModel, maXa);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTopicName() {
		return _topicName;
	}

	@Override
	public void setTopicName(String topicName) {
		_topicName = topicName;

		if (_topicPhanHoiRemoteModel != null) {
			try {
				Class<?> clazz = _topicPhanHoiRemoteModel.getClass();

				Method method = clazz.getMethod("setTopicName", String.class);

				method.invoke(_topicPhanHoiRemoteModel, topicName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTopicPhanHoiRemoteModel() {
		return _topicPhanHoiRemoteModel;
	}

	public void setTopicPhanHoiRemoteModel(BaseModel<?> topicPhanHoiRemoteModel) {
		_topicPhanHoiRemoteModel = topicPhanHoiRemoteModel;
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

		Class<?> remoteModelClass = _topicPhanHoiRemoteModel.getClass();

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

		Object returnValue = method.invoke(_topicPhanHoiRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TopicPhanHoiLocalServiceUtil.addTopicPhanHoi(this);
		}
		else {
			TopicPhanHoiLocalServiceUtil.updateTopicPhanHoi(this);
		}
	}

	@Override
	public TopicPhanHoi toEscapedModel() {
		return (TopicPhanHoi)ProxyUtil.newProxyInstance(TopicPhanHoi.class.getClassLoader(),
			new Class[] { TopicPhanHoi.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TopicPhanHoiClp clone = new TopicPhanHoiClp();

		clone.setTopicCode(getTopicCode());
		clone.setMaTinh(getMaTinh());
		clone.setMaHuyen(getMaHuyen());
		clone.setMaXa(getMaXa());
		clone.setTopicName(getTopicName());

		return clone;
	}

	@Override
	public int compareTo(TopicPhanHoi topicPhanHoi) {
		String primaryKey = topicPhanHoi.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TopicPhanHoiClp)) {
			return false;
		}

		TopicPhanHoiClp topicPhanHoi = (TopicPhanHoiClp)obj;

		String primaryKey = topicPhanHoi.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{topicCode=");
		sb.append(getTopicCode());
		sb.append(", maTinh=");
		sb.append(getMaTinh());
		sb.append(", maHuyen=");
		sb.append(getMaHuyen());
		sb.append(", maXa=");
		sb.append(getMaXa());
		sb.append(", topicName=");
		sb.append(getTopicName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>topicCode</column-name><column-value><![CDATA[");
		sb.append(getTopicCode());
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
			"<column><column-name>topicName</column-name><column-value><![CDATA[");
		sb.append(getTopicName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _topicCode;
	private String _maTinh;
	private String _maHuyen;
	private String _maXa;
	private String _topicName;
	private BaseModel<?> _topicPhanHoiRemoteModel;
}