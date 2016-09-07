create table BadgePortlet_Badge (
	badgeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	badgeType LONG,
	assignDate DATE null,
	toUser LONG,
	fromUser LONG,
	description VARCHAR(75) null
);