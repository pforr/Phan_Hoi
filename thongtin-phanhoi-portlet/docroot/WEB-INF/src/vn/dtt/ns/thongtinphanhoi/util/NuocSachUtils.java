package vn.dtt.ns.thongtinphanhoi.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vn.dtt.cmon.dm.dao.model.DATAITEM;
import vn.dtt.cmon.dm.dao.service.DATAITEMLocalServiceUtil;
import vn.dtt.cmon.user.dao.model.UserHuyen;
import vn.dtt.cmon.user.dao.model.UserMapping;
import vn.dtt.cmon.user.dao.model.UserTU;
import vn.dtt.cmon.user.dao.model.UserTramCap;
import vn.dtt.cmon.user.dao.service.UserHuyenLocalServiceUtil;
import vn.dtt.cmon.user.dao.service.UserTULocalServiceUtil;
import vn.dtt.cmon.user.dao.service.UserTramCapLocalServiceUtil;
import vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc;
import vn.dtt.sol.ns.tramcap.dao.service.TramCapNuocLocalServiceUtil;
import vn.dtt.ns.thongtinphanhoi.business.UserMappingBusiness;
import vn.dtt.ns.thongtinphanhoi.util.WebKeys;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.OrganizationLocalServiceUtil;

public class NuocSachUtils {
	
