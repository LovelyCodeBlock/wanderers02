package com.pet.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.pet.IDao.DaoFactory;
import com.pet.IDao.IStrayCatsDao;
import com.pet.model.StrayCats;

public class StrayCatsAction implements RequestAware{
	
	private IStrayCatsDao strayCatsDao = DaoFactory.getStrayCatsDao();
	
	private Map<String,Object> requestMap;
	
	private int pageNo;
	
	private List<StrayCats> strayCatsList = new ArrayList<StrayCats>(); 
	
	
	public IStrayCatsDao getStrayCatsDao()
	{
		return strayCatsDao;
	}

	public void setStrayCatsDao(IStrayCatsDao strayCatsDao)
	{
		this.strayCatsDao = strayCatsDao;
	}

	public List<StrayCats> getStrayCatsList()
	{
		return strayCatsList;
	}

	public void setStrayCatsList(List<StrayCats> strayCatsList)
	{
		this.strayCatsList = strayCatsList;
	}

	public String StrayCatsList() throws Exception{
		
		if(pageNo<1){
			pageNo = 1;
		}
	
		strayCatsList = strayCatsDao.strayCatsList(pageNo);
		requestMap.put("strayCatsList", strayCatsList);
		//将查询出来的结果压人到Map栈原因是防止值栈中的数据未能压人，但得另采用取值方式
		return "strayCatsList";
	
	}

	
	@Override
	public void setRequest(Map<String, Object> requestMap) {
		this.requestMap = requestMap;
		
	}
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

}
