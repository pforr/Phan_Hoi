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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author tubq
 */
public class ChiTietThongTinPhanHoiFinderUtil {
	public static long countTopicPhanHoi(java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.lang.String topicCode, java.util.Date fromDate,
		java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countTopicPhanHoi(maTinh, maHuyen, maXa, topicCode,
			fromDate, toDate);
	}

	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi> searchTopicPhanHoi(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.lang.String topicCode,
		java.util.Date fromDate, java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .searchTopicPhanHoi(maTinh, maHuyen, maXa, topicCode,
			fromDate, toDate, start, end);
	}

	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi> getAllTopicPhanHoi()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getAllTopicPhanHoi();
	}

	public static long countPhanHoiByTopicCode(java.lang.String topicCode,
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.lang.String feedbackCode,
		java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countPhanHoiByTopicCode(topicCode, maTinh, maHuyen, maXa,
			feedbackCode, fromDate, toDate);
	}

	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails> getTopicDetailsByTopicCode(
		java.lang.String topicCode, java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.lang.String feedbackCode, java.util.Date fromDate,
		java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getTopicDetailsByTopicCode(topicCode, maTinh, maHuyen,
			maXa, feedbackCode, fromDate, toDate, start, end);
	}

	public static long countPhanHoiByMaThongTinPhanAnh(
		java.lang.String topicCode, java.lang.String feedbackCode,
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countPhanHoiByMaThongTinPhanAnh(topicCode, feedbackCode,
			maTinh, maHuyen, maXa, fromDate, toDate);
	}

	public static long countPhanHoiGroupByFeedBackCode(
		java.lang.String topicCode, java.lang.String feedbackCode,
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countPhanHoiGroupByFeedBackCode(topicCode, feedbackCode,
			maTinh, maHuyen, maXa, fromDate, toDate);
	}

	public static vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails getTopicDetailsById(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getTopicDetailsById(id);
	}

	public static long countPhanHoiByTrangThaiYcgt(int trangThaiYcgt,
		java.lang.String topicCode, java.lang.String feedbackCode,
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countPhanHoiByTrangThaiYcgt(trangThaiYcgt, topicCode,
			feedbackCode, maTinh, maHuyen, maXa, fromDate, toDate);
	}

	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails> getTopicDetailsByTrangThaiYcgt(
		int trangThaiYcgt, java.lang.String topicCode,
		java.lang.String feedbackCode, java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.util.Date fromDate, java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getTopicDetailsByTrangThaiYcgt(trangThaiYcgt, topicCode,
			feedbackCode, maTinh, maHuyen, maXa, fromDate, toDate, start, end);
	}

	public static long countPhanHoiByTrangThaiYcgtAndGroupByFeedbackCode(
		int trangThaiYcgt, java.lang.String topicCode,
		java.lang.String feedbackCode, java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countPhanHoiByTrangThaiYcgtAndGroupByFeedbackCode(trangThaiYcgt,
			topicCode, feedbackCode, maTinh, maHuyen, maXa, fromDate, toDate);
	}

	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails> getTopicDetailsByTrangThaiYcgtAndGroupByFeedbackCode(
		int trangThaiYcgt, java.lang.String topicCode,
		java.lang.String feedbackCode, java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.util.Date fromDate, java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getTopicDetailsByTrangThaiYcgtAndGroupByFeedbackCode(trangThaiYcgt,
			topicCode, feedbackCode, maTinh, maHuyen, maXa, fromDate, toDate,
			start, end);
	}

	public static long countTopicDetailsByYcgtId(long ycgtId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countTopicDetailsByYcgtId(ycgtId);
	}

	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails> getTopicDetailsByYcgtId(
		long ycgtId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getTopicDetailsByYcgtId(ycgtId, start, end);
	}

	public static java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi> getChiTietThongTinPhanHoiBy_ttphId_thx(
		long thongTinPhanHoiId, java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getChiTietThongTinPhanHoiBy_ttphId_thx(thongTinPhanHoiId,
			maTinh, maHuyen, maXa);
	}

	public static ChiTietThongTinPhanHoiFinder getFinder() {
		if (_finder == null) {
			_finder = (ChiTietThongTinPhanHoiFinder)PortletBeanLocatorUtil.locate(vn.dtt.ns.thongtinphanhoi.dao.service.ClpSerializer.getServletContextName(),
					ChiTietThongTinPhanHoiFinder.class.getName());

			ReferenceRegistry.registerReference(ChiTietThongTinPhanHoiFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ChiTietThongTinPhanHoiFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ChiTietThongTinPhanHoiFinderUtil.class,
			"_finder");
	}

	private static ChiTietThongTinPhanHoiFinder _finder;
}