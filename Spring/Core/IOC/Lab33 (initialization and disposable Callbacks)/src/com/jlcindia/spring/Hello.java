package com.jlcindia.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Hello implements InitializingBean, DisposableBean{

	static{
		System.out.println("Hello--SB");
	}
	
	public Hello(){
		System.out.println("Hello--DC");
	}
//	The @PostConstruct and @PreDestroy annotation are not belong to Spring, it’s located in the J2ee library – common-annotations.jar.
	@PostConstruct
	public void init(){
		System.out.println("Hello--init()");
	}
	
	public void afterPropertiesSet() throws Exception {
		System.out.println("Hello--afterPropertiesSet()");
	}
	
	public void myInit(){
		System.out.println("Hello--myInit()");
	}
	
	@PreDestroy
	public void cleanUp(){
		System.out.println("Hello--cleanUp");
	}
	
	public void destroy() throws Exception {
		System.out.println("Hello--destroy()");
	}
	
	public void myCleanUp(){
		System.out.println("Hello--myCleanUp");
	}
	
	public void show(){
		System.out.println("Hello--show()");
	}

}
