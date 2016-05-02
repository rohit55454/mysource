package com.jlcindia.spring;

public class TxService {
	public void begin(){
		System.out.println("TS---begin()..........");
	}
	
	public void commit(){
		System.out.println("TS---commit() called");
	}
	
	public void rollBack(){
		System.out.println("TS---rollback()........");
	}
}
