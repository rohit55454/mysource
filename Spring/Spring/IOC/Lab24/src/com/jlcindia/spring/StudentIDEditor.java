package com.jlcindia.spring;

import java.beans.PropertyEditorSupport;

public class StudentIDEditor extends PropertyEditorSupport{
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String p1 = text.substring(0, 3);
		String p2 = text.substring(4);
		StudentID sid = new StudentID(Integer.parseInt(p2), p1);
		this.setValue(sid);
	}
	
}
