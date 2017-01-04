package com.spearbothy.action;

import org.apache.struts2.convention.annotation.Action;

import com.opensymphony.xwork2.ModelDriven;

/**
 * 嵌入网易云跟帖 数据
 * @author Alex_MaHao
 *
 */
public class CommentAction extends BaseAction implements ModelDriven<WYBean> {
	
	@Action("notifyComment")
	public void notifyComment(){
		System.out.println(getRequest().toString());
	}
}
