package com.spearbothy.receive;

/**
 * 文章接受的对象
 * @author alex_mahao
 *
 */
public class RArticle {
	
	private String userid;

	private String title;
	
	private String type;
	
	private String content;
	
	private String blogId;
	
	private int page;
	
	private int rows;
	
	private boolean isMarkdown;
	
	private String mdContent;
	
	private String digestContent;
	
	
	
	

	public String getDigestContent() {
		return digestContent;
	}

	public void setDigestContent(String digestContent) {
		this.digestContent = digestContent;
	}

	public boolean isMarkdown() {
		return isMarkdown;
	}

	public void setIsMarkdown(boolean isMarkdown) {
		this.isMarkdown = isMarkdown;
	}

	public String getMdContent() {
		return mdContent;
	}

	public void setMdContent(String mdContent) {
		this.mdContent = mdContent;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public void setMarkdown(boolean isMarkdown) {
		this.isMarkdown = isMarkdown;
	}
	
	
	
	
}
