package com.jlcindia.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lab25 {
	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("jlcindia.xml");
		ctx.start();
		JLCManager jlc = (JLCManager)ctx.getBean("jlc");
		Batch b = new Batch("B-24", "12-mar-2016", "6:30-8:30", 150);
		jlc.addBatch(b);
		Workshop ws = new Workshop("Web services", 5000, 99);
		jlc.addWorkshop(ws);
		ctx.stop();
		ctx.close();
		
	}
}
