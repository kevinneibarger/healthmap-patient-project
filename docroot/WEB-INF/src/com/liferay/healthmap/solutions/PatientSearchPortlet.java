package com.liferay.healthmap.solutions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.patient.registration.model.PatientRegistration;
import com.liferay.patient.registration.service.PatientRegistrationLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class PatientSearchPortlet
 */
public class PatientSearchPortlet extends MVCPortlet {
	@SuppressWarnings("static-access")
	public void updatePatient(ActionRequest request, ActionResponse response) throws PortalException, SystemException {

		System.out.println(" ----- UPDATING Patient!!! -------- ");
		boolean hasPcpInfo = false;

		// Get the patientId for updating purposes. If it's not there, we know
		// it's a new record
		// long patientId = ParamUtil.getLong(request, "patientId");

		PortletSession portletSession = request.getPortletSession();
		Long updatePatientId = (Long) portletSession.getAttribute("updatePatientId");

		// portletSession.removeAttribute("myObject");

		if (updatePatientId != null) {
			System.out.println("Update PAtient ID: " + updatePatientId + "\n\n");
		} else {
			System.err.println("ERROR: The patient Id was NULL coming from the UPDATE JSP!!");
			throw new PortalException("Patient Record Could NOT be Updated");
		}

		// System.out.println("Got Patient ID: "+patientId+"\n");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(PatientRegistration.class.getName(), request);

		PatientRegistrationLocalServiceUtil patientUtil = new PatientRegistrationLocalServiceUtil();

		if (updatePatientId > 0) {
			try {

				// Get the changes from the edit page.
				String firstName = ParamUtil.getString(request, "firstName");
				String lastName = ParamUtil.getString(request, "lastName");
				String address = ParamUtil.getString(request, "address1");
				String city = ParamUtil.getString(request, "city");
				String state = ParamUtil.getString(request, "state");
				String zip = ParamUtil.getString(request, "zipCode");
				String email = ParamUtil.getString(request, "emailAddr");
				String phoneNumber = ParamUtil.getString(request, "phoneNumber");
				String dob = ParamUtil.getString(request, "dob");
				String optIn = ParamUtil.getString(request, "optin");
				String referringPractice = ParamUtil.getString(request, "referPractice");

				String pcpFirstName = "";
				String pcpLastName = "";
				String pcpAddress = "";
				String pcpCity = "";
				String pcpState = "";
				String pcpZip = "";

				// Get the PCP columns if applicable - if pcpYes = on
				String pcpYes = ParamUtil.getString(request, "pcpYes");

				System.out.println("-------- From Portlet - UPDATE -------");
				System.out.println("---- First Name: " + firstName + " ----");
				System.out.println("---- Last Name: " + lastName + " ----");
				System.out.println("---- Address: " + address + " ----");
				System.out.println("---- City: " + city + " ----");
				System.out.println("---- State: " + state + " ----");
				System.out.println("---- Zip Code: " + zip + " ----");
				System.out.println("---- Email: " + email + " ----");
				System.out.println("---- Phone Number: " + phoneNumber + " ----");
				System.out.println("---- DOB: " + dob + " ----");
				System.out.println("---- Opt In: " + optIn + " ----");
				System.out.println("---- Referring Practice: " + referringPractice + " ----");

				if (pcpYes != null && pcpYes.equalsIgnoreCase("on")) {
					hasPcpInfo = true;
					pcpFirstName = ParamUtil.getString(request, "pcpFName");
					pcpLastName = ParamUtil.getString(request, "pcpLName");
					pcpAddress = ParamUtil.getString(request, "pcpAddress");
					pcpCity = ParamUtil.getString(request, "pcpCity");
					pcpState = ParamUtil.getString(request, "pcpState");
					pcpZip = ParamUtil.getString(request, "pcpZipCode");

					System.out.println("---- PCP First Name: " + pcpFirstName + " ----");
					System.out.println("---- PCP Last Name: " + pcpLastName + " ----");
					System.out.println("---- PCP Address: " + pcpAddress + " ----");
					System.out.println("---- PCP City: " + pcpCity + " ----");
					System.out.println("---- PCP State: " + pcpState + " ----");
					System.out.println("---- PCP Zip Code: " + pcpZip + " ----");
				}

				// set the opt-in flag.
				int optInFlag = -1;
				// if (optIn != null && optIn.equalsIgnoreCase("on")) {
				if (optIn != null && optIn.equalsIgnoreCase("1")) {
					optInFlag = 1;
				} else {
					optInFlag = 0;
				}

				if (hasPcpInfo) {

					patientUtil.updatePatientWithPCPInfo(serviceContext.getUserId(), updatePatientId.longValue(),
							firstName, lastName, address, city, state, zip, email, phoneNumber, dob, optInFlag,
							referringPractice, pcpFirstName, pcpLastName, pcpAddress, pcpCity, pcpState, pcpZip,
							serviceContext);
				} else {

					patientUtil.updatePatient(serviceContext.getUserId(), updatePatientId.longValue(), firstName,
							lastName, address, city, state, zip, email, phoneNumber, dob, optInFlag, referringPractice,
							serviceContext);
				}
				// SessionMessages.add(request, "Successfully Updated the
				// Patient Record");

				portletSession.removeAttribute("updatePatientId");

				SessionMessages.add(request.getPortletSession(), "patient-update-success");
				response.setRenderParameter("mvcPath", "/html/patientsearch/patientSearchResultContainer.jsp");

				// response.setRenderParameter("patientId",
				// Long.toString(updatePatientId.longValue()));

			} catch (Exception e) {
				e.printStackTrace();
				SessionErrors.add(request, e.getClass().getName());

				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter("mvcPath", "/html/patientsearch/patientSearchResultContainer.jsp");
			}

		}
	}

