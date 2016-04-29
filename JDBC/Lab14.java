package jdbc;

import java.sql.*;
import java.util.*;
import jdbc.JDBCUtil;

public class Lab14 {
	public static void main(String[] args) {
		Connection con = null;
		CallableStatement cs = null;
		try{
			Scanner sc = new Scanner(System.in);
			System.out.println("enter sid : ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("enter name : ");
			String nm = sc.nextLine();
			System.out.println("enter fee");
			float fee = sc.nextFloat();
			con = JDBCUtil.getMySqlConnection();
			cs = con.prepareCall("call insertstudentinfo(?, ?, ?)");
			cs.setInt(1, id);
			cs.setString(2, nm);
			cs.setFloat(3, fee);
			cs.execute();
			System.out.println("called successfully");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(cs, con);
		}
	}
}
