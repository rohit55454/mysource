package com.spring.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class HibernateCustomerDAO implements CustomerDAO{

	@Autowired
	HibernateTemplate hibTemp;
	
	@Override
	public List<CustomerTO>  getAllCustomers(){
		List<CustomerTO> cList = new ArrayList<>();
		String hql = "from Customer c";

		List<Customer> list= hibTemp.find(hql);
		
		for(Customer c : list) {
			CustomerTO cto = new CustomerTO(c.getCid(), c.getCname(), c.getEmail(), c.getCity(), c.getPhone());
			cList.add(cto);
		}
			
		return cList;
	}


	@Override
	public CustomerTO getCustomerByEmail(String email) {
		String hql = "from Customer c where c.email=?";
		List<Customer> list = hibTemp.find(hql, email);
		Customer c = (Customer)list.get(0);
		
		CustomerTO cto = new CustomerTO(c.getCid(), c.getCname(), c.getEmail(), c.getCity(), c.getPhone());
		
		return cto;
	}


	@Override
	public List<CustomerTO> getCustomerByCity(String city) {
		List<CustomerTO> ctolist = new ArrayList<CustomerTO>();
		String hql = "from Customer c where c.city=?";
		List<Customer> list = hibTemp.find(hql, city);
		
		for(Customer c : list){
			CustomerTO cto = new CustomerTO(c.getCid(), c.getCname(), c.getEmail(), c.getCity(), c.getPhone());
			ctolist.add(cto);
		}
		
		return ctolist;
	}


	@Override
	public int getCustomerCount() {
		String hql = "from Customer c";
		List<Customer> list = hibTemp.find(hql);
		
		return list.size();
	}


	@Override
	public String getCustomerCityByEmail(String email) {
		String hql = "from Customer c where c.email=?";
		List<Customer> list = hibTemp.find(hql, email);
		Customer c = (Customer) list.get(0);
		
		return c.getCity();
	}


	@Override
	public Long getCustomerPhoneByEmail(String email) {
		String hql = "from Customer c where c.email=?";
		List<Customer> list = hibTemp.find(hql, email);
		Customer c = (Customer) list.get(0);
		
		return c.getPhone();
		
	}


}