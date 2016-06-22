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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ThongTinPhanHoiLocalService}.
 *
 * @author tubq
 * @see ThongTinPhanHoiLocalService
 * @generated
 */
public class ThongTinPhanHoiLocalServiceWrapper
	implements ThongTinPhanHoiLocalService,
		ServiceWrapper<ThongTinPhanHoiLocalService> {
	public ThongTinPhanHoiLocalServiceWrapper(
		ThongTinPhanHoiLocalService thongTinPhanHoiLocalService) {
		_thongTinPhanHoiLocalService = thongTinPhanHoiLocalService;
	}

	/**
	* Adds the thong tin phan hoi to the database. Also notifies the appropriate model listeners.
	*
	* @param thongTinPhanHoi the thong tin phan hoi
	* @return the thong tin phan hoi that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi addThongTinPhanHoi(
		vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi thongTinPhanHoi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _thongTinPhanHoiLocalService.addThongTinPhanHoi(thongTinPhanHoi);
	}

	/**
	* Creates a new thong tin phan hoi with the primary key. Does not add the thong tin phan hoi to the database.
	*
	* @param id the primary key for the new thong tin phan hoi
	* @return the new thong tin phan hoi
	*/
	@Override
	public vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi createThongTinPhanHoi(
		long id) {
		return _thongTinPhanHoiLocalService.createThongTinPhanHoi(id);
	}

	/**
	* Deletes the thong tin phan hoi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the thong tin phan hoi
	* @return the thong tin phan hoi that was removed
	* @throws PortalException if a thong tin phan hoi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi deleteThongTinPhanHoi(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _thongTinPhanHoiLocalService.deleteThongTinPhanHoi(id);
	}

	/**
	* Deletes the thong tin phan hoi from the database. Also notifies the appropriate model listeners.
	*
	* @param thongTinPhanHoi the thong tin phan hoi
	* @return the thong tin phan hoi that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi deleteThongTinPhanHoi(
		vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi thongTinPhanHoi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _thongTinPhanHoiLocalService.deleteThongTinPhanHoi(thongTinPhanHoi);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _thongTinPhanHoiLocalService.dynamicQuery();
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
		return _thongTinPhanHoiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.thongtinphanhoi.dao.model.impl.ThongTinPhanHoiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _thongTinPhanHoiLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.thongtinphanhoi.dao.model.impl.ThongTinPhanHoiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _thongTinPhanHoiLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _thongTinPhanHoiLocalService.dynamicQueryCount(dynamicQuery);
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
		return _thongTinPhanHoiLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi fetchThongTinPhanHoi(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _thongTinPhanHoiLocalService.fetchThongTinPhanHoi(id);
	}

	/**
	* Returns the thong tin phan hoi with the primary key.
	*
	* @param id the primary key of the thong tin phan hoi
	* @return the thong tin phan hoi
	* @throws PortalException if a thong tin phan hoi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi getThongTinPhanHoi(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _thongTinPhanHoiLocalService.getThongTinPhanHoi(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _thongTinPhanHoiLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the thong tin phan hois.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.thongtinphanhoi.dao.model.impl.ThongTinPhanHoiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of thong tin phan hois
	* @param end the upper bound of the range of thong tin phan hois (not inclusive)
	* @return the range of thong tin phan hois
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi> getThongTinPhanHois(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _thongTinPhanHoiLocalService.getThongTinPhanHois(start, end);
	}

	/**
	* Returns the number of thong tin phan hois.
	*
	* @return the number of thong tin phan hois
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getThongTinPhanHoisCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _thongTinPhanHoiLocalService.getThongTinPhanHoisCount();
	}

	/**
	* Updates the thong tin phan hoi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param thongTinPhanHoi the thong tin phan hoi
	* @return the thong tin phan hoi that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi updateThongTinPhanHoi(
		vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi thongTinPhanHoi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _thongTinPhanHoiLocalService.updateThongTinPhanHoi(thongTinPhanHoi);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _thongTinPhanHoiLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_thongTinPhanHoiLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _thongTinPhanHoiLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ThongTinPhanHoiLocalService getWrappedThongTinPhanHoiLocalService() {
		return _thongTinPhanHoiLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedThongTinPhanHoiLocalService(
		ThongTinPhanHoiLocalService thongTinPhanHoiLocalService) {
		_thongTinPhanHoiLocalService = thongTinPhanHoiLocalService;
	}

	@Override
	public ThongTinPhanHoiLocalService getWrappedService() {
		return _thongTinPhanHoiLocalService;
	}

	@Override
	public void setWrappedService(
		ThongTinPhanHoiLocalService thongTinPhanHoiLocalService) {
		_thongTinPhanHoiLocalService = thongTinPhanHoiLocalService;
	}

	private ThongTinPhanHoiLocalService _thongTinPhanHoiLocalService;
}