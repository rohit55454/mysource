package com.spring.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class JdbcCustomerDAO implements CustomerDAO{

	@Autowired
	SimpleJdbcTemplate sjdbcTemp;

	@Override
	public List<CustomerTO> getAllCustomers() {
		String sql = "select * from customers";
		List<CustomerTO> list = sjdbcTemp.query(sql, new CustomerRowMapper());
		
		return list;
	}

	@Override
	public CustomerTO getCustomerByCid(int cid) {
		String sql = "select * from customers where cid=?";
		CustomerTO cto = (CustomerTO)sjdbcTemp.queryForObject(sql, new CustomerRowMapper(), cid);

		return cto;
	}

	@Override
	public CustomerTO getCustomerByEmail(String email) {
		String sql = "select * from customers where email=?";
		CustomerTO cto = (CustomerTO)sjdbcTemp.queryForObject(sql, new CustomerRowMapper(), email);
		return cto;
	}

	@Override
	public List<CustomerTO> getCustomerByCity(String city) {
		String sql = "select * from customers where city=?";
		List<CustomerTO> list = sjdbcTemp.query(sql, new CustomerRowMapper(), city);
		return list;
	}

	@Override
	public int getCustomersCount() {
		String sql = "select count(*) from customers";
		return sjdbcTemp.queryForInt(sql);
	}

	@Override
	public String getCustomerCityByEmail(String email) {
		String sql = "select city from customers where email=?";
		String city = (String)sjdbcTemp.queryForObject(sql, String.class, email);
		return city;
	}

	@Override
	public Long getCustomerPhoneByEmail(String email) {
		String sql = "select phone from customers where email=?";
		Long ph = (Long)sjdbcTemp.queryForObject(sql, Long.class, email);
		
		return ph;
	}
	
	
	

}
