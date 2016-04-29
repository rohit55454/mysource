package com.hibernate;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab29D {
	public static void main(String[] args) {
		Transaction tx = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			Customer cust = (Customer)session.load(Customer.class, 1);
			System.out.println("******* Customers info *******");
			System.out.println(cust.getCid()+"\t"+cust.getCname()+"\t"+cust.getEmail()+"\t"+cust.getPhone());
			
			System.out.println("Orders info");
			Set<Order> ods = cust.getOrders();
			for(Order o : ods){
				System.out.println(o.getOrderId()+"\t"+o.getStatus()+"\t"+o.getTotalCost()+"\t"+o.getOrderDate()+"\t"+o.getTotalQty());
				ShippingAddress add = o.getAddress();
				System.out.println(add.getCity()+"\t"+add.getState()+"\t"+add.getStreet());
				
				Set<OrderItem> ois = o.getOrderitems();
				for(OrderItem oi : ois)
					System.out.println(oi.getCost()+"\t"+oi.getOid()+"\t"+oi.getQty());
			}
			tx.commit();
			session.close();
		}catch (Exception e) {
			e.printStackTrace();
			if(tx != null)	tx.rollback();
		}
	}
}
