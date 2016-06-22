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

import vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TopicDetails in entity cache.
 *
 * @author tubq
 * @see TopicDetails
 * @generated
 */
public class TopicDetailsCacheModel implements CacheModel<TopicDetails>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{id=");
		sb.append(id);
		sb.append(", soDienThoai=");
		sb.append(soDienThoai);
		sb.append(", thoiGianGoi=");
		sb.append(thoiGianGoi);
		sb.append(", tongDai=");
		sb.append(tongDai);
		sb.append(", maTinh=");
		sb.append(maTinh);
		sb.append(", maHuyen=");
		sb.append(maHuyen);
		sb.append(", maXa=");
		sb.append(maXa);
		sb.append(", maTramCapNuoc=");
		sb.append(maTramCapNuoc);
		sb.append(", maThongTinPhanAnh=");
		sb.append(maThongTinPhanAnh);
		sb.append(", noiDungKhacNuoc=");
		sb.append(noiDungKhacNuoc);
		sb.append(", noiDungKhacVesinh=");
		sb.append(noiDungKhacVesinh);
		sb.append(", yeuCauGiaiTrinhId=");
		sb.append(yeuCauGiaiTrinhId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TopicDetails toEntityModel() {
		TopicDetailsImpl topicDetailsImpl = new TopicDetailsImpl();

		topicDetailsImpl.setId(id);

		if (soDienThoai == null) {
			topicDetailsImpl.setSoDienThoai(StringPool.BLANK);
		}
		else {
			topicDetailsImpl.setSoDienThoai(soDienThoai);
		}

		if (thoiGianGoi == Long.MIN_VALUE) {
			topicDetailsImpl.setThoiGianGoi(null);
		}
		else {
			topicDetailsImpl.setThoiGianGoi(new Date(thoiGianGoi));
		}

		topicDetailsImpl.setTongDai(tongDai);

		if (maTinh == null) {
			topicDetailsImpl.setMaTinh(StringPool.BLANK);
		}
		else {
			topicDetailsImpl.setMaTinh(maTinh);
		}

		if (maHuyen == null) {
			topicDetailsImpl.setMaHuyen(StringPool.BLANK);
		}
		else {
			topicDetailsImpl.setMaHuyen(maHuyen);
		}

		if (maXa == null) {
			topicDetailsImpl.setMaXa(StringPool.BLANK);
		}
		else {
			topicDetailsImpl.setMaXa(maXa);
		}

		if (maTramCapNuoc == null) {
			topicDetailsImpl.setMaTramCapNuoc(StringPool.BLANK);
		}
		else {
			topicDetailsImpl.setMaTramCapNuoc(maTramCapNuoc);
		}

		if (maThongTinPhanAnh == null) {
			topicDetailsImpl.setMaThongTinPhanAnh(StringPool.BLANK);
		}
		else {
			topicDetailsImpl.setMaThongTinPhanAnh(maThongTinPhanAnh);
		}

		if (noiDungKhacNuoc == null) {
			topicDetailsImpl.setNoiDungKhacNuoc(StringPool.BLANK);
		}
		else {
			topicDetailsImpl.setNoiDungKhacNuoc(noiDungKhacNuoc);
		}

		if (noiDungKhacVesinh == null) {
			topicDetailsImpl.setNoiDungKhacVesinh(StringPool.BLANK);
		}
		else {
			topicDetailsImpl.setNoiDungKhacVesinh(noiDungKhacVesinh);
		}

		topicDetailsImpl.setYeuCauGiaiTrinhId(yeuCauGiaiTrinhId);

		topicDetailsImpl.resetOriginalValues();

		return topicDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		soDienThoai = objectInput.readUTF();
		thoiGianGoi = objectInput.readLong();
		tongDai = objectInput.readInt();
		maTinh = objectInput.readUTF();
		maHuyen = objectInput.readUTF();
		maXa = objectInput.readUTF();
		maTramCapNuoc = objectInput.readUTF();
		maThongTinPhanAnh = objectInput.readUTF();
		noiDungKhacNuoc = objectInput.readUTF();
		noiDungKhacVesinh = objectInput.readUTF();
		yeuCauGiaiTrinhId = objectInput.readLong();
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

		if (maTramCapNuoc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(maTramCapNuoc);
		}

		if (maThongTinPhanAnh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(maThongTinPhanAnh);
		}

		if (noiDungKhacNuoc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(noiDungKhacNuoc);
		}

		if (noiDungKhacVesinh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(noiDungKhacVesinh);
		}

		objectOutput.writeLong(yeuCauGiaiTrinhId);
	}

	public long id;
	public String soDienThoai;
	public long thoiGianGoi;
	public int tongDai;
	public String maTinh;
	public String maHuyen;
	public String maXa;
	public String maTramCapNuoc;
	public String maThongTinPhanAnh;
	public String noiDungKhacNuoc;
	public String noiDungKhacVesinh;
	public long yeuCauGiaiTrinhId;
}