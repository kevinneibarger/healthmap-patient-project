<%@ include file="patientSearchInit.jsp"%>
<%
	long patientId = ParamUtil.getLong(renderRequest, "patientId");

	PatientRegistration patient = null;

	if (patientId > 0) {

		PatientRegistrationLocalServiceUtil patientUtil = new PatientRegistrationLocalServiceUtil();
		patient = patientUtil.getPatientRegistration(patientId);
		portletSession.setAttribute("updatePatientId", patientId);

	}
%>

<script>
$(document).ready(function() {
	
	var preSelectedState = patientState.value;

	$('#<portlet:namespace />state option').each(function(index,element){
		 console.log(index);
		 console.log(element.value);
		 console.log(element.text);
		 
		 if (element.value == preSelectedState) {
			 $('#<portlet:namespace />state').val(preSelectedState);
			 return false;
		 }
	});	
	
	var hasOptedIn = patientOptedIn.value;

	if (hasOptedIn == 1) {
		$('#<portlet:namespace />optin').attr("checked", true);
	} else {
		$('#<portlet:namespace />optin').attr("checked", false);
	}
	
	$('#<portlet:namespace />patientUpdateForm :checkbox').change(function() {
		//var portletNS = "_patientinformation_WAR_patientinformationportlet_";
		
		if ($(this).is(':checked')) {
			$('#<portlet:namespace />optin').val("1");
		} else {
			$('#<portlet:namespace />optin').val("0");
		}
	});
	
	// Check if opt-in is clicked
	$('#<portlet:namespace />optin').click(function(){
		
	});
			
	$('#<portlet:namespace />state option').each(function(index,element){
		 console.log(index);
		 console.log(element.value);
		 console.log(element.text);
		 
		 if (element.value == preSelectedState) {
			 $('#<portlet:namespace />state').val(preSelectedState);
			 return false;
		 }
	});
	
	jQuery.validator.addMethod("validPhone", 
		function (value, element) {
		return value.match(/^\d{3}-\d{3}-\d{4}$/);
	});
	
	jQuery.validator.addMethod(
			"validZip",
		    function(value, element) {
		        return value.match(/^[0-9]{5}$/);
		    }
		);
	
	
	$("#<portlet:namespace />patientUpdateForm").validate({
		 rules: {
			 <portlet:namespace/>firstName: "required",
			 <portlet:namespace/>lastName: "required",
			 <portlet:namespace/>address1: "required",
			 <portlet:namespace/>city: "required",
			 <portlet:namespace/>state: "required",
			 <portlet:namespace/>zipCode: {
				required: true,
				validZip: true
			 },
			 <portlet:namespace />phoneNumber: {
				 required: true,
				 validPhone: true
			 },
			 <portlet:namespace />emailAddr: {
	        	required: true,
	       	 	email: true
		      } 
		 },
		 messages: {
			 <portlet:namespace />firstName: {
		    	 	required: 
		 				function(){
		   
		    		  		return $("#<portlet:namespace />firstNameErr").text("Please enter your first name");
		    	 		}
		      },
		      <portlet:namespace />lastName: {
		    	 	required: function(){
		    		  	return $("#<portlet:namespace />lastNameErr").text("Please enter your last name");
		    	 	}
		      }, 
		      
		      <portlet:namespace />address1: {
		    	 	required: function(){
		    		  	return $("#<portlet:namespace />address1Err").text("Please enter your Address");
		    	 	}
		      },
		      <portlet:namespace />city: {
		    	 	required: function(){
		    		  	return $("#<portlet:namespace />cityErr").text("Please enter your City");
		    	 	}
		      },
		      <portlet:namespace />state: {
		    	 	required: function(){
		    		  	return $("#<portlet:namespace />stateErr").text("Please enter your state");
		    	 	}
		      },
		      <portlet:namespace />zipCode: {
		    	 	required: function(){
		    		  	return $("#<portlet:namespace />zipCodeErr").text("Please enter your zip code");
		    	 	},
		    	 	validZip: function() {
		    	 		return $("#<portlet:namespace />zipCodeErr").text("Zip Code is invalid format, must be only 5 digit numbers");
		    	 	}
		      },
		      <portlet:namespace />emailAddr: {
		    	 	required: function(){
		    		  	return $("#<portlet:namespace />emailAddrErr").text("Please enter an email address");
		    	 	},
		      		email: function() {
		      			return $("#<portlet:namespace />emailAddrErr").text("Please enter a valid email address");
		      		}
		      },
		      <portlet:namespace />phoneNumber: {
		    	 	required: function(){
		    		  	return $("#<portlet:namespace />phoneNumberErr").text("Please enter a Phone Number");
		    	 	},
		    	 	validPhone: function() {
		      			return $("#<portlet:namespace />phoneNumberErr").text("Please enter a phone number in the format 111-222-3333");
		      		}
		      }
		 
		 },
		 submitHandler: function(form) {
			 form.submit();
		 }
	 });   
});

