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

package vn.dtt.ns.thongtinphanhoi.dao.service.impl;

import java.util.Date;

import vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi;
import vn.dtt.ns.thongtinphanhoi.dao.model.ThongTinPhanHoi;
import vn.dtt.ns.thongtinphanhoi.dao.service.base.ChiTietThongTinPhanHoiServiceBaseImpl;
import vn.dtt.ns.thongtinphanhoi.util.DateTimeUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.security.ac.AccessControlled;

/**
 * The implementation of the chi tiet thong tin phan hoi remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author tubq
 * @see vn.dtt.ns.thongtinphanhoi.dao.service.base.ChiTietThongTinPhanHoiServiceBaseImpl
 * @see vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiServiceUtil
 */
public class ChiTietThongTinPhanHoiServiceImpl
	extends ChiTietThongTinPhanHoiServiceBaseImpl {
	protected final Log _log = LogFactoryUtil.getLog(ChiTietThongTinPhanHoiServiceImpl.class);
	
	public static final String THONGTIN_KIEMSOAT = "thongtinkiemsoat";
	public static final String THONGTIN_PHANHOI = "thongtinphanhoi";
	
	public static final String SODIENTHOAI = "sodienthoai";
	public static final String THOIGIANGOI = "thoigiangoi";
	public static final String TRANGTHAI_GIAODICH = "trangthai_giaodich";
	public static final String TONGDAI = "tongdai";
	public static final String LOAI_GIAODICH_PHANHOI = "loai_giaodich_phanhoi";
	public static final String MATINH = "matinh";
	public static final String MAHUYEN = "mahuyen";
	public static final String MAXA = "maxa";
	public static final String MATRAMCAPNUOC = "matramcapnuoc";
	public static final String NOIDUNGKHAC_NUOC = "noidungkhac_nuoc";
	public static final String NOIDUNGKHAC_VESINH = "noidungkhac_vesinh";
	
	public static final String THONGTIN_PHANHOI_ID = "thongtin_phanhoi_id";
	public static final String MA_THONGTIN_PHANANH = "mathongtinphananh";
	
	@AccessControlled(guestAccessEnabled=true)
	public boolean insertChiTietThongTinPhanHoi(String strInputJson) throws SystemException{
		try {
			ThongTinPhanHoi ttph = null;
			ChiTietThongTinPhanHoi chitietTtph = null;
			
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject(strInputJson);
			if(jsonObj != null){
				JSONObject ttksJsonKsObj = jsonObj.getJSONObject(THONGTIN_KIEMSOAT);
				JSONObject ttphJsonPhObj = jsonObj.getJSONObject(THONGTIN_PHANHOI);		
				
				if(ttksJsonKsObj != null && ttphJsonPhObj != null){
					long  ttphPk = counterLocalService.increment(ThongTinPhanHoi.class.getName());
					ttph = thongTinPhanHoiLocalService.createThongTinPhanHoi(ttphPk);
					 					
					//thong tin kiem soat
					String soDienThoai = ttksJsonKsObj.getString(SODIENTHOAI);					
					String strThoiGianGoi = ttksJsonKsObj.getString(THOIGIANGOI);
					Date thoiGianGoi = DateTimeUtil.convertStringToDate(strThoiGianGoi);
					int trangThaiGiaoDich = ttksJsonKsObj.getInt(TRANGTHAI_GIAODICH);
					int tongDai = ttksJsonKsObj.getInt(TONGDAI);					
					String maTinh = ttksJsonKsObj.getString(MATINH);
					String maHuyen = ttksJsonKsObj.getString(MAHUYEN);
					String maXa = ttksJsonKsObj.getString(MAXA);
					
					ttph.setSoDienThoai(soDienThoai);
					ttph.setThoiGianGoi(thoiGianGoi);
					ttph.setTrangThaiGiaoDich(trangThaiGiaoDich);
					ttph.setTongDai(tongDai);	
					ttph.setMaTinh(maTinh);
					ttph.setMaHuyen(maHuyen);
					ttph.setMaXa(maXa);
					
					thongTinPhanHoiLocalService.addThongTinPhanHoi(ttph);
														
					//thong tin phan hoi	
					
					String maTramCapNuoc = ttphJsonPhObj.getString(MATRAMCAPNUOC);
					String noiDungKhacNuoc = ttphJsonPhObj.getString(NOIDUNGKHAC_NUOC);	
					String noiDungKhacVeSinh = ttphJsonPhObj.getString(NOIDUNGKHAC_VESINH);	
					JSONArray mathongtinphJsonArray = ttphJsonPhObj.getJSONArray(MA_THONGTIN_PHANANH);
					
					if(mathongtinphJsonArray != null && mathongtinphJsonArray.length() > 0){
						for (int j = 0; j < mathongtinphJsonArray.length(); j++) {
							String maThongTinPhanAnh = mathongtinphJsonArray.getString(j);
							if(!StringPool.BLANK.equals(maThongTinPhanAnh)){
								long chitietTtphPk = counterLocalService.increment(ChiTietThongTinPhanHoi.class.getName());
								chitietTtph = chiTietThongTinPhanHoiLocalService.createChiTietThongTinPhanHoi(chitietTtphPk);
								
								chitietTtph.setThongTinPhanHoiId(ttph.getId());
								chitietTtph.setMaTramCapNuoc(maTramCapNuoc);
								chitietTtph.setNoiDungKhacNuoc(noiDungKhacNuoc);
								chitietTtph.setNoiDungKhacVeSinh(noiDungKhacVeSinh);
								chitietTtph.setMaThongTinPhanAnh(maThongTinPhanAnh);
								chiTietThongTinPhanHoiLocalService.addChiTietThongTinPhanHoi(chitietTtph);
							}
						}
					}
				}
			}else{
				_log.info("JSON String is invalid !");			
				return false;
			}
		} catch (JSONException je) {
			_log.error(je);			
			return false;
		} 	
		return true;
	}	
}