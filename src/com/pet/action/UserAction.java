package com.pet.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ModelDriven;
import com.pet.IDao.DaoFactory;
import com.pet.IDao.IUserDao;
import com.pet.model.User;

public class UserAction implements RequestAware,SessionAware,ModelDriven<User>{

	private Map<String,Object> requestMap;
	private Map<String,Object> sessionMap;

	IUserDao userDao = DaoFactory.getUserDao();
	private User user;

	
	public String login(){
		
		user = userDao.login(user.getUsername(), user.getPassword());
		if(user == null)	
		{
			//登录失败
			requestMap.put("error", "用户名或密码错误");
			return "login-error";
		}
		else
		{
			//登录成功
			sessionMap.put("currentUser", user);
			return "login-succss";
		}
			
	}
	
	
	public String register(){
		
		boolean	add = userDao.add(user);
		if(add == false)
		{
			//注册失败
			requestMap.put("registerError", "注册失败！用户名已存在！");
			return "register-error";
		}else{
			
			//注册成功并登陆
			sessionMap.put("currentUser", user);
			return "register-succss";
		}
		
	}

	@Override
	public void setRequest(Map<String, Object> requestMap) {
		   this.requestMap  = requestMap;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
			this.sessionMap = sessionMap;
	}


	//减少输入属性过多的方法，可直接将对象域中的数据与栈中属性进行赋值
	@Override
	public User getModel() {
		user  = new User();
		return user;
	}
	
}
