<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@ page import="com.liferay.course.model.Course" %><%@
page import="com.liferay.course.service.CourseLocalServiceUtil" %><%@
page import="com.liferay.course.service.permission.CourseModelPermission" %><%@
page import="com.liferay.course.service.permission.CoursePermission" %><%@
page import="com.liferay.course.util.WebKeys" %><%@
page import="com.liferay.portal.kernel.dao.search.ResultRow" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.security.permission.ActionKeys" %>

<portlet:defineObjects />
<theme:defineObjects />