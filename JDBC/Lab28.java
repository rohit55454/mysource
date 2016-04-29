package bookServ;

import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import jdbc.JDBCUtil;

public class Lab28 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id");
		int id = sc.nextInt();
		System.out.println("enter date");
		int d = sc.nextInt();
		System.out.println("enter month");
		int m = sc.nextInt();
		System.out.println("enter year");
		int y = sc.nextInt();
		
		Date dt = new Date(y-1900, m-1, d);
		
		Connection con = null;
		Statement st = null;
		
		try{
			con = JDBCUtil.getMySqlConnection();
			DatabaseMetaData md = con.getMetaData();
			String db = md.getDatabaseProductName();
			String dop = "";
			System.out.println(db);
			if(db.equals("Oracle")){
				SimpleDateFormat f = new SimpleDateFormat("dd-mmm-yy");
				dop = f.format(dt);
			}else if(db.equals("MySql")){
				SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
				dop = f.format(dt);
			}
			
			st = con.createStatement();
			String sql = String.format("insert into datetest values(%d, '%s')", id, dop);
			
			System.out.println(sql);
			st.executeUpdate(sql);
			
			System.out.println("inserted");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(st, con);
		}
		
	}
}
