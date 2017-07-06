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

package com.liferay.patient.registration.model.impl;

import com.liferay.patient.registration.model.PatientRegistration;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PatientRegistration in entity cache.
 *
 * @author kneibarger
 * @see PatientRegistration
 * @generated
 */
public class PatientRegistrationCacheModel implements CacheModel<PatientRegistration>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", patientRegistrationId=");
		sb.append(patientRegistrationId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", address1=");
		sb.append(address1);
		sb.append(", city=");
		sb.append(city);
		sb.append(", state=");
		sb.append(state);
		sb.append(", zipCode=");
		sb.append(zipCode);
		sb.append(", emailAddr=");
		sb.append(emailAddr);
		sb.append(", dob=");
		sb.append(dob);
		sb.append(", optIn=");
		sb.append(optIn);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", pcpFirstName=");
		sb.append(pcpFirstName);
		sb.append(", pcpLastName=");
		sb.append(pcpLastName);
		sb.append(", pcpAddress=");
		sb.append(pcpAddress);
		sb.append(", pcpCity=");
		sb.append(pcpCity);
		sb.append(", pcpState=");
		sb.append(pcpState);
		sb.append(", pcpZipCode=");
		sb.append(pcpZipCode);
		sb.append(", referringPractice=");
		sb.append(referringPractice);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PatientRegistration toEntityModel() {
		PatientRegistrationImpl patientRegistrationImpl = new PatientRegistrationImpl();

		if (uuid == null) {
			patientRegistrationImpl.setUuid(StringPool.BLANK);
		}
		else {
			patientRegistrationImpl.setUuid(uuid);
		}

		patientRegistrationImpl.setPatientRegistrationId(patientRegistrationId);
		patientRegistrationImpl.setGroupId(groupId);
		patientRegistrationImpl.setCompanyId(companyId);
		patientRegistrationImpl.setUserId(userId);

		if (userName == null) {
			patientRegistrationImpl.setUserName(StringPool.BLANK);
		}
		else {
			patientRegistrationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			patientRegistrationImpl.setCreateDate(null);
		}
		else {
			patientRegistrationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			patientRegistrationImpl.setModifiedDate(null);
		}
		else {
			patientRegistrationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (firstName == null) {
			patientRegistrationImpl.setFirstName(StringPool.BLANK);
		}
		else {
			patientRegistrationImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			patientRegistrationImpl.setLastName(StringPool.BLANK);
		}
		else {
			patientRegistrationImpl.setLastName(lastName);
		}

		if (address1 == null) {
			patientRegistrationImpl.setAddress1(StringPool.BLANK);
		}
		else {
			patientRegistrationImpl.setAddress1(address1);
		}

		if (city == null) {
			patientRegistrationImpl.setCity(StringPool.BLANK);
		}
		else {
			patientRegistrationImpl.setCity(city);
		}

		if (state == null) {
			patientRegistrationImpl.setState(StringPool.BLANK);
		}
		else {
			patientRegistrationImpl.setState(state);
		}

		if (zipCode == null) {
			patientRegistrationImpl.setZipCode(StringPool.BLANK);
		}
		else {
			patientRegistrationImpl.setZipCode(zipCode);
		}

		if (emailAddr == null) {
			patientRegistrationImpl.setEmailAddr(StringPool.BLANK);
		}
		else {
			patientRegistrationImpl.setEmailAddr(emailAddr);
		}

		if (dob == null) {
			patientRegistrationImpl.setDob(StringPool.BLANK);
		}
		else {
			patientRegistrationImpl.setDob(dob);
		}

		patientRegistrationImpl.setOptIn(optIn);

		if (phoneNumber == null) {
			patientRegistrationImpl.setPhoneNumber(StringPool.BLANK);
		}
		else {
			patientRegistrationImpl.setPhoneNumber(phoneNumber);
		}

		if (pcpFirstName == null) {
			patientRegistrationImpl.setPcpFirstName(StringPool.BLANK);
		}
		else {
			patientRegistrationImpl.setPcpFirstName(pcpFirstName);
		}

		if (pcpLastName == null) {
			patientRegistrationImpl.setPcpLastName(StringPool.BLANK);
		}
		else {
			patientRegistrationImpl.setPcpLastName(pcpLastName);
		}

		if (pcpAddress == null) {
			patientRegistrationImpl.setPcpAddress(StringPool.BLANK);
		}
		else {
			patientRegistrationImpl.setPcpAddress(pcpAddress);
		}

		if (pcpCity == null) {
			patientRegistrationImpl.setPcpCity(StringPool.BLANK);
		}
		else {
			patientRegistrationImpl.setPcpCity(pcpCity);
		}

		if (pcpState == null) {
			patientRegistrationImpl.setPcpState(StringPool.BLANK);
		}
		else {
			patientRegistrationImpl.setPcpState(pcpState);
		}

		if (pcpZipCode == null) {
			patientRegistrationImpl.setPcpZipCode(StringPool.BLANK);
		}
		else {
			patientRegistrationImpl.setPcpZipCode(pcpZipCode);
		}

		if (referringPractice == null) {
			patientRegistrationImpl.setReferringPractice(StringPool.BLANK);
		}
		else {
			patientRegistrationImpl.setReferringPractice(referringPractice);
		}

		patientRegistrationImpl.resetOriginalValues();

		return patientRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		patientRegistrationId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		address1 = objectInput.readUTF();
		city = objectInput.readUTF();
		state = objectInput.readUTF();
		zipCode = objectInput.readUTF();
		emailAddr = objectInput.readUTF();
		dob = objectInput.readUTF();
		optIn = objectInput.readInt();
		phoneNumber = objectInput.readUTF();
		pcpFirstName = objectInput.readUTF();
		pcpLastName = objectInput.readUTF();
		pcpAddress = objectInput.readUTF();
		pcpCity = objectInput.readUTF();
		pcpState = objectInput.readUTF();
		pcpZipCode = objectInput.readUTF();
		referringPractice = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(patientRegistrationId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (address1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address1);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (state == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (zipCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zipCode);
		}

		if (emailAddr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddr);
		}

		if (dob == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dob);
		}

		objectOutput.writeInt(optIn);

		if (phoneNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phoneNumber);
		}

		if (pcpFirstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pcpFirstName);
		}

		if (pcpLastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pcpLastName);
		}

		if (pcpAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pcpAddress);
		}

		if (pcpCity == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pcpCity);
		}

		if (pcpState == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pcpState);
		}

		if (pcpZipCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pcpZipCode);
		}

		if (referringPractice == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(referringPractice);
		}
	}

	public String uuid;
	public long patientRegistrationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String firstName;
	public String lastName;
	public String address1;
	public String city;
	public String state;
	public String zipCode;
	public String emailAddr;
	public String dob;
	public int optIn;
	public String phoneNumber;
	public String pcpFirstName;
	public String pcpLastName;
	public String pcpAddress;
	public String pcpCity;
	public String pcpState;
	public String pcpZipCode;
	public String referringPractice;
}