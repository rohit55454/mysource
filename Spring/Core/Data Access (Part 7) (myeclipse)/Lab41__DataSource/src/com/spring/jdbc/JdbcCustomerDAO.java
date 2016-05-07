package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcCustomerDAO implements CustomerDAO{
	
	private static final String driverClassName = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost/springdb";
	private static final String dbUsername = "root";
	private static final String dbPassword = "toor";

	DataSource ds = getDataSource();
	
//	@Autowired
	JdbcTemplate jdbcTemp = new JdbcTemplate(ds);
	
	public static DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(dbUsername);
		dataSource.setPassword(dbPassword);
		return dataSource;
	}
	
	@Override
	public void addCustomer(CustomerTO cto) {
		String sql = "insert into customers values(?,?,?,?,?)";
		Object[] args = {cto.getCid(), cto.getCname(), cto.getEmail(), cto.getPhone(), cto.getCity()};
		jdbcTemp.update(sql, args);
	}

	@Override
	public void updateCustomer(CustomerTO cto) {
		String sql = "update customers set cname=?, email=?, phone=?, city=? where cid=?";
		Object[] args = {cto.getCname(), cto.getEmail(), cto.getPhone(), cto.getCity(), cto.getCid()};
		jdbcTemp.update(sql, args);
	}

	@Override
	public void deleteCustomer(int cid) {
		String sql = "delete from customers where cid=?";
		Object[] args = {cid};
		jdbcTemp.update(sql, args);
	}
	
}
