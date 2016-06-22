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

import vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ChiTietThongTinPhanHoi in entity cache.
 *
 * @author tubq
 * @see ChiTietThongTinPhanHoi
 * @generated
 */
public class ChiTietThongTinPhanHoiCacheModel implements CacheModel<ChiTietThongTinPhanHoi>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(id);
		sb.append(", thongTinPhanHoiId=");
		sb.append(thongTinPhanHoiId);
		sb.append(", maTramCapNuoc=");
		sb.append(maTramCapNuoc);
		sb.append(", noiDungKhacNuoc=");
		sb.append(noiDungKhacNuoc);
		sb.append(", noiDungKhacVeSinh=");
		sb.append(noiDungKhacVeSinh);
		sb.append(", maThongTinPhanAnh=");
		sb.append(maThongTinPhanAnh);
		sb.append(", yeuCauGiaiTrinhId=");
		sb.append(yeuCauGiaiTrinhId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ChiTietThongTinPhanHoi toEntityModel() {
		ChiTietThongTinPhanHoiImpl chiTietThongTinPhanHoiImpl = new ChiTietThongTinPhanHoiImpl();

		chiTietThongTinPhanHoiImpl.setId(id);
		chiTietThongTinPhanHoiImpl.setThongTinPhanHoiId(thongTinPhanHoiId);

		if (maTramCapNuoc == null) {
			chiTietThongTinPhanHoiImpl.setMaTramCapNuoc(StringPool.BLANK);
		}
		else {
			chiTietThongTinPhanHoiImpl.setMaTramCapNuoc(maTramCapNuoc);
		}

		if (noiDungKhacNuoc == null) {
			chiTietThongTinPhanHoiImpl.setNoiDungKhacNuoc(StringPool.BLANK);
		}
		else {
			chiTietThongTinPhanHoiImpl.setNoiDungKhacNuoc(noiDungKhacNuoc);
		}

		if (noiDungKhacVeSinh == null) {
			chiTietThongTinPhanHoiImpl.setNoiDungKhacVeSinh(StringPool.BLANK);
		}
		else {
			chiTietThongTinPhanHoiImpl.setNoiDungKhacVeSinh(noiDungKhacVeSinh);
		}

		if (maThongTinPhanAnh == null) {
			chiTietThongTinPhanHoiImpl.setMaThongTinPhanAnh(StringPool.BLANK);
		}
		else {
			chiTietThongTinPhanHoiImpl.setMaThongTinPhanAnh(maThongTinPhanAnh);
		}

		chiTietThongTinPhanHoiImpl.setYeuCauGiaiTrinhId(yeuCauGiaiTrinhId);

		chiTietThongTinPhanHoiImpl.resetOriginalValues();

		return chiTietThongTinPhanHoiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		thongTinPhanHoiId = objectInput.readLong();
		maTramCapNuoc = objectInput.readUTF();
		noiDungKhacNuoc = objectInput.readUTF();
		noiDungKhacVeSinh = objectInput.readUTF();
		maThongTinPhanAnh = objectInput.readUTF();
		yeuCauGiaiTrinhId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(thongTinPhanHoiId);

		if (maTramCapNuoc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(maTramCapNuoc);
		}

		if (noiDungKhacNuoc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(noiDungKhacNuoc);
		}

		if (noiDungKhacVeSinh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(noiDungKhacVeSinh);
		}

		if (maThongTinPhanAnh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(maThongTinPhanAnh);
		}

		objectOutput.writeLong(yeuCauGiaiTrinhId);
	}

	public long id;
	public long thongTinPhanHoiId;
	public String maTramCapNuoc;
	public String noiDungKhacNuoc;
	public String noiDungKhacVeSinh;
	public String maThongTinPhanAnh;
	public long yeuCauGiaiTrinhId;
}