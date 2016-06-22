package vn.dtt.ns.thongtinphanhoi.business;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.cmon.dm.dao.model.DATAITEM;
import vn.dtt.cmon.dm.dao.service.DATAITEMLocalServiceUtil;
import vn.dtt.cmon.user.dao.model.UserMapping;
import vn.dtt.ns.thongtinphanhoi.business.UserMappingBusiness;
import vn.dtt.ns.thongtinphanhoi.util.NuocSachUtils;
import vn.dtt.ns.thongtinphanhoi.util.WebKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;

public class DataItemBusiness {

	public static DATAITEM getByNode3Id(long datagroupId, String node3) {

		DATAITEM dataItem = null;

		if (!node3.trim().contentEquals("")) {
			try {
				dataItem = DATAITEMLocalServiceUtil
						.getNode3(datagroupId, node3);
			} catch (Exception e) {
				_log.error(e);
			}
		}

		return dataItem;
	}

	/**
	 * @param datagroupId
	 * @param node2
	 * @return
	 */
	public static DATAITEM getByNode2Id(long datagroupId, String node1,
			String node2) {
		DATAITEM dataItem = null;

		if (!node2.trim().contentEquals("")) {
			try {
				dataItem = DATAITEMLocalServiceUtil.getNode2(datagroupId,
						node1, node2);
			} catch (Exception e) {
				_log.error(e);
			}
		}

		return dataItem;
	}

	/**
	 * @param datagroupId
	 * @param node1
	 * @return
	 */
	public static DATAITEM getByNode1Id(long datagroupId, String node1) {
		DATAITEM dataItem = null;
		if (!node1.trim().contentEquals("")) {

			try {
				dataItem = DATAITEMLocalServiceUtil
						.getNode1(datagroupId, node1);
			} catch (Exception e) {
				_log.error(e);
			}
		}
		return dataItem;
	}

	/**
	 * @param id
	 * @return
	 */
	public static DATAITEM getDataItemById(long id) {
		DATAITEM dataItem = null;
		if (id > 0) {
			try {
				dataItem = DATAITEMLocalServiceUtil.getDATAITEM(id);
			} catch (Exception e) {
				_log.error(e);
			}
		}
		return dataItem;
	}

	/**
	 * Get DATAITEM by dataGroupId
	 * 
	 * @param dataGroupId
	 * @return
	 */
	public static List<DATAITEM> getByDataGroupId(long dataGroupId) {
		List<DATAITEM> ls = new ArrayList<DATAITEM>();

		try {
			ls = DATAITEMLocalServiceUtil.getByDataGroupId(dataGroupId);
		} catch (Exception e) {
			_log.error(e);
		}

		return ls;
	}

	/**
	 * Get DATAITEM by dataGroupId in range
	 * 
	 * @param dataGroupId
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<DATAITEM> getByDataGroupId(long dataGroupId, int start,
			int end) {
		List<DATAITEM> ls = new ArrayList<DATAITEM>();

		try {
			ls = DATAITEMLocalServiceUtil.getByDataGroupId(dataGroupId, start,
					end);
		} catch (Exception e) {
			_log.error(e);
		}

		return ls;
	}

	/**
	 * Count DATAITEM by dataGroupId
	 * 
	 * @param dataGroupId
	 * @return
	 */
	public static int countByDataGroupId(long dataGroupId) {
		int count = 0;

		try {
			count = DATAITEMLocalServiceUtil.countByDataGroupId(dataGroupId);
		} catch (Exception e) {
			_log.error(e);
		}

		return count;
	}

	/**
	 * Get DATAITEM in Level1
	 * 
	 * @param dataGroupId
	 * @return
	 */
	public static List<DATAITEM> getInLevel1(long dataGroupId) {

		List<DATAITEM> ls = new ArrayList<DATAITEM>();

		try {
			ls = DATAITEMLocalServiceUtil.getByDataGroupLevel1(dataGroupId);
		} catch (Exception e) {
			_log.error(e);
		}

		return ls;

	}

	/**
	 * Get DATAITEM in Level1 in range
	 * 
	 * @param dataGroupId
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<DATAITEM> getInLevel1(long dataGroupId, int start,
			int end) {

		List<DATAITEM> ls = new ArrayList<DATAITEM>();

		try {
			ls = DATAITEMLocalServiceUtil.getByDataGroupLevel1(dataGroupId,
					start, end);
		} catch (Exception e) {
			_log.error(e);
		}

		return ls;

	}

	/**
	 * Count DATAITEM in Level1
	 * 
	 * @param dataGroupId
	 * @return
	 */
	public static int countInLevel1(long dataGroupId) {
		int count = 0;

		try {
			count = DATAITEMLocalServiceUtil
					.countByDataGroupLevel1(dataGroupId);
		} catch (Exception e) {
			_log.error(e);
		}

		return count;
	}

	/**
	 * @param dataGroupId
	 * @param node1
	 * @return
	 */
	public static List<DATAITEM> getInLevel2(long dataGroupId, String node1) {

		List<DATAITEM> ls = new ArrayList<DATAITEM>();

		try {
			ls = DATAITEMLocalServiceUtil.getByDataGroupLevel2(dataGroupId,
					node1);

		} catch (Exception e) {
			_log.error(e);
		}

		return ls;

	}

