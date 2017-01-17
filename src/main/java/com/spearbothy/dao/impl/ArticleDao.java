package com.spearbothy.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spearbothy.model.Blog;

@Repository
public class ArticleDao extends BaseDaoImpl<Blog> {

	/**
	 * 根据类型分页查询博客
	 * @param type
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Blog> getBlogsByType(String type, int page, int rows) {
		
		List<Blog> blogs;
		if (page == 0 && rows == 0) {
			blogs = getAllBlogsByType(type);
		} else {
			String hql = "select new Blog(b.id,b.title,b.browseCount,b.commentCount,b.digestContent,b.createTime)  from Blog b where b.resourceType.type='"
					+ type + "' order by b.createTime desc";
			blogs = find(hql, page, rows);
		}
		return blogs;
	}
	
	
	/**
	 * 获取该类型下所有的博客
	 * @param type
	 * @return
	 */
	public List<Blog> getAllBlogsByType(String type){
		String hql = "select new Blog(b.id,b.title,b.browseCount,b.commentCount,b.digestContent,b.createTime)  from Blog b where b.resourceType.type='"
				+ type + "' order by b.createTime";
		return find(hql);
	}
	
	/**
	 * 根据类型获取匹配的所有博客
	 * @param type
	 * @return
	 */
	public long getCountBlogsByType(String type){
		String hql = "select count(*)  from Blog b where b.resourceType.type='"
				+ type + "' order by b.createTime";
		return count(hql);
	}

	/**
	 * 根据id 查询文章的详情
	 * 
	 * @param id
	 * @return
	 */
	public Blog getBlodById(String id) {
		String hql = "select new Blog(b.id,b.title,b.content,b.createTime,b.browseCount,"
				+ "b.commentCount,b.lastEditTime,b.isMarkdown,b.user)  from Blog b where b.id='" + id + "'";

		Blog blog = get(hql);
		blog.setBrowseCount(blog.getBrowseCount()+1);
		
		String updateHql = "update Blog b set b.browseCount = "+blog.getBrowseCount()+" where b.id =  '" +blog.getId()+"'";
		executeHql(updateHql);
		return blog;
	}
}
