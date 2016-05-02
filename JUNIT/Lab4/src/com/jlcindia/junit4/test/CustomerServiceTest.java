package com.jlcindia.junit4.test;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.jlcindia.junit4.CustomerNotFoundException;
import com.jlcindia.junit4.CustomerService;
import com.jlcindia.junit4.CustomerTO;
import com.jlcindia.junit4.TestData;

@RunWith(value=Parameterized.class)
public class CustomerServiceTest {
	
	CustomerService cs = null;
	int cid;
	String email;
	
	public CustomerServiceTest(int cid, String email){
		this.cid = cid;
		this.email = email;
	}
	
	@Parameters
	public static Collection data(){
		System.out.println("data()...");
		return TestData.getCustomerData();
	}
	
	@Before
	public void init() throws Exception{
		System.out.println("init()...");
		cs = new CustomerService();
	}
	
	@After
	public void clean() throws Exception{
		cs = null;
	}
	
	@Test
	public void testGetCustomerByCid(){
		CustomerTO cto = cs.getCustomerByCid(cid);
		if(cto == null){
			assertNull(cto);
		}else{
			assertEquals(10, cto.getCid());
			assertEquals("rohit", cto.getCname());
			assertEquals("a@b.in", cto.getEmail());
		}
	}
	
	@Test(timeout=100)
//	@Test
	public void testGetAllCustomers(){
		ArrayList<CustomerTO> al = cs.getAllCustomers();
	}
	
	@Test(expected=CustomerNotFoundException.class)
	public void testGetCustomerByEmail(){
		CustomerTO cto = cs.getCustomerByEmail(email);
	}
	
	@Ignore
	@Test
	public void addCustomer(){}
	
	@Ignore
	@Test
	public void updateCustomer(){}
	
}
