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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi;
import vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoiModel;
import vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoiSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ThongTinPhanHoi service. Represents a row in the &quot;ws_thongtin_phanhoi&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoiModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ThongTinPhanHoiImpl}.
 * </p>
 *
 * @author tubq
 * @see ThongTinPhanHoiImpl
 * @see vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi
 * @see vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoiModel
 * @generated
 */
@JSON(strict = true)
public class ThongTinPhanHoiModelImpl extends BaseModelImpl<ThongTinPhanHoi>
	implements ThongTinPhanHoiModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a thong tin phan hoi model instance should use the {@link vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi} interface instead.
	 */
	public static final String TABLE_NAME = "ws_thongtin_phanhoi";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "sodienthoai", Types.VARCHAR },
			{ "thoigiangoi", Types.TIMESTAMP },
			{ "trangthai_giaodich", Types.INTEGER },
			{ "tongdai", Types.INTEGER },
			{ "matinh", Types.VARCHAR },
			{ "mahuyen", Types.VARCHAR },
			{ "maxa", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ws_thongtin_phanhoi (id LONG not null primary key,sodienthoai VARCHAR(75) null,thoigiangoi DATE null,trangthai_giaodich INTEGER,tongdai INTEGER,matinh VARCHAR(75) null,mahuyen VARCHAR(75) null,maxa VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table ws_thongtin_phanhoi";
	public static final String ORDER_BY_JPQL = " ORDER BY thongTinPhanHoi.id DESC";
	public static final String ORDER_BY_SQL = " ORDER BY ws_thongtin_phanhoi.id DESC";
	public static final String DATA_SOURCE = "thongtinphanhoiDatasource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi"),
			true);
	public static long SODIENTHOAI_COLUMN_BITMASK = 1L;
	public static long ID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ThongTinPhanHoi toModel(ThongTinPhanHoiSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ThongTinPhanHoi model = new ThongTinPhanHoiImpl();

		model.setId(soapModel.getId());
		model.setSoDienThoai(soapModel.getSoDienThoai());
		model.setThoiGianGoi(soapModel.getThoiGianGoi());
		model.setTrangThaiGiaoDich(soapModel.getTrangThaiGiaoDich());
		model.setTongDai(soapModel.getTongDai());
		model.setMaTinh(soapModel.getMaTinh());
		model.setMaHuyen(soapModel.getMaHuyen());
		model.setMaXa(soapModel.getMaXa());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ThongTinPhanHoi> toModels(
		ThongTinPhanHoiSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ThongTinPhanHoi> models = new ArrayList<ThongTinPhanHoi>(soapModels.length);

		for (ThongTinPhanHoiSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi"));

	public ThongTinPhanHoiModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ThongTinPhanHoi.class;
	}

	@Override
	public String getModelClassName() {
		return ThongTinPhanHoi.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("soDienThoai", getSoDienThoai());
		attributes.put("thoiGianGoi", getThoiGianGoi());
		attributes.put("trangThaiGiaoDich", getTrangThaiGiaoDich());
		attributes.put("tongDai", getTongDai());
		attributes.put("maTinh", getMaTinh());
		attributes.put("maHuyen", getMaHuyen());
		attributes.put("maXa", getMaXa());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String soDienThoai = (String)attributes.get("soDienThoai");

		if (soDienThoai != null) {
			setSoDienThoai(soDienThoai);
		}

		Date thoiGianGoi = (Date)attributes.get("thoiGianGoi");

		if (thoiGianGoi != null) {
			setThoiGianGoi(thoiGianGoi);
		}

		Integer trangThaiGiaoDich = (Integer)attributes.get("trangThaiGiaoDich");

		if (trangThaiGiaoDich != null) {
			setTrangThaiGiaoDich(trangThaiGiaoDich);
		}

		Integer tongDai = (Integer)attributes.get("tongDai");

		if (tongDai != null) {
			setTongDai(tongDai);
		}

		String maTinh = (String)attributes.get("maTinh");

		if (maTinh != null) {
			setMaTinh(maTinh);
		}

		String maHuyen = (String)attributes.get("maHuyen");

		if (maHuyen != null) {
			setMaHuyen(maHuyen);
		}

		String maXa = (String)attributes.get("maXa");

		if (maXa != null) {
			setMaXa(maXa);
		}
	}

	@JSON
	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_columnBitmask = -1L;

		_id = id;
	}

	@JSON
	@Override
	public String getSoDienThoai() {
		if (_soDienThoai == null) {
			return StringPool.BLANK;
		}
		else {
			return _soDienThoai;
		}
	}

	@Override
	public void setSoDienThoai(String soDienThoai) {
		_columnBitmask |= SODIENTHOAI_COLUMN_BITMASK;

		if (_originalSoDienThoai == null) {
			_originalSoDienThoai = _soDienThoai;
		}

		_soDienThoai = soDienThoai;
	}

	public String getOriginalSoDienThoai() {
		return GetterUtil.getString(_originalSoDienThoai);
	}

	@JSON
	@Override
	public Date getThoiGianGoi() {
		return _thoiGianGoi;
	}

	@Override
	public void setThoiGianGoi(Date thoiGianGoi) {
		_thoiGianGoi = thoiGianGoi;
	}

	@JSON
	@Override
	public int getTrangThaiGiaoDich() {
		return _trangThaiGiaoDich;
	}

	@Override
	public void setTrangThaiGiaoDich(int trangThaiGiaoDich) {
		_trangThaiGiaoDich = trangThaiGiaoDich;
	}

	@JSON
	@Override
	public int getTongDai() {
		return _tongDai;
	}

	@Override
	public void setTongDai(int tongDai) {
		_tongDai = tongDai;
	}

	@JSON
	@Override
	public String getMaTinh() {
		if (_maTinh == null) {
			return StringPool.BLANK;
		}
		else {
			return _maTinh;
		}
	}

	@Override
	public void setMaTinh(String maTinh) {
		_maTinh = maTinh;
	}

	@JSON
	@Override
	public String getMaHuyen() {
		if (_maHuyen == null) {
			return StringPool.BLANK;
		}
		else {
			return _maHuyen;
		}
	}

	@Override
	public void setMaHuyen(String maHuyen) {
		_maHuyen = maHuyen;
	}

	@JSON
	@Override
	public String getMaXa() {
		if (_maXa == null) {
			return StringPool.BLANK;
		}
		else {
			return _maXa;
		}
	}

	@Override
	public void setMaXa(String maXa) {
		_maXa = maXa;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ThongTinPhanHoi.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ThongTinPhanHoi toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ThongTinPhanHoi)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ThongTinPhanHoiImpl thongTinPhanHoiImpl = new ThongTinPhanHoiImpl();

		thongTinPhanHoiImpl.setId(getId());
		thongTinPhanHoiImpl.setSoDienThoai(getSoDienThoai());
		thongTinPhanHoiImpl.setThoiGianGoi(getThoiGianGoi());
		thongTinPhanHoiImpl.setTrangThaiGiaoDich(getTrangThaiGiaoDich());
		thongTinPhanHoiImpl.setTongDai(getTongDai());
		thongTinPhanHoiImpl.setMaTinh(getMaTinh());
		thongTinPhanHoiImpl.setMaHuyen(getMaHuyen());
		thongTinPhanHoiImpl.setMaXa(getMaXa());

		thongTinPhanHoiImpl.resetOriginalValues();

		return thongTinPhanHoiImpl;
	}

	@Override
	public int compareTo(ThongTinPhanHoi thongTinPhanHoi) {
		int value = 0;

		if (getId() < thongTinPhanHoi.getId()) {
			value = -1;
		}
		else if (getId() > thongTinPhanHoi.getId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ThongTinPhanHoi)) {
			return false;
		}

		ThongTinPhanHoi thongTinPhanHoi = (ThongTinPhanHoi)obj;

		long primaryKey = thongTinPhanHoi.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		ThongTinPhanHoiModelImpl thongTinPhanHoiModelImpl = this;

		thongTinPhanHoiModelImpl._originalSoDienThoai = thongTinPhanHoiModelImpl._soDienThoai;

		thongTinPhanHoiModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ThongTinPhanHoi> toCacheModel() {
		ThongTinPhanHoiCacheModel thongTinPhanHoiCacheModel = new ThongTinPhanHoiCacheModel();

		thongTinPhanHoiCacheModel.id = getId();

		thongTinPhanHoiCacheModel.soDienThoai = getSoDienThoai();

		String soDienThoai = thongTinPhanHoiCacheModel.soDienThoai;

		if ((soDienThoai != null) && (soDienThoai.length() == 0)) {
			thongTinPhanHoiCacheModel.soDienThoai = null;
		}

		Date thoiGianGoi = getThoiGianGoi();

		if (thoiGianGoi != null) {
			thongTinPhanHoiCacheModel.thoiGianGoi = thoiGianGoi.getTime();
		}
		else {
			thongTinPhanHoiCacheModel.thoiGianGoi = Long.MIN_VALUE;
		}

		thongTinPhanHoiCacheModel.trangThaiGiaoDich = getTrangThaiGiaoDich();

		thongTinPhanHoiCacheModel.tongDai = getTongDai();

		thongTinPhanHoiCacheModel.maTinh = getMaTinh();

		String maTinh = thongTinPhanHoiCacheModel.maTinh;

		if ((maTinh != null) && (maTinh.length() == 0)) {
			thongTinPhanHoiCacheModel.maTinh = null;
		}

		thongTinPhanHoiCacheModel.maHuyen = getMaHuyen();

		String maHuyen = thongTinPhanHoiCacheModel.maHuyen;

		if ((maHuyen != null) && (maHuyen.length() == 0)) {
			thongTinPhanHoiCacheModel.maHuyen = null;
		}

		thongTinPhanHoiCacheModel.maXa = getMaXa();

		String maXa = thongTinPhanHoiCacheModel.maXa;

		if ((maXa != null) && (maXa.length() == 0)) {
			thongTinPhanHoiCacheModel.maXa = null;
		}

		return thongTinPhanHoiCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", soDienThoai=");
		sb.append(getSoDienThoai());
		sb.append(", thoiGianGoi=");
		sb.append(getThoiGianGoi());
		sb.append(", trangThaiGiaoDich=");
		sb.append(getTrangThaiGiaoDich());
		sb.append(", tongDai=");
		sb.append(getTongDai());
		sb.append(", maTinh=");
		sb.append(getMaTinh());
		sb.append(", maHuyen=");
		sb.append(getMaHuyen());
		sb.append(", maXa=");
		sb.append(getMaXa());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soDienThoai</column-name><column-value><![CDATA[");
		sb.append(getSoDienThoai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thoiGianGoi</column-name><column-value><![CDATA[");
		sb.append(getThoiGianGoi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThaiGiaoDich</column-name><column-value><![CDATA[");
		sb.append(getTrangThaiGiaoDich());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tongDai</column-name><column-value><![CDATA[");
		sb.append(getTongDai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maTinh</column-name><column-value><![CDATA[");
		sb.append(getMaTinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maHuyen</column-name><column-value><![CDATA[");
		sb.append(getMaHuyen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maXa</column-name><column-value><![CDATA[");
		sb.append(getMaXa());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ThongTinPhanHoi.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ThongTinPhanHoi.class
		};
	private long _id;
	private String _soDienThoai;
	private String _originalSoDienThoai;
	private Date _thoiGianGoi;
	private int _trangThaiGiaoDich;
	private int _tongDai;
	private String _maTinh;
	private String _maHuyen;
	private String _maXa;
	private long _columnBitmask;
	private ThongTinPhanHoi _escapedModel;
}