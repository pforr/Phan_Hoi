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

import vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi;

import java.util.List;

/**
 * The persistence utility for the thong tin phan hoi service. This utility wraps {@link ThongTinPhanHoiPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tubq
 * @see ThongTinPhanHoiPersistence
 * @see ThongTinPhanHoiPersistenceImpl
 * @generated
 */
public class ThongTinPhanHoiUtil {
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
	public static void clearCache(ThongTinPhanHoi thongTinPhanHoi) {
		getPersistence().clearCache(thongTinPhanHoi);
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
	public static List<ThongTinPhanHoi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ThongTinPhanHoi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ThongTinPhanHoi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ThongTinPhanHoi update(ThongTinPhanHoi thongTinPhanHoi)
		throws SystemException {
		return getPersistence().update(thongTinPhanHoi);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ThongTinPhanHoi update(ThongTinPhanHoi thongTinPhanHoi,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(thongTinPhanHoi, serviceContext);
	}

	/**
	* Returns all the thong tin phan hois where soDienThoai = &#63;.
	*
	* @param soDienThoai the so dien thoai
	* @return the matching thong tin phan hois
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi> findBySoDienThoai(
		java.lang.String soDienThoai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySoDienThoai(soDienThoai);
	}

	/**
	* Returns a range of all the thong tin phan hois where soDienThoai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.thongtinphanhoi.dao.model.impl.ThongTinPhanHoiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param soDienThoai the so dien thoai
	* @param start the lower bound of the range of thong tin phan hois
	* @param end the upper bound of the range of thong tin phan hois (not inclusive)
	* @return the range of matching thong tin phan hois
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi> findBySoDienThoai(
		java.lang.String soDienThoai, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySoDienThoai(soDienThoai, start, end);
	}

	/**
	* Returns an ordered range of all the thong tin phan hois where soDienThoai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.thongtinphanhoi.dao.model.impl.ThongTinPhanHoiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param soDienThoai the so dien thoai
	* @param start the lower bound of the range of thong tin phan hois
	* @param end the upper bound of the range of thong tin phan hois (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching thong tin phan hois
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi> findBySoDienThoai(
		java.lang.String soDienThoai, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySoDienThoai(soDienThoai, start, end, orderByComparator);
	}

	/**
	* Returns the first thong tin phan hoi in the ordered set where soDienThoai = &#63;.
	*
	* @param soDienThoai the so dien thoai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching thong tin phan hoi
	* @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchThongTinPhanHoiException if a matching thong tin phan hoi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi findBySoDienThoai_First(
		java.lang.String soDienThoai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.ns.thongtinphanhoi.dao.NoSuchThongTinPhanHoiException {
		return getPersistence()
				   .findBySoDienThoai_First(soDienThoai, orderByComparator);
	}

	/**
	* Returns the first thong tin phan hoi in the ordered set where soDienThoai = &#63;.
	*
	* @param soDienThoai the so dien thoai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching thong tin phan hoi, or <code>null</code> if a matching thong tin phan hoi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi fetchBySoDienThoai_First(
		java.lang.String soDienThoai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySoDienThoai_First(soDienThoai, orderByComparator);
	}

	/**
	* Returns the last thong tin phan hoi in the ordered set where soDienThoai = &#63;.
	*
	* @param soDienThoai the so dien thoai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching thong tin phan hoi
	* @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchThongTinPhanHoiException if a matching thong tin phan hoi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi findBySoDienThoai_Last(
		java.lang.String soDienThoai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.ns.thongtinphanhoi.dao.NoSuchThongTinPhanHoiException {
		return getPersistence()
				   .findBySoDienThoai_Last(soDienThoai, orderByComparator);
	}

	/**
	* Returns the last thong tin phan hoi in the ordered set where soDienThoai = &#63;.
	*
	* @param soDienThoai the so dien thoai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching thong tin phan hoi, or <code>null</code> if a matching thong tin phan hoi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi fetchBySoDienThoai_Last(
		java.lang.String soDienThoai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySoDienThoai_Last(soDienThoai, orderByComparator);
	}

	/**
	* Returns the thong tin phan hois before and after the current thong tin phan hoi in the ordered set where soDienThoai = &#63;.
	*
	* @param id the primary key of the current thong tin phan hoi
	* @param soDienThoai the so dien thoai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next thong tin phan hoi
	* @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchThongTinPhanHoiException if a thong tin phan hoi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi[] findBySoDienThoai_PrevAndNext(
		long id, java.lang.String soDienThoai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.ns.thongtinphanhoi.dao.NoSuchThongTinPhanHoiException {
		return getPersistence()
				   .findBySoDienThoai_PrevAndNext(id, soDienThoai,
			orderByComparator);
	}

	/**
	* Removes all the thong tin phan hois where soDienThoai = &#63; from the database.
	*
	* @param soDienThoai the so dien thoai
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySoDienThoai(java.lang.String soDienThoai)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySoDienThoai(soDienThoai);
	}

	/**
	* Returns the number of thong tin phan hois where soDienThoai = &#63;.
	*
	* @param soDienThoai the so dien thoai
	* @return the number of matching thong tin phan hois
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySoDienThoai(java.lang.String soDienThoai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySoDienThoai(soDienThoai);
	}

	/**
	* Caches the thong tin phan hoi in the entity cache if it is enabled.
	*
	* @param thongTinPhanHoi the thong tin phan hoi
	*/
	public static void cacheResult(
		vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi thongTinPhanHoi) {
		getPersistence().cacheResult(thongTinPhanHoi);
	}

	/**
	* Caches the thong tin phan hois in the entity cache if it is enabled.
	*
	* @param thongTinPhanHois the thong tin phan hois
	*/
	public static void cacheResult(
		java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi> thongTinPhanHois) {
		getPersistence().cacheResult(thongTinPhanHois);
	}

	/**
	* Creates a new thong tin phan hoi with the primary key. Does not add the thong tin phan hoi to the database.
	*
	* @param id the primary key for the new thong tin phan hoi
	* @return the new thong tin phan hoi
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the thong tin phan hoi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the thong tin phan hoi
	* @return the thong tin phan hoi that was removed
	* @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchThongTinPhanHoiException if a thong tin phan hoi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.ns.thongtinphanhoi.dao.NoSuchThongTinPhanHoiException {
		return getPersistence().remove(id);
	}

	public static vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi updateImpl(
		vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi thongTinPhanHoi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(thongTinPhanHoi);
	}

	/**
	* Returns the thong tin phan hoi with the primary key or throws a {@link vn.dtt.ns.thongtinphanhoi.dao.NoSuchThongTinPhanHoiException} if it could not be found.
	*
	* @param id the primary key of the thong tin phan hoi
	* @return the thong tin phan hoi
	* @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchThongTinPhanHoiException if a thong tin phan hoi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.ns.thongtinphanhoi.dao.NoSuchThongTinPhanHoiException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the thong tin phan hoi with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the thong tin phan hoi
	* @return the thong tin phan hoi, or <code>null</code> if a thong tin phan hoi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the thong tin phan hois.
	*
	* @return the thong tin phan hois
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the thong tin phan hois.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.thongtinphanhoi.dao.model.impl.ThongTinPhanHoiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of thong tin phan hois
	* @param end the upper bound of the range of thong tin phan hois (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of thong tin phan hois
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the thong tin phan hois from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of thong tin phan hois.
	*
	* @return the number of thong tin phan hois
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ThongTinPhanHoiPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ThongTinPhanHoiPersistence)PortletBeanLocatorUtil.locate(vn.dtt.ns.thongtinphanhoi.dao.service.ClpSerializer.getServletContextName(),
					ThongTinPhanHoiPersistence.class.getName());

			ReferenceRegistry.registerReference(ThongTinPhanHoiUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ThongTinPhanHoiPersistence persistence) {
	}

	private static ThongTinPhanHoiPersistence _persistence;
}