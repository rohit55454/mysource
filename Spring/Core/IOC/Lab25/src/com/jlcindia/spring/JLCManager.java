package com.jlcindia.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class JLCManager implements ApplicationContextAware{

	ApplicationContext ctx = null;
	
	public void addBatch(Batch bat){
		ctx.publishEvent(new BatchEvent(this, bat));
	}
	
	public void addWorkshop(Workshop ws){
		ctx.publishEvent(new WorkshopEvent(this, ws));
	}
	
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx = ctx;
	}
	
}
