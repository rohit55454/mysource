package com.jlcindia.spring.aspects;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
//in order to run this advice we have to configure bean in xml.
public class LoggingAspect {

	
	@Before("allCircleMethods()")	// this will run getter or setter and this will print same statement for both, but if we want to print getter / setter specified statements individually then we have to use joinpoints.
	public void LoggingAdvice(Joinpoint joinPoint){
		System.out.println(joinPoint.toString());
	//	System.out.println(joinPoint.getTarget());
	}
	
	@Before("args(String)")
	public void StringArgsMethods(){
		System.out.println("method containing String as argument is called");
	}
	
	@Before("args(name)")
	public void StringArgsMethods2(String name){
		System.out.println("method containing String as argument is called : "+name);
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

