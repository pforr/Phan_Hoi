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

package vn.dtt.ns.thongtinphanhoi.dao.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails;
import vn.dtt.ns.thongtinphanhoi.dao.service.TopicDetailsService;
import vn.dtt.ns.thongtinphanhoi.dao.service.persistence.ChiTietThongTinPhanHoiFinder;
import vn.dtt.ns.thongtinphanhoi.dao.service.persistence.ChiTietThongTinPhanHoiPersistence;
import vn.dtt.ns.thongtinphanhoi.dao.service.persistence.ThongTinPhanHoiPersistence;
import vn.dtt.ns.thongtinphanhoi.dao.service.persistence.TopicDetailsPersistence;
import vn.dtt.ns.thongtinphanhoi.dao.service.persistence.TopicPhanHoiPersistence;
import vn.dtt.ns.thongtinphanhoi.dao.service.persistence.TrangThaiThongKePhanHoiPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the topic details remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link vn.dtt.ns.thongtinphanhoi.dao.service.impl.TopicDetailsServiceImpl}.
 * </p>
 *
 * @author tubq
 * @see vn.dtt.ns.thongtinphanhoi.dao.service.impl.TopicDetailsServiceImpl
 * @see vn.dtt.ns.thongtinphanhoi.dao.service.TopicDetailsServiceUtil
 * @generated
 */
