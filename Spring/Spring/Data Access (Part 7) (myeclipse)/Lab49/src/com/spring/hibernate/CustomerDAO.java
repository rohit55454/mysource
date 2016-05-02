package com.spring.hibernate;

import java.util.List;

public interface CustomerDAO {
	
	public List<CustomerTO> getAllCustomers();
	public CustomerTO getCustomerByEmail(String email);
	public List<CustomerTO> getCustomerByCity(String email);
	public int getCustomerCount();
	public String getCustomerCityByEmail(String email);
	public Long getCustomerPhoneByEmail(String email);
}
