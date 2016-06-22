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

package vn.dtt.ns.yeucaugiaitrinh.dao.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TrangThaiGiaiTrinh in entity cache.
 *
 * @author tubq
 * @see TrangThaiGiaiTrinh
 * @generated
 */
public class TrangThaiGiaiTrinhCacheModel implements CacheModel<TrangThaiGiaiTrinh>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(id);
		sb.append(", yeuCauGiaiTrinhId=");
		sb.append(yeuCauGiaiTrinhId);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append(", ghiChuNguoiLap=");
		sb.append(ghiChuNguoiLap);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngayCapNhat=");
		sb.append(ngayCapNhat);
		sb.append(", ghiChuNguoiDuyet=");
		sb.append(ghiChuNguoiDuyet);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TrangThaiGiaiTrinh toEntityModel() {
		TrangThaiGiaiTrinhImpl trangThaiGiaiTrinhImpl = new TrangThaiGiaiTrinhImpl();

		trangThaiGiaiTrinhImpl.setId(id);
		trangThaiGiaiTrinhImpl.setYeuCauGiaiTrinhId(yeuCauGiaiTrinhId);
		trangThaiGiaiTrinhImpl.setTrangThai(trangThai);

		if (ghiChuNguoiLap == null) {
			trangThaiGiaiTrinhImpl.setGhiChuNguoiLap(StringPool.BLANK);
		}
		else {
			trangThaiGiaiTrinhImpl.setGhiChuNguoiLap(ghiChuNguoiLap);
		}

		trangThaiGiaiTrinhImpl.setUserId(userId);

		if (ngayTao == Long.MIN_VALUE) {
			trangThaiGiaiTrinhImpl.setNgayTao(null);
		}
		else {
			trangThaiGiaiTrinhImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngayCapNhat == Long.MIN_VALUE) {
			trangThaiGiaiTrinhImpl.setNgayCapNhat(null);
		}
		else {
			trangThaiGiaiTrinhImpl.setNgayCapNhat(new Date(ngayCapNhat));
		}

		if (ghiChuNguoiDuyet == null) {
			trangThaiGiaiTrinhImpl.setGhiChuNguoiDuyet(StringPool.BLANK);
		}
		else {
			trangThaiGiaiTrinhImpl.setGhiChuNguoiDuyet(ghiChuNguoiDuyet);
		}

		trangThaiGiaiTrinhImpl.resetOriginalValues();

		return trangThaiGiaiTrinhImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		yeuCauGiaiTrinhId = objectInput.readLong();
		trangThai = objectInput.readInt();
		ghiChuNguoiLap = objectInput.readUTF();
		userId = objectInput.readLong();
		ngayTao = objectInput.readLong();
		ngayCapNhat = objectInput.readLong();
		ghiChuNguoiDuyet = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(yeuCauGiaiTrinhId);
		objectOutput.writeInt(trangThai);

		if (ghiChuNguoiLap == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ghiChuNguoiLap);
		}

		objectOutput.writeLong(userId);
		objectOutput.writeLong(ngayTao);
		objectOutput.writeLong(ngayCapNhat);

		if (ghiChuNguoiDuyet == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ghiChuNguoiDuyet);
		}
	}

	public long id;
	public long yeuCauGiaiTrinhId;
	public int trangThai;
	public String ghiChuNguoiLap;
	public long userId;
	public long ngayTao;
	public long ngayCapNhat;
	public String ghiChuNguoiDuyet;
}