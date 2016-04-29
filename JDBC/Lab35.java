package bookServ;

import java.sql.*;

public class Lab35 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jlcdb";
		String uname = "root";
		String pwd = "toor";
		try(Connection con = DriverManager.getConnection(url, uname, pwd);
				Statement st = con.createStatement();
				ResultSet re = st.executeQuery("select * from jlcstudents");){
			while(re.next())
				System.out.println(re.getInt(1)+"\t"+re.getString(2));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
