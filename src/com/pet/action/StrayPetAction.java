package com.pet.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.pet.IDao.DaoFactory;
import com.pet.IDao.IStrayPetDao;
import com.pet.model.StrayPet;

public class StrayPetAction implements RequestAware{
	
	private IStrayPetDao strayPetDao = DaoFactory.getStrayPetDao();
	
	private Map<String,Object> requestMap;
	
	private int pageNo;
	private String kind;
	
	private List<StrayPet> strayPetList = new ArrayList<StrayPet>(); 
	
	public String StrayPetList() throws Exception{
		
		if(pageNo<1){
			pageNo = 1;
		}
	
		strayPetList = strayPetDao.strayPetList((String) requestMap.get("Kind"), pageNo);
		requestMap.put("strayPetList", strayPetList);
		//将查询出来的结果压人到Map栈原因是防止值栈中的数据未能压人，但得另采用取值方式
		
		return "strayPetList";
	
	}

	
	@Override
	public void setRequest(Map<String, Object> requestMap) {
		this.requestMap = requestMap;
		
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<StrayPet> getStrayPetList() {
		return strayPetList;
	}

	public void setStrayPetList(List<StrayPet> strayPetList) {
		this.strayPetList = strayPetList;
	}
	
	
	
}
