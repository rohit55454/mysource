package com.jlcindia.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JlcConfig {
	public JlcConfig(){
		System.out.println("Spring container now getting ready");
	}
	
	@Bean(name="hello")
	public Hello getHello(){
		System.out.println("getHello()");
		return new Hello();
	}

	@Bean(name="ao")
	public A getA(){
		A obj = new A();
		obj.setA(99);
		obj.setMsg("Hello");
		return obj;
	}

	@Bean(name="bo")
	public B getB(){
		B obj = new B(88, "sri");
		return obj;
	}
}
