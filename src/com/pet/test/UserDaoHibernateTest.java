package com.pet.test;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.pet.dao.UserDaoHibernate;
import com.pet.model.User;

public class UserDaoHibernateTest
{
	private UserDaoHibernate userDaoHibernate = new UserDaoHibernate();

	@Ignore
	public void testAdd() throws Exception
	{
		User user = new User();
		user.setUsername("suer");
		user.setPassword(123+"");
		user.setNickname("Lily");
		System.out.println(userDaoHibernate.add(user));
	}
	@Ignore
	public void testDelete() throws Exception
	{
		System.out.println(userDaoHibernate.delete(20));
	}
	
	@Ignore
	public void testLoad() throws Exception
	{
		User user = userDaoHibernate.load(20);
		if(user == null)
		{
			System.out.println("用户不存在");
		}
		else
		{
			System.out.println(user);
		}
	}
	
	@Ignore
	public void testUpdate() throws Exception
	{
		User user = new User();
		user.setId(19);
		user.setNickname("哈哈");
		user.setAddress("流沙");
		
		boolean result = userDaoHibernate.update(user);
		if(result == false)
		{
			System.out.println("更改失败 用户不存在 ");
		}
	}
	
	@Ignore
	public void testList() throws Exception
	{
		List<User> users = userDaoHibernate.list();
		if(users == null)
		{
			
		}
		for (User user : users)
		{
			System.out.println(user);
		}
	}
	
	@Test
	public void testLogin() throws Exception
	{
		String username = "user";
		String password = "user";
		User user = userDaoHibernate.login(username, password);
		if(user == null)
		{
			System.out.println("账号或密码错误");
		}
		else
		{
			System.out.println(user.getAddress());
		}
		
	}
}
