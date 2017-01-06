package com.spearbothy.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ModelDriven;
import com.spearbothy.exception.BaseException;
import com.spearbothy.model.Blog;
import com.spearbothy.model.Comment;
import com.spearbothy.receive.RComment;
import com.spearbothy.response.ResultResponse;
import com.spearbothy.service.CommentService;
import com.spearbothy.util.SimplePropertyFilter;

/**
 * 评论的自实现
 */
public class CommentAction extends BaseAction implements ModelDriven<RComment> {

	RComment mRComment = new RComment();

	@Resource
	private CommentService commentService;

	@Override
	public RComment getModel() {
		return mRComment;
	}

	@Action("leaveMessage")
	public void leaveMessage() {
		// 留言功能的实现
		ResultResponse<String> result = new ResultResponse<>();

		if (StringUtils.isEmpty(mRComment.getUserId()) || StringUtils.isEmpty(mRComment.getContent())
				|| StringUtils.isEmpty(mRComment.getContentDesc()) || StringUtils.isEmpty(mRComment.getCommentType())) {
			// 所传参数不足
			result.setToastMsg("请求参数不合法");
		} else {
			try {
				commentService.leaveMessage(mRComment);
				result.setSuccessDate("");
			} catch (BaseException e) {
				result.setToastMsg(e.getMessage());
			}
		}
		// 回写数据
		writeJson(result);
	}

	@Action("getMessages")
	public void getMessages() {
		// 获取所有的留言
		ResultResponse<List<Comment>> result = new ResultResponse<>();

		String type = mRComment.getCommentType();

		if (StringUtils.isEmpty(type)) {
			result.setToastMsg("请求参数不合法");
		} else {
			try {
				List<Comment> comments = commentService.getMessages(type);
				result.setSuccessDate(comments);
			} catch (BaseException e) {
				e.printStackTrace();
			}
		}
		// 回写数据
		writeJson(result);
	}


	
}
