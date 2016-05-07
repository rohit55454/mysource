package com.jlcindia.spring;

import javax.annotation.Resource;

public class Hello {
	
	// @Autowired for Fields
	
	@Resource
	private A aobj;
	@Resource(name="bo")
	private B bobj;
	
	public void show(){
		System.out.println(aobj);
		System.out.println(bobj);
	}
}
