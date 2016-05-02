package com.jlcindia.junit3;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TestAll {
	public static Test suite(){
		TestSuite ts = new TestSuite();
		ts.addTestSuite(Arithmetic1Test.class);
		ts.addTestSuite(Arithmetic2Test.class);
		return ts;
	}
}
