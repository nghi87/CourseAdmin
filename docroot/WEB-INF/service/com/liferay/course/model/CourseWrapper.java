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

package com.liferay.course.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Course}.
 * </p>
 *
 * @author ces
 * @see Course
 * @generated
 */
public class CourseWrapper implements Course, ModelWrapper<Course> {
	public CourseWrapper(Course course) {
		_course = course;
	}

	@Override
	public Class<?> getModelClass() {
		return Course.class;
	}

	@Override
	public String getModelClassName() {
		return Course.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("courseId", getCourseId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("lecturer", getLecturer());
		attributes.put("duration", getDuration());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long courseId = (Long)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String lecturer = (String)attributes.get("lecturer");

		if (lecturer != null) {
			setLecturer(lecturer);
		}

		Integer duration = (Integer)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this course.
	*
	* @return the primary key of this course
	*/
	@Override
	public long getPrimaryKey() {
		return _course.getPrimaryKey();
	}

	/**
	* Sets the primary key of this course.
	*
	* @param primaryKey the primary key of this course
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_course.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this course.
	*
	* @return the uuid of this course
	*/
	@Override
	public java.lang.String getUuid() {
		return _course.getUuid();
	}

	/**
	* Sets the uuid of this course.
	*
	* @param uuid the uuid of this course
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_course.setUuid(uuid);
	}

	/**
	* Returns the course ID of this course.
	*
	* @return the course ID of this course
	*/
	@Override
	public long getCourseId() {
		return _course.getCourseId();
	}

	/**
	* Sets the course ID of this course.
	*
	* @param courseId the course ID of this course
	*/
	@Override
	public void setCourseId(long courseId) {
		_course.setCourseId(courseId);
	}

	/**
	* Returns the group ID of this course.
	*
	* @return the group ID of this course
	*/
	@Override
	public long getGroupId() {
		return _course.getGroupId();
	}

	/**
	* Sets the group ID of this course.
	*
	* @param groupId the group ID of this course
	*/
	@Override
	public void setGroupId(long groupId) {
		_course.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this course.
	*
	* @return the company ID of this course
	*/
	@Override
	public long getCompanyId() {
		return _course.getCompanyId();
	}

	/**
	* Sets the company ID of this course.
	*
	* @param companyId the company ID of this course
	*/
	@Override
	public void setCompanyId(long companyId) {
		_course.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this course.
	*
	* @return the user ID of this course
	*/
	@Override
	public long getUserId() {
		return _course.getUserId();
	}

	/**
	* Sets the user ID of this course.
	*
	* @param userId the user ID of this course
	*/
	@Override
	public void setUserId(long userId) {
		_course.setUserId(userId);
	}

	/**
	* Returns the user uuid of this course.
	*
	* @return the user uuid of this course
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _course.getUserUuid();
	}

	/**
	* Sets the user uuid of this course.
	*
	* @param userUuid the user uuid of this course
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_course.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this course.
	*
	* @return the user name of this course
	*/
	@Override
	public java.lang.String getUserName() {
		return _course.getUserName();
	}

	/**
	* Sets the user name of this course.
	*
	* @param userName the user name of this course
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_course.setUserName(userName);
	}

	/**
	* Returns the create date of this course.
	*
	* @return the create date of this course
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _course.getCreateDate();
	}

	/**
	* Sets the create date of this course.
	*
	* @param createDate the create date of this course
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_course.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this course.
	*
	* @return the modified date of this course
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _course.getModifiedDate();
	}

	/**
	* Sets the modified date of this course.
	*
	* @param modifiedDate the modified date of this course
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_course.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this course.
	*
	* @return the name of this course
	*/
	@Override
	public java.lang.String getName() {
		return _course.getName();
	}

	/**
	* Sets the name of this course.
	*
	* @param name the name of this course
	*/
	@Override
	public void setName(java.lang.String name) {
		_course.setName(name);
	}

	/**
	* Returns the description of this course.
	*
	* @return the description of this course
	*/
	@Override
	public java.lang.String getDescription() {
		return _course.getDescription();
	}

	/**
	* Sets the description of this course.
	*
	* @param description the description of this course
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_course.setDescription(description);
	}

	/**
	* Returns the lecturer of this course.
	*
	* @return the lecturer of this course
	*/
	@Override
	public java.lang.String getLecturer() {
		return _course.getLecturer();
	}

	/**
	* Sets the lecturer of this course.
	*
	* @param lecturer the lecturer of this course
	*/
	@Override
	public void setLecturer(java.lang.String lecturer) {
		_course.setLecturer(lecturer);
	}

	/**
	* Returns the duration of this course.
	*
	* @return the duration of this course
	*/
	@Override
	public int getDuration() {
		return _course.getDuration();
	}

	/**
	* Sets the duration of this course.
	*
	* @param duration the duration of this course
	*/
	@Override
	public void setDuration(int duration) {
		_course.setDuration(duration);
	}

	/**
	* Returns the status of this course.
	*
	* @return the status of this course
	*/
	@Override
	public boolean getStatus() {
		return _course.getStatus();
	}

	/**
	* Returns <code>true</code> if this course is status.
	*
	* @return <code>true</code> if this course is status; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus() {
		return _course.isStatus();
	}

	/**
	* Sets whether this course is status.
	*
	* @param status the status of this course
	*/
	@Override
	public void setStatus(boolean status) {
		_course.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _course.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_course.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _course.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_course.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _course.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _course.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_course.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _course.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_course.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_course.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_course.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CourseWrapper((Course)_course.clone());
	}

	@Override
	public int compareTo(com.liferay.course.model.Course course) {
		return _course.compareTo(course);
	}

	@Override
	public int hashCode() {
		return _course.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.course.model.Course> toCacheModel() {
		return _course.toCacheModel();
	}

	@Override
	public com.liferay.course.model.Course toEscapedModel() {
		return new CourseWrapper(_course.toEscapedModel());
	}

	@Override
	public com.liferay.course.model.Course toUnescapedModel() {
		return new CourseWrapper(_course.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _course.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _course.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_course.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CourseWrapper)) {
			return false;
		}

		CourseWrapper courseWrapper = (CourseWrapper)obj;

		if (Validator.equals(_course, courseWrapper._course)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _course.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Course getWrappedCourse() {
		return _course;
	}

	@Override
	public Course getWrappedModel() {
		return _course;
	}

	@Override
	public void resetOriginalValues() {
		_course.resetOriginalValues();
	}

	private Course _course;
}