package com.spearbothy.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
public class User implements Serializable {

	@Id
	@Column(name = "id", length = 36)
	private String id;

	@Column(name = "name", length = 32,unique=true)
	private String name; // 用户名

	@Column(name = "password", length = 32)
	private String password; // 密码

	@Column(name = "email", length = 32,unique=true)
	private String email; // 邮箱地址

	@Column(name = "register_time", nullable = true, columnDefinition = "timestamp default current_timestamp")
	private Date registerTime; // 注册时间

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Blog> books = new HashSet<Blog>();

	@OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Resource> resources = new HashSet<>();
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Breast> breasts = new HashSet<>();
	
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Comment> comments = new HashSet<>();
	


	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Message> messages = new HashSet<>();
	
	
	
	
	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Set<Blog> getBooks() {
		return books;
	}

	public void setBooks(Set<Blog> books) {
		this.books = books;
	}

	public Set<Resource> getResources() {
		return resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

	public Set<Breast> getBreasts() {
		return breasts;
	}

	public void setBreasts(Set<Breast> breasts) {
		this.breasts = breasts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", registerTime="
				+ registerTime + ", books=" + books + ", resources=" + resources + ", breasts=" + breasts
				+ ", comments=" + comments + ", messages=" + messages + "]";
	}


}
