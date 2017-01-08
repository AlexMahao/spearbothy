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
 */
@Repository
public class CommentDao extends BaseDaoImpl<Comment> {

	/**
	 * 根据类型和id获取
	 * 
	 * @param commentType
	 * @return
	 */
	public List<Comment> getComment(String commentType, String id) {
		/*String hql = "select new Comment(c.id,c.commentDesc,c.commentContent,c.createTime,new User(c.user.id,c.user.name),c.commentType,c.comments) "
				+ " from Comment c where c.commentType.commentType = '" + commentType + "'";
*/
		String hql = " from Comment c where c.commentType.commentType = '" + commentType + "'";

		
		List<Comment> comments;
		
		
		if (commentType.equals("blog")) {
			hql = " and c.blog.id = '" + id + "'";
		} else if (commentType.equals("resource")) {
			hql = " and c.resource.id = '" + id + "'";
		} else if (commentType.equals("message")) {
		
		}
		
		comments = find(hql);
		
		return comments;
	}

}
