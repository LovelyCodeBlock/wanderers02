package com.pet.IDao;

import java.util.List;

import com.pet.model.StrayCats;

public interface IStrayCatsDao {
	/**
	 * 返回流浪宠物信息结果集
	 * @param con
	 * @param kind
	 * @return
	 * @throws Exception
	 */
	public List<StrayCats> strayCatsList() throws Exception;
	public List<StrayCats> strayCatsList(int pageNo) throws Exception;
}
