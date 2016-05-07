package com.jlcindia.spring;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogService {
	
	public void log(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("log()......begin");
		logBefore();
		pjp.proceed();
		logReturning();
		System.out.println("log()......begin");
	}
	
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
