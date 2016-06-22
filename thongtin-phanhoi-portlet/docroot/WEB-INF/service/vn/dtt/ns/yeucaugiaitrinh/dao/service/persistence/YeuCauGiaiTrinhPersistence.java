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

import com.liferay.portal.service.persistence.BasePersistence;

import vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh;

/**
 * The persistence interface for the yeu cau giai trinh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tubq
 * @see YeuCauGiaiTrinhPersistenceImpl
 * @see YeuCauGiaiTrinhUtil
 * @generated
 */
public interface YeuCauGiaiTrinhPersistence extends BasePersistence<YeuCauGiaiTrinh> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link YeuCauGiaiTrinhUtil} to access the yeu cau giai trinh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the yeu cau giai trinh in the entity cache if it is enabled.
	*
	* @param yeuCauGiaiTrinh the yeu cau giai trinh
	*/
	public void cacheResult(
		vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh yeuCauGiaiTrinh);

	/**
	* Caches the yeu cau giai trinhs in the entity cache if it is enabled.
	*
	* @param yeuCauGiaiTrinhs the yeu cau giai trinhs
	*/
	public void cacheResult(
		java.util.List<vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh> yeuCauGiaiTrinhs);

	/**
	* Creates a new yeu cau giai trinh with the primary key. Does not add the yeu cau giai trinh to the database.
	*
	* @param id the primary key for the new yeu cau giai trinh
	* @return the new yeu cau giai trinh
	*/
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh create(long id);

	/**
	* Removes the yeu cau giai trinh with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the yeu cau giai trinh
	* @return the yeu cau giai trinh that was removed
	* @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchYeuCauGiaiTrinhException if a yeu cau giai trinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchYeuCauGiaiTrinhException;

	public vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh updateImpl(
		vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh yeuCauGiaiTrinh)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the yeu cau giai trinh with the primary key or throws a {@link vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchYeuCauGiaiTrinhException} if it could not be found.
	*
	* @param id the primary key of the yeu cau giai trinh
	* @return the yeu cau giai trinh
	* @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchYeuCauGiaiTrinhException if a yeu cau giai trinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchYeuCauGiaiTrinhException;

	/**
	* Returns the yeu cau giai trinh with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the yeu cau giai trinh
	* @return the yeu cau giai trinh, or <code>null</code> if a yeu cau giai trinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the yeu cau giai trinhs.
	*
	* @return the yeu cau giai trinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the yeu cau giai trinhs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of yeu cau giai trinhs.
	*
	* @return the number of yeu cau giai trinhs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}