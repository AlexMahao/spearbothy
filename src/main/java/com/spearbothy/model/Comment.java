package com.spearbothy.model;

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
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="comment_type_id")
	private CommentType commentType;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="comment_id")
	private Comment comment;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="resource_id")
	private Resource resource;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="blog_id")
	private Blog blog;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="message_id")
	private Message message;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="breast_id")
	private Breast breast;
	
	@OneToMany(mappedBy="comment",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Comment> comments = new HashSet<>();

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
	
	
	
}
