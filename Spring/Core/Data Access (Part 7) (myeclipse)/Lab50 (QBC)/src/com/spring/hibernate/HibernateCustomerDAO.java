package com.spring.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class HibernateCustomerDAO implements CustomerDAO{

	@Autowired
	HibernateTemplate hibTemp;
	
	
	@Override
	public String getCustomerCityByEmail(String email) {
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		dc.add(Expression.eq("email", email));
		
		List<Customer> list = hibTemp.findByCriteria(dc);
		Customer c = (Customer) list.get(0);
		
		return c.getCity();
	}
	
	@Override
	public List<CustomerTO>  getAllCustomers(){
		List<CustomerTO> cList = new ArrayList<>();
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		
		List<Customer> list= hibTemp.findByCriteria(dc);
		
		for(Customer c : list) {
			CustomerTO cto = new CustomerTO(c.getCid(), c.getCname(), c.getEmail(), c.getCity(), c.getPhone());
			cList.add(cto);
		}
			
		return cList;
	}

	

	@Override
	public Long getCustomerPhoneByEmail(String email) {
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		dc.add(Expression.eq("email", email));
		List<Customer> list = hibTemp.findByCriteria(dc);
		Customer c = (Customer) list.get(0);
		
		return c.getPhone();
		
	}

	@Override
	public int getCustomerCount() {
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		List<Customer> list = hibTemp.findByCriteria(dc);
		
		return list.size();
	}


	@Override
	public CustomerTO getCustomerByEmail(String email) {
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		dc.add(Expression.eq("email", email));
		List<Customer> list = hibTemp.findByCriteria(dc);
		Customer c = (Customer)list.get(0);
		
		CustomerTO cto = new CustomerTO(c.getCid(), c.getCname(), c.getEmail(), c.getCity(), c.getPhone());
		
		return cto;
	}


	@Override
	public List<CustomerTO> getCustomerByCity(String city) {
		List<CustomerTO> ctolist = new ArrayList<CustomerTO>();
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		dc.add(Expression.eq("city", city));
		
		hibTemp.setCacheQueries(true);
		
		List<Customer> list = hibTemp.findByCriteria(dc);
		
		for(Customer c : list){
			CustomerTO cto = new CustomerTO(c.getCid(), c.getCname(), c.getEmail(), c.getCity(), c.getPhone());
			ctolist.add(cto);
		}
		
		return ctolist;
	}


	

	



}