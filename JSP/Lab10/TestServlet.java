package com.jlc.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jlc.beans.*;

public class TestServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession sess = req.getSession();
		ServletContext ctx = sess.getServletContext();
		
	// 1. String, Wrappers and Date
		req.setAttribute("EM", "sri@jlc");
		sess.setAttribute("PH", new Long(123456));
		ctx.setAttribute("DOB", new Date());
		
	// 2. Collection of String, Wrappers and Date
		ArrayList<Integer> al = new ArrayList<>();
		al.add(new Integer(11));
		al.add(new Integer(22));
		al.add(new Integer(33));
		al.add(new Integer(44));
		al.add(new Integer(55));
		req.setAttribute("AL", al);
		
		String str[] = {"dd", "ss", "jlc", "sri"};
		sess.setAttribute("STR", str);
		
	// 3. Collection of Collections(*JSTL)
		ArrayList<ArrayList> aa = new ArrayList<ArrayList>();
		aa.add(al);
		aa.add(al);
		aa.add(al);
		req.setAttribute("AL1", aa);
		
	// 4. Custom or user Defined class Object
		Address add = new Address("asd", "KA");
		Account acc = new Account(101, "SA", 99999, add);
		Customer cust = new Customer(11, "custq", "cus@gmial", 987655555, acc);
		sess.setAttribute("CUST", cust);
		
	// 5. Collection of user Defined class Objects
		ArrayList<Customer> cs = new ArrayList<Customer>();
		cs.add(cust);
		cs.add(cust);
		cs.add(cust);
		cs.add(cust);
		cs.add(cust);
		sess.setAttribute("CS", cs);
		
	// 6. map object
		HashMap<String, String> hm = new HashMap<>();
		hm.put("sid", "11");
		hm.put("sname", "myname");
		hm.put("email", "myemail@gmail.com");
		sess.setAttribute("HM", hm);
		
	// 7. Collection of map objects
		ArrayList<HashMap<String, String>> all = new ArrayList<HashMap<String,String>>();
		all.add(hm);
		all.add(hm);
		all.add(hm);
		all.add(hm);
		req.setAttribute("AL2", all);
		
		RequestDispatcher rd = req.getRequestDispatcher("show.jsp");
		rd.forward(req, res);
	}
}
