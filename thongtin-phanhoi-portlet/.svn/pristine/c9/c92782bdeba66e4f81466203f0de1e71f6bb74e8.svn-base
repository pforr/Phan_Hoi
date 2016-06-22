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

package vn.dtt.ns.thongtinphanhoi.dao.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi;

import java.util.List;

/**
 * The persistence utility for the topic phan hoi service. This utility wraps {@link TopicPhanHoiPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tubq
 * @see TopicPhanHoiPersistence
 * @see TopicPhanHoiPersistenceImpl
 * @generated
 */
public class TopicPhanHoiUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(TopicPhanHoi topicPhanHoi) {
		getPersistence().clearCache(topicPhanHoi);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TopicPhanHoi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TopicPhanHoi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TopicPhanHoi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TopicPhanHoi update(TopicPhanHoi topicPhanHoi)
		throws SystemException {
		return getPersistence().update(topicPhanHoi);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TopicPhanHoi update(TopicPhanHoi topicPhanHoi,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(topicPhanHoi, serviceContext);
	}

	/**
	* Caches the topic phan hoi in the entity cache if it is enabled.
	*
	* @param topicPhanHoi the topic phan hoi
	*/
	public static void cacheResult(
		vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi topicPhanHoi) {
		getPersistence().cacheResult(topicPhanHoi);
	}

	/**
	* Caches the topic phan hois in the entity cache if it is enabled.
	*
	* @param topicPhanHois the topic phan hois
	*/
	public static void cacheResult(
		java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi> topicPhanHois) {
		getPersistence().cacheResult(topicPhanHois);
	}

	/**
	* Creates a new topic phan hoi with the primary key. Does not add the topic phan hoi to the database.
	*
	* @param topicCode the primary key for the new topic phan hoi
	* @return the new topic phan hoi
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi create(
		java.lang.String topicCode) {
		return getPersistence().create(topicCode);
	}

	/**
	* Removes the topic phan hoi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param topicCode the primary key of the topic phan hoi
	* @return the topic phan hoi that was removed
	* @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchTopicPhanHoiException if a topic phan hoi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi remove(
		java.lang.String topicCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.ns.thongtinphanhoi.dao.NoSuchTopicPhanHoiException {
		return getPersistence().remove(topicCode);
	}

	public static vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi updateImpl(
		vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi topicPhanHoi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(topicPhanHoi);
	}

	/**
	* Returns the topic phan hoi with the primary key or throws a {@link vn.dtt.ns.thongtinphanhoi.dao.NoSuchTopicPhanHoiException} if it could not be found.
	*
	* @param topicCode the primary key of the topic phan hoi
	* @return the topic phan hoi
	* @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchTopicPhanHoiException if a topic phan hoi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi findByPrimaryKey(
		java.lang.String topicCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.ns.thongtinphanhoi.dao.NoSuchTopicPhanHoiException {
		return getPersistence().findByPrimaryKey(topicCode);
	}

	/**
	* Returns the topic phan hoi with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param topicCode the primary key of the topic phan hoi
	* @return the topic phan hoi, or <code>null</code> if a topic phan hoi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi fetchByPrimaryKey(
		java.lang.String topicCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(topicCode);
	}

	/**
	* Returns all the topic phan hois.
	*
	* @return the topic phan hois
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the topic phan hois.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.thongtinphanhoi.dao.model.impl.TopicPhanHoiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of topic phan hois
	* @param end the upper bound of the range of topic phan hois (not inclusive)
	* @return the range of topic phan hois
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the topic phan hois.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.thongtinphanhoi.dao.model.impl.TopicPhanHoiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of topic phan hois
	* @param end the upper bound of the range of topic phan hois (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of topic phan hois
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the topic phan hois from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of topic phan hois.
	*
	* @return the number of topic phan hois
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TopicPhanHoiPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TopicPhanHoiPersistence)PortletBeanLocatorUtil.locate(vn.dtt.ns.thongtinphanhoi.dao.service.ClpSerializer.getServletContextName(),
					TopicPhanHoiPersistence.class.getName());

			ReferenceRegistry.registerReference(TopicPhanHoiUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TopicPhanHoiPersistence persistence) {
	}

	private static TopicPhanHoiPersistence _persistence;
}