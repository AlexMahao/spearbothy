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


/**
 *  资源类型，ios android html
 *
 */
@Entity
@Table(name="t_resource_type")
public class ResourceType {
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	
	@Column(name="resource_type")
	private String type;

	@OneToMany(mappedBy = "resourceType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Blog> blogs = new HashSet<>();
	
	@OneToMany(mappedBy="resourceType",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Resource> resources = new HashSet<>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(Set<Blog> blogs) {
		this.blogs = blogs;
	}

	public Set<Resource> getResources() {
		return resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

	
	
	
	
}
