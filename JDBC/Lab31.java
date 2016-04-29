package bookServ;

import java.io.*;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import jdbc.JDBCUtil;

public class Lab31 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter file name");
		String fileName = sc.nextLine();
		
		Connection con = null;
		PreparedStatement ps = null;
		FileOutputStream fos = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			String sql = "select name, data from datatable where name=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, fileName);
			ResultSet re = ps.executeQuery();
			
			while(re.next()){
				File image = new File("/home/rohit/Pictures"+fileName);
				fos = new FileOutputStream(image);
				byte[] buffer = new byte[1];
				InputStream is = re.getBinaryStream(2);
				while(is.read(buffer)>0)
					fos.write(buffer);
			}
			System.out.println("file accessed in given location\n"+fileName);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(ps, con);
			if(fos != null)
				try{
					fos.close();
				}catch (IOException e2) {
					e2.printStackTrace();
				}
		}
		
	}
}
