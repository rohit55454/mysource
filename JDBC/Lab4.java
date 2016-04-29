package labs;

import java.sql.*;
public class Lab4 {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jlcdb", "root", "toor");
			String query = "insert into jlcstudents values(77, 'nivas', 'nivas@jlc.com', 9865327845)";
			st = con.createStatement();
			
			int x = st.executeUpdate(query);
			if(x==1)	System.out.println("record inserted");
			else		System.out.println("record not inserted");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				if(st != null)	st.close();
				if(con != null)	con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
