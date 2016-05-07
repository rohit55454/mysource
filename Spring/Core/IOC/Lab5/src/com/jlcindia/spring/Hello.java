package com.jlcindia.spring;

public class Hello {
	private A aobj;
	private B bobj;
	
	public void setAobj(A aobj) {
		System.out.println("Hello-setAObj()");
		this.aobj = aobj;
	}
	
	public void setBobj(B bobj) {
		System.out.println("Hello-setBObj()");
		this.bobj = bobj;
	}
	
	public void show(){
		System.out.println(aobj);
		System.out.println(bobj);
	}
}
