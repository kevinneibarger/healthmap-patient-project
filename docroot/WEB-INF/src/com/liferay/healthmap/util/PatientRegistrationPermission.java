/**
 * 
 */
package com.liferay.healthmap.util;


import com.liferay.patient.registration.model.PatientRegistration;
import com.liferay.patient.registration.service.PatientRegistrationLocalServiceUtil;
import com.liferay.patient.registration.service.persistence.PatientRegistrationUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * @author kneibarger
 *
 */
public class PatientRegistrationPermission {

	 public static void check(PermissionChecker permissionChecker,
	            long patientId, String actionId) throws PortalException,
	            SystemException {

	        if (!contains(permissionChecker, patientId, actionId)) {
	            throw new PrincipalException();
	        }
	    }

	    @SuppressWarnings("static-access")
		public static boolean contains(PermissionChecker permissionChecker,
	            long patientId, String actionId) throws PortalException,
	            SystemException {

	    	PatientRegistrationLocalServiceUtil patientUtil = new PatientRegistrationLocalServiceUtil();
	    	PatientRegistration patient = patientUtil.getPatientRegistration(patientId);

	        return permissionChecker
	                .hasPermission(patient.getGroupId(),
	                		PatientRegistration.class.getName(), patient.getPatientRegistrationId(),
	                        actionId);

	    }
}
