//	( SMTP Appender)

package com.log4j;
import org.apache.log4j.*;

public class Test {
	static{
		PropertyConfigurator.configure("src/jlc-log4j.properties");
	}
	static Logger log = Logger.getLogger("Log4jSMTPTest");
	
	public static void main(String[] args) {
		System.out.println("Started");
		log.error("This is a Test Mail");
		System.out.println("Main completed");
	}
}
