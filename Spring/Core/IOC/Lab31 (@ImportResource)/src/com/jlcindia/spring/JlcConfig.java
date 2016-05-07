package com.jlcindia.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("spring.xml")
public class JlcConfig {
	public JlcConfig(){
		System.out.println("Spring container now getting ready");
	}
	
	@Bean(name="hello")
	public Hello getHello(){
		System.out.println("getHello()");
		return new Hello();
	}
}
