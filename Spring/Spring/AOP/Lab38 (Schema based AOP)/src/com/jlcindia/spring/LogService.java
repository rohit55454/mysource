package com.jlcindia.spring;

public class LogService {
	
	public void logBefore(){
		System.out.println("logBefore()............");
	}
	
	public void logReturning(){
		System.out.println("logReturning().........");
	}
	
	public void logThrowing(Exception e){
		System.out.println("logThrowing()........");
		System.out.println(e);
	}
	
	public void logOK(){
		System.out.println("logOK().........");
	}
	
}
