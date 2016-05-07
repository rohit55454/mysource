package com.jlcindia.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class Hello {
	
	// @Autowired for Constructors
	
	private A aobj;
	private B bobj;
	
	@Autowired
	public Hello(A aobj, B bobj) {
		super();
		this.aobj = aobj;
		this.bobj = bobj;
	}




	public void show(){
		System.out.println(aobj);
		System.out.println(bobj);
	}
}
