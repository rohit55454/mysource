package com.jlcindia.spring.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
//in order to run this advice we have to configure bean in xml.
public class LoggingAspect {

	@Before("allCircleMethods()")
	public void LoggingAdvice(){
		System.out.println("Advice run----allCircleMethods called");
	}
	
	@Before("allGetters() || allTriangleMethods()")
	public void SecondAdvice(){
		System.out.println("second Advice run----");
	}
	
	@Pointcut("execution(public String getName())")
	public void allGetters(){
		System.out.println("allGetters Advice will not run----");
	}
	
//	@Pointcut("execution(* * com.jlcindia.spring.model.Circle.*(..))")	//	.. means zero or more arguments
//				OR
	@Pointcut("within(com.jlcindia.spring.model.Circle)")
	public void allCircleMethods(){
		System.out.println("this Advice will not print----");
	}
	
	@Pointcut("within(com.jlcindia.spring.model.Triangle)")
	public void allTriangleMethods(){
		System.out.println("this Advice will not print----");
	}
}

