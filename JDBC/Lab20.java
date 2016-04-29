package jdbc;
import java.sql.*;
import jdbc.JDBCUtil;

public class Lab20 {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet re = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			re = st.executeQuery("select * from jlcstudents");
			
			System.out.println("*******All records********");
			while (re.next()) 	
				System.out.println(re.getInt(1)+"\t"+re.getString(2)+"\t"+re.getString(3)+"\t"+re.getLong(4));
			
			System.out.println("inserting records");
			re.moveToInsertRow();
			re.updateInt(1, 9999);
			re.updateString(2, "dk");
			re.updateString(3, "dk@jlc.com");
			re.updateLong(4, 96333333333L);
			re.insertRow();
			System.out.println("record inserted");
			
			System.out.println("updating records");
			re.absolute(2);
			re.updateInt(1, 9990);
			re.updateString(2, "dkml");
			re.updateString(3, "dkml@jlc.com");
			re.updateLong(4, 9633333333L);
			re.updateRow();
			System.out.println("record updated");
			
			System.out.println("deleting 3rd record");
			re.absolute(3);
			re.deleteRow();
			System.out.println("row deleted");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(re, st, con);
		}
	}
}
