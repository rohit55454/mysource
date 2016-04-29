package jdbc;
import java.sql.*;
import java.util.*;
import jdbc.JDBCUtil;

public class Lab11 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			Scanner sc = new Scanner(System.in);
			System.out.println("enter id");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("enter name ");
			String nm = sc.nextLine();
			System.out.println("enter email");
			String em = sc.nextLine();
			System.out.println("enter phone");
			long ph = sc.nextLong();
			
			String sql= "insert into jlcstudents values(?,?,?,?)";
			ps  =con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, nm);
			ps.setString(3, em);
			ps.setLong(4, ph);
			int x = ps.executeUpdate();
			if(x==1)	System.out.println("record inserted successfully");
			else		System.out.println("no record inserted");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(ps, con);
		}
	}
}
