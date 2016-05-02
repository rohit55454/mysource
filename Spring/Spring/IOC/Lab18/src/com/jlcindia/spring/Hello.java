package com.jlcindia.spring;

import org.springframework.beans.factory.annotation.Required;

public class Hello {
	
	// @Required Annotation  (it is not for Fields)

	private A aobj;
	private B bobj;
	
/*
 *  The @Required annotation applies to bean property setter methods and it indicates
 *  that the affected bean property must be populated in XML configuration file at 
 *  configuration time otherwise the container throws a BeanInitializationException 
 *  exception.
*/
	
/*
 * Here inorder to run this Lab edit the xml file and change the bean name "ao" to "aobj"
 * and "bo" name to "bobj".
 */





	@Required		
	public void setAobj(A aobj) {
		System.out.println("Hello--setAobj()");
		this.aobj = aobj;
	}
	
	@Required
	public void setBobj(B bobj) {
		System.out.println("Hello--setBobj()");
		this.bobj = bobj;
	}

	public void show(){
		System.out.println(aobj);
		System.out.println(bobj);
	}
}
