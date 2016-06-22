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

package vn.dtt.ns.thongtinphanhoi.dao.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TopicPhanHoi in entity cache.
 *
 * @author tubq
 * @see TopicPhanHoi
 * @generated
 */
public class TopicPhanHoiCacheModel implements CacheModel<TopicPhanHoi>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{topicCode=");
		sb.append(topicCode);
		sb.append(", maTinh=");
		sb.append(maTinh);
		sb.append(", maHuyen=");
		sb.append(maHuyen);
		sb.append(", maXa=");
		sb.append(maXa);
		sb.append(", topicName=");
		sb.append(topicName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TopicPhanHoi toEntityModel() {
		TopicPhanHoiImpl topicPhanHoiImpl = new TopicPhanHoiImpl();

		if (topicCode == null) {
			topicPhanHoiImpl.setTopicCode(StringPool.BLANK);
		}
		else {
			topicPhanHoiImpl.setTopicCode(topicCode);
		}

		if (maTinh == null) {
			topicPhanHoiImpl.setMaTinh(StringPool.BLANK);
		}
		else {
			topicPhanHoiImpl.setMaTinh(maTinh);
		}

		if (maHuyen == null) {
			topicPhanHoiImpl.setMaHuyen(StringPool.BLANK);
		}
		else {
			topicPhanHoiImpl.setMaHuyen(maHuyen);
		}

		if (maXa == null) {
			topicPhanHoiImpl.setMaXa(StringPool.BLANK);
		}
		else {
			topicPhanHoiImpl.setMaXa(maXa);
		}

		if (topicName == null) {
			topicPhanHoiImpl.setTopicName(StringPool.BLANK);
		}
		else {
			topicPhanHoiImpl.setTopicName(topicName);
		}

		topicPhanHoiImpl.resetOriginalValues();

		return topicPhanHoiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		topicCode = objectInput.readUTF();
		maTinh = objectInput.readUTF();
		maHuyen = objectInput.readUTF();
		maXa = objectInput.readUTF();
		topicName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (topicCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(topicCode);
		}

		if (maTinh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(maTinh);
		}

		if (maHuyen == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(maHuyen);
		}

		if (maXa == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(maXa);
		}

		if (topicName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(topicName);
		}
	}

	public String topicCode;
	public String maTinh;
	public String maHuyen;
	public String maXa;
	public String topicName;
}