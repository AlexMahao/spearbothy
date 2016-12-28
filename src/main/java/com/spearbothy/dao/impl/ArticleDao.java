package com.spearbothy.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spearbothy.model.Blog;

@Repository
public class ArticleDao extends BaseDaoImpl<Blog> {

	public List<Blog> getBlogsByType(String type, int page, int rows) {
		String hql = "select new Blog(b.id,b.title,b.browseCount,b.commentCount,b.createTime)  from Blog b where b.resourceType.type='"
				+ type + "' order by b.createTime";
		List<Blog> blogs;
		if (page == 0 && rows == 0) {
			blogs = find(hql);
		} else {
			blogs = find(hql, page, rows);
		}
		return blogs;
	}

	/**
	 * 根据id 查询文章的详情
	 * 
	 * @param id
	 * @return
	 */
	public Blog getBlodById(String id) {
		String hql = "select new Blog(b.id,b.title,b.content,b.mdContent,b.createTime,b.browseCount,"
				+ "b.commentCount,b.lastEditTime,b.isMarkdown,b.user)  from Blog b where b.id='" + id + "'";

		Blog blog = get(hql);

		return blog;
	}
}
