//package com.pet.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//
//import com.pet.IDao.IStrayPetDao;
//import com.pet.model.StrayPet;
//import com.pet.model.User;
//import com.pet.util.DbUtil;
//import com.pet.util.HibernateUtil;
//
//public class StrayPetDaoHibernate implements IStrayPetDao {
//
//	
//	@Override
//	public List<StrayPet> strayPetList(String kind) throws Exception {
//		Session session = null;
//		try
//		{
//			session = HibernateUtil.getSession();
//			String hql = "from User ";
//			Query query = session.createQuery(hql);
//			query.setParameter(0, user.getUsername());
//			List<User> result = query.list();
//			if(result.size() > 0)
//			{
//				return false;
//			}
//			session.beginTransaction();
//			session.save(user);
//			session.getTransaction().commit();
//		} 
//		catch (Exception e)
//		{
//			e.printStackTrace();
//			if(session != null)
//			{
//				session.getTransaction().rollback();
//			}
//			return false;
//		}
//		finally 
//		{
//			HibernateUtil.close(session);
//		}
//		return true;
//	
//	
//	}
//
//	
//	@Override
//	public List<StrayPet> strayPetList(String kind,int pageNo) throws Exception {
//		StringBuffer sql = new StringBuffer("select * from");
//		if("dog".equals(kind)) {
//			sql.append(" t_straydogs");
//		}else if("cat".equals(kind)) {
//			sql.append(" t_straycats");
//		}
//		sql.append(" order by id limit ?,?");
//		int pageSize = 9; 
//		int page = (pageNo - 1) * 9;//默认一页为9条数据
//		
//		Connection con = null;
//		try {
//			
//			con = DbUtil.getCon();
//			PreparedStatement pstmt = con.prepareStatement(sql.toString());
//			pstmt.setInt(1, page);
//			pstmt.setInt(2, pageSize);
//			ResultSet rs =pstmt.executeQuery();
//			
//			List<StrayPet> list = new ArrayList<StrayPet>();
//			while(rs.next()) {
//				
//				StrayPet strayPet = new StrayPet();
//				strayPet.setId(rs.getInt("id"));
//				strayPet.setName(rs.getString("name"));
//				strayPet.setKind(rs.getString("kind"));
//				strayPet.setSex(rs.getString("sex"));
//				strayPet.setHobby(rs.getString("hobby"));
//				strayPet.setFoundAddress(rs.getString("foundAddress"));
//				list.add(strayPet);
//				
//			}
//			return list;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}finally {
//			DbUtil.close(con);
//		}
//		
//	}
//
//	//婢х偑锟戒礁鍨归妴浣规暭閵嗕焦鐓�
//}
