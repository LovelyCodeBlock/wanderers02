package com.pet.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{
	private static SessionFactory sessionFactory = null;

	static {
		//1.创建配置对象
		Configuration configuration = new Configuration();
		//2.读取配置文件
		configuration.configure("/hibernate.cfg.xml");	///hibernate2.cfg.xml为默认文件名  可省略
		//3.创建SessionFactory对象
		sessionFactory = configuration.buildSessionFactory();
	}
	
	public static Session getSession()
	{
		//4.创建Session对象 
		return sessionFactory.openSession();//平时练习可以用这个    每次都开启一个全新的
//		return sessionFactory.getCurrentSession();//项目开发时用这个  来保证数据的安全性
	}
	
	public static void close(Session session)
	{
		if(session != null)
		{
			session.close();
		}
	}
}
