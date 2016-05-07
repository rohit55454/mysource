package com.jlcindia.spring;

import org.aspectj.lang.ProceedingJoinPoint;

public class TxService {
	
	public void runTx(ProceedingJoinPoint pjp)throws Throwable{
		System.out.println("runTx()....begin");
		begin();
		pjp.proceed();
		commit();
		System.out.println("runTx()....end");
	}
	
	public void begin(){
		System.out.println("TS---begin()..........");
	}
	
	public void commit(){
		System.out.println("TS---commit() called");
	}
	
	public void rollBack(){
		System.out.println("TS---rollback()........");
	}
}
