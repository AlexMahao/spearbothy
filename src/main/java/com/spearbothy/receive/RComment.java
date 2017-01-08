package com.spearbothy.receive;

public class RComment {

	private String userId;
	
	private String commentType;
	
	private String content;
	
	private String contentDesc;
	
	// 评论的id
	private String id;
	
	
	
	
	
	
	

	@Override
	public String toString() {
		return "RComment [userId=" + userId + ", commentType=" + commentType + ", content=" + content + ", contentDesc="
				+ contentDesc + ", id=" + id + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCommentType() {
		return commentType;
	}

	public void setCommentType(String commentType) {
		this.commentType = commentType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentDesc() {
		return contentDesc;
	}

	public void setContentDesc(String contentDesc) {
		this.contentDesc = contentDesc;
	}
	
	
	
}
