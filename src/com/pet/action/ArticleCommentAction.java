package com.pet.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.pet.IDao.DaoFactory;
import com.pet.IDao.ICommentDao;
import com.pet.model.ArticleList;
import com.pet.model.Comment;


public class ArticleCommentAction implements RequestAware{

	private ICommentDao beautyArticleCommentDao = DaoFactory.getBeautyArticleCommentDao();
	
	private Map<String,Object> requestMap;
	private List<Comment> ArticleContent  = new ArrayList<Comment>();
	private ArticleList article;
	private int id;
	private int pageNo;
	private String mold;
	
	public String ArticleContent() throws Exception{
		
		if(pageNo < 1){
			pageNo = 1;
		}
		
		ArticleContent = beautyArticleCommentDao.getArticleContent(mold,id,pageNo);
		article = beautyArticleCommentDao.getArticleList(mold,id);
		
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
	
	public String addComment(){
		
		
		
		return "succss";
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Comment> getArticleContent() {
		return ArticleContent;
	}


	public void setArticleContent(List<Comment> ArticleContent) {
		this.ArticleContent = ArticleContent;
	}

	@Override
	public void setRequest(Map<String, Object> requestMap) {
			this.requestMap = requestMap;
	}

	public ArticleList getArticle() {
		return article;
	}

	public void setArticle(ArticleList article) {
		this.article = article;
	}
	
	
	
}
