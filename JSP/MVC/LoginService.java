package com.mvc.service;

public class LoginService{
	
	public boolean validate(String un, String pw){
		if(un==pw && (un!=null || un.trim().equals("")))
			return true;
		else
			return false;
	}
}
