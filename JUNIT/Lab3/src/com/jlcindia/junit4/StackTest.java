package com.jlcindia.junit4;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import org.junit.runner.*;

import org.junit.runners.*;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class StackTest {
	
	Stack<String> stack;
	private String email;
	
	public StackTest(String email){
		this.email = email;
	}
	
	@Parameters
	public static Collection data(){
		Object [][]data = new Object[][]{{"sri@jlc.com"}, {"vas@jlc.com"}, {"sd@jlc.com"}};
		return Arrays.asList(data);
	}
	
	@Before
	public void init(){
		System.out.println("resourse is created");
		stack = new Stack<String>();
	}
	
	@After
	public void cleanup(){
		System.out.println("resourse is released");
		stack = null;
	}
	
	@Test
	public void pushTest(){
		System.out.println("pushTest"+email);
		stack.push(email);
		assertEquals(stack.peek(), email);
	}
	
	@Test(expected = EmptyStackException.class)
	public void peekTest(){
		System.out.println("peekTest()"+email);
		stack = new Stack<String>();
		stack.peek();
	}
	
	@Test
	public void emptyTest(){
		System.out.println("emptyTest()"+email);
		stack = new Stack<String>();
		assertTrue(stack.isEmpty());
	}

	
}
