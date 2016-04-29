//		using type 4

package labs;

import java.sql.*;

public class Lab1Oracle {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try{
			//STEP 1: LOAD THE Driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//STEP 2: Establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "toor");
			//STEP 3: Prepare the sql statement
			String sql = "insert into jlcstudents values(99, 'sri', 'sri@jlc.com', 9865327845)";
			//STEP 4: create a JDBC Statement
			st = con.createStatement();
			//STEP 5: submit the sql statement to database using JDBC statement
			int x = st.executeUpdate(sql);
			//STEP 6: process the result
			if(x==1){
				System.out.println("record inserted");
			}else{
				System.out.println("record not inserted");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			//STEP 7: close all resources
			try{
				if(st != null)	st.close();
				if(con != null)	con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}