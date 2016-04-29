package com.spring.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.rest.to.StudentTO;
import com.spring.rest.to.Students;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping(value="/getbyid/{id}", method=RequestMethod.GET)
	public String getStudent(@PathVariable int id, ModelMap model){
		System.out.println("in getStudent()....");
		StudentTO st = new StudentTO(id, "rohit", "a@b.in", 99999);
		model.addAttribute("STUD", st);
		return "index";
	}
	
	@RequestMapping(value="/add/{name}/{email}/{phone}", method=RequestMethod.POST)
	public String addStudent(@PathVariable String name, @PathVariable String email,
			@PathVariable String phone, ModelMap model){
		System.out.println("in addStudent()...");
		StudentTO st = new StudentTO(123, "asd", "a@b", 9999);
		System.out.println("in server "+st);
		model.addAttribute("ADDED", "Student info Added Successfully");
		
		return "index";
	}

	@RequestMapping(value="/getall", method=RequestMethod.GET)
	public String getAllStudents(ModelMap model){
		System.out.println("in getAllStudents");
		List<StudentTO> studList = new ArrayList<StudentTO>();
		
		studList.add(new StudentTO(1, "q", "q@z", 4658789));
		studList.add(new StudentTO(2, "w", "w@z", 7965874));
		studList.add(new StudentTO(3, "e", "e@z", 1234566));
		studList.add(new StudentTO(4, "r", "r@z", 6325478));
		
		Students list = new Students();
		list.setStudList(studList);
		model.addAttribute("LIST", list);
		
		return "index";
	}
	
}














