package com.log4j;
import org.apache.log4j.Logger;

public class JlcOperator {
	Logger log = Logger.getLogger(this.getClass());
	public int getReminder(String ab, String bc){
		log.info("--- getReminder invoked ----");
		log.debug("Values : "+ab+"\t"+bc);
		int rem = -1;
		try{
			int val1 = Integer.parseInt(ab);
			log.debug("2nd int values : "+val1);
			int val2 = Integer.parseInt(bc);
			log.debug("2nd int values : "+val2);
			log.info("Calcilating Remainder");
		}catch (Exception e) {
			log.error("Exception Occered");
		}
		log.debug("Calculated Remainder : "+rem);
		log.info("returnung Remainder");
		return rem;
	}
}
