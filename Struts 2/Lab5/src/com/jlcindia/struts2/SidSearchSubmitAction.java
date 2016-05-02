package com.jlcindia.struts2;

import java.rmi.StubNotFoundException;

import com.opensymphony.xwork2.ActionSupport;

public class SidSearchSubmitAction extends ActionSupport{
	private String sid;
	private StudentTO sto;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public StudentTO getSto() {
		return sto;
	}
	public void setSto(StudentTO sto) {
		this.sto = sto;
	}
	
	@Override
	public void validate() {
		System.out.println("SidSearchSubmitAction--validate()");
		
		if(sid==null || sid.length()==0)
			addFieldError("sid", getText("errors.sid.required"));
		else if(!sid.startsWith("JLC-"))
			addFieldError("sid", getText("errors.sid.format1"));
		else{
			String p2 = sid.substring(4);
			try{
				int x = Integer.parseInt(p2);
				if(x<100 || x>999)
					addFieldError("sid", getText("errors.sid.format2"));
			}catch(Exception e){
				addFieldError("sid", getText("errors.sid.format3"));
			}
		}
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("SidSearchSubmitAction--execute()");
		System.out.println(sid);
		if(sid.equals("JLC-123")){
			sto = new StudentTO();
			sto.setSid(sid);
			sto.setBid("B-99");
			sto.setSname("asd");
			sto.setEmail("a@b.com");
			sto.setPhone("124656");
		}
		else{
			throw new StubNotFoundException(sid);
		}
		return "success";
	}
	
}
