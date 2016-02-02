create table permissiontest_Firstnames (
	firstnameId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	firstname VARCHAR(75) null
);