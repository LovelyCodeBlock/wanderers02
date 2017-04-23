package com.pet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pet.IDao.IUserDao;
import com.pet.model.User;
import com.pet.util.DbUtil;

public class UserDao implements IUserDao
{
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	
	@Override
	public boolean add(User user) 
	{
		try
		{
			connection = DbUtil.getCon();
			String sql = "select count(*) from t_user where username = ?";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, user.getUsername());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				if(resultSet.getInt(1)>0)
				{
					return false;
				}
			}
			sql = "insert into t_user (username,password,nickname,sex,address) value (?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
		
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getNickname());
			preparedStatement.setString(4, user.getSex());
			
			preparedStatement.setString(5, user.getAddress());
	
//			preparedStatement.setInt(4, user.getType());
//			preparedStatement.setInt(5, user.getStatus());
			
			preparedStatement.executeUpdate();
			
		
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbUtil.close(resultSet);
			DbUtil.close(preparedStatement);
			DbUtil.close(connection);
		}
		return true;
	}

	@Override
	public boolean delete(int id)
	{
		
		try
		{
			connection = DbUtil.getCon();
			User user = this.load(id);
			if(user.getUsername().equals("admin"))
			{
				return false;	
			}
			String sql = "delete from t_user where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbUtil.close(preparedStatement);
			DbUtil.close(connection);
		}
		return true;
	}

	@Override
	public boolean update(User user)
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try
		{
			connection = DbUtil.getCon();
			String sql = "update t_user set password = ?,nickname = ?,sex = ?,address = ? where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getPassword());
			preparedStatement.setString(2, user.getNickname());
			preparedStatement.setString(3, user.getSex());
			preparedStatement.setString(4, user.getAddress());
//			preparedStatement.setInt(3, user.getType());
//			preparedStatement.setInt(4, user.getStatus());
			preparedStatement.setInt(5,user.getId());
			preparedStatement.executeUpdate();	
			
		} 
		catch (Exception e)
		{
			return false;
		}
		finally
		{
			DbUtil.close(preparedStatement);
			DbUtil.close(connection);
		}
		return true;
	}

	@Override
	public User load(int id)
	{
		
		User user = null;
		try
		{
			connection = DbUtil.getCon();
			String sql = "select * from t_user where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				user = new User();	
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setNickname(resultSet.getString("nickname"));
				user.setSex(resultSet.getString("sex"));
				user.setAddress(resultSet.getString("address"));
				user.setAdoptedPets(resultSet.getString("adoptedPets"));
//				user.setType(resultSet.getInt("type"));
//				user.setStatus(resultSet.getInt("status"));
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbUtil.close(resultSet);
			DbUtil.close(preparedStatement);
			DbUtil.close(connection);
		}
		return user;
	}

	@Override
	public List<User> list()
	{
		
		User user = null;
		List<User> users = new ArrayList<User>();
		try
		{
			connection = DbUtil.getCon();
			String sql = "select * from t_user";
			preparedStatement = connection.prepareStatement(sql);		
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				user = new User();	
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setNickname(resultSet.getString("nickname"));
				user.setSex(resultSet.getString("sex"));
				user.setAddress(resultSet.getString("address"));
//				user.setType(resultSet.getInt("type"));
//				user.setStatus(resultSet.getInt("status"));
				users.add(user);
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbUtil.close(resultSet);
			DbUtil.close(preparedStatement);
			DbUtil.close(connection);
		}
		return users;
		
	}

	@Override
	public User login(String username, String password)
	{
		
		User user = null;
		try
		{
			connection = DbUtil.getCon();
			String sql = "select * from t_user where username=? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				user = new User();	
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setNickname(resultSet.getString("nickname"));
				user.setSex(resultSet.getString("sex"));
				user.setAddress(resultSet.getString("address"));
				user.setAdoptedPets(resultSet.getString("adoptedPets"));
			}			
			
			//当用户不为空，输入密码与用户密码不一致时，将user置为null
			if(  user!=null && !user.getPassword().equals(password) )
			{
				user = null;
			}

			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbUtil.close(resultSet);
			DbUtil.close(preparedStatement);
			DbUtil.close(connection);
		}
		return user;
	}

}
