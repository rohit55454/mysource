package com.jlcindia.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JLCConfig {
	
	public JLCConfig(){
		System.out.println("Spring Container is getting ready");
	}
	
	@Bean(name="hello")			//	singleton and Aggressive
	public Hello getHello(){
		System.out.println("getHello()");
		return new Hello();
	}
	
	@Bean(name="hai")			//	lazy
	@Scope("prototype")
	public Hai getHai(){
		System.out.println("getHai()");
		return new Hai();
	}
}
