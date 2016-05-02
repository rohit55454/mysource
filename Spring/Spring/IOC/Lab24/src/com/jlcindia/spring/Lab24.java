package com.jlcindia.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lab24 {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("jlcindia.xml");
		
		Student stu = (Student)ctx.getBean("student");
		System.out.println(stu.getSid().getBid());
		System.out.println(stu.getSid().getSid());
		System.out.println(stu.getSname());
		System.out.println(stu.getPhone());
		System.out.println(stu.getFee().getFeeBal());
		System.out.println(stu.getFee().getFeePaid());
		System.out.println(stu.getFee().getTotalFee());
		System.out.println(stu.getEmails());
		System.out.println(stu.getPhones());
		
	}
}
