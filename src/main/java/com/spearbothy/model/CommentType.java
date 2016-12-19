package com.spearbothy.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_comment_type")
public class CommentType {

	@Id
	@Column
	@GeneratedValue
	private int id;
	
	@Column(name="comment_type")
	private String commentType;
	
	@OneToMany(mappedBy="commentType",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Comment> comments = new HashSet<>();



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommentType() {
		return commentType;
	}

	public void setCommentType(String commentType) {
		this.commentType = commentType;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	
	
}
