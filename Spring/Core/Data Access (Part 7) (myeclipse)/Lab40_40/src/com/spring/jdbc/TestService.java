package com.spring.jdbc;

import java.sql.*;
import javax.sql.*;
import javax.annotation.*;

public class TestService {

	@Resource(name="oracleDS")
	private DataSource oracleDS;
	
	@Resource(name="mysqlDS")
	private DataSource mysqlDS;
	
	public void showOracleInfo() {
		try{
			Connection oracon = oracleDS.getConnection();
			DatabaseMetaData oradbmd = oracon.getMetaData();
			System.out.println(oradbmd.getDatabaseProductName());
			System.out.println(oradbmd.getDefaultTransactionIsolation());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showMySqlInfo() {
		try{
			Connection mycon = mysqlDS.getConnection();
			DatabaseMetaData oradbmd = mycon.getMetaData();
			System.out.println(oradbmd.getDatabaseProductName());
			System.out.println(oradbmd.getDefaultTransactionIsolation());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
