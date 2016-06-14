create table scriptpp_History (
	historyId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	line VARCHAR(75) null
);

create table scriptpp_Script (
	ScriptId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	importContent VARCHAR(75) null,
	moduleContent VARCHAR(75) null
);