package com.jlcindia.struts1;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.ValidatorUtil;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessages;

public class JLCFieldChecks {
	public void validateStudentId(Object bean, ValidatorAction va, Field field, ActionErrors errors, HttpServletRequest req){
		
		System.out.println("validateStudentID()-------");
		
		System.out.println(bean.getClass().getName());
		
		String pname = field.getProperty();
		System.out.println("***pname***"+pname);
		
		String value = ValidatorUtil.getValueAsString(bean, pname);
		System.out.println("***value***"+value);
		
		int min = Integer.parseInt(field.getVarValue("min"));
		System.out.println("***min***"+min);
		
		int max = Integer.parseInt(field.getVarValue("max"));
		System.out.println("***max***"+max);
		
		if(value == null || value.length()==0)
			errors.add(pname, new ActionError("errors.required"));
		
		else if( !value.startsWith("JLC-")){
			errors.add(pname, new ActionError("errors.sid.format1"));
		}
		
		else{
			String str = value.substring(4);
			try{
				int x = Integer.parseInt(str);
				if(x<min || x>max){
					errors.add(pname, new ActionError("errors.sid.format2"));
				}
			}catch(Exception e){
				errors.add(pname, new ActionError("errors.sid.format3"));
			}
		}
	}
	
	public void validateBatchId(Object bean, ValidatorAction va, Field field, ActionErrors errors, HttpServletRequest req){
		System.out.println("validateBAtchId()");
		System.out.println(bean.getClass().getName());
		
		String pname = field.getProperty();
		System.out.println(pname);
		
		String value = ValidatorUtil.getValueAsString(bean, pname);
		System.out.println(value);
		
		int min = Integer.parseInt(field.getVarValue("min"));
		System.out.println(min);
		
		int max = Integer.parseInt(field.getVarValue("max"));
		System.out.println(max);
		
		if(value == null || value.length()==0)
			errors.add(pname, new ActionError("errors.required"));
		
		else if( ! value.startsWith("B-"))
			errors.add(pname, new ActionError("errors.bid.format1"));
		
		else{
			String str = value.substring(2);
			try{
				int x = Integer.parseInt(str);
				if(x<min || x>max){
					errors.add(pname, new ActionError("errors.bid.format2"));
				}
			}catch(Exception e){
				errors.add(pname, new ActionError("errors.bid.format3"));
			}
		}
	
	}
}
