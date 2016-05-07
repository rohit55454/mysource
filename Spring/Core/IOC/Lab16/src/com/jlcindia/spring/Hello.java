package com.jlcindia.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Hello {
	
	// @Autowired and @Qualifier for Constructor
	
	private A aobj;
	
	private B bobj;

	@Autowired
	public Hello(@Qualifier("ao1")A ao, @Qualifier("bo1")B bo){
		this.aobj = ao;
		this.bobj = bo;
	}
	
	public void show(){
		System.out.println(aobj);
		System.out.println(bobj);
	}
}
