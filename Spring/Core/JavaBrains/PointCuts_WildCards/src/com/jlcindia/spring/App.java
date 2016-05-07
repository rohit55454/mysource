package com.jlcindia.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jlcindia.spring.service.ShapeService;

public class App {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService ss1 = (ShapeService)ctx.getBean("shapeService");
		ShapeService ss2 = ctx.getBean("shapeService", ShapeService.class);
		System.out.println(ss1.getCircle().getName());
		System.out.println("**********************");
		System.out.println(ss1.getTriangle().getName());
	}
}
