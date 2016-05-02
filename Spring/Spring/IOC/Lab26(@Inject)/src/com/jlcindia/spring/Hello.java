package com.jlcindia.spring;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;

public class Hello {

//	add weld-osgi-bundle.jar to build path	
	@Inject
	private A aobj;
	
	@Inject
	@Qualifier("bo2")		//	@Qualifier must be from spring don't take from inject
	private B bobj;
	
	public void show() {
		System.out.println(aobj);
		System.out.println(bobj);
	}
	
}
