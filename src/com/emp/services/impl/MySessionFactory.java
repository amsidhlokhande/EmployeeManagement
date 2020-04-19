package com.emp.services.impl;

import org.apache.commons.logging.impl.Log4JLogger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class MySessionFactory
{
	private static SessionFactory sf = null;

	private MySessionFactory()
	{

	}

	public static SessionFactory getSessionFactory()
	{
		if (sf == null)
		{
			try
			{
				System.out
						.println("..........Reading Hibernate Configuration..........");
				Configuration cfg = new AnnotationConfiguration();
				cfg.configure("myHibernateConfig.xml");
				System.out
						.println(".........SessionFactory  loading..........");

				sf = cfg.buildSessionFactory();
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
		return sf;
	}

}
