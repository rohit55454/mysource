package com.jlcindia.spring;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;
import java.util.List;

public class ListEditor extends PropertyEditorSupport{
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String str[] = text.split(",");
		List list = Arrays.asList(str);
		this.setValue(list);
	}
	
}
