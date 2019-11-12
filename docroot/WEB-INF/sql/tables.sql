create table CS_Course (
	uuid_ VARCHAR(75) null,
	courseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(2000) null,
	lecturer VARCHAR(75) null,
	duration INTEGER,
	status BOOLEAN
);