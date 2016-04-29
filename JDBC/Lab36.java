package bookServ;

import javax.sql.*;
import javax.sql.rowset.*;

public class Lab36 {
	public static void main(String[] args) {
		try{
			RowSetFactory fac = RowSetProvider.newFactory();
			RowSet re = fac.createCachedRowSet();
			re.setUrl("jdbc:mysql://localhost:3306/jlcdb");
			re.setUsername("root");
			re.setPassword("toor");
			re.setCommand("select id, name, email, phone from jlcstudents");
			re.execute();
			while (re.next()) {
				System.out.println(re.getInt(1)+"\t"+re.getString(2)+"\t"+re.getString(3)+"\t"+re.getLong(4));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
