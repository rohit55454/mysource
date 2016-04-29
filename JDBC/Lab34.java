package bookServ;

import java.sql.*;
import jdbc.JDBCUtil;

public class Lab34 {
	public static void main(String[] args) {
		Connection con = null;
		ResultSet re = null;
		Statement st = null;
		
		try{
			con = JDBCUtil.getMySqlConnection();
			DatabaseMetaData md = con.getMetaData();
			System.out.println(RowIdLifetime.ROWID_UNSUPPORTED);
			System.out.println(RowIdLifetime.ROWID_VALID_FOREVER);
			System.out.println(RowIdLifetime.ROWID_VALID_SESSION);
			System.out.println(RowIdLifetime.ROWID_VALID_TRANSACTION);
			System.out.println("\n rowid lifetime");
			
			System.out.println(md.getRowIdLifetime());
			st = con.createStatement();
			re = st.executeQuery("select rowid, id, name, from jlcstudents");
			
			while(re.next()){
				RowId id = re.getRowId("rowid");
				String rowid = new String(id.getBytes());
				System.out.println(rowid+"\t"+re.getInt(2)+"\t"+re.getString(3));
			}
			
		}catch(SQLException e){
			for(Throwable ex : e)
				e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(re, st, con);
		}
	}
}
