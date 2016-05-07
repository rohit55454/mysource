package com.jlcindia.spring;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.beans.factory.annotation.Autowired;

public class JLCMRAdvice implements AfterReturningAdvice{

	@Autowired
	LogService ls = null;
	@Autowired
	TxService ts = null;
	
	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		ts.commit();
		ls.logReturning();
	}
	
}
