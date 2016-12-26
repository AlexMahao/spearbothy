package com.spearbothy.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spearbothy.model.Blog;

@Repository
public class ArticleDao  extends BaseDaoImpl<Blog>{
	
	
	
	public List<Blog> getBlogsByType(String type,int page ,int rows){
		String hql = "select new Blog(b.id,b.title,b.browseCount,b.commentCount,b.createTime)  from Blog b where b.resourceType.type='"+type+"' order by b.createTime";
		List<Blog> blogs;
		if(page==0&&rows==0){
			blogs = find(hql);
		}else{
			blogs = find(hql,page,rows);
		}
		return blogs;
	}
}
