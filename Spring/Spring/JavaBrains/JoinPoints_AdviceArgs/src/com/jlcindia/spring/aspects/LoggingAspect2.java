package com.jlcindia.spring.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
//in order to run this advice we have to configure bean in xml.
public class LoggingAspect2 {

	@Before("allCircleMethods()")
	public void loggingAdvice(){
		
	}
	
	@AfterReturning(pointcut="args(name)", returning="returnString")
	public void StringArgsMethods(String name, Object returnString){
		System.out.println("String args method called.... : "+name+"\t"+returnString);
	}
	
	@AfterThrowing(pointcut="args(name)", throwing="ex")
	public void exceptionAdvice(String name, RuntimeException ex){
		System.out.println("Exception thrown : "+ex);
	}
	
	@Pointcut("execution(* get*())")
	public void allGetters(){
		System.out.println("allGetters Advice will not run----");
	}
	
//	@Pointcut("execution(* * com.jlcindia.spring.model.Circle.*(..))")	//	.. means zero or more arguments
//				OR
	@Pointcut("within(com.jlcindia.spring.model.Circle)")
	public void allCircleMethods(){}

}

