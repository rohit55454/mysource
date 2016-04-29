package labs;

import java.sql.*;
public class Lab3Mysql {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet re = null;
		
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:jlcmydsn", "root", "toor");
			String sql = "select * from jlcstudents";
			st = con.createStatement();
			re = st.executeQuery(sql);
			
			while(re.next()){
				int sid = re.getInt(1);
				String sn = re.getString(2);
				String em = re.getString(3);
				long ph = re.getLong(4);
				System.out.println(sid+"\t"+sn+"\t"+em+"\t"+ph);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				if(re != null)	re.close();
				if(st != null)	st.close();
				if(con != null)	con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
