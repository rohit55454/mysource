package jdbc;

import java.sql.*;
import jdbc.JDBCUtil;

public class Lab19 {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet re = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			re = st.executeQuery("select * from jlcstudents");
			System.out.println("***forward direction****");
			
			while(re.next())
				System.out.println(re.getInt(1)+"\t"+re.getString(2)+"\t"+re.getString(3)+"\t"+re.getLong(4));
			System.out.println("******reverse direction*****");
			
			while(re.previous())
				System.out.println(re.getInt(1)+"\t"+re.getString(2)+"\t"+re.getString(3)+"\t"+re.getLong(4));
			
			System.out.println("1st record*********");
			re.first();
			System.out.println(re.getInt(1)+"\t"+re.getString(2)+"\t"+re.getString(3)+"\t"+re.getLong(4));
			
			System.out.println("last record *********");
			re.last();
			System.out.println(re.getInt(1)+"\t"+re.getString(2)+"\t"+re.getString(3)+"\t"+re.getLong(4));
			
			System.out.println("4th record");
			re.absolute(4);
			System.out.println(re.getInt(1)+"\t"+re.getString(2)+"\t"+re.getString(3)+"\t"+re.getLong(4));
			
			System.out.println("from 4th next 2 records");
			re.relative(2);
			System.out.println(re.getInt(1)+"\t"+re.getString(2)+"\t"+re.getString(3)+"\t"+re.getLong(4));
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(re, st, con);
		}
	}
}
