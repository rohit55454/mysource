package dao;

import model.Circle;

public interface JdbcDAO {
	public Circle getCircle(int circleId);
}
