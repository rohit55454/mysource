package com.jlcindia.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(HaiConfig.class)
public class HelloConfig {
	
	public HelloConfig(){
		System.out.println("HelloConfig--DC");
	}
	
	@Bean(name="hello")		// if we don't give alias to Bean then method name will be considered as Bean.
	public Hello getHello(){
		System.out.println("getHello()");
		return new Hello();
	}
	
}
