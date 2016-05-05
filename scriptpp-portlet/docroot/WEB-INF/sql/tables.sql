create table scriptpp_History (
	historyId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	line VARCHAR(75) null
);