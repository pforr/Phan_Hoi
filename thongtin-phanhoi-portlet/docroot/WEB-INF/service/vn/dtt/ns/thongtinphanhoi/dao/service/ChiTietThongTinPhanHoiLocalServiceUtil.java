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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ChiTietThongTinPhanHoi. This utility wraps
 * {@link vn.dtt.ns.thongtinphanhoi.dao.service.impl.ChiTietThongTinPhanHoiLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author tubq
 * @see ChiTietThongTinPhanHoiLocalService
 * @see vn.dtt.ns.thongtinphanhoi.dao.service.base.ChiTietThongTinPhanHoiLocalServiceBaseImpl
 * @see vn.dtt.ns.thongtinphanhoi.dao.service.impl.ChiTietThongTinPhanHoiLocalServiceImpl
 * @generated
 */
public class ChiTietThongTinPhanHoiLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.dtt.ns.thongtinphanhoi.dao.service.impl.ChiTietThongTinPhanHoiLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the chi tiet thong tin phan hoi to the database. Also notifies the appropriate model listeners.
	*
	* @param chiTietThongTinPhanHoi the chi tiet thong tin phan hoi
	* @return the chi tiet thong tin phan hoi that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi addChiTietThongTinPhanHoi(
		vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi chiTietThongTinPhanHoi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addChiTietThongTinPhanHoi(chiTietThongTinPhanHoi);
	}

	/**
	* Creates a new chi tiet thong tin phan hoi with the primary key. Does not add the chi tiet thong tin phan hoi to the database.
	*
	* @param id the primary key for the new chi tiet thong tin phan hoi
	* @return the new chi tiet thong tin phan hoi
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi createChiTietThongTinPhanHoi(
		long id) {
		return getService().createChiTietThongTinPhanHoi(id);
	}

	/**
	* Deletes the chi tiet thong tin phan hoi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the chi tiet thong tin phan hoi
	* @return the chi tiet thong tin phan hoi that was removed
	* @throws PortalException if a chi tiet thong tin phan hoi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi deleteChiTietThongTinPhanHoi(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteChiTietThongTinPhanHoi(id);
	}

	/**
	* Deletes the chi tiet thong tin phan hoi from the database. Also notifies the appropriate model listeners.
	*
	* @param chiTietThongTinPhanHoi the chi tiet thong tin phan hoi
	* @return the chi tiet thong tin phan hoi that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi deleteChiTietThongTinPhanHoi(
		vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi chiTietThongTinPhanHoi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteChiTietThongTinPhanHoi(chiTietThongTinPhanHoi);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi fetchChiTietThongTinPhanHoi(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchChiTietThongTinPhanHoi(id);
	}

	/**
	* Returns the chi tiet thong tin phan hoi with the primary key.
	*
	* @param id the primary key of the chi tiet thong tin phan hoi
	* @return the chi tiet thong tin phan hoi
	* @throws PortalException if a chi tiet thong tin phan hoi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi getChiTietThongTinPhanHoi(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getChiTietThongTinPhanHoi(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi> getChiTietThongTinPhanHois(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getChiTietThongTinPhanHois(start, end);
	}

	/**
	* Returns the number of chi tiet thong tin phan hois.
	*
	* @return the number of chi tiet thong tin phan hois
	* @throws SystemException if a system exception occurred
	*/
	public static int getChiTietThongTinPhanHoisCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getChiTietThongTinPhanHoisCount();
	}

	/**
	* Updates the chi tiet thong tin phan hoi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param chiTietThongTinPhanHoi the chi tiet thong tin phan hoi
	* @return the chi tiet thong tin phan hoi that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi updateChiTietThongTinPhanHoi(
		vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi chiTietThongTinPhanHoi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateChiTietThongTinPhanHoi(chiTietThongTinPhanHoi);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static long countTopicPhanHoi(java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.lang.String topicCode, java.util.Date fromDate,
		java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countTopicPhanHoi(maTinh, maHuyen, maXa, topicCode,
			fromDate, toDate);
	}

	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi> searchTopicPhanHoi(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.lang.String topicCode,
		java.util.Date fromDate, java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .searchTopicPhanHoi(maTinh, maHuyen, maXa, topicCode,
			fromDate, toDate, start, end);
	}

	public static long countPhanHoiByTopicCode(java.lang.String topicCode,
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.lang.String feedbackCode,
		java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countPhanHoiByTopicCode(topicCode, maTinh, maHuyen, maXa,
			feedbackCode, fromDate, toDate);
	}

	public static long countPhanHoiByMaThongTinPhanAnh(
		java.lang.String topicCode, java.lang.String feedbackCode,
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countPhanHoiByMaThongTinPhanAnh(topicCode, feedbackCode,
			maTinh, maHuyen, maXa, fromDate, toDate);
	}

	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi> getAllTopicPhanHoi()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllTopicPhanHoi();
	}

	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails> getTopicDetailsByTopicCode(
		java.lang.String topicCode, java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.lang.String feedbackCode, java.util.Date fromDate,
		java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getTopicDetailsByTopicCode(topicCode, maTinh, maHuyen,
			maXa, feedbackCode, fromDate, toDate, start, end);
	}

	public static vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails getTopicDetailsById(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTopicDetailsById(id);
	}

	public static long countPhanHoiByTrangThaiYcgt(int trangThaiYcgt,
		java.lang.String topicCode, java.lang.String feedbackCode,
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countPhanHoiByTrangThaiYcgt(trangThaiYcgt, topicCode,
			feedbackCode, maTinh, maHuyen, maXa, fromDate, toDate);
	}

	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails> getTopicDetailsByTrangThaiYcgt(
		int trangThaiYcgt, java.lang.String topicCode,
		java.lang.String feedbackCode, java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.util.Date fromDate, java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getTopicDetailsByTrangThaiYcgt(trangThaiYcgt, topicCode,
			feedbackCode, maTinh, maHuyen, maXa, fromDate, toDate, start, end);
	}

	public static long countPhanHoiByTrangThaiYcgtAndGroupByFeedbackCode(
		int trangThaiYcgt, java.lang.String topicCode,
		java.lang.String feedbackCode, java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countPhanHoiByTrangThaiYcgtAndGroupByFeedbackCode(trangThaiYcgt,
			topicCode, feedbackCode, maTinh, maHuyen, maXa, fromDate, toDate);
	}

	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails> getTopicDetailsByTrangThaiYcgtAndGroupByFeedbackCode(
		int trangThaiYcgt, java.lang.String topicCode,
		java.lang.String feedbackCode, java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.util.Date fromDate, java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getTopicDetailsByTrangThaiYcgtAndGroupByFeedbackCode(trangThaiYcgt,
			topicCode, feedbackCode, maTinh, maHuyen, maXa, fromDate, toDate,
			start, end);
	}

	public static long countTopicDetailsByYcgtId(long ycgtId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countTopicDetailsByYcgtId(ycgtId);
	}

	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails> getTopicDetailsByYcgtId(
		long ycgtId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTopicDetailsByYcgtId(ycgtId, start, end);
	}

	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi> getChiTietThongTinPhanHoiBy_ttphId_thx(
		long thongTinPhanHoiId, java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getChiTietThongTinPhanHoiBy_ttphId_thx(thongTinPhanHoiId,
			maTinh, maHuyen, maXa);
	}

	public static long countPhanHoiGroupByFeedBackCode(
		java.lang.String topicCode, java.lang.String feedbackCode,
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countPhanHoiGroupByFeedBackCode(topicCode, feedbackCode,
			maTinh, maHuyen, maXa, fromDate, toDate);
	}

	public static void clearService() {
		_service = null;
	}

	public static ChiTietThongTinPhanHoiLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ChiTietThongTinPhanHoiLocalService.class.getName());

			if (invokableLocalService instanceof ChiTietThongTinPhanHoiLocalService) {
				_service = (ChiTietThongTinPhanHoiLocalService)invokableLocalService;
			}
			else {
				_service = new ChiTietThongTinPhanHoiLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ChiTietThongTinPhanHoiLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ChiTietThongTinPhanHoiLocalService service) {
	}

	private static ChiTietThongTinPhanHoiLocalService _service;
}