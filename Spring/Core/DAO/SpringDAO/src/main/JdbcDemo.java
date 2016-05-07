package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.JdbcDAOImpl;
import dao.SimpleJdbcDaoImpl;
import model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDAOImpl dao = ctx.getBean("abc", JdbcDAOImpl.class);
		
//		Circle circle = dao.getCircle(11111);
//		System.out.println(circle.getName());
		
//		System.out.println(dao.getCircleCount());
//		System.out.println(dao.getCircleName(11111));
//		System.out.println(dao.getCircleForId(11111));
		
//		System.out.println(dao.getAllCirclesForId(11111));
		System.out.println(dao.getAllCircles());
		
//		dao.insertCircle(new Circle(2222, "xxx"));
//		dao.createATable();
//		dao.insertCircleUsingNamedParams(new Circle(333, "qqq"));
//		System.out.println(dao.getAllCircles().size());
		
//		For SimpleJdbcDaoimpl only
//		SimpleJdbcDaoImpl sdao = ctx.getBean("simpleJdbcDaoImpl", SimpleJdbcDaoImpl.class);
//		System.out.println(sdao.getCircleCount());
		
	}
}
