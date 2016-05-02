package com.pack.Maven_JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

public class Arithmetic1Test {

	private Arithmetic1 aobj = new Arithmetic1();

	@Test
	public void sumShouldReturnResult() {
		aobj = new Arithmetic1();
		int result = aobj.sum(10, 20);
		assertEquals(30, result);
	}
	
	@Test
	public void sumShouldReturnAResult() {
		int result = aobj.sum(10, 20, 30);
		assertEquals(60, result);
	}
	
	@Test
	public void sumShouldReturnAAResult() {
		int result = aobj.sub(30, 20);
		assertEquals(10, result);
	}

}
