package com.pet.IDao;

import java.util.List;

import com.pet.model.Pet;

public interface IPetDao {
	
	public List<Pet> petList( String kind) throws Exception;
	public List<Pet> petList(String kind,int pageNo) throws Exception;
}
