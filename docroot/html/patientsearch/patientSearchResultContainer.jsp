<%@ include file="patientSearchInit.jsp" %>

<% if(SessionMessages.contains(renderRequest.getPortletSession(),"patient-update-success")){%>
<liferay-ui:success key="patient-update-success" message="The Patient was successfully updated in the database" />
<%} %>


<%
 //Get the columns for sort purposes
String sortingColumn = ParamUtil.getString(request, "orderByCol"); 
String orderByType = ParamUtil.getString(request, "orderByType");
		 
// Get opt flag from search
int optIn = ParamUtil.getInteger(request, "optFlag");

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
		<portlet:param name="optFlag" value="<%= String.valueOf(optIn) %>" />
		<portlet:param name="mvcPath" value="/html/patientsearch/patientSearchResultContainer.jsp" />
	</liferay-portlet:renderURL>
	
	<liferay-ui:search-container
		displayTerms="<%= new DisplayTerms(renderRequest) %>"
		emptyResultsMessage="No Patients Found"
		headerNames="firstName,lastName"
		iteratorURL="<%= iteratorURL %>"
		orderByType="<%=orderByType %>"
		delta="10">
		
		
		<liferay-ui:search-form
			page="/html/patientsearch/patientSearch.jsp"
			servletContext="<%= application %>"
		/>
		
		<liferay-ui:search-container-results>
			<%
				
				DisplayTerms displayTerms =searchContainer.getDisplayTerms();
				List<PatientRegistration> patients = new ArrayList<PatientRegistration>();
			
				if (displayTerms.isAdvancedSearch()) {
					
					total = PatientRegistrationLocalServiceUtil.getPatientsSearchCount(firstName, lastName, optIn, displayTerms.isAndOperator());
					patients = PatientRegistrationLocalServiceUtil.getPatientSearchResults(firstName, lastName, optIn,
							displayTerms.isAndOperator(), searchContainer.getStart(), searchContainer.getEnd());
					
				} else {
					String searchkeywords = displayTerms.getKeywords();
					total = PatientRegistrationLocalServiceUtil.getPatientsSearchCountForKeywords(searchkeywords, true);
					patients = PatientRegistrationLocalServiceUtil.getPatientSearchResultsForKeywords(searchkeywords,
							false, searchContainer.getStart(), searchContainer.getEnd());
				}
				
				// Do sorting here..
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
		
				searchContainer.setTotal(total);
				searchContainer.setResults(sortablePatients);
					
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
