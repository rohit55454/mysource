package com.jlc.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPALab2 {

	public static void main(String[] args) {
		EntityTransaction tx = null;
		
		try{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("JLCINDIA-PU");
			EntityManager manager = factory.createEntityManager();
			tx = manager.getTransaction();
			
			tx.begin();
			Customer cust = (Customer)manager.getReference(Customer.class, 1);
			System.out.println(cust.getCid()+"\t"+cust.getCname()+"\t"+cust.getEmail()+"\t"+cust.getPhone()+"\t"+cust.getCity());
			tx.commit();
			System.out.println("process completed ..... check database.......");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
