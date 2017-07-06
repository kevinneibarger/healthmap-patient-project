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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the patient registration service. This utility wraps {@link PatientRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kneibarger
 * @see PatientRegistrationPersistence
 * @see PatientRegistrationPersistenceImpl
 * @generated
 */
public class PatientRegistrationUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(PatientRegistration patientRegistration) {
		getPersistence().clearCache(patientRegistration);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PatientRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PatientRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PatientRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PatientRegistration update(
		PatientRegistration patientRegistration) throws SystemException {
		return getPersistence().update(patientRegistration);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PatientRegistration update(
		PatientRegistration patientRegistration, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(patientRegistration, serviceContext);
	}

	/**
	* Returns all the patient registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

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
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first patient registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first patient registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last patient registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last patient registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

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
	public static com.liferay.patient.registration.model.PatientRegistration[] findByUuid_PrevAndNext(
		long patientRegistrationId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(patientRegistrationId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the patient registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of patient registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the patient registration where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.patient.registration.NoSuchistrationException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the patient registration where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the patient registration where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the patient registration where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the patient registration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of patient registrations where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the patient registrations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static com.liferay.patient.registration.model.PatientRegistration findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first patient registration in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

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
	public static com.liferay.patient.registration.model.PatientRegistration findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last patient registration in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static com.liferay.patient.registration.model.PatientRegistration[] findByUuid_C_PrevAndNext(
		long patientRegistrationId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(patientRegistrationId, uuid,
			companyId, orderByComparator);
	}

	/**
	* Removes all the patient registrations where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of patient registrations where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the patient registrations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first patient registration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first patient registration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last patient registration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last patient registration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

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
	public static com.liferay.patient.registration.model.PatientRegistration[] findByGroupId_PrevAndNext(
		long patientRegistrationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(patientRegistrationId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the patient registrations where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of patient registrations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the patient registrations where firstName = &#63;.
	*
	* @param firstName the first name
	* @return the matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByFirstName(
		java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFirstName(firstName);
	}

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
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByFirstName(
		java.lang.String firstName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFirstName(firstName, start, end);
	}

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
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByFirstName(
		java.lang.String firstName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFirstName(firstName, start, end, orderByComparator);
	}

	/**
	* Returns the first patient registration in the ordered set where firstName = &#63;.
	*
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration findByFirstName_First(
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFirstName_First(firstName, orderByComparator);
	}

	/**
	* Returns the first patient registration in the ordered set where firstName = &#63;.
	*
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchByFirstName_First(
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFirstName_First(firstName, orderByComparator);
	}

	/**
	* Returns the last patient registration in the ordered set where firstName = &#63;.
	*
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration findByFirstName_Last(
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFirstName_Last(firstName, orderByComparator);
	}

	/**
	* Returns the last patient registration in the ordered set where firstName = &#63;.
	*
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchByFirstName_Last(
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFirstName_Last(firstName, orderByComparator);
	}

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
	public static com.liferay.patient.registration.model.PatientRegistration[] findByFirstName_PrevAndNext(
		long patientRegistrationId, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFirstName_PrevAndNext(patientRegistrationId,
			firstName, orderByComparator);
	}

	/**
	* Removes all the patient registrations where firstName = &#63; from the database.
	*
	* @param firstName the first name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFirstName(java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFirstName(firstName);
	}

	/**
	* Returns the number of patient registrations where firstName = &#63;.
	*
	* @param firstName the first name
	* @return the number of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFirstName(java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFirstName(firstName);
	}

	/**
	* Returns all the patient registrations where firstName = &#63; and lastName = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @return the matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByFirstNameLastName(
		java.lang.String firstName, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFirstNameLastName(firstName, lastName);
	}

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
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByFirstNameLastName(
		java.lang.String firstName, java.lang.String lastName, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFirstNameLastName(firstName, lastName, start, end);
	}

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
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByFirstNameLastName(
		java.lang.String firstName, java.lang.String lastName, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFirstNameLastName(firstName, lastName, start, end,
			orderByComparator);
	}

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
	public static com.liferay.patient.registration.model.PatientRegistration findByFirstNameLastName_First(
		java.lang.String firstName, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFirstNameLastName_First(firstName, lastName,
			orderByComparator);
	}

	/**
	* Returns the first patient registration in the ordered set where firstName = &#63; and lastName = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchByFirstNameLastName_First(
		java.lang.String firstName, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFirstNameLastName_First(firstName, lastName,
			orderByComparator);
	}

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
	public static com.liferay.patient.registration.model.PatientRegistration findByFirstNameLastName_Last(
		java.lang.String firstName, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFirstNameLastName_Last(firstName, lastName,
			orderByComparator);
	}

	/**
	* Returns the last patient registration in the ordered set where firstName = &#63; and lastName = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchByFirstNameLastName_Last(
		java.lang.String firstName, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFirstNameLastName_Last(firstName, lastName,
			orderByComparator);
	}

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
	public static com.liferay.patient.registration.model.PatientRegistration[] findByFirstNameLastName_PrevAndNext(
		long patientRegistrationId, java.lang.String firstName,
		java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFirstNameLastName_PrevAndNext(patientRegistrationId,
			firstName, lastName, orderByComparator);
	}

	/**
	* Removes all the patient registrations where firstName = &#63; and lastName = &#63; from the database.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFirstNameLastName(java.lang.String firstName,
		java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFirstNameLastName(firstName, lastName);
	}

	/**
	* Returns the number of patient registrations where firstName = &#63; and lastName = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @return the number of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFirstNameLastName(java.lang.String firstName,
		java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFirstNameLastName(firstName, lastName);
	}

	/**
	* Returns all the patient registrations where lastName = &#63;.
	*
	* @param lastName the last name
	* @return the matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByLastName(
		java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLastName(lastName);
	}

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
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByLastName(
		java.lang.String lastName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLastName(lastName, start, end);
	}

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
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByLastName(
		java.lang.String lastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLastName(lastName, start, end, orderByComparator);
	}

	/**
	* Returns the first patient registration in the ordered set where lastName = &#63;.
	*
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration findByLastName_First(
		java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLastName_First(lastName, orderByComparator);
	}

	/**
	* Returns the first patient registration in the ordered set where lastName = &#63;.
	*
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchByLastName_First(
		java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLastName_First(lastName, orderByComparator);
	}

	/**
	* Returns the last patient registration in the ordered set where lastName = &#63;.
	*
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration findByLastName_Last(
		java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLastName_Last(lastName, orderByComparator);
	}

	/**
	* Returns the last patient registration in the ordered set where lastName = &#63;.
	*
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchByLastName_Last(
		java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLastName_Last(lastName, orderByComparator);
	}

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
	public static com.liferay.patient.registration.model.PatientRegistration[] findByLastName_PrevAndNext(
		long patientRegistrationId, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLastName_PrevAndNext(patientRegistrationId, lastName,
			orderByComparator);
	}

	/**
	* Removes all the patient registrations where lastName = &#63; from the database.
	*
	* @param lastName the last name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLastName(java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLastName(lastName);
	}

	/**
	* Returns the number of patient registrations where lastName = &#63;.
	*
	* @param lastName the last name
	* @return the number of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLastName(java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLastName(lastName);
	}

	/**
	* Returns the patient registration where patientRegistrationId = &#63; or throws a {@link com.liferay.patient.registration.NoSuchistrationException} if it could not be found.
	*
	* @param patientRegistrationId the patient registration ID
	* @return the matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration findByPatientId(
		long patientRegistrationId)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPatientId(patientRegistrationId);
	}

	/**
	* Returns the patient registration where patientRegistrationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param patientRegistrationId the patient registration ID
	* @return the matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchByPatientId(
		long patientRegistrationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPatientId(patientRegistrationId);
	}

	/**
	* Returns the patient registration where patientRegistrationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param patientRegistrationId the patient registration ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchByPatientId(
		long patientRegistrationId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPatientId(patientRegistrationId, retrieveFromCache);
	}

	/**
	* Removes the patient registration where patientRegistrationId = &#63; from the database.
	*
	* @param patientRegistrationId the patient registration ID
	* @return the patient registration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration removeByPatientId(
		long patientRegistrationId)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByPatientId(patientRegistrationId);
	}

	/**
	* Returns the number of patient registrations where patientRegistrationId = &#63;.
	*
	* @param patientRegistrationId the patient registration ID
	* @return the number of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPatientId(long patientRegistrationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPatientId(patientRegistrationId);
	}

	/**
	* Returns all the patient registrations where firstName = &#63; and lastName = &#63; and optIn = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param optIn the opt in
	* @return the matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByFirstNameLastNameOptIn(
		java.lang.String firstName, java.lang.String lastName, int optIn)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFirstNameLastNameOptIn(firstName, lastName, optIn);
	}

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
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByFirstNameLastNameOptIn(
		java.lang.String firstName, java.lang.String lastName, int optIn,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFirstNameLastNameOptIn(firstName, lastName, optIn,
			start, end);
	}

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
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByFirstNameLastNameOptIn(
		java.lang.String firstName, java.lang.String lastName, int optIn,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFirstNameLastNameOptIn(firstName, lastName, optIn,
			start, end, orderByComparator);
	}

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
	public static com.liferay.patient.registration.model.PatientRegistration findByFirstNameLastNameOptIn_First(
		java.lang.String firstName, java.lang.String lastName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFirstNameLastNameOptIn_First(firstName, lastName,
			optIn, orderByComparator);
	}

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
	public static com.liferay.patient.registration.model.PatientRegistration fetchByFirstNameLastNameOptIn_First(
		java.lang.String firstName, java.lang.String lastName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFirstNameLastNameOptIn_First(firstName, lastName,
			optIn, orderByComparator);
	}

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
	public static com.liferay.patient.registration.model.PatientRegistration findByFirstNameLastNameOptIn_Last(
		java.lang.String firstName, java.lang.String lastName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFirstNameLastNameOptIn_Last(firstName, lastName,
			optIn, orderByComparator);
	}

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
	public static com.liferay.patient.registration.model.PatientRegistration fetchByFirstNameLastNameOptIn_Last(
		java.lang.String firstName, java.lang.String lastName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFirstNameLastNameOptIn_Last(firstName, lastName,
			optIn, orderByComparator);
	}

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
	public static com.liferay.patient.registration.model.PatientRegistration[] findByFirstNameLastNameOptIn_PrevAndNext(
		long patientRegistrationId, java.lang.String firstName,
		java.lang.String lastName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFirstNameLastNameOptIn_PrevAndNext(patientRegistrationId,
			firstName, lastName, optIn, orderByComparator);
	}

	/**
	* Removes all the patient registrations where firstName = &#63; and lastName = &#63; and optIn = &#63; from the database.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param optIn the opt in
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFirstNameLastNameOptIn(
		java.lang.String firstName, java.lang.String lastName, int optIn)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByFirstNameLastNameOptIn(firstName, lastName, optIn);
	}

	/**
	* Returns the number of patient registrations where firstName = &#63; and lastName = &#63; and optIn = &#63;.
	*
	* @param firstName the first name
	* @param lastName the last name
	* @param optIn the opt in
	* @return the number of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFirstNameLastNameOptIn(
		java.lang.String firstName, java.lang.String lastName, int optIn)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByFirstNameLastNameOptIn(firstName, lastName, optIn);
	}

	/**
	* Returns all the patient registrations where firstName = &#63; and optIn = &#63;.
	*
	* @param firstName the first name
	* @param optIn the opt in
	* @return the matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByFirstNameOptIn(
		java.lang.String firstName, int optIn)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFirstNameOptIn(firstName, optIn);
	}

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
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByFirstNameOptIn(
		java.lang.String firstName, int optIn, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFirstNameOptIn(firstName, optIn, start, end);
	}

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
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByFirstNameOptIn(
		java.lang.String firstName, int optIn, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFirstNameOptIn(firstName, optIn, start, end,
			orderByComparator);
	}

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
	public static com.liferay.patient.registration.model.PatientRegistration findByFirstNameOptIn_First(
		java.lang.String firstName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFirstNameOptIn_First(firstName, optIn,
			orderByComparator);
	}

	/**
	* Returns the first patient registration in the ordered set where firstName = &#63; and optIn = &#63;.
	*
	* @param firstName the first name
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchByFirstNameOptIn_First(
		java.lang.String firstName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFirstNameOptIn_First(firstName, optIn,
			orderByComparator);
	}

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
	public static com.liferay.patient.registration.model.PatientRegistration findByFirstNameOptIn_Last(
		java.lang.String firstName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFirstNameOptIn_Last(firstName, optIn,
			orderByComparator);
	}

	/**
	* Returns the last patient registration in the ordered set where firstName = &#63; and optIn = &#63;.
	*
	* @param firstName the first name
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchByFirstNameOptIn_Last(
		java.lang.String firstName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFirstNameOptIn_Last(firstName, optIn,
			orderByComparator);
	}

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
	public static com.liferay.patient.registration.model.PatientRegistration[] findByFirstNameOptIn_PrevAndNext(
		long patientRegistrationId, java.lang.String firstName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFirstNameOptIn_PrevAndNext(patientRegistrationId,
			firstName, optIn, orderByComparator);
	}

	/**
	* Removes all the patient registrations where firstName = &#63; and optIn = &#63; from the database.
	*
	* @param firstName the first name
	* @param optIn the opt in
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFirstNameOptIn(java.lang.String firstName,
		int optIn) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFirstNameOptIn(firstName, optIn);
	}

	/**
	* Returns the number of patient registrations where firstName = &#63; and optIn = &#63;.
	*
	* @param firstName the first name
	* @param optIn the opt in
	* @return the number of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFirstNameOptIn(java.lang.String firstName,
		int optIn) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFirstNameOptIn(firstName, optIn);
	}

	/**
	* Returns all the patient registrations where lastName = &#63; and optIn = &#63;.
	*
	* @param lastName the last name
	* @param optIn the opt in
	* @return the matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByLastNameOptIn(
		java.lang.String lastName, int optIn)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLastNameOptIn(lastName, optIn);
	}

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
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByLastNameOptIn(
		java.lang.String lastName, int optIn, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLastNameOptIn(lastName, optIn, start, end);
	}

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
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByLastNameOptIn(
		java.lang.String lastName, int optIn, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLastNameOptIn(lastName, optIn, start, end,
			orderByComparator);
	}

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
	public static com.liferay.patient.registration.model.PatientRegistration findByLastNameOptIn_First(
		java.lang.String lastName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLastNameOptIn_First(lastName, optIn, orderByComparator);
	}

	/**
	* Returns the first patient registration in the ordered set where lastName = &#63; and optIn = &#63;.
	*
	* @param lastName the last name
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchByLastNameOptIn_First(
		java.lang.String lastName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLastNameOptIn_First(lastName, optIn,
			orderByComparator);
	}

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
	public static com.liferay.patient.registration.model.PatientRegistration findByLastNameOptIn_Last(
		java.lang.String lastName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLastNameOptIn_Last(lastName, optIn, orderByComparator);
	}

	/**
	* Returns the last patient registration in the ordered set where lastName = &#63; and optIn = &#63;.
	*
	* @param lastName the last name
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchByLastNameOptIn_Last(
		java.lang.String lastName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLastNameOptIn_Last(lastName, optIn, orderByComparator);
	}

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
	public static com.liferay.patient.registration.model.PatientRegistration[] findByLastNameOptIn_PrevAndNext(
		long patientRegistrationId, java.lang.String lastName, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLastNameOptIn_PrevAndNext(patientRegistrationId,
			lastName, optIn, orderByComparator);
	}

	/**
	* Removes all the patient registrations where lastName = &#63; and optIn = &#63; from the database.
	*
	* @param lastName the last name
	* @param optIn the opt in
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLastNameOptIn(java.lang.String lastName,
		int optIn) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLastNameOptIn(lastName, optIn);
	}

	/**
	* Returns the number of patient registrations where lastName = &#63; and optIn = &#63;.
	*
	* @param lastName the last name
	* @param optIn the opt in
	* @return the number of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLastNameOptIn(java.lang.String lastName, int optIn)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLastNameOptIn(lastName, optIn);
	}

	/**
	* Returns all the patient registrations where optIn = &#63;.
	*
	* @param optIn the opt in
	* @return the matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByOptIn(
		int optIn) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOptIn(optIn);
	}

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
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByOptIn(
		int optIn, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOptIn(optIn, start, end);
	}

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
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findByOptIn(
		int optIn, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOptIn(optIn, start, end, orderByComparator);
	}

	/**
	* Returns the first patient registration in the ordered set where optIn = &#63;.
	*
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration findByOptIn_First(
		int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOptIn_First(optIn, orderByComparator);
	}

	/**
	* Returns the first patient registration in the ordered set where optIn = &#63;.
	*
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchByOptIn_First(
		int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByOptIn_First(optIn, orderByComparator);
	}

	/**
	* Returns the last patient registration in the ordered set where optIn = &#63;.
	*
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration findByOptIn_Last(
		int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOptIn_Last(optIn, orderByComparator);
	}

	/**
	* Returns the last patient registration in the ordered set where optIn = &#63;.
	*
	* @param optIn the opt in
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchByOptIn_Last(
		int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByOptIn_Last(optIn, orderByComparator);
	}

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
	public static com.liferay.patient.registration.model.PatientRegistration[] findByOptIn_PrevAndNext(
		long patientRegistrationId, int optIn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOptIn_PrevAndNext(patientRegistrationId, optIn,
			orderByComparator);
	}

	/**
	* Removes all the patient registrations where optIn = &#63; from the database.
	*
	* @param optIn the opt in
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOptIn(int optIn)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOptIn(optIn);
	}

	/**
	* Returns the number of patient registrations where optIn = &#63;.
	*
	* @param optIn the opt in
	* @return the number of matching patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOptIn(int optIn)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOptIn(optIn);
	}

	/**
	* Caches the patient registration in the entity cache if it is enabled.
	*
	* @param patientRegistration the patient registration
	*/
	public static void cacheResult(
		com.liferay.patient.registration.model.PatientRegistration patientRegistration) {
		getPersistence().cacheResult(patientRegistration);
	}

	/**
	* Caches the patient registrations in the entity cache if it is enabled.
	*
	* @param patientRegistrations the patient registrations
	*/
	public static void cacheResult(
		java.util.List<com.liferay.patient.registration.model.PatientRegistration> patientRegistrations) {
		getPersistence().cacheResult(patientRegistrations);
	}

	/**
	* Creates a new patient registration with the primary key. Does not add the patient registration to the database.
	*
	* @param patientRegistrationId the primary key for the new patient registration
	* @return the new patient registration
	*/
	public static com.liferay.patient.registration.model.PatientRegistration create(
		long patientRegistrationId) {
		return getPersistence().create(patientRegistrationId);
	}

	/**
	* Removes the patient registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param patientRegistrationId the primary key of the patient registration
	* @return the patient registration that was removed
	* @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration remove(
		long patientRegistrationId)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(patientRegistrationId);
	}

	public static com.liferay.patient.registration.model.PatientRegistration updateImpl(
		com.liferay.patient.registration.model.PatientRegistration patientRegistration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(patientRegistration);
	}

	/**
	* Returns the patient registration with the primary key or throws a {@link com.liferay.patient.registration.NoSuchistrationException} if it could not be found.
	*
	* @param patientRegistrationId the primary key of the patient registration
	* @return the patient registration
	* @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration findByPrimaryKey(
		long patientRegistrationId)
		throws com.liferay.patient.registration.NoSuchistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(patientRegistrationId);
	}

	/**
	* Returns the patient registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param patientRegistrationId the primary key of the patient registration
	* @return the patient registration, or <code>null</code> if a patient registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.patient.registration.model.PatientRegistration fetchByPrimaryKey(
		long patientRegistrationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(patientRegistrationId);
	}

	/**
	* Returns all the patient registrations.
	*
	* @return the patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.patient.registration.model.PatientRegistration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the patient registrations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of patient registrations.
	*
	* @return the number of patient registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PatientRegistrationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PatientRegistrationPersistence)PortletBeanLocatorUtil.locate(com.liferay.patient.registration.service.ClpSerializer.getServletContextName(),
					PatientRegistrationPersistence.class.getName());

			ReferenceRegistry.registerReference(PatientRegistrationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PatientRegistrationPersistence persistence) {
	}

	private static PatientRegistrationPersistence _persistence;
}