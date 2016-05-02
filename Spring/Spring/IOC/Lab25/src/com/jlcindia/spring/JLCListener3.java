package com.jlcindia.spring;

import org.springframework.context.ApplicationListener;

public class JLCListener3 implements ApplicationListener<WorkshopEvent>{

	@Override
	public void onApplicationEvent(WorkshopEvent event) {
		System.out.println("JLCListener3---onApplicationEvent()");
		System.out.println("workshopEvent reaised");
		WorkshopEvent we = (WorkshopEvent)event;
		System.out.println(we.getWoekshop());
	}
	
}
