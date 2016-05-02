package com.jlcindia.junit4;

import java.util.Arrays;
import java.util.Collection;

public class TestData {
	public static Collection getData(){
		Object obj[][] = {{30,10,10}, {300,200,100}, {90,20,20}};
		return Arrays.asList(obj);
	}
}
