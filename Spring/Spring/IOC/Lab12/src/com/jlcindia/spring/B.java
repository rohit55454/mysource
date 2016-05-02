package com.jlcindia.spring;

public class B {
	private int b;
	private String str;
	
	public void setB(int b){
		System.out.println("B--setB()");
		this.b = b;
	}
	
	public void setStr(String str){
		System.out.println("B--setStr()");
		this.str = str;
	}
	
	public void showB(){
		System.out.println(b);
		System.out.println(str);
	}
}
