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
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for ChiTietThongTinPhanHoi. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author tubq
 * @see ChiTietThongTinPhanHoiLocalServiceUtil
 * @see vn.dtt.ns.thongtinphanhoi.dao.service.base.ChiTietThongTinPhanHoiLocalServiceBaseImpl
 * @see vn.dtt.ns.thongtinphanhoi.dao.service.impl.ChiTietThongTinPhanHoiLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ChiTietThongTinPhanHoiLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChiTietThongTinPhanHoiLocalServiceUtil} to access the chi tiet thong tin phan hoi local service. Add custom service methods to {@link vn.dtt.ns.thongtinphanhoi.dao.service.impl.ChiTietThongTinPhanHoiLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the chi tiet thong tin phan hoi to the database. Also notifies the appropriate model listeners.
	*
	* @param chiTietThongTinPhanHoi the chi tiet thong tin phan hoi
	* @return the chi tiet thong tin phan hoi that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi addChiTietThongTinPhanHoi(
		vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi chiTietThongTinPhanHoi)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new chi tiet thong tin phan hoi with the primary key. Does not add the chi tiet thong tin phan hoi to the database.
	*
	* @param id the primary key for the new chi tiet thong tin phan hoi
	* @return the new chi tiet thong tin phan hoi
	*/
	public vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi createChiTietThongTinPhanHoi(
		long id);

	/**
	* Deletes the chi tiet thong tin phan hoi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the chi tiet thong tin phan hoi
	* @return the chi tiet thong tin phan hoi that was removed
	* @throws PortalException if a chi tiet thong tin phan hoi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi deleteChiTietThongTinPhanHoi(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the chi tiet thong tin phan hoi from the database. Also notifies the appropriate model listeners.
	*
	* @param chiTietThongTinPhanHoi the chi tiet thong tin phan hoi
	* @return the chi tiet thong tin phan hoi that was removed
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi deleteChiTietThongTinPhanHoi(
		vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi chiTietThongTinPhanHoi)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi fetchChiTietThongTinPhanHoi(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the chi tiet thong tin phan hoi with the primary key.
	*
	* @param id the primary key of the chi tiet thong tin phan hoi
	* @return the chi tiet thong tin phan hoi
	* @throws PortalException if a chi tiet thong tin phan hoi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi getChiTietThongTinPhanHoi(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi> getChiTietThongTinPhanHois(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chi tiet thong tin phan hois.
	*
	* @return the number of chi tiet thong tin phan hois
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getChiTietThongTinPhanHoisCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the chi tiet thong tin phan hoi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param chiTietThongTinPhanHoi the chi tiet thong tin phan hoi
	* @return the chi tiet thong tin phan hoi that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi updateChiTietThongTinPhanHoi(
		vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi chiTietThongTinPhanHoi)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public long countTopicPhanHoi(java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.lang.String topicCode, java.util.Date fromDate,
		java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi> searchTopicPhanHoi(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.lang.String topicCode,
		java.util.Date fromDate, java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countPhanHoiByTopicCode(java.lang.String topicCode,
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.lang.String feedbackCode,
		java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countPhanHoiByMaThongTinPhanAnh(java.lang.String topicCode,
		java.lang.String feedbackCode, java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi> getAllTopicPhanHoi()
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails> getTopicDetailsByTopicCode(
		java.lang.String topicCode, java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.lang.String feedbackCode, java.util.Date fromDate,
		java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails getTopicDetailsById(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	public long countPhanHoiByTrangThaiYcgt(int trangThaiYcgt,
		java.lang.String topicCode, java.lang.String feedbackCode,
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails> getTopicDetailsByTrangThaiYcgt(
		int trangThaiYcgt, java.lang.String topicCode,
		java.lang.String feedbackCode, java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.util.Date fromDate, java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countPhanHoiByTrangThaiYcgtAndGroupByFeedbackCode(
		int trangThaiYcgt, java.lang.String topicCode,
		java.lang.String feedbackCode, java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails> getTopicDetailsByTrangThaiYcgtAndGroupByFeedbackCode(
		int trangThaiYcgt, java.lang.String topicCode,
		java.lang.String feedbackCode, java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.util.Date fromDate, java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countTopicDetailsByYcgtId(long ycgtId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails> getTopicDetailsByYcgtId(
		long ycgtId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi> getChiTietThongTinPhanHoiBy_ttphId_thx(
		long thongTinPhanHoiId, java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countPhanHoiGroupByFeedBackCode(java.lang.String topicCode,
		java.lang.String feedbackCode, java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException;
}