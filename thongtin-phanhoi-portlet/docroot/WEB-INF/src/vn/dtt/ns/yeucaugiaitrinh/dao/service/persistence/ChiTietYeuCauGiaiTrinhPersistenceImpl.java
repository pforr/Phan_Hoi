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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchChiTietYeuCauGiaiTrinhException;
import vn.dtt.ns.yeucaugiaitrinh.dao.model.ChiTietYeuCauGiaiTrinh;
import vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.ChiTietYeuCauGiaiTrinhImpl;
import vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.ChiTietYeuCauGiaiTrinhModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the chi tiet yeu cau giai trinh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tubq
 * @see ChiTietYeuCauGiaiTrinhPersistence
 * @see ChiTietYeuCauGiaiTrinhUtil
 * @generated
 */
public class ChiTietYeuCauGiaiTrinhPersistenceImpl extends BasePersistenceImpl<ChiTietYeuCauGiaiTrinh>
	implements ChiTietYeuCauGiaiTrinhPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ChiTietYeuCauGiaiTrinhUtil} to access the chi tiet yeu cau giai trinh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ChiTietYeuCauGiaiTrinhImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ChiTietYeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietYeuCauGiaiTrinhModelImpl.FINDER_CACHE_ENABLED,
			ChiTietYeuCauGiaiTrinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ChiTietYeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietYeuCauGiaiTrinhModelImpl.FINDER_CACHE_ENABLED,
			ChiTietYeuCauGiaiTrinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ChiTietYeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietYeuCauGiaiTrinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH =
		new FinderPath(ChiTietYeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietYeuCauGiaiTrinhModelImpl.FINDER_CACHE_ENABLED,
			ChiTietYeuCauGiaiTrinhImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByChiTietGiaiTrinhByYcgtIdAndMaThongTinPhanAnh",
			new String[] { Long.class.getName(), String.class.getName() },
			ChiTietYeuCauGiaiTrinhModelImpl.YEUCAUGIAITRINHID_COLUMN_BITMASK |
			ChiTietYeuCauGiaiTrinhModelImpl.MATHONGTINPHANANH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH =
		new FinderPath(ChiTietYeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietYeuCauGiaiTrinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByChiTietGiaiTrinhByYcgtIdAndMaThongTinPhanAnh",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the chi tiet yeu cau giai trinh where yeuCauGiaiTrinhId = &#63; and maThongTinPhanAnh = &#63; or throws a {@link vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchChiTietYeuCauGiaiTrinhException} if it could not be found.
	 *
	 * @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	 * @param maThongTinPhanAnh the ma thong tin phan anh
	 * @return the matching chi tiet yeu cau giai trinh
	 * @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchChiTietYeuCauGiaiTrinhException if a matching chi tiet yeu cau giai trinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietYeuCauGiaiTrinh findByChiTietGiaiTrinhByYcgtIdAndMaThongTinPhanAnh(
		long yeuCauGiaiTrinhId, String maThongTinPhanAnh)
		throws NoSuchChiTietYeuCauGiaiTrinhException, SystemException {
		ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh = fetchByChiTietGiaiTrinhByYcgtIdAndMaThongTinPhanAnh(yeuCauGiaiTrinhId,
				maThongTinPhanAnh);

		if (chiTietYeuCauGiaiTrinh == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("yeuCauGiaiTrinhId=");
			msg.append(yeuCauGiaiTrinhId);

			msg.append(", maThongTinPhanAnh=");
			msg.append(maThongTinPhanAnh);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchChiTietYeuCauGiaiTrinhException(msg.toString());
		}

		return chiTietYeuCauGiaiTrinh;
	}

	/**
	 * Returns the chi tiet yeu cau giai trinh where yeuCauGiaiTrinhId = &#63; and maThongTinPhanAnh = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	 * @param maThongTinPhanAnh the ma thong tin phan anh
	 * @return the matching chi tiet yeu cau giai trinh, or <code>null</code> if a matching chi tiet yeu cau giai trinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietYeuCauGiaiTrinh fetchByChiTietGiaiTrinhByYcgtIdAndMaThongTinPhanAnh(
		long yeuCauGiaiTrinhId, String maThongTinPhanAnh)
		throws SystemException {
		return fetchByChiTietGiaiTrinhByYcgtIdAndMaThongTinPhanAnh(yeuCauGiaiTrinhId,
			maThongTinPhanAnh, true);
	}

	/**
	 * Returns the chi tiet yeu cau giai trinh where yeuCauGiaiTrinhId = &#63; and maThongTinPhanAnh = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	 * @param maThongTinPhanAnh the ma thong tin phan anh
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching chi tiet yeu cau giai trinh, or <code>null</code> if a matching chi tiet yeu cau giai trinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietYeuCauGiaiTrinh fetchByChiTietGiaiTrinhByYcgtIdAndMaThongTinPhanAnh(
		long yeuCauGiaiTrinhId, String maThongTinPhanAnh,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { yeuCauGiaiTrinhId, maThongTinPhanAnh };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH,
					finderArgs, this);
		}

		if (result instanceof ChiTietYeuCauGiaiTrinh) {
			ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh = (ChiTietYeuCauGiaiTrinh)result;

			if ((yeuCauGiaiTrinhId != chiTietYeuCauGiaiTrinh.getYeuCauGiaiTrinhId()) ||
					!Validator.equals(maThongTinPhanAnh,
						chiTietYeuCauGiaiTrinh.getMaThongTinPhanAnh())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CHITIETYEUCAUGIAITRINH_WHERE);

			query.append(_FINDER_COLUMN_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH_YEUCAUGIAITRINHID_2);

			boolean bindMaThongTinPhanAnh = false;

			if (maThongTinPhanAnh == null) {
				query.append(_FINDER_COLUMN_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH_MATHONGTINPHANANH_1);
			}
			else if (maThongTinPhanAnh.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH_MATHONGTINPHANANH_3);
			}
			else {
				bindMaThongTinPhanAnh = true;

				query.append(_FINDER_COLUMN_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH_MATHONGTINPHANANH_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(yeuCauGiaiTrinhId);

				if (bindMaThongTinPhanAnh) {
					qPos.add(maThongTinPhanAnh);
				}

				List<ChiTietYeuCauGiaiTrinh> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ChiTietYeuCauGiaiTrinhPersistenceImpl.fetchByChiTietGiaiTrinhByYcgtIdAndMaThongTinPhanAnh(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh = list.get(0);

					result = chiTietYeuCauGiaiTrinh;

					cacheResult(chiTietYeuCauGiaiTrinh);

					if ((chiTietYeuCauGiaiTrinh.getYeuCauGiaiTrinhId() != yeuCauGiaiTrinhId) ||
							(chiTietYeuCauGiaiTrinh.getMaThongTinPhanAnh() == null) ||
							!chiTietYeuCauGiaiTrinh.getMaThongTinPhanAnh()
													   .equals(maThongTinPhanAnh)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH,
							finderArgs, chiTietYeuCauGiaiTrinh);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ChiTietYeuCauGiaiTrinh)result;
		}
	}

	/**
	 * Removes the chi tiet yeu cau giai trinh where yeuCauGiaiTrinhId = &#63; and maThongTinPhanAnh = &#63; from the database.
	 *
	 * @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	 * @param maThongTinPhanAnh the ma thong tin phan anh
	 * @return the chi tiet yeu cau giai trinh that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietYeuCauGiaiTrinh removeByChiTietGiaiTrinhByYcgtIdAndMaThongTinPhanAnh(
		long yeuCauGiaiTrinhId, String maThongTinPhanAnh)
		throws NoSuchChiTietYeuCauGiaiTrinhException, SystemException {
		ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh = findByChiTietGiaiTrinhByYcgtIdAndMaThongTinPhanAnh(yeuCauGiaiTrinhId,
				maThongTinPhanAnh);

		return remove(chiTietYeuCauGiaiTrinh);
	}

	/**
	 * Returns the number of chi tiet yeu cau giai trinhs where yeuCauGiaiTrinhId = &#63; and maThongTinPhanAnh = &#63;.
	 *
	 * @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	 * @param maThongTinPhanAnh the ma thong tin phan anh
	 * @return the number of matching chi tiet yeu cau giai trinhs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByChiTietGiaiTrinhByYcgtIdAndMaThongTinPhanAnh(
		long yeuCauGiaiTrinhId, String maThongTinPhanAnh)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH;

		Object[] finderArgs = new Object[] { yeuCauGiaiTrinhId, maThongTinPhanAnh };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CHITIETYEUCAUGIAITRINH_WHERE);

			query.append(_FINDER_COLUMN_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH_YEUCAUGIAITRINHID_2);

			boolean bindMaThongTinPhanAnh = false;

			if (maThongTinPhanAnh == null) {
				query.append(_FINDER_COLUMN_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH_MATHONGTINPHANANH_1);
			}
			else if (maThongTinPhanAnh.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH_MATHONGTINPHANANH_3);
			}
			else {
				bindMaThongTinPhanAnh = true;

				query.append(_FINDER_COLUMN_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH_MATHONGTINPHANANH_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(yeuCauGiaiTrinhId);

				if (bindMaThongTinPhanAnh) {
					qPos.add(maThongTinPhanAnh);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH_YEUCAUGIAITRINHID_2 =
		"chiTietYeuCauGiaiTrinh.yeuCauGiaiTrinhId = ? AND ";
	private static final String _FINDER_COLUMN_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH_MATHONGTINPHANANH_1 =
		"chiTietYeuCauGiaiTrinh.maThongTinPhanAnh IS NULL";
	private static final String _FINDER_COLUMN_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH_MATHONGTINPHANANH_2 =
		"chiTietYeuCauGiaiTrinh.maThongTinPhanAnh = ?";
	private static final String _FINDER_COLUMN_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH_MATHONGTINPHANANH_3 =
		"(chiTietYeuCauGiaiTrinh.maThongTinPhanAnh IS NULL OR chiTietYeuCauGiaiTrinh.maThongTinPhanAnh = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CHITIETGIAITRINHBYYCGTID =
		new FinderPath(ChiTietYeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietYeuCauGiaiTrinhModelImpl.FINDER_CACHE_ENABLED,
			ChiTietYeuCauGiaiTrinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByChiTietGiaiTrinhByYcgtId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHITIETGIAITRINHBYYCGTID =
		new FinderPath(ChiTietYeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietYeuCauGiaiTrinhModelImpl.FINDER_CACHE_ENABLED,
			ChiTietYeuCauGiaiTrinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByChiTietGiaiTrinhByYcgtId",
			new String[] { Long.class.getName() },
			ChiTietYeuCauGiaiTrinhModelImpl.YEUCAUGIAITRINHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CHITIETGIAITRINHBYYCGTID =
		new FinderPath(ChiTietYeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietYeuCauGiaiTrinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByChiTietGiaiTrinhByYcgtId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the chi tiet yeu cau giai trinhs where yeuCauGiaiTrinhId = &#63;.
	 *
	 * @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	 * @return the matching chi tiet yeu cau giai trinhs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChiTietYeuCauGiaiTrinh> findByChiTietGiaiTrinhByYcgtId(
		long yeuCauGiaiTrinhId) throws SystemException {
		return findByChiTietGiaiTrinhByYcgtId(yeuCauGiaiTrinhId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chi tiet yeu cau giai trinhs where yeuCauGiaiTrinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.ChiTietYeuCauGiaiTrinhModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	 * @param start the lower bound of the range of chi tiet yeu cau giai trinhs
	 * @param end the upper bound of the range of chi tiet yeu cau giai trinhs (not inclusive)
	 * @return the range of matching chi tiet yeu cau giai trinhs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChiTietYeuCauGiaiTrinh> findByChiTietGiaiTrinhByYcgtId(
		long yeuCauGiaiTrinhId, int start, int end) throws SystemException {
		return findByChiTietGiaiTrinhByYcgtId(yeuCauGiaiTrinhId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the chi tiet yeu cau giai trinhs where yeuCauGiaiTrinhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.ChiTietYeuCauGiaiTrinhModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	 * @param start the lower bound of the range of chi tiet yeu cau giai trinhs
	 * @param end the upper bound of the range of chi tiet yeu cau giai trinhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chi tiet yeu cau giai trinhs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChiTietYeuCauGiaiTrinh> findByChiTietGiaiTrinhByYcgtId(
		long yeuCauGiaiTrinhId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHITIETGIAITRINHBYYCGTID;
			finderArgs = new Object[] { yeuCauGiaiTrinhId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CHITIETGIAITRINHBYYCGTID;
			finderArgs = new Object[] {
					yeuCauGiaiTrinhId,
					
					start, end, orderByComparator
				};
		}

		List<ChiTietYeuCauGiaiTrinh> list = (List<ChiTietYeuCauGiaiTrinh>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh : list) {
				if ((yeuCauGiaiTrinhId != chiTietYeuCauGiaiTrinh.getYeuCauGiaiTrinhId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CHITIETYEUCAUGIAITRINH_WHERE);

			query.append(_FINDER_COLUMN_CHITIETGIAITRINHBYYCGTID_YEUCAUGIAITRINHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ChiTietYeuCauGiaiTrinhModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(yeuCauGiaiTrinhId);

				if (!pagination) {
					list = (List<ChiTietYeuCauGiaiTrinh>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ChiTietYeuCauGiaiTrinh>(list);
				}
				else {
					list = (List<ChiTietYeuCauGiaiTrinh>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first chi tiet yeu cau giai trinh in the ordered set where yeuCauGiaiTrinhId = &#63;.
	 *
	 * @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chi tiet yeu cau giai trinh
	 * @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchChiTietYeuCauGiaiTrinhException if a matching chi tiet yeu cau giai trinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietYeuCauGiaiTrinh findByChiTietGiaiTrinhByYcgtId_First(
		long yeuCauGiaiTrinhId, OrderByComparator orderByComparator)
		throws NoSuchChiTietYeuCauGiaiTrinhException, SystemException {
		ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh = fetchByChiTietGiaiTrinhByYcgtId_First(yeuCauGiaiTrinhId,
				orderByComparator);

		if (chiTietYeuCauGiaiTrinh != null) {
			return chiTietYeuCauGiaiTrinh;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("yeuCauGiaiTrinhId=");
		msg.append(yeuCauGiaiTrinhId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChiTietYeuCauGiaiTrinhException(msg.toString());
	}

	/**
	 * Returns the first chi tiet yeu cau giai trinh in the ordered set where yeuCauGiaiTrinhId = &#63;.
	 *
	 * @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chi tiet yeu cau giai trinh, or <code>null</code> if a matching chi tiet yeu cau giai trinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietYeuCauGiaiTrinh fetchByChiTietGiaiTrinhByYcgtId_First(
		long yeuCauGiaiTrinhId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ChiTietYeuCauGiaiTrinh> list = findByChiTietGiaiTrinhByYcgtId(yeuCauGiaiTrinhId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last chi tiet yeu cau giai trinh in the ordered set where yeuCauGiaiTrinhId = &#63;.
	 *
	 * @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chi tiet yeu cau giai trinh
	 * @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchChiTietYeuCauGiaiTrinhException if a matching chi tiet yeu cau giai trinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietYeuCauGiaiTrinh findByChiTietGiaiTrinhByYcgtId_Last(
		long yeuCauGiaiTrinhId, OrderByComparator orderByComparator)
		throws NoSuchChiTietYeuCauGiaiTrinhException, SystemException {
		ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh = fetchByChiTietGiaiTrinhByYcgtId_Last(yeuCauGiaiTrinhId,
				orderByComparator);

		if (chiTietYeuCauGiaiTrinh != null) {
			return chiTietYeuCauGiaiTrinh;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("yeuCauGiaiTrinhId=");
		msg.append(yeuCauGiaiTrinhId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChiTietYeuCauGiaiTrinhException(msg.toString());
	}

	/**
	 * Returns the last chi tiet yeu cau giai trinh in the ordered set where yeuCauGiaiTrinhId = &#63;.
	 *
	 * @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chi tiet yeu cau giai trinh, or <code>null</code> if a matching chi tiet yeu cau giai trinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietYeuCauGiaiTrinh fetchByChiTietGiaiTrinhByYcgtId_Last(
		long yeuCauGiaiTrinhId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByChiTietGiaiTrinhByYcgtId(yeuCauGiaiTrinhId);

		if (count == 0) {
			return null;
		}

		List<ChiTietYeuCauGiaiTrinh> list = findByChiTietGiaiTrinhByYcgtId(yeuCauGiaiTrinhId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the chi tiet yeu cau giai trinhs before and after the current chi tiet yeu cau giai trinh in the ordered set where yeuCauGiaiTrinhId = &#63;.
	 *
	 * @param id the primary key of the current chi tiet yeu cau giai trinh
	 * @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chi tiet yeu cau giai trinh
	 * @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchChiTietYeuCauGiaiTrinhException if a chi tiet yeu cau giai trinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietYeuCauGiaiTrinh[] findByChiTietGiaiTrinhByYcgtId_PrevAndNext(
		long id, long yeuCauGiaiTrinhId, OrderByComparator orderByComparator)
		throws NoSuchChiTietYeuCauGiaiTrinhException, SystemException {
		ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ChiTietYeuCauGiaiTrinh[] array = new ChiTietYeuCauGiaiTrinhImpl[3];

			array[0] = getByChiTietGiaiTrinhByYcgtId_PrevAndNext(session,
					chiTietYeuCauGiaiTrinh, yeuCauGiaiTrinhId,
					orderByComparator, true);

			array[1] = chiTietYeuCauGiaiTrinh;

			array[2] = getByChiTietGiaiTrinhByYcgtId_PrevAndNext(session,
					chiTietYeuCauGiaiTrinh, yeuCauGiaiTrinhId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChiTietYeuCauGiaiTrinh getByChiTietGiaiTrinhByYcgtId_PrevAndNext(
		Session session, ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh,
		long yeuCauGiaiTrinhId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHITIETYEUCAUGIAITRINH_WHERE);

		query.append(_FINDER_COLUMN_CHITIETGIAITRINHBYYCGTID_YEUCAUGIAITRINHID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ChiTietYeuCauGiaiTrinhModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(yeuCauGiaiTrinhId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(chiTietYeuCauGiaiTrinh);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChiTietYeuCauGiaiTrinh> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the chi tiet yeu cau giai trinhs where yeuCauGiaiTrinhId = &#63; from the database.
	 *
	 * @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByChiTietGiaiTrinhByYcgtId(long yeuCauGiaiTrinhId)
		throws SystemException {
		for (ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh : findByChiTietGiaiTrinhByYcgtId(
				yeuCauGiaiTrinhId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(chiTietYeuCauGiaiTrinh);
		}
	}

	/**
	 * Returns the number of chi tiet yeu cau giai trinhs where yeuCauGiaiTrinhId = &#63;.
	 *
	 * @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	 * @return the number of matching chi tiet yeu cau giai trinhs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByChiTietGiaiTrinhByYcgtId(long yeuCauGiaiTrinhId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CHITIETGIAITRINHBYYCGTID;

		Object[] finderArgs = new Object[] { yeuCauGiaiTrinhId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHITIETYEUCAUGIAITRINH_WHERE);

			query.append(_FINDER_COLUMN_CHITIETGIAITRINHBYYCGTID_YEUCAUGIAITRINHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(yeuCauGiaiTrinhId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CHITIETGIAITRINHBYYCGTID_YEUCAUGIAITRINHID_2 =
		"chiTietYeuCauGiaiTrinh.yeuCauGiaiTrinhId = ?";

	public ChiTietYeuCauGiaiTrinhPersistenceImpl() {
		setModelClass(ChiTietYeuCauGiaiTrinh.class);
	}

	/**
	 * Caches the chi tiet yeu cau giai trinh in the entity cache if it is enabled.
	 *
	 * @param chiTietYeuCauGiaiTrinh the chi tiet yeu cau giai trinh
	 */
	@Override
	public void cacheResult(ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh) {
		EntityCacheUtil.putResult(ChiTietYeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietYeuCauGiaiTrinhImpl.class,
			chiTietYeuCauGiaiTrinh.getPrimaryKey(), chiTietYeuCauGiaiTrinh);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH,
			new Object[] {
				chiTietYeuCauGiaiTrinh.getYeuCauGiaiTrinhId(),
				chiTietYeuCauGiaiTrinh.getMaThongTinPhanAnh()
			}, chiTietYeuCauGiaiTrinh);

		chiTietYeuCauGiaiTrinh.resetOriginalValues();
	}

	/**
	 * Caches the chi tiet yeu cau giai trinhs in the entity cache if it is enabled.
	 *
	 * @param chiTietYeuCauGiaiTrinhs the chi tiet yeu cau giai trinhs
	 */
	@Override
	public void cacheResult(
		List<ChiTietYeuCauGiaiTrinh> chiTietYeuCauGiaiTrinhs) {
		for (ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh : chiTietYeuCauGiaiTrinhs) {
			if (EntityCacheUtil.getResult(
						ChiTietYeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
						ChiTietYeuCauGiaiTrinhImpl.class,
						chiTietYeuCauGiaiTrinh.getPrimaryKey()) == null) {
				cacheResult(chiTietYeuCauGiaiTrinh);
			}
			else {
				chiTietYeuCauGiaiTrinh.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all chi tiet yeu cau giai trinhs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ChiTietYeuCauGiaiTrinhImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ChiTietYeuCauGiaiTrinhImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the chi tiet yeu cau giai trinh.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh) {
		EntityCacheUtil.removeResult(ChiTietYeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietYeuCauGiaiTrinhImpl.class,
			chiTietYeuCauGiaiTrinh.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(chiTietYeuCauGiaiTrinh);
	}

	@Override
	public void clearCache(List<ChiTietYeuCauGiaiTrinh> chiTietYeuCauGiaiTrinhs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh : chiTietYeuCauGiaiTrinhs) {
			EntityCacheUtil.removeResult(ChiTietYeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
				ChiTietYeuCauGiaiTrinhImpl.class,
				chiTietYeuCauGiaiTrinh.getPrimaryKey());

			clearUniqueFindersCache(chiTietYeuCauGiaiTrinh);
		}
	}

	protected void cacheUniqueFindersCache(
		ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh) {
		if (chiTietYeuCauGiaiTrinh.isNew()) {
			Object[] args = new Object[] {
					chiTietYeuCauGiaiTrinh.getYeuCauGiaiTrinhId(),
					chiTietYeuCauGiaiTrinh.getMaThongTinPhanAnh()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH,
				args, chiTietYeuCauGiaiTrinh);
		}
		else {
			ChiTietYeuCauGiaiTrinhModelImpl chiTietYeuCauGiaiTrinhModelImpl = (ChiTietYeuCauGiaiTrinhModelImpl)chiTietYeuCauGiaiTrinh;

			if ((chiTietYeuCauGiaiTrinhModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						chiTietYeuCauGiaiTrinh.getYeuCauGiaiTrinhId(),
						chiTietYeuCauGiaiTrinh.getMaThongTinPhanAnh()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH,
					args, chiTietYeuCauGiaiTrinh);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh) {
		ChiTietYeuCauGiaiTrinhModelImpl chiTietYeuCauGiaiTrinhModelImpl = (ChiTietYeuCauGiaiTrinhModelImpl)chiTietYeuCauGiaiTrinh;

		Object[] args = new Object[] {
				chiTietYeuCauGiaiTrinh.getYeuCauGiaiTrinhId(),
				chiTietYeuCauGiaiTrinh.getMaThongTinPhanAnh()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH,
			args);

		if ((chiTietYeuCauGiaiTrinhModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH.getColumnBitmask()) != 0) {
			args = new Object[] {
					chiTietYeuCauGiaiTrinhModelImpl.getOriginalYeuCauGiaiTrinhId(),
					chiTietYeuCauGiaiTrinhModelImpl.getOriginalMaThongTinPhanAnh()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CHITIETGIAITRINHBYYCGTIDANDMATHONGTINPHANANH,
				args);
		}
	}

	/**
	 * Creates a new chi tiet yeu cau giai trinh with the primary key. Does not add the chi tiet yeu cau giai trinh to the database.
	 *
	 * @param id the primary key for the new chi tiet yeu cau giai trinh
	 * @return the new chi tiet yeu cau giai trinh
	 */
	@Override
	public ChiTietYeuCauGiaiTrinh create(long id) {
		ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh = new ChiTietYeuCauGiaiTrinhImpl();

		chiTietYeuCauGiaiTrinh.setNew(true);
		chiTietYeuCauGiaiTrinh.setPrimaryKey(id);

		return chiTietYeuCauGiaiTrinh;
	}

	/**
	 * Removes the chi tiet yeu cau giai trinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chi tiet yeu cau giai trinh
	 * @return the chi tiet yeu cau giai trinh that was removed
	 * @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchChiTietYeuCauGiaiTrinhException if a chi tiet yeu cau giai trinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietYeuCauGiaiTrinh remove(long id)
		throws NoSuchChiTietYeuCauGiaiTrinhException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the chi tiet yeu cau giai trinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the chi tiet yeu cau giai trinh
	 * @return the chi tiet yeu cau giai trinh that was removed
	 * @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchChiTietYeuCauGiaiTrinhException if a chi tiet yeu cau giai trinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietYeuCauGiaiTrinh remove(Serializable primaryKey)
		throws NoSuchChiTietYeuCauGiaiTrinhException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh = (ChiTietYeuCauGiaiTrinh)session.get(ChiTietYeuCauGiaiTrinhImpl.class,
					primaryKey);

			if (chiTietYeuCauGiaiTrinh == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChiTietYeuCauGiaiTrinhException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(chiTietYeuCauGiaiTrinh);
		}
		catch (NoSuchChiTietYeuCauGiaiTrinhException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ChiTietYeuCauGiaiTrinh removeImpl(
		ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh)
		throws SystemException {
		chiTietYeuCauGiaiTrinh = toUnwrappedModel(chiTietYeuCauGiaiTrinh);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(chiTietYeuCauGiaiTrinh)) {
				chiTietYeuCauGiaiTrinh = (ChiTietYeuCauGiaiTrinh)session.get(ChiTietYeuCauGiaiTrinhImpl.class,
						chiTietYeuCauGiaiTrinh.getPrimaryKeyObj());
			}

			if (chiTietYeuCauGiaiTrinh != null) {
				session.delete(chiTietYeuCauGiaiTrinh);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (chiTietYeuCauGiaiTrinh != null) {
			clearCache(chiTietYeuCauGiaiTrinh);
		}

		return chiTietYeuCauGiaiTrinh;
	}

	@Override
	public ChiTietYeuCauGiaiTrinh updateImpl(
		vn.dtt.ns.yeucaugiaitrinh.dao.model.ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh)
		throws SystemException {
		chiTietYeuCauGiaiTrinh = toUnwrappedModel(chiTietYeuCauGiaiTrinh);

		boolean isNew = chiTietYeuCauGiaiTrinh.isNew();

		ChiTietYeuCauGiaiTrinhModelImpl chiTietYeuCauGiaiTrinhModelImpl = (ChiTietYeuCauGiaiTrinhModelImpl)chiTietYeuCauGiaiTrinh;

		Session session = null;

		try {
			session = openSession();

			if (chiTietYeuCauGiaiTrinh.isNew()) {
				session.save(chiTietYeuCauGiaiTrinh);

				chiTietYeuCauGiaiTrinh.setNew(false);
			}
			else {
				session.merge(chiTietYeuCauGiaiTrinh);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ChiTietYeuCauGiaiTrinhModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((chiTietYeuCauGiaiTrinhModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHITIETGIAITRINHBYYCGTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						chiTietYeuCauGiaiTrinhModelImpl.getOriginalYeuCauGiaiTrinhId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHITIETGIAITRINHBYYCGTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHITIETGIAITRINHBYYCGTID,
					args);

				args = new Object[] {
						chiTietYeuCauGiaiTrinhModelImpl.getYeuCauGiaiTrinhId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHITIETGIAITRINHBYYCGTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHITIETGIAITRINHBYYCGTID,
					args);
			}
		}

		EntityCacheUtil.putResult(ChiTietYeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietYeuCauGiaiTrinhImpl.class,
			chiTietYeuCauGiaiTrinh.getPrimaryKey(), chiTietYeuCauGiaiTrinh);

		clearUniqueFindersCache(chiTietYeuCauGiaiTrinh);
		cacheUniqueFindersCache(chiTietYeuCauGiaiTrinh);

		return chiTietYeuCauGiaiTrinh;
	}

	protected ChiTietYeuCauGiaiTrinh toUnwrappedModel(
		ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh) {
		if (chiTietYeuCauGiaiTrinh instanceof ChiTietYeuCauGiaiTrinhImpl) {
			return chiTietYeuCauGiaiTrinh;
		}

		ChiTietYeuCauGiaiTrinhImpl chiTietYeuCauGiaiTrinhImpl = new ChiTietYeuCauGiaiTrinhImpl();

		chiTietYeuCauGiaiTrinhImpl.setNew(chiTietYeuCauGiaiTrinh.isNew());
		chiTietYeuCauGiaiTrinhImpl.setPrimaryKey(chiTietYeuCauGiaiTrinh.getPrimaryKey());

		chiTietYeuCauGiaiTrinhImpl.setId(chiTietYeuCauGiaiTrinh.getId());
		chiTietYeuCauGiaiTrinhImpl.setYeuCauGiaiTrinhId(chiTietYeuCauGiaiTrinh.getYeuCauGiaiTrinhId());
		chiTietYeuCauGiaiTrinhImpl.setMaThongTinPhanAnh(chiTietYeuCauGiaiTrinh.getMaThongTinPhanAnh());
		chiTietYeuCauGiaiTrinhImpl.setSoLuong(chiTietYeuCauGiaiTrinh.getSoLuong());
		chiTietYeuCauGiaiTrinhImpl.setGiaiTrinh(chiTietYeuCauGiaiTrinh.getGiaiTrinh());

		return chiTietYeuCauGiaiTrinhImpl;
	}

	/**
	 * Returns the chi tiet yeu cau giai trinh with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the chi tiet yeu cau giai trinh
	 * @return the chi tiet yeu cau giai trinh
	 * @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchChiTietYeuCauGiaiTrinhException if a chi tiet yeu cau giai trinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietYeuCauGiaiTrinh findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChiTietYeuCauGiaiTrinhException, SystemException {
		ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh = fetchByPrimaryKey(primaryKey);

		if (chiTietYeuCauGiaiTrinh == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchChiTietYeuCauGiaiTrinhException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return chiTietYeuCauGiaiTrinh;
	}

	/**
	 * Returns the chi tiet yeu cau giai trinh with the primary key or throws a {@link vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchChiTietYeuCauGiaiTrinhException} if it could not be found.
	 *
	 * @param id the primary key of the chi tiet yeu cau giai trinh
	 * @return the chi tiet yeu cau giai trinh
	 * @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchChiTietYeuCauGiaiTrinhException if a chi tiet yeu cau giai trinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietYeuCauGiaiTrinh findByPrimaryKey(long id)
		throws NoSuchChiTietYeuCauGiaiTrinhException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the chi tiet yeu cau giai trinh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the chi tiet yeu cau giai trinh
	 * @return the chi tiet yeu cau giai trinh, or <code>null</code> if a chi tiet yeu cau giai trinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietYeuCauGiaiTrinh fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh = (ChiTietYeuCauGiaiTrinh)EntityCacheUtil.getResult(ChiTietYeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
				ChiTietYeuCauGiaiTrinhImpl.class, primaryKey);

		if (chiTietYeuCauGiaiTrinh == _nullChiTietYeuCauGiaiTrinh) {
			return null;
		}

		if (chiTietYeuCauGiaiTrinh == null) {
			Session session = null;

			try {
				session = openSession();

				chiTietYeuCauGiaiTrinh = (ChiTietYeuCauGiaiTrinh)session.get(ChiTietYeuCauGiaiTrinhImpl.class,
						primaryKey);

				if (chiTietYeuCauGiaiTrinh != null) {
					cacheResult(chiTietYeuCauGiaiTrinh);
				}
				else {
					EntityCacheUtil.putResult(ChiTietYeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
						ChiTietYeuCauGiaiTrinhImpl.class, primaryKey,
						_nullChiTietYeuCauGiaiTrinh);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ChiTietYeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
					ChiTietYeuCauGiaiTrinhImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return chiTietYeuCauGiaiTrinh;
	}

	/**
	 * Returns the chi tiet yeu cau giai trinh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the chi tiet yeu cau giai trinh
	 * @return the chi tiet yeu cau giai trinh, or <code>null</code> if a chi tiet yeu cau giai trinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietYeuCauGiaiTrinh fetchByPrimaryKey(long id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the chi tiet yeu cau giai trinhs.
	 *
	 * @return the chi tiet yeu cau giai trinhs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChiTietYeuCauGiaiTrinh> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chi tiet yeu cau giai trinhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.ChiTietYeuCauGiaiTrinhModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chi tiet yeu cau giai trinhs
	 * @param end the upper bound of the range of chi tiet yeu cau giai trinhs (not inclusive)
	 * @return the range of chi tiet yeu cau giai trinhs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChiTietYeuCauGiaiTrinh> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the chi tiet yeu cau giai trinhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.ChiTietYeuCauGiaiTrinhModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chi tiet yeu cau giai trinhs
	 * @param end the upper bound of the range of chi tiet yeu cau giai trinhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chi tiet yeu cau giai trinhs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChiTietYeuCauGiaiTrinh> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ChiTietYeuCauGiaiTrinh> list = (List<ChiTietYeuCauGiaiTrinh>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CHITIETYEUCAUGIAITRINH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CHITIETYEUCAUGIAITRINH;

				if (pagination) {
					sql = sql.concat(ChiTietYeuCauGiaiTrinhModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ChiTietYeuCauGiaiTrinh>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ChiTietYeuCauGiaiTrinh>(list);
				}
				else {
					list = (List<ChiTietYeuCauGiaiTrinh>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the chi tiet yeu cau giai trinhs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh : findAll()) {
			remove(chiTietYeuCauGiaiTrinh);
		}
	}

	/**
	 * Returns the number of chi tiet yeu cau giai trinhs.
	 *
	 * @return the number of chi tiet yeu cau giai trinhs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CHITIETYEUCAUGIAITRINH);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the chi tiet yeu cau giai trinh persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.dtt.ns.yeucaugiaitrinh.dao.model.ChiTietYeuCauGiaiTrinh")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ChiTietYeuCauGiaiTrinh>> listenersList = new ArrayList<ModelListener<ChiTietYeuCauGiaiTrinh>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ChiTietYeuCauGiaiTrinh>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ChiTietYeuCauGiaiTrinhImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CHITIETYEUCAUGIAITRINH = "SELECT chiTietYeuCauGiaiTrinh FROM ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh";
	private static final String _SQL_SELECT_CHITIETYEUCAUGIAITRINH_WHERE = "SELECT chiTietYeuCauGiaiTrinh FROM ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh WHERE ";
	private static final String _SQL_COUNT_CHITIETYEUCAUGIAITRINH = "SELECT COUNT(chiTietYeuCauGiaiTrinh) FROM ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh";
	private static final String _SQL_COUNT_CHITIETYEUCAUGIAITRINH_WHERE = "SELECT COUNT(chiTietYeuCauGiaiTrinh) FROM ChiTietYeuCauGiaiTrinh chiTietYeuCauGiaiTrinh WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "chiTietYeuCauGiaiTrinh.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ChiTietYeuCauGiaiTrinh exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ChiTietYeuCauGiaiTrinh exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ChiTietYeuCauGiaiTrinhPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"yeuCauGiaiTrinhId", "maThongTinPhanAnh", "soLuong", "giaiTrinh"
			});
	private static ChiTietYeuCauGiaiTrinh _nullChiTietYeuCauGiaiTrinh = new ChiTietYeuCauGiaiTrinhImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ChiTietYeuCauGiaiTrinh> toCacheModel() {
				return _nullChiTietYeuCauGiaiTrinhCacheModel;
			}
		};

	private static CacheModel<ChiTietYeuCauGiaiTrinh> _nullChiTietYeuCauGiaiTrinhCacheModel =
		new CacheModel<ChiTietYeuCauGiaiTrinh>() {
			@Override
			public ChiTietYeuCauGiaiTrinh toEntityModel() {
				return _nullChiTietYeuCauGiaiTrinh;
			}
		};
}