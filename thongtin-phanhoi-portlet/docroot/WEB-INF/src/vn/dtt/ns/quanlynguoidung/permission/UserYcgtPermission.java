package vn.dtt.ns.quanlynguoidung.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class UserYcgtPermission {
	public static void check(PermissionChecker permissionChecker, long groupId,
			String actionId) 
		throws PortalException {

		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long groupId, String actionId) {
		
		return permissionChecker.hasPermission(groupId, RESOURCE_NAME, groupId,
				actionId);
	}
	
	public static final String RESOURCE_NAME = "vn.dtt.ns.yeucaugiaitrinh.dao.model.YeuCauGiaiTrinh";
}
