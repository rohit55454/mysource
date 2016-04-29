package jdbc;
import java.sql.*;
import java.util.*;
import jdbc.JDBCUtil;

public class Lab9 {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet re = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			Scanner sc = new Scanner(System.in);
			System.out.println("enter id");
			int id = sc.nextInt();
			String sql = String.format("select * from jlcstudents where id = %d", id);
			st = con.createStatement();
			re = st.executeQuery(sql);
			
			if(re.next()){
				int sid = re.getInt(1);
				String nm = re.getString(2);
				String em = re.getString(3);
				long ph = re.getLong(4);
				System.out.println(sid+"\t"+nm+"\t"+em+"\t"+ph);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(re, st, con);
		}
	}
}
