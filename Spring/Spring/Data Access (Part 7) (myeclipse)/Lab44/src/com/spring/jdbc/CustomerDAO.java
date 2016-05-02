package com.spring.jdbc;

import java.util.List;

public interface CustomerDAO {
	
	public List<CustomerTO> getAllCustomers();
	public CustomerTO getCustomerByCid(int cid);
	public CustomerTO getCustomerByEmail(String email);
	public List<CustomerTO> getCustomerByCity(String city);
	
	public int getCustomersCount();
	public String getCustomerCityByEmail(String email);
	public Long getCustomerPhoneByEmail(String email);
	
}
