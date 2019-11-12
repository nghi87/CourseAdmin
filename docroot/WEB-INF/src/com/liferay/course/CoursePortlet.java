package com.liferay.course;

import com.liferay.course.model.Course;
import com.liferay.course.service.CourseLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class CoursePortlet
 */
public class CoursePortlet extends MVCPortlet {

	public void addCourse(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Course.class.getName(), request);

		long courseId = ParamUtil.getLong(request, "courseId");
		String name = ParamUtil.getString(request, "name");
		String description = ParamUtil.getString(request, "description");
		String lecturer = ParamUtil.getString(request, "lecturer");
		int duration = ParamUtil.getInteger(request, "duration");
		boolean status = ParamUtil.getBoolean(request, "status");

		if (courseId > 0) {
			try {
				CourseLocalServiceUtil.updateCourse(serviceContext.getUserId(),
						courseId, name, description, lecturer, duration, status,
						serviceContext);

				SessionMessages.add(request, "courseAdded");

			} catch (Exception e) {

				SessionErrors.add(request, e.getClass().getName());

				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter("mvcPath",
						"/html/course/edit_course.jsp");
			}

		} else {

			try {
				CourseLocalServiceUtil.addCourse(serviceContext.getUserId(),
						name, description, lecturer, duration, status,
						serviceContext);
				SessionMessages.add(request, "courseAdded");

			} catch (Exception e) {
				SessionErrors.add(request, e.getClass().getName());

				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter("mvcPath",
						"/html/course/edit_course.jsp");
			}
		}
	}

	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					Course.class.getName(), request);

			long groupId = serviceContext.getScopeGroupId();

			List<Course> courses = CourseLocalServiceUtil.getCourses(groupId);

			if (courses.size() == 0) {
				long userId = serviceContext.getUserId();

				for (int i = 1; i <= 5; i++) {
					CourseLocalServiceUtil.addCourse(userId,
							StringUtil.randomString(30),
							StringUtil.randomString(30),
							StringUtil.randomString(30), i, true,
							serviceContext);
				}
			}

		} catch (Exception e) {
			throw new PortletException();
		}

		super.render(request, response);
	}

	public void deleteCourse(ActionRequest request, ActionResponse response) {
		long courseId = ParamUtil.getLong(request, "courseId");

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					Course.class.getName(), request);

			CourseLocalServiceUtil.deleteCourse(courseId, serviceContext);

		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
		}
	}
}