package com.pet.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.pet.IDao.DaoFactory;
import com.pet.IDao.IStrayDogsDao;
import com.pet.model.StrayDogs;

public class StrayDogsAction implements RequestAware{
	
	private IStrayDogsDao strayDogsDao = DaoFactory.getStrayDogsDao();
	
	private Map<String,Object> requestMap;
	
	private int pageNo;
	
	private List<StrayDogs> strayDogsList = new ArrayList<StrayDogs>(); 
	
	
	public IStrayDogsDao getStrayDogsDao()
	{
		return strayDogsDao;
	}

	public void setStrayDogsDao(IStrayDogsDao strayDogsDao)
	{
		this.strayDogsDao = strayDogsDao;
	}

	public List<StrayDogs> getStrayDogsList()
	{
		return strayDogsList;
	}

	public void setStrayDogsList(List<StrayDogs> strayDogsList)
	{
		this.strayDogsList = strayDogsList;
	}

	public String StrayDogsList() throws Exception{
		
		if(pageNo<1){
			pageNo = 1;
		}
	
		strayDogsList = strayDogsDao.strayDogsList(pageNo);
		requestMap.put("strayDogsList", strayDogsList);
		//将查询出来的结果压人到Map栈原因是防止值栈中的数据未能压人，但得另采用取值方式
		return "strayDogsList";
	
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
