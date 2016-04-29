package bookServ;

import java.sql.*;

public class Lab33 {
	public static void main(String[] args) {
		Connection con = null;
		ResultSet re = null;
		
		try{
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE");
			DatabaseMetaData md = con.getMetaData();
			re = md.getSchemas("TABLE_CAT", "SYS%");
			
			System.out.println("---- SCHEMA ------");
			while(re.next())
				System.out.println(re.getString(1));
			
		}catch(SQLException e){
			for(Throwable ex : e)
				e.printStackTrace();
		}finally {
			try{
				if(re!=null)	re.close();
				if(con!=null)	con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
