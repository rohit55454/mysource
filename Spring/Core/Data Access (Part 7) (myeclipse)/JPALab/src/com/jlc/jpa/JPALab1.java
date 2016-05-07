package com.jlc.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPALab1 {

	public static void main(String[] args) {
		EntityTransaction tx = null;
		
		try{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("JLCINDIA-PU");
			EntityManager manager = factory.createEntityManager();
			tx = manager.getTransaction();
			
			tx.begin();
			Customer cust = new Customer("rohit", "a@jlc", "11111", "Blore");
			manager.persist(cust);
			tx.commit();
			System.out.println("process completed ..... check database.......");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
