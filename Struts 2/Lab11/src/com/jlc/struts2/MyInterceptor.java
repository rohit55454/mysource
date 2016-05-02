package com.jlc.struts2;

import java.util.Calendar;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyInterceptor implements Interceptor{
	public void init(){}
	public void  destroy(){}
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("pre-processing code of MyInterceptor");
		ActionContext ac = invocation.getInvocationContext();
		Map sessionMap = ac.getSession();
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		String greeting = (hour<6)?"Good Evening" : ((hour<6) ? "Good Morning" : (hour<6)?"Good afternoon" : "Good Evening") ;
		
		sessionMap.put("Greeting", greeting);
		String result = invocation.invoke();	// invokes next interceptor or execute() method
		System.out.println("post processing code of MyInterceptor");
		
		return result;
	}
	
}
