package main;

import dao.JdbcDAOImpl;
import model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
		
		Circle circle = new JdbcDAOImpl().getCircle(11111);
		System.out.println(circle.getName());
		
	}
}
