package com.jlcindia.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class JLCListener1 implements ApplicationListener{

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if(event instanceof BatchEvent){
			BatchEvent batchEvent = (BatchEvent)event;
			Batch bat = batchEvent.getBatch();
			System.out.println(bat);
		}
		else if(event instanceof WorkshopEvent){
			WorkshopEvent wsEvent = (WorkshopEvent)event;
			Workshop ws = wsEvent.getWoekshop();
			System.out.println(ws);
		}
		else{
			System.out.println(event);
		}
	}
	
}
