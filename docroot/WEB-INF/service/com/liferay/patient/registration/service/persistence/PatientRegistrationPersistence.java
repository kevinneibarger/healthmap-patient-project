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

package com.liferay.patient.registration.service.persistence;

import com.liferay.patient.registration.model.PatientRegistration;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the patient registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kneibarger
 * @see PatientRegistrationPersistenceImpl
 * @see PatientRegistrationUtil
 * @generated
 */
public interface PatientRegistrationPersistence extends BasePersistence<PatientRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PatientRegistrationUtil} to access the patient registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the patient registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the patient registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of patient registrations
	* @param end the upper bound of the range of patient registrations (not inclusive)
	* @return the range of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the patient registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of patient registrations
	* @param end the upper bound of the range of patient registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patient registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patient registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patient registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patient registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patient registrations before and after the current patient registration in the ordered set where uuid = &#63;.
	*
	* @param patientRegistrationId the primary key of the current patient registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration[] findByUuid_PrevAndNext(
		long patientRegistrationId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the patient registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patient registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patient registration where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.patient.registration.NoSuchistrationException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patient registration where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patient registration where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the patient registration where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the patient registration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patient registrations where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the patient registrations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the patient registrations where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of patient registrations
	* @param end the upper bound of the range of patient registrations (not inclusive)
	* @return the range of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the patient registrations where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of patient registrations
	* @param end the upper bound of the range of patient registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patient registration in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patient registration in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patient registration in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patient registration in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patient registrations before and after the current patient registration in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param patientRegistrationId the primary key of the current patient registration
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration[] findByUuid_C_PrevAndNext(
		long patientRegistrationId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the patient registrations where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patient registrations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the patient registrations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the patient registrations where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of patient registrations
	* @param end the upper bound of the range of patient registrations (not inclusive)
	* @return the range of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the patient registrations where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of patient registrations
	* @param end the upper bound of the range of patient registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patient registration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patient registration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patient registration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patient registration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patient registrations before and after the current patient registration in the ordered set where groupId = &#63;.
	*
	* @param patientRegistrationId the primary key of the current patient registration
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration[] findByGroupId_PrevAndNext(
		long patientRegistrationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the patient registrations where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patient registrations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the patient registrations where firstName = &#63;.
	*
	* @param firstName the first name
	* @return the matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByFirstName(
		java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the patient registrations where firstName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param firstName the first name
	* @param start the lower bound of the range of patient registrations
	* @param end the upper bound of the range of patient registrations (not inclusive)
	* @return the range of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByFirstName(
		java.lang.String firstName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the patient registrations where firstName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param firstName the first name
	* @param start the lower bound of the range of patient registrations
	* @param end the upper bound of the range of patient registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByFirstName(
		java.lang.String firstName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patient registration in the ordered set where firstName = &#63;.
	*
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration findByFirstName_First(
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patient registration in the ordered set where firstName = &#63;.
	*
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByFirstName_First(
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patient registration in the ordered set where firstName = &#63;.
	*
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration findByFirstName_Last(
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patient registration in the ordered set where firstName = &#63;.
	*
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByFirstName_Last(
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patient registrations before and after the current patient registration in the ordered set where firstName = &#63;.
	*
	* @param patientRegistrationId the primary key of the current patient registration
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration[] findByFirstName_PrevAndNext(
		long patientRegistrationId, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the patient registrations where firstName = &#63; from the database.
	*
	* @param firstName the first name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFirstName(java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patient registrations where firstName = &#63;.
	*
	* @param firstName the first name
	* @return the number of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByFirstName(java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the patient registrations where firstName = &#63; and lastName = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @return the matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByFirstNameLastName(
		java.lang.String firstName, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the patient registrations where firstName = &#63; and lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param start the lower bound of the range of patient registrations
	* @param end the upper bound of the range of patient registrations (not inclusive)
	* @return the range of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByFirstNameLastName(
		java.lang.String firstName, java.lang.String lastName, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the patient registrations where firstName = &#63; and lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param start the lower bound of the range of patient registrations
	* @param end the upper bound of the range of patient registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByFirstNameLastName(
		java.lang.String firstName, java.lang.String lastName, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patient registration in the ordered set where firstName = &#63; and lastName = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration findByFirstNameLastName_First(
		java.lang.String firstName, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patient registration in the ordered set where firstName = &#63; and lastName = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByFirstNameLastName_First(
		java.lang.String firstName, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patient registration in the ordered set where firstName = &#63; and lastName = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration findByFirstNameLastName_Last(
		java.lang.String firstName, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patient registration in the ordered set where firstName = &#63; and lastName = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByFirstNameLastName_Last(
		java.lang.String firstName, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patient registrations before and after the current patient registration in the ordered set where firstName = &#63; and lastName = &#63;.
	*
	* @param patientRegistrationId the primary key of the current patient registration
	* @param firstName the first name
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration[] findByFirstNameLastName_PrevAndNext(
		long patientRegistrationId, java.lang.String firstName,
		java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the patient registrations where firstName = &#63; and lastName = &#63; from the database.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFirstNameLastName(java.lang.String firstName,
		java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patient registrations where firstName = &#63; and lastName = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @return the number of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByFirstNameLastName(java.lang.String firstName,
		java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the patient registrations where lastName = &#63;.
	*
	* @param lastName the last name
	* @return the matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByLastName(
		java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the patient registrations where lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lastName the last name
	* @param start the lower bound of the range of patient registrations
	* @param end the upper bound of the range of patient registrations (not inclusive)
	* @return the range of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByLastName(
		java.lang.String lastName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the patient registrations where lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lastName the last name
	* @param start the lower bound of the range of patient registrations
	* @param end the upper bound of the range of patient registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByLastName(
		java.lang.String lastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patient registration in the ordered set where lastName = &#63;.
	*
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration findByLastName_First(
		java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patient registration in the ordered set where lastName = &#63;.
	*
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByLastName_First(
		java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patient registration in the ordered set where lastName = &#63;.
	*
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration findByLastName_Last(
		java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patient registration in the ordered set where lastName = &#63;.
	*
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByLastName_Last(
		java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patient registrations before and after the current patient registration in the ordered set where lastName = &#63;.
	*
	* @param patientRegistrationId the primary key of the current patient registration
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration[] findByLastName_PrevAndNext(
		long patientRegistrationId, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the patient registrations where lastName = &#63; from the database.
	*
	* @param lastName the last name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLastName(java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patient registrations where lastName = &#63;.
	*
	* @param lastName the last name
	* @return the number of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByLastName(java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patient registration where patientRegistrationId = &#63; or throws a {@link com.liferay.patient.registration.NoSuchistrationException} if it could not be found.
	*
	* @param patientRegistrationId the patient registration ID
	* @return the matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration findByPatientId(
		long patientRegistrationId)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patient registration where patientRegistrationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param patientRegistrationId the patient registration ID
	* @return the matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByPatientId(
		long patientRegistrationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patient registration where patientRegistrationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param patientRegistrationId the patient registration ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByPatientId(
		long patientRegistrationId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the patient registration where patientRegistrationId = &#63; from the database.
	*
	* @param patientRegistrationId the patient registration ID
	* @return the patient registration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration removeByPatientId(
		long patientRegistrationId)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patient registrations where patientRegistrationId = &#63;.
	*
	* @param patientRegistrationId the patient registration ID
	* @return the number of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByPatientId(long patientRegistrationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the patient registrations where firstName = &#63; and lastName = &#63; and optIn = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param optIn the opt in
	* @return the matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByFirstNameLastNameOptIn(
		java.lang.String firstName, java.lang.String lastName, int optIn)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the patient registrations where firstName = &#63; and lastName = &#63; and optIn = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param optIn the opt in
	* @param start the lower bound of the range of patient registrations
	* @param end the upper bound of the range of patient registrations (not inclusive)
	* @return the range of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByFirstNameLastNameOptIn(
		java.lang.String firstName, java.lang.String lastName, int optIn,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the patient registrations where firstName = &#63; and lastName = &#63; and optIn = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param optIn the opt in
	* @param start the lower bound of the range of patient registrations
	* @param end the upper bound of the range of patient registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByFirstNameLastNameOptIn(
		java.lang.String firstName, java.lang.String lastName, int optIn,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patient registration in the ordered set where firstName = &#63; and lastName = &#63; and optIn = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration findByFirstNameLastNameOptIn_First(
		java.lang.String firstName, java.lang.String lastName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patient registration in the ordered set where firstName = &#63; and lastName = &#63; and optIn = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByFirstNameLastNameOptIn_First(
		java.lang.String firstName, java.lang.String lastName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patient registration in the ordered set where firstName = &#63; and lastName = &#63; and optIn = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration findByFirstNameLastNameOptIn_Last(
		java.lang.String firstName, java.lang.String lastName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patient registration in the ordered set where firstName = &#63; and lastName = &#63; and optIn = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByFirstNameLastNameOptIn_Last(
		java.lang.String firstName, java.lang.String lastName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patient registrations before and after the current patient registration in the ordered set where firstName = &#63; and lastName = &#63; and optIn = &#63;.
	*
	* @param patientRegistrationId the primary key of the current patient registration
	* @param firstName the first name
	* @param lastName the last name
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration[] findByFirstNameLastNameOptIn_PrevAndNext(
		long patientRegistrationId, java.lang.String firstName,
		java.lang.String lastName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the patient registrations where firstName = &#63; and lastName = &#63; and optIn = &#63; from the database.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param optIn the opt in
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFirstNameLastNameOptIn(java.lang.String firstName,
		java.lang.String lastName, int optIn)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patient registrations where firstName = &#63; and lastName = &#63; and optIn = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param optIn the opt in
	* @return the number of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByFirstNameLastNameOptIn(java.lang.String firstName,
		java.lang.String lastName, int optIn)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the patient registrations where firstName = &#63; and optIn = &#63;.
	*
	* @param firstName the first name
	* @param optIn the opt in
	* @return the matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByFirstNameOptIn(
		java.lang.String firstName, int optIn)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the patient registrations where firstName = &#63; and optIn = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param firstName the first name
	* @param optIn the opt in
	* @param start the lower bound of the range of patient registrations
	* @param end the upper bound of the range of patient registrations (not inclusive)
	* @return the range of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByFirstNameOptIn(
		java.lang.String firstName, int optIn, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the patient registrations where firstName = &#63; and optIn = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param firstName the first name
	* @param optIn the opt in
	* @param start the lower bound of the range of patient registrations
	* @param end the upper bound of the range of patient registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByFirstNameOptIn(
		java.lang.String firstName, int optIn, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patient registration in the ordered set where firstName = &#63; and optIn = &#63;.
	*
	* @param firstName the first name
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration findByFirstNameOptIn_First(
		java.lang.String firstName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patient registration in the ordered set where firstName = &#63; and optIn = &#63;.
	*
	* @param firstName the first name
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByFirstNameOptIn_First(
		java.lang.String firstName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patient registration in the ordered set where firstName = &#63; and optIn = &#63;.
	*
	* @param firstName the first name
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration findByFirstNameOptIn_Last(
		java.lang.String firstName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patient registration in the ordered set where firstName = &#63; and optIn = &#63;.
	*
	* @param firstName the first name
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByFirstNameOptIn_Last(
		java.lang.String firstName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patient registrations before and after the current patient registration in the ordered set where firstName = &#63; and optIn = &#63;.
	*
	* @param patientRegistrationId the primary key of the current patient registration
	* @param firstName the first name
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration[] findByFirstNameOptIn_PrevAndNext(
		long patientRegistrationId, java.lang.String firstName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the patient registrations where firstName = &#63; and optIn = &#63; from the database.
	*
	* @param firstName the first name
	* @param optIn the opt in
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFirstNameOptIn(java.lang.String firstName, int optIn)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patient registrations where firstName = &#63; and optIn = &#63;.
	*
	* @param firstName the first name
	* @param optIn the opt in
	* @return the number of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByFirstNameOptIn(java.lang.String firstName, int optIn)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the patient registrations where lastName = &#63; and optIn = &#63;.
	*
	* @param lastName the last name
	* @param optIn the opt in
	* @return the matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByLastNameOptIn(
		java.lang.String lastName, int optIn)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the patient registrations where lastName = &#63; and optIn = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lastName the last name
	* @param optIn the opt in
	* @param start the lower bound of the range of patient registrations
	* @param end the upper bound of the range of patient registrations (not inclusive)
	* @return the range of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByLastNameOptIn(
		java.lang.String lastName, int optIn, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the patient registrations where lastName = &#63; and optIn = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lastName the last name
	* @param optIn the opt in
	* @param start the lower bound of the range of patient registrations
	* @param end the upper bound of the range of patient registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByLastNameOptIn(
		java.lang.String lastName, int optIn, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patient registration in the ordered set where lastName = &#63; and optIn = &#63;.
	*
	* @param lastName the last name
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration findByLastNameOptIn_First(
		java.lang.String lastName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patient registration in the ordered set where lastName = &#63; and optIn = &#63;.
	*
	* @param lastName the last name
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByLastNameOptIn_First(
		java.lang.String lastName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patient registration in the ordered set where lastName = &#63; and optIn = &#63;.
	*
	* @param lastName the last name
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration findByLastNameOptIn_Last(
		java.lang.String lastName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patient registration in the ordered set where lastName = &#63; and optIn = &#63;.
	*
	* @param lastName the last name
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByLastNameOptIn_Last(
		java.lang.String lastName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patient registrations before and after the current patient registration in the ordered set where lastName = &#63; and optIn = &#63;.
	*
	* @param patientRegistrationId the primary key of the current patient registration
	* @param lastName the last name
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration[] findByLastNameOptIn_PrevAndNext(
		long patientRegistrationId, java.lang.String lastName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the patient registrations where lastName = &#63; and optIn = &#63; from the database.
	*
	* @param lastName the last name
	* @param optIn the opt in
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLastNameOptIn(java.lang.String lastName, int optIn)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patient registrations where lastName = &#63; and optIn = &#63;.
	*
	* @param lastName the last name
	* @param optIn the opt in
	* @return the number of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByLastNameOptIn(java.lang.String lastName, int optIn)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the patient registrations where optIn = &#63;.
	*
	* @param optIn the opt in
	* @return the matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByOptIn(
		int optIn) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the patient registrations where optIn = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param optIn the opt in
	* @param start the lower bound of the range of patient registrations
	* @param end the upper bound of the range of patient registrations (not inclusive)
	* @return the range of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByOptIn(
		int optIn, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the patient registrations where optIn = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param optIn the opt in
	* @param start the lower bound of the range of patient registrations
	* @param end the upper bound of the range of patient registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByOptIn(
		int optIn, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patient registration in the ordered set where optIn = &#63;.
	*
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration findByOptIn_First(
		int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first patient registration in the ordered set where optIn = &#63;.
	*
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByOptIn_First(
		int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patient registration in the ordered set where optIn = &#63;.
	*
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration findByOptIn_Last(
		int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last patient registration in the ordered set where optIn = &#63;.
	*
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByOptIn_Last(
		int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patient registrations before and after the current patient registration in the ordered set where optIn = &#63;.
	*
	* @param patientRegistrationId the primary key of the current patient registration
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration[] findByOptIn_PrevAndNext(
		long patientRegistrationId, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the patient registrations where optIn = &#63; from the database.
	*
	* @param optIn the opt in
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOptIn(int optIn)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patient registrations where optIn = &#63;.
	*
	* @param optIn the opt in
	* @return the number of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByOptIn(int optIn)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the patient registration in the entity cache if it is enabled.
	*
	* @param patientRegistration the patient registration
	*/
	public void cacheResult(
		com.liferay.patient.registration.model.PatientRegistration patientRegistration);

	/**
	* Caches the patient registrations in the entity cache if it is enabled.
	*
	* @param patientRegistrations the patient registrations
	*/
	public void cacheResult(
		java.util.List<com.liferay.patient.registration.model.PatientRegistration> patientRegistrations);

	/**
	* Creates a new patient registration with the primary key. Does not add the patient registration to the database.
	*
	* @param patientRegistrationId the primary key for the new patient registration
	* @return the new patient registration
	*/
	public com.liferay.patient.registration.model.PatientRegistration create(
		long patientRegistrationId);

	/**
	* Removes the patient registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param patientRegistrationId the primary key of the patient registration
	* @return the patient registration that was removed
	* @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration remove(
		long patientRegistrationId)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.patient.registration.model.PatientRegistration updateImpl(
		com.liferay.patient.registration.model.PatientRegistration patientRegistration)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patient registration with the primary key or throws a {@link com.liferay.patient.registration.NoSuchistrationException} if it could not be found.
	*
	* @param patientRegistrationId the primary key of the patient registration
	* @return the patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration findByPrimaryKey(
		long patientRegistrationId)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the patient registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param patientRegistrationId the primary key of the patient registration
	* @return the patient registration, or <code>null</code> if a patient registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.patient.registration.model.PatientRegistration fetchByPrimaryKey(
		long patientRegistrationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the patient registrations.
	*
	* @return the patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the patient registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of patient registrations
	* @param end the upper bound of the range of patient registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.patient.registration.model.PatientRegistration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the patient registrations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of patient registrations.
	*
	* @return the number of patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}