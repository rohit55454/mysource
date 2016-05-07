package com.spring.transaction.jpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lab57 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		AccountDAO adao = (AccountDAO)ctx.getBean("adao");
		System.out.println(adao.getBalance(101));
		System.out.println(adao.getBalance(102));
		
	//	1. Deposit
		adao.deposit(101, 2000.0);
		
	//	2. Withdarw
		adao.withdraw(102, 5000.0);
		
	//	3. getBalance
		System.out.println(adao.getBalance(101));
		System.out.println(adao.getBalance(102));
		
	//	4. Fund Transfer
		System.out.println(adao.getBalance(103));
		System.out.println(adao.getBalance(101));
		
		adao.fundsTransfer(103, 101, 30000.0);
		
		System.out.println(adao.getBalance(103));
		System.out.println(adao.getBalance(101));
		
	}
	
}
