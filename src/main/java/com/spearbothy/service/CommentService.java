package com.spearbothy.service;

import java.util.List;

import com.spearbothy.exception.BaseException;
import com.spearbothy.model.Comment;
import com.spearbothy.receive.RComment;

public interface CommentService {

	void leaveMessage(RComment mRComment) throws BaseException;

	List<Comment> getMessages(String type) throws BaseException;

}
