package vn.dtt.ns.quanlynguoidung;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

import vn.dtt.cmon.dm.dao.model.DATAITEM;

import vn.dtt.cmon.user.dao.model.UserMapping;
import vn.dtt.cmon.user.dao.service.UserHuyenLocalServiceUtil;
import vn.dtt.cmon.user.dao.service.UserMappingLocalServiceUtil;
import vn.dtt.cmon.user.dao.service.UserTULocalServiceUtil;
import vn.dtt.cmon.user.dao.service.UserTinhLocalServiceUtil;
import vn.dtt.cmon.user.dao.service.UserTramCapLocalServiceUtil;
import vn.dtt.ns.thongtinphanhoi.business.DataItemBusiness;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.EmailAddress;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.model.Website;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.announcements.model.AnnouncementsDelivery;
import com.liferay.portlet.usersadmin.util.UsersAdmin;
import com.liferay.portlet.usersadmin.util.UsersAdminUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import vn.dtt.ns.thongtinphanhoi.util.MessageErrors;
import vn.dtt.ns.thongtinphanhoi.util.WebKeys;
/**
 * Portlet implementation class QuanLyNguoiDungAction
 */
public class QuanLyNguoiDungAction extends MVCPortlet {
 
	public static final String ID = "id";
	public static final String USER_ID = "userId";
	public static final String USER_TYPE = "typeUser";
	public static final String ORG_CODE1 = "orgCode1";
	public static final String ORG_CODE2 = "orgCode2";

	
	public void addUserTinh(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {

		List<String> errors = new ArrayList<String>();
		String screenName = ParamUtil.getString(actionRequest, "screenName");
		String fullname = ParamUtil.getString(actionRequest, "fullName");
		String matKhau1 = ParamUtil.getString(actionRequest, "password1");
		String matKhau2 = ParamUtil.getString(actionRequest, "password2");
		String emailAddress = ParamUtil
				.getString(actionRequest, "emailAddress");

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		boolean valid = validate(screenName, fullname, emailAddress, matKhau1,
				matKhau2, cmd, errors);

		//UserMappingAction action = new UserMappingAction();

		if (valid) {

			try {
				if (cmd.contentEquals(Constants.ADD)) {
					this.addUser(actionRequest, actionResponse);
					SessionMessages.add(actionRequest,
							"them-thanh-cong-nguoi-su-dung");
				} else if (cmd.contentEquals(Constants.UPDATE)) {
					this.updateUser(actionRequest, actionResponse);
					SessionMessages.add(actionRequest,
							"cap-nhat-thanh-cong-nguoi-su-dung");
				}
			} catch (Exception e) {
				SessionErrors.add(actionRequest, e.getClass().getName());
			}
		} else {
			for (String error : errors) {
				SessionErrors.add(actionRequest, error);
			}

		}

		sendCustomRedirect(actionRequest, actionResponse);
	}
	
	
	
	public void addUserTU(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {

		List<String> errors = new ArrayList<String>();
		String screenName = ParamUtil.getString(actionRequest, "screenName");
		String fullname = ParamUtil.getString(actionRequest, "fullName");
		String matKhau1 = ParamUtil.getString(actionRequest, "password1");
		String matKhau2 = ParamUtil.getString(actionRequest, "password2");
		String emailAddress = ParamUtil
				.getString(actionRequest, "emailAddress");

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		boolean valid = validate(screenName, fullname, emailAddress, matKhau1,
				matKhau2, cmd, errors);

		//UserMappingAction action = new UserMappingAction();

		if (valid) {

			try {
				if (cmd.contentEquals(Constants.ADD)) {
					this.addUser(actionRequest, actionResponse);
					SessionMessages.add(actionRequest,
							"them-thanh-cong-nguoi-su-dung");
				} else if (cmd.contentEquals(Constants.UPDATE)) {
					this.updateUser(actionRequest, actionResponse);
					SessionMessages.add(actionRequest,
							"cap-nhat-thanh-cong-nguoi-su-dung");
				}
			} catch (Exception e) {
				SessionErrors.add(actionRequest, e.getClass().getName());
			}
		} else {
			for (String error : errors) {
				SessionErrors.add(actionRequest, error);
			}

		}

		sendCustomRedirect(actionRequest, actionResponse);

		_log.info("--> Add User TU");
	}
	
	/**
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void addUser(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException {

		ServiceContext serviceContext = ServiceContextFactory
				.getInstance(actionRequest);

		long creatorUserId = 0l;
		long companyId = serviceContext.getCompanyId();
		boolean autoPassword = false;
		String password1 = ParamUtil.getString(actionRequest, "password1");
		String password2 = ParamUtil.getString(actionRequest, "password2");
		boolean autoScreenName = false;
		String screenName = ParamUtil.getString(actionRequest, "screenName");
		String emailAddress = ParamUtil
				.getString(actionRequest, "emailAddress");

		int userType = ParamUtil.getInteger(actionRequest, "userType");

		long[] lsMaTinh = ParamUtil.getLongValues(actionRequest,
				"orgCode1Checkbox");

		String[] rowIds = ParamUtil.getParameterValues(actionRequest, "rowIds");

		String maTinh = ParamUtil.getString(actionRequest, "selTinh");

		String[] arrMaHuyenDel = ParamUtil.getParameterValues(actionRequest,
				"maHuyenDel");

		long facebookId = 0;
		String openId = ParamUtil.getString(actionRequest, "openId");
		String firstName = ParamUtil.getString(actionRequest, "fullName");
		String middleName = ParamUtil.getString(actionRequest, "middleName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		int prefixId = ParamUtil.getInteger(actionRequest, "prefixId");
		int suffixId = ParamUtil.getInteger(actionRequest, "suffixId");
		boolean male = ParamUtil.getBoolean(actionRequest, "male", true);

		Calendar cal = Calendar.getInstance();

		int birthdayMonth = cal.get(Calendar.MONTH);
		int birthdayDay = cal.get(Calendar.DAY_OF_MONTH);
		int birthdayYear = cal.get(Calendar.YEAR);

		String jobTitle = ParamUtil.getString(actionRequest, "jobTitle");
		long[] groupIds = getLongArray(actionRequest,
				"groupsSearchContainerPrimaryKeys");
		long[] organizationIds = getLongArray(actionRequest,
				"organizationsSearchContainerPrimaryKeys");
		long[] roleIds = getLongArray(actionRequest,
				"rolesSearchContainerPrimaryKeys");
		long[] userGroupIds = getLongArray(actionRequest,
				"userGroupsSearchContainerPrimaryKeys");

		boolean sendEmail = true;

		UserMapping um = UserMappingLocalServiceUtil.addUserMapping(maTinh,
				userType, creatorUserId, companyId, autoPassword, password1,
				password2, autoScreenName, screenName, emailAddress,
				facebookId, openId, serviceContext.getLocale(), firstName,
				middleName, lastName, prefixId, suffixId, male, birthdayMonth,
				birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds,
				roleIds, userGroupIds, sendEmail, serviceContext);

		if (Validator.isNotNull(um)) {

			if (userType == 1) {
				UserTULocalServiceUtil.addDiaBanTUByUser(um.getUserId(),
						lsMaTinh);
			} else if (userType == 2 || userType == 6 ) {
				UserTinhLocalServiceUtil.addUserTinh(maTinh, um.getUserId(),
						rowIds, arrMaHuyenDel);
			} else if (userType == 3 || userType == 7 || userType == 8) {
				addDiaBanQlyHuyen(actionRequest, um.getUserId());
			} else if (userType == 4) {
				addDiaBanQuanLyTramCap(actionRequest, um.getUserId());
			}
		}

	}

	private void addDiaBanQuanLyTramCap(ActionRequest actionRequest, long userId)
			throws PortalException, SystemException {

		String maTinh = ParamUtil.getString(actionRequest, "selTinh");

		HashMap<Long, HashMap<String, List<String>>> hmTramHuyenXa = getTramHuyenXa(actionRequest);

		HashMap<Long, HashMap<String, List<String>>> hmTramHuyenXaDel = getTramHuyenXaDel(actionRequest);

		Set setTramHuyenXa = hmTramHuyenXa.entrySet();

		Iterator iteratorTramHuyenXa = setTramHuyenXa.iterator();

		while (iteratorTramHuyenXa.hasNext()) {
			Map.Entry mentry = (Map.Entry) iteratorTramHuyenXa.next();

			long maTramCap = (Long) mentry.getKey();

			HashMap<String, List<String>> hmHuyenXa = (HashMap<String, List<String>>) mentry
					.getValue();
			

			Set setHuyenXa = hmHuyenXa.entrySet();

			Iterator iteratorHuyenXa = setHuyenXa.iterator();

			while (iteratorHuyenXa.hasNext()) {
				Map.Entry meHuyenXa = (Map.Entry) iteratorHuyenXa.next();

				String maHuyen = (String) meHuyenXa.getKey();

				List<String> lsXa = (List<String>) meHuyenXa.getValue();

				// trong truong hop chon toan huyen
				if (lsXa.size() == 0) {
					lsXa = getLsMaXaByTinhHuyen(maTinh, maHuyen);
				}

				for (String maXa : lsXa) {
					UserTramCapLocalServiceUtil.addTramCap(maTinh, maHuyen,
							maXa, maTramCap, userId);
				}
			}

		}

		Set setTramHuyenXaDel = hmTramHuyenXaDel.entrySet();

		Iterator iteratorTramHuyenXaDel = setTramHuyenXaDel.iterator();

		while (iteratorTramHuyenXaDel.hasNext()) {
			Map.Entry mentry = (Map.Entry) iteratorTramHuyenXaDel.next();

			long maTramCap = (Long) mentry.getKey();

			HashMap<String, List<String>> hmHuyenXa = (HashMap<String, List<String>>) mentry
					.getValue();
			

			Set setHuyenXa = hmHuyenXa.entrySet();

			Iterator iteratorHuyenXa = setHuyenXa.iterator();

			while (iteratorHuyenXa.hasNext()) {
				Map.Entry meHuyenXa = (Map.Entry) iteratorHuyenXa.next();

				String maHuyen = (String) meHuyenXa.getKey();

				List<String> lsXa = (List<String>) meHuyenXa.getValue();

				// trong truong hop chon toan huyen
				if (lsXa.size() == 0) {
					lsXa = getLsMaXaByTinhHuyen(maTinh, maHuyen);
				}

				for (String maXa : lsXa) {
					UserTramCapLocalServiceUtil.delUserTramCap(maTinh, maHuyen, maXa, maTramCap, userId);
				}
			}

		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void addDiaBanQlyHuyen(ActionRequest actionRequest, long userId)
			throws PortalException, SystemException {

		HashMap<String, List<String>> hmHuyenXa = getXaHuyenSelect(actionRequest);

		HashMap<String, List<String>> hmHuyenXaDel = getXaHuyenSelectDel(actionRequest);

		String maTinh = ParamUtil.getString(actionRequest, "selTinh");

		Set set = hmHuyenXa.entrySet();

		Iterator iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();

			String maHuyen = (String) mentry.getKey();

			List<String> lsXa = (List<String>) mentry.getValue();

			// trong truong hop chon toan huyen
			if (lsXa.size() == 0) {
				lsXa = getLsMaXaByTinhHuyen(maTinh, maHuyen);
			}

			for (String maXa : lsXa) {
				UserHuyenLocalServiceUtil.addUserHuyen(maTinh, maHuyen, maXa,
						userId);
			}
		}

		Set setDel = hmHuyenXaDel.entrySet();

		Iterator iteratorSel = setDel.iterator();

		while (iteratorSel.hasNext()) {
			Map.Entry mentry = (Map.Entry) iteratorSel.next();

			String maHuyen = (String) mentry.getKey();

			List<String> lsXa = (List<String>) mentry.getValue();

			// trong truong hop chon toan huyen
			if (lsXa.size() == 0) {
				lsXa = getLsMaXaByTinhHuyen(maTinh, maHuyen);
			}

			for (String maXa : lsXa) {
				UserHuyenLocalServiceUtil.delUserHuyen(maTinh, maHuyen, maXa,
						userId);
			}
		}

	}

	private List<String> getLsMaXaByTinhHuyen(String maTinh, String maHuyen) {
		List<String> ls = new ArrayList<String>();

		List<DATAITEM> lsXa = DataItemBusiness.getInLevel3(1, maTinh, maHuyen);

		for (DATAITEM xa : lsXa) {
			String maXa = xa.getNode3();

			ls.add(maXa);
		}

		return ls;
	}

	private HashMap<String, List<String>> getXaHuyenSelectDel(
			ActionRequest actionRequest) {

		HashMap<String, List<String>> hmHuyenXa = new HashMap<String, List<String>>();

		String[] lsHuyen = ParamUtil.getParameterValues(actionRequest,
				"selChuyenDelCheckbox");

		for (String huyen : lsHuyen) {
			String[] xaSel = ParamUtil.getParameterValues(actionRequest, huyen
					+ "_selXaDelIds");

			List<String> lsXaSel = convertArrayToList(xaSel);

			hmHuyenXa.put(huyen, lsXaSel);
		}

		return hmHuyenXa;
	}

	private HashMap<String, List<String>> getXaHuyenSelect(
			ActionRequest actionRequest) {

		HashMap<String, List<String>> hmHuyenXa = new HashMap<String, List<String>>();

		String[] lsHuyen = ParamUtil
				.getParameterValues(actionRequest, "rowIds");

		for (String huyen : lsHuyen) {
			String[] xaSel = ParamUtil.getParameterValues(actionRequest, huyen	+ "_selXaIds");

			List<String> lsXaSel = convertArrayToList(xaSel);

			hmHuyenXa.put(huyen, lsXaSel);
		}

		return hmHuyenXa;
	}

	private HashMap<Long, HashMap<String, List<String>>> getTramHuyenXaDel(
			ActionRequest actionRequest) {

		HashMap<Long, HashMap<String, List<String>>> hashTramHuyenXa = new HashMap<Long, HashMap<String, List<String>>>();

		long[] lsMaTram = ParamUtil.getLongValues(actionRequest,
				"tramCapIdsCheckbox");

		for (long maTram : lsMaTram) {

			String[] arrMaHuyen = ParamUtil.getParameterValues(actionRequest,
					Long.toString(maTram) + "selMaHuyenDelCheckbox");

			for (String huyen : arrMaHuyen) {
				HashMap<String, List<String>> hmHuyenXa = new HashMap<String, List<String>>();

				String[] arrMaXa = ParamUtil.getParameterValues(actionRequest,
						huyen + "_selXaDelCheckbox");
				List<String> lsXaSel = convertArrayToList(arrMaXa);

				hmHuyenXa.put(huyen, lsXaSel);

				hashTramHuyenXa.put(maTram, hmHuyenXa);
			}
		}

		return hashTramHuyenXa;
	}

	private HashMap<Long, HashMap<String, List<String>>> getTramHuyenXa(
			ActionRequest actionRequest) {

		HashMap<Long, HashMap<String, List<String>>> hashTramHuyenXa = new HashMap<Long, HashMap<String, List<String>>>();

		long[] lsMaTram = ParamUtil.getLongValues(actionRequest, "rowIds");

		for (long maTram : lsMaTram) {

			String[] arrMaHuyen = ParamUtil.getParameterValues(actionRequest,
					Long.toString(maTram) + "selMaHuyen");

			for (String huyen : arrMaHuyen) {
				HashMap<String, List<String>> hmHuyenXa = new HashMap<String, List<String>>();

				String[] arrMaXa = ParamUtil.getParameterValues(actionRequest,
						huyen + "_selXa");
				List<String> lsXaSel = convertArrayToList(arrMaXa);

				hmHuyenXa.put(huyen, lsXaSel);

				hashTramHuyenXa.put(maTram, hmHuyenXa);
			}
		}

		return hashTramHuyenXa;
	}

	private List<String> convertArrayToList(String[] array) {
		List<String> out = new ArrayList<String>();

		for (String arr : array) {
			out.add(arr);
		}

		return out;
	}

	/**
	 * @param actionRequest
	 * @param actionResponse
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public UserMapping updateUser(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException {

		ServiceContext serviceContext = ServiceContextFactory
				.getInstance(actionRequest);

		int userType = ParamUtil.getInteger(actionRequest, "userType");

		long[] lsMaTinh = ParamUtil.getLongValues(actionRequest,
				"orgCode1Checkbox");

		String password1 = ParamUtil.getString(actionRequest, "password1");
		String password2 = ParamUtil.getString(actionRequest, "password2");

		long userId = ParamUtil.getLong(actionRequest, "userId");

		String fullName = ParamUtil.getString(actionRequest, "fullName");

		long[] roleIds = getLongArray(actionRequest,
				"rolesSearchContainerPrimaryKeys");

		long[] userGroupIds = getLongArray(actionRequest,
				"userGroupsSearchContainerPrimaryKeys");

		UserMapping um = UserMappingLocalServiceUtil.updateUserMapping(userId,
				password1, password2, fullName, roleIds, userGroupIds,
				serviceContext);

		String[] rowIds = ParamUtil.getParameterValues(actionRequest, "rowIds");

		String maTinh = ParamUtil.getString(actionRequest, "selTinh");

		String[] arrMaHuyenDel = ParamUtil.getParameterValues(actionRequest,
				"delHuyenIdCheckbox");

		if (Validator.isNotNull(um)) {

			if (userType == 1) {
				UserTULocalServiceUtil.addDiaBanTUByUser(um.getUserId(),
						lsMaTinh);
			} else if (userType == 2 ||  userType == 6) {
				UserTinhLocalServiceUtil.addUserTinh(maTinh, um.getUserId(),
						rowIds, arrMaHuyenDel);
			} else if (userType == 3 || userType == 7 || userType == 8) {
				addDiaBanQlyHuyen(actionRequest, um.getUserId());
			} else if (userType == 4) {
				addDiaBanQuanLyTramCap(actionRequest, um.getUserId());;
			}
		}

		return um;
	}

	/**
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void addUserMapping(ActionRequest request, ActionResponse response)
			throws Exception {

		User user = addUserLiferay(request);

		long id = ParamUtil.getLong(request, ID);
		long userId = 0;

		if (Validator.isNotNull(user)) {
			userId = user.getUserId();
		}

		String maTinh = ParamUtil.getString(request, "capTinh");
		String maHuyen = ParamUtil.getString(request, "capHuyen");
		String maTram = ParamUtil.getString(request, "capTram");

		int typeUser = ParamUtil.getInteger(request, USER_TYPE);
		String orgCode1 = StringPool.BLANK;
		String orgCode2 = StringPool.BLANK;

		if (typeUser == 1) {
			orgCode1 = StringPool.BLANK;
			orgCode2 = StringPool.BLANK;
		} else if (typeUser == 2 || typeUser == 6) {
			orgCode1 = maTinh;
			orgCode2 = StringPool.BLANK;
		} else if (typeUser == 3 || typeUser == 7 || typeUser == 8) {
			orgCode1 = maTinh;
			orgCode2 = maHuyen;
		} else if (typeUser == 4) {
			orgCode1 = maTinh;
			orgCode2 = maTram;
		}

		String firstName = ParamUtil.getString(request, "fullName");

		String cmd = ParamUtil.getString(request, Constants.CMD);

		List<String> errors = new ArrayList<String>();

		boolean valid = validationInput(userId, typeUser, errors);

		if (valid) {
			if (cmd.contentEquals(Constants.ADD)
					|| cmd.contentEquals(Constants.UPDATE)) {

				UserMappingLocalServiceUtil.addUserMapping(id, firstName,
						userId, typeUser, orgCode1, orgCode2);

				SessionMessages.add(request, "usermapping-saved-successfully");
			}
		}

		if (errors.size() != 0) {
			for (String error : errors) {
				SessionMessages.add(request, error);
			}
		}
	}

	/**
	 * @param actionRequest
	 * @return
	 */
	protected User addUserLiferay(ActionRequest actionRequest) {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		User user = null;

		long userId = ParamUtil.getLong(actionRequest, "userId");

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		boolean autoPassword = ParamUtil.getBoolean(actionRequest,
				"autoPassword", false);

		String password1 = actionRequest.getParameter("password1");
		String password2 = actionRequest.getParameter("password2");

		String reminderQueryQuestion = ParamUtil.getString(actionRequest,
				"reminderQueryQuestion");

		if (reminderQueryQuestion.equals(UsersAdmin.CUSTOM_QUESTION)) {
			reminderQueryQuestion = ParamUtil.getString(actionRequest,
					"reminderQueryCustomQuestion");
		}

		boolean autoScreenName = ParamUtil.getBoolean(actionRequest,
				"autoScreenName");
		String screenName = ParamUtil.getString(actionRequest, "screenName");
		String emailAddress = ParamUtil
				.getString(actionRequest, "emailAddress");
		long facebookId = 0;
		String openId = ParamUtil.getString(actionRequest, "openId");
		String firstName = ParamUtil.getString(actionRequest, "fullName");
		String middleName = ParamUtil.getString(actionRequest, "middleName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		int prefixId = ParamUtil.getInteger(actionRequest, "prefixId");
		int suffixId = ParamUtil.getInteger(actionRequest, "suffixId");
		boolean male = ParamUtil.getBoolean(actionRequest, "male", true);

		Calendar cal = Calendar.getInstance();

		int birthdayMonth = cal.get(Calendar.MONTH);
		int birthdayDay = cal.get(Calendar.DAY_OF_MONTH);
		int birthdayYear = cal.get(Calendar.YEAR);

		//
		// int birthdayMonth = ParamUtil
		// .getInteger(actionRequest, "birthdayMonth");
		// int birthdayDay = ParamUtil.getInteger(actionRequest, "birthdayDay");
		// int birthdayYear = ParamUtil.getInteger(actionRequest,
		// "birthdayYear");
		String jobTitle = ParamUtil.getString(actionRequest, "jobTitle");
		long[] groupIds = getLongArray(actionRequest,
				"groupsSearchContainerPrimaryKeys");
		long[] organizationIds = getLongArray(actionRequest,
				"organizationsSearchContainerPrimaryKeys");
		long[] roleIds = getLongArray(actionRequest,
				"rolesSearchContainerPrimaryKeys");
		long[] userGroupIds = getLongArray(actionRequest,
				"userGroupsSearchContainerPrimaryKeys");
		List<Address> addresses = UsersAdminUtil.getAddresses(actionRequest);
		List<EmailAddress> emailAddresses = UsersAdminUtil
				.getEmailAddresses(actionRequest);
		List<Phone> phones = UsersAdminUtil.getPhones(actionRequest);
		List<Website> websites = UsersAdminUtil.getWebsites(actionRequest);
		List<AnnouncementsDelivery> announcementsDeliveries = new ArrayList<AnnouncementsDelivery>();
		boolean sendEmail = true;

		try {

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					User.class.getName(), actionRequest);
			if (cmd.contentEquals(Constants.ADD)) {
				user = UserServiceUtil.addUser(themeDisplay.getCompanyId(),
						autoPassword, password1, password2, autoScreenName,
						screenName, emailAddress, facebookId, openId,
						LocaleUtil.getDefault(), firstName, middleName,
						lastName, prefixId, suffixId, male, birthdayMonth,
						birthdayDay, birthdayYear, jobTitle, groupIds,
						organizationIds, roleIds, userGroupIds, addresses,
						emailAddresses, phones, websites,
						announcementsDeliveries, sendEmail, serviceContext);

			} else if (cmd.contentEquals(Constants.UPDATE)) {

				try {
					user = UserLocalServiceUtil.getUser(userId);
				} catch (Exception e) {
				}

				user = UserServiceUtil.updateUser(userId, user.getPassword(),
						StringPool.BLANK, StringPool.BLANK, false,
						reminderQueryQuestion, user.getReminderQueryAnswer(),
						screenName, emailAddress, facebookId, openId,
						user.getLanguageId(), user.getTimeZone().getID(),
						user.getGreeting(), user.getComments(), firstName,
						middleName, lastName, prefixId, suffixId, male,
						birthdayMonth, birthdayDay, birthdayYear,
						StringPool.BLANK, StringPool.BLANK, StringPool.BLANK,
						StringPool.BLANK, StringPool.BLANK, StringPool.BLANK,
						StringPool.BLANK, StringPool.BLANK, StringPool.BLANK,
						StringPool.BLANK, jobTitle, groupIds, organizationIds,
						roleIds, new ArrayList<UserGroupRole>(), userGroupIds,
						addresses, emailAddresses, phones, websites,
						announcementsDeliveries, serviceContext);

			}

		} catch (Exception e) {
			_log.error(e);
		}

		return user;
	}

	/**
	 * @param portletRequest
	 * @param name
	 * @return
	 */
	protected long[] getLongArray(PortletRequest portletRequest, String name) {
		String value = portletRequest.getParameter(name);

		if (value == null) {
			return null;
		}

		return StringUtil.split(GetterUtil.getString(value), 0L);
	}

	/**
	 * @param userId
	 * @param userType
	 * @param errors
	 * @return
	 */
	private boolean validationInput(long userId, int userType,
			List<String> errors) {

		boolean result = true;

		if (userId == 0) {
			errors.add(MessageErrors.EMPTY_USER_LIFERAY);
			result = false;
		}

		if (userType == 0) {
			errors.add(MessageErrors.EMPTY_USER_TYPE);
			result = false;
		}

		return result;
	}

	public void addUserHuyen(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {

		List<String> errors = new ArrayList<String>();
		String screenName = ParamUtil.getString(actionRequest, "screenName");
		String fullname = ParamUtil.getString(actionRequest, "fullName");
		String matKhau1 = ParamUtil.getString(actionRequest, "password1");
		String matKhau2 = ParamUtil.getString(actionRequest, "password2");
		String emailAddress = ParamUtil
				.getString(actionRequest, "emailAddress");

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		boolean valid = validate(screenName, fullname, emailAddress, matKhau1,
				matKhau2, cmd, errors);

	

		if (valid) {

			try {
				if (cmd.contentEquals(Constants.ADD)) {
					addUser(actionRequest, actionResponse);
					SessionMessages.add(actionRequest,
							"them-thanh-cong-nguoi-su-dung");
				} else if (cmd.contentEquals(Constants.UPDATE)) {
					updateUser(actionRequest, actionResponse);
					SessionMessages.add(actionRequest,
							"cap-nhat-thanh-cong-nguoi-su-dung");
				}
			} catch (Exception e) {
				SessionErrors.add(actionRequest, e.getClass().getName());
			}
		} else {
			for (String error : errors) {
				SessionErrors.add(actionRequest, error);
			}

		}

		sendCustomRedirect(actionRequest, actionResponse);
	}
	protected boolean validate(String screenName, String fullname,
			String email, String matKhau1, String matKhau2, String cmd,
			List<String> errors) {

		boolean validate = true;

		if (Validator.isNull(screenName) || screenName.trim().length() == 0) {
			errors.add("screen-name-khong-hop-le");
			validate = false;
		}

		if (Validator.isNull(fullname) || fullname.trim().length() == 0) {
			errors.add("full-name-khong-hop-le");
			validate = false;
		}

		if (!Validator.isEmailAddress(email)) {
			errors.add("dia-chi-email-khong-hop-le");
			validate = false;
		}

		if (!Validator.equals(matKhau1, matKhau2)) {
			errors.add("mat-khau-khong-trung-nhau");
			validate = false;
		} else {
			if (cmd.contentEquals(Constants.ADD)
					&& !(Validator.isPassword(matKhau1) && Validator
							.isPassword(matKhau2))) {
				errors.add("mat-khau-khong-hop-le");
				validate = false;
			}
		}

		return validate;
	}
	/**
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 */
	private void sendCustomRedirect(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {

		if (!SessionErrors.isEmpty(actionRequest)) {
			String errorURL = ParamUtil
					.getString(actionRequest, "pageErrorURL");
			SessionMessages
					.add(actionRequest,
							PortalUtil.getPortletId(actionRequest)
									+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

			if (Validator.isNotNull(errorURL)) {
				actionResponse.sendRedirect(errorURL);
			}
		} else {
			String successURL = ParamUtil.getString(actionRequest,
					"pageSuccessURL");
			SessionMessages
					.add(actionRequest,
							PortalUtil.getPortletId(actionRequest)
									+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);

			if (Validator.isNotNull(successURL)) {
				actionResponse.sendRedirect(successURL);
			}
		}
	}
	
	
	private static Log _log = LogFactoryUtil.getLog(QuanLyNguoiDungAction.class);

}
