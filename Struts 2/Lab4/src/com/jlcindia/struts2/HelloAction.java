package com.jlcindia.struts2;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class HelloAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, SessionAware, ApplicationAware, ParameterAware, Preparable, ModelDriven<User>{
	
	private User user;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map ctxmap;
	private Map sesMap;
	private Map reqmap;
	private Map rpMap;
	
	static{
		System.out.println("static block");
	}
	
	public HelloAction(){
		System.out.println("Default Constructor");
	}
	
	@Override
	public void validate() {
		System.out.println("validaye()");
	}
	
	public String execute() throws Exception {
		System.out.println("execute()");
		System.out.println("Sname : "+user.getSname());
		System.out.println("Email : "+user.getEmail());
		
		return "success";
	}

	@Override
	public User getModel() {
		System.out.println("getModel()");
		return user;
	}

	@Override
	public void prepare() throws Exception {
		System.out.println("prepare()");
		user = new User();
		
	}

	@Override
	public void setParameters(Map rpMap) {
		System.out.println("setParameters()");
		this.rpMap = rpMap;
		
	}

	@Override
	public void setApplication(Map ctxMap) {
		System.out.println("setApplication()");
		this.ctxmap = ctxMap;
		
	}

	@Override
	public void setSession(Map sesMap) {
		System.out.println("setSession()");
		this.sesMap = sesMap;
		
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		System.out.println("setServletResponse()");
		this.response = response;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		System.out.println("setServletRequest()");
		this.request = request;
		
	}
}
