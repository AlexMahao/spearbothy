package com.spearbothy.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.spearbothy.model.Blog;
import com.spearbothy.model.Comment;
import com.spearbothy.model.CommentType;

/**
 * 评论的数据库操作
 * 
 * 查询博客就是查询博客 查询评论就是查询留言
 * 
 * 
 *
 */
@Repository
public class CommentDao extends BaseDaoImpl<Comment> {

	public final static String BLOG = "blog";
	public static final String MESSAGE = "message";

	public static final String RESOURCE = "resource";
	public static final String COMMENT = "comment";

	

	public List<Comment> getBlogMessage(String id) {
		String hql = " from Comment c where c.commentType.commentType = '" + BLOG + "'";
		hql =hql+ " and c.blog.id = '" + id + "'  order by c.createTime";
		System.out.println("-----"+hql);
		List<Comment> comments = find(hql);

		return comments;
	}

	public List<Comment> getMessage() {
		String hql = " from Comment c where c.commentType.commentType = '" + MESSAGE + "' order by c.createTime";
		List<Comment> comments = find(hql);
		return comments;
	}

	/**
	 * 评论无需做操作，级联查询查出
	 * 
	 * @param id
	 * @return
	 *//*
	public List<Comment> getComment(String id) {
		return null;
	}*/

	public List<Comment> getResourceMessage(String id) {
		String hql = " from Comment c where c.commentType.commentType = '" + RESOURCE + "'";
		hql =hql+ " and c.resource.id = '" + id + "' order by c.createTime";
		List<Comment> comments = find(hql);
		return comments;
	}

}
