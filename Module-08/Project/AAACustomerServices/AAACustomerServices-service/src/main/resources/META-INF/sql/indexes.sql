create index IX_5B21CFC8 on AAA_Customer (groupId);
create index IX_F32FC896 on AAA_Customer (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_3E1D7C98 on AAA_Customer (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_7906EF48 on AAA_Services (groupId);
create index IX_B0561916 on AAA_Services (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D99DED18 on AAA_Services (uuid_[$COLUMN_LENGTH:75$], groupId);