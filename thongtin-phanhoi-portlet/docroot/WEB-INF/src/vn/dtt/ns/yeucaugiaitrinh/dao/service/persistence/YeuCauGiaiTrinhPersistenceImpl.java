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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchYeuCauGiaiTrinhException;
import vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh;
import vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.YeuCauGiaiTrinhImpl;
import vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.YeuCauGiaiTrinhModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the yeu cau giai trinh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tubq
 * @see YeuCauGiaiTrinhPersistence
 * @see YeuCauGiaiTrinhUtil
 * @generated
 */
public class YeuCauGiaiTrinhPersistenceImpl extends BasePersistenceImpl<YeuCauGiaiTrinh>
	implements YeuCauGiaiTrinhPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link YeuCauGiaiTrinhUtil} to access the yeu cau giai trinh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = YeuCauGiaiTrinhImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(YeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauGiaiTrinhModelImpl.FINDER_CACHE_ENABLED,
			YeuCauGiaiTrinhImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(YeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauGiaiTrinhModelImpl.FINDER_CACHE_ENABLED,
			YeuCauGiaiTrinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(YeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauGiaiTrinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public YeuCauGiaiTrinhPersistenceImpl() {
		setModelClass(YeuCauGiaiTrinh.class);
	}

	/**
	 * Caches the yeu cau giai trinh in the entity cache if it is enabled.
	 *
	 * @param yeuCauGiaiTrinh the yeu cau giai trinh
	 */
	@Override
	public void cacheResult(YeuCauGiaiTrinh yeuCauGiaiTrinh) {
		EntityCacheUtil.putResult(YeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauGiaiTrinhImpl.class, yeuCauGiaiTrinh.getPrimaryKey(),
			yeuCauGiaiTrinh);

		yeuCauGiaiTrinh.resetOriginalValues();
	}

	/**
	 * Caches the yeu cau giai trinhs in the entity cache if it is enabled.
	 *
	 * @param yeuCauGiaiTrinhs the yeu cau giai trinhs
	 */
	@Override
	public void cacheResult(List<YeuCauGiaiTrinh> yeuCauGiaiTrinhs) {
		for (YeuCauGiaiTrinh yeuCauGiaiTrinh : yeuCauGiaiTrinhs) {
			if (EntityCacheUtil.getResult(
						YeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
						YeuCauGiaiTrinhImpl.class,
						yeuCauGiaiTrinh.getPrimaryKey()) == null) {
				cacheResult(yeuCauGiaiTrinh);
			}
			else {
				yeuCauGiaiTrinh.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all yeu cau giai trinhs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(YeuCauGiaiTrinhImpl.class.getName());
		}

		EntityCacheUtil.clearCache(YeuCauGiaiTrinhImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the yeu cau giai trinh.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(YeuCauGiaiTrinh yeuCauGiaiTrinh) {
		EntityCacheUtil.removeResult(YeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauGiaiTrinhImpl.class, yeuCauGiaiTrinh.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<YeuCauGiaiTrinh> yeuCauGiaiTrinhs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (YeuCauGiaiTrinh yeuCauGiaiTrinh : yeuCauGiaiTrinhs) {
			EntityCacheUtil.removeResult(YeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
				YeuCauGiaiTrinhImpl.class, yeuCauGiaiTrinh.getPrimaryKey());
		}
	}

	/**
	 * Creates a new yeu cau giai trinh with the primary key. Does not add the yeu cau giai trinh to the database.
	 *
	 * @param id the primary key for the new yeu cau giai trinh
	 * @return the new yeu cau giai trinh
	 */
	@Override
	public YeuCauGiaiTrinh create(long id) {
		YeuCauGiaiTrinh yeuCauGiaiTrinh = new YeuCauGiaiTrinhImpl();

		yeuCauGiaiTrinh.setNew(true);
		yeuCauGiaiTrinh.setPrimaryKey(id);

		return yeuCauGiaiTrinh;
	}

	/**
	 * Removes the yeu cau giai trinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the yeu cau giai trinh
	 * @return the yeu cau giai trinh that was removed
	 * @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchYeuCauGiaiTrinhException if a yeu cau giai trinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YeuCauGiaiTrinh remove(long id)
		throws NoSuchYeuCauGiaiTrinhException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the yeu cau giai trinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the yeu cau giai trinh
	 * @return the yeu cau giai trinh that was removed
	 * @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchYeuCauGiaiTrinhException if a yeu cau giai trinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YeuCauGiaiTrinh remove(Serializable primaryKey)
		throws NoSuchYeuCauGiaiTrinhException, SystemException {
		Session session = null;

		try {
			session = openSession();

			YeuCauGiaiTrinh yeuCauGiaiTrinh = (YeuCauGiaiTrinh)session.get(YeuCauGiaiTrinhImpl.class,
					primaryKey);

			if (yeuCauGiaiTrinh == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchYeuCauGiaiTrinhException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(yeuCauGiaiTrinh);
		}
		catch (NoSuchYeuCauGiaiTrinhException nsee) {
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
	protected YeuCauGiaiTrinh removeImpl(YeuCauGiaiTrinh yeuCauGiaiTrinh)
		throws SystemException {
		yeuCauGiaiTrinh = toUnwrappedModel(yeuCauGiaiTrinh);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(yeuCauGiaiTrinh)) {
				yeuCauGiaiTrinh = (YeuCauGiaiTrinh)session.get(YeuCauGiaiTrinhImpl.class,
						yeuCauGiaiTrinh.getPrimaryKeyObj());
			}

			if (yeuCauGiaiTrinh != null) {
				session.delete(yeuCauGiaiTrinh);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (yeuCauGiaiTrinh != null) {
			clearCache(yeuCauGiaiTrinh);
		}

		return yeuCauGiaiTrinh;
	}

	@Override
	public YeuCauGiaiTrinh updateImpl(
		vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh yeuCauGiaiTrinh)
		throws SystemException {
		yeuCauGiaiTrinh = toUnwrappedModel(yeuCauGiaiTrinh);

		boolean isNew = yeuCauGiaiTrinh.isNew();

		Session session = null;

		try {
			session = openSession();

			if (yeuCauGiaiTrinh.isNew()) {
				session.save(yeuCauGiaiTrinh);

				yeuCauGiaiTrinh.setNew(false);
			}
			else {
				session.merge(yeuCauGiaiTrinh);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(YeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
			YeuCauGiaiTrinhImpl.class, yeuCauGiaiTrinh.getPrimaryKey(),
			yeuCauGiaiTrinh);

		return yeuCauGiaiTrinh;
	}

	protected YeuCauGiaiTrinh toUnwrappedModel(YeuCauGiaiTrinh yeuCauGiaiTrinh) {
		if (yeuCauGiaiTrinh instanceof YeuCauGiaiTrinhImpl) {
			return yeuCauGiaiTrinh;
		}

		YeuCauGiaiTrinhImpl yeuCauGiaiTrinhImpl = new YeuCauGiaiTrinhImpl();

		yeuCauGiaiTrinhImpl.setNew(yeuCauGiaiTrinh.isNew());
		yeuCauGiaiTrinhImpl.setPrimaryKey(yeuCauGiaiTrinh.getPrimaryKey());

		yeuCauGiaiTrinhImpl.setId(yeuCauGiaiTrinh.getId());
		yeuCauGiaiTrinhImpl.setMaTinh(yeuCauGiaiTrinh.getMaTinh());
		yeuCauGiaiTrinhImpl.setMaHuyen(yeuCauGiaiTrinh.getMaHuyen());
		yeuCauGiaiTrinhImpl.setMaXa(yeuCauGiaiTrinh.getMaXa());
		yeuCauGiaiTrinhImpl.setMaChuDe(yeuCauGiaiTrinh.getMaChuDe());
		yeuCauGiaiTrinhImpl.setTrangThai(yeuCauGiaiTrinh.getTrangThai());
		yeuCauGiaiTrinhImpl.setSoLuongTheoChuDe(yeuCauGiaiTrinh.getSoLuongTheoChuDe());
		yeuCauGiaiTrinhImpl.setUserId(yeuCauGiaiTrinh.getUserId());
		yeuCauGiaiTrinhImpl.setNgayTao(yeuCauGiaiTrinh.getNgayTao());
		yeuCauGiaiTrinhImpl.setNgayCapNhat(yeuCauGiaiTrinh.getNgayCapNhat());
		yeuCauGiaiTrinhImpl.setNguoiPheDuyet(yeuCauGiaiTrinh.getNguoiPheDuyet());
		yeuCauGiaiTrinhImpl.setDaChuyenSangMinhBach(yeuCauGiaiTrinh.getDaChuyenSangMinhBach());
		yeuCauGiaiTrinhImpl.setMaYeuCauGiaiTrinh(yeuCauGiaiTrinh.getMaYeuCauGiaiTrinh());

		return yeuCauGiaiTrinhImpl;
	}

	/**
	 * Returns the yeu cau giai trinh with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the yeu cau giai trinh
	 * @return the yeu cau giai trinh
	 * @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchYeuCauGiaiTrinhException if a yeu cau giai trinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YeuCauGiaiTrinh findByPrimaryKey(Serializable primaryKey)
		throws NoSuchYeuCauGiaiTrinhException, SystemException {
		YeuCauGiaiTrinh yeuCauGiaiTrinh = fetchByPrimaryKey(primaryKey);

		if (yeuCauGiaiTrinh == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchYeuCauGiaiTrinhException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return yeuCauGiaiTrinh;
	}

	/**
	 * Returns the yeu cau giai trinh with the primary key or throws a {@link vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchYeuCauGiaiTrinhException} if it could not be found.
	 *
	 * @param id the primary key of the yeu cau giai trinh
	 * @return the yeu cau giai trinh
	 * @throws vn.dtt.ns.yeucaugiaitrinh.dao.NoSuchYeuCauGiaiTrinhException if a yeu cau giai trinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YeuCauGiaiTrinh findByPrimaryKey(long id)
		throws NoSuchYeuCauGiaiTrinhException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the yeu cau giai trinh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the yeu cau giai trinh
	 * @return the yeu cau giai trinh, or <code>null</code> if a yeu cau giai trinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YeuCauGiaiTrinh fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		YeuCauGiaiTrinh yeuCauGiaiTrinh = (YeuCauGiaiTrinh)EntityCacheUtil.getResult(YeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
				YeuCauGiaiTrinhImpl.class, primaryKey);

		if (yeuCauGiaiTrinh == _nullYeuCauGiaiTrinh) {
			return null;
		}

		if (yeuCauGiaiTrinh == null) {
			Session session = null;

			try {
				session = openSession();

				yeuCauGiaiTrinh = (YeuCauGiaiTrinh)session.get(YeuCauGiaiTrinhImpl.class,
						primaryKey);

				if (yeuCauGiaiTrinh != null) {
					cacheResult(yeuCauGiaiTrinh);
				}
				else {
					EntityCacheUtil.putResult(YeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
						YeuCauGiaiTrinhImpl.class, primaryKey,
						_nullYeuCauGiaiTrinh);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(YeuCauGiaiTrinhModelImpl.ENTITY_CACHE_ENABLED,
					YeuCauGiaiTrinhImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return yeuCauGiaiTrinh;
	}

	/**
	 * Returns the yeu cau giai trinh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the yeu cau giai trinh
	 * @return the yeu cau giai trinh, or <code>null</code> if a yeu cau giai trinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public YeuCauGiaiTrinh fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the yeu cau giai trinhs.
	 *
	 * @return the yeu cau giai trinhs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<YeuCauGiaiTrinh> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<YeuCauGiaiTrinh> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<YeuCauGiaiTrinh> findAll(int start, int end,
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

		List<YeuCauGiaiTrinh> list = (List<YeuCauGiaiTrinh>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_YEUCAUGIAITRINH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_YEUCAUGIAITRINH;

				if (pagination) {
					sql = sql.concat(YeuCauGiaiTrinhModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<YeuCauGiaiTrinh>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<YeuCauGiaiTrinh>(list);
				}
				else {
					list = (List<YeuCauGiaiTrinh>)QueryUtil.list(q,
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
	 * Removes all the yeu cau giai trinhs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (YeuCauGiaiTrinh yeuCauGiaiTrinh : findAll()) {
			remove(yeuCauGiaiTrinh);
		}
	}

	/**
	 * Returns the number of yeu cau giai trinhs.
	 *
	 * @return the number of yeu cau giai trinhs
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

				Query q = session.createQuery(_SQL_COUNT_YEUCAUGIAITRINH);

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
	 * Initializes the yeu cau giai trinh persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<YeuCauGiaiTrinh>> listenersList = new ArrayList<ModelListener<YeuCauGiaiTrinh>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<YeuCauGiaiTrinh>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(YeuCauGiaiTrinhImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_YEUCAUGIAITRINH = "SELECT yeuCauGiaiTrinh FROM YeuCauGiaiTrinh yeuCauGiaiTrinh";
	private static final String _SQL_COUNT_YEUCAUGIAITRINH = "SELECT COUNT(yeuCauGiaiTrinh) FROM YeuCauGiaiTrinh yeuCauGiaiTrinh";
	private static final String _ORDER_BY_ENTITY_ALIAS = "yeuCauGiaiTrinh.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No YeuCauGiaiTrinh exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(YeuCauGiaiTrinhPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"maTinh", "maHuyen", "maXa", "maChuDe", "trangThai",
				"soLuongTheoChuDe", "ngayTao", "ngayCapNhat", "nguoiPheDuyet",
				"daChuyenSangMinhBach", "maYeuCauGiaiTrinh"
			});
	private static YeuCauGiaiTrinh _nullYeuCauGiaiTrinh = new YeuCauGiaiTrinhImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<YeuCauGiaiTrinh> toCacheModel() {
				return _nullYeuCauGiaiTrinhCacheModel;
			}
		};

	private static CacheModel<YeuCauGiaiTrinh> _nullYeuCauGiaiTrinhCacheModel = new CacheModel<YeuCauGiaiTrinh>() {
			@Override
			public YeuCauGiaiTrinh toEntityModel() {
				return _nullYeuCauGiaiTrinh;
			}
		};
}