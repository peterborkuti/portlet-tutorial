create table nevnapp_DayEntity (
	dayId LONG not null primary key,
	month INTEGER,
	day INTEGER,
	nameId LONG
);

create table nevnapp_NameEntity (
	nameId LONG not null primary key,
	name VARCHAR(75) null,
	gender INTEGER
);