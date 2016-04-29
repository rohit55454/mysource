package jdbc;
import java.sql.*;
import jdbc.JDBCUtil;

public class Lab6 {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			String sql = "insert into jlcstudents values(102, 'abc', 'abc@gmail.com', 9123456789)";
			st = con.createStatement();
			int x = st.executeUpdate(sql);
			if(x==1)	System.out.println("record inserted");
			else		System.out.println("record not inserted");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(st, con);
		}
	}
}
