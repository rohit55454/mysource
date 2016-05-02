package com.jlcindia.junit3;

import com.jlcindia.Arithmetic1;

import junit.framework.TestCase;

public class Arithmetic1Test extends TestCase {
	Arithmetic1 al = null;

	protected void setUp() throws Exception {
		System.out.println("setup()...");
		super.setUp();
		al = new Arithmetic1();
	}

	protected void tearDown() throws Exception {
		System.out.println("teardown()...");
		super.tearDown();
		al = null;
	}

	public void testSum2() {
		System.out.println("testSum2()...");
		int x = al.sum(10, 20);
		assertEquals(30, x);
		
		x=al.sum(100, 200);
		assertEquals(300, x);
		
		x=al.sum(30, 20);
		assertEquals(50, x);
	}

	public void testSum3() {
		System.out.println("testSum3()...");
		int x = al.sum(10, 20, 30);
		assertEquals(60, x);
		
		x=al.sum(100, 200, 300);
		assertEquals(600, x);
		
		x=al.sum(30, 20, 30);
		assertEquals(80, x);
	}

	
	public void testSub() {
		System.out.println("testSub()...");
		int x = al.sub(100, 20);
		assertEquals(80, x);
		
		x = al.sub(1000, 200);
		assertEquals(800, x);
		
		x = al.sub(80, 20);
		assertEquals(60, x);
	}

}
