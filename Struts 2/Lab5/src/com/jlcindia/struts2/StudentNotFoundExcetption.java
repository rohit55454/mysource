package com.jlcindia.struts2;

public class StudentNotFoundExcetption extends Exception{
	String sid;

	public StudentNotFoundExcetption(){}
	public StudentNotFoundExcetption(String sid) {
		this.sid = sid;
	}
	
	public String getMessage(){
		String msg = "Student iD not Found";
		return msg;
	}
}
