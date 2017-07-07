<%@ include file="patientSearchInit.jsp"%>

<style type="text/css">
 .toggle-link {
     display: none;
 }
 </style>
 
<%
	String key = "toggle_id_patient_search";
	SessionClicks.put(request, key,"Advanced");

	SearchContainer searchContainer = (SearchContainer) request
			.getAttribute("liferay-ui:search:searchContainer");
	DisplayTerms displayTerms = searchContainer.getDisplayTerms();
%>
<liferay-ui:search-toggle buttonLabel="Patient Search"
	displayTerms="<%=displayTerms%>" id="toggle_id_patient_search">
	
	<aui:form>
		<aui:input label="First Name" name="firstName" value="<%=firstName%>" />
		<aui:input label="Last Name" name="lastName" value="<%=lastName%>" />
		
		<aui:select name="optFlag" label="Patient Opt-In">
			<aui:option label="Opt-In" value="1"></aui:option>
			<aui:option label="Opt-Out" value="0"></aui:option>
			<aui:option label="No Preference" value="-1"></aui:option>
		</aui:select>
	</aui:form>
	
</liferay-ui:search-toggle>