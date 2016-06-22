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

package vn.dtt.ns.thongtinphanhoi.dao.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoiClp;
import vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoiClp;
import vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetailsClp;
import vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoiClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tubq
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"thongtin-phanhoi-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"thongtin-phanhoi-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "thongtin-phanhoi-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ChiTietThongTinPhanHoiClp.class.getName())) {
			return translateInputChiTietThongTinPhanHoi(oldModel);
		}

		if (oldModelClassName.equals(ThongTinPhanHoiClp.class.getName())) {
			return translateInputThongTinPhanHoi(oldModel);
		}

		if (oldModelClassName.equals(TopicDetailsClp.class.getName())) {
			return translateInputTopicDetails(oldModel);
		}

		if (oldModelClassName.equals(TopicPhanHoiClp.class.getName())) {
			return translateInputTopicPhanHoi(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputChiTietThongTinPhanHoi(
		BaseModel<?> oldModel) {
		ChiTietThongTinPhanHoiClp oldClpModel = (ChiTietThongTinPhanHoiClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getChiTietThongTinPhanHoiRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputThongTinPhanHoi(BaseModel<?> oldModel) {
		ThongTinPhanHoiClp oldClpModel = (ThongTinPhanHoiClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getThongTinPhanHoiRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTopicDetails(BaseModel<?> oldModel) {
		TopicDetailsClp oldClpModel = (TopicDetailsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTopicDetailsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTopicPhanHoi(BaseModel<?> oldModel) {
		TopicPhanHoiClp oldClpModel = (TopicPhanHoiClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTopicPhanHoiRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"vn.dtt.ns.thongtinphanhoi.dao.model.impl.ChiTietThongTinPhanHoiImpl")) {
			return translateOutputChiTietThongTinPhanHoi(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.dtt.ns.thongtinphanhoi.dao.model.impl.ThongTinPhanHoiImpl")) {
			return translateOutputThongTinPhanHoi(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.dtt.ns.thongtinphanhoi.dao.model.impl.TopicDetailsImpl")) {
			return translateOutputTopicDetails(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.dtt.ns.thongtinphanhoi.dao.model.impl.TopicPhanHoiImpl")) {
			return translateOutputTopicPhanHoi(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"vn.dtt.ns.thongtinphanhoi.dao.NoSuchChiTietThongTinPhanHoiException")) {
			return new vn.dtt.ns.thongtinphanhoi.dao.NoSuchChiTietThongTinPhanHoiException();
		}

		if (className.equals(
					"vn.dtt.ns.thongtinphanhoi.dao.NoSuchThongTinPhanHoiException")) {
			return new vn.dtt.ns.thongtinphanhoi.dao.NoSuchThongTinPhanHoiException();
		}

		if (className.equals(
					"vn.dtt.ns.thongtinphanhoi.dao.NoSuchTopicDetailsException")) {
			return new vn.dtt.ns.thongtinphanhoi.dao.NoSuchTopicDetailsException();
		}

		if (className.equals(
					"vn.dtt.ns.thongtinphanhoi.dao.NoSuchTopicPhanHoiException")) {
			return new vn.dtt.ns.thongtinphanhoi.dao.NoSuchTopicPhanHoiException();
		}

		return throwable;
	}

	public static Object translateOutputChiTietThongTinPhanHoi(
		BaseModel<?> oldModel) {
		ChiTietThongTinPhanHoiClp newModel = new ChiTietThongTinPhanHoiClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setChiTietThongTinPhanHoiRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputThongTinPhanHoi(BaseModel<?> oldModel) {
		ThongTinPhanHoiClp newModel = new ThongTinPhanHoiClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setThongTinPhanHoiRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTopicDetails(BaseModel<?> oldModel) {
		TopicDetailsClp newModel = new TopicDetailsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTopicDetailsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTopicPhanHoi(BaseModel<?> oldModel) {
		TopicPhanHoiClp newModel = new TopicPhanHoiClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTopicPhanHoiRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}