public abstract class TopicDetailsServiceBaseImpl extends BaseServiceImpl
	implements TopicDetailsService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link vn.dtt.ns.thongtinphanhoi.dao.service.TopicDetailsServiceUtil} to access the topic details remote service.
	 */

	/**
	 * Returns the chi tiet thong tin phan hoi local service.
	 *
	 * @return the chi tiet thong tin phan hoi local service
	 */
	public vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiLocalService getChiTietThongTinPhanHoiLocalService() {
		return chiTietThongTinPhanHoiLocalService;
	}

	/**
	 * Sets the chi tiet thong tin phan hoi local service.
	 *
	 * @param chiTietThongTinPhanHoiLocalService the chi tiet thong tin phan hoi local service
	 */
	public void setChiTietThongTinPhanHoiLocalService(
		vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiLocalService chiTietThongTinPhanHoiLocalService) {
		this.chiTietThongTinPhanHoiLocalService = chiTietThongTinPhanHoiLocalService;
	}

	/**
	 * Returns the chi tiet thong tin phan hoi remote service.
	 *
	 * @return the chi tiet thong tin phan hoi remote service
	 */
	public vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiService getChiTietThongTinPhanHoiService() {
		return chiTietThongTinPhanHoiService;
	}

	/**
	 * Sets the chi tiet thong tin phan hoi remote service.
	 *
	 * @param chiTietThongTinPhanHoiService the chi tiet thong tin phan hoi remote service
	 */
	public void setChiTietThongTinPhanHoiService(
		vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiService chiTietThongTinPhanHoiService) {
		this.chiTietThongTinPhanHoiService = chiTietThongTinPhanHoiService;
	}

	/**
	 * Returns the chi tiet thong tin phan hoi persistence.
	 *
	 * @return the chi tiet thong tin phan hoi persistence
	 */
	public ChiTietThongTinPhanHoiPersistence getChiTietThongTinPhanHoiPersistence() {
		return chiTietThongTinPhanHoiPersistence;
	}

	/**
	 * Sets the chi tiet thong tin phan hoi persistence.
	 *
	 * @param chiTietThongTinPhanHoiPersistence the chi tiet thong tin phan hoi persistence
	 */
	public void setChiTietThongTinPhanHoiPersistence(
		ChiTietThongTinPhanHoiPersistence chiTietThongTinPhanHoiPersistence) {
		this.chiTietThongTinPhanHoiPersistence = chiTietThongTinPhanHoiPersistence;
	}

	/**
	 * Returns the chi tiet thong tin phan hoi finder.
	 *
	 * @return the chi tiet thong tin phan hoi finder
	 */
	public ChiTietThongTinPhanHoiFinder getChiTietThongTinPhanHoiFinder() {
		return chiTietThongTinPhanHoiFinder;
	}

	/**
	 * Sets the chi tiet thong tin phan hoi finder.
	 *
	 * @param chiTietThongTinPhanHoiFinder the chi tiet thong tin phan hoi finder
	 */
	public void setChiTietThongTinPhanHoiFinder(
		ChiTietThongTinPhanHoiFinder chiTietThongTinPhanHoiFinder) {
		this.chiTietThongTinPhanHoiFinder = chiTietThongTinPhanHoiFinder;
	}

	/**
	 * Returns the thong tin phan hoi local service.
	 *
	 * @return the thong tin phan hoi local service
	 */
	public vn.dtt.ns.thongtinphanhoi.dao.service.ThongTinPhanHoiLocalService getThongTinPhanHoiLocalService() {
		return thongTinPhanHoiLocalService;
	}

	/**
	 * Sets the thong tin phan hoi local service.
	 *
	 * @param thongTinPhanHoiLocalService the thong tin phan hoi local service
	 */
	public void setThongTinPhanHoiLocalService(
		vn.dtt.ns.thongtinphanhoi.dao.service.ThongTinPhanHoiLocalService thongTinPhanHoiLocalService) {
		this.thongTinPhanHoiLocalService = thongTinPhanHoiLocalService;
	}

	/**
	 * Returns the thong tin phan hoi remote service.
	 *
	 * @return the thong tin phan hoi remote service
	 */
	public vn.dtt.ns.thongtinphanhoi.dao.service.ThongTinPhanHoiService getThongTinPhanHoiService() {
		return thongTinPhanHoiService;
	}

	/**
	 * Sets the thong tin phan hoi remote service.
	 *
	 * @param thongTinPhanHoiService the thong tin phan hoi remote service
	 */
	public void setThongTinPhanHoiService(
		vn.dtt.ns.thongtinphanhoi.dao.service.ThongTinPhanHoiService thongTinPhanHoiService) {
		this.thongTinPhanHoiService = thongTinPhanHoiService;
	}

	/**
	 * Returns the thong tin phan hoi persistence.
	 *
	 * @return the thong tin phan hoi persistence
	 */
	public ThongTinPhanHoiPersistence getThongTinPhanHoiPersistence() {
		return thongTinPhanHoiPersistence;
	}

	/**
	 * Sets the thong tin phan hoi persistence.
	 *
	 * @param thongTinPhanHoiPersistence the thong tin phan hoi persistence
	 */
	public void setThongTinPhanHoiPersistence(
		ThongTinPhanHoiPersistence thongTinPhanHoiPersistence) {
		this.thongTinPhanHoiPersistence = thongTinPhanHoiPersistence;
	}

	/**
	 * Returns the topic details local service.
	 *
	 * @return the topic details local service
	 */
	public vn.dtt.ns.thongtinphanhoi.dao.service.TopicDetailsLocalService getTopicDetailsLocalService() {
		return topicDetailsLocalService;
	}

	/**
	 * Sets the topic details local service.
	 *
	 * @param topicDetailsLocalService the topic details local service
	 */
	public void setTopicDetailsLocalService(
		vn.dtt.ns.thongtinphanhoi.dao.service.TopicDetailsLocalService topicDetailsLocalService) {
		this.topicDetailsLocalService = topicDetailsLocalService;
	}

	/**
	 * Returns the topic details remote service.
	 *
	 * @return the topic details remote service
	 */
	public vn.dtt.ns.thongtinphanhoi.dao.service.TopicDetailsService getTopicDetailsService() {
		return topicDetailsService;
	}

	/**
	 * Sets the topic details remote service.
	 *
	 * @param topicDetailsService the topic details remote service
	 */
	public void setTopicDetailsService(
		vn.dtt.ns.thongtinphanhoi.dao.service.TopicDetailsService topicDetailsService) {
		this.topicDetailsService = topicDetailsService;
	}

	/**
	 * Returns the topic details persistence.
	 *
	 * @return the topic details persistence
	 */
	public TopicDetailsPersistence getTopicDetailsPersistence() {
		return topicDetailsPersistence;
	}

	/**
	 * Sets the topic details persistence.
	 *
	 * @param topicDetailsPersistence the topic details persistence
	 */
	public void setTopicDetailsPersistence(
		TopicDetailsPersistence topicDetailsPersistence) {
		this.topicDetailsPersistence = topicDetailsPersistence;
	}

	/**
	 * Returns the topic phan hoi local service.
	 *
	 * @return the topic phan hoi local service
	 */
	public vn.dtt.ns.thongtinphanhoi.dao.service.TopicPhanHoiLocalService getTopicPhanHoiLocalService() {
		return topicPhanHoiLocalService;
	}

	/**
	 * Sets the topic phan hoi local service.
	 *
	 * @param topicPhanHoiLocalService the topic phan hoi local service
	 */
	public void setTopicPhanHoiLocalService(
		vn.dtt.ns.thongtinphanhoi.dao.service.TopicPhanHoiLocalService topicPhanHoiLocalService) {
		this.topicPhanHoiLocalService = topicPhanHoiLocalService;
	}

	/**
	 * Returns the topic phan hoi remote service.
	 *
	 * @return the topic phan hoi remote service
	 */
	public vn.dtt.ns.thongtinphanhoi.dao.service.TopicPhanHoiService getTopicPhanHoiService() {
		return topicPhanHoiService;
	}

	/**
	 * Sets the topic phan hoi remote service.
	 *
	 * @param topicPhanHoiService the topic phan hoi remote service
	 */
	public void setTopicPhanHoiService(
		vn.dtt.ns.thongtinphanhoi.dao.service.TopicPhanHoiService topicPhanHoiService) {
		this.topicPhanHoiService = topicPhanHoiService;
	}

	/**
	 * Returns the topic phan hoi persistence.
	 *
	 * @return the topic phan hoi persistence
	 */
	public TopicPhanHoiPersistence getTopicPhanHoiPersistence() {
		return topicPhanHoiPersistence;
	}

	/**
	 * Sets the topic phan hoi persistence.
	 *
	 * @param topicPhanHoiPersistence the topic phan hoi persistence
	 */
	public void setTopicPhanHoiPersistence(
		TopicPhanHoiPersistence topicPhanHoiPersistence) {
		this.topicPhanHoiPersistence = topicPhanHoiPersistence;
	}

	/**
	 * Returns the trang thai thong ke phan hoi local service.
	 *
	 * @return the trang thai thong ke phan hoi local service
	 */
	public vn.dtt.ns.thongtinphanhoi.dao.service.TrangThaiThongKePhanHoiLocalService getTrangThaiThongKePhanHoiLocalService() {
		return trangThaiThongKePhanHoiLocalService;
	}

	/**
	 * Sets the trang thai thong ke phan hoi local service.
	 *
	 * @param trangThaiThongKePhanHoiLocalService the trang thai thong ke phan hoi local service
	 */
	public void setTrangThaiThongKePhanHoiLocalService(
		vn.dtt.ns.thongtinphanhoi.dao.service.TrangThaiThongKePhanHoiLocalService trangThaiThongKePhanHoiLocalService) {
		this.trangThaiThongKePhanHoiLocalService = trangThaiThongKePhanHoiLocalService;
	}

	/**
	 * Returns the trang thai thong ke phan hoi remote service.
	 *
	 * @return the trang thai thong ke phan hoi remote service
	 */
	public vn.dtt.ns.thongtinphanhoi.dao.service.TrangThaiThongKePhanHoiService getTrangThaiThongKePhanHoiService() {
		return trangThaiThongKePhanHoiService;
	}

	/**
	 * Sets the trang thai thong ke phan hoi remote service.
	 *
	 * @param trangThaiThongKePhanHoiService the trang thai thong ke phan hoi remote service
	 */
	public void setTrangThaiThongKePhanHoiService(
		vn.dtt.ns.thongtinphanhoi.dao.service.TrangThaiThongKePhanHoiService trangThaiThongKePhanHoiService) {
		this.trangThaiThongKePhanHoiService = trangThaiThongKePhanHoiService;
	}

	/**
	 * Returns the trang thai thong ke phan hoi persistence.
	 *
	 * @return the trang thai thong ke phan hoi persistence
	 */
	public TrangThaiThongKePhanHoiPersistence getTrangThaiThongKePhanHoiPersistence() {
		return trangThaiThongKePhanHoiPersistence;
	}

	/**
	 * Sets the trang thai thong ke phan hoi persistence.
	 *
	 * @param trangThaiThongKePhanHoiPersistence the trang thai thong ke phan hoi persistence
	 */
	public void setTrangThaiThongKePhanHoiPersistence(
		TrangThaiThongKePhanHoiPersistence trangThaiThongKePhanHoiPersistence) {
		this.trangThaiThongKePhanHoiPersistence = trangThaiThongKePhanHoiPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return TopicDetails.class;
	}

	protected String getModelClassName() {
		return TopicDetails.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = topicDetailsPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiLocalService.class)
	protected vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiLocalService chiTietThongTinPhanHoiLocalService;
	@BeanReference(type = vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiService.class)
	protected vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiService chiTietThongTinPhanHoiService;
	@BeanReference(type = ChiTietThongTinPhanHoiPersistence.class)
	protected ChiTietThongTinPhanHoiPersistence chiTietThongTinPhanHoiPersistence;
	@BeanReference(type = ChiTietThongTinPhanHoiFinder.class)
	protected ChiTietThongTinPhanHoiFinder chiTietThongTinPhanHoiFinder;
	@BeanReference(type = vn.dtt.ns.thongtinphanhoi.dao.service.ThongTinPhanHoiLocalService.class)
	protected vn.dtt.ns.thongtinphanhoi.dao.service.ThongTinPhanHoiLocalService thongTinPhanHoiLocalService;
	@BeanReference(type = vn.dtt.ns.thongtinphanhoi.dao.service.ThongTinPhanHoiService.class)
	protected vn.dtt.ns.thongtinphanhoi.dao.service.ThongTinPhanHoiService thongTinPhanHoiService;
	@BeanReference(type = ThongTinPhanHoiPersistence.class)
	protected ThongTinPhanHoiPersistence thongTinPhanHoiPersistence;
	@BeanReference(type = vn.dtt.ns.thongtinphanhoi.dao.service.TopicDetailsLocalService.class)
	protected vn.dtt.ns.thongtinphanhoi.dao.service.TopicDetailsLocalService topicDetailsLocalService;
	@BeanReference(type = vn.dtt.ns.thongtinphanhoi.dao.service.TopicDetailsService.class)
	protected vn.dtt.ns.thongtinphanhoi.dao.service.TopicDetailsService topicDetailsService;
	@BeanReference(type = TopicDetailsPersistence.class)
	protected TopicDetailsPersistence topicDetailsPersistence;
	@BeanReference(type = vn.dtt.ns.thongtinphanhoi.dao.service.TopicPhanHoiLocalService.class)
	protected vn.dtt.ns.thongtinphanhoi.dao.service.TopicPhanHoiLocalService topicPhanHoiLocalService;
	@BeanReference(type = vn.dtt.ns.thongtinphanhoi.dao.service.TopicPhanHoiService.class)
	protected vn.dtt.ns.thongtinphanhoi.dao.service.TopicPhanHoiService topicPhanHoiService;
	@BeanReference(type = TopicPhanHoiPersistence.class)
	protected TopicPhanHoiPersistence topicPhanHoiPersistence;
	@BeanReference(type = vn.dtt.ns.thongtinphanhoi.dao.service.TrangThaiThongKePhanHoiLocalService.class)
	protected vn.dtt.ns.thongtinphanhoi.dao.service.TrangThaiThongKePhanHoiLocalService trangThaiThongKePhanHoiLocalService;
	@BeanReference(type = vn.dtt.ns.thongtinphanhoi.dao.service.TrangThaiThongKePhanHoiService.class)
	protected vn.dtt.ns.thongtinphanhoi.dao.service.TrangThaiThongKePhanHoiService trangThaiThongKePhanHoiService;
	@BeanReference(type = TrangThaiThongKePhanHoiPersistence.class)
	protected TrangThaiThongKePhanHoiPersistence trangThaiThongKePhanHoiPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private TopicDetailsServiceClpInvoker _clpInvoker = new TopicDetailsServiceClpInvoker();
}