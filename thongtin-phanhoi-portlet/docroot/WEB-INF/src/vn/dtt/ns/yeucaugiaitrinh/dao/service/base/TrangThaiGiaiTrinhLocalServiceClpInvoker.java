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

package vn.dtt.ns.yeucaugiaitrinh.dao.service.base;

import vn.dtt.ns.yeucaugiaitrinh.dao.service.TrangThaiGiaiTrinhLocalServiceUtil;

import java.util.Arrays;

/**
 * @author tubq
 * @generated
 */
public class TrangThaiGiaiTrinhLocalServiceClpInvoker {
	public TrangThaiGiaiTrinhLocalServiceClpInvoker() {
		_methodName0 = "addTrangThaiGiaiTrinh";

		_methodParameterTypes0 = new String[] {
				"vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh"
			};

		_methodName1 = "createTrangThaiGiaiTrinh";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteTrangThaiGiaiTrinh";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteTrangThaiGiaiTrinh";

		_methodParameterTypes3 = new String[] {
				"vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchTrangThaiGiaiTrinh";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getTrangThaiGiaiTrinh";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getTrangThaiGiaiTrinhs";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getTrangThaiGiaiTrinhsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateTrangThaiGiaiTrinh";

		_methodParameterTypes15 = new String[] {
				"vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh"
			};

		_methodName50 = "getBeanIdentifier";

		_methodParameterTypes50 = new String[] {  };

		_methodName51 = "setBeanIdentifier";

		_methodParameterTypes51 = new String[] { "java.lang.String" };

		_methodName56 = "getTrangThaiGiaiTrinhByYcgtId";

		_methodParameterTypes56 = new String[] { "long" };

		_methodName57 = "getTrangThaiGiaiTrinhByYcgtIdAndTrangThai";

		_methodParameterTypes57 = new String[] { "long", "int" };

		_methodName58 = "getTrangThaiGiaiTrinhByQuaTrinhXuLy";

		_methodParameterTypes58 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return TrangThaiGiaiTrinhLocalServiceUtil.addTrangThaiGiaiTrinh((vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return TrangThaiGiaiTrinhLocalServiceUtil.createTrangThaiGiaiTrinh(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return TrangThaiGiaiTrinhLocalServiceUtil.deleteTrangThaiGiaiTrinh(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return TrangThaiGiaiTrinhLocalServiceUtil.deleteTrangThaiGiaiTrinh((vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return TrangThaiGiaiTrinhLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return TrangThaiGiaiTrinhLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return TrangThaiGiaiTrinhLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return TrangThaiGiaiTrinhLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return TrangThaiGiaiTrinhLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return TrangThaiGiaiTrinhLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return TrangThaiGiaiTrinhLocalServiceUtil.fetchTrangThaiGiaiTrinh(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return TrangThaiGiaiTrinhLocalServiceUtil.getTrangThaiGiaiTrinh(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return TrangThaiGiaiTrinhLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return TrangThaiGiaiTrinhLocalServiceUtil.getTrangThaiGiaiTrinhs(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return TrangThaiGiaiTrinhLocalServiceUtil.getTrangThaiGiaiTrinhsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return TrangThaiGiaiTrinhLocalServiceUtil.updateTrangThaiGiaiTrinh((vn.dtt.ns.yeucaugiaitrinh.dao.model.TrangThaiGiaiTrinh)arguments[0]);
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			return TrangThaiGiaiTrinhLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			TrangThaiGiaiTrinhLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return TrangThaiGiaiTrinhLocalServiceUtil.getTrangThaiGiaiTrinhByYcgtId(((Long)arguments[0]).longValue());
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return TrangThaiGiaiTrinhLocalServiceUtil.getTrangThaiGiaiTrinhByYcgtIdAndTrangThai(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return TrangThaiGiaiTrinhLocalServiceUtil.getTrangThaiGiaiTrinhByQuaTrinhXuLy(((Long)arguments[0]).longValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName58;
	private String[] _methodParameterTypes58;
}