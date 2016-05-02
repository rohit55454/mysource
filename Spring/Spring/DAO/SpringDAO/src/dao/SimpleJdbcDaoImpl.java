package dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class SimpleJdbcDaoImpl extends SimpleJdbcDaoSupport{

	public int getCircleCount() {
		String sql = "select count(*) from jdbcdao";
		return this.getJdbcTemplate().queryForInt(sql);
	}

	
}
