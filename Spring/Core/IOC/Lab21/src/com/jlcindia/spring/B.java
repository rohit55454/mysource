package com.jlcindia.spring;

import javax.annotation.PostConstruct;

public class B {
	private int b;
	private String str;
	
	static{
		System.out.println("BSB");
	}
	
	public B(){
		System.out.println("BDC");
	}
	
	public B(int b, String str){
		System.out.println("B-- 2 arg constructor");
		this.b = b;
		this.str = str;
	}

	@PostConstruct
	public void init(){
		System.out.println("B-init()");
	}
	
	@Override
	public String toString() {
		return b+"\t"+str;
	}
}
