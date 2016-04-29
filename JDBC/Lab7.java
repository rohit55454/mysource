package jdbc;
import java.sql.*;
import jdbc.JDBCUtil;

public class Lab7 {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet re = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			String sql= "select * from jlcstudents";
			st = con.createStatement();
			re = st.executeQuery(sql);
			if(re.next()){
				do{
					int id = re.getInt(1);
					String nm = re.getString(2);
					String em = re.getString(3);
					long ph = re.getLong(4);
					System.out.println(id+"\t"+nm+"\t"+em+"\t"+ph);
				}while(re.next());
			}else
				System.out.println("record not found");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(re, st, con);
		}
	}
}
