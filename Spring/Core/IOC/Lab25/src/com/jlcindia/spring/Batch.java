package com.jlcindia.spring;

public class Batch {
	String bid, sd, timings;
	int nos;
	
	public Batch(String bid, String sd, String timings, int nos) {
		super();
		this.bid = bid;
		this.sd = sd;
		this.timings = timings;
		this.nos = nos;
	}
	
	@Override
	public String toString() {
		String msg = "JLC Anno... new Batch";
		msg = msg + "\n batch id : " +bid;
		msg = msg + "\n Start Date : "+sd;
		msg = msg + "\n timings : "+timings;
		msg = msg + "\n no. of seats : "+nos;
		return msg;
	}
	
	
}
