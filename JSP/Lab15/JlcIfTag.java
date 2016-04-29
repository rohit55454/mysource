package com.jlc.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class JlcIfTag extends TagSupport{
	private String test;
	public void settest(String test){
		this.test = test;
	}
	public int doStartTag() throws JspException{
		boolean b1 = Boolean.parseBoolean(test);
		if(b1)
			return EVAL_BODY_INCLUDE;
		else
			return SKIP_BODY;
				
	}
}
