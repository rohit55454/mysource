package com.jlcindia.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogService {
	
	@Pointcut(value="execution(* com.jlcindia.spring.AccountService.my*(..))")
	public void jlc1(){}
	
	@Pointcut(value="execution(* com.jlcindia.spring.CustomerService.up*(..))")
	public void jlc2(){}
	
	
	@Around("jlc1() or jlc2()")
	public void log(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("LogService--log() begins");
		logBefore();
		pjp.proceed();
		logReturning();
		System.out.println("LogService--log() begins");
	}
	
	public void logBefore(){
		System.out.println("logBefore()............");
	}
	
	public void logReturning(){
		System.out.println("logReturning().........");
	}
	
	@AfterThrowing("jlc1() or jlc2()")
	public void logThrowing(Exception e){
		System.out.println("logThrowing()........");
		System.out.println(e);
	}
	
	@After("jlc1() or jlc2()")
	public void logOK(){
		System.out.println("logOK().........");
	}
	
}
