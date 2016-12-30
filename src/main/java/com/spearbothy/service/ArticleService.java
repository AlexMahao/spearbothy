package com.spearbothy.service;

import java.util.List;

import com.spearbothy.exception.BaseException;
import com.spearbothy.model.Blog;
import com.spearbothy.model.Page;
import com.spearbothy.receive.RArticle;

public interface ArticleService {

	public Blog publishArticle(RArticle rArticle) throws BaseException;

	public List<Blog> findBlogsByType(String type, int page, int rows) throws BaseException;

	public Blog getBlogDetail(String id) throws BaseException;

	Page<Blog> findBlogsByType(String type, Page<Blog> pageBean) throws BaseException;
}
