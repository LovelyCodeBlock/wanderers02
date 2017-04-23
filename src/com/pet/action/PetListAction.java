package com.pet.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.pet.IDao.DaoFactory;
import com.pet.IDao.IPetDao;
import com.pet.model.Pet;

public class PetListAction implements RequestAware{
	
	private IPetDao petDao = DaoFactory.getDogsDao();
	private Map<String,Object> requestMap;//暂时用不上
	
	private String kind;
	private int pageNo;
	

	private List<Pet> petList = new ArrayList<Pet>(); 
	
	public String petList() throws Exception{
		
		if(pageNo<1){
			pageNo = 1;
		}
		
		petList = petDao.petList( (String)requestMap.get("kind"),pageNo);
		requestMap.put("petList", petList);
		
		return "petList";
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

	public List<Pet> getPetList() {
		return petList;
	}

	public void setPetList(List<Pet> petList) {
		this.petList = petList;
	}

	
		
		
			
}
