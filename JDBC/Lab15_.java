package jdbc;
import java.sql.*;
import java.util.*;
import jdbc.JDBCUtil;

public class Lab15_ {
	public static void main(String[] args) {
		Connection con = null;
		CallableStatement cs = null;
		try{
			Scanner sc = new Scanner(System.in);
			System.out.println("enter id");
			int id = sc.nextInt();
			con = JDBCUtil.getMySqlConnection();
			String sql = "{call p1(?,?,?,?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, id);
			cs.registerOutParameter(2, Types.INTEGER);
			cs.registerOutParameter(3, Types.INTEGER);
			cs.registerOutParameter(4, Types.INTEGER);
			cs.registerOutParameter(5, Types.INTEGER);
			
			int x = cs.executeUpdate();
			int a = cs.getInt(2);
			int b = cs.getInt(3);
			int sum = cs.getInt(4);
			int sub = cs.getInt(5);
			
			System.out.println(a+"\t"+b+"\t"+sum+"\t"+sub);
			System.out.println(x);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(cs, con);
		}
	}
}
