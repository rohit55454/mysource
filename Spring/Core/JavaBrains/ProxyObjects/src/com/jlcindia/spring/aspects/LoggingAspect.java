package com.jlcindia.spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
//in order to run this advice we have to configure bean in xml.
public class LoggingAspect {


	@Around("allGetters()")
	public Object myAroundAdvice(ProceedingJoinPoint pjp){
		Object returnValue = null;
		
		try{
			System.out.println("before Advice");
			pjp.proceed();
			System.out.println("after returning");
			
		} catch (Throwable e) {
			System.out.println("After throwing");
			e.printStackTrace();
		}
		System.out.println("after finally");
		return returnValue;
	}
	
	public void loggingAdvice(){
		System.out.println("logging from Advice");
	}
	
}

