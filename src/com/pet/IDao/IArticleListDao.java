package com.pet.IDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.pet.model.ArticleList;

public interface IArticleListDao {

	public ArticleList getArticle(String mold,String id) throws Exception;
	public List<ArticleList> getArticleList(String mold,int pageNo) throws Exception;
	public boolean insertArticle(String mold,ArticleList article) throws Exception;
}
