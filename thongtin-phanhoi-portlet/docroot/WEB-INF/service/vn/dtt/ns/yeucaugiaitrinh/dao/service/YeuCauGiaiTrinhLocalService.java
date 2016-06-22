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

package vn.dtt.ns.yeucaugiaitrinh.dao.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for YeuCauGiaiTrinh. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author tubq
 * @see YeuCauGiaiTrinhLocalServiceUtil
 * @see vn.dtt.ns.yeucaugiaitrinh.dao.service.base.YeuCauGiaiTrinhLocalServiceBaseImpl
 * @see vn.dtt.ns.yeucaugiaitrinh.dao.service.impl.YeuCauGiaiTrinhLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface YeuCauGiaiTrinhLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link YeuCauGiaiTrinhLocalServiceUtil} to access the yeu cau giai trinh local service. Add custom service methods to {@link vn.dtt.ns.yeucaugiaitrinh.dao.service.impl.YeuCauGiaiTrinhLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the yeu cau giai trinh to the database. Also notifies the appropriate model listeners.
	*
	* @param yeuCauGiaiTrinh the yeu cau giai trinh
	* @return the yeu cau giai trinh that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh addYeuCauGiaiTrinh(
		vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh yeuCauGiaiTrinh)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new yeu cau giai trinh with the primary key. Does not add the yeu cau giai trinh to the database.
	*
	* @param id the primary key for the new yeu cau giai trinh
	* @return the new yeu cau giai trinh
	*/
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh createYeuCauGiaiTrinh(
		long id);

	/**
	* Deletes the yeu cau giai trinh with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the yeu cau giai trinh
	* @return the yeu cau giai trinh that was removed
	* @throws PortalException if a yeu cau giai trinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh deleteYeuCauGiaiTrinh(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the yeu cau giai trinh from the database. Also notifies the appropriate model listeners.
	*
	* @param yeuCauGiaiTrinh the yeu cau giai trinh
	* @return the yeu cau giai trinh that was removed
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh deleteYeuCauGiaiTrinh(
		vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh yeuCauGiaiTrinh)
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.YeuCauGiaiTrinhModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.YeuCauGiaiTrinhModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh fetchYeuCauGiaiTrinh(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the yeu cau giai trinh with the primary key.
	*
	* @param id the primary key of the yeu cau giai trinh
	* @return the yeu cau giai trinh
	* @throws PortalException if a yeu cau giai trinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh getYeuCauGiaiTrinh(
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
	* Returns a range of all the yeu cau giai trinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.YeuCauGiaiTrinhModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of yeu cau giai trinhs
	* @param end the upper bound of the range of yeu cau giai trinhs (not inclusive)
	* @return the range of yeu cau giai trinhs
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh> getYeuCauGiaiTrinhs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of yeu cau giai trinhs.
	*
	* @return the number of yeu cau giai trinhs
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getYeuCauGiaiTrinhsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the yeu cau giai trinh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param yeuCauGiaiTrinh the yeu cau giai trinh
	* @return the yeu cau giai trinh that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh updateYeuCauGiaiTrinh(
		vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh yeuCauGiaiTrinh)
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

	public long countYeuCauGiaiTrinh(java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		int trangThaiGiaiTrinh, java.lang.String maChuDe, int soLuotPhanHoi,
		java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh> searchYeuCauGiaiTrinh(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, int trangThaiGiaiTrinh,
		java.lang.String maChuDe, int soLuotPhanHoi, java.util.Date fromDate,
		java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countYeuCauGiaiTrinhNSVS(java.lang.String maTinh,
		java.lang.String[] maHuyen, java.lang.String[] maXa,
		int trangThaiGiaiTrinh, java.lang.String[] maChuDe, int soLuotPhanHoi,
		java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh> searchYeuCauGiaiTrinhNSVS(
		java.lang.String maTinh, java.lang.String[] maHuyen,
		java.lang.String[] maXa, int trangThaiGiaiTrinh,
		java.lang.String[] maChuDe, int soLuotPhanHoi, java.util.Date fromDate,
		java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;
}