package com.jlcindia.spring.service;

import com.jlcindia.spring.aspects.LoggingAspect;
import com.jlcindia.spring.model.Circle;

public class ShapeServiceProxy extends ShapeService {

	@Override
	public Circle getCircle() {
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
	}
}
