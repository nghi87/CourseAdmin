<%@include file="/html/init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	Course course = (Course) row.getObject();
%>

<liferay-ui:icon-menu>

	<c:if
		test="<%=CoursePermission.contains(permissionChecker,
							course.getCourseId(), ActionKeys.UPDATE)%>">
		<portlet:renderURL var="editURL">
			<portlet:param name="courseId"
				value="<%=String.valueOf(course.getCourseId())%>" />
			<portlet:param name="mvcPath" value="/html/course/edit_course.jsp" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="Edit"
			url="<%=editURL.toString()%>" />
	</c:if>
	<c:if
		test="<%=CoursePermission.contains(permissionChecker,
							course.getCourseId(), ActionKeys.PERMISSIONS)%>">

		<liferay-security:permissionsURL
			modelResource="<%=Course.class.getName()%>"
			modelResourceDescription="<%=course.getDescription()%>"
			resourcePrimKey="<%=String.valueOf(course.getCourseId())%>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" />

	</c:if>
	<c:if
		test="<%=CoursePermission.contains(permissionChecker,
							course.getCourseId(), ActionKeys.DELETE)%>">

		<portlet:actionURL name="deleteCourse" var="deleteURL">
			<portlet:param name="courseId"
				value="<%=String.valueOf(course.getCourseId())%>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />
	</c:if>

</liferay-ui:icon-menu>