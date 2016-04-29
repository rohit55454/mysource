package bookServ;

import java.sql.*;
import java.util.*;
import jdbc.JDBCUtil;

public class BookService {
	
	public boolean verifyUser(String un, String pw){
		boolean valid = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			ps = con.prepareStatement("select * from users_table where username=? and password=?");
			ps.setString(1, un);
			ps.setString(2, pw);
			re = ps.executeQuery();
			
			if(re.next())	valid = true;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(re, ps, con);
		}
		return valid;
	}
	
	public int deleteBook(String bid){
		int x = 0;
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			ps = con.prepareStatement("delete from jlcbooks where bid = ?");
			ps.setString(1, bid);
			x = ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(ps, con);
		}
		return x;
	}
	public boolean addBook(Book bo){
		boolean added = false;
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			ps.getConnection().prepareStatement("insert into jlcbooks values(?,?,?,?,?,?)");
			ps.setString(1, getNewBookid());
			ps.setString(2, bo.getBname());
			ps.setString(3, bo.getAuthor());
			ps.setString(4, bo.getPublication());
			ps.setDouble(5, bo.getCost());
			ps.setInt(6, bo.getEdition());
			
			ps.executeUpdate();
			added = true;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(ps, con);
		}
		return added;
	}
	public int updateBook(Book bo){
		int x = 0;
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			ps = con.prepareStatement("update jlcbooks set bname=?, author=?, publication=?, cost=?, edition=? where bid = ?");
			
			ps.setString(1, getNewBookid());
			ps.setString(2, bo.getBname());
			ps.setString(3, bo.getAuthor());
			ps.setString(4, bo.getPublication());
			ps.setDouble(5, bo.getCost());
			ps.setInt(6, bo.getEdition());
			
			ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(ps, con);
		}
		return x;
	}
	public Book getBookByBid(String bid){
		Book bo = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			ps = con.prepareStatement("select * from jlcbooks where bid=?");
			ps.setString(1, bid);
			re = ps.executeQuery();
			if(re.next())	bo = getBookFromResultSet(re);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(re, ps, con);
		}
		return bo;
	}
	public List<Book> getBooksByName(String bname){
		List<Book> al = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			ps = con.prepareStatement("select * from jlcbooks where bname=?");
			ps.setString(1, bname);
			re = ps.executeQuery();
			while(re.next()){
				Book bo = getBookFromResultSet(re);
				al.add(bo);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(re, ps, con);
		}
		return al;
	}
	public List<Book> getBooksByAuthor(String author){
		List<Book> al = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			ps = con.prepareStatement("select * from jlcbooks where author=?");
			ps.setString(1, author);
			re = ps.executeQuery();
			while(re.next()){
				Book bo = getBookFromResultSet(re);
				al.add(bo);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(re, ps, con);
		}
		return al;
	}
	public List<Book> getBooksByCost(double cost){
		List<Book> al = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			ps = con.prepareStatement("select * from jlcbooks where cost=?");
			ps.setDouble(1, cost);
			re = ps.executeQuery();
			while (re.next()) {
				Book bo = getBookFromResultSet(re);
				al.add(bo);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(re, ps, con);
		}
		return al;
	}
	public List<Book> getAllBooks(){
		List<Book> al = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			ps = con.prepareStatement("select * from jlcbooks");
			re = ps.executeQuery();
			while (re.next()) {
				Book bo = getBookFromResultSet(re);
				al.add(bo);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(re, ps, con);
		}
		return al;
	}

	private Book getBookFromResultSet(ResultSet re) throws Exception{
		Book bo = new Book();
		bo.setBid(re.getString(1));
		bo.setBname(re.getString(2));
		bo.setAuthor(re.getString(3));
		bo.setPublication(re.getString(4));
		bo.setCost(re.getDouble(5));
		bo.setEdition(re.getInt(6));
		return bo;
	}

	private String getNewBookid() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;
		String bid = "B-01";
		try{
			con = JDBCUtil.getMySqlConnection();
			ps = con.prepareStatement("select max(bid) from jlcbooks");
			re = ps.executeQuery();
			if(re.next()){
				bid = re.getString(1);
				if(bid != null){
					String id = bid.substring(2);
					int x = Integer.parseInt(id);
					x++;
					if(x<10)
						bid = "B-0"+x;
					else
						bid = "B-0";
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(re, ps, con);
		}
		return bid;
	}
	
}
