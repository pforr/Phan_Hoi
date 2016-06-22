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

import vn.dtt.ns.thongtinphanhoi.dao.NoSuchTopicDetailsException;
import vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails;
import vn.dtt.ns.thongtinphanhoi.dao.model.impl.TopicDetailsImpl;
import vn.dtt.ns.thongtinphanhoi.dao.model.impl.TopicDetailsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the topic details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tubq
 * @see TopicDetailsPersistence
 * @see TopicDetailsUtil
 * @generated
 */
public class TopicDetailsPersistenceImpl extends BasePersistenceImpl<TopicDetails>
	implements TopicDetailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TopicDetailsUtil} to access the topic details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TopicDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TopicDetailsModelImpl.ENTITY_CACHE_ENABLED,
			TopicDetailsModelImpl.FINDER_CACHE_ENABLED, TopicDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TopicDetailsModelImpl.ENTITY_CACHE_ENABLED,
			TopicDetailsModelImpl.FINDER_CACHE_ENABLED, TopicDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TopicDetailsModelImpl.ENTITY_CACHE_ENABLED,
			TopicDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public TopicDetailsPersistenceImpl() {
		setModelClass(TopicDetails.class);
	}

	/**
	 * Caches the topic details in the entity cache if it is enabled.
	 *
	 * @param topicDetails the topic details
	 */
	@Override
	public void cacheResult(TopicDetails topicDetails) {
		EntityCacheUtil.putResult(TopicDetailsModelImpl.ENTITY_CACHE_ENABLED,
			TopicDetailsImpl.class, topicDetails.getPrimaryKey(), topicDetails);

		topicDetails.resetOriginalValues();
	}

	/**
	 * Caches the topic detailses in the entity cache if it is enabled.
	 *
	 * @param topicDetailses the topic detailses
	 */
	@Override
	public void cacheResult(List<TopicDetails> topicDetailses) {
		for (TopicDetails topicDetails : topicDetailses) {
			if (EntityCacheUtil.getResult(
						TopicDetailsModelImpl.ENTITY_CACHE_ENABLED,
						TopicDetailsImpl.class, topicDetails.getPrimaryKey()) == null) {
				cacheResult(topicDetails);
			}
			else {
				topicDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all topic detailses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TopicDetailsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TopicDetailsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the topic details.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TopicDetails topicDetails) {
		EntityCacheUtil.removeResult(TopicDetailsModelImpl.ENTITY_CACHE_ENABLED,
			TopicDetailsImpl.class, topicDetails.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TopicDetails> topicDetailses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TopicDetails topicDetails : topicDetailses) {
			EntityCacheUtil.removeResult(TopicDetailsModelImpl.ENTITY_CACHE_ENABLED,
				TopicDetailsImpl.class, topicDetails.getPrimaryKey());
		}
	}

	/**
	 * Creates a new topic details with the primary key. Does not add the topic details to the database.
	 *
	 * @param id the primary key for the new topic details
	 * @return the new topic details
	 */
	@Override
	public TopicDetails create(long id) {
		TopicDetails topicDetails = new TopicDetailsImpl();

		topicDetails.setNew(true);
		topicDetails.setPrimaryKey(id);

		return topicDetails;
	}

	/**
	 * Removes the topic details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the topic details
	 * @return the topic details that was removed
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchTopicDetailsException if a topic details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TopicDetails remove(long id)
		throws NoSuchTopicDetailsException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the topic details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the topic details
	 * @return the topic details that was removed
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchTopicDetailsException if a topic details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TopicDetails remove(Serializable primaryKey)
		throws NoSuchTopicDetailsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TopicDetails topicDetails = (TopicDetails)session.get(TopicDetailsImpl.class,
					primaryKey);

			if (topicDetails == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTopicDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(topicDetails);
		}
		catch (NoSuchTopicDetailsException nsee) {
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
	protected TopicDetails removeImpl(TopicDetails topicDetails)
		throws SystemException {
		topicDetails = toUnwrappedModel(topicDetails);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(topicDetails)) {
				topicDetails = (TopicDetails)session.get(TopicDetailsImpl.class,
						topicDetails.getPrimaryKeyObj());
			}

			if (topicDetails != null) {
				session.delete(topicDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (topicDetails != null) {
			clearCache(topicDetails);
		}

		return topicDetails;
	}

	@Override
	public TopicDetails updateImpl(
		vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails topicDetails)
		throws SystemException {
		topicDetails = toUnwrappedModel(topicDetails);

		boolean isNew = topicDetails.isNew();

		Session session = null;

		try {
			session = openSession();

			if (topicDetails.isNew()) {
				session.save(topicDetails);

				topicDetails.setNew(false);
			}
			else {
				session.merge(topicDetails);
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

		EntityCacheUtil.putResult(TopicDetailsModelImpl.ENTITY_CACHE_ENABLED,
			TopicDetailsImpl.class, topicDetails.getPrimaryKey(), topicDetails);

		return topicDetails;
	}

	protected TopicDetails toUnwrappedModel(TopicDetails topicDetails) {
		if (topicDetails instanceof TopicDetailsImpl) {
			return topicDetails;
		}

		TopicDetailsImpl topicDetailsImpl = new TopicDetailsImpl();

		topicDetailsImpl.setNew(topicDetails.isNew());
		topicDetailsImpl.setPrimaryKey(topicDetails.getPrimaryKey());

		topicDetailsImpl.setId(topicDetails.getId());
		topicDetailsImpl.setSoDienThoai(topicDetails.getSoDienThoai());
		topicDetailsImpl.setThoiGianGoi(topicDetails.getThoiGianGoi());
		topicDetailsImpl.setTongDai(topicDetails.getTongDai());
		topicDetailsImpl.setMaTinh(topicDetails.getMaTinh());
		topicDetailsImpl.setMaHuyen(topicDetails.getMaHuyen());
		topicDetailsImpl.setMaXa(topicDetails.getMaXa());
		topicDetailsImpl.setMaTramCapNuoc(topicDetails.getMaTramCapNuoc());
		topicDetailsImpl.setMaThongTinPhanAnh(topicDetails.getMaThongTinPhanAnh());
		topicDetailsImpl.setNoiDungKhacNuoc(topicDetails.getNoiDungKhacNuoc());
		topicDetailsImpl.setNoiDungKhacVesinh(topicDetails.getNoiDungKhacVesinh());
		topicDetailsImpl.setYeuCauGiaiTrinhId(topicDetails.getYeuCauGiaiTrinhId());

		return topicDetailsImpl;
	}

	/**
	 * Returns the topic details with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the topic details
	 * @return the topic details
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchTopicDetailsException if a topic details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TopicDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTopicDetailsException, SystemException {
		TopicDetails topicDetails = fetchByPrimaryKey(primaryKey);

		if (topicDetails == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTopicDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return topicDetails;
	}

	/**
	 * Returns the topic details with the primary key or throws a {@link vn.dtt.ns.thongtinphanhoi.dao.NoSuchTopicDetailsException} if it could not be found.
	 *
	 * @param id the primary key of the topic details
	 * @return the topic details
	 * @throws vn.dtt.ns.thongtinphanhoi.dao.NoSuchTopicDetailsException if a topic details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TopicDetails findByPrimaryKey(long id)
		throws NoSuchTopicDetailsException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the topic details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the topic details
	 * @return the topic details, or <code>null</code> if a topic details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TopicDetails fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TopicDetails topicDetails = (TopicDetails)EntityCacheUtil.getResult(TopicDetailsModelImpl.ENTITY_CACHE_ENABLED,
				TopicDetailsImpl.class, primaryKey);

		if (topicDetails == _nullTopicDetails) {
			return null;
		}

		if (topicDetails == null) {
			Session session = null;

			try {
				session = openSession();

				topicDetails = (TopicDetails)session.get(TopicDetailsImpl.class,
						primaryKey);

				if (topicDetails != null) {
					cacheResult(topicDetails);
				}
				else {
					EntityCacheUtil.putResult(TopicDetailsModelImpl.ENTITY_CACHE_ENABLED,
						TopicDetailsImpl.class, primaryKey, _nullTopicDetails);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TopicDetailsModelImpl.ENTITY_CACHE_ENABLED,
					TopicDetailsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return topicDetails;
	}

	/**
	 * Returns the topic details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the topic details
	 * @return the topic details, or <code>null</code> if a topic details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TopicDetails fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the topic detailses.
	 *
	 * @return the topic detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TopicDetails> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the topic detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.thongtinphanhoi.dao.model.impl.TopicDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of topic detailses
	 * @param end the upper bound of the range of topic detailses (not inclusive)
	 * @return the range of topic detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TopicDetails> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the topic detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.dtt.ns.thongtinphanhoi.dao.model.impl.TopicDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of topic detailses
	 * @param end the upper bound of the range of topic detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of topic detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TopicDetails> findAll(int start, int end,
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

		List<TopicDetails> list = (List<TopicDetails>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TOPICDETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TOPICDETAILS;

				if (pagination) {
					sql = sql.concat(TopicDetailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TopicDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TopicDetails>(list);
				}
				else {
					list = (List<TopicDetails>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the topic detailses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TopicDetails topicDetails : findAll()) {
			remove(topicDetails);
		}
	}

	/**
	 * Returns the number of topic detailses.
	 *
	 * @return the number of topic detailses
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

				Query q = session.createQuery(_SQL_COUNT_TOPICDETAILS);

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
	 * Initializes the topic details persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TopicDetails>> listenersList = new ArrayList<ModelListener<TopicDetails>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TopicDetails>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TopicDetailsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TOPICDETAILS = "SELECT topicDetails FROM TopicDetails topicDetails";
	private static final String _SQL_COUNT_TOPICDETAILS = "SELECT COUNT(topicDetails) FROM TopicDetails topicDetails";
	private static final String _ORDER_BY_ENTITY_ALIAS = "topicDetails.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TopicDetails exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TopicDetailsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"soDienThoai", "thoiGianGoi", "tongDai", "maTinh", "maHuyen",
				"maXa", "maTramCapNuoc", "maThongTinPhanAnh", "noiDungKhacNuoc",
				"noiDungKhacVesinh", "yeuCauGiaiTrinhId"
			});
	private static TopicDetails _nullTopicDetails = new TopicDetailsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TopicDetails> toCacheModel() {
				return _nullTopicDetailsCacheModel;
			}
		};

	private static CacheModel<TopicDetails> _nullTopicDetailsCacheModel = new CacheModel<TopicDetails>() {
			@Override
			public TopicDetails toEntityModel() {
				return _nullTopicDetails;
			}
		};
}