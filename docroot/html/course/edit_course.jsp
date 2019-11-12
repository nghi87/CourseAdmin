<%@ include file="/html/init.jsp" %>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/course/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="addCourse" var="addCourseURL"></portlet:actionURL>

<%
	long courseId = ParamUtil.getLong(renderRequest, "courseId");

	Course course = null;

	if (courseId > 0) {

		course = CourseLocalServiceUtil.getCourse(courseId);

	}

	boolean status = course == null ? false : course.getStatus();
%>

<aui:form action="<%= addCourseURL %>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%= course %>" model="<%= Course.class %>" />
	<aui:fieldset>
		<aui:input label="course-name-text" name="name">
			<aui:validator name="required" />
			<aui:validator name="maxLength">75</aui:validator>
		</aui:input>
		<aui:input label="course-description-text" name="description" type="textarea">
			<aui:validator name="maxLength">2000</aui:validator>
		</aui:input>
		<aui:input label="course-lecturer-text" name="lecturer">
			<aui:validator name="required" />
			<aui:validator name="maxLength">75</aui:validator>
		</aui:input>
		<aui:input label="course-duration-text" name="duration">
			<aui:validator name="required" />
			<aui:validator name="number"></aui:validator>
			<aui:validator name="min">1</aui:validator>
			<aui:validator name="max">40</aui:validator>
		</aui:input>

		<aui:input name="courseId" type="hidden" />
	</aui:fieldset>
	<aui:field-wrapper label="course-status-radio">
		<aui:input checked="<%= status %>" label="course-available-option" name="status" type="radio" value="true" />
		<aui:input checked="<%= !status %>" label="course-unavailable-option" name="status" type="radio" value="false" />
	</aui:field-wrapper>

	<aui:button-row>
		<aui:button type="submit" value="course-save-button" />
		<aui:button onClick="<%= viewURL.toString() %>" type="cancel" value="course-cancel-button" />
	</aui:button-row>
</aui:form>