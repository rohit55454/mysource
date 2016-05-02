package com.jlcindia.junit4;

import java.util.ArrayList;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class CustomerService {
	
	public CustomerTO getCustomerByCid(int cid){
		CustomerTO cto = null;
		if(cid<=100){
			cto = new CustomerTO(cid, "rohit", "a@b.in");
		}
		return cto;
	}
	
	
	public ArrayList<CustomerTO> getAllCustomers(){
		ArrayList al = new ArrayList<>();
		
		if(1 == 1){
			while (true) {		}
		}
		
		return al;
	}
	
	public CustomerTO getCustomerByEmail(String email){
		CustomerTO cto = null;
		
		if(email.equals("a@b.in")){
			cto = new CustomerTO(101, "rohit", email);
		}
		else{
			throw new CustomerNotFoundException();
		}
		
		return cto;
	}
	
	public void addCustomer(){}
	
	public void updateCustomer(){}
	
	
}
