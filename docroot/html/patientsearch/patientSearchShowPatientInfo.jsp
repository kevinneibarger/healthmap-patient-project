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
	<p> Patient Information </p>
	
	<table id="patient-reg-table">
		<tr>
			<td align="right">First Name:</td>
			<td><%=selectedPatient.getFirstName() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		
		<tr>
			<td align="right">Last Name:</td>
			<td><%=selectedPatient.getLastName() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		
		<tr>
			<td align="right">Address:</td>
			<td><%=selectedPatient.getAddress1() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		<tr>
			<td align="right">City:</td>
			<td><%=selectedPatient.getCity()%></td>
			<td align="left">&nbsp;</td>
		</tr>
		<tr>
			<td align="right">State:</td>
			<td><%=selectedPatient.getState() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		<tr>
			<td align="right">Zip Code:</td>
			<td><%=selectedPatient.getZipCode() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		<tr>
			<td align="right">Email Address:</td>
			<td><%=selectedPatient.getEmailAddr() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		<tr>
		<td align="right">Phone Number:</td>
			<td><%=selectedPatient.getPhoneNumber() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		<tr>
			<td align="right">Date Of Birth:</td>
			<td><%=selectedPatient.getDob()%></td>
			<td align="left">&nbsp;</td>
		</tr>
		<tr>
			<td align="right">Opt-In:</td>
			<td><%=selectedPatient.getOptIn() %></td>
			<td align="left">&nbsp;</td>
		</tr>
	
		<% if (selectedPatient.getPcpFirstName() != null && !selectedPatient.getPcpFirstName().equalsIgnoreCase("")) { %>
	
		<!--  Show If yes is selected from the PCP -->
		<tr>
			<td align="right">PCP First Name</td>
			<td><%=selectedPatient.getPcpFirstName() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		
		<tr class="pcpInformation">
			<td align="right">PCP Last Name</td>
			<td><%=selectedPatient.getPcpLastName() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		<tr class="pcpInformation">
			<td align="right">PCP Address</td>
			<td><%=selectedPatient.getPcpAddress() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		<tr class="pcpInformation">
			<td align="right">PCP City</td>
			<td><%=selectedPatient.getPcpCity() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		<tr class="pcpInformation">
			<td align="right">PCP State</td>
			<td><%=selectedPatient.getPcpState() %></td>
			<td>&nbsp;</td>
		</tr>
		<tr class="pcpInformation">
			<td align="right">PCP Zip Code</td>
			<td><%=selectedPatient.getPcpZipCode() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		<% } %>
		
		<tr>
			<td align="right">Referring Practice:</td>
			<td><%=selectedPatient.getReferringPractice() %></td>
			<td align="left">&nbsp;</td>
		</tr>
		</table>
		<table id="patient-btn-table">
			<tr>
				<td align="right" width="45%">
					<input type="button" class="span5 btn" value="Edit Information" onclick="window.location.replace('<%=patientUpdateURL%>')"/>
				</td>
				<td align="left" width="45%"><input class="span5 btn"
					type="button"
					onclick="window.location.replace('<%=patientResultsURL%>')"
					value="Back" /></td>
				<td align="left" width="10%" valign="top">&nbsp;</td>
			</tr>
		</table>
	
<%}%>