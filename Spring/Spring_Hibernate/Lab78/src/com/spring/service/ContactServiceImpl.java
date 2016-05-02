package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.dao.ContactDAO;
import com.spring.to.ContactTo;

public class ContactServiceImpl implements ContactService{
	
	@Autowired
	ContactDAO cdao;

	@Override
	public int addContact(ContactTo cto) {
		return cdao.addContact(cto);
	}

	@Override
	public ContactTo getContactByEmail(String email) {
		return cdao.getContactByEmail(email);
	}

	@Override
	public void updateContact(ContactTo cto) {
		cdao.updateContact(cto);
	}

}
