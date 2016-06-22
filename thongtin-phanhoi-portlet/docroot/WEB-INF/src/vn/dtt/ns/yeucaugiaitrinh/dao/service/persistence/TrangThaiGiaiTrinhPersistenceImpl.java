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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchTrangThaiGiaiTrinhException;
import vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh;
import vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.TrangThaiGiaiTrinhImpl;
import vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.TrangThaiGiaiTrinhModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the trang thai giai trinh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tubq
 * @see TrangThaiGiaiTrinhPersistence
 * @see TrangThaiGiaiTrinhUtil
 * @generated
 */
public class TrangThaiGiaiTrinhPersistenceImpl extends BasePersistenceImpl<TrangThaiGiaiTrinh>
	implements TrangThaiGiaiTrinhPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TrangThaiGiaiTrinhUtil} to access the trang thai giai trinh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TrangThaiGiaiTrinhImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TrangThaiGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiGiaiTrinhModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiGiaiTrinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TrangThaiGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiGiaiTrinhModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiGiaiTrinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TrangThaiGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiGiaiTrinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QUATRINHXULY =
		new FinderPath(TrangThaiGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiGiaiTrinhModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiGiaiTrinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByQuaTrinhXuLy",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUATRINHXULY =
		new FinderPath(TrangThaiGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiGiaiTrinhModelImpl.FINDER_CACHE_ENABLED,
			TrangThaiGiaiTrinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQuaTrinhXuLy",
			new String[] { Long.class.getName() },
			TrangThaiGiaiTrinhModelImpl.YEUCAUGIAITRINHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_QUATRINHXULY = new FinderPath(TrangThaiGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiGiaiTrinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQuaTrinhXuLy",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the trang thai giai trinhs where yeuCauGiaiTrinhId = &#63;.
	 *
	 * @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	 * @return the matching trang thai giai trinhs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrangThaiGiaiTrinh> findByQuaTrinhXuLy(long yeuCauGiaiTrinhId)
		throws SystemException {
		return findByQuaTrinhXuLy(yeuCauGiaiTrinhId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<TrangThaiGiaiTrinh> findByQuaTrinhXuLy(long yeuCauGiaiTrinhId,
		int start, int end) throws SystemException {
		return findByQuaTrinhXuLy(yeuCauGiaiTrinhId, start, end, null);
	}

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
	@Override
	public List<TrangThaiGiaiTrinh> findByQuaTrinhXuLy(long yeuCauGiaiTrinhId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUATRINHXULY;
			finderArgs = new Object[] { yeuCauGiaiTrinhId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_QUATRINHXULY;
			finderArgs = new Object[] {
					yeuCauGiaiTrinhId,
					
					start, end, orderByComparator
				};
		}

		List<TrangThaiGiaiTrinh> list = (List<TrangThaiGiaiTrinh>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TrangThaiGiaiTrinh trangThaiGiaiTrinh : list) {
				if ((yeuCauGiaiTrinhId != trangThaiGiaiTrinh.getYeuCauGiaiTrinhId())) {
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

			query.append(_SQL_SELECT_TRANGTHAIGIAITRINH_WHERE);

			query.append(_FINDER_COLUMN_QUATRINHXULY_YEUCAUGIAITRINHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TrangThaiGiaiTrinhModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(yeuCauGiaiTrinhId);

				if (!pagination) {
					list = (List<TrangThaiGiaiTrinh>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TrangThaiGiaiTrinh>(list);
				}
				else {
					list = (List<TrangThaiGiaiTrinh>)QueryUtil.list(q,
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
	 * Returns the first trang thai giai trinh in the ordered set where yeuCauGiaiTrinhId = &#63;.
	 *
	 * @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trang thai giai trinh
	 * @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchTrangThaiGiaiTrinhException if a matching trang thai giai trinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiGiaiTrinh findByQuaTrinhXuLy_First(long yeuCauGiaiTrinhId,
		OrderByComparator orderByComparator)
		throws NoSuchTrangThaiGiaiTrinhException, SystemException {
		TrangThaiGiaiTrinh trangThaiGiaiTrinh = fetchByQuaTrinhXuLy_First(yeuCauGiaiTrinhId,
				orderByComparator);

		if (trangThaiGiaiTrinh != null) {
			return trangThaiGiaiTrinh;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("yeuCauGiaiTrinhId=");
		msg.append(yeuCauGiaiTrinhId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrangThaiGiaiTrinhException(msg.toString());
	}

	/**
	 * Returns the first trang thai giai trinh in the ordered set where yeuCauGiaiTrinhId = &#63;.
	 *
	 * @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trang thai giai trinh, or <code>null</code> if a matching trang thai giai trinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiGiaiTrinh fetchByQuaTrinhXuLy_First(
		long yeuCauGiaiTrinhId, OrderByComparator orderByComparator)
		throws SystemException {
		List<TrangThaiGiaiTrinh> list = findByQuaTrinhXuLy(yeuCauGiaiTrinhId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trang thai giai trinh in the ordered set where yeuCauGiaiTrinhId = &#63;.
	 *
	 * @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trang thai giai trinh
	 * @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchTrangThaiGiaiTrinhException if a matching trang thai giai trinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiGiaiTrinh findByQuaTrinhXuLy_Last(long yeuCauGiaiTrinhId,
		OrderByComparator orderByComparator)
		throws NoSuchTrangThaiGiaiTrinhException, SystemException {
		TrangThaiGiaiTrinh trangThaiGiaiTrinh = fetchByQuaTrinhXuLy_Last(yeuCauGiaiTrinhId,
				orderByComparator);

		if (trangThaiGiaiTrinh != null) {
			return trangThaiGiaiTrinh;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("yeuCauGiaiTrinhId=");
		msg.append(yeuCauGiaiTrinhId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrangThaiGiaiTrinhException(msg.toString());
	}

	/**
	 * Returns the last trang thai giai trinh in the ordered set where yeuCauGiaiTrinhId = &#63;.
	 *
	 * @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trang thai giai trinh, or <code>null</code> if a matching trang thai giai trinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiGiaiTrinh fetchByQuaTrinhXuLy_Last(long yeuCauGiaiTrinhId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByQuaTrinhXuLy(yeuCauGiaiTrinhId);

		if (count == 0) {
			return null;
		}

		List<TrangThaiGiaiTrinh> list = findByQuaTrinhXuLy(yeuCauGiaiTrinhId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public TrangThaiGiaiTrinh[] findByQuaTrinhXuLy_PrevAndNext(long id,
		long yeuCauGiaiTrinhId, OrderByComparator orderByComparator)
		throws NoSuchTrangThaiGiaiTrinhException, SystemException {
		TrangThaiGiaiTrinh trangThaiGiaiTrinh = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TrangThaiGiaiTrinh[] array = new TrangThaiGiaiTrinhImpl[3];

			array[0] = getByQuaTrinhXuLy_PrevAndNext(session,
					trangThaiGiaiTrinh, yeuCauGiaiTrinhId, orderByComparator,
					true);

			array[1] = trangThaiGiaiTrinh;

			array[2] = getByQuaTrinhXuLy_PrevAndNext(session,
					trangThaiGiaiTrinh, yeuCauGiaiTrinhId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TrangThaiGiaiTrinh getByQuaTrinhXuLy_PrevAndNext(
		Session session, TrangThaiGiaiTrinh trangThaiGiaiTrinh,
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

		query.append(_SQL_SELECT_TRANGTHAIGIAITRINH_WHERE);

		query.append(_FINDER_COLUMN_QUATRINHXULY_YEUCAUGIAITRINHID_2);

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
			query.append(TrangThaiGiaiTrinhModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(yeuCauGiaiTrinhId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(trangThaiGiaiTrinh);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TrangThaiGiaiTrinh> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trang thai giai trinhs where yeuCauGiaiTrinhId = &#63; from the database.
	 *
	 * @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByQuaTrinhXuLy(long yeuCauGiaiTrinhId)
		throws SystemException {
		for (TrangThaiGiaiTrinh trangThaiGiaiTrinh : findByQuaTrinhXuLy(
				yeuCauGiaiTrinhId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(trangThaiGiaiTrinh);
		}
	}

	/**
	 * Returns the number of trang thai giai trinhs where yeuCauGiaiTrinhId = &#63;.
	 *
	 * @param yeuCauGiaiTrinhId the yeu cau giai trinh ID
	 * @return the number of matching trang thai giai trinhs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByQuaTrinhXuLy(long yeuCauGiaiTrinhId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_QUATRINHXULY;

		Object[] finderArgs = new Object[] { yeuCauGiaiTrinhId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TRANGTHAIGIAITRINH_WHERE);

			query.append(_FINDER_COLUMN_QUATRINHXULY_YEUCAUGIAITRINHID_2);

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

	private static final String _FINDER_COLUMN_QUATRINHXULY_YEUCAUGIAITRINHID_2 = "trangThaiGiaiTrinh.yeuCauGiaiTrinhId = ? AND trangThaiGiaiTrinh.userId is not null AND trangThaiGiaiTrinh.userId > 0";

	public TrangThaiGiaiTrinhPersistenceImpl() {
		setModelClass(TrangThaiGiaiTrinh.class);
	}

	/**
	 * Caches the trang thai giai trinh in the entity cache if it is enabled.
	 *
	 * @param trangThaiGiaiTrinh the trang thai giai trinh
	 */
	@Override
	public void cacheResult(TrangThaiGiaiTrinh trangThaiGiaiTrinh) {
		EntityCacheUtil.putResult(TrangThaiGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiGiaiTrinhImpl.class, trangThaiGiaiTrinh.getPrimaryKey(),
			trangThaiGiaiTrinh);

		trangThaiGiaiTrinh.resetOriginalValues();
	}

	/**
	 * Caches the trang thai giai trinhs in the entity cache if it is enabled.
	 *
	 * @param trangThaiGiaiTrinhs the trang thai giai trinhs
	 */
	@Override
	public void cacheResult(List<TrangThaiGiaiTrinh> trangThaiGiaiTrinhs) {
		for (TrangThaiGiaiTrinh trangThaiGiaiTrinh : trangThaiGiaiTrinhs) {
			if (EntityCacheUtil.getResult(
						TrangThaiGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
						TrangThaiGiaiTrinhImpl.class,
						trangThaiGiaiTrinh.getPrimaryKey()) == null) {
				cacheResult(trangThaiGiaiTrinh);
			}
			else {
				trangThaiGiaiTrinh.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all trang thai giai trinhs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TrangThaiGiaiTrinhImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TrangThaiGiaiTrinhImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the trang thai giai trinh.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TrangThaiGiaiTrinh trangThaiGiaiTrinh) {
		EntityCacheUtil.removeResult(TrangThaiGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiGiaiTrinhImpl.class, trangThaiGiaiTrinh.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TrangThaiGiaiTrinh> trangThaiGiaiTrinhs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TrangThaiGiaiTrinh trangThaiGiaiTrinh : trangThaiGiaiTrinhs) {
			EntityCacheUtil.removeResult(TrangThaiGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
				TrangThaiGiaiTrinhImpl.class, trangThaiGiaiTrinh.getPrimaryKey());
		}
	}

	/**
	 * Creates a new trang thai giai trinh with the primary key. Does not add the trang thai giai trinh to the database.
	 *
	 * @param id the primary key for the new trang thai giai trinh
	 * @return the new trang thai giai trinh
	 */
	@Override
	public TrangThaiGiaiTrinh create(long id) {
		TrangThaiGiaiTrinh trangThaiGiaiTrinh = new TrangThaiGiaiTrinhImpl();

		trangThaiGiaiTrinh.setNew(true);
		trangThaiGiaiTrinh.setPrimaryKey(id);

		return trangThaiGiaiTrinh;
	}

	/**
	 * Removes the trang thai giai trinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the trang thai giai trinh
	 * @return the trang thai giai trinh that was removed
	 * @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchTrangThaiGiaiTrinhException if a trang thai giai trinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiGiaiTrinh remove(long id)
		throws NoSuchTrangThaiGiaiTrinhException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the trang thai giai trinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the trang thai giai trinh
	 * @return the trang thai giai trinh that was removed
	 * @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchTrangThaiGiaiTrinhException if a trang thai giai trinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiGiaiTrinh remove(Serializable primaryKey)
		throws NoSuchTrangThaiGiaiTrinhException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TrangThaiGiaiTrinh trangThaiGiaiTrinh = (TrangThaiGiaiTrinh)session.get(TrangThaiGiaiTrinhImpl.class,
					primaryKey);

			if (trangThaiGiaiTrinh == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTrangThaiGiaiTrinhException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(trangThaiGiaiTrinh);
		}
		catch (NoSuchTrangThaiGiaiTrinhException nsee) {
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
	protected TrangThaiGiaiTrinh removeImpl(
		TrangThaiGiaiTrinh trangThaiGiaiTrinh) throws SystemException {
		trangThaiGiaiTrinh = toUnwrappedModel(trangThaiGiaiTrinh);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(trangThaiGiaiTrinh)) {
				trangThaiGiaiTrinh = (TrangThaiGiaiTrinh)session.get(TrangThaiGiaiTrinhImpl.class,
						trangThaiGiaiTrinh.getPrimaryKeyObj());
			}

			if (trangThaiGiaiTrinh != null) {
				session.delete(trangThaiGiaiTrinh);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (trangThaiGiaiTrinh != null) {
			clearCache(trangThaiGiaiTrinh);
		}

		return trangThaiGiaiTrinh;
	}

	@Override
	public TrangThaiGiaiTrinh updateImpl(
		vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh trangThaiGiaiTrinh)
		throws SystemException {
		trangThaiGiaiTrinh = toUnwrappedModel(trangThaiGiaiTrinh);

		boolean isNew = trangThaiGiaiTrinh.isNew();

		TrangThaiGiaiTrinhModelImpl trangThaiGiaiTrinhModelImpl = (TrangThaiGiaiTrinhModelImpl)trangThaiGiaiTrinh;

		Session session = null;

		try {
			session = openSession();

			if (trangThaiGiaiTrinh.isNew()) {
				session.save(trangThaiGiaiTrinh);

				trangThaiGiaiTrinh.setNew(false);
			}
			else {
				session.merge(trangThaiGiaiTrinh);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TrangThaiGiaiTrinhModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((trangThaiGiaiTrinhModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUATRINHXULY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trangThaiGiaiTrinhModelImpl.getOriginalYeuCauGiaiTrinhId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUATRINHXULY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUATRINHXULY,
					args);

				args = new Object[] {
						trangThaiGiaiTrinhModelImpl.getYeuCauGiaiTrinhId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUATRINHXULY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUATRINHXULY,
					args);
			}
		}

		EntityCacheUtil.putResult(TrangThaiGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			TrangThaiGiaiTrinhImpl.class, trangThaiGiaiTrinh.getPrimaryKey(),
			trangThaiGiaiTrinh);

		return trangThaiGiaiTrinh;
	}

	protected TrangThaiGiaiTrinh toUnwrappedModel(
		TrangThaiGiaiTrinh trangThaiGiaiTrinh) {
		if (trangThaiGiaiTrinh instanceof TrangThaiGiaiTrinhImpl) {
			return trangThaiGiaiTrinh;
		}

		TrangThaiGiaiTrinhImpl trangThaiGiaiTrinhImpl = new TrangThaiGiaiTrinhImpl();

		trangThaiGiaiTrinhImpl.setNew(trangThaiGiaiTrinh.isNew());
		trangThaiGiaiTrinhImpl.setPrimaryKey(trangThaiGiaiTrinh.getPrimaryKey());

		trangThaiGiaiTrinhImpl.setId(trangThaiGiaiTrinh.getId());
		trangThaiGiaiTrinhImpl.setYeuCauGiaiTrinhId(trangThaiGiaiTrinh.getYeuCauGiaiTrinhId());
		trangThaiGiaiTrinhImpl.setTrangThai(trangThaiGiaiTrinh.getTrangThai());
		trangThaiGiaiTrinhImpl.setGhiChuNguoiLap(trangThaiGiaiTrinh.getGhiChuNguoiLap());
		trangThaiGiaiTrinhImpl.setUserId(trangThaiGiaiTrinh.getUserId());
		trangThaiGiaiTrinhImpl.setNgayTao(trangThaiGiaiTrinh.getNgayTao());
		trangThaiGiaiTrinhImpl.setNgayCapNhat(trangThaiGiaiTrinh.getNgayCapNhat());
		trangThaiGiaiTrinhImpl.setGhiChuNguoiDuyet(trangThaiGiaiTrinh.getGhiChuNguoiDuyet());

		return trangThaiGiaiTrinhImpl;
	}

	/**
	 * Returns the trang thai giai trinh with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the trang thai giai trinh
	 * @return the trang thai giai trinh
	 * @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchTrangThaiGiaiTrinhException if a trang thai giai trinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiGiaiTrinh findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTrangThaiGiaiTrinhException, SystemException {
		TrangThaiGiaiTrinh trangThaiGiaiTrinh = fetchByPrimaryKey(primaryKey);

		if (trangThaiGiaiTrinh == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTrangThaiGiaiTrinhException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return trangThaiGiaiTrinh;
	}

	/**
	 * Returns the trang thai giai trinh with the primary key or throws a {@link vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchTrangThaiGiaiTrinhException} if it could not be found.
	 *
	 * @param id the primary key of the trang thai giai trinh
	 * @return the trang thai giai trinh
	 * @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchTrangThaiGiaiTrinhException if a trang thai giai trinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiGiaiTrinh findByPrimaryKey(long id)
		throws NoSuchTrangThaiGiaiTrinhException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the trang thai giai trinh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the trang thai giai trinh
	 * @return the trang thai giai trinh, or <code>null</code> if a trang thai giai trinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiGiaiTrinh fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TrangThaiGiaiTrinh trangThaiGiaiTrinh = (TrangThaiGiaiTrinh)EntityCacheUtil.getResult(TrangThaiGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
				TrangThaiGiaiTrinhImpl.class, primaryKey);

		if (trangThaiGiaiTrinh == _nullTrangThaiGiaiTrinh) {
			return null;
		}

		if (trangThaiGiaiTrinh == null) {
			Session session = null;

			try {
				session = openSession();

				trangThaiGiaiTrinh = (TrangThaiGiaiTrinh)session.get(TrangThaiGiaiTrinhImpl.class,
						primaryKey);

				if (trangThaiGiaiTrinh != null) {
					cacheResult(trangThaiGiaiTrinh);
				}
				else {
					EntityCacheUtil.putResult(TrangThaiGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
						TrangThaiGiaiTrinhImpl.class, primaryKey,
						_nullTrangThaiGiaiTrinh);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TrangThaiGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
					TrangThaiGiaiTrinhImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return trangThaiGiaiTrinh;
	}

	/**
	 * Returns the trang thai giai trinh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the trang thai giai trinh
	 * @return the trang thai giai trinh, or <code>null</code> if a trang thai giai trinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TrangThaiGiaiTrinh fetchByPrimaryKey(long id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the trang thai giai trinhs.
	 *
	 * @return the trang thai giai trinhs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TrangThaiGiaiTrinh> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<TrangThaiGiaiTrinh> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<TrangThaiGiaiTrinh> findAll(int start, int end,
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

		List<TrangThaiGiaiTrinh> list = (List<TrangThaiGiaiTrinh>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TRANGTHAIGIAITRINH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRANGTHAIGIAITRINH;

				if (pagination) {
					sql = sql.concat(TrangThaiGiaiTrinhModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TrangThaiGiaiTrinh>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TrangThaiGiaiTrinh>(list);
				}
				else {
					list = (List<TrangThaiGiaiTrinh>)QueryUtil.list(q,
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
	 * Removes all the trang thai giai trinhs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TrangThaiGiaiTrinh trangThaiGiaiTrinh : findAll()) {
			remove(trangThaiGiaiTrinh);
		}
	}

	/**
	 * Returns the number of trang thai giai trinhs.
	 *
	 * @return the number of trang thai giai trinhs
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

				Query q = session.createQuery(_SQL_COUNT_TRANGTHAIGIAITRINH);

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
	 * Initializes the trang thai giai trinh persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TrangThaiGiaiTrinh>> listenersList = new ArrayList<ModelListener<TrangThaiGiaiTrinh>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TrangThaiGiaiTrinh>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TrangThaiGiaiTrinhImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TRANGTHAIGIAITRINH = "SELECT trangThaiGiaiTrinh FROM TrangThaiGiaiTrinh trangThaiGiaiTrinh";
	private static final String _SQL_SELECT_TRANGTHAIGIAITRINH_WHERE = "SELECT trangThaiGiaiTrinh FROM TrangThaiGiaiTrinh trangThaiGiaiTrinh WHERE ";
	private static final String _SQL_COUNT_TRANGTHAIGIAITRINH = "SELECT COUNT(trangThaiGiaiTrinh) FROM TrangThaiGiaiTrinh trangThaiGiaiTrinh";
	private static final String _SQL_COUNT_TRANGTHAIGIAITRINH_WHERE = "SELECT COUNT(trangThaiGiaiTrinh) FROM TrangThaiGiaiTrinh trangThaiGiaiTrinh WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "trangThaiGiaiTrinh.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TrangThaiGiaiTrinh exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TrangThaiGiaiTrinh exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TrangThaiGiaiTrinhPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"yeuCauGiaiTrinhId", "trangThai", "ghiChuNguoiLap", "ngayTao",
				"ngayCapNhat", "ghiChuNguoiDuyet"
			});
	private static TrangThaiGiaiTrinh _nullTrangThaiGiaiTrinh = new TrangThaiGiaiTrinhImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TrangThaiGiaiTrinh> toCacheModel() {
				return _nullTrangThaiGiaiTrinhCacheModel;
			}
		};

	private static CacheModel<TrangThaiGiaiTrinh> _nullTrangThaiGiaiTrinhCacheModel =
		new CacheModel<TrangThaiGiaiTrinh>() {
			@Override
			public TrangThaiGiaiTrinh toEntityModel() {
				return _nullTrangThaiGiaiTrinh;
			}
		};
}