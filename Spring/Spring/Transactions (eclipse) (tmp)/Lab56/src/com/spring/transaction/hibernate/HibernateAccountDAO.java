package com.spring.transaction.hibernate;

import org.hibernate.LockMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class HibernateAccountDAO implements AccountDAO{

	@Autowired
	HibernateTemplate htemp = null;
	
	@Autowired
	HibernateTransactionManager txMgr = null;
	
	
	public void deposit(int accno, double amt) {
		TransactionDefinition txDef = new DefaultTransactionDefinition();
		TransactionStatus ts = txMgr.getTransaction(txDef);

		Account acc = htemp.load(Account.class, accno, LockMode.READ);
		acc.setBal(acc.getBal()+amt);
		htemp.update(acc);
		txMgr.commit(ts);
	}

	public void withdraw(int accno, double amt) {
		TransactionDefinition txDef = new DefaultTransactionDefinition();
		TransactionStatus ts = txMgr.getTransaction(txDef);
		
		Account acc = htemp.load(Account.class, accno, LockMode.READ);
		double cbal = acc.getBal();
		if(cbal >= 5000+amt){
			acc.setBal(cbal-amt);
			htemp.update(acc);
		}else {
			throw new InsufficientFundsException();
		}
		txMgr.commit(ts);
	}

	public void fundsTransfer(int saccno, int daccno, double amt) {
		TransactionDefinition txDef = new DefaultTransactionDefinition();
		TransactionStatus ts = txMgr.getTransaction(txDef);
		try{
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
			
			txMgr.commit(ts);
		}catch(Exception e){
			txMgr.rollback(ts);
			e.printStackTrace();
		}
		
	}

	public double getBalance(int accno) {
		System.out.println(htemp);
		Account acc = htemp.load(Account.class, accno, LockMode.READ);
		double cbal = acc.getBal();
		return cbal;
	}

	
}