	/**
	 * @param maTinh
	 * @param maTramCap
	 * @param start
	 * @param end
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static List<UserMapping> getUserInTramCap(String maTinh,
			String maTramCap, int start, int end) throws PortalException,
			SystemException {
		List<UserMapping> lsUser = new ArrayList<UserMapping>();
		
		try {
			lsUser = UserTramCapLocalServiceUtil.findUserInTramCap(maTinh, maTramCap, start, end);
		} catch (Exception e) {
			_log.error(e);
		}
		
		return lsUser;
	}

	/**
	 * @param maTinh
	 * @param user
	 * @return
	 */
	public static List<TramCapNuoc> getTramCapByUserId(String maTinh, User user) {
		List<TramCapNuoc> lsTramCap = new ArrayList<TramCapNuoc>();

		long userId = 0l;

		if (Validator.isNotNull(user))
			userId = user.getUserId();

		try {
			lsTramCap = UserTramCapLocalServiceUtil.findTramCapByUserId(maTinh,
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			_log.error(e);
		}

		return lsTramCap;

	}

	/**
	 * Lay danh sach tinh by dia ban quan ly cap TU
	 * 
	 * @param user
	 * @return
	 */
	public static List<DATAITEM> getDiaBanTU(User user) {
		List<DATAITEM> lsDiaBan = new ArrayList<DATAITEM>();
		long userId = 0l;

		if (Validator.isNotNull(user))
			userId = user.getUserId();

		List<UserTU> lsUserTU = new ArrayList<UserTU>();

		try {
			lsUserTU = UserTULocalServiceUtil.getTinhByUserId(userId);
		
			for (UserTU userTu : lsUserTU) {
				long diaBanPk = CounterLocalServiceUtil.increment(DATAITEM.class.getName());
				DATAITEM diaBan = DATAITEMLocalServiceUtil.createDATAITEM(diaBanPk);
	
				diaBan.setDataGroupId(1);
				diaBan.setNode1(userTu.getMaTinh());
				diaBan.setName(userTu.getName());
	
				lsDiaBan.add(diaBan);
			}
		} catch (Exception e) {
			_log.error(e);
		}

		return lsDiaBan;
	}

	/**
	 * Get dia ban by Huyen
	 * 
	 * @param user
	 * @param maHuyen
	 * @return
	 */
	public static List<DATAITEM> getDiaBanHuyen(User user, String maHuyen) {

		List<DATAITEM> lsDiaBan = new ArrayList<DATAITEM>();
		long userId = 0l;

		if (Validator.isNotNull(user))
			userId = user.getUserId();

		List<UserHuyen> lsUserHuyen = new ArrayList<UserHuyen>();

		try {
			lsUserHuyen = UserHuyenLocalServiceUtil
					.getDiaBanHuyenByUserId(userId);
		

			List<String> lsMaHuyen = new ArrayList<String>();
	
			for (UserHuyen uh : lsUserHuyen) {
				lsMaHuyen.add(uh.getMaHuyen());
			}
	
			Set<String> hs = new HashSet<String>();
	
			hs.addAll(lsMaHuyen);
	
			lsMaHuyen.clear();
	
			lsMaHuyen.addAll(hs);
			if (Validator.isNull(maHuyen) && maHuyen.trim().length() == 0) {
	
				for (String mh : lsMaHuyen) {
					DATAITEM di = getDataItem(1, 2, mh);
	
					if (Validator.isNotNull(di))
						lsDiaBan.add(di);
				}
			} else {
				for (UserHuyen userTc : lsUserHuyen) {
					long diaBanPk = CounterLocalServiceUtil.increment(DATAITEM.class.getName());
					DATAITEM diaBan = DATAITEMLocalServiceUtil.createDATAITEM(diaBanPk);
					
					_log.info("userIduserId" + userTc.getMaHuyen());
					if (maHuyen.contentEquals(userTc.getMaHuyen())) {
						diaBan.setDataGroupId(1);
						diaBan.setName(userTc.getName());
						diaBan.setNode1(userTc.getMaTinh());
						diaBan.setNode2(userTc.getMaHuyen());
						diaBan.setNode3(userTc.getMaXa());
	
						lsDiaBan.add(diaBan);
					}
	
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}

		/*
		 * for (UserHuyen userTc : lsUserHuyen) { DATAITEM diaBan = new
		 * DATAITEMImpl(); // If maHuyen is null then add all to List if
		 * (Validator.isNull(maHuyen) && maHuyen.trim().length() == 0) {
		 * diaBan.setDataGroupId(1); diaBan.setName(userTc.getName());
		 * diaBan.setNode1(userTc.getMaTinh());
		 * diaBan.setNode2(userTc.getMaHuyen());
		 * diaBan.setNode3(userTc.getMaXa());
		 * 
		 * lsDiaBan.add(diaBan); } else { if
		 * (maHuyen.contentEquals(userTc.getMaHuyen())) {
		 * diaBan.setDataGroupId(1); diaBan.setName(userTc.getName());
		 * diaBan.setNode1(userTc.getMaTinh());
		 * diaBan.setNode2(userTc.getMaHuyen());
		 * diaBan.setNode3(userTc.getMaXa());
		 * 
		 * lsDiaBan.add(diaBan); } }
		 * 
		 * }
		 */
		return lsDiaBan;
	}

	private static List<DATAITEM> getDiaBanInTramCap(User user, String maTramCap) {
		List<DATAITEM> lsDiaBan = new ArrayList<DATAITEM>();

		long userId = 0l;

		if (Validator.isNotNull(user))
			userId = user.getUserId();

		List<UserTramCap> lsUserTramCap = new ArrayList<UserTramCap>();

		try {
			lsUserTramCap = UserTramCapLocalServiceUtil.getDiaBanByUserId(
					userId, Long.parseLong(maTramCap));

			for (UserTramCap userTc : lsUserTramCap) {
				long diaBanPk = CounterLocalServiceUtil.increment(DATAITEM.class.getName());
				DATAITEM diaBan = DATAITEMLocalServiceUtil.createDATAITEM(diaBanPk);
	
				diaBan.setDataGroupId(1);
				diaBan.setName(userTc.getName());
				diaBan.setNode1(userTc.getMaTinh());
				diaBan.setNode2(userTc.getMaHuyen());
				diaBan.setNode3(userTc.getMaXa());
	
				lsDiaBan.add(diaBan);
			}
		} catch (Exception e) {
			_log.error(e);
		}

		return lsDiaBan;
	}

	private static List<DATAITEM> getDiaBanInTramCap(User user) {
		List<DATAITEM> lsDiaBan = new ArrayList<DATAITEM>();

		long userId = user.getUserId();

		if (Validator.isNotNull(user))
			userId = user.getUserId();

		List<UserTramCap> lsUserTramCap = new ArrayList<UserTramCap>();

		try {
			lsUserTramCap = UserTramCapLocalServiceUtil
					.getDiaBanByUserId(userId);
		
			for (UserTramCap userTc : lsUserTramCap) {
				long diaBanPk = CounterLocalServiceUtil.increment(DATAITEM.class.getName());
				DATAITEM diaBan = DATAITEMLocalServiceUtil.createDATAITEM(diaBanPk);
	
				diaBan.setDataGroupId(1);
				diaBan.setName(userTc.getName());
				diaBan.setNode1(userTc.getMaTinh());
				diaBan.setNode2(userTc.getMaHuyen());
				diaBan.setNode3(userTc.getMaXa());
	
				lsDiaBan.add(diaBan);
			}
		} catch (Exception e) {
			_log.error(e);
		}

		return lsDiaBan;
	}

	/**
	 * Danh sach Huyen by tram cap
	 * 
	 * @param user
	 * @param maTramCap
	 *            (null - khong get theo ma tram)
	 * @return
	 */
	public static List<DATAITEM> getHuyenInTramCap(User user, String maTramCap) {

		_log.info("user" + user.getUserId() + ": maTramCap" + maTramCap);
		List<DATAITEM> lsDiaBan = new ArrayList<DATAITEM>();

		if (Validator.isNull(maTramCap)) {
			lsDiaBan = getDiaBanInTramCap(user);
		} else {
			lsDiaBan = getDiaBanInTramCap(user, maTramCap);
		}

		List<DATAITEM> lsHuyen = new ArrayList<DATAITEM>();

		List<String> lsMaHuyen = new ArrayList<String>();

		for (DATAITEM di : lsDiaBan) {
			lsMaHuyen.add(di.getNode2());
		}

		Set<String> hs = new HashSet<String>();

		hs.addAll(lsMaHuyen);

		lsMaHuyen.clear();

		lsMaHuyen.addAll(hs);

		for (String maHuyen : lsMaHuyen) {
			DATAITEM di = getDataItem(1, 2, maHuyen);

			if (Validator.isNotNull(di))
				lsHuyen.add(di);
		}

		return lsHuyen;
	}

	/**
	 * Lay danh sach xa by huyen
	 * 
	 * @param user
	 * @param maTramCap
	 * @param maHuyen
	 * @return
	 */
	public static List<DATAITEM> getXaInTramCapByHuyen(User user,
			String maTramCap, String maHuyen) {

		List<DATAITEM> lsDiaBanXaByHuyen = new ArrayList<DATAITEM>();

		List<UserTramCap> lsDiaBanXa = new ArrayList<UserTramCap>();

		long userId = 0l;

		if (Validator.isNotNull(user))
			userId = user.getUserId();

		try {
			lsDiaBanXa = UserTramCapLocalServiceUtil.getDiaBanByUserId(userId);
		} catch (Exception e) {
			_log.error(e);
		}

		for (UserTramCap utc : lsDiaBanXa) {

			DATAITEM di = null;

			if (maHuyen.contentEquals(utc.getMaHuyen())) {
				di = getDataItem(1, 3, utc.getMaXa());
			}

			if (Validator.isNotNull(di)) {
				lsDiaBanXaByHuyen.add(di);
			}
		}

		return lsDiaBanXaByHuyen;
	}

	/**
	 * @param source
	 * @return
	 */
	public static String formatNumber(int source) {
		String pattern = "###,###";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);

		String format = decimalFormat.format(source);

		return format;
	}

	/**
	 * @param source
	 * @return
	 */
	public static int formatPrice(String source) {
		DecimalFormat priceFormat = new DecimalFormat();
		DecimalFormatSymbols dfs = priceFormat.getDecimalFormatSymbols();

		dfs.setDecimalSeparator(',');
		dfs.setGroupingSeparator('.');
		priceFormat.setMinimumFractionDigits(0);
		priceFormat.setDecimalFormatSymbols(dfs);

		int price = 0;

		try {
			price = priceFormat.parse(source).intValue();
		} catch (Exception e) {
			_log.error(e);
		}

		return price;
	}

	/**
	 * @param user
	 * @param level
	 * @return
	 */
	public static String getInitLevel(User user, int level) {
		String initValue = StringPool.BLANK;

		UserMapping userMapping = UserMappingBusiness.getUserMapping(user);

		if (Validator.isNotNull(userMapping)) {
			if (level == 2) {
				initValue = userMapping.getOrgCode1();
			} else if (level == 3 || level == 4) {
				initValue = userMapping.getOrgCode2();
			}
		}

		return initValue;
	}

	/**
	 * @param tramCapId
	 * @return
	 */
	public static TramCapNuoc getTramCap(long tramCapId) {
		TramCapNuoc tramCap = null;

		try {
			tramCap = TramCapNuocLocalServiceUtil.fetchTramCapNuoc(tramCapId);
		} catch (Exception e) {
			_log.error(e);
		}

		return tramCap;
	}

	public static List<DATAITEM> getListHuyen(User user) {

		List<DATAITEM> lsHuyen = new ArrayList<DATAITEM>();

		UserMapping um = UserMappingBusiness.getUserMapping(user);

		int userType = 0;

		if (Validator.isNotNull(um)) {
			userType = um.getUserType();
		}

		if (userType == 1) {
			try {
				lsHuyen = DATAITEMLocalServiceUtil.getByDataGroupLevel2(
						WebKeys.DATAGROUPID_DONVIHANHCHINH, um.getOrgCode1());
			} catch (Exception e) {
				_log.error(e);
			}
		} else {
			DATAITEM di = null;
			try {
				di = getDataItem((int) WebKeys.DATAGROUPID_DONVIHANHCHINH, 2,
						um.getOrgCode2());
			} catch (Exception e) {
				_log.error(e);
			}

			if (Validator.isNotNull(di)) {
				lsHuyen.add(di);
			}
		}

		return lsHuyen;
	}

	/**
	 * @param user
	 * @return
	 */
	public static List<DATAITEM> getListTinh(User user) {

		List<DATAITEM> lsTinh = new ArrayList<DATAITEM>();

		UserMapping um = UserMappingBusiness.getUserMapping(user);

		int userType = 0;

		if (Validator.isNotNull(um)) {
			userType = um.getUserType();
		}

		if (userType == 1) {
			try {
				lsTinh = DATAITEMLocalServiceUtil
						.getByDataGroupLevel1(WebKeys.DATAGROUPID_DONVIHANHCHINH);
			} catch (Exception e) {
				_log.error(e);
			}
		} else {
			DATAITEM di = null;
			try {
				di = getDataItem((int) WebKeys.DATAGROUPID_DONVIHANHCHINH, 1,
						um.getOrgCode1());
			} catch (Exception e) {
				_log.error(e);
			}

			if (Validator.isNotNull(di)) {
				lsTinh.add(di);
			}
		}

		return lsTinh;
	}

	/**
	 * @param maTramCap
	 * @return
	 */
	public static String getTinhByTram(String maTramCap) {
		String tinh = StringPool.BLANK;
		try {
			TramCapNuoc tramCap = TramCapNuocLocalServiceUtil
					.fetchTramCapNuoc(Long.parseLong(maTramCap));

			if (Validator.isNotNull(tramCap)) {
				tinh = getNameTinh(tramCap.getMaTinh());
			}

		} catch (Exception e) {
			_log.error(e);
		}

		return tinh;
	}

	public static String getTenTram(String maTram) {
		String tenTram = StringPool.BLANK;
		/*
		 * if(Validator.isNotNull(maTram)){ try { TramCapNuoc tramCapNuocTenTram
		 * = TramCapNuocLocalServiceUtil. tenTram =
		 * tramCapNuocTenTram.getTenTram(); } catch (SystemException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); _log.error(e); }
		 * 
		 * }
		 */
		return tenTram;
	}

	/**
	 * Author: tailt
	 * 
	 * @param tramId
	 * @return
	 */
	public static String getTenTramByTramId(String tramId) {
		String tenTram = StringPool.BLANK;
		if (Validator.isNotNull(tramId)) {
			try {
				TramCapNuoc tramCapNuocTenTram = TramCapNuocLocalServiceUtil
						.fetchTramCapNuoc(ConvertUtil.convertToLong(tramId));
				if (Validator.isNotNull(tramCapNuocTenTram)) {
					tenTram = tramCapNuocTenTram.getTenTram();
				}
			} catch (SystemException e) {
				e.printStackTrace();
				_log.error(e);
			}

		}
		return tenTram;
	}

	/**
	 * @param userMapping
	 * @return
	 */
	public static String getEmailUser(UserMapping userMapping) {
		String email = StringPool.BLANK;

		User user = UserMappingBusiness.getUser(userMapping.getId());

		if (Validator.isNotNull(user))
			email = user.getEmailAddress();

		return email;
	}

	public static String getNameXa(String orgCode3) {

		String nameXa = StringPool.DASH;

		try {
			DATAITEM xa = DATAITEMLocalServiceUtil.getDataItem(
					(int) WebKeys.DATAGROUPID_DONVIHANHCHINH, 3, orgCode3);

			if (Validator.isNotNull(xa)) {
				nameXa = xa.getName();
			}
		} catch (Exception e) {
			_log.error(e);
		}

		return nameXa;
	}

	public static DATAITEM getDataItem(int dataGroupId, int level, String node) {
		DATAITEM dataItem = null;

		try {
			dataItem = DATAITEMLocalServiceUtil.getDataItem(dataGroupId, level,
					node);
		} catch (Exception e) {
			_log.error(e);
		}

		return dataItem;
	}

	/**
	 * @param orgCode2
	 * @return
	 */
	public static String getNameHuyen(String orgCode1, String orgCode2) {

		String nameHuyen = StringPool.DASH;

		try {
			DATAITEM huyen = DATAITEMLocalServiceUtil.getDataItem(
					(int) WebKeys.DATAGROUPID_DONVIHANHCHINH, 2, orgCode2);

			if (Validator.isNotNull(huyen)) {
				nameHuyen = huyen.getName();
			}
		} catch (Exception e) {
			_log.error(e);
		}

		return nameHuyen;
	}

	/**
	 * @param orgCode1
	 * @return
	 */
	public static String getNameTinh(String orgCode1) {
		String nameTinh = StringPool.DASH;

		DATAITEM tinh = null;

		try {
			tinh = DATAITEMLocalServiceUtil.getDataItem(
					(int) WebKeys.DATAGROUPID_DONVIHANHCHINH, 1, orgCode1);

			if (Validator.isNotNull(tinh)) {
				nameTinh = tinh.getName();
			} else {

			}
		} catch (Exception e) {
			_log.error(e);
		}

		return nameTinh;
	}

	/**
	 * @param orgCode2
	 * @return
	 */
	public static DATAITEM getDATAITEMHuyen(String orgCode1, String orgCode2) {

		DATAITEM huyen = null;

		try {
			huyen = DATAITEMLocalServiceUtil.getDataItem(
					(int) WebKeys.DATAGROUPID_DONVIHANHCHINH, 2, orgCode2);
		} catch (Exception e) {
			_log.error(e);
		}

		return huyen;
	}

	/**
	 * @param orgCode1
	 * @return
	 */
	public static DATAITEM getDATAITEMTinh(String orgCode1) {

		DATAITEM tinh = null;

		try {
			tinh = DATAITEMLocalServiceUtil.getDataItem(
					(int) WebKeys.DATAGROUPID_DONVIHANHCHINH, 1, orgCode1);
		} catch (Exception e) {
			_log.error(e);
		}

		return tinh;
	}

	/**
	 * @param user
	 * @return
	 */
	public static List<Organization> getOrgOfUser(User user) {

		List<Organization> orgs = new ArrayList<Organization>();
		if (user.getUserId() != 0) {
			try {
				orgs = OrganizationLocalServiceUtil.getUserOrganizations(user
						.getUserId());
			} catch (Exception e) {
				_log.error(e);
			}

		}

		return orgs;
	}

	private static Log _log = LogFactoryUtil.getLog(NuocSachUtils.class);
}
