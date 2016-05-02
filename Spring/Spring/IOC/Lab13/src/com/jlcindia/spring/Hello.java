package com.jlcindia.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class Hello {
	
	// @Autowired for Fields
	
	@Autowired
	private A aobj;
	@Autowired
	private B bobj;
	
	public void show(){
		System.out.println(aobj);
		System.out.println(bobj);
	}
}
