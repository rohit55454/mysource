package com.jlcindia.spring;

import org.springframework.context.ApplicationListener;

public class JLCListener2 implements ApplicationListener<BatchEvent>{

	@Override
	public void onApplicationEvent(BatchEvent event) {
		System.out.println("JLCListener2---onApplicationEvent()");
		System.out.println("Batch event reaised");
		BatchEvent be = (BatchEvent)event;
		System.out.println(be.getBatch());
	}

	
}
