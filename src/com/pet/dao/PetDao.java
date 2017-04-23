package com.pet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pet.IDao.IPetDao;
import com.pet.model.Pet;
import com.pet.util.DbUtil;

public class PetDao implements IPetDao{

	
	//��ѯpet�е����ݣ�����һ��list
	@Override
	public List<Pet> petList(String kind) throws Exception {
		
		StringBuffer sql = new StringBuffer("select * from ");
		if("dog".equals(kind)) {
			sql.append("t_dogs");
		}else if("cat".equals(kind)) {
			sql.append("t_cats");
		}
		
		Connection con = DbUtil.getCon();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();
		
		List<Pet> list = new ArrayList<Pet>();
		while(rs.next()) {
			Pet dog = new Pet();
			dog.setName(rs.getString("name"));
			dog.setHabit(rs.getString("habit"));
			dog.setHobby(rs.getString("hobby"));
			dog.setPhotoAddress(rs.getString("photoAddress"));
			list.add(dog);
		}
		
		return list;
	}
	
	
	
	//��ȡָ��ҳ����pet���ݣ�����һ��list
	@Override
	public List<Pet> petList(String kind,int pageNo) throws Exception {
		StringBuffer sql = new StringBuffer("select * from ");
		if("dog".equals(kind)) {
			sql.append("t_dogs");
		}else if("cat".equals(kind)) {
			sql.append("t_cats");
		}
		sql.append(" order by id limit ?,?");
		int pageSize = 12; 
		int page = (pageNo - 1) * 12;
		
		Connection con = DbUtil.getCon();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		pstmt.setInt(1, page);
		pstmt.setInt(2, pageSize);
		ResultSet rs = pstmt.executeQuery();
		
		List<Pet> list = new ArrayList<Pet>();
		while(rs.next()) {
			Pet dog = new Pet();
			dog.setName(rs.getString("name"));
			dog.setHabit(rs.getString("habit"));
			dog.setHobby(rs.getString("hobby"));
			dog.setPhotoAddress(rs.getString("photoAddress"));
			list.add(dog);
		}
		
		return list;
	}



	
	/**��ȡҳ��
	public int getPage(String kind){
		int recordCount = 0;
		int t1 = 0, t2 = 0;
		Connection con = null;
		try {
			con = DbUtil.getCon();
			ResultSet rs = petDao.petList(con,kind);
			List<Pet> list = new ArrayList<Pet>();
			while(rs.next()) {
				Pet dog = new Pet();
				dog.setName(rs.getString("name"));
				dog.setHabit(rs.getString("habit"));
				dog.setHobby(rs.getString("hobby"));
				dog.setPhotoAddress(rs.getString("photoAddress"));
				list.add(dog);
			}
			recordCount = list.size();
			t1 = recordCount % 5;  //Ĭ��ÿҳΪ5������
			t2 = recordCount / 5;
			}catch(Exception e){
				e.printStackTrace();
		}
		if (t1 != 0) {
			t2 = t2 + 1;
		}
		return t2;
		
	}
	*/
	
	//ɾ���ģ���
	
	
	
}
