package com.jlcindia.spring;

public class B {
	private int b;
	private String str;
	
	public B(int b, String str){
		System.out.println("B-2arg cons");
		this.b = b;
		this.str = str;
	}
	
	@Override
	public String toString() {
		return b+"\t"+str;
	}
}
