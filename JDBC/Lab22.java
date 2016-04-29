package jdbc;
import java.sql.*;
import jdbc.JDBCUtil;

public class Lab22 {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet re = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			st = con.createStatement();
			re = st.executeQuery("select * from jlcstudents");
			ResultSetMetaData md = re.getMetaData();
			int cols = md.getColumnCount();
			System.out.println("cols : "+cols);
			
			for(int i=1; i<=cols; i++){
				String colnm = md.getColumnName(i);
				String colcls = md.getColumnClassName(i);
				String tabnm = md.getTableName(i);
				int size = md.getPrecision(i);
				
				System.out.println(colnm+"\t"+colcls+"\t"+tabnm+"\t"+size);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(re, st, con);
		}
	}
}
