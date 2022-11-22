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

package AAACustomerServices.service.impl;

import AAACustomerServices.exception.CustomerEmailException;
import AAACustomerServices.exception.CustomerNameException;
import AAACustomerServices.model.Customer;
import AAACustomerServices.service.CustomerLocalServiceUtil;
import AAACustomerServices.service.base.CustomerLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=AAACustomerServices.model.Customer",
	service = AopService.class
)
public class CustomerLocalServiceImpl extends CustomerLocalServiceBaseImpl {
	protected void validate (String name, String email) 
	        throws PortalException {
	    if (Validator.isNull(name)) {
	        throw new CustomerNameException();
	    }

	    if (!Validator.isEmailAddress(email)) {
	        throw new CustomerEmailException();
	    }

	}
	
	public Customer addCustomer(
	        long userId, long groupId, String name, String email, String address, String national_Id, String contact,
	        int month, int day, int year, int hour, int minute, long serviceId,
	        ServiceContext serviceContext)
	
	    throws PortalException, SystemException {
		
		System.out.println("Add Customer Impl");

		//Get User using userLocalService
		User user = userLocalService.getUserById(userId);

	    Date now = new Date();
	    
	    validate(name, email);

	    //increment the customer ID
	    long customerId = counterLocalService.increment(Customer.class.getName());

	   
	    // Creating new Customer and initialize
	    
	    Customer customer = customerPersistence.create(customerId);

	    customer.setName(name);
	    customer.setEmail(email);
	    customer.setAddress(address);
	    customer.setNational_Id(national_Id);
	    customer.setContact(contact);

	    Calendar dateCal = CalendarFactoryUtil.getCalendar(user.getTimeZone());
	    dateCal.set(year, month, day, hour, minute);
	    Date date = dateCal.getTime();
	    customer.setStart_date(date);
	    customer.setServiceId(serviceId);


	    customer.setGroupId(groupId);
	    customer.setCompanyId(user.getCompanyId());
	    customer.setUserId(user.getUserId());
	    customer.setCreateDate(serviceContext.getCreateDate(now));
	    customer.setModifiedDate(serviceContext.getModifiedDate(now));

	    //Add new customer to the database
	    super.addCustomer(customer);
	    
	    System.out.println("End Customer Impl");
	    
	    return customer;
	}

	public Customer deleteCustomer(Customer customer) throws SystemException {
	    return customerPersistence.remove(customer);
	}

	public Customer deleteCustomer(long customerId)
	    throws PortalException, SystemException {

		Customer customer = customerPersistence.findByPrimaryKey(customerId);
	    return deleteCustomer(customer);
	}

	public Customer getCustomer(long customerId)
	    throws SystemException, PortalException {

	    return customerPersistence.findByPrimaryKey(customerId);
	}

	public List<Customer> getCustomersByGroupId(long groupId) throws SystemException {

	    return customerPersistence.findByGroupId(groupId);
	}

	public List<Customer> getCustomersByGroupId(long groupId, int start, int end)
	    throws SystemException {

	    return customerPersistence.findByGroupId(groupId, start, end);
	}

	public int getCustomersCountByGroupId(long groupId) throws SystemException {

	    return customerPersistence.countByGroupId(groupId);
	}

	public Customer updateCustomer(
	        long userId, long customerId, String name, String email, String address, String national_Id, String contact,
	        int month, int day, int year, int hour, int minute,
	        long serviceId, ServiceContext serviceContext)
	    throws PortalException, SystemException {
		
		System.out.println("Update Customer Impl");

		User user = userLocalService.getUserById(userId);
	   // User user = userPersistence.findByPrimaryKey(userId);

	    Date now = new Date();
	    
	    validate(name, email);

	    Customer customer = CustomerLocalServiceUtil.fetchCustomer(customerId);

	    customer.setModifiedDate(serviceContext.getModifiedDate(now));
	    customer.setName(name);
	    customer.setEmail(email);
	    customer.setAddress(address);
	    customer.setNational_Id(national_Id);
	    customer.setContact(contact);

	    Calendar dateCal = CalendarFactoryUtil.getCalendar(user.getTimeZone());
	    dateCal.set(year, month, day, hour, minute);
	    Date date = dateCal.getTime();
	    customer.setStart_date(date);

	    customer.setServiceId(serviceId);
	    super.updateCustomer(customer);

	    System.out.println("End Update Customer Impl");
	    return customer;
	}
}