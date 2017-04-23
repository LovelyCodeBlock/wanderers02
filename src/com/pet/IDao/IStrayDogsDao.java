package com.pet.IDao;

import java.util.List;

import com.pet.model.StrayCats;
import com.pet.model.StrayDogs;

public interface IStrayDogsDao {
	/**
	 * 返回流浪宠物信息结果集
	 * @param con
	 * @param kind
	 * @return
	 * @throws Exception
	 */
	public List<StrayDogs> strayDogsList() throws Exception;
	public List<StrayDogs> strayDogsList(int pageNo) throws Exception;
}
