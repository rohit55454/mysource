package com.jlcindia.spring;

public class Hello {
	private A aobj;
	private B bobj;
	
	public void setAobj(A aobj) {
		System.out.println("Hello-setAobj()");
		this.aobj = aobj;
	}
	
	public Hello(B bobj){
		System.out.println("Hello-1arg cons");
		this.bobj = bobj;
	}
	
	public void show(){
		System.out.println("..........aobj.showA()..........");
		aobj.showA();
		System.out.println("..........aobj.showB()..........");
		bobj.showB();
	}
}
