package com.spearbothy.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spearbothy.dao.impl.ArticleDao;
import com.spearbothy.dao.impl.ResourceTypeDao;
import com.spearbothy.dao.impl.UserDao;
import com.spearbothy.exception.BaseException;
import com.spearbothy.model.Blog;
import com.spearbothy.model.Page;
import com.spearbothy.model.ResourceType;
import com.spearbothy.model.User;
import com.spearbothy.receive.RArticle;
import com.spearbothy.service.ArticleService;

@Transactional
@Service(value = "aricleService")
public class AricleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ResourceTypeDao resourceTypeDao;

	@Override
	public Blog publishArticle(RArticle rArticle) throws BaseException {

		Blog blog = new Blog();
		// 发表文章
		User user = userDao.get(User.class, rArticle.getUserid());

		if (user == null) {
			throw new BaseException("用户不合法");
		}

		ResourceType resourceType = resourceTypeDao.getTypeByContent(rArticle.getType());

		if (resourceType == null) {
			throw new BaseException("类型不合法");
		}
		blog.setId(UUID.randomUUID().toString());
		blog.setUser(user);
		blog.setResourceType(resourceType);
		blog.setMarkdown(rArticle.isMarkdown());
		blog.setMdContent(rArticle.getMdContent());
		blog.setContent(rArticle.getContent());
		blog.setTitle(rArticle.getTitle());

		articleDao.save(blog);

		return blog;
	}

	@Override
	public List<Blog> findBlogsByType(String type, int page, int rows) throws BaseException {
		List<Blog> blogs = articleDao.getBlogsByType(type, page, rows);

		if (blogs == null || blogs.size() == 0) {
			throw new BaseException("暂无记录");
		}
		return blogs;
	}

	@Override
	public Page<Blog> findBlogsByType(String type, Page<Blog> pageBean) throws BaseException {
		int page = pageBean.getCurrentPage();
		int rows = pageBean.getPageSize();

		// 判断类型是否存在
		if (resourceTypeDao.getTypeByContent(type) == null) {
			throw new BaseException("查询类型不存在");
		}
		;

		List<Blog> blogs = articleDao.getBlogsByType(type, page, rows);
		int count = (int) articleDao.getCountBlogsByType(type);
		// 获取对象之后，返回分页的数据
		pageBean.setMaxRow((int) count);// 总记录数
		pageBean.setTotalPage((count + rows - 1) / (rows));// 共多少页
		pageBean.setHasNext((page - 1) * rows + blogs.size() < count);// 是否有下一页
		pageBean.setData(blogs);
		return pageBean;
	}

	@Override
	public Blog getBlogDetail(String id) throws BaseException {
		Blog blog = articleDao.getBlodById(id);

		if (blog == null) {
			throw new BaseException("无查询结果");
		}

		return blog;
	}

}
