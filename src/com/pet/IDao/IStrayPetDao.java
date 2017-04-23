package com.pet.IDao;

import java.util.List;
import com.pet.model.StrayPet;

public interface IStrayPetDao {
	/**
	 * 返回流浪宠物信息结果集
	 * @param con
	 * @param kind
	 * @return
	 * @throws Exception
	 */
	public List<StrayPet> strayPetList( String kind) throws Exception;
	public List<StrayPet> strayPetList( String kind,int pageNo) throws Exception;
}
