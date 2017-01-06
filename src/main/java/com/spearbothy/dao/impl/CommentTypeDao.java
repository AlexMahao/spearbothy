package com.spearbothy.dao.impl;

import org.springframework.stereotype.Repository;

import com.spearbothy.model.CommentType;
import com.spearbothy.model.ResourceType;

@Repository
public class CommentTypeDao extends BaseDaoImpl<CommentType> {
	/**
	 * 根据内容获取类型
	 * @param content
	 * @return
	 */
	public CommentType getTypeByContent(String content){
		
		return (CommentType) get("from CommentType where commentType = '"+content+"'");
		
	}
}
