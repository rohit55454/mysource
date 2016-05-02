package com.spring.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcCustomerDAO extends JdbcDaoSupport implements CustomerDAO{

	@Override
	public void addCustomer(final CustomerTO cto) {
		CallableStatementCreator csc = new CallableStatementCreator() {
			
			@Override
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				CallableStatement cs = con.prepareCall("call addCustomer(?,?,?,?,?)");
				cs.setInt(1, cto.getCid());
				cs.setString(2, cto.getCname());
				cs.setString(3, cto.getEmail());
				cs.setLong(4, cto.getPhone());
				cs.setString(5, cto.getCity());
				return cs;
			}
		};
		
		SqlParameter charParam = new SqlParameter(Types.VARCHAR);
		SqlParameter longParam = new SqlParameter(Types.LONGNVARCHAR);
		
		List<SqlParameter> plist = new ArrayList<>();
		plist.add(charParam);
		plist.add(charParam);
		plist.add(charParam);
		plist.add(longParam);
		plist.add(charParam);
		
		getJdbcTemplate().call(csc, plist);
			
	}
				
}
