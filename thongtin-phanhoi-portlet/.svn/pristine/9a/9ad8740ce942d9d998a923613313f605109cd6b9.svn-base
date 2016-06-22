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

package vn.dtt.ns.thongtinphanhoi.dao.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TopicDetailsService}.
 *
 * @author tubq
 * @see TopicDetailsService
 * @generated
 */
public class TopicDetailsServiceWrapper implements TopicDetailsService,
	ServiceWrapper<TopicDetailsService> {
	public TopicDetailsServiceWrapper(TopicDetailsService topicDetailsService) {
		_topicDetailsService = topicDetailsService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _topicDetailsService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_topicDetailsService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _topicDetailsService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TopicDetailsService getWrappedTopicDetailsService() {
		return _topicDetailsService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTopicDetailsService(
		TopicDetailsService topicDetailsService) {
		_topicDetailsService = topicDetailsService;
	}

	@Override
	public TopicDetailsService getWrappedService() {
		return _topicDetailsService;
	}

	@Override
	public void setWrappedService(TopicDetailsService topicDetailsService) {
		_topicDetailsService = topicDetailsService;
	}

	private TopicDetailsService _topicDetailsService;
}