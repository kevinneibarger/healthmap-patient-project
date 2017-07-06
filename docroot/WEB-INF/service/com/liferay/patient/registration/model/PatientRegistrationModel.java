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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.StagedGroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the PatientRegistration service. Represents a row in the &quot;PatientReg_PatientRegistration&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.patient.registration.model.impl.PatientRegistrationImpl}.
 * </p>
 *
 * @author kneibarger
 * @see PatientRegistration
 * @see com.liferay.patient.registration.model.impl.PatientRegistrationImpl
 * @see com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl
 * @generated
 */
public interface PatientRegistrationModel extends BaseModel<PatientRegistration>,
	StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a patient registration model instance should use the {@link PatientRegistration} interface instead.
	 */

	/**
	 * Returns the primary key of this patient registration.
	 *
	 * @return the primary key of this patient registration
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this patient registration.
	 *
	 * @param primaryKey the primary key of this patient registration
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this patient registration.
	 *
	 * @return the uuid of this patient registration
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this patient registration.
	 *
	 * @param uuid the uuid of this patient registration
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the patient registration ID of this patient registration.
	 *
	 * @return the patient registration ID of this patient registration
	 */
	public long getPatientRegistrationId();

	/**
	 * Sets the patient registration ID of this patient registration.
	 *
	 * @param patientRegistrationId the patient registration ID of this patient registration
	 */
	public void setPatientRegistrationId(long patientRegistrationId);

	/**
	 * Returns the group ID of this patient registration.
	 *
	 * @return the group ID of this patient registration
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this patient registration.
	 *
	 * @param groupId the group ID of this patient registration
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this patient registration.
	 *
	 * @return the company ID of this patient registration
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this patient registration.
	 *
	 * @param companyId the company ID of this patient registration
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this patient registration.
	 *
	 * @return the user ID of this patient registration
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this patient registration.
	 *
	 * @param userId the user ID of this patient registration
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this patient registration.
	 *
	 * @return the user uuid of this patient registration
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this patient registration.
	 *
	 * @param userUuid the user uuid of this patient registration
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this patient registration.
	 *
	 * @return the user name of this patient registration
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this patient registration.
	 *
	 * @param userName the user name of this patient registration
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this patient registration.
	 *
	 * @return the create date of this patient registration
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this patient registration.
	 *
	 * @param createDate the create date of this patient registration
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this patient registration.
	 *
	 * @return the modified date of this patient registration
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this patient registration.
	 *
	 * @param modifiedDate the modified date of this patient registration
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the first name of this patient registration.
	 *
	 * @return the first name of this patient registration
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this patient registration.
	 *
	 * @param firstName the first name of this patient registration
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the last name of this patient registration.
	 *
	 * @return the last name of this patient registration
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this patient registration.
	 *
	 * @param lastName the last name of this patient registration
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the address1 of this patient registration.
	 *
	 * @return the address1 of this patient registration
	 */
	@AutoEscape
	public String getAddress1();

	/**
	 * Sets the address1 of this patient registration.
	 *
	 * @param address1 the address1 of this patient registration
	 */
	public void setAddress1(String address1);

	/**
	 * Returns the city of this patient registration.
	 *
	 * @return the city of this patient registration
	 */
	@AutoEscape
	public String getCity();

	/**
	 * Sets the city of this patient registration.
	 *
	 * @param city the city of this patient registration
	 */
	public void setCity(String city);

	/**
	 * Returns the state of this patient registration.
	 *
	 * @return the state of this patient registration
	 */
	@AutoEscape
	public String getState();

	/**
	 * Sets the state of this patient registration.
	 *
	 * @param state the state of this patient registration
	 */
	public void setState(String state);

	/**
	 * Returns the zip code of this patient registration.
	 *
	 * @return the zip code of this patient registration
	 */
	@AutoEscape
	public String getZipCode();

	/**
	 * Sets the zip code of this patient registration.
	 *
	 * @param zipCode the zip code of this patient registration
	 */
	public void setZipCode(String zipCode);

	/**
	 * Returns the email addr of this patient registration.
	 *
	 * @return the email addr of this patient registration
	 */
	@AutoEscape
	public String getEmailAddr();

	/**
	 * Sets the email addr of this patient registration.
	 *
	 * @param emailAddr the email addr of this patient registration
	 */
	public void setEmailAddr(String emailAddr);

	/**
	 * Returns the dob of this patient registration.
	 *
	 * @return the dob of this patient registration
	 */
	@AutoEscape
	public String getDob();

	/**
	 * Sets the dob of this patient registration.
	 *
	 * @param dob the dob of this patient registration
	 */
	public void setDob(String dob);

	/**
	 * Returns the opt in of this patient registration.
	 *
	 * @return the opt in of this patient registration
	 */
	public int getOptIn();

	/**
	 * Sets the opt in of this patient registration.
	 *
	 * @param optIn the opt in of this patient registration
	 */
	public void setOptIn(int optIn);

	/**
	 * Returns the phone number of this patient registration.
	 *
	 * @return the phone number of this patient registration
	 */
	@AutoEscape
	public String getPhoneNumber();

	/**
	 * Sets the phone number of this patient registration.
	 *
	 * @param phoneNumber the phone number of this patient registration
	 */
	public void setPhoneNumber(String phoneNumber);

	/**
	 * Returns the pcp first name of this patient registration.
	 *
	 * @return the pcp first name of this patient registration
	 */
	@AutoEscape
	public String getPcpFirstName();

	/**
	 * Sets the pcp first name of this patient registration.
	 *
	 * @param pcpFirstName the pcp first name of this patient registration
	 */
	public void setPcpFirstName(String pcpFirstName);

	/**
	 * Returns the pcp last name of this patient registration.
	 *
	 * @return the pcp last name of this patient registration
	 */
	@AutoEscape
	public String getPcpLastName();

	/**
	 * Sets the pcp last name of this patient registration.
	 *
	 * @param pcpLastName the pcp last name of this patient registration
	 */
	public void setPcpLastName(String pcpLastName);

	/**
	 * Returns the pcp address of this patient registration.
	 *
	 * @return the pcp address of this patient registration
	 */
	@AutoEscape
	public String getPcpAddress();

	/**
	 * Sets the pcp address of this patient registration.
	 *
	 * @param pcpAddress the pcp address of this patient registration
	 */
	public void setPcpAddress(String pcpAddress);

	/**
	 * Returns the pcp city of this patient registration.
	 *
	 * @return the pcp city of this patient registration
	 */
	@AutoEscape
	public String getPcpCity();

	/**
	 * Sets the pcp city of this patient registration.
	 *
	 * @param pcpCity the pcp city of this patient registration
	 */
	public void setPcpCity(String pcpCity);

	/**
	 * Returns the pcp state of this patient registration.
	 *
	 * @return the pcp state of this patient registration
	 */
	@AutoEscape
	public String getPcpState();

	/**
	 * Sets the pcp state of this patient registration.
	 *
	 * @param pcpState the pcp state of this patient registration
	 */
	public void setPcpState(String pcpState);

	/**
	 * Returns the pcp zip code of this patient registration.
	 *
	 * @return the pcp zip code of this patient registration
	 */
	@AutoEscape
	public String getPcpZipCode();

	/**
	 * Sets the pcp zip code of this patient registration.
	 *
	 * @param pcpZipCode the pcp zip code of this patient registration
	 */
	public void setPcpZipCode(String pcpZipCode);

	/**
	 * Returns the referring practice of this patient registration.
	 *
	 * @return the referring practice of this patient registration
	 */
	@AutoEscape
	public String getReferringPractice();

	/**
	 * Sets the referring practice of this patient registration.
	 *
	 * @param referringPractice the referring practice of this patient registration
	 */
	public void setReferringPractice(String referringPractice);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.liferay.patient.registration.model.PatientRegistration patientRegistration);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.liferay.patient.registration.model.PatientRegistration> toCacheModel();

	@Override
	public com.liferay.patient.registration.model.PatientRegistration toEscapedModel();

	@Override
	public com.liferay.patient.registration.model.PatientRegistration toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}