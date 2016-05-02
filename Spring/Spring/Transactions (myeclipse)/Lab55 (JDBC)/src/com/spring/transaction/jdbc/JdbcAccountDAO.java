package com.spring.transaction.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class JdbcAccountDAO implements AccountDAO{

	@Autowired
	JdbcTemplate jtemp = null;
	
	@Autowired
	DataSourceTransactionManager txMgr = null;
	
	
	public void deposit(int accno, double amt) {
		TransactionDefinition txDef = new DefaultTransactionDefinition();
		TransactionStatus ts = txMgr.getTransaction(txDef);
		String sql = "select bal from accounts where accno = ?";
		int x = jtemp.queryForInt(sql, accno);
		double cbal = new Integer(x).doubleValue();
		double nbal = cbal+amt;
		String sql1 = "update accounts set bal=? where accno=?";
		jtemp.update(sql1, nbal, accno);
		txMgr.commit(ts);
		
	}

	public void withdraw(int accno, double amt) {
		TransactionDefinition txDef = new DefaultTransactionDefinition();
		TransactionStatus ts = txMgr.getTransaction(txDef);
		String sql = "select bal from accounts where accno=?";
		int x = jtemp.queryForInt(sql, accno);
		double cbal = new Integer(x).doubleValue();
		if(cbal >= 5000+amt){
			double nbal = cbal-amt;
			String sql1 = "update accounts set bal=? where accno=?";
			jtemp.update(sql1, nbal, accno);
		}else {
			throw new InsufficientFundsException();
		}
		txMgr.commit(ts);
		
	}

	public void fundsTransfer(int saccno, int daccno, double amt) {
		TransactionDefinition txDef = new DefaultTransactionDefinition();
		TransactionStatus ts = txMgr.getTransaction(txDef);
		try{
			String sql1 = "select bal from accounts where accno=?";
			String sql2 = "update accounts set bal=? where accno=?";
			int y = jtemp.queryForInt(sql1, daccno);
			double dcbal = new Integer(y).doubleValue();
			System.out.println("before deposit : "+dcbal);
			double dnbal = dcbal+amt;
			jtemp.update(sql2, dnbal, daccno);
			y = jtemp.queryForInt(sql1, daccno);
			dcbal = new Integer(y).doubleValue();
			System.out.println("After Deposit : "+dcbal);
			
			int x = jtemp.queryForInt(sql1, saccno);
			double scbal = new Integer(x).doubleValue();
			if(scbal >= 5000+amt){
				double snbal = scbal - amt;
				jtemp.update(sql2, snbal, saccno);
			}else
				throw new InsufficientFundsException();
			
			txMgr.commit(ts);
		}catch(Exception e){
			txMgr.rollback(ts);
			e.printStackTrace();
		}
		
	}

	public double getBalance(int accno) {
		String sql = "select bal from accounts where accno=?";
		int x = jtemp.queryForInt(sql, accno);
		double cbal = new Integer(x).doubleValue();
		
		return cbal;
	}

	
}
