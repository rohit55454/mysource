package com.spring.jdbc;

import java.util.List;

public interface CustomerDAO {
	
	public void addCustomer(CustomerTO cto);
	public List<CustomerTO> getAllCustomers();
	
}
