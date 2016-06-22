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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi;
import vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiLocalService;
import vn.dtt.ns.thongtinphanhoi.dao.service.persistence.ChiTietThongTinPhanHoiFinder;
import vn.dtt.ns.thongtinphanhoi.dao.service.persistence.ChiTietThongTinPhanHoiPersistence;
import vn.dtt.ns.thongtinphanhoi.dao.service.persistence.ThongTinPhanHoiPersistence;
import vn.dtt.ns.thongtinphanhoi.dao.service.persistence.TopicDetailsPersistence;
import vn.dtt.ns.thongtinphanhoi.dao.service.persistence.TopicPhanHoiPersistence;
import vn.dtt.ns.thongtinphanhoi.dao.service.persistence.TrangThaiThongKePhanHoiPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the chi tiet thong tin phan hoi local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link vn.dtt.ns.thongtinphanhoi.dao.service.impl.ChiTietThongTinPhanHoiLocalServiceImpl}.
 * </p>
 *
 * @author tubq
 * @see vn.dtt.ns.thongtinphanhoi.dao.service.impl.ChiTietThongTinPhanHoiLocalServiceImpl
 * @see vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiLocalServiceUtil
 * @generated
 */
public abstract class ChiTietThongTinPhanHoiLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements ChiTietThongTinPhanHoiLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiLocalServiceUtil} to access the chi tiet thong tin phan hoi local service.
	 */

	/**
	 * Adds the chi tiet thong tin phan hoi to the database. Also notifies the appropriate model listeners.
	 *
	 * @param chiTietThongTinPhanHoi the chi tiet thong tin phan hoi
	 * @return the chi tiet thong tin phan hoi that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ChiTietThongTinPhanHoi addChiTietThongTinPhanHoi(
		ChiTietThongTinPhanHoi chiTietThongTinPhanHoi)
		throws SystemException {
		chiTietThongTinPhanHoi.setNew(true);

		return chiTietThongTinPhanHoiPersistence.update(chiTietThongTinPhanHoi);
	}

	/**
	 * Creates a new chi tiet thong tin phan hoi with the primary key. Does not add the chi tiet thong tin phan hoi to the database.
	 *
	 * @param id the primary key for the new chi tiet thong tin phan hoi
	 * @return the new chi tiet thong tin phan hoi
	 */
	@Override
	public ChiTietThongTinPhanHoi createChiTietThongTinPhanHoi(long id) {
		return chiTietThongTinPhanHoiPersistence.create(id);
	}

	/**
	 * Deletes the chi tiet thong tin phan hoi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chi tiet thong tin phan hoi
	 * @return the chi tiet thong tin phan hoi that was removed
	 * @throws PortalException if a chi tiet thong tin phan hoi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ChiTietThongTinPhanHoi deleteChiTietThongTinPhanHoi(long id)
		throws PortalException, SystemException {
		return chiTietThongTinPhanHoiPersistence.remove(id);
	}

	/**
	 * Deletes the chi tiet thong tin phan hoi from the database. Also notifies the appropriate model listeners.
	 *
	 * @param chiTietThongTinPhanHoi the chi tiet thong tin phan hoi
	 * @return the chi tiet thong tin phan hoi that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ChiTietThongTinPhanHoi deleteChiTietThongTinPhanHoi(
		ChiTietThongTinPhanHoi chiTietThongTinPhanHoi)
		throws SystemException {
		return chiTietThongTinPhanHoiPersistence.remove(chiTietThongTinPhanHoi);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(ChiTietThongTinPhanHoi.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return chiTietThongTinPhanHoiPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.thongtinphanhoi.dao.model.impl.ChiTietThongTinPhanHoiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return chiTietThongTinPhanHoiPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.thongtinphanhoi.dao.model.impl.ChiTietThongTinPhanHoiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return chiTietThongTinPhanHoiPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return chiTietThongTinPhanHoiPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return chiTietThongTinPhanHoiPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public ChiTietThongTinPhanHoi fetchChiTietThongTinPhanHoi(long id)
		throws SystemException {
		return chiTietThongTinPhanHoiPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the chi tiet thong tin phan hoi with the primary key.
	 *
	 * @param id the primary key of the chi tiet thong tin phan hoi
	 * @return the chi tiet thong tin phan hoi
	 * @throws PortalException if a chi tiet thong tin phan hoi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietThongTinPhanHoi getChiTietThongTinPhanHoi(long id)
		throws PortalException, SystemException {
		return chiTietThongTinPhanHoiPersistence.findByPrimaryKey(id);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return chiTietThongTinPhanHoiPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the chi tiet thong tin phan hois.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.thongtinphanhoi.dao.model.impl.ChiTietThongTinPhanHoiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chi tiet thong tin phan hois
	 * @param end the upper bound of the range of chi tiet thong tin phan hois (not inclusive)
	 * @return the range of chi tiet thong tin phan hois
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChiTietThongTinPhanHoi> getChiTietThongTinPhanHois(int start,
		int end) throws SystemException {
		return chiTietThongTinPhanHoiPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of chi tiet thong tin phan hois.
	 *
	 * @return the number of chi tiet thong tin phan hois
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getChiTietThongTinPhanHoisCount() throws SystemException {
		return chiTietThongTinPhanHoiPersistence.countAll();
	}

	/**
	 * Updates the chi tiet thong tin phan hoi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param chiTietThongTinPhanHoi the chi tiet thong tin phan hoi
	 * @return the chi tiet thong tin phan hoi that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ChiTietThongTinPhanHoi updateChiTietThongTinPhanHoi(
		ChiTietThongTinPhanHoi chiTietThongTinPhanHoi)
		throws SystemException {
		return chiTietThongTinPhanHoiPersistence.update(chiTietThongTinPhanHoi);
	}

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

		PersistedModelLocalServiceRegistryUtil.register("vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi",
			chiTietThongTinPhanHoiLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi");
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
		return ChiTietThongTinPhanHoi.class;
	}

	protected String getModelClassName() {
		return ChiTietThongTinPhanHoi.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = chiTietThongTinPhanHoiPersistence.getDataSource();

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
	private ChiTietThongTinPhanHoiLocalServiceClpInvoker _clpInvoker = new ChiTietThongTinPhanHoiLocalServiceClpInvoker();
}