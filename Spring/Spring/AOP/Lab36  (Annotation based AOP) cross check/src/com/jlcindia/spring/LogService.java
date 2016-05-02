package com.jlcindia.spring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogService {
	
	@Pointcut(value="execution(* my*(..))")
	public void jlc1(){}
	
	@Pointcut(value="execution(* com.jlcindia.spring.CustomerService.up*(..))")
	public void jlc2(){}
	
	
	@Before("jlc1() || jlc2()")
	public void logBefore(){
		System.out.println("logBefore()............");
	}
	
	@AfterReturning("jlc1()")
	public void logReturning(){
		System.out.println("logReturning().........");
	}
	
	@AfterThrowing("jlc1()")
	public void logThrowing(Exception e){
		System.out.println("logThrowing()........");
		System.out.println(e);
	}
	
	@After("jlc1()")
	public void logOK(){
		System.out.println("logOK().........");
	}
	
}
