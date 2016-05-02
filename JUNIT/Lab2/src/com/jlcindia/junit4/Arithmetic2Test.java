package com.jlcindia.junit4;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.jlcindia.Arithmetic2;

@RunWith(Parameterized.class)
public class Arithmetic2Test {

	Arithmetic2 a1 = null;
	int a, b, c;
	
	public Arithmetic2Test(int a, int b, int c){
		System.out.println("Arithmetic1Test--3arg");
		this.a=a;
		this.b=b;
		this.c=c;
	}
	
	@Parameters
	public static Collection data(){
		System.out.println("data()");
		return TestData.getData();
	}
	
	
	@BeforeClass
	public static void initBeforeClass() throws Exception {
		System.out.println("initBeforeClass()......");
	}

	@AfterClass
	public static void cleanAfterClass() throws Exception {
		System.out.println("cleanAfterClass()......");
	}

	@Before
	public void init1() throws Exception {
		System.out.println("init1()....");
		a1 = new Arithmetic2();
	}
	
	@Before
	public void init2() throws Exception {
		System.out.println("init1()....");
	}

	@After
	public void clean1() throws Exception {
		System.out.println("clean1");
		a1 = null;
	}
	
	@After
	public void clean2() throws Exception {
		System.out.println("clean2");
	}

	@Test
	public void testMul2() {
		System.out.println("testSum2()");
		int x = a1.mul(a, b);
		assertEquals(a*b, x);
	}

	@Test
	public void testMul3() {
		System.out.println("testSum3()");
		int x = a1.mul(a, b, c);
		assertEquals(a*b*c, x);
	}
	
	@Test
	public void testDiv() {
		System.out.println("testSub()");
		int x = a1.div(a, b);
		assertEquals(a/b, x);
	}

}
