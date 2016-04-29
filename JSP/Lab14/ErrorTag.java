package com.jlc.tags;

import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ErrorTag extends TagSupport{
	private String property;
	public void setProperty(String property){
		this.property = property;
	}
	public int doEndTag() throws JspException{
		try{
			Object msg = pageContext.findAttribute(property);
			System.out.println(msg);
			if(msg!=null){
				Writer out = pageContext.getOut();
				out.write("<font color='red'>"+msg+"</font>");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}
}
