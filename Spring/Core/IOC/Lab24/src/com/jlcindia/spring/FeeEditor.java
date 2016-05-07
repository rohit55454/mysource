package com.jlcindia.spring;

import java.beans.PropertyEditorSupport;

public class FeeEditor extends PropertyEditorSupport{
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String[] str = text.split(",");
		Fee fee = new Fee(Double.parseDouble(str[0]), Double.parseDouble(str[1]), Double.parseDouble(str[2]));
		this.setValue(fee);
	}
	
}
