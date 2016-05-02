package com.spring.transaction.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class JpaAccountDAO implements AccountDAO{

	@Autowired
	JpaTemplate jtemp = null;
	
	@Autowired
	JpaTransactionManager txMgr = null;
	
	@Override
	public void deposit(int accno, double amt) {
		TransactionDefinition txDef = new DefaultTransactionDefinition();
		TransactionStatus ts = txMgr.getTransaction(txDef);
		Account acc = jtemp.getReference(Account.class, accno);
		acc.setBal(acc.getBal()+amt);
		jtemp.merge(acc);
		txMgr.commit(ts);
	}

	@Override
	public void withdraw(int accno, double amt) {
		TransactionDefinition txDef = new DefaultTransactionDefinition();
		TransactionStatus ts = txMgr.getTransaction(txDef);
		Account acc = jtemp.getReference(Account.class, accno);
		double cbal = acc.getBal();
		if(cbal >= 5000+amt){
			acc.setBal(cbal-amt);
			jtemp.merge(acc);
		}else {
			throw new InsufficientFundsException();
		}
		txMgr.commit(ts);
	}

	@Override
	public void fundsTransfer(int saccno, int daccno, double amt) {
		TransactionDefinition txDef = new DefaultTransactionDefinition();
		TransactionStatus ts = txMgr.getTransaction(txDef);
		
		try{
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

			txMgr.commit(ts);
		}catch (Exception e) {
			txMgr.rollback(ts);
			e.printStackTrace();
		}
		
		
	}

	@Override
	public double getBalance(int accno) {
		TransactionDefinition txDef = new DefaultTransactionDefinition();
		TransactionStatus ts = txMgr.getTransaction(txDef);
		Account acc = jtemp.getReference(Account.class, accno);
		double cbal = acc.getBal();
		txMgr.commit(ts);
		return cbal;
	}
	
	
}
