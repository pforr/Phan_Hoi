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

import com.liferay.portal.service.persistence.BasePersistence;

import vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi;

/**
 * The persistence interface for the topic phan hoi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tubq
 * @see TopicPhanHoiPersistenceImpl
 * @see TopicPhanHoiUtil
 * @generated
 */
public interface TopicPhanHoiPersistence extends BasePersistence<TopicPhanHoi> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TopicPhanHoiUtil} to access the topic phan hoi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the topic phan hoi in the entity cache if it is enabled.
	*
	* @param topicPhanHoi the topic phan hoi
	*/
	public void cacheResult(
		vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi topicPhanHoi);

	/**
	* Caches the topic phan hois in the entity cache if it is enabled.
	*
	* @param topicPhanHois the topic phan hois
	*/
	public void cacheResult(
		java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi> topicPhanHois);

	/**
	* Creates a new topic phan hoi with the primary key. Does not add the topic phan hoi to the database.
	*
	* @param topicCode the primary key for the new topic phan hoi
	* @return the new topic phan hoi
	*/
	public vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi create(
		java.lang.String topicCode);

	/**
	* Removes the topic phan hoi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param topicCode the primary key of the topic phan hoi
	* @return the topic phan hoi that was removed
	* @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchTopicPhanHoiException if a topic phan hoi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi remove(
		java.lang.String topicCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.ns.thongtinphanhoi.dao.NoSuchTopicPhanHoiException;

	public vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi updateImpl(
		vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi topicPhanHoi)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the topic phan hoi with the primary key or throws a {@link vn.dtt.ns.thongtinphanhoi.dao.NoSuchTopicPhanHoiException} if it could not be found.
	*
	* @param topicCode the primary key of the topic phan hoi
	* @return the topic phan hoi
	* @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchTopicPhanHoiException if a topic phan hoi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi findByPrimaryKey(
		java.lang.String topicCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.ns.thongtinphanhoi.dao.NoSuchTopicPhanHoiException;

	/**
	* Returns the topic phan hoi with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param topicCode the primary key of the topic phan hoi
	* @return the topic phan hoi, or <code>null</code> if a topic phan hoi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi fetchByPrimaryKey(
		java.lang.String topicCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the topic phan hois.
	*
	* @return the topic phan hois
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the topic phan hois from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of topic phan hois.
	*
	* @return the number of topic phan hois
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}