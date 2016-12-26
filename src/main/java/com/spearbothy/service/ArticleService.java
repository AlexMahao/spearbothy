package com.spearbothy.service;

import java.util.List;

import com.spearbothy.exception.BaseException;
import com.spearbothy.model.Blog;
import com.spearbothy.receive.RArticle;

public interface ArticleService {
		
	public Blog publishArticle(RArticle rArticle) throws BaseException; 
	
	public List<Blog> findBlogsByType(String type,int page,int rows) throws BaseException;
}
