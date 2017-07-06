<%-- <%@ page import="com.liferay.patient.registration.model.PatientRegistration" %>
<%@ page import="com.liferay.patient.registration.service.PatientRegistrationLocalServiceUtil" %>
<%@ page import="com.liferay.healthmap.util.PatientInfoComparator" %>
<%@ page import="java.util.List" %> --%>

<%@ include file="patientSearchInit.jsp" %>
<%
 //Get the columns for sort purposes
String sortingColumn = ParamUtil.getString(request, "orderByCol"); 
String orderByType = ParamUtil.getString(request, "orderByType");
String sortOrder = orderByType;

//Logic for toggle asc and desc
if(orderByType.equals("desc")){
  orderByType = "asc";
}else{
  orderByType = "desc";
}

if(Validator.isNull(orderByType)){
  orderByType = "desc";
} 
		
%>
<%-- <h4> Order By: <%=orderByType %> Column: <%=sortingColumn %></h4> 
<a href="<portlet:renderURL />">&laquo;Home</a>--%>
<h5> Search Patient Directory</h5>
<div class="separator"></div>

<input type="hidden" id="keywordSearch" value=""/>

<script>
$(document).ready(function() {
	
	alert('Is there a keyword? '+('#<portlet:namespace />toggle_id_patient_search').val());
	//$('#<portlet:namespace />keywordSearch')
});
</script>

<liferay-portlet:renderURL varImpl="patientSearchURL">
	<portlet:param name="mvcPath" value="/html/patientsearch/patientSearchResultContainer.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%=patientSearchURL %>" method="get" name="patientSearchForm">
	<liferay-portlet:renderURLParams varImpl="patientSearchURL" />
	
	<liferay-portlet:renderURL varImpl="iteratorURL">
		<portlet:param name="firstName" value="<%= firstName %>" />
		<portlet:param name="lastName" value="<%= lastName %>" />
		<portlet:param name="mvcPath" value="/html/patientsearch/patientSearchResultContainer.jsp" />
	</liferay-portlet:renderURL>
	
	<liferay-ui:search-container
		displayTerms="<%= new DisplayTerms(renderRequest) %>"
		emptyResultsMessage="No Patients Found"
		headerNames="firstName,lastName"
		iteratorURL="<%= iteratorURL %>"
		orderByType="<%=orderByType %>">
		
		
		<liferay-ui:search-form
			page="/html/patientsearch/patientSearch.jsp"
			servletContext="<%= application %>"
		/>
		
		<liferay-ui:search-container-results>
			<%
				
				DisplayTerms displayTerms =searchContainer.getDisplayTerms();
				if (displayTerms.isAdvancedSearch()) {
					total = PatientRegistrationLocalServiceUtil.getPatientsSearchCount(firstName, lastName, optIn, displayTerms.isAndOperator());
					
					searchContainer.setTotal(total);
					
					List<PatientRegistration> patients = PatientRegistrationLocalServiceUtil.getPatientSearchResults(firstName, lastName, optIn,
							displayTerms.isAndOperator(), searchContainer.getStart(), searchContainer.getEnd());
					
					
					List<PatientRegistration> sortablePatients = new ArrayList<PatientRegistration>(patients);
					
					// Sort by the column selected
					if (Validator.isNotNull(sortingColumn)) {
						// get the comparator
						PatientInfoComparator comparator = null;
						if (sortOrder.equals("asc")) {
							comparator = new PatientInfoComparator(sortingColumn, true);
						} else {
							comparator = new PatientInfoComparator(sortingColumn, false);
						}
						
						Collections.sort(sortablePatients, comparator);
					}
					
					searchContainer.setResults(sortablePatients);
					
				}else {
					String searchkeywords = displayTerms.getKeywords();
					total = PatientRegistrationLocalServiceUtil.getPatientsSearchCountForKeywords(searchkeywords, true);
					
					List<PatientRegistration> patients = PatientRegistrationLocalServiceUtil.getPatientSearchResultsForKeywords(searchkeywords,
							false, searchContainer.getStart(), searchContainer.getEnd());
					
					List<PatientRegistration> sortablePatients = new ArrayList<PatientRegistration>(patients);
					
					// Sort by the column selected
					if (Validator.isNotNull(sortingColumn)) {
						// get the comparator
						PatientInfoComparator comparator = null;
						if (sortOrder.equals("asc")) {
							comparator = new PatientInfoComparator(sortingColumn, true);
						} else {
							comparator = new PatientInfoComparator(sortingColumn, false);
						}
						
						Collections.sort(sortablePatients, comparator);
					}
			
					searchContainer.setResults(sortablePatients);
				}
					
			%>
		</liferay-ui:search-container-results>
		
		<liferay-ui:search-container-row
			className="com.liferay.patient.registration.model.PatientRegistration"
			keyProperty="patientRegistrationId"
			modelVar="patient">
			
			<liferay-portlet:renderURL varImpl="rowURL">
				<portlet:param name="backURL" value="<%= currentURL %>" />
				<portlet:param name="mvcPath" value="/html/patientsearch/patientSearchShowPatientInfo.jsp" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="patientId" value="<%= String.valueOf(patient.getPatientRegistrationId()) %>" />
			</liferay-portlet:renderURL>
			
			 <liferay-ui:search-container-column-text 
			 	href="<%= rowURL %>"
	        	name="First Name"
	        	property="firstName"
	        	orderable="true"
	      		orderableProperty="firstName"/>
        	 
        	<liferay-ui:search-container-column-text 
        		href="<%= rowURL %>"
	        	name="Last Name"
	        	property="lastName"
	        	orderable="true"
	      		orderableProperty="lastName"
        	 />	 
        	 <liferay-ui:search-container-column-text
        	 	name="Patient Opt-In"
				value='<%=patient.getOptIn()==1?"Yes":"No"%>'
			/>

		<liferay-ui:search-container-column-jsp path="/html/patientsearch/patientSearchActions.jsp" 
			name="Edit/Delete" align="right" />
	</liferay-ui:search-container-row>	
	
<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />
	</liferay-ui:search-container>
</aui:form>