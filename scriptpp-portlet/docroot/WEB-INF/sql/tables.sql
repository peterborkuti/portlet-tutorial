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
	scriptOptionsId LONG,
	importContent STRING null,
	moduleContent STRING null
);

create table scriptpp_ScriptOptions (
	ScriptOptionsId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	scriptName VARCHAR(75) null,
	dependencyList VARCHAR(75) null,
	scriptCounter LONG
);