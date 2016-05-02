package com.jlcindia.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Lab21 {
	public static void main(String[] args) {

		Resource res = new ClassPathResource("jlcindia.xml");
		BeanFactory factory = new XmlBeanFactory(res);
		System.out.println("container is ready");
		System.out.println("-----------------------------------");
		Hello h = (Hello)factory.getBean("HELLO");
		h.show();
		System.out.println("-----------------------------------");
		System.out.println("container is going to shutdown");
	}
}
