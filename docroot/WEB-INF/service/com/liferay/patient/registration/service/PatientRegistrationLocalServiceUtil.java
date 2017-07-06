/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.patient.registration.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for PatientRegistration. This utility wraps
 * {@link com.liferay.patient.registration.service.impl.PatientRegistrationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author kneibarger
 * @see PatientRegistrationLocalService
 * @see com.liferay.patient.registration.service.base.PatientRegistrationLocalServiceBaseImpl
 * @see com.liferay.patient.registration.service.impl.PatientRegistrationLocalServiceImpl
 * @generated
 */
public class PatientRegistrationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.patient.registration.service.impl.PatientRegistrationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the patient registration to the database. Also notifies the appropriate model listeners.
	*
	* @param patientRegistration the patient registration
	* @return the patient registration that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration addPatientRegistration(
		com.liferay.patient.registration.model.PatientRegistration patientRegistration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPatientRegistration(patientRegistration);
	}

	/**
	* Creates a new patient registration with the primary key. Does not add the patient registration to the database.
	*
	* @param patientRegistrationId the primary key for the new patient registration
	* @return the new patient registration
	*/
	public static com.liferay.patient.registration.model.PatientRegistration createPatientRegistration(
		long patientRegistrationId) {
		return getService().createPatientRegistration(patientRegistrationId);
	}

	/**
	* Deletes the patient registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param patientRegistrationId the primary key of the patient registration
	* @return the patient registration that was removed
	* @throws PortalException if a patient registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration deletePatientRegistration(
		long patientRegistrationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePatientRegistration(patientRegistrationId);
	}

	/**
	* Deletes the patient registration from the database. Also notifies the appropriate model listeners.
	*
	* @param patientRegistration the patient registration
	* @return the patient registration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration deletePatientRegistration(
		com.liferay.patient.registration.model.PatientRegistration patientRegistration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePatientRegistration(patientRegistration);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.patient.registration.model.PatientRegistration fetchPatientRegistration(
		long patientRegistrationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPatientRegistration(patientRegistrationId);
	}

	/**
	* Returns the patient registration with the matching UUID and company.
	*
	* @param uuid the patient registration's UUID
	* @param companyId the primary key of the company
	* @return the matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchPatientRegistrationByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchPatientRegistrationByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the patient registration matching the UUID and group.
	*
	* @param uuid the patient registration's UUID
	* @param groupId the primary key of the group
	* @return the matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchPatientRegistrationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchPatientRegistrationByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the patient registration with the primary key.
	*
	* @param patientRegistrationId the primary key of the patient registration
	* @return the patient registration
	* @throws PortalException if a patient registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration getPatientRegistration(
		long patientRegistrationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPatientRegistration(patientRegistrationId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the patient registration with the matching UUID and company.
	*
	* @param uuid the patient registration's UUID
	* @param companyId the primary key of the company
	* @return the matching patient registration
	* @throws PortalException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration getPatientRegistrationByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getPatientRegistrationByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the patient registration matching the UUID and group.
	*
	* @param uuid the patient registration's UUID
	* @param groupId the primary key of the group
	* @return the matching patient registration
	* @throws PortalException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration getPatientRegistrationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPatientRegistrationByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the patient registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of patient registrations
	* @param end the upper bound of the range of patient registrations (not inclusive)
	* @return the range of patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> getPatientRegistrations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPatientRegistrations(start, end);
	}

	/**
	* Returns the number of patient registrations.
	*
	* @return the number of patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int getPatientRegistrationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPatientRegistrationsCount();
	}

	/**
	* Updates the patient registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param patientRegistration the patient registration
	* @return the patient registration that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration updatePatientRegistration(
		com.liferay.patient.registration.model.PatientRegistration patientRegistration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePatientRegistration(patientRegistration);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> getAllPatients()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllPatients();
	}

	public static com.liferay.patient.registration.model.PatientRegistration updatePatient(
		long userId, long patientId, java.lang.String firstName,
		java.lang.String lastName, java.lang.String address,
		java.lang.String city, java.lang.String state, java.lang.String zip,
		java.lang.String email, java.lang.String phoneNumber,
		java.lang.String dob, int optIn, java.lang.String referringPractice,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updatePatient(userId, patientId, firstName, lastName,
			address, city, state, zip, email, phoneNumber, dob, optIn,
			referringPractice, serviceContext);
	}

	public static com.liferay.patient.registration.model.PatientRegistration deletePatient(
		long patientId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePatient(patientId, serviceContext);
	}

	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> searchPatients(
		java.util.Map<java.lang.String, java.lang.String> searchCriteriaMap,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().searchPatients(searchCriteriaMap, serviceContext);
	}

	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> getPatientSearchResults(
		java.lang.String firstName, java.lang.String lastName, int optInFlag,
		boolean andSearch, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getPatientSearchResults(firstName, lastName, optInFlag,
			andSearch, start, end);
	}

	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> getPatientSearchResultsForKeywords(
		java.lang.String keywords, boolean andSearch, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getPatientSearchResultsForKeywords(keywords, andSearch,
			start, end);
	}

	public static int getPatientsSearchCount(java.lang.String firstName,
		java.lang.String lastName, int optInFlag, boolean andSearch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getPatientsSearchCount(firstName, lastName, optInFlag,
			andSearch);
	}

	public static int getPatientsSearchCountForKeywords(
		java.lang.String keywords, boolean andSearch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getPatientsSearchCountForKeywords(keywords, andSearch);
	}

	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> getPatient(
		long groupId)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPatient(groupId);
	}

	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> getPatientsByLastName(
		java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPatientsByLastName(lastName);
	}

	public static com.liferay.patient.registration.model.PatientRegistration addNewPatient(
		long userId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String address, java.lang.String city,
		java.lang.String state, java.lang.String zip, java.lang.String email,
		java.lang.String phoneNumber, java.lang.String dob, int optIn,
		java.lang.String referringPractice,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addNewPatient(userId, firstName, lastName, address, city,
			state, zip, email, phoneNumber, dob, optIn, referringPractice,
			serviceContext);
	}

	public static com.liferay.patient.registration.model.PatientRegistration addNewPatientWithPCPInfo(
		long userId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String address, java.lang.String city,
		java.lang.String state, java.lang.String zip, java.lang.String email,
		java.lang.String phoneNumber, java.lang.String dob, int optIn,
		java.lang.String referringPractice, java.lang.String pcpFirstName,
		java.lang.String pcpLastName, java.lang.String pcpAddress,
		java.lang.String pcpCity, java.lang.String pcpState,
		java.lang.String pcpZipCode,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addNewPatientWithPCPInfo(userId, firstName, lastName,
			address, city, state, zip, email, phoneNumber, dob, optIn,
			referringPractice, pcpFirstName, pcpLastName, pcpAddress, pcpCity,
			pcpState, pcpZipCode, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static PatientRegistrationLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PatientRegistrationLocalService.class.getName());

			if (invokableLocalService instanceof PatientRegistrationLocalService) {
				_service = (PatientRegistrationLocalService)invokableLocalService;
			}
			else {
				_service = new PatientRegistrationLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PatientRegistrationLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PatientRegistrationLocalService service) {
	}

	private static PatientRegistrationLocalService _service;
}