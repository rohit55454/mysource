package com.jlcindia.junit4;

import java.util.Arrays;
import java.util.Collection;

public class TestData {
	public static Collection getCustomerData(){
		Object obj[][] = {{10, "a@jlc"}, {20, "b@jlc"}};
		return Arrays.asList(obj);
	}
}
