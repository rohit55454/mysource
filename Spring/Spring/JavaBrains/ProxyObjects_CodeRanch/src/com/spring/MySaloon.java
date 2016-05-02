package com.spring;

public class MySaloon implements Saloon{

	private String greeting;
	
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}


	@Override
	public void openSaloon() {
		System.out.println("Saloon Open "+"\t"+getClass()+"\t"+toString());
		System.out.println(greeting);
	}
	
}
