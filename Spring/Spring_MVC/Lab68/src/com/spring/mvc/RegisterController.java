package com.spring.mvc;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class RegisterController extends SimpleFormController{

	public ModelAndView onSubmit(Object command) throws ServletException {
		Student stu = (Student)command;
		System.out.println(stu.getSid());
		System.out.println(stu.getSname());
		System.out.println(stu.getEmail());
		System.out.println(stu.getPhone());
		System.out.println(stu.getQualification());
		System.out.println(stu.getGender());
		System.out.println(stu.getRemarks());
		
		String tim[] = stu.getTimings();
		for(String t : tim)
			System.out.println(t);
		
		String view = getSuccessView();
		return new ModelAndView(view, "student", stu);
		
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws ServletException{
		Student stu = new Student();
		stu.setSid("jlc-99");
		return stu;
	}
	
}
