package com.jlc.tag;

import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class UpperTag extends BodyTagSupport{
	public int doStartTag() throws JspException{
		return EVAL_BODY_BUFFERED;
	}
	
	@Override
	public int doEndTag() throws JspException {
		String str = getBodyContent().getString();
		try{
			Writer out = pageContext.getOut();
			out.write(str.toUpperCase());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
}
