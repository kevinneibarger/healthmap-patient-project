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

package com.liferay.patient.registration.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PatientRegistration}.
 * </p>
 *
 * @author kneibarger
 * @see PatientRegistration
 * @generated
 */
public class PatientRegistrationWrapper implements PatientRegistration,
	ModelWrapper<PatientRegistration> {
	public PatientRegistrationWrapper(PatientRegistration patientRegistration) {
		_patientRegistration = patientRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return PatientRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return PatientRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("patientRegistrationId", getPatientRegistrationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("address1", getAddress1());
		attributes.put("city", getCity());
		attributes.put("state", getState());
		attributes.put("zipCode", getZipCode());
		attributes.put("emailAddr", getEmailAddr());
		attributes.put("dob", getDob());
		attributes.put("optIn", getOptIn());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("pcpFirstName", getPcpFirstName());
		attributes.put("pcpLastName", getPcpLastName());
		attributes.put("pcpAddress", getPcpAddress());
		attributes.put("pcpCity", getPcpCity());
		attributes.put("pcpState", getPcpState());
		attributes.put("pcpZipCode", getPcpZipCode());
		attributes.put("referringPractice", getReferringPractice());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long patientRegistrationId = (Long)attributes.get(
				"patientRegistrationId");

		if (patientRegistrationId != null) {
			setPatientRegistrationId(patientRegistrationId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String address1 = (String)attributes.get("address1");

		if (address1 != null) {
			setAddress1(address1);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String zipCode = (String)attributes.get("zipCode");

		if (zipCode != null) {
			setZipCode(zipCode);
		}

		String emailAddr = (String)attributes.get("emailAddr");

		if (emailAddr != null) {
			setEmailAddr(emailAddr);
		}

		String dob = (String)attributes.get("dob");

		if (dob != null) {
			setDob(dob);
		}

		Integer optIn = (Integer)attributes.get("optIn");

		if (optIn != null) {
			setOptIn(optIn);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		String pcpFirstName = (String)attributes.get("pcpFirstName");

		if (pcpFirstName != null) {
			setPcpFirstName(pcpFirstName);
		}

		String pcpLastName = (String)attributes.get("pcpLastName");

		if (pcpLastName != null) {
			setPcpLastName(pcpLastName);
		}

		String pcpAddress = (String)attributes.get("pcpAddress");

		if (pcpAddress != null) {
			setPcpAddress(pcpAddress);
		}

		String pcpCity = (String)attributes.get("pcpCity");

		if (pcpCity != null) {
			setPcpCity(pcpCity);
		}

		String pcpState = (String)attributes.get("pcpState");

		if (pcpState != null) {
			setPcpState(pcpState);
		}

		String pcpZipCode = (String)attributes.get("pcpZipCode");

		if (pcpZipCode != null) {
			setPcpZipCode(pcpZipCode);
		}

		String referringPractice = (String)attributes.get("referringPractice");

		if (referringPractice != null) {
			setReferringPractice(referringPractice);
		}
	}

	/**
	* Returns the primary key of this patient registration.
	*
	* @return the primary key of this patient registration
	*/
	@Override
	public long getPrimaryKey() {
		return _patientRegistration.getPrimaryKey();
	}

	/**
	* Sets the primary key of this patient registration.
	*
	* @param primaryKey the primary key of this patient registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_patientRegistration.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this patient registration.
	*
	* @return the uuid of this patient registration
	*/
	@Override
	public java.lang.String getUuid() {
		return _patientRegistration.getUuid();
	}

	/**
	* Sets the uuid of this patient registration.
	*
	* @param uuid the uuid of this patient registration
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_patientRegistration.setUuid(uuid);
	}

	/**
	* Returns the patient registration ID of this patient registration.
	*
	* @return the patient registration ID of this patient registration
	*/
	@Override
	public long getPatientRegistrationId() {
		return _patientRegistration.getPatientRegistrationId();
	}

	/**
	* Sets the patient registration ID of this patient registration.
	*
	* @param patientRegistrationId the patient registration ID of this patient registration
	*/
	@Override
	public void setPatientRegistrationId(long patientRegistrationId) {
		_patientRegistration.setPatientRegistrationId(patientRegistrationId);
	}

	/**
	* Returns the group ID of this patient registration.
	*
	* @return the group ID of this patient registration
	*/
	@Override
	public long getGroupId() {
		return _patientRegistration.getGroupId();
	}

	/**
	* Sets the group ID of this patient registration.
	*
	* @param groupId the group ID of this patient registration
	*/
	@Override
	public void setGroupId(long groupId) {
		_patientRegistration.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this patient registration.
	*
	* @return the company ID of this patient registration
	*/
	@Override
	public long getCompanyId() {
		return _patientRegistration.getCompanyId();
	}

	/**
	* Sets the company ID of this patient registration.
	*
	* @param companyId the company ID of this patient registration
	*/
	@Override
	public void setCompanyId(long companyId) {
		_patientRegistration.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this patient registration.
	*
	* @return the user ID of this patient registration
	*/
	@Override
	public long getUserId() {
		return _patientRegistration.getUserId();
	}

	/**
	* Sets the user ID of this patient registration.
	*
	* @param userId the user ID of this patient registration
	*/
	@Override
	public void setUserId(long userId) {
		_patientRegistration.setUserId(userId);
	}

	/**
	* Returns the user uuid of this patient registration.
	*
	* @return the user uuid of this patient registration
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _patientRegistration.getUserUuid();
	}

	/**
	* Sets the user uuid of this patient registration.
	*
	* @param userUuid the user uuid of this patient registration
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_patientRegistration.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this patient registration.
	*
	* @return the user name of this patient registration
	*/
	@Override
	public java.lang.String getUserName() {
		return _patientRegistration.getUserName();
	}

	/**
	* Sets the user name of this patient registration.
	*
	* @param userName the user name of this patient registration
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_patientRegistration.setUserName(userName);
	}

	/**
	* Returns the create date of this patient registration.
	*
	* @return the create date of this patient registration
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _patientRegistration.getCreateDate();
	}

	/**
	* Sets the create date of this patient registration.
	*
	* @param createDate the create date of this patient registration
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_patientRegistration.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this patient registration.
	*
	* @return the modified date of this patient registration
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _patientRegistration.getModifiedDate();
	}

	/**
	* Sets the modified date of this patient registration.
	*
	* @param modifiedDate the modified date of this patient registration
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_patientRegistration.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the first name of this patient registration.
	*
	* @return the first name of this patient registration
	*/
	@Override
	public java.lang.String getFirstName() {
		return _patientRegistration.getFirstName();
	}

	/**
	* Sets the first name of this patient registration.
	*
	* @param firstName the first name of this patient registration
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_patientRegistration.setFirstName(firstName);
	}

	/**
	* Returns the last name of this patient registration.
	*
	* @return the last name of this patient registration
	*/
	@Override
	public java.lang.String getLastName() {
		return _patientRegistration.getLastName();
	}

	/**
	* Sets the last name of this patient registration.
	*
	* @param lastName the last name of this patient registration
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_patientRegistration.setLastName(lastName);
	}

	/**
	* Returns the address1 of this patient registration.
	*
	* @return the address1 of this patient registration
	*/
	@Override
	public java.lang.String getAddress1() {
		return _patientRegistration.getAddress1();
	}

	/**
	* Sets the address1 of this patient registration.
	*
	* @param address1 the address1 of this patient registration
	*/
	@Override
	public void setAddress1(java.lang.String address1) {
		_patientRegistration.setAddress1(address1);
	}

	/**
	* Returns the city of this patient registration.
	*
	* @return the city of this patient registration
	*/
	@Override
	public java.lang.String getCity() {
		return _patientRegistration.getCity();
	}

	/**
	* Sets the city of this patient registration.
	*
	* @param city the city of this patient registration
	*/
	@Override
	public void setCity(java.lang.String city) {
		_patientRegistration.setCity(city);
	}

	/**
	* Returns the state of this patient registration.
	*
	* @return the state of this patient registration
	*/
	@Override
	public java.lang.String getState() {
		return _patientRegistration.getState();
	}

	/**
	* Sets the state of this patient registration.
	*
	* @param state the state of this patient registration
	*/
	@Override
	public void setState(java.lang.String state) {
		_patientRegistration.setState(state);
	}

	/**
	* Returns the zip code of this patient registration.
	*
	* @return the zip code of this patient registration
	*/
	@Override
	public java.lang.String getZipCode() {
		return _patientRegistration.getZipCode();
	}

	/**
	* Sets the zip code of this patient registration.
	*
	* @param zipCode the zip code of this patient registration
	*/
	@Override
	public void setZipCode(java.lang.String zipCode) {
		_patientRegistration.setZipCode(zipCode);
	}

	/**
	* Returns the email addr of this patient registration.
	*
	* @return the email addr of this patient registration
	*/
	@Override
	public java.lang.String getEmailAddr() {
		return _patientRegistration.getEmailAddr();
	}

	/**
	* Sets the email addr of this patient registration.
	*
	* @param emailAddr the email addr of this patient registration
	*/
	@Override
	public void setEmailAddr(java.lang.String emailAddr) {
		_patientRegistration.setEmailAddr(emailAddr);
	}

	/**
	* Returns the dob of this patient registration.
	*
	* @return the dob of this patient registration
	*/
	@Override
	public java.lang.String getDob() {
		return _patientRegistration.getDob();
	}

	/**
	* Sets the dob of this patient registration.
	*
	* @param dob the dob of this patient registration
	*/
	@Override
	public void setDob(java.lang.String dob) {
		_patientRegistration.setDob(dob);
	}

	/**
	* Returns the opt in of this patient registration.
	*
	* @return the opt in of this patient registration
	*/
	@Override
	public int getOptIn() {
		return _patientRegistration.getOptIn();
	}

	/**
	* Sets the opt in of this patient registration.
	*
	* @param optIn the opt in of this patient registration
	*/
	@Override
	public void setOptIn(int optIn) {
		_patientRegistration.setOptIn(optIn);
	}

	/**
	* Returns the phone number of this patient registration.
	*
	* @return the phone number of this patient registration
	*/
	@Override
	public java.lang.String getPhoneNumber() {
		return _patientRegistration.getPhoneNumber();
	}

	/**
	* Sets the phone number of this patient registration.
	*
	* @param phoneNumber the phone number of this patient registration
	*/
	@Override
	public void setPhoneNumber(java.lang.String phoneNumber) {
		_patientRegistration.setPhoneNumber(phoneNumber);
	}

	/**
	* Returns the pcp first name of this patient registration.
	*
	* @return the pcp first name of this patient registration
	*/
	@Override
	public java.lang.String getPcpFirstName() {
		return _patientRegistration.getPcpFirstName();
	}

	/**
	* Sets the pcp first name of this patient registration.
	*
	* @param pcpFirstName the pcp first name of this patient registration
	*/
	@Override
	public void setPcpFirstName(java.lang.String pcpFirstName) {
		_patientRegistration.setPcpFirstName(pcpFirstName);
	}

	/**
	* Returns the pcp last name of this patient registration.
	*
	* @return the pcp last name of this patient registration
	*/
	@Override
	public java.lang.String getPcpLastName() {
		return _patientRegistration.getPcpLastName();
	}

	/**
	* Sets the pcp last name of this patient registration.
	*
	* @param pcpLastName the pcp last name of this patient registration
	*/
	@Override
	public void setPcpLastName(java.lang.String pcpLastName) {
		_patientRegistration.setPcpLastName(pcpLastName);
	}

	/**
	* Returns the pcp address of this patient registration.
	*
	* @return the pcp address of this patient registration
	*/
	@Override
	public java.lang.String getPcpAddress() {
		return _patientRegistration.getPcpAddress();
	}

	/**
	* Sets the pcp address of this patient registration.
	*
	* @param pcpAddress the pcp address of this patient registration
	*/
	@Override
	public void setPcpAddress(java.lang.String pcpAddress) {
		_patientRegistration.setPcpAddress(pcpAddress);
	}

	/**
	* Returns the pcp city of this patient registration.
	*
	* @return the pcp city of this patient registration
	*/
	@Override
	public java.lang.String getPcpCity() {
		return _patientRegistration.getPcpCity();
	}

	/**
	* Sets the pcp city of this patient registration.
	*
	* @param pcpCity the pcp city of this patient registration
	*/
	@Override
	public void setPcpCity(java.lang.String pcpCity) {
		_patientRegistration.setPcpCity(pcpCity);
	}

	/**
	* Returns the pcp state of this patient registration.
	*
	* @return the pcp state of this patient registration
	*/
	@Override
	public java.lang.String getPcpState() {
		return _patientRegistration.getPcpState();
	}

	/**
	* Sets the pcp state of this patient registration.
	*
	* @param pcpState the pcp state of this patient registration
	*/
	@Override
	public void setPcpState(java.lang.String pcpState) {
		_patientRegistration.setPcpState(pcpState);
	}

	/**
	* Returns the pcp zip code of this patient registration.
	*
	* @return the pcp zip code of this patient registration
	*/
	@Override
	public java.lang.String getPcpZipCode() {
		return _patientRegistration.getPcpZipCode();
	}

	/**
	* Sets the pcp zip code of this patient registration.
	*
	* @param pcpZipCode the pcp zip code of this patient registration
	*/
	@Override
	public void setPcpZipCode(java.lang.String pcpZipCode) {
		_patientRegistration.setPcpZipCode(pcpZipCode);
	}

	/**
	* Returns the referring practice of this patient registration.
	*
	* @return the referring practice of this patient registration
	*/
	@Override
	public java.lang.String getReferringPractice() {
		return _patientRegistration.getReferringPractice();
	}

	/**
	* Sets the referring practice of this patient registration.
	*
	* @param referringPractice the referring practice of this patient registration
	*/
	@Override
	public void setReferringPractice(java.lang.String referringPractice) {
		_patientRegistration.setReferringPractice(referringPractice);
	}

	@Override
	public boolean isNew() {
		return _patientRegistration.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_patientRegistration.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _patientRegistration.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_patientRegistration.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _patientRegistration.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _patientRegistration.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_patientRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _patientRegistration.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_patientRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_patientRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_patientRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PatientRegistrationWrapper((PatientRegistration)_patientRegistration.clone());
	}

	@Override
	public int compareTo(
		com.liferay.patient.registration.model.PatientRegistration patientRegistration) {
		return _patientRegistration.compareTo(patientRegistration);
	}

	@Override
	public int hashCode() {
		return _patientRegistration.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.patient.registration.model.PatientRegistration> toCacheModel() {
		return _patientRegistration.toCacheModel();
	}

	@Override
	public com.liferay.patient.registration.model.PatientRegistration toEscapedModel() {
		return new PatientRegistrationWrapper(_patientRegistration.toEscapedModel());
	}

	@Override
	public com.liferay.patient.registration.model.PatientRegistration toUnescapedModel() {
		return new PatientRegistrationWrapper(_patientRegistration.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _patientRegistration.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _patientRegistration.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_patientRegistration.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PatientRegistrationWrapper)) {
			return false;
		}

		PatientRegistrationWrapper patientRegistrationWrapper = (PatientRegistrationWrapper)obj;

		if (Validator.equals(_patientRegistration,
					patientRegistrationWrapper._patientRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _patientRegistration.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PatientRegistration getWrappedPatientRegistration() {
		return _patientRegistration;
	}

	@Override
	public PatientRegistration getWrappedModel() {
		return _patientRegistration;
	}

	@Override
	public void resetOriginalValues() {
		_patientRegistration.resetOriginalValues();
	}

	private PatientRegistration _patientRegistration;
}