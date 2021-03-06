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

import vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi;
import vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoiModel;
import vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoiSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ChiTietThongTinPhanHoi service. Represents a row in the &quot;ws_chitiet_thongtin_phanhoi&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoiModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ChiTietThongTinPhanHoiImpl}.
 * </p>
 *
 * @author tubq
 * @see ChiTietThongTinPhanHoiImpl
 * @see vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi
 * @see vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoiModel
 * @generated
 */
@JSON(strict = true)
public class ChiTietThongTinPhanHoiModelImpl extends BaseModelImpl<ChiTietThongTinPhanHoi>
	implements ChiTietThongTinPhanHoiModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a chi tiet thong tin phan hoi model instance should use the {@link vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi} interface instead.
	 */
	public static final String TABLE_NAME = "ws_chitiet_thongtin_phanhoi";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "thongtin_phanhoi_id", Types.BIGINT },
			{ "matramcapnuoc", Types.VARCHAR },
			{ "noidungkhac_nuoc", Types.VARCHAR },
			{ "noidungkhac_vesinh", Types.VARCHAR },
			{ "mathongtinphananh", Types.VARCHAR },
			{ "yeucau_giaitrinh_id", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table ws_chitiet_thongtin_phanhoi (id LONG not null primary key,thongtin_phanhoi_id LONG,matramcapnuoc VARCHAR(75) null,noidungkhac_nuoc VARCHAR(75) null,noidungkhac_vesinh VARCHAR(75) null,mathongtinphananh VARCHAR(75) null,yeucau_giaitrinh_id LONG)";
	public static final String TABLE_SQL_DROP = "drop table ws_chitiet_thongtin_phanhoi";
	public static final String ORDER_BY_JPQL = " ORDER BY chiTietThongTinPhanHoi.id DESC";
	public static final String ORDER_BY_SQL = " ORDER BY ws_chitiet_thongtin_phanhoi.id DESC";
	public static final String DATA_SOURCE = "thongtinphanhoiDatasource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi"),
			true);
	public static long THONGTINPHANHOIID_COLUMN_BITMASK = 1L;
	public static long ID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ChiTietThongTinPhanHoi toModel(
		ChiTietThongTinPhanHoiSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ChiTietThongTinPhanHoi model = new ChiTietThongTinPhanHoiImpl();

		model.setId(soapModel.getId());
		model.setThongTinPhanHoiId(soapModel.getThongTinPhanHoiId());
		model.setMaTramCapNuoc(soapModel.getMaTramCapNuoc());
		model.setNoiDungKhacNuoc(soapModel.getNoiDungKhacNuoc());
		model.setNoiDungKhacVeSinh(soapModel.getNoiDungKhacVeSinh());
		model.setMaThongTinPhanAnh(soapModel.getMaThongTinPhanAnh());
		model.setYeuCauGiaiTrinhId(soapModel.getYeuCauGiaiTrinhId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ChiTietThongTinPhanHoi> toModels(
		ChiTietThongTinPhanHoiSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ChiTietThongTinPhanHoi> models = new ArrayList<ChiTietThongTinPhanHoi>(soapModels.length);

		for (ChiTietThongTinPhanHoiSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi"));

	public ChiTietThongTinPhanHoiModelImpl() {
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
		return ChiTietThongTinPhanHoi.class;
	}

	@Override
	public String getModelClassName() {
		return ChiTietThongTinPhanHoi.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("thongTinPhanHoiId", getThongTinPhanHoiId());
		attributes.put("maTramCapNuoc", getMaTramCapNuoc());
		attributes.put("noiDungKhacNuoc", getNoiDungKhacNuoc());
		attributes.put("noiDungKhacVeSinh", getNoiDungKhacVeSinh());
		attributes.put("maThongTinPhanAnh", getMaThongTinPhanAnh());
		attributes.put("yeuCauGiaiTrinhId", getYeuCauGiaiTrinhId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long thongTinPhanHoiId = (Long)attributes.get("thongTinPhanHoiId");

		if (thongTinPhanHoiId != null) {
			setThongTinPhanHoiId(thongTinPhanHoiId);
		}

		String maTramCapNuoc = (String)attributes.get("maTramCapNuoc");

		if (maTramCapNuoc != null) {
			setMaTramCapNuoc(maTramCapNuoc);
		}

		String noiDungKhacNuoc = (String)attributes.get("noiDungKhacNuoc");

		if (noiDungKhacNuoc != null) {
			setNoiDungKhacNuoc(noiDungKhacNuoc);
		}

		String noiDungKhacVeSinh = (String)attributes.get("noiDungKhacVeSinh");

		if (noiDungKhacVeSinh != null) {
			setNoiDungKhacVeSinh(noiDungKhacVeSinh);
		}

		String maThongTinPhanAnh = (String)attributes.get("maThongTinPhanAnh");

		if (maThongTinPhanAnh != null) {
			setMaThongTinPhanAnh(maThongTinPhanAnh);
		}

		Long yeuCauGiaiTrinhId = (Long)attributes.get("yeuCauGiaiTrinhId");

		if (yeuCauGiaiTrinhId != null) {
			setYeuCauGiaiTrinhId(yeuCauGiaiTrinhId);
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
	public long getThongTinPhanHoiId() {
		return _thongTinPhanHoiId;
	}

	@Override
	public void setThongTinPhanHoiId(long thongTinPhanHoiId) {
		_columnBitmask |= THONGTINPHANHOIID_COLUMN_BITMASK;

		if (!_setOriginalThongTinPhanHoiId) {
			_setOriginalThongTinPhanHoiId = true;

			_originalThongTinPhanHoiId = _thongTinPhanHoiId;
		}

		_thongTinPhanHoiId = thongTinPhanHoiId;
	}

	public long getOriginalThongTinPhanHoiId() {
		return _originalThongTinPhanHoiId;
	}

	@JSON
	@Override
	public String getMaTramCapNuoc() {
		if (_maTramCapNuoc == null) {
			return StringPool.BLANK;
		}
		else {
			return _maTramCapNuoc;
		}
	}

	@Override
	public void setMaTramCapNuoc(String maTramCapNuoc) {
		_maTramCapNuoc = maTramCapNuoc;
	}

	@JSON
	@Override
	public String getNoiDungKhacNuoc() {
		if (_noiDungKhacNuoc == null) {
			return StringPool.BLANK;
		}
		else {
			return _noiDungKhacNuoc;
		}
	}

	@Override
	public void setNoiDungKhacNuoc(String noiDungKhacNuoc) {
		_noiDungKhacNuoc = noiDungKhacNuoc;
	}

	@JSON
	@Override
	public String getNoiDungKhacVeSinh() {
		if (_noiDungKhacVeSinh == null) {
			return StringPool.BLANK;
		}
		else {
			return _noiDungKhacVeSinh;
		}
	}

	@Override
	public void setNoiDungKhacVeSinh(String noiDungKhacVeSinh) {
		_noiDungKhacVeSinh = noiDungKhacVeSinh;
	}

	@JSON
	@Override
	public String getMaThongTinPhanAnh() {
		if (_maThongTinPhanAnh == null) {
			return StringPool.BLANK;
		}
		else {
			return _maThongTinPhanAnh;
		}
	}

	@Override
	public void setMaThongTinPhanAnh(String maThongTinPhanAnh) {
		_maThongTinPhanAnh = maThongTinPhanAnh;
	}

	@JSON
	@Override
	public long getYeuCauGiaiTrinhId() {
		return _yeuCauGiaiTrinhId;
	}

	@Override
	public void setYeuCauGiaiTrinhId(long yeuCauGiaiTrinhId) {
		_yeuCauGiaiTrinhId = yeuCauGiaiTrinhId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ChiTietThongTinPhanHoi.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ChiTietThongTinPhanHoi toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ChiTietThongTinPhanHoi)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ChiTietThongTinPhanHoiImpl chiTietThongTinPhanHoiImpl = new ChiTietThongTinPhanHoiImpl();

		chiTietThongTinPhanHoiImpl.setId(getId());
		chiTietThongTinPhanHoiImpl.setThongTinPhanHoiId(getThongTinPhanHoiId());
		chiTietThongTinPhanHoiImpl.setMaTramCapNuoc(getMaTramCapNuoc());
		chiTietThongTinPhanHoiImpl.setNoiDungKhacNuoc(getNoiDungKhacNuoc());
		chiTietThongTinPhanHoiImpl.setNoiDungKhacVeSinh(getNoiDungKhacVeSinh());
		chiTietThongTinPhanHoiImpl.setMaThongTinPhanAnh(getMaThongTinPhanAnh());
		chiTietThongTinPhanHoiImpl.setYeuCauGiaiTrinhId(getYeuCauGiaiTrinhId());

		chiTietThongTinPhanHoiImpl.resetOriginalValues();

		return chiTietThongTinPhanHoiImpl;
	}

	@Override
	public int compareTo(ChiTietThongTinPhanHoi chiTietThongTinPhanHoi) {
		int value = 0;

		if (getId() < chiTietThongTinPhanHoi.getId()) {
			value = -1;
		}
		else if (getId() > chiTietThongTinPhanHoi.getId()) {
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

		if (!(obj instanceof ChiTietThongTinPhanHoi)) {
			return false;
		}

		ChiTietThongTinPhanHoi chiTietThongTinPhanHoi = (ChiTietThongTinPhanHoi)obj;

		long primaryKey = chiTietThongTinPhanHoi.getPrimaryKey();

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
		ChiTietThongTinPhanHoiModelImpl chiTietThongTinPhanHoiModelImpl = this;

		chiTietThongTinPhanHoiModelImpl._originalThongTinPhanHoiId = chiTietThongTinPhanHoiModelImpl._thongTinPhanHoiId;

		chiTietThongTinPhanHoiModelImpl._setOriginalThongTinPhanHoiId = false;

		chiTietThongTinPhanHoiModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ChiTietThongTinPhanHoi> toCacheModel() {
		ChiTietThongTinPhanHoiCacheModel chiTietThongTinPhanHoiCacheModel = new ChiTietThongTinPhanHoiCacheModel();

		chiTietThongTinPhanHoiCacheModel.id = getId();

		chiTietThongTinPhanHoiCacheModel.thongTinPhanHoiId = getThongTinPhanHoiId();

		chiTietThongTinPhanHoiCacheModel.maTramCapNuoc = getMaTramCapNuoc();

		String maTramCapNuoc = chiTietThongTinPhanHoiCacheModel.maTramCapNuoc;

		if ((maTramCapNuoc != null) && (maTramCapNuoc.length() == 0)) {
			chiTietThongTinPhanHoiCacheModel.maTramCapNuoc = null;
		}

		chiTietThongTinPhanHoiCacheModel.noiDungKhacNuoc = getNoiDungKhacNuoc();

		String noiDungKhacNuoc = chiTietThongTinPhanHoiCacheModel.noiDungKhacNuoc;

		if ((noiDungKhacNuoc != null) && (noiDungKhacNuoc.length() == 0)) {
			chiTietThongTinPhanHoiCacheModel.noiDungKhacNuoc = null;
		}

		chiTietThongTinPhanHoiCacheModel.noiDungKhacVeSinh = getNoiDungKhacVeSinh();

		String noiDungKhacVeSinh = chiTietThongTinPhanHoiCacheModel.noiDungKhacVeSinh;

		if ((noiDungKhacVeSinh != null) && (noiDungKhacVeSinh.length() == 0)) {
			chiTietThongTinPhanHoiCacheModel.noiDungKhacVeSinh = null;
		}

		chiTietThongTinPhanHoiCacheModel.maThongTinPhanAnh = getMaThongTinPhanAnh();

		String maThongTinPhanAnh = chiTietThongTinPhanHoiCacheModel.maThongTinPhanAnh;

		if ((maThongTinPhanAnh != null) && (maThongTinPhanAnh.length() == 0)) {
			chiTietThongTinPhanHoiCacheModel.maThongTinPhanAnh = null;
		}

		chiTietThongTinPhanHoiCacheModel.yeuCauGiaiTrinhId = getYeuCauGiaiTrinhId();

		return chiTietThongTinPhanHoiCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", thongTinPhanHoiId=");
		sb.append(getThongTinPhanHoiId());
		sb.append(", maTramCapNuoc=");
		sb.append(getMaTramCapNuoc());
		sb.append(", noiDungKhacNuoc=");
		sb.append(getNoiDungKhacNuoc());
		sb.append(", noiDungKhacVeSinh=");
		sb.append(getNoiDungKhacVeSinh());
		sb.append(", maThongTinPhanAnh=");
		sb.append(getMaThongTinPhanAnh());
		sb.append(", yeuCauGiaiTrinhId=");
		sb.append(getYeuCauGiaiTrinhId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thongTinPhanHoiId</column-name><column-value><![CDATA[");
		sb.append(getThongTinPhanHoiId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maTramCapNuoc</column-name><column-value><![CDATA[");
		sb.append(getMaTramCapNuoc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiDungKhacNuoc</column-name><column-value><![CDATA[");
		sb.append(getNoiDungKhacNuoc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiDungKhacVeSinh</column-name><column-value><![CDATA[");
		sb.append(getNoiDungKhacVeSinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maThongTinPhanAnh</column-name><column-value><![CDATA[");
		sb.append(getMaThongTinPhanAnh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yeuCauGiaiTrinhId</column-name><column-value><![CDATA[");
		sb.append(getYeuCauGiaiTrinhId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ChiTietThongTinPhanHoi.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ChiTietThongTinPhanHoi.class
		};
	private long _id;
	private long _thongTinPhanHoiId;
	private long _originalThongTinPhanHoiId;
	private boolean _setOriginalThongTinPhanHoiId;
	private String _maTramCapNuoc;
	private String _noiDungKhacNuoc;
	private String _noiDungKhacVeSinh;
	private String _maThongTinPhanAnh;
	private long _yeuCauGiaiTrinhId;
	private long _columnBitmask;
	private ChiTietThongTinPhanHoi _escapedModel;
}