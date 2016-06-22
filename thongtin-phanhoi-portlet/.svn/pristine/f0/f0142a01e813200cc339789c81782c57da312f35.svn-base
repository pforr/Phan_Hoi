package vn.dtt.ns.thongtinphanhoi.dao.service.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi;
import vn.dtt.ns.thongtinphanhoi.dao.model.TopicDetails;
import vn.dtt.ns.thongtinphanhoi.dao.model.TopicPhanHoi;
import vn.dtt.ns.thongtinphanhoi.dao.model.impl.TopicDetailsImpl;
import vn.dtt.ns.thongtinphanhoi.dao.model.impl.TopicPhanHoiImpl;
import vn.dtt.ns.thongtinphanhoi.util.DateTimeUtil;
import vn.dtt.ns.thongtinphanhoi.util.ThongTinPhanHoiConstants;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class ChiTietThongTinPhanHoiFinderImpl extends BasePersistenceImpl<ChiTietThongTinPhanHoi> implements ChiTietThongTinPhanHoiFinder{

	public long countTopicPhanHoi(String maTinh, String maHuyen, String maXa, String topicCode, Date fromDate, Date toDate) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			StringBuffer sql = new StringBuffer("");
			sql.append(" SELECT COUNT(DISTINCT a.matinh, a.mahuyen, a.maxa, c.code) AS TOTAL FROM ws_phanhoi.ws_thongtin_phanhoi a"); 
			sql.append(" JOIN ws_phanhoi.ws_chitiet_thongtin_phanhoi b JOIN ns_danhmuc.dm_dataitem c");
			sql.append(" ON a.id = b.thongtin_phanhoi_id and substring(b.mathongtinphananh,1,2) = c.code");
			sql.append(" WHERE c.datagroupid = 9 AND c.level = 1");

			if(!StringPool.BLANK.equals(maTinh)){
				sql.append(" AND a.matinh = ?");
			}
			
			if(!StringPool.BLANK.equals(maHuyen)){
				sql.append(" AND a.mahuyen = ?");
			}
			
			if(!StringPool.BLANK.equals(maXa)){
				sql.append(" AND a.maxa = ?");
			}
			
			if(!StringPool.BLANK.equals(topicCode)){
				sql.append(" AND c.code = ?");
			}
			
			if(fromDate != null){
				sql.append(" AND a.thoigiangoi >=?");
			}
			
			if(toDate != null){
				sql.append(" AND a.thoigiangoi <=?");
			}
			
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addScalar("TOTAL", Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);
			
			if(!StringPool.BLANK.equals(maTinh)){
				qPos.add(maTinh);
			}
			
			if(!StringPool.BLANK.equals(maHuyen)){
				qPos.add(maHuyen);
			}
			
			if(!StringPool.BLANK.equals(maXa)){
				qPos.add(maXa);
			}
			
			if(!StringPool.BLANK.equals(topicCode)){
				qPos.add(topicCode);
			}
			
			if(fromDate != null){
				qPos.add(fromDate);
			}
			
			if(toDate != null){
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
	
	public List<TopicPhanHoi> searchTopicPhanHoi(String maTinh, String maHuyen, String maXa, String topicCode, Date fromDate, Date toDate, int start, int end) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			
			StringBuffer sql = new StringBuffer("");
			sql.append(" SELECT DISTINCT  c.code, a.matinh, a.mahuyen, a.maxa, c.name FROM ws_phanhoi.ws_thongtin_phanhoi a"); 
			sql.append(" JOIN ws_phanhoi.ws_chitiet_thongtin_phanhoi b JOIN ns_danhmuc.dm_dataitem c");
			sql.append(" ON a.id = b.thongtin_phanhoi_id and substring(b.mathongtinphananh,1,2) = c.code");
			sql.append(" WHERE c.datagroupid = 9 AND c.level = 1");

			if(!StringPool.BLANK.equals(maTinh)){
				sql.append(" AND a.matinh = ?");
			}
			
			if(!StringPool.BLANK.equals(maHuyen)){
				sql.append(" AND a.mahuyen = ?");
			}
			
			if(!StringPool.BLANK.equals(maXa)){
				sql.append(" AND a.maxa = ?");
			}
			
			if(!StringPool.BLANK.equals(topicCode)){
				sql.append(" AND c.code = ?");
			}
			
			if(fromDate != null){
				sql.append(" AND a.thoigiangoi >= ?");
			}
			
			if(toDate != null){
				sql.append(" AND a.thoigiangoi <= ?");
			}		
			
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.setCacheable(false);				
			q.addScalar("code", Type.STRING);
			q.addScalar("matinh", Type.STRING);	
			q.addScalar("mahuyen", Type.STRING);	
			q.addScalar("maxa", Type.STRING);
			q.addScalar("name", Type.STRING);	
			
			//q.addEntity("TopicPhanHoi", TopicPhanHoiImpl.class);
           
			QueryPos qPos = QueryPos.getInstance(q);
			
			if(!StringPool.BLANK.equals(maTinh)){
				qPos.add(maTinh);
			}
			
			if(!StringPool.BLANK.equals(maHuyen)){
				qPos.add(maHuyen);
			}
			
			if(!StringPool.BLANK.equals(maXa)){
				qPos.add(maXa);
			}
			
			if(!StringPool.BLANK.equals(topicCode)){
				qPos.add(topicCode);
			}
			
			if(fromDate != null){
				qPos.add(fromDate);
			}
			
			if(toDate != null){
				qPos.add(DateTimeUtil.getCuoiNgay(toDate));
			}
				
			Iterator<Object[]> itr = (Iterator<Object[]>) QueryUtil.iterate(q,getDialect(), start, end);
            List<TopicPhanHoi> result = new ArrayList<TopicPhanHoi>();
			while (itr.hasNext()) {
				Object[] a= itr.next();
				TopicPhanHoi tp = new TopicPhanHoiImpl();
				tp.setTopicCode((String)a[0]);
				tp.setMaTinh((String)a[1]);
				tp.setMaHuyen((String)a[2]);
				tp.setMaXa((String)a[3]);
				tp.setTopicName((String)a[4]);
				
				result.add(tp);
			}
			return result;
			
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<TopicPhanHoi> getAllTopicPhanHoi() throws SystemException {
		Session session = null;
		try {
			session = openSession();
			
			StringBuffer sql = new StringBuffer("");
			sql.append(" SELECT DISTINCT code, name FROM ns_danhmuc.dm_dataitem"); 		
			sql.append(" WHERE datagroupid = 9 AND level = 1");

			SQLQuery q = session.createSQLQuery(sql.toString());
			q.setCacheable(false);				
			q.addScalar("code", Type.STRING);
			q.addScalar("name", Type.STRING);			
           
			QueryPos qPos = QueryPos.getInstance(q);			
			Iterator<Object[]> itr = (Iterator<Object[]>) QueryUtil.iterate(q,getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
            List<TopicPhanHoi> result = new ArrayList<TopicPhanHoi>();
			while (itr.hasNext()) {
				Object[] a= itr.next();
				TopicPhanHoi tp = new TopicPhanHoiImpl();
				tp.setTopicCode((String)a[0]);
				tp.setTopicName((String)a[1]);
				result.add(tp);
			}
			return result;
			
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public long countPhanHoiByTopicCode(String topicCode, String maTinh, String maHuyen, String maXa, String feedbackCode, Date fromDate, Date toDate) throws SystemException {
		Session session = null;

		try {
			session = openSession();
			if(!StringPool.BLANK.equals(topicCode)){
				StringBuffer sql = new StringBuffer("");
				sql.append(" SELECT COUNT(DISTINCT a.matinh, a.mahuyen, a.maxa, b.mathongtinphananh) AS TOTAL FROM ws_phanhoi.ws_thongtin_phanhoi a JOIN ws_phanhoi.ws_chitiet_thongtin_phanhoi b");
				sql.append(" on a.id = b.thongtin_phanhoi_id");
				sql.append(" WHERE substring(b.mathongtinphananh,1,2) = ?");
				
				if(!StringPool.BLANK.equals(maTinh)){
					sql.append(" AND a.matinh =?");
				}
				
				if(!StringPool.BLANK.equals(maHuyen)){
					sql.append(" AND a.mahuyen =?");
				}
				
				if(!StringPool.BLANK.equals(maXa)){
					sql.append(" AND a.maxa =?");
				}
				
				if(!StringPool.BLANK.equals(feedbackCode)){
					sql.append(" AND b.mathongtinphananh = ?");
				}
				
				if(fromDate != null){
					sql.append(" AND a.thoigiangoi >=?");
				}
				
				if(toDate != null){
					sql.append(" AND a.thoigiangoi <=?");
				}
				
				SQLQuery q = session.createSQLQuery(sql.toString());
				q.addScalar("TOTAL", Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);	
				qPos.add(topicCode);
				
				if(!StringPool.BLANK.equals(maTinh)){
					qPos.add(maTinh);
				}
				
				if(!StringPool.BLANK.equals(maHuyen)){
					qPos.add(maHuyen);
				}
				
				if(!StringPool.BLANK.equals(maXa)){
					qPos.add(maXa);
				}
				
				if(!StringPool.BLANK.equals(feedbackCode)){
					qPos.add(feedbackCode);
				}
				
				if(fromDate != null){
					qPos.add(fromDate);
				}
				
				if(toDate != null){
					qPos.add(DateTimeUtil.getCuoiNgay(toDate));
				}
				
				Iterator<Long> itr = q.iterate();
				if (itr.hasNext()) {
					Long value = itr.next();
					
					if (value != null) {
						return value;
					}
				}
			}						
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		
		return 0;
	}
	
	public List<TopicDetails> getTopicDetailsByTopicCode(String topicCode, String maTinh, String maHuyen, String maXa, String feedbackCode, Date fromDate, Date toDate, int start, int end) throws SystemException {
		Session session = null;
		List<TopicDetails> lstTopicDetails = new ArrayList<TopicDetails>();
		try {
			session = openSession();
			if(!StringPool.BLANK.equals(topicCode)){
				StringBuffer sql = new StringBuffer("");
				sql.append(" SELECT DISTINCT b.id, a.sodienthoai, a.thoigiangoi, a.tongdai, a.matinh, a.mahuyen, a.maxa, b.matramcapnuoc, b.mathongtinphananh, b.noidungkhac_nuoc, b.noidungkhac_vesinh, b.yeucau_giaitrinh_id");
				sql.append(" FROM ws_phanhoi.ws_thongtin_phanhoi a JOIN ws_phanhoi.ws_chitiet_thongtin_phanhoi b");
				sql.append(" on a.id = b.thongtin_phanhoi_id");
				sql.append(" WHERE substring(b.mathongtinphananh,1,2) = ?");
				
				if(!StringPool.BLANK.equals(maTinh)){
					sql.append(" AND a.matinh =?");
				}
				
				if(!StringPool.BLANK.equals(maHuyen)){
					sql.append(" AND a.mahuyen =?");
				}
				
				if(!StringPool.BLANK.equals(maXa)){
					sql.append(" AND a.maxa =?");
				}
				
				if(!StringPool.BLANK.equals(feedbackCode)){
					sql.append(" AND b.mathongtinphananh = ?");
				}
				
				if(fromDate != null){
					sql.append(" AND a.thoigiangoi >=?");
				}
				
				if(toDate != null){
					sql.append(" AND a.thoigiangoi <=?");
				}
				
				SQLQuery q = session.createSQLQuery(sql.toString());
				q.addEntity("TopicDetails", TopicDetailsImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);	
				qPos.add(topicCode);
				
				if(!StringPool.BLANK.equals(maTinh)){
					qPos.add(maTinh);
				}
				
				if(!StringPool.BLANK.equals(maHuyen)){
					qPos.add(maHuyen);
				}
				
				if(!StringPool.BLANK.equals(maXa)){
					qPos.add(maXa);
				}
				
				if(!StringPool.BLANK.equals(feedbackCode)){
					qPos.add(feedbackCode);
				}
				
				if(fromDate != null){
					qPos.add(fromDate);
				}
				
				if(toDate != null){
					qPos.add(DateTimeUtil.getCuoiNgay(toDate));
				}
						
				lstTopicDetails = (List<TopicDetails>) QueryUtil.list(q, getDialect(), start, end);			
			}
			return lstTopicDetails;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public long countPhanHoiByMaThongTinPhanAnh(String topicCode, String feedbackCode, String maTinh, String maHuyen, String maXa, Date fromDate, Date toDate) throws SystemException {
		Session session = null;

		try {
			session = openSession();
			if(!StringPool.BLANK.equals(topicCode)){
				StringBuffer sql = new StringBuffer("");
				sql.append(" SELECT COUNT(*) AS TOTAL FROM ws_phanhoi.ws_thongtin_phanhoi a JOIN ws_phanhoi.ws_chitiet_thongtin_phanhoi b");
				sql.append(" on a.id = b.thongtin_phanhoi_id");
				sql.append(" WHERE substring(b.mathongtinphananh,1,2) = ?");
				
				if(!StringPool.BLANK.equals(feedbackCode)){
					sql.append(" AND b.mathongtinphananh = ?");
				}
				
				if(!StringPool.BLANK.equals(maTinh)){
					sql.append(" AND a.matinh =?");
				}
				
				if(!StringPool.BLANK.equals(maHuyen)){
					sql.append(" AND a.mahuyen =?");
				}
				
				if(!StringPool.BLANK.equals(maXa)){
					sql.append(" AND a.maxa =?");
				}								
				
				if(fromDate != null){
					sql.append(" AND a.thoigiangoi >=?");
				}
				
				if(toDate != null){
					sql.append(" AND a.thoigiangoi <=?");
				}
				
				sql.append(" GROUP BY a.id, a.mahuyen, a.maxa, b.mathongtinphananh");
				
				SQLQuery q = session.createSQLQuery(sql.toString());
				q.addScalar("TOTAL", Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);	
				qPos.add(topicCode);
				
				if(!StringPool.BLANK.equals(feedbackCode)){
					qPos.add(feedbackCode);
				}
								
				if(!StringPool.BLANK.equals(maTinh)){
					qPos.add(maTinh);
				}
				
				if(!StringPool.BLANK.equals(maHuyen)){
					qPos.add(maHuyen);
				}
				
				if(!StringPool.BLANK.equals(maXa)){
					qPos.add(maXa);
				}
				
				if(fromDate != null){
					qPos.add(fromDate);
				}
				
				if(toDate != null){
					qPos.add(DateTimeUtil.getCuoiNgay(toDate));
				}
				
				Iterator<Long> itr = q.iterate();
				if (itr.hasNext()) {
					Long value = itr.next();
					
					if (value != null) {
						return value;
					}
				}
			}						
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		
		return 0;
	}
	
	public long countPhanHoiGroupByFeedBackCode(String topicCode, String feedbackCode, String maTinh, String maHuyen, String maXa, Date fromDate, Date toDate) throws SystemException {
		Session session = null;

		try {
			session = openSession();
			if(!StringPool.BLANK.equals(topicCode)){
				StringBuffer sql = new StringBuffer("");
				sql.append(" SELECT COUNT(*) AS TOTAL FROM ws_phanhoi.ws_thongtin_phanhoi a JOIN ws_phanhoi.ws_chitiet_thongtin_phanhoi b");
				sql.append(" on a.id = b.thongtin_phanhoi_id");
				sql.append(" WHERE substring(b.mathongtinphananh,1,2) = ? AND (b.yeucau_giaitrinh_id is null OR b.yeucau_giaitrinh_id = 0)");
				
				if(!StringPool.BLANK.equals(feedbackCode)){
					sql.append(" AND b.mathongtinphananh = ?");
				}
				
				if(!StringPool.BLANK.equals(maTinh)){
					sql.append(" AND a.matinh =?");
				}
				
				if(!StringPool.BLANK.equals(maHuyen)){
					sql.append(" AND a.mahuyen =?");
				}
				
				if(!StringPool.BLANK.equals(maXa)){
					sql.append(" AND a.maxa =?");
				}								
				
				if(fromDate != null){
					sql.append(" AND a.thoigiangoi >=?");
				}
				
				if(toDate != null){
					sql.append(" AND a.thoigiangoi <=?");
				}
				
				sql.append(" GROUP BY a.mahuyen, a.maxa, b.mathongtinphananh");
				
				SQLQuery q = session.createSQLQuery(sql.toString());
				q.addScalar("TOTAL", Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);	
				qPos.add(topicCode);
				
				if(!StringPool.BLANK.equals(feedbackCode)){
					qPos.add(feedbackCode);
				}
								
				if(!StringPool.BLANK.equals(maTinh)){
					qPos.add(maTinh);
				}
				
				if(!StringPool.BLANK.equals(maHuyen)){
					qPos.add(maHuyen);
				}
				
				if(!StringPool.BLANK.equals(maXa)){
					qPos.add(maXa);
				}
				
				if(fromDate != null){
					qPos.add(fromDate);
				}
				
				if(toDate != null){
					qPos.add(DateTimeUtil.getCuoiNgay(toDate));
				}
				
				Iterator<Long> itr = q.iterate();
				if (itr.hasNext()) {
					Long value = itr.next();
					
					if (value != null) {
						return value;
					}
				}
			}						
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		
		return 0;
	}
	
	public TopicDetails getTopicDetailsById(long id)throws SystemException {
		Session session = null;
		TopicDetails topicDetails = null;
		List<TopicDetails> lstTopicDetails = new ArrayList<TopicDetails>();
		try {
			session = openSession();
			if(!Validator.isNull(id)){
				StringBuffer sql = new StringBuffer("");
				sql.append(" SELECT b.id, a.sodienthoai, a.thoigiangoi, a.tongdai, a.matinh, a.mahuyen, a.maxa, b.matramcapnuoc, b.mathongtinphananh, b.noidungkhac_nuoc, b.noidungkhac_vesinh, b.yeucau_giaitrinh_id");
				sql.append(" FROM ws_phanhoi.ws_thongtin_phanhoi a JOIN ws_phanhoi.ws_chitiet_thongtin_phanhoi b");
				sql.append(" on a.id = b.thongtin_phanhoi_id");
				sql.append(" WHERE b.id = ").append(id);
								
				SQLQuery q = session.createSQLQuery(sql.toString());
				q.addEntity("TopicDetails", TopicDetailsImpl.class);

				lstTopicDetails = (List<TopicDetails>)QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);	
				topicDetails = lstTopicDetails.size() > 0 ? lstTopicDetails.get(0) : null;				
			}
			return topicDetails;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public long countPhanHoiByTrangThaiYcgt(int trangThaiYcgt, String topicCode, String feedbackCode, String maTinh, String maHuyen, String maXa, Date fromDate, Date toDate) throws SystemException {
		Session session = null;

		try {
			session = openSession();		
			if(!StringPool.BLANK.equals(topicCode)){
				StringBuffer sql = new StringBuffer("");
				sql.append(" SELECT COUNT(*) AS TOTAL FROM (SELECT a.matinh, a.mahuyen, a.maxa, b.mathongtinphananh FROM ws_phanhoi.ws_thongtin_phanhoi a JOIN ws_phanhoi.ws_chitiet_thongtin_phanhoi b");
				sql.append(" on a.id = b.thongtin_phanhoi_id");
				sql.append(" WHERE substring(b.mathongtinphananh,1,2) = ?");
				
				if(!StringPool.BLANK.equals(feedbackCode)){
					sql.append(" AND b.mathongtinphananh =?");
				}
				
				if(trangThaiYcgt >= 0){
					if(trangThaiYcgt == ThongTinPhanHoiConstants.TrangThaiYcgt.DA_TAO_YCGT){
						sql.append(" AND b.yeucau_giaitrinh_id > 0");
					}
					
					if(trangThaiYcgt == ThongTinPhanHoiConstants.TrangThaiYcgt.CHUA_TAO_YCGT){
						sql.append(" AND (b.yeucau_giaitrinh_id is null OR b.yeucau_giaitrinh_id = 0)");
					}
				}
				
				if(!StringPool.BLANK.equals(maTinh)){
					sql.append(" AND a.matinh =?");
				}
				
				if(!StringPool.BLANK.equals(maHuyen)){
					sql.append(" AND a.mahuyen =?");
				}
				
				if(!StringPool.BLANK.equals(maXa)){
					sql.append(" AND a.maxa =?");
				}
				
				if(fromDate != null){
					sql.append(" AND a.thoigiangoi >=?");
				}
				
				if(toDate != null){
					sql.append(" AND a.thoigiangoi <=?");
				}
				
				sql.append(" GROUP BY a.id, a.matinh, a.mahuyen, a.maxa, b.mathongtinphananh) t");
				
				SQLQuery q = session.createSQLQuery(sql.toString());
				q.addScalar("TOTAL", Type.LONG);
	
				QueryPos qPos = QueryPos.getInstance(q);				
				qPos.add(topicCode);
				
				if(!StringPool.BLANK.equals(feedbackCode)){
					qPos.add(feedbackCode);
				}								
				
				if(!StringPool.BLANK.equals(maTinh)){
					qPos.add(maTinh);
				}
				
				if(!StringPool.BLANK.equals(maHuyen)){
					qPos.add(maHuyen);
				}
				
				if(!StringPool.BLANK.equals(maXa)){
					qPos.add(maXa);
				}
				
				if(fromDate != null){
					qPos.add(fromDate);
				}
				
				if(toDate != null){					
					qPos.add(DateTimeUtil.getCuoiNgay(toDate));
				}
				
				Iterator<Long> itr = q.iterate();
				if (itr.hasNext()) {
					Long value = itr.next();
					
					if (value != null) {
						return value;
					}		
				}		
			}
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		
		return 0;
	}
	
	public List<TopicDetails> getTopicDetailsByTrangThaiYcgt(int trangThaiYcgt, String topicCode, String feedbackCode, String maTinh, String maHuyen, String maXa, Date fromDate, Date toDate, int start, int end) throws SystemException {
		Session session = null;		
		try {
			session = openSession();
			if(!StringPool.BLANK.equals(topicCode)){
				StringBuffer sql = new StringBuffer("");
				sql.append(" SELECT b.id, a.sodienthoai, a.thoigiangoi, a.tongdai, a.matinh, a.mahuyen, a.maxa,  b.matramcapnuoc, b.mathongtinphananh, b.noidungkhac_nuoc, b.noidungkhac_vesinh, b.yeucau_giaitrinh_id");
				sql.append(" FROM ws_phanhoi.ws_thongtin_phanhoi a JOIN ws_phanhoi.ws_chitiet_thongtin_phanhoi b");
				sql.append(" on a.id = b.thongtin_phanhoi_id");
				sql.append(" WHERE substring(b.mathongtinphananh,1,2) = ?");
				
				if(!StringPool.BLANK.equals(feedbackCode)){
					sql.append(" AND b.mathongtinphananh =?");
				}
				
				if(trangThaiYcgt >= 0){
					if(trangThaiYcgt == ThongTinPhanHoiConstants.TrangThaiYcgt.DA_TAO_YCGT){
						sql.append(" AND b.yeucau_giaitrinh_id > 0");
					}
					
					if(trangThaiYcgt == ThongTinPhanHoiConstants.TrangThaiYcgt.CHUA_TAO_YCGT){
						sql.append(" AND (b.yeucau_giaitrinh_id is null OR b.yeucau_giaitrinh_id = 0)");
					}
				}

				if(!StringPool.BLANK.equals(maTinh)){
					sql.append(" AND a.matinh =?");
				}
				
				if(!StringPool.BLANK.equals(maHuyen)){
					sql.append(" AND a.mahuyen =?");
				}
				
				if(!StringPool.BLANK.equals(maXa)){
					sql.append(" AND a.maxa =?");
				}
				
				if(fromDate != null){
					sql.append(" AND a.thoigiangoi >=?");
				}
				
				if(toDate != null){
					sql.append(" AND a.thoigiangoi <=?");
				}
				
				sql.append(" GROUP BY a.id, a.matinh, a.mahuyen, a.maxa, b.mathongtinphananh");
				
				SQLQuery q = session.createSQLQuery(sql.toString());
				q.addEntity("TopicDetails", TopicDetailsImpl.class);
	
				QueryPos qPos = QueryPos.getInstance(q);	
				qPos.add(topicCode);
				
				if(!StringPool.BLANK.equals(feedbackCode)){
					qPos.add(feedbackCode);
				}
				
				if(!StringPool.BLANK.equals(maTinh)){
					qPos.add(maTinh);
				}
				
				if(!StringPool.BLANK.equals(maHuyen)){
					qPos.add(maHuyen);
				}
				
				if(!StringPool.BLANK.equals(maXa)){
					qPos.add(maXa);
				}
				
				if(fromDate != null){
					qPos.add(fromDate);
				}
				
				if(toDate != null){
					
					qPos.add(DateTimeUtil.getCuoiNgay(toDate));
				}
						
				return (List<TopicDetails>) QueryUtil.list(q, getDialect(), start, end);	
			}
			
			return null;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	
	public long countPhanHoiByTrangThaiYcgtAndGroupByFeedbackCode(int trangThaiYcgt, String topicCode, String feedbackCode, String maTinh, String maHuyen, String maXa, Date fromDate, Date toDate) throws SystemException {
		Session session = null;

		try {
			session = openSession();		
			if(!StringPool.BLANK.equals(topicCode)){
				StringBuffer sql = new StringBuffer("");
				sql.append(" SELECT COUNT(*) AS TOTAL FROM (SELECT a.matinh, a.mahuyen, a.maxa, b.mathongtinphananh FROM ws_phanhoi.ws_thongtin_phanhoi a JOIN ws_phanhoi.ws_chitiet_thongtin_phanhoi b");
				sql.append(" on a.id = b.thongtin_phanhoi_id");
				sql.append(" WHERE substring(b.mathongtinphananh,1,2) = ?");
				
				if(!StringPool.BLANK.equals(feedbackCode)){
					sql.append(" AND b.mathongtinphananh =?");
				}
				
				if(trangThaiYcgt >= 0){
					if(trangThaiYcgt == ThongTinPhanHoiConstants.TrangThaiYcgt.DA_TAO_YCGT){
						sql.append(" AND b.yeucau_giaitrinh_id > 0");
					}
					
					if(trangThaiYcgt == ThongTinPhanHoiConstants.TrangThaiYcgt.CHUA_TAO_YCGT){
						sql.append(" AND (b.yeucau_giaitrinh_id is null OR b.yeucau_giaitrinh_id = 0)");
					}
				}
				
				if(!StringPool.BLANK.equals(maTinh)){
					sql.append(" AND a.matinh =?");
				}
				
				if(!StringPool.BLANK.equals(maHuyen)){
					sql.append(" AND a.mahuyen =?");
				}
				
				if(!StringPool.BLANK.equals(maXa)){
					sql.append(" AND a.maxa =?");
				}
				
				if(fromDate != null){
					sql.append(" AND a.thoigiangoi >=?");
				}
				
				if(toDate != null){
					sql.append(" AND a.thoigiangoi <=?");
				}
				
				sql.append(" GROUP BY  a.matinh, a.mahuyen, a.maxa, b.mathongtinphananh) t");
				
				SQLQuery q = session.createSQLQuery(sql.toString());
				q.addScalar("TOTAL", Type.LONG);
	
				QueryPos qPos = QueryPos.getInstance(q);				
				qPos.add(topicCode);
				
				if(!StringPool.BLANK.equals(feedbackCode)){
					qPos.add(feedbackCode);
				}								
				
				if(!StringPool.BLANK.equals(maTinh)){
					qPos.add(maTinh);
				}
				
				if(!StringPool.BLANK.equals(maHuyen)){
					qPos.add(maHuyen);
				}
				
				if(!StringPool.BLANK.equals(maXa)){
					qPos.add(maXa);
				}
				
				if(fromDate != null){
					qPos.add(fromDate);
				}
				
				if(toDate != null){					
					qPos.add(DateTimeUtil.getCuoiNgay(toDate));
				}
				
				Iterator<Long> itr = q.iterate();
				if (itr.hasNext()) {
					Long value = itr.next();
					
					if (value != null) {
						return value;
					}		
				}		
			}
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		
		return 0;
	}
	
	public List<TopicDetails> getTopicDetailsByTrangThaiYcgtAndGroupByFeedbackCode(int trangThaiYcgt, String topicCode, String feedbackCode, String maTinh, String maHuyen, String maXa, Date fromDate, Date toDate, int start, int end) throws SystemException {
		Session session = null;		
		try {
			session = openSession();
			if(!StringPool.BLANK.equals(topicCode)){
				StringBuffer sql = new StringBuffer("");
				sql.append(" SELECT b.id, a.sodienthoai, a.thoigiangoi, a.tongdai, a.matinh, a.mahuyen, a.maxa,  b.matramcapnuoc, b.mathongtinphananh, b.noidungkhac_nuoc, b.noidungkhac_vesinh, b.yeucau_giaitrinh_id");
				sql.append(" FROM ws_phanhoi.ws_thongtin_phanhoi a JOIN ws_phanhoi.ws_chitiet_thongtin_phanhoi b");
				sql.append(" on a.id = b.thongtin_phanhoi_id");
				sql.append(" WHERE substring(b.mathongtinphananh,1,2) = ?");
				
				if(!StringPool.BLANK.equals(feedbackCode)){
					sql.append(" AND b.mathongtinphananh =?");
				}
				
				if(trangThaiYcgt >= 0){
					if(trangThaiYcgt == ThongTinPhanHoiConstants.TrangThaiYcgt.DA_TAO_YCGT){
						sql.append(" AND b.yeucau_giaitrinh_id > 0");
					}
					
					if(trangThaiYcgt == ThongTinPhanHoiConstants.TrangThaiYcgt.CHUA_TAO_YCGT){
						sql.append(" AND (b.yeucau_giaitrinh_id is null OR b.yeucau_giaitrinh_id = 0)");
					}
				}

				if(!StringPool.BLANK.equals(maTinh)){
					sql.append(" AND a.matinh =?");
				}
				
				if(!StringPool.BLANK.equals(maHuyen)){
					sql.append(" AND a.mahuyen =?");
				}
				
				if(!StringPool.BLANK.equals(maXa)){
					sql.append(" AND a.maxa =?");
				}
				
				if(fromDate != null){
					sql.append(" AND a.thoigiangoi >=?");
				}
				
				if(toDate != null){
					sql.append(" AND a.thoigiangoi <=?");
				}
				
				sql.append(" GROUP BY a.matinh, a.mahuyen, a.maxa, b.mathongtinphananh");
				
				SQLQuery q = session.createSQLQuery(sql.toString());
				q.addEntity("TopicDetails", TopicDetailsImpl.class);
	
				QueryPos qPos = QueryPos.getInstance(q);	
				qPos.add(topicCode);
				
				if(!StringPool.BLANK.equals(feedbackCode)){
					qPos.add(feedbackCode);
				}
				
				if(!StringPool.BLANK.equals(maTinh)){
					qPos.add(maTinh);
				}
				
				if(!StringPool.BLANK.equals(maHuyen)){
					qPos.add(maHuyen);
				}
				
				if(!StringPool.BLANK.equals(maXa)){
					qPos.add(maXa);
				}
				
				if(fromDate != null){
					qPos.add(fromDate);
				}
				
				if(toDate != null){
					
					qPos.add(DateTimeUtil.getCuoiNgay(toDate));
				}
						
				return (List<TopicDetails>) QueryUtil.list(q, getDialect(), start, end);	
			}
			
			return null;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public long countTopicDetailsByYcgtId(long ycgtId) throws SystemException {
		Session session = null;

		try {
			session = openSession();		
			if(Validator.isNotNull(ycgtId)){
				StringBuffer sql = new StringBuffer("");
				sql.append(" SELECT COUNT(*) AS TOTAL FROM ws_phanhoi.ws_thongtin_phanhoi a JOIN ws_phanhoi.ws_chitiet_thongtin_phanhoi b");
				sql.append(" on a.id = b.thongtin_phanhoi_id");
				sql.append(" WHERE b.yeucau_giaitrinh_id = ?");							
				
				SQLQuery q = session.createSQLQuery(sql.toString());
				q.addScalar("TOTAL", Type.LONG);
	
				QueryPos qPos = QueryPos.getInstance(q);				
				qPos.add(ycgtId);								
				
				Iterator<Long> itr = q.iterate();
				if (itr.hasNext()) {
					Long value = itr.next();
					
					if (value != null) {
						return value;
					}		
				}		
			}
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		
		return 0;
	}
	
	public List<TopicDetails> getTopicDetailsByYcgtId(long ycgtId, int start, int end) throws SystemException {
		Session session = null;		
		try {
			session = openSession();
			if(Validator.isNotNull(ycgtId)){
				StringBuffer sql = new StringBuffer("");
				sql.append(" SELECT b.id, a.sodienthoai, a.thoigiangoi, a.tongdai, a.matinh, a.mahuyen, a.maxa,  b.matramcapnuoc, b.mathongtinphananh, b.noidungkhac_nuoc, b.noidungkhac_vesinh, b.yeucau_giaitrinh_id");
				sql.append(" FROM ws_phanhoi.ws_thongtin_phanhoi a JOIN ws_phanhoi.ws_chitiet_thongtin_phanhoi b");
				sql.append(" on a.id = b.thongtin_phanhoi_id");
				sql.append(" WHERE b.yeucau_giaitrinh_id = ?");								
				
				SQLQuery q = session.createSQLQuery(sql.toString());
				q.addEntity("TopicDetails", TopicDetailsImpl.class);
	
				QueryPos qPos = QueryPos.getInstance(q);	
				qPos.add(ycgtId);
								
				return (List<TopicDetails>) QueryUtil.list(q, getDialect(), start, end);	
			}
			
			return null;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<ChiTietThongTinPhanHoi> getChiTietThongTinPhanHoiBy_ttphId_thx(long thongTinPhanHoiId, String maTinh, String maHuyen, String maXa)throws SystemException {
		Session session = null;				
		try {
			session = openSession();
			if(Validator.isNotNull(thongTinPhanHoiId)){
				StringBuffer sql = new StringBuffer("");
				sql.append(" SELECT a.id, a.thongtin_phanhoi_id, a.yeucau_giaitrinh_id, a.mathongtinphananh FROM ws_phanhoi.ws_chitiet_thongtin_phanhoi a JOIN ws_phanhoi.ws_thongtin_phanhoi b");				
				sql.append(" ON a.thongtin_phanhoi_id = b.id");
				sql.append(" WHERE b.thongtin_phanhoi_id = ?");
				
				if(!StringPool.BLANK.equals(maTinh)){
					sql.append(" AND b.matinh= ? ");
				}
				
				if(!StringPool.BLANK.equals(maHuyen)){
					sql.append(" AND b.mahuyen= ? ");
				}
				
				if(!StringPool.BLANK.equals(maXa)){
					sql.append(" AND b.maxa= ? ");
				}				
				
				SQLQuery q = session.createSQLQuery(sql.toString());
				q.addEntity("TopicDetails", TopicDetailsImpl.class);
	
				QueryPos qPos = QueryPos.getInstance(q);	
				qPos.add(thongTinPhanHoiId);
				
				if(!StringPool.BLANK.equals(maTinh)){
					qPos.add(maTinh);
				}
				
				if(!StringPool.BLANK.equals(maHuyen)){
					qPos.add(maHuyen);
				}
				
				if(!StringPool.BLANK.equals(maXa)){
					qPos.add(maXa);
				}
												
				return (List<ChiTietThongTinPhanHoi>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			}
			
			return null;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	

	public long countThongKePhanHoi(String maTinh, int month, int year) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			StringBuffer sql = new StringBuffer("");
			sql.append(" SELECT COUNT(DISTINCT c.code) AS TOTAL FROM ws_phanhoi.ws_thongtin_phanhoi a"); 
			sql.append(" JOIN ws_phanhoi.ws_chitiet_thongtin_phanhoi b JOIN ns_danhmuc.dm_dataitem c");
			sql.append(" ON a.id = b.thongtin_phanhoi_id and substring(b.mathongtinphananh,1,2) = c.code");
			sql.append(" WHERE c.datagroupid = 9 AND c.level = 1");

			if(!StringPool.BLANK.equals(maTinh)){
				sql.append(" AND a.matinh = ?");
			}
						
			if(month > 0){
				sql.append(" AND MONTH(a.thoigiangoi) = ?");
			}
			
			if(year > 0){
				sql.append(" AND YEAR(a.thoigiangoi) = ?");
			}
			
			//sql.append(" GROUP BY c.code");
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addScalar("TOTAL", Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);
			
			if(!StringPool.BLANK.equals(maTinh)){
				qPos.add(maTinh);
			}						
			
			if(month > 0){
				qPos.add(month);
			}
			
			if(year > 0){
				qPos.add(year);
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
	
	public List<TopicPhanHoi> searchThongKePhanHoi(String maTinh, int month, int year, int start, int end) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			
			StringBuffer sql = new StringBuffer("");
			sql.append(" SELECT DISTINCT  c.code, a.matinh, a.mahuyen, a.maxa, c.name FROM ws_phanhoi.ws_thongtin_phanhoi a"); 
			sql.append(" JOIN ws_phanhoi.ws_chitiet_thongtin_phanhoi b JOIN ns_danhmuc.dm_dataitem c");
			sql.append(" ON a.id = b.thongtin_phanhoi_id AND substring(b.mathongtinphananh,1,2) = c.code");
			sql.append(" WHERE c.datagroupid = 9 AND c.level = 1");

			if(!StringPool.BLANK.equals(maTinh)){
				sql.append(" AND a.matinh = ?");
			}
						
			if(month > 0){
				sql.append(" AND MONTH(a.thoigiangoi) = ?");
			}
			
			if(year > 0){
				sql.append(" AND YEAR(a.thoigiangoi) = ?");
			}		
			
			sql.append(" GROUP BY c.code");
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.setCacheable(false);				
			q.addScalar("code", Type.STRING);
			q.addScalar("matinh", Type.STRING);	
			q.addScalar("mahuyen", Type.STRING);	
			q.addScalar("maxa", Type.STRING);
			q.addScalar("name", Type.STRING);							
           
			QueryPos qPos = QueryPos.getInstance(q);
			
			if(!StringPool.BLANK.equals(maTinh)){
				qPos.add(maTinh);
			}
			
			if(month > 0){
				qPos.add(month);
			}
			
			if(year > 0){
				qPos.add(year);
			}
				
			Iterator<Object[]> itr = (Iterator<Object[]>) QueryUtil.iterate(q,getDialect(), start, end);
            List<TopicPhanHoi> result = new ArrayList<TopicPhanHoi>();
			while (itr.hasNext()) {
				Object[] a= itr.next();
				TopicPhanHoi tp = new TopicPhanHoiImpl();
				tp.setTopicCode((String)a[0]);
				tp.setMaTinh((String)a[1]);
				tp.setMaHuyen((String)a[2]);
				tp.setMaXa((String)a[3]);
				tp.setTopicName((String)a[4]);
				
				result.add(tp);
			}
			return result;
			
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public long countThongKePhanHoiByTrangThai(int trangThaiYcgt, String topicCode, String maTinh, Date fromDate, Date toDate) throws SystemException {	
		Session session = null;

		try {
			session = openSession();		
			if(!StringPool.BLANK.equals(topicCode)){
				StringBuffer sql = new StringBuffer("");
				sql.append(" SELECT COUNT(*) AS TOTAL FROM (SELECT a.matinh, a.mahuyen, a.maxa, b.mathongtinphananh FROM ws_phanhoi.ws_thongtin_phanhoi a JOIN ws_phanhoi.ws_chitiet_thongtin_phanhoi b ");
				sql.append(" ON a.id = b.thongtin_phanhoi_id");
				sql.append(" WHERE substring(b.mathongtinphananh,1,2) = ?");
				
				if(trangThaiYcgt >= 0){
					if(trangThaiYcgt == ThongTinPhanHoiConstants.TrangThaiYcgt.DA_TAO_YCGT){
						sql.append(" AND b.yeucau_giaitrinh_id > 0");
					}
					
					if(trangThaiYcgt == ThongTinPhanHoiConstants.TrangThaiYcgt.CHUA_TAO_YCGT){
						sql.append(" AND (b.yeucau_giaitrinh_id is null OR b.yeucau_giaitrinh_id = 0)");
					}
				}
				
				if(!StringPool.BLANK.equals(maTinh)){
					sql.append(" AND a.matinh =?");
				}				
				
				if(fromDate != null){
					sql.append(" AND a.thoigiangoi >=?");
				}
				
				if(toDate != null){
					sql.append(" AND a.thoigiangoi <=?");
				}
				
				sql.append(" GROUP BY a.matinh, a.mahuyen, a.maxa, b.mathongtinphananh) t");
				
				SQLQuery q = session.createSQLQuery(sql.toString());
				q.addScalar("TOTAL", Type.LONG);
	
				QueryPos qPos = QueryPos.getInstance(q);				
				qPos.add(topicCode);
				
				if(!StringPool.BLANK.equals(maTinh)){
					qPos.add(maTinh);
				}
			
				if(fromDate != null){
					qPos.add(fromDate);
				}
				
				if(toDate != null){					
					qPos.add(DateTimeUtil.getCuoiNgay(toDate));
				}
				
				Iterator<Long> itr = q.iterate();
				if (itr.hasNext()) {
					Long value = itr.next();
					
					if (value != null) {
						return value;
					}		
				}		
			}
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		
		return 0;
	}
}
