package com.spring;

import java.lang.reflect.Method;
import java.util.Date;

import org.springframework.aop.MethodBeforeAdvice;

public class SaloonWatcher implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] arg1, Object target) throws Throwable {
		System.out.println(new Date()+"\t"+method.getName()+"  "+"called on "+target);
	}

}
