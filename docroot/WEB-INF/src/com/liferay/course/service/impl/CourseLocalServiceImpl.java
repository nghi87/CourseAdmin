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

package com.liferay.course.service.impl;

import com.liferay.course.CourseDurationException;
import com.liferay.course.CourseLecturerException;
import com.liferay.course.CourseNameException;
import com.liferay.course.CourseStatusException;
import com.liferay.course.model.Course;
import com.liferay.course.service.base.CourseLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the course local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.course.service.CourseLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author ces
 * @see com.liferay.course.service.base.CourseLocalServiceBaseImpl
 * @see com.liferay.course.service.CourseLocalServiceUtil
 */
public class CourseLocalServiceImpl extends CourseLocalServiceBaseImpl {

	public Course addCourse(long userId, String name, String description,
			String lecturer, int duration, boolean status, ServiceContext serviceContext)
					throws PortalException, SystemException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(name, description, lecturer, duration, status);

		long courseId = counterLocalService.increment();

		Course course = coursePersistence.create(courseId);

		course.setUuid(serviceContext.getUuid());
		course.setUserId(userId);
		course.setGroupId(groupId);
		course.setCompanyId(user.getCompanyId());
		course.setUserName(user.getFullName());
		course.setCreateDate(serviceContext.getCreateDate(now));
		course.setModifiedDate(serviceContext.getModifiedDate(now));

		course.setName(name);
		course.setDescription(description);
		course.setLecturer(lecturer);
		course.setDuration(duration);
		course.setStatus(status);

		course.setExpandoBridgeAttributes(serviceContext);

		coursePersistence.update(course);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
				Course.class.getName(), courseId, false, true, true);

		return course;
	}

	public Course deleteCourse(long courseId, ServiceContext serviceContext)
			throws PortalException, SystemException {

		Course course = getCourse(courseId);

		resourceLocalService.deleteResource(serviceContext.getCompanyId(),
				Course.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				courseId);

		course = deleteCourse(courseId);

		return course;
	}

	public List<Course> getCourses(long groupId, int start, int end)
			throws SystemException {
		return coursePersistence.findByGroupId(groupId, start, end);
	}

	public Course updateCourse(long userId, long courseId, String name,
			String description, String lecturer, int duration, boolean status, ServiceContext serviceContext)
					throws PortalException, SystemException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(name, description, lecturer, duration, status);

		Course course = getCourse(courseId);

		course.setUserId(userId);
		course.setUserName(user.getFullName());

		course.setName(name);
		course.setDescription(description);
		course.setLecturer(lecturer);
		course.setDuration(duration);
		course.setStatus(status);

		course.setModifiedDate(serviceContext.getModifiedDate(now));
		course.setExpandoBridgeAttributes(serviceContext);

		coursePersistence.update(course);

		resourceLocalService.updateResources(user.getCompanyId(), groupId,
				Course.class.getName(), courseId,
				serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());

		return course;
	} public List<Course> getCourses(long groupId) throws SystemException {
		return coursePersistence.findByGroupId(groupId);
	}

	protected void validate(String name, String description, String lecturer,
			int duration, boolean status) throws PortalException {
		if (Validator.isNull(name)) {
			throw new CourseNameException();
		}

		if (Validator.isNull(lecturer)) {
			throw new CourseLecturerException();
		}

		if (Validator.isNull(duration)) {
			throw new CourseDurationException();
		}

		if (Validator.isNull(status)) {
			throw new CourseStatusException();
		}
	}

}