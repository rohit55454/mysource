package com.jlcindia.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HaiConfig {
	
	public HaiConfig(){
		System.out.println("HaiConfig--DC");
	}
	
	@Bean(name="hai")		// if we don't give alias to Bean then method name will be considered as Bean.
	public Hai getHai(){
		System.out.println("getHai()");
		return new Hai();
	}
	
}
