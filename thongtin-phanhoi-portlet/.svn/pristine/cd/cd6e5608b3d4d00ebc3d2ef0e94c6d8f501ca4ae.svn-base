package vn.dtt.ns.quanlynguoidung.permission;

import vn.dtt.ns.thongtinphanhoi.util.ActionKeys;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class UserMappingPermission {
	public static void check(PermissionChecker permissionChecker, long groupId,
			String actionId) 
		throws PortalException {

		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
	}
	
	public static void check(PermissionChecker permissionChecker, long groupId,
			int trangThai, String actionId) throws PortalException {

		if (!contains(permissionChecker, groupId, trangThai, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, long groupId,
			String tableName, long id,int trangThai, String actionId) throws PortalException {

		if (!contains(permissionChecker, groupId, trangThai, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long groupId,String tableName, long userId, long userIdData, int trangThai, String actionId) {
		boolean isPermission = false;
		if(tableName.trim().equalsIgnoreCase("me_kehoachkiemdemnuoc")){
			if (actionId.equals(ActionKeys.ADMIN_KEHOACH_KIEMDEM)) {
				if (contains(permissionChecker, groupId, actionId)
						&& (trangThai == 0) && userId == userIdData) {
					isPermission = true;
				}
				if (contains(permissionChecker, groupId, actionId)
						&& (trangThai == 2 ) && userId == userIdData) {
					isPermission = false;
				}
			}
		}else if(tableName.trim().equalsIgnoreCase("me_vesinhgiadinh") || tableName.trim().equalsIgnoreCase("me_vesinhcongtrinh") ){
			if (actionId.equals(ActionKeys.ADMIN_VESINH)) {
				if (contains(permissionChecker, groupId, actionId)
						&& (trangThai == 0) && userId == userIdData) {
					isPermission = true;
				}
			}
		}else if(tableName.trim().equalsIgnoreCase("me_daunoinuoc")){
			if (actionId.equals(ActionKeys.ADMIN_DAUNOI)) {
				if (contains(permissionChecker, groupId, actionId)
						&& (trangThai == 0) && userId == userIdData) {
					isPermission = true;
				}
			}
		}
		
		return isPermission;
	}
	
	public static boolean contains(PermissionChecker permissionChecker,
			long groupId, int trangThai, String actionId) {
		boolean isPermission = false;
		if (actionId.equals(ActionKeys.ADMIN_KEHOACH_KIEMDEM)) {
			if (contains(permissionChecker, groupId, actionId)
					&& (trangThai == 0 || trangThai == 1)) {
				isPermission = true;
			}
			if (contains(permissionChecker, groupId, actionId)
					&& (trangThai == 2)) {
				isPermission = false;
			}
		}
		return isPermission;
	}
	public static boolean contains(PermissionChecker permissionChecker,
			long groupId, String actionId) {
		
		return permissionChecker.hasPermission(groupId, _NAME, groupId,
				actionId);
	}

	private static final String _NAME = "vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc";
}
