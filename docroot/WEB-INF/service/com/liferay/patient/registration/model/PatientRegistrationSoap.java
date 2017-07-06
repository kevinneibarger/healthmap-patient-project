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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.patient.registration.service.http.PatientRegistrationServiceSoap}.
 *
 * @author kneibarger
 * @see com.liferay.patient.registration.service.http.PatientRegistrationServiceSoap
 * @generated
 */
public class PatientRegistrationSoap implements Serializable {
	public static PatientRegistrationSoap toSoapModel(PatientRegistration model) {
		PatientRegistrationSoap soapModel = new PatientRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPatientRegistrationId(model.getPatientRegistrationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setAddress1(model.getAddress1());
		soapModel.setCity(model.getCity());
		soapModel.setState(model.getState());
		soapModel.setZipCode(model.getZipCode());
		soapModel.setEmailAddr(model.getEmailAddr());
		soapModel.setDob(model.getDob());
		soapModel.setOptIn(model.getOptIn());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setPcpFirstName(model.getPcpFirstName());
		soapModel.setPcpLastName(model.getPcpLastName());
		soapModel.setPcpAddress(model.getPcpAddress());
		soapModel.setPcpCity(model.getPcpCity());
		soapModel.setPcpState(model.getPcpState());
		soapModel.setPcpZipCode(model.getPcpZipCode());
		soapModel.setReferringPractice(model.getReferringPractice());

		return soapModel;
	}

	public static PatientRegistrationSoap[] toSoapModels(
		PatientRegistration[] models) {
		PatientRegistrationSoap[] soapModels = new PatientRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PatientRegistrationSoap[][] toSoapModels(
		PatientRegistration[][] models) {
		PatientRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PatientRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PatientRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PatientRegistrationSoap[] toSoapModels(
		List<PatientRegistration> models) {
		List<PatientRegistrationSoap> soapModels = new ArrayList<PatientRegistrationSoap>(models.size());

		for (PatientRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PatientRegistrationSoap[soapModels.size()]);
	}

	public PatientRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _patientRegistrationId;
	}

	public void setPrimaryKey(long pk) {
		setPatientRegistrationId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPatientRegistrationId() {
		return _patientRegistrationId;
	}

	public void setPatientRegistrationId(long patientRegistrationId) {
		_patientRegistrationId = patientRegistrationId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getAddress1() {
		return _address1;
	}

	public void setAddress1(String address1) {
		_address1 = address1;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getZipCode() {
		return _zipCode;
	}

	public void setZipCode(String zipCode) {
		_zipCode = zipCode;
	}

	public String getEmailAddr() {
		return _emailAddr;
	}

	public void setEmailAddr(String emailAddr) {
		_emailAddr = emailAddr;
	}

	public String getDob() {
		return _dob;
	}

	public void setDob(String dob) {
		_dob = dob;
	}

	public int getOptIn() {
		return _optIn;
	}

	public void setOptIn(int optIn) {
		_optIn = optIn;
	}

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public String getPcpFirstName() {
		return _pcpFirstName;
	}

	public void setPcpFirstName(String pcpFirstName) {
		_pcpFirstName = pcpFirstName;
	}

	public String getPcpLastName() {
		return _pcpLastName;
	}

	public void setPcpLastName(String pcpLastName) {
		_pcpLastName = pcpLastName;
	}

	public String getPcpAddress() {
		return _pcpAddress;
	}

	public void setPcpAddress(String pcpAddress) {
		_pcpAddress = pcpAddress;
	}

	public String getPcpCity() {
		return _pcpCity;
	}

	public void setPcpCity(String pcpCity) {
		_pcpCity = pcpCity;
	}

	public String getPcpState() {
		return _pcpState;
	}

	public void setPcpState(String pcpState) {
		_pcpState = pcpState;
	}

	public String getPcpZipCode() {
		return _pcpZipCode;
	}

	public void setPcpZipCode(String pcpZipCode) {
		_pcpZipCode = pcpZipCode;
	}

	public String getReferringPractice() {
		return _referringPractice;
	}

	public void setReferringPractice(String referringPractice) {
		_referringPractice = referringPractice;
	}

	private String _uuid;
	private long _patientRegistrationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _firstName;
	private String _lastName;
	private String _address1;
	private String _city;
	private String _state;
	private String _zipCode;
	private String _emailAddr;
	private String _dob;
	private int _optIn;
	private String _phoneNumber;
	private String _pcpFirstName;
	private String _pcpLastName;
	private String _pcpAddress;
	private String _pcpCity;
	private String _pcpState;
	private String _pcpZipCode;
	private String _referringPractice;
}