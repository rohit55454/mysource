package com.jlc.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class JlcForTag extends TagSupport{
	private int var;
	private int i;
	public void setvar(int var){
		this.var = var;
	}
	public int doStartTag() throws JspException{
		int i=0;
		if(i<var)
			return EVAL_BODY_INCLUDE;
		else
			return SKIP_BODY;
	}

	public int doAfterBody() throws JspException{
		i++;
		if(i<var)
			return EVAL_BODY_INCLUDE;
		else
			return SKIP_BODY;
	}
}