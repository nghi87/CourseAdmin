<%@include file="/html/init.jsp"%>

<aui:button-row cssClass="course-buttons">
	<portlet:renderURL var="addCourseURL">
		<portlet:param name="mvcPath" value="/html/course/edit_course.jsp"></portlet:param>
	</portlet:renderURL>
	<c:if test='<%= CourseModelPermission.contains(permissionChecker, scopeGroupId, "ADD_COURSE") %>'>
	<aui:button onClick="<%=addCourseURL.toString() %>" value="Add Course"></aui:button>
	</c:if>
</aui:button-row>

<liferay-ui:search-container>
	<liferay-ui:search-container-results
		results="<%= CourseLocalServiceUtil.getCourses(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.course.model.Course"
		modelVar="course"
	>
	
		<liferay-ui:search-container-column-text property="name" />

		<liferay-ui:search-container-column-text property="duration" />

		<liferay-ui:search-container-column-text property="lecturer" name="Lecturer"/>

		<liferay-ui:search-container-column-text property="description" />

		<liferay-ui:search-container-column-text name="Status" value='<%=(course.getStatus()? "Available" : "Unavailable") %>'/>

		<liferay-ui:search-container-column-jsp path="/html/course/course_actions.jsp" align="right" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>