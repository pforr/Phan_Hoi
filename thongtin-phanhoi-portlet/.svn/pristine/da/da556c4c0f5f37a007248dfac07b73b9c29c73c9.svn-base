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

package vn.dtt.ns.quanlynguoidung.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Role;

/**
 * @author Brian Wing Shun Chan
 */
public class RoleSearch extends SearchContainer<Role> {

	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();

	static {
		headerNames.add("title");
		headerNames.add("type");

		headerNames.add("description");

		orderableHeaders.put("title", "title");
		orderableHeaders.put("type", "type");
		orderableHeaders.put("description", "description");
	}

	public static final String EMPTY_RESULTS_MESSAGE = "no-roles-were-found";

	public RoleSearch(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(
			portletRequest, null,
			null, DEFAULT_CUR_PARAM,
			DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
	}

	private static Log _log = LogFactoryUtil.getLog(RoleSearch.class);

}