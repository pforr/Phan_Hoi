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

import vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ThongTinPhanHoi in entity cache.
 *
 * @author tubq
 * @see ThongTinPhanHoi
 * @generated
 */
public class ThongTinPhanHoiCacheModel implements CacheModel<ThongTinPhanHoi>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(id);
		sb.append(", soDienThoai=");
		sb.append(soDienThoai);
		sb.append(", thoiGianGoi=");
		sb.append(thoiGianGoi);
		sb.append(", trangThaiGiaoDich=");
		sb.append(trangThaiGiaoDich);
		sb.append(", tongDai=");
		sb.append(tongDai);
		sb.append(", maTinh=");
		sb.append(maTinh);
		sb.append(", maHuyen=");
		sb.append(maHuyen);
		sb.append(", maXa=");
		sb.append(maXa);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ThongTinPhanHoi toEntityModel() {
		ThongTinPhanHoiImpl thongTinPhanHoiImpl = new ThongTinPhanHoiImpl();

		thongTinPhanHoiImpl.setId(id);

		if (soDienThoai == null) {
			thongTinPhanHoiImpl.setSoDienThoai(StringPool.BLANK);
		}
		else {
			thongTinPhanHoiImpl.setSoDienThoai(soDienThoai);
		}

		if (thoiGianGoi == Long.MIN_VALUE) {
			thongTinPhanHoiImpl.setThoiGianGoi(null);
		}
		else {
			thongTinPhanHoiImpl.setThoiGianGoi(new Date(thoiGianGoi));
		}

		thongTinPhanHoiImpl.setTrangThaiGiaoDich(trangThaiGiaoDich);
		thongTinPhanHoiImpl.setTongDai(tongDai);

		if (maTinh == null) {
			thongTinPhanHoiImpl.setMaTinh(StringPool.BLANK);
		}
		else {
			thongTinPhanHoiImpl.setMaTinh(maTinh);
		}

		if (maHuyen == null) {
			thongTinPhanHoiImpl.setMaHuyen(StringPool.BLANK);
		}
		else {
			thongTinPhanHoiImpl.setMaHuyen(maHuyen);
		}

		if (maXa == null) {
			thongTinPhanHoiImpl.setMaXa(StringPool.BLANK);
		}
		else {
			thongTinPhanHoiImpl.setMaXa(maXa);
		}

		thongTinPhanHoiImpl.resetOriginalValues();

		return thongTinPhanHoiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		soDienThoai = objectInput.readUTF();
		thoiGianGoi = objectInput.readLong();
		trangThaiGiaoDich = objectInput.readInt();
		tongDai = objectInput.readInt();
		maTinh = objectInput.readUTF();
		maHuyen = objectInput.readUTF();
		maXa = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (soDienThoai == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(soDienThoai);
		}

		objectOutput.writeLong(thoiGianGoi);
		objectOutput.writeInt(trangThaiGiaoDich);
		objectOutput.writeInt(tongDai);

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
	}

	public long id;
	public String soDienThoai;
	public long thoiGianGoi;
	public int trangThaiGiaoDich;
	public int tongDai;
	public String maTinh;
	public String maHuyen;
	public String maXa;
}