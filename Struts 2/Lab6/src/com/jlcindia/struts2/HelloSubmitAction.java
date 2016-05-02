package com.jlcindia.struts2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class HelloSubmitAction extends ActionSupport implements ModelDriven<User>, Preparable, ServletRequestAware, ApplicationAware{

	private StudentTO sto;				//	we have to initialize
	private User user;					//	Model FrameWork will initialize
	private int x = 999;				//	we have to initialize
	private List<String> emails;		//	we have to initialize
	private List<StudentTO> students;	//	we have to initialize
	
	private HttpServletRequest request;		//	Model FrameWork will initialize
	private HttpServletResponse response;	//	Model FrameWork will initialize
	private Map<String, Object> ctxMap;		//	Model FrameWork will initialize	
	private Map<String, Object> sesMap; 	//	Model FrameWork will initialize
	private Map<String, Object> reqMap;		//	Model FrameWork will initialize
	
	
	public HelloSubmitAction(){
		Address add = new Address();
		add.setCity("Blore");
		add.setState("KA");
		add.setCountry("IN");
		
		sto = new StudentTO();
		
		sto.setSid("JLC-123");
		sto.setBid("B-99");
		sto.setSname("rohit");
		sto.setEmail("rohit@gmail.com");
		sto.setPhone("1111111");
		sto.setAddress(add);
		
		emails = new ArrayList<>();
		emails.add("a@z.com");
		emails.add("b@z.com");
		emails.add("c@z.com");
		emails.add("d@z.com");
		
		students = new ArrayList<>();
		students.add(sto);	students.add(sto);	students.add(sto);	students.add(sto);
		
	}
	
	public void validate(){
		if(user.getName()==null || user.getName().length()==0)
			addFieldError("name", "Name is required");
		if(user.getEmail()==null || user.getEmail().length()==0)
			addFieldError("email", "Email is required");
		if(user.getPhone()==null || user.getPhone().length()==0)
			addFieldError("phone", "Phone is required");
	}
	
	public String execute() throws Exception{
		System.out.println(user.getName());
		System.out.println(user.getEmail());
		System.out.println(user.getPhone());
		System.out.println(x);
		
		HttpServletRequest req = ServletActionContext.getRequest();
		System.out.println(req==request);		//	true
		
		HttpServletResponse res = ServletActionContext.getResponse();
		System.out.println(res==response);		//	false
		
		req.setAttribute("UNAME", user.getName());
		reqMap.put("EMAIL", user.getEmail());
		req.setAttribute("EMAILS", emails);
		reqMap.put("STO", sto);
		
		HttpSession session = req.getSession();
		session.setAttribute("UNAME", user.getName());
		sesMap.put("EMAIl", user.getEmail());
		session.setAttribute("EMAILS", emails);
		sesMap.put("STO", sto);
		
		
		ServletContext ctx = ServletActionContext.getServletContext();
		ctx.setAttribute("UNAME", user.getName());
		ctx.setAttribute("EMAIL", user.getEmail());
		ctx.setAttribute("EMAILS", emails);
		ctxMap.put("STO", sto);
		
		return "success";
		
	}
	
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponce(HttpServletResponse responce) {
		this.response = response;
	}
	

	public void setSession(Map<String,Object> sesMap){
		this.sesMap = sesMap;
	}
	
	public void setRequest(Map<String,Object> reqMap) {
		this.reqMap = reqMap;
	}


	@Override
	public User getModel() {
		return user;
	}
	
	@Override
	public void setApplication(Map ctxMap){
		this.ctxMap = ctxMap;
	}
	
//	public void setApplication(Map<String,Object> ctxMap) {
//		this.ctxMap = ctxMap;
//		
//	}
	
	public void prepare() throws Exception{
		user = new User();
	}
	
	
// 			SETTERS AND GETTERS.......................
	

	public StudentTO getSto() {
		return sto;
	}

	public void setSto(StudentTO sto) {
		this.sto = sto;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public List<StudentTO> getStudents() {
		return students;
	}

	public void setStudents(List<StudentTO> students) {
		this.students = students;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Map<String, Object> getCtxMap() {
		return ctxMap;
	}

	public void setCtxMap(Map<String, Object> ctxMap) {
		this.ctxMap = ctxMap;
	}

	public Map<String, Object> getSesMap() {
		return sesMap;
	}

	public void setSesMap(Map<String, Object> sesMap) {
		this.sesMap = sesMap;
	}

	public Map<String, Object> getReqMap() {
		return reqMap;
	}

	public void setReqMap(Map<String, Object> reqMap) {
		this.reqMap = reqMap;
	}
	
	
}
