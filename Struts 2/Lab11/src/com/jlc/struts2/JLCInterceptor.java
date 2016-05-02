package com.jlc.struts2;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class JLCInterceptor implements Interceptor{
	public void init(){}
	public void  destroy(){}
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("pre-processing code of JLCInterceptor");
		ActionContext ac = invocation.getInvocationContext();
		Map sessionMap = ac.getSession();
		sessionMap.put("JLCMSG", "Welcome to Java Learning Center");
		String result = invocation.invoke(); 	// invokes next interceptor or execute() method
		System.out.println("post processing code of JLCInterceptor");
		
		return result;
	}
	
}
