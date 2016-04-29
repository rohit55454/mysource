create or replace table contacts(contactid number(6) primary key,firstname varchar(10), lastname varchar(10),
					  email varchar(10), phone number(10), dob varchar(10), status varchar(10) );

	

create sequence contactId_seq start with 101 increment by 1;

