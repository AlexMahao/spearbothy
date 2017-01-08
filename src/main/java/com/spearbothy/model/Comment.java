package com.spearbothy.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name="t_comment")
public class Comment {

	
	@Id
	@Column
	private String id;
	
	@Column(name="comment_desc")
	private String commentDesc;
	
	@Column(name="comment_content")
	private String commentContent;
	

	@Column(name="create_time",nullable=true,columnDefinition="timestamp default current_timestamp")
	private Date createTime;
	
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="comment_type_id")
	private CommentType commentType; // 类型，指当前评论的目标对象，包含博客，资源，留言，评论
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="comment_id")
	private Comment comment;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="resource_id")
	private Resource resource;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="blog_id")
	private Blog blog;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="message_id")
	private Message message;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="breast_id")
	private Breast breast;
	
	@OneToMany(mappedBy="comment",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Comment> comments = new HashSet<>();

	 
	
	
	public Comment() {
		super();
	}

	public Comment(String id, String commentDesc, String commentContent, Date createTime, User user,
			CommentType commentType, Set<Comment> comments) {
		super();
		this.id = id;
		this.commentDesc = commentDesc;
		this.commentContent = commentContent;
		this.createTime = createTime;
		this.user = user;
		this.commentType = commentType;
		this.comments = comments;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCommentDesc() {
		return commentDesc;
	}

	public void setCommentDesc(String commentDesc) {
		this.commentDesc = commentDesc;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CommentType getCommentType() {
		return commentType;
	}

	public void setCommentType(CommentType commentType) {
		this.commentType = commentType;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public Breast getBreast() {
		return breast;
	}

	public void setBreast(Breast breast) {
		this.breast = breast;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", commentDesc=" + commentDesc + ", commentContent=" + commentContent
				+ ", createTime=" + createTime + ", user=" + user + ", commentType=" + commentType + ", comment="
				+ comment + ", resource=" + resource + ", blog=" + blog + ", message=" + message + ", breast=" + breast
				+ ", comments=" + comments + "]";
	}
	
	
	
}
