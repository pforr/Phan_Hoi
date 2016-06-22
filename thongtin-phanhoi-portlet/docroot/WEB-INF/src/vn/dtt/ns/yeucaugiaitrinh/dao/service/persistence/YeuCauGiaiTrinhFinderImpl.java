package vn.dtt.ns.yeucaugiaitrinh.dao.service.persistence;

import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import vn.dtt.ns.thongtinphanhoi.util.DateTimeUtil;
import vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh;
import vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.YeuCauGiaiTrinhImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class YeuCauGiaiTrinhFinderImpl extends BasePersistenceImpl<YeuCauGiaiTrinh> implements YeuCauGiaiTrinhFinder{
	private static Log _log = LogFactoryUtil.getLog(YeuCauGiaiTrinhFinderImpl.class);
	public long countYeuCauGiaiTrinh(String maTinh, String maHuyen, String maXa, int trangThaiGiaiTrinh, String maChuDe, int soLuotPhanHoi, Date fromDate, Date toDate) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			StringBuffer sql = new StringBuffer("");
			sql.append(" SELECT COUNT(DISTINCT a.matinh, a.mahuyen, a.maxa, a.machude, a.soluong_theochude) AS TOTAL FROM ws_phanhoi.ws_yeucau_giaitrinh a"); 
			sql.append(" JOIN ws_phanhoi.ws_trangthai_giaitrinh b");
			sql.append(" ON a.id = b.yeucau_giaitrinh_id");
			sql.append(" WHERE 1 = 1 AND b.userId > 0");
			
			if(Validator.isNotNull(trangThaiGiaiTrinh) && trangThaiGiaiTrinh > 0){				
				sql.append(" AND a.trangthai = ?");				
			}

			if(Validator.isNotNull(maTinh)){
				sql.append(" AND a.matinh = ?");
			}
			
			if(Validator.isNotNull(maHuyen)){
				sql.append(" AND a.mahuyen = ?");
			}
			
			if(Validator.isNotNull(maXa)){
				sql.append(" AND a.maxa = ?");
			}
			
			if(Validator.isNotNull(maChuDe)){
				sql.append(" AND a.machude = ?");
			}
			
			if(Validator.isNotNull(soLuotPhanHoi) && soLuotPhanHoi > 0){
				sql.append(" AND a.soluong_theochude > ?");
			}
			
			if(Validator.isNotNull(fromDate)){
				sql.append(" AND a.ngaytao >=?");
			}
			
			if(Validator.isNotNull(toDate)){
				sql.append(" AND a.ngaytao <=?");
			}						
			_log.info("countYeuCauGiaiTrinh--"+sql.toString());
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addScalar("TOTAL", Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);
			
			if(Validator.isNotNull(trangThaiGiaiTrinh) && trangThaiGiaiTrinh > 0){		
				qPos.add(trangThaiGiaiTrinh);		
				_log.info("trangThaiGiaiTrinh--"+trangThaiGiaiTrinh);
			}
			
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
				_log.info("maTinh--"+maTinh);
			}
			
			if(Validator.isNotNull(maHuyen)){
				qPos.add(maHuyen);
				_log.info("maHuyen--"+maHuyen);
			}
			
			if(Validator.isNotNull(maXa)){
				qPos.add(maXa);
				_log.info("maXa--"+maXa);
			}
			
			if(Validator.isNotNull(maChuDe)){
				qPos.add(maChuDe);
				_log.info("maChuDe--"+maChuDe);
			}
			
			if(Validator.isNotNull(soLuotPhanHoi) && soLuotPhanHoi > 0){
				qPos.add(soLuotPhanHoi);
				_log.info("soLuotPhanHoi--"+soLuotPhanHoi);
			}
			
			if(Validator.isNotNull(fromDate)){
				qPos.add(DateTimeUtil.getDauNgay(fromDate));
				_log.info("fromDate--"+DateTimeUtil.getDauNgay(fromDate));
			}
			
			if(Validator.isNotNull(toDate)){
				qPos.add(DateTimeUtil.getCuoiNgay(toDate));
				_log.info("toDate--"+DateTimeUtil.getCuoiNgay(toDate));
			}
			
			Iterator<Long> itr = q.iterate();
			if (itr.hasNext()) {
				Long value = itr.next();
				
				if (value != null) {
					return value;
				}
			}
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		
		return 0;
	}
	
	public List<YeuCauGiaiTrinh> searchYeuCauGiaiTrinh(String maTinh, String maHuyen, String maXa, int trangThaiGiaiTrinh, String maChuDe, int soLuotPhanHoi, Date fromDate, Date toDate, int start, int end) throws SystemException {
		Session session = null;
				
		try {
			session = openSession();
			
			StringBuffer sql = new StringBuffer("");
			sql.append(" SELECT a.* FROM ws_phanhoi.ws_yeucau_giaitrinh a");
			sql.append(" JOIN ws_phanhoi.ws_trangthai_giaitrinh b");
			sql.append(" ON a.id = b.yeucau_giaitrinh_id");
			sql.append(" WHERE 1 = 1 AND b.userId > 0");
			
			if(Validator.isNotNull(trangThaiGiaiTrinh) && trangThaiGiaiTrinh > 0){						
				sql.append(" AND a.trangthai = ?");				
			}

			if(Validator.isNotNull(maTinh)){
				sql.append(" AND a.matinh = ?");
			}
			
			if(Validator.isNotNull(maHuyen)){
				sql.append(" AND a.mahuyen = ?");
			}
			
			if(Validator.isNotNull(maXa)){
				sql.append(" AND a.maxa = ?");
			}
			
			if(Validator.isNotNull(maChuDe)){
				sql.append(" AND a.machude = ?");
			}
			
			if(Validator.isNotNull(soLuotPhanHoi) && soLuotPhanHoi > 0){
				sql.append(" AND a.soluong_theochude > ?");
			}
			
			if(Validator.isNotNull(fromDate)){
				sql.append(" AND a.ngaytao >=?");
			}
			
			if(Validator.isNotNull(toDate)){
				sql.append(" AND a.ngaytao <=?");
			}			
			
			sql.append(" GROUP BY a.matinh, a.mahuyen, a.maxa, a.machude, a.soluong_theochude ");
			sql.append(" ORDER BY a.id DESC, a.matinh, a.mahuyen, a.maxa,a.trangthai, a.machude,  a.soluong_theochude ASC ");
			_log.info("searchYeuCauGiaiTrinh--"+sql.toString()+"==");
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.setCacheable(false);						
			
			q.addEntity(YeuCauGiaiTrinhImpl.TABLE_NAME, YeuCauGiaiTrinhImpl.class);
           
			QueryPos qPos = QueryPos.getInstance(q);
			
			if(Validator.isNotNull(trangThaiGiaiTrinh) && trangThaiGiaiTrinh > 0){				
				qPos.add(trangThaiGiaiTrinh);		
			}
			
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
			
			if(Validator.isNotNull(maHuyen)){
				qPos.add(maHuyen);
			}
			
			if(Validator.isNotNull(maXa)){
				qPos.add(maXa);
			}
			
			if(Validator.isNotNull(maChuDe)){
				qPos.add(maChuDe);
			}
			
			if(Validator.isNotNull(soLuotPhanHoi) && soLuotPhanHoi > 0){
				qPos.add(soLuotPhanHoi);
			}
			
			if(Validator.isNotNull(fromDate)){
				qPos.add(DateTimeUtil.getDauNgay(fromDate));
			}
			
			if(Validator.isNotNull(toDate)){
				qPos.add(DateTimeUtil.getCuoiNgay(toDate));
			}
				
			return (List<YeuCauGiaiTrinh>) QueryUtil.list(q, getDialect(), start, end);						
			
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public long countYeuCauGiaiTrinhNSVS(String maTinh, String[] maHuyen, String[] maXa, int trangThaiGiaiTrinh, String[] maChuDe, int soLuotPhanHoi, Date fromDate, Date toDate) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			StringBuffer sql = new StringBuffer("");
			sql.append(" SELECT COUNT(DISTINCT a.matinh, a.mahuyen, a.maxa, a.machude, a.soluong_theochude) AS TOTAL FROM ws_phanhoi.ws_yeucau_giaitrinh a "); 
			sql.append(" JOIN ws_phanhoi.ws_trangthai_giaitrinh b ");
			sql.append(" ON a.id = b.yeucau_giaitrinh_id ");
			sql.append(" WHERE 1 = 1 AND b.userId > 0 ");
			
			if(Validator.isNotNull(maTinh)){
				sql.append(" AND a.matinh = ?");
			}
			
			if(ArrayUtil.isNotEmpty(maHuyen) && maHuyen.length > 0){
				
				sql.append(" AND a.mahuyen IN (  ");
				
				String temp="";
				for(int i=0;i<maHuyen.length;i++){
				  temp+=",?";
				}
				temp=temp.replaceFirst(",","");				
				sql.append(temp);
				sql.append("  ) ");
				
			}
			if(ArrayUtil.isNotEmpty(maXa) && maXa.length > 0){
				sql.append(" AND a.maxa IN (  ");
				
				String temp="";
				for(int i=0;i<maXa.length;i++){
				  temp+=",?";
				}
				temp=temp.replaceFirst(",","");				
				sql.append(temp);
				sql.append("  ) ");
				
			}
			
			if(Validator.isNotNull(trangThaiGiaiTrinh) && trangThaiGiaiTrinh > 0){						
				sql.append(" AND a.trangthai = ?");				
			}
			
			if(ArrayUtil.isNotEmpty(maChuDe) && maChuDe.length > 0){
				sql.append(" AND a.machude IN (  ");
				
				String temp="";
				for(int i=0;i<maChuDe.length;i++){
				  temp+=",?";
				}
				temp=temp.replaceFirst(",","");				
				sql.append(temp);
				sql.append("  ) ");
				
			}
			
			
			
			if(Validator.isNotNull(soLuotPhanHoi) && soLuotPhanHoi > 0){
				sql.append(" AND a.soluong_theochude > ?");
			}
			
			if(Validator.isNotNull(fromDate) && fromDate != null){
				sql.append(" AND a.ngaytao >=?");
			}
			
			if(Validator.isNotNull(toDate) && toDate != null){
				sql.append(" AND a.ngaytao <=?");
			}							
			_log.info("countYeuCauGiaiTrinhNSVS--"+sql.toString());
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addScalar("TOTAL", Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);
			
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
				_log.info("--maTinh--"+maTinh);
			}
			
			if(ArrayUtil.isNotEmpty(maHuyen) && maHuyen.length > 0){
				for(int i=0;i<maHuyen.length;i++){
					qPos.add(maHuyen[i].toString());
				}
				_log.info("--mahuyen--"+Arrays.toString(maHuyen));
			}
			
			if(ArrayUtil.isNotEmpty(maXa) && maXa.length > 0){
				for(int i=0;i<maXa.length;i++){
					qPos.add(maXa[i].toString());
				}
				_log.info("--maXa--"+Arrays.toString(maXa));
			}
			
			if(Validator.isNotNull(trangThaiGiaiTrinh) && trangThaiGiaiTrinh > 0){
				qPos.add(trangThaiGiaiTrinh);		
			}
			
			if(ArrayUtil.isNotEmpty(maChuDe) && maChuDe.length > 0){
				for(int i=0;i<maChuDe.length;i++){
					qPos.add(maChuDe[i].toString());
				}
				_log.info("--maChuDe--"+Arrays.toString(maChuDe));
			}
			
			
			if(Validator.isNotNull(soLuotPhanHoi) && soLuotPhanHoi > 0){
				qPos.add(soLuotPhanHoi);
			}
			
			if(Validator.isNotNull(fromDate) && fromDate != null){
				_log.info("fromDate=="+fromDate);
				qPos.add(DateTimeUtil.getDauNgay(fromDate));
			}
			
			if(Validator.isNotNull(toDate) && toDate != null){
				_log.info("fromDate=="+DateTimeUtil.getCuoiNgay(toDate));
				qPos.add(DateTimeUtil.getCuoiNgay(toDate));
			}
			
			Iterator<Long> itr = q.iterate();
			if (itr.hasNext()) {
				Long value = itr.next();
				
				if (value != null) {
					return value;
				}
			}
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		
		return 0;
	}
	
	public List<YeuCauGiaiTrinh> searchYeuCauGiaiTrinhNSVS(String maTinh, String[] maHuyen, String[] maXa, int trangThaiGiaiTrinh, String[] maChuDe, int soLuotPhanHoi, Date fromDate, Date toDate, int start, int end) throws SystemException {
		Session session = null;
				
		try {
			session = openSession();
			
			StringBuffer sql = new StringBuffer("");
			sql.append(" SELECT a.* FROM ws_phanhoi.ws_yeucau_giaitrinh a");
			sql.append(" JOIN ws_phanhoi.ws_trangthai_giaitrinh b");
			sql.append(" ON a.id = b.yeucau_giaitrinh_id");
			sql.append(" WHERE 1 = 1 AND b.userId > 0 ");
			
			if(Validator.isNotNull(maTinh)){
				sql.append(" AND a.matinh = ? ");
			}
			
			if(ArrayUtil.isNotEmpty(maHuyen) && maHuyen.length > 0){
				sql.append(" AND a.mahuyen IN (  ");
				
				String temp="";
				for(int i=0;i<maHuyen.length;i++){
				  temp+=",?";
				}
				temp=temp.replaceFirst(",","");				
				sql.append(temp);
				sql.append("  ) ");
			}
			if(ArrayUtil.isNotEmpty(maXa) && maXa.length > 0){
				sql.append(" AND a.maxa IN (  ");
				
				String temp="";
				for(int i=0;i<maXa.length;i++){
				  temp+=",?";
				}
				temp=temp.replaceFirst(",","");				
				sql.append(temp);
				sql.append("  ) ");
			}
			
			if(Validator.isNotNull(trangThaiGiaiTrinh) && trangThaiGiaiTrinh > 0){						
				sql.append(" AND a.trangthai = ? ");				
			}
			
			if(ArrayUtil.isNotEmpty(maChuDe) && maChuDe.length > 0){
				sql.append(" AND a.machude IN (  ");
				
				String temp="";
				for(int i=0;i<maChuDe.length;i++){
				  temp+=",?";
				}
				temp=temp.replaceFirst(",","");				
				sql.append(temp);
				sql.append("  ) ");
			}
			
			if(Validator.isNotNull(soLuotPhanHoi) && soLuotPhanHoi > 0){
				sql.append(" AND a.soluong_theochude > ? ");
			}
			
			if(Validator.isNotNull(fromDate) && fromDate != null){
				sql.append(" AND a.ngaytao >=? ");
			}
			
			if(Validator.isNotNull(toDate) && toDate != null){
				sql.append(" AND a.ngaytao <=? ");
			}			
			
			sql.append(" GROUP BY a.matinh, a.mahuyen, a.maxa, a.machude, a.soluong_theochude");
			sql.append(" ORDER BY a.id DESC, a.matinh, a.mahuyen, a.maxa,a.trangthai, a.machude,  a.soluong_theochude ASC ");
			_log.info("searchYeuCauGiaiTrinhNSVS--"+sql.toString()+"==");
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.setCacheable(false);						
			
			q.addEntity(YeuCauGiaiTrinhImpl.TABLE_NAME, YeuCauGiaiTrinhImpl.class);
           
			QueryPos qPos = QueryPos.getInstance(q);
			
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
			
			if(ArrayUtil.isNotEmpty(maHuyen) && maHuyen.length > 0){
				for(int i=0;i<maHuyen.length;i++){
					qPos.add(maHuyen[i].toString());
				}
			}
			
			if(ArrayUtil.isNotEmpty(maXa) && maXa.length > 0){
				for(int i=0;i<maXa.length;i++){
					qPos.add(maXa[i].toString());
				}
			}
			
			if(Validator.isNotNull(trangThaiGiaiTrinh) && trangThaiGiaiTrinh > 0){
				qPos.add(trangThaiGiaiTrinh);		
			}
			
			if(ArrayUtil.isNotEmpty(maChuDe) && maChuDe.length > 0){
				for(int i=0;i<maChuDe.length;i++){
					qPos.add(maChuDe[i].toString());
				}
			}
			
			
			if(Validator.isNotNull(soLuotPhanHoi) && soLuotPhanHoi > 0){
				qPos.add(soLuotPhanHoi);
			}
			
			if(Validator.isNotNull(fromDate) && fromDate != null){
				qPos.add(DateTimeUtil.getDauNgay(fromDate));
			}
			
			if(Validator.isNotNull(toDate) && toDate != null){
				qPos.add(DateTimeUtil.getCuoiNgay(toDate));
			}
				
			return (List<YeuCauGiaiTrinh>) QueryUtil.list(q, getDialect(), start, end);						
			
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
}
