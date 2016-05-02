package com.jlcindia.spring;

import com.jlcindia.spring.DataSource;
import javax.annotation.Resource;

public class TestBean {
	@Resource(name="oracleDS")
	DataSource oracleDS;
	
	@Resource(name="mysqlDS")
	DataSource mysqlDS;
	
	public void show(){
		System.out.println(oracleDS);
		System.out.println(mysqlDS);
	}
}
