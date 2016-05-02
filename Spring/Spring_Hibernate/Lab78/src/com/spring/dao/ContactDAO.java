package com.spring.dao;

import com.spring.to.ContactTo;

public interface ContactDAO {
	public int addContact(ContactTo cto);
	public ContactTo getContactByEmail(String email);
	public void updateContact(ContactTo cto);
	
}
