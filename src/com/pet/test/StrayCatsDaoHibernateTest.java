package com.pet.test;



import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.pet.IDao.DaoFactory;
import com.pet.model.StrayCats;

public class StrayCatsDaoHibernateTest
{
	@Ignore
	public void testStrayCatsList() throws Exception
	{
		List<StrayCats> strayCats = new ArrayList<StrayCats>();
		strayCats = DaoFactory.getStrayCatsDao().strayCatsList();
		System.out.println("==========="+strayCats.size());
		for (StrayCats strayCat : strayCats)
		{
			System.out.println(strayCat);
		}
	}
	@Test
	public void testStrayCatsList2() throws Exception
	{
		List<StrayCats> strayCats = new ArrayList<StrayCats>();
		strayCats = DaoFactory.getStrayCatsDao().strayCatsList(2);
		System.out.println("==========="+strayCats.size());
		for (StrayCats strayCat : strayCats)
		{
			System.out.println(strayCat);
		}
	}

}
