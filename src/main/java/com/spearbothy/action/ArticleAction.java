package com.spearbothy.action;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;

import com.opensymphony.xwork2.ModelDriven;
import com.spearbothy.exception.BaseException;
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

}
