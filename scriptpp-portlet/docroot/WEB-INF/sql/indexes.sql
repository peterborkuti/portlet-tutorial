create index IX_27E7B9DF on scriptpp_Script (groupId, userId);
create index IX_5C5A597F on scriptpp_Script (groupId, userId, scriptOptionsId);

create index IX_4F57DF7F on scriptpp_ScriptOptions (groupId, userId);
create index IX_8FC807E9 on scriptpp_ScriptOptions (groupId, userId, scriptName);