package com.pet.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pet.IDao.IStrayCatsDao;
import com.pet.model.StrayCats;
import com.pet.model.User;
import com.pet.util.HibernateUtil;

public class StrayCatsDao implements IStrayCatsDao 
{
	@Override
	public List<StrayCats> strayCatsList() throws Exception
	{
		Session session = null;
		List<StrayCats> strayCatslList = null;
		try
		{
			session = HibernateUtil.getSession();
			String hql = "from StrayCats";
			Query query = session.createQuery(hql);
			strayCatslList = new ArrayList<StrayCats>();
			strayCatslList = query.list();
			if(strayCatslList.size() <= 0)
			{
				return null;
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			if(session != null)
			{
				session.getTransaction().rollback();
			}
			return null;
		}
		finally 
		{
			HibernateUtil.close(session);
		}
		return strayCatslList;
	}


	@Override
	public List<StrayCats> strayCatsList(int pageNo) throws Exception
	{
		int pageSize = 9; 
		Session session = null;
		Query query = null;
		List<StrayCats> strayCatslList = null;
		try
		{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			String hql = "from StrayCats strayCats";
			query = session.createQuery(hql);
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		strayCatslList = new ArrayList<StrayCats>();
		strayCatslList = query.list();
		return strayCatslList;
	}

	//增、删、改、查
}
