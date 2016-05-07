package com.spring.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcCustomerDAO implements CustomerDAO{

	@Autowired
	JdbcTemplate jdbcTemp;

	@Override
	public List<CustomerTO> getAllCustomers() {
		String sql = "select * from customers";
		List list = jdbcTemp.query(sql, new CustomerRowMapper());
		
		return list;
	}

	@Override
	public CustomerTO getCustomerByCid(int cid) {
		String sql = "select * from customers where cid=?";
		Object[] args = {cid};
		CustomerTO cto = (CustomerTO)jdbcTemp.queryForObject(sql, args, new CustomerRowMapper());
		
		return cto;
	}

	@Override
	public CustomerTO getCustomerByEmail(String email) {
		String sql = "select * from customers where email=?";
		Object[] args = {email};
		CustomerTO cto = (CustomerTO)jdbcTemp.queryForObject(sql, args, new CustomerRowMapper());
		
		return cto;
	}

	@Override
	public List<CustomerTO> getCustomerByCity(String city) {
		String sql = "select * from customers where city=?";
		Object[] args = {city};
		List list = jdbcTemp.query(sql, args, new CustomerRowMapper());
		
		return list;
	}

	@Override
	public int getCustomersCount() {
		String sql = "select count(*) from customers";
		return jdbcTemp.queryForInt(sql);
	}

	@Override
	public String getCustomerCityByEmail(String email) {
		String sql = "select city from customers where email=?";
		Object[] args = {email};
		String city = jdbcTemp.queryForObject(sql, args, String.class);
		
		return city;
	}

	@Override
	public Long getCustomerPhoneByEmail(String email) {
		String sql = "select phone from customers where email=?";
		Object[] args = {email};
	//	Long ph = (Long)jdbcTemp.queryForObject(sql, args, Long.class);
		long ph = jdbcTemp.queryForLong(sql, args);
		
		return ph;
	}
	


}
