package com.pet.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pet.IDao.IUserDao;
import com.pet.model.User;
import com.pet.util.HibernateUtil;

public class UserDaoHibernate  implements IUserDao 
{
	@Override
	/**
	 * 作用：添加一个用户
	 * 若要添加的用户名已存在  则返回false  反之返回true
	 */
	public boolean add(User user)
	{
		Session session = null;
		try
		{
			session = HibernateUtil.getSession();
			String hql = "from User user where user.username=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, user.getUsername());
			List<User> result = query.list();
			if(result.size() > 0)
			{
				return false;
			}
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			if(session != null)
			{
				session.getTransaction().rollback();
			}
			return false;
		}
		finally 
		{
			HibernateUtil.close(session);
		}
		return true;
	}

	@Override
	/**
	 * 通过id删除一个user对象  
	 * 若该id不存在则返回false 反之返回true
	 */
	public boolean delete(int id)
	{
		Session session = null;
		try
		{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			User user = (User)session.get(User.class, id);
			if(user == null)
			{
				return false;
			}
			session.delete(user);
			session.getTransaction().commit();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			if(session != null)
			{
				session.getTransaction().rollback();
			}
			return false;
		}
		finally 
		{
			HibernateUtil.close(session);
		}
		return true;
	}

	@Override
	/**
	 * 根据id查询user  
	 * 返回值可能为null
	 */
	public User load(int id)
	{
		Session session = null;
		User user = null;
		try 
		{
			session = HibernateUtil.getSession();
			user = (User)session.get(User.class, id);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			HibernateUtil.close(session);
		}
		return user;
	}

	@Override
	/**
	 * 更新一个user
	 * 先根据id查询user是否存在    若不存在则返回false
	 * 存在则更新其除了username以外的属性
	 */
	public boolean update(User user)
	{
		Session session = null;
		try 
		{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			User u = (User)session.get(User.class, user.getId());
			if(u == null)
			{
				return false;
			}
			u.setNickname(user.getNickname());
			u.setPassword(user.getPassword());
			u.setSex(user.getSex());
			u.setAddress(user.getAddress());
			u.setAdoptedPets(user.getAdoptedPets());
			u.setIcon(user.getIcon());
			session.getTransaction().commit();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			if(session!=null)
			{
				session.getTransaction().rollback();
			}
			return false;
		} 
		finally 
		{
			HibernateUtil.close(session);
		}
		return true;
	}

	@Override
	public List<User> list()
	{
		Session session = null;
		List<User> users = null;
		try
		{
			session = HibernateUtil.getSession();
			String hql = "from User";
			Query query = session.createQuery(hql);
			users = query.list();
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
		return users;
	}

	@Override
	public User login(String username, String password)
	{
		Session session = null;
		User user = null;
		try
		{
			session = HibernateUtil.getSession();
			String hql = "from User user where user.username=?";
			Query query = session.createQuery(hql);
			query.setParameter(0,username);
			List<User> result = query.list();
//			System.out.println(result.size()+"====");
			for (User user2 : result)
			{
				System.out.println(user2);
			}
			if(result.size() <= 0)
			{
				return null;
			}
			user = result.get(0);
			if(user.getPassword() == null || "".equals(user.getPassword().trim()))
			{
				return null;
			}
			else if (! user.getPassword().equals(password)) 
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
		return user;
	}
	
}
