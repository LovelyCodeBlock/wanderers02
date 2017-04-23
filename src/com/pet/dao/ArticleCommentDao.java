package com.pet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pet.IDao.ICommentDao;
import com.pet.model.ArticleList;
import com.pet.model.Comment;
import com.pet.util.DbUtil;


public class ArticleCommentDao implements ICommentDao {

	@Override
	public List<Comment> getArticleContent(String mold,String questionId) throws Exception {
		StringBuffer sql = new StringBuffer("select * from ");
		if("beauty".equals(mold)) {
			sql.append("t_beautyarticles");
		}else if("feed".equals(mold)) {
			sql.append("t_feedknowledge");
		}else if("talk".equals(mold)){
			sql.append("t_talkanddicuss");
		}
		sql.append(" and exchangeId="+questionId);
		
		Connection con = null;
		try {
			
			con = DbUtil.getCon();
			PreparedStatement pstmt = con.prepareStatement(sql.toString().replaceFirst("and", "where"));
			ResultSet rs = pstmt.executeQuery();
			
			List<Comment> contentList = new ArrayList<Comment>();
			while(rs.next()) {
				Comment content = new Comment();
				content.setAnswerName(rs.getString("answerName"));
				content.setContent(rs.getString("content"));
				content.setTime(rs.getString("time"));
				contentList.add(content);
			}
			
			return contentList;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
				DbUtil.close(con);
		}
	}
	
	@Override
	public List<Comment> getArticleContent(String mold,int questionId,int pageNo) throws Exception {
		StringBuffer sql = new StringBuffer("select * from ");
		
		if("beauty".equals(mold)) {
			sql.append("t_beautyarticles");
		}else if("feed".equals(mold)) {
			sql.append("t_feedknowledge");
		}else if("talk".equals(mold)){
			sql.append("t_talkanddicuss");
		}
		
		sql.append(" where exchangeId="+questionId);
		sql.append(" order by id limit ?,?");
		
		int pageSize = 4;  
		int page = (pageNo - 1) * 4;
		
		Connection con = null;
		try {
			
			con = DbUtil.getCon();
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, page);
			pstmt.setInt(2, pageSize);
			ResultSet rs = pstmt.executeQuery();
			
			List<Comment> contentList = new ArrayList<Comment>();
			
			while(rs.next()) {
				Comment content = new Comment();
				content.setAnswerName(rs.getString("answerName"));
				content.setContent(rs.getString("content"));
				content.setTime(rs.getString("time"));
				contentList.add(content);
			}
			
			return contentList;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
				DbUtil.close(con);
		}
		
	}
	
	public ArticleList getArticleList(String mold,int id) {
		
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
	
	
	
	/**
	 * @param  con        [description]
	 * @param  artCon     [description]
	 * @param  questionId [description]
	 * @throws Exception  [description]
	 */
	@Override
	public boolean addArticleContent(String mold,Comment artCon) throws Exception{
		StringBuffer sql = new StringBuffer("insert into ");
		
		if("beauty".equals(mold)) {
			sql.append("t_beautyarticles");
		}else if("feed".equals(mold)) {
			sql.append("t_feedknowledge");
		}else if("talk".equals(mold)){
			sql.append("t_talkanddicuss");
		}
		sql.append(" (id,exchangeId,answerName,content,time) values (null,?,?,?,?)");
		
		Connection con = null;
		con = DbUtil.getCon();
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		//pstmt.setInt(1, artCon.getId());
		pstmt.setInt(1, artCon.getArticleId());
		pstmt.setString(2, artCon.getAnswerName());
		pstmt.setString(3, artCon.getContent());
		pstmt.setString(4, artCon.getTime());
		
		pstmt.executeUpdate();
		
		return true;
	}


}
