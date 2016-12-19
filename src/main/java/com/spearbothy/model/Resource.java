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

import org.hibernate.annotations.Type;

@Entity
@Table(name = "t_resource")
public class Resource {

	@Id
	@Column(name = "id", length = 36)
	private String id;

	@Column
	private String title;


	@Type(type="text")  
	@Column(name="content")
	private String content;
	
	@Column
	private String link;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "type_id")
	private ResourceType resourceType;

	@OneToMany(mappedBy="resource",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Comment> comments = new HashSet<>();
	
	
	
	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	/*
	 * @Column private String title;
	 * 
	 * @Column(columnDefinition="text") private String desc;
	 * 
	 * @Column private String link;
	 * 
	 * @ManyToOne(cascade=CascadeType.ALL)
	 * 
	 * @JoinColumn(name="user_id") private User user;
	 * 
	 * @ManyToOne(cascade=CascadeType.ALL)
	 * 
	 * @JoinColumn(name="type_id") private ResourceType resourceType;
	 * 
	 * public String getId() { return id; }
	 * 
	 * public void setId(String id) { this.id = id; }
	 * 
	 * public String getTitle() { return title; }
	 * 
	 * public void setTitle(String title) { this.title = title; }
	 * 
	 * public String getDesc() { return desc; }
	 * 
	 * public void setDesc(String desc) { this.desc = desc; }
	 * 
	 * public String getLink() { return link; }
	 * 
	 * public void setLink(String link) { this.link = link; }
	 * 
	 * public User getUser() { return user; }
	 * 
	 * public void setUser(User user) { this.user = user; }
	 * 
	 * public ResourceType getResourceType() { return resourceType; }
	 * 
	 * public void setResourceType(ResourceType resourceType) {
	 * this.resourceType = resourceType; }
	 * 
	 * 
	 */
}
