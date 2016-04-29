package bookServ;

import java.io.*;
import javax.sql.*;

public class Lab26 {
	public static void main(String[] args) {
		try{
			System.out.println("deserializing cachedRowset");
			FileInputStream fis = new FileInputStream("/home/rohit/Desktop/java/tmp/rowset.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			RowSet re = (RowSet)ois.readObject();
			System.out.println("*******deserialized*****************");
			
			while(re.next())
				System.out.println(re.getInt(1)+"\t"+re.getString(2)+"\t"+re.getString(3)+"\t"+ re.getLong(4));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
