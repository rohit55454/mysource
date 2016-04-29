package labs;

import java.sql.*;

public class Lab5 {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet re = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jlcdb", "root", "toor");
			String sql = "select * from jlcstudents";
			st = con.createStatement();
			re = st.executeQuery(sql);
			
			if(re.next()){
				do{
					int sid = re.getInt(1);
					String sn = re.getString(2);
					String em = re.getString(3);
					long ph = re.getLong(4);
					System.out.println(sid+"\t"+sn+"\t"+em+"\t"+ph);
				}while(re.next());
			}
			else	System.out.println("record not found");
		}catch(Exception e){e.printStackTrace();}
		finally {
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