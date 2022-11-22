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

package AAACustomerServices.model.impl;

import AAACustomerServices.model.Services;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Services in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ServicesCacheModel
	implements CacheModel<Services>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ServicesCacheModel)) {
			return false;
		}

		ServicesCacheModel servicesCacheModel = (ServicesCacheModel)object;

		if (serviceId == servicesCacheModel.serviceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, serviceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", serviceId=");
		sb.append(serviceId);
		sb.append(", serviceName=");
		sb.append(serviceName);
		sb.append(", serviceDescription=");
		sb.append(serviceDescription);
		sb.append(", servicePrice=");
		sb.append(servicePrice);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Services toEntityModel() {
		ServicesImpl servicesImpl = new ServicesImpl();

		if (uuid == null) {
			servicesImpl.setUuid("");
		}
		else {
			servicesImpl.setUuid(uuid);
		}

		servicesImpl.setServiceId(serviceId);

		if (serviceName == null) {
			servicesImpl.setServiceName("");
		}
		else {
			servicesImpl.setServiceName(serviceName);
		}

		if (serviceDescription == null) {
			servicesImpl.setServiceDescription("");
		}
		else {
			servicesImpl.setServiceDescription(serviceDescription);
		}

		if (servicePrice == null) {
			servicesImpl.setServicePrice("");
		}
		else {
			servicesImpl.setServicePrice(servicePrice);
		}

		servicesImpl.setGroupId(groupId);
		servicesImpl.setCompanyId(companyId);
		servicesImpl.setUserId(userId);

		if (userName == null) {
			servicesImpl.setUserName("");
		}
		else {
			servicesImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			servicesImpl.setCreateDate(null);
		}
		else {
			servicesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			servicesImpl.setModifiedDate(null);
		}
		else {
			servicesImpl.setModifiedDate(new Date(modifiedDate));
		}

		servicesImpl.resetOriginalValues();

		return servicesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		serviceId = objectInput.readLong();
		serviceName = objectInput.readUTF();
		serviceDescription = objectInput.readUTF();
		servicePrice = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(serviceId);

		if (serviceName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(serviceName);
		}

		if (serviceDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(serviceDescription);
		}

		if (servicePrice == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(servicePrice);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long serviceId;
	public String serviceName;
	public String serviceDescription;
	public String servicePrice;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}