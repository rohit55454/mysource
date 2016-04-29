package bookServ;

import java.io.*;
import javax.sql.RowSet;
import com.sun.rowset.JdbcRowSetImpl;

public class Lab24 {
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			RowSet re = new JdbcRowSetImpl();
			re.setUrl("jdbc:mysql://localhost:3306/jlcdb");
			re.setUsername("root");
			re.setPassword("toor");
			re.setCommand("select id, name, email, phone from jlcstudents");
			re.execute();
			while (re.next()) {
				System.out.println(re.getInt(1)+"\t"+re.getString(2)+"\t"+re.getString(3)+"\t"+ re.getLong(4));
				re.absolute(2);
				re.updateString(2, "dande");
				re.updateString(3, "dande@jlc.com");
				re.updateLong(4, 999999999);
				re.updateRow();
				System.out.println("updated !!!!!!");
				
				re.beforeFirst();
				System.out.println("serializing jdbcrowset**************************");
				
		/*		String filename = "newFile.txt";
				String workingDirectory = System.getProperty("user.dir");
				String absoluteFilePath = workingDirectory + File.separator + filename;
				System.out.println(absoluteFilePath);
		*/		
				FileOutputStream fos = new FileOutputStream("/home/rohit/Desktop/java/tmp/rowset.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(re);
				System.out.println("serialized");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
