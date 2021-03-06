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

import vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh;

/**
 * The persistence interface for the trang thai giai trinh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tubq
 * @see TrangThaiGiaiTrinhPersistenceImpl
 * @see TrangThaiGiaiTrinhUtil
 * @generated
 */
public interface TrangThaiGiaiTrinhPersistence extends BasePersistence<TrangThaiGiaiTrinh> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TrangThaiGiaiTrinhUtil} to access the trang thai giai trinh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the trang thai giai trinhs where yeuCauGiaiTrinhId = &#63;.
	*
	* @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	* @return the matching trang thai giai trinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh> findByQuaTrinhXuLy(
		long yeuCauGiaiTrinhId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the trang thai giai trinhs where yeuCauGiaiTrinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.TrangThaiGiaiTrinhModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	* @param start the lower bound of the range of trang thai giai trinhs
	* @param end the upper bound of the range of trang thai giai trinhs (not inclusive)
	* @return the range of matching trang thai giai trinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh> findByQuaTrinhXuLy(
		long yeuCauGiaiTrinhId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the trang thai giai trinhs where yeuCauGiaiTrinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.TrangThaiGiaiTrinhModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	* @param start the lower bound of the range of trang thai giai trinhs
	* @param end the upper bound of the range of trang thai giai trinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching trang thai giai trinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh> findByQuaTrinhXuLy(
		long yeuCauGiaiTrinhId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first trang thai giai trinh in the ordered set where yeuCauGiaiTrinhId = &#63;.
	*
	* @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching trang thai giai trinh
	* @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchTrangThaiGiaiTrinhException if a matching trang thai giai trinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh findByQuaTrinhXuLy_First(
		long yeuCauGiaiTrinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchTrangThaiGiaiTrinhException;

	/**
	* Returns the first trang thai giai trinh in the ordered set where yeuCauGiaiTrinhId = &#63;.
	*
	* @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching trang thai giai trinh, or <code>null</code> if a matching trang thai giai trinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh fetchByQuaTrinhXuLy_First(
		long yeuCauGiaiTrinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last trang thai giai trinh in the ordered set where yeuCauGiaiTrinhId = &#63;.
	*
	* @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching trang thai giai trinh
	* @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchTrangThaiGiaiTrinhException if a matching trang thai giai trinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh findByQuaTrinhXuLy_Last(
		long yeuCauGiaiTrinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchTrangThaiGiaiTrinhException;

	/**
	* Returns the last trang thai giai trinh in the ordered set where yeuCauGiaiTrinhId = &#63;.
	*
	* @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching trang thai giai trinh, or <code>null</code> if a matching trang thai giai trinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh fetchByQuaTrinhXuLy_Last(
		long yeuCauGiaiTrinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the trang thai giai trinhs before and after the current trang thai giai trinh in the ordered set where yeuCauGiaiTrinhId = &#63;.
	*
	* @param id the primary key of the current trang thai giai trinh
	* @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next trang thai giai trinh
	* @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchTrangThaiGiaiTrinhException if a trang thai giai trinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh[] findByQuaTrinhXuLy_PrevAndNext(
		long id, long yeuCauGiaiTrinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchTrangThaiGiaiTrinhException;

	/**
	* Removes all the trang thai giai trinhs where yeuCauGiaiTrinhId = &#63; from the database.
	*
	* @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByQuaTrinhXuLy(long yeuCauGiaiTrinhId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of trang thai giai trinhs where yeuCauGiaiTrinhId = &#63;.
	*
	* @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	* @return the number of matching trang thai giai trinhs
	* @throws SystemException if a system exception occurred
	*/
	public int countByQuaTrinhXuLy(long yeuCauGiaiTrinhId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the trang thai giai trinh in the entity cache if it is enabled.
	*
	* @param trangThaiGiaiTrinh the trang thai giai trinh
	*/
	public void cacheResult(
		vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh trangThaiGiaiTrinh);

	/**
	* Caches the trang thai giai trinhs in the entity cache if it is enabled.
	*
	* @param trangThaiGiaiTrinhs the trang thai giai trinhs
	*/
	public void cacheResult(
		java.util.List<vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh> trangThaiGiaiTrinhs);

	/**
	* Creates a new trang thai giai trinh with the primary key. Does not add the trang thai giai trinh to the database.
	*
	* @param id the primary key for the new trang thai giai trinh
	* @return the new trang thai giai trinh
	*/
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh create(
		long id);

	/**
	* Removes the trang thai giai trinh with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the trang thai giai trinh
	* @return the trang thai giai trinh that was removed
	* @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchTrangThaiGiaiTrinhException if a trang thai giai trinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchTrangThaiGiaiTrinhException;

	public vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh updateImpl(
		vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh trangThaiGiaiTrinh)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the trang thai giai trinh with the primary key or throws a {@link vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchTrangThaiGiaiTrinhException} if it could not be found.
	*
	* @param id the primary key of the trang thai giai trinh
	* @return the trang thai giai trinh
	* @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchTrangThaiGiaiTrinhException if a trang thai giai trinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchTrangThaiGiaiTrinhException;

	/**
	* Returns the trang thai giai trinh with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the trang thai giai trinh
	* @return the trang thai giai trinh, or <code>null</code> if a trang thai giai trinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the trang thai giai trinhs.
	*
	* @return the trang thai giai trinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the trang thai giai trinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.TrangThaiGiaiTrinhModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of trang thai giai trinhs
	* @param end the upper bound of the range of trang thai giai trinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of trang thai giai trinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the trang thai giai trinhs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of trang thai giai trinhs.
	*
	* @return the number of trang thai giai trinhs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}