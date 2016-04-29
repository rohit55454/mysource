package jdbc;
import java.sql.*;
import jdbc.JDBCUtil;

public class Lab21 {
	public static void main(String[] args) throws SQLException {
		Connection con = JDBCUtil.getMySqlConnection();
		DatabaseMetaData md = con.getMetaData();
		System.out.println("URL : "+md.getURL());
		System.out.println("USER : "+md.getUserName());
		System.out.println("major version :"+md.getDatabaseMajorVersion());
		System.out.println("minor version :"+md.getDatabaseMinorVersion());
		System.out.println("full outer join : "+md.supportsFullOuterJoins());
		System.out.println("full join : "+md.supportsOuterJoins());
		
		System.out.println("product name : "+md.getDatabaseProductName());
		System.out.println("muti rs : "+md.supportsMultipleOpenResults());
		
		System.out.println("db : "+md.getDatabaseProductName());
		
	}
}
