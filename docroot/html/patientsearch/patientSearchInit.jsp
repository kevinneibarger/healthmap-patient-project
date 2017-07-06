<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%-- Liferay Kernel Imports --%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms" %>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@page import="com.liferay.portal.kernel.util.StringPool" %>
<%@page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<%-- Liferay Util Imports --%>
<%@page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.util.SessionClicks" %>

<%-- Liferay Security Imports --%>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>

<%-- Local Package Imports --%>
<%@ page import="com.liferay.healthmap.util.WebKeys" %>
<%@ page import="com.liferay.healthmap.util.PatientRegistrationPermission" %>
<%@ page import="com.liferay.healthmap.util.PatientInfoComparator" %>
<%@ page import="com.liferay.patient.registration.model.PatientRegistration" %>
<%@ page import="com.liferay.patient.registration.service.PatientRegistrationLocalServiceUtil" %>

<%-- Java Imports --%>
<%@ page import="java.text.Format" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections"%>
<%@ page import="java.util.List" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
String currentURL = PortalUtil.getCurrentURL(request);
String firstName = ParamUtil.getString(request, "firstName");
String lastName = ParamUtil.getString(request, "lastName");
int optIn = ParamUtil.getInteger(request, "optFlag");
%>