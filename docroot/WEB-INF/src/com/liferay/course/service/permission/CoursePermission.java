package com.liferay.course.service.permission;

import com.liferay.course.model.Course;
import com.liferay.course.service.CourseLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
public class CoursePermission {
	public static void check(PermissionChecker permissionChecker,
			long guestbookId, String actionId) throws PortalException,
			SystemException {

		if (!contains(permissionChecker, guestbookId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long courseId, String actionId) throws PortalException,
			SystemException {

		Course course = CourseLocalServiceUtil.getCourse(courseId);

		return permissionChecker.hasPermission(course.getGroupId(),
				Course.class.getName(), course.getCourseId(), actionId);
	}
}