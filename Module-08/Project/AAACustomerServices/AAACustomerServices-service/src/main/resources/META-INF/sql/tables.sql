create table AAA_Customer (
	uuid_ VARCHAR(75) null,
	customerId LONG not null primary key,
	name VARCHAR(75) null,
	email VARCHAR(75) null,
	address VARCHAR(75) null,
	national_Id VARCHAR(75) null,
	contact VARCHAR(75) null,
	start_date DATE null,
	serviceId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table AAA_Services (
	uuid_ VARCHAR(75) null,
	serviceId LONG not null primary key,
	serviceName VARCHAR(75) null,
	serviceDescription VARCHAR(75) null,
	servicePrice VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);