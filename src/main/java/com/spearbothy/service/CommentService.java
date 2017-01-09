package com.spearbothy.service;

import java.util.List;

import com.spearbothy.exception.BaseException;
import com.spearbothy.model.Comment;
import com.spearbothy.receive.RComment;

public interface CommentService {
	// 留言
	void leaveComment(RComment mRComment) throws BaseException;

	// 获取留言
	List<Comment> getMessages(String type, String id) throws BaseException;

	
}
