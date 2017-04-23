package com.pet.IDao;

import com.pet.dao.ArticleCommentDao;
import com.pet.dao.ArticleDao;
import com.pet.dao.PetDao;
import com.pet.dao.StrayCatsDao;
import com.pet.dao.StrayDogsDao;
import com.pet.dao.StrayPetDao;
import com.pet.dao.UserDao;

public class DaoFactory
{
	public static IUserDao getUserDao()
	{
		return new UserDao();
	}

	public static IPetDao getDogsDao() {
		return new PetDao();
	}
	
	public static IStrayPetDao getStrayPetDao() {
		return new StrayPetDao();
	}
	
	public static IArticleListDao getBeautyArticleListDao() {
		return new ArticleDao();
	}
	
	public static ICommentDao getBeautyArticleCommentDao() {
		return new ArticleCommentDao();
	}
	public static IStrayCatsDao getStrayCatsDao()
	{
		return new StrayCatsDao();
	}
	public static IStrayDogsDao getStrayDogsDao()
	{
		return new StrayDogsDao();
	}
}
	
	/**
	
	public static IArticleListDao getTalkAndDicussListDao() {
		return new TalkAndDicussListDao();
	}
	public static IArticleListDao getFeedKnowledgeListDao() {
		return new FeedKnowledgeListDao();
	}
	
	public static ICommentDao getFeedKnowledgeCommentDao() {
		return new FeedKnowledgeCommentDao();
	}
	public static ICommentDao getTalkAndDicussCommentDao() {
		return new TalkAndDicussCommentDao();
	}
	
	*/

