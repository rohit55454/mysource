package com.jlcindia.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Hello implements InitializingBean, DisposableBean,
								BeanNameAware, BeanFactoryAware, ApplicationContextAware{
	
	
	int x;
	String str, msg, banme;
	
	@Autowired
	A aobj;
	B bobj;
	
	ApplicationContext ctx1;
	BeanFactory factory1;
	
	@Autowired
	ApplicationContext ctx2;
	@Autowired
	BeanFactory factory2;
	
	static{
		System.out.println("Hello--SB");
	}
	
	public Hello(int x){
		System.out.println("Hello--(int x)");
		this.x = x;
	}
	
	public void setStr(String str) {
		System.out.println("Hello-setStr()");
		System.out.println(aobj);
		System.out.println(bobj);
		this.str = str;
	}
	
	public void setBobj(B bobj) {
		System.out.println("Hello--setBobj()");
		this.bobj = bobj;
	}
	
	@PostConstruct
	public void init1(){
		System.out.println("Hello--init1()");
		msg = "Welcome to JLC";
		if(str==null)
			str="Hai guys";
	}
	
	@PostConstruct
	public void init2(){
		System.out.println("Hello--init2()");
		msg = "Welcome to JLC";
		if(str==null)
			str="Hai guys";
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Hello--afterPropertiesSet()");
		msg = "Welcome to JLC";
		if(str==null)
			str="Hai guys";
	}
	
	public void myinit(){
		System.out.println("Helllo--myiinit()");
		msg = "Welcome to JLC";
		if(str==null)
			str="Hai guys";
	}
	
	@Override
	public void setBeanName(String bname) {
		System.out.println("Hello--setBeanName");
		this.banme = bname;
	}
	
	@Override
	public void setBeanFactory(BeanFactory factory1) throws BeansException {
		System.out.println("Hello--setBeanFactory()");
		this.factory1 = factory1;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext ctx1) throws BeansException {
		System.out.println("Hello--setApplicationContext()");
		this.ctx1 = ctx1;
	}
	
	@PreDestroy
	public void cleanup(){
		System.out.println("Hello--cleanup()");
	}

	public void destroy() throws Exception{
		System.out.println("Hello--destroy()");
	}
	
	public void mycleanup(){
		System.out.println("Hello--mycleanup()");
	}
	
	public void show(){
		System.out.println("Hello--show()");
		System.out.println(x);
		System.out.println(str);
		System.out.println(msg);
		System.out.println("Bean name : "+banme);
		System.out.println(factory1);
		System.out.println(ctx1);
		System.out.println(factory2);
		System.out.println(ctx2);
		
		System.out.println(ctx1==ctx2);
		System.out.println(factory1==factory2);
	}
}