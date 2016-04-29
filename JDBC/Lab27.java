package bookServ;

import java.sql.*;
import jdbc.JDBCUtil;

public class Lab27 {
	public static void main(String[] args) {
		Account acc = new Account();
		acc.transfer(77, 88, 5000);
	}
}
class InsufficientFundsException extends Exception{
	InsufficientFundsException(){}
	public String toString(){
		return "Insufficient Funds";
	}
}
class InvalidAccountNumberException extends Exception{
	int accno;
	InvalidAccountNumberException(){}
	InvalidAccountNumberException(int accno){
		this.accno = accno;
	}
	public String toString(){
		return "AccNo : "+accno+" is not valid";
	}
}
class Account{
	int bal;
	int dabal, sabal, danbal, sanbal;
	public void transfer(int sa, int da, int amt){
		Connection con = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			//	********   STARTING TRANSACTION 	***********************
			con.setAutoCommit(false);
			//	********   OPERATION 1 CHECK DESTINATION ACCOUNT 	***********************			
			ps1 = con.prepareStatement("select bal from account where accno = ?");
			ps1.setInt(1, da);
			ResultSet r1 = ps1.executeQuery();
			if(r1.next())
				dabal = r1.getInt(1);
			else
				throw new InvalidAccountNumberException(da);

			danbal = dabal + amt;

			//	********   OPERATION 2 UPDATE DESTINATION ACCOUNT 	***********************				
			ps2 = con.prepareStatement("update account set bal=? where accno=?");
			ps2.setInt(1, danbal);
			ps2.setInt(2, da);
			ps2.executeUpdate();
			System.out.println("*****  "+da+" updated");


			//	********   OPERATION 3 CHECK source ACCOUNT 	***********************
			ps1.setInt(1, sa);
			r1 = ps1.executeQuery();
			if(r1.next())
				sabal = r1.getInt(1);
			else 
				throw new InvalidAccountNumberException();

			if(sabal >= amt)	sanbal = sabal-amt;
			else				throw new InsufficientFundsException();

			//	********   OPERATION 4 UPDATE SOURCE ACCOUNT 	***********************
			ps2.setInt(1, sanbal);
			ps2.setInt(2, sa);
			ps2.executeUpdate();
			con.commit();
			System.out.println("****" + sa + " updated");
			System.out.println("**********	fund transferred	*****************");

		}catch(Exception e){
			System.out.println(e);
			try{
				con.rollback();
			}catch(Exception e1){}
		}finally {
			JDBCUtil.cleanUp(ps1, con);
			JDBCUtil.cleanUp(ps2, con);
		}
	}	
}
