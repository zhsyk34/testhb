package com.zhsy.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static Configuration configuration = null;
	private static StandardServiceRegistryBuilder builder = null;

	public static SessionFactory getFactory() {
		configuration = new Configuration().configure();
		builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		return configuration.buildSessionFactory(builder.build());
	}
}
