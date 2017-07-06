<%@ include file="../patientsearch/patientSearchInit.jsp" %>

<portlet:actionURL name="addNewPatient" var="addNewPatientURL" windowState="normal"></portlet:actionURL>
<input type="hidden" value="<%=addNewPatientURL%>" id="formURL"/>

<script>
	$(document).ready(function() {
			
		$(function() { 
		
			jQuery.validator.addMethod(
					"validDOB",
				    function(value, element) {
				        return value.match(/^\d\d?\/\d\d?\/\d\d\d\d$/);
				    }
				);
			
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
			
			$("#<portlet:namespace />pcpYes").attr('checked', false);
			$(".pcpInformation").hide();
			
			// Check check boxes
			$('#<portlet:namespace />patientRegForm :checkbox').change(function() {
				if ($(this).attr('class') == 'pcpYesChecked') {
					if ($(this).is(':checked')) {
						$(".pcpInformation").show();
				    } else {
				        $(".pcpInformation").hide();
				    }
				}
			});
			
			/* $("#<portlet:namespace />pcpYes").click(function() {
				if ($('#<portlet:namespace />pcpYes').is(':checked')) {
					alert($('#<portlet:namespace />pcpYes').is(':checked'));
				} 
				$("#<portlet:namespace />pcpNo").attr('checked', false);
				$(".pcpInformation").show();
			});
			
			$("#<portlet:namespace />pcpNo").click(function() {
				$("#<portlet:namespace />pcpYes").attr('checked', false);
				$(".pcpInformation").hide();
			}); */
			
		
			
				 $("#<portlet:namespace />patientRegForm").validate({
					 rules: {
						 <portlet:namespace />firstName: "required",
						 <portlet:namespace />lastName: "required",
						 <portlet:namespace />address1: "required",
						 <portlet:namespace />city: "required",
						 <portlet:namespace />state: "required",
						 <portlet:namespace />zipCode: {
							required: true,
							validZip: true
						 },
						 <portlet:namespace />dob: {
							 required: true,
							 validDOB: true
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
					      },
					      <portlet:namespace />dob: {
					    	 	required: function(){
					    		  	return $("#<portlet:namespace />dobErr").text("Please enter a valid date of birth");
					    	 	},
					    	 	validDOB: function() {
					    	 		return $("#<portlet:namespace />dobErr").text("Please enter a date in the format dd/mm/yyyy.");
					    	 	}
					      }
					 
					 },
					 submitHandler: function(form) {
						 form.submit();
					 }
				 });   
		 	
		 	 
		 	$("#<portlet:namespace />dob").datepicker({
		 		changeMonth: true,
	            changeYear: true,
	            yearRange: "-110:+0",
		 		minDate : new Date(1900, 1, -1, 1),
		 		maxDate : new Date()
		 	});
		});
	});
</script>

