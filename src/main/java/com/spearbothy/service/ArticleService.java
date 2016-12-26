package com.spearbothy.service;

import com.spearbothy.exception.BaseException;
import com.spearbothy.model.Blog;
import com.spearbothy.receive.RArticle;

public interface ArticleService {
		
	public Blog publishArticle(RArticle rArticle) throws BaseException; 
}
