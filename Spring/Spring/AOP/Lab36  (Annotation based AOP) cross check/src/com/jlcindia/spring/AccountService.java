package com.jlcindia.spring;

public class AccountService {
	public void getBal(){
		System.out.println("getBal--begin");
		System.out.println("getBal--done");
		System.out.println("getBal--end");
	}
	
	public void myDeposit(){
		System.out.println("Deposit--begin");
		System.out.println("Deposit--done");
		System.out.println("Deposit--end");
	}
	
	public void myWithdraw() throws Exception{
		System.out.println("withdraw---begin");
		if(1==1){
			throw new InsufficientFundsException();
		}
		System.out.println("withdraw---end");
	}
	
}
