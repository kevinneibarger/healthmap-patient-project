package com.liferay.healthmap.solutions;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.patient.registration.model.PatientRegistration;
import com.liferay.patient.registration.service.PatientRegistrationLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class PatientRegistrationPortlet
 */
public class PatientRegistrationPortlet extends MVCPortlet {
 
	@SuppressWarnings("static-access")
	public void addNewPatient(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		
		boolean hasPcpInfo = false;
		String firstName = null;
		String lastName = null;
		String address = null;
		String city = null;
		String state = null;
		String zip = null;
		String email = null;
		String phoneNumber = null;
		String dob = null;
		String optIn = "";
		String referringPractice = "";
		String pcpFirstName = "";
		String pcpLastName = "";
		String pcpAddress = "";
		String pcpCity = "";
		String pcpState = "";
		String pcpZip = "";
		// Get the PCP columns if applicable - if pcpYes = on
		String pcpYes = ParamUtil.getString(request, "pcpYes");
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
		        PatientRegistration.class.getName(), request);
		
		firstName = ParamUtil.getString(request, "firstName");
		lastName = ParamUtil.getString(request, "lastName");
		address = ParamUtil.getString(request, "address1");
		city = ParamUtil.getString(request, "city");
		state = ParamUtil.getString(request, "state");
		zip = ParamUtil.getString(request, "zipCode");
		email = ParamUtil.getString(request, "emailAddr");
		phoneNumber = ParamUtil.getString(request, "phoneNumber");
		dob = ParamUtil.getString(request, "dob");
		optIn = ParamUtil.getString(request, "optin");
		referringPractice = ParamUtil.getString(request, "referPractice");

		System.out.println("---- First Name: "+firstName+" ----");
		System.out.println("---- Last Name: "+lastName+" ----");
		System.out.println("---- Address: "+address+" ----");
		System.out.println("---- City: "+city+"----");
		System.out.println("---- State: "+state+" ----");
		System.out.println("---- Zip Code: "+zip+" ----");
		System.out.println("---- Email: "+email+" ----");
		System.out.println("---- Phone Number: "+phoneNumber+" ----");
		System.out.println("---- DOB: "+dob+" ----");
		System.out.println("---- Opt In: "+optIn+" ----");
		System.out.println("--- Referring Practice: "+referringPractice+" ----");
		
		if (pcpYes != null && pcpYes.equalsIgnoreCase("on")) {
			hasPcpInfo = true;
			pcpFirstName = ParamUtil.getString(request, "pcpFName");
			pcpLastName = ParamUtil.getString(request, "pcpLName");
			pcpAddress = ParamUtil.getString(request, "pcpAddress");
			pcpCity = ParamUtil.getString(request, "pcpCity");
			pcpState = ParamUtil.getString(request, "pcpState");
			pcpZip = ParamUtil.getString(request, "pcpZipCode");
			
			System.out.println("---- PCP First Name: "+pcpFirstName+" ----");
			System.out.println("---- PCP Last Name: "+pcpLastName+" ----");
			System.out.println("---- PCP Address: "+pcpAddress+" ----");
			System.out.println("---- PCP City: "+pcpCity+" ----");
			System.out.println("---- PCP State: "+pcpState+" ----");
			System.out.println("---- PCP Zip Code: "+pcpZip+" ----");
		}
		
		PatientRegistrationLocalServiceUtil patientUtil = new PatientRegistrationLocalServiceUtil();
		
		try {
			
			int optInFlag = -1;
			
			if (optIn != null && optIn.equalsIgnoreCase("on")) {
				optInFlag = 1;
			} else {
				optInFlag = 0;
			}
			
			if (hasPcpInfo) {
				
				patientUtil.addNewPatientWithPCPInfo(serviceContext.getUserId(), firstName, lastName, address, city, state, zip, email, phoneNumber, 
						dob, optInFlag, referringPractice, pcpFirstName, pcpLastName, pcpAddress, pcpCity, pcpState, pcpZip, serviceContext);
			} else {
				patientUtil.addNewPatient(serviceContext.getUserId(), firstName, lastName, address, city, state, 
					zip, email, phoneNumber, dob, optInFlag, referringPractice, serviceContext);
			}
		
			SessionMessages.add(request.getPortletSession(),"new-patient-add-success");
			response.setRenderParameter("mvcPath",
		            "/html/patientregistration/patientRegistrationAddSuccess.jsp");
			
	    } catch (Exception e) {
	    	e.printStackTrace();
	        SessionErrors.add(request, e.getClass().getName());

	        response.setRenderParameter("mvcPath",
	            "/html/patientregistration/patientRegistrationAddError.jsp");
	    }
	}


}
