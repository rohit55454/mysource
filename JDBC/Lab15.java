package jdbc;
import java.sql.*;
import java.util.*;
import jdbc.JDBCUtil;

public class Lab15 {
	public static void main(String[] args) {
		Connection con = null;
		CallableStatement cs = null;
		try{
			Scanner sc = new Scanner(System.in);
			System.out.println("enter id");
			int id = sc.nextInt();
			System.out.println("enter installment");
			float ins = sc.nextFloat();
			
			con = JDBCUtil.getMySqlConnection();
			cs = con.prepareCall("call updateinfo(?,?,?)");
			cs.setInt(1, id);
			cs.setFloat(2, ins);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.FLOAT);
			cs.execute();
			String nm = cs.getString(2);
			float fee = cs.getFloat(3);
			System.out.println(nm+"\t"+fee);
			System.out.println("called successfully");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(cs, con);
		}
	}
}
