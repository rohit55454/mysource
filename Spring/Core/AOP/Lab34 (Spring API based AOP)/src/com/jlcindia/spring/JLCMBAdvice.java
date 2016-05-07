package com.jlcindia.spring;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;

public class JLCMBAdvice implements MethodBeforeAdvice{

	@Autowired
	LogService ls = null;
	@Autowired
	SecurityService ss = null;
	@Autowired
	TxService ts = null;
	
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		ss.verifyUser();
		ls.logBefore();
		ts.begin();
		
	}
		
}
