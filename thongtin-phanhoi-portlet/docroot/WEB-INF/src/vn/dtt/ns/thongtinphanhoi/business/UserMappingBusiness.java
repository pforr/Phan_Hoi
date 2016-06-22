package vn.dtt.ns.thongtinphanhoi.business;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.cmon.user.dao.model.UserMapping;
import vn.dtt.cmon.user.dao.service.UserMappingLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

public class UserMappingBusiness {
	
	
	
	/**
	 * Get User by userMapping
	 * 
	 * @param userId
	 * @return
	 */
	public static UserMapping getByUserId(long userId) {
		UserMapping userMapping = null;
		try {
			userMapping = UserMappingLocalServiceUtil.getByUserId(userId);
		} catch (Exception e) {
			return null;
		}

		return userMapping;
	}
	/**
	 * Get User by userMapping
	 * 
	 * @param userMappingId
	 * @return
	 */
	public static User getUser(long userMappingId) {
		User user = null;
		UserMapping userMapping = getUserMapping(userMappingId);
		try {
			user = UserLocalServiceUtil.getUser(userMapping.getUserId());
		} catch (Exception e) {
			return null;
		}

		return user;
	}

	/**
	 * @param id
	 * @return
	 */
	public static UserMapping getUserMapping(long id) {
		UserMapping userMapping = null;
		if (id != 0) {
			try {
				userMapping = UserMappingLocalServiceUtil.getUserMapping(id);
			} catch (Exception e) {
				_log.error(e);
			}
		}

		return userMapping;
	}

	/**
	 * Lay userMapping cua nguoi dang nhap
	 * 
	 * @param user
	 * @return
	 */
	public static UserMapping getUserMapping(User user) {
		UserMapping userMapping = null;

		try {
			return UserMappingLocalServiceUtil.getByUserId(user.getUserId());
		} catch (Exception e) {
			// in case, using login not map with UserMapping will be WARN
			return userMapping;
		}
	}

	/**
	 * @param user
	 * @return
	 */
	public static int getUserType(User user) {
		// TODO : Can sua lai ham nay, trong truong hop nguoi dung khong co
		// mapping trong database
		int userType = 0;

		try {
			if (Validator.isNotNull(user)) {
				userType = UserMappingLocalServiceUtil.getByUserId(
						user.getUserId()).getUserType();
			}
		} catch (Exception e) {

		}

		return userType;
	}

	/**
	 * @param userMappingId
	 * @param keyword
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<UserMapping> findUser(String keyword, int userType,
			String orgCode1, String orgCode2, int start, int end) {
		List<UserMapping> list = new ArrayList<UserMapping>();

		try {
			list = UserMappingLocalServiceUtil.find(keyword, userType,
					orgCode1, orgCode2, start, end);
		} catch (Exception e) {
			_log.error(e);
		}

		return list;
	}

	/**
	 * @param userMapping
	 * @param keyword
	 * @return
	 */
	public static int countUser(String keyword, int userType, String orgCode1,
			String orgCode2) {
		int count = 0;

		try {
			count = UserMappingLocalServiceUtil.count(keyword, userType,
					orgCode1, orgCode2);
		} catch (Exception e) {
			_log.error(e);
		}

		return count;
	}

	/**
	 * @param orgCode1
	 * @return
	 */
	public static List<UserMapping> getByOrgCode1(String orgCode1) {

		List<UserMapping> list = new ArrayList<UserMapping>();

		try {
			list = UserMappingLocalServiceUtil.getByOrg1(orgCode1);
		} catch (Exception e) {
			_log.error(e);
		}

		return list;
	}

	/**
	 * @param orgCode2
	 * @return
	 */
	public static List<UserMapping> getByOrgCode2(String orgCode2) {

		List<UserMapping> list = new ArrayList<UserMapping>();

		try {
			list = UserMappingLocalServiceUtil.getByOrg2(orgCode2);
		} catch (Exception e) {
			_log.error(e);
		}

		return list;
	}

	/**
	 * @param orgCode1
	 * @param orgCode2
	 * @return
	 */
	public static List<UserMapping> getByOrgCode1_OrgCode2(String orgCode1,
			String orgCode2) {

		List<UserMapping> list = new ArrayList<UserMapping>();

		try {
			list = UserMappingLocalServiceUtil.getByOrg1_Org2(orgCode1,
					orgCode2);
		} catch (Exception e) {
			_log.error(e);
		}

		return list;
	}

	/**
	 * @param userType
	 * @param orgCode1
	 * @return
	 */
	public static List<UserMapping> getByTypeOrg1(int userType, String orgCode1) {

		List<UserMapping> list = new ArrayList<UserMapping>();

		try {
			list = UserMappingLocalServiceUtil
					.getByTypeOrg1(userType, orgCode1);
		} catch (Exception e) {
			_log.error(e);
		}

		return list;
	}

	public static List<UserMapping> getByTypeOrg2(int userType,
			String orgCode1, String orgCode2) {

		List<UserMapping> list = new ArrayList<UserMapping>();

		try {
			list = UserMappingLocalServiceUtil.getByTypeOrg2(userType,
					orgCode1, orgCode2);
		} catch (Exception e) {
			_log.error(e);
		}

		return list;
	}

	private static Log _log = LogFactoryUtil.getLog(UserMappingBusiness.class);
}
