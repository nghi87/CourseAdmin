<%@include file="/html/init.jsp"%>

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

<aui:form action="<%=addCourseURL%>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%=course%>" model="<%=Course.class%>" />
	<aui:fieldset>
		<aui:input name="name">
			<aui:validator name="required" />
			<aui:validator name="maxLength">75</aui:validator>
		</aui:input>
		<aui:input name="description" type="textarea">
			<aui:validator name="maxLength">2000</aui:validator>
		</aui:input>
		<aui:input name="lecturer" label="Lecturer">
			<aui:validator name="required" />
			<aui:validator name="maxLength">75</aui:validator>
		</aui:input>
		<aui:input name="duration">
			<aui:validator name="required" />
			<aui:validator name="number"></aui:validator>
			<aui:validator name="min">1</aui:validator>
			<aui:validator name="max">40</aui:validator>
		</aui:input>

		<aui:input name="courseId" type="hidden" />
	</aui:fieldset>
	<aui:field-wrapper label="Status">
		<aui:input name="status" type="radio" value="true" label="Available" checked="<%=status%>" />
		<aui:input name="status" type="radio" value="false" label="Unavailable" checked="<%=!status%>" />
	</aui:field-wrapper>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>
	</aui:button-row>
</aui:form>