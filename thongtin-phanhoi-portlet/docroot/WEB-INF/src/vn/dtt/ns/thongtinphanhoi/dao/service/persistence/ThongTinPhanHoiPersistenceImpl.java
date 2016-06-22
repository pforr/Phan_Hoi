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

import vn.dtt.ns.thongtinphanhoi.dao.NoSuchThongTinPhanHoiException;
import vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi;
import vn.dtt.ns.thongtinphanhoi.dao.model.impl.ThongTinPhanHoiImpl;
import vn.dtt.ns.thongtinphanhoi.dao.model.impl.ThongTinPhanHoiModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the thong tin phan hoi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tubq
 * @see ThongTinPhanHoiPersistence
 * @see ThongTinPhanHoiUtil
 * @generated
 */
public class ThongTinPhanHoiPersistenceImpl extends BasePersistenceImpl<ThongTinPhanHoi>
	implements ThongTinPhanHoiPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ThongTinPhanHoiUtil} to access the thong tin phan hoi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ThongTinPhanHoiImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinPhanHoiModelImpl.FINDER_CACHE_ENABLED,
			ThongTinPhanHoiImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinPhanHoiModelImpl.FINDER_CACHE_ENABLED,
			ThongTinPhanHoiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinPhanHoiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SODIENTHOAI =
		new FinderPath(ThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinPhanHoiModelImpl.FINDER_CACHE_ENABLED,
			ThongTinPhanHoiImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySoDienThoai",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SODIENTHOAI =
		new FinderPath(ThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinPhanHoiModelImpl.FINDER_CACHE_ENABLED,
			ThongTinPhanHoiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySoDienThoai",
			new String[] { String.class.getName() },
			ThongTinPhanHoiModelImpl.SODIENTHOAI_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SODIENTHOAI = new FinderPath(ThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinPhanHoiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySoDienThoai",
			new String[] { String.class.getName() });

	/**
	 * Returns all the thong tin phan hois where soDienThoai = &#63;.
	 *
	 * @param soDienThoai the so dien thoai
	 * @return the matching thong tin phan hois
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ThongTinPhanHoi> findBySoDienThoai(String soDienThoai)
		throws SystemException {
		return findBySoDienThoai(soDienThoai, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<ThongTinPhanHoi> findBySoDienThoai(String soDienThoai,
		int start, int end) throws SystemException {
		return findBySoDienThoai(soDienThoai, start, end, null);
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
	@Override
	public List<ThongTinPhanHoi> findBySoDienThoai(String soDienThoai,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SODIENTHOAI;
			finderArgs = new Object[] { soDienThoai };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SODIENTHOAI;
			finderArgs = new Object[] { soDienThoai, start, end, orderByComparator };
		}

		List<ThongTinPhanHoi> list = (List<ThongTinPhanHoi>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ThongTinPhanHoi thongTinPhanHoi : list) {
				if (!Validator.equals(soDienThoai,
							thongTinPhanHoi.getSoDienThoai())) {
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

			query.append(_SQL_SELECT_THONGTINPHANHOI_WHERE);

			boolean bindSoDienThoai = false;

			if (soDienThoai == null) {
				query.append(_FINDER_COLUMN_SODIENTHOAI_SODIENTHOAI_1);
			}
			else if (soDienThoai.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SODIENTHOAI_SODIENTHOAI_3);
			}
			else {
				bindSoDienThoai = true;

				query.append(_FINDER_COLUMN_SODIENTHOAI_SODIENTHOAI_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ThongTinPhanHoiModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSoDienThoai) {
					qPos.add(soDienThoai);
				}

				if (!pagination) {
					list = (List<ThongTinPhanHoi>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ThongTinPhanHoi>(list);
				}
				else {
					list = (List<ThongTinPhanHoi>)QueryUtil.list(q,
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
	 * Returns the first thong tin phan hoi in the ordered set where soDienThoai = &#63;.
	 *
	 * @param soDienThoai the so dien thoai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thong tin phan hoi
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchThongTinPhanHoiException if a matching thong tin phan hoi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ThongTinPhanHoi findBySoDienThoai_First(String soDienThoai,
		OrderByComparator orderByComparator)
		throws NoSuchThongTinPhanHoiException, SystemException {
		ThongTinPhanHoi thongTinPhanHoi = fetchBySoDienThoai_First(soDienThoai,
				orderByComparator);

		if (thongTinPhanHoi != null) {
			return thongTinPhanHoi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("soDienThoai=");
		msg.append(soDienThoai);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchThongTinPhanHoiException(msg.toString());
	}

	/**
	 * Returns the first thong tin phan hoi in the ordered set where soDienThoai = &#63;.
	 *
	 * @param soDienThoai the so dien thoai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thong tin phan hoi, or <code>null</code> if a matching thong tin phan hoi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ThongTinPhanHoi fetchBySoDienThoai_First(String soDienThoai,
		OrderByComparator orderByComparator) throws SystemException {
		List<ThongTinPhanHoi> list = findBySoDienThoai(soDienThoai, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ThongTinPhanHoi findBySoDienThoai_Last(String soDienThoai,
		OrderByComparator orderByComparator)
		throws NoSuchThongTinPhanHoiException, SystemException {
		ThongTinPhanHoi thongTinPhanHoi = fetchBySoDienThoai_Last(soDienThoai,
				orderByComparator);

		if (thongTinPhanHoi != null) {
			return thongTinPhanHoi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("soDienThoai=");
		msg.append(soDienThoai);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchThongTinPhanHoiException(msg.toString());
	}

	/**
	 * Returns the last thong tin phan hoi in the ordered set where soDienThoai = &#63;.
	 *
	 * @param soDienThoai the so dien thoai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching thong tin phan hoi, or <code>null</code> if a matching thong tin phan hoi could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ThongTinPhanHoi fetchBySoDienThoai_Last(String soDienThoai,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySoDienThoai(soDienThoai);

		if (count == 0) {
			return null;
		}

		List<ThongTinPhanHoi> list = findBySoDienThoai(soDienThoai, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ThongTinPhanHoi[] findBySoDienThoai_PrevAndNext(long id,
		String soDienThoai, OrderByComparator orderByComparator)
		throws NoSuchThongTinPhanHoiException, SystemException {
		ThongTinPhanHoi thongTinPhanHoi = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ThongTinPhanHoi[] array = new ThongTinPhanHoiImpl[3];

			array[0] = getBySoDienThoai_PrevAndNext(session, thongTinPhanHoi,
					soDienThoai, orderByComparator, true);

			array[1] = thongTinPhanHoi;

			array[2] = getBySoDienThoai_PrevAndNext(session, thongTinPhanHoi,
					soDienThoai, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ThongTinPhanHoi getBySoDienThoai_PrevAndNext(Session session,
		ThongTinPhanHoi thongTinPhanHoi, String soDienThoai,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_THONGTINPHANHOI_WHERE);

		boolean bindSoDienThoai = false;

		if (soDienThoai == null) {
			query.append(_FINDER_COLUMN_SODIENTHOAI_SODIENTHOAI_1);
		}
		else if (soDienThoai.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_SODIENTHOAI_SODIENTHOAI_3);
		}
		else {
			bindSoDienThoai = true;

			query.append(_FINDER_COLUMN_SODIENTHOAI_SODIENTHOAI_2);
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
			query.append(ThongTinPhanHoiModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindSoDienThoai) {
			qPos.add(soDienThoai);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(thongTinPhanHoi);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ThongTinPhanHoi> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the thong tin phan hois where soDienThoai = &#63; from the database.
	 *
	 * @param soDienThoai the so dien thoai
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySoDienThoai(String soDienThoai)
		throws SystemException {
		for (ThongTinPhanHoi thongTinPhanHoi : findBySoDienThoai(soDienThoai,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(thongTinPhanHoi);
		}
	}

	/**
	 * Returns the number of thong tin phan hois where soDienThoai = &#63;.
	 *
	 * @param soDienThoai the so dien thoai
	 * @return the number of matching thong tin phan hois
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySoDienThoai(String soDienThoai) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SODIENTHOAI;

		Object[] finderArgs = new Object[] { soDienThoai };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_THONGTINPHANHOI_WHERE);

			boolean bindSoDienThoai = false;

			if (soDienThoai == null) {
				query.append(_FINDER_COLUMN_SODIENTHOAI_SODIENTHOAI_1);
			}
			else if (soDienThoai.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SODIENTHOAI_SODIENTHOAI_3);
			}
			else {
				bindSoDienThoai = true;

				query.append(_FINDER_COLUMN_SODIENTHOAI_SODIENTHOAI_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSoDienThoai) {
					qPos.add(soDienThoai);
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

	private static final String _FINDER_COLUMN_SODIENTHOAI_SODIENTHOAI_1 = "thongTinPhanHoi.soDienThoai IS NULL";
	private static final String _FINDER_COLUMN_SODIENTHOAI_SODIENTHOAI_2 = "thongTinPhanHoi.soDienThoai = ?";
	private static final String _FINDER_COLUMN_SODIENTHOAI_SODIENTHOAI_3 = "(thongTinPhanHoi.soDienThoai IS NULL OR thongTinPhanHoi.soDienThoai = '')";

	public ThongTinPhanHoiPersistenceImpl() {
		setModelClass(ThongTinPhanHoi.class);
	}

	/**
	 * Caches the thong tin phan hoi in the entity cache if it is enabled.
	 *
	 * @param thongTinPhanHoi the thong tin phan hoi
	 */
	@Override
	public void cacheResult(ThongTinPhanHoi thongTinPhanHoi) {
		EntityCacheUtil.putResult(ThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinPhanHoiImpl.class, thongTinPhanHoi.getPrimaryKey(),
			thongTinPhanHoi);

		thongTinPhanHoi.resetOriginalValues();
	}

	/**
	 * Caches the thong tin phan hois in the entity cache if it is enabled.
	 *
	 * @param thongTinPhanHois the thong tin phan hois
	 */
	@Override
	public void cacheResult(List<ThongTinPhanHoi> thongTinPhanHois) {
		for (ThongTinPhanHoi thongTinPhanHoi : thongTinPhanHois) {
			if (EntityCacheUtil.getResult(
						ThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
						ThongTinPhanHoiImpl.class,
						thongTinPhanHoi.getPrimaryKey()) == null) {
				cacheResult(thongTinPhanHoi);
			}
			else {
				thongTinPhanHoi.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all thong tin phan hois.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ThongTinPhanHoiImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ThongTinPhanHoiImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the thong tin phan hoi.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ThongTinPhanHoi thongTinPhanHoi) {
		EntityCacheUtil.removeResult(ThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinPhanHoiImpl.class, thongTinPhanHoi.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ThongTinPhanHoi> thongTinPhanHois) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ThongTinPhanHoi thongTinPhanHoi : thongTinPhanHois) {
			EntityCacheUtil.removeResult(ThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
				ThongTinPhanHoiImpl.class, thongTinPhanHoi.getPrimaryKey());
		}
	}

	/**
	 * Creates a new thong tin phan hoi with the primary key. Does not add the thong tin phan hoi to the database.
	 *
	 * @param id the primary key for the new thong tin phan hoi
	 * @return the new thong tin phan hoi
	 */
	@Override
	public ThongTinPhanHoi create(long id) {
		ThongTinPhanHoi thongTinPhanHoi = new ThongTinPhanHoiImpl();

		thongTinPhanHoi.setNew(true);
		thongTinPhanHoi.setPrimaryKey(id);

		return thongTinPhanHoi;
	}

	/**
	 * Removes the thong tin phan hoi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the thong tin phan hoi
	 * @return the thong tin phan hoi that was removed
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchThongTinPhanHoiException if a thong tin phan hoi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ThongTinPhanHoi remove(long id)
		throws NoSuchThongTinPhanHoiException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the thong tin phan hoi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the thong tin phan hoi
	 * @return the thong tin phan hoi that was removed
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchThongTinPhanHoiException if a thong tin phan hoi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ThongTinPhanHoi remove(Serializable primaryKey)
		throws NoSuchThongTinPhanHoiException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ThongTinPhanHoi thongTinPhanHoi = (ThongTinPhanHoi)session.get(ThongTinPhanHoiImpl.class,
					primaryKey);

			if (thongTinPhanHoi == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchThongTinPhanHoiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(thongTinPhanHoi);
		}
		catch (NoSuchThongTinPhanHoiException nsee) {
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
	protected ThongTinPhanHoi removeImpl(ThongTinPhanHoi thongTinPhanHoi)
		throws SystemException {
		thongTinPhanHoi = toUnwrappedModel(thongTinPhanHoi);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(thongTinPhanHoi)) {
				thongTinPhanHoi = (ThongTinPhanHoi)session.get(ThongTinPhanHoiImpl.class,
						thongTinPhanHoi.getPrimaryKeyObj());
			}

			if (thongTinPhanHoi != null) {
				session.delete(thongTinPhanHoi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (thongTinPhanHoi != null) {
			clearCache(thongTinPhanHoi);
		}

		return thongTinPhanHoi;
	}

	@Override
	public ThongTinPhanHoi updateImpl(
		vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi thongTinPhanHoi)
		throws SystemException {
		thongTinPhanHoi = toUnwrappedModel(thongTinPhanHoi);

		boolean isNew = thongTinPhanHoi.isNew();

		ThongTinPhanHoiModelImpl thongTinPhanHoiModelImpl = (ThongTinPhanHoiModelImpl)thongTinPhanHoi;

		Session session = null;

		try {
			session = openSession();

			if (thongTinPhanHoi.isNew()) {
				session.save(thongTinPhanHoi);

				thongTinPhanHoi.setNew(false);
			}
			else {
				session.merge(thongTinPhanHoi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ThongTinPhanHoiModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((thongTinPhanHoiModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SODIENTHOAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						thongTinPhanHoiModelImpl.getOriginalSoDienThoai()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SODIENTHOAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SODIENTHOAI,
					args);

				args = new Object[] { thongTinPhanHoiModelImpl.getSoDienThoai() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SODIENTHOAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SODIENTHOAI,
					args);
			}
		}

		EntityCacheUtil.putResult(ThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
			ThongTinPhanHoiImpl.class, thongTinPhanHoi.getPrimaryKey(),
			thongTinPhanHoi);

		return thongTinPhanHoi;
	}

	protected ThongTinPhanHoi toUnwrappedModel(ThongTinPhanHoi thongTinPhanHoi) {
		if (thongTinPhanHoi instanceof ThongTinPhanHoiImpl) {
			return thongTinPhanHoi;
		}

		ThongTinPhanHoiImpl thongTinPhanHoiImpl = new ThongTinPhanHoiImpl();

		thongTinPhanHoiImpl.setNew(thongTinPhanHoi.isNew());
		thongTinPhanHoiImpl.setPrimaryKey(thongTinPhanHoi.getPrimaryKey());

		thongTinPhanHoiImpl.setId(thongTinPhanHoi.getId());
		thongTinPhanHoiImpl.setSoDienThoai(thongTinPhanHoi.getSoDienThoai());
		thongTinPhanHoiImpl.setThoiGianGoi(thongTinPhanHoi.getThoiGianGoi());
		thongTinPhanHoiImpl.setTrangThaiGiaoDich(thongTinPhanHoi.getTrangThaiGiaoDich());
		thongTinPhanHoiImpl.setTongDai(thongTinPhanHoi.getTongDai());
		thongTinPhanHoiImpl.setMaTinh(thongTinPhanHoi.getMaTinh());
		thongTinPhanHoiImpl.setMaHuyen(thongTinPhanHoi.getMaHuyen());
		thongTinPhanHoiImpl.setMaXa(thongTinPhanHoi.getMaXa());

		return thongTinPhanHoiImpl;
	}

	/**
	 * Returns the thong tin phan hoi with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the thong tin phan hoi
	 * @return the thong tin phan hoi
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchThongTinPhanHoiException if a thong tin phan hoi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ThongTinPhanHoi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchThongTinPhanHoiException, SystemException {
		ThongTinPhanHoi thongTinPhanHoi = fetchByPrimaryKey(primaryKey);

		if (thongTinPhanHoi == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchThongTinPhanHoiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return thongTinPhanHoi;
	}

	/**
	 * Returns the thong tin phan hoi with the primary key or throws a {@link vn.dtt.ns.thongtinphanhoi.dao.NoSuchThongTinPhanHoiException} if it could not be found.
	 *
	 * @param id the primary key of the thong tin phan hoi
	 * @return the thong tin phan hoi
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchThongTinPhanHoiException if a thong tin phan hoi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ThongTinPhanHoi findByPrimaryKey(long id)
		throws NoSuchThongTinPhanHoiException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the thong tin phan hoi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the thong tin phan hoi
	 * @return the thong tin phan hoi, or <code>null</code> if a thong tin phan hoi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ThongTinPhanHoi fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ThongTinPhanHoi thongTinPhanHoi = (ThongTinPhanHoi)EntityCacheUtil.getResult(ThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
				ThongTinPhanHoiImpl.class, primaryKey);

		if (thongTinPhanHoi == _nullThongTinPhanHoi) {
			return null;
		}

		if (thongTinPhanHoi == null) {
			Session session = null;

			try {
				session = openSession();

				thongTinPhanHoi = (ThongTinPhanHoi)session.get(ThongTinPhanHoiImpl.class,
						primaryKey);

				if (thongTinPhanHoi != null) {
					cacheResult(thongTinPhanHoi);
				}
				else {
					EntityCacheUtil.putResult(ThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
						ThongTinPhanHoiImpl.class, primaryKey,
						_nullThongTinPhanHoi);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ThongTinPhanHoiModelImpl.ENTITY_CACHE_ENABLED,
					ThongTinPhanHoiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return thongTinPhanHoi;
	}

	/**
	 * Returns the thong tin phan hoi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the thong tin phan hoi
	 * @return the thong tin phan hoi, or <code>null</code> if a thong tin phan hoi with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ThongTinPhanHoi fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the thong tin phan hois.
	 *
	 * @return the thong tin phan hois
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ThongTinPhanHoi> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ThongTinPhanHoi> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<ThongTinPhanHoi> findAll(int start, int end,
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

		List<ThongTinPhanHoi> list = (List<ThongTinPhanHoi>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_THONGTINPHANHOI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_THONGTINPHANHOI;

				if (pagination) {
					sql = sql.concat(ThongTinPhanHoiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ThongTinPhanHoi>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ThongTinPhanHoi>(list);
				}
				else {
					list = (List<ThongTinPhanHoi>)QueryUtil.list(q,
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
	 * Removes all the thong tin phan hois from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ThongTinPhanHoi thongTinPhanHoi : findAll()) {
			remove(thongTinPhanHoi);
		}
	}

	/**
	 * Returns the number of thong tin phan hois.
	 *
	 * @return the number of thong tin phan hois
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

				Query q = session.createQuery(_SQL_COUNT_THONGTINPHANHOI);

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
	 * Initializes the thong tin phan hoi persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ThongTinPhanHoi>> listenersList = new ArrayList<ModelListener<ThongTinPhanHoi>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ThongTinPhanHoi>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ThongTinPhanHoiImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_THONGTINPHANHOI = "SELECT thongTinPhanHoi FROM ThongTinPhanHoi thongTinPhanHoi";
	private static final String _SQL_SELECT_THONGTINPHANHOI_WHERE = "SELECT thongTinPhanHoi FROM ThongTinPhanHoi thongTinPhanHoi WHERE ";
	private static final String _SQL_COUNT_THONGTINPHANHOI = "SELECT COUNT(thongTinPhanHoi) FROM ThongTinPhanHoi thongTinPhanHoi";
	private static final String _SQL_COUNT_THONGTINPHANHOI_WHERE = "SELECT COUNT(thongTinPhanHoi) FROM ThongTinPhanHoi thongTinPhanHoi WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "thongTinPhanHoi.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ThongTinPhanHoi exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ThongTinPhanHoi exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ThongTinPhanHoiPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"soDienThoai", "thoiGianGoi", "trangThaiGiaoDich", "tongDai",
				"maTinh", "maHuyen", "maXa"
			});
	private static ThongTinPhanHoi _nullThongTinPhanHoi = new ThongTinPhanHoiImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ThongTinPhanHoi> toCacheModel() {
				return _nullThongTinPhanHoiCacheModel;
			}
		};

	private static CacheModel<ThongTinPhanHoi> _nullThongTinPhanHoiCacheModel = new CacheModel<ThongTinPhanHoi>() {
			@Override
			public ThongTinPhanHoi toEntityModel() {
				return _nullThongTinPhanHoi;
			}
		};
}