package com.jlcindia.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lab37 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jlcindia.xml");
		CustomerService cst = (CustomerService)ctx.getBean("cs");
		cst.addCustomer();
		System.out.println("***********************");
		cst.updateCustomer();
		
		System.out.println("***********************");
		
		AccountService ast = (AccountService)ctx.getBean("as");
		ast.myDeposit();
		System.out.println("***********************");
		ast.getBal();
		System.out.println("***********************");		
		try{
			ast.myWithdraw();
		}catch (Exception e) {
			System.out.println("Sorry---------");
		}
	}
}
