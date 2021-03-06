package vn.dtt.ns.yeucaugiaitrinh.dao.service.persistence;

import java.util.List;

import vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh;
import vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh;
import vn.dtt.ns.yeucaugiaitrinh.dao.model.impl.TrangThaiGiaiTrinhImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class TrangThaiGiaiTrinhFinderImpl extends BasePersistenceImpl<YeuCauGiaiTrinh> implements TrangThaiGiaiTrinhFinder{

	public TrangThaiGiaiTrinh getTrangThaiGiaiTrinhByYcgtId(long ycgtId) throws SystemException {
		Session session = null;
				
		try {			
			session = openSession();
			if(Validator.isNotNull(ycgtId)){
				StringBuffer sql = new StringBuffer("");
				sql.append(" SELECT * FROM ws_phanhoi.ws_trangthai_giaitrinh");
				sql.append(" WHERE id = (SELECT max(id) FROM ws_phanhoi.ws_trangthai_giaitrinh WHERE yeucau_giaitrinh_id = ? AND userId > 0)");				
		
				SQLQuery q = session.createSQLQuery(sql.toString());
				q.setCacheable(false);						
				
				q.addEntity("TrangThaiGiaiTrinh", TrangThaiGiaiTrinhImpl.class);
	           
				QueryPos qPos = QueryPos.getInstance(q);
				qPos.add(ycgtId);
				
				List<TrangThaiGiaiTrinh> lstTrangThaiGiaiTrinh =  (List<TrangThaiGiaiTrinh>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);	
				if(lstTrangThaiGiaiTrinh != null && lstTrangThaiGiaiTrinh.size() > 0){
					return lstTrangThaiGiaiTrinh.get(0);
				}
			}
			
			return null;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}		
	
	public TrangThaiGiaiTrinh getTrangThaiGiaiTrinhByYcgtIdAndTrangThai(long ycgtId, int trangThai) throws SystemException {
		Session session = null;
				
		try {			
			session = openSession();
			if(Validator.isNotNull(ycgtId)){
				StringBuffer sql = new StringBuffer("");
				sql.append(" SELECT * FROM ws_phanhoi.ws_trangthai_giaitrinh");
				sql.append(" WHERE id = (SELECT max(id) FROM ws_phanhoi.ws_trangthai_giaitrinh WHERE yeucau_giaitrinh_id = ? AND trangthai = ? AND (userId is null OR userId = 0))");				
		
				SQLQuery q = session.createSQLQuery(sql.toString());
				q.setCacheable(false);						
				
				q.addEntity("TrangThaiGiaiTrinh", TrangThaiGiaiTrinhImpl.class);
	           
				QueryPos qPos = QueryPos.getInstance(q);
				qPos.add(ycgtId);
				qPos.add(trangThai);
				
				List<TrangThaiGiaiTrinh> lstTrangThaiGiaiTrinh =  (List<TrangThaiGiaiTrinh>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);	
				if(lstTrangThaiGiaiTrinh != null && lstTrangThaiGiaiTrinh.size() > 0){
					return lstTrangThaiGiaiTrinh.get(0);
				}
			}
			
			return null;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}		
}
