package jdbc;
import java.sql.*;
import jdbc.JDBCUtil;

public class Lab17 {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			st = con.createStatement();
			String sql1 = "insert into jlcstudents values(99, 'sri', 'sri@jlc.com', 9999999999)";
			st.addBatch(sql1);
			String sql2 = "insert into jlcstudents values(99, 'sri', 'sri@jlc.com', 9999999999)";
			st.addBatch(sql2);
			String sql3 = "insert into jlcstudents values(99, 'sri', 'sri@jlc.com', 9999999999)";
			st.addBatch(sql3);
			String sql4 = "insert into jlcstudents values(99, 'sri', 'sri@jlc.com', 9999999999)";
			st.addBatch(sql4);
			String sql5 = "insert into jlcstudents values(99, 'sri', 'sri@jlc.com', 9999999999)";
			st.addBatch(sql5);
			String sql6 = "insert into jlcstudents values(99, 'sri', 'sri@jlc.com', 9999999999)";
			st.addBatch(sql6);
			
			int x[] = st.executeBatch();
			for(int i=0; i<x.length; i++)
				System.out.println(x[i]);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(st, con);
		}
		
	}
}
