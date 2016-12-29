package com.spearbothy.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;

import com.opensymphony.xwork2.ModelDriven;
import com.spearbothy.exception.BaseException;
import com.spearbothy.model.Blog;
import com.spearbothy.receive.RArticle;
import com.spearbothy.response.Code;
import com.spearbothy.response.ResultResponse;
import com.spearbothy.service.ArticleService;

/**
 * 文章的相关处理类
 */
public class ArticleAction extends BaseAction implements ModelDriven<RArticle> {

	private RArticle mRArticle = new RArticle();
	
	@Override
	public RArticle getModel() {
		return mRArticle;
	}
	
	@Resource
	public ArticleService aricleService;
	
	@Action("publishArticle")
	public void publishArticle(){
		System.out.println("*****************开始发表博客*****************8");
		
		ResultResponse<String> result = new ResultResponse<>();
		
		if(StringUtils.isEmpty(mRArticle.getUserid())||StringUtils.isEmpty(mRArticle.getTitle())
				||StringUtils.isEmpty(mRArticle.getType())
				||StringUtils.isEmpty(mRArticle.getContent())){
			result.setCode(Code.TOAST_MESSAGE);
			result.setMsg("所传参数不足");
		}else{
			try {
				aricleService.publishArticle(mRArticle);
				result.setCode(Code.SUCCESS);
				result.setMsg("发表成功");
			} catch (BaseException e) {
				result.setCode(Code.TOAST_MESSAGE);
				result.setMsg(e.getMessage());
			}catch(Exception e){
				e.printStackTrace();
				result.setCode(Code.TOAST_MESSAGE);
				result.setMsg("服务器错误");
			}
		}
		writeJson(result);
		
	}
	
	
	@Action("findBlogs")
	public void findBlogs(){
		
		System.out.println("*****************查询博客列表*****************8");
		
		ResultResponse<List<Blog>> result = new ResultResponse<>();
		
		if(StringUtils.isEmpty(mRArticle.getType())){
			result.setCode(Code.TOAST_MESSAGE);
			result.setMsg("所传参数不足");
		}else{
			try {
				List<Blog> blogs = aricleService.findBlogsByType(mRArticle.getType(), mRArticle.getPage(), mRArticle.getRows());
				result.setCode(Code.SUCCESS);
				result.setMsg("发表成功");
				result.setData(blogs);
			} catch (BaseException e) {
				result.setCode(Code.TOAST_MESSAGE);
				result.setMsg(e.getMessage());
			}catch(Exception e){
				e.printStackTrace();
				result.setCode(Code.TOAST_MESSAGE);
				result.setMsg("服务器错误");
			}
		}
		
		writeJson(result);
	}
	
	
	@Action("getBlogDetail")
	public void getBlogDetail(){
		
		System.out.println("*****************获取博客详情*****************8");
		// 获取文章详情
		ResultResponse<Blog> result = new ResultResponse<>();
		
		if(StringUtils.isEmpty(mRArticle.getBlogId())){
			result.setToastMsg("请求参数不合法");
		}else{
			try {
				
				Blog blog = aricleService.getBlogDetail(mRArticle.getBlogId());
				System.out.println(blog.getUser().getName()+"-------------------");
				result.setSuccessDate(blog);
			} catch (BaseException e) {
				result.setToastMsg(e);
			}
		}
		
		writeJson(result);
	}
}
