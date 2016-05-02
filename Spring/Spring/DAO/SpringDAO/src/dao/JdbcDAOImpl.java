package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import model.Circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component(value="abc")		//	if we do not give the value attribute then by Default it will take the class name with first letter small.
public class JdbcDAOImpl /* implements JdbcDAO */{

	@Autowired
	private DataSource dataSource;

	JdbcTemplate jtmp = new JdbcTemplate();		//	initializing JdbcTemplate here is not good practice

	NamedParameterJdbcTemplate nptmp ;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
//		this.dataSource = (DataSource) new JdbcTemplate(dataSource);	//	initializing JdbcTemplate here is good practice
//		this.nptmp = new NamedParameterJdbcTemplate(dataSource);
	}


	public JdbcTemplate getJtmp() {
		return jtmp;
	}

	public void setJtmp(JdbcTemplate jtmp) {
		this.jtmp = jtmp;
	}

	/*	
	@Override
	public Circle getCircle(int circleId) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Circle circle = null;
		try {
			con = dataSource.getConnection();

			ps = con.prepareStatement("select * from jdbcdao where id=?");
			ps.setInt(1, circleId);

			rs = ps.executeQuery();
			if(rs.next())
				circle = new Circle(circleId, rs.getString("name"));

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

	 */	

	///////////		USING JdbcTemplate		/////////////////////////	
	public int getCircleCount() {
		jtmp.setDataSource(getDataSource());
		return jtmp.queryForInt("select count(*) from jdbcdao");
	}

	public String getCircleName(int circleId){
		jtmp.setDataSource(getDataSource());
		return jtmp.queryForObject("select name from jdbcdao where id=?", new Object[]{circleId}, String.class);
		//	we can not use * in select statement (causes IncorrectResultSetColumnCountException)
		//	so use RowMapper instead.
		//	works only when exactly one row returns.
		//	Data access exception thrown when a result was not of the expected size, for example when expecting a single row but getting 0 or more than 1 rows.
	}

	public Circle getCircleForId(int circleId){
		jtmp.setDataSource(getDataSource());
		return jtmp.queryForObject("select * from jdbcdao where id=?", new Object[]{circleId}, new CircleMapper()); 
		//	works only when exactly one row returns.
		//	Data access exception thrown when a result was not of the expected size, for example when expecting a single row but getting 0 or more than 1 rows.
	}

	public List<Circle> getAllCirclesForId(int circleId){
		jtmp.setDataSource(getDataSource());
		return jtmp.query("select * from jdbcdao where id=?",new Object[]{circleId}, new CircleMapper()); 
	}

	public List<Circle> getAllCircles(){
		jtmp.setDataSource(getDataSource());
		List list = jtmp.query("select * from jdbcdao", new CircleMapper());
		return list; 
	}

	private static final class CircleMapper implements RowMapper<Circle>{

		@Override
		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
			Circle circle = new Circle();
			circle.setId(rs.getInt("id"));
			circle.setName(rs.getString("name"));
			return circle;
		}

	}
	

	public void insertCircle(Circle circle){
		jtmp.setDataSource(getDataSource());
		jtmp.update("insert into jdbcdao values(? , ?)", new Object[]{circle.getId(), circle.getName()});
	}

	public void createATable(){
		jtmp.setDataSource(getDataSource());
		jtmp.execute("create table triangle (id int, name varchar(10))");
	}
	
	public void insertCircleUsingNamedParams(Circle circle){
		String sql = "insert into jdbcdao values(? , ?)";
		SqlParameterSource npm = new MapSqlParameterSource("id", circle.getId()).addValue("name", circle.getName());

		nptmp.update(sql, npm);
	}
	
}
