package com.spring.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.LockMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class HibernateCustomerDAO implements CustomerDAO{

	@Autowired
	HibernateTemplate hibTemp;
	
	@Override
	public CustomerTO getCustomerByCid(int cid) {
		Customer c = (Customer)hibTemp.load(Customer.class, cid);
		CustomerTO cto = new CustomerTO(c.getCid(), c.getCname(), c.getEmail(), c.getCity(), c.getPhone());
		return cto;
	}
	
	public List<CustomerTO>  getAllCustomers(){
		List<CustomerTO> cList = new ArrayList<>();
		String hql = "from Customer c";
		List<Customer> list = hibTemp.find(hql);
		
		for(Customer c : list) {
			CustomerTO cto = new CustomerTO(c.getCid(), c.getCname(), c.getEmail(), c.getCity(), c.getPhone());
			cList.add(cto);
		}
			
		return cList;
	}

	@Override
	public void addCustomer(CustomerTO c) {
		Customer cust = new Customer(c.getCname(), c.getEmail(), c.getCity(), c.getPhone());
		hibTemp.save(cust);
	}

	@Override
	public void updateCustomer(CustomerTO cto) {
		Customer c = (Customer)hibTemp.load(Customer.class, cto.getCid());
		c.setCid(cto.getCid());
		c.setCname(cto.getCname());
		c.setEmail(cto.getEmail());
		c.setPhone(cto.getPhone());
		c.setCity(cto.getCity());
		
		hibTemp.update(c, LockMode.NONE);
	}

	@Override
	public void deleteCustomer(int cid) {
		Customer c = (Customer)hibTemp.load(Customer.class, cid);
		hibTemp.delete(c, LockMode.NONE);
	}

}
