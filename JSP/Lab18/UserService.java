package com.jlc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jlc.to.UserTo;
import com.jlc.util.JDBCUtil;

public class UserService {
	public int verifyUser(String un, String pw){
		int x = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;
		
		try{
			con = JDBCUtil.getMySqlConnection();
			String sql ="select * from jlcusers where username=? and password=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, un);
			ps.setString(2, pw);
			re = ps.executeQuery();
			if(re.next())
				x=1;
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.cleanup(re, ps, con);
		}
		return x;
	}
	
	public int registeruser(UserTo uo){
		int x = 0;
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			String sql = "insert into jlcusers values(?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, uo.getUserid());
			ps.setString(2, uo.getFname());
			ps.setString(3, uo.getEmail());
			ps.setLong(4, uo.getPhone());
			ps.setString(5, uo.getUsername());
			ps.setString(6, uo.getPassword());
			x = ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.cleanup(ps, con);
		}
		
		return x;
	}
	
	public String getPasswordByEmail(String em){
		String pw = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			String sql = "select password from jlcusers where email=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, em);
			re = ps.executeQuery();
			if(re.next())
				pw = re.getString(1);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.cleanup(ps, con);
		}
		
		return pw;
	}
	
	public int getNextUserId(){
		int x = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			String sql = "select max(userid) from jlcusers";
			ps = con.prepareStatement(sql);
			re = ps.executeQuery();
			
			if(re.next()){
				x = re.getInt(1);
				x = x+1;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.cleanup(ps, con);
		}
		return x;
	}
	
}
