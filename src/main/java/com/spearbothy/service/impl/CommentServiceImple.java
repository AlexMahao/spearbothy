package com.spearbothy.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spearbothy.dao.impl.ArticleDao;
import com.spearbothy.dao.impl.CommentDao;
import com.spearbothy.dao.impl.CommentTypeDao;
import com.spearbothy.dao.impl.UserDao;
import com.spearbothy.exception.BaseException;
import com.spearbothy.model.Blog;
import com.spearbothy.model.Comment;
import com.spearbothy.model.CommentType;
import com.spearbothy.model.User;
import com.spearbothy.receive.RComment;
import com.spearbothy.service.CommentService;

@Transactional
@Service("commentService")
public class CommentServiceImple implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Autowired
	private CommentTypeDao commentTypeDao;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ArticleDao articleDao;

	/**
	 * 重新定义service 方法
	 * 
	 * getMessage(String type);
	 * 
	 * leaveMessage(Comment);
	 * 
	 * leaveBolgMessage(String type,String id);
	 * 
	 * getBlogMessage(String type,id)
	 * 
	 * getComment(String type,String id);//，判断类型
	 * 
	 * leaveComment(); //
	 * 
	 */

	/**
	 * 发表评论的方法
	 */
	public void leaveComment(RComment rComment) throws BaseException {
		User user = userDao.get(User.class, rComment.getUserId());

		if (user == null) {
			throw new BaseException("用户不存在");
		}

		CommentType commentType = commentTypeDao.getTypeByContent(rComment.getCommentType());

		if (commentType == null) {
			throw new BaseException("类型不存在");
		}
		// 基础参数设置
		Comment comment = new Comment();
		
		if(rComment.getCommentType().equals(commentDao.MESSAGE)){
			// 如果是留言,不对id 进行判断
		}else if(rComment.getCommentType().equals(commentDao.BLOG)){
			// 判断博客是否存在
			
			
			Blog blog = articleDao.get(Blog.class, rComment.getId());
			if(blog==null){
				throw new BaseException("评论目标不存在");
			}
			
			blog.setCommentCount(blog.getCommentCount());
			articleDao.save(blog);
			comment.setBlog(blog);
			
		}else if(rComment.getCommentType().equals(commentDao.COMMENT)){
			Comment commentP = commentDao.get(Comment.class, rComment.getId());

			if (commentP == null) {
				throw new BaseException("评论目标不存在");
			}
			comment.setComment(commentP);
		}else if(rComment.getCommentType().equals(commentDao.RESOURCE)){
			throw new BaseException("访问非法");
		}
		
		comment.setId(UUID.randomUUID().toString());
		comment.setCommentDesc(rComment.getContentDesc());
		comment.setCommentContent(rComment.getContent());
		comment.setUser(user);
		comment.setCommentType(commentType);
		commentDao.save(comment);
	}


	@Override
	public List<Comment> getMessages(String type,String id) throws BaseException {

		CommentType commentType = commentTypeDao.getTypeByContent(type);

		if (commentType == null) {
			throw new BaseException("类型不存在");
		}
		
		if(type.equals(commentDao.MESSAGE)){
			return commentDao.getMessage();

		}else if(type.equals(commentDao.BLOG)){
			return commentDao.getBlogMessage(id);
		}else{
			throw new BaseException("访问非法");
		}
		
	}
	
	

	/*
	 * @Override public List<Comment> getMessages(String type,String id) throws
	 * BaseException {
	 * 
	 * CommentType commentType = commentTypeDao.getTypeByContent(type);
	 * 
	 * if(commentType==null){ throw new BaseException("类型不存在"); }
	 * 
	 * List<Comment> comment = commentDao.getComment(type,"");
	 * 
	 * return comment;
	 * 
	 * }
	 */



	/**
	 * 评论的基本验证
	 * 
	 * @param mRComment
	 * @return
	 * @throws BaseException
	 */
	public Comment getCommentBaseParams(RComment mRComment) throws BaseException {
		/**
		 * 1,验证用户是否存在 2,判断评论类型是否存在 3,发表留言
		 */
		User user = userDao.get(User.class, mRComment.getUserId());

		if (user == null) {
			throw new BaseException("用户不存在");
		}

		CommentType commentType = commentTypeDao.getTypeByContent(mRComment.getCommentType());

		if (commentType == null) {
			throw new BaseException("类型不存在");
		}

		Comment commentP = commentDao.get(Comment.class, mRComment.getId());

		if (commentP == null) {
			throw new BaseException("评论目标不存在");
		}

		Comment comment = new Comment();

		comment.setId(UUID.randomUUID().toString());
		comment.setCommentDesc(mRComment.getContentDesc());
		comment.setCommentContent(mRComment.getContent());
		comment.setUser(user);
		comment.setCommentType(commentType);
		return comment;
	}


}
