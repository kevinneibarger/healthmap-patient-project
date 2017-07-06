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

import com.liferay.patient.registration.service.ClpSerializer;
import com.liferay.patient.registration.service.PatientRegistrationLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kneibarger
 */
public class PatientRegistrationClp extends BaseModelImpl<PatientRegistration>
	implements PatientRegistration {
	public PatientRegistrationClp() {
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
	public long getPrimaryKey() {
		return _patientRegistrationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPatientRegistrationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _patientRegistrationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_patientRegistrationRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPatientRegistrationId() {
		return _patientRegistrationId;
	}

	@Override
	public void setPatientRegistrationId(long patientRegistrationId) {
		_patientRegistrationId = patientRegistrationId;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setPatientRegistrationId",
						long.class);

				method.invoke(_patientRegistrationRemoteModel,
					patientRegistrationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_patientRegistrationRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_patientRegistrationRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_patientRegistrationRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_patientRegistrationRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_patientRegistrationRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_patientRegistrationRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstName() {
		return _firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_patientRegistrationRemoteModel, firstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastName() {
		return _lastName;
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_patientRegistrationRemoteModel, lastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddress1() {
		return _address1;
	}

	@Override
	public void setAddress1(String address1) {
		_address1 = address1;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress1", String.class);

				method.invoke(_patientRegistrationRemoteModel, address1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCity() {
		return _city;
	}

	@Override
	public void setCity(String city) {
		_city = city;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setCity", String.class);

				method.invoke(_patientRegistrationRemoteModel, city);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getState() {
		return _state;
	}

	@Override
	public void setState(String state) {
		_state = state;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setState", String.class);

				method.invoke(_patientRegistrationRemoteModel, state);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZipCode() {
		return _zipCode;
	}

	@Override
	public void setZipCode(String zipCode) {
		_zipCode = zipCode;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setZipCode", String.class);

				method.invoke(_patientRegistrationRemoteModel, zipCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmailAddr() {
		return _emailAddr;
	}

	@Override
	public void setEmailAddr(String emailAddr) {
		_emailAddr = emailAddr;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailAddr", String.class);

				method.invoke(_patientRegistrationRemoteModel, emailAddr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDob() {
		return _dob;
	}

	@Override
	public void setDob(String dob) {
		_dob = dob;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setDob", String.class);

				method.invoke(_patientRegistrationRemoteModel, dob);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getOptIn() {
		return _optIn;
	}

	@Override
	public void setOptIn(int optIn) {
		_optIn = optIn;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setOptIn", int.class);

				method.invoke(_patientRegistrationRemoteModel, optIn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPhoneNumber() {
		return _phoneNumber;
	}

	@Override
	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setPhoneNumber", String.class);

				method.invoke(_patientRegistrationRemoteModel, phoneNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPcpFirstName() {
		return _pcpFirstName;
	}

	@Override
	public void setPcpFirstName(String pcpFirstName) {
		_pcpFirstName = pcpFirstName;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setPcpFirstName", String.class);

				method.invoke(_patientRegistrationRemoteModel, pcpFirstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPcpLastName() {
		return _pcpLastName;
	}

	@Override
	public void setPcpLastName(String pcpLastName) {
		_pcpLastName = pcpLastName;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setPcpLastName", String.class);

				method.invoke(_patientRegistrationRemoteModel, pcpLastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPcpAddress() {
		return _pcpAddress;
	}

	@Override
	public void setPcpAddress(String pcpAddress) {
		_pcpAddress = pcpAddress;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setPcpAddress", String.class);

				method.invoke(_patientRegistrationRemoteModel, pcpAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPcpCity() {
		return _pcpCity;
	}

	@Override
	public void setPcpCity(String pcpCity) {
		_pcpCity = pcpCity;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setPcpCity", String.class);

				method.invoke(_patientRegistrationRemoteModel, pcpCity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPcpState() {
		return _pcpState;
	}

	@Override
	public void setPcpState(String pcpState) {
		_pcpState = pcpState;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setPcpState", String.class);

				method.invoke(_patientRegistrationRemoteModel, pcpState);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPcpZipCode() {
		return _pcpZipCode;
	}

	@Override
	public void setPcpZipCode(String pcpZipCode) {
		_pcpZipCode = pcpZipCode;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setPcpZipCode", String.class);

				method.invoke(_patientRegistrationRemoteModel, pcpZipCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReferringPractice() {
		return _referringPractice;
	}

	@Override
	public void setReferringPractice(String referringPractice) {
		_referringPractice = referringPractice;

		if (_patientRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _patientRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setReferringPractice",
						String.class);

				method.invoke(_patientRegistrationRemoteModel, referringPractice);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				PatientRegistration.class.getName()));
	}

	public BaseModel<?> getPatientRegistrationRemoteModel() {
		return _patientRegistrationRemoteModel;
	}

	public void setPatientRegistrationRemoteModel(
		BaseModel<?> patientRegistrationRemoteModel) {
		_patientRegistrationRemoteModel = patientRegistrationRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _patientRegistrationRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_patientRegistrationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PatientRegistrationLocalServiceUtil.addPatientRegistration(this);
		}
		else {
			PatientRegistrationLocalServiceUtil.updatePatientRegistration(this);
		}
	}

	@Override
	public PatientRegistration toEscapedModel() {
		return (PatientRegistration)ProxyUtil.newProxyInstance(PatientRegistration.class.getClassLoader(),
			new Class[] { PatientRegistration.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PatientRegistrationClp clone = new PatientRegistrationClp();

		clone.setUuid(getUuid());
		clone.setPatientRegistrationId(getPatientRegistrationId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setAddress1(getAddress1());
		clone.setCity(getCity());
		clone.setState(getState());
		clone.setZipCode(getZipCode());
		clone.setEmailAddr(getEmailAddr());
		clone.setDob(getDob());
		clone.setOptIn(getOptIn());
		clone.setPhoneNumber(getPhoneNumber());
		clone.setPcpFirstName(getPcpFirstName());
		clone.setPcpLastName(getPcpLastName());
		clone.setPcpAddress(getPcpAddress());
		clone.setPcpCity(getPcpCity());
		clone.setPcpState(getPcpState());
		clone.setPcpZipCode(getPcpZipCode());
		clone.setReferringPractice(getReferringPractice());

		return clone;
	}

	@Override
	public int compareTo(PatientRegistration patientRegistration) {
		long primaryKey = patientRegistration.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PatientRegistrationClp)) {
			return false;
		}

		PatientRegistrationClp patientRegistration = (PatientRegistrationClp)obj;

		long primaryKey = patientRegistration.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", patientRegistrationId=");
		sb.append(getPatientRegistrationId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", address1=");
		sb.append(getAddress1());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", state=");
		sb.append(getState());
		sb.append(", zipCode=");
		sb.append(getZipCode());
		sb.append(", emailAddr=");
		sb.append(getEmailAddr());
		sb.append(", dob=");
		sb.append(getDob());
		sb.append(", optIn=");
		sb.append(getOptIn());
		sb.append(", phoneNumber=");
		sb.append(getPhoneNumber());
		sb.append(", pcpFirstName=");
		sb.append(getPcpFirstName());
		sb.append(", pcpLastName=");
		sb.append(getPcpLastName());
		sb.append(", pcpAddress=");
		sb.append(getPcpAddress());
		sb.append(", pcpCity=");
		sb.append(getPcpCity());
		sb.append(", pcpState=");
		sb.append(getPcpState());
		sb.append(", pcpZipCode=");
		sb.append(getPcpZipCode());
		sb.append(", referringPractice=");
		sb.append(getReferringPractice());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(79);

		sb.append("<model><model-name>");
		sb.append("com.liferay.patient.registration.model.PatientRegistration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>patientRegistrationId</column-name><column-value><![CDATA[");
		sb.append(getPatientRegistrationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address1</column-name><column-value><![CDATA[");
		sb.append(getAddress1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>state</column-name><column-value><![CDATA[");
		sb.append(getState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zipCode</column-name><column-value><![CDATA[");
		sb.append(getZipCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddr</column-name><column-value><![CDATA[");
		sb.append(getEmailAddr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dob</column-name><column-value><![CDATA[");
		sb.append(getDob());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>optIn</column-name><column-value><![CDATA[");
		sb.append(getOptIn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phoneNumber</column-name><column-value><![CDATA[");
		sb.append(getPhoneNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pcpFirstName</column-name><column-value><![CDATA[");
		sb.append(getPcpFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pcpLastName</column-name><column-value><![CDATA[");
		sb.append(getPcpLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pcpAddress</column-name><column-value><![CDATA[");
		sb.append(getPcpAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pcpCity</column-name><column-value><![CDATA[");
		sb.append(getPcpCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pcpState</column-name><column-value><![CDATA[");
		sb.append(getPcpState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pcpZipCode</column-name><column-value><![CDATA[");
		sb.append(getPcpZipCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>referringPractice</column-name><column-value><![CDATA[");
		sb.append(getReferringPractice());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _patientRegistrationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
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
	private BaseModel<?> _patientRegistrationRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.patient.registration.service.ClpSerializer.class;
}