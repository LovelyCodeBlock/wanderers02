package com.pet.IDao;

import java.util.List;

import com.pet.model.ArticleList;
import com.pet.model.Comment;


/**
 * 某条帖子的评论信息接�?
 * @author Cedo
 *
 */
public interface ICommentDao {

	public List<Comment> getArticleContent(String mold,String questionId) throws Exception;
	public List<Comment> getArticleContent(String mold,int questionId,int pageNo) throws Exception;
	public boolean addArticleContent(String mold,Comment artCon) throws Exception;
	public ArticleList getArticleList(String mold,int id);
}
