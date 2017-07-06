<%@ page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<portlet:defineObjects />

<% if(SessionMessages.contains(renderRequest.getPortletSession(),"patient-update-success")){%>
<liferay-ui:success key="patient-update-success" message="The Patient was successfully updated in the database" />
<%} %>

<portlet:renderURL var="clickRenderURL">
     <portlet:param name="jspPage" value="/html/patientsearch/patientSearchResultContainer.jsp" />
 </portlet:renderURL>
 
 <input class="span5 btn" onClick="<portlet:namespace/>doRedirect()" value="Back To Results"/>

<script>
    function <portlet:namespace/>doRedirect() {
        location.href = '<%= clickRenderURL %>';
    }
</script>