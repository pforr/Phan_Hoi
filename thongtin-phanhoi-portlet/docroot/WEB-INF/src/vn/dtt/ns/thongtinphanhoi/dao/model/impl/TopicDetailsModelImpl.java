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

import vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails;
import vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetailsModel;
import vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetailsSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the TopicDetails service. Represents a row in the &quot;thongtinphanhoi_TopicDetails&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetailsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TopicDetailsImpl}.
 * </p>
 *
 * @author tubq
 * @see TopicDetailsImpl
 * @see vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails
 * @see vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetailsModel
 * @generated
 */
@JSON(strict = true)
public class TopicDetailsModelImpl extends BaseModelImpl<TopicDetails>
	implements TopicDetailsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a topic details model instance should use the {@link vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails} interface instead.
	 */
	public static final String TABLE_NAME = "thongtinphanhoi_TopicDetails";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "sodienthoai", Types.VARCHAR },
			{ "thoigiangoi", Types.TIMESTAMP },
			{ "tongdai", Types.INTEGER },
			{ "matinh", Types.VARCHAR },
			{ "mahuyen", Types.VARCHAR },
			{ "maxa", Types.VARCHAR },
			{ "matramcapnuoc", Types.VARCHAR },
			{ "mathongtinphananh", Types.VARCHAR },
			{ "noidungkhac_nuoc", Types.VARCHAR },
			{ "noidungkhac_vesinh", Types.VARCHAR },
			{ "yeucau_giaitrinh_id", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table thongtinphanhoi_TopicDetails (id LONG not null primary key,sodienthoai VARCHAR(75) null,thoigiangoi DATE null,tongdai INTEGER,matinh VARCHAR(75) null,mahuyen VARCHAR(75) null,maxa VARCHAR(75) null,matramcapnuoc VARCHAR(75) null,mathongtinphananh VARCHAR(75) null,noidungkhac_nuoc VARCHAR(75) null,noidungkhac_vesinh VARCHAR(75) null,yeucau_giaitrinh_id LONG)";
	public static final String TABLE_SQL_DROP = "drop table thongtinphanhoi_TopicDetails";
	public static final String ORDER_BY_JPQL = " ORDER BY topicDetails.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY thongtinphanhoi_TopicDetails.id ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TopicDetails toModel(TopicDetailsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TopicDetails model = new TopicDetailsImpl();

		model.setId(soapModel.getId());
		model.setSoDienThoai(soapModel.getSoDienThoai());
		model.setThoiGianGoi(soapModel.getThoiGianGoi());
		model.setTongDai(soapModel.getTongDai());
		model.setMaTinh(soapModel.getMaTinh());
		model.setMaHuyen(soapModel.getMaHuyen());
		model.setMaXa(soapModel.getMaXa());
		model.setMaTramCapNuoc(soapModel.getMaTramCapNuoc());
		model.setMaThongTinPhanAnh(soapModel.getMaThongTinPhanAnh());
		model.setNoiDungKhacNuoc(soapModel.getNoiDungKhacNuoc());
		model.setNoiDungKhacVesinh(soapModel.getNoiDungKhacVesinh());
		model.setYeuCauGiaiTrinhId(soapModel.getYeuCauGiaiTrinhId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TopicDetails> toModels(TopicDetailsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TopicDetails> models = new ArrayList<TopicDetails>(soapModels.length);

		for (TopicDetailsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails"));

	public TopicDetailsModelImpl() {
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
		return TopicDetails.class;
	}

	@Override
	public String getModelClassName() {
		return TopicDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("soDienThoai", getSoDienThoai());
		attributes.put("thoiGianGoi", getThoiGianGoi());
		attributes.put("tongDai", getTongDai());
		attributes.put("maTinh", getMaTinh());
		attributes.put("maHuyen", getMaHuyen());
		attributes.put("maXa", getMaXa());
		attributes.put("maTramCapNuoc", getMaTramCapNuoc());
		attributes.put("maThongTinPhanAnh", getMaThongTinPhanAnh());
		attributes.put("noiDungKhacNuoc", getNoiDungKhacNuoc());
		attributes.put("noiDungKhacVesinh", getNoiDungKhacVesinh());
		attributes.put("yeuCauGiaiTrinhId", getYeuCauGiaiTrinhId());

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

		String maTramCapNuoc = (String)attributes.get("maTramCapNuoc");

		if (maTramCapNuoc != null) {
			setMaTramCapNuoc(maTramCapNuoc);
		}

		String maThongTinPhanAnh = (String)attributes.get("maThongTinPhanAnh");

		if (maThongTinPhanAnh != null) {
			setMaThongTinPhanAnh(maThongTinPhanAnh);
		}

		String noiDungKhacNuoc = (String)attributes.get("noiDungKhacNuoc");

		if (noiDungKhacNuoc != null) {
			setNoiDungKhacNuoc(noiDungKhacNuoc);
		}

		String noiDungKhacVesinh = (String)attributes.get("noiDungKhacVesinh");

		if (noiDungKhacVesinh != null) {
			setNoiDungKhacVesinh(noiDungKhacVesinh);
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
		_soDienThoai = soDienThoai;
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
	public String getNoiDungKhacVesinh() {
		if (_noiDungKhacVesinh == null) {
			return StringPool.BLANK;
		}
		else {
			return _noiDungKhacVesinh;
		}
	}

	@Override
	public void setNoiDungKhacVesinh(String noiDungKhacVesinh) {
		_noiDungKhacVesinh = noiDungKhacVesinh;
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

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			TopicDetails.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TopicDetails toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TopicDetails)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TopicDetailsImpl topicDetailsImpl = new TopicDetailsImpl();

		topicDetailsImpl.setId(getId());
		topicDetailsImpl.setSoDienThoai(getSoDienThoai());
		topicDetailsImpl.setThoiGianGoi(getThoiGianGoi());
		topicDetailsImpl.setTongDai(getTongDai());
		topicDetailsImpl.setMaTinh(getMaTinh());
		topicDetailsImpl.setMaHuyen(getMaHuyen());
		topicDetailsImpl.setMaXa(getMaXa());
		topicDetailsImpl.setMaTramCapNuoc(getMaTramCapNuoc());
		topicDetailsImpl.setMaThongTinPhanAnh(getMaThongTinPhanAnh());
		topicDetailsImpl.setNoiDungKhacNuoc(getNoiDungKhacNuoc());
		topicDetailsImpl.setNoiDungKhacVesinh(getNoiDungKhacVesinh());
		topicDetailsImpl.setYeuCauGiaiTrinhId(getYeuCauGiaiTrinhId());

		topicDetailsImpl.resetOriginalValues();

		return topicDetailsImpl;
	}

	@Override
	public int compareTo(TopicDetails topicDetails) {
		long primaryKey = topicDetails.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TopicDetails)) {
			return false;
		}

		TopicDetails topicDetails = (TopicDetails)obj;

		long primaryKey = topicDetails.getPrimaryKey();

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
	}

	@Override
	public CacheModel<TopicDetails> toCacheModel() {
		TopicDetailsCacheModel topicDetailsCacheModel = new TopicDetailsCacheModel();

		topicDetailsCacheModel.id = getId();

		topicDetailsCacheModel.soDienThoai = getSoDienThoai();

		String soDienThoai = topicDetailsCacheModel.soDienThoai;

		if ((soDienThoai != null) && (soDienThoai.length() == 0)) {
			topicDetailsCacheModel.soDienThoai = null;
		}

		Date thoiGianGoi = getThoiGianGoi();

		if (thoiGianGoi != null) {
			topicDetailsCacheModel.thoiGianGoi = thoiGianGoi.getTime();
		}
		else {
			topicDetailsCacheModel.thoiGianGoi = Long.MIN_VALUE;
		}

		topicDetailsCacheModel.tongDai = getTongDai();

		topicDetailsCacheModel.maTinh = getMaTinh();

		String maTinh = topicDetailsCacheModel.maTinh;

		if ((maTinh != null) && (maTinh.length() == 0)) {
			topicDetailsCacheModel.maTinh = null;
		}

		topicDetailsCacheModel.maHuyen = getMaHuyen();

		String maHuyen = topicDetailsCacheModel.maHuyen;

		if ((maHuyen != null) && (maHuyen.length() == 0)) {
			topicDetailsCacheModel.maHuyen = null;
		}

		topicDetailsCacheModel.maXa = getMaXa();

		String maXa = topicDetailsCacheModel.maXa;

		if ((maXa != null) && (maXa.length() == 0)) {
			topicDetailsCacheModel.maXa = null;
		}

		topicDetailsCacheModel.maTramCapNuoc = getMaTramCapNuoc();

		String maTramCapNuoc = topicDetailsCacheModel.maTramCapNuoc;

		if ((maTramCapNuoc != null) && (maTramCapNuoc.length() == 0)) {
			topicDetailsCacheModel.maTramCapNuoc = null;
		}

		topicDetailsCacheModel.maThongTinPhanAnh = getMaThongTinPhanAnh();

		String maThongTinPhanAnh = topicDetailsCacheModel.maThongTinPhanAnh;

		if ((maThongTinPhanAnh != null) && (maThongTinPhanAnh.length() == 0)) {
			topicDetailsCacheModel.maThongTinPhanAnh = null;
		}

		topicDetailsCacheModel.noiDungKhacNuoc = getNoiDungKhacNuoc();

		String noiDungKhacNuoc = topicDetailsCacheModel.noiDungKhacNuoc;

		if ((noiDungKhacNuoc != null) && (noiDungKhacNuoc.length() == 0)) {
			topicDetailsCacheModel.noiDungKhacNuoc = null;
		}

		topicDetailsCacheModel.noiDungKhacVesinh = getNoiDungKhacVesinh();

		String noiDungKhacVesinh = topicDetailsCacheModel.noiDungKhacVesinh;

		if ((noiDungKhacVesinh != null) && (noiDungKhacVesinh.length() == 0)) {
			topicDetailsCacheModel.noiDungKhacVesinh = null;
		}

		topicDetailsCacheModel.yeuCauGiaiTrinhId = getYeuCauGiaiTrinhId();

		return topicDetailsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", soDienThoai=");
		sb.append(getSoDienThoai());
		sb.append(", thoiGianGoi=");
		sb.append(getThoiGianGoi());
		sb.append(", tongDai=");
		sb.append(getTongDai());
		sb.append(", maTinh=");
		sb.append(getMaTinh());
		sb.append(", maHuyen=");
		sb.append(getMaHuyen());
		sb.append(", maXa=");
		sb.append(getMaXa());
		sb.append(", maTramCapNuoc=");
		sb.append(getMaTramCapNuoc());
		sb.append(", maThongTinPhanAnh=");
		sb.append(getMaThongTinPhanAnh());
		sb.append(", noiDungKhacNuoc=");
		sb.append(getNoiDungKhacNuoc());
		sb.append(", noiDungKhacVesinh=");
		sb.append(getNoiDungKhacVesinh());
		sb.append(", yeuCauGiaiTrinhId=");
		sb.append(getYeuCauGiaiTrinhId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails");
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
		sb.append(
			"<column><column-name>maTramCapNuoc</column-name><column-value><![CDATA[");
		sb.append(getMaTramCapNuoc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maThongTinPhanAnh</column-name><column-value><![CDATA[");
		sb.append(getMaThongTinPhanAnh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiDungKhacNuoc</column-name><column-value><![CDATA[");
		sb.append(getNoiDungKhacNuoc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noiDungKhacVesinh</column-name><column-value><![CDATA[");
		sb.append(getNoiDungKhacVesinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yeuCauGiaiTrinhId</column-name><column-value><![CDATA[");
		sb.append(getYeuCauGiaiTrinhId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = TopicDetails.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			TopicDetails.class
		};
	private long _id;
	private String _soDienThoai;
	private Date _thoiGianGoi;
	private int _tongDai;
	private String _maTinh;
	private String _maHuyen;
	private String _maXa;
	private String _maTramCapNuoc;
	private String _maThongTinPhanAnh;
	private String _noiDungKhacNuoc;
	private String _noiDungKhacVesinh;
	private long _yeuCauGiaiTrinhId;
	private TopicDetails _escapedModel;
}