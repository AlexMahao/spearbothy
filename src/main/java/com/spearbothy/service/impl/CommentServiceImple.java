package com.spearbothy.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spearbothy.dao.impl.CommentDao;
import com.spearbothy.dao.impl.CommentTypeDao;
import com.spearbothy.dao.impl.UserDao;
import com.spearbothy.exception.BaseException;
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
	
	
	@Override
	public void leaveMessage(RComment mRComment) throws BaseException {
		/**
		 * 1,验证用户是否存在
		 * 2,判断评论类型是否存在
		 * 3,发表留言
		 */
		User user = userDao.get(User.class, mRComment.getUserId());
		
		if(user==null){
			throw new BaseException("用户不存在");
		}
		
		CommentType commentType = commentTypeDao.getTypeByContent(mRComment.getCommentType());
		
		if(commentType==null){
			throw new BaseException("类型不存在");
		}
		
		Comment comment = new Comment();
		
		comment.setId(UUID.randomUUID().toString());
		comment.setCommentDesc(mRComment.getContentDesc());
		comment.setCommentContent(mRComment.getContent());
		comment.setUser(user);
		comment.setCommentType(commentType);
		
		commentDao.save(comment);
	}


	@Override
	public List<Comment> getMessages(String type) throws BaseException {
		
		CommentType commentType = commentTypeDao.getTypeByContent(type);
		
		if(commentType==null){
			throw new BaseException("类型不存在");
		}
		
		List<Comment> comment = commentDao.getComment(type,"");
		
		return comment;
		
	}  
	
	

}
