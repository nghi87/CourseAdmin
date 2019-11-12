create index IX_9DA5F43A on CS_Course (courseId);
create index IX_6E13D67A on CS_Course (groupId);
create index IX_3340BF84 on CS_Course (uuid_);
create index IX_A4352A24 on CS_Course (uuid_, companyId);
create unique index IX_D889E9A6 on CS_Course (uuid_, groupId);