package com.spearbothy.action;

import org.apache.struts2.convention.annotation.Action;

public class CommentAction extends BaseAction {
	
	@Action("notifyComment")
	public void notifyComment(){
		System.out.println(getRequest().toString());
	}
}
