//	Using basic Configurator(Default ConsoleAppender & Pattern Layout)

package com.log4j;
import org.apache.log4j.*;

public class Test {
	static{
		Layout lay = new PatternLayout("'%d' '%C' '%p' '%c' '%M' '%m' '%l' '%n'");
		Appender app = null;
		try{
			app = new ConsoleAppender(lay);
			BasicConfigurator.configure(app);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	static Logger log = Logger.getLogger("Test");
	
	public static void main(String[] args) {
		Logger root = Logger.getRootLogger();
		root.setLevel(Level.DEBUG);
		log.info("--- main Method started ----");
		log.debug("Values as CLA : "+args.length);
		for(int i=0; i<2; i++){
			try{
				Thread.sleep(1000);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(args.length == 0){
			log.warn("No Command Line Argument Specified");
		}
		log.debug("1st value in main : "+args[0]);
		log.debug("2nd value in main : "+args[1]);
		log.info("creating JlcOperator Object");
		JlcOperator op = new JlcOperator();
		log.info("Invoking the get Reminder() from JlcOperator");
		int rem = op.getReminder(args[0], args[1]);
		System.out.println("Remainder in main : "+rem);
		log.info("--- main completed");
	}
}
