package com.spring.service;

import com.spring.to.ContactTo;

public interface ContactService {
	public int addContact(ContactTo cto);
	public ContactTo getContactByEmail(String email);
	public void updateContact(ContactTo cto);
}
