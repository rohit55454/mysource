package com.jlcindia.spring.service;

import com.jlcindia.spring.model.Circle;
import com.jlcindia.spring.model.Triangle;

public class ShapeService {
	
	private Circle circle;
	private Triangle triangle;
	
	public Circle getCircle() {
		System.out.println("getCircle called");
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
	
	
}
