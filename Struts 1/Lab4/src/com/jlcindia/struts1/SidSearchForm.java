package com.jlcindia.struts1;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class SidSearchForm extends ActionForm{
	private String sid;

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}
	
	@Override
	public ActionErrors validate(ActionMapping am, HttpServletRequest req) {
		ActionErrors errors = new ActionErrors();
		if(sid == null || sid.length()==0)
			errors.add("sid", new ActionError("errors.sid.required"));
		else if(! sid.startsWith("jlc-"))
			errors.add("sid", new ActionError("errors.sid.format1"));
		else{
			String p = sid.substring(4);
			try{
				int x = Integer.parseInt(p);
				if(x<100 || x>999)
					errors.add("sid", new ActionError("errors.sid.format2"));
			}catch(Exception e){
				errors.add("sid", new ActionError("errors.sid.format3"));
			}
		}
		return errors;
	}
	
	@Override
	public void reset(ActionMapping am, HttpServletRequest req) {
		this.sid = null;
	}
}
