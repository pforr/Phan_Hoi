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

import vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing YeuCauGiaiTrinh in entity cache.
 *
 * @author tubq
 * @see YeuCauGiaiTrinh
 * @generated
 */
public class YeuCauGiaiTrinhCacheModel implements CacheModel<YeuCauGiaiTrinh>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{id=");
		sb.append(id);
		sb.append(", maTinh=");
		sb.append(maTinh);
		sb.append(", maHuyen=");
		sb.append(maHuyen);
		sb.append(", maXa=");
		sb.append(maXa);
		sb.append(", maChuDe=");
		sb.append(maChuDe);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append(", soLuongTheoChuDe=");
		sb.append(soLuongTheoChuDe);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngayCapNhat=");
		sb.append(ngayCapNhat);
		sb.append(", nguoiPheDuyet=");
		sb.append(nguoiPheDuyet);
		sb.append(", daChuyenSangMinhBach=");
		sb.append(daChuyenSangMinhBach);
		sb.append(", maYeuCauGiaiTrinh=");
		sb.append(maYeuCauGiaiTrinh);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public YeuCauGiaiTrinh toEntityModel() {
		YeuCauGiaiTrinhImpl yeuCauGiaiTrinhImpl = new YeuCauGiaiTrinhImpl();

		yeuCauGiaiTrinhImpl.setId(id);

		if (maTinh == null) {
			yeuCauGiaiTrinhImpl.setMaTinh(StringPool.BLANK);
		}
		else {
			yeuCauGiaiTrinhImpl.setMaTinh(maTinh);
		}

		if (maHuyen == null) {
			yeuCauGiaiTrinhImpl.setMaHuyen(StringPool.BLANK);
		}
		else {
			yeuCauGiaiTrinhImpl.setMaHuyen(maHuyen);
		}

		if (maXa == null) {
			yeuCauGiaiTrinhImpl.setMaXa(StringPool.BLANK);
		}
		else {
			yeuCauGiaiTrinhImpl.setMaXa(maXa);
		}

		if (maChuDe == null) {
			yeuCauGiaiTrinhImpl.setMaChuDe(StringPool.BLANK);
		}
		else {
			yeuCauGiaiTrinhImpl.setMaChuDe(maChuDe);
		}

		yeuCauGiaiTrinhImpl.setTrangThai(trangThai);
		yeuCauGiaiTrinhImpl.setSoLuongTheoChuDe(soLuongTheoChuDe);
		yeuCauGiaiTrinhImpl.setUserId(userId);

		if (ngayTao == Long.MIN_VALUE) {
			yeuCauGiaiTrinhImpl.setNgayTao(null);
		}
		else {
			yeuCauGiaiTrinhImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngayCapNhat == Long.MIN_VALUE) {
			yeuCauGiaiTrinhImpl.setNgayCapNhat(null);
		}
		else {
			yeuCauGiaiTrinhImpl.setNgayCapNhat(new Date(ngayCapNhat));
		}

		yeuCauGiaiTrinhImpl.setNguoiPheDuyet(nguoiPheDuyet);
		yeuCauGiaiTrinhImpl.setDaChuyenSangMinhBach(daChuyenSangMinhBach);

		if (maYeuCauGiaiTrinh == null) {
			yeuCauGiaiTrinhImpl.setMaYeuCauGiaiTrinh(StringPool.BLANK);
		}
		else {
			yeuCauGiaiTrinhImpl.setMaYeuCauGiaiTrinh(maYeuCauGiaiTrinh);
		}

		yeuCauGiaiTrinhImpl.resetOriginalValues();

		return yeuCauGiaiTrinhImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		maTinh = objectInput.readUTF();
		maHuyen = objectInput.readUTF();
		maXa = objectInput.readUTF();
		maChuDe = objectInput.readUTF();
		trangThai = objectInput.readInt();
		soLuongTheoChuDe = objectInput.readInt();
		userId = objectInput.readLong();
		ngayTao = objectInput.readLong();
		ngayCapNhat = objectInput.readLong();
		nguoiPheDuyet = objectInput.readLong();
		daChuyenSangMinhBach = objectInput.readInt();
		maYeuCauGiaiTrinh = objectInput.readUTF();
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

		if (maChuDe == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(maChuDe);
		}

		objectOutput.writeInt(trangThai);
		objectOutput.writeInt(soLuongTheoChuDe);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(ngayTao);
		objectOutput.writeLong(ngayCapNhat);
		objectOutput.writeLong(nguoiPheDuyet);
		objectOutput.writeInt(daChuyenSangMinhBach);

		if (maYeuCauGiaiTrinh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(maYeuCauGiaiTrinh);
		}
	}

	public long id;
	public String maTinh;
	public String maHuyen;
	public String maXa;
	public String maChuDe;
	public int trangThai;
	public int soLuongTheoChuDe;
	public long userId;
	public long ngayTao;
	public long ngayCapNhat;
	public long nguoiPheDuyet;
	public int daChuyenSangMinhBach;
	public String maYeuCauGiaiTrinh;
}