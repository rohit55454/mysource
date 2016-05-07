package com.spring.transaction.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class JdbcAccountDAO implements AccountDAO{

	@Autowired
	JdbcTemplate jtemp = null;
	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.REPEATABLE_READ)
	
	
	public void deposit(int accno, double amt) {
		String sql = "select bal from accounts where accno=?";
		int x = jtemp.queryForInt(sql, accno);
		double cbal = new Integer(x).doubleValue();
		double nbal = cbal+amt;
		String sql1 = "update accounts set bal=? where accno=?";
		jtemp.update(sql1, nbal, accno);

	}

	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.REPEATABLE_READ)
	public void withdraw(int accno, double amt) {
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
		
	}

	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.REPEATABLE_READ)
	public void fundsTransfer(int saccno, int daccno, double amt) {
		String sql1 = "select bal from accounts where accno=?";
		String sql2 = "update accounts set bal=? where accno=?";
		int y = jtemp.queryForInt(sql1, daccno);
		double dcbal = new Integer(y).doubleValue();
		System.out.println("before deposit : "+dcbal);
		double dnbal = dcbal+amt;
		jtemp.update(sql2, dnbal, daccno);
		y = jtemp.queryForInt(sql1, daccno);
		dcbal = new Integer(y).doubleValue();
		System.out.println("after deposit : "+dcbal);
		
		int x = jtemp.queryForInt(sql1, saccno);
		double scbal = new Integer(x).doubleValue();
		if(scbal >= 5000+amt){
			double snbal = scbal-amt;
			jtemp.update(sql2, snbal, saccno);
		}else {
			throw new InsufficientFundsException();
		}
		
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.REPEATABLE_READ)
	public double getBalance(int accno) {
		String sql = "select bal from accounts where accno=?";
		int x = jtemp.queryForInt(sql, accno);
		double cbal = new Integer(x).doubleValue();
		
		return cbal;
	}

	
}