	@SuppressWarnings("static-access")
	public void deletePatient(ActionRequest request, ActionResponse response) {

		long patientId = ParamUtil.getLong(request, "patientId");

		try {

			ServiceContext serviceContext = ServiceContextFactory.getInstance(PatientRegistration.class.getName(),
					request);

			response.setRenderParameter("patientId", Long.toString(patientId));

			PatientRegistrationLocalServiceUtil patientUtil = new PatientRegistrationLocalServiceUtil();
			patientUtil.deletePatient(patientId, serviceContext);

			SessionMessages.add(request.getPortletSession(), "patient-delete-success");

		} catch (Exception e) {

			SessionErrors.add(request, e.getClass().getName());
		}
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {

		try {

			long patientId = ParamUtil.getLong(renderRequest, "patientId");

			List<PatientRegistration> patients = PatientRegistrationLocalServiceUtil.getAllPatients();

			if (!(patientId > 0)) {
				patientId = patients.get(0).getPatientRegistrationId();
			}

			renderRequest.setAttribute("patientId", patientId);

		} catch (Exception e) {

			throw new PortletException(e);
		}

		super.render(renderRequest, renderResponse);

	}

//	@SuppressWarnings("static-access")
//	public void searchPatients(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
//
//		// Get all possible search criteria
//		String firstName = ParamUtil.getString(request, "searchByFN");
//		String lastName = ParamUtil.getString(request, "searchByLN");
//		String city = ParamUtil.getString(request, "searchByCity");
//		String state = ParamUtil.getString(request, "searchByState");
//		String zip = ParamUtil.getString(request, "searchByZip");
//		String dob = ParamUtil.getString(request, "searchByDOB");
//		String optIn = ParamUtil.getString(request, "searchByOptInChx");
//
//		System.out.println("-------- From Portlet - SEARCH -------");
//		System.out.println("---- First Name: " + firstName + " ----");
//		System.out.println("---- Last Name: " + lastName + " ----");
//		System.out.println("---- City: " + city + " ----");
//		System.out.println("---- State: " + state + " ----");
//		System.out.println("---- Zip Code: " + zip + " ----");
//		System.out.println("---- DOB: " + dob + " ----");
//		System.out.println("---- Opt In: " + optIn + " ----");
//
//		// set the opt-in flag.
//		int optInFlag = -1;
//		if (optIn != null && optIn.equalsIgnoreCase("on")) {
//			optInFlag = 1;
//		} else {
//			optInFlag = 0;
//		}
//
//		ServiceContext serviceContext = ServiceContextFactory.getInstance(PatientRegistration.class.getName(), request);
//
//		PatientRegistrationLocalServiceUtil patientUtil = new PatientRegistrationLocalServiceUtil();
//
//		Map<String, String> searchCriteriaMap = new HashMap<String, String>();
//
//		if (firstName != null && !firstName.startsWith("Search by") && !firstName.equals("")) {
//			searchCriteriaMap.put("FN", firstName);
//		}
//
//		if (lastName != null && !lastName.startsWith("Search by") && !lastName.equals("")) {
//			searchCriteriaMap.put("LN", lastName);
//		}
//
//		// if (dob != null && !dob.startsWith("Search by")) {
//		// searchCriteriaMap.put("DOB", dob);
//		// }
//		//
//		// if (city != null && !city.startsWith("Search by")) {
//		// searchCriteriaMap.put("CITY", city);
//		// }
//		//
//		// if (state != null && !state.startsWith("Search by")) {
//		// searchCriteriaMap.put("ST", state);
//		// }
//		//
//		// if (zip != null && !zip.startsWith("Search by")) {
//		// searchCriteriaMap.put("ZIP", zip);
//		// }
//
//		if (optInFlag != -1 && optInFlag != 0) {
//			searchCriteriaMap.put("OPT", new Integer(optInFlag).toString());
//		}
//
//		List<PatientRegistration> patientData = patientUtil.searchPatients(searchCriteriaMap, serviceContext);
//		request.setAttribute("patientData", patientData);
//	}

}
