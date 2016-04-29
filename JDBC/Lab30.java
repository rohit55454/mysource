package bookServ;

import java.io.*;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import jdbc.JDBCUtil;

public class Lab30 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter file name with path");
		String fileName = sc.nextLine();
		String absPath = fileName;
		StringTokenizer tk = new StringTokenizer(fileName, "\\");
		while(tk.hasMoreTokens())
			fileName = tk.nextToken();
		
		Connection con = null;
		PreparedStatement ps = null;
		FileInputStream fis = null;
		
		try{
			con = JDBCUtil.getMySqlConnection();
			String sql = "insert into datatable(name, data) values(?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, fileName);
			File image = new File(absPath);
			fis = new FileInputStream(image);
			ps.setBinaryStream(2, fis, (int)image.length());
			ps.execute();
			System.out.println("inserted");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(ps, con);
			if(fis != null)	
				try{
					fis.close();
				}catch (Exception e2) {
					e2.printStackTrace();
				}
		}
		
	}
}
//		/home/rohit/Pictures/vlcsnap-2015-11-06-02h17m30s1.png

