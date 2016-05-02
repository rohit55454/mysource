package com.jlcindia.jboss;

import java.sql.*;
import javax.sql.*;
import com.jlcindia.jboss.DataSourceUtil;

public class DSLab {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;
		try{
			DataSource ds = DataSourceUtil.getDataSource();
			con = ds.getConnection();
			String sql = "select * from jlcstudents";
			ps = con.prepareStatement(sql);
			re = ps.executeQuery();
			while(re.next()){
				int id = re.getInt(1);
				String sn = re.getString(2);
				String em = re.getString(3);
				long ph = re.getLong(4);
				System.out.println(id+"\t"+sn+"\t"+em+"\t"+ph);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataSourceUtil.cleanup(re, con, ps);
		}
	}
}
