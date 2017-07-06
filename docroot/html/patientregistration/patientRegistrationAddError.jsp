<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<portlet:defineObjects />

<portlet:renderURL var="clickRenderURL">
     <portlet:param name="jspPage" value="/html/patientregistration/patientregistrationform.jsp" />
 </portlet:renderURL>
 
 <input class="span2 btn" onClick="<portlet:namespace/>doRedirect()" value="Try Again"/>

<script>
    function <portlet:namespace/>doRedirect() {
        location.href = '<%= clickRenderURL %>';
    }
</script>