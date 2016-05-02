//	( DOMConfigurator)

package com.log4j;

import org.apache.log4j.*;
import org.apache.log4j.xml.DOMConfigurator;
import org.w3c.dom.DOMConfiguration;

public class Test {
	static{
		DOMConfigurator.configure("src/log4j.xml");
	}
	static Logger log = Logger.getLogger("Log4jSMTPTest");
	
	public static void main(String[] args) {
		System.out.println("Started");
		log.error("This is a Test Mail");
		System.out.println("Main completed");
	}
}
