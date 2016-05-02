import java.sql.*;

public class JdbcDemo {
	
	public static void main(String[] args) {

		Connection con = null;
		Statement st = null;
		
		try {
			//	STEP 1. Load Driver class
			Class.forName("com.mysql.jdbc.Driver");
			//	2. get the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/daodb", "root", "toor");
			//	3. prepare sql statement
			String sql1 = "create table jdbcdao1(id int(5), name varchar(10))";
			String sql2 = "insert into jdbcdao values(11111, 'abc')";
			String sql3 = "CREATE TABLE REGISTRATION " +
	                   "(id INTEGER not NULL, " +
	                   " first VARCHAR(255), " + 
	                   " last VARCHAR(255), " + 
	                   " age INTEGER, " + 
	                   " PRIMARY KEY ( id ))"; 
			//	4. create JDBC Statement
			st = con.createStatement();
			//	5. submit the sql
			int x = st.executeUpdate(sql1);
			//	6. process the result
			if(x==1)	System.out.println("success");
			else		System.out.println("failed");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//	7. close all resources
				try {
					if(con!=null)	con.close();
					if(st!=null)	st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}
		
	}
	
}
