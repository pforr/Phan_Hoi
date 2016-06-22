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

import vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi;

import java.util.List;

/**
 * The persistence utility for the chi tiet thong tin phan hoi service. This utility wraps {@link ChiTietThongTinPhanHoiPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tubq
 * @see ChiTietThongTinPhanHoiPersistence
 * @see ChiTietThongTinPhanHoiPersistenceImpl
 * @generated
 */
public class ChiTietThongTinPhanHoiUtil {
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
	public static void clearCache(ChiTietThongTinPhanHoi chiTietThongTinPhanHoi) {
		getPersistence().clearCache(chiTietThongTinPhanHoi);
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
	public static List<ChiTietThongTinPhanHoi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ChiTietThongTinPhanHoi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ChiTietThongTinPhanHoi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ChiTietThongTinPhanHoi update(
		ChiTietThongTinPhanHoi chiTietThongTinPhanHoi)
		throws SystemException {
		return getPersistence().update(chiTietThongTinPhanHoi);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ChiTietThongTinPhanHoi update(
		ChiTietThongTinPhanHoi chiTietThongTinPhanHoi,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(chiTietThongTinPhanHoi, serviceContext);
	}

	/**
	* Returns all the chi tiet thong tin phan hois where thongTinPhanHoiId = &#63;.
	*
	* @param thongTinPhanHoiId the thong tin phan hoi ID
	* @return the matching chi tiet thong tin phan hois
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi> findByThongTinPhanHoiId(
		long thongTinPhanHoiId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByThongTinPhanHoiId(thongTinPhanHoiId);
	}

	/**
	* Returns a range of all the chi tiet thong tin phan hois where thongTinPhanHoiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.thongtinphanhoi.dao.model.impl.ChiTietThongTinPhanHoiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param thongTinPhanHoiId the thong tin phan hoi ID
	* @param start the lower bound of the range of chi tiet thong tin phan hois
	* @param end the upper bound of the range of chi tiet thong tin phan hois (not inclusive)
	* @return the range of matching chi tiet thong tin phan hois
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi> findByThongTinPhanHoiId(
		long thongTinPhanHoiId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThongTinPhanHoiId(thongTinPhanHoiId, start, end);
	}

	/**
	* Returns an ordered range of all the chi tiet thong tin phan hois where thongTinPhanHoiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.thongtinphanhoi.dao.model.impl.ChiTietThongTinPhanHoiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param thongTinPhanHoiId the thong tin phan hoi ID
	* @param start the lower bound of the range of chi tiet thong tin phan hois
	* @param end the upper bound of the range of chi tiet thong tin phan hois (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching chi tiet thong tin phan hois
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi> findByThongTinPhanHoiId(
		long thongTinPhanHoiId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThongTinPhanHoiId(thongTinPhanHoiId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first chi tiet thong tin phan hoi in the ordered set where thongTinPhanHoiId = &#63;.
	*
	* @param thongTinPhanHoiId the thong tin phan hoi ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chi tiet thong tin phan hoi
	* @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchChiTietThongTinPhanHoiException if a matching chi tiet thong tin phan hoi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi findByThongTinPhanHoiId_First(
		long thongTinPhanHoiId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.ns.thongtinphanhoi.dao.NoSuchChiTietThongTinPhanHoiException {
		return getPersistence()
				   .findByThongTinPhanHoiId_First(thongTinPhanHoiId,
			orderByComparator);
	}

	/**
	* Returns the first chi tiet thong tin phan hoi in the ordered set where thongTinPhanHoiId = &#63;.
	*
	* @param thongTinPhanHoiId the thong tin phan hoi ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chi tiet thong tin phan hoi, or <code>null</code> if a matching chi tiet thong tin phan hoi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi fetchByThongTinPhanHoiId_First(
		long thongTinPhanHoiId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByThongTinPhanHoiId_First(thongTinPhanHoiId,
			orderByComparator);
	}

	/**
	* Returns the last chi tiet thong tin phan hoi in the ordered set where thongTinPhanHoiId = &#63;.
	*
	* @param thongTinPhanHoiId the thong tin phan hoi ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chi tiet thong tin phan hoi
	* @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchChiTietThongTinPhanHoiException if a matching chi tiet thong tin phan hoi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi findByThongTinPhanHoiId_Last(
		long thongTinPhanHoiId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.ns.thongtinphanhoi.dao.NoSuchChiTietThongTinPhanHoiException {
		return getPersistence()
				   .findByThongTinPhanHoiId_Last(thongTinPhanHoiId,
			orderByComparator);
	}

	/**
	* Returns the last chi tiet thong tin phan hoi in the ordered set where thongTinPhanHoiId = &#63;.
	*
	* @param thongTinPhanHoiId the thong tin phan hoi ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chi tiet thong tin phan hoi, or <code>null</code> if a matching chi tiet thong tin phan hoi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi fetchByThongTinPhanHoiId_Last(
		long thongTinPhanHoiId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByThongTinPhanHoiId_Last(thongTinPhanHoiId,
			orderByComparator);
	}

	/**
	* Returns the chi tiet thong tin phan hois before and after the current chi tiet thong tin phan hoi in the ordered set where thongTinPhanHoiId = &#63;.
	*
	* @param id the primary key of the current chi tiet thong tin phan hoi
	* @param thongTinPhanHoiId the thong tin phan hoi ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next chi tiet thong tin phan hoi
	* @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchChiTietThongTinPhanHoiException if a chi tiet thong tin phan hoi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi[] findByThongTinPhanHoiId_PrevAndNext(
		long id, long thongTinPhanHoiId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.ns.thongtinphanhoi.dao.NoSuchChiTietThongTinPhanHoiException {
		return getPersistence()
				   .findByThongTinPhanHoiId_PrevAndNext(id, thongTinPhanHoiId,
			orderByComparator);
	}

	/**
	* Removes all the chi tiet thong tin phan hois where thongTinPhanHoiId = &#63; from the database.
	*
	* @param thongTinPhanHoiId the thong tin phan hoi ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByThongTinPhanHoiId(long thongTinPhanHoiId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByThongTinPhanHoiId(thongTinPhanHoiId);
	}

	/**
	* Returns the number of chi tiet thong tin phan hois where thongTinPhanHoiId = &#63;.
	*
	* @param thongTinPhanHoiId the thong tin phan hoi ID
	* @return the number of matching chi tiet thong tin phan hois
	* @throws SystemException if a system exception occurred
	*/
	public static int countByThongTinPhanHoiId(long thongTinPhanHoiId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByThongTinPhanHoiId(thongTinPhanHoiId);
	}

	/**
	* Caches the chi tiet thong tin phan hoi in the entity cache if it is enabled.
	*
	* @param chiTietThongTinPhanHoi the chi tiet thong tin phan hoi
	*/
	public static void cacheResult(
		vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi chiTietThongTinPhanHoi) {
		getPersistence().cacheResult(chiTietThongTinPhanHoi);
	}

	/**
	* Caches the chi tiet thong tin phan hois in the entity cache if it is enabled.
	*
	* @param chiTietThongTinPhanHois the chi tiet thong tin phan hois
	*/
	public static void cacheResult(
		java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi> chiTietThongTinPhanHois) {
		getPersistence().cacheResult(chiTietThongTinPhanHois);
	}

	/**
	* Creates a new chi tiet thong tin phan hoi with the primary key. Does not add the chi tiet thong tin phan hoi to the database.
	*
	* @param id the primary key for the new chi tiet thong tin phan hoi
	* @return the new chi tiet thong tin phan hoi
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the chi tiet thong tin phan hoi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the chi tiet thong tin phan hoi
	* @return the chi tiet thong tin phan hoi that was removed
	* @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchChiTietThongTinPhanHoiException if a chi tiet thong tin phan hoi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.ns.thongtinphanhoi.dao.NoSuchChiTietThongTinPhanHoiException {
		return getPersistence().remove(id);
	}

	public static vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi updateImpl(
		vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi chiTietThongTinPhanHoi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(chiTietThongTinPhanHoi);
	}

	/**
	* Returns the chi tiet thong tin phan hoi with the primary key or throws a {@link vn.dtt.ns.thongtinphanhoi.dao.NoSuchChiTietThongTinPhanHoiException} if it could not be found.
	*
	* @param id the primary key of the chi tiet thong tin phan hoi
	* @return the chi tiet thong tin phan hoi
	* @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchChiTietThongTinPhanHoiException if a chi tiet thong tin phan hoi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.ns.thongtinphanhoi.dao.NoSuchChiTietThongTinPhanHoiException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the chi tiet thong tin phan hoi with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the chi tiet thong tin phan hoi
	* @return the chi tiet thong tin phan hoi, or <code>null</code> if a chi tiet thong tin phan hoi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the chi tiet thong tin phan hois.
	*
	* @return the chi tiet thong tin phan hois
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the chi tiet thong tin phan hois.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.thongtinphanhoi.dao.model.impl.ChiTietThongTinPhanHoiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of chi tiet thong tin phan hois
	* @param end the upper bound of the range of chi tiet thong tin phan hois (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of chi tiet thong tin phan hois
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the chi tiet thong tin phan hois from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of chi tiet thong tin phan hois.
	*
	* @return the number of chi tiet thong tin phan hois
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ChiTietThongTinPhanHoiPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ChiTietThongTinPhanHoiPersistence)PortletBeanLocatorUtil.locate(vn.dtt.ns.thongtinphanhoi.dao.service.ClpSerializer.getServletContextName(),
					ChiTietThongTinPhanHoiPersistence.class.getName());

			ReferenceRegistry.registerReference(ChiTietThongTinPhanHoiUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ChiTietThongTinPhanHoiPersistence persistence) {
	}

	private static ChiTietThongTinPhanHoiPersistence _persistence;
}