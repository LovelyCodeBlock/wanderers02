package com.pet.action;

import java.util.ArrayList;
import java.util.List;

import com.pet.IDao.DaoFactory;
import com.pet.IDao.IArticleListDao;
import com.pet.model.ArticleList;

public class ArticleAction{

	private IArticleListDao articleListDao = DaoFactory.getBeautyArticleListDao();
	
	private int pageNo;
	private String mold; //为帖子类型
	private String id;
	private List<ArticleList> articleList = new ArrayList<ArticleList>();
	private ArticleList article = new ArticleList();//为写好的文章
	
	public String ArticleList() throws Exception{
		
		if(pageNo <1){
			pageNo = 1;
		}
		
		articleList  = articleListDao.getArticleList(mold,pageNo);
		
		if("beauty".equals(mold)){
			return "Beauty";
		}
		else if("feed".equals(mold)){
			return "Feed";
		}
		else if("talk".equals(mold)){
			return "Talk";
		}
	
		return "error";
		
	}
	
	public String addArticle() throws Exception{
		
		if(pageNo <1){
			pageNo = 1;
		}
		
		article = articleListDao.getArticle(mold, id);
		
		if(articleListDao.insertArticle(mold, article))
			return "success";
		else
			return "error";
	}
	


	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getMold() {
		return mold;
	}

	public void setMold(String mold) {
		this.mold = mold;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ArticleList> getArticleList() {
		return articleList;
	}


	public void setArticleList(List<ArticleList> articleList) {
		this.articleList = articleList;
	}

	public ArticleList getArticle() {
		return article;
	}

	public void setArticle(ArticleList article) {
		this.article = article;
	}
	
	
	
	
	
	
		

}
