package com.jlcindia.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

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
	
	@Bean(name="hai")			//singleton but	lazy
	@Lazy
	public Hai getHai(){
		System.out.println("getHai()");
		return new Hai();
	}
}
