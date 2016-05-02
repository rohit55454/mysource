package com.jlcindia.spring;

public class CustomerServiceImpl implements CustomerService{

	@Override
	public void addCustomer() {
		System.out.println("Adding customer....begin");
		System.out.println("Adding customer....done");
		System.out.println("Adding customer....end");
	}

	@Override
	public void updateCustomer() {
		System.out.println("updating customer....begin");
		System.out.println("updating customer....done");
		System.out.println("updating customer....end");
	}
	
}
