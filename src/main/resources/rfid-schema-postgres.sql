drop table if exists TILT_SWITCH_EVENT;
drop table if exists TILT_SWITCH;
drop table if exists RFID_EVENT;
drop table if exists RFID;
drop table if exists USERS;



create table USERS (
USER_ID SERIAL primary key, 
RFID_ID integer UNIQUE not null,
FIRSTNAME varchar(100) not null,
LASTNAME varchar(100) not null,
CREATEDTIME timestamp not null
);

create table RFID (
RFID_ID SERIAL primary key, 
RFID varchar(100) not null,
ACTIVE boolean not null,
CREATEDTIME timestamp not null
);

create table RFID_EVENT (
RFID_EVENT_ID SERIAL primary key, 
RFID_ID integer not null,
SENSORID varchar(100) not null,
EVENTTIME timestamp not null
);

create table TILT_SWITCH (
TILT_SWITCH_ID SERIAL primary key, 
TILTSWITCHID varchar(100) not null,
CREATEDTIME timestamp not null
);

create table TILT_SWITCH_EVENT (
TILT_SWITCH_EVENT_ID SERIAL primary key, 
TILT_SWITCH_ID integer not null,
OPEN boolean not null,
EVENTTIME timestamp not null
);

alter table USERS add constraint FK_USER_RFID foreign key (RFID_ID) references RFID(RFID_ID) on delete cascade;
alter table RFID_EVENT add constraint FK_RFID_RFID_EVENT foreign key (RFID_ID) references RFID(RFID_ID) on delete cascade;
alter table TILT_SWITCH_EVENT add constraint FK_TILT_SWITCH_EVENT foreign key (TILT_SWITCH_ID) references TILT_SWITCH(TILT_SWITCH_ID) on delete cascade;

insert into TILT_SWITCH (TILT_SWITCH_ID, TILTSWITCHID, CREATEDTIME) values (1, 'need-a-sensor-id', TIMESTAMP '2015-01-12 15:36:38');
insert into RFID (RFID_ID, RFID, ACTIVE, CREATEDTIME) values (1, '0909200181', 't', TIMESTAMP '2015-01-10 12:31:22');
insert into RFID (RFID_ID, RFID, ACTIVE, CREATEDTIME) values (2, 'b3dabaa9', 't', TIMESTAMP '2015-01-10 12:31:22');
insert into RFID (RFID_ID, RFID, ACTIVE, CREATEDTIME) values (3, 'cb6e5e74', 'f', TIMESTAMP '2015-01-11 12:31:22');
insert into USERS (USER_ID, RFID_ID, FIRSTNAME, LASTNAME, CREATEDTIME) values (1, 1, 'Eugene', 'Bell', TIMESTAMP '2015-01-10 10:00:00');
insert into USERS (USER_ID, RFID_ID, FIRSTNAME, LASTNAME, CREATEDTIME) values (2, 2, 'Trevor', 'Kenna', TIMESTAMP '2015-01-11 12:00:00');
insert into USERS (USER_ID, RFID_ID, FIRSTNAME, LASTNAME, CREATEDTIME) values (3, 3, 'Stephen', 'Carter', TIMESTAMP '2015-01-11 13:00:00');
--insert into RFID_EVENT (RFID_EVENT_ID, RFID_ID, EVENTTIME) values (1, 1, TIMESTAMP '2015-01-10 12:31:22');
--insert into RFID_EVENT (RFID_EVENT_ID, RFID_ID, EVENTTIME) values (2, 1, TIMESTAMP '2015-01-10 12:31:23');
--insert into RFID_EVENT (RFID_EVENT_ID, RFID_ID, EVENTTIME) values (3, 1, TIMESTAMP '2015-01-10 12:31:24');
--insert into RFID_EVENT (RFID_EVENT_ID, RFID_ID, EVENTTIME) values (4, 1, TIMESTAMP '2015-01-10 12:31:25');
--insert into RFID_EVENT (RFID_EVENT_ID, RFID_ID, EVENTTIME) values (5, 1, TIMESTAMP '2015-01-10 12:31:26');
