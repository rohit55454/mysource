package com.spring.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes
public class RegisterController {

	@Autowired
	private StudentValidator studentValidator;
	
	@RequestMapping(value="/registerStudent", method=RequestMethod.POST)
	public String registerStudent(@ModelAttribute("student") Student stu, 
									BindingResult result) throws Exception {
		System.out.println("registerStudent()....");
		studentValidator.validate(stu, result);
		
		if(result.hasErrors()){
			System.out.println(result.getErrorCount());
			return "register";
		}
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
		
		return "home";
		
	}
	
	@RequestMapping(value="/register")
	protected String showRegisterForm(Map model) throws Exception{
		System.out.println("showRegisterForm()....");
		Student stu = new Student();
		stu.setSid("JLC-99");
		model.put("student", stu);
		return "register";
	}
	
	
	
	
	
	
	
/**************************************************************************	
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
**********************************************************************************/	
}
