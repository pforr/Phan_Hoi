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

package vn.dtt.ns.thongtinphanhoi.dao.service.base;

import vn.dtt.ns.thongtinphanhoi.dao.service.ChiTietThongTinPhanHoiLocalServiceUtil;

import java.util.Arrays;

/**
 * @author tubq
 * @generated
 */
public class ChiTietThongTinPhanHoiLocalServiceClpInvoker {
	public ChiTietThongTinPhanHoiLocalServiceClpInvoker() {
		_methodName0 = "addChiTietThongTinPhanHoi";

		_methodParameterTypes0 = new String[] {
				"vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi"
			};

		_methodName1 = "createChiTietThongTinPhanHoi";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteChiTietThongTinPhanHoi";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteChiTietThongTinPhanHoi";

		_methodParameterTypes3 = new String[] {
				"vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi"
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

		_methodName10 = "fetchChiTietThongTinPhanHoi";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getChiTietThongTinPhanHoi";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getChiTietThongTinPhanHois";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getChiTietThongTinPhanHoisCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateChiTietThongTinPhanHoi";

		_methodParameterTypes15 = new String[] {
				"vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi"
			};

		_methodName60 = "getBeanIdentifier";

		_methodParameterTypes60 = new String[] {  };

		_methodName61 = "setBeanIdentifier";

		_methodParameterTypes61 = new String[] { "java.lang.String" };

		_methodName66 = "countTopicPhanHoi";

		_methodParameterTypes66 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Date", "java.util.Date"
			};

		_methodName67 = "searchTopicPhanHoi";

		_methodParameterTypes67 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Date", "java.util.Date", "int",
				"int"
			};

		_methodName68 = "countPhanHoiByTopicCode";

		_methodParameterTypes68 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.util.Date",
				"java.util.Date"
			};

		_methodName69 = "countPhanHoiByMaThongTinPhanAnh";

		_methodParameterTypes69 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.util.Date",
				"java.util.Date"
			};

		_methodName70 = "getAllTopicPhanHoi";

		_methodParameterTypes70 = new String[] {  };

		_methodName71 = "getTopicDetailsByTopicCode";

		_methodParameterTypes71 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.util.Date",
				"java.util.Date", "int", "int"
			};

		_methodName72 = "getTopicDetailsById";

		_methodParameterTypes72 = new String[] { "long" };

		_methodName73 = "countPhanHoiByTrangThaiYcgt";

		_methodParameterTypes73 = new String[] {
				"int", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.util.Date", "java.util.Date"
			};

		_methodName74 = "getTopicDetailsByTrangThaiYcgt";

		_methodParameterTypes74 = new String[] {
				"int", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.util.Date", "java.util.Date", "int", "int"
			};

		_methodName75 = "countPhanHoiByTrangThaiYcgtAndGroupByFeedbackCode";

		_methodParameterTypes75 = new String[] {
				"int", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.util.Date", "java.util.Date"
			};

		_methodName76 = "getTopicDetailsByTrangThaiYcgtAndGroupByFeedbackCode";

		_methodParameterTypes76 = new String[] {
				"int", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.util.Date", "java.util.Date", "int", "int"
			};

		_methodName77 = "countTopicDetailsByYcgtId";

		_methodParameterTypes77 = new String[] { "long" };

		_methodName78 = "getTopicDetailsByYcgtId";

		_methodParameterTypes78 = new String[] { "long", "int", "int" };

		_methodName79 = "getChiTietThongTinPhanHoiBy_ttphId_thx";

		_methodParameterTypes79 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName80 = "countPhanHoiGroupByFeedBackCode";

		_methodParameterTypes80 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.util.Date",
				"java.util.Date"
			};

		_methodName81 = "countThongKePhanHoi";

		_methodParameterTypes81 = new String[] { "java.lang.String", "int", "int" };

		_methodName82 = "searchThongKePhanHoi";

		_methodParameterTypes82 = new String[] {
				"java.lang.String", "int", "int", "int", "int"
			};

		_methodName83 = "countThongKePhanHoiByTrangThai";

		_methodParameterTypes83 = new String[] {
				"int", "java.lang.String", "java.lang.String", "java.util.Date",
				"java.util.Date"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.addChiTietThongTinPhanHoi((vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.createChiTietThongTinPhanHoi(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.deleteChiTietThongTinPhanHoi(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.deleteChiTietThongTinPhanHoi((vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.fetchChiTietThongTinPhanHoi(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.getChiTietThongTinPhanHoi(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.getChiTietThongTinPhanHois(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.getChiTietThongTinPhanHoisCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.updateChiTietThongTinPhanHoi((vn.dtt.ns.thongtinphanhoi.dao.model.ChiTietThongTinPhanHoi)arguments[0]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			ChiTietThongTinPhanHoiLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.countTopicPhanHoi((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.util.Date)arguments[4],
				(java.util.Date)arguments[5]);
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.searchTopicPhanHoi((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.util.Date)arguments[4],
				(java.util.Date)arguments[5],
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.countPhanHoiByTopicCode((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.util.Date)arguments[5], (java.util.Date)arguments[6]);
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.countPhanHoiByMaThongTinPhanAnh((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.util.Date)arguments[5], (java.util.Date)arguments[6]);
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.getAllTopicPhanHoi();
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.getTopicDetailsByTopicCode((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.util.Date)arguments[5], (java.util.Date)arguments[6],
				((Integer)arguments[7]).intValue(),
				((Integer)arguments[8]).intValue());
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.getTopicDetailsById(((Long)arguments[0]).longValue());
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.countPhanHoiByTrangThaiYcgt(((Integer)arguments[0]).intValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.util.Date)arguments[6],
				(java.util.Date)arguments[7]);
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.getTopicDetailsByTrangThaiYcgt(((Integer)arguments[0]).intValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.util.Date)arguments[6],
				(java.util.Date)arguments[7],
				((Integer)arguments[8]).intValue(),
				((Integer)arguments[9]).intValue());
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.countPhanHoiByTrangThaiYcgtAndGroupByFeedbackCode(((Integer)arguments[0]).intValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.util.Date)arguments[6],
				(java.util.Date)arguments[7]);
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.getTopicDetailsByTrangThaiYcgtAndGroupByFeedbackCode(((Integer)arguments[0]).intValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.util.Date)arguments[6],
				(java.util.Date)arguments[7],
				((Integer)arguments[8]).intValue(),
				((Integer)arguments[9]).intValue());
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.countTopicDetailsByYcgtId(((Long)arguments[0]).longValue());
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.getTopicDetailsByYcgtId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.getChiTietThongTinPhanHoiBy_ttphId_thx(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3]);
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.countPhanHoiGroupByFeedBackCode((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.util.Date)arguments[5], (java.util.Date)arguments[6]);
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.countThongKePhanHoi((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.searchThongKePhanHoi((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return ChiTietThongTinPhanHoiLocalServiceUtil.countThongKePhanHoiByTrangThai(((Integer)arguments[0]).intValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.util.Date)arguments[3], (java.util.Date)arguments[4]);
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
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName61;
	private String[] _methodParameterTypes61;
	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName69;
	private String[] _methodParameterTypes69;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
	private String _methodName78;
	private String[] _methodParameterTypes78;
	private String _methodName79;
	private String[] _methodParameterTypes79;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName83;
	private String[] _methodParameterTypes83;
}