package jdbc;
import java.sql.*;
import jdbc.JDBCUtil;
import oracle.jdbc.*;

public class Lab16 {
	public static void main(String[] args) {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet re = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			cs = con.prepareCall("call getAllStudents");
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			
			re = (ResultSet)cs.getObject(1);
			if(re.next()){
				do{
					int id = re.getInt(1);
					String nm = re.getString(2);
					float fee = re.getFloat(3);
					System.out.println(id+"\t"+nm+"\t"+fee);
				}while(re.next());
			}else		System.out.println("no record found");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(re, cs, con);
		}
	}
}
