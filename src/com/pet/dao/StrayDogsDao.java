package com.pet.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pet.IDao.IStrayDogsDao;
import com.pet.model.StrayDogs;
import com.pet.model.StrayDogs;
import com.pet.model.User;
import com.pet.util.HibernateUtil;

public class StrayDogsDao implements IStrayDogsDao 
{

	@Override
	public List<StrayDogs> strayDogsList() throws Exception
	{
		Session session = null;
		List<StrayDogs> strayDogsList = null;
		try
		{
			session = HibernateUtil.getSession();
			String hql = "from StrayDogs";
			Query query = session.createQuery(hql);
			strayDogsList = new ArrayList<StrayDogs>();
			strayDogsList = query.list();
			if(strayDogsList.size() <= 0)
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
		return strayDogsList;
	}

	@Override
	public List<StrayDogs> strayDogsList(int pageNo) throws Exception
	{
		int pageSize = 9; 
		Session session = null;
		Query query = null;
		List<StrayDogs> strayDogsList = null;
		try
		{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			String hql = "from StrayDogs strayDogs";
			query = session.createQuery(hql);
			query.setFirstResult((pageNo-1)*pageSize);
			query.setMaxResults(pageSize);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		strayDogsList = new ArrayList<StrayDogs>();
		strayDogsList = query.list();
		return strayDogsList;
	}
	}

	

	//增、删、改、查

