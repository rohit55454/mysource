package com.jlcindia.spring;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class TestBean {

	@Autowired
	ApplicationContext ctx = null;
	
	void showEnglish(){
		String m1 = ctx.getMessage("username.required", null, null);
		String m2 = ctx.getMessage("password.required", new Object[]{"password"}, null);
		String m3 = ctx.getMessage("errors.min", new Object[]{"username", "5"}, null);
		String m4 = ctx.getMessage("errors.max", new Object[]{"username", "10"}, null);
		String m5 = ctx.getMessage("errors.range", new Object[]{"password", "6", "12"}, null);
		String m6 = ctx.getMessage("errors.range1", new Object[]{"password", "6", "12"}, "username rangenot OK" ,null);
		
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		System.out.println(m4);
		System.out.println(m5);
		System.out.println(m6);
	}
	
	void showHindi(){
		String m1 = ctx.getMessage("username.required", null, new Locale("hi"));
		String m2 = ctx.getMessage("password.required", new Object[]{"password"}, new Locale("hi"));
		String m3 = ctx.getMessage("errors.min", new Object[]{"username", "5"}, new Locale("hi"));
		String m4 = ctx.getMessage("errors.max", new Object[]{"username", "10"}, new Locale("hi"));
		String m5 = ctx.getMessage("errors.range", new Object[]{"password", "6", "12"}, new Locale("hi"));
		String m6 = ctx.getMessage("errors.range1", new Object[]{"password", "6", "12"}, "username rangenot OK", new Locale("hi"));
		
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		System.out.println(m4);
		System.out.println(m5);
		System.out.println(m6);
	}
	
}
