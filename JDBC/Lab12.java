package jdbc;
import java.sql.*;
import java.util.*;
import jdbc.JDBCUtil;

public class Lab12 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			Scanner sc = new Scanner(System.in);
			System.out.println("enter sid");
			int id = sc.nextInt();
			String sql = "select * from jlcstudents where id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			re = ps.executeQuery();
			if(re.next()){
				int sid = re.getInt(1);
				String nm = re.getString(2);
				String em = re.getString(3);
				long ph = re.getLong(4);
				System.out.println(sid+"\t"+nm+"\t"+em+"\t"+ph);
			}else	System.out.println("record not found");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(re, ps, con);
		}
	}
}
