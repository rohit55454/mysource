package bookServ;

import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import jdbc.JDBCUtil;

public class Lab29 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id");
		int sid = sc.nextInt();
		System.out.println("enter date");
		int d = sc.nextInt();
		System.out.println("enter month");
		int m = sc.nextInt();
		System.out.println("enter year");
		int y = sc.nextInt();
		
		Date dt = new Date(y-1900, m-1, d);
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;
		
		try{
			con = JDBCUtil.getMySqlConnection();
			ps = con.prepareStatement("insert into datetest values(?, ?)");
			ps.setInt(1, sid);
			ps.setDate(2, dt);
			ps.executeUpdate();
			System.out.println("inserted");
			JDBCUtil.cleanUp(ps, null);
			ps = con.prepareStatement("select * from datetest");
			re = ps.executeQuery();
			while(re.next()){
				int id = re.getInt(1);
				Date dop = re.getDate(2);
				SimpleDateFormat f = new SimpleDateFormat("dd-mmm-yyyy");
				String d1 = f.format(dop);
				System.out.println(id+"\t"+d1);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(ps, con);
		}
		
	}
}


