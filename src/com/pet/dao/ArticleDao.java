package com.pet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pet.IDao.IArticleListDao;
import com.pet.model.ArticleList;
import com.pet.util.DbUtil;

public class ArticleDao implements IArticleListDao {

	public List<ArticleList> getArticleList(String mold) throws Exception {
		StringBuffer sql = new StringBuffer("select * from ");
		if("beauty".equals(mold)) {
			sql.append("t_beauty");
		}else if("feed".equals(mold)) {
			sql.append("t_feed");
		}else if("talk".equals(mold)){
			sql.append("t_talk");
		}
		
		Connection con = null;
		try {
			
			con = DbUtil.getCon();
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			
			List<ArticleList> list =  new ArrayList<ArticleList>();
			
			while(rs.next()) {
				
				ArticleList articleList = new ArticleList();
				articleList.setId(rs.getInt("id"));
				articleList.setTitle(rs.getString("title"));
				articleList.setPublisher(rs.getString("publisher"));
				articleList.setComments(rs.getInt("comments"));
				String summary = rs.getString("summary");
				if(summary.length()> 300) {
					summary = summary.substring(0, 300);
				}
				articleList.setSummary(summary);
				articleList.setTime(rs.getString("time"));
				
				list.add(articleList);
				
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(con != null) {
				DbUtil.close(con);
			}
		}
	}

	@Override
	public ArticleList getArticle(String mold,String id) throws Exception {
		
		StringBuffer sql = new StringBuffer("select * from ");
		if("beauty".equals(mold)) {
			sql.append("t_beauty");
		}else if("feed".equals(mold)) {
			sql.append("t_feed");
		}else if("talk".equals(mold)){
			sql.append("t_talk");
		}
		sql.append(" and id=" + id);
		
		Connection con = null;
		try {
			
			con = DbUtil.getCon();
			PreparedStatement pstmt = con.prepareStatement(sql.toString().replaceFirst("and", "where"));
			ResultSet rs = pstmt.executeQuery();
			ArticleList article = null;
			
			if(rs.next()) {
				article = new ArticleList();
				article.setTitle(rs.getString("title"));
				article.setPublisher(rs.getString("publisher"));
				article.setComments(rs.getInt("comments"));
				article.setSummary(rs.getString("summary"));
				article.setTime(rs.getString("time"));
			}
			
			return article;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DbUtil.close(con);
		}
	}
	

	
	
	@Override
	public List<ArticleList> getArticleList(String mold,int pageNo) throws Exception{
		
		StringBuffer sql = new StringBuffer("select * from ");
		if("beauty".equals(mold)) {
			sql.append("t_beauty");
		}else if("feed".equals(mold)) {
			sql.append("t_feed");
		}else if("talk".equals(mold)){
			sql.append("t_talk");
		}
		sql.append(" order by id limit ?,?");
		
		int pageSize = 5;  
		int page = (pageNo - 1) * 5;
		
		Connection con = null;
		try {
			
			con = DbUtil.getCon();
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, page);
			pstmt.setInt(2, pageSize);
			ResultSet rs = pstmt.executeQuery();
			
			List<ArticleList> list = new ArrayList<ArticleList>();
			while(rs.next()) {
				
				ArticleList articleList = new ArticleList();
				articleList.setId(rs.getInt("id"));
				articleList.setTitle(rs.getString("title"));
				articleList.setPublisher(rs.getString("publisher"));
				articleList.setComments(rs.getInt("comments"));
				String summary = rs.getString("summary");
				if(summary.length()> 300) {
					summary = summary.substring(0, 300);
					
				}
				articleList.setSummary(summary);
				articleList.setTime(rs.getString("time"));
				
				list.add(articleList);
				
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(con != null) {
				try {
					DbUtil.close(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	

	
	/**
	 * 插入文章
	 */
	@Override
	public boolean insertArticle(String mold,ArticleList article) throws Exception {
		
		StringBuffer sql = new StringBuffer("insert into ");
		if("beauty".equals(mold)) {
			sql.append("t_beauty");
		}else if("feed".equals(mold)) {
			sql.append("t_feed");
		}else if("talk".equals(mold)){
			sql.append("t_talk");
		}
		sql.append(" values(null,?,?,?,?,?)");
		
		Connection con = DbUtil.getCon();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1, article.getTitle());
		pstmt.setString(2, article.getPublisher());
		pstmt.setString(3, article.getTime());
		pstmt.setInt(4, article.getComments());
		pstmt.setString(5, article.getSummary());
		
		pstmt.executeUpdate();
		
		return true;
	}
	
}
	