<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.patient.registration.model.PatientRegistration" %>
<%@ page import="com.liferay.patient.registration.service.PatientRegistrationLocalServiceUtil" %>
<%@page import="java.util.List"%>

<%@ include file="patientSearchInit.jsp" %>

<portlet:defineObjects />

<%
	String redirect = ParamUtil.getString(request, "backURL");
	long patientId = ParamUtil.getLong(request, "patientId");
	PatientRegistration selectedPatient = null;
	if (patientId > 0) {
		selectedPatient = PatientRegistrationLocalServiceUtil.getPatientRegistration(patientId);
	}
%>

<portlet:renderURL var="patientResultsURL" windowState="normal">
	<portlet:param name="jspPage" value="/html/patientsearch/patientSearchResultContainer.jsp" />
</portlet:renderURL>

 <portlet:renderURL var="patientUpdateURL">
     <portlet:param name="patientId"
         value="<%= String.valueOf(selectedPatient.getPatientRegistrationId()) %>" />
     <portlet:param name="mvcPath" value="/html/patientsearch/patientSearchEditPatientInfo.jsp" />
 </portlet:renderURL>
      
<%if(selectedPatient!=null){%>
	<h3 class="patient-view-header"> Patient Information </h3>
	<div class="separator"></div>
	<table id="patient-reg-table">
		<tr>
			<td align="right" class="patient-info-label">First Name:</td>
			<td class="patient-info-data"><%=selectedPatient.getFirstName() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		
		<tr>
			<td align="right" class="patient-info-label">Last Name:</td>
			<td class="patient-info-data"><%=selectedPatient.getLastName() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		
		<tr>
			<td align="right" class="patient-info-label">Address:</td>
			<td class="patient-info-data"><%=selectedPatient.getAddress1() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		<tr>
			<td align="right" class="patient-info-label">City:</td>
			<td class="patient-info-data"><%=selectedPatient.getCity()%></td>
			<td align="left">&nbsp;</td>
		</tr>
		<tr>
			<td align="right" class="patient-info-label">State:</td>
			<td class="patient-info-data"><%=selectedPatient.getState() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		<tr>
			<td align="right" class="patient-info-label">Zip Code:</td>
			<td class="patient-info-data"><%=selectedPatient.getZipCode() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		<tr>
			<td align="right" class="patient-info-label">Email Address:</td>
			<td class="patient-info-data"><%=selectedPatient.getEmailAddr() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		<tr>
		<td align="right" class="patient-info-label">Phone Number:</td>
			<td class="patient-info-data"><%=selectedPatient.getPhoneNumber() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		<tr>
			<td align="right" class="patient-info-label">Date Of Birth:</td>
			<td class="patient-info-data"><%=selectedPatient.getDob()%></td>
			<td align="left">&nbsp;</td>
		</tr>
		<tr>
			<td align="right" class="patient-info-label">Opt-In:</td>
			<td class="patient-info-data"><%=selectedPatient.getOptIn()==1?"Yes":"No" %></td>
			<td align="left">&nbsp;</td>
		</tr>
	
		<% if (selectedPatient.getPcpFirstName() != null && !selectedPatient.getPcpFirstName().equalsIgnoreCase("")) { %>
	
		<!--  Show If yes is selected from the PCP -->
		<tr>
			<td align="right" class="patient-info-label">PCP First Name</td>
			<td class="patient-info-data"><%=selectedPatient.getPcpFirstName() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		
		<tr class="pcpInformation">
			<td align="right" class="patient-info-label">PCP Last Name</td>
			<td class="patient-info-data"><%=selectedPatient.getPcpLastName() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		<tr class="pcpInformation">
			<td align="right" class="patient-info-label">PCP Address</td>
			<td class="patient-info-data"><%=selectedPatient.getPcpAddress() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		<tr class="pcpInformation">
			<td align="right" class="patient-info-label">PCP City</td>
			<td class="patient-info-data"><%=selectedPatient.getPcpCity() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		<tr class="pcpInformation">
			<td align="right" class="patient-info-label">PCP State</td>
			<td class="patient-info-data"><%=selectedPatient.getPcpState() %></td>
			<td>&nbsp;</td>
		</tr>
		<tr class="pcpInformation">
			<td align="right" class="patient-info-label">PCP Zip Code</td>
			<td class="patient-info-data"><%=selectedPatient.getPcpZipCode() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		<% } %>
		
		<tr>
			<td align="right" class="patient-info-label">Referring Practice:</td>
			<td class="patient-info-data"><%=selectedPatient.getReferringPractice() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		</table>
		<table id="patient-btn-table">
			<tr>
				<td align="right" width="45%">
					<input type="button" class="span5 btn" value="Edit Information" onclick="window.location.replace('<%=patientUpdateURL%>')"/>
				</td>
				<td align="left" width="50%"><input class="span7 btn"
					type="button"
					onclick="window.location.replace('<%=patientResultsURL%>')"
					value="Back To Search Results" /></td>
				<td align="left" width="5%" valign="top">&nbsp;</td>
			</tr>
		</table>
	
<%}%>