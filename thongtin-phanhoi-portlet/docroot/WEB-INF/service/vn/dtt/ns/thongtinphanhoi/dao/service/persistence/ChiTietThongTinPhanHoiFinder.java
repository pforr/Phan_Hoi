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

/**
 * @author tubq
 */
public interface ChiTietThongTinPhanHoiFinder {
	public long countTopicPhanHoi(java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.lang.String topicCode, java.util.Date fromDate,
		java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi> searchTopicPhanHoi(
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.lang.String topicCode,
		java.util.Date fromDate, java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi> getAllTopicPhanHoi()
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countPhanHoiByTopicCode(java.lang.String topicCode,
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.lang.String feedbackCode,
		java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails> getTopicDetailsByTopicCode(
		java.lang.String topicCode, java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.lang.String feedbackCode, java.util.Date fromDate,
		java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countPhanHoiByMaThongTinPhanAnh(java.lang.String topicCode,
		java.lang.String feedbackCode, java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countPhanHoiGroupByFeedBackCode(java.lang.String topicCode,
		java.lang.String feedbackCode, java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails getTopicDetailsById(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	public long countPhanHoiByTrangThaiYcgt(int trangThaiYcgt,
		java.lang.String topicCode, java.lang.String feedbackCode,
		java.lang.String maTinh, java.lang.String maHuyen,
		java.lang.String maXa, java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails> getTopicDetailsByTrangThaiYcgt(
		int trangThaiYcgt, java.lang.String topicCode,
		java.lang.String feedbackCode, java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.util.Date fromDate, java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countPhanHoiByTrangThaiYcgtAndGroupByFeedbackCode(
		int trangThaiYcgt, java.lang.String topicCode,
		java.lang.String feedbackCode, java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.util.Date fromDate, java.util.Date toDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails> getTopicDetailsByTrangThaiYcgtAndGroupByFeedbackCode(
		int trangThaiYcgt, java.lang.String topicCode,
		java.lang.String feedbackCode, java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa,
		java.util.Date fromDate, java.util.Date toDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countTopicDetailsByYcgtId(long ycgtId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails> getTopicDetailsByYcgtId(
		long ycgtId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi> getChiTietThongTinPhanHoiBy_ttphId_thx(
		long thongTinPhanHoiId, java.lang.String maTinh,
		java.lang.String maHuyen, java.lang.String maXa)
		throws com.liferay.portal.kernel.exception.SystemException;
}