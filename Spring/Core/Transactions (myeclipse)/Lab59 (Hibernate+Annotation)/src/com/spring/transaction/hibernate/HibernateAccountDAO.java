package com.spring.transaction.hibernate;

import org.hibernate.LockMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class HibernateAccountDAO implements AccountDAO{

	@Autowired
	HibernateTemplate htemp = null;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, isolation=Isolation.REPEATABLE_READ)
	public void deposit(int accno, double amt) {

		Account acc = htemp.load(Account.class, accno, LockMode.READ);
		acc.setBal(acc.getBal()+amt);
		htemp.update(acc);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW, isolation=Isolation.REPEATABLE_READ)
	public void withdraw(int accno, double amt) {
		Account acc = htemp.load(Account.class, accno, LockMode.READ);
		double cbal = acc.getBal();
		if(cbal >= 5000+amt){
			acc.setBal(cbal-amt);
			htemp.update(acc);
		}else {
			throw new InsufficientFundsException();
		}
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW, isolation=Isolation.REPEATABLE_READ)
	public void fundsTransfer(int saccno, int daccno, double amt) {
			Account acc1 = htemp.load(Account.class, daccno, LockMode.READ);
			acc1.setBal(acc1.getBal()+amt);
			htemp.update(acc1);
			
			Account acc2 = htemp.load(Account.class, daccno, LockMode.READ);
			double scbal = acc2.getBal();
			if(scbal>=5000+amt){
				acc2.setBal(scbal-amt);
				htemp.update(acc2);
			}else {
				throw new InsufficientFundsException();
			}
	}

	public double getBalance(int accno) {
		System.out.println(htemp);
		Account acc = htemp.load(Account.class, accno, LockMode.READ);
		double cbal = acc.getBal();
		return cbal;
	}

	
}
