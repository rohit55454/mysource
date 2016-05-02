package com.spring.transaction.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTemplate;

public class JpaAccountDAO implements AccountDAO{

	@Autowired
	JpaTemplate jtemp = null;

	public void deposit(int accno, double amt) {
		Account acc = jtemp.getReference(Account.class, accno);
		acc.setBal(acc.getBal()+amt);
		jtemp.merge(acc);
	}

	public void withdraw(int accno, double amt) {
		Account acc = jtemp.getReference(Account.class, accno);
		double cbal = acc.getBal();
		if(cbal >= 5000+amt){
			acc.setBal(cbal-amt);
			jtemp.merge(acc);
		}else {
			throw new InsufficientFundsException();
		}
	}

	@Override
	public void fundsTransfer(int saccno, int daccno, double amt) {
		Account acc1 = jtemp.getReference(Account.class, daccno);
		acc1.setBal(acc1.getBal()+amt);
		jtemp.merge(acc1);

		Account acc2 = jtemp.getReference(Account.class, saccno);
		double scbal = acc2.getBal();

		if(scbal >= 5000+amt){
			acc2.setBal(acc2.getBal()-amt);
			jtemp.merge(acc2);
		}else{
			throw new InsufficientFundsException();
		}

	}

	@Override
	public double getBalance(int accno) {
		Account acc = jtemp.getReference(Account.class, accno);
		double cbal = acc.getBal();
		return cbal;
	}


}
