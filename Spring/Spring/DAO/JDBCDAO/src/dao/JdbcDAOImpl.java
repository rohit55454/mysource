package dao;

import java.sql.*;

import model.Circle;

public class JdbcDAOImpl implements JdbcDAO{

	@Override
	public Circle getCircle(int circleId) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Circle circle = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/daodb", "root", "toor");
			
			ps = con.prepareStatement("select * from jdbcdao where id=?");
			ps.setInt(1, circleId);
			
			rs = ps.executeQuery();
			if(rs.next())
				circle = new Circle(circleId, rs.getString("name"));
				System.out.println("**********************");
				System.out.println(rs.next());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
				try {
					if(con!=null)	con.close();
					if(ps!=null)	ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}
		
		return circle;
	}
	
}