<% if(SessionMessages.contains(renderRequest.getPortletSession(),"new-patient-add-success")){%>
<liferay-ui:success key="new-patient-add-success" message="The New Patient was successfully added to the database" />
<%} %>

 <form id="<portlet:namespace />patientRegForm" action="<%=addNewPatientURL%>" method="post">
 	<h4 class="registration-form-header">Patient Registration Form</h4>
 	<div class="separator"></div>
	 <table id="patient-reg-table">
		<tr>
			<td align="right">First Name:</td>
			<td><input name="<portlet:namespace />firstName" class="required" id="<portlet:namespace />firstName" /></td>
			<td align="left"><p id="<portlet:namespace />firstNameErr" class="eVal"></p></td>
		</tr>
		
		<tr>
			<td align="right">Last Name:</td>
			<td><input name="<portlet:namespace />lastName" class="required" id="<portlet:namespace />lastName" /></td>
			<td><p id="<portlet:namespace />lastNameErr" class="eVal"></p></td>
		</tr>
		
		<tr>
			<td align="right">Address:</td>
			<td><input name="<portlet:namespace />address1" class="required" id="<portlet:namespace />address1" /></td>
			<td><p id="<portlet:namespace />address1Err" class="eVal"></p></td>
		</tr>
		<tr>
			<td align="right">City:</td>
			<td><input name="<portlet:namespace />city" class="required" id="<portlet:namespace />city" /></td>
			<td><p id="<portlet:namespace />cityErr" class="eVal"></p></td>
		</tr>
		<tr>
			<td align="right">State:</td>
			<td><select name="<portlet:namespace />state" id="<portlet:namespace />state" class="required">
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
			<td><input name="<portlet:namespace />zipCode" class="required" id="<portlet:namespace />zipCode" /></td>
			<td><p id="<portlet:namespace />zipCodeErr" class="eVal"></p></td>
		</tr>
		<tr>
			<td align="right">Email Address:</td>
			<td><input name="<portlet:namespace />emailAddr" class="required" id="<portlet:namespace />emailAddr" /></td>
			<td><p id="<portlet:namespace />emailAddrErr" class="eVal"></p></td>
		</tr>
		<tr>
		<td align="right">Phone Number:</td>
			<td><input name="<portlet:namespace />phoneNumber" class="required" id="<portlet:namespace />phoneNumber" /></td>
			<td><p id="<portlet:namespace />phoneNumberErr" class="eVal"></p></td>
		</tr>
		<tr>
			<td align="right">Date Of Birth:</td>
			<td><input name="<portlet:namespace />dob" class="required" id="<portlet:namespace />dob" /></td>
			<td><p id="<portlet:namespace />dobErr" class="eVal"></p></td>
		</tr>
		<tr>
			<td align="right">Opt-In:</td>
			<td><input type="checkbox" name="<portlet:namespace />optin" id="<portlet:namespace />optin" /></td>
			
			<td>&nbsp;</td>
		</tr>
		
		<tr>
			<td align="right">Do you have a Primary Care Provider (PCP)? &nbsp;</td>
			<td><input type="checkbox" name="<portlet:namespace />pcpYes" id="<portlet:namespace />pcpYes" class="pcpYesChecked"/></td>
			<td>&nbsp;</td>
		</tr>
		
		<!--  Show If yes is selected from the PCP -->
		<tr class="pcpInformation">
			<td align="right">PCP First Name:</td>
			<td><input name="<portlet:namespace />pcpFName" id="<portlet:namespace />pcpFName" /></td>
			<td>&nbsp;</td>
		</tr>
		<tr class="pcpInformation">
			<td align="right">PCP Last Name:</td>
			<td><input name="<portlet:namespace />pcpLName" id="<portlet:namespace />pcpLName" /></td>
			<td>&nbsp;</td>
		</tr>
		<tr class="pcpInformation">
			<td align="right">PCP Address:</td>
			<td><input name="<portlet:namespace />pcpAddress" id="<portlet:namespace />pcpAddress" /></td>
			<td>&nbsp;</td>
		</tr>
		<tr class="pcpInformation">
			<td align="right">PCP City:</td>
			<td><input name="<portlet:namespace />pcpCity" id="<portlet:namespace />pcpCity" /></td>
			<td>&nbsp;</td>
		</tr>
		<tr class="pcpInformation">
			<td align="right">PCP State:</td>
			<td><select name="<portlet:namespace />pcpState" id="<portlet:namespace />pcpState">
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
			<td>&nbsp;</td>
		</tr>
		<tr class="pcpInformation">
			<td align="right">PCP Zip Code:</td>
			<td><input name="<portlet:namespace />pcpZipCode" id="<portlet:namespace />pcpZipCode" /></td>
			<td>&nbsp;</td>
		</tr>
		
		<tr>
			<td align="right">Referring Practice:</td>
			<td><input name="<portlet:namespace />referPractice" id="<portlet:namespace />referPractice" /></td>
			<td>&nbsp;</td>
		</tr>
		
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		
		<tr>
			<td align="right">&nbsp;</td>
			<td>
			 <input type="submit" class="span10 btn" value="Register Now" id="<portlet:namespace />submitReturn"/>
			<%-- <input type="submit" value="Register Now" id="<portlet:namespace />submitReturn" /></td> --%>
			<td>&nbsp;</td>
		</tr>
		
	</table> 
</form>