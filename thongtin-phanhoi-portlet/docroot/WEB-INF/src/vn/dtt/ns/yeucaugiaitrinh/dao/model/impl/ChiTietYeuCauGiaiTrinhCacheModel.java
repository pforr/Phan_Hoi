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

import vn.dtt.ns.yeucaugiaitrinh.dao.model.ChiTietYeuCauGiaiTrinh;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ChiTietYeuCauGiaiTrinh in entity cache.
 *
 * @author tubq
 * @see ChiTietYeuCauGiaiTrinh
 * @generated
 */
public class ChiTietYeuCauGiaiTrinhCacheModel implements CacheModel<ChiTietYeuCauGiaiTrinh>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", yeuCauGiaiTrinhId=");
		sb.append(yeuCauGiaiTrinhId);
		sb.append(", maThongTinPhanAnh=");
		sb.append(maThongTinPhanAnh);
		sb.append(", soLuong=");
		sb.append(soLuong);
		sb.append(", giaiTrinh=");
		sb.append(giaiTrinh);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ChiTietYeuCauGiaiTrinh toEntityModel() {
		ChiTietYeuCauGiaiTrinhImpl chiTietYeuCauGiaiTrinhImpl = new ChiTietYeuCauGiaiTrinhImpl();

		chiTietYeuCauGiaiTrinhImpl.setId(id);
		chiTietYeuCauGiaiTrinhImpl.setYeuCauGiaiTrinhId(yeuCauGiaiTrinhId);

		if (maThongTinPhanAnh == null) {
			chiTietYeuCauGiaiTrinhImpl.setMaThongTinPhanAnh(StringPool.BLANK);
		}
		else {
			chiTietYeuCauGiaiTrinhImpl.setMaThongTinPhanAnh(maThongTinPhanAnh);
		}

		chiTietYeuCauGiaiTrinhImpl.setSoLuong(soLuong);

		if (giaiTrinh == null) {
			chiTietYeuCauGiaiTrinhImpl.setGiaiTrinh(StringPool.BLANK);
		}
		else {
			chiTietYeuCauGiaiTrinhImpl.setGiaiTrinh(giaiTrinh);
		}

		chiTietYeuCauGiaiTrinhImpl.resetOriginalValues();

		return chiTietYeuCauGiaiTrinhImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		yeuCauGiaiTrinhId = objectInput.readLong();
		maThongTinPhanAnh = objectInput.readUTF();
		soLuong = objectInput.readInt();
		giaiTrinh = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(yeuCauGiaiTrinhId);

		if (maThongTinPhanAnh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(maThongTinPhanAnh);
		}

		objectOutput.writeInt(soLuong);

		if (giaiTrinh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(giaiTrinh);
		}
	}

	public long id;
	public long yeuCauGiaiTrinhId;
	public String maThongTinPhanAnh;
	public int soLuong;
	public String giaiTrinh;
}