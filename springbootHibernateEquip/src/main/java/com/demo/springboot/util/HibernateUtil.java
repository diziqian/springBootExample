package com.demo.springboot.util;

import java.io.File;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.demo.springboot.entity.GsmTaskSpecs;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
//	private static final SessionFactory sessionFactory = buildSessionFactory();
    
//    private static SessionFactory buildSessionFactory() {
	//private SessionFactory buildSessionFactory() {
	public static SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = null;
        try {
        	System.out.println("getSessionFactory begin!!!");
        	
        	Configuration configuration = new Configuration();
        	
        	Properties settings = new Properties();
        	settings.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
            settings.put(Environment.URL, "jdbc:sqlserver://localhost:53802;databaseName=javatest");
            settings.put(Environment.USER, "sa");
            settings.put(Environment.PASS, "sa123");
//            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            settings.put(Environment.SHOW_SQL, "true");
            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            settings.put(Environment.HBM2DDL_AUTO, "create-drop");        	
        	
//        	 settings.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
//             settings.put(Environment.USER, "sa");
//             settings.put(Environment.PASS, "sa1234");
//             settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
//             settings.put(Environment.URL, "jdbc:sqlserver://localhost:53802;databaseName=javatest");
//             settings.put(Environment.SHOW_SQL, "true");
//
//             settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//
//             settings.put(Environment.HBM2DDL_AUTO, "create-drop");

             configuration.setProperties(settings);

             configuration.addAnnotatedClass(GsmTaskSpecs.class);

             ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                 .applySettings(configuration.getProperties()).build();
             
             System.out.println("getSessionFactory****");

             sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        	
             System.out.println("getSessionFactory success!!!");
        	
            // Create the SessionFactory from hibernate.cfg.xml
//            return new Configuration().configure(new File(&quot;hibernate.cgf.xml&quot;)).buildSessionFactory();
  
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
//            System.err.println(&quot;Initial SessionFactory creation failed.&quot; + ex);
//            throw new ExceptionInInitializerError(ex);
        	sessionFactory = null;
        	ex.printStackTrace();
        }
        
        return sessionFactory;
    }
  
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//  
//    public static void shutdown() {
//        // Close caches and connection pools
//        getSessionFactory().close();
//    }
}
