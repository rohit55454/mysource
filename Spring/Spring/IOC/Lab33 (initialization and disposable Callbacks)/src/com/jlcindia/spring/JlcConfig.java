package com.jlcindia.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JlcConfig {
	public JlcConfig(){
		System.out.println("Spring container now getting ready");
	}
	
	@Bean(name="hello", initMethod="myInit", destroyMethod="myCleanUp")
	public Hello getHello(){
		System.out.println("getHello()");
		return new Hello();
	}

}
