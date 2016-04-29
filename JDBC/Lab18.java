package jdbc;
import java.sql.*;
import java.util.*;
import jdbc.JDBCUtil;

public class Lab18 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			String sql = "insert into jlcstudents(id, name) values (?, ?)";
			ps = con.prepareStatement(sql);
			Scanner sc = new Scanner(System.in);
			char choice = 'Y';
			do{
				System.out.println("enter name");
				String nm = sc.nextLine();
				System.out.println("enter id");
				int id = sc.nextInt();
				ps.setInt(1, id);
				ps.setString(2, nm);
				ps.addBatch();
				
				System.out.println("do u want to add more");
				sc.nextLine();
				choice = sc.nextLine().charAt(0);
			}while(choice == 'Y');
			
			int res[] = ps.executeBatch();
			for(int i=0; i<res.length; i++)
				System.out.println("res : "+res[i]);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(ps, con);
		}
	}
}
