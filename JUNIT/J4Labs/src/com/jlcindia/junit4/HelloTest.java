package com.jlcindia.junit4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jlcindia.Hello;

public class HelloTest {
	Hello hello = null;
	
	@BeforeClass
	public static void initBeforeClass() throws Exception {
		System.out.println("initBeforeClass");
	}

	@AfterClass
	public static void cleanUpAfterClass() throws Exception {
		System.out.println("cleanUpAfterClass");
	}

	@Before
	public void init() throws Exception {
		System.out.println("init()......");
		hello = new Hello();
	}

	@After
	public void cleanUp() throws Exception {
		System.out.println("cleanUp()......");
		hello = null;
	}

	@Test
	public void testGetMessage1() {
		System.out.println("testGetMessage1");
		String str = hello.getMessage1();
		assertNotNull(str);
	}

	@Test
	public void testGetMessage2() {
		System.out.println("testGetMessage2");
		String str = hello.getMessage2();
		assertNotNull(str);
	}

}
