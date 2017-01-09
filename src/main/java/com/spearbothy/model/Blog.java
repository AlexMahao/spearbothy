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

import org.hibernate.annotations.Type;

@Entity
@Table(name="t_blog")
public class Blog {

	@Id
	@Column(name="id",length=36)
	private String id;
	
	@Column(name="title" ,length=100)
	private String title;
	
	@Type(type="text")  
	@Column(name="content")
	private String content;
	
	
	@Type(type="text")  
	@Column(name="md_content")
	private String mdContent;
	
	@Column(name="create_time",nullable=true,columnDefinition="timestamp default current_timestamp")
	private Date createTime;
	
	@Column(name="browse_count")
	private int browseCount;
	
	@Type(type="text")  
	@Column(name="digest_content")
	private String digestContent;
	
	@Column(name="comment_count")
	private int commentCount;
	
	@Column(name="last_edit_time",nullable=true,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date lastEditTime;
	
	@Column(name="is_markdown")
	private boolean isMarkdown;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="type_id")
	private ResourceType resourceType;

	@OneToMany(mappedBy="blog",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Comment> comments = new HashSet<>();

	
	
	
	
	
	
	public String getDigestContent() {
		return digestContent;
	}

	public void setDigestContent(String digestContent) {
		this.digestContent = digestContent;
	}

	public Blog(String id, String title, String content, Date createTime, int browseCount,
			int commentCount, Date lastEditTime, boolean isMarkdown, User user) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.mdContent = mdContent;
		this.createTime = createTime;
		this.browseCount = browseCount;
		this.commentCount = commentCount;
		this.lastEditTime = lastEditTime;
		this.isMarkdown = isMarkdown;
		this.user = user;
	}

	public Blog(String id, String title, int browseCount, int commentCount,String  digestContent,Date createTime) {
		super();
		this.id = id;
		this.title = title;
		this.browseCount = browseCount;
		this.commentCount = commentCount;
		this.createTime = createTime;
		this.digestContent = digestContent;
	}

	public Blog() {
		super();
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getBrowseCount() {
		return browseCount;
	}

	public void setBrowseCount(int browseCount) {
		this.browseCount = browseCount;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	public boolean isMarkdown() {
		return isMarkdown;
	}

	public void setMarkdown(boolean isMarkdown) {
		this.isMarkdown = isMarkdown;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ResourceType getResourceType() {
		return resourceType;
	}

	public void setResourceType(ResourceType resourceType) {
		this.resourceType = resourceType;
	}

	public String getMdContent() {
		return mdContent;
	}

	public void setMdContent(String mdContent) {
		this.mdContent = mdContent;
	}
	
	
	
	
	
	
}
