package com.spring.jdbc;

import java.util.List;

public interface CustomerDAO {
	
	public void addCustomer(CustomerTO cto);
	public void updateCustomer(CustomerTO cto);
	public void deleteCustomer(int cid);
	
	public List<CustomerTO> getAllCustomers();
	public CustomerTO getCustomerByCid(int cid);
	
}
