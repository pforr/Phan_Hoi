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

import vn.dtt.ns.thongtinphanhoi.dao.model.TrangThaiThongKePhanHoi;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TrangThaiThongKePhanHoi in entity cache.
 *
 * @author tubq
 * @see TrangThaiThongKePhanHoi
 * @generated
 */
public class TrangThaiThongKePhanHoiCacheModel implements CacheModel<TrangThaiThongKePhanHoi>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{id=");
		sb.append(id);
		sb.append(", maTinh=");
		sb.append(maTinh);
		sb.append(", thangNam=");
		sb.append(thangNam);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngayCapNhat=");
		sb.append(ngayCapNhat);
		sb.append(", nguoiChuyen=");
		sb.append(nguoiChuyen);
		sb.append(", nguoiCapNhat=");
		sb.append(nguoiCapNhat);
		sb.append(", daChuyenSangMinhBach=");
		sb.append(daChuyenSangMinhBach);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", version=");
		sb.append(version);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TrangThaiThongKePhanHoi toEntityModel() {
		TrangThaiThongKePhanHoiImpl trangThaiThongKePhanHoiImpl = new TrangThaiThongKePhanHoiImpl();

		trangThaiThongKePhanHoiImpl.setId(id);

		if (maTinh == null) {
			trangThaiThongKePhanHoiImpl.setMaTinh(StringPool.BLANK);
		}
		else {
			trangThaiThongKePhanHoiImpl.setMaTinh(maTinh);
		}

		if (thangNam == null) {
			trangThaiThongKePhanHoiImpl.setThangNam(StringPool.BLANK);
		}
		else {
			trangThaiThongKePhanHoiImpl.setThangNam(thangNam);
		}

		if (ngayTao == Long.MIN_VALUE) {
			trangThaiThongKePhanHoiImpl.setNgayTao(null);
		}
		else {
			trangThaiThongKePhanHoiImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngayCapNhat == Long.MIN_VALUE) {
			trangThaiThongKePhanHoiImpl.setNgayCapNhat(null);
		}
		else {
			trangThaiThongKePhanHoiImpl.setNgayCapNhat(new Date(ngayCapNhat));
		}

		if (nguoiChuyen == null) {
			trangThaiThongKePhanHoiImpl.setNguoiChuyen(StringPool.BLANK);
		}
		else {
			trangThaiThongKePhanHoiImpl.setNguoiChuyen(nguoiChuyen);
		}

		if (nguoiCapNhat == null) {
			trangThaiThongKePhanHoiImpl.setNguoiCapNhat(StringPool.BLANK);
		}
		else {
			trangThaiThongKePhanHoiImpl.setNguoiCapNhat(nguoiCapNhat);
		}

		trangThaiThongKePhanHoiImpl.setDaChuyenSangMinhBach(daChuyenSangMinhBach);
		trangThaiThongKePhanHoiImpl.setArticleId(articleId);
		trangThaiThongKePhanHoiImpl.setGroupId(groupId);
		trangThaiThongKePhanHoiImpl.setUserId(userId);

		if (version == null) {
			trangThaiThongKePhanHoiImpl.setVersion(StringPool.BLANK);
		}
		else {
			trangThaiThongKePhanHoiImpl.setVersion(version);
		}

		trangThaiThongKePhanHoiImpl.resetOriginalValues();

		return trangThaiThongKePhanHoiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		maTinh = objectInput.readUTF();
		thangNam = objectInput.readUTF();
		ngayTao = objectInput.readLong();
		ngayCapNhat = objectInput.readLong();
		nguoiChuyen = objectInput.readUTF();
		nguoiCapNhat = objectInput.readUTF();
		daChuyenSangMinhBach = objectInput.readInt();
		articleId = objectInput.readInt();
		groupId = objectInput.readInt();
		userId = objectInput.readInt();
		version = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (maTinh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(maTinh);
		}

		if (thangNam == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(thangNam);
		}

		objectOutput.writeLong(ngayTao);
		objectOutput.writeLong(ngayCapNhat);

		if (nguoiChuyen == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nguoiChuyen);
		}

		if (nguoiCapNhat == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nguoiCapNhat);
		}

		objectOutput.writeInt(daChuyenSangMinhBach);
		objectOutput.writeInt(articleId);
		objectOutput.writeInt(groupId);
		objectOutput.writeInt(userId);

		if (version == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(version);
		}
	}

	public long id;
	public String maTinh;
	public String thangNam;
	public long ngayTao;
	public long ngayCapNhat;
	public String nguoiChuyen;
	public String nguoiCapNhat;
	public int daChuyenSangMinhBach;
	public int articleId;
	public int groupId;
	public int userId;
	public String version;
}