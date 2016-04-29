package com.jlc.ctag;

import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class ShowMessageTag extends TagSupport{
	private String sname;
	private String email;
	
	public void setSname(String sname) {
		this.sname = sname;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int doEndTag() throws JspException{
		Writer out = pageContext.getOut();
		try{
			if(sname==null || sname.trim().isEmpty())
				out.write("<font color='red'> u have not specified ur name");
			else{
				out.write("<font color='blue'>"+sname+"</font>");
				if(email==null || email.trim().isEmpty())
					out.write("<font color='red'> u have not specified ur email");
				else
					out.write("<font color='blue'>"+email+"</font>");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}
	
}
