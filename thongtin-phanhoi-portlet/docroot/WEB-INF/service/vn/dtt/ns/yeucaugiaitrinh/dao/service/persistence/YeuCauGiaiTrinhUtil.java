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

package vn.dtt.ns.yeucaugiaitrinh.dao.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh;

import java.util.List;

/**
 * The persistence utility for the yeu cau giai trinh service. This utility wraps {@link YeuCauGiaiTrinhPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tubq
 * @see YeuCauGiaiTrinhPersistence
 * @see YeuCauGiaiTrinhPersistenceImpl
 * @generated
 */
public class YeuCauGiaiTrinhUtil {
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
	public static void clearCache(YeuCauGiaiTrinh yeuCauGiaiTrinh) {
		getPersistence().clearCache(yeuCauGiaiTrinh);
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
	public static List<YeuCauGiaiTrinh> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<YeuCauGiaiTrinh> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<YeuCauGiaiTrinh> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static YeuCauGiaiTrinh update(YeuCauGiaiTrinh yeuCauGiaiTrinh)
		throws SystemException {
		return getPersistence().update(yeuCauGiaiTrinh);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static YeuCauGiaiTrinh update(YeuCauGiaiTrinh yeuCauGiaiTrinh,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(yeuCauGiaiTrinh, serviceContext);
	}

	/**
	* Caches the yeu cau giai trinh in the entity cache if it is enabled.
	*
	* @param yeuCauGiaiTrinh the yeu cau giai trinh
	*/
	public static void cacheResult(
		vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh yeuCauGiaiTrinh) {
		getPersistence().cacheResult(yeuCauGiaiTrinh);
	}

	/**
	* Caches the yeu cau giai trinhs in the entity cache if it is enabled.
	*
	* @param yeuCauGiaiTrinhs the yeu cau giai trinhs
	*/
	public static void cacheResult(
		java.util.List<vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh> yeuCauGiaiTrinhs) {
		getPersistence().cacheResult(yeuCauGiaiTrinhs);
	}

	/**
	* Creates a new yeu cau giai trinh with the primary key. Does not add the yeu cau giai trinh to the database.
	*
	* @param id the primary key for the new yeu cau giai trinh
	* @return the new yeu cau giai trinh
	*/
	public static vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the yeu cau giai trinh with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the yeu cau giai trinh
	* @return the yeu cau giai trinh that was removed
	* @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchYeuCauGiaiTrinhException if a yeu cau giai trinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchYeuCauGiaiTrinhException {
		return getPersistence().remove(id);
	}

	public static vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh updateImpl(
		vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh yeuCauGiaiTrinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(yeuCauGiaiTrinh);
	}

	/**
	* Returns the yeu cau giai trinh with the primary key or throws a {@link vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchYeuCauGiaiTrinhException} if it could not be found.
	*
	* @param id the primary key of the yeu cau giai trinh
	* @return the yeu cau giai trinh
	* @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchYeuCauGiaiTrinhException if a yeu cau giai trinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchYeuCauGiaiTrinhException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the yeu cau giai trinh with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the yeu cau giai trinh
	* @return the yeu cau giai trinh, or <code>null</code> if a yeu cau giai trinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the yeu cau giai trinhs.
	*
	* @return the yeu cau giai trinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the yeu cau giai trinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.YeuCauGiaiTrinhModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of yeu cau giai trinhs
	* @param end the upper bound of the range of yeu cau giai trinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of yeu cau giai trinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the yeu cau giai trinhs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of yeu cau giai trinhs.
	*
	* @return the number of yeu cau giai trinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static YeuCauGiaiTrinhPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (YeuCauGiaiTrinhPersistence)PortletBeanLocatorUtil.locate(vn.dtt.ns.yeucaugiaitrinh.dao.service.ClpSerializer.getServletContextName(),
					YeuCauGiaiTrinhPersistence.class.getName());

			ReferenceRegistry.registerReference(YeuCauGiaiTrinhUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(YeuCauGiaiTrinhPersistence persistence) {
	}

	private static YeuCauGiaiTrinhPersistence _persistence;
}