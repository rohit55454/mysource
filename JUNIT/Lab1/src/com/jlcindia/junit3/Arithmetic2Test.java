package com.jlcindia.junit3;

import com.jlcindia.Arithmetic2;

import junit.framework.TestCase;

public class Arithmetic2Test extends TestCase {

	Arithmetic2 a2 = null;
	
	protected void setUp() throws Exception {
		System.out.println("setUp()...");
		super.setUp();
		a2 = new Arithmetic2();
	}

	protected void tearDown() throws Exception {
		System.out.println("tearDown()...");
		super.tearDown();
		a2 = null;
	}

	public void testMul2() {
		System.out.println("testMul2()...");
		int x = a2.mul(10, 20);
		assertEquals(200, x);
		
		x=a2.mul(100, 200);
		assertEquals(20000, x);
		
		x=a2.mul(30, 20);
		assertEquals(600, x);
	}

	public void testMul3() {
		System.out.println("testSum3()...");
		int x = a2.mul(10, 20, 30);
		assertEquals(6000, x);
		
		x=a2.mul(100, 200, 300);
		assertEquals(6000000, x);
		
		x=a2.mul(30, 20, 30);
		assertEquals(18000, x);
	}

	
	public void testDiv() {
		System.out.println("testDiv()...");
		int x = a2.div(100, 20);
		assertEquals(5, x);
		
		x = a2.div(1000, 20);
		assertEquals(50, x);
		
		x = a2.div(80, 20);
		assertEquals(4, x);
	}


}
