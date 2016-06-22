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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import vn.dtt.ns.thongtinphanhoi.dao.NoSuchChiTietThongTinPhanHoiException;
import vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi;
import vn.dtt.ns.thongtinphanhoi.dao.model.impl.ChiTietThongTinPhanHoiImpl;
import vn.dtt.ns.thongtinphanhoi.dao.model.impl.ChiTietThongTinPhanHoiModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the chi tiet thong tin phan hoi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tubq
 * @see ChiTietThongTinPhanHoiPersistence
 * @see ChiTietThongTinPhanHoiUtil
 * @generated
 */
public class ChiTietThongTinPhanHoiPersistenceImpl extends BasePersistenceImpl<ChiTietThongTinPhanHoi>
	implements ChiTietThongTinPhanHoiPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ChiTietThongTinPhanHoiUtil} to access the chi tiet thong tin phan hoi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ChiTietThongTinPhanHoiImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ChiTietThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietThongTinPhanHoiModelImpl.FINDER_CACHE_ENABLED,
			ChiTietThongTinPhanHoiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ChiTietThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietThongTinPhanHoiModelImpl.FINDER_CACHE_ENABLED,
			ChiTietThongTinPhanHoiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ChiTietThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietThongTinPhanHoiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_THONGTINPHANHOIID =
		new FinderPath(ChiTietThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietThongTinPhanHoiModelImpl.FINDER_CACHE_ENABLED,
			ChiTietThongTinPhanHoiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByThongTinPhanHoiId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THONGTINPHANHOIID =
		new FinderPath(ChiTietThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietThongTinPhanHoiModelImpl.FINDER_CACHE_ENABLED,
			ChiTietThongTinPhanHoiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByThongTinPhanHoiId", new String[] { Long.class.getName() },
			ChiTietThongTinPhanHoiModelImpl.THONGTINPHANHOIID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_THONGTINPHANHOIID = new FinderPath(ChiTietThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietThongTinPhanHoiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByThongTinPhanHoiId", new String[] { Long.class.getName() });

	/**
	 * Returns all the chi tiet thong tin phan hois where thongTinPhanHoiId = &#63;.
	 *
	 * @param thongTinPhanHoiId the thong tin phan hoi ID
	 * @return the matching chi tiet thong tin phan hois
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChiTietThongTinPhanHoi> findByThongTinPhanHoiId(
		long thongTinPhanHoiId) throws SystemException {
		return findByThongTinPhanHoiId(thongTinPhanHoiId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<ChiTietThongTinPhanHoi> findByThongTinPhanHoiId(
		long thongTinPhanHoiId, int start, int end) throws SystemException {
		return findByThongTinPhanHoiId(thongTinPhanHoiId, start, end, null);
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
	@Override
	public List<ChiTietThongTinPhanHoi> findByThongTinPhanHoiId(
		long thongTinPhanHoiId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THONGTINPHANHOIID;
			finderArgs = new Object[] { thongTinPhanHoiId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_THONGTINPHANHOIID;
			finderArgs = new Object[] {
					thongTinPhanHoiId,
					
					start, end, orderByComparator
				};
		}

		List<ChiTietThongTinPhanHoi> list = (List<ChiTietThongTinPhanHoi>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ChiTietThongTinPhanHoi chiTietThongTinPhanHoi : list) {
				if ((thongTinPhanHoiId != chiTietThongTinPhanHoi.getThongTinPhanHoiId())) {
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

			query.append(_SQL_SELECT_CHITIETTHONGTINPHANHOI_WHERE);

			query.append(_FINDER_COLUMN_THONGTINPHANHOIID_THONGTINPHANHOIID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ChiTietThongTinPhanHoiModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thongTinPhanHoiId);

				if (!pagination) {
					list = (List<ChiTietThongTinPhanHoi>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ChiTietThongTinPhanHoi>(list);
				}
				else {
					list = (List<ChiTietThongTinPhanHoi>)QueryUtil.list(q,
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
	 * Returns the first chi tiet thong tin phan hoi in the ordered set where thongTinPhanHoiId = &#63;.
	 *
	 * @param thongTinPhanHoiId the thong tin phan hoi ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chi tiet thong tin phan hoi
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchChiTietThongTinPhanHoiException if a matching chi tiet thong tin phan hoi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietThongTinPhanHoi findByThongTinPhanHoiId_First(
		long thongTinPhanHoiId, OrderByComparator orderByComparator)
		throws NoSuchChiTietThongTinPhanHoiException, SystemException {
		ChiTietThongTinPhanHoi chiTietThongTinPhanHoi = fetchByThongTinPhanHoiId_First(thongTinPhanHoiId,
				orderByComparator);

		if (chiTietThongTinPhanHoi != null) {
			return chiTietThongTinPhanHoi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("thongTinPhanHoiId=");
		msg.append(thongTinPhanHoiId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChiTietThongTinPhanHoiException(msg.toString());
	}

	/**
	 * Returns the first chi tiet thong tin phan hoi in the ordered set where thongTinPhanHoiId = &#63;.
	 *
	 * @param thongTinPhanHoiId the thong tin phan hoi ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chi tiet thong tin phan hoi, or <code>null</code> if a matching chi tiet thong tin phan hoi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietThongTinPhanHoi fetchByThongTinPhanHoiId_First(
		long thongTinPhanHoiId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ChiTietThongTinPhanHoi> list = findByThongTinPhanHoiId(thongTinPhanHoiId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ChiTietThongTinPhanHoi findByThongTinPhanHoiId_Last(
		long thongTinPhanHoiId, OrderByComparator orderByComparator)
		throws NoSuchChiTietThongTinPhanHoiException, SystemException {
		ChiTietThongTinPhanHoi chiTietThongTinPhanHoi = fetchByThongTinPhanHoiId_Last(thongTinPhanHoiId,
				orderByComparator);

		if (chiTietThongTinPhanHoi != null) {
			return chiTietThongTinPhanHoi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("thongTinPhanHoiId=");
		msg.append(thongTinPhanHoiId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChiTietThongTinPhanHoiException(msg.toString());
	}

	/**
	 * Returns the last chi tiet thong tin phan hoi in the ordered set where thongTinPhanHoiId = &#63;.
	 *
	 * @param thongTinPhanHoiId the thong tin phan hoi ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chi tiet thong tin phan hoi, or <code>null</code> if a matching chi tiet thong tin phan hoi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietThongTinPhanHoi fetchByThongTinPhanHoiId_Last(
		long thongTinPhanHoiId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByThongTinPhanHoiId(thongTinPhanHoiId);

		if (count == 0) {
			return null;
		}

		List<ChiTietThongTinPhanHoi> list = findByThongTinPhanHoiId(thongTinPhanHoiId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ChiTietThongTinPhanHoi[] findByThongTinPhanHoiId_PrevAndNext(
		long id, long thongTinPhanHoiId, OrderByComparator orderByComparator)
		throws NoSuchChiTietThongTinPhanHoiException, SystemException {
		ChiTietThongTinPhanHoi chiTietThongTinPhanHoi = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ChiTietThongTinPhanHoi[] array = new ChiTietThongTinPhanHoiImpl[3];

			array[0] = getByThongTinPhanHoiId_PrevAndNext(session,
					chiTietThongTinPhanHoi, thongTinPhanHoiId,
					orderByComparator, true);

			array[1] = chiTietThongTinPhanHoi;

			array[2] = getByThongTinPhanHoiId_PrevAndNext(session,
					chiTietThongTinPhanHoi, thongTinPhanHoiId,
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

	protected ChiTietThongTinPhanHoi getByThongTinPhanHoiId_PrevAndNext(
		Session session, ChiTietThongTinPhanHoi chiTietThongTinPhanHoi,
		long thongTinPhanHoiId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHITIETTHONGTINPHANHOI_WHERE);

		query.append(_FINDER_COLUMN_THONGTINPHANHOIID_THONGTINPHANHOIID_2);

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
			query.append(ChiTietThongTinPhanHoiModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(thongTinPhanHoiId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(chiTietThongTinPhanHoi);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChiTietThongTinPhanHoi> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the chi tiet thong tin phan hois where thongTinPhanHoiId = &#63; from the database.
	 *
	 * @param thongTinPhanHoiId the thong tin phan hoi ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByThongTinPhanHoiId(long thongTinPhanHoiId)
		throws SystemException {
		for (ChiTietThongTinPhanHoi chiTietThongTinPhanHoi : findByThongTinPhanHoiId(
				thongTinPhanHoiId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(chiTietThongTinPhanHoi);
		}
	}

	/**
	 * Returns the number of chi tiet thong tin phan hois where thongTinPhanHoiId = &#63;.
	 *
	 * @param thongTinPhanHoiId the thong tin phan hoi ID
	 * @return the number of matching chi tiet thong tin phan hois
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByThongTinPhanHoiId(long thongTinPhanHoiId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_THONGTINPHANHOIID;

		Object[] finderArgs = new Object[] { thongTinPhanHoiId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHITIETTHONGTINPHANHOI_WHERE);

			query.append(_FINDER_COLUMN_THONGTINPHANHOIID_THONGTINPHANHOIID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(thongTinPhanHoiId);

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

	private static final String _FINDER_COLUMN_THONGTINPHANHOIID_THONGTINPHANHOIID_2 =
		"chiTietThongTinPhanHoi.thongTinPhanHoiId = ?";

	public ChiTietThongTinPhanHoiPersistenceImpl() {
		setModelClass(ChiTietThongTinPhanHoi.class);
	}

	/**
	 * Caches the chi tiet thong tin phan hoi in the entity cache if it is enabled.
	 *
	 * @param chiTietThongTinPhanHoi the chi tiet thong tin phan hoi
	 */
	@Override
	public void cacheResult(ChiTietThongTinPhanHoi chiTietThongTinPhanHoi) {
		EntityCacheUtil.putResult(ChiTietThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietThongTinPhanHoiImpl.class,
			chiTietThongTinPhanHoi.getPrimaryKey(), chiTietThongTinPhanHoi);

		chiTietThongTinPhanHoi.resetOriginalValues();
	}

	/**
	 * Caches the chi tiet thong tin phan hois in the entity cache if it is enabled.
	 *
	 * @param chiTietThongTinPhanHois the chi tiet thong tin phan hois
	 */
	@Override
	public void cacheResult(
		List<ChiTietThongTinPhanHoi> chiTietThongTinPhanHois) {
		for (ChiTietThongTinPhanHoi chiTietThongTinPhanHoi : chiTietThongTinPhanHois) {
			if (EntityCacheUtil.getResult(
						ChiTietThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
						ChiTietThongTinPhanHoiImpl.class,
						chiTietThongTinPhanHoi.getPrimaryKey()) == null) {
				cacheResult(chiTietThongTinPhanHoi);
			}
			else {
				chiTietThongTinPhanHoi.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all chi tiet thong tin phan hois.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ChiTietThongTinPhanHoiImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ChiTietThongTinPhanHoiImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the chi tiet thong tin phan hoi.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ChiTietThongTinPhanHoi chiTietThongTinPhanHoi) {
		EntityCacheUtil.removeResult(ChiTietThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietThongTinPhanHoiImpl.class,
			chiTietThongTinPhanHoi.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ChiTietThongTinPhanHoi> chiTietThongTinPhanHois) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ChiTietThongTinPhanHoi chiTietThongTinPhanHoi : chiTietThongTinPhanHois) {
			EntityCacheUtil.removeResult(ChiTietThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
				ChiTietThongTinPhanHoiImpl.class,
				chiTietThongTinPhanHoi.getPrimaryKey());
		}
	}

	/**
	 * Creates a new chi tiet thong tin phan hoi with the primary key. Does not add the chi tiet thong tin phan hoi to the database.
	 *
	 * @param id the primary key for the new chi tiet thong tin phan hoi
	 * @return the new chi tiet thong tin phan hoi
	 */
	@Override
	public ChiTietThongTinPhanHoi create(long id) {
		ChiTietThongTinPhanHoi chiTietThongTinPhanHoi = new ChiTietThongTinPhanHoiImpl();

		chiTietThongTinPhanHoi.setNew(true);
		chiTietThongTinPhanHoi.setPrimaryKey(id);

		return chiTietThongTinPhanHoi;
	}

	/**
	 * Removes the chi tiet thong tin phan hoi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chi tiet thong tin phan hoi
	 * @return the chi tiet thong tin phan hoi that was removed
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchChiTietThongTinPhanHoiException if a chi tiet thong tin phan hoi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietThongTinPhanHoi remove(long id)
		throws NoSuchChiTietThongTinPhanHoiException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the chi tiet thong tin phan hoi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the chi tiet thong tin phan hoi
	 * @return the chi tiet thong tin phan hoi that was removed
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchChiTietThongTinPhanHoiException if a chi tiet thong tin phan hoi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietThongTinPhanHoi remove(Serializable primaryKey)
		throws NoSuchChiTietThongTinPhanHoiException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ChiTietThongTinPhanHoi chiTietThongTinPhanHoi = (ChiTietThongTinPhanHoi)session.get(ChiTietThongTinPhanHoiImpl.class,
					primaryKey);

			if (chiTietThongTinPhanHoi == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChiTietThongTinPhanHoiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(chiTietThongTinPhanHoi);
		}
		catch (NoSuchChiTietThongTinPhanHoiException nsee) {
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
	protected ChiTietThongTinPhanHoi removeImpl(
		ChiTietThongTinPhanHoi chiTietThongTinPhanHoi)
		throws SystemException {
		chiTietThongTinPhanHoi = toUnwrappedModel(chiTietThongTinPhanHoi);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(chiTietThongTinPhanHoi)) {
				chiTietThongTinPhanHoi = (ChiTietThongTinPhanHoi)session.get(ChiTietThongTinPhanHoiImpl.class,
						chiTietThongTinPhanHoi.getPrimaryKeyObj());
			}

			if (chiTietThongTinPhanHoi != null) {
				session.delete(chiTietThongTinPhanHoi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (chiTietThongTinPhanHoi != null) {
			clearCache(chiTietThongTinPhanHoi);
		}

		return chiTietThongTinPhanHoi;
	}

	@Override
	public ChiTietThongTinPhanHoi updateImpl(
		vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi chiTietThongTinPhanHoi)
		throws SystemException {
		chiTietThongTinPhanHoi = toUnwrappedModel(chiTietThongTinPhanHoi);

		boolean isNew = chiTietThongTinPhanHoi.isNew();

		ChiTietThongTinPhanHoiModelImpl chiTietThongTinPhanHoiModelImpl = (ChiTietThongTinPhanHoiModelImpl)chiTietThongTinPhanHoi;

		Session session = null;

		try {
			session = openSession();

			if (chiTietThongTinPhanHoi.isNew()) {
				session.save(chiTietThongTinPhanHoi);

				chiTietThongTinPhanHoi.setNew(false);
			}
			else {
				session.merge(chiTietThongTinPhanHoi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ChiTietThongTinPhanHoiModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((chiTietThongTinPhanHoiModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THONGTINPHANHOIID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						chiTietThongTinPhanHoiModelImpl.getOriginalThongTinPhanHoiId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THONGTINPHANHOIID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THONGTINPHANHOIID,
					args);

				args = new Object[] {
						chiTietThongTinPhanHoiModelImpl.getThongTinPhanHoiId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_THONGTINPHANHOIID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_THONGTINPHANHOIID,
					args);
			}
		}

		EntityCacheUtil.putResult(ChiTietThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			ChiTietThongTinPhanHoiImpl.class,
			chiTietThongTinPhanHoi.getPrimaryKey(), chiTietThongTinPhanHoi);

		return chiTietThongTinPhanHoi;
	}

	protected ChiTietThongTinPhanHoi toUnwrappedModel(
		ChiTietThongTinPhanHoi chiTietThongTinPhanHoi) {
		if (chiTietThongTinPhanHoi instanceof ChiTietThongTinPhanHoiImpl) {
			return chiTietThongTinPhanHoi;
		}

		ChiTietThongTinPhanHoiImpl chiTietThongTinPhanHoiImpl = new ChiTietThongTinPhanHoiImpl();

		chiTietThongTinPhanHoiImpl.setNew(chiTietThongTinPhanHoi.isNew());
		chiTietThongTinPhanHoiImpl.setPrimaryKey(chiTietThongTinPhanHoi.getPrimaryKey());

		chiTietThongTinPhanHoiImpl.setId(chiTietThongTinPhanHoi.getId());
		chiTietThongTinPhanHoiImpl.setThongTinPhanHoiId(chiTietThongTinPhanHoi.getThongTinPhanHoiId());
		chiTietThongTinPhanHoiImpl.setMaTramCapNuoc(chiTietThongTinPhanHoi.getMaTramCapNuoc());
		chiTietThongTinPhanHoiImpl.setNoiDungKhacNuoc(chiTietThongTinPhanHoi.getNoiDungKhacNuoc());
		chiTietThongTinPhanHoiImpl.setNoiDungKhacVeSinh(chiTietThongTinPhanHoi.getNoiDungKhacVeSinh());
		chiTietThongTinPhanHoiImpl.setMaThongTinPhanAnh(chiTietThongTinPhanHoi.getMaThongTinPhanAnh());
		chiTietThongTinPhanHoiImpl.setYeuCauGiaiTrinhId(chiTietThongTinPhanHoi.getYeuCauGiaiTrinhId());

		return chiTietThongTinPhanHoiImpl;
	}

	/**
	 * Returns the chi tiet thong tin phan hoi with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the chi tiet thong tin phan hoi
	 * @return the chi tiet thong tin phan hoi
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchChiTietThongTinPhanHoiException if a chi tiet thong tin phan hoi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietThongTinPhanHoi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChiTietThongTinPhanHoiException, SystemException {
		ChiTietThongTinPhanHoi chiTietThongTinPhanHoi = fetchByPrimaryKey(primaryKey);

		if (chiTietThongTinPhanHoi == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchChiTietThongTinPhanHoiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return chiTietThongTinPhanHoi;
	}

	/**
	 * Returns the chi tiet thong tin phan hoi with the primary key or throws a {@link vn.dtt.ns.thongtinphanhoi.dao.NoSuchChiTietThongTinPhanHoiException} if it could not be found.
	 *
	 * @param id the primary key of the chi tiet thong tin phan hoi
	 * @return the chi tiet thong tin phan hoi
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchChiTietThongTinPhanHoiException if a chi tiet thong tin phan hoi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietThongTinPhanHoi findByPrimaryKey(long id)
		throws NoSuchChiTietThongTinPhanHoiException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the chi tiet thong tin phan hoi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the chi tiet thong tin phan hoi
	 * @return the chi tiet thong tin phan hoi, or <code>null</code> if a chi tiet thong tin phan hoi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietThongTinPhanHoi fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ChiTietThongTinPhanHoi chiTietThongTinPhanHoi = (ChiTietThongTinPhanHoi)EntityCacheUtil.getResult(ChiTietThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
				ChiTietThongTinPhanHoiImpl.class, primaryKey);

		if (chiTietThongTinPhanHoi == _nullChiTietThongTinPhanHoi) {
			return null;
		}

		if (chiTietThongTinPhanHoi == null) {
			Session session = null;

			try {
				session = openSession();

				chiTietThongTinPhanHoi = (ChiTietThongTinPhanHoi)session.get(ChiTietThongTinPhanHoiImpl.class,
						primaryKey);

				if (chiTietThongTinPhanHoi != null) {
					cacheResult(chiTietThongTinPhanHoi);
				}
				else {
					EntityCacheUtil.putResult(ChiTietThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
						ChiTietThongTinPhanHoiImpl.class, primaryKey,
						_nullChiTietThongTinPhanHoi);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ChiTietThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
					ChiTietThongTinPhanHoiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return chiTietThongTinPhanHoi;
	}

	/**
	 * Returns the chi tiet thong tin phan hoi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the chi tiet thong tin phan hoi
	 * @return the chi tiet thong tin phan hoi, or <code>null</code> if a chi tiet thong tin phan hoi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChiTietThongTinPhanHoi fetchByPrimaryKey(long id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the chi tiet thong tin phan hois.
	 *
	 * @return the chi tiet thong tin phan hois
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChiTietThongTinPhanHoi> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ChiTietThongTinPhanHoi> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<ChiTietThongTinPhanHoi> findAll(int start, int end,
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

		List<ChiTietThongTinPhanHoi> list = (List<ChiTietThongTinPhanHoi>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CHITIETTHONGTINPHANHOI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CHITIETTHONGTINPHANHOI;

				if (pagination) {
					sql = sql.concat(ChiTietThongTinPhanHoiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ChiTietThongTinPhanHoi>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ChiTietThongTinPhanHoi>(list);
				}
				else {
					list = (List<ChiTietThongTinPhanHoi>)QueryUtil.list(q,
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
	 * Removes all the chi tiet thong tin phan hois from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ChiTietThongTinPhanHoi chiTietThongTinPhanHoi : findAll()) {
			remove(chiTietThongTinPhanHoi);
		}
	}

	/**
	 * Returns the number of chi tiet thong tin phan hois.
	 *
	 * @return the number of chi tiet thong tin phan hois
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

				Query q = session.createQuery(_SQL_COUNT_CHITIETTHONGTINPHANHOI);

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
	 * Initializes the chi tiet thong tin phan hoi persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ChiTietThongTinPhanHoi>> listenersList = new ArrayList<ModelListener<ChiTietThongTinPhanHoi>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ChiTietThongTinPhanHoi>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ChiTietThongTinPhanHoiImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CHITIETTHONGTINPHANHOI = "SELECT chiTietThongTinPhanHoi FROM ChiTietThongTinPhanHoi chiTietThongTinPhanHoi";
	private static final String _SQL_SELECT_CHITIETTHONGTINPHANHOI_WHERE = "SELECT chiTietThongTinPhanHoi FROM ChiTietThongTinPhanHoi chiTietThongTinPhanHoi WHERE ";
	private static final String _SQL_COUNT_CHITIETTHONGTINPHANHOI = "SELECT COUNT(chiTietThongTinPhanHoi) FROM ChiTietThongTinPhanHoi chiTietThongTinPhanHoi";
	private static final String _SQL_COUNT_CHITIETTHONGTINPHANHOI_WHERE = "SELECT COUNT(chiTietThongTinPhanHoi) FROM ChiTietThongTinPhanHoi chiTietThongTinPhanHoi WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "chiTietThongTinPhanHoi.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ChiTietThongTinPhanHoi exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ChiTietThongTinPhanHoi exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ChiTietThongTinPhanHoiPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"thongTinPhanHoiId", "maTramCapNuoc", "noiDungKhacNuoc",
				"noiDungKhacVeSinh", "maThongTinPhanAnh", "yeuCauGiaiTrinhId"
			});
	private static ChiTietThongTinPhanHoi _nullChiTietThongTinPhanHoi = new ChiTietThongTinPhanHoiImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ChiTietThongTinPhanHoi> toCacheModel() {
				return _nullChiTietThongTinPhanHoiCacheModel;
			}
		};

	private static CacheModel<ChiTietThongTinPhanHoi> _nullChiTietThongTinPhanHoiCacheModel =
		new CacheModel<ChiTietThongTinPhanHoi>() {
			@Override
			public ChiTietThongTinPhanHoi toEntityModel() {
				return _nullChiTietThongTinPhanHoi;
			}
		};
}