</script>
<portlet:actionURL name="updatePatient" var="updatePatientURL"
	windowState="normal"></portlet:actionURL>

<portlet:renderURL var="patientResultsURL" windowState="normal">
	<portlet:param name="jspPage" value="/html/patientsearch/patientSearchResultContainer.jsp" />
</portlet:renderURL>

<input type="hidden" value="<%=updatePatientURL%>" id="updateURL" />
<input type="hidden" value="<%=patientResultsURL%>" id="resultsURL" />
<input type="hidden" value="<%=patient.getState()%>" id="patientState" />
<input type="hidden" value="<%=patient.getOptIn()%>" id="patientOptedIn" />


<form id="<portlet:namespace />patientUpdateForm" action="<%=updatePatientURL%>" method="post">
	<table id="patient-reg-table">
		<tr>
			<td align="right">First Name:</td>
			<td><input name="<portlet:namespace />firstName"
				class="required" id="<portlet:namespace />firstName"
				value="<%=patient.getFirstName()%>" /></td>
			<td align="left"><p id="<portlet:namespace />firstNameErr"
					class="eVal"></p></td>
		</tr>

		<tr>
			<td align="right">Last Name:</td>
			<td><input name="<portlet:namespace />lastName" class="required"
				id="<portlet:namespace />lastName"
				value="<%=patient.getLastName()%>" /></td>
			<td><p id="<portlet:namespace />lastNameErr" class="eVal"></p></td>
		</tr>

		<tr>
			<td align="right">Address:</td>
			<td><input name="<portlet:namespace />address1" class="required"
				id="<portlet:namespace />address1"
				value="<%=patient.getAddress1()%>" /></td>
			<td><p id="<portlet:namespace />address1Err" class="eVal"></p></td>
		</tr>
		<tr>
			<td align="right">City:</td>
			<td><input name="<portlet:namespace />city" class="required"
				id="<portlet:namespace />city" value="<%=patient.getCity()%>" /></td>
			<td><p id="<portlet:namespace />cityErr" class="eVal"></p></td>
		</tr>
		<tr>
			<td align="right">State:</td>
			<td><select name="<portlet:namespace />state"
				id="<portlet:namespace />state" class="required">
					<option value="">-- Select a State --</option>
					<option value="AL">Alabama</option>
					<option value="AK">Alaska</option>
					<option value="AZ">Arizona</option>
					<option value="AR">Arkansas</option>
					<option value="CA">California</option>
					<option value="CO">Colorado</option>
					<option value="CT">Connecticut</option>
					<option value="DE">Delaware</option>
					<option value="DC">District of Columbia</option>
					<option value="FL">Florida</option>
					<option value="GA">Georgia</option>
					<option value="HI">Hawaii</option>
					<option value="ID">Idaho</option>
					<option value="IL">Illinois</option>
					<option value="IN">Indiana</option>
					<option value="IA">Iowa</option>
					<option value="KS">Kansas</option>
					<option value="KY">Kentucky</option>
					<option value="LA">Louisiana</option>
					<option value="ME">Maine</option>
					<option value="MD">Maryland</option>
					<option value="MA">Massachusetts</option>
					<option value="MI">Michigan</option>
					<option value="MN">Minnesota</option>
					<option value="MS">Mississippi</option>
					<option value="MO">Missouri</option>
					<option value="MT">Montana</option>
					<option value="NE">Nebraska</option>
					<option value="NV">Nevada</option>
					<option value="NH">New Hampshire</option>
					<option value="NJ">New Jersey</option>
					<option value="NM">New Mexico</option>
					<option value="NY">New York</option>
					<option value="NC">North Carolina</option>
					<option value="ND">North Dakota</option>
					<option value="OH">Ohio</option>
					<option value="OK">Oklahoma</option>
					<option value="OR">Oregon</option>
					<option value="PA">Pennsylvania</option>
					<option value="RI">Rhode Island</option>
					<option value="SC">South Carolina</option>
					<option value="SD">South Dakota</option>
					<option value="TN">Tennessee</option>
					<option value="TX">Texas</option>
					<option value="UT">Utah</option>
					<option value="VT">Vermont</option>
					<option value="VA">Virginia</option>
					<option value="WA">Washington</option>
					<option value="WV">West Virginia</option>
					<option value="WI">Wisconsin</option>
					<option value="WY">Wyoming</option>
			</select></td>
			<td><p id="<portlet:namespace />stateErr" class="eVal"></p></td>
		</tr>
		<tr>
			<td align="right">Zip Code:</td>
			<td><input name="<portlet:namespace />zipCode" class="required"
				id="<portlet:namespace />zipCode" value="<%=patient.getZipCode()%>" /></td>
			<td><p id="<portlet:namespace />zipCodeErr" class="eVal"></p></td>
		</tr>
		<tr>
			<td align="right">Email Address:</td>
			<td><input name="<portlet:namespace />emailAddr"
				class="required" id="<portlet:namespace />emailAddr"
				value="<%=patient.getEmailAddr()%>" /></td>
			<td><p id="<portlet:namespace />emailAddrErr" class="eVal"></p></td>
		</tr>
		<tr>
			<td align="right">Phone Number:</td>
			<td><input name="<portlet:namespace />phoneNumber"
				class="required" id="<portlet:namespace />phoneNumber"
				value="<%=patient.getPhoneNumber()%>" /></td>
			<td><p id="<portlet:namespace />phoneNumberErr" class="eVal"></p></td>
		</tr>
		<tr>
			<td align="right">Date Of Birth:</td>
			<td><input name="<portlet:namespace />dob" readonly
				id="<portlet:namespace />dob" value="<%=patient.getDob()%>" /></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right">Opt-In:</td>
			<td><input type="checkbox" name="<portlet:namespace />optin"
				id="<portlet:namespace />optin" class="optInClass" /></td>

			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right">Referring Practice:</td>
			<td><input name="<portlet:namespace />referPractice"
				id="<portlet:namespace />referPractice"
				value="<%=patient.getReferringPractice()%>" /></td>
			<td>&nbsp;</td>
		</tr>

	</table>
	<table id="patient-btn-table">
		<tr>
			<td align="right" width="45%">
				<%-- <input type="button" class="span5 btn" value="Update" id="<portlet:namespace />updatePatient"/></td> --%>
				<input type="submit" class="span5 btn" value="Update"
				id="<portlet:namespace />submitReturn" />
			</td>
			<td align="left" width="45%"><input class="span5 btn"
				type="button"
				onclick="window.location.replace('<%=patientResultsURL%>')"
				value="Back" /></td>
			<td align="left" width="10%" valign="top">&nbsp;</td>
		</tr>
	</table>
</form>