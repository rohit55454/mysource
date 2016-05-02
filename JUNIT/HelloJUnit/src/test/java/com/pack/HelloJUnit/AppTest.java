package com.pack.HelloJUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppTest {

	private App aobj;
	
	@Before
	public void setup(){
		System.out.println("setup()...");
		aobj = new App();
	}
	
	@Test
	public void helloTest() {
		System.out.println("helloTest()...");
		String greet = aobj.hello("Rohit");
		assertNotNull(greet);
		assertEquals("Hello Rohit", greet);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void throwAnException_forNameNull(){
		System.out.println("throwAnException_forNameNull()...");
		aobj.hello(null);
	}
	
/*	@Test(expected=IllegalArgumentException.class)
	public void throwAnException_forNameBlank(){
		System.out.println("throwAnException_forNameBlank()...");
		aobj.hello("");
	}
*/	
	@After
	public void teardown(){
		System.out.println("teardown()...");
		aobj = null;
	}

}

















