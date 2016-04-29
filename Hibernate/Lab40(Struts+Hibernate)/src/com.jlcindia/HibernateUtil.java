package com.jlcindia;

import javax.security.auth.login.Configuration;

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
