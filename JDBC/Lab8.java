package jdbc;
import java.sql.*;
import java.util.*;
import jdbc.JDBCUtil;

public class Lab8 {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			Scanner sc = new Scanner(System.in);
			System.out.println("enter id : ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("enter name : ");
			String nm = sc.nextLine();
			System.out.println("enter email ; ");
			String em = sc.nextLine();
			System.out.println("enter phone : ");
			long ph = sc.nextLong();
			
			String sql = String.format("insert into jlcstudents values(%d,'%s','%s',%d)", id, nm, em, ph);
			System.out.println(sql);
			
			st = con.createStatement();
			int x = st.executeUpdate(sql);
			if(x==1)		System.out.println("record inserted successfully");
			else			System.out.println("no record found");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(st, con);
		}
	}
}
