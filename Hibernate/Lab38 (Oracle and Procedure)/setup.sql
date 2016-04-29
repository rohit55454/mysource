create or replace procedure getAllJLCContacts(cts_cursor out sys_refCursor)
AS
BEGIN
Open cts_cursor for select * from contacts;
END;
/

create or replace procedure getAllActiveJLCContacts(cts_cursor out sys_refcursor, st in char)
AS
BEGIN
OPEN cts_cursor for select * from contacts where status = st;
END;
/
