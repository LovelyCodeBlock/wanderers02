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
			//��¼ʧ��
			requestMap.put("error", "�û������������");
			return "login-error";
		}
		else
		{
			//��¼�ɹ�
			sessionMap.put("currentUser", user);
			return "login-succss";
		}
			
	}
	
	
	public String register(){
		
		boolean	add = userDao.add(user);
		if(add == false)
		{
			//ע��ʧ��
			requestMap.put("registerError", "ע��ʧ�ܣ��û����Ѵ��ڣ�");
			return "register-error";
		}else{
			
			//ע��ɹ�����½
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


	//�����������Թ���ķ�������ֱ�ӽ��������е�������ջ�����Խ��и�ֵ
	@Override
	public User getModel() {
		user  = new User();
		return user;
	}
	
}
