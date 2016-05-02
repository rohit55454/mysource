package com.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.spring.hibernate.Contact;
import com.spring.to.ContactTo;

public class HibernateContactDAO implements ContactDAO{
	
	@Autowired
	HibernateTemplate htemp;

	@Override
	public int addContact(ContactTo cto) {
		System.out.println("addContact()....");
		Contact ct = new Contact(cto.getFname(), cto.getLname(), cto.getEmail(), cto.getPhone());
		Integer it = (Integer)htemp.save(ct);
		int cid = it.intValue();
		return cid;
	}

	@Override
	public ContactTo getContactByEmail(String email) {
		System.out.println("getContactByEmail()....");
		String hql = "from Contact ct where ct.email=?";
		List<Contact> list = htemp.find(hql, email);
		ContactTo cto = null;
		if(list.size()>0){
			Contact ct = list.get(0);
			cto = new ContactTo(ct.getCid(), ct.getFname(), ct.getLname(), ct.getEmail(), ct.getPhone());
		}
		return cto;
	}

	@Override
	public void updateContact(ContactTo cto) {
		System.out.println("updateContact()....");
		Contact ct = new Contact(cto.getCid(), cto.getFname(), cto.getLname(), cto.getEmail(), cto.getPhone());
		htemp.update(ct);
	}

}
