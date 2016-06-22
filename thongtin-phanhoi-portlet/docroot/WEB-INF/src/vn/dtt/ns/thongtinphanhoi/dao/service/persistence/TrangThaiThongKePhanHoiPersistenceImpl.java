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

import vn.dtt.ns.thongtinphanhoi.dao.NoSuchTrangThaiThongKePhanHoiException;
import vn.dtt.ns.thongtinphanhoi.dao.model.TrangThaiThongKePhanHoi;
import vn.dtt.ns.thongtinphanhoi.dao.model.impl.TrangThaiThongKePhanHoiImpl;
import vn.dtt.ns.thongtinphanhoi.dao.model.impl.TrangThaiThongKePhanHoiModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the trang thai thong ke phan hoi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tubq
 * @see TrangThaiThongKePhanHoiPersistence
 * @see TrangThaiThongKePhanHoiUtil
 * @generated
 */
public class TrangThaiThongKePhanHoiPersistenceImpl extends BasePersistenceImpl<TrangThaiThongKePhanHoi>
	implements TrangThaiThongKePhanHoiPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TrangThaiThongKePhanHoiUtil} to access the trang thai thong ke phan hoi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TrangThaiThongKePhanHoiImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TrangThaiThongKePhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiThongKePhanHoiModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiThongKePhanHoiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TrangThaiThongKePhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiThongKePhanHoiModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiThongKePhanHoiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TrangThaiThongKePhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiThongKePhanHoiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_MATINHTHANGNAMCHUYENSANGMB =
		new FinderPath(TrangThaiThongKePhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiThongKePhanHoiModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiThongKePhanHoiImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBymaTinhThangNamChuyenSangMB",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName()
			},
			TrangThaiThongKePhanHoiModelImpl.MATINH_COLUMN_BITMASK |
			TrangThaiThongKePhanHoiModelImpl.THANGNAM_COLUMN_BITMASK |
			TrangThaiThongKePhanHoiModelImpl.DACHUYENSANGMINHBACH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MATINHTHANGNAMCHUYENSANGMB =
		new FinderPath(TrangThaiThongKePhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiThongKePhanHoiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBymaTinhThangNamChuyenSangMB",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns the trang thai thong ke phan hoi where maTinh = &#63; and thangNam = &#63; and daChuyenSangMinhBach = &#63; or throws a {@link vn.dtt.ns.thongtinphanhoi.dao.NoSuchTrangThaiThongKePhanHoiException} if it could not be found.
	 *
	 * @param maTinh the ma tinh
	 * @param thangNam the thang nam
	 * @param daChuyenSangMinhBach the da chuyen sang minh bach
	 * @return the matching trang thai thong ke phan hoi
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchTrangThaiThongKePhanHoiException if a matching trang thai thong ke phan hoi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi findBymaTinhThangNamChuyenSangMB(
		String maTinh, String thangNam, int daChuyenSangMinhBach)
		throws NoSuchTrangThaiThongKePhanHoiException, SystemException {
		TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = fetchBymaTinhThangNamChuyenSangMB(maTinh,
				thangNam, daChuyenSangMinhBach);

		if (trangThaiThongKePhanHoi == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("maTinh=");
			msg.append(maTinh);

			msg.append(", thangNam=");
			msg.append(thangNam);

			msg.append(", daChuyenSangMinhBach=");
			msg.append(daChuyenSangMinhBach);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTrangThaiThongKePhanHoiException(msg.toString());
		}

		return trangThaiThongKePhanHoi;
	}

	/**
	 * Returns the trang thai thong ke phan hoi where maTinh = &#63; and thangNam = &#63; and daChuyenSangMinhBach = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param maTinh the ma tinh
	 * @param thangNam the thang nam
	 * @param daChuyenSangMinhBach the da chuyen sang minh bach
	 * @return the matching trang thai thong ke phan hoi, or <code>null</code> if a matching trang thai thong ke phan hoi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi fetchBymaTinhThangNamChuyenSangMB(
		String maTinh, String thangNam, int daChuyenSangMinhBach)
		throws SystemException {
		return fetchBymaTinhThangNamChuyenSangMB(maTinh, thangNam,
			daChuyenSangMinhBach, true);
	}

	/**
	 * Returns the trang thai thong ke phan hoi where maTinh = &#63; and thangNam = &#63; and daChuyenSangMinhBach = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param maTinh the ma tinh
	 * @param thangNam the thang nam
	 * @param daChuyenSangMinhBach the da chuyen sang minh bach
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching trang thai thong ke phan hoi, or <code>null</code> if a matching trang thai thong ke phan hoi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi fetchBymaTinhThangNamChuyenSangMB(
		String maTinh, String thangNam, int daChuyenSangMinhBach,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				maTinh, thangNam, daChuyenSangMinhBach
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MATINHTHANGNAMCHUYENSANGMB,
					finderArgs, this);
		}

		if (result instanceof TrangThaiThongKePhanHoi) {
			TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = (TrangThaiThongKePhanHoi)result;

			if (!Validator.equals(maTinh, trangThaiThongKePhanHoi.getMaTinh()) ||
					!Validator.equals(thangNam,
						trangThaiThongKePhanHoi.getThangNam()) ||
					(daChuyenSangMinhBach != trangThaiThongKePhanHoi.getDaChuyenSangMinhBach())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_TRANGTHAITHONGKEPHANHOI_WHERE);

			boolean bindMaTinh = false;

			if (maTinh == null) {
				query.append(_FINDER_COLUMN_MATINHTHANGNAMCHUYENSANGMB_MATINH_1);
			}
			else if (maTinh.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MATINHTHANGNAMCHUYENSANGMB_MATINH_3);
			}
			else {
				bindMaTinh = true;

				query.append(_FINDER_COLUMN_MATINHTHANGNAMCHUYENSANGMB_MATINH_2);
			}

			boolean bindThangNam = false;

			if (thangNam == null) {
				query.append(_FINDER_COLUMN_MATINHTHANGNAMCHUYENSANGMB_THANGNAM_1);
			}
			else if (thangNam.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MATINHTHANGNAMCHUYENSANGMB_THANGNAM_3);
			}
			else {
				bindThangNam = true;

				query.append(_FINDER_COLUMN_MATINHTHANGNAMCHUYENSANGMB_THANGNAM_2);
			}

			query.append(_FINDER_COLUMN_MATINHTHANGNAMCHUYENSANGMB_DACHUYENSANGMINHBACH_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMaTinh) {
					qPos.add(maTinh);
				}

				if (bindThangNam) {
					qPos.add(thangNam);
				}

				qPos.add(daChuyenSangMinhBach);

				List<TrangThaiThongKePhanHoi> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MATINHTHANGNAMCHUYENSANGMB,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TrangThaiThongKePhanHoiPersistenceImpl.fetchBymaTinhThangNamChuyenSangMB(String, String, int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = list.get(0);

					result = trangThaiThongKePhanHoi;

					cacheResult(trangThaiThongKePhanHoi);

					if ((trangThaiThongKePhanHoi.getMaTinh() == null) ||
							!trangThaiThongKePhanHoi.getMaTinh().equals(maTinh) ||
							(trangThaiThongKePhanHoi.getThangNam() == null) ||
							!trangThaiThongKePhanHoi.getThangNam()
														.equals(thangNam) ||
							(trangThaiThongKePhanHoi.getDaChuyenSangMinhBach() != daChuyenSangMinhBach)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MATINHTHANGNAMCHUYENSANGMB,
							finderArgs, trangThaiThongKePhanHoi);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MATINHTHANGNAMCHUYENSANGMB,
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
			return (TrangThaiThongKePhanHoi)result;
		}
	}

	/**
	 * Removes the trang thai thong ke phan hoi where maTinh = &#63; and thangNam = &#63; and daChuyenSangMinhBach = &#63; from the database.
	 *
	 * @param maTinh the ma tinh
	 * @param thangNam the thang nam
	 * @param daChuyenSangMinhBach the da chuyen sang minh bach
	 * @return the trang thai thong ke phan hoi that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi removeBymaTinhThangNamChuyenSangMB(
		String maTinh, String thangNam, int daChuyenSangMinhBach)
		throws NoSuchTrangThaiThongKePhanHoiException, SystemException {
		TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = findBymaTinhThangNamChuyenSangMB(maTinh,
				thangNam, daChuyenSangMinhBach);

		return remove(trangThaiThongKePhanHoi);
	}

	/**
	 * Returns the number of trang thai thong ke phan hois where maTinh = &#63; and thangNam = &#63; and daChuyenSangMinhBach = &#63;.
	 *
	 * @param maTinh the ma tinh
	 * @param thangNam the thang nam
	 * @param daChuyenSangMinhBach the da chuyen sang minh bach
	 * @return the number of matching trang thai thong ke phan hois
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBymaTinhThangNamChuyenSangMB(String maTinh,
		String thangNam, int daChuyenSangMinhBach) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MATINHTHANGNAMCHUYENSANGMB;

		Object[] finderArgs = new Object[] {
				maTinh, thangNam, daChuyenSangMinhBach
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TRANGTHAITHONGKEPHANHOI_WHERE);

			boolean bindMaTinh = false;

			if (maTinh == null) {
				query.append(_FINDER_COLUMN_MATINHTHANGNAMCHUYENSANGMB_MATINH_1);
			}
			else if (maTinh.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MATINHTHANGNAMCHUYENSANGMB_MATINH_3);
			}
			else {
				bindMaTinh = true;

				query.append(_FINDER_COLUMN_MATINHTHANGNAMCHUYENSANGMB_MATINH_2);
			}

			boolean bindThangNam = false;

			if (thangNam == null) {
				query.append(_FINDER_COLUMN_MATINHTHANGNAMCHUYENSANGMB_THANGNAM_1);
			}
			else if (thangNam.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MATINHTHANGNAMCHUYENSANGMB_THANGNAM_3);
			}
			else {
				bindThangNam = true;

				query.append(_FINDER_COLUMN_MATINHTHANGNAMCHUYENSANGMB_THANGNAM_2);
			}

			query.append(_FINDER_COLUMN_MATINHTHANGNAMCHUYENSANGMB_DACHUYENSANGMINHBACH_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMaTinh) {
					qPos.add(maTinh);
				}

				if (bindThangNam) {
					qPos.add(thangNam);
				}

				qPos.add(daChuyenSangMinhBach);

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

	private static final String _FINDER_COLUMN_MATINHTHANGNAMCHUYENSANGMB_MATINH_1 =
		"trangThaiThongKePhanHoi.maTinh IS NULL AND ";
	private static final String _FINDER_COLUMN_MATINHTHANGNAMCHUYENSANGMB_MATINH_2 =
		"trangThaiThongKePhanHoi.maTinh = ? AND ";
	private static final String _FINDER_COLUMN_MATINHTHANGNAMCHUYENSANGMB_MATINH_3 =
		"(trangThaiThongKePhanHoi.maTinh IS NULL OR trangThaiThongKePhanHoi.maTinh = '') AND ";
	private static final String _FINDER_COLUMN_MATINHTHANGNAMCHUYENSANGMB_THANGNAM_1 =
		"trangThaiThongKePhanHoi.thangNam IS NULL AND ";
	private static final String _FINDER_COLUMN_MATINHTHANGNAMCHUYENSANGMB_THANGNAM_2 =
		"trangThaiThongKePhanHoi.thangNam = ? AND ";
	private static final String _FINDER_COLUMN_MATINHTHANGNAMCHUYENSANGMB_THANGNAM_3 =
		"(trangThaiThongKePhanHoi.thangNam IS NULL OR trangThaiThongKePhanHoi.thangNam = '') AND ";
	private static final String _FINDER_COLUMN_MATINHTHANGNAMCHUYENSANGMB_DACHUYENSANGMINHBACH_2 =
		"trangThaiThongKePhanHoi.daChuyenSangMinhBach = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_ARTICLEID = new FinderPath(TrangThaiThongKePhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiThongKePhanHoiModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiThongKePhanHoiImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByarticleId", new String[] { Integer.class.getName() },
			TrangThaiThongKePhanHoiModelImpl.ARTICLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLEID = new FinderPath(TrangThaiThongKePhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiThongKePhanHoiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByarticleId",
			new String[] { Integer.class.getName() });

	/**
	 * Returns the trang thai thong ke phan hoi where articleId = &#63; or throws a {@link vn.dtt.ns.thongtinphanhoi.dao.NoSuchTrangThaiThongKePhanHoiException} if it could not be found.
	 *
	 * @param articleId the article ID
	 * @return the matching trang thai thong ke phan hoi
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchTrangThaiThongKePhanHoiException if a matching trang thai thong ke phan hoi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi findByarticleId(int articleId)
		throws NoSuchTrangThaiThongKePhanHoiException, SystemException {
		TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = fetchByarticleId(articleId);

		if (trangThaiThongKePhanHoi == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("articleId=");
			msg.append(articleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTrangThaiThongKePhanHoiException(msg.toString());
		}

		return trangThaiThongKePhanHoi;
	}

	/**
	 * Returns the trang thai thong ke phan hoi where articleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param articleId the article ID
	 * @return the matching trang thai thong ke phan hoi, or <code>null</code> if a matching trang thai thong ke phan hoi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi fetchByarticleId(int articleId)
		throws SystemException {
		return fetchByarticleId(articleId, true);
	}

	/**
	 * Returns the trang thai thong ke phan hoi where articleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param articleId the article ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching trang thai thong ke phan hoi, or <code>null</code> if a matching trang thai thong ke phan hoi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi fetchByarticleId(int articleId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { articleId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ARTICLEID,
					finderArgs, this);
		}

		if (result instanceof TrangThaiThongKePhanHoi) {
			TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = (TrangThaiThongKePhanHoi)result;

			if ((articleId != trangThaiThongKePhanHoi.getArticleId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TRANGTHAITHONGKEPHANHOI_WHERE);

			query.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleId);

				List<TrangThaiThongKePhanHoi> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARTICLEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TrangThaiThongKePhanHoiPersistenceImpl.fetchByarticleId(int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = list.get(0);

					result = trangThaiThongKePhanHoi;

					cacheResult(trangThaiThongKePhanHoi);

					if ((trangThaiThongKePhanHoi.getArticleId() != articleId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARTICLEID,
							finderArgs, trangThaiThongKePhanHoi);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ARTICLEID,
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
			return (TrangThaiThongKePhanHoi)result;
		}
	}

	/**
	 * Removes the trang thai thong ke phan hoi where articleId = &#63; from the database.
	 *
	 * @param articleId the article ID
	 * @return the trang thai thong ke phan hoi that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi removeByarticleId(int articleId)
		throws NoSuchTrangThaiThongKePhanHoiException, SystemException {
		TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = findByarticleId(articleId);

		return remove(trangThaiThongKePhanHoi);
	}

	/**
	 * Returns the number of trang thai thong ke phan hois where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the number of matching trang thai thong ke phan hois
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByarticleId(int articleId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ARTICLEID;

		Object[] finderArgs = new Object[] { articleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRANGTHAITHONGKEPHANHOI_WHERE);

			query.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleId);

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

	private static final String _FINDER_COLUMN_ARTICLEID_ARTICLEID_2 = "trangThaiThongKePhanHoi.articleId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_ARTICLEIDANDDACHUYENSANGMINHBACH =
		new FinderPath(TrangThaiThongKePhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiThongKePhanHoiModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiThongKePhanHoiImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByarticleIdAndDaChuyenSangMinhBach",
			new String[] { Integer.class.getName(), Integer.class.getName() },
			TrangThaiThongKePhanHoiModelImpl.ARTICLEID_COLUMN_BITMASK |
			TrangThaiThongKePhanHoiModelImpl.DACHUYENSANGMINHBACH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLEIDANDDACHUYENSANGMINHBACH =
		new FinderPath(TrangThaiThongKePhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiThongKePhanHoiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByarticleIdAndDaChuyenSangMinhBach",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	/**
	 * Returns the trang thai thong ke phan hoi where articleId = &#63; and daChuyenSangMinhBach = &#63; or throws a {@link vn.dtt.ns.thongtinphanhoi.dao.NoSuchTrangThaiThongKePhanHoiException} if it could not be found.
	 *
	 * @param articleId the article ID
	 * @param daChuyenSangMinhBach the da chuyen sang minh bach
	 * @return the matching trang thai thong ke phan hoi
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchTrangThaiThongKePhanHoiException if a matching trang thai thong ke phan hoi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi findByarticleIdAndDaChuyenSangMinhBach(
		int articleId, int daChuyenSangMinhBach)
		throws NoSuchTrangThaiThongKePhanHoiException, SystemException {
		TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = fetchByarticleIdAndDaChuyenSangMinhBach(articleId,
				daChuyenSangMinhBach);

		if (trangThaiThongKePhanHoi == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("articleId=");
			msg.append(articleId);

			msg.append(", daChuyenSangMinhBach=");
			msg.append(daChuyenSangMinhBach);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTrangThaiThongKePhanHoiException(msg.toString());
		}

		return trangThaiThongKePhanHoi;
	}

	/**
	 * Returns the trang thai thong ke phan hoi where articleId = &#63; and daChuyenSangMinhBach = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param articleId the article ID
	 * @param daChuyenSangMinhBach the da chuyen sang minh bach
	 * @return the matching trang thai thong ke phan hoi, or <code>null</code> if a matching trang thai thong ke phan hoi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi fetchByarticleIdAndDaChuyenSangMinhBach(
		int articleId, int daChuyenSangMinhBach) throws SystemException {
		return fetchByarticleIdAndDaChuyenSangMinhBach(articleId,
			daChuyenSangMinhBach, true);
	}

	/**
	 * Returns the trang thai thong ke phan hoi where articleId = &#63; and daChuyenSangMinhBach = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param articleId the article ID
	 * @param daChuyenSangMinhBach the da chuyen sang minh bach
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching trang thai thong ke phan hoi, or <code>null</code> if a matching trang thai thong ke phan hoi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi fetchByarticleIdAndDaChuyenSangMinhBach(
		int articleId, int daChuyenSangMinhBach, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { articleId, daChuyenSangMinhBach };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ARTICLEIDANDDACHUYENSANGMINHBACH,
					finderArgs, this);
		}

		if (result instanceof TrangThaiThongKePhanHoi) {
			TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = (TrangThaiThongKePhanHoi)result;

			if ((articleId != trangThaiThongKePhanHoi.getArticleId()) ||
					(daChuyenSangMinhBach != trangThaiThongKePhanHoi.getDaChuyenSangMinhBach())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TRANGTHAITHONGKEPHANHOI_WHERE);

			query.append(_FINDER_COLUMN_ARTICLEIDANDDACHUYENSANGMINHBACH_ARTICLEID_2);

			query.append(_FINDER_COLUMN_ARTICLEIDANDDACHUYENSANGMINHBACH_DACHUYENSANGMINHBACH_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleId);

				qPos.add(daChuyenSangMinhBach);

				List<TrangThaiThongKePhanHoi> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARTICLEIDANDDACHUYENSANGMINHBACH,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TrangThaiThongKePhanHoiPersistenceImpl.fetchByarticleIdAndDaChuyenSangMinhBach(int, int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = list.get(0);

					result = trangThaiThongKePhanHoi;

					cacheResult(trangThaiThongKePhanHoi);

					if ((trangThaiThongKePhanHoi.getArticleId() != articleId) ||
							(trangThaiThongKePhanHoi.getDaChuyenSangMinhBach() != daChuyenSangMinhBach)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARTICLEIDANDDACHUYENSANGMINHBACH,
							finderArgs, trangThaiThongKePhanHoi);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ARTICLEIDANDDACHUYENSANGMINHBACH,
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
			return (TrangThaiThongKePhanHoi)result;
		}
	}

	/**
	 * Removes the trang thai thong ke phan hoi where articleId = &#63; and daChuyenSangMinhBach = &#63; from the database.
	 *
	 * @param articleId the article ID
	 * @param daChuyenSangMinhBach the da chuyen sang minh bach
	 * @return the trang thai thong ke phan hoi that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi removeByarticleIdAndDaChuyenSangMinhBach(
		int articleId, int daChuyenSangMinhBach)
		throws NoSuchTrangThaiThongKePhanHoiException, SystemException {
		TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = findByarticleIdAndDaChuyenSangMinhBach(articleId,
				daChuyenSangMinhBach);

		return remove(trangThaiThongKePhanHoi);
	}

	/**
	 * Returns the number of trang thai thong ke phan hois where articleId = &#63; and daChuyenSangMinhBach = &#63;.
	 *
	 * @param articleId the article ID
	 * @param daChuyenSangMinhBach the da chuyen sang minh bach
	 * @return the number of matching trang thai thong ke phan hois
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByarticleIdAndDaChuyenSangMinhBach(int articleId,
		int daChuyenSangMinhBach) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ARTICLEIDANDDACHUYENSANGMINHBACH;

		Object[] finderArgs = new Object[] { articleId, daChuyenSangMinhBach };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TRANGTHAITHONGKEPHANHOI_WHERE);

			query.append(_FINDER_COLUMN_ARTICLEIDANDDACHUYENSANGMINHBACH_ARTICLEID_2);

			query.append(_FINDER_COLUMN_ARTICLEIDANDDACHUYENSANGMINHBACH_DACHUYENSANGMINHBACH_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleId);

				qPos.add(daChuyenSangMinhBach);

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

	private static final String _FINDER_COLUMN_ARTICLEIDANDDACHUYENSANGMINHBACH_ARTICLEID_2 =
		"trangThaiThongKePhanHoi.articleId = ? AND ";
	private static final String _FINDER_COLUMN_ARTICLEIDANDDACHUYENSANGMINHBACH_DACHUYENSANGMINHBACH_2 =
		"trangThaiThongKePhanHoi.daChuyenSangMinhBach = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MATINH = new FinderPath(TrangThaiThongKePhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiThongKePhanHoiModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiThongKePhanHoiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymaTinh",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATINH =
		new FinderPath(TrangThaiThongKePhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiThongKePhanHoiModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiThongKePhanHoiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBymaTinh",
			new String[] { String.class.getName() },
			TrangThaiThongKePhanHoiModelImpl.MATINH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MATINH = new FinderPath(TrangThaiThongKePhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiThongKePhanHoiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymaTinh",
			new String[] { String.class.getName() });

	/**
	 * Returns all the trang thai thong ke phan hois where maTinh = &#63;.
	 *
	 * @param maTinh the ma tinh
	 * @return the matching trang thai thong ke phan hois
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrangThaiThongKePhanHoi> findBymaTinh(String maTinh)
		throws SystemException {
		return findBymaTinh(maTinh, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trang thai thong ke phan hois where maTinh = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.thongtinphanhoi.dao.model.impl.TrangThaiThongKePhanHoiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maTinh the ma tinh
	 * @param start the lower bound of the range of trang thai thong ke phan hois
	 * @param end the upper bound of the range of trang thai thong ke phan hois (not inclusive)
	 * @return the range of matching trang thai thong ke phan hois
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrangThaiThongKePhanHoi> findBymaTinh(String maTinh, int start,
		int end) throws SystemException {
		return findBymaTinh(maTinh, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trang thai thong ke phan hois where maTinh = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.thongtinphanhoi.dao.model.impl.TrangThaiThongKePhanHoiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maTinh the ma tinh
	 * @param start the lower bound of the range of trang thai thong ke phan hois
	 * @param end the upper bound of the range of trang thai thong ke phan hois (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trang thai thong ke phan hois
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrangThaiThongKePhanHoi> findBymaTinh(String maTinh, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATINH;
			finderArgs = new Object[] { maTinh };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MATINH;
			finderArgs = new Object[] { maTinh, start, end, orderByComparator };
		}

		List<TrangThaiThongKePhanHoi> list = (List<TrangThaiThongKePhanHoi>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TrangThaiThongKePhanHoi trangThaiThongKePhanHoi : list) {
				if (!Validator.equals(maTinh,
							trangThaiThongKePhanHoi.getMaTinh())) {
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

			query.append(_SQL_SELECT_TRANGTHAITHONGKEPHANHOI_WHERE);

			boolean bindMaTinh = false;

			if (maTinh == null) {
				query.append(_FINDER_COLUMN_MATINH_MATINH_1);
			}
			else if (maTinh.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MATINH_MATINH_3);
			}
			else {
				bindMaTinh = true;

				query.append(_FINDER_COLUMN_MATINH_MATINH_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TrangThaiThongKePhanHoiModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMaTinh) {
					qPos.add(maTinh);
				}

				if (!pagination) {
					list = (List<TrangThaiThongKePhanHoi>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TrangThaiThongKePhanHoi>(list);
				}
				else {
					list = (List<TrangThaiThongKePhanHoi>)QueryUtil.list(q,
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
	 * Returns the first trang thai thong ke phan hoi in the ordered set where maTinh = &#63;.
	 *
	 * @param maTinh the ma tinh
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trang thai thong ke phan hoi
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchTrangThaiThongKePhanHoiException if a matching trang thai thong ke phan hoi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi findBymaTinh_First(String maTinh,
		OrderByComparator orderByComparator)
		throws NoSuchTrangThaiThongKePhanHoiException, SystemException {
		TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = fetchBymaTinh_First(maTinh,
				orderByComparator);

		if (trangThaiThongKePhanHoi != null) {
			return trangThaiThongKePhanHoi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("maTinh=");
		msg.append(maTinh);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrangThaiThongKePhanHoiException(msg.toString());
	}

	/**
	 * Returns the first trang thai thong ke phan hoi in the ordered set where maTinh = &#63;.
	 *
	 * @param maTinh the ma tinh
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trang thai thong ke phan hoi, or <code>null</code> if a matching trang thai thong ke phan hoi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi fetchBymaTinh_First(String maTinh,
		OrderByComparator orderByComparator) throws SystemException {
		List<TrangThaiThongKePhanHoi> list = findBymaTinh(maTinh, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trang thai thong ke phan hoi in the ordered set where maTinh = &#63;.
	 *
	 * @param maTinh the ma tinh
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trang thai thong ke phan hoi
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchTrangThaiThongKePhanHoiException if a matching trang thai thong ke phan hoi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi findBymaTinh_Last(String maTinh,
		OrderByComparator orderByComparator)
		throws NoSuchTrangThaiThongKePhanHoiException, SystemException {
		TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = fetchBymaTinh_Last(maTinh,
				orderByComparator);

		if (trangThaiThongKePhanHoi != null) {
			return trangThaiThongKePhanHoi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("maTinh=");
		msg.append(maTinh);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrangThaiThongKePhanHoiException(msg.toString());
	}

	/**
	 * Returns the last trang thai thong ke phan hoi in the ordered set where maTinh = &#63;.
	 *
	 * @param maTinh the ma tinh
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trang thai thong ke phan hoi, or <code>null</code> if a matching trang thai thong ke phan hoi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi fetchBymaTinh_Last(String maTinh,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBymaTinh(maTinh);

		if (count == 0) {
			return null;
		}

		List<TrangThaiThongKePhanHoi> list = findBymaTinh(maTinh, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trang thai thong ke phan hois before and after the current trang thai thong ke phan hoi in the ordered set where maTinh = &#63;.
	 *
	 * @param id the primary key of the current trang thai thong ke phan hoi
	 * @param maTinh the ma tinh
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trang thai thong ke phan hoi
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchTrangThaiThongKePhanHoiException if a trang thai thong ke phan hoi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi[] findBymaTinh_PrevAndNext(long id,
		String maTinh, OrderByComparator orderByComparator)
		throws NoSuchTrangThaiThongKePhanHoiException, SystemException {
		TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TrangThaiThongKePhanHoi[] array = new TrangThaiThongKePhanHoiImpl[3];

			array[0] = getBymaTinh_PrevAndNext(session,
					trangThaiThongKePhanHoi, maTinh, orderByComparator, true);

			array[1] = trangThaiThongKePhanHoi;

			array[2] = getBymaTinh_PrevAndNext(session,
					trangThaiThongKePhanHoi, maTinh, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TrangThaiThongKePhanHoi getBymaTinh_PrevAndNext(Session session,
		TrangThaiThongKePhanHoi trangThaiThongKePhanHoi, String maTinh,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRANGTHAITHONGKEPHANHOI_WHERE);

		boolean bindMaTinh = false;

		if (maTinh == null) {
			query.append(_FINDER_COLUMN_MATINH_MATINH_1);
		}
		else if (maTinh.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MATINH_MATINH_3);
		}
		else {
			bindMaTinh = true;

			query.append(_FINDER_COLUMN_MATINH_MATINH_2);
		}

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
			query.append(TrangThaiThongKePhanHoiModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindMaTinh) {
			qPos.add(maTinh);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(trangThaiThongKePhanHoi);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TrangThaiThongKePhanHoi> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trang thai thong ke phan hois where maTinh = &#63; from the database.
	 *
	 * @param maTinh the ma tinh
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBymaTinh(String maTinh) throws SystemException {
		for (TrangThaiThongKePhanHoi trangThaiThongKePhanHoi : findBymaTinh(
				maTinh, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(trangThaiThongKePhanHoi);
		}
	}

	/**
	 * Returns the number of trang thai thong ke phan hois where maTinh = &#63;.
	 *
	 * @param maTinh the ma tinh
	 * @return the number of matching trang thai thong ke phan hois
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBymaTinh(String maTinh) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MATINH;

		Object[] finderArgs = new Object[] { maTinh };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRANGTHAITHONGKEPHANHOI_WHERE);

			boolean bindMaTinh = false;

			if (maTinh == null) {
				query.append(_FINDER_COLUMN_MATINH_MATINH_1);
			}
			else if (maTinh.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MATINH_MATINH_3);
			}
			else {
				bindMaTinh = true;

				query.append(_FINDER_COLUMN_MATINH_MATINH_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMaTinh) {
					qPos.add(maTinh);
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

	private static final String _FINDER_COLUMN_MATINH_MATINH_1 = "trangThaiThongKePhanHoi.maTinh IS NULL";
	private static final String _FINDER_COLUMN_MATINH_MATINH_2 = "trangThaiThongKePhanHoi.maTinh = ?";
	private static final String _FINDER_COLUMN_MATINH_MATINH_3 = "(trangThaiThongKePhanHoi.maTinh IS NULL OR trangThaiThongKePhanHoi.maTinh = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THANGNAM = new FinderPath(TrangThaiThongKePhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiThongKePhanHoiModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiThongKePhanHoiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBythangNam",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THANGNAM =
		new FinderPath(TrangThaiThongKePhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiThongKePhanHoiModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiThongKePhanHoiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBythangNam",
			new String[] { String.class.getName() },
			TrangThaiThongKePhanHoiModelImpl.THANGNAM_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_THANGNAM = new FinderPath(TrangThaiThongKePhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiThongKePhanHoiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBythangNam",
			new String[] { String.class.getName() });

	/**
	 * Returns all the trang thai thong ke phan hois where thangNam = &#63;.
	 *
	 * @param thangNam the thang nam
	 * @return the matching trang thai thong ke phan hois
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrangThaiThongKePhanHoi> findBythangNam(String thangNam)
		throws SystemException {
		return findBythangNam(thangNam, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the trang thai thong ke phan hois where thangNam = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.thongtinphanhoi.dao.model.impl.TrangThaiThongKePhanHoiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param thangNam the thang nam
	 * @param start the lower bound of the range of trang thai thong ke phan hois
	 * @param end the upper bound of the range of trang thai thong ke phan hois (not inclusive)
	 * @return the range of matching trang thai thong ke phan hois
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrangThaiThongKePhanHoi> findBythangNam(String thangNam,
		int start, int end) throws SystemException {
		return findBythangNam(thangNam, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trang thai thong ke phan hois where thangNam = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.thongtinphanhoi.dao.model.impl.TrangThaiThongKePhanHoiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param thangNam the thang nam
	 * @param start the lower bound of the range of trang thai thong ke phan hois
	 * @param end the upper bound of the range of trang thai thong ke phan hois (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trang thai thong ke phan hois
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrangThaiThongKePhanHoi> findBythangNam(String thangNam,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THANGNAM;
			finderArgs = new Object[] { thangNam };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_THANGNAM;
			finderArgs = new Object[] { thangNam, start, end, orderByComparator };
		}

		List<TrangThaiThongKePhanHoi> list = (List<TrangThaiThongKePhanHoi>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TrangThaiThongKePhanHoi trangThaiThongKePhanHoi : list) {
				if (!Validator.equals(thangNam,
							trangThaiThongKePhanHoi.getThangNam())) {
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

			query.append(_SQL_SELECT_TRANGTHAITHONGKEPHANHOI_WHERE);

			boolean bindThangNam = false;

			if (thangNam == null) {
				query.append(_FINDER_COLUMN_THANGNAM_THANGNAM_1);
			}
			else if (thangNam.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_THANGNAM_THANGNAM_3);
			}
			else {
				bindThangNam = true;

				query.append(_FINDER_COLUMN_THANGNAM_THANGNAM_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TrangThaiThongKePhanHoiModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindThangNam) {
					qPos.add(thangNam);
				}

				if (!pagination) {
					list = (List<TrangThaiThongKePhanHoi>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TrangThaiThongKePhanHoi>(list);
				}
				else {
					list = (List<TrangThaiThongKePhanHoi>)QueryUtil.list(q,
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
	 * Returns the first trang thai thong ke phan hoi in the ordered set where thangNam = &#63;.
	 *
	 * @param thangNam the thang nam
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trang thai thong ke phan hoi
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchTrangThaiThongKePhanHoiException if a matching trang thai thong ke phan hoi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi findBythangNam_First(String thangNam,
		OrderByComparator orderByComparator)
		throws NoSuchTrangThaiThongKePhanHoiException, SystemException {
		TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = fetchBythangNam_First(thangNam,
				orderByComparator);

		if (trangThaiThongKePhanHoi != null) {
			return trangThaiThongKePhanHoi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("thangNam=");
		msg.append(thangNam);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrangThaiThongKePhanHoiException(msg.toString());
	}

	/**
	 * Returns the first trang thai thong ke phan hoi in the ordered set where thangNam = &#63;.
	 *
	 * @param thangNam the thang nam
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trang thai thong ke phan hoi, or <code>null</code> if a matching trang thai thong ke phan hoi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi fetchBythangNam_First(String thangNam,
		OrderByComparator orderByComparator) throws SystemException {
		List<TrangThaiThongKePhanHoi> list = findBythangNam(thangNam, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trang thai thong ke phan hoi in the ordered set where thangNam = &#63;.
	 *
	 * @param thangNam the thang nam
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trang thai thong ke phan hoi
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchTrangThaiThongKePhanHoiException if a matching trang thai thong ke phan hoi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi findBythangNam_Last(String thangNam,
		OrderByComparator orderByComparator)
		throws NoSuchTrangThaiThongKePhanHoiException, SystemException {
		TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = fetchBythangNam_Last(thangNam,
				orderByComparator);

		if (trangThaiThongKePhanHoi != null) {
			return trangThaiThongKePhanHoi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("thangNam=");
		msg.append(thangNam);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrangThaiThongKePhanHoiException(msg.toString());
	}

	/**
	 * Returns the last trang thai thong ke phan hoi in the ordered set where thangNam = &#63;.
	 *
	 * @param thangNam the thang nam
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trang thai thong ke phan hoi, or <code>null</code> if a matching trang thai thong ke phan hoi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi fetchBythangNam_Last(String thangNam,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBythangNam(thangNam);

		if (count == 0) {
			return null;
		}

		List<TrangThaiThongKePhanHoi> list = findBythangNam(thangNam,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trang thai thong ke phan hois before and after the current trang thai thong ke phan hoi in the ordered set where thangNam = &#63;.
	 *
	 * @param id the primary key of the current trang thai thong ke phan hoi
	 * @param thangNam the thang nam
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trang thai thong ke phan hoi
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchTrangThaiThongKePhanHoiException if a trang thai thong ke phan hoi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi[] findBythangNam_PrevAndNext(long id,
		String thangNam, OrderByComparator orderByComparator)
		throws NoSuchTrangThaiThongKePhanHoiException, SystemException {
		TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TrangThaiThongKePhanHoi[] array = new TrangThaiThongKePhanHoiImpl[3];

			array[0] = getBythangNam_PrevAndNext(session,
					trangThaiThongKePhanHoi, thangNam, orderByComparator, true);

			array[1] = trangThaiThongKePhanHoi;

			array[2] = getBythangNam_PrevAndNext(session,
					trangThaiThongKePhanHoi, thangNam, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TrangThaiThongKePhanHoi getBythangNam_PrevAndNext(
		Session session, TrangThaiThongKePhanHoi trangThaiThongKePhanHoi,
		String thangNam, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRANGTHAITHONGKEPHANHOI_WHERE);

		boolean bindThangNam = false;

		if (thangNam == null) {
			query.append(_FINDER_COLUMN_THANGNAM_THANGNAM_1);
		}
		else if (thangNam.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_THANGNAM_THANGNAM_3);
		}
		else {
			bindThangNam = true;

			query.append(_FINDER_COLUMN_THANGNAM_THANGNAM_2);
		}

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
			query.append(TrangThaiThongKePhanHoiModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindThangNam) {
			qPos.add(thangNam);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(trangThaiThongKePhanHoi);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TrangThaiThongKePhanHoi> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trang thai thong ke phan hois where thangNam = &#63; from the database.
	 *
	 * @param thangNam the thang nam
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBythangNam(String thangNam) throws SystemException {
		for (TrangThaiThongKePhanHoi trangThaiThongKePhanHoi : findBythangNam(
				thangNam, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(trangThaiThongKePhanHoi);
		}
	}

	/**
	 * Returns the number of trang thai thong ke phan hois where thangNam = &#63;.
	 *
	 * @param thangNam the thang nam
	 * @return the number of matching trang thai thong ke phan hois
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBythangNam(String thangNam) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_THANGNAM;

		Object[] finderArgs = new Object[] { thangNam };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRANGTHAITHONGKEPHANHOI_WHERE);

			boolean bindThangNam = false;

			if (thangNam == null) {
				query.append(_FINDER_COLUMN_THANGNAM_THANGNAM_1);
			}
			else if (thangNam.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_THANGNAM_THANGNAM_3);
			}
			else {
				bindThangNam = true;

				query.append(_FINDER_COLUMN_THANGNAM_THANGNAM_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindThangNam) {
					qPos.add(thangNam);
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

	private static final String _FINDER_COLUMN_THANGNAM_THANGNAM_1 = "trangThaiThongKePhanHoi.thangNam IS NULL";
	private static final String _FINDER_COLUMN_THANGNAM_THANGNAM_2 = "trangThaiThongKePhanHoi.thangNam = ?";
	private static final String _FINDER_COLUMN_THANGNAM_THANGNAM_3 = "(trangThaiThongKePhanHoi.thangNam IS NULL OR trangThaiThongKePhanHoi.thangNam = '')";

	public TrangThaiThongKePhanHoiPersistenceImpl() {
		setModelClass(TrangThaiThongKePhanHoi.class);
	}

	/**
	 * Caches the trang thai thong ke phan hoi in the entity cache if it is enabled.
	 *
	 * @param trangThaiThongKePhanHoi the trang thai thong ke phan hoi
	 */
	@Override
	public void cacheResult(TrangThaiThongKePhanHoi trangThaiThongKePhanHoi) {
		EntityCacheUtil.putResult(TrangThaiThongKePhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiThongKePhanHoiImpl.class,
			trangThaiThongKePhanHoi.getPrimaryKey(), trangThaiThongKePhanHoi);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MATINHTHANGNAMCHUYENSANGMB,
			new Object[] {
				trangThaiThongKePhanHoi.getMaTinh(),
				trangThaiThongKePhanHoi.getThangNam(),
				trangThaiThongKePhanHoi.getDaChuyenSangMinhBach()
			}, trangThaiThongKePhanHoi);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARTICLEID,
			new Object[] { trangThaiThongKePhanHoi.getArticleId() },
			trangThaiThongKePhanHoi);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARTICLEIDANDDACHUYENSANGMINHBACH,
			new Object[] {
				trangThaiThongKePhanHoi.getArticleId(),
				trangThaiThongKePhanHoi.getDaChuyenSangMinhBach()
			}, trangThaiThongKePhanHoi);

		trangThaiThongKePhanHoi.resetOriginalValues();
	}

	/**
	 * Caches the trang thai thong ke phan hois in the entity cache if it is enabled.
	 *
	 * @param trangThaiThongKePhanHois the trang thai thong ke phan hois
	 */
	@Override
	public void cacheResult(
		List<TrangThaiThongKePhanHoi> trangThaiThongKePhanHois) {
		for (TrangThaiThongKePhanHoi trangThaiThongKePhanHoi : trangThaiThongKePhanHois) {
			if (EntityCacheUtil.getResult(
						TrangThaiThongKePhanHoiModelImpl.ENTITY_CACHE_ENABLED,
						TrangThaiThongKePhanHoiImpl.class,
						trangThaiThongKePhanHoi.getPrimaryKey()) == null) {
				cacheResult(trangThaiThongKePhanHoi);
			}
			else {
				trangThaiThongKePhanHoi.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all trang thai thong ke phan hois.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TrangThaiThongKePhanHoiImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TrangThaiThongKePhanHoiImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the trang thai thong ke phan hoi.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TrangThaiThongKePhanHoi trangThaiThongKePhanHoi) {
		EntityCacheUtil.removeResult(TrangThaiThongKePhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiThongKePhanHoiImpl.class,
			trangThaiThongKePhanHoi.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(trangThaiThongKePhanHoi);
	}

	@Override
	public void clearCache(
		List<TrangThaiThongKePhanHoi> trangThaiThongKePhanHois) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TrangThaiThongKePhanHoi trangThaiThongKePhanHoi : trangThaiThongKePhanHois) {
			EntityCacheUtil.removeResult(TrangThaiThongKePhanHoiModelImpl.ENTITY_CACHE_ENABLED,
				TrangThaiThongKePhanHoiImpl.class,
				trangThaiThongKePhanHoi.getPrimaryKey());

			clearUniqueFindersCache(trangThaiThongKePhanHoi);
		}
	}

	protected void cacheUniqueFindersCache(
		TrangThaiThongKePhanHoi trangThaiThongKePhanHoi) {
		if (trangThaiThongKePhanHoi.isNew()) {
			Object[] args = new Object[] {
					trangThaiThongKePhanHoi.getMaTinh(),
					trangThaiThongKePhanHoi.getThangNam(),
					trangThaiThongKePhanHoi.getDaChuyenSangMinhBach()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MATINHTHANGNAMCHUYENSANGMB,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MATINHTHANGNAMCHUYENSANGMB,
				args, trangThaiThongKePhanHoi);

			args = new Object[] { trangThaiThongKePhanHoi.getArticleId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ARTICLEID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARTICLEID, args,
				trangThaiThongKePhanHoi);

			args = new Object[] {
					trangThaiThongKePhanHoi.getArticleId(),
					trangThaiThongKePhanHoi.getDaChuyenSangMinhBach()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ARTICLEIDANDDACHUYENSANGMINHBACH,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARTICLEIDANDDACHUYENSANGMINHBACH,
				args, trangThaiThongKePhanHoi);
		}
		else {
			TrangThaiThongKePhanHoiModelImpl trangThaiThongKePhanHoiModelImpl = (TrangThaiThongKePhanHoiModelImpl)trangThaiThongKePhanHoi;

			if ((trangThaiThongKePhanHoiModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MATINHTHANGNAMCHUYENSANGMB.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trangThaiThongKePhanHoi.getMaTinh(),
						trangThaiThongKePhanHoi.getThangNam(),
						trangThaiThongKePhanHoi.getDaChuyenSangMinhBach()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MATINHTHANGNAMCHUYENSANGMB,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MATINHTHANGNAMCHUYENSANGMB,
					args, trangThaiThongKePhanHoi);
			}

			if ((trangThaiThongKePhanHoiModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ARTICLEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trangThaiThongKePhanHoi.getArticleId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ARTICLEID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARTICLEID, args,
					trangThaiThongKePhanHoi);
			}

			if ((trangThaiThongKePhanHoiModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ARTICLEIDANDDACHUYENSANGMINHBACH.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trangThaiThongKePhanHoi.getArticleId(),
						trangThaiThongKePhanHoi.getDaChuyenSangMinhBach()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ARTICLEIDANDDACHUYENSANGMINHBACH,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ARTICLEIDANDDACHUYENSANGMINHBACH,
					args, trangThaiThongKePhanHoi);
			}
		}
	}

	protected void clearUniqueFindersCache(
		TrangThaiThongKePhanHoi trangThaiThongKePhanHoi) {
		TrangThaiThongKePhanHoiModelImpl trangThaiThongKePhanHoiModelImpl = (TrangThaiThongKePhanHoiModelImpl)trangThaiThongKePhanHoi;

		Object[] args = new Object[] {
				trangThaiThongKePhanHoi.getMaTinh(),
				trangThaiThongKePhanHoi.getThangNam(),
				trangThaiThongKePhanHoi.getDaChuyenSangMinhBach()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MATINHTHANGNAMCHUYENSANGMB,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MATINHTHANGNAMCHUYENSANGMB,
			args);

		if ((trangThaiThongKePhanHoiModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_MATINHTHANGNAMCHUYENSANGMB.getColumnBitmask()) != 0) {
			args = new Object[] {
					trangThaiThongKePhanHoiModelImpl.getOriginalMaTinh(),
					trangThaiThongKePhanHoiModelImpl.getOriginalThangNam(),
					trangThaiThongKePhanHoiModelImpl.getOriginalDaChuyenSangMinhBach()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MATINHTHANGNAMCHUYENSANGMB,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MATINHTHANGNAMCHUYENSANGMB,
				args);
		}

		args = new Object[] { trangThaiThongKePhanHoi.getArticleId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ARTICLEID, args);

		if ((trangThaiThongKePhanHoiModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ARTICLEID.getColumnBitmask()) != 0) {
			args = new Object[] {
					trangThaiThongKePhanHoiModelImpl.getOriginalArticleId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLEID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ARTICLEID, args);
		}

		args = new Object[] {
				trangThaiThongKePhanHoi.getArticleId(),
				trangThaiThongKePhanHoi.getDaChuyenSangMinhBach()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLEIDANDDACHUYENSANGMINHBACH,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ARTICLEIDANDDACHUYENSANGMINHBACH,
			args);

		if ((trangThaiThongKePhanHoiModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ARTICLEIDANDDACHUYENSANGMINHBACH.getColumnBitmask()) != 0) {
			args = new Object[] {
					trangThaiThongKePhanHoiModelImpl.getOriginalArticleId(),
					trangThaiThongKePhanHoiModelImpl.getOriginalDaChuyenSangMinhBach()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLEIDANDDACHUYENSANGMINHBACH,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ARTICLEIDANDDACHUYENSANGMINHBACH,
				args);
		}
	}

	/**
	 * Creates a new trang thai thong ke phan hoi with the primary key. Does not add the trang thai thong ke phan hoi to the database.
	 *
	 * @param id the primary key for the new trang thai thong ke phan hoi
	 * @return the new trang thai thong ke phan hoi
	 */
	@Override
	public TrangThaiThongKePhanHoi create(long id) {
		TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = new TrangThaiThongKePhanHoiImpl();

		trangThaiThongKePhanHoi.setNew(true);
		trangThaiThongKePhanHoi.setPrimaryKey(id);

		return trangThaiThongKePhanHoi;
	}

	/**
	 * Removes the trang thai thong ke phan hoi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the trang thai thong ke phan hoi
	 * @return the trang thai thong ke phan hoi that was removed
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchTrangThaiThongKePhanHoiException if a trang thai thong ke phan hoi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi remove(long id)
		throws NoSuchTrangThaiThongKePhanHoiException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the trang thai thong ke phan hoi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the trang thai thong ke phan hoi
	 * @return the trang thai thong ke phan hoi that was removed
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchTrangThaiThongKePhanHoiException if a trang thai thong ke phan hoi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi remove(Serializable primaryKey)
		throws NoSuchTrangThaiThongKePhanHoiException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = (TrangThaiThongKePhanHoi)session.get(TrangThaiThongKePhanHoiImpl.class,
					primaryKey);

			if (trangThaiThongKePhanHoi == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTrangThaiThongKePhanHoiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(trangThaiThongKePhanHoi);
		}
		catch (NoSuchTrangThaiThongKePhanHoiException nsee) {
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
	protected TrangThaiThongKePhanHoi removeImpl(
		TrangThaiThongKePhanHoi trangThaiThongKePhanHoi)
		throws SystemException {
		trangThaiThongKePhanHoi = toUnwrappedModel(trangThaiThongKePhanHoi);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(trangThaiThongKePhanHoi)) {
				trangThaiThongKePhanHoi = (TrangThaiThongKePhanHoi)session.get(TrangThaiThongKePhanHoiImpl.class,
						trangThaiThongKePhanHoi.getPrimaryKeyObj());
			}

			if (trangThaiThongKePhanHoi != null) {
				session.delete(trangThaiThongKePhanHoi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (trangThaiThongKePhanHoi != null) {
			clearCache(trangThaiThongKePhanHoi);
		}

		return trangThaiThongKePhanHoi;
	}

	@Override
	public TrangThaiThongKePhanHoi updateImpl(
		vn.dtt.ns.thongtinphanhoi.dao.model.TrangThaiThongKePhanHoi trangThaiThongKePhanHoi)
		throws SystemException {
		trangThaiThongKePhanHoi = toUnwrappedModel(trangThaiThongKePhanHoi);

		boolean isNew = trangThaiThongKePhanHoi.isNew();

		TrangThaiThongKePhanHoiModelImpl trangThaiThongKePhanHoiModelImpl = (TrangThaiThongKePhanHoiModelImpl)trangThaiThongKePhanHoi;

		Session session = null;

		try {
			session = openSession();

			if (trangThaiThongKePhanHoi.isNew()) {
				session.save(trangThaiThongKePhanHoi);

				trangThaiThongKePhanHoi.setNew(false);
			}
			else {
				session.merge(trangThaiThongKePhanHoi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TrangThaiThongKePhanHoiModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((trangThaiThongKePhanHoiModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATINH.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trangThaiThongKePhanHoiModelImpl.getOriginalMaTinh()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MATINH, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATINH,
					args);

				args = new Object[] { trangThaiThongKePhanHoiModelImpl.getMaTinh() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MATINH, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATINH,
					args);
			}

			if ((trangThaiThongKePhanHoiModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THANGNAM.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trangThaiThongKePhanHoiModelImpl.getOriginalThangNam()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THANGNAM, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THANGNAM,
					args);

				args = new Object[] {
						trangThaiThongKePhanHoiModelImpl.getThangNam()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THANGNAM, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THANGNAM,
					args);
			}
		}

		EntityCacheUtil.putResult(TrangThaiThongKePhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiThongKePhanHoiImpl.class,
			trangThaiThongKePhanHoi.getPrimaryKey(), trangThaiThongKePhanHoi);

		clearUniqueFindersCache(trangThaiThongKePhanHoi);
		cacheUniqueFindersCache(trangThaiThongKePhanHoi);

		return trangThaiThongKePhanHoi;
	}

	protected TrangThaiThongKePhanHoi toUnwrappedModel(
		TrangThaiThongKePhanHoi trangThaiThongKePhanHoi) {
		if (trangThaiThongKePhanHoi instanceof TrangThaiThongKePhanHoiImpl) {
			return trangThaiThongKePhanHoi;
		}

		TrangThaiThongKePhanHoiImpl trangThaiThongKePhanHoiImpl = new TrangThaiThongKePhanHoiImpl();

		trangThaiThongKePhanHoiImpl.setNew(trangThaiThongKePhanHoi.isNew());
		trangThaiThongKePhanHoiImpl.setPrimaryKey(trangThaiThongKePhanHoi.getPrimaryKey());

		trangThaiThongKePhanHoiImpl.setId(trangThaiThongKePhanHoi.getId());
		trangThaiThongKePhanHoiImpl.setMaTinh(trangThaiThongKePhanHoi.getMaTinh());
		trangThaiThongKePhanHoiImpl.setThangNam(trangThaiThongKePhanHoi.getThangNam());
		trangThaiThongKePhanHoiImpl.setNgayTao(trangThaiThongKePhanHoi.getNgayTao());
		trangThaiThongKePhanHoiImpl.setNgayCapNhat(trangThaiThongKePhanHoi.getNgayCapNhat());
		trangThaiThongKePhanHoiImpl.setNguoiChuyen(trangThaiThongKePhanHoi.getNguoiChuyen());
		trangThaiThongKePhanHoiImpl.setNguoiCapNhat(trangThaiThongKePhanHoi.getNguoiCapNhat());
		trangThaiThongKePhanHoiImpl.setDaChuyenSangMinhBach(trangThaiThongKePhanHoi.getDaChuyenSangMinhBach());
		trangThaiThongKePhanHoiImpl.setArticleId(trangThaiThongKePhanHoi.getArticleId());
		trangThaiThongKePhanHoiImpl.setGroupId(trangThaiThongKePhanHoi.getGroupId());
		trangThaiThongKePhanHoiImpl.setUserId(trangThaiThongKePhanHoi.getUserId());
		trangThaiThongKePhanHoiImpl.setVersion(trangThaiThongKePhanHoi.getVersion());

		return trangThaiThongKePhanHoiImpl;
	}

	/**
	 * Returns the trang thai thong ke phan hoi with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the trang thai thong ke phan hoi
	 * @return the trang thai thong ke phan hoi
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchTrangThaiThongKePhanHoiException if a trang thai thong ke phan hoi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTrangThaiThongKePhanHoiException, SystemException {
		TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = fetchByPrimaryKey(primaryKey);

		if (trangThaiThongKePhanHoi == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTrangThaiThongKePhanHoiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return trangThaiThongKePhanHoi;
	}

	/**
	 * Returns the trang thai thong ke phan hoi with the primary key or throws a {@link vn.dtt.ns.thongtinphanhoi.dao.NoSuchTrangThaiThongKePhanHoiException} if it could not be found.
	 *
	 * @param id the primary key of the trang thai thong ke phan hoi
	 * @return the trang thai thong ke phan hoi
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchTrangThaiThongKePhanHoiException if a trang thai thong ke phan hoi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi findByPrimaryKey(long id)
		throws NoSuchTrangThaiThongKePhanHoiException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the trang thai thong ke phan hoi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the trang thai thong ke phan hoi
	 * @return the trang thai thong ke phan hoi, or <code>null</code> if a trang thai thong ke phan hoi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TrangThaiThongKePhanHoi trangThaiThongKePhanHoi = (TrangThaiThongKePhanHoi)EntityCacheUtil.getResult(TrangThaiThongKePhanHoiModelImpl.ENTITY_CACHE_ENABLED,
				TrangThaiThongKePhanHoiImpl.class, primaryKey);

		if (trangThaiThongKePhanHoi == _nullTrangThaiThongKePhanHoi) {
			return null;
		}

		if (trangThaiThongKePhanHoi == null) {
			Session session = null;

			try {
				session = openSession();

				trangThaiThongKePhanHoi = (TrangThaiThongKePhanHoi)session.get(TrangThaiThongKePhanHoiImpl.class,
						primaryKey);

				if (trangThaiThongKePhanHoi != null) {
					cacheResult(trangThaiThongKePhanHoi);
				}
				else {
					EntityCacheUtil.putResult(TrangThaiThongKePhanHoiModelImpl.ENTITY_CACHE_ENABLED,
						TrangThaiThongKePhanHoiImpl.class, primaryKey,
						_nullTrangThaiThongKePhanHoi);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TrangThaiThongKePhanHoiModelImpl.ENTITY_CACHE_ENABLED,
					TrangThaiThongKePhanHoiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return trangThaiThongKePhanHoi;
	}

	/**
	 * Returns the trang thai thong ke phan hoi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the trang thai thong ke phan hoi
	 * @return the trang thai thong ke phan hoi, or <code>null</code> if a trang thai thong ke phan hoi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiThongKePhanHoi fetchByPrimaryKey(long id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the trang thai thong ke phan hois.
	 *
	 * @return the trang thai thong ke phan hois
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrangThaiThongKePhanHoi> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trang thai thong ke phan hois.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.thongtinphanhoi.dao.model.impl.TrangThaiThongKePhanHoiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of trang thai thong ke phan hois
	 * @param end the upper bound of the range of trang thai thong ke phan hois (not inclusive)
	 * @return the range of trang thai thong ke phan hois
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrangThaiThongKePhanHoi> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the trang thai thong ke phan hois.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.thongtinphanhoi.dao.model.impl.TrangThaiThongKePhanHoiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of trang thai thong ke phan hois
	 * @param end the upper bound of the range of trang thai thong ke phan hois (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trang thai thong ke phan hois
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrangThaiThongKePhanHoi> findAll(int start, int end,
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

		List<TrangThaiThongKePhanHoi> list = (List<TrangThaiThongKePhanHoi>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TRANGTHAITHONGKEPHANHOI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRANGTHAITHONGKEPHANHOI;

				if (pagination) {
					sql = sql.concat(TrangThaiThongKePhanHoiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TrangThaiThongKePhanHoi>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TrangThaiThongKePhanHoi>(list);
				}
				else {
					list = (List<TrangThaiThongKePhanHoi>)QueryUtil.list(q,
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
	 * Removes all the trang thai thong ke phan hois from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TrangThaiThongKePhanHoi trangThaiThongKePhanHoi : findAll()) {
			remove(trangThaiThongKePhanHoi);
		}
	}

	/**
	 * Returns the number of trang thai thong ke phan hois.
	 *
	 * @return the number of trang thai thong ke phan hois
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

				Query q = session.createQuery(_SQL_COUNT_TRANGTHAITHONGKEPHANHOI);

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
	 * Initializes the trang thai thong ke phan hoi persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.dtt.ns.thongtinphanhoi.dao.model.TrangThaiThongKePhanHoi")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TrangThaiThongKePhanHoi>> listenersList = new ArrayList<ModelListener<TrangThaiThongKePhanHoi>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TrangThaiThongKePhanHoi>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TrangThaiThongKePhanHoiImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TRANGTHAITHONGKEPHANHOI = "SELECT trangThaiThongKePhanHoi FROM TrangThaiThongKePhanHoi trangThaiThongKePhanHoi";
	private static final String _SQL_SELECT_TRANGTHAITHONGKEPHANHOI_WHERE = "SELECT trangThaiThongKePhanHoi FROM TrangThaiThongKePhanHoi trangThaiThongKePhanHoi WHERE ";
	private static final String _SQL_COUNT_TRANGTHAITHONGKEPHANHOI = "SELECT COUNT(trangThaiThongKePhanHoi) FROM TrangThaiThongKePhanHoi trangThaiThongKePhanHoi";
	private static final String _SQL_COUNT_TRANGTHAITHONGKEPHANHOI_WHERE = "SELECT COUNT(trangThaiThongKePhanHoi) FROM TrangThaiThongKePhanHoi trangThaiThongKePhanHoi WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "trangThaiThongKePhanHoi.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TrangThaiThongKePhanHoi exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TrangThaiThongKePhanHoi exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TrangThaiThongKePhanHoiPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"maTinh", "thangNam", "ngayTao", "ngayCapNhat", "nguoiChuyen",
				"nguoiCapNhat", "daChuyenSangMinhBach"
			});
	private static TrangThaiThongKePhanHoi _nullTrangThaiThongKePhanHoi = new TrangThaiThongKePhanHoiImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TrangThaiThongKePhanHoi> toCacheModel() {
				return _nullTrangThaiThongKePhanHoiCacheModel;
			}
		};

	private static CacheModel<TrangThaiThongKePhanHoi> _nullTrangThaiThongKePhanHoiCacheModel =
		new CacheModel<TrangThaiThongKePhanHoi>() {
			@Override
			public TrangThaiThongKePhanHoi toEntityModel() {
				return _nullTrangThaiThongKePhanHoi;
			}
		};
}