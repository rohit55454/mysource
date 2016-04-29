package com.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	static SessionFactory factory;
	
	static{
		Configuration cfg = new Configuration();
		cfg = cfg.configure();
		StandardServiceRegistryBuilder ssrbuilder = new StandardServiceRegistryBuilder();
		StandardServiceRegistry ssRegistry = ssrbuilder.applySettings(cfg.getProperties()).build();
		factory = cfg.buildSessionFactory(ssRegistry);
	}
	
	public static SessionFactory getSessionFactory(){
		return factory;
	}
}