	/**
	 * Get DATAITEM in Level2
	 * 
	 * @param dataGroupId
	 * @param node1
	 * @return
	 */
	public static List<DATAITEM> getInLevel2(long dataGroupId, String node1,
			User user) {

		UserMapping um = UserMappingBusiness.getUserMapping(user);

		int userType = 0;

		if (Validator.isNotNull(um)) {
			userType = um.getUserType();
		}

		List<DATAITEM> ls = new ArrayList<DATAITEM>();

		try {
			if (userType != 3) {
				ls = DATAITEMLocalServiceUtil.getByDataGroupLevel2(dataGroupId,
						node1);
			} else {
				DATAITEM di = null;
				try {
					di = NuocSachUtils.getDataItem(
							(int) WebKeys.DATAGROUPID_DONVIHANHCHINH, 2,
							um.getOrgCode2());
				} catch (Exception e) {
					_log.error(e);
				}

				if (Validator.isNotNull(di)) {
					ls.add(di);
				}
			}

		} catch (Exception e) {
			_log.error(e);
		}

		return ls;

	}

	/**
	 * Get DATAITEM in Level2 in range
	 * 
	 * @param dataGroupId
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<DATAITEM> getInLevel2(long dataGroupId, String node1,
			int start, int end) {

		List<DATAITEM> ls = new ArrayList<DATAITEM>();

		try {
			ls = DATAITEMLocalServiceUtil.getByDataGroupLevel2(dataGroupId,
					node1, start, end);
		} catch (Exception e) {
			_log.error(e);
		}

		return ls;

	}

	/**
	 * Count DATAITEM in Level2
	 * 
	 * @param dataGroupId
	 * @return
	 */
	public static int countInLevel2(long dataGroupId, String node1) {
		int count = 0;

		try {
			count = DATAITEMLocalServiceUtil.countByDataGroupLevel2(
					dataGroupId, node1);
		} catch (Exception e) {
			_log.error(e);
		}

		return count;
	}

	/**
	 * Get DATAITEM in Level3
	 * 
	 * @param dataGroupId
	 * @param node1
	 * @param node2
	 * @return
	 */
	public static List<DATAITEM> getInLevel3(long dataGroupId, String node1,
			String node2) {

		List<DATAITEM> ls = new ArrayList<DATAITEM>();

		try {
			ls = DATAITEMLocalServiceUtil.getByDataGroupLevel3(dataGroupId,
					node1, node2);
		} catch (Exception e) {
			_log.error(e);
		}

		return ls;

	}

	/**
	 * Get DATAITEM in Level3
	 * 
	 * @param dataGroupId
	 * @param node1
	 * @param node2
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<DATAITEM> getInLevel3(long dataGroupId, String node1,
			String node2, int start, int end) {

		List<DATAITEM> ls = new ArrayList<DATAITEM>();

		try {
			ls = DATAITEMLocalServiceUtil.getByDataGroupLevel3(dataGroupId,
					node1, node2, start, end);
		} catch (Exception e) {
			_log.error(e);
		}

		return ls;

	}

	/**
	 * Count DATAITEM in Level3s
	 * 
	 * @param dataGroupId
	 * @param node1
	 * @param node2
	 * @return
	 */
	public static DATAITEM getDataItem(int dataGroupId, int level, String node){
		DATAITEM result = null;
		try{
			result = DATAITEMLocalServiceUtil.getDataItem(dataGroupId, level, node);
		}catch (Exception e) {
			_log.error(e);
		}
		return result;
	}
	public static int countInLevel3(long dataGroupId, String node1, String node2) {
		int count = 0;

		try {
			count = DATAITEMLocalServiceUtil.countByDataGroupLevel3(
					dataGroupId, node1, node2);
		} catch (Exception e) {
			_log.error(e);
		}

		return count;
	}

	/**
	 * @param ten
	 *            tinh thanh
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public static DATAITEM getDATAITEMByTen(String name, String maUni)
			throws PortalException, SystemException, NullPointerException {
		DATAITEM result = null;
		List<DATAITEM> resultList = new ArrayList<DATAITEM>();
		resultList = DATAITEMLocalServiceUtil.getDATAITEMByTen(name);
		_log.info(maUni + "tinh" + name + "///" + resultList.size());
		if (maUni.isEmpty() && resultList.size() > 0) {
			result = resultList.get(0);
		} else if (!maUni.isEmpty() && resultList.size() > 0) {
			for (DATAITEM dataitem : resultList) {
				_log.info("dataitem" + dataitem);
				if (dataitem.getNode1().equalsIgnoreCase(maUni)
						|| dataitem.getNode2().equalsIgnoreCase(maUni)) {
					result = dataitem;
					break;
				}
			}
		}
		return result;
	}
	
	
	
	public static DATAITEM getDATAITEMByTen(String name, String maUni,int lever) throws PortalException, SystemException,NullPointerException {
		return DATAITEMLocalServiceUtil.findDataItemByName(name, maUni, lever);
		
		/*		DATAITEM result = null;
		List<DATAITEM> resultList = new ArrayList<DATAITEM>();
		
		_log.info("@@@@@@@@@name_"+name+"----maUni_"+maUni+"----level_"+lever);
		
		resultList =DATAITEMLocalServiceUtil.getDATAITEMByTen(name);
		_log.info(maUni+"tinh"+name+"///"+resultList.size());
		if(maUni.isEmpty() && resultList.size()>0){
			result = resultList.get(0);
		}else if(!maUni.isEmpty() && resultList.size()>0){
			for (DATAITEM dataitem : resultList) {
				_log.info("dataitem"+dataitem);
				if(lever == 2 && dataitem.getNode1().equalsIgnoreCase(maUni) && dataitem.getLevel() == 2){
					result = dataitem;
					break;
				}else if(lever == 3 && dataitem.getNode2().equalsIgnoreCase(maUni) && dataitem.getLevel() == 3){
					result = dataitem;
					break;
				}
//				if(dataitem.getNode1().equalsIgnoreCase(maUni) || dataitem.getNode2().equalsIgnoreCase(maUni)){
//					result = dataitem;
//					break;
//				}
			}
		}
		return result;*/
		
		
	}
	private static Log _log = LogFactoryUtil.getLog(DataItemBusiness.class);
}
