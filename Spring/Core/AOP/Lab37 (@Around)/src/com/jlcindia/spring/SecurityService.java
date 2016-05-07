package com.jlcindia.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecurityService {
	
	@Pointcut(value="execution(*com.jlcindia.spring.AccountService.my*(..))")
	public void jlc1(){}
	
	@Pointcut(value="execution(* com.jlcindia.spring.CustomerService.up*(..))")
	public void jlc2(){}
	
	@Around("jlc1() or jlc2()")
	public void verifyUser(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("verifyUser()..begin.........");
		pjp.proceed();
		System.out.println("verifyUser()..end.........");
	}
}
