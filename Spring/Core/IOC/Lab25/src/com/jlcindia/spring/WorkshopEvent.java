package com.jlcindia.spring;

import org.springframework.context.ApplicationEvent;

public class WorkshopEvent extends ApplicationEvent{

	Workshop ws;
	
	public WorkshopEvent(Object source, Workshop ws) {
		super(source);
		this.ws = ws;
	}
	
	public Workshop getWoekshop(){
		return ws;
	}
}
