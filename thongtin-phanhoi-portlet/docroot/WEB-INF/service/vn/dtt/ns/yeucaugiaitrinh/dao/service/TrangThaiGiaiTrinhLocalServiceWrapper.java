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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TrangThaiGiaiTrinhLocalService}.
 *
 * @author tubq
 * @see TrangThaiGiaiTrinhLocalService
 * @generated
 */
public class TrangThaiGiaiTrinhLocalServiceWrapper
	implements TrangThaiGiaiTrinhLocalService,
		ServiceWrapper<TrangThaiGiaiTrinhLocalService> {
	public TrangThaiGiaiTrinhLocalServiceWrapper(
		TrangThaiGiaiTrinhLocalService trangThaiGiaiTrinhLocalService) {
		_trangThaiGiaiTrinhLocalService = trangThaiGiaiTrinhLocalService;
	}

	/**
	* Adds the trang thai giai trinh to the database. Also notifies the appropriate model listeners.
	*
	* @param trangThaiGiaiTrinh the trang thai giai trinh
	* @return the trang thai giai trinh that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh addTrangThaiGiaiTrinh(
		vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh trangThaiGiaiTrinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiGiaiTrinhLocalService.addTrangThaiGiaiTrinh(trangThaiGiaiTrinh);
	}

	/**
	* Creates a new trang thai giai trinh with the primary key. Does not add the trang thai giai trinh to the database.
	*
	* @param id the primary key for the new trang thai giai trinh
	* @return the new trang thai giai trinh
	*/
	@Override
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh createTrangThaiGiaiTrinh(
		long id) {
		return _trangThaiGiaiTrinhLocalService.createTrangThaiGiaiTrinh(id);
	}

	/**
	* Deletes the trang thai giai trinh with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the trang thai giai trinh
	* @return the trang thai giai trinh that was removed
	* @throws PortalException if a trang thai giai trinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh deleteTrangThaiGiaiTrinh(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiGiaiTrinhLocalService.deleteTrangThaiGiaiTrinh(id);
	}

	/**
	* Deletes the trang thai giai trinh from the database. Also notifies the appropriate model listeners.
	*
	* @param trangThaiGiaiTrinh the trang thai giai trinh
	* @return the trang thai giai trinh that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh deleteTrangThaiGiaiTrinh(
		vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh trangThaiGiaiTrinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiGiaiTrinhLocalService.deleteTrangThaiGiaiTrinh(trangThaiGiaiTrinh);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _trangThaiGiaiTrinhLocalService.dynamicQuery();
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiGiaiTrinhLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.TrangThaiGiaiTrinhModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiGiaiTrinhLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.TrangThaiGiaiTrinhModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiGiaiTrinhLocalService.dynamicQuery(dynamicQuery,
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiGiaiTrinhLocalService.dynamicQueryCount(dynamicQuery);
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiGiaiTrinhLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh fetchTrangThaiGiaiTrinh(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiGiaiTrinhLocalService.fetchTrangThaiGiaiTrinh(id);
	}

	/**
	* Returns the trang thai giai trinh with the primary key.
	*
	* @param id the primary key of the trang thai giai trinh
	* @return the trang thai giai trinh
	* @throws PortalException if a trang thai giai trinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh getTrangThaiGiaiTrinh(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiGiaiTrinhLocalService.getTrangThaiGiaiTrinh(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiGiaiTrinhLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the trang thai giai trinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.TrangThaiGiaiTrinhModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of trang thai giai trinhs
	* @param end the upper bound of the range of trang thai giai trinhs (not inclusive)
	* @return the range of trang thai giai trinhs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh> getTrangThaiGiaiTrinhs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiGiaiTrinhLocalService.getTrangThaiGiaiTrinhs(start, end);
	}

	/**
	* Returns the number of trang thai giai trinhs.
	*
	* @return the number of trang thai giai trinhs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTrangThaiGiaiTrinhsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiGiaiTrinhLocalService.getTrangThaiGiaiTrinhsCount();
	}

	/**
	* Updates the trang thai giai trinh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param trangThaiGiaiTrinh the trang thai giai trinh
	* @return the trang thai giai trinh that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh updateTrangThaiGiaiTrinh(
		vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh trangThaiGiaiTrinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiGiaiTrinhLocalService.updateTrangThaiGiaiTrinh(trangThaiGiaiTrinh);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _trangThaiGiaiTrinhLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_trangThaiGiaiTrinhLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _trangThaiGiaiTrinhLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh getTrangThaiGiaiTrinhByYcgtId(
		long ycgtId) throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiGiaiTrinhLocalService.getTrangThaiGiaiTrinhByYcgtId(ycgtId);
	}

	@Override
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh getTrangThaiGiaiTrinhByYcgtIdAndTrangThai(
		long ycgtId, int trangThai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiGiaiTrinhLocalService.getTrangThaiGiaiTrinhByYcgtIdAndTrangThai(ycgtId,
			trangThai);
	}

	@Override
	public java.util.List<vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh> getTrangThaiGiaiTrinhByQuaTrinhXuLy(
		long ycgtId) throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiGiaiTrinhLocalService.getTrangThaiGiaiTrinhByQuaTrinhXuLy(ycgtId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TrangThaiGiaiTrinhLocalService getWrappedTrangThaiGiaiTrinhLocalService() {
		return _trangThaiGiaiTrinhLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTrangThaiGiaiTrinhLocalService(
		TrangThaiGiaiTrinhLocalService trangThaiGiaiTrinhLocalService) {
		_trangThaiGiaiTrinhLocalService = trangThaiGiaiTrinhLocalService;
	}

	@Override
	public TrangThaiGiaiTrinhLocalService getWrappedService() {
		return _trangThaiGiaiTrinhLocalService;
	}

	@Override
	public void setWrappedService(
		TrangThaiGiaiTrinhLocalService trangThaiGiaiTrinhLocalService) {
		_trangThaiGiaiTrinhLocalService = trangThaiGiaiTrinhLocalService;
	}

	private TrangThaiGiaiTrinhLocalService _trangThaiGiaiTrinhLocalService;
}