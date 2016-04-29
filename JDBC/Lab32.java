package bookServ;

import java.sql.*;

import jdbc.JDBCUtil;
import oracle.jdbc.pool.OracleDataSource;

public class Lab32 {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet re = null;
		OracleDataSource ods = null;
		
		try{
			ods = new OracleDataSource();
			ods.setURL("system");
			ods.setPassword("toor");
			ods.setURL("jdbc:oracle:thin:@localhost:1521:XE");
			con = ods.getConnection();
			st = con.createStatement();
			re = st.executeQuery("select * from jlcstudents");
			
			if(re.next()){
				do{
					int id = re.getInt("sid");
					String nm = re.getString("sname");
					System.out.println(id+"\t"+nm);
				}while(re.next());
			}else
				System.out.println("no record found");
		}catch(SQLException e){
			for(Throwable ex :e)
				e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(re, st, con);
		}
	}
}
